package com.amap.api.services.core;

import android.content.Context;
import com.tencent.open.GameAppOperation;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p253a.C5018b;
/* renamed from: com.amap.api.services.core.n */
/* loaded from: classes.dex */
class C1244n extends AbstractC1227bt {

    /* renamed from: a */
    private Context f4166a;

    /* renamed from: b */
    private String f4167b;

    public C1244n(Context context) {
        this.f4166a = context;
        this.f4167b = C1259w.m16920f(context);
    }

    /* renamed from: a */
    private C1245o m16955a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("status");
            if ("0".equals(optString) || !"1".equals(optString)) {
                return null;
            }
            JSONObject m16956a = m16956a(jSONObject, "result");
            return new C1245o(m16957a(m16954b(m16956a(m16956a(m16956a, "common"), "commoninfo"), "com_isupload")), m16957a(m16954b(m16956a(m16956a(m16956a, "exception"), "exceptinfo"), "ex_isupload")));
        } catch (JSONException e) {
            C1233d.m17031a(e, "ManifestManager", "loadData");
            return null;
        } catch (Exception e2) {
            C1233d.m17031a(e2, "ManifestManager", "loadData");
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m16956a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    /* renamed from: a */
    private boolean m16957a(String str) {
        return str != null && str.equals("1");
    }

    /* renamed from: b */
    private String m16954b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(str);
    }

    /* renamed from: a */
    public C1245o m16958a() {
        try {
            C1224bs m17051a = C1224bs.m17051a(false);
            a(C1165ac.m17269a(this.f4166a));
            return m16955a(m17051a.m17055a(this));
        } catch (Exception e) {
            C1233d.m17031a(e, "ManifestManager", "feachManifest");
            return null;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/config/resource";
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: c_ */
    public Map<String, String> mo16937c_() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", this.f4167b);
        hashMap.put("opertype", "common;exception");
        hashMap.put("plattype", "android");
        hashMap.put("product", "sea");
        hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, "2.5.0");
        hashMap.put("ext", C5018b.f21482c);
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(this.f4167b);
        stringBuffer.append("&opertype=common;exception");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append("sea");
        stringBuffer.append("&version=").append("2.5.0");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String m17247a = C1169ae.m17247a(stringBuffer.toString());
        String m16917a = C1261y.m16917a();
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m16917a);
        hashMap.put("scode", C1261y.m16913a(this.f4166a, m16917a, m17247a));
        return hashMap;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: d_ */
    public Map<String, String> mo16935d_() {
        HashMap hashMap = new HashMap();
        hashMap.put(C5083e.f21661Y, "AMAP SDK Android Search 2.5.0");
        return hashMap;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: e */
    public HttpEntity mo16934e() {
        return null;
    }
}
