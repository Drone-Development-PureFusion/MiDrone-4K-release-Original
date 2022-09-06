package com.p080b;

import android.content.Context;
import android.util.Log;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.tencent.stat.DeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p258f.C5078j;
/* renamed from: com.b.dn */
/* loaded from: classes.dex */
public class C1534dn {

    /* renamed from: c */
    private static C1549dv f5487c;

    /* renamed from: a */
    public static int f5485a = -1;

    /* renamed from: b */
    public static String f5486b = "";

    /* renamed from: d */
    private static String f5488d = "http://apiinit.amap.com/v3/log/init";

    /* renamed from: e */
    private static String f5489e = null;

    /* renamed from: a */
    private static String m15660a() {
        return f5488d;
    }

    /* renamed from: a */
    private static Map<String, String> m15659a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String m15654a = C1535do.m15654a();
            hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m15654a);
            hashMap.put("key", C1533dm.m15662f(context));
            hashMap.put("scode", C1535do.m15650a(context, m15654a, C1552dw.m15560a("resType=json&encode=UTF-8&key=" + C1533dm.m15662f(context))));
        } catch (Throwable th) {
            C1450b.m16187a(th, "Auth", "gParams");
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m15656a(String str) {
        C1533dm.m15665c(str);
    }

    /* renamed from: a */
    public static synchronized boolean m15658a(Context context, C1549dv c1549dv) {
        boolean m15657a;
        synchronized (C1534dn.class) {
            m15657a = m15657a(context, c1549dv, true);
        }
        return m15657a;
    }

    /* renamed from: a */
    private static boolean m15657a(Context context, C1549dv c1549dv, boolean z) {
        f5487c = c1549dv;
        try {
            String m15660a = m15660a();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", C5078j.f21618a);
            hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            hashMap.put(C5083e.f21675j, "Keep-Alive");
            hashMap.put(C5083e.f21661Y, f5487c.f5528b);
            hashMap.put("X-INFO", C1535do.m15651a(context, f5487c, null, z));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", f5487c.f5527a, f5487c.f5529c));
            C1422am m16345a = C1422am.m16345a();
            C1553dx c1553dx = new C1553dx();
            c1553dx.a(C1546dt.m15589a(context));
            c1553dx.m15548a(hashMap);
            c1553dx.m15547b(m15659a(context));
            c1553dx.m15549a(m15660a);
            return m15655a(m16345a.m16342b(c1553dx));
        } catch (Throwable th) {
            C1450b.m16187a(th, "Auth", "getAuth");
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m15655a(byte[] bArr) {
        String str;
        if (bArr == null) {
            return true;
        }
        try {
            try {
                str = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                str = new String(bArr);
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f5485a = 1;
                } else if (i == 0) {
                    f5485a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f5486b = jSONObject.getString("info");
            }
            if (f5485a == 0) {
                Log.i("AuthFailure", f5486b);
            }
            return f5485a == 1;
        } catch (JSONException e2) {
            C1450b.m16187a(e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            C1450b.m16187a(th, "Auth", "lData");
            return false;
        }
    }
}
