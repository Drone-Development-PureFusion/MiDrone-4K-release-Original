package p004b.p005a.p006a.p028b.p030b;

import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC0272c<E> extends C0527f implements AbstractC0271b<E> {

    /* renamed from: b */
    String f477b;

    /* renamed from: c */
    boolean f478c;

    @Override // p004b.p005a.p006a.p028b.p030b.AbstractC0271b
    /* renamed from: a */
    public String mo21089a() {
        return this.f477b;
    }

    @Override // p004b.p005a.p006a.p028b.p030b.AbstractC0271b
    /* renamed from: b */
    public void mo21088b(String str) {
        if (this.f477b != null) {
            throw new IllegalStateException("name has been already set");
        }
        this.f477b = str;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f478c;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f478c = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f478c = false;
    }
}
