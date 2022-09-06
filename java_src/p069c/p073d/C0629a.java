package p069c.p073d;

import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import p069c.p071b.AbstractC0618i;
import p069c.p071b.AbstractC0621l;
import p069c.p071b.C0610b;
import p069c.p071b.C0620k;
import p069c.p071b.C0622m;
import p069c.p072c.AbstractC0626a;
/* renamed from: c.d.a */
/* loaded from: classes.dex */
public class C0629a implements AbstractC0621l {

    /* renamed from: a */
    PrintStream f1420a;

    /* renamed from: b */
    int f1421b = 0;

    public C0629a(PrintStream printStream) {
        this.f1420a = printStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19799a() {
        m19792b().println();
        m19792b().println("<RETURN> to continue");
    }

    /* renamed from: a */
    protected void m19798a(long j) {
        m19792b().println();
        m19792b().println("Time: " + m19791b(j));
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public void mo836a(AbstractC0618i abstractC0618i) {
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public void mo835a(AbstractC0618i abstractC0618i, C0610b c0610b) {
        m19792b().print("F");
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public void mo834a(AbstractC0618i abstractC0618i, Throwable th) {
        m19792b().print("E");
    }

    /* renamed from: a */
    protected void m19797a(C0620k c0620k) {
        m19792b().print(AbstractC0626a.m19809i(c0620k.m19869c()));
    }

    /* renamed from: a */
    public void m19796a(C0620k c0620k, int i) {
        m19790b(c0620k, i);
        m19797a(c0620k);
    }

    /* renamed from: a */
    protected void m19795a(C0622m c0622m) {
        m19793a(c0622m.m19859b(), c0622m.m19866a(), XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m19794a(C0622m c0622m, long j) {
        m19798a(j);
        m19795a(c0622m);
        m19789b(c0622m);
        m19788c(c0622m);
    }

    /* renamed from: a */
    protected void m19793a(Enumeration<C0620k> enumeration, int i, String str) {
        int i2 = 1;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            m19792b().println("There was " + i + " " + str + ":");
        } else {
            m19792b().println("There were " + i + " " + str + "s:");
        }
        while (true) {
            int i3 = i2;
            if (!enumeration.hasMoreElements()) {
                return;
            }
            m19796a(enumeration.nextElement(), i3);
            i2 = i3 + 1;
        }
    }

    /* renamed from: b */
    public PrintStream m19792b() {
        return this.f1420a;
    }

    /* renamed from: b */
    protected String m19791b(long j) {
        return NumberFormat.getInstance().format(j / 1000.0d);
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: b */
    public void mo833b(AbstractC0618i abstractC0618i) {
        m19792b().print(".");
        int i = this.f1421b;
        this.f1421b = i + 1;
        if (i >= 40) {
            m19792b().println();
            this.f1421b = 0;
        }
    }

    /* renamed from: b */
    protected void m19790b(C0620k c0620k, int i) {
        m19792b().print(i + ") " + c0620k.m19871a());
    }

    /* renamed from: b */
    protected void m19789b(C0622m c0622m) {
        m19793a(c0622m.m19855d(), c0622m.m19856c(), "failure");
    }

    /* renamed from: c */
    protected void m19788c(C0622m c0622m) {
        if (c0622m.m19851h()) {
            m19792b().println();
            m19792b().print("OK");
            m19792b().println(" (" + c0622m.m19854e() + " test" + (c0622m.m19854e() == 1 ? "" : "s") + ")");
        } else {
            m19792b().println();
            m19792b().println("FAILURES!!!");
            m19792b().println("Tests run: " + c0622m.m19854e() + ",  Failures: " + c0622m.m19856c() + ",  Errors: " + c0622m.m19866a());
        }
        m19792b().println();
    }
}
