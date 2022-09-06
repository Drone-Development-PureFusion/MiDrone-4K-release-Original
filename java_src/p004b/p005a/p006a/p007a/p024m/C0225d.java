package p004b.p005a.p006a.p007a.p024m;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p037b.AbstractC0327c;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p053n.AbstractC0510c;
/* renamed from: b.a.a.a.m.d */
/* loaded from: classes.dex */
public class C0225d extends AbstractC0301c implements AbstractC0327c {

    /* renamed from: a */
    List<C0328d> f350a;

    /* renamed from: a */
    public List<C0328d> m21263a() {
        return this.f350a;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p037b.AbstractC0327c
    /* renamed from: a */
    public void mo20934a(C0328d c0328d) {
        this.f350a.add(c0328d);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        c0344k.m20876b(this);
        Object m20871f = c0344k.m20871f();
        if (m20871f instanceof C0226e) {
            C0226e c0226e = (C0226e) m20871f;
            c0226e.a((AbstractC0510c) new C0222a(this.f350a, c0226e.f(), c0344k.mo20210o()));
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f350a = new ArrayList();
        c0344k.m20883a((AbstractC0327c) this);
    }
}
