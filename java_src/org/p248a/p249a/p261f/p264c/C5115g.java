package org.p248a.p249a.p261f.p264c;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p261f.p263b.AbstractC5105b;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5356f;
@AbstractC5007d
/* renamed from: org.a.a.f.c.g */
/* loaded from: classes2.dex */
public class C5115g implements AbstractC5105b {

    /* renamed from: a */
    public static final String f21740a = "TLS";

    /* renamed from: b */
    public static final String f21741b = "SSL";

    /* renamed from: c */
    public static final String f21742c = "SSLv2";

    /* renamed from: d */
    public static final X509HostnameVerifier f21743d = new C5109b();

    /* renamed from: e */
    public static final X509HostnameVerifier f21744e = new C5110c();

    /* renamed from: f */
    public static final X509HostnameVerifier f21745f = new C5121k();

    /* renamed from: g */
    private static final String f21746g = "HttpClient";

    /* renamed from: h */
    private final SSLSocketFactory f21747h;

    /* renamed from: i */
    private final X509HostnameVerifier f21748i;

    /* renamed from: j */
    private final String[] f21749j;

    /* renamed from: k */
    private final String[] f21750k;

    public C5115g(SSLContext sSLContext) {
        this(sSLContext, f21744e);
    }

    public C5115g(SSLContext sSLContext, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) C5351a.m1321a(sSLContext, "SSL context")).getSocketFactory(), (String[]) null, (String[]) null, x509HostnameVerifier);
    }

    public C5115g(SSLContext sSLContext, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) C5351a.m1321a(sSLContext, "SSL context")).getSocketFactory(), strArr, strArr2, x509HostnameVerifier);
    }

    public C5115g(SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        this(sSLSocketFactory, (String[]) null, (String[]) null, x509HostnameVerifier);
    }

    public C5115g(SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this.f21747h = (SSLSocketFactory) C5351a.m1321a(sSLSocketFactory, "SSL socket factory");
        this.f21749j = strArr;
        this.f21750k = strArr2;
        this.f21748i = x509HostnameVerifier == null ? f21744e : x509HostnameVerifier;
    }

    /* renamed from: a */
    public static C5115g m1993a() {
        return new C5115g((SSLSocketFactory) SSLSocketFactory.getDefault(), f21744e);
    }

    /* renamed from: a */
    private void m1988a(SSLSocket sSLSocket, String str) {
        try {
            if (Log.isLoggable(f21746g, 3)) {
                try {
                    SSLSession session = sSLSocket.getSession();
                    Log.d(f21746g, "Secure session established");
                    Log.d(f21746g, " negotiated protocol: " + session.getProtocol());
                    Log.d(f21746g, " negotiated cipher suite: " + session.getCipherSuite());
                    X509Certificate x509Certificate = (X509Certificate) session.getPeerCertificates()[0];
                    Log.d(f21746g, " peer principal: " + x509Certificate.getSubjectX500Principal().toString());
                    Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                    if (subjectAlternativeNames != null) {
                        ArrayList arrayList = new ArrayList();
                        for (List<?> list : subjectAlternativeNames) {
                            if (!list.isEmpty()) {
                                arrayList.add((String) list.get(1));
                            }
                        }
                        Log.d(f21746g, " peer alternative names: " + arrayList);
                    }
                    Log.d(f21746g, " issuer principal: " + x509Certificate.getIssuerX500Principal().toString());
                    Collection<List<?>> issuerAlternativeNames = x509Certificate.getIssuerAlternativeNames();
                    if (issuerAlternativeNames != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (List<?> list2 : issuerAlternativeNames) {
                            if (!list2.isEmpty()) {
                                arrayList2.add((String) list2.get(1));
                            }
                        }
                        Log.d(f21746g, " issuer alternative names: " + arrayList2);
                    }
                } catch (Exception e) {
                }
            }
            this.f21748i.verify(str, sSLSocket);
        } catch (IOException e2) {
            try {
                sSLSocket.close();
            } catch (Exception e3) {
            }
            throw e2;
        }
    }

    /* renamed from: a */
    private static String[] m1991a(String str) {
        if (C5356f.m1296b(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    /* renamed from: b */
    public static C5115g m1986b() {
        return new C5115g((SSLSocketFactory) SSLSocketFactory.getDefault(), m1991a(System.getProperty("https.protocols")), m1991a(System.getProperty("https.cipherSuites")), f21744e);
    }

    @Override // org.p248a.p249a.p261f.p263b.AbstractC5104a
    /* renamed from: a */
    public Socket mo1992a(int i, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) {
        C5351a.m1321a(httpHost, "HTTP host");
        C5351a.m1321a(inetSocketAddress, "Remote address");
        Socket mo1987a = socket != null ? socket : mo1987a(httpContext);
        if (inetSocketAddress2 != null) {
            mo1987a.bind(inetSocketAddress2);
        }
        if (i > 0) {
            try {
                if (mo1987a.getSoTimeout() == 0) {
                    mo1987a.setSoTimeout(i);
                }
            } catch (IOException e) {
                try {
                    mo1987a.close();
                } catch (IOException e2) {
                }
                throw e;
            }
        }
        if (Log.isLoggable(f21746g, 3)) {
            Log.d(f21746g, "Connecting socket to " + inetSocketAddress + " with timeout " + i);
        }
        mo1987a.connect(inetSocketAddress, i);
        if (mo1987a instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) mo1987a;
            if (Log.isLoggable(f21746g, 3)) {
                Log.d(f21746g, "Starting handshake");
            }
            sSLSocket.startHandshake();
            m1988a(sSLSocket, httpHost.getHostName());
            return mo1987a;
        }
        return mo1990a(mo1987a, httpHost.getHostName(), inetSocketAddress.getPort(), httpContext);
    }

    @Override // org.p248a.p249a.p261f.p263b.AbstractC5105b
    @TargetApi(17)
    /* renamed from: a */
    public Socket mo1990a(Socket socket, String str, int i, HttpContext httpContext) {
        SSLSocket sSLSocket = (SSLSocket) this.f21747h.createSocket(socket, str, i, true);
        if (this.f21749j != null) {
            sSLSocket.setEnabledProtocols(this.f21749j);
        } else {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            ArrayList arrayList = new ArrayList(enabledProtocols.length);
            for (String str2 : enabledProtocols) {
                if (!str2.startsWith("SSL")) {
                    arrayList.add(str2);
                }
            }
            if (!arrayList.isEmpty()) {
                sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }
        if (this.f21750k != null) {
            sSLSocket.setEnabledCipherSuites(this.f21750k);
        }
        if (Log.isLoggable(f21746g, 3)) {
            Log.d(f21746g, "Enabled protocols: " + Arrays.asList(sSLSocket.getEnabledProtocols()));
            Log.d(f21746g, "Enabled cipher suites:" + Arrays.asList(sSLSocket.getEnabledCipherSuites()));
        }
        m1989a(sSLSocket);
        if (Build.VERSION.SDK_INT >= 17) {
            if (Log.isLoggable(f21746g, 3)) {
                Log.d(f21746g, "Enabling SNI for " + str);
            }
            try {
                sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
            } catch (Exception e) {
                if (Log.isLoggable(f21746g, 3)) {
                    Log.d(f21746g, "SNI configuration failed", e);
                }
            }
        }
        if (Log.isLoggable(f21746g, 3)) {
            Log.d(f21746g, "Starting handshake");
        }
        sSLSocket.startHandshake();
        m1988a(sSLSocket, str);
        return sSLSocket;
    }

    @Override // org.p248a.p249a.p261f.p263b.AbstractC5104a
    /* renamed from: a */
    public Socket mo1987a(HttpContext httpContext) {
        return SocketFactory.getDefault().createSocket();
    }

    /* renamed from: a */
    protected void m1989a(SSLSocket sSLSocket) {
    }

    /* renamed from: c */
    X509HostnameVerifier m1985c() {
        return this.f21748i;
    }
}
