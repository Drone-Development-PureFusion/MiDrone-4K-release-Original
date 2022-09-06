package org.p248a.p249a.p268i.p271c;

import com.facebook.common.util.UriUtil;
import org.apache.http.HttpHost;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.C5132j;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.c.k */
/* loaded from: classes2.dex */
public class C5218k implements AbstractC5131i {

    /* renamed from: a */
    public static final C5218k f22086a = new C5218k();

    @Override // org.p248a.p249a.p261f.AbstractC5131i
    /* renamed from: a */
    public int mo1630a(HttpHost httpHost) {
        C5351a.m1321a(httpHost, "HTTP host");
        int port = httpHost.getPort();
        if (port > 0) {
            return port;
        }
        String schemeName = httpHost.getSchemeName();
        if (schemeName.equalsIgnoreCase(UriUtil.HTTP_SCHEME)) {
            return 80;
        }
        if (!schemeName.equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
            throw new C5132j(schemeName + " protocol is not supported");
        }
        return 443;
    }
}
