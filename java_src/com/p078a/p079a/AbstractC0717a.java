package com.p078a.p079a;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
/* renamed from: com.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0717a implements AbstractC0749x {

    /* renamed from: a */
    private long f1717a;

    /* renamed from: b */
    private byte[] f1718b;

    /* renamed from: c */
    private byte[] f1719c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0717a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0717a(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0717a(String str, byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        this.f1717a = crc32.getValue();
        try {
            this.f1718b = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("FATAL: UTF-8 encoding not supported.", e);
        }
    }

    /* renamed from: g */
    private void m19337g() {
        if (this.f1718b == null) {
            return;
        }
        this.f1719c = new byte[this.f1718b.length + 5];
        this.f1719c[0] = 1;
        System.arraycopy(C0756z.m19129a(this.f1717a), 0, this.f1719c, 1, 4);
        System.arraycopy(this.f1718b, 0, this.f1719c, 5, this.f1718b.length);
    }

    /* renamed from: a */
    public void m19340a(long j) {
        this.f1717a = j;
        this.f1719c = null;
    }

    /* renamed from: a */
    public void m19339a(byte[] bArr) {
        if (bArr != null) {
            this.f1718b = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f1718b, 0, bArr.length);
        } else {
            this.f1718b = null;
        }
        this.f1719c = null;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        if (i2 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b = bArr[i];
        if (b != 1) {
            throw new ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        this.f1717a = C0756z.m19127a(bArr, i + 1);
        this.f1718b = new byte[i2 - 5];
        System.arraycopy(bArr, i + 5, this.f1718b, 0, i2 - 5);
        this.f1719c = null;
    }

    /* renamed from: b */
    public byte[] m19338b() {
        if (this.f1718b != null) {
            byte[] bArr = new byte[this.f1718b.length];
            System.arraycopy(this.f1718b, 0, bArr, 0, bArr.length);
            return bArr;
        }
        return null;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        if (this.f1719c == null) {
            m19337g();
        }
        if (this.f1719c != null) {
            byte[] bArr = new byte[this.f1719c.length];
            System.arraycopy(this.f1719c, 0, bArr, 0, bArr.length);
            return bArr;
        }
        return null;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        if (this.f1719c == null) {
            m19337g();
        }
        return new C0721ab(this.f1719c.length);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        return mo19163c();
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return mo19162d();
    }

    /* renamed from: i_ */
    public long m19336i_() {
        return this.f1717a;
    }
}
