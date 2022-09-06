package p004b.p005a.p006a.p028b.p050l;

import java.io.IOException;
import java.io.OutputStream;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0541a;
import p004b.p005a.p006a.p028b.p055p.C0542b;
/* renamed from: b.a.a.b.l.c */
/* loaded from: classes.dex */
public abstract class AbstractC0467c extends OutputStream {

    /* renamed from: a */
    static final int f1033a = 8;

    /* renamed from: b */
    protected OutputStream f1034b;

    /* renamed from: f */
    private AbstractC0292f f1038f;

    /* renamed from: g */
    private C0465a f1039g;

    /* renamed from: d */
    private int f1036d = 0;

    /* renamed from: e */
    private int f1037e = 0;

    /* renamed from: c */
    protected boolean f1035c = true;

    /* renamed from: a */
    private boolean m20428a() {
        return this.f1039g != null && !this.f1035c;
    }

    /* renamed from: b */
    private void m20424b() {
        if (this.f1039g != null) {
            this.f1039g = null;
            this.f1037e = 0;
            m20423b(new C0542b("Recovered from IO failure on " + mo20420c(), this));
        }
    }

    /* renamed from: a */
    public void m20427a(AbstractC0292f abstractC0292f) {
        this.f1038f = abstractC0292f;
    }

    /* renamed from: a */
    void m20426a(AbstractC0547g abstractC0547g) {
        this.f1037e++;
        if (this.f1037e < 8) {
            m20423b(abstractC0547g);
        }
        if (this.f1037e == 8) {
            m20423b(abstractC0547g);
            m20423b(new C0542b("Will supress future messages regarding " + mo20420c(), this));
        }
    }

    /* renamed from: a */
    void m20425a(IOException iOException) {
        m20426a(new C0541a("IO failure while writing to " + mo20420c(), this, iOException));
        this.f1035c = false;
        if (this.f1039g == null) {
            this.f1039g = new C0465a();
        }
    }

    /* renamed from: b */
    public void m20423b(AbstractC0547g abstractC0547g) {
        if (this.f1038f != null) {
            AbstractC0551k mo20997n = this.f1038f.mo20997n();
            if (mo20997n == null) {
                return;
            }
            mo20997n.mo20188a(abstractC0547g);
            return;
        }
        int i = this.f1036d;
        this.f1036d = i + 1;
        if (i != 0) {
            return;
        }
        System.out.println("LOGBACK: No context given for " + this);
    }

    /* renamed from: c */
    abstract String mo20420c();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f1034b != null) {
            this.f1034b.close();
        }
    }

    /* renamed from: d */
    abstract OutputStream mo20419d();

    /* renamed from: e */
    void m20422e() {
        try {
            close();
        } catch (IOException e) {
        }
        m20426a(new C0542b("Attempting to recover from IO failure on " + mo20420c(), this));
        try {
            this.f1034b = mo20419d();
            this.f1035c = true;
        } catch (IOException e2) {
            m20426a(new C0541a("Failed to open " + mo20420c(), this, e2));
        }
    }

    /* renamed from: f */
    public AbstractC0292f m20421f() {
        return this.f1038f;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (this.f1034b != null) {
            try {
                this.f1034b.flush();
                m20424b();
            } catch (IOException e) {
                m20425a(e);
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (m20428a()) {
            if (this.f1039g.m20434a()) {
                return;
            }
            m20422e();
            return;
        }
        try {
            this.f1034b.write(i);
            m20424b();
        } catch (IOException e) {
            m20425a(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (m20428a()) {
            if (this.f1039g.m20434a()) {
                return;
            }
            m20422e();
            return;
        }
        try {
            this.f1034b.write(bArr, i, i2);
            m20424b();
        } catch (IOException e) {
            m20425a(e);
        }
    }
}
