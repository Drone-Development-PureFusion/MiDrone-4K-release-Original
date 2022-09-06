package p069c.p071b;
/* renamed from: c.b.d */
/* loaded from: classes.dex */
public class C0612d extends C0610b {

    /* renamed from: a */
    private static final int f1390a = 20;
    private static final long serialVersionUID = 1;

    /* renamed from: b */
    private String f1391b;

    /* renamed from: c */
    private String f1392c;

    public C0612d(String str, String str2, String str3) {
        super(str);
        this.f1391b = str2;
        this.f1392c = str3;
    }

    /* renamed from: a */
    public String m19927a() {
        return this.f1392c;
    }

    /* renamed from: b */
    public String m19926b() {
        return this.f1391b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new C0611c(20, this.f1391b, this.f1392c).m19933a(super.getMessage());
    }
}
