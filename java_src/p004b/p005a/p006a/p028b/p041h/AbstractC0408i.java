package p004b.p005a.p006a.p028b.p041h;

import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.AbstractC0459j;
/* renamed from: b.a.a.b.h.i */
/* loaded from: classes.dex */
public abstract class AbstractC0408i<E> extends AbstractC0269b<E> {

    /* renamed from: i */
    static final String f866i = "http://logback.qos.ch/codes.html#syslog_layout";

    /* renamed from: j */
    static final int f867j = 65000;

    /* renamed from: k */
    AbstractC0459j<E> f869k;

    /* renamed from: l */
    String f870l;

    /* renamed from: m */
    String f871m;

    /* renamed from: n */
    protected String f872n;

    /* renamed from: o */
    protected C0410k f873o;

    /* renamed from: r */
    int f876r;

    /* renamed from: p */
    int f874p = 514;

    /* renamed from: q */
    boolean f875q = false;

    /* renamed from: a */
    private boolean f868a = false;

    /* renamed from: a */
    private boolean m20576a() {
        try {
            this.f873o = new C0410k(this.f871m, this.f874p);
            int m20556b = this.f873o.m20556b();
            if (this.f876r == 0) {
                this.f876r = Math.min(m20556b, (int) f867j);
                d("Defaulting maxMessageSize to [" + this.f876r + "]");
            } else if (this.f876r > m20556b) {
                e("maxMessageSize of [" + this.f876r + "] is larger than the system defined datagram size of [" + m20556b + "].");
                e("This may result in dropped logs.");
            }
        } catch (SocketException e) {
            c("Failed to bind to a random datagram socket. Will try to reconnect later.", e);
        } catch (UnknownHostException e2) {
            a("Could not create SyslogWriter", e2);
        }
        return this.f873o != null;
    }

    /* renamed from: b */
    public static int m20569b(String str) {
        if ("KERN".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("USER".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("MAIL".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("DAEMON".equalsIgnoreCase(str)) {
            return 24;
        }
        if ("AUTH".equalsIgnoreCase(str)) {
            return 32;
        }
        if ("SYSLOG".equalsIgnoreCase(str)) {
            return 40;
        }
        if ("LPR".equalsIgnoreCase(str)) {
            return 48;
        }
        if ("NEWS".equalsIgnoreCase(str)) {
            return 56;
        }
        if ("UUCP".equalsIgnoreCase(str)) {
            return 64;
        }
        if ("CRON".equalsIgnoreCase(str)) {
            return 72;
        }
        if ("AUTHPRIV".equalsIgnoreCase(str)) {
            return 80;
        }
        if ("FTP".equalsIgnoreCase(str)) {
            return 88;
        }
        if ("NTP".equalsIgnoreCase(str)) {
            return 96;
        }
        if ("AUDIT".equalsIgnoreCase(str)) {
            return 104;
        }
        if ("ALERT".equalsIgnoreCase(str)) {
            return 112;
        }
        if ("CLOCK".equalsIgnoreCase(str)) {
            return 120;
        }
        if ("LOCAL0".equalsIgnoreCase(str)) {
            return 128;
        }
        if ("LOCAL1".equalsIgnoreCase(str)) {
            return 136;
        }
        if ("LOCAL2".equalsIgnoreCase(str)) {
            return 144;
        }
        if ("LOCAL3".equalsIgnoreCase(str)) {
            return 152;
        }
        if ("LOCAL4".equalsIgnoreCase(str)) {
            return 160;
        }
        if ("LOCAL5".equalsIgnoreCase(str)) {
            return 168;
        }
        if ("LOCAL6".equalsIgnoreCase(str)) {
            return 176;
        }
        if (!"LOCAL7".equalsIgnoreCase(str)) {
            throw new IllegalArgumentException(str + " is not a valid syslog facility string");
        }
        return 184;
    }

    /* renamed from: a */
    public void m20575a(int i) {
        this.f874p = i;
    }

    /* renamed from: a */
    public void m20574a(AbstractC0459j<E> abstractC0459j) {
        e("The layout of a SyslogAppender cannot be set directly. See also http://logback.qos.ch/codes.html#syslog_layout");
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (!g_()) {
            return;
        }
        if (!this.f875q && this.f868a) {
            this.f875q = true;
            m20576a();
        }
        if (this.f873o == null) {
            return;
        }
        try {
            String mo20455a = this.f869k.mo20455a((AbstractC0459j<E>) e);
            if (mo20455a == null) {
                return;
            }
            if (mo20455a.length() > this.f876r) {
                mo20455a = mo20455a.substring(0, this.f876r);
            }
            this.f873o.write(mo20455a.getBytes());
            this.f873o.flush();
            mo20573a(e, this.f873o);
        } catch (IOException e2) {
            a("Failed to send diagram to " + this.f871m, e2);
        }
    }

    /* renamed from: a */
    protected void mo20573a(Object obj, OutputStream outputStream) {
    }

    /* renamed from: b */
    public abstract int mo20570b(Object obj);

    /* renamed from: b */
    public abstract AbstractC0459j<E> mo20572b();

    /* renamed from: b */
    public void m20571b(int i) {
        this.f876r = i;
    }

    /* renamed from: b */
    public void m20568b(boolean z) {
        this.f868a = z;
    }

    /* renamed from: f */
    public String m20567f() {
        return this.f871m;
    }

    /* renamed from: f */
    public void m20566f(String str) {
        this.f871m = str;
    }

    /* renamed from: g */
    public void m20565g(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.f870l = str;
    }

    /* renamed from: h */
    public void m20564h(String str) {
        this.f872n = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        int i = 0;
        if (this.f870l == null) {
            c("The Facility option is mandatory");
            i = 1;
        }
        if (!this.f868a && !m20576a()) {
            i++;
        }
        if (this.f869k == null) {
            this.f869k = mo20572b();
        }
        if (i == 0) {
            super.mo20156j();
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f873o.close();
        super.mo20155k();
    }

    /* renamed from: l */
    public String m20563l() {
        return this.f870l;
    }

    /* renamed from: m */
    public int m20562m() {
        return this.f874p;
    }

    /* renamed from: n */
    public int m20561n() {
        return this.f876r;
    }

    /* renamed from: o */
    public AbstractC0459j<E> m20560o() {
        return this.f869k;
    }

    /* renamed from: p */
    public boolean m20559p() {
        return this.f868a;
    }

    /* renamed from: q */
    public String m20558q() {
        return this.f872n;
    }
}
