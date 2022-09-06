package org.codehaus.jackson.org.objectweb.asm;

import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes2.dex */
class MethodWriter implements MethodVisitor {

    /* renamed from: A */
    private int f22908A;

    /* renamed from: B */
    private Handler f22909B;

    /* renamed from: C */
    private Handler f22910C;

    /* renamed from: D */
    private int f22911D;

    /* renamed from: E */
    private ByteVector f22912E;

    /* renamed from: F */
    private int f22913F;

    /* renamed from: G */
    private ByteVector f22914G;

    /* renamed from: H */
    private int f22915H;

    /* renamed from: I */
    private ByteVector f22916I;

    /* renamed from: J */
    private Attribute f22917J;

    /* renamed from: K */
    private boolean f22918K;

    /* renamed from: L */
    private int f22919L;

    /* renamed from: M */
    private final int f22920M;

    /* renamed from: N */
    private Label f22921N;

    /* renamed from: O */
    private Label f22922O;

    /* renamed from: P */
    private Label f22923P;

    /* renamed from: Q */
    private int f22924Q;

    /* renamed from: R */
    private int f22925R;

    /* renamed from: S */
    private int f22926S;

    /* renamed from: a */
    MethodWriter f22927a;

    /* renamed from: b */
    final ClassWriter f22928b;

    /* renamed from: c */
    private int f22929c;

    /* renamed from: d */
    private final int f22930d;

    /* renamed from: e */
    private final int f22931e;

    /* renamed from: f */
    private final String f22932f;

    /* renamed from: g */
    String f22933g;

    /* renamed from: h */
    int f22934h;

    /* renamed from: i */
    int f22935i;

    /* renamed from: j */
    int f22936j;

    /* renamed from: k */
    int[] f22937k;

    /* renamed from: l */
    private ByteVector f22938l;

    /* renamed from: m */
    private AnnotationWriter f22939m;

    /* renamed from: n */
    private AnnotationWriter f22940n;

    /* renamed from: o */
    private AnnotationWriter[] f22941o;

    /* renamed from: p */
    private AnnotationWriter[] f22942p;

    /* renamed from: q */
    private Attribute f22943q;

    /* renamed from: r */
    private ByteVector f22944r = new ByteVector();

    /* renamed from: s */
    private int f22945s;

    /* renamed from: t */
    private int f22946t;

    /* renamed from: u */
    private int f22947u;

    /* renamed from: v */
    private ByteVector f22948v;

    /* renamed from: w */
    private int f22949w;

    /* renamed from: x */
    private int[] f22950x;

    /* renamed from: y */
    private int f22951y;

