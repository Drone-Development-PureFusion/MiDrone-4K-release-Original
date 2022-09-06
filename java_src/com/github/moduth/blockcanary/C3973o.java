package com.github.moduth.blockcanary;

import android.util.Log;
import com.github.moduth.blockcanary.p215b.C3948b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.github.moduth.blockcanary.o */
/* loaded from: classes.dex */
class C3973o {

    /* renamed from: a */
    private static final String f17001a = "UploadMonitorLog";

    /* renamed from: b */
    private static final SimpleDateFormat f17002b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private C3973o() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static void m6343a() {
        C3961g.m6372b().post(new Runnable() { // from class: com.github.moduth.blockcanary.o.1
            @Override // java.lang.Runnable
            public void run() {
                File m6341c = C3973o.m6341c();
                if (m6341c.exists()) {
                    C3953c.m6380b().mo6369a(m6341c);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static File m6341c() {
        String l = Long.toString(System.currentTimeMillis());
        try {
            l = f17002b.format(new Date());
        } catch (Throwable th) {
            Log.e(f17001a, "zipFile: ", th);
        }
        File m6355b = C3965j.m6355b("Monitor_looper_" + l);
        C3953c.m6380b().mo6368a(C3948b.m6391c(), m6355b);
        C3965j.m6356b();
        return m6355b;
    }
}
