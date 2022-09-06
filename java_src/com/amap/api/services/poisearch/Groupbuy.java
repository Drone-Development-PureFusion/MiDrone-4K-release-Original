package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.C1233d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public final class Groupbuy implements Parcelable {
    public static final Parcelable.Creator<Groupbuy> CREATOR = new C1282d();

    /* renamed from: a */
    private String f4330a;

    /* renamed from: b */
    private String f4331b;

    /* renamed from: c */
    private String f4332c;

    /* renamed from: d */
    private Date f4333d;

    /* renamed from: e */
    private Date f4334e;

    /* renamed from: f */
    private int f4335f;

    /* renamed from: g */
    private int f4336g;

    /* renamed from: h */
    private float f4337h;

    /* renamed from: i */
    private float f4338i;

    /* renamed from: j */
    private float f4339j;

    /* renamed from: k */
    private String f4340k;

    /* renamed from: l */
    private String f4341l;

    /* renamed from: m */
    private List<Photo> f4342m;

    /* renamed from: n */
    private String f4343n;

    /* renamed from: o */
    private String f4344o;

    public Groupbuy() {
        this.f4342m = new ArrayList();
    }

    public Groupbuy(Parcel parcel) {
        this.f4342m = new ArrayList();
        this.f4330a = parcel.readString();
        this.f4331b = parcel.readString();
        this.f4332c = parcel.readString();
        this.f4333d = C1233d.m17025e(parcel.readString());
        this.f4334e = C1233d.m17025e(parcel.readString());
        this.f4335f = parcel.readInt();
        this.f4336g = parcel.readInt();
        this.f4337h = parcel.readFloat();
        this.f4338i = parcel.readFloat();
        this.f4339j = parcel.readFloat();
        this.f4340k = parcel.readString();
        this.f4341l = parcel.readString();
        this.f4342m = parcel.createTypedArrayList(Photo.CREATOR);
        this.f4343n = parcel.readString();
        this.f4344o = parcel.readString();
    }

    public void addPhotos(Photo photo) {
        this.f4342m.add(photo);
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
            Groupbuy groupbuy = (Groupbuy) obj;
            if (this.f4335f != groupbuy.f4335f) {
                return false;
            }
            if (this.f4332c == null) {
                if (groupbuy.f4332c != null) {
                    return false;
                }
            } else if (!this.f4332c.equals(groupbuy.f4332c)) {
                return false;
            }
            if (Float.floatToIntBits(this.f4339j) != Float.floatToIntBits(groupbuy.f4339j)) {
                return false;
            }
            if (this.f4334e == null) {
                if (groupbuy.f4334e != null) {
                    return false;
                }
            } else if (!this.f4334e.equals(groupbuy.f4334e)) {
                return false;
            }
            if (Float.floatToIntBits(this.f4338i) == Float.floatToIntBits(groupbuy.f4338i) && Float.floatToIntBits(this.f4337h) == Float.floatToIntBits(groupbuy.f4337h)) {
                if (this.f4342m == null) {
                    if (groupbuy.f4342m != null) {
                        return false;
                    }
                } else if (!this.f4342m.equals(groupbuy.f4342m)) {
                    return false;
                }
                if (this.f4344o == null) {
                    if (groupbuy.f4344o != null) {
                        return false;
                    }
                } else if (!this.f4344o.equals(groupbuy.f4344o)) {
                    return false;
                }
                if (this.f4336g != groupbuy.f4336g) {
                    return false;
                }
                if (this.f4333d == null) {
                    if (groupbuy.f4333d != null) {
                        return false;
                    }
                } else if (!this.f4333d.equals(groupbuy.f4333d)) {
                    return false;
                }
                if (this.f4340k == null) {
                    if (groupbuy.f4340k != null) {
                        return false;
                    }
                } else if (!this.f4340k.equals(groupbuy.f4340k)) {
                    return false;
                }
                if (this.f4341l == null) {
                    if (groupbuy.f4341l != null) {
                        return false;
                    }
                } else if (!this.f4341l.equals(groupbuy.f4341l)) {
                    return false;
                }
                if (this.f4330a == null) {
                    if (groupbuy.f4330a != null) {
                        return false;
                    }
                } else if (!this.f4330a.equals(groupbuy.f4330a)) {
                    return false;
                }
                if (this.f4331b == null) {
                    if (groupbuy.f4331b != null) {
                        return false;
                    }
                } else if (!this.f4331b.equals(groupbuy.f4331b)) {
                    return false;
                }
                return this.f4343n == null ? groupbuy.f4343n == null : this.f4343n.equals(groupbuy.f4343n);
            }
            return false;
        }
        return false;
    }

    public int getCount() {
        return this.f4335f;
    }

    public String getDetail() {
        return this.f4332c;
    }

    public float getDiscount() {
        return this.f4339j;
    }

    public Date getEndTime() {
        if (this.f4334e == null) {
            return null;
        }
        return (Date) this.f4334e.clone();
    }

    public float getGroupbuyPrice() {
        return this.f4338i;
    }

    public float getOriginalPrice() {
        return this.f4337h;
    }

    public List<Photo> getPhotos() {
        return this.f4342m;
    }

    public String getProvider() {
        return this.f4344o;
    }

    public int getSoldCount() {
        return this.f4336g;
    }

    public Date getStartTime() {
        if (this.f4333d == null) {
            return null;
        }
        return (Date) this.f4333d.clone();
    }

    public String getTicketAddress() {
        return this.f4340k;
    }

    public String getTicketTel() {
        return this.f4341l;
    }

    public String getTypeCode() {
        return this.f4330a;
    }

    public String getTypeDes() {
        return this.f4331b;
    }

    public String getUrl() {
        return this.f4343n;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4331b == null ? 0 : this.f4331b.hashCode()) + (((this.f4330a == null ? 0 : this.f4330a.hashCode()) + (((this.f4341l == null ? 0 : this.f4341l.hashCode()) + (((this.f4340k == null ? 0 : this.f4340k.hashCode()) + (((this.f4333d == null ? 0 : this.f4333d.hashCode()) + (((((this.f4344o == null ? 0 : this.f4344o.hashCode()) + (((this.f4342m == null ? 0 : this.f4342m.hashCode()) + (((((((this.f4334e == null ? 0 : this.f4334e.hashCode()) + (((((this.f4332c == null ? 0 : this.f4332c.hashCode()) + ((this.f4335f + 31) * 31)) * 31) + Float.floatToIntBits(this.f4339j)) * 31)) * 31) + Float.floatToIntBits(this.f4338i)) * 31) + Float.floatToIntBits(this.f4337h)) * 31)) * 31)) * 31) + this.f4336g) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4343n != null) {
            i = this.f4343n.hashCode();
        }
        return hashCode + i;
    }

    public void initPhotos(List<Photo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4342m.clear();
        for (Photo photo : list) {
            this.f4342m.add(photo);
        }
    }

    public void setCount(int i) {
        this.f4335f = i;
    }

    public void setDetail(String str) {
        this.f4332c = str;
    }

    public void setDiscount(float f) {
        this.f4339j = f;
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f4334e = null;
        } else {
            this.f4334e = (Date) date.clone();
        }
    }

    public void setGroupbuyPrice(float f) {
        this.f4338i = f;
    }

    public void setOriginalPrice(float f) {
        this.f4337h = f;
    }

    public void setProvider(String str) {
        this.f4344o = str;
    }

    public void setSoldCount(int i) {
        this.f4336g = i;
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f4333d = null;
        } else {
            this.f4333d = (Date) date.clone();
        }
    }

    public void setTicketAddress(String str) {
        this.f4340k = str;
    }

    public void setTicketTel(String str) {
        this.f4341l = str;
    }

    public void setTypeCode(String str) {
        this.f4330a = str;
    }

    public void setTypeDes(String str) {
        this.f4331b = str;
    }

    public void setUrl(String str) {
        this.f4343n = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4330a);
        parcel.writeString(this.f4331b);
        parcel.writeString(this.f4332c);
        parcel.writeString(C1233d.m17030a(this.f4333d));
        parcel.writeString(C1233d.m17030a(this.f4334e));
        parcel.writeInt(this.f4335f);
        parcel.writeInt(this.f4336g);
        parcel.writeFloat(this.f4337h);
        parcel.writeFloat(this.f4338i);
        parcel.writeFloat(this.f4339j);
        parcel.writeString(this.f4340k);
        parcel.writeString(this.f4341l);
        parcel.writeTypedList(this.f4342m);
        parcel.writeString(this.f4343n);
        parcel.writeString(this.f4344o);
    }
}
