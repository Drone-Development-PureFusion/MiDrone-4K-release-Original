package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
/* loaded from: classes.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    @VisibleForTesting
    static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    @VisibleForTesting
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Map<String, String> map = null;
        String id = producerContext.getId();
        ProducerListener listener = producerContext.getListener();
        listener.onProducerStart(id, PRODUCER_NAME);
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest());
        CloseableReference<PooledByteBuffer> closeableReference = this.mMemoryCache.get(encodedCacheKey);
        try {
            if (closeableReference != null) {
                EncodedImage encodedImage = new EncodedImage(closeableReference);
                if (listener.requiresExtraMap(id)) {
                    map = ImmutableMap.m13830of(VALUE_FOUND, "true");
                }
                listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, map);
                consumer.onProgressUpdate(1.0f);
                consumer.onNewResult(encodedImage, true);
                EncodedImage.closeSafely(encodedImage);
            } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                if (listener.requiresExtraMap(id)) {
                    map = ImmutableMap.m13830of(VALUE_FOUND, "false");
                }
                listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, map);
                consumer.onNewResult(null, true);
            } else {
                DelegatingConsumer<EncodedImage, EncodedImage> delegatingConsumer = new DelegatingConsumer<EncodedImage, EncodedImage>(consumer) { // from class: com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer.1
                    @Override // com.facebook.imagepipeline.producers.BaseConsumer
                    public void onNewResultImpl(EncodedImage encodedImage2, boolean z) {
                        if (!z || encodedImage2 == null) {
                            getConsumer().onNewResult(encodedImage2, z);
                            return;
                        }
                        CloseableReference byteBufferRef = encodedImage2.getByteBufferRef();
                        if (byteBufferRef != null) {
                            try {
                                byteBufferRef = EncodedMemoryCacheProducer.this.mMemoryCache.cache(encodedCacheKey, byteBufferRef);
                                if (byteBufferRef != null) {
                                    try {
                                        EncodedImage encodedImage3 = new EncodedImage(byteBufferRef);
                                        encodedImage3.copyMetaDataFrom(encodedImage2);
                                        try {
                                            getConsumer().onProgressUpdate(1.0f);
                                            getConsumer().onNewResult(encodedImage3, true);
                                            return;
                                        } finally {
                                            EncodedImage.closeSafely(encodedImage3);
                                        }
                                    } finally {
                                    }
                                }
                            } finally {
                            }
                        }
                        getConsumer().onNewResult(encodedImage2, true);
                    }
                };
                if (listener.requiresExtraMap(id)) {
                    map = ImmutableMap.m13830of(VALUE_FOUND, "false");
                }
                listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, map);
                this.mInputProducer.produceResults(delegatingConsumer, producerContext);
            }
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
