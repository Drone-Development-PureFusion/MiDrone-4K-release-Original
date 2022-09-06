package p000a;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import p000a.C0004c;
import p000a.C0018l;
/* renamed from: a.m */
/* loaded from: classes.dex */
public class C0031m implements AbstractC0009e {

    /* renamed from: b */
    private static final String f91b = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";

    /* renamed from: c */
    private static final String f92c = "Prefer-Html-Meta-Tags";

    /* renamed from: d */
    private static final String f93d = "al";

    /* renamed from: e */
    private static final String f94e = "value";

    /* renamed from: f */
    private static final String f95f = "app_name";

    /* renamed from: g */
    private static final String f96g = "class";

    /* renamed from: h */
    private static final String f97h = "package";

    /* renamed from: i */
    private static final String f98i = "url";

    /* renamed from: j */
    private static final String f99j = "should_fallback";

    /* renamed from: k */
    private static final String f100k = "url";

    /* renamed from: l */
    private static final String f101l = "web";

    /* renamed from: m */
    private static final String f102m = "android";

    /* renamed from: a */
    private final Context f103a;

    public C0031m(Context context) {
        this.f103a = context;
    }

    /* renamed from: a */
    private static Uri m21566a(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    /* renamed from: a */
    private static List<Map<String, Object>> m21563a(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0004c m21560b(Map<String, Object> map, Uri uri) {
        Uri uri2;
        ArrayList arrayList = new ArrayList();
        List<Map> list = (List) map.get(f102m);
        if (list == null) {
            list = Collections.emptyList();
        }
        for (Map map2 : list) {
            List<Map<String, Object>> m21563a = m21563a(map2, "url");
            List<Map<String, Object>> m21563a2 = m21563a(map2, f97h);
            List<Map<String, Object>> m21563a3 = m21563a(map2, "class");
            List<Map<String, Object>> m21563a4 = m21563a(map2, "app_name");
            int max = Math.max(m21563a.size(), Math.max(m21563a2.size(), Math.max(m21563a3.size(), m21563a4.size())));
            int i = 0;
            while (i < max) {
                arrayList.add(new C0004c.C0005a((String) (m21563a2.size() > i ? m21563a2.get(i).get("value") : null), (String) (m21563a3.size() > i ? m21563a3.get(i).get("value") : null), m21566a((String) (m21563a.size() > i ? m21563a.get(i).get("value") : null)), (String) (m21563a4.size() > i ? m21563a4.get(i).get("value") : null)));
                i++;
            }
        }
        List list2 = (List) map.get(f101l);
        if (list2 == null || list2.size() <= 0) {
            uri2 = uri;
        } else {
            Map map3 = (Map) list2.get(0);
            List list3 = (List) map3.get("url");
            List list4 = (List) map3.get(f99j);
            uri2 = (list4 == null || list4.size() <= 0 || !Arrays.asList("no", "false", "0").contains(((String) ((Map) list4.get(0)).get("value")).toLowerCase())) ? uri : null;
            if (uri2 != null && list3 != null && list3.size() > 0) {
                uri2 = m21566a((String) ((Map) list3.get(0)).get("value"));
            }
        }
        return new C0004c(uri, arrayList, uri2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m21561b(URLConnection uRLConnection) {
        InputStream inputStream;
        InputStream errorStream;
        int i = 0;
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                errorStream = uRLConnection.getInputStream();
            } catch (Exception e) {
                errorStream = httpURLConnection.getErrorStream();
            }
            inputStream = errorStream;
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                String[] split = uRLConnection.getContentType().split(";");
                int length = split.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.startsWith("charset=")) {
                        contentEncoding = trim.substring("charset=".length());
                        break;
                    }
                    i++;
                }
                if (contentEncoding == null) {
                    contentEncoding = "UTF-8";
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), contentEncoding);
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.Map] */
    /* renamed from: b */
    public static Map<String, Object> m21559b(JSONArray jSONArray) {
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String[] split = jSONObject.getString("property").split(":");
            if (split[0].equals(f93d)) {
                HashMap hashMap2 = hashMap;
                for (int i2 = 1; i2 < split.length; i2++) {
                    List list = (List) hashMap2.get(split[i2]);
                    if (list == null) {
                        ArrayList arrayList2 = new ArrayList();
                        hashMap2.put(split[i2], arrayList2);
                        arrayList = arrayList2;
                    } else {
                        arrayList = list;
                    }
                    HashMap hashMap3 = arrayList.size() > 0 ? (Map) arrayList.get(arrayList.size() - 1) : null;
                    if (hashMap3 == null || i2 == split.length - 1) {
                        hashMap3 = new HashMap();
                        arrayList.add(hashMap3);
                    }
                    hashMap2 = hashMap3;
                }
                if (jSONObject.has("content")) {
                    if (jSONObject.isNull("content")) {
                        hashMap2.put("value", null);
                    } else {
                        hashMap2.put("value", jSONObject.getString("content"));
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // p000a.AbstractC0009e
    /* renamed from: a */
    public C0018l<C0004c> mo21567a(final Uri uri) {
        final C0015i c0015i = new C0015i();
        final C0015i c0015i2 = new C0015i();
        return C0018l.m21610a((Callable) new Callable<Void>() { // from class: a.m.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                URL url;
                URL url2 = new URL(uri.toString());
                HttpURLConnection httpURLConnection = null;
                while (url2 != null) {
                    URLConnection openConnection = url2.openConnection();
                    if (openConnection instanceof HttpURLConnection) {
                        ((HttpURLConnection) openConnection).setInstanceFollowRedirects(true);
                    }
                    openConnection.setRequestProperty(C0031m.f92c, C0031m.f93d);
                    openConnection.connect();
                    if (openConnection instanceof HttpURLConnection) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                        if (httpURLConnection2.getResponseCode() < 300 || httpURLConnection2.getResponseCode() >= 400) {
                            url = null;
                        } else {
                            URL url3 = new URL(httpURLConnection2.getHeaderField(C5083e.f21644H));
                            httpURLConnection2.disconnect();
                            url = url3;
                        }
                        url2 = url;
                        httpURLConnection = openConnection;
                    } else {
                        httpURLConnection = openConnection;
                        url2 = null;
                    }
                }
                try {
                    c0015i.m21626a(C0031m.m21561b(httpURLConnection));
                    c0015i2.m21626a(httpURLConnection.getContentType());
                    return null;
                } finally {
                    if (httpURLConnection instanceof HttpURLConnection) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).m21592d(new AbstractC0016j<Void, C0018l<JSONArray>>() { // from class: a.m.2
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0018l<JSONArray> mo21799then(C0018l<Void> c0018l) {
                final C0018l.C0030a m21621a = C0018l.m21621a();
                WebView webView = new WebView(C0031m.this.f103a);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setNetworkAvailable(false);
                webView.setWebViewClient(new WebViewClient() { // from class: a.m.2.1

                    /* renamed from: b */
                    private boolean f111b = false;

                    /* renamed from: a */
                    private void m21556a(WebView webView2) {
                        if (!this.f111b) {
                            this.f111b = true;
                            webView2.loadUrl(C0031m.f91b);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onLoadResource(WebView webView2, String str) {
                        super.onLoadResource(webView2, str);
                        m21556a(webView2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str) {
                        super.onPageFinished(webView2, str);
                        m21556a(webView2);
                    }
                });
                webView.addJavascriptInterface(new Object() { // from class: a.m.2.2
                    @JavascriptInterface
                    public void setValue(String str) {
                        try {
                            m21621a.m21573a((C0018l.C0030a) new JSONArray(str));
                        } catch (JSONException e) {
                            m21621a.m21574a((Exception) e);
                        }
                    }
                }, "boltsWebViewAppLinkResolverResult");
                webView.loadDataWithBaseURL(uri.toString(), (String) c0015i.m21627a(), c0015i2.m21627a() != null ? ((String) c0015i2.m21627a()).split(";")[0] : null, null, null);
                return m21621a.m21575a();
            }
        }, C0018l.f50b).m21598c(new AbstractC0016j<JSONArray, C0004c>() { // from class: a.m.1
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public C0004c mo21799then(C0018l<JSONArray> c0018l) {
                return C0031m.m21560b(C0031m.m21559b(c0018l.m21590e()), uri);
            }
        });
    }
}
