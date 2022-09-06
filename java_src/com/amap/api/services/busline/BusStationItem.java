package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new C1161b();

    /* renamed from: a */
    private String f3923a;

    /* renamed from: b */
    private String f3924b;

    /* renamed from: c */
    private LatLonPoint f3925c;

    /* renamed from: d */
    private String f3926d;

    /* renamed from: e */
    private String f3927e;

    /* renamed from: f */
    private List<BusLineItem> f3928f;

    public BusStationItem() {
        this.f3928f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f3928f = new ArrayList();
        this.f3924b = parcel.readString();
        this.f3923a = parcel.readString();
        this.f3925c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f3926d = parcel.readString();
        this.f3927e = parcel.readString();
        this.f3928f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BusStationItem(Parcel parcel, C1161b c1161b) {
        this(parcel);
    }

    /* renamed from: a */
    private String m17300a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                stringBuffer.append(list.get(i2).getBusLineName());
                if (i2 < list.size() - 1) {
                    stringBuffer.append("|");
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationItem busStationItem = (BusStationItem) obj;
            return this.f3923a == null ? busStationItem.f3923a == null : this.f3923a.equals(busStationItem.f3923a);
        }
        return false;
    }

    public String getAdCode() {
        return this.f3927e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f3928f;
    }

    public String getBusStationId() {
        return this.f3923a;
    }

    public String getBusStationName() {
        return this.f3924b;
    }

    public String getCityCode() {
        return this.f3926d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f3925c;
    }

    public int hashCode() {
        return (this.f3923a == null ? 0 : this.f3923a.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f3927e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f3928f = list;
    }

    public void setBusStationId(String str) {
        this.f3923a = str;
    }

    public void setBusStationName(String str) {
        this.f3924b = str;
    }

    public void setCityCode(String str) {
        this.f3926d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f3925c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.f3924b + " LatLonPoint: " + this.f3925c.toString() + " BusLines: " + m17300a(this.f3928f) + " CityCode: " + this.f3926d + " AdCode: " + this.f3927e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3924b);
        parcel.writeString(this.f3923a);
        parcel.writeValue(this.f3925c);
        parcel.writeString(this.f3926d);
        parcel.writeString(this.f3927e);
        parcel.writeList(this.f3928f);
    }
}
