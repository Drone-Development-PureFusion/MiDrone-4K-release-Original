package com.p080b;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.baidu.tts.loopj.RequestParams;
import com.facebook.common.util.UriUtil;
import com.p080b.C1549dv;
import com.tencent.stat.DeviceInfo;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p258f.C5078j;
/* renamed from: com.b.bl */
/* loaded from: classes.dex */
public class C1467bl {

    /* renamed from: e */
    private static C1467bl f5090e = null;

    /* renamed from: a */
    C1549dv f5091a;

    /* renamed from: b */
    String f5092b;

    /* renamed from: c */
    C1422am f5093c;

    /* renamed from: d */
    C1423an f5094d = null;

    /* renamed from: f */
    private long f5095f = 0;

    /* renamed from: g */
    private int f5096g = C1514cx.f5415j;

    /* renamed from: h */
    private int f5097h = C1514cx.f5415j;

    private C1467bl(Context context) {
        this.f5091a = null;
        this.f5092b = null;
        this.f5093c = null;
        try {
            this.f5091a = new C1549dv.C1550a("loc", "2.4.1", "AMAP_Location_SDK_Android 2.4.1").m15569a(C1514cx.m15726b()).m15573a();
        } catch (C1532dl e) {
            C1514cx.m15728a(e, "LocNetManager", "LocNetManager");
        }
        this.f5092b = C1535do.m15651a(context, this.f5091a, new HashMap(), true);
        this.f5093c = C1422am.m16345a();
    }

    /* renamed from: a */
    public static int m16068a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static synchronized C1467bl m16071a(Context context) {
        C1467bl c1467bl;
        synchronized (C1467bl.class) {
            if (f5090e == null) {
                f5090e = new C1467bl(context);
            }
            c1467bl = f5090e;
        }
        return c1467bl;
    }

    /* renamed from: a */
    public String m16067a(byte[] bArr, Context context, String str, boolean z) {
        String str2 = null;
        if (m16068a(C1477bs.m15988c(context)) == -1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        C1468bm c1468bm = new C1468bm();
        hashMap.clear();
        hashMap.put("Content-Type", C5078j.f21618a);
        hashMap.put(C5083e.f21675j, "Keep-Alive");
        if (z) {
            hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            hashMap.put(C5083e.f21661Y, "AMAP_Location_SDK_Android 2.4.1");
            hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "2.4.1", "loc"));
            hashMap.put("logversion", "2.1");
        }
        c1468bm.m16065a(hashMap);
        c1468bm.m16066a(str);
        c1468bm.m16064a(bArr);
        c1468bm.a(C1546dt.m15589a(context));
        c1468bm.a(C1514cx.f5415j);
        c1468bm.b(C1514cx.f5415j);
        try {
            str2 = new String(z ? this.f5093c.m16344a(c1468bm) : this.f5093c.m16342b(c1468bm), "utf-8");
            return str2;
        } catch (C1532dl e) {
            C1514cx.m15728a(e, "LocNetManager", "post");
            return str2;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "LocNetManager", "post");
            return str2;
        }
    }

    /* renamed from: a */
    public HttpURLConnection m16070a(Context context, String str, HashMap<String, String> hashMap, byte[] bArr) {
        try {
            if (m16068a(C1477bs.m15988c(context)) == -1) {
                return null;
            }
            boolean z = false;
            C1468bm c1468bm = new C1468bm();
            c1468bm.m16065a(hashMap);
            c1468bm.m16066a(str);
            c1468bm.m16064a(bArr);
            c1468bm.a(C1546dt.m15589a(context));
            c1468bm.a(C1514cx.f5415j);
            c1468bm.b(C1514cx.f5415j);
            if (str.toLowerCase(Locale.US).startsWith(UriUtil.HTTPS_SCHEME)) {
                z = true;
            }
            return this.f5093c.m16343a(c1468bm, z);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "LocNetManager", "doHttpPost");
            return null;
        }
    }

    /* renamed from: a */
    public byte[] m16069a(Context context, JSONObject jSONObject, C1472bo c1472bo, String str) {
        if (C1477bs.m16000a(jSONObject, "httptimeout")) {
            try {
                this.f5096g = jSONObject.getInt("httptimeout");
            } catch (Throwable th) {
                C1514cx.m15728a(th, "LocNetManager", "req");
            }
        }
        if (m16068a(C1477bs.m15988c(context)) == -1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        C1468bm c1468bm = new C1468bm();
        hashMap.clear();
        hashMap.put("Content-Type", RequestParams.APPLICATION_OCTET_STREAM);
        hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        hashMap.put("gzipped", "1");
        hashMap.put(C5083e.f21675j, "Keep-Alive");
        hashMap.put(C5083e.f21661Y, "AMAP_Location_SDK_Android 2.4.1");
        hashMap.put("X-INFO", this.f5092b);
        hashMap.put("KEY", C1533dm.m15662f(context));
        hashMap.put("enginever", "4.2");
        String m15654a = C1535do.m15654a();
        String m15650a = C1535do.m15650a(context, m15654a, "key=" + C1533dm.m15662f(context));
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m15654a);
        hashMap.put("scode", m15650a);
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "2.4.1", "loc"));
        hashMap.put("logversion", "2.1");
        hashMap.put("encr", "1");
        c1468bm.m16065a(hashMap);
        c1468bm.m16066a(str);
        c1468bm.m16064a(C1477bs.m15999a(c1472bo.m16061a()));
        c1468bm.a(C1546dt.m15589a(context));
        c1468bm.a(this.f5096g);
        c1468bm.b(this.f5096g);
        return this.f5093c.m16342b(c1468bm);
    }
}
