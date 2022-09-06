package p244m.framework.p245a;

import com.baidu.tts.loopj.RequestParams;
import com.facebook.common.util.UriUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p252c.p258f.C5078j;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: m.framework.a.g */
/* loaded from: classes2.dex */
public class C4944g {

    /* renamed from: a */
    public static int f21283a;

    /* renamed from: b */
    public static int f21284b;

    /* renamed from: a */
    private String m2566a(ArrayList<C4941d<String>> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<C4941d<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C4941d<String> next = it2.next();
            String encode = URLEncoder.encode(next.f21278a, "utf-8");
            String encode2 = next.f21279b != null ? URLEncoder.encode(next.f21279b, "utf-8") : "";
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(encode).append(SignatureVisitor.INSTANCEOF).append(encode2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private HttpClient m2576a() {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        C4946i c4946i = new C4946i(keyStore);
        c4946i.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(UriUtil.HTTP_SCHEME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme(UriUtil.HTTPS_SCHEME, c4946i, 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: a */
    private HttpPost m2574a(String str, ArrayList<C4941d<String>> arrayList) {
        HttpPost httpPost = new HttpPost(str);
        if (arrayList != null) {
            C4948j c4948j = new C4948j();
            c4948j.m2563a(m2566a(arrayList));
            InputStreamEntity c = c4948j.c();
            c.setContentType(C5078j.f21618a);
            httpPost.setEntity(c);
        }
        return httpPost;
    }

    /* renamed from: a */
    private HttpPost m2570a(String str, ArrayList<C4941d<String>> arrayList, C4941d<String> c4941d) {
        HttpPost httpPost = new HttpPost(str);
        String uuid = UUID.randomUUID().toString();
        C4942e c4942e = new C4942e();
        C4948j c4948j = new C4948j();
        if (arrayList != null) {
            Iterator<C4941d<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                c4948j.m2563a("--").m2563a(uuid).m2563a(C3947a.f16890a);
                c4948j.m2563a("content-disposition: form-data; name=\"").m2563a(next.f21278a).m2563a("\"\r\n\r\n");
                c4948j.m2563a(next.f21279b).m2563a(C3947a.f16890a);
            }
        }
        httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + uuid);
        c4948j.m2563a("--").m2563a(uuid).m2563a(C3947a.f16890a);
        c4948j.m2563a("Content-Disposition: form-data; name=\"").m2563a(c4941d.f21278a).m2563a("\"; filename=\"").m2563a(new File(c4941d.f21279b).getName()).m2563a("\"\r\n");
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(c4941d.f21279b);
        if (contentTypeFor == null || contentTypeFor.length() <= 0) {
            if (c4941d.f21279b.toLowerCase().endsWith("jpg") || c4941d.f21279b.toLowerCase().endsWith("jepg")) {
                contentTypeFor = "image/jpeg";
            } else if (c4941d.f21279b.toLowerCase().endsWith("png")) {
                contentTypeFor = "image/png";
            } else if (c4941d.f21279b.toLowerCase().endsWith("gif")) {
                contentTypeFor = "image/gif";
            } else {
                FileInputStream fileInputStream = new FileInputStream(c4941d.f21279b);
                contentTypeFor = URLConnection.guessContentTypeFromStream(fileInputStream);
                fileInputStream.close();
                if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                    contentTypeFor = RequestParams.APPLICATION_OCTET_STREAM;
                }
            }
        }
        c4948j.m2563a("Content-Type: ").m2563a(contentTypeFor).m2563a("\r\n\r\n");
        c4942e.m2579a(c4948j);
        C4939b c4939b = new C4939b();
        c4939b.m2581a(c4941d.f21279b);
        c4942e.m2579a(c4939b);
        C4948j c4948j2 = new C4948j();
        c4948j2.m2563a("\r\n--").m2563a(uuid).m2563a("--\r\n");
        c4942e.m2579a(c4948j2);
        httpPost.setEntity(c4942e.c());
        return httpPost;
    }

    /* renamed from: a */
    public String m2573a(String str, ArrayList<C4941d<String>> arrayList, ArrayList<C4941d<String>> arrayList2) {
        if (arrayList != null) {
            String m2566a = m2566a(arrayList);
            if (m2566a.length() > 0) {
                str = String.valueOf(str) + C0228a.f351a + m2566a;
            }
        }
        HttpGet httpGet = new HttpGet(str);
        if (arrayList2 != null) {
            Iterator<C4941d<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                httpGet.setHeader(next.f21278a, next.f21279b);
            }
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f21283a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f21284b);
        httpGet.setParams(basicHttpParams);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            return entityUtils;
        }
        String entityUtils2 = EntityUtils.toString(execute.getEntity(), "utf-8");
        m2576a.getConnectionManager().shutdown();
        throw new Throwable(entityUtils2);
    }

