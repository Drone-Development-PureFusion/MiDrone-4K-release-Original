package p004b.p005a.p006a.p028b.p041h.p043b;

import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
/* renamed from: b.a.a.b.h.b.k */
/* loaded from: classes.dex */
public class C0389k {

    /* renamed from: a */
    private static final String f800a = "javax.net.ssl.keyStore";

    /* renamed from: b */
    private static final String f801b = "javax.net.ssl.trustStore";

    /* renamed from: c */
    private C0382d f802c;

    /* renamed from: d */
    private C0382d f803d;

    /* renamed from: e */
    private C0392n f804e;

    /* renamed from: f */
    private C0381c f805f;

    /* renamed from: g */
    private C0393o f806g;

    /* renamed from: h */
    private String f807h;

    /* renamed from: i */
    private String f808i;

    /* renamed from: b */
    private KeyManager[] m20679b(AbstractC0526e abstractC0526e) {
        if (m20681b() == null) {
            return null;
        }
        KeyStore m20707a = m20681b().m20707a();
        abstractC0526e.mo20226d("key store of type '" + m20707a.getType() + "' provider '" + m20707a.getProvider() + "': " + m20681b().m20705b());
        KeyManagerFactory m20712a = m20671e().m20712a();
        abstractC0526e.mo20226d("key manager algorithm '" + m20712a.getAlgorithm() + "' provider '" + m20712a.getProvider() + "'");
        m20712a.init(m20707a, m20681b().m20699e().toCharArray());
        return m20712a.getKeyManagers();
    }

    /* renamed from: c */
    private C0382d m20675c(String str) {
        if (System.getProperty(str) == null) {
            return null;
        }
        C0382d c0382d = new C0382d();
        c0382d.m20706a(m20672d(str));
        c0382d.m20702c(System.getProperty(str + "Provider"));
        c0382d.m20700d(System.getProperty(str + "Password"));
        c0382d.m20704b(System.getProperty(str + "Type"));
        return c0382d;
    }

    /* renamed from: c */
    private TrustManager[] m20676c(AbstractC0526e abstractC0526e) {
        if (m20677c() == null) {
            return null;
        }
        KeyStore m20707a = m20677c().m20707a();
        abstractC0526e.mo20226d("trust store of type '" + m20707a.getType() + "' provider '" + m20707a.getProvider() + "': " + m20677c().m20705b());
        TrustManagerFactory m20644a = m20670f().m20644a();
        abstractC0526e.mo20226d("trust manager algorithm '" + m20644a.getAlgorithm() + "' provider '" + m20644a.getProvider() + "'");
        m20644a.init(m20707a);
        return m20644a.getTrustManagers();
    }

    /* renamed from: d */
    private String m20672d(String str) {
        String property = System.getProperty(str);
        return (property == null || property.startsWith("file:")) ? property : "file:" + property;
    }

    /* renamed from: d */
    private SecureRandom m20673d(AbstractC0526e abstractC0526e) {
        SecureRandom m20649a = m20674d().m20649a();
        abstractC0526e.mo20226d("secure random algorithm '" + m20649a.getAlgorithm() + "' provider '" + m20649a.getProvider() + "'");
        return m20649a;
    }

    /* renamed from: a */
    public SSLContext m20683a(AbstractC0526e abstractC0526e) {
        SSLContext sSLContext = m20668h() != null ? SSLContext.getInstance(m20669g(), m20668h()) : SSLContext.getInstance(m20669g());
        abstractC0526e.mo20226d("SSL protocol '" + sSLContext.getProtocol() + "' provider '" + sSLContext.getProvider() + "'");
        sSLContext.init(m20679b(abstractC0526e), m20676c(abstractC0526e), m20673d(abstractC0526e));
        return sSLContext;
    }

    /* renamed from: a */
    public void m20687a(C0381c c0381c) {
        this.f805f = c0381c;
    }

    /* renamed from: a */
    public void m20686a(C0382d c0382d) {
        this.f802c = c0382d;
    }

    /* renamed from: a */
    public void m20685a(C0392n c0392n) {
        this.f804e = c0392n;
    }

    /* renamed from: a */
    public void m20684a(C0393o c0393o) {
        this.f806g = c0393o;
    }

    /* renamed from: a */
    public void m20682a(String str) {
        this.f807h = str;
    }

    /* renamed from: b */
    public C0382d m20681b() {
        if (this.f802c == null) {
            this.f802c = m20675c(f800a);
        }
        return this.f802c;
    }

    /* renamed from: b */
    public void m20680b(C0382d c0382d) {
        this.f803d = c0382d;
    }

    /* renamed from: b */
    public void m20678b(String str) {
        this.f808i = str;
    }

    /* renamed from: c */
    public C0382d m20677c() {
        if (this.f803d == null) {
            this.f803d = m20675c(f801b);
        }
        return this.f803d;
    }

    /* renamed from: d */
    public C0392n m20674d() {
        return this.f804e == null ? new C0392n() : this.f804e;
    }

    /* renamed from: e */
    public C0381c m20671e() {
        return this.f805f == null ? new C0381c() : this.f805f;
    }

    /* renamed from: f */
    public C0393o m20670f() {
        return this.f806g == null ? new C0393o() : this.f806g;
    }

    /* renamed from: g */
    public String m20669g() {
        return this.f807h == null ? "SSL" : this.f807h;
    }

    /* renamed from: h */
    public String m20668h() {
        return this.f808i;
    }
}
