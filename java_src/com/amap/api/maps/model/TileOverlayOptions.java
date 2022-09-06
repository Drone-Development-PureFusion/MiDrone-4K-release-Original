package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();

    /* renamed from: a */
    private final int f3805a;

    /* renamed from: b */
    private TileProvider f3806b;

    /* renamed from: c */
    private boolean f3807c;

    /* renamed from: d */
    private float f3808d;

    /* renamed from: e */
    private int f3809e;

    /* renamed from: f */
    private int f3810f;

    /* renamed from: g */
    private String f3811g;

    /* renamed from: h */
    private boolean f3812h;

    /* renamed from: i */
    private boolean f3813i;

    public TileOverlayOptions() {
        this.f3807c = true;
        this.f3809e = 5242880;
        this.f3810f = 20971520;
        this.f3811g = null;
        this.f3812h = true;
        this.f3813i = true;
        this.f3805a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.f3807c = true;
        this.f3809e = 5242880;
        this.f3810f = 20971520;
        this.f3811g = null;
        this.f3812h = true;
        this.f3813i = true;
        this.f3805a = i;
        this.f3807c = z;
        this.f3808d = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.f3811g = str;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.f3813i = z;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i) {
        this.f3810f = i * 1024;
        return this;
    }

    public String getDiskCacheDir() {
        return this.f3811g;
    }

    public boolean getDiskCacheEnabled() {
        return this.f3813i;
    }

    public int getDiskCacheSize() {
        return this.f3810f;
    }

    public int getMemCacheSize() {
        return this.f3809e;
    }

    public boolean getMemoryCacheEnabled() {
        return this.f3812h;
    }

    public TileProvider getTileProvider() {
        return this.f3806b;
    }

    public float getZIndex() {
        return this.f3808d;
    }

    public boolean isVisible() {
        return this.f3807c;
    }

    public TileOverlayOptions memCacheSize(int i) {
        this.f3809e = i;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.f3812h = z;
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f3806b = tileProvider;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f3807c = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f3805a);
        parcel.writeValue(this.f3806b);
        parcel.writeByte((byte) (this.f3807c ? 1 : 0));
        parcel.writeFloat(this.f3808d);
        parcel.writeInt(this.f3809e);
        parcel.writeInt(this.f3810f);
        parcel.writeString(this.f3811g);
        parcel.writeByte((byte) (this.f3812h ? 1 : 0));
        if (!this.f3813i) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public TileOverlayOptions zIndex(float f) {
        this.f3808d = f;
        return this;
    }
}
