package org.codehaus.jackson.org.objectweb.asm;

import com.hoho.android.usbserial.driver.UsbId;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class ClassReader {
    public static final int EXPAND_FRAMES = 8;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    /* renamed from: a */
    private final int[] f22820a;

    /* renamed from: b */
    public final byte[] f22821b;

    /* renamed from: c */
    private final String[] f22822c;

    /* renamed from: d */
    private final int f22823d;
    public final int header;

    public ClassReader(InputStream inputStream) {
        this(m262a(inputStream));
    }

    public ClassReader(String str) {
        this(ClassLoader.getSystemResourceAsStream(new StringBuffer().append(str.replace(C0359h.f677G, '/')).append(".class").toString()));
    }

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        int readUnsignedShort;
        this.f22821b = bArr;
        this.f22820a = new int[readUnsignedShort(i + 8)];
        int length = this.f22820a.length;
        this.f22822c = new String[length];
        int i3 = 0;
        int i4 = 1;
        int i5 = i + 10;
        while (i4 < length) {
            this.f22820a[i4] = i5 + 1;
            switch (bArr[i5]) {
                case 1:
                    readUnsignedShort = readUnsignedShort(i5 + 1) + 3;
                    if (readUnsignedShort <= i3) {
                        break;
                    } else {
                        i3 = readUnsignedShort;
                        break;
                    }
                case 2:
                case 7:
                case 8:
                default:
                    readUnsignedShort = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    readUnsignedShort = 5;
                    break;
                case 5:
                case 6:
                    readUnsignedShort = 9;
                    i4++;
                    break;
            }
            i4++;
            i5 = readUnsignedShort + i5;
        }
        this.f22823d = i3;
        this.header = i5;
    }

    /* renamed from: a */
    private int m264a(int i, char[] cArr, String str, AnnotationVisitor annotationVisitor) {
        int i2 = 0;
        if (annotationVisitor == null) {
            switch (this.f22821b[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) {
                case 64:
                    return m263a(i + 3, cArr, true, (AnnotationVisitor) null);
                case 91:
                    return m263a(i + 1, cArr, false, (AnnotationVisitor) null);
                case 101:
                    return i + 5;
                default:
                    return i + 3;
            }
        }
        int i3 = i + 1;
        switch (this.f22821b[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) {
            case 64:
                return m263a(i3 + 2, cArr, true, annotationVisitor.visitAnnotation(str, readUTF8(i3, cArr)));
            case 66:
                annotationVisitor.visit(str, new Byte((byte) readInt(this.f22820a[readUnsignedShort(i3)])));
                return i3 + 2;
            case UsbId.ARDUINO_UNO_R3 /* 67 */:
                annotationVisitor.visit(str, new Character((char) readInt(this.f22820a[readUnsignedShort(i3)])));
                return i3 + 2;
            case 68:
            case 70:
            case 73:
            case 74:
                annotationVisitor.visit(str, readConst(readUnsignedShort(i3), cArr));
                return i3 + 2;
            case 83:
                annotationVisitor.visit(str, new Short((short) readInt(this.f22820a[readUnsignedShort(i3)])));
                return i3 + 2;
            case 90:
                annotationVisitor.visit(str, readInt(this.f22820a[readUnsignedShort(i3)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                return i3 + 2;
            case 91:
                int readUnsignedShort = readUnsignedShort(i3);
                int i4 = i3 + 2;
                if (readUnsignedShort == 0) {
                    return m263a(i4 - 2, cArr, false, annotationVisitor.visitArray(str));
                }
                int i5 = i4 + 1;
                switch (this.f22821b[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) {
                    case 66:
                        byte[] bArr = new byte[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            bArr[i2] = (byte) readInt(this.f22820a[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, bArr);
                        return i5 - 1;
                    case UsbId.ARDUINO_UNO_R3 /* 67 */:
                        char[] cArr2 = new char[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            cArr2[i2] = (char) readInt(this.f22820a[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, cArr2);
                        return i5 - 1;
                    case 68:
                        double[] dArr = new double[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            dArr[i2] = Double.longBitsToDouble(readLong(this.f22820a[readUnsignedShort(i5)]));
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, dArr);
                        return i5 - 1;
                    case 70:
                        float[] fArr = new float[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            fArr[i2] = Float.intBitsToFloat(readInt(this.f22820a[readUnsignedShort(i5)]));
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, fArr);
                        return i5 - 1;
                    case 73:
                        int[] iArr = new int[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            iArr[i2] = readInt(this.f22820a[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, iArr);
                        return i5 - 1;
                    case 74:
                        long[] jArr = new long[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            jArr[i2] = readLong(this.f22820a[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, jArr);
                        return i5 - 1;
                    case 83:
                        short[] sArr = new short[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            sArr[i2] = (short) readInt(this.f22820a[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, sArr);
                        return i5 - 1;
                    case 90:
                        boolean[] zArr = new boolean[readUnsignedShort];
                        int i6 = i5;
                        for (int i7 = 0; i7 < readUnsignedShort; i7++) {
                            zArr[i7] = readInt(this.f22820a[readUnsignedShort(i6)]) != 0;
                            i6 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                        return i6 - 1;
                    default:
                        return m263a(i5 - 3, cArr, false, annotationVisitor.visitArray(str));
                }
            case 99:
                annotationVisitor.visit(str, Type.getType(readUTF8(i3, cArr)));
                return i3 + 2;
            case 101:
                annotationVisitor.visitEnum(str, readUTF8(i3, cArr), readUTF8(i3 + 2, cArr));
                return i3 + 4;
            case Opcodes.DREM /* 115 */:
                annotationVisitor.visit(str, readUTF8(i3, cArr));
                return i3 + 2;
            default:
                return i3;
        }
    }

    /* renamed from: a */
    private int m263a(int i, char[] cArr, boolean z, AnnotationVisitor annotationVisitor) {
        int i2;
        int readUnsignedShort = readUnsignedShort(i);
        int i3 = i + 2;
        if (z) {
            i2 = i3;
            int i4 = readUnsignedShort;
            while (i4 > 0) {
                i4--;
                i2 = m264a(i2 + 2, cArr, readUTF8(i2, cArr), annotationVisitor);
            }
        } else {
            i2 = i3;
            int i5 = readUnsignedShort;
            while (i5 > 0) {
                i5--;
                i2 = m264a(i2, cArr, (String) null, annotationVisitor);
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i2;
    }

    /* renamed from: a */
    private int m260a(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i2 + 1;
        switch (this.f22821b[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) {
            case 0:
                objArr[i] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i] = readClass(i3, cArr);
                return i3 + 2;
            default:
                objArr[i] = readLabel(readUnsignedShort(i3), labelArr);
                return i3 + 2;
        }
    }

    /* renamed from: a */
    private String m266a(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i + i2;
        byte[] bArr = this.f22821b;
        char c = 0;
        char c2 = 0;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            switch (c2) {
                case 0:
                    int i7 = b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    if (i7 >= 128) {
                        if (i7 < 224 && i7 > 191) {
                            c = (char) (i7 & 31);
                            c2 = 1;
                            i3 = i5;
                            break;
                        } else {
                            c = (char) (i7 & 15);
                            c2 = 2;
                            i3 = i5;
                            break;
                        }
                    } else {
                        i3 = i5 + 1;
                        cArr[i5] = (char) i7;
                        break;
                    }
                case 1:
                    cArr[i5] = (char) ((b & 63) | (c << 6));
                    i3 = i5 + 1;
                    c2 = 0;
                    break;
                case 2:
                    c = (char) ((c << 6) | (b & 63));
                    c2 = 1;
                    i3 = i5;
                    break;
                default:
                    i3 = i5;
                    break;
            }
            i5 = i3;
            i = i6;
        }
        return new String(cArr, 0, i5);
    }

    /* renamed from: a */
    private Attribute m259a(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        for (int i4 = 0; i4 < attributeArr.length; i4++) {
            if (attributeArr[i4].type.equals(str)) {
                return attributeArr[i4].read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, null, -1, null);
    }

    /* renamed from: a */
    private void m265a(int i, String str, char[] cArr, boolean z, MethodVisitor methodVisitor) {
        int i2 = i + 1;
        int i3 = this.f22821b[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        int length = Type.getArgumentTypes(str).length - i3;
        int i4 = 0;
        while (i4 < length) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor.visitParameterAnnotation(i4, "Ljava/lang/Synthetic;", false);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
            i4++;
        }
        while (true) {
            int i5 = i4;
            if (i5 < i3 + length) {
                i2 += 2;
                for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
                    i2 = m263a(i2 + 2, cArr, true, methodVisitor.visitParameterAnnotation(i5, readUTF8(i2, cArr), z));
                }
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static byte[] m262a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        byte[] bArr = new byte[inputStream.available()];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                if (i >= bArr.length) {
                    return bArr;
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                return bArr2;
            }
            int i2 = read + i;
            if (i2 == bArr.length) {
                int read2 = inputStream.read();
                if (read2 < 0) {
                    return bArr;
                }
                byte[] bArr3 = new byte[bArr.length + 1000];
                System.arraycopy(bArr, 0, bArr3, 0, i2);
                i = i2 + 1;
                bArr3[i2] = (byte) read2;
                bArr = bArr3;
            } else {
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m261a(ClassWriter classWriter) {
        int i;
        char[] cArr = new char[this.f22823d];
        int length = this.f22820a.length;
        Item[] itemArr = new Item[length];
        int i2 = 1;
        while (i2 < length) {
            int i3 = this.f22820a[i2];
            byte b = this.f22821b[i3 - 1];
            Item item = new Item(i2);
            switch (b) {
                case 1:
                    String str = this.f22822c[i2];
                    if (str == null) {
                        int i4 = this.f22820a[i2];
                        String[] strArr = this.f22822c;
                        str = m266a(i4 + 2, readUnsignedShort(i4), cArr);
                        strArr[i2] = str;
                    }
                    item.m222a(b, str, null, null);
                    i = i2;
                    break;
                case 2:
                case 7:
                case 8:
                default:
                    item.m222a(b, readUTF8(i3, cArr), null, null);
                    i = i2;
                    break;
                case 3:
                    item.m223a(readInt(i3));
                    i = i2;
                    break;
                case 4:
                    item.m224a(Float.intBitsToFloat(readInt(i3)));
                    i = i2;
                    break;
                case 5:
                    item.m221a(readLong(i3));
                    i = i2 + 1;
                    break;
                case 6:
                    item.m225a(Double.longBitsToDouble(readLong(i3)));
                    i = i2 + 1;
                    break;
                case 9:
                case 10:
                case 11:
                    int i5 = this.f22820a[readUnsignedShort(i3 + 2)];
                    item.m222a(b, readClass(i3, cArr), readUTF8(i5, cArr), readUTF8(i5 + 2, cArr));
                    i = i2;
                    break;
                case 12:
                    item.m222a(b, readUTF8(i3, cArr), readUTF8(i3 + 2, cArr), null);
                    i = i2;
                    break;
            }
            int length2 = item.f22894j % itemArr.length;
            item.f22895k = itemArr[length2];
            itemArr[length2] = item;
            i2 = i + 1;
        }
        int i6 = this.f22820a[1] - 1;
        classWriter.f22836d.putByteArray(this.f22821b, i6, this.header - i6);
        classWriter.f22837e = itemArr;
        classWriter.f22838f = (int) (0.75d * length);
        classWriter.f22835c = length;
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        int i2;
        int i3;
        String[] strArr;
        Object[] objArr;
        Object[] objArr2;
        int i4;
        int i5;
        String readClass;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int readUnsignedShort;
        boolean z;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Attribute attribute;
        int i18;
        boolean z2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        Attribute attribute2;
        int i26;
        int i27;
        int i28;
        Attribute attribute3;
        int i29;
        int i30;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i31;
        Attribute attribute4;
        int i32;
        int i33;
        byte[] bArr = this.f22821b;
        char[] cArr = new char[this.f22823d];
        int i34 = 0;
        int i35 = 0;
        Attribute attribute5 = null;
        int i36 = this.header;
        int readUnsignedShort2 = readUnsignedShort(i36);
        String readClass2 = readClass(i36 + 2, cArr);
        int i37 = this.f22820a[readUnsignedShort(i36 + 4)];
        String readUTF8 = i37 == 0 ? null : readUTF8(i37, cArr);
        String[] strArr2 = new String[readUnsignedShort(i36 + 6)];
        int i38 = 0;
        int i39 = i36 + 8;
        int i40 = 0;
        while (true) {
            i2 = i39;
            if (i40 >= strArr2.length) {
                break;
            }
            strArr2[i40] = readClass(i2, cArr);
            i39 = i2 + 2;
            i40++;
        }
        boolean z3 = (i & 1) != 0;
        boolean z4 = (i & 2) != 0;
        boolean z5 = (i & 8) != 0;
        int i41 = i2 + 2;
        for (int readUnsignedShort3 = readUnsignedShort(i2); readUnsignedShort3 > 0; readUnsignedShort3--) {
            i41 += 8;
            for (int readUnsignedShort4 = readUnsignedShort(i41 + 6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i41 += readInt(i41 + 2) + 6;
            }
        }
        int readUnsignedShort5 = readUnsignedShort(i41);
        int i42 = i41 + 2;
        for (int i43 = readUnsignedShort5; i43 > 0; i43--) {
            i42 += 8;
            for (int readUnsignedShort6 = readUnsignedShort(i42 + 6); readUnsignedShort6 > 0; readUnsignedShort6--) {
                i42 += readInt(i42 + 2) + 6;
            }
        }
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        int readUnsignedShort7 = readUnsignedShort(i42);
        int i44 = i42 + 2;
        while (readUnsignedShort7 > 0) {
            String readUTF82 = readUTF8(i44, cArr);
            if ("SourceFile".equals(readUTF82)) {
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = readUTF8(i44 + 6, cArr);
                i31 = i38;
                attribute4 = attribute5;
                str = str11;
                i33 = i34;
                i32 = i35;
            } else if ("InnerClasses".equals(readUTF82)) {
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i44 + 6;
                attribute4 = attribute5;
                str = str11;
                i33 = i34;
                i32 = i35;
            } else if ("EnclosingMethod".equals(readUTF82)) {
                str3 = readClass(i44 + 6, cArr);
                int readUnsignedShort8 = readUnsignedShort(i44 + 8);
                if (readUnsignedShort8 != 0) {
                    str2 = readUTF8(this.f22820a[readUnsignedShort8], cArr);
                    str = readUTF8(this.f22820a[readUnsignedShort8] + 2, cArr);
                } else {
                    str = str11;
                    str2 = str10;
                }
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i32 = i35;
                i33 = i34;
            } else if (Consts.SIGNATURE.equals(readUTF82)) {
                str6 = readUTF8(i44 + 6, cArr);
                str = str11;
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i32 = i35;
                i33 = i34;
            } else if ("RuntimeVisibleAnnotations".equals(readUTF82)) {
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i33 = i44 + 6;
                str = str11;
                i32 = i35;
            } else if ("Deprecated".equals(readUTF82)) {
                readUnsignedShort2 |= 131072;
                str = str11;
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i32 = i35;
                i33 = i34;
            } else if ("Synthetic".equals(readUTF82)) {
                readUnsignedShort2 |= 266240;
                str = str11;
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i32 = i35;
                i33 = i34;
            } else if ("SourceDebugExtension".equals(readUTF82)) {
                int readInt = readInt(i44 + 2);
                str2 = str10;
                str3 = str9;
                str4 = m266a(i44 + 6, readInt, new char[readInt]);
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                str = str11;
                i33 = i34;
                i32 = i35;
            } else if ("RuntimeInvisibleAnnotations".equals(readUTF82)) {
                str2 = str10;
                str3 = str9;
                str4 = str8;
                str5 = str7;
                i31 = i38;
                attribute4 = attribute5;
                i33 = i34;
                str = str11;
                i32 = i44 + 6;
            } else {
                Attribute m259a = m259a(attributeArr, readUTF82, i44 + 6, readInt(i44 + 2), cArr, -1, null);
                if (m259a != null) {
                    m259a.f22815a = attribute5;
                    str2 = str10;
                    str3 = str9;
                    str4 = str8;
                    str5 = str7;
                    i31 = i38;
                    attribute4 = m259a;
                    str = str11;
                    i33 = i34;
                    i32 = i35;
                } else {
                    str = str11;
                    str2 = str10;
                    str3 = str9;
                    str4 = str8;
                    str5 = str7;
                    i31 = i38;
                    attribute4 = attribute5;
                    i32 = i35;
                    i33 = i34;
                }
            }
            str7 = str5;
            readUnsignedShort7--;
            i38 = i31;
            i44 += readInt(i44 + 2) + 6;
            attribute5 = attribute4;
            i35 = i32;
            i34 = i33;
            str8 = str4;
            str11 = str;
            str10 = str2;
            str9 = str3;
        }
        classVisitor.visit(readInt(4), readUnsignedShort2, readClass2, str6, readUTF8, strArr2);
        if (!z4 && (str7 != null || str8 != null)) {
            classVisitor.visitSource(str7, str8);
        }
        if (str9 != null) {
            classVisitor.visitOuterClass(str9, str10, str11);
        }
        int i45 = 1;
        while (i45 >= 0) {
            int i46 = i45 == 0 ? i35 : i34;
            if (i46 != 0) {
                int i47 = i46 + 2;
                int readUnsignedShort9 = readUnsignedShort(i46);
                while (readUnsignedShort9 > 0) {
                    readUnsignedShort9--;
                    i47 = m263a(i47 + 2, cArr, true, classVisitor.visitAnnotation(readUTF8(i47, cArr), i45 != 0));
                }
            }
            i45--;
        }
        while (attribute5 != null) {
            Attribute attribute6 = attribute5.f22815a;
            attribute5.f22815a = null;
            classVisitor.visitAttribute(attribute5);
            attribute5 = attribute6;
        }
        if (i38 != 0) {
            int readUnsignedShort10 = readUnsignedShort(i38);
            int i48 = i38 + 2;
            while (readUnsignedShort10 > 0) {
                classVisitor.visitInnerClass(readUnsignedShort(i48) == 0 ? null : readClass(i48, cArr), readUnsignedShort(i48 + 2) == 0 ? null : readClass(i48 + 2, cArr), readUnsignedShort(i48 + 4) == 0 ? null : readUTF8(i48 + 4, cArr), readUnsignedShort(i48 + 6));
                readUnsignedShort10--;
                i48 += 8;
            }
        }
        int i49 = i2 + 2;
        for (int readUnsignedShort11 = readUnsignedShort(i2); readUnsignedShort11 > 0; readUnsignedShort11--) {
            int readUnsignedShort12 = readUnsignedShort(i49);
            String readUTF83 = readUTF8(i49 + 2, cArr);
            String readUTF84 = readUTF8(i49 + 4, cArr);
            int i50 = 0;
            String str12 = null;
            int i51 = 0;
            int i52 = 0;
            Attribute attribute7 = null;
            int readUnsignedShort13 = readUnsignedShort(i49 + 6);
            i49 += 8;
            while (readUnsignedShort13 > 0) {
                String readUTF85 = readUTF8(i49, cArr);
                if ("ConstantValue".equals(readUTF85)) {
                    i27 = readUnsignedShort(i49 + 6);
                    i28 = readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i52;
                    i30 = i51;
                } else if (Consts.SIGNATURE.equals(readUTF85)) {
                    str12 = readUTF8(i49 + 6, cArr);
                    i27 = i50;
                    i28 = readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i52;
                    i30 = i51;
                } else if ("Deprecated".equals(readUTF85)) {
                    i28 = 131072 | readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i52;
                    i30 = i51;
                    i27 = i50;
                } else if ("Synthetic".equals(readUTF85)) {
                    i28 = 266240 | readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i52;
                    i30 = i51;
                    i27 = i50;
                } else if ("RuntimeVisibleAnnotations".equals(readUTF85)) {
                    i28 = readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i52;
                    i30 = i49 + 6;
                    i27 = i50;
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF85)) {
                    i28 = readUnsignedShort12;
                    attribute3 = attribute7;
                    i29 = i49 + 6;
                    i30 = i51;
                    i27 = i50;
                } else {
                    Attribute m259a2 = m259a(attributeArr, readUTF85, i49 + 6, readInt(i49 + 2), cArr, -1, null);
                    if (m259a2 != null) {
                        m259a2.f22815a = attribute7;
                        i28 = readUnsignedShort12;
                        attribute3 = m259a2;
                        i29 = i52;
                        i30 = i51;
                        i27 = i50;
                    } else {
                        i27 = i50;
                        i28 = readUnsignedShort12;
                        attribute3 = attribute7;
                        i29 = i52;
                        i30 = i51;
                    }
                }
                i50 = i27;
                readUnsignedShort13--;
                readUnsignedShort12 = i28;
                i49 += readInt(i49 + 2) + 6;
                attribute7 = attribute3;
                i52 = i29;
                i51 = i30;
            }
            FieldVisitor visitField = classVisitor.visitField(readUnsignedShort12, readUTF83, readUTF84, str12, i50 == 0 ? null : readConst(i50, cArr));
            if (visitField != null) {
                int i53 = 1;
                while (i53 >= 0) {
                    int i54 = i53 == 0 ? i52 : i51;
                    if (i54 != 0) {
                        int i55 = i54 + 2;
                        int readUnsignedShort14 = readUnsignedShort(i54);
                        while (readUnsignedShort14 > 0) {
                            readUnsignedShort14--;
                            i55 = m263a(i55 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i55, cArr), i53 != 0));
                        }
                    }
                    i53--;
                }
                while (attribute7 != null) {
                    Attribute attribute8 = attribute7.f22815a;
                    attribute7.f22815a = null;
                    visitField.visitAttribute(attribute7);
                    attribute7 = attribute8;
                }
                visitField.visitEnd();
            }
        }
        int i56 = i49 + 2;
        for (int readUnsignedShort15 = readUnsignedShort(i49); readUnsignedShort15 > 0; readUnsignedShort15--) {
            int i57 = i56 + 6;
            int readUnsignedShort16 = readUnsignedShort(i56);
            String readUTF86 = readUTF8(i56 + 2, cArr);
            String readUTF87 = readUTF8(i56 + 4, cArr);
            String str13 = null;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            Attribute attribute9 = null;
            int i63 = 0;
            int i64 = 0;
            int readUnsignedShort17 = readUnsignedShort(i56 + 6);
            i56 += 8;
            while (readUnsignedShort17 > 0) {
                String readUTF88 = readUTF8(i56, cArr);
                int readInt2 = readInt(i56 + 2);
                int i65 = i56 + 6;
                if ("Code".equals(readUTF88)) {
                    if (!z3) {
                        i26 = i62;
                        i19 = i61;
                        i20 = i60;
                        i21 = i64;
                        i22 = i65;
                        i23 = readUnsignedShort16;
                        attribute2 = attribute9;
                        i24 = i59;
                        i25 = i58;
                    }
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i59;
                    i25 = i58;
                } else if ("Exceptions".equals(readUTF88)) {
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i65;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i59;
                    i25 = i58;
                } else if (Consts.SIGNATURE.equals(readUTF88)) {
                    str13 = readUTF8(i65, cArr);
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i59;
                    i25 = i58;
                } else if ("Deprecated".equals(readUTF88)) {
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = 131072 | readUnsignedShort16;
                    i24 = i59;
                    i25 = i58;
                    i26 = i62;
                    attribute2 = attribute9;
                } else if ("RuntimeVisibleAnnotations".equals(readUTF88)) {
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i59;
                    i25 = i65;
                } else if ("AnnotationDefault".equals(readUTF88)) {
                    i26 = i62;
                    i19 = i61;
                    i20 = i65;
                    i21 = i64;
                    i22 = i63;
                    i25 = i58;
                    attribute2 = attribute9;
                    i24 = i59;
                    i23 = readUnsignedShort16;
                } else if ("Synthetic".equals(readUTF88)) {
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = 266240 | readUnsignedShort16;
                    i24 = i59;
                    i25 = i58;
                    i26 = i62;
                    attribute2 = attribute9;
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF88)) {
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i65;
                    i25 = i58;
                } else if ("RuntimeVisibleParameterAnnotations".equals(readUTF88)) {
                    i26 = i62;
                    i19 = i65;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i24 = i59;
                    attribute2 = attribute9;
                    i23 = readUnsignedShort16;
                    i25 = i58;
                } else if ("RuntimeInvisibleParameterAnnotations".equals(readUTF88)) {
                    i26 = i65;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    attribute2 = attribute9;
                    i23 = readUnsignedShort16;
                    i24 = i59;
                    i25 = i58;
                } else {
                    Attribute m259a3 = m259a(attributeArr, readUTF88, i65, readInt2, cArr, -1, null);
                    if (m259a3 != null) {
                        m259a3.f22815a = attribute9;
                        i19 = i61;
                        i20 = i60;
                        i21 = i64;
                        i22 = i63;
                        i23 = readUnsignedShort16;
                        i24 = i59;
                        i25 = i58;
                        int i66 = i62;
                        attribute2 = m259a3;
                        i26 = i66;
                    }
                    i26 = i62;
                    i19 = i61;
                    i20 = i60;
                    i21 = i64;
                    i22 = i63;
                    i23 = readUnsignedShort16;
                    attribute2 = attribute9;
                    i24 = i59;
                    i25 = i58;
                }
                readUnsignedShort17--;
                i63 = i22;
                readUnsignedShort16 = i23;
                i56 = readInt2 + i65;
                attribute9 = attribute2;
                i59 = i24;
                i58 = i25;
                i62 = i26;
                i64 = i21;
                i61 = i19;
                i60 = i20;
            }
            if (i64 == 0) {
                i3 = i64;
                strArr = null;
            } else {
                String[] strArr3 = new String[readUnsignedShort(i64)];
                i3 = i64 + 2;
                for (int i67 = 0; i67 < strArr3.length; i67++) {
                    strArr3[i67] = readClass(i3, cArr);
                    i3 += 2;
                }
                strArr = strArr3;
            }
            MethodVisitor visitMethod = classVisitor.visitMethod(readUnsignedShort16, readUTF86, readUTF87, str13, strArr);
            if (visitMethod != null) {
                if (visitMethod instanceof MethodWriter) {
                    MethodWriter methodWriter = (MethodWriter) visitMethod;
                    if (methodWriter.f22928b.f22833J == this && str13 == methodWriter.f22933g) {
                        boolean z6 = false;
                        if (strArr == null) {
                            z2 = methodWriter.f22936j == 0;
                        } else {
                            if (strArr.length == methodWriter.f22936j) {
                                z6 = true;
                                int i68 = i3;
                                for (int length = strArr.length - 1; length >= 0; length--) {
                                    i68 -= 2;
                                    if (methodWriter.f22937k[length] != readUnsignedShort(i68)) {
                                        z2 = false;
                                    }
                                }
                            }
                            z2 = z6;
                        }
                        if (z2) {
                            methodWriter.f22934h = i57;
                            methodWriter.f22935i = i56 - i57;
                        }
                    }
                }
                if (i60 != 0) {
                    AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
                    m264a(i60, cArr, (String) null, visitAnnotationDefault);
                    if (visitAnnotationDefault != null) {
                        visitAnnotationDefault.visitEnd();
                    }
                }
                int i69 = 1;
                while (i69 >= 0) {
                    int i70 = i69 == 0 ? i59 : i58;
                    if (i70 != 0) {
                        int i71 = i70 + 2;
                        int readUnsignedShort18 = readUnsignedShort(i70);
                        while (readUnsignedShort18 > 0) {
                            readUnsignedShort18--;
                            i71 = m263a(i71 + 2, cArr, true, visitMethod.visitAnnotation(readUTF8(i71, cArr), i69 != 0));
                        }
                    }
                    i69--;
                }
                if (i61 != 0) {
                    m265a(i61, readUTF87, cArr, true, visitMethod);
                }
                if (i62 != 0) {
                    m265a(i62, readUTF87, cArr, false, visitMethod);
                }
                while (attribute9 != null) {
                    Attribute attribute10 = attribute9.f22815a;
                    attribute9.f22815a = null;
                    visitMethod.visitAttribute(attribute9);
                    attribute9 = attribute10;
                }
            }
            if (visitMethod != null && i63 != 0) {
                int readUnsignedShort19 = readUnsignedShort(i63);
                int readUnsignedShort20 = readUnsignedShort(i63 + 2);
                int readInt3 = readInt(i63 + 4);
                int i72 = i63 + 8;
                int i73 = i72 + readInt3;
                visitMethod.visitCode();
                Label[] labelArr = new Label[readInt3 + 2];
                readLabel(readInt3 + 1, labelArr);
                int i74 = i72;
                while (i74 < i73) {
                    int i75 = i74 - i72;
                    switch (ClassWriter.f22824a[bArr[i74] & SmileConstants.BYTE_MARKER_END_OF_CONTENT]) {
                        case 0:
                        case 4:
                            i18 = i74 + 1;
                            break;
                        case 1:
                        case 3:
                        case 10:
                            i18 = i74 + 2;
                            break;
                        case 2:
                        case 5:
                        case 6:
                        case 11:
                        case 12:
                            i18 = i74 + 3;
                            break;
                        case 7:
                            i18 = i74 + 5;
                            break;
                        case 8:
                            readLabel(readShort(i74 + 1) + i75, labelArr);
                            i18 = i74 + 3;
                            break;
                        case 9:
                            readLabel(readInt(i74 + 1) + i75, labelArr);
                            i18 = i74 + 5;
                            break;
                        case 13:
                            int i76 = (i74 + 4) - (i75 & 3);
                            readLabel(readInt(i76) + i75, labelArr);
                            i18 = i76 + 12;
                            int readInt4 = (readInt(i76 + 8) - readInt(i76 + 4)) + 1;
                            while (readInt4 > 0) {
                                readLabel(readInt(i18) + i75, labelArr);
                                readInt4--;
                                i18 += 4;
                            }
                            break;
                        case 14:
                            int i77 = (i74 + 4) - (i75 & 3);
                            readLabel(readInt(i77) + i75, labelArr);
                            i18 = i77 + 8;
                            int readInt5 = readInt(i77 + 4);
                            while (readInt5 > 0) {
                                readLabel(readInt(i18 + 4) + i75, labelArr);
                                readInt5--;
                                i18 += 8;
                            }
                            break;
                        case 15:
                        default:
                            i18 = i74 + 4;
                            break;
                        case 16:
                            if ((bArr[i74 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 132) {
                                i18 = i74 + 6;
                                break;
                            } else {
                                i18 = i74 + 4;
                                break;
                            }
                    }
                    i74 = i18;
                }
                int i78 = i74 + 2;
                for (int readUnsignedShort21 = readUnsignedShort(i74); readUnsignedShort21 > 0; readUnsignedShort21--) {
                    Label readLabel = readLabel(readUnsignedShort(i78), labelArr);
                    Label readLabel2 = readLabel(readUnsignedShort(i78 + 2), labelArr);
                    Label readLabel3 = readLabel(readUnsignedShort(i78 + 4), labelArr);
                    int readUnsignedShort22 = readUnsignedShort(i78 + 6);
                    if (readUnsignedShort22 == 0) {
                        visitMethod.visitTryCatchBlock(readLabel, readLabel2, readLabel3, null);
                    } else {
                        visitMethod.visitTryCatchBlock(readLabel, readLabel2, readLabel3, readUTF8(this.f22820a[readUnsignedShort22], cArr));
                    }
                    i78 += 8;
                }
                int i79 = 0;
                int i80 = 0;
                int i81 = 0;
                int i82 = 0;
                int i83 = 0;
                int i84 = 0;
                boolean z7 = true;
                Attribute attribute11 = null;
                int readUnsignedShort23 = readUnsignedShort(i78);
                int i85 = i78 + 2;
                while (readUnsignedShort23 > 0) {
                    String readUTF89 = readUTF8(i85, cArr);
                    if ("LocalVariableTable".equals(readUTF89)) {
                        if (!z4) {
                            int i86 = i85 + 6;
                            int i87 = i85 + 8;
                            for (int readUnsignedShort24 = readUnsignedShort(i85 + 6); readUnsignedShort24 > 0; readUnsignedShort24--) {
                                int readUnsignedShort25 = readUnsignedShort(i87);
                                if (labelArr[readUnsignedShort25] == null) {
                                    readLabel(readUnsignedShort25, labelArr).f22896a |= 1;
                                }
                                int readUnsignedShort26 = readUnsignedShort25 + readUnsignedShort(i87 + 2);
                                if (labelArr[readUnsignedShort26] == null) {
                                    readLabel(readUnsignedShort26, labelArr).f22896a |= 1;
                                }
                                i87 += 10;
                            }
                            i15 = i83;
                            i13 = i82;
                            i16 = i81;
                            i14 = i80;
                            i17 = i86;
                            z = z7;
                        }
                        z = z7;
                        i15 = i83;
                        i13 = i82;
                        i16 = i81;
                        i14 = i80;
                        i17 = i79;
                    } else if ("LocalVariableTypeTable".equals(readUTF89)) {
                        i15 = i83;
                        i13 = i82;
                        i16 = i81;
                        i14 = i85 + 6;
                        z = z7;
                        i17 = i79;
                    } else {
                        if ("LineNumberTable".equals(readUTF89)) {
                            if (!z4) {
                                int i88 = i85 + 8;
                                for (int readUnsignedShort27 = readUnsignedShort(i85 + 6); readUnsignedShort27 > 0; readUnsignedShort27--) {
                                    int readUnsignedShort28 = readUnsignedShort(i88);
                                    if (labelArr[readUnsignedShort28] == null) {
                                        readLabel(readUnsignedShort28, labelArr).f22896a |= 1;
                                    }
                                    labelArr[readUnsignedShort28].f22897b = readUnsignedShort(i88 + 2);
                                    i88 += 4;
                                }
                            }
                        } else if ("StackMapTable".equals(readUTF89)) {
                            if ((i & 4) == 0) {
                                i16 = i85 + 8;
                                i14 = i80;
                                i17 = i79;
                                i13 = readInt(i85 + 2);
                                i15 = readUnsignedShort(i85 + 6);
                                z = z7;
                            }
                        } else if (!"StackMap".equals(readUTF89)) {
                            int i89 = 0;
                            Attribute attribute12 = attribute11;
                            while (i89 < attributeArr.length) {
                                if (!attributeArr[i89].type.equals(readUTF89) || (attribute = attributeArr[i89].read(this, i85 + 6, readInt(i85 + 2), cArr, i72 - 8, labelArr)) == null) {
                                    attribute = attribute12;
                                } else {
                                    attribute.f22815a = attribute12;
                                }
                                i89++;
                                attribute12 = attribute;
                            }
                            z = z7;
                            i13 = i82;
                            attribute11 = attribute12;
                            i14 = i80;
                            i15 = i83;
                            i16 = i81;
                            i17 = i79;
                        } else if ((i & 4) == 0) {
                            i16 = i85 + 8;
                            i13 = readInt(i85 + 2);
                            i15 = readUnsignedShort(i85 + 6);
                            z = false;
                            i14 = i80;
                            i17 = i79;
                        }
                        z = z7;
                        i15 = i83;
                        i13 = i82;
                        i16 = i81;
                        i14 = i80;
                        i17 = i79;
                    }
                    z7 = z;
                    i80 = i14;
                    i79 = i17;
                    readUnsignedShort23--;
                    i85 += readInt(i85 + 2) + 6;
                    i82 = i13;
                    i81 = i16;
                    i83 = i15;
                }
                if (i81 != 0) {
                    Object[] objArr3 = new Object[readUnsignedShort20];
                    objArr = new Object[readUnsignedShort19];
                    if (z5) {
                        if ((readUnsignedShort16 & 8) != 0) {
                            i12 = 0;
                        } else if ("<init>".equals(readUTF86)) {
                            i12 = 1;
                            objArr3[0] = Opcodes.UNINITIALIZED_THIS;
                        } else {
                            i12 = 1;
                            objArr3[0] = readClass(this.header + 2, cArr);
                        }
                        int i90 = 1;
                        while (true) {
                            int i91 = i90 + 1;
                            switch (readUTF87.charAt(i90)) {
                                case 'B':
                                case UsbId.ARDUINO_UNO_R3 /* 67 */:
                                case 'I':
                                case 'S':
                                case 'Z':
                                    objArr3[i12] = Opcodes.INTEGER;
                                    i12++;
                                    i90 = i91;
                                case 'D':
                                    objArr3[i12] = Opcodes.DOUBLE;
                                    i12++;
                                    i90 = i91;
                                case 'F':
                                    objArr3[i12] = Opcodes.FLOAT;
                                    i12++;
                                    i90 = i91;
                                case 'J':
                                    objArr3[i12] = Opcodes.LONG;
                                    i12++;
                                    i90 = i91;
                                case 'L':
                                    while (readUTF87.charAt(i91) != ';') {
                                        i91++;
                                    }
                                    int i92 = i90 + 1;
                                    i90 = i91 + 1;
                                    objArr3[i12] = readUTF87.substring(i92, i91);
                                    i12++;
                                case '[':
                                    while (readUTF87.charAt(i91) == '[') {
                                        i91++;
                                    }
                                    if (readUTF87.charAt(i91) == 'L') {
                                        int i93 = i91 + 1;
                                        while (readUTF87.charAt(i93) != ';') {
                                            i93++;
                                        }
                                        i91 = i93;
                                    }
                                    int i94 = i91 + 1;
                                    objArr3[i12] = readUTF87.substring(i90, i94);
                                    i12++;
                                    i90 = i94;
                            }
                        }
                    } else {
                        i12 = 0;
                    }
                    i4 = -1;
                    for (int i95 = i81; i95 < (i81 + i82) - 2; i95++) {
                        if (bArr[i95] == 8 && (readUnsignedShort = readUnsignedShort(i95 + 1)) >= 0 && readUnsignedShort < readInt3 && (bArr[i72 + readUnsignedShort] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 187) {
                            readLabel(readUnsignedShort, labelArr);
                        }
                    }
                    i84 = i12;
                    objArr2 = objArr3;
                } else {
                    objArr = null;
                    objArr2 = null;
                    i4 = 0;
                }
                Object[] objArr4 = objArr2;
                int i96 = 0;
                int i97 = 0;
                int i98 = i84;
                int i99 = i4;
                int i100 = 0;
                int i101 = i83;
                int i102 = i81;
                for (int i103 = i72; i103 < i73; i103 = i5) {
                    int i104 = i103 - i72;
                    Label label = labelArr[i104];
                    if (label != null) {
                        visitMethod.visitLabel(label);
                        if (!z4 && label.f22897b > 0) {
                            visitMethod.visitLineNumber(label.f22897b, label);
                        }
                    }
                    int i105 = i101;
                    while (objArr4 != null && (i99 == i104 || i99 == -1)) {
                        if (!z7 || z5) {
                            visitMethod.visitFrame(-1, i98, objArr4, i96, objArr);
                        } else if (i99 != -1) {
                            visitMethod.visitFrame(i100, i97, objArr4, i96, objArr);
                        }
                        if (i105 > 0) {
                            if (z7) {
                                i8 = i102 + 1;
                                i6 = bArr[i102] & 255;
                                i7 = i99;
                            } else {
                                i6 = 255;
                                i7 = -1;
                                i8 = i102;
                            }
                            int i106 = 0;
                            if (i6 < 64) {
                                i10 = 3;
                                i9 = 0;
                                i11 = i6;
                            } else if (i6 < 128) {
                                i11 = i6 - 64;
                                i8 = m260a(objArr, 0, i8, cArr, labelArr);
                                i10 = 4;
                                i9 = 1;
                            } else {
                                int readUnsignedShort29 = readUnsignedShort(i8);
                                i8 += 2;
                                if (i6 == 247) {
                                    i8 = m260a(objArr, 0, i8, cArr, labelArr);
                                    i10 = 4;
                                    i9 = 1;
                                    i11 = readUnsignedShort29;
                                } else if (i6 >= 248 && i6 < 251) {
                                    int i107 = 251 - i6;
                                    i98 -= i107;
                                    i10 = 2;
                                    i106 = i107;
                                    i9 = 0;
                                    i11 = readUnsignedShort29;
                                } else if (i6 == 251) {
                                    i10 = 3;
                                    i9 = 0;
                                    i11 = readUnsignedShort29;
                                } else if (i6 < 255) {
                                    int i108 = i8;
                                    int i109 = z5 ? i98 : 0;
                                    int i110 = i6 - 251;
                                    while (i110 > 0) {
                                        i108 = m260a(objArr4, i109, i108, cArr, labelArr);
                                        i110--;
                                        i109++;
                                    }
                                    int i111 = i6 - 251;
                                    i98 += i111;
                                    i10 = 1;
                                    i8 = i108;
                                    i106 = i111;
                                    i9 = 0;
                                    i11 = readUnsignedShort29;
                                } else {
                                    int readUnsignedShort30 = readUnsignedShort(i8);
                                    int i112 = i8 + 2;
                                    int i113 = 0;
                                    int i114 = readUnsignedShort30;
                                    while (i114 > 0) {
                                        i112 = m260a(objArr4, i113, i112, cArr, labelArr);
                                        i114--;
                                        i113++;
                                    }
                                    int readUnsignedShort31 = readUnsignedShort(i112);
                                    i8 = i112 + 2;
                                    int i115 = 0;
                                    int i116 = readUnsignedShort31;
                                    while (i116 > 0) {
                                        i8 = m260a(objArr, i115, i8, cArr, labelArr);
                                        i116--;
                                        i115++;
                                    }
                                    i9 = readUnsignedShort31;
                                    i106 = readUnsignedShort30;
                                    i10 = 0;
                                    i98 = readUnsignedShort30;
                                    i11 = readUnsignedShort29;
                                }
                            }
                            int i117 = i11 + 1 + i7;
                            readLabel(i117, labelArr);
                            i96 = i9;
                            i97 = i106;
                            i100 = i10;
                            i105--;
                            i99 = i117;
                            i102 = i8;
                        } else {
                            objArr4 = null;
                        }
                    }
                    int i118 = bArr[i103] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    switch (ClassWriter.f22824a[i118]) {
                        case 0:
                            visitMethod.visitInsn(i118);
                            i5 = i103 + 1;
                            break;
                        case 1:
                            visitMethod.visitIntInsn(i118, bArr[i103 + 1]);
                            i5 = i103 + 2;
                            break;
                        case 2:
                            visitMethod.visitIntInsn(i118, readShort(i103 + 1));
                            i5 = i103 + 3;
                            break;
                        case 3:
                            visitMethod.visitVarInsn(i118, bArr[i103 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                            i5 = i103 + 2;
                            break;
                        case 4:
                            if (i118 > 54) {
                                int i119 = i118 - 59;
                                visitMethod.visitVarInsn((i119 >> 2) + 54, i119 & 3);
                            } else {
                                int i120 = i118 - 26;
                                visitMethod.visitVarInsn((i120 >> 2) + 21, i120 & 3);
                            }
                            i5 = i103 + 1;
                            break;
                        case 5:
                            visitMethod.visitTypeInsn(i118, readClass(i103 + 1, cArr));
                            i5 = i103 + 3;
                            break;
                        case 6:
                        case 7:
                            int i121 = this.f22820a[readUnsignedShort(i103 + 1)];
                            if (i118 == 186) {
                                readClass = Opcodes.INVOKEDYNAMIC_OWNER;
                            } else {
                                readClass = readClass(i121, cArr);
                                i121 = this.f22820a[readUnsignedShort(i121 + 2)];
                            }
                            String readUTF810 = readUTF8(i121, cArr);
                            String readUTF811 = readUTF8(i121 + 2, cArr);
                            if (i118 < 182) {
                                visitMethod.visitFieldInsn(i118, readClass, readUTF810, readUTF811);
                            } else {
                                visitMethod.visitMethodInsn(i118, readClass, readUTF810, readUTF811);
                            }
                            if (i118 != 185 && i118 != 186) {
                                i5 = i103 + 3;
                                break;
                            } else {
                                i5 = i103 + 5;
                                break;
                            }
                        case 8:
                            visitMethod.visitJumpInsn(i118, labelArr[readShort(i103 + 1) + i104]);
                            i5 = i103 + 3;
                            break;
                        case 9:
                            visitMethod.visitJumpInsn(i118 - 33, labelArr[readInt(i103 + 1) + i104]);
                            i5 = i103 + 5;
                            break;
                        case 10:
                            visitMethod.visitLdcInsn(readConst(bArr[i103 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, cArr));
                            i5 = i103 + 2;
                            break;
                        case 11:
                            visitMethod.visitLdcInsn(readConst(readUnsignedShort(i103 + 1), cArr));
                            i5 = i103 + 3;
                            break;
                        case 12:
                            visitMethod.visitIincInsn(bArr[i103 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, bArr[i103 + 2]);
                            i5 = i103 + 3;
                            break;
                        case 13:
                            int i122 = (i103 + 4) - (i104 & 3);
                            int readInt6 = i104 + readInt(i122);
                            int readInt7 = readInt(i122 + 4);
                            int readInt8 = readInt(i122 + 8);
                            i5 = i122 + 12;
                            Label[] labelArr2 = new Label[(readInt8 - readInt7) + 1];
                            for (int i123 = 0; i123 < labelArr2.length; i123++) {
                                labelArr2[i123] = labelArr[readInt(i5) + i104];
                                i5 += 4;
                            }
                            visitMethod.visitTableSwitchInsn(readInt7, readInt8, labelArr[readInt6], labelArr2);
                            break;
                        case 14:
                            int i124 = (i103 + 4) - (i104 & 3);
                            int readInt9 = i104 + readInt(i124);
                            int readInt10 = readInt(i124 + 4);
                            i5 = i124 + 8;
                            int[] iArr = new int[readInt10];
                            Label[] labelArr3 = new Label[readInt10];
                            for (int i125 = 0; i125 < iArr.length; i125++) {
                                iArr[i125] = readInt(i5);
                                labelArr3[i125] = labelArr[readInt(i5 + 4) + i104];
                                i5 += 8;
                            }
                            visitMethod.visitLookupSwitchInsn(labelArr[readInt9], iArr, labelArr3);
                            break;
                        case 15:
                        default:
                            visitMethod.visitMultiANewArrayInsn(readClass(i103 + 1, cArr), bArr[i103 + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                            i5 = i103 + 4;
                            break;
                        case 16:
                            int i126 = bArr[i103 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                            if (i126 == 132) {
                                visitMethod.visitIincInsn(readUnsignedShort(i103 + 2), readShort(i103 + 4));
                                i5 = i103 + 6;
                                break;
                            } else {
                                visitMethod.visitVarInsn(i126, readUnsignedShort(i103 + 2));
                                i5 = i103 + 4;
                                break;
                            }
                    }
                    i101 = i105;
                }
                Label label2 = labelArr[i73 - i72];
                if (label2 != null) {
                    visitMethod.visitLabel(label2);
                }
                if (!z4 && i79 != 0) {
                    int[] iArr2 = null;
                    if (i80 != 0) {
                        int readUnsignedShort32 = readUnsignedShort(i80) * 3;
                        int i127 = i80 + 2;
                        iArr2 = new int[readUnsignedShort32];
                        while (readUnsignedShort32 > 0) {
                            int i128 = readUnsignedShort32 - 1;
                            iArr2[i128] = i127 + 6;
                            int i129 = i128 - 1;
                            iArr2[i129] = readUnsignedShort(i127 + 8);
                            readUnsignedShort32 = i129 - 1;
                            iArr2[readUnsignedShort32] = readUnsignedShort(i127);
                            i127 += 10;
                        }
                    }
                    int i130 = i79 + 2;
                    for (int readUnsignedShort33 = readUnsignedShort(i79); readUnsignedShort33 > 0; readUnsignedShort33--) {
                        int readUnsignedShort34 = readUnsignedShort(i130);
                        int readUnsignedShort35 = readUnsignedShort(i130 + 2);
                        int readUnsignedShort36 = readUnsignedShort(i130 + 8);
                        String str14 = null;
                        if (iArr2 != null) {
                            int i131 = 0;
                            while (true) {
                                if (i131 >= iArr2.length) {
                                    break;
                                } else if (iArr2[i131] == readUnsignedShort34 && iArr2[i131 + 1] == readUnsignedShort36) {
                                    str14 = readUTF8(iArr2[i131 + 2], cArr);
                                } else {
                                    i131 += 3;
                                }
                            }
                        }
                        visitMethod.visitLocalVariable(readUTF8(i130 + 4, cArr), readUTF8(i130 + 6, cArr), str14, labelArr[readUnsignedShort34], labelArr[readUnsignedShort34 + readUnsignedShort35], readUnsignedShort36);
                        i130 += 10;
                    }
                }
                while (attribute11 != null) {
                    Attribute attribute13 = attribute11.f22815a;
                    attribute11.f22815a = null;
                    visitMethod.visitAttribute(attribute11);
                    attribute11 = attribute13;
                }
                visitMethod.visitMaxs(readUnsignedShort19, readUnsignedShort20);
            }
            if (visitMethod != null) {
                visitMethod.visitEnd();
            }
        }
        classVisitor.visitEnd();
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.f22823d]);
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.f22823d];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i) {
        return this.f22820a[i];
    }

    public String getSuperName() {
        int i = this.f22820a[readUnsignedShort(this.header + 4)];
        if (i == 0) {
            return null;
        }
        return readUTF8(i, new char[this.f22823d]);
    }

    public int readByte(int i) {
        return this.f22821b[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.f22820a[readUnsignedShort(i)], cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.f22820a[i];
        switch (this.f22821b[i2 - 1]) {
            case 3:
                return new Integer(readInt(i2));
            case 4:
                return new Float(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return new Long(readLong(i2));
            case 6:
                return new Double(Double.longBitsToDouble(readLong(i2)));
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr));
            default:
                return readUTF8(i2, cArr);
        }
    }

    public int readInt(int i) {
        byte[] bArr = this.f22821b;
        return (bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }

    protected Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    public long readLong(int i) {
        return (readInt(i) << 32) | (readInt(i + 4) & 4294967295L);
    }

    public short readShort(int i) {
        byte[] bArr = this.f22821b;
        return (short) ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8));
    }

    public String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        String str = this.f22822c[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.f22820a[readUnsignedShort];
        String[] strArr = this.f22822c;
        String m266a = m266a(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = m266a;
        return m266a;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.f22821b;
        return (bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }
}
