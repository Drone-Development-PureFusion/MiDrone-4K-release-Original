package org.p248a.p249a.p252c.p255c;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p258f.C5067a;
@AbstractC5006c
/* renamed from: org.a.a.c.c.e */
/* loaded from: classes2.dex */
public abstract class AbstractC5038e extends AbstractC5046m implements HttpEntityEnclosingRequest {

    /* renamed from: a */
    private HttpEntity f21541a;

    @Override // org.p248a.p249a.p252c.p255c.AbstractC5032a
    public Object clone() {
        AbstractC5038e abstractC5038e = (AbstractC5038e) super.clone();
        if (this.f21541a != null) {
            abstractC5038e.f21541a = (HttpEntity) C5067a.m2157a(this.f21541a);
        }
        return abstractC5038e;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader(C5083e.f21688w);
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public HttpEntity getEntity() {
        return this.f21541a;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.f21541a = httpEntity;
    }
}
