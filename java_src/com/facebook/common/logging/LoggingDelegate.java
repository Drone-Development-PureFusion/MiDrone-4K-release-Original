package com.facebook.common.logging;
/* loaded from: classes.dex */
public interface LoggingDelegate {
    /* renamed from: d */
    void mo13759d(String str, String str2);

    /* renamed from: d */
    void mo13758d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo13757e(String str, String str2);

    /* renamed from: e */
    void mo13756e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo13755i(String str, String str2);

    /* renamed from: i */
    void mo13754i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo13753v(String str, String str2);

    /* renamed from: v */
    void mo13752v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo13751w(String str, String str2);

    /* renamed from: w */
    void mo13750w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
