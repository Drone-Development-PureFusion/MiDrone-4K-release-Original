package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new C1304j();

    /* renamed from: a */
    private BusStationItem f4466a;

    /* renamed from: b */
    private BusStationItem f4467b;

    /* renamed from: c */
    private List<LatLonPoint> f4468c;

    /* renamed from: d */
    private int f4469d;

    /* renamed from: e */
    private List<BusStationItem> f4470e;

    /* renamed from: f */
    private float f4471f;

    public RouteBusLineItem() {
        this.f4468c = new ArrayList();
        this.f4470e = new ArrayList();
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f4468c = new ArrayList();
        this.f4470e = new ArrayList();
        this.f4466a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f4467b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f4468c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f4469d = parcel.readInt();
        this.f4470e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f4471f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
            if (this.f4467b == null) {
                if (routeBusLineItem.f4467b != null) {
                    return false;
                }
            } else if (!this.f4467b.equals(routeBusLineItem.f4467b)) {
                return false;
            }
            return this.f4466a == null ? routeBusLineItem.f4466a == null : this.f4466a.equals(routeBusLineItem.f4466a);
        }
        return false;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f4467b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f4466a;
    }

    public float getDuration() {
        return this.f4471f;
    }

    public int getPassStationNum() {
        return this.f4469d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f4470e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f4468c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4467b == null ? 0 : this.f4467b.hashCode()) + (super.hashCode() * 31)) * 31;
        if (this.f4466a != null) {
            i = this.f4466a.hashCode();
        }
        return hashCode + i;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f4467b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f4466a = busStationItem;
    }

    public void setDuration(float f) {
        this.f4471f = f;
    }

    public void setPassStationNum(int i) {
        this.f4469d = i;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f4470e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f4468c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4466a, i);
        parcel.writeParcelable(this.f4467b, i);
        parcel.writeTypedList(this.f4468c);
        parcel.writeInt(this.f4469d);
        parcel.writeTypedList(this.f4470e);
        parcel.writeFloat(this.f4471f);
    }
}
