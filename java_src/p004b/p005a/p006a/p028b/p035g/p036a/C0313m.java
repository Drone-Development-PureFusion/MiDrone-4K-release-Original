package p004b.p005a.p006a.p028b.p035g.p036a;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p037b.C0329e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p035g.p040e.C0351a;
/* renamed from: b.a.a.b.g.a.m */
/* loaded from: classes.dex */
public class C0313m extends AbstractC0300b {

    /* renamed from: a */
    private static final String f594a = "included";

    /* renamed from: b */
    private static final String f595b = "configuration";

    /* renamed from: c */
    private int f596c = 2;

    /* renamed from: a */
    private InputStream m20952a(URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            if (!c()) {
                a("Failed to open [" + url.toString() + "]", (Throwable) e);
            }
            return null;
        }
    }

    /* renamed from: a */
    private String m20956a(C0328d c0328d) {
        return c0328d.f616c.length() > 0 ? c0328d.f616c : c0328d.f615b;
    }

    /* renamed from: a */
    private void m20955a(C0329e c0329e) {
        boolean z;
        boolean z2;
        int i;
        C0328d c0328d;
        List<C0328d> m20922d = c0329e.m20922d();
        if (m20922d.size() == 0) {
            return;
        }
        C0328d c0328d2 = m20922d.get(0);
        if (c0328d2 != null) {
            String m20956a = m20956a(c0328d2);
            z2 = f594a.equalsIgnoreCase(m20956a);
            z = f595b.equalsIgnoreCase(m20956a);
        } else {
            z = false;
            z2 = false;
        }
        if (!z2 && !z) {
            return;
        }
        m20922d.remove(0);
        int size = m20922d.size();
        if (size == 0 || (c0328d = m20922d.get(size - 1)) == null) {
            return;
        }
        String m20956a2 = m20956a(c0328d);
        if ((!z2 || !f594a.equalsIgnoreCase(m20956a2)) && (!z || !f595b.equalsIgnoreCase(m20956a2))) {
            return;
        }
        m20922d.remove(i);
    }

    /* renamed from: a */
    protected C0329e mo20953a(InputStream inputStream, URL url) {
        return new C0329e(h_());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m20957a(int i) {
        this.f596c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b
    /* renamed from: a */
    public void mo20954a(C0344k c0344k, URL url) {
        InputStream m20952a = m20952a(url);
        try {
            if (m20952a != null) {
                C0351a.m20828b(h_(), url);
                C0329e mo20953a = mo20953a(m20952a, url);
                mo20953a.mo20233a(h_());
                mo20953a.m20928a(m20952a);
                m20955a(mo20953a);
                c0344k.m20874c().m20866a().m20888a(mo20953a.m20922d(), this.f596c);
            }
        } catch (C0346m e) {
            a("Failed processing [" + url.toString() + "]", (Throwable) e);
        } finally {
            a(m20952a);
        }
    }
}
