package org.p248a.p249a.p268i;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.i.k */
/* loaded from: classes2.dex */
public class C5316k implements ConnectionReuseStrategy {

    /* renamed from: a */
    public static final C5316k f22323a = new C5316k();

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}
