package com.facebook.imagepipeline.cache;
/* loaded from: classes.dex */
public interface MemoryCacheTracker {
    void onCacheHit();

    void onCacheMiss();

    void onCachePut();
}
