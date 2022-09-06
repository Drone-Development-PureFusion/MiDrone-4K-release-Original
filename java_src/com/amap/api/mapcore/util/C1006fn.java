package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.fn */
/* loaded from: classes.dex */
public class C1006fn extends AbstractC1075hd {

    /* renamed from: a */
    private byte[] f3172a;

    /* renamed from: b */
    private String f3173b;

    public C1006fn(byte[] bArr) {
        this.f3173b = "1";
        this.f3172a = (byte[]) bArr.clone();
    }

    public C1006fn(byte[] bArr, String str) {
        this.f3173b = "1";
        this.f3172a = (byte[]) bArr.clone();
        this.f3173b = str;
    }

    /* renamed from: d */
    private String m18019d() {
        byte[] m18047a = C0999fi.m18047a(C1001fk.f3155a);
        byte[] bArr = new byte[m18047a.length + 50];
        System.arraycopy(this.f3172a, 0, bArr, 0, 50);
        System.arraycopy(m18047a, 0, bArr, 50, m18047a.length);
        return C0992fe.m18094a(bArr);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: a */
    public Map<String, String> mo17702a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f3172a.length));
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: b */
    public Map<String, String> mo17699b() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: c */
    public String mo17697c() {
        return String.format(C1001fk.f3156b, "1", this.f3173b, "1", "open", m18019d());
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: g */
    public byte[] mo17696g() {
        return this.f3172a;
    }
}
