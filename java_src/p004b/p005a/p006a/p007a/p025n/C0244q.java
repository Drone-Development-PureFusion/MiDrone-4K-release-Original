package p004b.p005a.p006a.p007a.p025n;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.a.n.q */
/* loaded from: classes.dex */
public class C0244q implements AbstractC0232e {

    /* renamed from: j */
    private static final Method f400j;

    /* renamed from: k */
    private static final C0244q[] f401k;

    /* renamed from: a */
    C0243p[] f402a;

    /* renamed from: b */
    int f403b;

    /* renamed from: c */
    private Throwable f404c;

    /* renamed from: d */
    private String f405d;

    /* renamed from: e */
    private String f406e;

    /* renamed from: f */
    private C0244q f407f;

    /* renamed from: g */
    private C0244q[] f408g;

    /* renamed from: h */
    private transient C0241n f409h;

    /* renamed from: i */
    private boolean f410i = false;

    static {
        Method method = null;
        try {
            method = Throwable.class.getMethod("getSuppressed", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
        f400j = method;
        f401k = new C0244q[0];
    }

    public C0244q(Throwable th) {
        this.f408g = f401k;
        this.f404c = th;
        this.f405d = th.getClass().getName();
        this.f406e = th.getMessage();
        this.f402a = C0245r.m21179a(th.getStackTrace());
        Throwable cause = th.getCause();
        if (cause != null) {
            this.f407f = new C0244q(cause);
            this.f407f.f403b = C0245r.m21178a(cause.getStackTrace(), this.f402a);
        }
        if (f400j != null) {
            try {
                Object invoke = f400j.invoke(th, new Object[0]);
                if (!(invoke instanceof Throwable[])) {
                    return;
                }
                Throwable[] thArr = (Throwable[]) invoke;
                if (thArr.length <= 0) {
                    return;
                }
                this.f408g = new C0244q[thArr.length];
                for (int i = 0; i < thArr.length; i++) {
                    this.f408g[i] = new C0244q(thArr[i]);
                    this.f408g[i].f403b = C0245r.m21178a(thArr[i].getStackTrace(), this.f402a);
                }
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: a */
    public String mo21172a() {
        return this.f406e;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: b */
    public String mo21170b() {
        return this.f405d;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: c */
    public C0243p[] mo21169c() {
        return this.f402a;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: d */
    public int mo21168d() {
        return this.f403b;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: e */
    public AbstractC0232e mo21167e() {
        return this.f407f;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: f */
    public AbstractC0232e[] mo21166f() {
        return this.f408g;
    }

    /* renamed from: g */
    public Throwable m21190g() {
        return this.f404c;
    }

    /* renamed from: h */
    public C0241n m21189h() {
        if (this.f404c != null && this.f409h == null) {
            this.f409h = new C0241n();
        }
        return this.f409h;
    }

    /* renamed from: i */
    public void m21188i() {
        C0241n m21189h;
        if (!this.f410i && (m21189h = m21189h()) != null) {
            this.f410i = true;
            m21189h.m21203a(this);
        }
    }

    /* renamed from: j */
    public void m21187j() {
        C0243p[] c0243pArr;
        StringBuilder sb = new StringBuilder();
        for (C0243p c0243p : this.f402a) {
            sb.append('\t').append(c0243p.toString());
            C0245r.m21181a(sb, c0243p);
            sb.append(C0359h.f706c);
        }
        System.out.println(sb.toString());
    }
}
