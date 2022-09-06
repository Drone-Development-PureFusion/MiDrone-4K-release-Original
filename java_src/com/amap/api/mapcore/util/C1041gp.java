package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;
/* renamed from: com.amap.api.mapcore.util.gp */
/* loaded from: classes.dex */
public class C1041gp implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C1041gp f3249a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f3250b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c */
    private Context f3251c;

    /* renamed from: d */
    private C0996fh f3252d;

    private C1041gp(Context context, C0996fh c0996fh) {
        this.f3251c = context.getApplicationContext();
        this.f3252d = c0996fh;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized C1041gp m17863a(Context context, C0996fh c0996fh) {
        C1041gp c1041gp;
        synchronized (C1041gp.class) {
            if (f3249a == null) {
                f3249a = new C1041gp(context, c0996fh);
            }
            c1041gp = f3249a;
        }
        return c1041gp;
    }

    /* renamed from: a */
    void m17862a(Throwable th) {
        String m18046a = C0999fi.m18046a(th);
        try {
            if (TextUtils.isEmpty(m18046a)) {
                return;
            }
            if ((!m18046a.contains("amapdynamic") && !m18046a.contains("admic")) || !m18046a.contains("com.amap.api")) {
                if (m18046a.contains("com.autonavi.aps.amapapi.offline")) {
                    C1036gn.m17885a(new C1016fu(this.f3251c, C1042gq.m17861a()), this.f3251c, "OfflineLocation");
                    return;
                } else if (m18046a.contains("com.data.carrier_v4")) {
                    C1036gn.m17885a(new C1016fu(this.f3251c, C1042gq.m17861a()), this.f3251c, "Collection");
                    return;
                } else if (!m18046a.contains("com.autonavi.aps.amapapi.httpdns") && !m18046a.contains("com.autonavi.httpdns")) {
                    return;
                } else {
                    C1036gn.m17885a(new C1016fu(this.f3251c, C1042gq.m17861a()), this.f3251c, "HttpDNS");
                    return;
                }
            }
            C1016fu c1016fu = new C1016fu(this.f3251c, C1042gq.m17861a());
            if (m18046a.contains("loc")) {
                C1036gn.m17885a(c1016fu, this.f3251c, "loc");
            }
            if (m18046a.contains("navi")) {
                C1036gn.m17885a(c1016fu, this.f3251c, "navi");
            }
            if (m18046a.contains("sea")) {
                C1036gn.m17885a(c1016fu, this.f3251c, "sea");
            }
            if (m18046a.contains("2dmap")) {
                C1036gn.m17885a(c1016fu, this.f3251c, "2dmap");
            }
            if (!m18046a.contains("3dmap")) {
                return;
            }
            C1036gn.m17885a(c1016fu, this.f3251c, "3dmap");
        } catch (Throwable th2) {
            C1002fl.m18028a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m17862a(th);
        if (this.f3250b != null) {
            this.f3250b.uncaughtException(thread, th);
        }
    }
}
