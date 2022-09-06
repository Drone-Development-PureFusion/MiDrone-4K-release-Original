package p069c.p070a;

import p069c.p071b.AbstractC0618i;
import p069c.p071b.AbstractC0619j;
import p069c.p071b.C0622m;
import p069c.p071b.C0624n;
/* renamed from: c.a.a */
/* loaded from: classes.dex */
public class C0603a extends C0624n {

    /* renamed from: a */
    private volatile int f1374a;

    public C0603a() {
    }

    public C0603a(Class<? extends AbstractC0619j> cls) {
        super(cls);
    }

    public C0603a(Class<? extends AbstractC0619j> cls, String str) {
        super(cls, str);
    }

    public C0603a(String str) {
        super(str);
    }

    @Override // p069c.p071b.C0624n
    /* renamed from: a */
    public void mo19845a(final AbstractC0618i abstractC0618i, final C0622m c0622m) {
        new Thread() { // from class: c.a.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    abstractC0618i.mo19844a(c0622m);
                } finally {
                    C0603a.this.m19979b();
                }
            }
        }.start();
    }

    @Override // p069c.p071b.C0624n, p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        this.f1374a = 0;
        super.mo19844a(c0622m);
        m19978k_();
    }

    /* renamed from: b */
    public synchronized void m19979b() {
        this.f1374a++;
        notifyAll();
    }

    /* renamed from: k_ */
    synchronized void m19978k_() {
        while (this.f1374a < d()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
