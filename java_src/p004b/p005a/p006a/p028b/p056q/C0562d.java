package p004b.p005a.p006a.p028b.p056q;

import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.q.d */
/* loaded from: classes.dex */
public class C0562d {

    /* renamed from: a */
    public static final C0562d f1241a = new C0562d(EnumC0563a.START, null);

    /* renamed from: b */
    public static final C0562d f1242b = new C0562d(EnumC0563a.CURLY_LEFT, null);

    /* renamed from: c */
    public static final C0562d f1243c = new C0562d(EnumC0563a.CURLY_RIGHT, null);

    /* renamed from: d */
    public static final C0562d f1244d = new C0562d(EnumC0563a.DEFAULT, null);

    /* renamed from: e */
    EnumC0563a f1245e;

    /* renamed from: f */
    String f1246f;

    /* renamed from: b.a.a.b.q.d$a */
    /* loaded from: classes.dex */
    public enum EnumC0563a {
        LITERAL,
        START,
        CURLY_LEFT,
        CURLY_RIGHT,
        DEFAULT
    }

    public C0562d(EnumC0563a enumC0563a, String str) {
        this.f1245e = enumC0563a;
        this.f1246f = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0562d c0562d = (C0562d) obj;
        if (this.f1245e != c0562d.f1245e) {
            return false;
        }
        if (this.f1246f != null) {
            if (this.f1246f.equals(c0562d.f1246f)) {
                return true;
            }
        } else if (c0562d.f1246f == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f1245e != null ? this.f1245e.hashCode() : 0) * 31;
        if (this.f1246f != null) {
            i = this.f1246f.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String str = "Token{type=" + this.f1245e;
        if (this.f1246f != null) {
            str = str + ", payload='" + this.f1246f + C0359h.f729z;
        }
        return str + C0359h.f726w;
    }
}
