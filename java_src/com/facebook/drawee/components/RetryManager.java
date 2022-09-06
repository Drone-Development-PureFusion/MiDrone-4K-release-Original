package com.facebook.drawee.components;
/* loaded from: classes.dex */
public class RetryManager {
    private static final int MAX_TAP_TO_RETRY_ATTEMPTS = 4;
    private int mMaxTapToRetryAttempts;
    private int mTapToRetryAttempts;
    private boolean mTapToRetryEnabled;

    public RetryManager() {
        init();
    }

    public static RetryManager newInstance() {
        return new RetryManager();
    }

    public void init() {
        this.mTapToRetryEnabled = false;
        this.mMaxTapToRetryAttempts = 4;
        reset();
    }

    public boolean isTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public void notifyTapToRetry() {
        this.mTapToRetryAttempts++;
    }

    public void reset() {
        this.mTapToRetryAttempts = 0;
    }

    public void setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
    }

    public boolean shouldRetryOnTap() {
        return this.mTapToRetryEnabled && this.mTapToRetryAttempts < this.mMaxTapToRetryAttempts;
    }
}
