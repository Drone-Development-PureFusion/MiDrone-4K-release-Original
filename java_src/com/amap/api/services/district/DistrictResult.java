package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a */
    private DistrictSearchQuery f4214a;

    /* renamed from: b */
    private ArrayList<DistrictItem> f4215b;

    /* renamed from: c */
    private int f4216c;

    /* renamed from: d */
    private AMapException f4217d;

    public DistrictResult() {
        this.f4215b = new ArrayList<>();
        this.CREATOR = new C1266b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DistrictResult(Parcel parcel) {
        this.f4215b = new ArrayList<>();
        this.CREATOR = new C1266b(this);
        this.f4214a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f4215b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f4215b = new ArrayList<>();
        this.CREATOR = new C1266b(this);
        this.f4214a = districtSearchQuery;
        this.f4215b = arrayList;
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
            DistrictResult districtResult = (DistrictResult) obj;
            if (this.f4214a == null) {
                if (districtResult.f4214a != null) {
                    return false;
                }
            } else if (!this.f4214a.equals(districtResult.f4214a)) {
                return false;
            }
            return this.f4215b == null ? districtResult.f4215b == null : this.f4215b.equals(districtResult.f4215b);
        }
        return false;
    }

    public AMapException getAMapException() {
        return this.f4217d;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.f4215b;
    }

    public int getPageCount() {
        return this.f4216c;
    }

    public DistrictSearchQuery getQuery() {
        return this.f4214a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4214a == null ? 0 : this.f4214a.hashCode()) + 31) * 31;
        if (this.f4215b != null) {
            i = this.f4215b.hashCode();
        }
        return hashCode + i;
    }

    public void setAMapException(AMapException aMapException) {
        this.f4217d = aMapException;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f4215b = arrayList;
    }

    public void setPageCount(int i) {
        this.f4216c = i;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f4214a = districtSearchQuery;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f4214a + ", mDistricts=" + this.f4215b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4214a, i);
        parcel.writeTypedList(this.f4215b);
    }
}
