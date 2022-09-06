package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Tile implements Parcelable {
    public static final C1145b CREATOR = new C1145b();

    /* renamed from: a */
    private final int f3803a;
    public final byte[] data;
    public final int height;
    public final int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.f3803a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3803a);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
    }
}
