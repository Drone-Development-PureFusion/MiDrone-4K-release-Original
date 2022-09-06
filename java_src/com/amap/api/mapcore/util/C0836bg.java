package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.bg */
/* loaded from: classes.dex */
public class C0836bg {

    /* renamed from: a */
    private static C0836bg f2336a;

    /* renamed from: b */
    private C1084hl f2337b;

    /* renamed from: c */
    private LinkedHashMap<String, AbstractRunnableC1086hm> f2338c = new LinkedHashMap<>();

    /* renamed from: d */
    private boolean f2339d = true;

    private C0836bg(boolean z, int i) {
        if (z) {
            try {
                this.f2337b = C1084hl.m17665a(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static C0836bg m18846a(int i) {
        return m18843a(true, i);
    }

    /* renamed from: a */
    private static synchronized C0836bg m18843a(boolean z, int i) {
        C0836bg c0836bg;
        synchronized (C0836bg.class) {
            if (f2336a == null) {
                f2336a = new C0836bg(z, i);
            } else if (z && f2336a.f2337b == null) {
                f2336a.f2337b = C1084hl.m17665a(i);
            }
            c0836bg = f2336a;
        }
        return c0836bg;
    }

    /* renamed from: a */
    public void m18847a() {
        synchronized (this.f2338c) {
            if (this.f2338c.size() < 1) {
                return;
            }
            for (Map.Entry<String, AbstractRunnableC1086hm> entry : this.f2338c.entrySet()) {
                entry.getKey();
                ((C0832bc) entry.getValue()).m18857b();
            }
            this.f2338c.clear();
        }
    }

    /* renamed from: a */
    public void m18845a(AbstractC0835bf abstractC0835bf) {
        synchronized (this.f2338c) {
            C0832bc c0832bc = (C0832bc) this.f2338c.get(abstractC0835bf.mo18848b());
            if (c0832bc == null) {
                return;
            }
            c0832bc.m18857b();
        }
    }

    /* renamed from: a */
    public void m18844a(AbstractC0835bf abstractC0835bf, Context context, AMap aMap) {
        if (this.f2337b == null) {
        }
        if (!this.f2338c.containsKey(abstractC0835bf.mo18848b())) {
            C0832bc c0832bc = new C0832bc((AbstractC0857bv) abstractC0835bf, context.getApplicationContext(), aMap);
            synchronized (this.f2338c) {
                this.f2338c.put(abstractC0835bf.mo18848b(), c0832bc);
            }
        }
        this.f2337b.m17663a(this.f2338c.get(abstractC0835bf.mo18848b()));
    }

    /* renamed from: b */
    public void m18842b() {
        m18847a();
        C1084hl c1084hl = this.f2337b;
        C1084hl.m17666a();
        this.f2337b = null;
        f2336a = null;
    }

    /* renamed from: b */
    public void m18841b(AbstractC0835bf abstractC0835bf) {
        C0832bc c0832bc = (C0832bc) this.f2338c.get(abstractC0835bf.mo18848b());
        if (c0832bc != null) {
            synchronized (this.f2338c) {
                c0832bc.m18856c();
                this.f2338c.remove(abstractC0835bf.mo18848b());
            }
        }
    }
}
