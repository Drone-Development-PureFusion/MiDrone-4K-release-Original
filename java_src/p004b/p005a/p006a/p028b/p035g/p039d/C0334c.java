package p004b.p005a.p006a.p028b.p035g.p039d;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.g.d.c */
/* loaded from: classes.dex */
public class C0334c extends C0527f {

    /* renamed from: a */
    URL f625a;

    /* renamed from: b */
    List<File> f626b = new ArrayList();

    /* renamed from: c */
    List<Long> f627c = new ArrayList();

    /* renamed from: d */
    private void m20912d(URL url) {
        File m20914c = m20914c(url);
        if (m20914c != null) {
            this.f626b.add(m20914c);
            this.f627c.add(Long.valueOf(m20914c.lastModified()));
        }
    }

    /* renamed from: a */
    public void m20919a() {
        this.f625a = null;
        this.f627c.clear();
        this.f626b.clear();
    }

    /* renamed from: a */
    public void m20918a(URL url) {
        this.f625a = url;
        if (url != null) {
            m20912d(url);
        }
    }

    /* renamed from: b */
    public URL m20917b() {
        return this.f625a;
    }

    /* renamed from: b */
    public void m20916b(URL url) {
        m20912d(url);
    }

    /* renamed from: c */
    File m20914c(URL url) {
        if ("file".equals(url.getProtocol())) {
            return new File(URLDecoder.decode(url.getFile()));
        }
        d("URL [" + url + "] is not of type file");
        return null;
    }

    /* renamed from: c */
    public List<File> m20915c() {
        return new ArrayList(this.f626b);
    }

    /* renamed from: d */
    public boolean m20913d() {
        int size = this.f626b.size();
        for (int i = 0; i < size; i++) {
            if (this.f627c.get(i).longValue() != this.f626b.get(i).lastModified()) {
                return true;
            }
        }
        return false;
    }
}
