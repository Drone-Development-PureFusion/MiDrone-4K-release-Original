package com.amap.api.mapcore.util;

import com.tencent.open.GameAppOperation;
import java.util.HashMap;
import java.util.Map;
@AbstractC1017fv(m17950a = "file")
/* renamed from: com.amap.api.mapcore.util.gr */
/* loaded from: classes.dex */
public class C1043gr {
    @AbstractC1018fw(m17948a = "fname", m17947b = 6)

    /* renamed from: a */
    private String f3254a;
    @AbstractC1018fw(m17948a = "md", m17947b = 6)

    /* renamed from: b */
    private String f3255b;
    @AbstractC1018fw(m17948a = "sname", m17947b = 6)

    /* renamed from: c */
    private String f3256c;
    @AbstractC1018fw(m17948a = GameAppOperation.QQFAV_DATALINE_VERSION, m17947b = 6)

    /* renamed from: d */
    private String f3257d;
    @AbstractC1018fw(m17948a = "dversion", m17947b = 6)

    /* renamed from: e */
    private String f3258e;
    @AbstractC1018fw(m17948a = "status", m17947b = 6)

    /* renamed from: f */
    private String f3259f;

    /* renamed from: com.amap.api.mapcore.util.gr$a */
    /* loaded from: classes.dex */
    public static class C1044a {

        /* renamed from: a */
        private String f3260a;

        /* renamed from: b */
        private String f3261b;

        /* renamed from: c */
        private String f3262c;

        /* renamed from: d */
        private String f3263d;

        /* renamed from: e */
        private String f3264e;

        /* renamed from: f */
        private String f3265f = "copy";

        public C1044a(String str, String str2, String str3, String str4, String str5) {
            this.f3260a = str;
            this.f3261b = str2;
            this.f3262c = str3;
            this.f3263d = str4;
            this.f3264e = str5;
        }

        /* renamed from: a */
        public C1044a m17842a(String str) {
            this.f3265f = str;
            return this;
        }

        /* renamed from: a */
        public C1043gr m17844a() {
            return new C1043gr(this);
        }
    }

    private C1043gr() {
    }

    public C1043gr(C1044a c1044a) {
        this.f3254a = c1044a.f3260a;
        this.f3255b = c1044a.f3261b;
        this.f3256c = c1044a.f3262c;
        this.f3257d = c1044a.f3263d;
        this.f3258e = c1044a.f3264e;
        this.f3259f = c1044a.f3265f;
    }

    /* renamed from: a */
    public static String m17855a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m17854a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m17853a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, str3);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m17851b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m17850b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("status", str2);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public String m17856a() {
        return this.f3254a;
    }

    /* renamed from: b */
    public String m17852b() {
        return this.f3255b;
    }

    /* renamed from: c */
    public String m17849c() {
        return this.f3256c;
    }

    /* renamed from: c */
    public void m17848c(String str) {
        this.f3259f = str;
    }

    /* renamed from: d */
    public String m17847d() {
        return this.f3257d;
    }

    /* renamed from: e */
    public String m17846e() {
        return this.f3258e;
    }

    /* renamed from: f */
    public String m17845f() {
        return this.f3259f;
    }
}
