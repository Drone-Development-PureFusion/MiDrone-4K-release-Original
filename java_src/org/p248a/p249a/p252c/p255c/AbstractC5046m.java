package org.p248a.p249a.p252c.p255c;

import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpProtocolParams;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p253a.C5019c;
@AbstractC5006c
/* renamed from: org.a.a.c.c.m */
/* loaded from: classes2.dex */
public abstract class AbstractC5046m extends AbstractC5032a implements AbstractC5036c, HttpUriRequest {

    /* renamed from: a */
    private ProtocolVersion f21548a;

    /* renamed from: b */
    private URI f21549b;

    /* renamed from: c */
    private C5019c f21550c;

    /* renamed from: a */
    public void m2229a(URI uri) {
        this.f21549b = uri;
    }

    /* renamed from: a */
    public void m2228a(C5019c c5019c) {
        this.f21550c = c5019c;
    }

    /* renamed from: a */
    public void m2227a(ProtocolVersion protocolVersion) {
        this.f21548a = protocolVersion;
    }

    /* renamed from: c */
    public void m2226c() {
    }

    /* renamed from: d */
    public void m2225d() {
        b();
    }

    public abstract String getMethod();

    public ProtocolVersion getProtocolVersion() {
        return this.f21548a != null ? this.f21548a : HttpProtocolParams.getVersion(getParams());
    }

    public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri = getURI();
        String str = null;
        if (uri != null) {
            str = uri.toASCIIString();
        }
        if (str == null || str.length() == 0) {
            str = "/";
        }
        return new BasicRequestLine(method, str, protocolVersion);
    }

    public URI getURI() {
        return this.f21549b;
    }

    @Override // org.p248a.p249a.p252c.p255c.AbstractC5036c
    /* renamed from: l_ */
    public C5019c mo2224l_() {
        return this.f21550c;
    }

    public String toString() {
        return getMethod() + " " + getURI() + " " + getProtocolVersion();
    }
}
