package com.fimi.soul.biz.p176e;

import com.fimi.soul.biz.camera.entity.RelayEntity;
import com.fimi.soul.biz.p168a.C2367d;
/* renamed from: com.fimi.soul.biz.e.a */
/* loaded from: classes.dex */
public class C2440a implements C2367d.AbstractC2369a {

    /* renamed from: a */
    public static C2440a f8415a = null;

    /* renamed from: b */
    private static final int f8416b = 100;

    /* renamed from: c */
    private volatile boolean f8417c;

    /* renamed from: d */
    private C2367d f8418d = C2367d.m12459a();

    public C2440a() {
        this.f8418d.m12457a(this);
    }

    /* renamed from: b */
    public static C2440a m12171b() {
        if (f8415a == null) {
            synchronized (C2440a.class) {
                if (f8415a == null) {
                    f8415a = new C2440a();
                }
            }
        }
        return f8415a;
    }

    /* renamed from: a */
    public void m12173a() {
        this.f8418d.m12454b();
        this.f8418d.m12449c("5G");
    }

    @Override // com.fimi.soul.biz.p168a.C2367d.AbstractC2369a
    /* renamed from: a */
    public void mo7975a(RelayEntity relayEntity) {
        if (relayEntity == null || "5G".equals(relayEntity.getDevice_type())) {
            return;
        }
        this.f8417c = true;
    }

    /* renamed from: a */
    public void m12172a(boolean z) {
        this.f8417c = z;
    }

    /* renamed from: c */
    public boolean m12170c() {
        return this.f8417c;
    }

    /* renamed from: d */
    public void m12169d() {
        this.f8417c = false;
    }
}
