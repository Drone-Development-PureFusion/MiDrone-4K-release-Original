package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
import java.util.Map;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.a.n.j */
/* loaded from: classes.dex */
public class C0237j implements Serializable {
    private static final long serialVersionUID = 5488023392483144387L;

    /* renamed from: a */
    final String f360a;

    /* renamed from: b */
    final Map<String, String> f361b;

    /* renamed from: c */
    final long f362c;

    public C0237j(C0151f c0151f) {
        this.f360a = c0151f.p();
        this.f361b = c0151f.o();
        this.f362c = c0151f.q();
    }

    public C0237j(String str, Map<String, String> map, long j) {
        this.f360a = str;
        this.f361b = map;
        this.f362c = j;
    }

    /* renamed from: a */
    public String m21241a() {
        return this.f360a;
    }

    /* renamed from: b */
    public Map<String, String> m21240b() {
        return this.f361b;
    }

    /* renamed from: c */
    public long m21239c() {
        return this.f362c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0237j)) {
            return false;
        }
        C0237j c0237j = (C0237j) obj;
        if (this.f362c != c0237j.f362c) {
            return false;
        }
        if (this.f360a == null ? c0237j.f360a != null : !this.f360a.equals(c0237j.f360a)) {
            return false;
        }
        if (this.f361b != null) {
            if (this.f361b.equals(c0237j.f361b)) {
                return true;
            }
        } else if (c0237j.f361b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f360a != null ? this.f360a.hashCode() : 0) * 31;
        if (this.f361b != null) {
            i = this.f361b.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.f362c ^ (this.f362c >>> 32)));
    }

    public String toString() {
        return "LoggerContextVO{name='" + this.f360a + C0359h.f729z + ", propertyMap=" + this.f361b + ", birthTime=" + this.f362c + C0359h.f726w;
    }
}
