package com.fimi.soul.module.dronemanage;
/* renamed from: com.fimi.soul.module.dronemanage.d */
/* loaded from: classes.dex */
public class C3237d {

    /* renamed from: a */
    private static C3237d f12455a = null;

    /* renamed from: b */
    private EnumC3238a f12456b = EnumC3238a.NONEXECUTE;

    /* renamed from: com.fimi.soul.module.dronemanage.d$a */
    /* loaded from: classes.dex */
    public enum EnumC3238a {
        EXECUTE,
        NONEXECUTE
    }

    private C3237d() {
    }

    /* renamed from: a */
    public static C3237d m9019a() {
        if (f12455a == null) {
            f12455a = new C3237d();
        }
        return f12455a;
    }

    /* renamed from: a */
    public void m9018a(EnumC3238a enumC3238a) {
        this.f12456b = enumC3238a;
    }

    /* renamed from: b */
    public EnumC3238a m9017b() {
        return this.f12456b;
    }
}
