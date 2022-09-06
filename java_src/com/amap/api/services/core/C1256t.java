package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.t */
/* loaded from: classes.dex */
public class C1256t extends AbstractC1254r<RegeocodeQuery, RegeocodeAddress> {
    public C1256t(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public RegeocodeAddress mo16811b(String str) {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject != null) {
                regeocodeAddress.setFormatAddress(C1239j.m17002b(optJSONObject, "formatted_address"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
                if (optJSONObject2 != null) {
                    C1239j.m17009a(optJSONObject2, regeocodeAddress);
                }
                regeocodeAddress.setPois(C1239j.m16998c(optJSONObject));
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                if (optJSONArray != null) {
                    C1239j.m17004b(optJSONArray, regeocodeAddress);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
                if (optJSONArray2 != null) {
                    C1239j.m17012a(optJSONArray2, regeocodeAddress);
                }
            }
        } catch (JSONException e) {
            C1233d.m17031a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        return regeocodeAddress;
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&extensions=all").append("&location=").append(((RegeocodeQuery) this.f4183a).getPoint().getLongitude()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(((RegeocodeQuery) this.f4183a).getPoint().getLatitude());
        stringBuffer.append("&radius=").append(((RegeocodeQuery) this.f4183a).getRadius());
        stringBuffer.append("&coordsys=").append(((RegeocodeQuery) this.f4183a).getLatLonType());
        stringBuffer.append("&key=" + C1259w.m16920f(this.f4186d));
        stringBuffer.append("&language=").append(C1232c.m17036b());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/geocode/regeo?";
    }
}
