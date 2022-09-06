package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    /* renamed from: a */
    String f3767a;

    /* renamed from: g */
    private BitmapDescriptor f3773g;

    /* renamed from: h */
    private List<BitmapDescriptor> f3774h;

    /* renamed from: i */
    private List<Integer> f3775i;

    /* renamed from: j */
    private List<Integer> f3776j;

    /* renamed from: c */
    private float f3769c = 10.0f;

    /* renamed from: d */
    private int f3770d = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: e */
    private float f3771e = 0.0f;

    /* renamed from: f */
    private boolean f3772f = true;

    /* renamed from: k */
    private boolean f3777k = true;

    /* renamed from: l */
    private boolean f3778l = false;

    /* renamed from: m */
    private boolean f3779m = false;

    /* renamed from: n */
    private boolean f3780n = false;

    /* renamed from: o */
    private float f3781o = 1.0f;

    /* renamed from: p */
    private boolean f3782p = false;

    /* renamed from: b */
    private final List<LatLng> f3768b = new ArrayList();

    public PolylineOptions aboveMaskLayer(boolean z) {
        this.f3782p = z;
        return this;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f3768b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f3768b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f3768b.add(latLng);
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.f3770d = i;
        return this;
    }

    public PolylineOptions colorValues(List<Integer> list) {
        this.f3775i = list;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f3778l = z;
        return this;
    }

    public int getColor() {
        return this.f3770d;
    }

    public List<Integer> getColorValues() {
        return this.f3775i;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f3773g;
    }

    public List<Integer> getCustomTextureIndex() {
        return this.f3776j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.f3774h;
    }

    public List<LatLng> getPoints() {
        return this.f3768b;
    }

    public float getTransparency() {
        return this.f3781o;
    }

    public float getWidth() {
        return this.f3769c;
    }

    public float getZIndex() {
        return this.f3771e;
    }

    public boolean isAboveMaskLayer() {
        return this.f3782p;
    }

    public boolean isDottedLine() {
        return this.f3779m;
    }

    public boolean isGeodesic() {
        return this.f3778l;
    }

    public boolean isUseGradient() {
        return this.f3780n;
    }

    public boolean isUseTexture() {
        return this.f3777k;
    }

    public boolean isVisible() {
        return this.f3772f;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.f3773g = bitmapDescriptor;
        return this;
    }

    public PolylineOptions setCustomTextureIndex(List<Integer> list) {
        this.f3776j = list;
        return this;
    }

    public PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.f3774h = list;
        return this;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.f3779m = z;
        return this;
    }

    public void setPoints(List<LatLng> list) {
        if (list == null || this.f3768b.hashCode() == list.hashCode()) {
            return;
        }
        this.f3768b.clear();
        this.f3768b.addAll(list);
    }

    public PolylineOptions setUseTexture(boolean z) {
        this.f3777k = z;
        return this;
    }

    public PolylineOptions transparency(float f) {
        this.f3781o = f;
        return this;
    }

    public PolylineOptions useGradient(boolean z) {
        this.f3780n = z;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f3772f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.f3769c = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3768b);
        parcel.writeFloat(this.f3769c);
        parcel.writeInt(this.f3770d);
        parcel.writeFloat(this.f3771e);
        parcel.writeFloat(this.f3781o);
        parcel.writeString(this.f3767a);
        parcel.writeBooleanArray(new boolean[]{this.f3772f, this.f3779m, this.f3778l, this.f3780n, this.f3782p});
        if (this.f3773g != null) {
            parcel.writeParcelable(this.f3773g, i);
        }
        if (this.f3774h != null) {
            parcel.writeList(this.f3774h);
        }
        if (this.f3776j != null) {
            parcel.writeList(this.f3776j);
        }
        if (this.f3775i != null) {
            parcel.writeList(this.f3775i);
        }
    }

    public PolylineOptions zIndex(float f) {
        this.f3771e = f;
        return this;
    }
}
