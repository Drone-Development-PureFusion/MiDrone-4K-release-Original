package com.baidu.tts.loopj;

import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import java.io.UnsupportedEncodingException;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Coder {

        /* renamed from: op */
        public int f6271op;
        public byte[] output;

        Coder() {
        }

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.baidu.tts.loopj.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
            if (r14 != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
            r10.state = r3;
            r10.value = r2;
            r10.f6271op = r0;
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
            r10.state = r3;
            r10.f6271op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x010f, code lost:
            r10.state = 6;
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
            r10.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
            return false;
         */
        @Override // com.baidu.tts.loopj.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            if (this.state == 6) {
                return false;
            }
            int i5 = i2 + i;
            int i6 = this.state;
            int i7 = this.value;
            int i8 = 0;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
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
                                this.state = 6;
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
                                this.state = 6;
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
                                this.state = 6;
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
                                this.state = 6;
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
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 5:
                            if (i11 != -1) {
                                this.state = 6;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Encoder extends Coder {
        private static final byte[] ENCODE = {65, 66, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, DroneMap.f12610m, 81, DroneMap.f12611n, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, DroneMap.f12610m, 81, DroneMap.f12611n, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i, byte[] bArr) {
            boolean z = true;
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            this.do_newline = (i & 2) == 0;
            this.do_cr = (i & 4) == 0 ? false : z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        @Override // com.baidu.tts.loopj.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.baidu.tts.loopj.Base64.Coder
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            byte b;
            int i5;
            int i6;
            byte b2;
            int i7;
            byte b3;
            int i8;
            int i9;
            int i10;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i11 = 0;
            int i12 = this.count;
            int i13 = i2 + i;
            int i14 = -1;
            switch (this.tailLen) {
                case 0:
                    i3 = i;
                    break;
                case 1:
                    if (i + 2 <= i13) {
                        int i15 = i + 1;
                        i14 = ((this.tail[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i15] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                        this.tailLen = 0;
                        i3 = i15 + 1;
                        break;
                    }
                    i3 = i;
                    break;
                case 2:
                    if (i + 1 <= i13) {
                        i3 = i + 1;
                        i14 = ((this.tail[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.tail[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                        this.tailLen = 0;
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
                    if (this.do_cr) {
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
                        if (i3 - this.tailLen == i13 - 1) {
                            if (this.tailLen > 0) {
                                i8 = 1;
                                b3 = this.tail[0];
                            } else {
                                int i18 = i3 + 1;
                                b3 = bArr[i3];
                                i8 = 0;
                            }
                            int i19 = (b3 & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 4;
                            this.tailLen -= i8;
                            int i20 = i17 + 1;
                            bArr3[i17] = bArr2[(i19 >> 6) & 63];
                            int i21 = i20 + 1;
                            bArr3[i20] = bArr2[i19 & 63];
                            if (this.do_padding) {
                                int i22 = i21 + 1;
                                bArr3[i21] = 61;
                                i21 = i22 + 1;
                                bArr3[i22] = 61;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i21] = 13;
                                    i21++;
                                }
                                bArr3[i21] = 10;
                                i21++;
                            }
                            i17 = i21;
                        } else if (i3 - this.tailLen == i13 - 2) {
                            if (this.tailLen > 1) {
                                i6 = 1;
                                b = this.tail[0];
                                i5 = i3;
                            } else {
                                b = bArr[i3];
                                i5 = i3 + 1;
                                i6 = 0;
                            }
                            int i23 = (b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 10;
                            if (this.tailLen > 0) {
                                b2 = this.tail[i6];
                                i6++;
                            } else {
                                int i24 = i5 + 1;
                                b2 = bArr[i5];
                            }
                            int i25 = ((b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 2) | i23;
                            this.tailLen -= i6;
                            int i26 = i17 + 1;
                            bArr3[i17] = bArr2[(i25 >> 12) & 63];
                            int i27 = i26 + 1;
                            bArr3[i26] = bArr2[(i25 >> 6) & 63];
                            int i28 = i27 + 1;
                            bArr3[i27] = bArr2[i25 & 63];
                            if (this.do_padding) {
                                i7 = i28 + 1;
                                bArr3[i28] = 61;
                            } else {
                                i7 = i28;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i7] = 13;
                                    i7++;
                                }
                                bArr3[i7] = 10;
                                i7++;
                            }
                            i17 = i7;
                        } else if (this.do_newline && i17 > 0 && i16 != 19) {
                            if (this.do_cr) {
                                i4 = i17 + 1;
                                bArr3[i17] = 13;
                            } else {
                                i4 = i17;
                            }
                            i17 = i4 + 1;
                            bArr3[i4] = 10;
                        }
                    } else if (i3 == i13 - 1) {
                        byte[] bArr4 = this.tail;
                        int i29 = this.tailLen;
                        this.tailLen = i29 + 1;
                        bArr4[i29] = bArr[i3];
                    } else if (i3 == i13 - 2) {
                        byte[] bArr5 = this.tail;
                        int i30 = this.tailLen;
                        this.tailLen = i30 + 1;
                        bArr5[i30] = bArr[i3];
                        byte[] bArr6 = this.tail;
                        int i31 = this.tailLen;
                        this.tailLen = i31 + 1;
                        bArr6[i31] = bArr[i3 + 1];
                    }
                    this.f6271op = i17;
                    this.count = i16;
                    return true;
                }
                int i32 = ((bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i3 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i3 + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                bArr3[i17] = bArr2[(i32 >> 18) & 63];
                bArr3[i17 + 1] = bArr2[(i32 >> 12) & 63];
                bArr3[i17 + 2] = bArr2[(i32 >> 6) & 63];
                bArr3[i17 + 3] = bArr2[i32 & 63];
                i3 += 3;
                i11 = i17 + 4;
                i12 = i16 - 1;
                if (i12 == 0) {
                    if (this.do_cr) {
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

    private Base64() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[(i2 * 3) / 4]);
        if (!decoder.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.f6271op == decoder.output.length) {
            return decoder.output;
        }
        byte[] bArr2 = new byte[decoder.f6271op];
        System.arraycopy(decoder.output, 0, bArr2, 0, decoder.f6271op);
        return bArr2;
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            i4 += (encoder.do_cr ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        return encoder.output;
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
