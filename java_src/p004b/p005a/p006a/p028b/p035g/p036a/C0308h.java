package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.h */
/* loaded from: classes.dex */
public class C0308h extends AbstractC0301c {

    /* renamed from: a */
    boolean f579a = false;

    /* renamed from: a */
    public void m20962a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f579a = false;
        String value = attributes.getValue(AbstractC0302d.f562f);
        String value2 = attributes.getValue(AbstractC0302d.f561e);
        if (C0589u.m20054e(value)) {
            this.f579a = true;
            c("No 'conversionWord' attribute in <conversionRule>");
        } else if (C0589u.m20054e(value2)) {
            this.f579a = true;
            c0344k.c("No 'converterClass' attribute in <conversionRule>");
        } else {
            try {
                Map map = (Map) this.f1190s.mo20998f(C0359h.f710g);
                if (map == null) {
                    map = new HashMap();
                    this.f1190s.mo21002a(C0359h.f710g, map);
                }
                d("registering conversion word " + value + " with class [" + value2 + "]");
                map.put(value, value2);
            } catch (Exception e) {
                this.f579a = true;
                c("Could not add conversion rule to PatternLayout.");
            }
        }
    }
}
