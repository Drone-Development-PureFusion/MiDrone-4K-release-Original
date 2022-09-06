package cn.sharesdk.framework.p075b.p077b;
/* renamed from: cn.sharesdk.framework.b.b.a */
/* loaded from: classes.dex */
public class C0655a extends AbstractC0657c {

    /* renamed from: c */
    private static int f1496c;

    /* renamed from: d */
    private static long f1497d;

    /* renamed from: a */
    public int f1498a;

    /* renamed from: b */
    public String f1499b;

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected String mo19653a() {
        return "[API]";
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected void mo19652a(long j) {
        f1497d = j;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    protected int mo19650b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: c */
    protected int mo19648c() {
        return 50;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: d */
    protected long mo19647d() {
        return f1496c;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: e */
    protected long mo19646e() {
        return f1497d;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: f */
    protected void mo19645f() {
        f1496c++;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|').append(this.f1498a);
        sb.append('|').append(this.f1499b);
        return sb.toString();
    }
}
