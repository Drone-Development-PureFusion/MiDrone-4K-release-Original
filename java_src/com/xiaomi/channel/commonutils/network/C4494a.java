package com.xiaomi.channel.commonutils.network;
/* renamed from: com.xiaomi.channel.commonutils.network.a */
/* loaded from: classes.dex */
public class C4494a implements AbstractC4496c {

    /* renamed from: a */
    private final String f18568a;

    /* renamed from: b */
    private final String f18569b;

    public C4494a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f18568a = str;
        this.f18569b = str2;
    }

    @Override // com.xiaomi.channel.commonutils.network.AbstractC4496c
    /* renamed from: a */
    public String mo5002a() {
        return this.f18568a;
    }

    @Override // com.xiaomi.channel.commonutils.network.AbstractC4496c
    /* renamed from: b */
    public String mo5001b() {
        return this.f18569b;
    }
}
