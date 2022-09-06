package p004b.p005a.p006a.p028b.p035g;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p037b.C0329e;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p;
import p004b.p005a.p006a.p028b.p035g.p039d.C0339f;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0345l;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p035g.p039d.C0350q;
import p004b.p005a.p006a.p028b.p035g.p040e.C0351a;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p055p.C0552l;
/* renamed from: b.a.a.b.g.a */
/* loaded from: classes.dex */
public abstract class AbstractC0298a extends C0527f {

    /* renamed from: a */
    protected C0345l f539a;

    /* renamed from: a */
    public static void m20990a(AbstractC0292f abstractC0292f, URL url) {
        C0351a.m20832a(abstractC0292f, url);
    }

    /* renamed from: a */
    private final void m20984a(InputSource inputSource) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!C0351a.m20830b(this.f1190s)) {
            m20990a(h_(), (URL) null);
        }
        C0329e c0329e = new C0329e(this.f1190s);
        c0329e.mo20926a(inputSource);
        mo20280a(c0329e.m20922d());
        if (new C0552l(this.f1190s).m20170b(currentTimeMillis)) {
            d("Registering current configuration as safe fallback point");
            m20983d();
        }
    }

    /* renamed from: a */
    protected C0340g mo20991a() {
        return new C0340g();
    }

    /* renamed from: a */
    protected void mo20989a(C0339f c0339f) {
    }

    /* renamed from: a */
    protected abstract void mo20282a(C0345l c0345l);

    /* renamed from: a */
    protected abstract void mo20281a(AbstractC0349p abstractC0349p);

    /* renamed from: a */
    public final void m20988a(File file) {
        try {
            m20990a(h_(), file.toURI().toURL());
            m20987a(new FileInputStream(file));
        } catch (IOException e) {
            String str = "Could not open [" + file.getPath() + "].";
            a(str, e);
            throw new C0346m(str, e);
        }
    }

    /* renamed from: a */
    public final void m20987a(InputStream inputStream) {
        try {
            m20984a(new InputSource(inputStream));
            try {
                inputStream.close();
            } catch (IOException e) {
                a("Could not close the stream", e);
                throw new C0346m("Could not close the stream", e);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException e2) {
                a("Could not close the stream", e2);
                throw new C0346m("Could not close the stream", e2);
            }
        }
    }

    /* renamed from: a */
    public final void m20986a(String str) {
        m20988a(new File(str));
    }

    /* renamed from: a */
    public final void m20985a(URL url) {
        try {
            m20990a(h_(), url);
            URLConnection openConnection = url.openConnection();
            openConnection.setUseCaches(false);
            m20987a(openConnection.getInputStream());
        } catch (IOException e) {
            String str = "Could not open URL [" + url + "].";
            a(str, e);
            throw new C0346m(str, e);
        }
    }

    /* renamed from: a */
    public void mo20280a(List<C0328d> list) {
        mo20939b();
        synchronized (this.f1190s.mo20994r()) {
            this.f539a.m20866a().m20889a(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo20939b() {
        C0350q c0350q = new C0350q(this.f1190s);
        mo20281a(c0350q);
        this.f539a = new C0345l(this.f1190s, c0350q, mo20991a());
        C0344k m20850c = this.f539a.m20850c();
        m20850c.a(this.f1190s);
        mo20282a(this.f539a);
        mo20989a(m20850c.m20885a());
    }

    /* renamed from: d */
    public void m20983d() {
        this.f1190s.mo21002a(C0359h.f683M, this.f539a.m20866a().m20890a());
    }

    /* renamed from: e */
    public List<C0328d> m20982e() {
        return (List) this.f1190s.mo20998f(C0359h.f683M);
    }
}
