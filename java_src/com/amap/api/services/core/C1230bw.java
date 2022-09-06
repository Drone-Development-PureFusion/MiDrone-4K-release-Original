package com.amap.api.services.core;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
/* renamed from: com.amap.api.services.core.bw */
/* loaded from: classes.dex */
class C1230bw implements X509TrustManager {
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
