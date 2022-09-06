package p004b.p005a.p006a.p007a.p019j.p020a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;
import p004b.p005a.p006a.p007a.p019j.AbstractC0180b;
import p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b;
import p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0373j;
import p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0374k;
import p004b.p005a.p006a.p028b.p057r.C0571e;
/* renamed from: b.a.a.a.j.a.h */
/* loaded from: classes.dex */
public class C0179h extends AbstractC0180b {

    /* renamed from: a */
    public static final int f275a = 50;

    /* renamed from: b */
    private int f276b = AbstractRunnableC0378b.f766a;

    /* renamed from: c */
    private int f277c = 50;

    /* renamed from: d */
    private String f278d;

    /* renamed from: e */
    private ServerSocket f279e;

    /* renamed from: f */
    private AbstractRunnableC0374k f280f;

    /* renamed from: a */
    protected AbstractC0373j<AbstractC0172a> m21369a(ServerSocket serverSocket) {
        return new C0173b(serverSocket);
    }

    /* renamed from: a */
    protected AbstractRunnableC0374k m21371a(AbstractC0373j<AbstractC0172a> abstractC0373j, Executor executor) {
        return new C0174c(abstractC0373j, executor);
    }

    /* renamed from: a */
    public void m21372a(int i) {
        this.f276b = i;
    }

    /* renamed from: a */
    public void m21370a(String str) {
        this.f278d = str;
    }

    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: a */
    protected boolean mo21337a() {
        try {
            this.f280f = m21371a(m21369a(mo21367e().createServerSocket(m21365h(), m21364i(), m21366g())), h_().mo20993s());
            this.f280f.a(h_());
            return true;
        } catch (Exception e) {
            a("server startup error: " + e, e);
            C0571e.m20116a(this.f279e);
            return false;
        }
    }

    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: b */
    protected void mo21331b() {
        try {
            if (this.f280f == null) {
                return;
            }
            this.f280f.mo20753b();
        } catch (IOException e) {
            a("server shutdown error: " + e, e);
        }
    }

    /* renamed from: b */
    public void m21368b(int i) {
        this.f277c = i;
    }

    @Override // p004b.p005a.p006a.p007a.p019j.AbstractC0180b
    /* renamed from: d */
    protected Runnable mo21327d() {
        return this.f280f;
    }

    /* renamed from: e */
    protected ServerSocketFactory mo21367e() {
        return ServerSocketFactory.getDefault();
    }

    /* renamed from: g */
    protected InetAddress m21366g() {
        if (m21363l() == null) {
            return null;
        }
        return InetAddress.getByName(m21363l());
    }

    /* renamed from: h */
    public int m21365h() {
        return this.f276b;
    }

    /* renamed from: i */
    public int m21364i() {
        return this.f277c;
    }

    /* renamed from: l */
    public String m21363l() {
        return this.f278d;
    }
}
