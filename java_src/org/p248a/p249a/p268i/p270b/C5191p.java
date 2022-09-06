package org.p248a.p249a.p268i.p270b;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p267h.C5142g;
@AbstractC5006c
@Deprecated
/* renamed from: org.a.a.i.b.p */
/* loaded from: classes.dex */
public class C5191p extends RequestWrapper implements HttpEntityEnclosingRequest {

    /* renamed from: a */
    private HttpEntity f21965a;

    /* renamed from: b */
    private boolean f21966b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.b.p$a */
    /* loaded from: classes2.dex */
    public class C5192a extends C5142g {
        C5192a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.p248a.p249a.p267h.C5142g
        public void consumeContent() {
            C5191p.this.f21966b = true;
            super.consumeContent();
        }

        @Override // org.p248a.p249a.p267h.C5142g
        public InputStream getContent() {
            C5191p.this.f21966b = true;
            return super.getContent();
        }

        @Override // org.p248a.p249a.p267h.C5142g
        public void writeTo(OutputStream outputStream) {
            C5191p.this.f21966b = true;
            super.writeTo(outputStream);
        }
    }

    public C5191p(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        super(httpEntityEnclosingRequest);
        setEntity(httpEntityEnclosingRequest.getEntity());
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader(C5083e.f21688w);
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public HttpEntity getEntity() {
        return this.f21965a;
    }

    public boolean isRepeatable() {
        return this.f21965a == null || this.f21965a.isRepeatable() || !this.f21966b;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.f21965a = httpEntity != null ? new C5192a(httpEntity) : null;
        this.f21966b = false;
    }
}
