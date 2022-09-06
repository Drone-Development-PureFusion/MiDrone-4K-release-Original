package com.fimi.soul.biz.p179h;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.biz.h.a */
/* loaded from: classes.dex */
public class C2462a {

    /* renamed from: a */
    public static final int f8475a = 0;

    /* renamed from: b */
    public static final int f8476b = 1;

    /* renamed from: c */
    private List<String> f8477c;

    /* renamed from: d */
    private Handler f8478d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.biz.h.a$a */
    /* loaded from: classes.dex */
    public static class C2466a {

        /* renamed from: a */
        private static final C2462a f8488a = new C2462a();

        private C2466a() {
        }
    }

    private C2462a() {
        this.f8478d = new Handler();
        this.f8477c = new ArrayList();
    }

    /* renamed from: a */
    public static C2462a m12098a() {
        return C2466a.f8488a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12097a(final int i, final C2657a c2657a) {
        if (c2657a.mo11216ac()) {
            this.f8478d.post(new Runnable() { // from class: com.fimi.soul.biz.h.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c2657a.mo11216ac()) {
                        if (1 == i && !c2657a.m11320al()) {
                            C3057d.m9823a(c2657a).m9817c(i);
                        } else if (i != 0) {
                        } else {
                            C3057d.m9823a(c2657a).m9817c(i);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public String m12096a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return C3658ar.m7565q(context) ? activityManager.getRunningTasks(2).get(1).topActivity.getShortClassName() : activityManager.getRunningTasks(1).get(0).topActivity.getShortClassName();
    }

    /* renamed from: a */
    public void m12093a(final C2657a c2657a) {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.h.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!C2462a.this.f8477c.contains(C2462a.this.m12096a(c2657a.f9270d))) {
                    C2462a.this.m12097a(0, c2657a);
                } else {
                    C2462a.this.m12097a(1, c2657a);
                }
            }
        });
    }

    /* renamed from: a */
    public void m12092a(String str) {
        String m12089c = m12089c(str);
        if (!this.f8477c.contains(m12089c)) {
            this.f8477c.add(m12089c);
        }
    }

    /* renamed from: a */
    public void m12091a(final String str, final int i, final C2657a c2657a) {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                String m12096a = C2462a.this.m12096a(c2657a.f9270d);
                String m12089c = C2462a.this.m12089c(str);
                if (C2462a.this.f8477c.contains(m12089c) && m12089c.equals(m12096a) && 1 == i) {
                    C2462a.this.m12097a(i, c2657a);
                } else if (i != 0) {
                } else {
                    C2462a.this.m12097a(i, c2657a);
                }
            }
        });
    }

    /* renamed from: b */
    public void m12090b(String str) {
        String m12089c = m12089c(str);
        if (this.f8477c.contains(m12089c)) {
            this.f8477c.remove(m12089c);
        }
    }

    /* renamed from: c */
    public String m12089c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(".").append(str);
        return sb.toString();
    }
}
