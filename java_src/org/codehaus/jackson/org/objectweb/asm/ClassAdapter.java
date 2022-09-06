package org.codehaus.jackson.org.objectweb.asm;
/* loaded from: classes2.dex */
public class ClassAdapter implements ClassVisitor {

    /* renamed from: cv */
    protected ClassVisitor f22819cv;

    public ClassAdapter(ClassVisitor classVisitor) {
        this.f22819cv = classVisitor;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f22819cv.visit(i, i2, str, str2, str3, strArr);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        return this.f22819cv.visitAnnotation(str, z);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitAttribute(Attribute attribute) {
        this.f22819cv.visitAttribute(attribute);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitEnd() {
        this.f22819cv.visitEnd();
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        return this.f22819cv.visitField(i, str, str2, str3, obj);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitInnerClass(String str, String str2, String str3, int i) {
        this.f22819cv.visitInnerClass(str, str2, str3, i);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        return this.f22819cv.visitMethod(i, str, str2, str3, strArr);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitOuterClass(String str, String str2, String str3) {
        this.f22819cv.visitOuterClass(str, str2, str3);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitSource(String str, String str2) {
        this.f22819cv.visitSource(str, str2);
    }
}