    /* renamed from: a */
    public String m2569a(String str, ArrayList<C4941d<String>> arrayList, C4941d<String> c4941d, ArrayList<C4941d<String>> arrayList2) {
        HttpPost m2574a = (c4941d == null || c4941d.f21279b == null || !new File(c4941d.f21279b).exists()) ? m2574a(str, arrayList) : m2570a(str, arrayList, c4941d);
        if (arrayList2 != null) {
            Iterator<C4941d<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                m2574a.setHeader(next.f21278a, next.f21279b);
            }
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f21283a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f21284b);
        m2574a.setParams(basicHttpParams);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(m2574a);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode == 200 || statusCode == 201) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            return entityUtils;
        }
        String entityUtils2 = EntityUtils.toString(execute.getEntity(), "utf-8");
        m2576a.getConnectionManager().shutdown();
        throw new Throwable(entityUtils2);
    }

    /* renamed from: a */
    public void m2575a(String str, File file) {
        HttpGet httpGet = new HttpGet(str);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() != 200) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            throw new Throwable(entityUtils);
        }
        InputStream content = execute.getEntity().getContent();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        for (int read = content.read(bArr); read > 0; read = content.read(bArr)) {
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        content.close();
        fileOutputStream.close();
        m2576a.getConnectionManager().shutdown();
    }

    /* renamed from: a */
    public void m2572a(String str, ArrayList<C4941d<String>> arrayList, ArrayList<C4941d<String>> arrayList2, AbstractC4945h abstractC4945h) {
        if (arrayList != null) {
            String m2566a = m2566a(arrayList);
            if (m2566a.length() > 0) {
                str = String.valueOf(str) + C0228a.f351a + m2566a;
            }
        }
        HttpGet httpGet = new HttpGet(str);
        if (arrayList2 != null) {
            Iterator<C4941d<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                httpGet.setHeader(next.f21278a, next.f21279b);
            }
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f21283a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f21284b);
        httpGet.setParams(basicHttpParams);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() != 200) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            throw new Throwable(entityUtils);
        }
        InputStream content = execute.getEntity().getContent();
        if (abstractC4945h != null) {
            abstractC4945h.mo2442a(content);
        }
        content.close();
        m2576a.getConnectionManager().shutdown();
    }

    /* renamed from: a */
    public void m2571a(String str, ArrayList<C4941d<String>> arrayList, AbstractC4940c abstractC4940c, AbstractC4945h abstractC4945h) {
        HttpPost httpPost = new HttpPost(str);
        if (arrayList != null) {
            Iterator<C4941d<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                httpPost.setHeader(next.f21278a, next.f21279b);
            }
        }
        httpPost.setEntity(abstractC4940c.m2580c());
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpPost);
        if (execute.getStatusLine().getStatusCode() == 200) {
            InputStream content = execute.getEntity().getContent();
            if (abstractC4945h != null) {
                abstractC4945h.mo2442a(content);
            }
            content.close();
            m2576a.getConnectionManager().shutdown();
        }
        String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
        m2576a.getConnectionManager().shutdown();
        throw new Throwable(entityUtils);
    }

    /* renamed from: a */
    public void m2568a(String str, ArrayList<C4941d<String>> arrayList, C4941d<String> c4941d, ArrayList<C4941d<String>> arrayList2, AbstractC4945h abstractC4945h) {
        HttpPost m2574a = (c4941d == null || c4941d.f21279b == null || !new File(c4941d.f21279b).exists()) ? m2574a(str, arrayList) : m2570a(str, arrayList, c4941d);
        if (arrayList2 != null) {
            Iterator<C4941d<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                m2574a.setHeader(next.f21278a, next.f21279b);
            }
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f21283a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f21284b);
        m2574a.setParams(basicHttpParams);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(m2574a);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode != 200 && statusCode != 201) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            throw new Throwable(entityUtils);
        }
        InputStream content = execute.getEntity().getContent();
        if (abstractC4945h != null) {
            abstractC4945h.mo2442a(content);
        }
        content.close();
        m2576a.getConnectionManager().shutdown();
    }

    /* renamed from: a */
    public void m2567a(String str, AbstractC4945h abstractC4945h) {
        HttpGet httpGet = new HttpGet(str);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() != 200) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            throw new Throwable(entityUtils);
        }
        InputStream content = execute.getEntity().getContent();
        if (abstractC4945h != null) {
            abstractC4945h.mo2442a(content);
        }
        content.close();
        m2576a.getConnectionManager().shutdown();
    }

    /* renamed from: b */
    public String m2565b(String str, ArrayList<C4941d<String>> arrayList, C4941d<String> c4941d, ArrayList<C4941d<String>> arrayList2) {
        if (arrayList != null) {
            String m2566a = m2566a(arrayList);
            if (m2566a.length() > 0) {
                str = String.valueOf(str) + C0228a.f351a + m2566a;
            }
        }
        HttpPut httpPut = new HttpPut(str);
        if (arrayList2 != null) {
            Iterator<C4941d<String>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C4941d<String> next = it2.next();
                httpPut.setHeader(next.f21278a, next.f21279b);
            }
        }
        C4939b c4939b = new C4939b();
        c4939b.m2581a(c4941d.f21279b);
        InputStreamEntity c = c4939b.c();
        c.setContentEncoding(RequestParams.APPLICATION_OCTET_STREAM);
        httpPut.setEntity(c);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f21283a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f21284b);
        httpPut.setParams(basicHttpParams);
        HttpClient m2576a = str.startsWith("https://") ? m2576a() : new DefaultHttpClient();
        HttpResponse execute = m2576a.execute(httpPut);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode == 200 || statusCode == 201) {
            String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
            m2576a.getConnectionManager().shutdown();
            return entityUtils;
        }
        String entityUtils2 = EntityUtils.toString(execute.getEntity(), "utf-8");
        m2576a.getConnectionManager().shutdown();
        throw new Throwable(entityUtils2);
    }
}
