package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class Scenic implements Parcelable {
    public static final Parcelable.Creator<Scenic> CREATOR = new C1289k();

    /* renamed from: a */
    private String f4398a;

    /* renamed from: b */
    private String f4399b;

    /* renamed from: c */
    private String f4400c;

    /* renamed from: d */
    private String f4401d;

    /* renamed from: e */
    private String f4402e;

    /* renamed from: f */
    private String f4403f;

    /* renamed from: g */
    private String f4404g;

    /* renamed from: h */
    private String f4405h;

    /* renamed from: i */
    private String f4406i;

    /* renamed from: j */
    private String f4407j;

    /* renamed from: k */
    private String f4408k;

    /* renamed from: l */
    private String f4409l;

    /* renamed from: m */
    private List<Photo> f4410m;

    public Scenic() {
        this.f4410m = new ArrayList();
    }

    public Scenic(Parcel parcel) {
        this.f4410m = new ArrayList();
        this.f4398a = parcel.readString();
        this.f4399b = parcel.readString();
        this.f4400c = parcel.readString();
        this.f4401d = parcel.readString();
        this.f4402e = parcel.readString();
        this.f4403f = parcel.readString();
        this.f4404g = parcel.readString();
        this.f4405h = parcel.readString();
        this.f4406i = parcel.readString();
        this.f4407j = parcel.readString();
        this.f4408k = parcel.readString();
        this.f4409l = parcel.readString();
        this.f4410m = parcel.createTypedArrayList(Photo.CREATOR);
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
            Scenic scenic = (Scenic) obj;
            if (this.f4400c == null) {
                if (scenic.f4400c != null) {
                    return false;
                }
            } else if (!this.f4400c.equals(scenic.f4400c)) {
                return false;
            }
            if (this.f4398a == null) {
                if (scenic.f4398a != null) {
                    return false;
                }
            } else if (!this.f4398a.equals(scenic.f4398a)) {
                return false;
            }
            if (this.f4401d == null) {
                if (scenic.f4401d != null) {
                    return false;
                }
            } else if (!this.f4401d.equals(scenic.f4401d)) {
                return false;
            }
            if (this.f4409l == null) {
                if (scenic.f4409l != null) {
                    return false;
                }
            } else if (!this.f4409l.equals(scenic.f4409l)) {
                return false;
            }
            if (this.f4408k == null) {
                if (scenic.f4408k != null) {
                    return false;
                }
            } else if (!this.f4408k.equals(scenic.f4408k)) {
                return false;
            }
            if (this.f4406i == null) {
                if (scenic.f4406i != null) {
                    return false;
                }
            } else if (!this.f4406i.equals(scenic.f4406i)) {
                return false;
            }
            if (this.f4407j == null) {
                if (scenic.f4407j != null) {
                    return false;
                }
            } else if (!this.f4407j.equals(scenic.f4407j)) {
                return false;
            }
            if (this.f4410m == null) {
                if (scenic.f4410m != null) {
                    return false;
                }
            } else if (!this.f4410m.equals(scenic.f4410m)) {
                return false;
            }
            if (this.f4402e == null) {
                if (scenic.f4402e != null) {
                    return false;
                }
            } else if (!this.f4402e.equals(scenic.f4402e)) {
                return false;
            }
            if (this.f4399b == null) {
                if (scenic.f4399b != null) {
                    return false;
                }
            } else if (!this.f4399b.equals(scenic.f4399b)) {
                return false;
            }
            if (this.f4404g == null) {
                if (scenic.f4404g != null) {
                    return false;
                }
            } else if (!this.f4404g.equals(scenic.f4404g)) {
                return false;
            }
            if (this.f4403f == null) {
                if (scenic.f4403f != null) {
                    return false;
                }
            } else if (!this.f4403f.equals(scenic.f4403f)) {
                return false;
            }
            return this.f4405h == null ? scenic.f4405h == null : this.f4405h.equals(scenic.f4405h);
        }
        return false;
    }

    public String getDeepsrc() {
        return this.f4400c;
    }

    public String getIntro() {
        return this.f4398a;
    }

    public String getLevel() {
        return this.f4401d;
    }

    public String getOpentime() {
        return this.f4409l;
    }

    public String getOpentimeGDF() {
        return this.f4408k;
    }

    public String getOrderWapUrl() {
        return this.f4406i;
    }

    public String getOrderWebUrl() {
        return this.f4407j;
    }

    public List<Photo> getPhotos() {
        return this.f4410m;
    }

    public String getPrice() {
        return this.f4402e;
    }

    public String getRating() {
        return this.f4399b;
    }

    public String getRecommend() {
        return this.f4404g;
    }

    public String getSeason() {
        return this.f4403f;
    }

    public String getTheme() {
        return this.f4405h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4403f == null ? 0 : this.f4403f.hashCode()) + (((this.f4404g == null ? 0 : this.f4404g.hashCode()) + (((this.f4399b == null ? 0 : this.f4399b.hashCode()) + (((this.f4402e == null ? 0 : this.f4402e.hashCode()) + (((this.f4410m == null ? 0 : this.f4410m.hashCode()) + (((this.f4407j == null ? 0 : this.f4407j.hashCode()) + (((this.f4406i == null ? 0 : this.f4406i.hashCode()) + (((this.f4408k == null ? 0 : this.f4408k.hashCode()) + (((this.f4409l == null ? 0 : this.f4409l.hashCode()) + (((this.f4401d == null ? 0 : this.f4401d.hashCode()) + (((this.f4398a == null ? 0 : this.f4398a.hashCode()) + (((this.f4400c == null ? 0 : this.f4400c.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4405h != null) {
            i = this.f4405h.hashCode();
        }
        return hashCode + i;
    }

    public void setDeepsrc(String str) {
        this.f4400c = str;
    }

    public void setIntro(String str) {
        this.f4398a = str;
    }

    public void setLevel(String str) {
        this.f4401d = str;
    }

    public void setOpentime(String str) {
        this.f4409l = str;
    }

    public void setOpentimeGDF(String str) {
        this.f4408k = str;
    }

    public void setOrderWapUrl(String str) {
        this.f4406i = str;
    }

    public void setOrderWebUrl(String str) {
        this.f4407j = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f4410m = list;
    }

    public void setPrice(String str) {
        this.f4402e = str;
    }

    public void setRating(String str) {
        this.f4399b = str;
    }

    public void setRecommend(String str) {
        this.f4404g = str;
    }

    public void setSeason(String str) {
        this.f4403f = str;
    }

    public void setTheme(String str) {
        this.f4405h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4398a);
        parcel.writeString(this.f4399b);
        parcel.writeString(this.f4400c);
        parcel.writeString(this.f4401d);
        parcel.writeString(this.f4402e);
        parcel.writeString(this.f4403f);
        parcel.writeString(this.f4404g);
        parcel.writeString(this.f4405h);
        parcel.writeString(this.f4406i);
        parcel.writeString(this.f4407j);
        parcel.writeString(this.f4408k);
        parcel.writeString(this.f4409l);
        parcel.writeTypedList(this.f4410m);
    }
}
