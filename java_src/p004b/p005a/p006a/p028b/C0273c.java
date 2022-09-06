package p004b.p005a.p006a.p028b;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import p004b.p005a.p006a.p028b.p054o.AbstractC0523b;
import p004b.p005a.p006a.p028b.p054o.C0524c;
/* renamed from: b.a.a.b.c */
/* loaded from: classes.dex */
public class C0273c<E> extends AbstractC0554q<E> implements AbstractC0523b<E> {

    /* renamed from: d */
    public static final int f479d = 256;

    /* renamed from: g */
    static final int f480g = -1;

    /* renamed from: c */
    BlockingQueue<E> f482c;

    /* renamed from: b */
    C0524c<E> f481b = new C0524c<>();

    /* renamed from: e */
    int f483e = 256;

    /* renamed from: f */
    int f484f = 0;

    /* renamed from: h */
    int f485h = -1;

    /* renamed from: i */
    C0273c<E>.C0274a f486i = new C0274a();

    /* renamed from: b.a.a.b.c$a */
    /* loaded from: classes.dex */
    class C0274a extends Thread {
        C0274a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            C0273c c0273c = C0273c.this;
            C0524c<E> c0524c = c0273c.f481b;
            while (c0273c.g_()) {
                try {
                    c0524c.m20250a((C0524c<E>) c0273c.f482c.take());
                } catch (InterruptedException e) {
                }
            }
            C0273c.this.d("Worker thread will flush remaining events before exiting.");
            for (E e2 : c0273c.f482c) {
                c0524c.m20250a((C0524c<E>) e2);
            }
            c0524c.mo20245e();
        }
    }

    /* renamed from: a */
    private boolean m21087a() {
        return this.f482c.remainingCapacity() < this.f485h;
    }

    /* renamed from: c */
    private void m21081c(E e) {
        try {
            this.f482c.put(e);
        } catch (InterruptedException e2) {
        }
    }

    /* renamed from: a */
    public void m21086a(int i) {
        this.f483e = i;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a */
    public void mo20251a(AbstractC0266a<E> abstractC0266a) {
        if (this.f484f != 0) {
            e("One and only one appender may be attached to AsyncAppender.");
            e("Ignoring additional appender named [" + abstractC0266a.mo20159g() + "]");
            return;
        }
        this.f484f++;
        d("Attaching appender named [" + abstractC0266a.mo20159g() + "] to AsyncAppender.");
        this.f481b.mo20251a((AbstractC0266a) abstractC0266a);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q
    /* renamed from: a */
    protected void mo20164a(E e) {
        if (!m21087a() || !mo21082b((C0273c<E>) e)) {
            mo21085a_((C0273c<E>) e);
            m21081c((C0273c<E>) e);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a_ */
    public AbstractC0266a<E> mo20249a_(String str) {
        return this.f481b.mo20249a_(str);
    }

    /* renamed from: a_ */
    protected void mo21085a_(E e) {
    }

    /* renamed from: b */
    public int m21084b() {
        return this.f483e;
    }

    /* renamed from: b */
    public void m21083b(int i) {
        this.f485h = i;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20248b(AbstractC0266a<E> abstractC0266a) {
        return this.f481b.mo20248b(abstractC0266a);
    }

    /* renamed from: b */
    protected boolean mo21082b(E e) {
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20247b(String str) {
        return this.f481b.mo20247b(str);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: c */
    public boolean mo20246c(AbstractC0266a<E> abstractC0266a) {
        return this.f481b.mo20246c(abstractC0266a);
    }

    /* renamed from: d */
    public int m21080d() {
        return this.f485h;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: e */
    public void mo20245e() {
        this.f481b.mo20245e();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: f */
    public Iterator<AbstractC0266a<E>> mo20244f() {
        return this.f481b.mo20244f();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f484f == 0) {
            c("No attached appenders found.");
        } else if (this.f483e < 1) {
            c("Invalid queue size [" + this.f483e + "]");
        } else {
            this.f482c = new ArrayBlockingQueue(this.f483e);
            if (this.f485h == -1) {
                this.f485h = this.f483e / 5;
            }
            d("Setting discardingThreshold to " + this.f485h);
            this.f486i.setDaemon(true);
            this.f486i.setName("AsyncAppender-Worker-" + this.f486i.getName());
            super.mo20156j();
            this.f486i.start();
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        if (!g_()) {
            return;
        }
        super.mo20155k();
        this.f486i.interrupt();
        try {
            this.f486i.join(1000L);
        } catch (InterruptedException e) {
            a("Failed to join worker thread", e);
        }
    }

    /* renamed from: l */
    public int m21079l() {
        return this.f482c.size();
    }

    /* renamed from: m */
    public int m21078m() {
        return this.f482c.remainingCapacity();
    }
}
