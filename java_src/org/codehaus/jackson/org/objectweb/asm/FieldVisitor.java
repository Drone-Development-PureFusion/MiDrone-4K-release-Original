package org.codehaus.jackson.org.objectweb.asm;
/* loaded from: classes2.dex */
public interface FieldVisitor {
    AnnotationVisitor visitAnnotation(String str, boolean z);

    void visitAttribute(Attribute attribute);

    void visitEnd();
}
