package org.p248a.p249a.p261f;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.p248a.p249a.p282o.C5351a;
@Deprecated
/* renamed from: org.a.a.f.f */
/* loaded from: classes.dex */
public class C5128f extends InetSocketAddress {
    private static final long serialVersionUID = -6650701828361907957L;

    /* renamed from: a */
    private final HttpHost f21775a;

    public C5128f(HttpHost httpHost, InetAddress inetAddress, int i) {
        super(inetAddress, i);
        C5351a.m1321a(httpHost, "HTTP host");
        this.f21775a = httpHost;
    }

    /* renamed from: a */
    public HttpHost m1958a() {
        return this.f21775a;
    }

    @Override // java.net.InetSocketAddress
    public String toString() {
        return this.f21775a.getHostName() + ":" + getPort();
    }
}
