package com.p078a.p079a;

import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.a.a.z */
/* loaded from: classes.dex */
public final class C0756z implements Cloneable {

    /* renamed from: a */
    public static final C0756z f1939a = new C0756z(33639248);

    /* renamed from: b */
    public static final C0756z f1940b = new C0756z(67324752);

    /* renamed from: c */
    public static final C0756z f1941c = new C0756z(134695760);

    /* renamed from: d */
    static final C0756z f1942d = new C0756z(4294967295L);

    /* renamed from: e */
    private static final int f1943e = 1;

    /* renamed from: f */
    private static final int f1944f = 65280;

    /* renamed from: g */
    private static final int f1945g = 8;

    /* renamed from: h */
    private static final int f1946h = 2;

    /* renamed from: i */
    private static final int f1947i = 16711680;

    /* renamed from: j */
    private static final int f1948j = 16;

    /* renamed from: k */
    private static final int f1949k = 3;

    /* renamed from: l */
    private static final long f1950l = 4278190080L;

    /* renamed from: m */
    private static final int f1951m = 24;

    /* renamed from: n */
    private final long f1952n;

    public C0756z(long j) {
        this.f1952n = j;
    }

    public C0756z(byte[] bArr) {
        this(bArr, 0);
    }

    public C0756z(byte[] bArr, int i) {
        this.f1952n = m19127a(bArr, i);
    }

    /* renamed from: a */
    public static long m19128a(byte[] bArr) {
        return m19127a(bArr, 0);
    }

    /* renamed from: a */
    public static long m19127a(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & f1950l) + ((bArr[i + 2] << 16) & f1947i) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: a */
    public static byte[] m19129a(long j) {
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((f1950l & j) >> 24)};
    }

    /* renamed from: a */
    public byte[] m19130a() {
        return m19129a(this.f1952n);
    }

    /* renamed from: b */
    public long m19126b() {
        return this.f1952n;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C0756z) && this.f1952n == ((C0756z) obj).m19126b();
    }

    public int hashCode() {
        return (int) this.f1952n;
    }

    public String toString() {
        return "ZipLong value: " + this.f1952n;
    }
}
