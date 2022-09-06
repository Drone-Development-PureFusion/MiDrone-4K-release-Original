package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;
/* loaded from: classes.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_MARGIN_BOTTOM = 2;
    public static final int LOGO_MARGIN_LEFT = 0;
    public static final int LOGO_MARGIN_RIGHT = 1;
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;

    /* renamed from: h */
    private CameraPosition f3581h;

    /* renamed from: a */
    private int f3574a = 1;

    /* renamed from: b */
    private boolean f3575b = true;

    /* renamed from: c */
    private boolean f3576c = true;

    /* renamed from: d */
    private boolean f3577d = true;

    /* renamed from: e */
    private boolean f3578e = true;

    /* renamed from: f */
    private boolean f3579f = true;

    /* renamed from: g */
    private boolean f3580g = false;

    /* renamed from: i */
    private boolean f3582i = false;

    /* renamed from: j */
    private boolean f3583j = false;

    /* renamed from: k */
    private int f3584k = 0;

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f3581h = cameraPosition;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.f3582i = z;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.f3581h;
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.f3582i);
    }

    public int getLogoPosition() {
        return this.f3584k;
    }

    public int getMapType() {
        return this.f3574a;
    }

    public Boolean getRotateGesturesEnabled() {
        return Boolean.valueOf(this.f3575b);
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.f3583j);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.f3576c);
    }

    public Boolean getTiltGesturesEnabled() {
        return Boolean.valueOf(this.f3577d);
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.f3580g);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.f3579f);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.f3578e);
    }

    public AMapOptions logoPosition(int i) {
        this.f3584k = i;
        return this;
    }

    public AMapOptions mapType(int i) {
        this.f3574a = i;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z) {
        this.f3575b = z;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.f3583j = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.f3576c = z;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z) {
        this.f3577d = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3581h, i);
        parcel.writeInt(this.f3574a);
        parcel.writeBooleanArray(new boolean[]{this.f3575b, this.f3576c, this.f3577d, this.f3578e, this.f3579f, this.f3580g, this.f3582i, this.f3583j});
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.f3580g = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.f3579f = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.f3578e = z;
        return this;
    }
}
