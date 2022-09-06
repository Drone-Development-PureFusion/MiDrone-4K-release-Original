package p004b.p005a.p006a.p028b.p035g.p039d;
/* renamed from: b.a.a.b.g.d.j */
/* loaded from: classes.dex */
public class C0343j {

    /* renamed from: a */
    final Class<?> f638a;

    /* renamed from: b */
    final String f639b;

    public C0343j(Class<?> cls, String str) {
        this.f638a = cls;
        this.f639b = str;
    }

    /* renamed from: a */
    public Class<?> m20887a() {
        return this.f638a;
    }

    /* renamed from: b */
    public String m20886b() {
        return this.f639b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0343j c0343j = (C0343j) obj;
            if (this.f638a == null) {
                if (c0343j.f638a != null) {
                    return false;
                }
            } else if (!this.f638a.equals(c0343j.f638a)) {
                return false;
            }
            return this.f639b == null ? c0343j.f639b == null : this.f639b.equals(c0343j.f639b);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f638a == null ? 0 : this.f638a.hashCode()) + 31) * 31;
        if (this.f639b != null) {
            i = this.f639b.hashCode();
        }
        return hashCode + i;
    }
}
