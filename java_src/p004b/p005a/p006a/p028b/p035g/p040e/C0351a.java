package p004b.p005a.p006a.p028b.p035g.p040e;

import java.net.URL;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0334c;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0542b;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.g.e.a */
/* loaded from: classes.dex */
public class C0351a {

    /* renamed from: a */
    static final C0351a f658a = new C0351a();

    private C0351a() {
    }

    /* renamed from: a */
    public static URL m20835a(AbstractC0292f abstractC0292f) {
        C0334c m20827c = m20827c(abstractC0292f);
        if (m20827c == null) {
            return null;
        }
        return m20827c.m20917b();
    }

    /* renamed from: a */
    static void m20834a(AbstractC0292f abstractC0292f, AbstractC0547g abstractC0547g) {
        if (abstractC0292f == null) {
            System.out.println("Null context in " + C0334c.class.getName());
            return;
        }
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        if (mo20997n == null) {
            return;
        }
        mo20997n.mo20188a(abstractC0547g);
    }

    /* renamed from: a */
    static void m20833a(AbstractC0292f abstractC0292f, String str) {
        m20834a(abstractC0292f, new C0542b(str, f658a));
    }

    /* renamed from: a */
    public static void m20832a(AbstractC0292f abstractC0292f, URL url) {
        if (abstractC0292f == null) {
            return;
        }
        C0334c m20827c = m20827c(abstractC0292f);
        if (m20827c == null) {
            m20827c = new C0334c();
            m20827c.a(abstractC0292f);
            abstractC0292f.mo21002a(C0359h.f681K, m20827c);
        } else {
            m20827c.m20919a();
        }
        m20831a(abstractC0292f, true);
        m20827c.m20918a(url);
    }

    /* renamed from: a */
    public static void m20831a(AbstractC0292f abstractC0292f, boolean z) {
        abstractC0292f.mo21002a(C0359h.f682L, Boolean.valueOf(z));
    }

    /* renamed from: b */
    static void m20829b(AbstractC0292f abstractC0292f, String str) {
        m20834a(abstractC0292f, new C0553m(str, f658a));
    }

    /* renamed from: b */
    public static void m20828b(AbstractC0292f abstractC0292f, URL url) {
        C0334c m20827c = m20827c(abstractC0292f);
        if (m20827c == null) {
            m20829b(abstractC0292f, "Null ConfigurationWatchList. Cannot add " + url);
            return;
        }
        m20833a(abstractC0292f, "Adding [" + url + "] to configuration watch list.");
        m20827c.m20916b(url);
    }

    /* renamed from: b */
    public static boolean m20830b(AbstractC0292f abstractC0292f) {
        Object mo20998f;
        if (abstractC0292f != null && (mo20998f = abstractC0292f.mo20998f(C0359h.f682L)) != null) {
            return ((Boolean) mo20998f).booleanValue();
        }
        return false;
    }

    /* renamed from: c */
    public static C0334c m20827c(AbstractC0292f abstractC0292f) {
        if (abstractC0292f == null) {
            return null;
        }
        return (C0334c) abstractC0292f.mo20998f(C0359h.f681K);
    }
}
