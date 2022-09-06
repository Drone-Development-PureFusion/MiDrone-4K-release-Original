package com.p078a.p079a;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
/* renamed from: com.a.a.b */
/* loaded from: classes.dex */
public class C0723b implements AbstractC0735l, AbstractC0749x, Cloneable {

    /* renamed from: h */
    private static final C0721ab f1773h = new C0721ab(30062);

    /* renamed from: i */
    private static final int f1774i = 4;

    /* renamed from: j */
    private int f1775j = 0;

    /* renamed from: k */
    private int f1776k = 0;

    /* renamed from: l */
    private int f1777l = 0;

    /* renamed from: m */
    private String f1778m = "";

    /* renamed from: n */
    private boolean f1779n = false;

    /* renamed from: o */
    private CRC32 f1780o = new CRC32();

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public C0721ab mo19165a() {
        return f1773h;
    }

    /* renamed from: a */
    public void m19264a(int i) {
        this.f1776k = i;
    }

    /* renamed from: a */
    public void m19263a(String str) {
        this.f1778m = str;
        this.f1775j = m19258d(this.f1775j);
    }

    /* renamed from: a */
    public void m19262a(boolean z) {
        this.f1779n = z;
        this.f1775j = m19258d(this.f1775j);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        boolean z = false;
        long m19127a = C0756z.m19127a(bArr, i);
        byte[] bArr2 = new byte[i2 - 4];
        System.arraycopy(bArr, i + 4, bArr2, 0, i2 - 4);
        this.f1780o.reset();
        this.f1780o.update(bArr2);
        long value = this.f1780o.getValue();
        if (m19127a != value) {
            throw new ZipException("bad CRC checksum " + Long.toHexString(m19127a) + " instead of " + Long.toHexString(value));
        }
        int m19278a = C0721ab.m19278a(bArr2, 0);
        byte[] bArr3 = new byte[(int) C0756z.m19127a(bArr2, 2)];
        this.f1776k = C0721ab.m19278a(bArr2, 6);
        this.f1777l = C0721ab.m19278a(bArr2, 8);
        if (bArr3.length == 0) {
            this.f1778m = "";
        } else {
            System.arraycopy(bArr2, 10, bArr3, 0, bArr3.length);
            this.f1778m = new String(bArr3);
        }
        if ((m19278a & 16384) != 0) {
            z = true;
        }
        m19262a(z);
        m19259c(m19278a);
    }

    /* renamed from: b */
    public int m19261b() {
        return this.f1776k;
    }

    /* renamed from: b */
    public void m19260b(int i) {
        this.f1777l = i;
    }

    /* renamed from: c */
    public void m19259c(int i) {
        this.f1775j = m19258d(i);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        return mo19161e();
    }

    public Object clone() {
        try {
            C0723b c0723b = (C0723b) super.clone();
            c0723b.f1780o = new CRC32();
            return c0723b;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: d */
    protected int m19258d(int i) {
        int i2 = 32768;
        if (m19255i()) {
            i2 = AbstractC0735l.f1811b;
        } else if (m19253k()) {
            i2 = 16384;
        }
        return i2 | (i & AbstractC0735l.f1810a);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        return mo19160f();
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        byte[] bArr = new byte[mo19160f().m19277b() - 4];
        System.arraycopy(C0721ab.m19280a(m19254j()), 0, bArr, 0, 2);
        byte[] bytes = m19256h().getBytes();
        System.arraycopy(C0756z.m19129a(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(C0721ab.m19280a(m19261b()), 0, bArr, 6, 2);
        System.arraycopy(C0721ab.m19280a(m19257g()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f1780o.reset();
        this.f1780o.update(bArr);
        long value = this.f1780o.getValue();
        byte[] bArr2 = new byte[bArr.length + 4];
        System.arraycopy(C0756z.m19129a(value), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return new C0721ab(m19256h().getBytes().length + 14);
    }

    /* renamed from: g */
    public int m19257g() {
        return this.f1777l;
    }

    /* renamed from: h */
    public String m19256h() {
        return this.f1778m;
    }

    /* renamed from: i */
    public boolean m19255i() {
        return m19256h().length() != 0;
    }

    /* renamed from: j */
    public int m19254j() {
        return this.f1775j;
    }

    /* renamed from: k */
    public boolean m19253k() {
        return this.f1779n && !m19255i();
    }
}
