package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.e */
/* loaded from: classes.dex */
public class C1234e extends AbstractC1254r<DistrictSearchQuery, DistrictResult> {
    public C1234e(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public DistrictResult mo16811b(String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f4183a, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e) {
            C1233d.m17031a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C1233d.m17031a(e2, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        C1239j.m17011a(optJSONArray, arrayList, (DistrictItem) null);
        return districtResult;
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=").append(((DistrictSearchQuery) this.f4183a).getPageNum() + 1);
        stringBuffer.append("&offset=").append(((DistrictSearchQuery) this.f4183a).getPageSize());
        stringBuffer.append("&showChild=").append(((DistrictSearchQuery) this.f4183a).isShowChild());
        if (((DistrictSearchQuery) this.f4183a).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f4183a).checkKeyWords()) {
            stringBuffer.append("&keywords=").append(c(((DistrictSearchQuery) this.f4183a).getKeywords()));
        }
        if (((DistrictSearchQuery) this.f4183a).checkLevels()) {
            stringBuffer.append("&level=").append(((DistrictSearchQuery) this.f4183a).getKeywordsLevel());
        }
        stringBuffer.append("&key=" + C1259w.m16920f(this.f4186d));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/config/district?";
    }
}
