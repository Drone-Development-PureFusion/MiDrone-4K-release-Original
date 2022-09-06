package p004b.p005a.p006a.p007a.p015g.p016a;

import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
/* renamed from: b.a.a.a.g.a.a */
/* loaded from: classes.dex */
public class C0158a extends AbstractC0300b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.a.g.a.a$a */
    /* loaded from: classes.dex */
    public class C0159a {

        /* renamed from: b */
        private URL f240b;

        C0159a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public URL m21405a() {
            return this.f240b;
        }

        /* renamed from: a */
        void m21404a(URL url) {
            this.f240b = url;
        }
    }

    /* renamed from: a */
    private URL m21407a(C0344k c0344k) {
        URL m21405a;
        if (!c0344k.m20872e()) {
            Object m20871f = c0344k.m20871f();
            if ((m20871f instanceof C0159a) && (m21405a = ((C0159a) m20871f).m21405a()) != null) {
                return m21405a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private URL m21406b(C0344k c0344k, URL url) {
        C0159a c0159a = new C0159a();
        c0159a.m21404a(url);
        c0344k.m20881a(c0159a);
        return url;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b, p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        if (m21407a(c0344k) != null) {
            return;
        }
        super.mo20940a(c0344k, str, attributes);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b
    /* renamed from: a */
    protected void mo20954a(C0344k c0344k, URL url) {
        m21406b(c0344k, url);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b
    /* renamed from: a */
    protected void mo20975a(String str, Exception exc) {
        if (exc == null || (exc instanceof FileNotFoundException) || (exc instanceof UnknownHostException)) {
            d(str);
        } else {
            c(str, exc);
        }
    }
}
