package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class Dining implements Parcelable {
    public static final Parcelable.Creator<Dining> CREATOR = new C1280b();

    /* renamed from: a */
    private boolean f4302a;

    /* renamed from: b */
    private String f4303b;

    /* renamed from: c */
    private String f4304c;

    /* renamed from: d */
    private String f4305d;

    /* renamed from: e */
    private String f4306e;

    /* renamed from: f */
    private String f4307f;

    /* renamed from: g */
    private String f4308g;

    /* renamed from: h */
    private String f4309h;

    /* renamed from: i */
    private String f4310i;

    /* renamed from: j */
    private String f4311j;

    /* renamed from: k */
    private String f4312k;

    /* renamed from: l */
    private String f4313l;

    /* renamed from: m */
    private String f4314m;

    /* renamed from: n */
    private String f4315n;

    /* renamed from: o */
    private String f4316o;

    /* renamed from: p */
    private String f4317p;

    /* renamed from: q */
    private String f4318q;

    /* renamed from: r */
    private String f4319r;

    /* renamed from: s */
    private String f4320s;

    /* renamed from: t */
    private List<Photo> f4321t;

    public Dining() {
        this.f4321t = new ArrayList();
    }

    public Dining(Parcel parcel) {
        this.f4321t = new ArrayList();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4302a = zArr[0];
        this.f4303b = parcel.readString();
        this.f4304c = parcel.readString();
        this.f4305d = parcel.readString();
        this.f4306e = parcel.readString();
        this.f4307f = parcel.readString();
        this.f4308g = parcel.readString();
        this.f4309h = parcel.readString();
        this.f4310i = parcel.readString();
        this.f4311j = parcel.readString();
        this.f4312k = parcel.readString();
        this.f4313l = parcel.readString();
        this.f4314m = parcel.readString();
        this.f4315n = parcel.readString();
        this.f4316o = parcel.readString();
        this.f4317p = parcel.readString();
        this.f4318q = parcel.readString();
        this.f4319r = parcel.readString();
        this.f4320s = parcel.readString();
        this.f4321t = parcel.createTypedArrayList(Photo.CREATOR);
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
            Dining dining = (Dining) obj;
            if (this.f4320s == null) {
                if (dining.f4320s != null) {
                    return false;
                }
            } else if (!this.f4320s.equals(dining.f4320s)) {
                return false;
            }
            if (this.f4314m == null) {
                if (dining.f4314m != null) {
                    return false;
                }
            } else if (!this.f4314m.equals(dining.f4314m)) {
                return false;
            }
            if (this.f4312k == null) {
                if (dining.f4312k != null) {
                    return false;
                }
            } else if (!this.f4312k.equals(dining.f4312k)) {
                return false;
            }
            if (this.f4307f == null) {
                if (dining.f4307f != null) {
                    return false;
                }
            } else if (!this.f4307f.equals(dining.f4307f)) {
                return false;
            }
            if (this.f4303b == null) {
                if (dining.f4303b != null) {
                    return false;
                }
            } else if (!this.f4303b.equals(dining.f4303b)) {
                return false;
            }
            if (this.f4308g == null) {
                if (dining.f4308g != null) {
                    return false;
                }
            } else if (!this.f4308g.equals(dining.f4308g)) {
                return false;
            }
            if (this.f4310i == null) {
                if (dining.f4310i != null) {
                    return false;
                }
            } else if (!this.f4310i.equals(dining.f4310i)) {
                return false;
            }
            if (this.f4305d == null) {
                if (dining.f4305d != null) {
                    return false;
                }
            } else if (!this.f4305d.equals(dining.f4305d)) {
                return false;
            }
            if (this.f4302a != dining.f4302a) {
                return false;
            }
            if (this.f4319r == null) {
                if (dining.f4319r != null) {
                    return false;
                }
            } else if (!this.f4319r.equals(dining.f4319r)) {
                return false;
            }
            if (this.f4318q == null) {
                if (dining.f4318q != null) {
                    return false;
                }
            } else if (!this.f4318q.equals(dining.f4318q)) {
                return false;
            }
            if (this.f4317p == null) {
                if (dining.f4317p != null) {
                    return false;
                }
            } else if (!this.f4317p.equals(dining.f4317p)) {
                return false;
            }
            if (this.f4315n == null) {
                if (dining.f4315n != null) {
                    return false;
                }
            } else if (!this.f4315n.equals(dining.f4315n)) {
                return false;
            }
            if (this.f4316o == null) {
                if (dining.f4316o != null) {
                    return false;
                }
            } else if (!this.f4316o.equals(dining.f4316o)) {
                return false;
            }
            if (this.f4321t == null) {
                if (dining.f4321t != null) {
                    return false;
                }
            } else if (!this.f4321t.equals(dining.f4321t)) {
                return false;
            }
            if (this.f4306e == null) {
                if (dining.f4306e != null) {
                    return false;
                }
            } else if (!this.f4306e.equals(dining.f4306e)) {
                return false;
            }
            if (this.f4313l == null) {
                if (dining.f4313l != null) {
                    return false;
                }
            } else if (!this.f4313l.equals(dining.f4313l)) {
                return false;
            }
            if (this.f4311j == null) {
                if (dining.f4311j != null) {
                    return false;
                }
            } else if (!this.f4311j.equals(dining.f4311j)) {
                return false;
            }
            if (this.f4304c == null) {
                if (dining.f4304c != null) {
                    return false;
                }
            } else if (!this.f4304c.equals(dining.f4304c)) {
                return false;
            }
            return this.f4309h == null ? dining.f4309h == null : this.f4309h.equals(dining.f4309h);
        }
        return false;
    }

    public String getAddition() {
        return this.f4320s;
    }

    public String getAtmosphere() {
        return this.f4314m;
    }

    public String getCost() {
        return this.f4312k;
    }

    public String getCpRating() {
        return this.f4307f;
    }

    public String getCuisines() {
        return this.f4303b;
    }

    public String getDeepsrc() {
        return this.f4308g;
    }

    public String getEnvironmentRating() {
        return this.f4310i;
    }

    public String getIntro() {
        return this.f4305d;
    }

    public String getOpentime() {
        return this.f4319r;
    }

    public String getOpentimeGDF() {
        return this.f4318q;
    }

    public String getOrderinAppUrl() {
        return this.f4317p;
    }

    public String getOrderingWapUrl() {
        return this.f4315n;
    }

    public String getOrderingWebUrl() {
        return this.f4316o;
    }

    public List<Photo> getPhotos() {
        return this.f4321t;
    }

    public String getRating() {
        return this.f4306e;
    }

    public String getRecommend() {
        return this.f4313l;
    }

    public String getServiceRating() {
        return this.f4311j;
    }

    public String getTag() {
        return this.f4304c;
    }

    public String getTasteRating() {
        return this.f4309h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4304c == null ? 0 : this.f4304c.hashCode()) + (((this.f4311j == null ? 0 : this.f4311j.hashCode()) + (((this.f4313l == null ? 0 : this.f4313l.hashCode()) + (((this.f4306e == null ? 0 : this.f4306e.hashCode()) + (((this.f4321t == null ? 0 : this.f4321t.hashCode()) + (((this.f4316o == null ? 0 : this.f4316o.hashCode()) + (((this.f4315n == null ? 0 : this.f4315n.hashCode()) + (((this.f4317p == null ? 0 : this.f4317p.hashCode()) + (((this.f4318q == null ? 0 : this.f4318q.hashCode()) + (((this.f4319r == null ? 0 : this.f4319r.hashCode()) + (((this.f4302a ? 1231 : 1237) + (((this.f4305d == null ? 0 : this.f4305d.hashCode()) + (((this.f4310i == null ? 0 : this.f4310i.hashCode()) + (((this.f4308g == null ? 0 : this.f4308g.hashCode()) + (((this.f4303b == null ? 0 : this.f4303b.hashCode()) + (((this.f4307f == null ? 0 : this.f4307f.hashCode()) + (((this.f4312k == null ? 0 : this.f4312k.hashCode()) + (((this.f4314m == null ? 0 : this.f4314m.hashCode()) + (((this.f4320s == null ? 0 : this.f4320s.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4309h != null) {
            i = this.f4309h.hashCode();
        }
        return hashCode + i;
    }

    public boolean isMealOrdering() {
        return this.f4302a;
    }

    public void setAddition(String str) {
        this.f4320s = str;
    }

    public void setAtmosphere(String str) {
        this.f4314m = str;
    }

    public void setCost(String str) {
        this.f4312k = str;
    }

    public void setCpRating(String str) {
        this.f4307f = str;
    }

    public void setCuisines(String str) {
        this.f4303b = str;
    }

    public void setDeepsrc(String str) {
        this.f4308g = str;
    }

    public void setEnvironmentRating(String str) {
        this.f4310i = str;
    }

    public void setIntro(String str) {
        this.f4305d = str;
    }

    public void setMealOrdering(boolean z) {
        this.f4302a = z;
    }

    public void setOpentime(String str) {
        this.f4319r = str;
    }

    public void setOpentimeGDF(String str) {
        this.f4318q = str;
    }

    public void setOrderinAppUrl(String str) {
        this.f4317p = str;
    }

    public void setOrderingWapUrl(String str) {
        this.f4315n = str;
    }

    public void setOrderingWebUrl(String str) {
        this.f4316o = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f4321t = list;
    }

    public void setRating(String str) {
        this.f4306e = str;
    }

    public void setRecommend(String str) {
        this.f4313l = str;
    }

    public void setServiceRating(String str) {
        this.f4311j = str;
    }

    public void setTag(String str) {
        this.f4304c = str;
    }

    public void setTasteRating(String str) {
        this.f4309h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f4302a});
        parcel.writeString(this.f4303b);
        parcel.writeString(this.f4304c);
        parcel.writeString(this.f4305d);
        parcel.writeString(this.f4306e);
        parcel.writeString(this.f4307f);
        parcel.writeString(this.f4308g);
        parcel.writeString(this.f4309h);
        parcel.writeString(this.f4310i);
        parcel.writeString(this.f4311j);
        parcel.writeString(this.f4312k);
        parcel.writeString(this.f4313l);
        parcel.writeString(this.f4314m);
        parcel.writeString(this.f4315n);
        parcel.writeString(this.f4316o);
        parcel.writeString(this.f4317p);
        parcel.writeString(this.f4318q);
        parcel.writeString(this.f4319r);
        parcel.writeString(this.f4320s);
        parcel.writeTypedList(this.f4321t);
    }
}
