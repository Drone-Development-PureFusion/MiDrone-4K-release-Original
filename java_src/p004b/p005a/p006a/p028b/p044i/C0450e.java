package p004b.p005a.p006a.p028b.p044i;
/* renamed from: b.a.a.b.i.e */
/* loaded from: classes.dex */
public class C0450e {

    /* renamed from: a */
    private int f996a;

    /* renamed from: b */
    private int f997b;

    /* renamed from: c */
    private boolean f998c;

    /* renamed from: d */
    private boolean f999d;

    public C0450e() {
        this.f996a = Integer.MIN_VALUE;
        this.f997b = Integer.MAX_VALUE;
        this.f998c = true;
        this.f999d = true;
    }

    public C0450e(int i, int i2) {
        this.f996a = Integer.MIN_VALUE;
        this.f997b = Integer.MAX_VALUE;
        this.f998c = true;
        this.f999d = true;
        this.f996a = i;
        this.f997b = i2;
    }

    public C0450e(int i, int i2, boolean z, boolean z2) {
        this.f996a = Integer.MIN_VALUE;
        this.f997b = Integer.MAX_VALUE;
        this.f998c = true;
        this.f999d = true;
        this.f996a = i;
        this.f997b = i2;
        this.f998c = z;
        this.f999d = z2;
    }

    /* renamed from: a */
    public static C0450e m20488a(String str) {
        if (str == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        C0450e c0450e = new C0450e();
        int indexOf = str.indexOf(46);
        String str2 = null;
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            if (indexOf + 1 == str.length()) {
                throw new IllegalArgumentException("Formatting string [" + str + "] should not end with '.'");
            }
            str2 = str.substring(indexOf + 1);
            str = substring;
        }
        if (str != null && str.length() > 0) {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                c0450e.f996a = parseInt;
            } else {
                c0450e.f996a = -parseInt;
                c0450e.f998c = false;
            }
        }
        if (str2 != null && str2.length() > 0) {
            int parseInt2 = Integer.parseInt(str2);
            if (parseInt2 >= 0) {
                c0450e.f997b = parseInt2;
            } else {
                c0450e.f997b = -parseInt2;
                c0450e.f999d = false;
            }
        }
        return c0450e;
    }

    /* renamed from: a */
    public void m20489a(int i) {
        this.f997b = i;
    }

    /* renamed from: a */
    public void m20487a(boolean z) {
        this.f998c = z;
    }

    /* renamed from: a */
    public boolean m20490a() {
        return this.f998c;
    }

    /* renamed from: b */
    public int m20486b() {
        return this.f997b;
    }

    /* renamed from: b */
    public void m20485b(int i) {
        this.f996a = i;
    }

    /* renamed from: b */
    public void m20484b(boolean z) {
        this.f999d = z;
    }

    /* renamed from: c */
    public int m20483c() {
        return this.f996a;
    }

    /* renamed from: d */
    public boolean m20482d() {
        return this.f999d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0450e)) {
            return false;
        }
        C0450e c0450e = (C0450e) obj;
        return this.f996a == c0450e.f996a && this.f997b == c0450e.f997b && this.f998c == c0450e.f998c && this.f999d == c0450e.f999d;
    }

    public int hashCode() {
        int i = 1;
        int i2 = ((this.f998c ? 1 : 0) + (((this.f996a * 31) + this.f997b) * 31)) * 31;
        if (!this.f999d) {
            i = 0;
        }
        return i2 + i;
    }

    public String toString() {
        return "FormatInfo(" + this.f996a + ", " + this.f997b + ", " + this.f998c + ", " + this.f999d + ")";
    }
}
