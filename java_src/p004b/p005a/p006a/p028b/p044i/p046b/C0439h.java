package p004b.p005a.p006a.p028b.p044i.p046b;
/* renamed from: b.a.a.b.i.b.h */
/* loaded from: classes.dex */
class C0439h {

    /* renamed from: a */
    static final int f962a = 37;

    /* renamed from: b */
    static final int f963b = 41;

    /* renamed from: c */
    static final int f964c = 45;

    /* renamed from: d */
    static final int f965d = 46;

    /* renamed from: e */
    static final int f966e = 123;

    /* renamed from: f */
    static final int f967f = 125;

    /* renamed from: g */
    static final int f968g = 1000;

    /* renamed from: h */
    static final int f969h = 1002;

    /* renamed from: i */
    static final int f970i = 1004;

    /* renamed from: k */
    static final int f972k = 1006;

    /* renamed from: l */
    static final int f973l = Integer.MAX_VALUE;

    /* renamed from: q */
    private final int f978q;

    /* renamed from: r */
    private final Object f979r;

    /* renamed from: m */
    static C0439h f974m = new C0439h(Integer.MAX_VALUE, "EOF");

    /* renamed from: n */
    static C0439h f975n = new C0439h(41);

    /* renamed from: j */
    static final int f971j = 1005;

    /* renamed from: o */
    static C0439h f976o = new C0439h(f971j, "BARE");

    /* renamed from: p */
    static C0439h f977p = new C0439h(37);

    public C0439h(int i) {
        this(i, null);
    }

    public C0439h(int i, Object obj) {
        this.f978q = i;
        this.f979r = obj;
    }

    /* renamed from: a */
    public int m20510a() {
        return this.f978q;
    }

    /* renamed from: b */
    public Object m20509b() {
        return this.f979r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0439h)) {
            return false;
        }
        C0439h c0439h = (C0439h) obj;
        if (this.f978q != c0439h.f978q) {
            return false;
        }
        if (this.f979r != null) {
            if (this.f979r.equals(c0439h.f979r)) {
                return true;
            }
        } else if (c0439h.f979r == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f979r != null ? this.f979r.hashCode() : 0) + (this.f978q * 29);
    }

    public String toString() {
        String str;
        switch (this.f978q) {
            case 37:
                str = "%";
                break;
            case 41:
                str = "RIGHT_PARENTHESIS";
                break;
            case 1000:
                str = "LITERAL";
                break;
            case 1002:
                str = "FormatModifier";
                break;
            case 1004:
                str = "SIMPLE_KEYWORD";
                break;
            case f971j /* 1005 */:
                str = "COMPOSITE_KEYWORD";
                break;
            case f972k /* 1006 */:
                str = "OPTION";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return this.f979r == null ? "Token(" + str + ")" : "Token(" + str + ", \"" + this.f979r + "\")";
    }
}
