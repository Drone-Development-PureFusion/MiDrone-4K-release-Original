package p004b.p005a.p006a.p028b.p056q;

import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.q.a */
/* loaded from: classes.dex */
public class C0555a {

    /* renamed from: a */
    EnumC0557a f1226a;

    /* renamed from: b */
    Object f1227b;

    /* renamed from: c */
    Object f1228c;

    /* renamed from: d */
    C0555a f1229d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.b.q.a$a */
    /* loaded from: classes.dex */
    public enum EnumC0557a {
        LITERAL,
        VARIABLE
    }

    public C0555a(EnumC0557a enumC0557a, Object obj) {
        this.f1226a = enumC0557a;
        this.f1227b = obj;
    }

    public C0555a(EnumC0557a enumC0557a, Object obj, Object obj2) {
        this.f1226a = enumC0557a;
        this.f1227b = obj;
        this.f1228c = obj2;
    }

    /* renamed from: a */
    public void m20154a() {
        System.out.print(toString());
        System.out.print(" -> ");
        if (this.f1229d != null) {
            this.f1229d.m20154a();
        } else {
            System.out.print(" null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m20153a(C0555a c0555a) {
        if (c0555a == null) {
            return;
        }
        while (this.f1229d != null) {
            this = this.f1229d;
        }
        this.f1229d = c0555a;
    }

    /* renamed from: a */
    void m20152a(C0555a c0555a, StringBuilder sb) {
        while (c0555a != null) {
            sb.append(c0555a.toString()).append(" --> ");
            c0555a = c0555a.f1229d;
        }
        sb.append("null ");
    }

    /* renamed from: b */
    public void m20151b(C0555a c0555a) {
        this.f1229d = c0555a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0555a c0555a = (C0555a) obj;
        if (this.f1226a != c0555a.f1226a) {
            return false;
        }
        if (this.f1227b == null ? c0555a.f1227b != null : !this.f1227b.equals(c0555a.f1227b)) {
            return false;
        }
        if (this.f1228c == null ? c0555a.f1228c != null : !this.f1228c.equals(c0555a.f1228c)) {
            return false;
        }
        if (this.f1229d != null) {
            if (this.f1229d.equals(c0555a.f1229d)) {
                return true;
            }
        } else if (c0555a.f1229d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f1228c != null ? this.f1228c.hashCode() : 0) + (((this.f1227b != null ? this.f1227b.hashCode() : 0) + ((this.f1226a != null ? this.f1226a.hashCode() : 0) * 31)) * 31)) * 31;
        if (this.f1229d != null) {
            i = this.f1229d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        switch (this.f1226a) {
            case LITERAL:
                return "Node{type=" + this.f1226a + ", payload='" + this.f1227b + "'}";
            case VARIABLE:
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (this.f1228c != null) {
                    m20152a((C0555a) this.f1228c, sb2);
                }
                m20152a((C0555a) this.f1227b, sb);
                String str = "Node{type=" + this.f1226a + ", payload='" + sb.toString() + "'";
                if (this.f1228c != null) {
                    str = str + ", defaultPart=" + sb2.toString();
                }
                return str + C0359h.f726w;
            default:
                return null;
        }
    }
}
