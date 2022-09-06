package org.p248a.p249a.p252c.p255c;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.c.c.i */
/* loaded from: classes2.dex */
public class C5042i extends AbstractC5046m {

    /* renamed from: a */
    public static final String f21544a = "OPTIONS";

    public C5042i() {
    }

    public C5042i(String str) {
        a(URI.create(str));
    }

    public C5042i(URI uri) {
        a(uri);
    }

    /* renamed from: a */
    public Set<String> m2230a(HttpResponse httpResponse) {
        C5351a.m1321a(httpResponse, "HTTP response");
        HeaderIterator headerIterator = httpResponse.headerIterator(C5083e.f21672g);
        HashSet hashSet = new HashSet();
        while (headerIterator.hasNext()) {
            for (HeaderElement headerElement : headerIterator.nextHeader().getElements()) {
                hashSet.add(headerElement.getName());
            }
        }
        return hashSet;
    }

    @Override // org.p248a.p249a.p252c.p255c.AbstractC5046m
    public String getMethod() {
        return f21544a;
    }
}
