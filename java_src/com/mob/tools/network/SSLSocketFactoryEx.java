package com.mob.tools.network;

import com.mob.tools.network.NetworkHelper;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.p248a.p249a.p261f.p264c.C5115g;
/* loaded from: classes.dex */
public class SSLSocketFactoryEx extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance(C5115g.f21740a);

    public SSLSocketFactoryEx(KeyStore keyStore) {
        super(keyStore);
        this.sslContext.init(null, new TrustManager[]{new NetworkHelper.SimpleX509TrustManager(null)}, new SecureRandom());
    }

    public void allowAllHostnameVerifier() {
        setHostnameVerifier(STRICT_HOSTNAME_VERIFIER);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.sslContext.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }
}
