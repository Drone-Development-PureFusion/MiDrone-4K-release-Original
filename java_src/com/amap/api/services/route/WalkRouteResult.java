package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new C1314t();

    /* renamed from: a */
    private List<WalkPath> f4505a;

    /* renamed from: b */
    private RouteSearch.WalkRouteQuery f4506b;

    public WalkRouteResult() {
        this.f4505a = new ArrayList();
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f4505a = new ArrayList();
        this.f4505a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f4506b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f4505a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f4506b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f4505a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f4506b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f4505a);
        parcel.writeParcelable(this.f4506b, i);
    }
}
