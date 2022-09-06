package org.p248a.p249a.p261f.p262a;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
@Deprecated
/* renamed from: org.a.a.f.a.h */
/* loaded from: classes.dex */
class C5102h implements SocketFactory {

    /* renamed from: a */
    private final AbstractC5100f f21727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5102h(AbstractC5100f abstractC5100f) {
        this.f21727a = abstractC5100f;
    }

    /* renamed from: a */
    public AbstractC5100f m2019a() {
        return this.f21727a;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        InetSocketAddress inetSocketAddress = null;
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        }
        return this.f21727a.mo2021a(socket, new InetSocketAddress(InetAddress.getByName(str), i), inetSocketAddress, httpParams);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.f21727a.mo2020a(new BasicHttpParams());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof C5102h ? this.f21727a.equals(((C5102h) obj).f21727a) : this.f21727a.equals(obj);
    }

    public int hashCode() {
        return this.f21727a.hashCode();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) {
        return this.f21727a.mo2022a(socket);
    }
}
