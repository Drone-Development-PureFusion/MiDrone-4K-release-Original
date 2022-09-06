package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.AbstractC0016j;
import p000a.C0018l;
/* loaded from: classes.dex */
public class DiskCacheProducer implements Producer<EncodedImage> {
    @VisibleForTesting
    static final String PRODUCER_NAME = "DiskCacheProducer";
    @VisibleForTesting
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final BufferedDiskCache mCache;
        private final CacheKey mCacheKey;

        private DiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
            super(consumer);
            this.mCache = bufferedDiskCache;
            this.mCacheKey = cacheKey;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, boolean z) {
            if (encodedImage != null && z) {
                this.mCache.put(this.mCacheKey, encodedImage);
            }
            getConsumer().onNewResult(encodedImage, z);
        }
    }

    public DiskCacheProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @VisibleForTesting
    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z) {
        if (!producerListener.requiresExtraMap(str)) {
            return null;
        }
        return ImmutableMap.m13830of(VALUE_FOUND, String.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeStartInputProducer(Consumer<EncodedImage> consumer, Consumer<EncodedImage> consumer2, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, true);
        } else {
            this.mInputProducer.produceResults(consumer2, producerContext);
        }
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<EncodedImage> consumer, final ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            maybeStartInputProducer(consumer, consumer, producerContext);
            return;
        }
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        listener.onProducerStart(id, PRODUCER_NAME);
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest);
        final BufferedDiskCache bufferedDiskCache = imageRequest.getImageType() == ImageRequest.ImageType.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
        AbstractC0016j abstractC0016j = new AbstractC0016j<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.DiskCacheProducer.1
            @Override // p000a.AbstractC0016j
            /* renamed from: then  reason: collision with other method in class */
            public Void mo21799then(C0018l<EncodedImage> c0018l) {
                if (c0018l.m21599c() || (c0018l.m21594d() && (c0018l.m21589f() instanceof CancellationException))) {
                    listener.onProducerFinishWithCancellation(id, DiskCacheProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (c0018l.m21594d()) {
                    listener.onProducerFinishWithFailure(id, DiskCacheProducer.PRODUCER_NAME, c0018l.m21589f(), null);
                    DiskCacheProducer.this.maybeStartInputProducer(consumer, new DiskCacheConsumer(consumer, bufferedDiskCache, encodedCacheKey), producerContext);
                } else {
                    EncodedImage m21590e = c0018l.m21590e();
                    if (m21590e != null) {
                        listener.onProducerFinishWithSuccess(id, DiskCacheProducer.PRODUCER_NAME, DiskCacheProducer.getExtraMap(listener, id, true));
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(m21590e, true);
                        m21590e.close();
                    } else {
                        listener.onProducerFinishWithSuccess(id, DiskCacheProducer.PRODUCER_NAME, DiskCacheProducer.getExtraMap(listener, id, false));
                        DiskCacheProducer.this.maybeStartInputProducer(consumer, new DiskCacheConsumer(consumer, bufferedDiskCache, encodedCacheKey), producerContext);
                    }
                }
                return null;
            }
        };
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache.get(encodedCacheKey, atomicBoolean).m21620a(abstractC0016j);
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }
}
