package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;
/* renamed from: com.b.ad */
/* loaded from: classes.dex */
public class C1404ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C1404ad f4828a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f4829b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c */
    private Context f4830c;

    /* renamed from: d */
    private C1549dv f4831d;

    private C1404ad(Context context, C1549dv c1549dv) {
        this.f4830c = context.getApplicationContext();
        this.f4831d = c1549dv;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized C1404ad m16426a(Context context, C1549dv c1549dv) {
        C1404ad c1404ad;
        synchronized (C1404ad.class) {
            if (f4828a == null) {
                f4828a = new C1404ad(context, c1549dv);
            }
            c1404ad = f4828a;
        }
        return c1404ad;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String m15559a = C1552dw.m15559a(th);
        try {
            if (!TextUtils.isEmpty(m15559a) && m15559a.contains("amapdynamic") && m15559a.contains("com.amap.api")) {
                C1399ab.m16449a(new C1565k(this.f4830c, C1405ae.m16425c()), this.f4830c, this.f4831d);
            }
        } catch (Throwable th2) {
            C1450b.m16187a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        if (this.f4829b != null) {
            this.f4829b.uncaughtException(thread, th);
        }
    }
}
