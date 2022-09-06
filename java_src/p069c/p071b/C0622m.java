package p069c.p071b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
/* renamed from: c.b.m */
/* loaded from: classes.dex */
public class C0622m {

    /* renamed from: a */
    protected List<C0620k> f1403a = new ArrayList();

    /* renamed from: b */
    protected List<C0620k> f1404b = new ArrayList();

    /* renamed from: c */
    protected List<AbstractC0621l> f1405c = new ArrayList();

    /* renamed from: d */
    protected int f1406d = 0;

    /* renamed from: e */
    private boolean f1407e = false;

    /* renamed from: i */
    private synchronized List<AbstractC0621l> m19850i() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f1405c);
        return arrayList;
    }

    /* renamed from: a */
    public synchronized int m19866a() {
        return this.f1404b.size();
    }

    /* renamed from: a */
    public void m19865a(AbstractC0618i abstractC0618i) {
        for (AbstractC0621l abstractC0621l : m19850i()) {
            abstractC0621l.mo836a(abstractC0618i);
        }
    }

    /* renamed from: a */
    public synchronized void m19864a(AbstractC0618i abstractC0618i, C0610b c0610b) {
        this.f1403a.add(new C0620k(abstractC0618i, c0610b));
        for (AbstractC0621l abstractC0621l : m19850i()) {
            abstractC0621l.mo835a(abstractC0618i, c0610b);
        }
    }

    /* renamed from: a */
    public void m19863a(AbstractC0618i abstractC0618i, AbstractC0617h abstractC0617h) {
        try {
            abstractC0617h.mo19849a();
        } catch (C0610b e) {
            m19864a(abstractC0618i, e);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            m19862a(abstractC0618i, th);
        }
    }

    /* renamed from: a */
    public synchronized void m19862a(AbstractC0618i abstractC0618i, Throwable th) {
        this.f1404b.add(new C0620k(abstractC0618i, th));
        for (AbstractC0621l abstractC0621l : m19850i()) {
            abstractC0621l.mo834a(abstractC0618i, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19861a(final AbstractC0619j abstractC0619j) {
        m19858b(abstractC0619j);
        m19863a(abstractC0619j, new AbstractC0617h() { // from class: c.b.m.1
            @Override // p069c.p071b.AbstractC0617h
            /* renamed from: a */
            public void mo19849a() {
                abstractC0619j.m19891d();
            }
        });
        m19865a((AbstractC0618i) abstractC0619j);
    }

    /* renamed from: a */
    public synchronized void m19860a(AbstractC0621l abstractC0621l) {
        this.f1405c.add(abstractC0621l);
    }

    /* renamed from: b */
    public synchronized Enumeration<C0620k> m19859b() {
        return Collections.enumeration(this.f1404b);
    }

    /* renamed from: b */
    public void m19858b(AbstractC0618i abstractC0618i) {
        int mo19848a = abstractC0618i.mo19848a();
        synchronized (this) {
            this.f1406d = mo19848a + this.f1406d;
        }
        for (AbstractC0621l abstractC0621l : m19850i()) {
            abstractC0621l.mo833b(abstractC0618i);
        }
    }

    /* renamed from: b */
    public synchronized void m19857b(AbstractC0621l abstractC0621l) {
        this.f1405c.remove(abstractC0621l);
    }

    /* renamed from: c */
    public synchronized int m19856c() {
        return this.f1403a.size();
    }

    /* renamed from: d */
    public synchronized Enumeration<C0620k> m19855d() {
        return Collections.enumeration(this.f1403a);
    }

    /* renamed from: e */
    public synchronized int m19854e() {
        return this.f1406d;
    }

    /* renamed from: f */
    public synchronized boolean m19853f() {
        return this.f1407e;
    }

    /* renamed from: g */
    public synchronized void m19852g() {
        this.f1407e = true;
    }

    /* renamed from: h */
    public synchronized boolean m19851h() {
        boolean z;
        if (m19856c() == 0) {
            if (m19866a() == 0) {
                z = true;
            }
        }
        z = false;
        return z;
    }
}
