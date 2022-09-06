package p004b.p005a.p006a.p007a.p025n;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.p318d.AbstractC5756f;
import org.p318d.C5753e;
import org.p318d.p320b.C5734f;
import org.p318d.p322d.AbstractC5751c;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p027p.C0263f;
/* renamed from: b.a.a.a.n.l */
/* loaded from: classes.dex */
public class C0239l implements AbstractC0231d {

    /* renamed from: n */
    private static final Map<String, String> f366n = new HashMap();

    /* renamed from: a */
    transient String f367a;

    /* renamed from: b */
    transient String f368b;

    /* renamed from: c */
    private String f369c;

    /* renamed from: d */
    private String f370d;

    /* renamed from: e */
    private C0151f f371e;

    /* renamed from: f */
    private C0237j f372f;

    /* renamed from: g */
    private transient C0146d f373g;

    /* renamed from: h */
    private String f374h;

    /* renamed from: i */
    private transient Object[] f375i;

    /* renamed from: j */
    private C0244q f376j;

    /* renamed from: k */
    private StackTraceElement[] f377k;

    /* renamed from: l */
    private AbstractC5756f f378l;

    /* renamed from: m */
    private Map<String, String> f379m;

    /* renamed from: o */
    private long f380o;

    public C0239l() {
    }

    public C0239l(String str, C0148e c0148e, C0146d c0146d, String str2, Throwable th, Object[] objArr) {
        this.f367a = str;
        this.f370d = c0148e.mo88d();
        this.f371e = c0148e.m21456n();
        this.f372f = this.f371e.m21432d();
        this.f373g = c0146d;
        this.f374h = str2;
        this.f375i = objArr;
        th = th == null ? m21225b(objArr) : th;
        if (th != null) {
            this.f376j = new C0244q(th);
            if (c0148e.m21456n().m21430e()) {
                this.f376j.m21188i();
            }
        }
        this.f380o = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m21232a(ObjectOutputStream objectOutputStream) {
        throw new UnsupportedOperationException(getClass() + " does not support serialization. Use LoggerEventVO instance instead. See also LoggerEventVO.build method.");
    }

    /* renamed from: b */
    private Throwable m21225b(Object[] objArr) {
        Throwable m21252a = C0230c.m21252a(objArr);
        if (C0230c.m21253a(m21252a)) {
            this.f375i = C0230c.m21251b(objArr);
        }
        return m21252a;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: a */
    public String mo21222a() {
        if (this.f369c == null) {
            this.f369c = Thread.currentThread().getName();
        }
        return this.f369c;
    }

    /* renamed from: a */
    public void m21236a(long j) {
        this.f380o = j;
    }

    /* renamed from: a */
    public void m21235a(C0146d c0146d) {
        if (this.f373g != null) {
            throw new IllegalStateException("The level has been already set for this event.");
        }
        this.f373g = c0146d;
    }

    /* renamed from: a */
    public void m21234a(C0237j c0237j) {
        this.f372f = c0237j;
    }

    /* renamed from: a */
    public void m21233a(C0244q c0244q) {
        if (this.f376j != null) {
            throw new IllegalStateException("ThrowableProxy has been already set.");
        }
        this.f376j = c0244q;
    }

    /* renamed from: a */
    public void m21231a(String str) {
        this.f370d = str;
    }

    /* renamed from: a */
    public void m21230a(Map<String, String> map) {
        if (this.f379m != null) {
            throw new IllegalStateException("The MDCPropertyMap has been already set for this event.");
        }
        this.f379m = map;
    }

    /* renamed from: a */
    public void m21229a(AbstractC5756f abstractC5756f) {
        if (this.f378l != null) {
            throw new IllegalStateException("The marker has been already set for this event.");
        }
        this.f378l = abstractC5756f;
    }

    /* renamed from: a */
    public void m21228a(Object[] objArr) {
        if (this.f375i != null) {
            throw new IllegalStateException("argArray has been already set");
        }
        this.f375i = objArr;
    }

    /* renamed from: a */
    public void m21227a(StackTraceElement[] stackTraceElementArr) {
        this.f377k = stackTraceElementArr;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: b */
    public C0146d mo21220b() {
        return this.f373g;
    }

    /* renamed from: b */
    public void m21226b(String str) {
        if (this.f369c != null) {
            throw new IllegalStateException("threadName has been already set");
        }
        this.f369c = str;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: c */
    public String mo21219c() {
        return this.f374h;
    }

    /* renamed from: c */
    public void m21224c(String str) {
        if (this.f374h != null) {
            throw new IllegalStateException("The message for this event has been set already.");
        }
        this.f374h = str;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: d */
    public Object[] mo21218d() {
        return this.f375i;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: e */
    public String mo21217e() {
        if (this.f368b != null) {
            return this.f368b;
        }
        if (this.f375i != null) {
            this.f368b = C5734f.m154a(this.f374h, this.f375i).m160a();
        } else {
            this.f368b = this.f374h;
        }
        return this.f368b;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: f */
    public String mo21216f() {
        return this.f370d;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: g */
    public C0237j mo21215g() {
        return this.f372f;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: h */
    public AbstractC0232e mo21214h() {
        return this.f376j;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: i */
    public StackTraceElement[] mo21213i() {
        if (this.f377k == null) {
            this.f377k = C0228a.m21257a(new Throwable(), this.f367a, this.f371e.m21425l(), this.f371e.m21424m());
        }
        return this.f377k;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: j */
    public boolean mo21212j() {
        return this.f377k != null;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: k */
    public AbstractC5756f mo21211k() {
        return this.f378l;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: l */
    public Map<String, String> mo21210l() {
        if (this.f379m == null) {
            AbstractC5751c m13c = C5753e.m13c();
            if (m13c instanceof C0263f) {
                this.f379m = ((C0263f) m13c).m21108b();
            } else {
                this.f379m = m13c.mo23d();
            }
        }
        if (this.f379m == null) {
            this.f379m = f366n;
        }
        return this.f379m;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: m */
    public Map<String, String> mo21209m() {
        return mo21210l();
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: n */
    public long mo21208n() {
        return this.f380o;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d, p004b.p005a.p006a.p028b.p054o.AbstractC0530i
    /* renamed from: o */
    public void mo20213o() {
        mo21217e();
        mo21222a();
        mo21210l();
    }

    /* renamed from: p */
    public long m21223p() {
        return this.f372f.m21239c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.f373g).append("] ");
        sb.append(mo21217e());
        return sb.toString();
    }
}
