package com.p078a.p079a;

import java.util.zip.ZipException;
/* renamed from: com.a.a.g */
/* loaded from: classes.dex */
public final class C0729g implements AbstractC0749x {

    /* renamed from: a */
    private static final C0721ab f1799a = new C0721ab(51966);

    /* renamed from: b */
    private static final C0721ab f1800b = new C0721ab(0);

    /* renamed from: c */
    private static final byte[] f1801c = new byte[0];

    /* renamed from: d */
    private static final C0729g f1802d = new C0729g();

    /* renamed from: b */
    public static C0729g m19234b() {
        return f1802d;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public C0721ab mo19165a() {
        return f1799a;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        return f1801c;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        return f1800b;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        return f1801c;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return f1800b;
    }
}
