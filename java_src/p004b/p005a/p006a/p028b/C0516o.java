package p004b.p005a.p006a.p028b;

import java.io.IOException;
import java.io.OutputStream;
import p004b.p005a.p006a.p028b.p031c.AbstractC0277c;
import p004b.p005a.p006a.p028b.p031c.C0280f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0530i;
import p004b.p005a.p006a.p028b.p054o.C0535n;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.C0541a;
/* renamed from: b.a.a.b.o */
/* loaded from: classes.dex */
public class C0516o<E> extends AbstractC0554q<E> {

    /* renamed from: a */
    private OutputStream f1165a;

    /* renamed from: c */
    protected AbstractC0277c<E> f1166c;

    /* renamed from: d */
    protected C0535n f1167d = new C0535n();

    /* renamed from: a */
    public void m20277a(AbstractC0277c<E> abstractC0277c) {
        this.f1166c = abstractC0277c;
    }

    /* renamed from: a */
    public void m20276a(AbstractC0459j<E> abstractC0459j) {
        e("This appender no longer admits a layout as a sub-component, set an encoder instead.");
        e("To ensure compatibility, wrapping your layout in LayoutWrappingEncoder.");
        e("See also http://logback.qos.ch/codes.html#layoutInsteadOfEncoder for details");
        C0280f c0280f = new C0280f();
        c0280f.mo20467a((AbstractC0459j) abstractC0459j);
        c0280f.a(this.f1190s);
        this.f1166c = c0280f;
    }

    /* renamed from: a */
    public void m20275a(OutputStream outputStream) {
        synchronized (this.f1167d) {
            m20271m();
            this.f1165a = outputStream;
            if (this.f1166c == null) {
                e("Encoder has not been set. Cannot invoke its init method.");
            } else {
                m20270n();
            }
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q
    /* renamed from: a */
    protected void mo20164a(E e) {
        if (!g_()) {
            return;
        }
        mo20273c((C0516o<E>) e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo20274b(E e) {
        this.f1166c.mo21052a((AbstractC0277c<E>) e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo20273c(E e) {
        if (!g_()) {
            return;
        }
        try {
            if (e instanceof AbstractC0530i) {
                ((AbstractC0530i) e).mo20213o();
            }
            synchronized (this.f1167d) {
                mo20274b(e);
            }
        } catch (IOException e2) {
            this.f1224j = false;
            a((AbstractC0547g) new C0541a("IO failure in appender", this, e2));
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        int i = 0;
        if (this.f1166c == null) {
            a((AbstractC0547g) new C0541a("No encoder set for the appender named \"" + this.f1225k + "\".", this));
            i = 1;
        }
        if (this.f1165a == null) {
            a((AbstractC0547g) new C0541a("No output stream set for the appender named \"" + this.f1225k + "\".", this));
            i++;
        }
        if (i == 0) {
            super.mo20156j();
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        synchronized (this.f1167d) {
            m20271m();
            super.mo20155k();
        }
    }

    /* renamed from: l */
    public OutputStream m20272l() {
        return this.f1165a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public void m20271m() {
        if (this.f1165a != null) {
            try {
                m20269o();
                this.f1165a.close();
                this.f1165a = null;
            } catch (IOException e) {
                a((AbstractC0547g) new C0541a("Could not close output stream for OutputStreamAppender.", this, e));
            }
        }
    }

    /* renamed from: n */
    void m20270n() {
        if (this.f1166c == null || this.f1165a == null) {
            return;
        }
        try {
            this.f1166c.mo21053a(this.f1165a);
        } catch (IOException e) {
            this.f1224j = false;
            a((AbstractC0547g) new C0541a("Failed to initialize encoder for appender named [" + this.f1225k + "].", this, e));
        }
    }

    /* renamed from: o */
    void m20269o() {
        if (this.f1166c == null || this.f1165a == null) {
            return;
        }
        try {
            this.f1166c.mo21055a();
        } catch (IOException e) {
            this.f1224j = false;
            a((AbstractC0547g) new C0541a("Failed to write footer for appender named [" + this.f1225k + "].", this, e));
        }
    }

    /* renamed from: p */
    public AbstractC0277c<E> m20268p() {
        return this.f1166c;
    }
}
