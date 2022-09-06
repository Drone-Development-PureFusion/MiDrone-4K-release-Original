package org.p248a.p249a.p268i;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p255c.C5041h;
import org.p248a.p249a.p252c.p255c.C5042i;
import org.p248a.p249a.p252c.p255c.C5045l;
import org.p248a.p249a.p252c.p255c.C5050o;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.h */
/* loaded from: classes2.dex */
public class C5310h implements HttpRequestFactory {

    /* renamed from: a */
    public static final C5310h f22309a = new C5310h();

    /* renamed from: b */
    private static final String[] f22310b = {"GET"};

    /* renamed from: c */
    private static final String[] f22311c = {"POST", C5045l.f21547a};

    /* renamed from: d */
    private static final String[] f22312d = {C5041h.f21543a, C5042i.f21544a, "DELETE", C5050o.f21556a, "CONNECT"};

    /* renamed from: a */
    private static boolean m1475a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpRequest newHttpRequest(String str, String str2) {
        if (m1475a(f22310b, str)) {
            return new BasicHttpRequest(str, str2);
        }
        if (m1475a(f22311c, str)) {
            return new BasicHttpEntityEnclosingRequest(str, str2);
        }
        if (!m1475a(f22312d, str)) {
            throw new MethodNotSupportedException(str + " method not supported");
        }
        return new BasicHttpRequest(str, str2);
    }

    public HttpRequest newHttpRequest(RequestLine requestLine) {
        C5351a.m1321a(requestLine, "Request line");
        String method = requestLine.getMethod();
        if (m1475a(f22310b, method)) {
            return new BasicHttpRequest(requestLine);
        }
        if (m1475a(f22311c, method)) {
            return new BasicHttpEntityEnclosingRequest(requestLine);
        }
        if (!m1475a(f22312d, method)) {
            throw new MethodNotSupportedException(method + " method not supported");
        }
        return new BasicHttpRequest(requestLine);
    }
}
