package p004b.p005a.p006a.p028b.p041h.p043b;

import java.net.InetAddress;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
/* renamed from: b.a.a.b.h.b.a */
/* loaded from: classes.dex */
public class C0379a extends ServerSocketFactory {

    /* renamed from: a */
    private final C0391m f783a;

    /* renamed from: b */
    private final SSLServerSocketFactory f784b;

    public C0379a(C0391m c0391m, SSLServerSocketFactory sSLServerSocketFactory) {
        this.f783a = c0391m;
        this.f784b = sSLServerSocketFactory;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f784b.createServerSocket(i);
        this.f783a.m20665a(new C0386h(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f784b.createServerSocket(i, i2);
        this.f783a.m20665a(new C0386h(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f784b.createServerSocket(i, i2, inetAddress);
        this.f783a.m20665a(new C0386h(sSLServerSocket));
        return sSLServerSocket;
    }
}
