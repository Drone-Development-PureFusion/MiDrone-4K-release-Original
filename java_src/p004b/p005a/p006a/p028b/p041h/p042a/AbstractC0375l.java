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
/* renamed from: b.a.a.b.h.a.l */
/* loaded from: classes.dex */
public abstract class AbstractC0375l<E> extends AbstractC0269b<E> {

    /* renamed from: a */
    public static final int f756a = 50;

    /* renamed from: b */
    public static final int f757b = 100;

    /* renamed from: c */
    private int f758c = AbstractRunnableC0378b.f766a;

    /* renamed from: d */
    private int f759d = 50;

    /* renamed from: e */
    private int f760e = 100;

    /* renamed from: i */
    private String f761i;

    /* renamed from: j */
    private AbstractRunnableC0374k<AbstractC0368e> f762j;

    /* renamed from: a */
    protected AbstractC0373j<AbstractC0368e> m20747a(ServerSocket serverSocket) {
        return new C0369f(serverSocket);
    }

    /* renamed from: a */
    protected AbstractRunnableC0374k<AbstractC0368e> m20750a(AbstractC0373j<AbstractC0368e> abstractC0373j, Executor executor) {
        return new C0370g(abstractC0373j, executor, m20739m());
    }

    /* renamed from: a */
    protected abstract AbstractC0536o<E> m20752a();

    /* renamed from: a */
    public void m20751a(int i) {
        this.f758c = i;
    }

    /* renamed from: a */
    public void m20749a(Integer num) {
        this.f759d = num.intValue();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (e == null) {
            return;
        }
        m20744b((AbstractC0375l<E>) e);
        final Serializable mo20212a = m20752a().mo20212a(e);
        this.f762j.mo20754a(new AbstractC0364c<AbstractC0368e>() { // from class: b.a.a.b.h.a.l.1
            @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractC0364c
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo20738a(AbstractC0368e abstractC0368e) {
                abstractC0368e.mo20758a(mo20212a);
            }
        });
    }

    /* renamed from: a */
    public void m20748a(String str) {
        this.f761i = str;
    }

    /* renamed from: b */
    protected ServerSocketFactory m20746b() {
        return ServerSocketFactory.getDefault();
    }

    /* renamed from: b */
    public void m20745b(int i) {
        this.f760e = i;
    }

    /* renamed from: b */
    protected abstract void m20744b(E e);

    /* renamed from: d */
    protected InetAddress m20743d() {
        if (m20740l() == null) {
            return null;
        }
        return InetAddress.getByName(m20740l());
    }

    /* renamed from: e */
    public int m20742e() {
        return this.f758c;
    }

    /* renamed from: f */
    public Integer m20741f() {
        return Integer.valueOf(this.f759d);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (g_()) {
            return;
        }
        try {
            this.f762j = m20750a(m20747a(m20746b().createServerSocket(m20742e(), m20741f().intValue(), m20743d())), h_().mo20993s());
            this.f762j.a(h_());
            h_().mo20993s().execute(this.f762j);
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
            this.f762j.mo20753b();
            super.mo20155k();
        } catch (IOException e) {
            a("server shutdown error: " + e, e);
        }
    }

    /* renamed from: l */
    public String m20740l() {
        return this.f761i;
    }

    /* renamed from: m */
    public int m20739m() {
        return this.f760e;
    }
}
