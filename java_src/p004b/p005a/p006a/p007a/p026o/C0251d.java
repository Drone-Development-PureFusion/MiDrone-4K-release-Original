package p004b.p005a.p006a.p007a.p026o;

import org.p318d.AbstractC5756f;
import org.p318d.C5753e;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.o.d */
/* loaded from: classes.dex */
public class C0251d extends AbstractC0254g {

    /* renamed from: a */
    String f431a;

    /* renamed from: b */
    String f432b;

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i
    /* renamed from: a */
    public EnumC0533l mo21125a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        if (this.f431a == null) {
            return EnumC0533l.NEUTRAL;
        }
        return this.f432b.equals(C5753e.m19a(this.f431a)) ? this.f436c : this.f437d;
    }

    /* renamed from: a */
    public void m21150a(String str) {
        this.f432b = str;
    }

    /* renamed from: b */
    public void m21149b(String str) {
        this.f431a = str;
    }
}
