package p004b.p005a.p006a.p028b.p057r;
/* renamed from: b.a.a.b.r.r */
/* loaded from: classes.dex */
public class C0584r {

    /* renamed from: a */
    private static final int f1300a = 65535;

    /* renamed from: e */
    private static final long f1301e = 100;

    /* renamed from: b */
    private volatile long f1302b = 15;

    /* renamed from: c */
    private volatile long f1303c = System.currentTimeMillis();

    /* renamed from: d */
    private long f1304d = 0;

    /* renamed from: f */
    private final long f1305f = 800;

    /* renamed from: a */
    public void m20083a(long j) {
        long j2 = j - this.f1303c;
        this.f1303c = j;
        if (j2 < f1301e && this.f1302b < 65535) {
            this.f1302b = (this.f1302b << 1) | 1;
        } else if (j2 <= 800) {
        } else {
            this.f1302b >>>= 2;
        }
    }

    /* renamed from: a */
    public boolean m20084a() {
        long j = this.f1304d;
        this.f1304d = 1 + j;
        return (j & this.f1302b) != this.f1302b;
    }
}
