package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.j */
/* loaded from: classes.dex */
public class C2924j extends AbstractC2860a {

    /* renamed from: a */
    private boolean f11038a = false;

    /* renamed from: b */
    private boolean f11039b = false;

    /* renamed from: c */
    private EnumC2926b f11040c = EnumC2926b.Set;

    /* renamed from: d */
    private EnumC2925a f11041d = EnumC2925a.None;

    /* renamed from: e */
    private int f11042e = 0;

    /* renamed from: f */
    private int f11043f = 0;

    /* renamed from: com.fimi.soul.drone.i.j$a */
    /* loaded from: classes.dex */
    public enum EnumC2925a {
        None,
        StartRecord,
        StopRecrod,
        QuicklyShot,
        StopQuicklyShot,
        NormalShot
    }

    /* renamed from: com.fimi.soul.drone.i.j$b */
    /* loaded from: classes.dex */
    public enum EnumC2926b {
        Set,
        Get
    }

    /* renamed from: a */
    private EnumC2925a m10249a(byte b) {
        return b == 1 ? EnumC2925a.StartRecord : b == 2 ? EnumC2925a.StopRecrod : b == 6 ? EnumC2925a.QuicklyShot : b == 9 ? EnumC2925a.StopQuicklyShot : b == 5 ? EnumC2925a.NormalShot : EnumC2925a.None;
    }

    /* renamed from: b */
    private EnumC2926b m10243b(byte b) {
        if (b != 1 && b == 2) {
            return EnumC2926b.Get;
        }
        return EnumC2926b.Set;
    }

    @Override // com.fimi.soul.drone.p193d.AbstractC2682a
    /* renamed from: a */
    public void mo10248a(C2771d c2771d) {
        c2771d.m11052c();
        byte m11050d = c2771d.m11050d();
        byte m11050d2 = c2771d.m11050d();
        if (a() == 51) {
            this.f11042e = (m11050d2 * 100) + c2771d.m11050d();
            this.f11043f = c2771d.m11050d();
        }
        m10247a(m10249a(m11050d));
        m10246a(m10243b(m11050d2));
        if (c2771d.m11050d() == 1) {
            m10241b(true);
        }
        if (c2771d.m11050d() == 1) {
            m10245a(true);
        }
    }

    /* renamed from: a */
    public void m10247a(EnumC2925a enumC2925a) {
        this.f11041d = enumC2925a;
    }

    /* renamed from: a */
    public void m10246a(EnumC2926b enumC2926b) {
        this.f11040c = enumC2926b;
    }

    /* renamed from: a */
    public void m10245a(boolean z) {
        this.f11039b = z;
    }

    /* renamed from: b */
    public int m10244b() {
        return this.f11043f;
    }

    /* renamed from: b */
    public void m10242b(int i) {
        this.f11043f = i;
    }

    /* renamed from: b */
    public void m10241b(boolean z) {
        this.f11038a = z;
    }

    /* renamed from: c */
    public EnumC2926b m10240c() {
        return this.f11040c;
    }

    /* renamed from: d */
    public int m10239d() {
        return this.f11042e;
    }

    /* renamed from: e */
    public EnumC2925a m10238e() {
        return this.f11041d;
    }

    /* renamed from: f */
    public boolean m10237f() {
        return this.f11039b;
    }

    /* renamed from: g */
    public boolean m10236g() {
        return this.f11038a;
    }

    public String toString() {
        return "CloudCamraActionVariable{isFormatSDCard=" + this.f11038a + ", isResetFactory=" + this.f11039b + ", cameraRequestType=" + this.f11040c + ", cameraActionType=" + this.f11041d + C0359h.f726w;
    }
}
