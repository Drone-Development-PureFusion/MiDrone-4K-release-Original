package com.github.moduth.blockcanary;

import android.util.Log;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.github.moduth.blockcanary.p215b.C3948b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
/* renamed from: com.github.moduth.blockcanary.j */
/* loaded from: classes.dex */
public class C3965j {

    /* renamed from: a */
    private static final String f16976a = "LogWriter";

    /* renamed from: b */
    private static final Object f16977b = new Object();

    /* renamed from: c */
    private static final SimpleDateFormat f16978c = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");

    /* renamed from: d */
    private static final SimpleDateFormat f16979d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: e */
    private static final long f16980e = 172800000;

    private C3965j() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static String m6358a(String str) {
        String m6357a;
        synchronized (f16977b) {
            m6357a = m6357a("looper", str);
        }
        return m6357a;
    }

    /* renamed from: a */
    private static String m6357a(String str, String str2) {
        BufferedWriter bufferedWriter;
        String str3;
        Throwable th;
        long currentTimeMillis;
        try {
            File m6392b = C3948b.m6392b();
            currentTimeMillis = System.currentTimeMillis();
            str3 = m6392b.getAbsolutePath() + "/" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f16978c.format(Long.valueOf(currentTimeMillis)) + ".txt";
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (Throwable th3) {
            bufferedWriter = null;
            str3 = "";
            th = th3;
        }
        try {
            bufferedWriter.write("\r\n**********************\r\n");
            bufferedWriter.write(f16979d.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
            bufferedWriter.write(C3947a.f16890a);
            bufferedWriter.write(C3947a.f16890a);
            bufferedWriter.write(str2);
            bufferedWriter.write(C3947a.f16890a);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedWriter bufferedWriter2 = null;
            if (0 != 0) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e) {
                    Log.e(f16976a, "saveLogToSDCard: ", e);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                Log.e(f16976a, "saveLogToSDCard: ", th);
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (Exception e2) {
                        Log.e(f16976a, "saveLogToSDCard: ", e2);
                    }
                }
                return str3;
            } catch (Throwable th5) {
                BufferedWriter bufferedWriter3 = bufferedWriter;
                if (bufferedWriter3 != null) {
                    try {
                        bufferedWriter3.close();
                    } catch (Exception e3) {
                        Log.e(f16976a, "saveLogToSDCard: ", e3);
                    }
                }
                throw th5;
            }
        }
        return str3;
    }

    /* renamed from: a */
    public static void m6359a() {
        C3961g.m6372b().post(new Runnable() { // from class: com.github.moduth.blockcanary.j.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                File[] m6391c = C3948b.m6391c();
                if (m6391c == null || m6391c.length <= 0) {
                    return;
                }
                synchronized (C3965j.f16977b) {
                    for (File file : m6391c) {
                        if (currentTimeMillis - file.lastModified() > C3965j.f16980e) {
                            file.delete();
                        }
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public static File m6355b(String str) {
        return new File(C3948b.m6393a() + "/" + str + ".log.zip");
    }

    /* renamed from: b */
    public static void m6356b() {
        synchronized (f16977b) {
            try {
                File[] m6391c = C3948b.m6391c();
                if (m6391c != null && m6391c.length > 0) {
                    for (File file : m6391c) {
                        file.delete();
                    }
                }
            }
        }
    }
}
