package com.facebook.cache.common;

import com.facebook.common.internal.Preconditions;
/* loaded from: classes.dex */
public class SimpleCacheKey implements CacheKey {
    final String mKey;

    public SimpleCacheKey(String str) {
        this.mKey = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleCacheKey)) {
            return false;
        }
        return this.mKey.equals(((SimpleCacheKey) obj).mKey);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mKey.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.mKey;
    }
}
