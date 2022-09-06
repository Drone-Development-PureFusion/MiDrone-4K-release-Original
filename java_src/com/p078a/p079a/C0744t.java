package com.p078a.p079a;

import java.math.BigInteger;
/* renamed from: com.a.a.t */
/* loaded from: classes.dex */
public final class C0744t {

    /* renamed from: a */
    public static final C0744t f1852a = new C0744t(0);

    /* renamed from: b */
    private static final int f1853b = 1;

    /* renamed from: c */
    private static final int f1854c = 65280;

    /* renamed from: d */
    private static final int f1855d = 8;

    /* renamed from: e */
    private static final int f1856e = 2;

    /* renamed from: f */
    private static final int f1857f = 16711680;

    /* renamed from: g */
    private static final int f1858g = 16;

    /* renamed from: h */
    private static final int f1859h = 3;

    /* renamed from: i */
    private static final long f1860i = 4278190080L;

    /* renamed from: j */
    private static final int f1861j = 24;

    /* renamed from: k */
    private static final int f1862k = 4;

    /* renamed from: l */
    private static final long f1863l = 1095216660480L;

    /* renamed from: m */
    private static final int f1864m = 32;

    /* renamed from: n */
    private static final int f1865n = 5;

    /* renamed from: o */
    private static final long f1866o = 280375465082880L;

    /* renamed from: p */
    private static final int f1867p = 40;

    /* renamed from: q */
    private static final int f1868q = 6;

    /* renamed from: r */
    private static final long f1869r = 71776119061217280L;

    /* renamed from: s */
    private static final int f1870s = 48;

    /* renamed from: t */
    private static final int f1871t = 7;

    /* renamed from: u */
    private static final long f1872u = 9151314442816847872L;

    /* renamed from: v */
    private static final int f1873v = 56;

    /* renamed from: w */
    private static final int f1874w = 63;

    /* renamed from: x */
    private static final byte f1875x = Byte.MIN_VALUE;

    /* renamed from: y */
    private final BigInteger f1876y;

    public C0744t(long j) {
        this(BigInteger.valueOf(j));
    }

    public C0744t(BigInteger bigInteger) {
        this.f1876y = bigInteger;
    }

    public C0744t(byte[] bArr) {
        this(bArr, 0);
    }

    public C0744t(byte[] bArr, int i) {
        this.f1876y = m19204b(bArr, i);
    }

    /* renamed from: a */
    public static long m19208a(byte[] bArr) {
        return m19207a(bArr, 0);
    }

    /* renamed from: a */
    public static long m19207a(byte[] bArr, int i) {
        return m19204b(bArr, i).longValue();
    }

    /* renamed from: a */
    public static byte[] m19210a(long j) {
        return m19209a(BigInteger.valueOf(j));
    }

    /* renamed from: a */
    public static byte[] m19209a(BigInteger bigInteger) {
        long longValue = bigInteger.longValue();
        byte[] bArr = {(byte) (255 & longValue), (byte) ((65280 & longValue) >> 8), (byte) ((16711680 & longValue) >> 16), (byte) ((f1860i & longValue) >> 24), (byte) ((f1863l & longValue) >> 32), (byte) ((f1866o & longValue) >> 40), (byte) ((f1869r & longValue) >> 48), (byte) ((longValue & f1872u) >> 56)};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | f1875x);
        }
        return bArr;
    }

    /* renamed from: b */
    public static BigInteger m19205b(byte[] bArr) {
        return m19204b(bArr, 0);
    }

    /* renamed from: b */
    public static BigInteger m19204b(byte[] bArr, int i) {
        BigInteger valueOf = BigInteger.valueOf(((bArr[i + 7] << 56) & f1872u) + ((bArr[i + 6] << 48) & f1869r) + ((bArr[i + 5] << 40) & f1866o) + ((bArr[i + 4] << 32) & f1863l) + ((bArr[i + 3] << 24) & f1860i) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255));
        return (bArr[i + 7] & f1875x) == -128 ? valueOf.setBit(63) : valueOf;
    }

    /* renamed from: a */
    public byte[] m19211a() {
        return m19209a(this.f1876y);
    }

    /* renamed from: b */
    public long m19206b() {
        return this.f1876y.longValue();
    }

    /* renamed from: c */
    public BigInteger m19203c() {
        return this.f1876y;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0744t)) {
            return false;
        }
        return this.f1876y.equals(((C0744t) obj).m19203c());
    }

    public int hashCode() {
        return this.f1876y.hashCode();
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.f1876y;
    }
}
