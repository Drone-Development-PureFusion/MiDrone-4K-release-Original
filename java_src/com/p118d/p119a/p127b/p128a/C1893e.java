package com.p118d.p119a.p127b.p128a;

import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.d.a.b.a.e */
/* loaded from: classes.dex */
public class C1893e {

    /* renamed from: a */
    private static final int f6669a = 9;

    /* renamed from: b */
    private static final String f6670b = "x";

    /* renamed from: c */
    private final int f6671c;

    /* renamed from: d */
    private final int f6672d;

    public C1893e(int i, int i2) {
        this.f6671c = i;
        this.f6672d = i2;
    }

    public C1893e(int i, int i2, int i3) {
        if (i3 % Opcodes.GETFIELD == 0) {
            this.f6671c = i;
            this.f6672d = i2;
            return;
        }
        this.f6671c = i2;
        this.f6672d = i;
    }

    /* renamed from: a */
    public int m14153a() {
        return this.f6671c;
    }

    /* renamed from: a */
    public C1893e m14152a(float f) {
        return new C1893e((int) (this.f6671c * f), (int) (this.f6672d * f));
    }

    /* renamed from: a */
    public C1893e m14151a(int i) {
        return new C1893e(this.f6671c / i, this.f6672d / i);
    }

    /* renamed from: b */
    public int m14150b() {
        return this.f6672d;
    }

    public String toString() {
        return new StringBuilder(9).append(this.f6671c).append(f6670b).append(this.f6672d).toString();
    }
}
