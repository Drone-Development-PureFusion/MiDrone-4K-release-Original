package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0471a;
import p004b.p005a.p006a.p028b.p051m.p052a.C0472b;
import p004b.p005a.p006a.p028b.p051m.p052a.C0475e;
import p004b.p005a.p006a.p028b.p051m.p052a.C0479h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0483i;
import p004b.p005a.p006a.p028b.p051m.p052a.C0488n;
import p004b.p005a.p006a.p028b.p051m.p052a.EnumC0473c;
/* renamed from: b.a.a.b.m.k */
/* loaded from: classes.dex */
public class C0504k<E> extends AbstractC0498e implements AbstractC0505l<E> {

    /* renamed from: a */
    static final String f1135a = "The FileNamePattern option must be set before using TimeBasedRollingPolicy. ";

    /* renamed from: b */
    static final int f1136b = 0;

    /* renamed from: c */
    C0483i f1137c;

    /* renamed from: d */
    Future<?> f1138d;

    /* renamed from: e */
    AbstractC0502i<E> f1139e;

    /* renamed from: g */
    private C0475e f1141g;

    /* renamed from: n */
    private AbstractC0471a f1144n;

    /* renamed from: h */
    private C0488n f1142h = new C0488n();

    /* renamed from: m */
    private int f1143m = 0;

    /* renamed from: f */
    boolean f1140f = false;

    /* renamed from: b */
    private String m20310b(String str) {
        return C0479h.m20397a(C0479h.m20393b(str));
    }

    /* renamed from: o */
    private void m20306o() {
        if (this.f1138d != null) {
            try {
                this.f1138d.get(30L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                a("Timeout while waiting for compression job to finish", e);
            } catch (Exception e2) {
                a("Unexpected exception while waiting for compression job to finish", e2);
            }
        }
    }

    /* renamed from: a */
    public AbstractC0502i<E> m20317a() {
        return this.f1139e;
    }

    /* renamed from: a */
    Future m20314a(String str, String str2) {
        String n = n();
        String str3 = n + System.nanoTime() + ".tmp";
        this.f1142h.m20372a(n, str3);
        return m20313a(str3, str, str2);
    }

    /* renamed from: a */
    Future m20313a(String str, String str2, String str3) {
        return new C0472b(this.f1141g).m20418a(str, str2, str3);
    }

    /* renamed from: a */
    public void m20316a(int i) {
        this.f1143m = i;
    }

    /* renamed from: a */
    public void m20315a(AbstractC0502i<E> abstractC0502i) {
        this.f1139e = abstractC0502i;
    }

    /* renamed from: a */
    public void m20312a(boolean z) {
        this.f1140f = z;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0505l
    /* renamed from: a */
    public boolean mo20305a(File file, E e) {
        return this.f1139e.a(file, (File) e);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: b */
    public void mo20311b() {
        String mo20321e = this.f1139e.mo20321e();
        String m20397a = C0479h.m20397a(mo20321e);
        if (this.f1113i == EnumC0473c.NONE) {
            if (n() != null) {
                this.f1142h.m20372a(n(), mo20321e);
            }
        } else if (n() == null) {
            this.f1138d = m20313a(mo20321e, mo20321e, m20397a);
        } else {
            this.f1138d = m20314a(mo20321e, m20397a);
        }
        if (this.f1144n != null) {
            this.f1144n.mo20401a(new Date(this.f1139e.mo20319g()));
        }
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: d */
    public String mo20309d() {
        String n = n();
        return n != null ? n : this.f1139e.mo20323b();
    }

    /* renamed from: e */
    public int m20308e() {
        return this.f1143m;
    }

    /* renamed from: f */
    public boolean m20307f() {
        return this.f1140f;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0498e, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f1142h.a(this.f1190s);
        if (this.f1115k == null) {
            e(f1135a);
            e(C0359h.f680J);
            throw new IllegalStateException("The FileNamePattern option must be set before using TimeBasedRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
        }
        this.f1114j = new C0483i(this.f1115k, this.f1190s);
        h();
        this.f1141g = new C0475e(this.f1113i);
        this.f1141g.a(this.f1190s);
        this.f1137c = new C0483i(C0475e.m20415a(this.f1115k, this.f1113i), this.f1190s);
        d("Will use the pattern " + this.f1137c + " for the active file");
        if (this.f1113i == EnumC0473c.ZIP) {
            this.f1116l = new C0483i(m20310b(this.f1115k), this.f1190s);
        }
        if (this.f1139e == null) {
            this.f1139e = new C0470a();
        }
        this.f1139e.a(this.f1190s);
        this.f1139e.mo20325a(this);
        this.f1139e.j();
        if (this.f1143m != 0) {
            this.f1144n = this.f1139e.mo20320f();
            this.f1144n.mo20406a(this.f1143m);
            if (this.f1140f) {
                d("Cleaning on start up");
                this.f1144n.mo20401a(new Date(this.f1139e.mo20319g()));
            }
        }
        super.mo20156j();
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0498e, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        if (!g_()) {
            return;
        }
        m20306o();
        super.mo20155k();
    }

    public String toString() {
        return "c.q.l.core.rolling.TimeBasedRollingPolicy";
    }
}
