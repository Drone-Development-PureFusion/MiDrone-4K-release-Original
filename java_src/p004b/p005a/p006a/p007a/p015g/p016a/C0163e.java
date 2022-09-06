package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0302d;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
@Deprecated
/* renamed from: b.a.a.a.g.a.e */
/* loaded from: classes.dex */
public class C0163e extends AbstractC0301c {

    /* renamed from: a */
    boolean f246a = false;

    /* renamed from: a */
    public void m21401a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        Object m20871f = c0344k.m20871f();
        if (!(m20871f instanceof C0148e)) {
            this.f246a = true;
            c("For element <level>, could not find a logger at the top of execution stack.");
            return;
        }
        C0148e c0148e = (C0148e) m20871f;
        String mo88d = c0148e.mo88d();
        String m20870f = c0344k.m20870f(attributes.getValue("value"));
        if (AbstractC0302d.f566j.equalsIgnoreCase(m20870f) || AbstractC0302d.f567k.equalsIgnoreCase(m20870f)) {
            c0148e.m21474a((C0146d) null);
        } else {
            c0148e.m21474a(C0146d.m21481a(m20870f, C0146d.f205s));
        }
        d(mo88d + " level set to " + c0148e.m21461c());
    }
}
