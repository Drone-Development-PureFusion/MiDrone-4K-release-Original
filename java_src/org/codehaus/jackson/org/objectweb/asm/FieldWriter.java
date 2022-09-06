package org.codehaus.jackson.org.objectweb.asm;

import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class FieldWriter implements FieldVisitor {

    /* renamed from: a */
    FieldWriter f22862a;

    /* renamed from: b */
    private final ClassWriter f22863b;

    /* renamed from: c */
    private final int f22864c;

    /* renamed from: d */
    private final int f22865d;

    /* renamed from: e */
    private final int f22866e;

    /* renamed from: f */
    private int f22867f;

    /* renamed from: g */
    private int f22868g;

    /* renamed from: h */
    private AnnotationWriter f22869h;

    /* renamed from: i */
    private AnnotationWriter f22870i;

    /* renamed from: j */
    private Attribute f22871j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldWriter(ClassWriter classWriter, int i, String str, String str2, String str3, Object obj) {
        if (classWriter.f22857y == null) {
            classWriter.f22857y = this;
        } else {
            classWriter.f22858z.f22862a = this;
        }
        classWriter.f22858z = this;
        this.f22863b = classWriter;
        this.f22864c = i;
        this.f22865d = classWriter.newUTF8(str);
        this.f22866e = classWriter.newUTF8(str2);
        if (str3 != null) {
            this.f22867f = classWriter.newUTF8(str3);
        }
        if (obj != null) {
            this.f22868g = classWriter.m252a(obj).f22887a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m241a() {
        int i;
        int i2 = 8;
        if (this.f22868g != 0) {
            this.f22863b.newUTF8("ConstantValue");
            i2 = 16;
        }
        if ((this.f22864c & 4096) != 0 && ((this.f22863b.f22834b & 65535) < 49 || (this.f22864c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            this.f22863b.newUTF8("Synthetic");
            i2 += 6;
        }
        if ((this.f22864c & 131072) != 0) {
            this.f22863b.newUTF8("Deprecated");
            i2 += 6;
        }
        if (this.f22867f != 0) {
            this.f22863b.newUTF8(Consts.SIGNATURE);
            i2 += 8;
        }
        if (this.f22869h != null) {
            this.f22863b.newUTF8("RuntimeVisibleAnnotations");
            i2 += this.f22869h.m275a() + 8;
        }
        if (this.f22870i != null) {
            this.f22863b.newUTF8("RuntimeInvisibleAnnotations");
            i = i2 + this.f22870i.m275a() + 8;
        } else {
            i = i2;
        }
        return this.f22871j != null ? i + this.f22871j.m271a(this.f22863b, null, 0, -1, -1) : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m240a(ByteVector byteVector) {
        byteVector.putShort(((393216 | ((this.f22864c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) / 64)) ^ (-1)) & this.f22864c).putShort(this.f22865d).putShort(this.f22866e);
        int i = this.f22868g != 0 ? 1 : 0;
        if ((this.f22864c & 4096) != 0 && ((this.f22863b.f22834b & 65535) < 49 || (this.f22864c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            i++;
        }
        if ((this.f22864c & 131072) != 0) {
            i++;
        }
        if (this.f22867f != 0) {
            i++;
        }
        if (this.f22869h != null) {
            i++;
        }
        if (this.f22870i != null) {
            i++;
        }
        if (this.f22871j != null) {
            i += this.f22871j.m272a();
        }
        byteVector.putShort(i);
        if (this.f22868g != 0) {
            byteVector.putShort(this.f22863b.newUTF8("ConstantValue"));
            byteVector.putInt(2).putShort(this.f22868g);
        }
        if ((this.f22864c & 4096) != 0 && ((this.f22863b.f22834b & 65535) < 49 || (this.f22864c & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            byteVector.putShort(this.f22863b.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.f22864c & 131072) != 0) {
            byteVector.putShort(this.f22863b.newUTF8("Deprecated")).putInt(0);
        }
        if (this.f22867f != 0) {
            byteVector.putShort(this.f22863b.newUTF8(Consts.SIGNATURE));
            byteVector.putInt(2).putShort(this.f22867f);
        }
        if (this.f22869h != null) {
            byteVector.putShort(this.f22863b.newUTF8("RuntimeVisibleAnnotations"));
            this.f22869h.m274a(byteVector);
        }
        if (this.f22870i != null) {
            byteVector.putShort(this.f22863b.newUTF8("RuntimeInvisibleAnnotations"));
            this.f22870i.m274a(byteVector);
        }
        if (this.f22871j != null) {
            this.f22871j.m270a(this.f22863b, null, 0, -1, -1, byteVector);
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.FieldVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f22863b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f22863b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f22813g = this.f22869h;
            this.f22869h = annotationWriter;
        } else {
            annotationWriter.f22813g = this.f22870i;
            this.f22870i = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.FieldVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.f22815a = this.f22871j;
        this.f22871j = attribute;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.FieldVisitor
    public void visitEnd() {
    }
}
