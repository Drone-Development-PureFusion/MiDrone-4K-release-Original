package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public class LoggerProxy {

    /* renamed from: a */
    private static C1662d f5807a = C1662d.m15079a();

    /* renamed from: a */
    public static void m15092a(String str, String str2) {
        log(7, str, str2);
    }

    public static void addPrintString(String str) {
        f5807a.m15074a(str);
    }

    public static void addPrintStrings(List<String> list) {
        f5807a.m15073a(list);
    }

    public static void addUnPrintString(String str) {
        f5807a.m15069b(str);
    }

    public static void clearHandler() {
        f5807a.m15071b();
    }

    public static void clearSpecifyStrings() {
        f5807a.m15068c();
    }

    /* renamed from: d */
    public static void m15091d(String str, String str2) {
        log(3, str, str2);
    }

    /* renamed from: e */
    public static void m15090e(String str, String str2) {
        log(6, str, str2);
    }

    /* renamed from: i */
    public static void m15089i(String str, String str2) {
        log(4, str, str2);
    }

    public static boolean isModeRelease() {
        return f5807a.m15066e();
    }

    public static void log(int i, String str, String str2) {
        try {
            f5807a.m15078a(i, str, str2);
        } catch (Exception e) {
            Log.e("LoggerProxy", "log exception=" + e.toString());
        }
    }

    public static void printable(boolean z) {
        f5807a.m15072a(z);
    }

    public static void setModeRelease() {
        f5807a.m15067d();
    }

    /* renamed from: v */
    public static void m15088v(String str, String str2) {
        log(2, str, str2);
    }

    /* renamed from: w */
    public static void m15087w(String str, String str2) {
        log(5, str, str2);
    }
}
