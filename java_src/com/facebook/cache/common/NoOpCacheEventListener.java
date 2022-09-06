package com.facebook.cache.common;

import com.facebook.cache.common.CacheEventListener;
/* loaded from: classes.dex */
public class NoOpCacheEventListener implements CacheEventListener {
    private static NoOpCacheEventListener sInstance = null;

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        NoOpCacheEventListener noOpCacheEventListener;
        synchronized (NoOpCacheEventListener.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = sInstance;
        }
        return noOpCacheEventListener;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEventListener.EvictionReason evictionReason, int i, long j) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException() {
    }
}
