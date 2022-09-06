package cn.sharesdk.framework.p075b.p077b;
/* renamed from: cn.sharesdk.framework.b.b.d */
/* loaded from: classes.dex */
public class C0658d extends AbstractC0657c {

    /* renamed from: d */
    private static int f1515d;

    /* renamed from: n */
    private static long f1516n;

    /* renamed from: a */
    public String f1517a;

    /* renamed from: b */
    public int f1518b;

    /* renamed from: c */
    public String f1519c = "";

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected String mo19653a() {
        return "[EVT]";
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected void mo19652a(long j) {
        f1516n = j;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    protected int mo19650b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: c */
    protected int mo19648c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: d */
    protected long mo19647d() {
        return f1515d;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: e */
    protected long mo19646e() {
        return f1516n;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: f */
    protected void mo19645f() {
        f1515d++;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|').append(this.f1517a);
        sb.append('|').append(this.f1518b);
        sb.append('|').append(this.f1519c);
        return sb.toString();
    }
}
