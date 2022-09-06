package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new C1253q();

    /* renamed from: a */
    private String f3950a;

    /* renamed from: b */
    private String f3951b;

    /* renamed from: c */
    private String f3952c;

    /* renamed from: d */
    private String f3953d;

    /* renamed from: e */
    private String f3954e;

    /* renamed from: f */
    private int f3955f;

    /* renamed from: g */
    private LatLonPoint f3956g;

    /* renamed from: h */
    private LatLonPoint f3957h;

    /* renamed from: i */
    private String f3958i;

    /* renamed from: j */
    private String f3959j;

    /* renamed from: k */
    private String f3960k;

    /* renamed from: l */
    private boolean f3961l;

    /* renamed from: m */
    private boolean f3962m;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    /* renamed from: n */
    private String f3963n;

    /* renamed from: o */
    private String f3964o;

    /* renamed from: p */
    private String f3965p;

    /* renamed from: q */
    private String f3966q;

    /* renamed from: r */
    private boolean f3967r;

    /* renamed from: s */
    private String f3968s;

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiItem(Parcel parcel) {
        this.f3954e = "";
        this.f3955f = -1;
        this.f3950a = parcel.readString();
        this.f3952c = parcel.readString();
        this.f3951b = parcel.readString();
        this.f3954e = parcel.readString();
        this.f3955f = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f3953d = parcel.readString();
        this.f3956g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f3957h = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f3958i = parcel.readString();
        this.f3959j = parcel.readString();
        this.f3960k = parcel.readString();
        boolean[] zArr = new boolean[3];
        parcel.readBooleanArray(zArr);
        this.f3961l = zArr[0];
        this.f3962m = zArr[1];
        this.f3967r = zArr[2];
        this.f3963n = parcel.readString();
        this.f3964o = parcel.readString();
        this.f3965p = parcel.readString();
        this.f3966q = parcel.readString();
        this.f3968s = parcel.readString();
    }

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f3954e = "";
        this.f3955f = -1;
        this.f3950a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
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
            PoiItem poiItem = (PoiItem) obj;
            return this.f3950a == null ? poiItem.f3950a == null : this.f3950a.equals(poiItem.f3950a);
        }
        return false;
    }

    public String getAdCode() {
        return this.f3952c;
    }

    public String getAdName() {
        return this.f3966q;
    }

    public String getCityCode() {
        return this.f3953d;
    }

    public String getCityName() {
        return this.f3965p;
    }

    public String getDirection() {
        return this.f3963n;
    }

    public int getDistance() {
        return this.f3955f;
    }

    public String getEmail() {
        return this.f3960k;
    }

    public LatLonPoint getEnter() {
        return this.f3956g;
    }

    public LatLonPoint getExit() {
        return this.f3957h;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getPoiId() {
        return this.f3950a;
    }

    public String getPostcode() {
        return this.f3959j;
    }

    public String getProvinceCode() {
        return this.f3968s;
    }

    public String getProvinceName() {
        return this.f3964o;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTel() {
        return this.f3951b;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTypeDes() {
        return this.f3954e;
    }

    public String getWebsite() {
        return this.f3958i;
    }

    public int hashCode() {
        return (this.f3950a == null ? 0 : this.f3950a.hashCode()) + 31;
    }

    public boolean isDiscountInfo() {
        return this.f3962m;
    }

    public boolean isGroupbuyInfo() {
        return this.f3961l;
    }

    public boolean isIndoorMap() {
        return this.f3967r;
    }

    public void setAdCode(String str) {
        this.f3952c = str;
    }

    public void setAdName(String str) {
        this.f3966q = str;
    }

    public void setCityCode(String str) {
        this.f3953d = str;
    }

    public void setCityName(String str) {
        this.f3965p = str;
    }

    public void setDirection(String str) {
        this.f3963n = str;
    }

    public void setDiscountInfo(boolean z) {
        this.f3962m = z;
    }

    public void setDistance(int i) {
        this.f3955f = i;
    }

    public void setEmail(String str) {
        this.f3960k = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f3956g = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f3957h = latLonPoint;
    }

    public void setGroupbuyInfo(boolean z) {
        this.f3961l = z;
    }

    public void setIndoorMap(boolean z) {
        this.f3967r = z;
    }

    public void setPostcode(String str) {
        this.f3959j = str;
    }

    public void setProvinceCode(String str) {
        this.f3968s = str;
    }

    public void setProvinceName(String str) {
        this.f3964o = str;
    }

    public void setTel(String str) {
        this.f3951b = str;
    }

    public void setTypeDes(String str) {
        this.f3954e = str;
    }

    public void setWebsite(String str) {
        this.f3958i = str;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3950a);
        parcel.writeString(this.f3952c);
        parcel.writeString(this.f3951b);
        parcel.writeString(this.f3954e);
        parcel.writeInt(this.f3955f);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f3953d);
        parcel.writeValue(this.f3956g);
        parcel.writeValue(this.f3957h);
        parcel.writeString(this.f3958i);
        parcel.writeString(this.f3959j);
        parcel.writeString(this.f3960k);
        parcel.writeBooleanArray(new boolean[]{this.f3961l, this.f3962m, this.f3967r});
        parcel.writeString(this.f3963n);
        parcel.writeString(this.f3964o);
        parcel.writeString(this.f3965p);
        parcel.writeString(this.f3966q);
        parcel.writeString(this.f3968s);
    }
}
