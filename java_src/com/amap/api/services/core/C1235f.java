package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.core.f */
/* loaded from: classes.dex */
public class C1235f extends AbstractC1254r<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public C1235f(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public DriveRouteResult mo16811b(String str) {
        return C1239j.m16999c(str);
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C1259w.m16920f(this.f4186d));
        stringBuffer.append("&origin=").append(C1233d.m17033a(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getFrom()));
        if (!C1239j.m16985h(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getStartPoiID())) {
            stringBuffer.append("&originid=").append(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getStartPoiID());
        }
        stringBuffer.append("&destination=").append(C1233d.m17033a(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getTo()));
        if (!C1239j.m16985h(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getDestinationPoiID())) {
            stringBuffer.append("&destinationid=").append(((RouteSearch.DriveRouteQuery) this.f4183a).getFromAndTo().getDestinationPoiID());
        }
        stringBuffer.append("&strategy=").append("" + ((RouteSearch.DriveRouteQuery) this.f4183a).getMode());
        stringBuffer.append("&extensions=all");
        if (((RouteSearch.DriveRouteQuery) this.f4183a).hasPassPoint()) {
            stringBuffer.append("&waypoints=").append(((RouteSearch.DriveRouteQuery) this.f4183a).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f4183a).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=").append(((RouteSearch.DriveRouteQuery) this.f4183a).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f4183a).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=").append(c(((RouteSearch.DriveRouteQuery) this.f4183a).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/direction/driving?";
    }
}
