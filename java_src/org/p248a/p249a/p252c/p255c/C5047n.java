package org.p248a.p249a.p252c.p255c;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.c.c.n */
/* loaded from: classes.dex */
public class C5047n extends AbstractHttpMessage implements HttpUriRequest {

    /* renamed from: a */
    private final HttpRequest f21551a;

    /* renamed from: b */
    private final String f21552b;

    /* renamed from: c */
    private ProtocolVersion f21553c;

    /* renamed from: d */
    private URI f21554d;

    /* renamed from: org.a.a.c.c.n$a */
    /* loaded from: classes2.dex */
    static class C5049a extends C5047n implements HttpEntityEnclosingRequest {

        /* renamed from: a */
        private HttpEntity f21555a;

        public C5049a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
            super(httpEntityEnclosingRequest);
            this.f21555a = httpEntityEnclosingRequest.getEntity();
        }

        public boolean expectContinue() {
            Header firstHeader = getFirstHeader(C5083e.f21688w);
            return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
        }

        public HttpEntity getEntity() {
            return this.f21555a;
        }

        public void setEntity(HttpEntity httpEntity) {
            this.f21555a = httpEntity;
        }
    }

    private C5047n(HttpRequest httpRequest) {
        this.f21551a = httpRequest;
        this.f21553c = this.f21551a.getRequestLine().getProtocolVersion();
        this.f21552b = this.f21551a.getRequestLine().getMethod();
        if (httpRequest instanceof HttpUriRequest) {
            this.f21554d = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.f21554d = null;
        }
        setHeaders(httpRequest.getAllHeaders());
    }

    /* renamed from: a */
    public static C5047n m2221a(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return null;
        }
        return httpRequest instanceof HttpEntityEnclosingRequest ? new C5049a((HttpEntityEnclosingRequest) httpRequest) : new C5047n(httpRequest);
    }

    /* renamed from: a */
    public HttpRequest m2223a() {
        return this.f21551a;
    }

    /* renamed from: a */
    public void m2222a(URI uri) {
        this.f21554d = uri;
    }

    /* renamed from: a */
    public void m2220a(ProtocolVersion protocolVersion) {
        this.f21553c = protocolVersion;
    }

    public void abort() {
        throw new UnsupportedOperationException();
    }

    public String getMethod() {
        return this.f21552b;
    }

    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = this.f21551a.getParams().copy();
        }
        return this.params;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.f21553c != null ? this.f21553c : this.f21551a.getProtocolVersion();
    }

    public RequestLine getRequestLine() {
        String aSCIIString = this.f21554d != null ? this.f21554d.toASCIIString() : this.f21551a.getRequestLine().getUri();
        if (aSCIIString == null || aSCIIString.length() == 0) {
            aSCIIString = "/";
        }
        return new BasicRequestLine(this.f21552b, aSCIIString, getProtocolVersion());
    }

    public URI getURI() {
        return this.f21554d;
    }

    public boolean isAborted() {
        return false;
    }

    public String toString() {
        return getRequestLine() + " " + this.headergroup;
    }
}
