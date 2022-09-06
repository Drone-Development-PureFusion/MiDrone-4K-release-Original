package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.C1232c;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1239j;
import com.amap.api.services.core.C1255s;
import com.amap.api.services.core.C1259w;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.poisearch.j */
/* loaded from: classes.dex */
class C1288j extends AbstractC1285g<C1255s, ArrayList<PoiItem>> {

    /* renamed from: h */
    private int f4412h = 1;

    /* renamed from: i */
    private int f4413i = 20;

    /* renamed from: j */
    private int f4414j = 0;

    /* renamed from: k */
    private List<String> f4415k = new ArrayList();

    /* renamed from: l */
    private List<SuggestionCity> f4416l = new ArrayList();

    public C1288j(Context context, C1255s c1255s) {
        super(context, c1255s);
    }

    /* renamed from: n */
    private String m16803n() {
        return ((C1255s) this.f4183a).f4189b.isDistanceSort() ? "distance" : "weight";
    }

    /* renamed from: o */
    private String m16802o() {
        StringBuffer stringBuffer = new StringBuffer();
        if (((C1255s) this.f4183a).f4188a.hasGroupBuyLimit() && ((C1255s) this.f4183a).f4188a.hasDiscountLimit()) {
            stringBuffer.append("&filter=groupbuy:1|discount:1");
            return stringBuffer.toString();
        }
        if (((C1255s) this.f4183a).f4188a.hasGroupBuyLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("groupbuy:1");
        }
        if (((C1255s) this.f4183a).f4188a.hasDiscountLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("discount:1");
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void m16815a(int i) {
        this.f4412h = i + 1;
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((C1255s) this.f4183a).f4189b != null) {
            if (((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.BOUND_SHAPE)) {
                sb.append("&location=").append(C1233d.m17035a(((C1255s) this.f4183a).f4189b.getCenter().getLongitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + C1233d.m17035a(((C1255s) this.f4183a).f4189b.getCenter().getLatitude()));
                sb.append("&radius=").append(((C1255s) this.f4183a).f4189b.getRange());
                sb.append("&sortrule=").append(m16803n());
            } else if (((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.RECTANGLE_SHAPE)) {
                LatLonPoint lowerLeft = ((C1255s) this.f4183a).f4189b.getLowerLeft();
                LatLonPoint upperRight = ((C1255s) this.f4183a).f4189b.getUpperRight();
                sb.append("&polygon=" + C1233d.m17035a(lowerLeft.getLongitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + C1233d.m17035a(lowerLeft.getLatitude()) + ";" + C1233d.m17035a(upperRight.getLongitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + C1233d.m17035a(upperRight.getLatitude()));
            } else if (((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.POLYGON_SHAPE) && (polyGonList = ((C1255s) this.f4183a).f4189b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + C1233d.m17029a(polyGonList));
            }
        }
        String city = ((C1255s) this.f4183a).f4188a.getCity();
        if (!a(city)) {
            sb.append("&city=").append(c(city));
        }
        if (!C1233d.m17032a(m16802o())) {
            sb.append(m16802o());
        }
        sb.append("&keywords=" + c(((C1255s) this.f4183a).f4188a.getQueryString()));
        sb.append("&language=").append(C1232c.m17036b());
        sb.append("&offset=" + this.f4413i);
        sb.append("&page=" + this.f4412h);
        sb.append("&types=" + c(((C1255s) this.f4183a).f4188a.getCategory()));
        sb.append("&extensions=all");
        sb.append("&key=" + C1259w.m16920f(this.f4186d));
        return sb.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        String str = C1232c.m17038a() + "/place";
        return ((C1255s) this.f4183a).f4189b == null ? str + "/text?" : ((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.BOUND_SHAPE) ? str + "/around?" : (((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.RECTANGLE_SHAPE) || ((C1255s) this.f4183a).f4189b.getShape().equals(PoiSearch.SearchBound.POLYGON_SHAPE)) ? str + "/polygon?" : str;
    }

    /* renamed from: b */
    public void m16812b(int i) {
        int i2 = 30;
        int i3 = i > 30 ? 30 : i;
        if (i3 > 0) {
            i2 = i3;
        }
        this.f4413i = i2;
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: e */
    public ArrayList<PoiItem> mo16811b(String str) {
        JSONObject optJSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f4414j = jSONObject.optInt("count");
                arrayList = C1239j.m16998c(jSONObject);
                if (jSONObject.has("suggestion") && (optJSONObject = jSONObject.optJSONObject("suggestion")) != null) {
                    this.f4416l = C1239j.m17010a(optJSONObject);
                    this.f4415k = C1239j.m17003b(optJSONObject);
                }
            } catch (JSONException e) {
                C1233d.m17031a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            } catch (Exception e2) {
                C1233d.m17031a(e2, "PoiSearchKeywordHandler", "paseJSONException");
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public int m16809f() {
        return this.f4413i;
    }

    /* renamed from: i */
    public int m16808i() {
        return this.f4414j;
    }

    /* renamed from: j */
    public PoiSearch.Query m16807j() {
        return ((C1255s) this.f4183a).f4188a;
    }

    /* renamed from: k */
    public PoiSearch.SearchBound m16806k() {
        return ((C1255s) this.f4183a).f4189b;
    }

    /* renamed from: l */
    public List<String> m16805l() {
        return this.f4415k;
    }

    /* renamed from: m */
    public List<SuggestionCity> m16804m() {
        return this.f4416l;
    }
}
