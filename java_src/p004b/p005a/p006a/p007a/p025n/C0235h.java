package p004b.p005a.p006a.p007a.p025n;

import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.a.n.h */
/* loaded from: classes.dex */
public class C0235h extends C0527f implements AbstractC0234g {
    /* renamed from: a */
    public C0151f m21248a() {
        return (C0151f) this.f1190s;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0234g
    /* renamed from: a */
    public void mo21247a(C0151f c0151f) {
        super.mo20233a((AbstractC0292f) c0151f);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.C0527f, p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20233a(AbstractC0292f abstractC0292f) {
        if ((abstractC0292f instanceof C0151f) || abstractC0292f == null) {
            super.mo20233a(abstractC0292f);
            return;
        }
        throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
    }
}
