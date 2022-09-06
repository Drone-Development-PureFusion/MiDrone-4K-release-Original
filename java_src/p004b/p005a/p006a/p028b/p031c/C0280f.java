package p004b.p005a.p006a.p028b.p031c;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.c.f */
/* loaded from: classes.dex */
public class C0280f<E> extends AbstractC0278d<E> {

    /* renamed from: c */
    protected AbstractC0459j<E> f493c;

    /* renamed from: d */
    private Charset f494d;

    /* renamed from: e */
    private boolean f495e = true;

    /* renamed from: a */
    private void m21064a(StringBuilder sb, String str) {
        if (str != null) {
            sb.append(str);
        }
    }

    /* renamed from: a */
    private byte[] m21065a(String str) {
        if (this.f494d == null) {
            return str.getBytes();
        }
        try {
            return str.getBytes(this.f494d.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("An existing charset cannot possibly be unsupported.");
        }
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21055a() {
        m21057g();
    }

    /* renamed from: a */
    public void mo20467a(AbstractC0459j<E> abstractC0459j) {
        this.f493c = abstractC0459j;
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0278d, p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21053a(OutputStream outputStream) {
        super.mo21053a(outputStream);
        m21058f();
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21052a(E e) {
        this.f489b.write(m21065a(this.f493c.mo20455a((AbstractC0459j<E>) e)));
        if (this.f495e) {
            this.f489b.flush();
        }
    }

    /* renamed from: a */
    public void m21063a(Charset charset) {
        this.f494d = charset;
    }

    /* renamed from: a */
    public void m21062a(boolean z) {
        this.f495e = z;
    }

    /* renamed from: b */
    public boolean m21061b() {
        return this.f495e;
    }

    /* renamed from: d */
    public AbstractC0459j<E> m21060d() {
        return this.f493c;
    }

    /* renamed from: e */
    public Charset m21059e() {
        return this.f494d;
    }

    /* renamed from: f */
    void m21058f() {
        if (this.f493c == null || this.f489b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        m21064a(sb, this.f493c.mo20445e());
        m21064a(sb, this.f493c.mo20444f());
        if (sb.length() <= 0) {
            return;
        }
        sb.append(C0359h.f706c);
        this.f489b.write(m21065a(sb.toString()));
        this.f489b.flush();
    }

    /* renamed from: g */
    void m21057g() {
        if (this.f493c == null || this.f489b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        m21064a(sb, this.f493c.mo20443g());
        m21064a(sb, this.f493c.mo20442h());
        if (sb.length() <= 0) {
            return;
        }
        this.f489b.write(m21065a(sb.toString()));
        this.f489b.flush();
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0278d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0278d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f488a = true;
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0278d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f488a = false;
        if (this.f489b != null) {
            try {
                this.f489b.flush();
            } catch (IOException e) {
            }
        }
    }
}
