package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
class WhatToKeepCachedArray {
    private final boolean[] mData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WhatToKeepCachedArray(int i) {
        this.mData = new boolean[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean get(int i) {
        return this.mData[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOutsideRange(int i, int i2) {
        for (int i3 = 0; i3 < this.mData.length; i3++) {
            if (AnimatedDrawableUtil.isOutsideRange(i, i2, i3)) {
                this.mData[i3] = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i, boolean z) {
        this.mData[i] = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAll(boolean z) {
        for (int i = 0; i < this.mData.length; i++) {
            this.mData[i] = z;
        }
    }
}
