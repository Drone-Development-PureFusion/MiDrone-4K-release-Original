package com.xiaomi.push.service.timers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
/* renamed from: com.xiaomi.push.service.timers.a */
/* loaded from: classes.dex */
public final class C4691a {

    /* renamed from: a */
    private static AbstractC4692a f19196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.timers.a$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4692a {
        /* renamed from: a */
        void mo4081a();

        /* renamed from: a */
        void mo4079a(boolean z);

        /* renamed from: b */
        boolean mo4078b();
    }

    /* renamed from: a */
    public static synchronized void m4087a() {
        synchronized (C4691a.class) {
            if (f19196a != null) {
                f19196a.mo4081a();
            }
        }
    }

    /* renamed from: a */
    public static void m4086a(Context context) {
        boolean z = false;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f19196a = new C4693b(applicationContext);
            return;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    if ("com.xiaomi.push.service.XMJobService".equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            AbstractC4478b.m5041a("check service err : " + e.getMessage());
        }
        if (!z && C4473j.m5064b(applicationContext)) {
            throw new RuntimeException("Should export service: com.xiaomi.push.service.XMJobService with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (Build.VERSION.SDK_INT < 21 || !z) {
            f19196a = new C4693b(applicationContext);
            return;
        }
        try {
            if (Class.forName("android.app.job.JobService").getDeclaredField("mBinder") == null) {
                return;
            }
            f19196a = new C4694c(applicationContext);
        } catch (Exception e2) {
            f19196a = new C4693b(applicationContext);
        }
    }

    /* renamed from: a */
    public static synchronized void m4085a(boolean z) {
        synchronized (C4691a.class) {
            if (f19196a == null) {
                AbstractC4478b.m5041a("timer is not initialized");
            } else {
                f19196a.mo4079a(z);
            }
        }
    }

    /* renamed from: b */
    public static synchronized boolean m4084b() {
        boolean mo4078b;
        synchronized (C4691a.class) {
            mo4078b = f19196a == null ? false : f19196a.mo4078b();
        }
        return mo4078b;
    }
}
