package org.p248a.p249a.p268i.p270b;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5005b
/* renamed from: org.a.a.i.b.f */
/* loaded from: classes2.dex */
public class C5181f implements ResponseHandler<String> {
    /* renamed from: a */
    public String handleResponse(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            C5354d.m1303b(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        } else if (entity != null) {
            return C5354d.m1299f(entity);
        } else {
            return null;
        }
    }
}
