package p004b.p005a.p006a.p028b.p050l;
/* renamed from: b.a.a.b.l.a */
/* loaded from: classes.dex */
public class C0465a {

    /* renamed from: a */
    public static final long f1025a = 20;

    /* renamed from: b */
    static long f1026b = 327680;

    /* renamed from: e */
    private static long f1027e = -1;

    /* renamed from: d */
    private long f1029d = 20;

    /* renamed from: f */
    private long f1030f = f1027e;

    /* renamed from: c */
    long f1028c = System.currentTimeMillis() + m20431c();

    /* renamed from: b */
    private long m20432b() {
        return this.f1030f != f1027e ? this.f1030f : System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m20431c() {
        long j = this.f1029d;
        if (this.f1029d < f1026b) {
            this.f1029d *= 4;
        }
        return j;
    }

    /* renamed from: a */
    void m20433a(long j) {
        this.f1030f = j;
    }

    /* renamed from: a */
    public boolean m20434a() {
        long m20432b = m20432b();
        if (m20432b > this.f1028c) {
            this.f1028c = m20432b + m20431c();
            return false;
        }
        return true;
    }
}
