package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
/* loaded from: classes.dex */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    @VisibleForTesting
    static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";

    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        super(memoryCache, cacheKeyFactory, producer);
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey) {
        return consumer;
    }
}
