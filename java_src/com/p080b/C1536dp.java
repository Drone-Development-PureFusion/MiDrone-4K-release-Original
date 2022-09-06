package com.p080b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.open.GameAppOperation;
import com.tencent.stat.DeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
/* renamed from: com.b.dp */
/* loaded from: classes.dex */
public class C1536dp {

    /* renamed from: com.b.dp$a */
    /* loaded from: classes.dex */
    public static class C1537a {

        /* renamed from: a */
        public JSONObject f5490a;

        /* renamed from: b */
        public JSONObject f5491b;

        /* renamed from: c */
        public JSONObject f5492c;

        /* renamed from: d */
        public JSONObject f5493d;

        /* renamed from: e */
        public JSONObject f5494e;

        /* renamed from: f */
        public JSONObject f5495f;

        /* renamed from: g */
        public C1538a f5496g;

        /* renamed from: h */
        public C1540c f5497h;

        /* renamed from: i */
        public C1539b f5498i;

        /* renamed from: com.b.dp$a$a */
        /* loaded from: classes.dex */
        public static class C1538a {

            /* renamed from: a */
            public boolean f5499a;

            /* renamed from: b */
            public boolean f5500b;
        }

        /* renamed from: com.b.dp$a$b */
        /* loaded from: classes.dex */
        public static class C1539b {

            /* renamed from: a */
            public String f5501a;

            /* renamed from: b */
            public String f5502b;
        }

        /* renamed from: com.b.dp$a$c */
        /* loaded from: classes.dex */
        public static class C1540c {

            /* renamed from: a */
            public String f5503a;

            /* renamed from: b */
            public String f5504b;

            /* renamed from: c */
            public String f5505c;
        }
    }

    /* renamed from: com.b.dp$b */
    /* loaded from: classes.dex */
    static class C1541b extends AbstractC1428aq {

        /* renamed from: d */
        private Context f5506d;

        /* renamed from: e */
        private C1549dv f5507e;

        /* renamed from: f */
        private String f5508f;

        C1541b(Context context, C1549dv c1549dv, String str) {
            this.f5508f = "";
            this.f5506d = context;
            this.f5507e = c1549dv;
            this.f5508f = str;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: a */
        public Map<String, String> mo15505a() {
            HashMap hashMap = new HashMap();
            hashMap.put(C5083e.f21661Y, this.f5507e.m15577c());
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", this.f5507e.m15578b(), this.f5507e.m15580a()));
            hashMap.put("logversion", "2.0");
            return hashMap;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: b */
        public Map<String, String> mo15504b() {
            String m15615q = C1542dq.m15615q(this.f5506d);
            if (!TextUtils.isEmpty(m15615q)) {
                m15615q = C1545ds.m15596b(new StringBuilder(m15615q).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("key", C1533dm.m15662f(this.f5506d));
            hashMap.put("opertype", this.f5508f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.f5507e.m15580a());
            hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, this.f5507e.m15578b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", m15615q);
            hashMap.put("abitype", Build.CPU_ABI);
            hashMap.put("ext", this.f5507e.m15576d());
            String m15654a = C1535do.m15654a();
            String m15650a = C1535do.m15650a(this.f5506d, m15654a, C1552dw.m15555b(hashMap));
            hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m15654a);
            hashMap.put("scode", m15650a);
            return hashMap;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: c */
        public String mo15503c() {
            return "https://restapi.amap.com/v3/config/resource?";
        }
    }

    /* renamed from: a */
    public static C1537a m15644a(Context context, C1549dv c1549dv, String str) {
        try {
            return m15638a(new C1422am().m16344a(new C1541b(context, c1549dv, str)));
        } catch (C1532dl e) {
            C1450b.m16187a(e, "ConfigManager", "loadConfig");
            return new C1537a();
        } catch (Throwable th) {
            C1450b.m16187a(th, "ConfigManager", "loadConfig");
            return new C1537a();
        }
    }

    /* renamed from: a */
    public static C1537a m15638a(byte[] bArr) {
        JSONObject jSONObject;
        boolean z = false;
        C1537a c1537a = new C1537a();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    JSONObject jSONObject2 = new JSONObject(new String(bArr, "UTF-8"));
                    if ("1".equals(m15639a(jSONObject2, "status")) && jSONObject2.has("result") && (jSONObject = jSONObject2.getJSONObject("result")) != null) {
                        boolean m15637b = C1552dw.m15557a(jSONObject, "exception") ? m15637b(jSONObject.getJSONObject("exception")) : false;
                        if (C1552dw.m15557a(jSONObject, "common")) {
                            z = m15642a(jSONObject.getJSONObject("common"));
                        }
                        C1537a.C1538a c1538a = new C1537a.C1538a();
                        c1538a.f5499a = m15637b;
                        c1538a.f5500b = z;
                        c1537a.f5496g = c1538a;
                        if (jSONObject.has("sdkupdate")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("sdkupdate");
                            C1537a.C1540c c1540c = new C1537a.C1540c();
                            m15640a(jSONObject3, c1540c);
                            c1537a.f5497h = c1540c;
                        }
                        if (C1552dw.m15557a(jSONObject, "sdkcoordinate")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("sdkcoordinate");
                            C1537a.C1539b c1539b = new C1537a.C1539b();
                            m15641a(jSONObject4, c1539b);
                            c1537a.f5498i = c1539b;
                        }
                        if (C1552dw.m15557a(jSONObject, "callamap")) {
                            c1537a.f5494e = jSONObject.getJSONObject("callamap");
                        }
                        if (C1552dw.m15557a(jSONObject, "ca")) {
                            c1537a.f5495f = jSONObject.getJSONObject("ca");
                        }
                        if (C1552dw.m15557a(jSONObject, "locate")) {
                            c1537a.f5493d = jSONObject.getJSONObject("locate");
                        }
                        if (C1552dw.m15557a(jSONObject, "callamappro")) {
                            c1537a.f5492c = jSONObject.getJSONObject("callamappro");
                        }
                        if (C1552dw.m15557a(jSONObject, "opflag")) {
                            c1537a.f5491b = jSONObject.getJSONObject("opflag");
                        }
                        if (C1552dw.m15557a(jSONObject, "amappushflag")) {
                            c1537a.f5490a = jSONObject.getJSONObject("amappushflag");
                        }
                    }
                }
            } catch (UnsupportedEncodingException e) {
                C1450b.m16187a(e, "ConfigManager", "loadConfig");
            } catch (JSONException e2) {
                C1450b.m16187a(e2, "ConfigManager", "loadConfig");
            } catch (Throwable th) {
                C1450b.m16187a(th, "ConfigManager", "loadConfig");
            }
        }
        return c1537a;
    }

