package org.p248a.p249a.p261f.p262a;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;
@Deprecated
/* renamed from: org.a.a.f.a.g */
/* loaded from: classes.dex */
class C5101g implements AbstractC5100f {

    /* renamed from: a */
    private final SocketFactory f21726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5101g(SocketFactory socketFactory) {
        this.f21726a = socketFactory;
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public Socket mo2021a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) {
        String hostName = inetSocketAddress.getHostName();
        int port = inetSocketAddress.getPort();
        InetAddress inetAddress = null;
        int i = 0;
        if (inetSocketAddress2 != null) {
            inetAddress = inetSocketAddress2.getAddress();
            i = inetSocketAddress2.getPort();
        }
        return this.f21726a.connectSocket(socket, hostName, port, inetAddress, i, httpParams);
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public Socket mo2020a(HttpParams httpParams) {
        return this.f21726a.createSocket();
    }

    /* renamed from: a */
    public SocketFactory m2023a() {
        return this.f21726a;
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public boolean mo2022a(Socket socket) {
        return this.f21726a.isSecure(socket);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof C5101g ? this.f21726a.equals(((C5101g) obj).f21726a) : this.f21726a.equals(obj);
    }

    public int hashCode() {
        return this.f21726a.hashCode();
    }
}
