package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class Hotel implements Parcelable {
    public static final Parcelable.Creator<Hotel> CREATOR = new C1283e();

    /* renamed from: a */
    private String f4345a;

    /* renamed from: b */
    private String f4346b;

    /* renamed from: c */
    private String f4347c;

    /* renamed from: d */
    private String f4348d;

    /* renamed from: e */
    private String f4349e;

    /* renamed from: f */
    private String f4350f;

    /* renamed from: g */
    private String f4351g;

    /* renamed from: h */
    private String f4352h;

    /* renamed from: i */
    private String f4353i;

    /* renamed from: j */
    private String f4354j;

    /* renamed from: k */
    private String f4355k;

    /* renamed from: l */
    private List<Photo> f4356l;

    public Hotel() {
        this.f4356l = new ArrayList();
    }

    public Hotel(Parcel parcel) {
        this.f4356l = new ArrayList();
        this.f4345a = parcel.readString();
        this.f4346b = parcel.readString();
        this.f4347c = parcel.readString();
        this.f4348d = parcel.readString();
        this.f4349e = parcel.readString();
        this.f4350f = parcel.readString();
        this.f4351g = parcel.readString();
        this.f4352h = parcel.readString();
        this.f4353i = parcel.readString();
        this.f4354j = parcel.readString();
        this.f4355k = parcel.readString();
        this.f4356l = parcel.createTypedArrayList(Photo.CREATOR);
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
            Hotel hotel = (Hotel) obj;
            if (this.f4354j == null) {
                if (hotel.f4354j != null) {
                    return false;
                }
            } else if (!this.f4354j.equals(hotel.f4354j)) {
                return false;
            }
            if (this.f4355k == null) {
                if (hotel.f4355k != null) {
                    return false;
                }
            } else if (!this.f4355k.equals(hotel.f4355k)) {
                return false;
            }
            if (this.f4351g == null) {
                if (hotel.f4351g != null) {
                    return false;
                }
            } else if (!this.f4351g.equals(hotel.f4351g)) {
                return false;
            }
            if (this.f4349e == null) {
                if (hotel.f4349e != null) {
                    return false;
                }
            } else if (!this.f4349e.equals(hotel.f4349e)) {
                return false;
            }
            if (this.f4350f == null) {
                if (hotel.f4350f != null) {
                    return false;
                }
            } else if (!this.f4350f.equals(hotel.f4350f)) {
                return false;
            }
            if (this.f4347c == null) {
                if (hotel.f4347c != null) {
                    return false;
                }
            } else if (!this.f4347c.equals(hotel.f4347c)) {
                return false;
            }
            if (this.f4348d == null) {
                if (hotel.f4348d != null) {
                    return false;
                }
            } else if (!this.f4348d.equals(hotel.f4348d)) {
                return false;
            }
            if (this.f4356l == null) {
                if (hotel.f4356l != null) {
                    return false;
                }
            } else if (!this.f4356l.equals(hotel.f4356l)) {
                return false;
            }
            if (this.f4345a == null) {
                if (hotel.f4345a != null) {
                    return false;
                }
            } else if (!this.f4345a.equals(hotel.f4345a)) {
                return false;
            }
            if (this.f4352h == null) {
                if (hotel.f4352h != null) {
                    return false;
                }
            } else if (!this.f4352h.equals(hotel.f4352h)) {
                return false;
            }
            if (this.f4346b == null) {
                if (hotel.f4346b != null) {
                    return false;
                }
            } else if (!this.f4346b.equals(hotel.f4346b)) {
                return false;
            }
            return this.f4353i == null ? hotel.f4353i == null : this.f4353i.equals(hotel.f4353i);
        }
        return false;
    }

    public String getAddition() {
        return this.f4354j;
    }

    public String getDeepsrc() {
        return this.f4355k;
    }

    public String getEnvironmentRating() {
        return this.f4351g;
    }

    public String getFaciRating() {
        return this.f4349e;
    }

    public String getHealthRating() {
        return this.f4350f;
    }

    public String getIntro() {
        return this.f4347c;
    }

    public String getLowestPrice() {
        return this.f4348d;
    }

    public List<Photo> getPhotos() {
        return this.f4356l;
    }

    public String getRating() {
        return this.f4345a;
    }

    public String getServiceRating() {
        return this.f4352h;
    }

    public String getStar() {
        return this.f4346b;
    }

    public String getTraffic() {
        return this.f4353i;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4346b == null ? 0 : this.f4346b.hashCode()) + (((this.f4352h == null ? 0 : this.f4352h.hashCode()) + (((this.f4345a == null ? 0 : this.f4345a.hashCode()) + (((this.f4356l == null ? 0 : this.f4356l.hashCode()) + (((this.f4348d == null ? 0 : this.f4348d.hashCode()) + (((this.f4347c == null ? 0 : this.f4347c.hashCode()) + (((this.f4350f == null ? 0 : this.f4350f.hashCode()) + (((this.f4349e == null ? 0 : this.f4349e.hashCode()) + (((this.f4351g == null ? 0 : this.f4351g.hashCode()) + (((this.f4355k == null ? 0 : this.f4355k.hashCode()) + (((this.f4354j == null ? 0 : this.f4354j.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4353i != null) {
            i = this.f4353i.hashCode();
        }
        return hashCode + i;
    }

    public void setAddition(String str) {
        this.f4354j = str;
    }

    public void setDeepsrc(String str) {
        this.f4355k = str;
    }

    public void setEnvironmentRating(String str) {
        this.f4351g = str;
    }

    public void setFaciRating(String str) {
        this.f4349e = str;
    }

    public void setHealthRating(String str) {
        this.f4350f = str;
    }

    public void setIntro(String str) {
        this.f4347c = str;
    }

    public void setLowestPrice(String str) {
        this.f4348d = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f4356l = list;
    }

    public void setRating(String str) {
        this.f4345a = str;
    }

    public void setServiceRating(String str) {
        this.f4352h = str;
    }

    public void setStar(String str) {
        this.f4346b = str;
    }

    public void setTraffic(String str) {
        this.f4353i = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4345a);
        parcel.writeString(this.f4346b);
        parcel.writeString(this.f4347c);
        parcel.writeString(this.f4348d);
        parcel.writeString(this.f4349e);
        parcel.writeString(this.f4350f);
        parcel.writeString(this.f4351g);
        parcel.writeString(this.f4352h);
        parcel.writeString(this.f4353i);
        parcel.writeString(this.f4354j);
        parcel.writeString(this.f4355k);
        parcel.writeTypedList(this.f4356l);
    }
}
