package com.p118d.p119a.p127b.p128a;
/* renamed from: com.d.a.b.a.b */
/* loaded from: classes.dex */
public class C1889b {

    /* renamed from: a */
    private final EnumC1890a f6654a;

    /* renamed from: b */
    private final Throwable f6655b;

    /* renamed from: com.d.a.b.a.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1890a {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public C1889b(EnumC1890a enumC1890a, Throwable th) {
        this.f6654a = enumC1890a;
        this.f6655b = th;
    }

    /* renamed from: a */
    public EnumC1890a m14155a() {
        return this.f6654a;
    }

    /* renamed from: b */
    public Throwable m14154b() {
        return this.f6655b;
    }
}
