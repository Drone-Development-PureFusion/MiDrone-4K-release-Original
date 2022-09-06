package com.android.volley;

import com.android.volley.AbstractC1317b;
/* renamed from: com.android.volley.p */
/* loaded from: classes.dex */
public class C1341p<T> {

    /* renamed from: a */
    public final T f4618a;

    /* renamed from: b */
    public final AbstractC1317b.C1318a f4619b;

    /* renamed from: c */
    public final C1384u f4620c;

    /* renamed from: d */
    public boolean f4621d;

    /* renamed from: com.android.volley.p$a */
    /* loaded from: classes.dex */
    public interface AbstractC1342a {
        /* renamed from: a */
        void mo7531a(C1384u c1384u);
    }

    /* renamed from: com.android.volley.p$b */
    /* loaded from: classes.dex */
    public interface AbstractC1343b<T> {
        /* renamed from: a */
        void mo13137a(T t);
    }

    private C1341p(C1384u c1384u) {
        this.f4621d = false;
        this.f4618a = null;
        this.f4619b = null;
        this.f4620c = c1384u;
    }

    private C1341p(T t, AbstractC1317b.C1318a c1318a) {
        this.f4621d = false;
        this.f4618a = t;
        this.f4619b = c1318a;
        this.f4620c = null;
    }

    /* renamed from: a */
    public static <T> C1341p<T> m16688a(C1384u c1384u) {
        return new C1341p<>(c1384u);
    }

    /* renamed from: a */
    public static <T> C1341p<T> m16687a(T t, AbstractC1317b.C1318a c1318a) {
        return new C1341p<>(t, c1318a);
    }

    /* renamed from: a */
    public boolean m16689a() {
        return this.f4620c == null;
    }
}
