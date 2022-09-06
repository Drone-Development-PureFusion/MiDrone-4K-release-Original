package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.facebook.common.util.UriUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.p223a.C4188a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p229b.C4343g;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p261f.p264c.C5115g;
import p004b.p005a.p006a.p007a.p025n.C0228a;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0383e;
/* loaded from: classes2.dex */
public class HttpUtils {

    /* renamed from: a */
    private static final String f18192a = HttpUtils.class.getName();

    /* loaded from: classes2.dex */
    public static class CustomSSLSocketFactory extends SSLSocketFactory {

        /* renamed from: a */
        private final SSLContext f18199a = SSLContext.getInstance(C5115g.f21740a);

        public CustomSSLSocketFactory(KeyStore keyStore) {
            super(keyStore);
            MyX509TrustManager myX509TrustManager;
            try {
                myX509TrustManager = new MyX509TrustManager();
            } catch (Exception e) {
                myX509TrustManager = null;
            }
            this.f18199a.init(null, new TrustManager[]{myX509TrustManager}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() {
            return this.f18199a.getSocketFactory().createSocket();
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return this.f18199a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    /* loaded from: classes2.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class MyX509TrustManager implements X509TrustManager {

        /* renamed from: a */
        X509TrustManager f18200a;

        MyX509TrustManager() {
            KeyStore keyStore;
            FileInputStream fileInputStream;
            Throwable th;
            FileInputStream fileInputStream2;
            TrustManager[] trustManagers;
            try {
                keyStore = KeyStore.getInstance(AbstractC0383e.f794b);
            } catch (Exception e) {
                keyStore = null;
            }
            TrustManager[] trustManagerArr = new TrustManager[0];
            if (keyStore != null) {
                try {
                    fileInputStream2 = new FileInputStream("trustedCerts");
                } catch (Throwable th2) {
                    fileInputStream = null;
                    th = th2;
                }
                try {
                    keyStore.load(fileInputStream2, "passphrase".toCharArray());
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    trustManagerFactory.init(keyStore);
                    trustManagers = trustManagerFactory.getTrustManagers();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } else {
                TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory2.init((KeyStore) null);
                trustManagers = trustManagerFactory2.getTrustManagers();
            }
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f18200a = (X509TrustManager) trustManagers[i];
                    return;
                }
            }
            throw new Exception("Couldn't initialize");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f18200a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f18200a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f18200a.getAcceptedIssuers();
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkProxy {
        public final String host;
        public final int port;

        private NetworkProxy(String str, int i) {
            this.host = str;
            this.port = i;
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    private HttpUtils() {
    }

    /* renamed from: a */
    private static int m5364a(Context context) {
        int port;
        if (Build.VERSION.SDK_INT < 11) {
            return (context == null || (port = Proxy.getPort(context)) < 0) ? Proxy.getDefaultPort() : port;
        }
        String property = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return -1;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: a */
    private static String m5362a(HttpResponse httpResponse) {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf(AsyncHttpClient.ENCODING_GZIP) <= -1) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
        }
    }

    /* renamed from: a */
    private static void m5363a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            C4188a.m5956a(context, qQToken, "requireApi", str);
        }
    }

    /* renamed from: b */
    private static String m5361b(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context == null) {
                return Proxy.getDefaultHost();
            }
            String host = Proxy.getHost(context);
            return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
        }
        return System.getProperty("http.proxyHost");
    }

