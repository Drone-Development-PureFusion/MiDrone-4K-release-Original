package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.baidu.tts.loopj.AsyncHttpClient;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p258f.C5078j;
@Deprecated
/* renamed from: com.amap.api.mapcore.util.fa */
/* loaded from: classes.dex */
public class C0985fa {

    /* renamed from: c */
    private static C0996fh f3091c;

    /* renamed from: a */
    public static int f3089a = -1;

    /* renamed from: b */
    public static String f3090b = "";

    /* renamed from: d */
    private static String f3092d = "http://apiinit.amap.com/v3/log/init";

    /* renamed from: e */
    private static String f3093e = null;

    /* renamed from: a */
    private static String m18157a() {
        return f3092d;
    }

    /* renamed from: a */
    private static Map<String, String> m18156a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String m18151a = C0986fb.m18151a();
            hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m18151a);
            hashMap.put("key", C0976ey.m18166f(context));
            hashMap.put("scode", C0986fb.m18146a(context, m18151a, C0999fi.m18038d("resType=json&encode=UTF-8&key=" + C0976ey.m18166f(context))));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Auth", "gParams");
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m18153a(String str) {
        C0976ey.m18171a(str);
    }

    @Deprecated
    /* renamed from: a */
    public static synchronized boolean m18155a(Context context, C0996fh c0996fh) {
        boolean m18154a;
        synchronized (C0985fa.class) {
            m18154a = m18154a(context, c0996fh, false);
        }
        return m18154a;
    }

    /* renamed from: a */
    private static boolean m18154a(Context context, C0996fh c0996fh, boolean z) {
        f3091c = c0996fh;
        try {
            String m18157a = m18157a();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", C5078j.f21618a);
            hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            hashMap.put(C5083e.f21675j, "Keep-Alive");
            hashMap.put(C5083e.f21661Y, f3091c.m18067d());
            hashMap.put("X-INFO", C0986fb.m18148a(context, f3091c, null, z));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", f3091c.m18070b(), f3091c.m18074a()));
            C1057gx m17771a = C1057gx.m17771a();
            C1000fj c1000fj = new C1000fj();
            c1000fj.a(C0993ff.m18085a(context));
            c1000fj.m18030a(hashMap);
            c1000fj.m18029b(m18156a(context));
            c1000fj.m18031a(m18157a);
            return m18152a(m17771a.mo17705b(c1000fj));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Auth", "getAuth");
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m18152a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(C0999fi.m18043a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f3089a = 1;
                } else if (i == 0) {
                    f3089a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f3090b = jSONObject.getString("info");
            }
            if (f3089a == 0) {
                Log.i("AuthFailure", f3090b);
            }
            return f3089a == 1;
        } catch (JSONException e) {
            C1002fl.m18028a(e, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Auth", "lData");
            return false;
        }
    }
}
