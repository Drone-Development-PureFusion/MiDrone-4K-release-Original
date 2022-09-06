package com.fimi.soul.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fimi.kernel.utils.C2258f;
import com.fimi.kernel.utils.C2273r;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.base.C2353b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.p248a.p249a.p261f.p264c.AbstractC5124n;
import org.p248a.p249a.p261f.p264c.C5115g;
import org.p248a.p249a.p261f.p264c.C5119i;
import org.p248a.p249a.p268i.p270b.C5197t;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class NetUtil {

    /* renamed from: a */
    public static String f14748a = null;

    /* renamed from: b */
    public static Header f14749b = null;

    /* renamed from: c */
    public static final String f14750c = "admin";

    /* renamed from: d */
    private static NetUtil f14751d;

    static {
        System.loadLibrary("server-jni");
    }

    /* renamed from: a */
    public static NetUtil m7770a() {
        if (f14751d == null) {
            f14751d = new NetUtil();
        }
        return f14751d;
    }

    /* renamed from: a */
    public static String m7767a(String str, List<NameValuePair> list, Context context) {
        if (m7768a(m7761b(list))) {
            str = "";
        }
        C2277v.m12784a(context);
        m7764a(list, context);
        HttpPost httpPost = new HttpPost(str);
        if (list != null) {
            try {
                if (list.size() > 0) {
                    httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        HttpClient m7763b = m7763b();
        String str2 = "";
        try {
            HttpResponse execute = m7763b.execute(httpPost);
            f14749b = execute.getFirstHeader("Content-Encoding");
            if (execute.getStatusLine().getStatusCode() == 200) {
                str2 = C2273r.m12840a(EntityUtils.toString(execute.getEntity(), "utf-8"), getNetKey());
            } else {
                C2353b.m12509a(" request  timeout ", NetUtil.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            m7763b.getConnectionManager().shutdown();
        }
        return str2;
    }

    /* renamed from: a */
    public static String m7766a(String str, List<NameValuePair> list, Context context, boolean z) {
        String str2;
        Exception e;
        if (!z) {
            return m7767a(str, list, context);
        }
        m7764a(list, context);
        new C2277v(context);
        if (list != null && list.size() > 0) {
            str = str + C0228a.f351a + URLEncodedUtils.format(list, "UTF-8");
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.getParams().setParameter("http.connection.timeout", 30000);
        defaultHttpClient.getParams().setParameter("http.socket.timeout", 120000);
        try {
            try {
                HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
                int statusCode = execute.getStatusLine().getStatusCode();
                f14749b = execute.getFirstHeader("Content-Encoding");
                if (statusCode == 200) {
                    List cookies = defaultHttpClient.getCookieStore().getCookies();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= cookies.size()) {
                            break;
                        } else if ("JSESSIONID".equals(((Cookie) cookies.get(i2)).getName())) {
                            f14748a = ((Cookie) cookies.get(i2)).getValue();
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                    str2 = EntityUtils.toString(execute.getEntity(), "utf-8");
                    try {
                        C2353b.m12509a("data... json: " + str2, NetUtil.class);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return str2;
                    }
                } else {
                    str2 = "";
                }
                return str2;
            } finally {
                defaultHttpClient.getConnectionManager().shutdown();
            }
        } catch (Exception e3) {
            str2 = "";
            e = e3;
        }
    }

    /* renamed from: a */
    public static String m7765a(List<NameValuePair> list) {
        TreeMap treeMap = new TreeMap();
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                treeMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
        }
        if (treeMap == null || treeMap.size() == 0) {
            return null;
        }
        for (String str : treeMap.keySet()) {
            if (treeMap.get(str) != null && treeMap.get(str) != "") {
                stringBuffer.append(str + "=" + ((String) treeMap.get(str)) + "&");
            }
        }
        try {
            return C3671aw.m7512a(URLEncoder.encode(stringBuffer.toString() + "key=", "utf-8"), getServerTokenKey()).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m7764a(List<NameValuePair> list, Context context) {
        list.add(new BasicNameValuePair("req", C2258f.m13020a(new Date(), C2258f.f7530e) + ((int) (Math.random() * 1000000.0d)) + "10"));
        list.add(new BasicNameValuePair("channel", "android"));
        list.add(new BasicNameValuePair("visitID", C2353b.m12507c(context).getUserID().equals("") ? "0" : C2353b.m12507c(context).getUserID()));
        list.add(new BasicNameValuePair("local", C3658ar.m7590d()));
        list.add(new BasicNameValuePair("appVersion", C3658ar.m7589d(context)));
        list.add(new BasicNameValuePair("encrypt", "0"));
        list.add(new BasicNameValuePair("signMsg", m7765a(list)));
    }

    /* renamed from: a */
    public static boolean m7769a(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isAvailable() && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m7768a(String str) {
        boolean z = false;
        for (EnumC3687o enumC3687o : EnumC3687o.values()) {
            if (enumC3687o.toString().equals(str)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static String m7762b(String str, List<NameValuePair> list, Context context) {
        return m7767a(str, list, context);
    }

    /* renamed from: b */
    public static String m7761b(List<NameValuePair> list) {
        String str = null;
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                str = nameValuePair.getName().equals("commandCode") ? nameValuePair.getValue() : str;
            }
        }
        return str;
    }

    /* renamed from: b */
    private static HttpClient m7763b() {
        try {
            return C5197t.m1680a().m1712a(new C5115g(C5119i.m1973c().m1984a().m1981a((KeyStore) null, new AbstractC5124n() { // from class: com.fimi.soul.utils.NetUtil.1
                @Override // org.p248a.p249a.p261f.p264c.AbstractC5124n
                /* renamed from: a */
                public boolean mo1964a(X509Certificate[] x509CertificateArr, String str) {
                    return true;
                }
            }).m1976c())).m1681i();
        } catch (KeyManagementException e) {
            e.printStackTrace();
            return null;
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static native String getLogTokenKey();

    public static native String getNetKey();

    public static native String getSSL1234Key();

    public static native String getServerTokenKey();
}
