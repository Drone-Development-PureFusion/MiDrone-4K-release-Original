package p004b.p005a.p006a.p028b.p041h.p043b;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* renamed from: b.a.a.b.h.b.b */
/* loaded from: classes.dex */
public class C0380b extends SocketFactory {

    /* renamed from: a */
    private final C0391m f785a;

    /* renamed from: b */
    private final SSLSocketFactory f786b;

    public C0380b(C0391m c0391m, SSLSocketFactory sSLSocketFactory) {
        this.f785a = c0391m;
        this.f786b = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f786b.createSocket(str, i);
        this.f785a.m20665a(new C0387i(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f786b.createSocket(str, i, inetAddress, i2);
        this.f785a.m20665a(new C0387i(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f786b.createSocket(inetAddress, i);
        this.f785a.m20665a(new C0387i(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f786b.createSocket(inetAddress, i, inetAddress2, i2);
        this.f785a.m20665a(new C0387i(sSLSocket));
        return sSLSocket;
    }
}
