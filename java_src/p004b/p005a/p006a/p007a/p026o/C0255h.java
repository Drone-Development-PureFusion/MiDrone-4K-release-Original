package p004b.p005a.p006a.p007a.p026o;

import java.net.URL;
import java.util.List;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p015g.C0157a;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p039d.C0334c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p035g.p040e.C0351a;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
import p004b.p005a.p006a.p028b.p055p.C0552l;
/* renamed from: b.a.a.a.o.h */
/* loaded from: classes.dex */
public class C0255h extends AbstractC0257i {

    /* renamed from: a */
    public static final long f438a = 60000;

    /* renamed from: j */
    private static final int f439j = 65535;

    /* renamed from: k */
    private static final long f440k = 100;

    /* renamed from: l */
    private static final long f441l = 800;

    /* renamed from: c */
    URL f443c;

    /* renamed from: d */
    protected volatile long f444d;

    /* renamed from: e */
    C0334c f445e;

    /* renamed from: b */
    long f442b = 60000;

    /* renamed from: g */
    private long f446g = 0;

    /* renamed from: h */
    private volatile long f447h = 15;

    /* renamed from: i */
    private volatile long f448i = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.a.o.h$a */
    /* loaded from: classes.dex */
    public class RunnableC0256a implements Runnable {
        RunnableC0256a() {
        }

        /* renamed from: a */
        private void m21127a(C0151f c0151f) {
            C0157a c0157a = new C0157a();
            c0157a.a(C0255h.this.f1190s);
            C0552l c0552l = new C0552l(C0255h.this.f1190s);
            List<C0328d> e = c0157a.e();
            URL m20835a = C0351a.m20835a(C0255h.this.f1190s);
            c0151f.mo20999f();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c0157a.a(C0255h.this.f443c);
                if (!c0552l.m20179a(currentTimeMillis)) {
                    return;
                }
                m21126a(c0151f, e, m20835a);
            } catch (C0346m e2) {
                m21126a(c0151f, e, m20835a);
            }
        }

        /* renamed from: a */
        private void m21126a(C0151f c0151f, List<C0328d> list, URL url) {
            C0157a c0157a = new C0157a();
            c0157a.a(C0255h.this.f1190s);
            if (list == null) {
                C0255h.this.e("No previous configuration to fall back on.");
                return;
            }
            C0255h.this.e("Falling back to previously registered safe configuration.");
            try {
                c0151f.mo20999f();
                C0157a.a(C0255h.this.f1190s, url);
                c0157a.a(list);
                C0255h.this.d("Re-registering previous fallback configuration once more as a fallback configuration point");
                c0157a.d();
            } catch (C0346m e) {
                C0255h.this.a("Unexpected exception thrown by a configuration considered safe.", e);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0255h.this.f443c == null) {
                C0255h.this.d("Due to missing top level configuration file, skipping reconfiguration");
                return;
            }
            C0151f c0151f = (C0151f) C0255h.this.f1190s;
            C0255h.this.d("Will reset and reconfigure context named [" + C0255h.this.f1190s.mo20996p() + "]");
            if (!C0255h.this.f443c.toString().endsWith("xml")) {
                return;
            }
            m21127a(c0151f);
        }
    }

    /* renamed from: d */
    private void m21132d(long j) {
        long j2 = j - this.f448i;
        this.f448i = j;
        if (j2 < f440k && this.f447h < 65535) {
            this.f447h = (this.f447h << 1) | 1;
        } else if (j2 <= f441l) {
        } else {
            this.f447h >>>= 2;
        }
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i
    /* renamed from: a */
    public EnumC0533l mo21125a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        if (!g_()) {
            return EnumC0533l.NEUTRAL;
        }
        long j = this.f446g;
        this.f446g = 1 + j;
        if ((j & this.f447h) != this.f447h) {
            return EnumC0533l.NEUTRAL;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f445e) {
            m21132d(currentTimeMillis);
            if (m21137b(currentTimeMillis)) {
                m21138b();
                m21141a();
            }
        }
        return EnumC0533l.NEUTRAL;
    }

    /* renamed from: a */
    void m21141a() {
        d("Detected change in [" + this.f445e.m20915c() + "]");
        this.f1190s.mo20993s().submit(new RunnableC0256a());
    }

    /* renamed from: a */
    void m21140a(long j) {
        this.f444d = this.f442b + j;
    }

    /* renamed from: b */
    void m21138b() {
        this.f444d = Long.MAX_VALUE;
    }

    /* renamed from: b */
    protected boolean m21137b(long j) {
        if (j >= this.f444d) {
            m21140a(j);
            return this.f445e.m20913d();
        }
        return false;
    }

    /* renamed from: c */
    public void m21135c(long j) {
        this.f442b = j;
    }

    /* renamed from: d */
    public long m21133d() {
        return this.f442b;
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f445e = C0351a.m20827c(this.f1190s);
        if (this.f445e == null) {
            e("Empty ConfigurationWatchList in context");
            return;
        }
        this.f443c = this.f445e.m20917b();
        if (this.f443c == null) {
            e("Due to missing top level configuration file, automatic reconfiguration is impossible.");
            return;
        }
        d("Will scan for changes in [" + this.f445e.m20915c() + "] every " + (this.f442b / 1000) + " seconds. ");
        synchronized (this.f445e) {
            m21140a(System.currentTimeMillis());
        }
        super.mo20156j();
    }

    public String toString() {
        return "ReconfigureOnChangeFilter{invocationCounter=" + this.f446g + C0359h.f726w;
    }
}
