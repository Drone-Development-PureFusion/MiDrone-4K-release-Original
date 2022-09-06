package org.codehaus.jackson.sym;
/* loaded from: classes2.dex */
public final class Name3 extends Name {
    final int mQuad1;
    final int mQuad2;
    final int mQuad3;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Name3(String str, int i, int i2, int i3, int i4) {
        super(str, i);
        this.mQuad1 = i2;
        this.mQuad2 = i3;
        this.mQuad3 = i4;
    }

    @Override // org.codehaus.jackson.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // org.codehaus.jackson.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // org.codehaus.jackson.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.mQuad1 && iArr[1] == this.mQuad2 && iArr[2] == this.mQuad3;
    }
}
