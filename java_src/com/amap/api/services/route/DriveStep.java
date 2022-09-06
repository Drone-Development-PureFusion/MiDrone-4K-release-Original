package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new C1302h();

    /* renamed from: a */
    private String f4452a;

    /* renamed from: b */
    private String f4453b;

    /* renamed from: c */
    private String f4454c;

    /* renamed from: d */
    private float f4455d;

    /* renamed from: e */
    private float f4456e;

    /* renamed from: f */
    private float f4457f;

    /* renamed from: g */
    private String f4458g;

    /* renamed from: h */
    private float f4459h;

    /* renamed from: i */
    private List<LatLonPoint> f4460i;

    /* renamed from: j */
    private String f4461j;

    /* renamed from: k */
    private String f4462k;

    /* renamed from: l */
    private List<RouteSearchCity> f4463l;

    public DriveStep() {
        this.f4460i = new ArrayList();
        this.f4463l = new ArrayList();
    }

    public DriveStep(Parcel parcel) {
        this.f4460i = new ArrayList();
        this.f4463l = new ArrayList();
        this.f4452a = parcel.readString();
        this.f4453b = parcel.readString();
        this.f4454c = parcel.readString();
        this.f4455d = parcel.readFloat();
        this.f4456e = parcel.readFloat();
        this.f4457f = parcel.readFloat();
        this.f4458g = parcel.readString();
        this.f4459h = parcel.readFloat();
        this.f4460i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f4461j = parcel.readString();
        this.f4462k = parcel.readString();
        this.f4463l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f4461j;
    }

    public String getAssistantAction() {
        return this.f4462k;
    }

    public float getDistance() {
        return this.f4455d;
    }

    public float getDuration() {
        return this.f4459h;
    }

    public String getInstruction() {
        return this.f4452a;
    }

    public String getOrientation() {
        return this.f4453b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f4460i;
    }

    public String getRoad() {
        return this.f4454c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f4463l;
    }

    public float getTollDistance() {
        return this.f4457f;
    }

    public String getTollRoad() {
        return this.f4458g;
    }

    public float getTolls() {
        return this.f4456e;
    }

    public void setAction(String str) {
        this.f4461j = str;
    }

    public void setAssistantAction(String str) {
        this.f4462k = str;
    }

    public void setDistance(float f) {
        this.f4455d = f;
    }

    public void setDuration(float f) {
        this.f4459h = f;
    }

    public void setInstruction(String str) {
        this.f4452a = str;
    }

    public void setOrientation(String str) {
        this.f4453b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f4460i = list;
    }

    public void setRoad(String str) {
        this.f4454c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f4463l = list;
    }

    public void setTollDistance(float f) {
        this.f4457f = f;
    }

    public void setTollRoad(String str) {
        this.f4458g = str;
    }

    public void setTolls(float f) {
        this.f4456e = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4452a);
        parcel.writeString(this.f4453b);
        parcel.writeString(this.f4454c);
        parcel.writeFloat(this.f4455d);
        parcel.writeFloat(this.f4456e);
        parcel.writeFloat(this.f4457f);
        parcel.writeString(this.f4458g);
        parcel.writeFloat(this.f4459h);
        parcel.writeTypedList(this.f4460i);
        parcel.writeString(this.f4461j);
        parcel.writeString(this.f4462k);
        parcel.writeTypedList(this.f4463l);
    }
}
