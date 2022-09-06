package com.amap.api.services.core;

import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
/* renamed from: com.amap.api.services.core.bt */
/* loaded from: classes.dex */
public abstract class AbstractC1227bt {

    /* renamed from: e */
    int f4148e = 20000;

    /* renamed from: f */
    int f4149f = 20000;

    /* renamed from: g */
    HttpHost f4150g = null;

    /* renamed from: a */
    public final void m17045a(HttpHost httpHost) {
        this.f4150g = httpHost;
    }

    /* renamed from: b */
    public abstract String mo16813b();

    /* renamed from: c */
    public final void m17044c(int i) {
        this.f4148e = i;
    }

    /* renamed from: c_ */
    public abstract Map<String, String> mo16937c_();

    /* renamed from: d */
    public final void m17043d(int i) {
        this.f4149f = i;
    }

    /* renamed from: d_ */
    public abstract Map<String, String> mo16935d_();

    /* renamed from: e */
    public abstract HttpEntity mo16934e();

    /* renamed from: e_ */
    public byte[] mo17042e_() {
        return null;
    }
}
