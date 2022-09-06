package com.android.volley.toolbox;

import com.android.volley.AbstractC1333n;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
/* renamed from: com.android.volley.toolbox.g */
/* loaded from: classes.dex */
public class C1360g implements AbstractC1363i {

    /* renamed from: b */
    private static final String f4663b = "Content-Type";

    /* renamed from: a */
    protected final HttpClient f4664a;

    /* renamed from: com.android.volley.toolbox.g$a */
    /* loaded from: classes.dex */
    public static final class C1361a extends HttpEntityEnclosingRequestBase {

        /* renamed from: a */
        public static final String f4665a = "PATCH";

        public C1361a() {
        }

        public C1361a(String str) {
            setURI(URI.create(str));
        }

        public C1361a(URI uri) {
            setURI(uri);
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public C1360g(HttpClient httpClient) {
        this.f4664a = httpClient;
    }

    /* renamed from: a */
    private static List<NameValuePair> m16641a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            arrayList.add(new BasicNameValuePair(str, map.get(str)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m16640a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, AbstractC1333n<?> abstractC1333n) {
        byte[] mo16587v = abstractC1333n.mo16587v();
        if (mo16587v != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(mo16587v));
        }
    }

    /* renamed from: a */
    private static void m16638a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    /* renamed from: b */
    static HttpUriRequest m16637b(AbstractC1333n<?> abstractC1333n, Map<String, String> map) {
        switch (abstractC1333n.m16735a()) {
            case -1:
                byte[] mo16589r = abstractC1333n.mo16589r();
                if (mo16589r == null) {
                    return new HttpGet(abstractC1333n.m16714g());
                }
                HttpPost httpPost = new HttpPost(abstractC1333n.m16714g());
                httpPost.addHeader("Content-Type", abstractC1333n.mo16590q());
                httpPost.setEntity(new ByteArrayEntity(mo16589r));
                return httpPost;
            case 0:
                return new HttpGet(abstractC1333n.m16714g());
            case 1:
                HttpPost httpPost2 = new HttpPost(abstractC1333n.m16714g());
                httpPost2.addHeader("Content-Type", abstractC1333n.mo16588u());
                m16640a((HttpEntityEnclosingRequestBase) httpPost2, abstractC1333n);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(abstractC1333n.m16714g());
                httpPut.addHeader("Content-Type", abstractC1333n.mo16588u());
                m16640a((HttpEntityEnclosingRequestBase) httpPut, abstractC1333n);
                return httpPut;
            case 3:
                return new HttpDelete(abstractC1333n.m16714g());
            case 4:
                return new HttpHead(abstractC1333n.m16714g());
            case 5:
                return new HttpOptions(abstractC1333n.m16714g());
            case 6:
                return new HttpTrace(abstractC1333n.m16714g());
            case 7:
                C1361a c1361a = new C1361a(abstractC1333n.m16714g());
                c1361a.addHeader("Content-Type", abstractC1333n.mo16588u());
                m16640a(c1361a, abstractC1333n);
                return c1361a;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    @Override // com.android.volley.toolbox.AbstractC1363i
    /* renamed from: a */
    public HttpResponse mo16631a(AbstractC1333n<?> abstractC1333n, Map<String, String> map) {
        HttpUriRequest m16637b = m16637b(abstractC1333n, map);
        m16638a(m16637b, map);
        m16638a(m16637b, abstractC1333n.m16708n());
        m16639a(m16637b);
        HttpParams params = m16637b.getParams();
        int m16703y = abstractC1333n.m16703y();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, m16703y);
        return this.f4664a.execute(m16637b);
    }

    /* renamed from: a */
    protected void m16639a(HttpUriRequest httpUriRequest) {
    }
}
