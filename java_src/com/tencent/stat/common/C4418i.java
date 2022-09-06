package com.tencent.stat.common;

import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.tencent.stat.common.i */
/* loaded from: classes2.dex */
class C4418i extends AbstractC4417h {

    /* renamed from: c */
    private static final int[] f18441c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: d */
    private static final int[] f18442d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: e */
    private int f18443e;

    /* renamed from: f */
    private int f18444f;

    /* renamed from: g */
    private final int[] f18445g;

    public C4418i(int i, byte[] bArr) {
        this.f18439a = bArr;
        this.f18445g = (i & 8) == 0 ? f18441c : f18442d;
        this.f18443e = 0;
        this.f18444f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r14 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        r10.f18443e = r3;
        r10.f18444f = r2;
        r10.f18440b = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0105, code lost:
        switch(r3) {
            case 0: goto L21;
            case 1: goto L23;
            case 2: goto L25;
            case 3: goto L26;
            case 4: goto L27;
            default: goto L21;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0108, code lost:
        r10.f18443e = r3;
        r10.f18440b = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x010f, code lost:
        r10.f18443e = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0115, code lost:
        r5[r0] = (byte) (r2 >> 4);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x011e, code lost:
        r1 = r0 + 1;
        r5[r0] = (byte) (r2 >> 10);
        r0 = r1 + 1;
        r5[r1] = (byte) (r2 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x012d, code lost:
        r10.f18443e = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m5214a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (this.f18443e == 6) {
            return false;
        }
        int i5 = i2 + i;
        int i6 = this.f18443e;
        int i7 = this.f18444f;
        int i8 = 0;
        byte[] bArr2 = this.f18439a;
        int[] iArr = this.f18445g;
        int i9 = i;
        while (true) {
            if (i9 < i5) {
                if (i6 == 0) {
                    while (i9 + 4 <= i5 && (i7 = (iArr[bArr[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] << 18) | (iArr[bArr[i9 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] << 12) | (iArr[bArr[i9 + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT] << 6) | iArr[bArr[i9 + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT]) >= 0) {
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i9 += 4;
                    }
                    if (i9 >= i5) {
                        i3 = i7;
                    }
                }
                int i10 = i9 + 1;
                int i11 = iArr[bArr[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT];
                switch (i6) {
                    case 0:
                        if (i11 >= 0) {
                            i4 = i6 + 1;
                            i7 = i11;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        break;
                    case 1:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            i4 = i6 + 1;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        break;
                    case 2:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            i4 = i6 + 1;
                            continue;
                        } else if (i11 == -2) {
                            bArr2[i8] = (byte) (i7 >> 4);
                            i4 = 4;
                            i8++;
                        } else if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        i6 = i4;
                        i9 = i10;
                        break;
                    case 3:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            bArr2[i8 + 2] = (byte) i7;
                            bArr2[i8 + 1] = (byte) (i7 >> 8);
                            bArr2[i8] = (byte) (i7 >> 16);
                            i8 += 3;
                            i4 = 0;
                            continue;
                        } else if (i11 == -2) {
                            bArr2[i8 + 1] = (byte) (i7 >> 2);
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 += 2;
                            i4 = 5;
                        } else if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        i6 = i4;
                        i9 = i10;
                        break;
                    case 4:
                        if (i11 == -2) {
                            i4 = i6 + 1;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        break;
                    case 5:
                        if (i11 != -1) {
                            this.f18443e = 6;
                            return false;
                        }
                        break;
                }
                i4 = i6;
                i6 = i4;
                i9 = i10;
            } else {
                i3 = i7;
            }
        }
    }
}
