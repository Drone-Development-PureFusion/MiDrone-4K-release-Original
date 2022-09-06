package p069c.p071b;
/* renamed from: c.b.c */
/* loaded from: classes.dex */
public class C0611c {

    /* renamed from: a */
    private static final String f1382a = "...";

    /* renamed from: b */
    private static final String f1383b = "]";

    /* renamed from: c */
    private static final String f1384c = "[";

    /* renamed from: d */
    private int f1385d;

    /* renamed from: e */
    private String f1386e;

    /* renamed from: f */
    private String f1387f;

    /* renamed from: g */
    private int f1388g;

    /* renamed from: h */
    private int f1389h;

    public C0611c(int i, String str, String str2) {
        this.f1385d = i;
        this.f1386e = str;
        this.f1387f = str2;
    }

    /* renamed from: a */
    private void m19934a() {
        this.f1388g = 0;
        int min = Math.min(this.f1386e.length(), this.f1387f.length());
        while (this.f1388g < min && this.f1386e.charAt(this.f1388g) == this.f1387f.charAt(this.f1388g)) {
            this.f1388g++;
        }
    }

    /* renamed from: b */
    private String m19931b(String str) {
        String str2 = f1384c + str.substring(this.f1388g, (str.length() - this.f1389h) + 1) + f1383b;
        if (this.f1388g > 0) {
            str2 = m19930c() + str2;
        }
        return this.f1389h > 0 ? str2 + m19929d() : str2;
    }

    /* renamed from: b */
    private void m19932b() {
        int length = this.f1386e.length() - 1;
        int length2 = this.f1387f.length() - 1;
        while (length2 >= this.f1388g && length >= this.f1388g && this.f1386e.charAt(length) == this.f1387f.charAt(length2)) {
            length2--;
            length--;
        }
        this.f1389h = this.f1386e.length() - length;
    }

    /* renamed from: c */
    private String m19930c() {
        return (this.f1388g > this.f1385d ? f1382a : "") + this.f1386e.substring(Math.max(0, this.f1388g - this.f1385d), this.f1388g);
    }

    /* renamed from: d */
    private String m19929d() {
        return this.f1386e.substring((this.f1386e.length() - this.f1389h) + 1, Math.min((this.f1386e.length() - this.f1389h) + 1 + this.f1385d, this.f1386e.length())) + ((this.f1386e.length() - this.f1389h) + 1 < this.f1386e.length() - this.f1385d ? f1382a : "");
    }

    /* renamed from: e */
    private boolean m19928e() {
        return this.f1386e.equals(this.f1387f);
    }

    /* renamed from: a */
    public String m19933a(String str) {
        if (this.f1386e == null || this.f1387f == null || m19928e()) {
            return C0609a.m19936f(str, this.f1386e, this.f1387f);
        }
        m19934a();
        m19932b();
        return C0609a.m19936f(str, m19931b(this.f1386e), m19931b(this.f1387f));
    }
}
