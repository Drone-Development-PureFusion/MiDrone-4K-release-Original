package p004b.p005a.p006a.p028b.p035g.p036a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC0300b extends AbstractC0301c {

    /* renamed from: a */
    private static final String f542a = "file";

    /* renamed from: b */
    private static final String f543b = "url";

    /* renamed from: c */
    private static final String f544c = "resource";

    /* renamed from: d */
    private static final String f545d = "optional";

    /* renamed from: m */
    private String f546m;

    /* renamed from: n */
    private boolean f547n;

    /* renamed from: o */
    private URL f548o;

    /* renamed from: a */
    private URL m20978a(C0344k c0344k, Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue(f544c);
        if (!C0589u.m20054e(value)) {
            this.f546m = c0344k.m20870f(value);
            return m20970f(this.f546m);
        } else if (!C0589u.m20054e(value2)) {
            this.f546m = c0344k.m20870f(value2);
            return m20976a(this.f546m);
        } else if (C0589u.m20054e(value3)) {
            throw new IllegalStateException("A URL stream should have been returned");
        } else {
            this.f546m = c0344k.m20870f(value3);
            return m20972b(this.f546m);
        }
    }

    /* renamed from: a */
    private URL m20976a(String str) {
        try {
            URL url = new URL(str);
            url.openStream().close();
            return url;
        } catch (MalformedURLException e) {
            if (!this.f547n) {
                mo20975a("URL [" + str + "] is not well formed.", (Exception) e);
            }
            return null;
        } catch (IOException e2) {
            if (!this.f547n) {
                mo20975a("URL [" + str + "] cannot be opened.", (Exception) e2);
            }
            return null;
        }
    }

    /* renamed from: a */
    private boolean m20974a(Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue(f544c);
        int i = !C0589u.m20054e(value) ? 1 : 0;
        if (!C0589u.m20054e(value2)) {
            i++;
        }
        if (!C0589u.m20054e(value3)) {
            i++;
        }
        if (i == 0) {
            mo20975a(String.format("One of \"%1$s\", \"%2$s\" or \"%3$s\" attributes must be set.", "file", f544c, "url"), (Exception) null);
            return false;
        } else if (i > 1) {
            mo20975a(String.format("Only one of \"%1$s\", \"%2$s\" or \"%3$s\" attributes should be set.", "file", f544c, "url"), (Exception) null);
            return false;
        } else if (i != 1) {
            throw new IllegalStateException("Count value [" + i + "] is not expected");
        } else {
            return true;
        }
    }

    /* renamed from: b */
    private URL m20972b(String str) {
        URL m20079a = C0585s.m20079a(str);
        if (m20079a == null) {
            if (this.f547n) {
                return null;
            }
            mo20975a("Could not find resource corresponding to [" + str + "]", (Exception) null);
            return null;
        }
        return m20079a;
    }

    /* renamed from: f */
    private URL m20970f(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            if (this.f547n) {
                return null;
            }
            mo20975a("File does not exist [" + str + "]", (Exception) new FileNotFoundException(str));
            return null;
        }
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public URL m20979a() {
        return this.f548o;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f546m = null;
        this.f547n = C0589u.m20059a(attributes.getValue(f545d), false);
        if (!m20974a(attributes)) {
            return;
        }
        try {
            URL m20978a = m20978a(c0344k, attributes);
            if (m20978a == null) {
                return;
            }
            mo20954a(c0344k, m20978a);
        } catch (C0346m e) {
            mo20975a("Error while parsing " + this.f546m, (Exception) e);
        }
    }

    /* renamed from: a */
    protected abstract void mo20954a(C0344k c0344k, URL url);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m20977a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    protected void mo20975a(String str, Exception exc) {
        a(str, (Throwable) exc);
    }

    /* renamed from: b */
    protected String m20973b() {
        return this.f546m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public boolean m20971c() {
        return this.f547n;
    }
}
