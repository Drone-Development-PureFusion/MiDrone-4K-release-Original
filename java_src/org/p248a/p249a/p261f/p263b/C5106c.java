package org.p248a.p249a.p261f.p263b;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.f.b.c */
/* loaded from: classes2.dex */
public class C5106c implements AbstractC5104a {

    /* renamed from: a */
    public static final C5106c f21728a = new C5106c();

    /* renamed from: a */
    public static C5106c m2018a() {
        return f21728a;
    }

    @Override // org.p248a.p249a.p261f.p263b.AbstractC5104a
    /* renamed from: a */
    public Socket mo1992a(int i, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) {
        if (socket == null) {
            socket = mo1987a(httpContext);
        }
        if (inetSocketAddress2 != null) {
            socket.bind(inetSocketAddress2);
        }
        try {
            socket.connect(inetSocketAddress, i);
            return socket;
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e2) {
            }
            throw e;
        }
    }

    @Override // org.p248a.p249a.p261f.p263b.AbstractC5104a
    /* renamed from: a */
    public Socket mo1987a(HttpContext httpContext) {
        return new Socket();
    }
}
