package org.p248a.p249a.p252c;

import java.util.Map;
import java.util.Queue;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p251b.C5009a;
/* renamed from: org.a.a.c.b */
/* loaded from: classes2.dex */
public interface AbstractC5021b {
    /* renamed from: a */
    Queue<C5009a> mo1786a(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext);

    /* renamed from: a */
    void mo1783a(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext);

    /* renamed from: a */
    boolean mo1784a(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext);

    /* renamed from: b */
    Map<String, Header> mo1781b(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext);

    /* renamed from: b */
    void mo1780b(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext);
}
