package p004b.p005a.p006a.p028b.p041h;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g;
import p004b.p005a.p006a.p028b.p057r.AbstractC0575i;
import p004b.p005a.p006a.p028b.p057r.C0582p;
/* renamed from: b.a.a.b.h.c */
/* loaded from: classes.dex */
public class C0394c implements AbstractCallableC0401g {

    /* renamed from: a */
    private final InetAddress f821a;

    /* renamed from: b */
    private final int f822b;

    /* renamed from: c */
    private final AbstractC0575i f823c;

    /* renamed from: d */
    private AbstractCallableC0401g.AbstractC0402a f824d;

    /* renamed from: e */
    private SocketFactory f825e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.a.a.b.h.c$a */
    /* loaded from: classes.dex */
    public static class C0396a implements AbstractCallableC0401g.AbstractC0402a {
        private C0396a() {
        }

        @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g.AbstractC0402a
        /* renamed from: a */
        public void mo20578a(AbstractCallableC0401g abstractCallableC0401g, Exception exc) {
            System.out.println(exc);
        }
    }

    public C0394c(InetAddress inetAddress, int i, long j, long j2) {
        this(inetAddress, i, new C0582p(j, j2));
    }

    public C0394c(InetAddress inetAddress, int i, AbstractC0575i abstractC0575i) {
        this.f821a = inetAddress;
        this.f822b = i;
        this.f823c = abstractC0575i;
    }

    /* renamed from: b */
    private Socket m20639b() {
        try {
            return this.f825e.createSocket(this.f821a, this.f822b);
        } catch (IOException e) {
            this.f824d.mo20578a(this, e);
            return null;
        }
    }

    /* renamed from: c */
    private void m20638c() {
        if (this.f824d == null) {
            this.f824d = new C0396a();
        }
        if (this.f825e == null) {
            this.f825e = SocketFactory.getDefault();
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Socket call() {
        m20638c();
        Socket m20639b = m20639b();
        while (m20639b == null && !Thread.currentThread().isInterrupted()) {
            Thread.sleep(this.f823c.mo20085a());
            m20639b = m20639b();
        }
        return m20639b;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g
    /* renamed from: a */
    public void mo20583a(AbstractCallableC0401g.AbstractC0402a abstractC0402a) {
        this.f824d = abstractC0402a;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractCallableC0401g
    /* renamed from: a */
    public void mo20582a(SocketFactory socketFactory) {
        this.f825e = socketFactory;
    }
}
