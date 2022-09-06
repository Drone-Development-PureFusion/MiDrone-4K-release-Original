package org.p248a.p249a.p268i.p274f;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5006c
/* renamed from: org.a.a.i.f.d */
/* loaded from: classes.dex */
class C5280d implements AbstractC5035b {

    /* renamed from: a */
    private final HttpResponse f22201a;

    /* renamed from: b */
    private final C5279c f22202b;

    public C5280d(HttpResponse httpResponse, C5279c c5279c) {
        this.f22201a = httpResponse;
        this.f22202b = c5279c;
        C5287k.m1513a(httpResponse, c5279c);
    }

    public void addHeader(String str, String str2) {
        this.f22201a.addHeader(str, str2);
    }

    public void addHeader(Header header) {
        this.f22201a.addHeader(header);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f22202b != null) {
            this.f22202b.abortConnection();
        }
    }

    public boolean containsHeader(String str) {
        return this.f22201a.containsHeader(str);
    }

    public Header[] getAllHeaders() {
        return this.f22201a.getAllHeaders();
    }

    public HttpEntity getEntity() {
        return this.f22201a.getEntity();
    }

    public Header getFirstHeader(String str) {
        return this.f22201a.getFirstHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.f22201a.getHeaders(str);
    }

    public Header getLastHeader(String str) {
        return this.f22201a.getLastHeader(str);
    }

    public Locale getLocale() {
        return this.f22201a.getLocale();
    }

    @Deprecated
    public HttpParams getParams() {
        return this.f22201a.getParams();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.f22201a.getProtocolVersion();
    }

    public StatusLine getStatusLine() {
        return this.f22201a.getStatusLine();
    }

    public HeaderIterator headerIterator() {
        return this.f22201a.headerIterator();
    }

    public HeaderIterator headerIterator(String str) {
        return this.f22201a.headerIterator(str);
    }

    public void removeHeader(Header header) {
        this.f22201a.removeHeader(header);
    }

    public void removeHeaders(String str) {
        this.f22201a.removeHeaders(str);
    }

    public void setEntity(HttpEntity httpEntity) {
        this.f22201a.setEntity(httpEntity);
    }

    public void setHeader(String str, String str2) {
        this.f22201a.setHeader(str, str2);
    }

    public void setHeader(Header header) {
        this.f22201a.setHeader(header);
    }

    public void setHeaders(Header[] headerArr) {
        this.f22201a.setHeaders(headerArr);
    }

    public void setLocale(Locale locale) {
        this.f22201a.setLocale(locale);
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.f22201a.setParams(httpParams);
    }

    public void setReasonPhrase(String str) {
        this.f22201a.setReasonPhrase(str);
    }

    public void setStatusCode(int i) {
        this.f22201a.setStatusCode(i);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i) {
        this.f22201a.setStatusLine(protocolVersion, i);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.f22201a.setStatusLine(protocolVersion, i, str);
    }

    public void setStatusLine(StatusLine statusLine) {
        this.f22201a.setStatusLine(statusLine);
    }

    public String toString() {
        return "HttpResponseProxy{" + this.f22201a + C0359h.f726w;
    }
}
