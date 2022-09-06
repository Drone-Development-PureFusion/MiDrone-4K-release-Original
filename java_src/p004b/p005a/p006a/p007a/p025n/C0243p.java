package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
/* renamed from: b.a.a.a.n.p */
/* loaded from: classes.dex */
public class C0243p implements Serializable {
    private static final long serialVersionUID = -2374374378980555982L;

    /* renamed from: a */
    final StackTraceElement f397a;

    /* renamed from: b */
    private transient String f398b;

    /* renamed from: c */
    private C0229b f399c;

    public C0243p(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            throw new IllegalArgumentException("ste cannot be null");
        }
        this.f397a = stackTraceElement;
    }

    /* renamed from: a */
    public String m21194a() {
        if (this.f398b == null) {
            this.f398b = "at " + this.f397a.toString();
        }
        return this.f398b;
    }

    /* renamed from: a */
    public void m21193a(C0229b c0229b) {
        if (this.f399c != null) {
            throw new IllegalStateException("Packaging data has been already set");
        }
        this.f399c = c0229b;
    }

    /* renamed from: b */
    public StackTraceElement m21192b() {
        return this.f397a;
    }

    /* renamed from: c */
    public C0229b m21191c() {
        return this.f399c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0243p c0243p = (C0243p) obj;
            if (!this.f397a.equals(c0243p.f397a)) {
                return false;
            }
            return this.f399c == null ? c0243p.f399c == null : this.f399c.equals(c0243p.f399c);
        }
        return false;
    }

    public int hashCode() {
        return this.f397a.hashCode();
    }

    public String toString() {
        return m21194a();
    }
}
