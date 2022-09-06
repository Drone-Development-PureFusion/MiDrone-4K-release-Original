package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.p248a.p249a.p252c.p253a.C5018b;
@AbstractC1017fv(m17950a = "a")
/* renamed from: com.amap.api.mapcore.util.fh */
/* loaded from: classes.dex */
public class C0996fh {
    @AbstractC1018fw(m17948a = "a1", m17947b = 6)

    /* renamed from: a */
    private String f3132a;
    @AbstractC1018fw(m17948a = "a2", m17947b = 6)

    /* renamed from: b */
    private String f3133b;
    @AbstractC1018fw(m17948a = "a6", m17947b = 2)

    /* renamed from: c */
    private int f3134c;
    @AbstractC1018fw(m17948a = "a3", m17947b = 6)

    /* renamed from: d */
    private String f3135d;
    @AbstractC1018fw(m17948a = "a4", m17947b = 6)

    /* renamed from: e */
    private String f3136e;
    @AbstractC1018fw(m17948a = "a5", m17947b = 6)

    /* renamed from: f */
    private String f3137f;

    /* renamed from: g */
    private String f3138g;

    /* renamed from: h */
    private String f3139h;

    /* renamed from: i */
    private String f3140i;

    /* renamed from: j */
    private String f3141j;

    /* renamed from: k */
    private String f3142k;

    /* renamed from: l */
    private String[] f3143l;

    /* renamed from: com.amap.api.mapcore.util.fh$a */
    /* loaded from: classes.dex */
    public static class C0998a {

        /* renamed from: a */
        private String f3144a;

        /* renamed from: b */
        private String f3145b;

        /* renamed from: c */
        private String f3146c;

        /* renamed from: d */
        private String f3147d;

        /* renamed from: e */
        private boolean f3148e = true;

        /* renamed from: f */
        private String f3149f = C5018b.f21482c;

        /* renamed from: g */
        private String[] f3150g = null;

        public C0998a(String str, String str2, String str3) {
            this.f3144a = str2;
            this.f3145b = str2;
            this.f3147d = str3;
            this.f3146c = str;
        }

        /* renamed from: a */
        public C0998a m18061a(String str) {
            this.f3145b = str;
            return this;
        }

        /* renamed from: a */
        public C0998a m18060a(String[] strArr) {
            this.f3150g = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C0996fh m18063a() {
            if (this.f3150g == null) {
                throw new C0975ex("sdk packages is null");
            }
            return new C0996fh(this);
        }
    }

    private C0996fh() {
        this.f3134c = 1;
        this.f3143l = null;
    }

    private C0996fh(C0998a c0998a) {
        int i = 1;
        this.f3134c = 1;
        this.f3143l = null;
        this.f3138g = c0998a.f3144a;
        this.f3139h = c0998a.f3145b;
        this.f3141j = c0998a.f3146c;
        this.f3140i = c0998a.f3147d;
        this.f3134c = !c0998a.f3148e ? 0 : i;
        this.f3142k = c0998a.f3149f;
        this.f3143l = c0998a.f3150g;
        this.f3133b = C0999fi.m18042b(this.f3139h);
        this.f3132a = C0999fi.m18042b(this.f3141j);
        this.f3135d = C0999fi.m18042b(this.f3140i);
        this.f3136e = C0999fi.m18042b(m18071a(this.f3143l));
        this.f3137f = C0999fi.m18042b(this.f3142k);
    }

    /* renamed from: a */
    public static String m18073a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", C0999fi.m18042b(str));
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private String m18071a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str).append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private String[] m18069b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public static String m18064g() {
        return "a6=1";
    }

    /* renamed from: a */
    public String m18074a() {
        if (TextUtils.isEmpty(this.f3141j) && !TextUtils.isEmpty(this.f3132a)) {
            this.f3141j = C0999fi.m18040c(this.f3132a);
        }
        return this.f3141j;
    }

    /* renamed from: a */
    public void m18072a(boolean z) {
        this.f3134c = z ? 1 : 0;
    }

    /* renamed from: b */
    public String m18070b() {
        return this.f3138g;
    }

    /* renamed from: c */
    public String m18068c() {
        if (TextUtils.isEmpty(this.f3139h) && !TextUtils.isEmpty(this.f3133b)) {
            this.f3139h = C0999fi.m18040c(this.f3133b);
        }
        return this.f3139h;
    }

    /* renamed from: d */
    public String m18067d() {
        if (TextUtils.isEmpty(this.f3140i) && !TextUtils.isEmpty(this.f3135d)) {
            this.f3140i = C0999fi.m18040c(this.f3135d);
        }
        return this.f3140i;
    }

    /* renamed from: e */
    public String m18066e() {
        if (TextUtils.isEmpty(this.f3142k) && !TextUtils.isEmpty(this.f3137f)) {
            this.f3142k = C0999fi.m18040c(this.f3137f);
        }
        if (TextUtils.isEmpty(this.f3142k)) {
            this.f3142k = C5018b.f21482c;
        }
        return this.f3142k;
    }

    /* renamed from: f */
    public String[] m18065f() {
        if ((this.f3143l == null || this.f3143l.length == 0) && !TextUtils.isEmpty(this.f3136e)) {
            this.f3143l = m18069b(C0999fi.m18040c(this.f3136e));
        }
        return (String[]) this.f3143l.clone();
    }
}
