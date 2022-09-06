package com.android.volley.toolbox;

import com.android.volley.AbstractC1333n;
import com.facebook.common.util.UriUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.p248a.p249a.p252c.p255c.C5041h;
import org.p248a.p249a.p252c.p255c.C5042i;
import org.p248a.p249a.p252c.p255c.C5045l;
import org.p248a.p249a.p252c.p255c.C5050o;
/* renamed from: com.android.volley.toolbox.j */
/* loaded from: classes.dex */
public class C1364j implements AbstractC1363i {

    /* renamed from: a */
    private static final String f4666a = "Content-Type";

    /* renamed from: b */
    private final AbstractC1365a f4667b;

    /* renamed from: c */
    private final SSLSocketFactory f4668c;

    /* renamed from: com.android.volley.toolbox.j$a */
    /* loaded from: classes.dex */
    public interface AbstractC1365a {
        /* renamed from: a */
        String m16625a(String str);
    }

    public C1364j() {
        this(null);
    }

    public C1364j(AbstractC1365a abstractC1365a) {
        this(abstractC1365a, null);
    }

    public C1364j(AbstractC1365a abstractC1365a, SSLSocketFactory sSLSocketFactory) {
        this.f4667b = abstractC1365a;
        this.f4668c = sSLSocketFactory;
    }

    /* renamed from: a */
    private HttpURLConnection m16627a(URL url, AbstractC1333n<?> abstractC1333n) {
        HttpURLConnection m16628a = m16628a(url);
        int m16703y = abstractC1333n.m16703y();
        m16628a.setConnectTimeout(m16703y);
        m16628a.setReadTimeout(m16703y);
        m16628a.setUseCaches(false);
        m16628a.setDoInput(true);
        if (UriUtil.HTTPS_SCHEME.equals(url.getProtocol()) && this.f4668c != null) {
            ((HttpsURLConnection) m16628a).setSSLSocketFactory(this.f4668c);
        }
        return m16628a;
    }

    /* renamed from: a */
    private static HttpEntity m16630a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* renamed from: a */
    static void m16629a(HttpURLConnection httpURLConnection, AbstractC1333n<?> abstractC1333n) {
        switch (abstractC1333n.m16735a()) {
            case -1:
                byte[] mo16589r = abstractC1333n.mo16589r();
                if (mo16589r == null) {
                    return;
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.addRequestProperty("Content-Type", abstractC1333n.mo16590q());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(mo16589r);
                dataOutputStream.close();
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m16626b(httpURLConnection, abstractC1333n);
                return;
            case 2:
                httpURLConnection.setRequestMethod(C5045l.f21547a);
                m16626b(httpURLConnection, abstractC1333n);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod(C5041h.f21543a);
                return;
            case 5:
                httpURLConnection.setRequestMethod(C5042i.f21544a);
                return;
            case 6:
                httpURLConnection.setRequestMethod(C5050o.f21556a);
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m16626b(httpURLConnection, abstractC1333n);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: a */
    private static boolean m16632a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* renamed from: b */
    private static void m16626b(HttpURLConnection httpURLConnection, AbstractC1333n<?> abstractC1333n) {
        byte[] mo16587v = abstractC1333n.mo16587v();
        if (mo16587v != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", abstractC1333n.mo16588u());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(mo16587v);
            dataOutputStream.close();
        }
    }

    /* renamed from: a */
    protected HttpURLConnection m16628a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.android.volley.toolbox.AbstractC1363i
    /* renamed from: a */
    public HttpResponse mo16631a(AbstractC1333n<?> abstractC1333n, Map<String, String> map) {
        String str;
        String m16714g = abstractC1333n.m16714g();
        HashMap hashMap = new HashMap();
        hashMap.putAll(abstractC1333n.m16708n());
        hashMap.putAll(map);
        if (this.f4667b != null) {
            str = this.f4667b.m16625a(m16714g);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + m16714g);
            }
        } else {
            str = m16714g;
        }
        HttpURLConnection m16627a = m16627a(new URL(str), abstractC1333n);
        for (String str2 : hashMap.keySet()) {
            m16627a.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        m16629a(m16627a, abstractC1333n);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (m16627a.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicStatusLine basicStatusLine = new BasicStatusLine(protocolVersion, m16627a.getResponseCode(), m16627a.getResponseMessage());
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
        if (m16632a(abstractC1333n.m16735a(), basicStatusLine.getStatusCode())) {
            basicHttpResponse.setEntity(m16630a(m16627a));
        }
        for (Map.Entry<String, List<String>> entry : m16627a.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }
}
