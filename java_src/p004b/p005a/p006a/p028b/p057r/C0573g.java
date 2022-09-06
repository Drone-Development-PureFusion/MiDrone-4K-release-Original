package p004b.p005a.p006a.p028b.p057r;

import java.util.Properties;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.r.g */
/* loaded from: classes.dex */
public class C0573g extends C0527f {
    public C0573g(AbstractC0292f abstractC0292f) {
        a(abstractC0292f);
    }

    /* renamed from: a */
    public void m20112a() {
        this.f1190s.mo21001a(C0359h.f685O, "localhost");
    }

    /* renamed from: a */
    public void m20111a(Properties properties) {
        if (properties == null) {
            return;
        }
        for (String str : properties.keySet()) {
            this.f1190s.mo21001a(str, properties.getProperty(str));
        }
    }
}
