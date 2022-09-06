package com.amap.api.services.core;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
/* renamed from: com.amap.api.services.core.bh */
/* loaded from: classes.dex */
public class C1208bh extends AbstractC1227bt {

    /* renamed from: a */
    private byte[] f4090a;

    public C1208bh(byte[] bArr) {
        this.f4090a = (byte[]) bArr.clone();
    }

    /* renamed from: f */
    private String m17149f() {
        byte[] bytes = C1185au.f4042a.getBytes();
        byte[] bArr = new byte[bytes.length + 50];
        System.arraycopy(this.f4090a, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return C1164ab.m17276a(bArr);
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return String.format(C1185au.f4043b, "1", "1", "1", "open", m17149f());
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: c_ */
    public Map<String, String> mo16937c_() {
        return null;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: d_ */
    public Map<String, String> mo16935d_() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f4090a.length));
        return hashMap;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: e */
    public HttpEntity mo16934e() {
        return null;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: e_ */
    public byte[] mo17042e_() {
        return this.f4090a;
    }
}
