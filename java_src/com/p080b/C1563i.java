package com.p080b;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.b.i */
/* loaded from: classes.dex */
public class C1563i extends AbstractC1428aq {

    /* renamed from: d */
    private byte[] f5565d;

    public C1563i(byte[] bArr) {
        this.f5565d = (byte[]) bArr.clone();
    }

    /* renamed from: g */
    private String m15501g() {
        byte[] bytes;
        try {
            bytes = C1554dy.f5542a.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = C1554dy.f5542a.getBytes();
        }
        byte[] bArr = new byte[bytes.length + 50];
        System.arraycopy(this.f5565d, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return C1545ds.m15598a(bArr);
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: a */
    public Map<String, String> mo15505a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f5565d.length));
        return hashMap;
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: b */
    public Map<String, String> mo15504b() {
        return null;
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: c */
    public String mo15503c() {
        return String.format(C1554dy.f5543b, "1", "1", "1", "open", m15501g());
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: d */
    public byte[] mo15502d() {
        return this.f5565d;
    }
}
