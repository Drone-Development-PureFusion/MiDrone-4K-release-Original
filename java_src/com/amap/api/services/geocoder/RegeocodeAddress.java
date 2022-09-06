package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new C1272c();

    /* renamed from: a */
    private String f4256a;

    /* renamed from: b */
    private String f4257b;

    /* renamed from: c */
    private String f4258c;

    /* renamed from: d */
    private String f4259d;

    /* renamed from: e */
    private String f4260e;

    /* renamed from: f */
    private String f4261f;

    /* renamed from: g */
    private String f4262g;

    /* renamed from: h */
    private StreetNumber f4263h;

    /* renamed from: i */
    private String f4264i;

    /* renamed from: j */
    private String f4265j;

    /* renamed from: k */
    private List<RegeocodeRoad> f4266k;

    /* renamed from: l */
    private List<Crossroad> f4267l;

    /* renamed from: m */
    private List<PoiItem> f4268m;

    /* renamed from: n */
    private List<BusinessArea> f4269n;

    public RegeocodeAddress() {
        this.f4266k = new ArrayList();
        this.f4267l = new ArrayList();
        this.f4268m = new ArrayList();
        this.f4269n = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f4266k = new ArrayList();
        this.f4267l = new ArrayList();
        this.f4268m = new ArrayList();
        this.f4269n = new ArrayList();
        this.f4256a = parcel.readString();
        this.f4257b = parcel.readString();
        this.f4258c = parcel.readString();
        this.f4259d = parcel.readString();
        this.f4260e = parcel.readString();
        this.f4261f = parcel.readString();
        this.f4262g = parcel.readString();
        this.f4263h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f4266k = parcel.readArrayList(Road.class.getClassLoader());
        this.f4267l = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f4268m = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f4264i = parcel.readString();
        this.f4265j = parcel.readString();
        this.f4269n = parcel.readArrayList(BusinessArea.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RegeocodeAddress(Parcel parcel, C1272c c1272c) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f4265j;
    }

    public String getBuilding() {
        return this.f4262g;
    }

    public List<BusinessArea> getBusinessAreas() {
        return this.f4269n;
    }

    public String getCity() {
        return this.f4258c;
    }

    public String getCityCode() {
        return this.f4264i;
    }

    public List<Crossroad> getCrossroads() {
        return this.f4267l;
    }

    public String getDistrict() {
        return this.f4259d;
    }

    public String getFormatAddress() {
        return this.f4256a;
    }

    public String getNeighborhood() {
        return this.f4261f;
    }

    public List<PoiItem> getPois() {
        return this.f4268m;
    }

    public String getProvince() {
        return this.f4257b;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.f4266k;
    }

    public StreetNumber getStreetNumber() {
        return this.f4263h;
    }

    public String getTownship() {
        return this.f4260e;
    }

    public void setAdCode(String str) {
        this.f4265j = str;
    }

    public void setBuilding(String str) {
        this.f4262g = str;
    }

    public void setBusinessAreas(List<BusinessArea> list) {
        this.f4269n = list;
    }

    public void setCity(String str) {
        this.f4258c = str;
    }

    public void setCityCode(String str) {
        this.f4264i = str;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.f4267l = list;
    }

    public void setDistrict(String str) {
        this.f4259d = str;
    }

    public void setFormatAddress(String str) {
        this.f4256a = str;
    }

    public void setNeighborhood(String str) {
        this.f4261f = str;
    }

    public void setPois(List<PoiItem> list) {
        this.f4268m = list;
    }

    public void setProvince(String str) {
        this.f4257b = str;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.f4266k = list;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.f4263h = streetNumber;
    }

    public void setTownship(String str) {
        this.f4260e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4256a);
        parcel.writeString(this.f4257b);
        parcel.writeString(this.f4258c);
        parcel.writeString(this.f4259d);
        parcel.writeString(this.f4260e);
        parcel.writeString(this.f4261f);
        parcel.writeString(this.f4262g);
        parcel.writeValue(this.f4263h);
        parcel.writeList(this.f4266k);
        parcel.writeList(this.f4267l);
        parcel.writeList(this.f4268m);
        parcel.writeString(this.f4264i);
        parcel.writeString(this.f4265j);
        parcel.writeList(this.f4269n);
    }
}
