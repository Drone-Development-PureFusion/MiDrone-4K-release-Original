package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
import java.util.Arrays;
/* renamed from: b.a.a.a.n.s */
/* loaded from: classes.dex */
public class C0246s implements AbstractC0232e, Serializable {
    private static final long serialVersionUID = -773438177285807139L;

    /* renamed from: a */
    private String f414a;

    /* renamed from: b */
    private String f415b;

    /* renamed from: c */
    private int f416c;

    /* renamed from: d */
    private C0243p[] f417d;

    /* renamed from: e */
    private AbstractC0232e f418e;

    /* renamed from: f */
    private AbstractC0232e[] f419f;

    /* renamed from: a */
    public static C0246s m21171a(AbstractC0232e abstractC0232e) {
        if (abstractC0232e == null) {
            return null;
        }
        C0246s c0246s = new C0246s();
        c0246s.f414a = abstractC0232e.mo21170b();
        c0246s.f415b = abstractC0232e.mo21172a();
        c0246s.f416c = abstractC0232e.mo21168d();
        c0246s.f417d = abstractC0232e.mo21169c();
        AbstractC0232e mo21167e = abstractC0232e.mo21167e();
        if (mo21167e != null) {
            c0246s.f418e = m21171a(mo21167e);
        }
        AbstractC0232e[] mo21166f = abstractC0232e.mo21166f();
        if (mo21166f != null) {
            c0246s.f419f = new AbstractC0232e[mo21166f.length];
            for (int i = 0; i < mo21166f.length; i++) {
                c0246s.f419f[i] = m21171a(mo21166f[i]);
            }
        }
        return c0246s;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: a */
    public String mo21172a() {
        return this.f415b;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: b */
    public String mo21170b() {
        return this.f414a;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: c */
    public C0243p[] mo21169c() {
        return this.f417d;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: d */
    public int mo21168d() {
        return this.f416c;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: e */
    public AbstractC0232e mo21167e() {
        return this.f418e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0246s c0246s = (C0246s) obj;
            if (this.f414a == null) {
                if (c0246s.f414a != null) {
                    return false;
                }
            } else if (!this.f414a.equals(c0246s.f414a)) {
                return false;
            }
            if (Arrays.equals(this.f417d, c0246s.f417d) && Arrays.equals(this.f419f, c0246s.f419f)) {
                return this.f418e == null ? c0246s.f418e == null : this.f418e.equals(c0246s.f418e);
            }
            return false;
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0232e
    /* renamed from: f */
    public AbstractC0232e[] mo21166f() {
        return this.f419f;
    }

    public int hashCode() {
        return (this.f414a == null ? 0 : this.f414a.hashCode()) + 31;
    }
}
