package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new C1301g();

    /* renamed from: a */
    private float f4449a;

    /* renamed from: b */
    private List<DrivePath> f4450b;

    /* renamed from: c */
    private RouteSearch.DriveRouteQuery f4451c;

    public DriveRouteResult() {
        this.f4450b = new ArrayList();
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f4450b = new ArrayList();
        this.f4449a = parcel.readFloat();
        this.f4450b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f4451c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f4451c;
    }

    public List<DrivePath> getPaths() {
        return this.f4450b;
    }

    public float getTaxiCost() {
        return this.f4449a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f4451c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f4450b = list;
    }

    public void setTaxiCost(float f) {
        this.f4449a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4449a);
        parcel.writeTypedList(this.f4450b);
        parcel.writeParcelable(this.f4451c, i);
    }
}
