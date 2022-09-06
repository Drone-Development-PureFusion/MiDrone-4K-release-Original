package org.codehaus.jackson.org.objectweb.asm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AnnotationWriter implements AnnotationVisitor {

    /* renamed from: a */
    private final ClassWriter f22807a;

    /* renamed from: b */
    private int f22808b;

    /* renamed from: c */
    private final boolean f22809c;

    /* renamed from: d */
    private final ByteVector f22810d;

    /* renamed from: e */
    private final ByteVector f22811e;

    /* renamed from: f */
    private final int f22812f;

    /* renamed from: g */
    AnnotationWriter f22813g;

    /* renamed from: h */
    AnnotationWriter f22814h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnotationWriter(ClassWriter classWriter, boolean z, ByteVector byteVector, ByteVector byteVector2, int i) {
        this.f22807a = classWriter;
        this.f22809c = z;
        this.f22810d = byteVector;
        this.f22811e = byteVector2;
        this.f22812f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m273a(AnnotationWriter[] annotationWriterArr, int i, ByteVector byteVector) {
        int length = ((annotationWriterArr.length - i) * 2) + 1;
        for (int i2 = i; i2 < annotationWriterArr.length; i2++) {
            length += annotationWriterArr[i2] == null ? 0 : annotationWriterArr[i2].m275a();
        }
        byteVector.putInt(length).putByte(annotationWriterArr.length - i);
        while (i < annotationWriterArr.length) {
            AnnotationWriter annotationWriter = annotationWriterArr[i];
            AnnotationWriter annotationWriter2 = null;
            int i3 = 0;
            while (annotationWriter != null) {
                i3++;
                annotationWriter.visitEnd();
                annotationWriter.f22814h = annotationWriter2;
                AnnotationWriter annotationWriter3 = annotationWriter;
                annotationWriter = annotationWriter.f22813g;
                annotationWriter2 = annotationWriter3;
            }
            byteVector.putShort(i3);
            while (annotationWriter2 != null) {
                byteVector.putByteArray(annotationWriter2.f22810d.f22817a, 0, annotationWriter2.f22810d.f22818b);
                annotationWriter2 = annotationWriter2.f22814h;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m275a() {
        int i = 0;
        while (this != null) {
            i += this.f22810d.f22818b;
            this = this.f22813g;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m274a(ByteVector byteVector) {
        AnnotationWriter annotationWriter = null;
        int i = 2;
        int i2 = 0;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.f22813g) {
            i2++;
            i += annotationWriter2.f22810d.f22818b;
            annotationWriter2.visitEnd();
            annotationWriter2.f22814h = annotationWriter;
            annotationWriter = annotationWriter2;
        }
        byteVector.putInt(i);
        byteVector.putShort(i2);
        while (annotationWriter != null) {
            byteVector.putByteArray(annotationWriter.f22810d.f22817a, 0, annotationWriter.f22810d.f22818b);
            annotationWriter = annotationWriter.f22814h;
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.AnnotationVisitor
    public void visit(String str, Object obj) {
        int i = 1;
        int i2 = 0;
        this.f22808b++;
        if (this.f22809c) {
            this.f22810d.putShort(this.f22807a.newUTF8(str));
        }
        if (obj instanceof String) {
            this.f22810d.m267b(Opcodes.DREM, this.f22807a.newUTF8((String) obj));
        } else if (obj instanceof Byte) {
            this.f22810d.m267b(66, this.f22807a.m256a((int) ((Byte) obj).byteValue()).f22887a);
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                i = 0;
            }
            this.f22810d.m267b(90, this.f22807a.m256a(i).f22887a);
        } else if (obj instanceof Character) {
            this.f22810d.m267b(67, this.f22807a.m256a((int) ((Character) obj).charValue()).f22887a);
        } else if (obj instanceof Short) {
            this.f22810d.m267b(83, this.f22807a.m256a((int) ((Short) obj).shortValue()).f22887a);
        } else if (obj instanceof Type) {
            this.f22810d.m267b(99, this.f22807a.newUTF8(((Type) obj).getDescriptor()));
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f22810d.m267b(91, bArr.length);
            while (i2 < bArr.length) {
                this.f22810d.m267b(66, this.f22807a.m256a((int) bArr[i2]).f22887a);
                i2++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f22810d.m267b(91, zArr.length);
            for (boolean z : zArr) {
                this.f22810d.m267b(90, this.f22807a.m256a(z ? 1 : 0).f22887a);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f22810d.m267b(91, sArr.length);
            while (i2 < sArr.length) {
                this.f22810d.m267b(83, this.f22807a.m256a((int) sArr[i2]).f22887a);
                i2++;
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f22810d.m267b(91, cArr.length);
            while (i2 < cArr.length) {
                this.f22810d.m267b(67, this.f22807a.m256a((int) cArr[i2]).f22887a);
                i2++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f22810d.m267b(91, iArr.length);
            while (i2 < iArr.length) {
                this.f22810d.m267b(73, this.f22807a.m256a(iArr[i2]).f22887a);
                i2++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f22810d.m267b(91, jArr.length);
            while (i2 < jArr.length) {
                this.f22810d.m267b(74, this.f22807a.m253a(jArr[i2]).f22887a);
                i2++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f22810d.m267b(91, fArr.length);
            while (i2 < fArr.length) {
                this.f22810d.m267b(70, this.f22807a.m257a(fArr[i2]).f22887a);
                i2++;
            }
        } else if (!(obj instanceof double[])) {
            Item m252a = this.f22807a.m252a(obj);
            this.f22810d.m267b(".s.IFJDCS".charAt(m252a.f22888b), m252a.f22887a);
        } else {
            double[] dArr = (double[]) obj;
            this.f22810d.m267b(91, dArr.length);
            while (i2 < dArr.length) {
                this.f22810d.m267b(68, this.f22807a.m258a(dArr[i2]).f22887a);
                i2++;
            }
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.AnnotationVisitor
    public AnnotationVisitor visitAnnotation(String str, String str2) {
        this.f22808b++;
        if (this.f22809c) {
            this.f22810d.putShort(this.f22807a.newUTF8(str));
        }
        this.f22810d.m267b(64, this.f22807a.newUTF8(str2)).putShort(0);
        return new AnnotationWriter(this.f22807a, true, this.f22810d, this.f22810d, this.f22810d.f22818b - 2);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.AnnotationVisitor
    public AnnotationVisitor visitArray(String str) {
        this.f22808b++;
        if (this.f22809c) {
            this.f22810d.putShort(this.f22807a.newUTF8(str));
        }
        this.f22810d.m267b(91, 0);
        return new AnnotationWriter(this.f22807a, false, this.f22810d, this.f22810d, this.f22810d.f22818b - 2);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.AnnotationVisitor
    public void visitEnd() {
        if (this.f22811e != null) {
            byte[] bArr = this.f22811e.f22817a;
            bArr[this.f22812f] = (byte) (this.f22808b >>> 8);
            bArr[this.f22812f + 1] = (byte) this.f22808b;
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.AnnotationVisitor
    public void visitEnum(String str, String str2, String str3) {
        this.f22808b++;
        if (this.f22809c) {
            this.f22810d.putShort(this.f22807a.newUTF8(str));
        }
        this.f22810d.m267b(101, this.f22807a.newUTF8(str2)).putShort(this.f22807a.newUTF8(str3));
    }
}
