package com.tencent.stat.common;

import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.tencent.stat.common.j */
/* loaded from: classes2.dex */
class C4419j extends AbstractC4417h {

    /* renamed from: g */
    static final /* synthetic */ boolean f18446g;

    /* renamed from: h */
    private static final byte[] f18447h;

    /* renamed from: i */
    private static final byte[] f18448i;

    /* renamed from: c */
    int f18449c;

    /* renamed from: d */
    public final boolean f18450d;

    /* renamed from: e */
    public final boolean f18451e;

    /* renamed from: f */
    public final boolean f18452f;

    /* renamed from: j */
    private final byte[] f18453j;

    /* renamed from: k */
    private int f18454k;

    /* renamed from: l */
    private final byte[] f18455l;

    static {
        f18446g = !C4416g.class.desiredAssertionStatus();
        f18447h = new byte[]{65, 66, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, DroneMap.f12610m, 81, DroneMap.f12611n, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 43, 47};
        f18448i = new byte[]{65, 66, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, DroneMap.f12610m, 81, DroneMap.f12611n, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 45, 95};
    }

    public C4419j(int i, byte[] bArr) {
        boolean z = true;
        this.f18439a = bArr;
        this.f18450d = (i & 1) == 0;
        this.f18451e = (i & 2) == 0;
        this.f18452f = (i & 4) == 0 ? false : z;
        this.f18455l = (i & 8) == 0 ? f18447h : f18448i;
        this.f18453j = new byte[2];
        this.f18449c = 0;
        this.f18454k = this.f18451e ? 19 : -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public boolean m5213a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        byte b;
        int i5;
        byte b2;
        int i6;
        byte b3;
        int i7;
        int i8;
        int i9;
        int i10;
        byte[] bArr2 = this.f18455l;
        byte[] bArr3 = this.f18439a;
        int i11 = 0;
        int i12 = this.f18454k;
        int i13 = i2 + i;
        int i14 = -1;
        switch (this.f18449c) {
            case 0:
                i3 = i;
                break;
            case 1:
                if (i + 2 <= i13) {
                    int i15 = i + 1;
                    i14 = ((this.f18453j[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i15] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    this.f18449c = 0;
                    i3 = i15 + 1;
                    break;
                }
                i3 = i;
                break;
            case 2:
                if (i + 1 <= i13) {
                    i3 = i + 1;
                    i14 = ((this.f18453j[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f18453j[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    this.f18449c = 0;
                    break;
                }
                i3 = i;
                break;
            default:
                i3 = i;
                break;
        }
        if (i14 != -1) {
            bArr3[0] = bArr2[(i14 >> 18) & 63];
            bArr3[1] = bArr2[(i14 >> 12) & 63];
            bArr3[2] = bArr2[(i14 >> 6) & 63];
            i11 = 4;
            bArr3[3] = bArr2[i14 & 63];
            i12--;
            if (i12 == 0) {
                if (this.f18452f) {
                    i10 = 5;
                    bArr3[4] = 13;
                } else {
                    i10 = 4;
                }
                i11 = i10 + 1;
                bArr3[i10] = 10;
                i12 = 19;
            }
        }
        while (true) {
            int i16 = i12;
            int i17 = i11;
            if (i3 + 3 > i13) {
                if (z) {
                    if (i3 - this.f18449c == i13 - 1) {
                        if (this.f18449c > 0) {
                            i8 = 1;
                            b3 = this.f18453j[0];
                            i7 = i3;
                        } else {
                            b3 = bArr[i3];
                            i7 = i3 + 1;
                            i8 = 0;
                        }
                        int i18 = (b3 & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 4;
                        this.f18449c -= i8;
                        int i19 = i17 + 1;
                        bArr3[i17] = bArr2[(i18 >> 6) & 63];
                        int i20 = i19 + 1;
                        bArr3[i19] = bArr2[i18 & 63];
                        if (this.f18450d) {
                            int i21 = i20 + 1;
                            bArr3[i20] = 61;
                            i20 = i21 + 1;
                            bArr3[i21] = 61;
                        }
                        if (this.f18451e) {
                            if (this.f18452f) {
                                bArr3[i20] = 13;
                                i20++;
                            }
                            bArr3[i20] = 10;
                            i20++;
                        }
                        i3 = i7;
                        i17 = i20;
                    } else if (i3 - this.f18449c == i13 - 2) {
                        if (this.f18449c > 1) {
                            i5 = 1;
                            b = this.f18453j[0];
                        } else {
                            b = bArr[i3];
                            i3++;
                            i5 = 0;
                        }
                        int i22 = (b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 10;
                        if (this.f18449c > 0) {
                            b2 = this.f18453j[i5];
                            i5++;
                        } else {
                            b2 = bArr[i3];
                            i3++;
                        }
                        int i23 = ((b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 2) | i22;
                        this.f18449c -= i5;
                        int i24 = i17 + 1;
                        bArr3[i17] = bArr2[(i23 >> 12) & 63];
                        int i25 = i24 + 1;
                        bArr3[i24] = bArr2[(i23 >> 6) & 63];
                        int i26 = i25 + 1;
                        bArr3[i25] = bArr2[i23 & 63];
                        if (this.f18450d) {
                            i6 = i26 + 1;
                            bArr3[i26] = 61;
                        } else {
                            i6 = i26;
                        }
                        if (this.f18451e) {
                            if (this.f18452f) {
                                bArr3[i6] = 13;
                                i6++;
                            }
                            bArr3[i6] = 10;
                            i6++;
                        }
                        i17 = i6;
                    } else if (this.f18451e && i17 > 0 && i16 != 19) {
                        if (this.f18452f) {
                            i4 = i17 + 1;
                            bArr3[i17] = 13;
                        } else {
                            i4 = i17;
                        }
                        i17 = i4 + 1;
                        bArr3[i4] = 10;
                    }
                    if (!f18446g && this.f18449c != 0) {
                        throw new AssertionError();
                    }
                    if (!f18446g && i3 != i13) {
                        throw new AssertionError();
                    }
                } else if (i3 == i13 - 1) {
                    byte[] bArr4 = this.f18453j;
                    int i27 = this.f18449c;
                    this.f18449c = i27 + 1;
                    bArr4[i27] = bArr[i3];
                } else if (i3 == i13 - 2) {
                    byte[] bArr5 = this.f18453j;
                    int i28 = this.f18449c;
                    this.f18449c = i28 + 1;
                    bArr5[i28] = bArr[i3];
                    byte[] bArr6 = this.f18453j;
                    int i29 = this.f18449c;
                    this.f18449c = i29 + 1;
                    bArr6[i29] = bArr[i3 + 1];
                }
                this.f18440b = i17;
                this.f18454k = i16;
                return true;
            }
            int i30 = ((bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i3 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i3 + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            bArr3[i17] = bArr2[(i30 >> 18) & 63];
            bArr3[i17 + 1] = bArr2[(i30 >> 12) & 63];
            bArr3[i17 + 2] = bArr2[(i30 >> 6) & 63];
            bArr3[i17 + 3] = bArr2[i30 & 63];
            i3 += 3;
            i11 = i17 + 4;
            i12 = i16 - 1;
            if (i12 == 0) {
                if (this.f18452f) {
                    i9 = i11 + 1;
                    bArr3[i11] = 13;
                } else {
                    i9 = i11;
                }
                i11 = i9 + 1;
                bArr3[i9] = 10;
                i12 = 19;
            }
        }
    }
}
