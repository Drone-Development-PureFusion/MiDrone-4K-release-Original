package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: a */
    String f3711a;

    /* renamed from: f */
    float f3716f;

    /* renamed from: g */
    private LatLng f3717g;

    /* renamed from: h */
    private String f3718h;

    /* renamed from: i */
    private String f3719i;

    /* renamed from: v */
    private boolean f3732v;

    /* renamed from: j */
    private float f3720j = 0.5f;

    /* renamed from: k */
    private float f3721k = 1.0f;

    /* renamed from: l */
    private float f3722l = 0.0f;

    /* renamed from: m */
    private boolean f3723m = false;

    /* renamed from: n */
    private boolean f3724n = true;

    /* renamed from: o */
    private boolean f3725o = false;

    /* renamed from: p */
    private int f3726p = 0;

    /* renamed from: q */
    private int f3727q = 0;

    /* renamed from: r */
    private ArrayList<BitmapDescriptor> f3728r = new ArrayList<>();

    /* renamed from: s */
    private int f3729s = 20;

    /* renamed from: t */
    private boolean f3730t = false;

    /* renamed from: u */
    private boolean f3731u = false;

    /* renamed from: b */
    float f3712b = 1.0f;

    /* renamed from: c */
    boolean f3713c = false;

    /* renamed from: d */
    boolean f3714d = true;

    /* renamed from: e */
    int f3715e = 5;

    /* renamed from: a */
    private void m17382a() {
        if (this.f3728r == null) {
            this.f3728r = new ArrayList<>();
        }
    }

    public MarkerOptions alpha(float f) {
        this.f3712b = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f3720j = f;
        this.f3721k = f2;
        return this;
    }

    public MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.f3713c = z;
        return this;
    }

    public MarkerOptions belowMaskLayer(boolean z) {
        this.f3732v = z;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions displayLevel(int i) {
        this.f3715e = i;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f3723m = z;
        return this;
    }

    public float getAlpha() {
        return this.f3712b;
    }

    public float getAnchorU() {
        return this.f3720j;
    }

    public float getAnchorV() {
        return this.f3721k;
    }

    public int getDisplayLevel() {
        return this.f3715e;
    }

    public BitmapDescriptor getIcon() {
        if (this.f3728r == null || this.f3728r.size() == 0) {
            return null;
        }
        return this.f3728r.get(0);
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f3728r;
    }

    public int getInfoWindowOffsetX() {
        return this.f3726p;
    }

    public int getInfoWindowOffsetY() {
        return this.f3727q;
    }

    public int getPeriod() {
        return this.f3729s;
    }

    public LatLng getPosition() {
        return this.f3717g;
    }

    public float getRotateAngle() {
        return this.f3716f;
    }

    public String getSnippet() {
        return this.f3719i;
    }

    public String getTitle() {
        return this.f3718h;
    }

    public float getZIndex() {
        return this.f3722l;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        m17382a();
        this.f3728r.clear();
        this.f3728r.add(bitmapDescriptor);
        return this;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.f3728r = arrayList;
        return this;
    }

    public MarkerOptions infoWindowEnable(boolean z) {
        this.f3714d = z;
        return this;
    }

    public boolean isBelowMaskLayer() {
        return this.f3732v;
    }

    public boolean isDraggable() {
        return this.f3723m;
    }

    public boolean isFlat() {
        return this.f3731u;
    }

    public boolean isGps() {
        return this.f3730t;
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.f3713c;
    }

    public boolean isInfoWindowEnable() {
        return this.f3714d;
    }

    public boolean isPerspective() {
        return this.f3725o;
    }

    public boolean isVisible() {
        return this.f3724n;
    }

    public MarkerOptions period(int i) {
        if (i <= 1) {
            this.f3729s = 1;
        } else {
            this.f3729s = i;
        }
        return this;
    }

    public MarkerOptions perspective(boolean z) {
        this.f3725o = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f3717g = latLng;
        return this;
    }

    public MarkerOptions rotateAngle(float f) {
        this.f3716f = f;
        return this;
    }

    public MarkerOptions setFlat(boolean z) {
        this.f3731u = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.f3730t = z;
        return this;
    }

    public MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.f3726p = i;
        this.f3727q = i2;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f3719i = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f3718h = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f3724n = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3717g, i);
        parcel.writeString(this.f3718h);
        parcel.writeString(this.f3719i);
        parcel.writeFloat(this.f3720j);
        parcel.writeFloat(this.f3721k);
        parcel.writeInt(this.f3726p);
        parcel.writeInt(this.f3727q);
        parcel.writeBooleanArray(new boolean[]{this.f3724n, this.f3723m, this.f3730t, this.f3731u, this.f3713c, this.f3714d, this.f3732v});
        parcel.writeString(this.f3711a);
        parcel.writeInt(this.f3729s);
        parcel.writeList(this.f3728r);
        parcel.writeFloat(this.f3722l);
        parcel.writeFloat(this.f3712b);
        parcel.writeInt(this.f3715e);
        parcel.writeFloat(this.f3716f);
        if (this.f3728r == null || this.f3728r.size() == 0) {
            return;
        }
        parcel.writeParcelable(this.f3728r.get(0), i);
    }

    public MarkerOptions zIndex(float f) {
        this.f3722l = f;
        return this;
    }
}
