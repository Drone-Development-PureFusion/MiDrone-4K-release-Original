package com.p080b;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* renamed from: com.b.be */
/* loaded from: classes.dex */
public class C1457be {

    /* renamed from: a */
    private ByteArrayInputStream f5059a;

    /* renamed from: b */
    private long f5060b;

    /* renamed from: c */
    private boolean f5061c;

    /* renamed from: d */
    private RandomAccessFile f5062d;

    /* renamed from: e */
    private boolean f5063e = false;

    /* renamed from: f */
    private final byte[] f5064f = new byte[8];

    /* renamed from: g */
    private C1458a f5065g;

    /* renamed from: h */
    private String f5066h;

    /* renamed from: com.b.be$a */
    /* loaded from: classes.dex */
    public static class C1458a {

        /* renamed from: a */
        public boolean f5067a = true;

        /* renamed from: b */
        public boolean f5068b = true;
    }

    public C1457be(File file, C1458a c1458a) {
        this.f5061c = false;
        this.f5062d = null;
        this.f5066h = null;
        if (c1458a != null) {
            if (c1458a.f5067a) {
                byte[] m16004a = C1477bs.m16004a(file);
                this.f5059a = new ByteArrayInputStream(m16004a);
                this.f5060b = m16004a.length;
                this.f5061c = false;
                this.f5066h = file.getAbsolutePath();
            } else {
                this.f5062d = new RandomAccessFile(file, "r");
                this.f5061c = true;
            }
            this.f5065g = c1458a;
        }
    }

    /* renamed from: h */
    private void m16117h() {
        if (this.f5063e) {
            throw new IOException("file closed");
        }
    }

    /* renamed from: a */
    public void m16124a(long j) {
        if (j < 0) {
            throw new IOException("offset < 0: " + j);
        }
        m16117h();
        if (this.f5061c) {
            this.f5062d.seek(j);
            return;
        }
        this.f5059a.reset();
        this.f5059a.skip(j);
    }

    /* renamed from: a */
    public boolean m16125a() {
        if (this.f5065g == null) {
            return false;
        }
        return this.f5065g.f5067a;
    }

    /* renamed from: b */
    public void m16123b() {
        synchronized (this) {
            if (!this.f5061c) {
                if (this.f5059a != null) {
                    this.f5059a.close();
                    this.f5059a = null;
                }
            } else if (this.f5062d != null) {
                this.f5062d.close();
                this.f5062d = null;
            }
            this.f5063e = true;
        }
    }

    /* renamed from: c */
    public final long m16122c() {
        m16117h();
        if (this.f5061c) {
            return this.f5062d.readLong();
        }
        this.f5059a.read(this.f5064f);
        return C1477bs.m15991b(this.f5064f);
    }

    /* renamed from: d */
    public final int m16121d() {
        m16117h();
        if (this.f5061c) {
            return this.f5062d.readUnsignedShort();
        }
        this.f5059a.read(this.f5064f, 0, 2);
        return C1477bs.m15986c(this.f5064f);
    }

    /* renamed from: e */
    public final int m16120e() {
        m16117h();
        if (this.f5061c) {
            return this.f5062d.readInt();
        }
        this.f5059a.read(this.f5064f, 0, 4);
        return C1477bs.m15982d(this.f5064f);
    }

    /* renamed from: f */
    public final int m16119f() {
        m16117h();
        return this.f5061c ? this.f5062d.readUnsignedByte() : this.f5059a.read();
    }

    protected void finalize() {
        m16123b();
        super.finalize();
    }

    /* renamed from: g */
    public long m16118g() {
        if (this.f5063e) {
            throw new IOException("file closed");
        }
        return this.f5061c ? this.f5062d.length() : this.f5060b;
    }
}