    /* renamed from: z */
    private int[] f22952z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        int i2 = 0;
        if (classWriter.f22825A == null) {
            classWriter.f22825A = this;
        } else {
            classWriter.f22826B.f22927a = this;
        }
        classWriter.f22826B = this;
        this.f22928b = classWriter;
        this.f22929c = i;
        this.f22930d = classWriter.newUTF8(str);
        this.f22931e = classWriter.newUTF8(str2);
        this.f22932f = str2;
        this.f22933g = str3;
        if (strArr != null && strArr.length > 0) {
            this.f22936j = strArr.length;
            this.f22937k = new int[this.f22936j];
            for (int i3 = 0; i3 < this.f22936j; i3++) {
                this.f22937k[i3] = classWriter.newClass(strArr[i3]);
            }
        }
        this.f22920M = !z2 ? z ? 1 : 2 : i2;
        if (z || z2) {
            if (z2 && "<init>".equals(str)) {
                this.f22929c |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
            }
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.f22932f) >> 2;
            this.f22946t = (i & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.f22921N = new Label();
            this.f22921N.f22896a |= 8;
            visitLabel(this.f22921N);
        }
    }

    /* renamed from: a */
    static int m204a(byte[] bArr, int i) {
        return ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: a */
    static int m202a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i < iArr[i4] && iArr[i4] <= i2) {
                i3 += iArr2[i4];
            } else if (i2 < iArr[i4] && iArr[i4] <= i) {
                i3 -= iArr2[i4];
            }
        }
        return i3;
    }

    /* renamed from: a */
    private void m210a(int i, int i2) {
        while (i < i2) {
            int i3 = this.f22952z[i];
            int i4 = (-268435456) & i3;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                switch (i3 & 267386880) {
                    case 24117248:
                        this.f22948v.putByte(7).putShort(this.f22928b.newClass(this.f22928b.f22828E[i5].f22891g));
                        continue;
                    case 25165824:
                        this.f22948v.putByte(8).putShort(this.f22928b.f22828E[i5].f22889c);
                        continue;
                    default:
                        this.f22948v.putByte(i5);
                        continue;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i6 = i4 >> 28;
                while (true) {
                    int i7 = i6 - 1;
                    if (i6 > 0) {
                        stringBuffer.append('[');
                        i6 = i7;
                    } else {
                        if ((i3 & 267386880) != 24117248) {
                            switch (i3 & 15) {
                                case 1:
                                    stringBuffer.append('I');
                                    break;
                                case 2:
                                    stringBuffer.append('F');
                                    break;
                                case 3:
                                    stringBuffer.append('D');
                                    break;
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                default:
                                    stringBuffer.append('J');
                                    break;
                                case 9:
                                    stringBuffer.append('Z');
                                    break;
                                case 10:
                                    stringBuffer.append('B');
                                    break;
                                case 11:
                                    stringBuffer.append('C');
                                    break;
                                case 12:
                                    stringBuffer.append('S');
                                    break;
                            }
                        } else {
                            stringBuffer.append('L');
                            stringBuffer.append(this.f22928b.f22828E[i3 & 1048575].f22891g);
                            stringBuffer.append(';');
                        }
                        this.f22948v.putByte(7).putShort(this.f22928b.newClass(stringBuffer.toString()));
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: a */
    private void m209a(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        if (this.f22952z == null || this.f22952z.length < i4) {
            this.f22952z = new int[i4];
        }
        this.f22952z[0] = i;
        this.f22952z[1] = i2;
        this.f22952z[2] = i3;
        this.f22951y = 3;
    }

    /* renamed from: a */
    private void m208a(int i, Label label) {
        Edge edge = new Edge();
        edge.f22859a = i;
        edge.f22860b = label;
        edge.f22861c = this.f22923P.f22905j;
        this.f22923P.f22905j = edge;
    }

    /* renamed from: a */
    private void m207a(Object obj) {
        if (obj instanceof String) {
            this.f22948v.putByte(7).putShort(this.f22928b.newClass((String) obj));
        } else if (obj instanceof Integer) {
            this.f22948v.putByte(((Integer) obj).intValue());
        } else {
            this.f22948v.putByte(8).putShort(((Label) obj).f22898c);
        }
    }

    /* renamed from: a */
    private void m205a(Label label, Label[] labelArr) {
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(Opcodes.LOOKUPSWITCH, 0, (ClassWriter) null, (Item) null);
                m208a(0, label);
                label.m219a().f22896a |= 16;
                for (int i = 0; i < labelArr.length; i++) {
                    m208a(0, labelArr[i]);
                    labelArr[i].m219a().f22896a |= 16;
                }
            } else {
                this.f22924Q--;
                m208a(this.f22924Q, label);
                for (Label label2 : labelArr) {
                    m208a(this.f22924Q, label2);
                }
            }
            m194e();
        }
    }

    /* renamed from: a */
    static void m203a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) i2;
    }

    /* renamed from: a */
    static void m201a(int[] iArr, int[] iArr2, Label label) {
        if ((label.f22896a & 4) == 0) {
            label.f22898c = m202a(iArr, iArr2, 0, label.f22898c);
            label.f22896a |= 4;
        }
    }

    /* renamed from: b */
    static short m198b(byte[] bArr, int i) {
        return (short) (((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
    }

    /* renamed from: b */
    private void m200b() {
        if (this.f22950x != null) {
            if (this.f22948v == null) {
                this.f22948v = new ByteVector();
            }
            m197c();
            this.f22947u++;
        }
        this.f22950x = this.f22952z;
        this.f22952z = null;
    }

    /* renamed from: b */
    private void m199b(Frame frame) {
        int i = 0;
        int[] iArr = frame.f22874c;
        int[] iArr2 = frame.f22875d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            if (i5 == 16777216) {
                i4++;
            } else {
                i3 += i4 + 1;
                i4 = 0;
            }
            if (i5 == 16777220 || i5 == 16777219) {
                i2++;
            }
            i2++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr2.length) {
            int i8 = iArr2[i6];
            i7++;
            if (i8 == 16777220 || i8 == 16777219) {
                i6++;
            }
            i6++;
        }
        m209a(frame.f22873b.f22898c, i3, i7);
        int i9 = 0;
        while (i3 > 0) {
            int i10 = iArr[i9];
            int[] iArr3 = this.f22952z;
            int i11 = this.f22951y;
            this.f22951y = i11 + 1;
            iArr3[i11] = i10;
            if (i10 == 16777220 || i10 == 16777219) {
                i9++;
            }
            i9++;
            i3--;
        }
        while (i < iArr2.length) {
            int i12 = iArr2[i];
            int[] iArr4 = this.f22952z;
            int i13 = this.f22951y;
            this.f22951y = i13 + 1;
            iArr4[i13] = i12;
            if (i12 == 16777220 || i12 == 16777219) {
                i++;
            }
            i++;
        }
        m200b();
    }

    /* renamed from: c */
    static int m196c(byte[] bArr, int i) {
        return ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: c */
    private void m197c() {
        int i;
        int i2;
        char c = '@';
        int i3 = 0;
        int i4 = this.f22952z[1];
        int i5 = this.f22952z[2];
        if ((this.f22928b.f22834b & 65535) < 50) {
            this.f22948v.putShort(this.f22952z[0]).putShort(i4);
            m210a(3, i4 + 3);
            this.f22948v.putShort(i5);
            m210a(i4 + 3, i4 + 3 + i5);
            return;
        }
        int i6 = this.f22950x[1];
        int i7 = this.f22947u == 0 ? this.f22952z[0] : (this.f22952z[0] - this.f22950x[0]) - 1;
        if (i5 == 0) {
            i = i4 - i6;
            switch (i) {
                case -3:
                case -2:
                case -1:
                    c = 248;
                    i6 = i4;
                    break;
                case 0:
                    if (i7 >= 64) {
                        c = 251;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c = 252;
                    break;
                default:
                    c = 255;
                    break;
            }
            i2 = i6;
        } else if (i4 == i6 && i5 == 1) {
            if (i7 >= 63) {
                c = 247;
            }
            i = 0;
            i2 = i6;
        } else {
            i = 0;
            c = 255;
            i2 = i6;
        }
        if (c != 255) {
            int i8 = 3;
            while (true) {
                if (i3 < i2) {
                    if (this.f22952z[i8] != this.f22950x[i8]) {
                        c = 255;
                    } else {
                        i8++;
                        i3++;
                    }
                }
            }
        }
        switch (c) {
            case 0:
                this.f22948v.putByte(i7);
                return;
            case '@':
                this.f22948v.putByte(i7 + 64);
                m210a(i4 + 3, i4 + 4);
                return;
            case 247:
                this.f22948v.putByte(247).putShort(i7);
                m210a(i4 + 3, i4 + 4);
                return;
            case 248:
                this.f22948v.putByte(i + 251).putShort(i7);
                return;
            case 251:
                this.f22948v.putByte(251).putShort(i7);
                return;
            case SmileConstants.INT_MARKER_END_OF_STRING /* 252 */:
                this.f22948v.putByte(i + 251).putShort(i7);
                m210a(i2 + 3, i4 + 3);
                return;
            default:
                this.f22948v.putByte(255).putShort(i7).putShort(i4);
                m210a(3, i4 + 3);
                this.f22948v.putShort(i5);
                m210a(i4 + 3, i4 + 3 + i5);
                return;
        }
    }

    /* renamed from: d */
    private void m195d() {
        int i;
        int m198b;
        int i2;
        int m198b2;
        int i3;
        byte[] bArr = this.f22944r.f22817a;
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        boolean[] zArr = new boolean[this.f22944r.f22818b];
        int i4 = 3;
        while (true) {
            if (i4 == 3) {
                i4 = 2;
            }
            int i5 = i4;
            short s = 0;
            while (s < bArr.length) {
                int i6 = bArr[s] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int i7 = 0;
                switch (ClassWriter.f22824a[i6]) {
                    case 0:
                    case 4:
                        s++;
                        break;
                    case 1:
                    case 3:
                    case 10:
                        s += 2;
                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 11:
                    case 12:
                        s += 3;
                        break;
                    case 7:
                        s += 5;
                        break;
                    case 8:
                        if (i6 > 201) {
                            i6 = i6 < 218 ? i6 - 49 : i6 - 20;
                            m198b2 = m196c(bArr, s + 1) + s;
                        } else {
                            m198b2 = m198b(bArr, s + 1) + s;
                        }
                        int m202a = m202a(iArr, iArr2, s, m198b2);
                        if ((m202a < -32768 || m202a > 32767) && !zArr[s]) {
                            i3 = (i6 == 167 || i6 == 168) ? 2 : 5;
                            zArr[s] = true;
                        } else {
                            i3 = 0;
                        }
                        s += 3;
                        i7 = i3;
                        break;
                    case 9:
                        s += 5;
                        break;
                    case 13:
                        if (i5 == 1) {
                            i7 = -(m202a(iArr, iArr2, 0, s) & 3);
                        } else if (!zArr[s]) {
                            i7 = s & 3;
                            zArr[s] = true;
                        }
                        int i8 = (s + 4) - (s & 3);
                        s = i8 + (((m204a(bArr, i8 + 8) - m204a(bArr, i8 + 4)) + 1) * 4) + 12;
                        break;
                    case 14:
                        if (i5 == 1) {
                            i7 = -(m202a(iArr, iArr2, 0, s) & 3);
                        } else if (!zArr[s]) {
                            i7 = s & 3;
                            zArr[s] = true;
                        }
                        int i9 = (s + 4) - (s & 3);
                        s = i9 + (m204a(bArr, i9 + 4) * 8) + 8;
                        break;
                    case 15:
                    default:
                        s += 4;
                        break;
                    case 16:
                        if ((bArr[s + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 132) {
                            s += 6;
                            break;
                        } else {
                            s += 4;
                            break;
                        }
                }
                if (i7 != 0) {
                    int[] iArr3 = new int[iArr.length + 1];
                    int[] iArr4 = new int[iArr2.length + 1];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr4, 0, iArr2.length);
                    iArr3[iArr.length] = s;
                    iArr4[iArr2.length] = i7;
                    if (i7 > 0) {
                        i5 = 3;
                        iArr2 = iArr4;
                        iArr = iArr3;
                    } else {
                        iArr2 = iArr4;
                        iArr = iArr3;
                    }
                }
            }
            if (i5 < 3) {
                i5--;
            }
            if (i5 == 0) {
                ByteVector byteVector = new ByteVector(this.f22944r.f22818b);
                short s2 = 0;
                while (s2 < this.f22944r.f22818b) {
                    int i10 = bArr[s2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    switch (ClassWriter.f22824a[i10]) {
                        case 0:
                        case 4:
                            byteVector.putByte(i10);
                            s2++;
                            continue;
                        case 1:
                        case 3:
                        case 10:
                            byteVector.putByteArray(bArr, s2, 2);
                            s2 += 2;
                            continue;
                        case 2:
                        case 5:
                        case 6:
                        case 11:
                        case 12:
                            byteVector.putByteArray(bArr, s2, 3);
                            s2 += 3;
                            continue;
                        case 7:
                            byteVector.putByteArray(bArr, s2, 5);
                            s2 += 5;
                            continue;
                        case 8:
                            if (i10 > 201) {
                                i10 = i10 < 218 ? i10 - 49 : i10 - 20;
                                m198b = m196c(bArr, s2 + 1) + s2;
                            } else {
                                m198b = m198b(bArr, s2 + 1) + s2;
                            }
                            int m202a2 = m202a(iArr, iArr2, s2, m198b);
                            if (zArr[s2]) {
                                if (i10 == 167) {
                                    byteVector.putByte(200);
                                    i2 = m202a2;
                                } else if (i10 == 168) {
                                    byteVector.putByte(201);
                                    i2 = m202a2;
                                } else {
                                    byteVector.putByte(i10 <= 166 ? ((i10 + 1) ^ 1) - 1 : i10 ^ 1);
                                    byteVector.putShort(8);
                                    byteVector.putByte(200);
                                    i2 = m202a2 - 3;
                                }
                                byteVector.putInt(i2);
                            } else {
                                byteVector.putByte(i10);
                                byteVector.putShort(m202a2);
                            }
                            s2 += 3;
                            continue;
                        case 9:
                            int m202a3 = m202a(iArr, iArr2, s2, m204a(bArr, s2 + 1) + s2);
                            byteVector.putByte(i10);
                            byteVector.putInt(m202a3);
                            s2 += 5;
                            continue;
                        case 13:
                            int i11 = (s2 + 4) - (s2 & 3);
                            byteVector.putByte(170);
                            byteVector.putByteArray(null, 0, (4 - (byteVector.f22818b % 4)) % 4);
                            int i12 = i11 + 4;
                            byteVector.putInt(m202a(iArr, iArr2, s2, m204a(bArr, i11) + s2));
                            int m204a = m204a(bArr, i12);
                            int i13 = i12 + 4;
                            byteVector.putInt(m204a);
                            int m204a2 = (m204a(bArr, i13) - m204a) + 1;
                            int i14 = i13 + 4;
                            byteVector.putInt(m204a(bArr, i14 - 4));
                            i = i14;
                            int i15 = m204a2;
                            while (i15 > 0) {
                                byteVector.putInt(m202a(iArr, iArr2, s2, s2 + m204a(bArr, i)));
                                i15--;
                                i += 4;
                            }
                            break;
                        case 14:
                            int i16 = (s2 + 4) - (s2 & 3);
                            byteVector.putByte(Opcodes.LOOKUPSWITCH);
                            byteVector.putByteArray(null, 0, (4 - (byteVector.f22818b % 4)) % 4);
                            int i17 = i16 + 4;
                            byteVector.putInt(m202a(iArr, iArr2, s2, m204a(bArr, i16) + s2));
                            int m204a3 = m204a(bArr, i17);
                            byteVector.putInt(m204a3);
                            i = i17 + 4;
                            int i18 = m204a3;
                            while (i18 > 0) {
                                byteVector.putInt(m204a(bArr, i));
                                int i19 = i + 4;
                                byteVector.putInt(m202a(iArr, iArr2, s2, s2 + m204a(bArr, i19)));
                                i18--;
                                i = i19 + 4;
                            }
                            break;
                        case 15:
                        default:
                            byteVector.putByteArray(bArr, s2, 4);
                            s2 += 4;
                            continue;
                        case 16:
                            if ((bArr[s2 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 132) {
                                byteVector.putByteArray(bArr, s2, 6);
                                s2 += 6;
                            } else {
                                byteVector.putByteArray(bArr, s2, 4);
                                s2 += 4;
                                continue;
                            }
                    }
                    s2 = i;
                }
                if (this.f22947u > 0) {
                    if (this.f22920M == 0) {
                        this.f22947u = 0;
                        this.f22948v = null;
                        this.f22950x = null;
                        this.f22952z = null;
                        Frame frame = new Frame();
                        frame.f22873b = this.f22921N;
                        frame.m232a(this.f22928b, this.f22929c, Type.getArgumentTypes(this.f22932f), this.f22946t);
                        m199b(frame);
                        for (Label label = this.f22921N; label != null; label = label.f22904i) {
                            int i20 = label.f22898c - 3;
                            if ((label.f22896a & 32) != 0 || (i20 >= 0 && zArr[i20])) {
                                m201a(iArr, iArr2, label);
                                m199b(label.f22903h);
                            }
                        }
                    } else {
                        this.f22928b.f22832I = true;
                    }
                }
                for (Handler handler = this.f22909B; handler != null; handler = handler.f22886f) {
                    m201a(iArr, iArr2, handler.f22881a);
                    m201a(iArr, iArr2, handler.f22882b);
                    m201a(iArr, iArr2, handler.f22883c);
                }
                int i21 = 0;
                while (true) {
                    int i22 = i21;
                    if (i22 >= 2) {
                        if (this.f22916I != null) {
                            byte[] bArr2 = this.f22916I.f22817a;
                            for (int i23 = 0; i23 < this.f22916I.f22818b; i23 += 4) {
                                m203a(bArr2, i23, m202a(iArr, iArr2, 0, m196c(bArr2, i23)));
                            }
                        }
                        for (Attribute attribute = this.f22917J; attribute != null; attribute = attribute.f22815a) {
                            Label[] labels = attribute.getLabels();
                            if (labels != null) {
                                for (int length = labels.length - 1; length >= 0; length--) {
                                    m201a(iArr, iArr2, labels[length]);
                                }
                            }
                        }
                        this.f22944r = byteVector;
                        return;
                    }
                    ByteVector byteVector2 = i22 == 0 ? this.f22912E : this.f22914G;
                    if (byteVector2 != null) {
                        byte[] bArr3 = byteVector2.f22817a;
                        for (int i24 = 0; i24 < byteVector2.f22818b; i24 += 10) {
                            int m196c = m196c(bArr3, i24);
                            int m202a4 = m202a(iArr, iArr2, 0, m196c);
                            m203a(bArr3, i24, m202a4);
                            m203a(bArr3, i24 + 2, m202a(iArr, iArr2, 0, m196c + m196c(bArr3, i24 + 2)) - m202a4);
                        }
                    }
                    i21 = i22 + 1;
                }
            } else {
                i4 = i5;
            }
        }
    }

    /* renamed from: e */
    private void m194e() {
        if (this.f22920M == 0) {
            Label label = new Label();
            label.f22903h = new Frame();
            label.f22903h.f22873b = label;
            label.m214a(this, this.f22944r.f22818b, this.f22944r.f22817a);
            this.f22922O.f22904i = label;
            this.f22922O = label;
        } else {
            this.f22923P.f22902g = this.f22925R;
        }
        this.f22923P = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m211a() {
        int i;
        if (this.f22934h != 0) {
            return this.f22935i + 6;
        }
        if (this.f22918K) {
            m195d();
        }
        int i2 = 8;
        if (this.f22944r.f22818b > 0) {
            this.f22928b.newUTF8("Code");
            int i3 = this.f22944r.f22818b + 18 + (this.f22908A * 8) + 8;
            if (this.f22912E != null) {
                this.f22928b.newUTF8("LocalVariableTable");
                i3 += this.f22912E.f22818b + 8;
            }
            if (this.f22914G != null) {
                this.f22928b.newUTF8("LocalVariableTypeTable");
                i3 += this.f22914G.f22818b + 8;
            }
            if (this.f22916I != null) {
                this.f22928b.newUTF8("LineNumberTable");
                i3 += this.f22916I.f22818b + 8;
            }
            if (this.f22948v != null) {
                this.f22928b.newUTF8((this.f22928b.f22834b & 65535) >= 50 ? "StackMapTable" : "StackMap");
                i2 = i3 + this.f22948v.f22818b + 8;
            } else {
                i2 = i3;
            }
            if (this.f22917J != null) {
                i2 += this.f22917J.m271a(this.f22928b, this.f22944r.f22817a, this.f22944r.f22818b, this.f22945s, this.f22946t);
            }
        }
        if (this.f22936j > 0) {
            this.f22928b.newUTF8("Exceptions");
            i2 += (this.f22936j * 2) + 8;
        }
        if ((this.f22929c & 4096) != 0 && ((this.f22928b.f22834b & 65535) < 49 || (this.f22929c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            this.f22928b.newUTF8("Synthetic");
            i2 += 6;
        }
        if ((this.f22929c & 131072) != 0) {
            this.f22928b.newUTF8("Deprecated");
            i2 += 6;
        }
        if (this.f22933g != null) {
            this.f22928b.newUTF8(Consts.SIGNATURE);
            this.f22928b.newUTF8(this.f22933g);
            i2 += 8;
        }
        if (this.f22938l != null) {
            this.f22928b.newUTF8("AnnotationDefault");
            i2 += this.f22938l.f22818b + 6;
        }
        if (this.f22939m != null) {
            this.f22928b.newUTF8("RuntimeVisibleAnnotations");
            i2 += this.f22939m.m275a() + 8;
        }
        if (this.f22940n != null) {
            this.f22928b.newUTF8("RuntimeInvisibleAnnotations");
            i2 += this.f22940n.m275a() + 8;
        }
        if (this.f22941o != null) {
            this.f22928b.newUTF8("RuntimeVisibleParameterAnnotations");
            i = i2 + ((this.f22941o.length - this.f22926S) * 2) + 7;
            int length = this.f22941o.length;
            while (true) {
                length--;
                if (length < this.f22926S) {
                    break;
                }
                i += this.f22941o[length] == null ? 0 : this.f22941o[length].m275a();
            }
        } else {
            i = i2;
        }
        if (this.f22942p != null) {
            this.f22928b.newUTF8("RuntimeInvisibleParameterAnnotations");
            i += ((this.f22942p.length - this.f22926S) * 2) + 7;
            int length2 = this.f22942p.length;
            while (true) {
                length2--;
                if (length2 < this.f22926S) {
                    break;
                }
                i += this.f22942p[length2] == null ? 0 : this.f22942p[length2].m275a();
            }
        }
        int i4 = i;
        return this.f22943q != null ? i4 + this.f22943q.m271a(this.f22928b, null, 0, -1, -1) : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m206a(ByteVector byteVector) {
        boolean z = true;
        byteVector.putShort(((393216 | ((this.f22929c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) / 64)) ^ (-1)) & this.f22929c).putShort(this.f22930d).putShort(this.f22931e);
        if (this.f22934h != 0) {
            byteVector.putByteArray(this.f22928b.f22833J.f22821b, this.f22934h, this.f22935i);
            return;
        }
        int i = this.f22944r.f22818b > 0 ? 1 : 0;
        if (this.f22936j > 0) {
            i++;
        }
        if ((this.f22929c & 4096) != 0 && ((this.f22928b.f22834b & 65535) < 49 || (this.f22929c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            i++;
        }
        if ((this.f22929c & 131072) != 0) {
            i++;
        }
        if (this.f22933g != null) {
            i++;
        }
        if (this.f22938l != null) {
            i++;
        }
        if (this.f22939m != null) {
            i++;
        }
        if (this.f22940n != null) {
            i++;
        }
        if (this.f22941o != null) {
            i++;
        }
        if (this.f22942p != null) {
            i++;
        }
        if (this.f22943q != null) {
            i += this.f22943q.m272a();
        }
        byteVector.putShort(i);
        if (this.f22944r.f22818b > 0) {
            int i2 = this.f22944r.f22818b + 12 + (this.f22908A * 8);
            if (this.f22912E != null) {
                i2 += this.f22912E.f22818b + 8;
            }
            if (this.f22914G != null) {
                i2 += this.f22914G.f22818b + 8;
            }
            if (this.f22916I != null) {
                i2 += this.f22916I.f22818b + 8;
            }
            int i3 = this.f22948v != null ? i2 + this.f22948v.f22818b + 8 : i2;
            if (this.f22917J != null) {
                i3 += this.f22917J.m271a(this.f22928b, this.f22944r.f22817a, this.f22944r.f22818b, this.f22945s, this.f22946t);
            }
            byteVector.putShort(this.f22928b.newUTF8("Code")).putInt(i3);
            byteVector.putShort(this.f22945s).putShort(this.f22946t);
            byteVector.putInt(this.f22944r.f22818b).putByteArray(this.f22944r.f22817a, 0, this.f22944r.f22818b);
            byteVector.putShort(this.f22908A);
            if (this.f22908A > 0) {
                for (Handler handler = this.f22909B; handler != null; handler = handler.f22886f) {
                    byteVector.putShort(handler.f22881a.f22898c).putShort(handler.f22882b.f22898c).putShort(handler.f22883c.f22898c).putShort(handler.f22885e);
                }
            }
            int i4 = this.f22912E != null ? 1 : 0;
            if (this.f22914G != null) {
                i4++;
            }
            if (this.f22916I != null) {
                i4++;
            }
            if (this.f22948v != null) {
                i4++;
            }
            if (this.f22917J != null) {
                i4 += this.f22917J.m272a();
            }
            byteVector.putShort(i4);
            if (this.f22912E != null) {
                byteVector.putShort(this.f22928b.newUTF8("LocalVariableTable"));
                byteVector.putInt(this.f22912E.f22818b + 2).putShort(this.f22911D);
                byteVector.putByteArray(this.f22912E.f22817a, 0, this.f22912E.f22818b);
            }
            if (this.f22914G != null) {
                byteVector.putShort(this.f22928b.newUTF8("LocalVariableTypeTable"));
                byteVector.putInt(this.f22914G.f22818b + 2).putShort(this.f22913F);
                byteVector.putByteArray(this.f22914G.f22817a, 0, this.f22914G.f22818b);
            }
            if (this.f22916I != null) {
                byteVector.putShort(this.f22928b.newUTF8("LineNumberTable"));
                byteVector.putInt(this.f22916I.f22818b + 2).putShort(this.f22915H);
                byteVector.putByteArray(this.f22916I.f22817a, 0, this.f22916I.f22818b);
            }
            if (this.f22948v != null) {
                if ((this.f22928b.f22834b & 65535) < 50) {
                    z = false;
                }
                byteVector.putShort(this.f22928b.newUTF8(z ? "StackMapTable" : "StackMap"));
                byteVector.putInt(this.f22948v.f22818b + 2).putShort(this.f22947u);
                byteVector.putByteArray(this.f22948v.f22817a, 0, this.f22948v.f22818b);
            }
            if (this.f22917J != null) {
                this.f22917J.m270a(this.f22928b, this.f22944r.f22817a, this.f22944r.f22818b, this.f22946t, this.f22945s, byteVector);
            }
        }
        if (this.f22936j > 0) {
            byteVector.putShort(this.f22928b.newUTF8("Exceptions")).putInt((this.f22936j * 2) + 2);
            byteVector.putShort(this.f22936j);
            for (int i5 = 0; i5 < this.f22936j; i5++) {
                byteVector.putShort(this.f22937k[i5]);
            }
        }
        if ((this.f22929c & 4096) != 0 && ((this.f22928b.f22834b & 65535) < 49 || (this.f22929c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            byteVector.putShort(this.f22928b.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.f22929c & 131072) != 0) {
            byteVector.putShort(this.f22928b.newUTF8("Deprecated")).putInt(0);
        }
        if (this.f22933g != null) {
            byteVector.putShort(this.f22928b.newUTF8(Consts.SIGNATURE)).putInt(2).putShort(this.f22928b.newUTF8(this.f22933g));
        }
        if (this.f22938l != null) {
            byteVector.putShort(this.f22928b.newUTF8("AnnotationDefault"));
            byteVector.putInt(this.f22938l.f22818b);
            byteVector.putByteArray(this.f22938l.f22817a, 0, this.f22938l.f22818b);
        }
        if (this.f22939m != null) {
            byteVector.putShort(this.f22928b.newUTF8("RuntimeVisibleAnnotations"));
            this.f22939m.m274a(byteVector);
        }
        if (this.f22940n != null) {
            byteVector.putShort(this.f22928b.newUTF8("RuntimeInvisibleAnnotations"));
            this.f22940n.m274a(byteVector);
        }
        if (this.f22941o != null) {
            byteVector.putShort(this.f22928b.newUTF8("RuntimeVisibleParameterAnnotations"));
            AnnotationWriter.m273a(this.f22941o, this.f22926S, byteVector);
        }
        if (this.f22942p != null) {
            byteVector.putShort(this.f22928b.newUTF8("RuntimeInvisibleParameterAnnotations"));
            AnnotationWriter.m273a(this.f22942p, this.f22926S, byteVector);
        }
        if (this.f22943q == null) {
            return;
        }
        this.f22943q.m270a(this.f22928b, null, 0, -1, -1, byteVector);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f22928b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f22928b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f22813g = this.f22939m;
            this.f22939m = annotationWriter;
        } else {
            annotationWriter.f22813g = this.f22940n;
            this.f22940n = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        this.f22938l = new ByteVector();
        return new AnnotationWriter(this.f22928b, false, this.f22938l, null, 0);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.f22815a = this.f22917J;
            this.f22917J = attribute;
            return;
        }
        attribute.f22815a = this.f22943q;
        this.f22943q = attribute;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitFieldInsn(int i, String str, String str2, String str3) {
        int i2;
        int i3 = 1;
        int i4 = -2;
        Item m248a = this.f22928b.m248a(str, str2, str3);
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, 0, this.f22928b, m248a);
            } else {
                char charAt = str3.charAt(0);
                switch (i) {
                    case Opcodes.GETSTATIC /* 178 */:
                        int i5 = this.f22924Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i3 = 2;
                        }
                        i2 = i3 + i5;
                        break;
                    case Opcodes.PUTSTATIC /* 179 */:
                        i2 = ((charAt == 'D' || charAt == 'J') ? -2 : -1) + this.f22924Q;
                        break;
                    case Opcodes.GETFIELD /* 180 */:
                        int i6 = this.f22924Q;
                        if (charAt != 'D' && charAt != 'J') {
                            i3 = 0;
                        }
                        i2 = i3 + i6;
                        break;
                    default:
                        int i7 = this.f22924Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i4 = -3;
                        }
                        i2 = i7 + i4;
                        break;
                }
                if (i2 > this.f22925R) {
                    this.f22925R = i2;
                }
                this.f22924Q = i2;
            }
        }
        this.f22944r.m267b(i, m248a.f22887a);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5 = 0;
        if (this.f22920M == 0) {
            return;
        }
        if (i == -1) {
            m209a(this.f22944r.f22818b, i2, i3);
            for (int i6 = 0; i6 < i2; i6++) {
                if (objArr[i6] instanceof String) {
                    int[] iArr = this.f22952z;
                    int i7 = this.f22951y;
                    this.f22951y = i7 + 1;
                    iArr[i7] = this.f22928b.m243c((String) objArr[i6]) | 24117248;
                } else if (objArr[i6] instanceof Integer) {
                    int[] iArr2 = this.f22952z;
                    int i8 = this.f22951y;
                    this.f22951y = i8 + 1;
                    iArr2[i8] = ((Integer) objArr[i6]).intValue();
                } else {
                    int[] iArr3 = this.f22952z;
                    int i9 = this.f22951y;
                    this.f22951y = i9 + 1;
                    iArr3[i9] = this.f22928b.m250a("", ((Label) objArr[i6]).f22898c) | 25165824;
                }
            }
            while (i5 < i3) {
                if (objArr2[i5] instanceof String) {
                    int[] iArr4 = this.f22952z;
                    int i10 = this.f22951y;
                    this.f22951y = i10 + 1;
                    iArr4[i10] = this.f22928b.m243c((String) objArr2[i5]) | 24117248;
                } else if (objArr2[i5] instanceof Integer) {
                    int[] iArr5 = this.f22952z;
                    int i11 = this.f22951y;
                    this.f22951y = i11 + 1;
                    iArr5[i11] = ((Integer) objArr2[i5]).intValue();
                } else {
                    int[] iArr6 = this.f22952z;
                    int i12 = this.f22951y;
                    this.f22951y = i12 + 1;
                    iArr6[i12] = this.f22928b.m250a("", ((Label) objArr2[i5]).f22898c) | 25165824;
                }
                i5++;
            }
            m200b();
            return;
        }
        if (this.f22948v == null) {
            this.f22948v = new ByteVector();
            i4 = this.f22944r.f22818b;
        } else {
            i4 = (this.f22944r.f22818b - this.f22949w) - 1;
            if (i4 < 0) {
                if (i == 3) {
                    return;
                }
                throw new IllegalStateException();
            }
        }
        switch (i) {
            case 0:
                this.f22948v.putByte(255).putShort(i4).putShort(i2);
                for (int i13 = 0; i13 < i2; i13++) {
                    m207a(objArr[i13]);
                }
                this.f22948v.putShort(i3);
                while (i5 < i3) {
                    m207a(objArr2[i5]);
                    i5++;
                }
                break;
            case 1:
                this.f22948v.putByte(i2 + 251).putShort(i4);
                for (int i14 = 0; i14 < i2; i14++) {
                    m207a(objArr[i14]);
                }
                break;
            case 2:
                this.f22948v.putByte(251 - i2).putShort(i4);
                break;
            case 3:
                if (i4 < 64) {
                    this.f22948v.putByte(i4);
                    break;
                } else {
                    this.f22948v.putByte(251).putShort(i4);
                    break;
                }
            case 4:
                if (i4 < 64) {
                    this.f22948v.putByte(i4 + 64);
                } else {
                    this.f22948v.putByte(247).putShort(i4);
                }
                m207a(objArr2[0]);
                break;
        }
        this.f22949w = this.f22944r.f22818b;
        this.f22947u++;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitIincInsn(int i, int i2) {
        int i3;
        if (this.f22923P != null && this.f22920M == 0) {
            this.f22923P.f22903h.m236a(132, i, (ClassWriter) null, (Item) null);
        }
        if (this.f22920M != 2 && (i3 = i + 1) > this.f22946t) {
            this.f22946t = i3;
        }
        if (i > 255 || i2 > 127 || i2 < -128) {
            this.f22944r.putByte(SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING).m267b(132, i).putShort(i2);
        } else {
            this.f22944r.putByte(132).m268a(i, i2);
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitInsn(int i) {
        this.f22944r.putByte(i);
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, 0, (ClassWriter) null, (Item) null);
            } else {
                int i2 = this.f22924Q + Frame.f22872a[i];
                if (i2 > this.f22925R) {
                    this.f22925R = i2;
                }
                this.f22924Q = i2;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            m194e();
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitIntInsn(int i, int i2) {
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, i2, (ClassWriter) null, (Item) null);
            } else if (i != 188) {
                int i3 = this.f22924Q + 1;
                if (i3 > this.f22925R) {
                    this.f22925R = i3;
                }
                this.f22924Q = i3;
            }
        }
        if (i == 17) {
            this.f22944r.m267b(i, i2);
        } else {
            this.f22944r.m268a(i, i2);
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitJumpInsn(int i, Label label) {
        Label label2 = null;
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, 0, (ClassWriter) null, (Item) null);
                label.m219a().f22896a |= 16;
                m208a(0, label);
                if (i != 167) {
                    label2 = new Label();
                }
            } else if (i == 168) {
                if ((label.f22896a & 512) == 0) {
                    label.f22896a |= 512;
                    this.f22919L++;
                }
                this.f22923P.f22896a |= 128;
                m208a(this.f22924Q + 1, label);
                label2 = new Label();
            } else {
                this.f22924Q += Frame.f22872a[i];
                m208a(this.f22924Q, label);
            }
        }
        if ((label.f22896a & 2) == 0 || label.f22898c - this.f22944r.f22818b >= -32768) {
            this.f22944r.putByte(i);
            label.m213a(this, this.f22944r, this.f22944r.f22818b - 1, false);
        } else {
            if (i == 167) {
                this.f22944r.putByte(200);
            } else if (i == 168) {
                this.f22944r.putByte(201);
            } else {
                if (label2 != null) {
                    label2.f22896a |= 16;
                }
                this.f22944r.putByte(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
                this.f22944r.putShort(8);
                this.f22944r.putByte(200);
            }
            label.m213a(this, this.f22944r, this.f22944r.f22818b - 1, true);
        }
        if (this.f22923P != null) {
            if (label2 != null) {
                visitLabel(label2);
            }
            if (i != 167) {
                return;
            }
            m194e();
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitLabel(Label label) {
        this.f22918K |= label.m214a(this, this.f22944r.f22818b, this.f22944r.f22817a);
        if ((label.f22896a & 1) != 0) {
            return;
        }
        if (this.f22920M != 0) {
            if (this.f22920M != 1) {
                return;
            }
            if (this.f22923P != null) {
                this.f22923P.f22902g = this.f22925R;
                m208a(this.f22924Q, label);
            }
            this.f22923P = label;
            this.f22924Q = 0;
            this.f22925R = 0;
            if (this.f22922O != null) {
                this.f22922O.f22904i = label;
            }
            this.f22922O = label;
            return;
        }
        if (this.f22923P != null) {
            if (label.f22898c == this.f22923P.f22898c) {
                this.f22923P.f22896a |= label.f22896a & 16;
                label.f22903h = this.f22923P.f22903h;
                return;
            }
            m208a(0, label);
        }
        this.f22923P = label;
        if (label.f22903h == null) {
            label.f22903h = new Frame();
            label.f22903h.f22873b = label;
        }
        if (this.f22922O != null) {
            if (label.f22898c == this.f22922O.f22898c) {
                this.f22922O.f22896a |= label.f22896a & 16;
                label.f22903h = this.f22922O.f22903h;
                this.f22923P = this.f22922O;
                return;
            }
            this.f22922O.f22904i = label;
        }
        this.f22922O = label;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item m252a = this.f22928b.m252a(obj);
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(18, 0, this.f22928b, m252a);
            } else {
                int i = (m252a.f22888b == 5 || m252a.f22888b == 6) ? this.f22924Q + 2 : this.f22924Q + 1;
                if (i > this.f22925R) {
                    this.f22925R = i;
                }
                this.f22924Q = i;
            }
        }
        int i2 = m252a.f22887a;
        if (m252a.f22888b == 5 || m252a.f22888b == 6) {
            this.f22944r.m267b(20, i2);
        } else if (i2 >= 256) {
            this.f22944r.m267b(19, i2);
        } else {
            this.f22944r.m268a(18, i2);
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitLineNumber(int i, Label label) {
        if (this.f22916I == null) {
            this.f22916I = new ByteVector();
        }
        this.f22915H++;
        this.f22916I.putShort(label.f22898c);
        this.f22916I.putShort(i);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        int i2 = 2;
        if (str3 != null) {
            if (this.f22914G == null) {
                this.f22914G = new ByteVector();
            }
            this.f22913F++;
            this.f22914G.putShort(label.f22898c).putShort(label2.f22898c - label.f22898c).putShort(this.f22928b.newUTF8(str)).putShort(this.f22928b.newUTF8(str3)).putShort(i);
        }
        if (this.f22912E == null) {
            this.f22912E = new ByteVector();
        }
        this.f22911D++;
        this.f22912E.putShort(label.f22898c).putShort(label2.f22898c - label.f22898c).putShort(this.f22928b.newUTF8(str)).putShort(this.f22928b.newUTF8(str2)).putShort(i);
        if (this.f22920M != 2) {
            char charAt = str2.charAt(0);
            if (charAt != 'J' && charAt != 'D') {
                i2 = 1;
            }
            int i3 = i2 + i;
            if (i3 <= this.f22946t) {
                return;
            }
            this.f22946t = i3;
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        int i = this.f22944r.f22818b;
        this.f22944r.putByte(Opcodes.LOOKUPSWITCH);
        this.f22944r.putByteArray(null, 0, (4 - (this.f22944r.f22818b % 4)) % 4);
        label.m213a(this, this.f22944r, i, true);
        this.f22944r.putInt(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            this.f22944r.putInt(iArr[i2]);
            labelArr[i2].m213a(this, this.f22944r, i, true);
        }
        m205a(label, labelArr);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitMaxs(int i, int i2) {
        Label label;
        if (this.f22920M != 0) {
            if (this.f22920M != 1) {
                this.f22945s = i;
                this.f22946t = i2;
                return;
            }
            for (Handler handler = this.f22909B; handler != null; handler = handler.f22886f) {
                Label label2 = handler.f22883c;
                Label label3 = handler.f22882b;
                for (Label label4 = handler.f22881a; label4 != label3; label4 = label4.f22904i) {
                    Edge edge = new Edge();
                    edge.f22859a = Integer.MAX_VALUE;
                    edge.f22860b = label2;
                    if ((label4.f22896a & 128) == 0) {
                        edge.f22861c = label4.f22905j;
                        label4.f22905j = edge;
                    } else {
                        edge.f22861c = label4.f22905j.f22861c.f22861c;
                        label4.f22905j.f22861c.f22861c = edge;
                    }
                }
            }
            if (this.f22919L > 0) {
                this.f22921N.m212b(null, 1L, this.f22919L);
                int i3 = 0;
                for (Label label5 = this.f22921N; label5 != null; label5 = label5.f22904i) {
                    if ((label5.f22896a & 128) != 0) {
                        Label label6 = label5.f22905j.f22861c.f22860b;
                        if ((label6.f22896a & 1024) == 0) {
                            i3++;
                            label6.m212b(null, ((i3 / 32) << 32) | (1 << (i3 % 32)), this.f22919L);
                        }
                    }
                }
                for (Label label7 = this.f22921N; label7 != null; label7 = label7.f22904i) {
                    if ((label7.f22896a & 128) != 0) {
                        for (Label label8 = this.f22921N; label8 != null; label8 = label8.f22904i) {
                            label8.f22896a &= -2049;
                        }
                        label7.f22905j.f22861c.f22860b.m212b(label7, 0L, this.f22919L);
                    }
                }
            }
            Label label9 = this.f22921N;
            int i4 = 0;
            while (label9 != null) {
                Label label10 = label9.f22906k;
                int i5 = label9.f22901f;
                int i6 = label9.f22902g + i5;
                if (i6 <= i4) {
                    i6 = i4;
                }
                Edge edge2 = label9.f22905j;
                Edge edge3 = (label9.f22896a & 128) != 0 ? edge2.f22861c : edge2;
                while (edge3 != null) {
                    Label label11 = edge3.f22860b;
                    if ((label11.f22896a & 8) == 0) {
                        label11.f22901f = edge3.f22859a == Integer.MAX_VALUE ? 1 : edge3.f22859a + i5;
                        label11.f22896a |= 8;
                        label11.f22906k = label10;
                        label = label11;
                    } else {
                        label = label10;
                    }
                    edge3 = edge3.f22861c;
                    label10 = label;
                }
                label9 = label10;
                i4 = i6;
            }
            this.f22945s = i4;
            return;
        }
        for (Handler handler2 = this.f22909B; handler2 != null; handler2 = handler2.f22886f) {
            Label m219a = handler2.f22881a.m219a();
            Label m219a2 = handler2.f22883c.m219a();
            Label m219a3 = handler2.f22882b.m219a();
            int m243c = 24117248 | this.f22928b.m243c(handler2.f22884d == null ? "java/lang/Throwable" : handler2.f22884d);
            m219a2.f22896a |= 16;
            for (Label label12 = m219a; label12 != m219a3; label12 = label12.f22904i) {
                Edge edge4 = new Edge();
                edge4.f22859a = m243c;
                edge4.f22860b = m219a2;
                edge4.f22861c = label12.f22905j;
                label12.f22905j = edge4;
            }
        }
        Frame frame = this.f22921N.f22903h;
        frame.m232a(this.f22928b, this.f22929c, Type.getArgumentTypes(this.f22932f), this.f22946t);
        m199b(frame);
        Label label13 = this.f22921N;
        int i7 = 0;
        while (label13 != null) {
            Label label14 = label13.f22906k;
            label13.f22906k = null;
            Frame frame2 = label13.f22903h;
            if ((label13.f22896a & 16) != 0) {
                label13.f22896a |= 32;
            }
            label13.f22896a |= 64;
            int length = frame2.f22875d.length + label13.f22902g;
            if (length <= i7) {
                length = i7;
            }
            Edge edge5 = label13.f22905j;
            while (edge5 != null) {
                Label m219a4 = edge5.f22860b.m219a();
                if (!frame2.m230a(this.f22928b, m219a4.f22903h, edge5.f22859a) || m219a4.f22906k != null) {
                    m219a4 = label14;
                } else {
                    m219a4.f22906k = label14;
                }
                edge5 = edge5.f22861c;
                label14 = m219a4;
            }
            label13 = label14;
            i7 = length;
        }
        int i8 = i7;
        for (Label label15 = this.f22921N; label15 != null; label15 = label15.f22904i) {
            Frame frame3 = label15.f22903h;
            if ((label15.f22896a & 32) != 0) {
                m199b(frame3);
            }
            if ((label15.f22896a & 64) == 0) {
                Label label16 = label15.f22904i;
                int i9 = label15.f22898c;
                int i10 = (label16 == null ? this.f22944r.f22818b : label16.f22898c) - 1;
                if (i10 >= i9) {
                    i8 = Math.max(i8, 1);
                    for (int i11 = i9; i11 < i10; i11++) {
                        this.f22944r.f22817a[i11] = 0;
                    }
                    this.f22944r.f22817a[i10] = -65;
                    m209a(i9, 0, 1);
                    int[] iArr = this.f22952z;
                    int i12 = this.f22951y;
                    this.f22951y = i12 + 1;
                    iArr[i12] = this.f22928b.m243c("java/lang/Throwable") | 24117248;
                    m200b();
                }
            }
        }
        this.f22945s = i8;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int i, String str, String str2, String str3) {
        int i2;
        boolean z = i == 185;
        Item m249a = i == 186 ? this.f22928b.m249a(str2, str3) : this.f22928b.m247a(str, str2, str3, z);
        int i3 = m249a.f22889c;
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, 0, this.f22928b, m249a);
            } else {
                if (i3 == 0) {
                    i2 = Type.getArgumentsAndReturnSizes(str3);
                    m249a.f22889c = i2;
                } else {
                    i2 = i3;
                }
                int i4 = (i == 184 || i == 186) ? (this.f22924Q - (i2 >> 2)) + (i2 & 3) + 1 : (this.f22924Q - (i2 >> 2)) + (i2 & 3);
                if (i4 > this.f22925R) {
                    this.f22925R = i4;
                }
                this.f22924Q = i4;
                i3 = i2;
            }
        }
        if (z) {
            if (i3 == 0) {
                i3 = Type.getArgumentsAndReturnSizes(str3);
                m249a.f22889c = i3;
            }
            this.f22944r.m267b(Opcodes.INVOKEINTERFACE, m249a.f22887a).m268a(i3 >> 2, 0);
            return;
        }
        this.f22944r.m267b(i, m249a.f22887a);
        if (i != 186) {
            return;
        }
        this.f22944r.putShort(0);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String str, int i) {
        Item m251a = this.f22928b.m251a(str);
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(197, i, this.f22928b, m251a);
            } else {
                this.f22924Q += 1 - i;
            }
        }
        this.f22944r.m267b(197, m251a.f22887a).putByte(i);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.f22926S = Math.max(this.f22926S, i + 1);
            return new AnnotationWriter(this.f22928b, false, byteVector, null, 0);
        }
        byteVector.putShort(this.f22928b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f22928b, true, byteVector, byteVector, 2);
        if (z) {
            if (this.f22941o == null) {
                this.f22941o = new AnnotationWriter[Type.getArgumentTypes(this.f22932f).length];
            }
            annotationWriter.f22813g = this.f22941o[i];
            this.f22941o[i] = annotationWriter;
            return annotationWriter;
        }
        if (this.f22942p == null) {
            this.f22942p = new AnnotationWriter[Type.getArgumentTypes(this.f22932f).length];
        }
        annotationWriter.f22813g = this.f22942p[i];
        this.f22942p[i] = annotationWriter;
        return annotationWriter;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitTableSwitchInsn(int i, int i2, Label label, Label[] labelArr) {
        int i3 = this.f22944r.f22818b;
        this.f22944r.putByte(170);
        this.f22944r.putByteArray(null, 0, (4 - (this.f22944r.f22818b % 4)) % 4);
        label.m213a(this, this.f22944r, i3, true);
        this.f22944r.putInt(i).putInt(i2);
        for (Label label2 : labelArr) {
            label2.m213a(this, this.f22944r, i3, true);
        }
        m205a(label, labelArr);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.f22908A++;
        Handler handler = new Handler();
        handler.f22881a = label;
        handler.f22882b = label2;
        handler.f22883c = label3;
        handler.f22884d = str;
        handler.f22885e = str != null ? this.f22928b.newClass(str) : 0;
        if (this.f22910C == null) {
            this.f22909B = handler;
        } else {
            this.f22910C.f22886f = handler;
        }
        this.f22910C = handler;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitTypeInsn(int i, String str) {
        Item m251a = this.f22928b.m251a(str);
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, this.f22944r.f22818b, this.f22928b, m251a);
            } else if (i == 187) {
                int i2 = this.f22924Q + 1;
                if (i2 > this.f22925R) {
                    this.f22925R = i2;
                }
                this.f22924Q = i2;
            }
        }
        this.f22944r.m267b(i, m251a.f22887a);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.MethodVisitor
    public void visitVarInsn(int i, int i2) {
        if (this.f22923P != null) {
            if (this.f22920M == 0) {
                this.f22923P.f22903h.m236a(i, i2, (ClassWriter) null, (Item) null);
            } else if (i == 169) {
                this.f22923P.f22896a |= 256;
                this.f22923P.f22901f = this.f22924Q;
                m194e();
            } else {
                int i3 = this.f22924Q + Frame.f22872a[i];
                if (i3 > this.f22925R) {
                    this.f22925R = i3;
                }
                this.f22924Q = i3;
            }
        }
        if (this.f22920M != 2) {
            int i4 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i4 > this.f22946t) {
                this.f22946t = i4;
            }
        }
        if (i2 < 4 && i != 169) {
            this.f22944r.putByte(i < 54 ? ((i - 21) << 2) + 26 + i2 : ((i - 54) << 2) + 59 + i2);
        } else if (i2 >= 256) {
            this.f22944r.putByte(SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING).m267b(i, i2);
        } else {
            this.f22944r.m268a(i, i2);
        }
        if (i < 54 || this.f22920M != 0 || this.f22908A <= 0) {
            return;
        }
        visitLabel(new Label());
    }
}
