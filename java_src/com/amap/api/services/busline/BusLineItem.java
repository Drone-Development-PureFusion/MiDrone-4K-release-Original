package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.LatLonPoint;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new C1160a();

    /* renamed from: a */
    private float f3889a;

    /* renamed from: b */
    private String f3890b;

    /* renamed from: c */
    private String f3891c;

    /* renamed from: d */
    private String f3892d;

    /* renamed from: e */
    private List<LatLonPoint> f3893e;

    /* renamed from: f */
    private List<LatLonPoint> f3894f;

    /* renamed from: g */
    private String f3895g;

    /* renamed from: h */
    private String f3896h;

    /* renamed from: i */
    private String f3897i;

    /* renamed from: j */
    private Date f3898j;

    /* renamed from: k */
    private Date f3899k;

    /* renamed from: l */
    private String f3900l;

    /* renamed from: m */
    private float f3901m;

    /* renamed from: n */
    private float f3902n;

    /* renamed from: o */
    private List<BusStationItem> f3903o;

    public BusLineItem() {
        this.f3893e = new ArrayList();
        this.f3894f = new ArrayList();
        this.f3903o = new ArrayList();
    }

    public BusLineItem(Parcel parcel) {
        this.f3893e = new ArrayList();
        this.f3894f = new ArrayList();
        this.f3903o = new ArrayList();
        this.f3889a = parcel.readFloat();
        this.f3890b = parcel.readString();
        this.f3891c = parcel.readString();
        this.f3892d = parcel.readString();
        this.f3893e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f3894f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f3895g = parcel.readString();
        this.f3896h = parcel.readString();
        this.f3897i = parcel.readString();
        this.f3898j = C1233d.m17025e(parcel.readString());
        this.f3899k = C1233d.m17025e(parcel.readString());
        this.f3900l = parcel.readString();
        this.f3901m = parcel.readFloat();
        this.f3902n = parcel.readFloat();
        this.f3903o = parcel.readArrayList(BusStationItem.class.getClassLoader());
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
            BusLineItem busLineItem = (BusLineItem) obj;
            return this.f3895g == null ? busLineItem.f3895g == null : this.f3895g.equals(busLineItem.f3895g);
        }
        return false;
    }

    public float getBasicPrice() {
        return this.f3901m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f3894f;
    }

    public String getBusCompany() {
        return this.f3900l;
    }

    public String getBusLineId() {
        return this.f3895g;
    }

    public String getBusLineName() {
        return this.f3890b;
    }

    public String getBusLineType() {
        return this.f3891c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f3903o;
    }

    public String getCityCode() {
        return this.f3892d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f3893e;
    }

    public float getDistance() {
        return this.f3889a;
    }

    public Date getFirstBusTime() {
        if (this.f3898j == null) {
            return null;
        }
        return (Date) this.f3898j.clone();
    }

    public Date getLastBusTime() {
        if (this.f3899k == null) {
            return null;
        }
        return (Date) this.f3899k.clone();
    }

    public String getOriginatingStation() {
        return this.f3896h;
    }

    public String getTerminalStation() {
        return this.f3897i;
    }

    public float getTotalPrice() {
        return this.f3902n;
    }

    public int hashCode() {
        return (this.f3895g == null ? 0 : this.f3895g.hashCode()) + 31;
    }

    public void setBasicPrice(float f) {
        this.f3901m = f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f3894f = list;
    }

    public void setBusCompany(String str) {
        this.f3900l = str;
    }

    public void setBusLineId(String str) {
        this.f3895g = str;
    }

    public void setBusLineName(String str) {
        this.f3890b = str;
    }

    public void setBusLineType(String str) {
        this.f3891c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f3903o = list;
    }

    public void setCityCode(String str) {
        this.f3892d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f3893e = list;
    }

    public void setDistance(float f) {
        this.f3889a = f;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f3898j = null;
        } else {
            this.f3898j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f3899k = null;
        } else {
            this.f3899k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f3896h = str;
    }

    public void setTerminalStation(String str) {
        this.f3897i = str;
    }

    public void setTotalPrice(float f) {
        this.f3902n = f;
    }

    public String toString() {
        return this.f3890b + " " + C1233d.m17030a(this.f3898j) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + C1233d.m17030a(this.f3899k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f3889a);
        parcel.writeString(this.f3890b);
        parcel.writeString(this.f3891c);
        parcel.writeString(this.f3892d);
        parcel.writeList(this.f3893e);
        parcel.writeList(this.f3894f);
        parcel.writeString(this.f3895g);
        parcel.writeString(this.f3896h);
        parcel.writeString(this.f3897i);
        parcel.writeString(C1233d.m17030a(this.f3898j));
        parcel.writeString(C1233d.m17030a(this.f3899k));
        parcel.writeString(this.f3900l);
        parcel.writeFloat(this.f3901m);
        parcel.writeFloat(this.f3902n);
        parcel.writeList(this.f3903o);
    }
}
