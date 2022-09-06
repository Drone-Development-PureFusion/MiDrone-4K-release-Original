package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.g */
/* loaded from: classes.dex */
public class C1236g extends AbstractC1254r<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public C1236g(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public ArrayList<GeocodeAddress> mo16811b(String str) {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("count") && jSONObject.getInt("count") > 0) ? C1239j.m16974n(jSONObject) : arrayList;
        } catch (JSONException e) {
            C1233d.m17031a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            C1233d.m17031a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&address=").append(c(((GeocodeQuery) this.f4183a).getLocationName()));
        String city = ((GeocodeQuery) this.f4183a).getCity();
        if (!C1239j.m16985h(city)) {
            stringBuffer.append("&city=").append(c(city));
        }
        stringBuffer.append("&key=" + C1259w.m16920f(this.f4186d));
        stringBuffer.append("&language=").append(C1232c.m17036b());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/geocode/geo?";
    }
}
