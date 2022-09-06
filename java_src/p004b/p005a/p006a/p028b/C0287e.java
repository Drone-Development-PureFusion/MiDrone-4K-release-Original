package p004b.p005a.p006a.p028b;

import java.util.Arrays;
import p004b.p005a.p006a.p028b.p035g.p039d.EnumC0335d;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0553m;
@Deprecated
/* renamed from: b.a.a.b.e */
/* loaded from: classes.dex */
public class C0287e<E> extends C0516o<E> {

    /* renamed from: a */
    protected EnumC0335d f514a = EnumC0335d.SystemOut;

    /* renamed from: b */
    private void m21035b(String str) {
        C0553m c0553m = new C0553m("[" + str + "] should be one of " + Arrays.toString(EnumC0335d.values()), this);
        c0553m.mo20200a(new C0553m("Using previously set target, System.out by default.", this));
        a((AbstractC0547g) c0553m);
    }

    /* renamed from: a */
    public String m21037a() {
        return this.f514a.m20911a();
    }

    /* renamed from: a */
    public void m21036a(String str) {
        EnumC0335d m20910a = EnumC0335d.m20910a(str.trim());
        if (m20910a == null) {
            m21035b(str);
        } else {
            this.f514a = m20910a;
        }
    }

    @Override // p004b.p005a.p006a.p028b.C0516o, p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        a(this.f514a.m20909b());
        super.mo20156j();
    }
}
