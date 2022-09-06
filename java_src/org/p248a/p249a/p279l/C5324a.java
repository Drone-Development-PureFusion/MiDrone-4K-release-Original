package org.p248a.p249a.p279l;

import java.nio.charset.Charset;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p260e.C5091f;
@Deprecated
/* renamed from: org.a.a.l.a */
/* loaded from: classes.dex */
public final class C5324a {
    private C5324a() {
    }

    /* renamed from: a */
    public static C5091f m1428a(HttpParams httpParams) {
        return C5091f.m2032g().m2030a(httpParams.getIntParameter("http.socket.timeout", 0)).m2028b(httpParams.getIntParameter("http.socket.linger", -1)).m2026c(httpParams.getBooleanParameter("http.tcp.nodelay", true)).m2031a();
    }

    /* renamed from: b */
    public static C5087c m1427b(HttpParams httpParams) {
        return C5087c.m2047d().m2044b(httpParams.getIntParameter("http.connection.max-header-count", -1)).m2045a(httpParams.getIntParameter("http.connection.max-line-length", -1)).m2046a();
    }

    /* renamed from: c */
    public static C5084a m1426c(HttpParams httpParams) {
        C5087c m1427b = m1427b(httpParams);
        String str = (String) httpParams.getParameter("http.protocol.element-charset");
        return C5084a.m2060h().m2057a(str != null ? Charset.forName(str) : null).m2055a(m1427b).m2059a();
    }
}
