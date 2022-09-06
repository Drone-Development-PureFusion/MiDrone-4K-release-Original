package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusStationQuery;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.amap.api.services.core.b */
/* loaded from: classes.dex */
public class C1194b<T> extends AbstractC1254r<T, ArrayList<?>> {

    /* renamed from: h */
    private int f4061h = 0;

    /* renamed from: i */
    private List<String> f4062i = new ArrayList();

    /* renamed from: j */
    private List<SuggestionCity> f4063j = new ArrayList();

    public C1194b(Context context, T t) {
        super(context, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public ArrayList<?> mo16811b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f4063j = C1239j.m17010a(optJSONObject);
                this.f4062i = C1239j.m17003b(optJSONObject);
            }
            this.f4061h = jSONObject.optInt("count");
            return this.f4183a instanceof BusLineQuery ? C1239j.m16982i(jSONObject) : C1239j.m16990e(jSONObject);
        } catch (Exception e) {
            C1233d.m17031a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (this.f4183a instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.f4183a;
            sb.append("&extensions=all");
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=").append(c(((BusLineQuery) this.f4183a).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!C1239j.m16985h(city)) {
                    sb.append("&city=").append(c(city));
                }
                sb.append("&keywords=" + c(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + (busLineQuery.getPageNumber() + 1));
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.f4183a;
            String city2 = busStationQuery.getCity();
            if (!C1239j.m16985h(city2)) {
                sb.append("&city=").append(c(city2));
            }
            sb.append("&keywords=" + c(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + (busStationQuery.getPageNumber() + 1));
        }
        sb.append("&key=" + C1259w.m16920f(this.f4186d));
        return sb.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/bus/" + (this.f4183a instanceof BusLineQuery ? ((BusLineQuery) this.f4183a).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.f4183a).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + C0228a.f351a;
    }

    /* renamed from: b_ */
    public List<String> m17172b_() {
        return this.f4062i;
    }

    /* renamed from: c */
    public T m17171c() {
        return this.f4183a;
    }

    /* renamed from: d */
    public int m17170d() {
        return this.f4061h;
    }

    /* renamed from: f */
    public List<SuggestionCity> m17169f() {
        return this.f4063j;
    }
}
