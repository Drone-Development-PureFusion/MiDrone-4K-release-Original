package org.p248a.p249a.p252c.p256d;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.p252c.p253a.C5019c;
@Deprecated
/* renamed from: org.a.a.c.d.a */
/* loaded from: classes.dex */
public final class C5055a {
    private C5055a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0.isEmpty() != false) goto L18;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C5019c m2185a(HttpParams httpParams) {
        if (httpParams == null) {
            return null;
        }
        try {
            Field declaredField = httpParams.getClass().getDeclaredField("parameters");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(httpParams);
            if (map != null) {
            }
            return null;
        } catch (Exception e) {
        }
        return C5019c.m2278q().m2265d(httpParams.getIntParameter("http.socket.timeout", 0)).m2268b(httpParams.getBooleanParameter("http.connection.stalecheck", true)).m2267c(httpParams.getIntParameter("http.connection.timeout", 0)).m2271a(httpParams.getBooleanParameter("http.protocol.expect-continue", false)).m2272a((HttpHost) httpParams.getParameter("http.route.default-proxy")).m2274a((InetAddress) httpParams.getParameter("http.route.local-address")).m2262f(httpParams.getBooleanParameter("http.protocol.handle-authentication", true)).m2263e(httpParams.getBooleanParameter("http.protocol.allow-circular-redirects", false)).m2275a((String) httpParams.getParameter("http.protocol.cookie-policy")).m2276a(httpParams.getIntParameter("http.protocol.max-redirects", 50)).m2266c(httpParams.getBooleanParameter("http.protocol.handle-redirects", true)).m2264d(!httpParams.getBooleanParameter("http.protocol.reject-relative-redirect", false)).m2277a();
    }
}
