package org.p248a.p249a.p252c.p257e;

import com.baidu.tts.loopj.AsyncHttpClient;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p254b.C5023b;
import org.p248a.p249a.p252c.p254b.C5028f;
@AbstractC5005b
/* renamed from: org.a.a.c.e.h */
/* loaded from: classes2.dex */
public class C5064h implements HttpResponseInterceptor {

    /* renamed from: a */
    public static final String f21584a = "http.client.response.uncompressed";

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Header contentEncoding;
        HeaderElement headerElement;
        boolean z = true;
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || entity.getContentLength() == 0 || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        HeaderElement[] elements = contentEncoding.getElements();
        if (0 < elements.length) {
            String lowerCase = elements[0].getName().toLowerCase(Locale.ENGLISH);
            if (AsyncHttpClient.ENCODING_GZIP.equals(lowerCase) || "x-gzip".equals(lowerCase)) {
                httpResponse.setEntity(new C5028f(httpResponse.getEntity()));
            } else if (!"deflate".equals(lowerCase)) {
                if ("identity".equals(lowerCase)) {
                    return;
                }
                throw new HttpException("Unsupported Content-Coding: " + headerElement.getName());
            } else {
                httpResponse.setEntity(new C5023b(httpResponse.getEntity()));
            }
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        httpResponse.removeHeaders("Content-Length");
        httpResponse.removeHeaders("Content-Encoding");
        httpResponse.removeHeaders("Content-MD5");
    }
}
