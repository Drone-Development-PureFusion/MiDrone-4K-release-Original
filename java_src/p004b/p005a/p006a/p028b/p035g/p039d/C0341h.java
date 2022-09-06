package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.List;
/* renamed from: b.a.a.b.g.d.h */
/* loaded from: classes.dex */
public class C0341h extends C0340g {
    public C0341h() {
    }

    public C0341h(String str) {
        super(str);
    }

    public C0341h(List<String> list) {
        super(list);
    }

    /* renamed from: a */
    private boolean m20894a(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    /* renamed from: a */
    public boolean m20895a(C0340g c0340g) {
        if (c0340g.m20897e() != e()) {
            return false;
        }
        int e = e();
        for (int i = 0; i < e; i++) {
            if (!m20894a(a(i), c0340g.m20903a(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int m20893b(C0340g c0340g) {
        if (c0340g == null) {
            return 0;
        }
        int size = this.f634a.size();
        int size2 = c0340g.f634a.size();
        if (size == 0 || size2 == 0) {
            return 0;
        }
        int i = size <= size2 ? size : size2;
        int i2 = 0;
        for (int i3 = 1; i3 <= i && m20894a(this.f634a.get(size - i3), c0340g.f634a.get(size2 - i3)); i3++) {
            i2++;
        }
        return i2;
    }

    /* renamed from: c */
    public boolean m20892c(C0340g c0340g) {
        if (c0340g == null) {
            return false;
        }
        return c0340g.m20896f().contains(f());
    }

    /* renamed from: d */
    public int m20891d(C0340g c0340g) {
        int i = 0;
        if (c0340g == null) {
            return 0;
        }
        int size = this.f634a.size();
        int size2 = c0340g.f634a.size();
        if (size == 0 || size2 == 0) {
            return 0;
        }
        int i2 = size <= size2 ? size : size2;
        int i3 = 0;
        while (i3 < i2 && m20894a(this.f634a.get(i3), c0340g.f634a.get(i3))) {
            i3++;
            i++;
        }
        return i;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p039d.C0340g
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0341h)) {
            return false;
        }
        C0341h c0341h = (C0341h) obj;
        if (c0341h.e() != e()) {
            return false;
        }
        int e = e();
        for (int i = 0; i < e; i++) {
            if (!m20894a(a(i), c0341h.a(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int e = e();
        int i = 0;
        for (int i2 = 0; i2 < e; i2++) {
            i ^= a(i2).toLowerCase().hashCode();
        }
        return i;
    }
}
