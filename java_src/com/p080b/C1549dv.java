package com.p080b;

import org.p248a.p249a.p252c.p253a.C5018b;
/* renamed from: com.b.dv */
/* loaded from: classes.dex */
public class C1549dv {

    /* renamed from: a */
    String f5527a;

    /* renamed from: b */
    String f5528b;

    /* renamed from: c */
    String f5529c;

    /* renamed from: d */
    private boolean f5530d;

    /* renamed from: e */
    private String f5531e;

    /* renamed from: f */
    private String[] f5532f;

    /* renamed from: com.b.dv$a */
    /* loaded from: classes.dex */
    public static class C1550a {

        /* renamed from: a */
        private String f5533a;

        /* renamed from: b */
        private String f5534b;

        /* renamed from: c */
        private String f5535c;

        /* renamed from: d */
        private boolean f5536d = true;

        /* renamed from: e */
        private String f5537e = C5018b.f21482c;

        /* renamed from: f */
        private String[] f5538f = null;

        public C1550a(String str, String str2, String str3) {
            this.f5533a = str2;
            this.f5535c = str3;
            this.f5534b = str;
        }

        /* renamed from: a */
        public C1550a m15571a(String str) {
            this.f5537e = str;
            return this;
        }

        /* renamed from: a */
        public C1550a m15570a(boolean z) {
            this.f5536d = z;
            return this;
        }

        /* renamed from: a */
        public C1550a m15569a(String[] strArr) {
            this.f5538f = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C1549dv m15573a() {
            if (this.f5538f == null) {
                throw new C1532dl("sdk packages is null");
            }
            return new C1549dv(this);
        }
    }

    private C1549dv(C1550a c1550a) {
        this.f5530d = true;
        this.f5531e = C5018b.f21482c;
        this.f5532f = null;
        this.f5527a = c1550a.f5533a;
        this.f5529c = c1550a.f5534b;
        this.f5528b = c1550a.f5535c;
        this.f5530d = c1550a.f5536d;
        this.f5531e = c1550a.f5537e;
        this.f5532f = c1550a.f5538f;
    }

    /* renamed from: a */
    public String m15580a() {
        return this.f5529c;
    }

    /* renamed from: a */
    public void m15579a(boolean z) {
        this.f5530d = z;
    }

    /* renamed from: b */
    public String m15578b() {
        return this.f5527a;
    }

    /* renamed from: c */
    public String m15577c() {
        return this.f5528b;
    }

    /* renamed from: d */
    public String m15576d() {
        return this.f5531e;
    }

    /* renamed from: e */
    public boolean m15575e() {
        return this.f5530d;
    }

    /* renamed from: f */
    public String[] m15574f() {
        return (String[]) this.f5532f.clone();
    }
}
