package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new C1265a();

    /* renamed from: a */
    private String f4207a;

    /* renamed from: b */
    private String f4208b;

    /* renamed from: c */
    private String f4209c;

    /* renamed from: d */
    private LatLonPoint f4210d;

    /* renamed from: e */
    private String f4211e;

    /* renamed from: f */
    private List<DistrictItem> f4212f;

    /* renamed from: g */
    private String[] f4213g;

    public DistrictItem() {
        this.f4212f = new ArrayList();
        this.f4213g = new String[0];
    }

    public DistrictItem(Parcel parcel) {
        this.f4212f = new ArrayList();
        this.f4213g = new String[0];
        this.f4207a = parcel.readString();
        this.f4208b = parcel.readString();
        this.f4209c = parcel.readString();
        this.f4210d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f4211e = parcel.readString();
        this.f4212f = parcel.createTypedArrayList(CREATOR);
        this.f4213g = new String[parcel.readInt()];
        parcel.readStringArray(this.f4213g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f4212f = new ArrayList();
        this.f4213g = new String[0];
        this.f4209c = str;
        this.f4207a = str2;
        this.f4208b = str3;
        this.f4210d = latLonPoint;
        this.f4211e = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] districtBoundary() {
        return this.f4213g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DistrictItem districtItem = (DistrictItem) obj;
            if (this.f4208b == null) {
                if (districtItem.f4208b != null) {
                    return false;
                }
            } else if (!this.f4208b.equals(districtItem.f4208b)) {
                return false;
            }
            if (this.f4210d == null) {
                if (districtItem.f4210d != null) {
                    return false;
                }
            } else if (!this.f4210d.equals(districtItem.f4210d)) {
                return false;
            }
            if (this.f4207a == null) {
                if (districtItem.f4207a != null) {
                    return false;
                }
            } else if (!this.f4207a.equals(districtItem.f4207a)) {
                return false;
            }
            if (!Arrays.equals(this.f4213g, districtItem.f4213g)) {
                return false;
            }
            if (this.f4212f == null) {
                if (districtItem.f4212f != null) {
                    return false;
                }
            } else if (!this.f4212f.equals(districtItem.f4212f)) {
                return false;
            }
            if (this.f4211e == null) {
                if (districtItem.f4211e != null) {
                    return false;
                }
            } else if (!this.f4211e.equals(districtItem.f4211e)) {
                return false;
            }
            return this.f4209c == null ? districtItem.f4209c == null : this.f4209c.equals(districtItem.f4209c);
        }
        return false;
    }

    public String getAdcode() {
        return this.f4208b;
    }

    public LatLonPoint getCenter() {
        return this.f4210d;
    }

    public String getCitycode() {
        return this.f4207a;
    }

    public String getLevel() {
        return this.f4211e;
    }

    public String getName() {
        return this.f4209c;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f4212f;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4211e == null ? 0 : this.f4211e.hashCode()) + (((this.f4212f == null ? 0 : this.f4212f.hashCode()) + (((((this.f4207a == null ? 0 : this.f4207a.hashCode()) + (((this.f4210d == null ? 0 : this.f4210d.hashCode()) + (((this.f4208b == null ? 0 : this.f4208b.hashCode()) + 31) * 31)) * 31)) * 31) + Arrays.hashCode(this.f4213g)) * 31)) * 31)) * 31;
        if (this.f4209c != null) {
            i = this.f4209c.hashCode();
        }
        return hashCode + i;
    }

    public void setAdcode(String str) {
        this.f4208b = str;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.f4210d = latLonPoint;
    }

    public void setCitycode(String str) {
        this.f4207a = str;
    }

    public void setDistrictBoundary(String[] strArr) {
        this.f4213g = strArr;
    }

    public void setLevel(String str) {
        this.f4211e = str;
    }

    public void setName(String str) {
        this.f4209c = str;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f4212f = arrayList;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f4207a + ", mAdcode=" + this.f4208b + ", mName=" + this.f4209c + ", mCenter=" + this.f4210d + ", mLevel=" + this.f4211e + ", mDistricts=" + this.f4212f + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4207a);
        parcel.writeString(this.f4208b);
        parcel.writeString(this.f4209c);
        parcel.writeParcelable(this.f4210d, i);
        parcel.writeString(this.f4211e);
        parcel.writeTypedList(this.f4212f);
        parcel.writeInt(this.f4213g.length);
        parcel.writeStringArray(this.f4213g);
    }
}
