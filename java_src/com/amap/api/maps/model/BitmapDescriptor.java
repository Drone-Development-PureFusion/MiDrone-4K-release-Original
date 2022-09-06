package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.C0945eh;
/* loaded from: classes.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a */
    int f3651a;

    /* renamed from: b */
    int f3652b;

    /* renamed from: c */
    Bitmap f3653c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap) {
        this.f3651a = 0;
        this.f3652b = 0;
        if (bitmap != null) {
            this.f3651a = bitmap.getWidth();
            this.f3652b = bitmap.getHeight();
            this.f3653c = m17415a(bitmap, C0945eh.m18360a(this.f3651a), C0945eh.m18360a(this.f3652b));
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.f3651a = 0;
        this.f3652b = 0;
        this.f3651a = i;
        this.f3652b = i2;
        this.f3653c = bitmap;
    }

    /* renamed from: a */
    private Bitmap m17415a(Bitmap bitmap, int i, int i2) {
        return C0945eh.m18354a(bitmap, i, i2);
    }

    /* renamed from: clone */
    public BitmapDescriptor m21706clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.f3653c), this.f3651a, this.f3652b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this.f3653c == null || this.f3653c.isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) obj;
        if (bitmapDescriptor.f3653c == null || bitmapDescriptor.f3653c.isRecycled() || this.f3651a != bitmapDescriptor.getWidth() || this.f3652b != bitmapDescriptor.getHeight()) {
            return false;
        }
        try {
            return this.f3653c.sameAs(bitmapDescriptor.f3653c);
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap getBitmap() {
        return this.f3653c;
    }

    public int getHeight() {
        return this.f3652b;
    }

    public int getWidth() {
        return this.f3651a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void recycle() {
        if (this.f3653c == null || this.f3653c.isRecycled()) {
            return;
        }
        this.f3653c.recycle();
        this.f3653c = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3653c, i);
        parcel.writeInt(this.f3651a);
        parcel.writeInt(this.f3652b);
    }
}
