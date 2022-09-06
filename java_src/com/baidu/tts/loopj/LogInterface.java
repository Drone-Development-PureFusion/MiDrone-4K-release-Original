package com.baidu.tts.loopj;
/* loaded from: classes.dex */
public interface LogInterface {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    /* renamed from: d */
    void mo14723d(String str, String str2);

    /* renamed from: d */
    void mo14722d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo14721e(String str, String str2);

    /* renamed from: e */
    void mo14720e(String str, String str2, Throwable th);

    int getLoggingLevel();

    /* renamed from: i */
    void mo14719i(String str, String str2);

    /* renamed from: i */
    void mo14718i(String str, String str2, Throwable th);

    boolean isLoggingEnabled();

    void setLoggingEnabled(boolean z);

    void setLoggingLevel(int i);

    boolean shouldLog(int i);

    /* renamed from: v */
    void mo14717v(String str, String str2);

    /* renamed from: v */
    void mo14716v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo14715w(String str, String str2);

    /* renamed from: w */
    void mo14714w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
