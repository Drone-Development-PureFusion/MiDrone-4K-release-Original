package p004b.p005a.p006a.p007a;

import java.io.Serializable;
import org.p248a.p249a.p252c.p255c.C5050o;
/* renamed from: b.a.a.a.d */
/* loaded from: classes.dex */
public final class C0146d implements Serializable {

    /* renamed from: a */
    public static final int f187a = Integer.MAX_VALUE;

    /* renamed from: c */
    public static final int f189c = 30000;

    /* renamed from: d */
    public static final int f190d = 20000;

    /* renamed from: e */
    public static final int f191e = 10000;

    /* renamed from: f */
    public static final int f192f = 5000;

    /* renamed from: g */
    public static final int f193g = Integer.MIN_VALUE;
    private static final long serialVersionUID = -814092767334282137L;

    /* renamed from: v */
    public final int f208v;

    /* renamed from: w */
    public final String f209w;

    /* renamed from: h */
    public static final Integer f194h = Integer.MAX_VALUE;

    /* renamed from: b */
    public static final int f188b = 40000;

    /* renamed from: i */
    public static final Integer f195i = Integer.valueOf((int) f188b);

    /* renamed from: j */
    public static final Integer f196j = 30000;

    /* renamed from: k */
    public static final Integer f197k = 20000;

    /* renamed from: l */
    public static final Integer f198l = 10000;

    /* renamed from: m */
    public static final Integer f199m = 5000;

    /* renamed from: n */
    public static final Integer f200n = Integer.MIN_VALUE;

    /* renamed from: o */
    public static final C0146d f201o = new C0146d(Integer.MAX_VALUE, "OFF");

    /* renamed from: p */
    public static final C0146d f202p = new C0146d(f188b, "ERROR");

    /* renamed from: q */
    public static final C0146d f203q = new C0146d(30000, "WARN");

    /* renamed from: r */
    public static final C0146d f204r = new C0146d(20000, "INFO");

    /* renamed from: s */
    public static final C0146d f205s = new C0146d(10000, "DEBUG");

    /* renamed from: t */
    public static final C0146d f206t = new C0146d(5000, C5050o.f21556a);

    /* renamed from: u */
    public static final C0146d f207u = new C0146d(Integer.MIN_VALUE, "ALL");

    private C0146d(int i, String str) {
        this.f208v = i;
        this.f209w = str;
    }

    /* renamed from: a */
    public static C0146d m21485a(int i) {
        return m21484a(i, f205s);
    }

    /* renamed from: a */
    public static C0146d m21484a(int i, C0146d c0146d) {
        switch (i) {
            case Integer.MIN_VALUE:
                return f207u;
            case 5000:
                return f206t;
            case 10000:
                return f205s;
            case 20000:
                return f204r;
            case 30000:
                return f203q;
            case f188b /* 40000 */:
                return f202p;
            case Integer.MAX_VALUE:
                return f201o;
            default:
                return c0146d;
        }
    }

    /* renamed from: a */
    public static C0146d m21482a(String str) {
        return m21481a(str, f205s);
    }

    /* renamed from: a */
    public static C0146d m21481a(String str, C0146d c0146d) {
        return str == null ? c0146d : str.equalsIgnoreCase("ALL") ? f207u : str.equalsIgnoreCase(C5050o.f21556a) ? f206t : str.equalsIgnoreCase("DEBUG") ? f205s : str.equalsIgnoreCase("INFO") ? f204r : str.equalsIgnoreCase("WARN") ? f203q : str.equalsIgnoreCase("ERROR") ? f202p : str.equalsIgnoreCase("OFF") ? f201o : c0146d;
    }

    /* renamed from: b */
    public static int m21478b(C0146d c0146d) {
        if (c0146d == null) {
            throw new IllegalArgumentException("null level parameter is not admitted");
        }
        switch (c0146d.m21486a()) {
            case 5000:
                return 0;
            case 10000:
                return 10;
            case 20000:
                return 20;
            case 30000:
                return 30;
            case f188b /* 40000 */:
                return 40;
            default:
                throw new IllegalArgumentException(c0146d + " not a valid level value");
        }
    }

    /* renamed from: b */
    public static C0146d m21479b(int i) {
        switch (i) {
            case 0:
                return f206t;
            case 10:
                return f205s;
            case 20:
                return f204r;
            case 30:
                return f203q;
            case 40:
                return f202p;
            default:
                throw new IllegalArgumentException(i + " not a valid level value");
        }
    }

    /* renamed from: b */
    public static C0146d m21477b(String str) {
        return m21481a(str, f205s);
    }

    private Object readResolve() {
        return m21485a(this.f208v);
    }

    /* renamed from: a */
    public int m21486a() {
        return this.f208v;
    }

    /* renamed from: a */
    public boolean m21483a(C0146d c0146d) {
        return this.f208v >= c0146d.f208v;
    }

    /* renamed from: b */
    public Integer m21480b() {
        switch (this.f208v) {
            case Integer.MIN_VALUE:
                return f200n;
            case 5000:
                return f199m;
            case 10000:
                return f198l;
            case 20000:
                return f197k;
            case 30000:
                return f196j;
            case f188b /* 40000 */:
                return f195i;
            case Integer.MAX_VALUE:
                return f194h;
            default:
                throw new IllegalStateException("Level " + this.f209w + ", " + this.f208v + " is unknown.");
        }
    }

    public String toString() {
        return this.f209w;
    }
}
