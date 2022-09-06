package com.mob.tools.network;

import android.content.Context;
import android.os.Build;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.baidu.tts.loopj.RequestParams;
import com.facebook.common.util.UriUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p252c.p255c.C5041h;
import org.p248a.p249a.p252c.p255c.C5045l;
import org.p248a.p249a.p252c.p258f.C5078j;
import org.p248a.p249a.p261f.p264c.C5115g;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class NetworkHelper {
    public static int connectionTimeout;
    public static int readTimout;

    /* loaded from: classes.dex */
    public static class NetworkTimeOut {
        public int connectionTimeout;
        public int readTimout;
    }

    /* loaded from: classes.dex */
    public static final class SimpleX509TrustManager implements X509TrustManager {
        private X509TrustManager standardTrustManager;

        public SimpleX509TrustManager(KeyStore keyStore) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers == null || trustManagers.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.standardTrustManager = (X509TrustManager) trustManagers[0];
            } catch (Exception e) {
                MobLog.getInstance().m5972d("failed to initialize the standard trust manager: " + e.getMessage(), new Object[0]);
                this.standardTrustManager = null;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr == null) {
                throw new IllegalArgumentException("there were no certificates.");
            }
            if (x509CertificateArr.length == 1) {
                x509CertificateArr[0].checkValidity();
            } else if (this.standardTrustManager == null) {
                throw new CertificateException("there were one more certificates but no trust manager found.");
            } else {
                this.standardTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) {
        Object obj;
        String str2;
        boolean z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            obj = ReflectHelper.getInstanceField(httpURLConnection, "methodTokens");
        } catch (Throwable th) {
            obj = null;
        }
        if (obj == null) {
            try {
                obj = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
                str2 = "PERMITTED_USER_METHODS";
                z = true;
            } catch (Throwable th2) {
                str2 = "PERMITTED_USER_METHODS";
                z = true;
            }
        } else {
            str2 = "methodTokens";
            z = false;
        }
        if (obj != null) {
            String[] strArr = (String[]) obj;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = "PATCH";
            if (z) {
                ReflectHelper.setStaticField("HttpURLConnection", str2, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, str2, strArr2);
            }
        }
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance(C5115g.f21740a);
            sSLContext.init(null, new TrustManager[]{new SimpleX509TrustManager(null)}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
        }
        int i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) {
        String uuid = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                stringPart.append("--").append(uuid).append(C3947a.f16890a);
                stringPart.append("Content-Disposition: form-data; name=\"").append(next.name).append("\"\r\n\r\n");
                stringPart.append(next.value).append(C3947a.f16890a);
            }
        }
        multiPart.append(stringPart);
        Iterator<KVPair<String>> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            KVPair<String> next2 = it3.next();
            StringPart stringPart2 = new StringPart();
            File file = new File(next2.value);
            stringPart2.append("--").append(uuid).append(C3947a.f16890a);
            stringPart2.append("Content-Disposition: form-data; name=\"").append(next2.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(next2.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (next2.value.toLowerCase().endsWith("jpg") || next2.value.toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (next2.value.toLowerCase().endsWith("png")) {
                    contentTypeFor = "image/png";
                } else if (next2.value.toLowerCase().endsWith("gif")) {
                    contentTypeFor = "image/gif";
                } else {
                    FileInputStream fileInputStream = new FileInputStream(next2.value);
                    contentTypeFor = URLConnection.guessContentTypeFromStream(fileInputStream);
                    fileInputStream.close();
                    if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                        contentTypeFor = RequestParams.APPLICATION_OCTET_STREAM;
                    }
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile(next2.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append(C3947a.f16890a);
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(uuid).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) {
        httpURLConnection.setRequestProperty("Content-Type", C5078j.f21618a);
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(kvPairsToUrl(arrayList));
        }
        return stringPart;
    }

    private void httpPatchImpl(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        DefaultHttpClient defaultHttpClient;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpPatch: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + C0228a.f351a + kvPairsToUrl;
            }
        }
        HttpPatch httpPatch = new HttpPatch(str);
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                httpPatch.setHeader(next.name, next.value);
            }
        }
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j);
        InputStreamEntity inputStreamEntity = new InputStreamEntity(filePart.toInputStream(), filePart.length() - j);
        inputStreamEntity.setContentEncoding("application/offset+octet-stream");
        httpPatch.setEntity(inputStreamEntity);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        int i = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i > 0) {
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        }
        int i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        }
        httpPatch.setParams(basicHttpParams);
        if (str.startsWith("https://")) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            SSLSocketFactoryEx sSLSocketFactoryEx = new SSLSocketFactoryEx(keyStore);
            sSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams2, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams2, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(UriUtil.HTTP_SCHEME, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, sSLSocketFactoryEx, 443));
            defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams2, schemeRegistry), basicHttpParams2);
        } else {
            defaultHttpClient = new DefaultHttpClient();
        }
        HttpResponse execute = defaultHttpClient.execute(httpPatch);
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl(execute));
            } finally {
            }
        } else {
            defaultHttpClient.getConnectionManager().shutdown();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    private String kvPairsToUrl(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair<String> next = it2.next();
            String urlEncode = Data.urlEncode(next.name, "utf-8");
            String urlEncode2 = next.value != null ? Data.urlEncode(next.value, "utf-8") : "";
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(urlEncode).append(SignatureVisitor.INSTANCEOF).append(urlEncode2);
        }
        return sb.toString();
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut) {
        String str3;
        List<String> list;
        int lastIndexOf;
        List<String> list2;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("downloading: " + str, new Object[0]);
        if (z) {
            File file = new File(ResHelper.getCachePath(context, str2), Data.MD5(str));
            if (z && file.exists()) {
                MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            connection.disconnect();
            HashMap hashMap = new HashMap();
            hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb.toString());
            hashMap.put("status", Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(hashMap));
        }
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        if (headerFields == null || (list2 = headerFields.get(AsyncHttpClient.HEADER_CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
            str3 = null;
        } else {
            String[] split = list2.get(0).split(";");
            str3 = null;
            for (String str4 : split) {
                if (str4.trim().startsWith("filename")) {
                    str3 = str4.split("=")[1];
                    if (str3.startsWith("\"") && str3.endsWith("\"")) {
                        str3 = str3.substring(1, str3.length() - 1);
                    }
                }
            }
        }
        if (str3 == null) {
            String MD5 = Data.MD5(str);
            if (headerFields != null && (list = headerFields.get("Content-Type")) != null && list.size() > 0) {
                String str5 = list.get(0);
                String trim = str5 == null ? "" : str5.trim();
                if (trim.startsWith("image/")) {
                    String substring = trim.substring("image/".length());
                    StringBuilder append = new StringBuilder().append(MD5).append(".");
                    if ("jpeg".equals(substring)) {
                        substring = "jpg";
                    }
                    str3 = append.append(substring).toString();
                } else {
                    int lastIndexOf2 = str.lastIndexOf(47);
                    String str6 = null;
                    if (lastIndexOf2 > 0) {
                        str6 = str.substring(lastIndexOf2 + 1);
                    }
                    if (str6 != null && str6.length() > 0 && (lastIndexOf = str6.lastIndexOf(46)) > 0 && str6.length() - lastIndexOf < 10) {
                        str3 = MD5 + str6.substring(lastIndexOf);
                    }
                }
            }
            str3 = MD5;
        }
        File file2 = new File(ResHelper.getCachePath(context, str2), str3);
        if (z && file2.exists()) {
            connection.disconnect();
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return file2.getAbsolutePath();
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (file2.exists()) {
            file2.delete();
        }
        try {
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            inputStream.close();
            fileOutputStream.close();
            connection.disconnect();
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return file2.getAbsolutePath();
        } catch (Throwable th) {
            if (file2.exists()) {
                file2.delete();
            }
            throw th;
        }
    }

    public void getHttpPostResponse(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        HTTPPart textPostHTTPPart;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (kVPair == null || kVPair.value == null || !new File(kVPair.value).exists()) {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
        } else {
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(kVPair);
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList3);
        }
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
            } finally {
            }
        } else {
            connection.disconnect();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpGet: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + C0228a.f351a + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            connection.disconnect();
            String sb2 = sb.toString();
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            if (sb3.length() > 0) {
                sb3.append('\n');
            }
            sb3.append(readLine2);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb3.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public ArrayList<KVPair<String[]>> httpHead(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpHead: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + C0228a.f351a + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setRequestMethod(C5041h.f21543a);
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        ArrayList<KVPair<String[]>> arrayList3 = new ArrayList<>();
        if (headerFields != null) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                List<String> value = entry.getValue();
                if (value == null) {
                    arrayList3.add(new KVPair<>(entry.getKey(), new String[0]));
                } else {
                    String[] strArr = new String[value.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        strArr[i2] = value.get(i2);
                        i = i2 + 1;
                    }
                    arrayList3.add(new KVPair<>(entry.getKey(), strArr));
                }
            }
        }
        connection.disconnect();
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return arrayList3;
    }

    public void httpPatch(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        if (Build.VERSION.SDK_INT >= 23) {
            httpPatchImpl23(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        } else {
            httpPatchImpl(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        }
    }

    public void httpPatchImpl23(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpPatch: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + C0228a.f351a + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PATCH");
        connection.setRequestProperty("Content-Type", "application/offset+octet-stream");
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
            } finally {
            }
        } else {
            connection.disconnect();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, int i, NetworkTimeOut networkTimeOut) {
        ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
        if (kVPair != null && kVPair.value != null && new File(kVPair.value).exists()) {
            arrayList3.add(kVPair);
        }
        return httpPostFiles(str, arrayList, arrayList3, arrayList2, i, networkTimeOut);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPost(str, arrayList, kVPair, arrayList2, 0, networkTimeOut);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007a A[LOOP:1: B:15:0x0078->B:16:0x007a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        HTTPPart textPostHTTPPart;
        HTTPPart hTTPPart;
        int read;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        if (arrayList2 == null || arrayList2.size() <= 0) {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        } else {
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList2);
            if (i >= 0) {
                connection.setChunkedStreamingMode(i);
                hTTPPart = textPostHTTPPart;
                if (arrayList3 != null) {
                    Iterator<KVPair<String>> it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        KVPair<String> next = it2.next();
                        connection.setRequestProperty(next.name, next.value);
                    }
                }
                connection.connect();
                OutputStream outputStream = connection.getOutputStream();
                InputStream inputStream = hTTPPart.toInputStream();
                byte[] bArr = new byte[65536];
                for (read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                    outputStream.write(bArr, 0, read);
                }
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                if (httpResponseCallback == null) {
                    try {
                        httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    } finally {
                    }
                } else {
                    connection.disconnect();
                }
                MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            }
        }
        hTTPPart = textPostHTTPPart;
        if (arrayList3 != null) {
        }
        connection.connect();
        OutputStream outputStream2 = connection.getOutputStream();
        InputStream inputStream2 = hTTPPart.toInputStream();
        byte[] bArr2 = new byte[65536];
        while (read > 0) {
        }
        outputStream2.flush();
        inputStream2.close();
        outputStream2.close();
        if (httpResponseCallback == null) {
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        httpPost(str, arrayList, arrayList2, arrayList3, 0, httpResponseCallback, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, NetworkTimeOut networkTimeOut) {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.2
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 201) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    hashMap.put("resp", sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb2.toString());
                hashMap2.put("status", Integer.valueOf(responseCode));
                throw new Throwable(new Hashon().fromHashMap(hashMap2));
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, NetworkTimeOut networkTimeOut) {
        return httpPostFiles(str, arrayList, arrayList2, arrayList3, 0, networkTimeOut);
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut, null);
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, OnReadListener onReadListener) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("httpPut: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + C0228a.f351a + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod(C5045l.f21547a);
        connection.setRequestProperty("Content-Type", RequestParams.APPLICATION_OCTET_STREAM);
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        if (onReadListener != null) {
            filePart.setOnReadListener(onReadListener);
        }
        filePart.setFile(kVPair.value);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200 || responseCode == 201) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            connection.disconnect();
            String sb2 = sb.toString();
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            if (sb3.length() > 0) {
                sb3.append('\n');
            }
            sb3.append(readLine2);
        }
        bufferedReader2.close();
        HashMap hashMap = new HashMap();
        hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb3.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        final HashMap hashMap = new HashMap();
        jsonPost(str, arrayList, arrayList2, networkTimeOut, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.1
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 201) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    hashMap.put(UriUtil.LOCAL_RESOURCE_SCHEME, sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb2.toString());
                hashMap2.put("status", Integer.valueOf(responseCode));
                throw new Throwable(new Hashon().fromHashMap(hashMap2));
            }
        });
        if (hashMap.containsKey(UriUtil.LOCAL_RESOURCE_SCHEME)) {
            return (String) hashMap.get(UriUtil.LOCAL_RESOURCE_SCHEME);
        }
        return null;
    }

    public void jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair<String> next = it2.next();
            hashMap.put(next.name, next.value);
        }
        jsonPost(str, hashMap, arrayList2, networkTimeOut, httpResponseCallback);
    }

    public void jsonPost(String str, HashMap<String, Object> hashMap, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("jsonPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestProperty("content-type", RequestParams.APPLICATION_JSON);
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        StringPart stringPart = new StringPart();
        if (hashMap != null) {
            stringPart.append(new Hashon().fromHashMap(hashMap));
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = stringPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
            } finally {
            }
        } else {
            connection.disconnect();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, (ArrayList<KVPair<String>>) null, httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, (ArrayList<KVPair<String>>) null, rawNetworkCallback, networkTimeOut);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
            } finally {
            }
        } else {
            connection.disconnect();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                rawNetworkCallback.onResponse(connection.getInputStream());
            }
            connection.disconnect();
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(readLine);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
            } finally {
            }
        } else {
            connection.disconnect();
        }
        MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m5966i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair<String> next = it2.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                try {
                    rawNetworkCallback.onResponse(connection.getInputStream());
                } finally {
                }
            } else {
                connection.disconnect();
            }
            MobLog.getInstance().m5966i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(readLine);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, sb.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }
}
