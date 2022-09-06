package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
/* loaded from: classes.dex */
public final class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();

    /* renamed from: a */
    String f3790a;

    /* renamed from: b */
    private LatLng f3791b;

    /* renamed from: c */
    private String f3792c;

    /* renamed from: e */
    private float f3794e;

    /* renamed from: j */
    private Object f3799j;

    /* renamed from: d */
    private Typeface f3793d = Typeface.DEFAULT;

    /* renamed from: f */
    private int f3795f = 4;

    /* renamed from: g */
    private int f3796g = 32;

    /* renamed from: h */
    private int f3797h = -1;

    /* renamed from: i */
    private int f3798i = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: k */
    private int f3800k = 20;

    /* renamed from: l */
    private float f3801l = 0.0f;

    /* renamed from: m */
    private boolean f3802m = true;

    public TextOptions align(int i, int i2) {
        this.f3795f = i;
        this.f3796g = i2;
        return this;
    }

    public TextOptions backgroundColor(int i) {
        this.f3797h = i;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextOptions fontColor(int i) {
        this.f3798i = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.f3800k = i;
        return this;
    }

    public int getAlignX() {
        return this.f3795f;
    }

    public int getAlignY() {
        return this.f3796g;
    }

    public int getBackgroundColor() {
        return this.f3797h;
    }

    public int getFontColor() {
        return this.f3798i;
    }

    public int getFontSize() {
        return this.f3800k;
    }

    public Object getObject() {
        return this.f3799j;
    }

    public LatLng getPosition() {
        return this.f3791b;
    }

    public float getRotate() {
        return this.f3794e;
    }

    public String getText() {
        return this.f3792c;
    }

    public Typeface getTypeface() {
        return this.f3793d;
    }

    public float getZIndex() {
        return this.f3801l;
    }

    public boolean isVisible() {
        return this.f3802m;
    }

    public TextOptions position(LatLng latLng) {
        this.f3791b = latLng;
        return this;
    }

    public TextOptions rotate(float f) {
        this.f3794e = f;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.f3799j = obj;
        return this;
    }

    public TextOptions text(String str) {
        this.f3792c = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.f3793d = typeface;
        }
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f3802m = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3790a);
        Bundle bundle = new Bundle();
        if (this.f3791b != null) {
            bundle.putDouble("lat", this.f3791b.latitude);
            bundle.putDouble("lng", this.f3791b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.f3792c);
        parcel.writeInt(this.f3793d.getStyle());
        parcel.writeFloat(this.f3794e);
        parcel.writeInt(this.f3795f);
        parcel.writeInt(this.f3796g);
        parcel.writeInt(this.f3797h);
        parcel.writeInt(this.f3798i);
        parcel.writeInt(this.f3800k);
        parcel.writeFloat(this.f3801l);
        parcel.writeByte((byte) (this.f3802m ? 1 : 0));
        if (this.f3799j instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.f3799j);
            parcel.writeBundle(bundle2);
        }
    }

    public TextOptions zIndex(float f) {
        this.f3801l = f;
        return this;
    }
}
