package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.C1233d;
/* loaded from: classes.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new C1267c();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a */
    private int f4226a;

    /* renamed from: b */
    private int f4227b;

    /* renamed from: c */
    private String f4228c;

    /* renamed from: d */
    private String f4229d;

    /* renamed from: e */
    private boolean f4230e;

    /* renamed from: f */
    private boolean f4231f;

    public DistrictSearchQuery() {
        this.f4226a = 0;
        this.f4227b = 20;
        this.f4230e = true;
        this.f4231f = false;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f4226a = 0;
        this.f4227b = 20;
        this.f4230e = true;
        this.f4231f = false;
        this.f4228c = str;
        this.f4229d = str2;
        this.f4226a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.f4230e = z;
        this.f4227b = i2;
    }

    public boolean checkKeyWords() {
        return this.f4228c != null && !this.f4228c.trim().equalsIgnoreCase("");
    }

    public boolean checkLevels() {
        if (this.f4229d == null) {
            return false;
        }
        return this.f4229d.trim().equals(KEYWORDS_COUNTRY) || this.f4229d.trim().equals(KEYWORDS_PROVINCE) || this.f4229d.trim().equals(KEYWORDS_CITY) || this.f4229d.trim().equals(KEYWORDS_DISTRICT) || this.f4229d.trim().equals(KEYWORDS_BUSINESS);
    }

    /* renamed from: clone */
    public DistrictSearchQuery m21742clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            C1233d.m17031a(e, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery(this.f4228c, this.f4229d, this.f4226a, this.f4230e, this.f4227b);
        districtSearchQuery.setShowBoundary(this.f4231f);
        return districtSearchQuery;
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
            DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
            if (this.f4231f != districtSearchQuery.f4231f) {
                return false;
            }
            if (this.f4228c == null) {
                if (districtSearchQuery.f4228c != null) {
                    return false;
                }
            } else if (!this.f4228c.equals(districtSearchQuery.f4228c)) {
                return false;
            }
            if (this.f4229d == null) {
                if (districtSearchQuery.f4229d != null) {
                    return false;
                }
            } else if (!this.f4229d.equals(districtSearchQuery.f4229d)) {
                return false;
            }
            return this.f4226a == districtSearchQuery.f4226a && this.f4227b == districtSearchQuery.f4227b && this.f4230e == districtSearchQuery.f4230e;
        }
        return false;
    }

    public String getKeywords() {
        return this.f4228c;
    }

    public String getKeywordsLevel() {
        return this.f4229d;
    }

    public int getPageNum() {
        return this.f4226a;
    }

    public int getPageSize() {
        return this.f4227b;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = 0;
        int hashCode = ((this.f4228c == null ? 0 : this.f4228c.hashCode()) + (((this.f4231f ? 1231 : 1237) + 31) * 31)) * 31;
        if (this.f4229d != null) {
            i2 = this.f4229d.hashCode();
        }
        int i3 = (((((hashCode + i2) * 31) + this.f4226a) * 31) + this.f4227b) * 31;
        if (!this.f4230e) {
            i = 1237;
        }
        return i3 + i;
    }

    public boolean isShowBoundary() {
        return this.f4231f;
    }

    public boolean isShowChild() {
        return this.f4230e;
    }

    public void setKeywords(String str) {
        this.f4228c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f4229d = str;
    }

    public void setPageNum(int i) {
        this.f4226a = i;
    }

    public void setPageSize(int i) {
        this.f4227b = i;
    }

    public void setShowBoundary(boolean z) {
        this.f4231f = z;
    }

    public void setShowChild(boolean z) {
        this.f4230e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        if (this.f4228c == null) {
            if (districtSearchQuery.f4228c != null) {
                return false;
            }
        } else if (!this.f4228c.equals(districtSearchQuery.f4228c)) {
            return false;
        }
        if (this.f4229d == null) {
            if (districtSearchQuery.f4229d != null) {
                return false;
            }
        } else if (!this.f4229d.equals(districtSearchQuery.f4229d)) {
            return false;
        }
        return this.f4227b == districtSearchQuery.f4227b && this.f4230e == districtSearchQuery.f4230e && this.f4231f == districtSearchQuery.f4231f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f4228c);
        parcel.writeString(this.f4229d);
        parcel.writeInt(this.f4226a);
        parcel.writeInt(this.f4227b);
        parcel.writeByte((byte) (this.f4230e ? 1 : 0));
        if (!this.f4231f) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }
}
