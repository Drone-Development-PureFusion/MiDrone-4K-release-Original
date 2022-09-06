package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
/* renamed from: b.a.a.a.n.b */
/* loaded from: classes.dex */
public class C0229b implements Serializable {
    private static final long serialVersionUID = -804643281218337001L;

    /* renamed from: a */
    final String f357a;

    /* renamed from: b */
    final String f358b;

    /* renamed from: c */
    private final boolean f359c;

    public C0229b(String str, String str2) {
        this.f357a = str;
        this.f358b = str2;
        this.f359c = true;
    }

    public C0229b(String str, String str2, boolean z) {
        this.f357a = str;
        this.f358b = str2;
        this.f359c = z;
    }

    /* renamed from: a */
    public String m21256a() {
        return this.f357a;
    }

    /* renamed from: b */
    public String m21255b() {
        return this.f358b;
    }

    /* renamed from: c */
    public boolean m21254c() {
        return this.f359c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0229b c0229b = (C0229b) obj;
            if (this.f357a == null) {
                if (c0229b.f357a != null) {
                    return false;
                }
            } else if (!this.f357a.equals(c0229b.f357a)) {
                return false;
            }
            if (this.f359c != c0229b.f359c) {
                return false;
            }
            return this.f358b == null ? c0229b.f358b == null : this.f358b.equals(c0229b.f358b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f357a == null ? 0 : this.f357a.hashCode()) + 31;
    }
}
