package com.amap.api.services.core;

import org.p248a.p249a.p252c.p253a.C5018b;
/* renamed from: com.amap.api.services.core.ad */
/* loaded from: classes.dex */
public class C1166ad {

    /* renamed from: a */
    String f3980a;

    /* renamed from: b */
    String f3981b;

    /* renamed from: c */
    String f3982c;

    /* renamed from: d */
    private boolean f3983d;

    /* renamed from: e */
    private String f3984e;

    /* renamed from: f */
    private String[] f3985f;

    /* renamed from: com.amap.api.services.core.ad$a */
    /* loaded from: classes.dex */
    public static class C1168a {

        /* renamed from: a */
        private String f3986a;

        /* renamed from: b */
        private String f3987b;

        /* renamed from: c */
        private String f3988c;

        /* renamed from: d */
        private boolean f3989d = true;

        /* renamed from: e */
        private String f3990e = C5018b.f21482c;

        /* renamed from: f */
        private String[] f3991f = null;

        public C1168a(String str, String str2, String str3) {
            this.f3986a = str2;
            this.f3988c = str3;
            this.f3987b = str;
        }

        /* renamed from: a */
        public C1168a m17256a(String str) {
            this.f3990e = str;
            return this;
        }

        /* renamed from: a */
        public C1168a m17255a(boolean z) {
            this.f3989d = z;
            return this;
        }

        /* renamed from: a */
        public C1168a m17254a(String[] strArr) {
            this.f3991f = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C1166ad m17258a() {
            if (this.f3991f == null) {
                throw new C1258v("sdk packages is null");
            }
            return new C1166ad(this);
        }
    }

    private C1166ad(C1168a c1168a) {
        this.f3983d = true;
        this.f3984e = C5018b.f21482c;
        this.f3985f = null;
        this.f3980a = c1168a.f3986a;
        this.f3982c = c1168a.f3987b;
        this.f3981b = c1168a.f3988c;
        this.f3983d = c1168a.f3989d;
        this.f3984e = c1168a.f3990e;
        this.f3985f = c1168a.f3991f;
    }

    /* renamed from: a */
    public String m17264a() {
        return this.f3982c;
    }

    /* renamed from: b */
    public String m17263b() {
        return this.f3980a;
    }

    /* renamed from: c */
    public String m17262c() {
        return this.f3981b;
    }

    /* renamed from: d */
    public String m17261d() {
        return this.f3984e;
    }

    /* renamed from: e */
    public boolean m17260e() {
        return this.f3983d;
    }

    /* renamed from: f */
    public String[] m17259f() {
        return (String[]) this.f3985f.clone();
    }
}
