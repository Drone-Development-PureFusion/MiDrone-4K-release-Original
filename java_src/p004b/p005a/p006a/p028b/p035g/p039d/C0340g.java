package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: b.a.a.b.g.d.g */
/* loaded from: classes.dex */
public class C0340g {

    /* renamed from: a */
    ArrayList<String> f634a = new ArrayList<>();

    public C0340g() {
    }

    public C0340g(String str) {
        String[] split;
        if (str == null || (split = str.split("/")) == null) {
            return;
        }
        for (String str2 : split) {
            if (str2.length() > 0) {
                this.f634a.add(str2);
            }
        }
    }

    public C0340g(List<String> list) {
        this.f634a.addAll(list);
    }

    /* renamed from: a */
    private boolean m20901a(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    /* renamed from: a */
    public C0340g m20904a() {
        C0340g c0340g = new C0340g();
        c0340g.f634a.addAll(this.f634a);
        return c0340g;
    }

    /* renamed from: a */
    public String m20903a(int i) {
        return this.f634a.get(i);
    }

    /* renamed from: a */
    public void m20902a(String str) {
        this.f634a.add(str);
    }

    /* renamed from: b */
    public List<String> m20900b() {
        return new ArrayList(this.f634a);
    }

    /* renamed from: c */
    public void m20899c() {
        if (!this.f634a.isEmpty()) {
            this.f634a.remove(this.f634a.size() - 1);
        }
    }

    /* renamed from: d */
    public String m20898d() {
        if (!this.f634a.isEmpty()) {
            return this.f634a.get(this.f634a.size() - 1);
        }
        return null;
    }

    /* renamed from: e */
    public int m20897e() {
        return this.f634a.size();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0340g)) {
            return false;
        }
        C0340g c0340g = (C0340g) obj;
        if (c0340g.m20897e() != m20897e()) {
            return false;
        }
        int m20897e = m20897e();
        for (int i = 0; i < m20897e; i++) {
            if (!m20901a(m20903a(i), c0340g.m20903a(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public String m20896f() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = this.f634a.iterator();
        while (it2.hasNext()) {
            sb.append("[").append(it2.next()).append("]");
        }
        return sb.toString();
    }

    public String toString() {
        return m20896f();
    }
}
