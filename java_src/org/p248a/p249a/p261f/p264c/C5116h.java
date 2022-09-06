package org.p248a.p249a.p261f.p264c;

import java.net.Socket;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.f.c.h */
/* loaded from: classes2.dex */
public class C5116h {

    /* renamed from: a */
    static final String f21751a = "TLS";

    /* renamed from: b */
    static final String f21752b = "SSL";

    /* renamed from: c */
    private String f21753c;

    /* renamed from: d */
    private Set<KeyManager> f21754d = new HashSet();

    /* renamed from: e */
    private Set<TrustManager> f21755e = new HashSet();

    /* renamed from: f */
    private SecureRandom f21756f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.f.c.h$a */
    /* loaded from: classes2.dex */
    public static class C5117a implements X509KeyManager {

        /* renamed from: a */
        private final X509KeyManager f21757a;

        /* renamed from: b */
        private final AbstractC5114f f21758b;

        C5117a(X509KeyManager x509KeyManager, AbstractC5114f abstractC5114f) {
            this.f21757a = x509KeyManager;
            this.f21758b = abstractC5114f;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            HashMap hashMap = new HashMap();
            for (String str : strArr) {
                String[] clientAliases = this.f21757a.getClientAliases(str, principalArr);
                if (clientAliases != null) {
                    for (String str2 : clientAliases) {
                        hashMap.put(str2, new C5113e(str, this.f21757a.getCertificateChain(str2)));
                    }
                }
            }
            return this.f21758b.m1994a(hashMap, socket);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            HashMap hashMap = new HashMap();
            String[] serverAliases = this.f21757a.getServerAliases(str, principalArr);
            if (serverAliases != null) {
                for (String str2 : serverAliases) {
                    hashMap.put(str2, new C5113e(str, this.f21757a.getCertificateChain(str2)));
                }
            }
            return this.f21758b.m1994a(hashMap, socket);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String str) {
            return this.f21757a.getCertificateChain(str);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String str, Principal[] principalArr) {
            return this.f21757a.getClientAliases(str, principalArr);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String str) {
            return this.f21757a.getPrivateKey(str);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String str, Principal[] principalArr) {
            return this.f21757a.getServerAliases(str, principalArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.f.c.h$b */
    /* loaded from: classes2.dex */
    public static class C5118b implements X509TrustManager {

        /* renamed from: a */
        private final X509TrustManager f21759a;

        /* renamed from: b */
        private final AbstractC5124n f21760b;

        C5118b(X509TrustManager x509TrustManager, AbstractC5124n abstractC5124n) {
            this.f21759a = x509TrustManager;
            this.f21760b = abstractC5124n;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f21759a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (!this.f21760b.mo1964a(x509CertificateArr, str)) {
                this.f21759a.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f21759a.getAcceptedIssuers();
        }
    }

    /* renamed from: a */
    public C5116h m1984a() {
        this.f21753c = "TLS";
        return this;
    }

    /* renamed from: a */
    public C5116h m1983a(String str) {
        this.f21753c = str;
        return this;
    }

    /* renamed from: a */
    public C5116h m1982a(KeyStore keyStore) {
        return m1981a(keyStore, (AbstractC5124n) null);
    }

    /* renamed from: a */
    public C5116h m1981a(KeyStore keyStore, AbstractC5124n abstractC5124n) {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers != null) {
            if (abstractC5124n != null) {
                for (int i = 0; i < trustManagers.length; i++) {
                    TrustManager trustManager = trustManagers[i];
                    if (trustManager instanceof X509TrustManager) {
                        trustManagers[i] = new C5118b((X509TrustManager) trustManager, abstractC5124n);
                    }
                }
            }
            for (TrustManager trustManager2 : trustManagers) {
                this.f21755e.add(trustManager2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5116h m1980a(KeyStore keyStore, char[] cArr) {
        m1979a(keyStore, cArr, null);
        return this;
    }

    /* renamed from: a */
    public C5116h m1979a(KeyStore keyStore, char[] cArr, AbstractC5114f abstractC5114f) {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, cArr);
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        if (keyManagers != null) {
            if (abstractC5114f != null) {
                for (int i = 0; i < keyManagers.length; i++) {
                    KeyManager keyManager = keyManagers[i];
                    if (keyManager instanceof X509KeyManager) {
                        keyManagers[i] = new C5117a((X509KeyManager) keyManager, abstractC5114f);
                    }
                }
            }
            for (KeyManager keyManager2 : keyManagers) {
                this.f21754d.add(keyManager2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5116h m1978a(SecureRandom secureRandom) {
        this.f21756f = secureRandom;
        return this;
    }

    /* renamed from: b */
    public C5116h m1977b() {
        this.f21753c = "SSL";
        return this;
    }

    /* renamed from: c */
    public SSLContext m1976c() {
        SSLContext sSLContext = SSLContext.getInstance(this.f21753c != null ? this.f21753c : "TLS");
        sSLContext.init(!this.f21754d.isEmpty() ? (KeyManager[]) this.f21754d.toArray(new KeyManager[this.f21754d.size()]) : null, !this.f21755e.isEmpty() ? (TrustManager[]) this.f21755e.toArray(new TrustManager[this.f21755e.size()]) : null, this.f21756f);
        return sSLContext;
    }
}
