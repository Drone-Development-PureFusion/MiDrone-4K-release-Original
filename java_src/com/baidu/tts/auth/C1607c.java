package com.baidu.tts.auth;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p105j.AbstractC1725a;
import com.baidu.tts.p105j.AbstractCallableC1726b;
import com.baidu.tts.tools.StringTool;
import com.facebook.common.util.UriUtil;
import com.tencent.connect.common.Constants;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.p248a.p249a.p261f.p264c.C5115g;
/* renamed from: com.baidu.tts.auth.c */
/* loaded from: classes.dex */
public class C1607c implements AbstractCallableC1726b<C1607c, C1608a> {

    /* renamed from: a */
    private String f5700a;

    /* renamed from: b */
    private String f5701b;

    /* renamed from: c */
    private String f5702c;

    /* renamed from: com.baidu.tts.auth.c$a */
    /* loaded from: classes.dex */
    public static class C1608a implements AbstractC1725a {

        /* renamed from: a */
        private String f5703a;

        /* renamed from: b */
        private String f5704b;

        /* renamed from: c */
        private long f5705c;

        /* renamed from: d */
        private TtsError f5706d;

        /* renamed from: a */
        public String m15289a() {
            return this.f5704b;
        }

        /* renamed from: a */
        public void m15288a(long j) {
            this.f5705c = j;
        }

        /* renamed from: a */
        public void m15287a(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.m15091d("OnlineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.f5706d = ttsError;
        }

        /* renamed from: a */
        public void m15286a(String str) {
            this.f5703a = str;
        }

        /* renamed from: b */
        public TtsError m15285b() {
            return this.f5706d;
        }

        /* renamed from: b */
        public void m15284b(String str) {
            this.f5704b = str;
        }

        @Override // com.baidu.tts.p105j.AbstractC1725a
        /* renamed from: g */
        public boolean mo14832g() {
            if (StringTool.isEmpty(this.f5703a)) {
                return this.f5704b != null && System.currentTimeMillis() < this.f5705c;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.auth.c$b */
    /* loaded from: classes.dex */
    public class C1609b extends SSLSocketFactory {

        /* renamed from: a */
        SSLContext f5707a = SSLContext.getInstance(C5115g.f21740a);

        public C1609b(KeyStore keyStore) {
            super(keyStore);
            this.f5707a.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.baidu.tts.auth.c.b.1
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
            return this.f5707a.getSocketFactory().createSocket();
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return this.f5707a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    /* renamed from: a */
    private HttpClient m15299a(Context context) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            C1609b c1609b = new C1609b(keyStore);
            c1609b.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            ConnectManager connectManager = new ConnectManager(context);
            String proxy = connectManager.getProxy();
            String proxyPort = connectManager.getProxyPort();
            if (!TextUtils.isEmpty(proxy)) {
                basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(proxy, Integer.valueOf(proxyPort).intValue()));
            }
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(UriUtil.HTTP_SCHEME, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, c1609b, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    /* renamed from: a */
    private boolean m15296a(String str, String str2) {
        return !StringTool.isEmpty(str) && !StringTool.isEmpty(str2);
    }

    /* renamed from: b */
    private String m15293b(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("grant_type", "client_credentials"));
        linkedList.add(new BasicNameValuePair(Constants.PARAM_CLIENT_ID, str));
        linkedList.add(new BasicNameValuePair("client_secret", str2));
        return "https://openapi.baidu.com/oauth/2.0/token?" + URLEncodedUtils.format(linkedList, "utf-8");
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1607c c1607c) {
        String m15300a = c1607c.m15300a();
        if (StringTool.isEmpty(this.f5700a)) {
            String m15295b = c1607c.m15295b();
            String m15292c = c1607c.m15292c();
            LoggerProxy.m15091d("OnlineAuth", "mAK=" + this.f5701b + "--mSK=" + this.f5702c + "--ak2=" + m15295b + "--sk2=" + m15292c);
            return (!StringTool.isEqual(this.f5701b, m15295b) || !StringTool.isEqual(this.f5702c, m15292c)) ? 1 : 0;
        }
        LoggerProxy.m15091d("OnlineAuth", "mProductId=" + this.f5700a + "--productId2=" + m15300a);
        if (m15300a == null) {
            return 1;
        }
        return this.f5700a.compareTo(m15300a);
    }

    /* renamed from: a */
    public String m15300a() {
        return this.f5700a;
    }

    /* renamed from: a */
    public void m15297a(String str) {
        this.f5700a = str;
    }

    /* renamed from: b */
    public String m15295b() {
        return this.f5701b;
    }

    /* renamed from: b */
    public void m15294b(String str) {
        this.f5701b = str;
    }

    /* renamed from: c */
    public String m15292c() {
        return this.f5702c;
    }

    /* renamed from: c */
    public void m15291c(String str) {
        this.f5702c = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    public C1608a call() {
        LoggerProxy.m15091d("OnlineAuth", "enter online auth");
        C1608a c1608a = new C1608a();
        if (StringTool.isEmpty(this.f5700a)) {
            try {
                HttpClient m15299a = m15299a(C1719b.m14869a().m14864h());
                if (m15296a(this.f5701b, this.f5702c)) {
                    String m15293b = m15293b(this.f5701b, this.f5702c);
                    LoggerProxy.m15091d("OnlineAuth", "url=" + m15293b);
                    HttpResponse execute = m15299a.execute(new HttpPost(m15293b));
                    String entityUtils = EntityUtils.toString(execute.getEntity());
                    int statusCode = execute.getStatusLine().getStatusCode();
                    LoggerProxy.m15091d("OnlineAuth", "body=" + entityUtils + "--code=" + statusCode);
                    if (statusCode == 200) {
                        JSONObject jSONObject = new JSONObject(entityUtils);
                        if (jSONObject.has("access_token")) {
                            c1608a.m15284b(jSONObject.getString("access_token"));
                        } else {
                            c1608a.m15287a(C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_AUTH_FAILURE));
                        }
                        if (jSONObject.has("expires_in")) {
                            c1608a.m15288a(System.nanoTime() + (Math.min(jSONObject.getInt("expires_in"), 86400L) * 1000000000));
                        }
                    } else {
                        c1608a.m15287a(C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_AUTH_FAILURE));
                    }
                } else {
                    c1608a.m15287a(C1717c.m14880a().m14873b(EnumC1711n.TTS_PARAMETER_INVALID));
                }
            } catch (Exception e) {
                c1608a.m15287a(C1717c.m14880a().m14874a(EnumC1711n.ONLINE_ENGINE_AUTH_FAILURE, e));
            }
        } else {
            c1608a.m15286a(this.f5700a);
        }
        LoggerProxy.m15091d("OnlineAuth", "end online auth");
        return c1608a;
    }
}
