package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
/* loaded from: classes.dex */
public final class GroundOverlayOptions implements Parcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: a */
    private final int f3676a;

    /* renamed from: b */
    private BitmapDescriptor f3677b;

    /* renamed from: c */
    private LatLng f3678c;

    /* renamed from: d */
    private float f3679d;

    /* renamed from: e */
    private float f3680e;

    /* renamed from: f */
    private LatLngBounds f3681f;

    /* renamed from: g */
    private float f3682g;

    /* renamed from: h */
    private float f3683h;

    /* renamed from: i */
    private boolean f3684i;

    /* renamed from: j */
    private float f3685j;

    /* renamed from: k */
    private float f3686k;

    /* renamed from: l */
    private float f3687l;

    public GroundOverlayOptions() {
        this.f3683h = 0.0f;
        this.f3684i = true;
        this.f3685j = 0.0f;
        this.f3686k = 0.5f;
        this.f3687l = 0.5f;
        this.f3676a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f3683h = 0.0f;
        this.f3684i = true;
        this.f3685j = 0.0f;
        this.f3686k = 0.5f;
        this.f3687l = 0.5f;
        this.f3676a = i;
        this.f3677b = BitmapDescriptorFactory.fromBitmap(null);
        this.f3678c = latLng;
        this.f3679d = f;
        this.f3680e = f2;
        this.f3681f = latLngBounds;
        this.f3682g = f3;
        this.f3683h = f4;
        this.f3684i = z;
        this.f3685j = f5;
        this.f3686k = f6;
        this.f3687l = f7;
    }

    /* renamed from: a */
    private GroundOverlayOptions m17409a(LatLng latLng, float f, float f2) {
        this.f3678c = latLng;
        this.f3679d = f;
        this.f3680e = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f3686k = f;
        this.f3687l = f2;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f3682g = f;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f3686k;
    }

    public float getAnchorV() {
        return this.f3687l;
    }

    public float getBearing() {
        return this.f3682g;
    }

    public LatLngBounds getBounds() {
        return this.f3681f;
    }

    public float getHeight() {
        return this.f3680e;
    }

    public BitmapDescriptor getImage() {
        return this.f3677b;
    }

    public LatLng getLocation() {
        return this.f3678c;
    }

    public float getTransparency() {
        return this.f3685j;
    }

    public float getWidth() {
        return this.f3679d;
    }

    public float getZIndex() {
        return this.f3683h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f3677b = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.f3684i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        if (this.f3681f != null) {
            Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w("GroundOverlayOptions", "Location must be specified");
        }
        if (f <= 0.0f) {
            Log.w("GroundOverlayOptions", "Width must be non-negative");
        }
        return m17409a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        if (this.f3681f != null) {
            Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w("GroundOverlayOptions", "Location must be specified");
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w("GroundOverlayOptions", "Width and Height must be non-negative");
        }
        return m17409a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (this.f3678c != null) {
            Log.w("GroundOverlayOptions", "Position has already been set using position: " + this.f3678c);
        }
        this.f3681f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f < 0.0f) {
            Log.w("GroundOverlayOptions", "Transparency must be in the range [0..1]");
            f = 0.0f;
        }
        this.f3685j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f3684i = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3676a);
        parcel.writeParcelable(this.f3677b, i);
        parcel.writeParcelable(this.f3678c, i);
        parcel.writeFloat(this.f3679d);
        parcel.writeFloat(this.f3680e);
        parcel.writeParcelable(this.f3681f, i);
        parcel.writeFloat(this.f3682g);
        parcel.writeFloat(this.f3683h);
        parcel.writeByte((byte) (this.f3684i ? 1 : 0));
        parcel.writeFloat(this.f3685j);
        parcel.writeFloat(this.f3686k);
        parcel.writeFloat(this.f3687l);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f3683h = f;
        return this;
    }
}
