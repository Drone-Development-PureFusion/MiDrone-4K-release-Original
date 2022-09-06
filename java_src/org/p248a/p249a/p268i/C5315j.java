package org.p248a.p249a.p268i;

import com.p078a.p079a.AbstractC0735l;
import it.p235a.p236a.AbstractC4863e;
import java.util.Locale;
import org.apache.http.ReasonPhraseCatalog;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.j */
/* loaded from: classes2.dex */
public class C5315j implements ReasonPhraseCatalog {

    /* renamed from: a */
    public static final C5315j f22321a = new C5315j();

    /* renamed from: b */
    private static final String[][] f22322b = {null, new String[3], new String[8], new String[8], new String[25], new String[8]};

    static {
        m1470a(200, "OK");
        m1470a(201, "Created");
        m1470a(202, "Accepted");
        m1470a(204, "No Content");
        m1470a(301, "Moved Permanently");
        m1470a(302, "Moved Temporarily");
        m1470a(304, "Not Modified");
        m1470a(400, "Bad Request");
        m1470a(401, "Unauthorized");
        m1470a(403, "Forbidden");
        m1470a(404, "Not Found");
        m1470a(500, "Internal Server Error");
        m1470a(AbstractC4863e.f20793b, "Not Implemented");
        m1470a(AbstractC4863e.f20794c, "Bad Gateway");
        m1470a(AbstractC4863e.f20795d, "Service Unavailable");
        m1470a(100, "Continue");
        m1470a(307, "Temporary Redirect");
        m1470a(405, "Method Not Allowed");
        m1470a(409, "Conflict");
        m1470a(412, "Precondition Failed");
        m1470a(413, "Request Too Long");
        m1470a(414, "Request-URI Too Long");
        m1470a(415, "Unsupported Media Type");
        m1470a(300, "Multiple Choices");
        m1470a(303, "See Other");
        m1470a(305, "Use Proxy");
        m1470a(402, "Payment Required");
        m1470a(406, "Not Acceptable");
        m1470a(407, "Proxy Authentication Required");
        m1470a(408, "Request Timeout");
        m1470a(101, "Switching Protocols");
        m1470a(203, "Non Authoritative Information");
        m1470a(205, "Reset Content");
        m1470a(206, "Partial Content");
        m1470a(AbstractC4863e.f20796e, "Gateway Timeout");
        m1470a(505, "Http Version Not Supported");
        m1470a(410, "Gone");
        m1470a(411, "Length Required");
        m1470a(416, "Requested Range Not Satisfiable");
        m1470a(417, "Expectation Failed");
        m1470a(102, "Processing");
        m1470a(207, "Multi-Status");
        m1470a(422, "Unprocessable Entity");
        m1470a(419, "Insufficient Space On Resource");
        m1470a(AbstractC0735l.f1816g, "Method Failure");
        m1470a(423, "Locked");
        m1470a(507, "Insufficient Storage");
        m1470a(424, "Failed Dependency");
    }

    protected C5315j() {
    }

    /* renamed from: a */
    private static void m1470a(int i, String str) {
        int i2 = i / 100;
        f22322b[i2][i - (i2 * 100)] = str;
    }

    public String getReason(int i, Locale locale) {
        C5351a.m1319a(i >= 100 && i < 600, "Unknown category for status code " + i);
        int i2 = i / 100;
        int i3 = i - (i2 * 100);
        if (f22322b[i2].length > i3) {
            return f22322b[i2][i3];
        }
        return null;
    }
}
