package p004b.p005a.p006a.p028b.p041h.p042a;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b;
import p004b.p005a.p006a.p028b.p054o.AbstractC0536o;
/* renamed from: b.a.a.b.h.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0361a<E> extends AbstractC0269b<E> {

    /* renamed from: a */
    public static final int f732a = 50;

    /* renamed from: b */
    public static final int f733b = 100;

    /* renamed from: c */
    private int f734c = AbstractRunnableC0378b.f766a;

    /* renamed from: d */
    private int f735d = 50;

    /* renamed from: e */
    private int f736e = 100;

    /* renamed from: i */
    private String f737i;

    /* renamed from: j */
    private AbstractRunnableC0374k<AbstractC0368e> f738j;

    /* renamed from: a */
    protected AbstractC0373j<AbstractC0368e> m20778a(ServerSocket serverSocket) {
        return new C0369f(serverSocket);
    }

    /* renamed from: a */
    protected AbstractRunnableC0374k<AbstractC0368e> m20780a(AbstractC0373j<AbstractC0368e> abstractC0373j, Executor executor) {
        return new C0370g(abstractC0373j, executor, m20770o());
    }

    /* renamed from: a */
    protected abstract AbstractC0536o<E> mo20782a();

    /* renamed from: a */
    public void m20781a(int i) {
        this.f734c = i;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (e == null) {
            return;
        }
        mo20776b((AbstractC0361a<E>) e);
        final Serializable mo20212a = mo20782a().mo20212a(e);
        this.f738j.mo20754a(new AbstractC0364c<AbstractC0368e>() { // from class: b.a.a.b.h.a.a.1
            @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0364c
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo20738a(AbstractC0368e abstractC0368e) {
                abstractC0368e.mo20758a(mo20212a);
            }
        });
    }

    /* renamed from: a */
    public void m20779a(String str) {
        this.f737i = str;
    }

    /* renamed from: b */
    public void m20777b(int i) {
        this.f735d = i;
    }

    /* renamed from: b */
    protected abstract void mo20776b(E e);

    /* renamed from: c */
    public void m20775c(int i) {
        this.f736e = i;
    }

    /* renamed from: d */
    protected ServerSocketFactory mo20756d() {
        return ServerSocketFactory.getDefault();
    }

    /* renamed from: e */
    protected InetAddress m20774e() {
        if (m20771n() == null) {
            return null;
        }
        return InetAddress.getByName(m20771n());
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (g_()) {
            return;
        }
        try {
            this.f738j = m20780a(m20778a(mo20756d().createServerSocket(m20773l(), m20772m(), m20774e())), h_().mo20993s());
            this.f738j.a(h_());
            h_().mo20993s().execute(this.f738j);
            super.mo20156j();
        } catch (Exception e) {
            a("server startup error: " + e, e);
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        if (!g_()) {
            return;
        }
        try {
            this.f738j.mo20753b();
            super.mo20155k();
        } catch (IOException e) {
            a("server shutdown error: " + e, e);
        }
    }

    /* renamed from: l */
    public int m20773l() {
        return this.f734c;
    }

    /* renamed from: m */
    public int m20772m() {
        return this.f735d;
    }

    /* renamed from: n */
    public String m20771n() {
        return this.f737i;
    }

    /* renamed from: o */
    public int m20770o() {
        return this.f736e;
    }
}
