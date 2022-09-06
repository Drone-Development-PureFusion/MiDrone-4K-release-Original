package p004b.p005a.p006a.p007a.p026o;

import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.o.a */
/* loaded from: classes.dex */
public class C0248a extends AbstractC0257i {

    /* renamed from: a */
    public static final int f420a = 100;

    /* renamed from: b */
    public static final int f421b = 5;

    /* renamed from: c */
    public int f422c = 5;

    /* renamed from: d */
    public int f423d = 100;

    /* renamed from: e */
    private C0250c f424e;

    /* renamed from: a */
    public int m21164a() {
        return this.f422c;
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i
    /* renamed from: a */
    public EnumC0533l mo21125a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        return this.f424e.m21151a(str) <= this.f422c ? EnumC0533l.NEUTRAL : EnumC0533l.DENY;
    }

    /* renamed from: a */
    public void m21163a(int i) {
        this.f422c = i;
    }

    /* renamed from: b */
    public int m21162b() {
        return this.f423d;
    }

    /* renamed from: b */
    public void m21161b(int i) {
        this.f423d = i;
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f424e = new C0250c(this.f423d);
        super.mo20156j();
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f424e.clear();
        this.f424e = null;
        super.mo20155k();
    }
}
