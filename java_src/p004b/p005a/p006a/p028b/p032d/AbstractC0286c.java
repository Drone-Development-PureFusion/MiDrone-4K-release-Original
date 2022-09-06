package p004b.p005a.p006a.p028b.p032d;

import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.b.d.c */
/* loaded from: classes.dex */
public abstract class AbstractC0286c<E> extends C0527f implements AbstractC0534m {

    /* renamed from: a */
    private String f512a;

    /* renamed from: d */
    boolean f513d = false;

    /* renamed from: a */
    public abstract EnumC0533l mo21040a(E e);

    /* renamed from: b */
    public void m21039b(String str) {
        this.f512a = str;
    }

    /* renamed from: e */
    public String m21038e() {
        return this.f512a;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f513d;
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f513d = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f513d = false;
    }
}
