package p004b.p005a.p006a.p007a.p027p;

import p004b.p005a.p006a.p007a.C0139c;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p023l.AbstractC0220a;
import p004b.p005a.p006a.p007a.p023l.C0221b;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.p.b */
/* loaded from: classes.dex */
public class C0259b {

    /* renamed from: a */
    static C0259b f458a = new C0259b();

    /* renamed from: b */
    AbstractC0220a f459b;

    /* renamed from: c */
    Object f460c;

    /* renamed from: a */
    static AbstractC0220a m21115a(C0151f c0151f, String str) {
        return (AbstractC0220a) C0585s.m20075b(str).getConstructor(C0151f.class).newInstance(c0151f);
    }

    /* renamed from: a */
    public static C0259b m21117a() {
        return f458a;
    }

    /* renamed from: a */
    public void m21116a(C0151f c0151f, Object obj) {
        if (this.f460c == null) {
            this.f460c = obj;
        } else if (this.f460c != obj) {
            throw new IllegalAccessException("Only certain classes can access this method.");
        }
        String m20056c = C0589u.m20056c(C0139c.f154a);
        if (m20056c == null) {
            this.f459b = new C0221b(c0151f);
        } else if (m20056c.equals("JNDI")) {
            throw new RuntimeException("JNDI not supported");
        } else {
            this.f459b = m21115a(c0151f, m20056c);
        }
    }

    /* renamed from: b */
    public AbstractC0220a m21114b() {
        return this.f459b;
    }
}
