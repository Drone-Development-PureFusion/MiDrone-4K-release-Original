package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.C0977ez;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.be */
/* loaded from: classes.dex */
public class C0834be extends AbstractC0861by<String, List<OfflineMapProvince>> {

    /* renamed from: d */
    private Context f2335d;

    public C0834be(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    protected String mo18733a() {
        return "006";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    public List<OfflineMapProvince> mo18729b(JSONObject jSONObject) {
        try {
            if (this.f2335d != null) {
                C0856bu.m18743c(jSONObject.toString(), this.f2335d);
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            if (this.f2335d == null) {
                return null;
            }
            return C0856bu.m18751a(jSONObject, this.f2335d);
        } catch (JSONException e) {
            C1007fo.m18012b(e, "OfflineUpdateCityHandler", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    protected JSONObject mo18731a(C0977ez.C0978a c0978a) {
        JSONObject jSONObject = c0978a.f3065n;
        if (!jSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m18850a(Context context) {
        this.f2335d = context;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: b */
    protected Map<String, String> mo18730b() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapver", this.f2402a);
        return hashMap;
    }
}
