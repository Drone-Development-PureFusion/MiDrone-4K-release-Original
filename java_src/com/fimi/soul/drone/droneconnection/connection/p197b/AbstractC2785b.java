package com.fimi.soul.drone.droneconnection.connection.p197b;

import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2799e;
import com.fimi.soul.drone.droneconnection.connection.C2779b;
import com.fimi.soul.utils.NetUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2785b extends AbstractC2799e {

    /* renamed from: a */
    private static final int f10316a = 20000;

    /* renamed from: o */
    private static final String f10317o = NetUtil.getSSL1234Key();

    /* renamed from: p */
    private static final String f10318p = "client.bks";

    /* renamed from: q */
    private static final String f10319q = "ca.bks";

    /* renamed from: i */
    private Socket f10320i;

    /* renamed from: j */
    private BufferedOutputStream f10321j;

    /* renamed from: k */
    private BufferedInputStream f10322k;

    /* renamed from: l */
    private String f10323l;

    /* renamed from: m */
    private int f10324m;

    /* renamed from: n */
    private String f10325n = null;

    /* renamed from: r */
    private SSLContext f10326r = null;

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.b.b$a */
    /* loaded from: classes.dex */
    public class C2789a implements X509TrustManager {

        /* renamed from: b */
        private X509TrustManager f10332b;

        public C2789a(KeyStore keyStore) {
            this.f10332b = null;
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 0) {
                throw new NoSuchAlgorithmException("no trust manager found");
            }
            this.f10332b = (X509TrustManager) trustManagers[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f10332b.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr == null) {
                this.f10332b.checkServerTrusted(x509CertificateArr, str);
                return;
            }
            for (X509Certificate x509Certificate : x509CertificateArr) {
                x509Certificate.checkValidity();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f10332b.getAcceptedIssuers();
        }
    }

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.b.b$b */
    /* loaded from: classes.dex */
    public class C2790b implements X509TrustManager {
        public C2790b() {
        }

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
    }

    /* renamed from: l */
    private void m10997l() {
        this.f10324m = mo11006a();
        this.f10323l = mo11001b();
        InetAddress byName = InetAddress.getByName(this.f10323l);
        this.f10325n = byName.toString();
        this.f10320i = new Socket();
        this.f10320i.setReuseAddress(true);
        if (this.f10320i == null) {
            return;
        }
        this.f10320i.setSoLinger(true, 0);
        this.f10320i.connect(new InetSocketAddress(byName, this.f10324m), 20000);
        this.f10320i.setTrafficClass(20);
        if (!this.f10320i.isConnected()) {
            return;
        }
        this.f10321j = new BufferedOutputStream(this.f10320i.getOutputStream());
        this.f10322k = new BufferedInputStream(this.f10320i.getInputStream());
    }

    /* renamed from: a */
    protected abstract int mo11006a();

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: b */
    public final int mo10940b(byte[] bArr) {
        if (this.f10322k != null) {
            return this.f10322k.read(bArr);
        }
        return -1;
    }

    /* renamed from: b */
    protected abstract String mo11001b();

    /* renamed from: c */
    public void m10999c() {
        this.f10324m = mo11006a();
        this.f10323l = mo11001b();
        try {
            this.f10325n = InetAddress.getByName(this.f10323l).toString();
            this.f10326r = SSLContext.getInstance("SSL");
            KeyStore keyStore = KeyStore.getInstance("BKS");
            keyStore.load(DroidPlannerApp.m12520g().getResources().getAssets().open(f10318p), f10317o.toCharArray());
            KeyStore keyStore2 = KeyStore.getInstance("BKS");
            keyStore2.load(DroidPlannerApp.m12520g().getResources().getAssets().open(f10319q), f10317o.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
            keyManagerFactory.init(keyStore, f10317o.toCharArray());
            TrustManagerFactory.getInstance("X509").init(keyStore2);
            TrustManager[] trustManagerArr = {new C2789a(keyStore2)};
            new TrustManager[1][0] = new C2790b();
            this.f10326r.init(keyManagerFactory.getKeyManagers(), trustManagerArr, null);
            SSLSocket sSLSocket = (SSLSocket) this.f10326r.getSocketFactory().createSocket(this.f10323l, this.f10324m);
            sSLSocket.setTrafficClass(20);
            sSLSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() { // from class: com.fimi.soul.drone.droneconnection.connection.b.b.3
                @Override // javax.net.ssl.HandshakeCompletedListener
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                }
            });
            sSLSocket.startHandshake();
            this.f10320i = sSLSocket;
            if (this.f10320i == null || !this.f10320i.isConnected()) {
                return;
            }
            this.f10321j = new BufferedOutputStream(this.f10320i.getOutputStream());
            this.f10322k = new BufferedInputStream(this.f10320i.getInputStream());
        } catch (Exception e) {
            h();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: d */
    public final void mo10937d() {
        if (!C2367d.m12459a().m12438k()) {
            m10997l();
        } else {
            m10999c();
        }
        C2779b.m11016b(false);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: d */
    public final void mo10935d(final byte[] bArr) {
        C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC2785b.this.f10321j == null || AbstractC2785b.this.f10321j == null) {
                    return;
                }
                try {
                    AbstractC2785b.this.f10321j.write(bArr);
                    AbstractC2785b.this.f10321j.flush();
                } catch (IOException e) {
                    AbstractC2785b.this.h();
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.fimi.soul.drone.droneconnection.connection.b.b$2] */
    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: e */
    public final void mo10934e() {
        if (this.f10320i != null) {
            new Thread() { // from class: com.fimi.soul.drone.droneconnection.connection.b.b.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        if (AbstractC2785b.this.f10322k != null) {
                            AbstractC2785b.this.f10322k.close();
                        }
                        if (AbstractC2785b.this.f10321j != null) {
                            AbstractC2785b.this.f10321j.close();
                        }
                        if (AbstractC2785b.this.f10320i != null) {
                            AbstractC2785b.this.f10320i.close();
                        }
                        AbstractC2785b.this.f10320i = null;
                        AbstractC2785b.this.f10322k = null;
                        AbstractC2785b.this.f10321j = null;
                    } catch (Exception e) {
                    }
                }
            }.start();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: j */
    public final int mo10926j() {
        return 3;
    }
}
