package com.baidu.tts.loopj;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public class LogHandler implements LogInterface {
    boolean mLoggingEnabled = true;
    int mLoggingLevel = 2;

    @TargetApi(8)
    private void checkedWtf(String str, String str2, Throwable th) {
        Log.wtf(str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: d */
    public void mo14723d(String str, String str2) {
        log(2, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: d */
    public void mo14722d(String str, String str2, Throwable th) {
        logWithThrowable(3, str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: e */
    public void mo14721e(String str, String str2) {
        log(6, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: e */
    public void mo14720e(String str, String str2, Throwable th) {
        logWithThrowable(6, str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public int getLoggingLevel() {
        return this.mLoggingLevel;
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: i */
    public void mo14719i(String str, String str2) {
        log(4, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: i */
    public void mo14718i(String str, String str2, Throwable th) {
        logWithThrowable(4, str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public boolean isLoggingEnabled() {
        return this.mLoggingEnabled;
    }

    public void log(int i, String str, String str2) {
        logWithThrowable(i, str, str2, null);
    }

    public void logWithThrowable(int i, String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(i)) {
            return;
        }
        switch (i) {
            case 2:
                Log.v(str, str2, th);
                return;
            case 3:
                Log.d(str, str2, th);
                return;
            case 4:
                Log.i(str, str2, th);
                return;
            case 5:
                Log.w(str, str2, th);
                return;
            case 6:
                Log.e(str, str2, th);
                return;
            case 7:
            default:
                return;
            case 8:
                if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8) {
                    checkedWtf(str, str2, th);
                    return;
                } else {
                    Log.e(str, str2, th);
                    return;
                }
        }
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public void setLoggingEnabled(boolean z) {
        this.mLoggingEnabled = z;
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public void setLoggingLevel(int i) {
        this.mLoggingLevel = i;
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public boolean shouldLog(int i) {
        return i >= this.mLoggingLevel;
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: v */
    public void mo14717v(String str, String str2) {
        log(2, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: v */
    public void mo14716v(String str, String str2, Throwable th) {
        logWithThrowable(2, str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: w */
    public void mo14715w(String str, String str2) {
        log(5, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    /* renamed from: w */
    public void mo14714w(String str, String str2, Throwable th) {
        logWithThrowable(5, str, str2, th);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public void wtf(String str, String str2) {
        log(8, str, str2);
    }

    @Override // com.baidu.tts.loopj.LogInterface
    public void wtf(String str, String str2, Throwable th) {
        logWithThrowable(8, str, str2, th);
    }
}
