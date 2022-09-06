package p004b.p005a.p006a.p028b.p044i.p046b;
/* renamed from: b.a.a.b.i.b.d */
/* loaded from: classes.dex */
public class C0435d {

    /* renamed from: c */
    static final int f941c = 0;

    /* renamed from: d */
    static final int f942d = 1;

    /* renamed from: e */
    static final int f943e = 2;

    /* renamed from: f */
    final int f944f;

    /* renamed from: g */
    final Object f945g;

    /* renamed from: h */
    C0435d f946h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0435d(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0435d(int i, Object obj) {
        this.f944f = i;
        this.f945g = obj;
    }

    /* renamed from: b */
    public void m20532b(C0435d c0435d) {
        this.f946h = c0435d;
    }

    /* renamed from: c */
    public int m20531c() {
        return this.f944f;
    }

    /* renamed from: d */
    public Object m20530d() {
        return this.f945g;
    }

    /* renamed from: e */
    public C0435d m20529e() {
        return this.f946h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0435d)) {
            return false;
        }
        C0435d c0435d = (C0435d) obj;
        if (this.f944f == c0435d.f944f && (this.f945g == null ? c0435d.f945g == null : this.f945g.equals(c0435d.f945g))) {
            if (this.f946h != null) {
                if (this.f946h.equals(c0435d.f946h)) {
                    return true;
                }
            } else if (c0435d.f946h == null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public String m20528f() {
        return this.f946h != null ? " -> " + this.f946h : "";
    }

    public int hashCode() {
        return (this.f945g != null ? this.f945g.hashCode() : 0) + (this.f944f * 31);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.f944f) {
            case 0:
                stringBuffer.append("LITERAL(" + this.f945g + ")");
                break;
            default:
                stringBuffer.append(super.toString());
                break;
        }
        stringBuffer.append(m20528f());
        return stringBuffer.toString();
    }
}
