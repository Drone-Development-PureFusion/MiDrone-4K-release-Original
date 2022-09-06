package com.android.volley;

import java.util.Collections;
import java.util.Map;
/* renamed from: com.android.volley.b */
/* loaded from: classes.dex */
public interface AbstractC1317b {

    /* renamed from: com.android.volley.b$a */
    /* loaded from: classes.dex */
    public static class C1318a {

        /* renamed from: a */
        public byte[] f4530a;

        /* renamed from: b */
        public String f4531b;

        /* renamed from: c */
        public long f4532c;

        /* renamed from: d */
        public long f4533d;

        /* renamed from: e */
        public long f4534e;

        /* renamed from: f */
        public long f4535f;

        /* renamed from: g */
        public Map<String, String> f4536g = Collections.emptyMap();

        /* renamed from: a */
        public boolean m16748a() {
            return this.f4534e < System.currentTimeMillis();
        }

        /* renamed from: b */
        public boolean m16747b() {
            return this.f4535f < System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    C1318a mo16585a(String str);

    /* renamed from: a */
    void mo16586a();

    /* renamed from: a */
    void mo16584a(String str, C1318a c1318a);

    /* renamed from: a */
    void mo16583a(String str, boolean z);

    /* renamed from: b */
    void mo16582b();

    /* renamed from: b */
    void mo16581b(String str);
}