    public static String encodePostBody(Bundle bundle, String str) {
        Object obj;
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            if (!(bundle.get(str2) instanceof String)) {
                i = i2;
            } else {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + C3947a.f16890a + C3947a.f16890a + ((String) obj));
                if (i2 < size - 1) {
                    sb.append("\r\n--" + str + C3947a.f16890a);
                }
                i = i2;
            }
        }
        return sb.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(URLEncoder.encode(Constants.ACCEPT_TIME_SEPARATOR_SP + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
                z = z;
            }
        }
        return sb.toString();
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int i;
        int i2 = 0;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(UriUtil.HTTP_SCHEME, PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 16) {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                CustomSSLSocketFactory customSSLSocketFactory = new CustomSSLSocketFactory(keyStore);
                customSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, customSSLSocketFactory, 443));
            } catch (Exception e) {
                schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, SSLSocketFactory.getSocketFactory(), 443));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        OpenConfig openConfig = context != null ? OpenConfig.getInstance(context, str) : null;
        if (openConfig != null) {
            i = openConfig.getInt("Common_HttpConnectionTimeout");
            i2 = openConfig.getInt("Common_SocketConnectionTimeout");
        } else {
            i = 0;
        }
        if (i == 0) {
            i = 15000;
        }
        if (i2 == 0) {
            i2 = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        NetworkProxy proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(proxy.host, proxy.port));
        }
        return defaultHttpClient;
    }

    public static NetworkProxy getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0) {
                String m5361b = m5361b(context);
                int m5364a = m5364a(context);
                if (!TextUtils.isEmpty(m5361b) && m5364a >= 0) {
                    return new NetworkProxy(m5361b, m5364a);
                }
            }
            return null;
        }
        return null;
    }

    public static Util.Statistic openUrl2(Context context, String str, String str2, Bundle bundle) {
        HttpUriRequest httpUriRequest;
        int i;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable())) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            String string = bundle2.getString("appid_for_getting_config");
            bundle2.remove("appid_for_getting_config");
            HttpClient httpClient = getHttpClient(context, string, str);
            if (str2.equals("GET")) {
                String encodeUrl = encodeUrl(bundle2);
                int length = 0 + encodeUrl.length();
                C4331f.m5445b(f18192a, "-->openUrl2 before url =" + str);
                String str3 = str.indexOf(C0228a.f351a) == -1 ? str + C0228a.f351a : str + "&";
                C4331f.m5445b(f18192a, "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
                HttpUriRequest httpGet = new HttpGet(str3 + encodeUrl);
                httpGet.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpUriRequest = httpGet;
                i = length;
            } else if (str2.equals("POST")) {
                HttpUriRequest httpPost = new HttpPost(str);
                httpPost.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                Bundle bundle3 = new Bundle();
                for (String str4 : bundle2.keySet()) {
                    Object obj = bundle2.get(str4);
                    if (obj instanceof byte[]) {
                        bundle3.putByteArray(str4, (byte[]) obj);
                    }
                }
                if (!bundle2.containsKey("method")) {
                    bundle2.putString("method", str2);
                }
                httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
                httpPost.setHeader(C5083e.f21675j, "Keep-Alive");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(Util.getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                byteArrayOutputStream.write(Util.getBytesUTF8(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
                if (!bundle3.isEmpty()) {
                    int size = bundle3.size();
                    byteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    int i2 = -1;
                    for (String str5 : bundle3.keySet()) {
                        i2++;
                        byteArrayOutputStream.write(Util.getBytesUTF8("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"" + C3947a.f16890a));
                        byteArrayOutputStream.write(Util.getBytesUTF8("Content-Type: content/unknown\r\n\r\n"));
                        byte[] byteArray = bundle3.getByteArray(str5);
                        if (byteArray != null) {
                            byteArrayOutputStream.write(byteArray);
                        }
                        if (i2 < size - 1) {
                            byteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        }
                    }
                }
                byteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                i = byteArray2.length + 0;
                byteArrayOutputStream.close();
                httpPost.setEntity(new ByteArrayEntity(byteArray2));
                httpUriRequest = httpPost;
            } else {
                httpUriRequest = null;
                i = 0;
            }
            HttpResponse execute = httpClient.execute(httpUriRequest);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
            }
            return new Util.Statistic(m5362a(execute), i);
        }
        throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01bd A[LOOP:0: B:8:0x00da->B:29:0x01bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject request(QQToken qQToken, Context context, String str, Bundle bundle, String str2) {
        String str3;
        String str4;
        int i;
        ConnectTimeoutException connectTimeoutException;
        JSONObject jSONObject;
        SocketTimeoutException socketTimeoutException;
        JSONObject jSONObject2;
        int i2;
        long j;
        JSONObject jSONObject3;
        long j2;
        JSONObject jSONObject4;
        long j3;
        Util.Statistic openUrl2;
        JSONObject parseJson;
        C4331f.m5448a(C4331f.f18119d, "OpenApi request");
        if (!str.toLowerCase().startsWith(UriUtil.HTTP_SCHEME)) {
            str4 = ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/") + str;
            str3 = ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/") + str;
        } else {
            str3 = str;
            str4 = str;
        }
        m5363a(context, qQToken, str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = OpenConfig.getInstance(context, qQToken.getAppId()).getInt("Common_HttpRetryCount");
        C4331f.m5445b("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i3 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
        int i4 = i3 == 0 ? 3 : i3;
        C4331f.m5445b("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i4 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
        long j4 = elapsedRealtime;
        int i5 = 0;
        JSONObject jSONObject5 = null;
        while (true) {
            int i6 = i5 + 1;
            try {
                try {
                    try {
                        openUrl2 = openUrl2(context, str4, str2, bundle);
                        parseJson = Util.parseJson(openUrl2.response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        C4343g.m5402a().m5398a(str3, j4, 0L, 0L, -4);
                        throw e;
                    }
                } catch (SocketTimeoutException e2) {
                    socketTimeoutException = e2;
                    jSONObject2 = jSONObject5;
                } catch (ConnectTimeoutException e3) {
                    connectTimeoutException = e3;
                    jSONObject = jSONObject5;
                }
                try {
                    try {
                        i2 = parseJson.getInt("ret");
                    } catch (JSONException e4) {
                        i2 = -4;
                    }
                    j3 = openUrl2.reqSize;
                    j = openUrl2.rspSize;
                    jSONObject4 = parseJson;
                    break;
                } catch (SocketTimeoutException e5) {
                    jSONObject2 = parseJson;
                    socketTimeoutException = e5;
                    socketTimeoutException.printStackTrace();
                    i2 = -8;
                    j = 0;
                    if (i6 >= i4) {
                        C4343g.m5402a().m5398a(str3, j4, 0L, 0L, -8);
                        throw socketTimeoutException;
                    }
                    j4 = SystemClock.elapsedRealtime();
                    jSONObject3 = jSONObject2;
                    j2 = 0;
                    if (i6 < i4) {
                        jSONObject4 = jSONObject3;
                        j3 = j2;
                        C4343g.m5402a().m5398a(str3, j4, j3, j, i2);
                        return jSONObject4;
                    }
                    jSONObject5 = jSONObject3;
                    i5 = i6;
                } catch (ConnectTimeoutException e6) {
                    jSONObject = parseJson;
                    connectTimeoutException = e6;
                    connectTimeoutException.printStackTrace();
                    i2 = -7;
                    j = 0;
                    if (i6 >= i4) {
                        C4343g.m5402a().m5398a(str3, j4, 0L, 0L, -7);
                        throw connectTimeoutException;
                    }
                    j4 = SystemClock.elapsedRealtime();
                    jSONObject3 = jSONObject;
                    j2 = 0;
                    if (i6 < i4) {
                    }
                }
                jSONObject5 = jSONObject3;
                i5 = i6;
            } catch (HttpStatusException e7) {
                e7.printStackTrace();
                try {
                    i = Integer.parseInt(e7.getMessage().replace(HttpStatusException.ERROR_INFO, ""));
                } catch (Exception e8) {
                    e8.printStackTrace();
                    i = -9;
                }
                C4343g.m5402a().m5398a(str3, j4, 0L, 0L, i);
                throw e7;
            } catch (NetworkUnavailableException e9) {
                e9.printStackTrace();
                throw e9;
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                C4343g.m5402a().m5398a(str3, j4, 0L, 0L, -3);
                throw e10;
            } catch (IOException e11) {
                e11.printStackTrace();
                C4343g.m5402a().m5398a(str3, j4, 0L, 0L, getErrorCodeFromException(e11));
                throw e11;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.open.utils.HttpUtils$1] */
    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        C4331f.m5448a(C4331f.f18119d, "OpenApi requestAsync");
        new Thread() { // from class: com.tencent.open.utils.HttpUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(QQToken.this, context, str, bundle, str2);
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onComplete(request);
                    C4331f.m5445b(C4331f.f18119d, "OpenApi onComplete");
                } catch (HttpStatusException e) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onHttpStatusException(e);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync onHttpStatusException", e);
                } catch (NetworkUnavailableException e2) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onNetworkUnavailableException(e2);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync onNetworkUnavailableException", e2);
                } catch (MalformedURLException e3) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onMalformedURLException(e3);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync MalformedURLException", e3);
                } catch (SocketTimeoutException e4) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onSocketTimeoutException(e4);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync onSocketTimeoutException", e4);
                } catch (ConnectTimeoutException e5) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onConnectTimeoutException(e5);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync onConnectTimeoutException", e5);
                } catch (IOException e6) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onIOException(e6);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync IOException", e6);
                } catch (JSONException e7) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onJSONException(e7);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync JSONException", e7);
                } catch (Exception e8) {
                    if (iRequestListener == null) {
                        return;
                    }
                    iRequestListener.onUnknowException(e8);
                    C4331f.m5444b(C4331f.f18119d, "OpenApi requestAsync onUnknowException", e8);
                }
            }
        }.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01b4 A[LOOP:0: B:8:0x00d3->B:29:0x01b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0115 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject upload(QQToken qQToken, Context context, String str, Bundle bundle) {
        String str2;
        String str3;
        int i;
        ConnectTimeoutException connectTimeoutException;
        JSONObject jSONObject;
        SocketTimeoutException socketTimeoutException;
        JSONObject jSONObject2;
        int i2;
        long j;
        JSONObject jSONObject3;
        long j2;
        JSONObject jSONObject4;
        long j3;
        if (!str.toLowerCase().startsWith(UriUtil.HTTP_SCHEME)) {
            str3 = ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/") + str;
            str2 = ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/") + str;
        } else {
            str2 = str;
            str3 = str;
        }
        m5363a(context, qQToken, str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = OpenConfig.getInstance(context, qQToken.getAppId()).getInt("Common_HttpRetryCount");
        C4331f.m5445b("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i3 + "   appid:" + qQToken.getAppId() + "     url:" + str2);
        int i4 = i3 == 0 ? 3 : i3;
        C4331f.m5445b("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i4 + "   appid:" + qQToken.getAppId() + "     url:" + str2);
        long j4 = elapsedRealtime;
        int i5 = 0;
        JSONObject jSONObject5 = null;
        while (true) {
            int i6 = i5 + 1;
            try {
                try {
                    try {
                        Util.Statistic upload = Util.upload(context, str3, bundle);
                        JSONObject parseJson = Util.parseJson(upload.response);
                        try {
                            try {
                                i2 = parseJson.getInt("ret");
                            } catch (JSONException e) {
                                i2 = -4;
                            }
                            j3 = upload.reqSize;
                            j = upload.rspSize;
                            jSONObject4 = parseJson;
                            break;
                        } catch (SocketTimeoutException e2) {
                            jSONObject2 = parseJson;
                            socketTimeoutException = e2;
                            socketTimeoutException.printStackTrace();
                            i2 = -8;
                            j = 0;
                            if (i6 >= i4) {
                                C4343g.m5402a().m5398a(str2, j4, 0L, 0L, -8);
                                throw socketTimeoutException;
                            }
                            j4 = SystemClock.elapsedRealtime();
                            jSONObject3 = jSONObject2;
                            j2 = 0;
                            if (i6 < i4) {
                                jSONObject4 = jSONObject3;
                                j3 = j2;
                                C4343g.m5402a().m5398a(str2, j4, j3, j, i2);
                                return jSONObject4;
                            }
                            jSONObject5 = jSONObject3;
                            i5 = i6;
                        } catch (ConnectTimeoutException e3) {
                            jSONObject = parseJson;
                            connectTimeoutException = e3;
                            connectTimeoutException.printStackTrace();
                            i2 = -7;
                            j = 0;
                            if (i6 >= i4) {
                                C4343g.m5402a().m5398a(str2, j4, 0L, 0L, -7);
                                throw connectTimeoutException;
                            }
                            j4 = SystemClock.elapsedRealtime();
                            jSONObject3 = jSONObject;
                            j2 = 0;
                            if (i6 < i4) {
                            }
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        C4343g.m5402a().m5398a(str2, j4, 0L, 0L, -4);
                        throw e4;
                    }
                } catch (SocketTimeoutException e5) {
                    socketTimeoutException = e5;
                    jSONObject2 = jSONObject5;
                } catch (ConnectTimeoutException e6) {
                    connectTimeoutException = e6;
                    jSONObject = jSONObject5;
                }
                jSONObject5 = jSONObject3;
                i5 = i6;
            } catch (HttpStatusException e7) {
                e7.printStackTrace();
                try {
                    i = Integer.parseInt(e7.getMessage().replace(HttpStatusException.ERROR_INFO, ""));
                } catch (Exception e8) {
                    e8.printStackTrace();
                    i = -9;
                }
                C4343g.m5402a().m5398a(str2, j4, 0L, 0L, i);
                throw e7;
            } catch (NetworkUnavailableException e9) {
                e9.printStackTrace();
                throw e9;
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                C4343g.m5402a().m5398a(str2, j4, 0L, 0L, -3);
                throw e10;
            } catch (IOException e11) {
                e11.printStackTrace();
                C4343g.m5402a().m5398a(str2, j4, 0L, 0L, getErrorCodeFromException(e11));
                throw e11;
            }
        }
    }
}
