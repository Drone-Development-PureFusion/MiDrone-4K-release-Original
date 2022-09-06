package p244m.framework.p245a;

import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.p248a.p249a.p261f.p264c.C5115g;
/* renamed from: m.framework.a.i */
/* loaded from: classes2.dex */
public class C4946i extends SSLSocketFactory {

    /* renamed from: a */
    SSLContext f21285a = SSLContext.getInstance(C5115g.f21740a);

    public C4946i(KeyStore keyStore) {
        super(keyStore);
        this.f21285a.init(null, new TrustManager[]{new X509TrustManager() { // from class: m.framework.a.i.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.f21285a.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.f21285a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
