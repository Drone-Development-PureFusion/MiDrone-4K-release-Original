package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.core.a */
/* loaded from: classes.dex */
public class C1162a extends AbstractC1254r<RouteSearch.BusRouteQuery, BusRouteResult> {
    public C1162a(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public BusRouteResult mo16811b(String str) {
        return C1239j.m17005b(str);
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C1259w.m16920f(this.f4186d));
        stringBuffer.append("&origin=").append(C1233d.m17033a(((RouteSearch.BusRouteQuery) this.f4183a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C1233d.m17033a(((RouteSearch.BusRouteQuery) this.f4183a).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f4183a).getCity();
        if (!C1239j.m16985h(city)) {
            stringBuffer.append("&city=").append(c(city));
        }
        stringBuffer.append("&strategy=").append("" + ((RouteSearch.BusRouteQuery) this.f4183a).getMode());
        stringBuffer.append("&nightflag=").append(((RouteSearch.BusRouteQuery) this.f4183a).getNightFlag());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/direction/transit/integrated?";
    }
}
