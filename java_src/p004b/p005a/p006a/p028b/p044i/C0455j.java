package p004b.p005a.p006a.p028b.p044i;

import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.p031c.C0280f;
/* renamed from: b.a.a.b.i.j */
/* loaded from: classes.dex */
public class C0455j<E> extends C0280f<E> {

    /* renamed from: d */
    String f1009d;

    /* renamed from: e */
    protected boolean f1010e = false;

    @Override // p004b.p005a.p006a.p028b.p031c.C0280f
    /* renamed from: a */
    public void mo20467a(AbstractC0459j<E> abstractC0459j) {
        throw new UnsupportedOperationException("one cannot set the layout of " + getClass().getName());
    }

    /* renamed from: a */
    public void m20466a(String str) {
        this.f1009d = str;
    }

    /* renamed from: b */
    public void m20465b(boolean z) {
        this.f1010e = z;
    }

    /* renamed from: c */
    public void m20464c(boolean z) {
        e("[outputPatternAsPresentationHeader] property is deprecated. Please use [outputPatternAsHeader] option instead.");
        this.f1010e = z;
    }

    /* renamed from: h */
    public String m20463h() {
        return this.f1009d;
    }

    /* renamed from: l */
    public boolean m20462l() {
        return this.f1010e;
    }

    /* renamed from: m */
    public boolean m20461m() {
        return this.f1010e;
    }
}
