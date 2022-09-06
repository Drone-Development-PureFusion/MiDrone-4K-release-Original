package p069c.p071b;

import java.io.PrintWriter;
import java.io.StringWriter;
/* renamed from: c.b.k */
/* loaded from: classes.dex */
public class C0620k {

    /* renamed from: a */
    protected AbstractC0618i f1401a;

    /* renamed from: b */
    protected Throwable f1402b;

    public C0620k(AbstractC0618i abstractC0618i, Throwable th) {
        this.f1401a = abstractC0618i;
        this.f1402b = th;
    }

    /* renamed from: a */
    public AbstractC0618i m19871a() {
        return this.f1401a;
    }

    /* renamed from: b */
    public Throwable m19870b() {
        return this.f1402b;
    }

    /* renamed from: c */
    public String m19869c() {
        StringWriter stringWriter = new StringWriter();
        m19870b().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: d */
    public String m19868d() {
        return m19870b().getMessage();
    }

    /* renamed from: e */
    public boolean m19867e() {
        return m19870b() instanceof C0610b;
    }

    public String toString() {
        return this.f1401a + ": " + this.f1402b.getMessage();
    }
}
