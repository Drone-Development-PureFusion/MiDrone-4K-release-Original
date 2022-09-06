package org.p318d.p321c;

import org.p318d.AbstractC5721a;
import org.p318d.p320b.C5741m;
import org.p318d.p322d.AbstractC5750b;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p027p.C0258a;
import p004b.p005a.p006a.p007a.p027p.C0259b;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p055p.C0552l;
import p004b.p005a.p006a.p028b.p057r.C0591w;
/* renamed from: org.d.c.a */
/* loaded from: classes2.dex */
public class C5745a implements AbstractC5750b {

    /* renamed from: b */
    static final String f23021b = "http://logback.qos.ch/codes.html#null_CS";

    /* renamed from: e */
    private boolean f23024e = false;

    /* renamed from: f */
    private C0151f f23025f = new C0151f();

    /* renamed from: g */
    private final C0259b f23026g = C0259b.m21117a();

    /* renamed from: a */
    public static String f23020a = "1.6";

    /* renamed from: c */
    private static C5745a f23022c = new C5745a();

    /* renamed from: d */
    private static Object f23023d = new Object();

    static {
        f23022c.m55c();
    }

    private C5745a() {
        this.f23025f.mo21000b("default");
    }

    /* renamed from: a */
    public static C5745a m57a() {
        return f23022c;
    }

    /* renamed from: b */
    static void m56b() {
        f23022c = new C5745a();
        f23022c.m55c();
    }

    /* renamed from: c */
    void m55c() {
        try {
            try {
                new C0258a(this.f23025f).m21122a();
            } catch (C0346m e) {
                C5741m.m123a("Failed to auto configure default logger context", e);
            }
            if (!C0552l.m20177a(this.f23025f)) {
                C0591w.m20053a(this.f23025f);
            }
            this.f23026g.m21116a(this.f23025f, f23023d);
            this.f23024e = true;
        } catch (Throwable th) {
            C5741m.m123a("Failed to instantiate [" + C0151f.class.getName() + "]", th);
        }
    }

    @Override // org.p318d.p322d.AbstractC5750b
    /* renamed from: d */
    public AbstractC5721a mo30d() {
        if (!this.f23024e) {
            return this.f23025f;
        }
        if (this.f23026g.m21114b() != null) {
            return this.f23026g.m21114b().mo21276a();
        }
        throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
    }

    @Override // org.p318d.p322d.AbstractC5750b
    /* renamed from: e */
    public String mo29e() {
        return this.f23026g.getClass().getName();
    }
}
