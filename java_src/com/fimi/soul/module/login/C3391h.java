package com.fimi.soul.module.login;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.module.login.h */
/* loaded from: classes.dex */
public class C3391h implements Serializable {

    /* renamed from: a */
    public static final String f13231a = "https://fimiservice-newus.mi-ae.com/";

    /* renamed from: b */
    public static final String f13232b = "https://paas-frankfurt.fimi.com/fimi-cms-web-interface/";

    /* renamed from: c */
    public static final String f13233c = "https://paas-singapore.fimi.com/fimi-cms-web-interface/";

    /* renamed from: d */
    public static final String f13234d = "https://paas-beijing6.fimi.com/";

    /* renamed from: e */
    public static final String f13235e = "https://paas-moscow.fimi.com/fimi-cms-web-interface/";

    /* renamed from: f */
    private int f13236f;

    /* renamed from: g */
    private int f13237g;

    /* renamed from: h */
    private boolean f13238h;

    /* renamed from: i */
    private String f13239i;

    /* renamed from: j */
    private String f13240j;

    /* renamed from: a */
    public String m8514a() {
        return this.f13240j;
    }

    /* renamed from: a */
    public void m8513a(int i) {
        this.f13236f = i;
    }

    /* renamed from: a */
    public void m8512a(String str) {
        this.f13240j = str;
    }

    /* renamed from: a */
    public void m8511a(boolean z) {
        this.f13238h = z;
    }

    /* renamed from: b */
    public String m8510b() {
        return this.f13239i;
    }

    /* renamed from: b */
    public void m8509b(int i) {
        this.f13237g = i;
    }

    /* renamed from: b */
    public void m8508b(String str) {
        this.f13239i = str;
    }

    /* renamed from: c */
    public int m8507c() {
        return this.f13236f;
    }

    /* renamed from: d */
    public int m8506d() {
        return this.f13237g;
    }

    /* renamed from: e */
    public boolean m8505e() {
        return this.f13238h;
    }

    public String toString() {
        return "ServiceItem{info=" + this.f13236f + ", code=" + this.f13237g + ", isSelect=" + this.f13238h + ", serviceUrl='" + this.f13239i + C0359h.f729z + ", countryCode='" + this.f13240j + C0359h.f729z + C0359h.f726w;
    }
}
