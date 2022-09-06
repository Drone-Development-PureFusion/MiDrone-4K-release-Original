package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.C1233d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public final class Discount implements Parcelable {
    public static final Parcelable.Creator<Discount> CREATOR = new C1281c();

    /* renamed from: a */
    private String f4322a;

    /* renamed from: b */
    private String f4323b;

    /* renamed from: c */
    private Date f4324c;

    /* renamed from: d */
    private Date f4325d;

    /* renamed from: e */
    private int f4326e;

    /* renamed from: f */
    private List<Photo> f4327f;

    /* renamed from: g */
    private String f4328g;

    /* renamed from: h */
    private String f4329h;

    public Discount() {
        this.f4327f = new ArrayList();
    }

    public Discount(Parcel parcel) {
        this.f4327f = new ArrayList();
        this.f4322a = parcel.readString();
        this.f4323b = parcel.readString();
        this.f4324c = C1233d.m17025e(parcel.readString());
        this.f4325d = C1233d.m17025e(parcel.readString());
        this.f4326e = parcel.readInt();
        this.f4327f = parcel.createTypedArrayList(Photo.CREATOR);
        this.f4328g = parcel.readString();
        this.f4329h = parcel.readString();
    }

    public void addPhotos(Photo photo) {
        this.f4327f.add(photo);
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
            Discount discount = (Discount) obj;
            if (this.f4323b == null) {
                if (discount.f4323b != null) {
                    return false;
                }
            } else if (!this.f4323b.equals(discount.f4323b)) {
                return false;
            }
            if (this.f4325d == null) {
                if (discount.f4325d != null) {
                    return false;
                }
            } else if (!this.f4325d.equals(discount.f4325d)) {
                return false;
            }
            if (this.f4327f == null) {
                if (discount.f4327f != null) {
                    return false;
                }
            } else if (!this.f4327f.equals(discount.f4327f)) {
                return false;
            }
            if (this.f4329h == null) {
                if (discount.f4329h != null) {
                    return false;
                }
            } else if (!this.f4329h.equals(discount.f4329h)) {
                return false;
            }
            if (this.f4326e != discount.f4326e) {
                return false;
            }
            if (this.f4324c == null) {
                if (discount.f4324c != null) {
                    return false;
                }
            } else if (!this.f4324c.equals(discount.f4324c)) {
                return false;
            }
            if (this.f4322a == null) {
                if (discount.f4322a != null) {
                    return false;
                }
            } else if (!this.f4322a.equals(discount.f4322a)) {
                return false;
            }
            return this.f4328g == null ? discount.f4328g == null : this.f4328g.equals(discount.f4328g);
        }
        return false;
    }

    public String getDetail() {
        return this.f4323b;
    }

    public Date getEndTime() {
        if (this.f4325d == null) {
            return null;
        }
        return (Date) this.f4325d.clone();
    }

    public List<Photo> getPhotos() {
        return this.f4327f;
    }

    public String getProvider() {
        return this.f4329h;
    }

    public int getSoldCount() {
        return this.f4326e;
    }

    public Date getStartTime() {
        if (this.f4324c == null) {
            return null;
        }
        return (Date) this.f4324c.clone();
    }

    public String getTitle() {
        return this.f4322a;
    }

    public String getUrl() {
        return this.f4328g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4322a == null ? 0 : this.f4322a.hashCode()) + (((this.f4324c == null ? 0 : this.f4324c.hashCode()) + (((((this.f4329h == null ? 0 : this.f4329h.hashCode()) + (((this.f4327f == null ? 0 : this.f4327f.hashCode()) + (((this.f4325d == null ? 0 : this.f4325d.hashCode()) + (((this.f4323b == null ? 0 : this.f4323b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + this.f4326e) * 31)) * 31)) * 31;
        if (this.f4328g != null) {
            i = this.f4328g.hashCode();
        }
        return hashCode + i;
    }

    public void initPhotos(List<Photo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4327f.clear();
        for (Photo photo : list) {
            this.f4327f.add(photo);
        }
    }

    public void setDetail(String str) {
        this.f4323b = str;
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f4325d = null;
        } else {
            this.f4325d = (Date) date.clone();
        }
    }

    public void setProvider(String str) {
        this.f4329h = str;
    }

    public void setSoldCount(int i) {
        this.f4326e = i;
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f4324c = null;
        } else {
            this.f4324c = (Date) date.clone();
        }
    }

    public void setTitle(String str) {
        this.f4322a = str;
    }

    public void setUrl(String str) {
        this.f4328g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4322a);
        parcel.writeString(this.f4323b);
        parcel.writeString(C1233d.m17030a(this.f4324c));
        parcel.writeString(C1233d.m17030a(this.f4325d));
        parcel.writeInt(this.f4326e);
        parcel.writeTypedList(this.f4327f);
        parcel.writeString(this.f4328g);
        parcel.writeString(this.f4329h);
    }
}
