package org.codehaus.jackson.org.objectweb.asm.signature;

import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class SignatureWriter implements SignatureVisitor {

    /* renamed from: a */
    private final StringBuffer f22958a = new StringBuffer();

    /* renamed from: b */
    private boolean f22959b;

    /* renamed from: c */
    private boolean f22960c;

    /* renamed from: d */
    private int f22961d;

    /* renamed from: a */
    private void m189a() {
        if (this.f22959b) {
            this.f22959b = false;
            this.f22958a.append('>');
        }
    }

    /* renamed from: b */
    private void m188b() {
        if (this.f22961d % 2 != 0) {
            this.f22958a.append('>');
        }
        this.f22961d /= 2;
    }

    public String toString() {
        return this.f22958a.toString();
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitArrayType() {
        this.f22958a.append('[');
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitBaseType(char c) {
        this.f22958a.append(c);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitClassBound() {
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitClassType(String str) {
        this.f22958a.append('L');
        this.f22958a.append(str);
        this.f22961d *= 2;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitEnd() {
        m188b();
        this.f22958a.append(';');
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitExceptionType() {
        this.f22958a.append('^');
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitFormalTypeParameter(String str) {
        if (!this.f22959b) {
            this.f22959b = true;
            this.f22958a.append('<');
        }
        this.f22958a.append(str);
        this.f22958a.append(C0359h.f671A);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitInnerClassType(String str) {
        m188b();
        this.f22958a.append(C0359h.f677G);
        this.f22958a.append(str);
        this.f22961d *= 2;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterface() {
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterfaceBound() {
        this.f22958a.append(C0359h.f671A);
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitParameterType() {
        m189a();
        if (!this.f22960c) {
            this.f22960c = true;
            this.f22958a.append(C0359h.f722s);
        }
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitReturnType() {
        m189a();
        if (!this.f22960c) {
            this.f22958a.append(C0359h.f722s);
        }
        this.f22958a.append(C0359h.f723t);
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitSuperclass() {
        m189a();
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitTypeArgument(char c) {
        if (this.f22961d % 2 == 0) {
            this.f22961d++;
            this.f22958a.append('<');
        }
        if (c != '=') {
            this.f22958a.append(c);
        }
        return this;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitTypeArgument() {
        if (this.f22961d % 2 == 0) {
            this.f22961d++;
            this.f22958a.append('<');
        }
        this.f22958a.append('*');
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor
    public void visitTypeVariable(String str) {
        this.f22958a.append('T');
        this.f22958a.append(str);
        this.f22958a.append(';');
    }
}
