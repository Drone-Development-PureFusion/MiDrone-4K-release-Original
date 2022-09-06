package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class Cinema implements Parcelable {
    public static final Parcelable.Creator<Cinema> CREATOR = new C1279a();

    /* renamed from: a */
    private boolean f4294a;

    /* renamed from: b */
    private String f4295b;

    /* renamed from: c */
    private String f4296c;

    /* renamed from: d */
    private String f4297d;

    /* renamed from: e */
    private String f4298e;

    /* renamed from: f */
    private String f4299f;

    /* renamed from: g */
    private String f4300g;

    /* renamed from: h */
    private List<Photo> f4301h;

    public Cinema() {
        this.f4301h = new ArrayList();
    }

    public Cinema(Parcel parcel) {
        this.f4301h = new ArrayList();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4294a = zArr[0];
        this.f4295b = parcel.readString();
        this.f4296c = parcel.readString();
        this.f4297d = parcel.readString();
        this.f4298e = parcel.readString();
        this.f4299f = parcel.readString();
        this.f4300g = parcel.readString();
        this.f4301h = parcel.createTypedArrayList(Photo.CREATOR);
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
            Cinema cinema = (Cinema) obj;
            if (this.f4297d == null) {
                if (cinema.f4297d != null) {
                    return false;
                }
            } else if (!this.f4297d.equals(cinema.f4297d)) {
                return false;
            }
            if (this.f4295b == null) {
                if (cinema.f4295b != null) {
                    return false;
                }
            } else if (!this.f4295b.equals(cinema.f4295b)) {
                return false;
            }
            if (this.f4300g == null) {
                if (cinema.f4300g != null) {
                    return false;
                }
            } else if (!this.f4300g.equals(cinema.f4300g)) {
                return false;
            }
            if (this.f4299f == null) {
                if (cinema.f4299f != null) {
                    return false;
                }
            } else if (!this.f4299f.equals(cinema.f4299f)) {
                return false;
            }
            if (this.f4298e == null) {
                if (cinema.f4298e != null) {
                    return false;
                }
            } else if (!this.f4298e.equals(cinema.f4298e)) {
                return false;
            }
            if (this.f4301h == null) {
                if (cinema.f4301h != null) {
                    return false;
                }
            } else if (!this.f4301h.equals(cinema.f4301h)) {
                return false;
            }
            if (this.f4296c == null) {
                if (cinema.f4296c != null) {
                    return false;
                }
            } else if (!this.f4296c.equals(cinema.f4296c)) {
                return false;
            }
            return this.f4294a == cinema.f4294a;
        }
        return false;
    }

    public String getDeepsrc() {
        return this.f4297d;
    }

    public String getIntro() {
        return this.f4295b;
    }

    public String getOpentime() {
        return this.f4300g;
    }

    public String getOpentimeGDF() {
        return this.f4299f;
    }

    public String getParking() {
        return this.f4298e;
    }

    public List<Photo> getPhotos() {
        return this.f4301h;
    }

    public String getRating() {
        return this.f4296c;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4301h == null ? 0 : this.f4301h.hashCode()) + (((this.f4298e == null ? 0 : this.f4298e.hashCode()) + (((this.f4299f == null ? 0 : this.f4299f.hashCode()) + (((this.f4300g == null ? 0 : this.f4300g.hashCode()) + (((this.f4295b == null ? 0 : this.f4295b.hashCode()) + (((this.f4297d == null ? 0 : this.f4297d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4296c != null) {
            i = this.f4296c.hashCode();
        }
        return (this.f4294a ? 1231 : 1237) + ((hashCode + i) * 31);
    }

    public boolean isSeatOrdering() {
        return this.f4294a;
    }

    public void setDeepsrc(String str) {
        this.f4297d = str;
    }

    public void setIntro(String str) {
        this.f4295b = str;
    }

    public void setOpentime(String str) {
        this.f4300g = str;
    }

    public void setOpentimeGDF(String str) {
        this.f4299f = str;
    }

    public void setParking(String str) {
        this.f4298e = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f4301h = list;
    }

    public void setRating(String str) {
        this.f4296c = str;
    }

    public void setSeatOrdering(boolean z) {
        this.f4294a = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f4294a});
        parcel.writeString(this.f4295b);
        parcel.writeString(this.f4296c);
        parcel.writeString(this.f4297d);
        parcel.writeString(this.f4298e);
        parcel.writeString(this.f4299f);
        parcel.writeString(this.f4300g);
        parcel.writeTypedList(this.f4301h);
    }
}
