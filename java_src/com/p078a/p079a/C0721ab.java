package com.p078a.p079a;

import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.a.a.ab */
/* loaded from: classes.dex */
public final class C0721ab implements Cloneable {

    /* renamed from: a */
    private static final int f1769a = 65280;

    /* renamed from: b */
    private static final int f1770b = 8;

    /* renamed from: c */
    private final int f1771c;

    public C0721ab(int i) {
        this.f1771c = i;
    }

    public C0721ab(byte[] bArr) {
        this(bArr, 0);
    }

    public C0721ab(byte[] bArr, int i) {
        this.f1771c = m19278a(bArr, i);
    }

    /* renamed from: a */
    public static int m19279a(byte[] bArr) {
        return m19278a(bArr, 0);
    }

    /* renamed from: a */
    public static int m19278a(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & 65280) + (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: a */
    public static byte[] m19280a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8)};
    }

    /* renamed from: a */
    public byte[] m19281a() {
        return new byte[]{(byte) (this.f1771c & 255), (byte) ((this.f1771c & 65280) >> 8)};
    }

    /* renamed from: b */
    public int m19277b() {
        return this.f1771c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C0721ab) && this.f1771c == ((C0721ab) obj).m19277b();
    }

    public int hashCode() {
        return this.f1771c;
    }

    public String toString() {
        return "ZipShort value: " + this.f1771c;
    }
}
