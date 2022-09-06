package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PoiItemDetail extends PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItemDetail> CREATOR = new C1286h();

    /* renamed from: a */
    private List<Groupbuy> f4359a;

    /* renamed from: b */
    private List<Discount> f4360b;

    /* renamed from: c */
    private Dining f4361c;

    /* renamed from: d */
    private Hotel f4362d;

    /* renamed from: e */
    private Cinema f4363e;

    /* renamed from: f */
    private Scenic f4364f;

    /* renamed from: g */
    private DeepType f4365g;

    /* loaded from: classes.dex */
    public enum DeepType {
        UNKNOWN,
        DINING,
        HOTEL,
        CINEMA,
        SCENIC
    }

    private PoiItemDetail(Parcel parcel) {
        super(parcel);
        this.f4359a = new ArrayList();
        this.f4360b = new ArrayList();
        this.f4359a = parcel.readArrayList(Groupbuy.class.getClassLoader());
        this.f4360b = parcel.readArrayList(Discount.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PoiItemDetail(Parcel parcel, C1286h c1286h) {
        this(parcel);
    }

    public PoiItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
        this.f4359a = new ArrayList();
        this.f4360b = new ArrayList();
    }

    public void addDiscount(Discount discount) {
        this.f4360b.add(discount);
    }

    public void addGroupbuy(Groupbuy groupbuy) {
        this.f4359a.add(groupbuy);
    }

    @Override // com.amap.api.services.core.PoiItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.PoiItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            PoiItemDetail poiItemDetail = (PoiItemDetail) obj;
            if (this.f4363e == null) {
                if (poiItemDetail.f4363e != null) {
                    return false;
                }
            } else if (!this.f4363e.equals(poiItemDetail.f4363e)) {
                return false;
            }
            if (this.f4365g != poiItemDetail.f4365g) {
                return false;
            }
            if (this.f4361c == null) {
                if (poiItemDetail.f4361c != null) {
                    return false;
                }
            } else if (!this.f4361c.equals(poiItemDetail.f4361c)) {
                return false;
            }
            if (this.f4360b == null) {
                if (poiItemDetail.f4360b != null) {
                    return false;
                }
            } else if (!this.f4360b.equals(poiItemDetail.f4360b)) {
                return false;
            }
            if (this.f4359a == null) {
                if (poiItemDetail.f4359a != null) {
                    return false;
                }
            } else if (!this.f4359a.equals(poiItemDetail.f4359a)) {
                return false;
            }
            if (this.f4362d == null) {
                if (poiItemDetail.f4362d != null) {
                    return false;
                }
            } else if (!this.f4362d.equals(poiItemDetail.f4362d)) {
                return false;
            }
            return this.f4364f == null ? poiItemDetail.f4364f == null : this.f4364f.equals(poiItemDetail.f4364f);
        }
        return false;
    }

    public Cinema getCinema() {
        return this.f4363e;
    }

    public DeepType getDeepType() {
        return this.f4365g;
    }

    public Dining getDining() {
        return this.f4361c;
    }

    public List<Discount> getDiscounts() {
        return this.f4360b;
    }

    public List<Groupbuy> getGroupbuys() {
        return this.f4359a;
    }

    public Hotel getHotel() {
        return this.f4362d;
    }

    public Scenic getScenic() {
        return this.f4364f;
    }

    @Override // com.amap.api.services.core.PoiItem
    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4362d == null ? 0 : this.f4362d.hashCode()) + (((this.f4359a == null ? 0 : this.f4359a.hashCode()) + (((this.f4360b == null ? 0 : this.f4360b.hashCode()) + (((this.f4361c == null ? 0 : this.f4361c.hashCode()) + (((this.f4365g == null ? 0 : this.f4365g.hashCode()) + (((this.f4363e == null ? 0 : this.f4363e.hashCode()) + (super.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4364f != null) {
            i = this.f4364f.hashCode();
        }
        return hashCode + i;
    }

    public void initDiscounts(List<Discount> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4360b.clear();
        for (Discount discount : list) {
            this.f4360b.add(discount);
        }
    }

    public void initGroupbuys(List<Groupbuy> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Groupbuy groupbuy : list) {
            this.f4359a.add(groupbuy);
        }
    }

    public void setCinema(Cinema cinema) {
        this.f4363e = cinema;
    }

    public void setDeepType(DeepType deepType) {
        this.f4365g = deepType;
    }

    public void setDining(Dining dining) {
        this.f4361c = dining;
    }

    public void setHotel(Hotel hotel) {
        this.f4362d = hotel;
    }

    public void setScenic(Scenic scenic) {
        this.f4364f = scenic;
    }

    @Override // com.amap.api.services.core.PoiItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f4359a);
        parcel.writeList(this.f4360b);
    }
}
