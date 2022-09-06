package org.p248a.p249a.p268i.p274f;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.p248a.p249a.p250a.AbstractC5006c;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5006c
/* renamed from: org.a.a.i.f.j */
/* loaded from: classes.dex */
class C5286j implements HttpEntity {

    /* renamed from: a */
    private final HttpEntity f22226a;

    /* renamed from: b */
    private boolean f22227b = false;

    C5286j(HttpEntity httpEntity) {
        this.f22226a = httpEntity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1517a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null || entity.isRepeatable() || m1518a(entity)) {
            return;
        }
        httpEntityEnclosingRequest.setEntity(new C5286j(entity));
    }

    /* renamed from: a */
    static boolean m1518a(HttpEntity httpEntity) {
        return httpEntity instanceof C5286j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m1516a(HttpRequest httpRequest) {
        HttpEntity entity;
        if (!(httpRequest instanceof HttpEntityEnclosingRequest) || (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) == null) {
            return true;
        }
        if (m1518a(entity) && !((C5286j) entity).m1515b()) {
            return true;
        }
        return entity.isRepeatable();
    }

    /* renamed from: a */
    public HttpEntity m1519a() {
        return this.f22226a;
    }

    /* renamed from: b */
    public boolean m1515b() {
        return this.f22227b;
    }

    @Deprecated
    public void consumeContent() {
        this.f22227b = true;
        this.f22226a.consumeContent();
    }

    public InputStream getContent() {
        return this.f22226a.getContent();
    }

    public Header getContentEncoding() {
        return this.f22226a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f22226a.getContentLength();
    }

    public Header getContentType() {
        return this.f22226a.getContentType();
    }

    public boolean isChunked() {
        return this.f22226a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f22226a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f22226a.isStreaming();
    }

    public String toString() {
        return "RequestEntityProxy{" + this.f22226a + C0359h.f726w;
    }

    public void writeTo(OutputStream outputStream) {
        this.f22227b = true;
        this.f22226a.writeTo(outputStream);
    }
}
