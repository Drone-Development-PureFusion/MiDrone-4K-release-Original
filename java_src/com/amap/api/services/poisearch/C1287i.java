package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.C1232c;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1239j;
import com.amap.api.services.core.C1259w;
import com.amap.api.services.core.ServiceSettings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.poisearch.i */
/* loaded from: classes.dex */
class C1287i extends AbstractC1285g<String, PoiItemDetail> {

    /* renamed from: h */
    private String f4411h;

    public C1287i(Context context, String str, String str2) {
        super(context, str);
        this.f4411h = "zh-CN";
        if ("en".equals(str2)) {
            this.f4411h = str2;
        }
    }

    /* renamed from: a */
    private PoiItemDetail m16818a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        PoiItemDetail poiItemDetail = null;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            poiItemDetail = C1239j.m16994d(optJSONObject);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
            if (optJSONObject2 != null) {
                C1239j.m17018a(poiItemDetail, optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("deep_info");
            if (optJSONObject3 != null) {
                C1239j.m16992e(poiItemDetail, optJSONObject3, optJSONObject);
            }
        }
        return poiItemDetail;
    }

    /* renamed from: f */
    private String m16816f() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append((String) this.f4183a);
        sb.append("&output=json");
        sb.append("&extensions=all");
        sb.append("&language=").append(ServiceSettings.getInstance().getLanguage());
        sb.append("&key=" + C1259w.m16920f(this.f4186d));
        return sb.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        return m16816f();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/place/detail?";
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: e */
    public PoiItemDetail mo16811b(String str) {
        try {
            return m16818a(new JSONObject(str));
        } catch (JSONException e) {
            C1233d.m17031a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            C1233d.m17031a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }
}
