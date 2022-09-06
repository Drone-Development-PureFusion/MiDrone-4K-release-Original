package com.fimi.soul.module.calibcompass;

import com.fimi.soul.module.p207b.C3050a;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.fimi.soul.module.calibcompass.a */
/* loaded from: classes.dex */
public class C3074a {

    /* renamed from: a */
    private static C3074a f11473a;

    /* renamed from: b */
    private volatile ConcurrentHashMap<String, C3050a> f11474b = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static C3074a m9756a() {
        if (f11473a == null) {
            synchronized (C3074a.class) {
                if (f11473a == null) {
                    f11473a = new C3074a();
                }
            }
        }
        return f11473a;
    }

    /* renamed from: a */
    private void m9755a(C3050a c3050a) {
        if (c3050a != null) {
            c3050a.m9846b();
        }
    }

    /* renamed from: a */
    public void m9754a(String str) {
        m9755a(this.f11474b.get(str));
        this.f11474b.remove(str);
    }

    /* renamed from: a */
    public void m9753a(String str, C3050a c3050a) {
        if (c3050a != null) {
            if (this.f11474b.containsKey(str)) {
                m9755a(this.f11474b.get(str));
                this.f11474b.remove(str);
            }
            this.f11474b.put(str, c3050a);
        }
    }
}
