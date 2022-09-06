package org.p248a.p249a.p267h;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.g */
/* loaded from: classes.dex */
public class C5142g implements HttpEntity {

    /* renamed from: a */
    protected HttpEntity f21805a;

    public C5142g(HttpEntity httpEntity) {
        this.f21805a = (HttpEntity) C5351a.m1321a(httpEntity, "Wrapped entity");
    }

    @Deprecated
    public void consumeContent() {
        this.f21805a.consumeContent();
    }

    public InputStream getContent() {
        return this.f21805a.getContent();
    }

    public Header getContentEncoding() {
        return this.f21805a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f21805a.getContentLength();
    }

    public Header getContentType() {
        return this.f21805a.getContentType();
    }

    public boolean isChunked() {
        return this.f21805a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f21805a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f21805a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) {
        this.f21805a.writeTo(outputStream);
    }
}
