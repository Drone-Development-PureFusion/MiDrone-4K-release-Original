package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new C1297c();

    /* renamed from: a */
    private RouteBusWalkItem f4437a;

    /* renamed from: b */
    private List<RouteBusLineItem> f4438b;

    /* renamed from: c */
    private Doorway f4439c;

    /* renamed from: d */
    private Doorway f4440d;

    public BusStep() {
        this.f4438b = new ArrayList();
    }

    public BusStep(Parcel parcel) {
        this.f4438b = new ArrayList();
        this.f4437a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f4438b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f4439c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f4440d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteBusLineItem getBusLine() {
        if (this.f4438b == null || this.f4438b.size() == 0) {
            return null;
        }
        return this.f4438b.get(0);
    }

    public Doorway getEntrance() {
        return this.f4439c;
    }

    public Doorway getExit() {
        return this.f4440d;
    }

    public RouteBusWalkItem getWalk() {
        return this.f4437a;
    }

    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        if (this.f4438b == null) {
            return;
        }
        if (this.f4438b.size() == 0) {
            this.f4438b.add(routeBusLineItem);
        }
        this.f4438b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f4438b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f4439c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f4440d = doorway;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f4437a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4437a, i);
        parcel.writeTypedList(this.f4438b);
        parcel.writeParcelable(this.f4439c, i);
        parcel.writeParcelable(this.f4440d, i);
    }
}
