package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
/* renamed from: com.amap.api.services.core.u */
/* loaded from: classes.dex */
public class C1257u extends AbstractC1254r<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public C1257u(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public WalkRouteResult mo16811b(String str) {
        return C1239j.m16995d(str);
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C1259w.m16920f(this.f4186d));
        stringBuffer.append("&origin=").append(C1233d.m17033a(((RouteSearch.WalkRouteQuery) this.f4183a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C1233d.m17033a(((RouteSearch.WalkRouteQuery) this.f4183a).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/direction/walking?";
    }
}