    /* renamed from: a */
    public static String m15639a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    /* renamed from: a */
    private static void m15641a(JSONObject jSONObject, C1537a.C1539b c1539b) {
        if (jSONObject != null) {
            try {
                String m15639a = m15639a(jSONObject, "md5");
                String m15639a2 = m15639a(jSONObject, "url");
                c1539b.f5502b = m15639a;
                c1539b.f5501a = m15639a2;
            } catch (JSONException e) {
                C1450b.m16187a(e, "ConfigManager", "parseSDKCoordinate");
            } catch (Throwable th) {
                C1450b.m16187a(th, "ConfigManager", "parseSDKCoordinate");
            }
        }
    }

    /* renamed from: a */
    private static void m15640a(JSONObject jSONObject, C1537a.C1540c c1540c) {
        if (jSONObject != null) {
            try {
                String m15639a = m15639a(jSONObject, "md5");
                String m15639a2 = m15639a(jSONObject, "url");
                String m15639a3 = m15639a(jSONObject, "sdkversion");
                if (TextUtils.isEmpty(m15639a) || TextUtils.isEmpty(m15639a2) || TextUtils.isEmpty(m15639a3)) {
                    return;
                }
                c1540c.f5503a = m15639a2;
                c1540c.f5504b = m15639a;
                c1540c.f5505c = m15639a3;
            } catch (JSONException e) {
                C1450b.m16187a(e, "ConfigManager", "parseSDKUpdate");
            } catch (Throwable th) {
                C1450b.m16187a(th, "ConfigManager", "parseSDKUpdate");
            }
        }
    }

    /* renamed from: a */
    private static boolean m15643a(String str) {
        return str != null && str.equals("1");
    }

    /* renamed from: a */
    private static boolean m15642a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return m15643a(m15639a(jSONObject.getJSONObject("commoninfo"), "com_isupload"));
        } catch (JSONException e) {
            C1450b.m16187a(e, "ConfigManager", "parseCommon");
            return false;
        } catch (Throwable th) {
            C1450b.m16187a(th, "ConfigManager", "parseCommon");
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m15637b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return m15643a(m15639a(jSONObject.getJSONObject("exceptinfo"), "ex_isupload"));
        } catch (JSONException e) {
            C1450b.m16187a(e, "ConfigManager", "parseException");
            return false;
        } catch (Throwable th) {
            C1450b.m16187a(th, "ConfigManager", "parseException");
            return false;
        }
    }
}
