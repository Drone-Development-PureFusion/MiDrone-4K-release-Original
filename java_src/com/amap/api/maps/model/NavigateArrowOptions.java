package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import it.p235a.p236a.AbstractC4863e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public final class NavigateArrowOptions implements Parcelable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();

    /* renamed from: a */
    String f3746a;

    /* renamed from: c */
    private float f3748c = 10.0f;

    /* renamed from: d */
    private int f3749d = Color.argb((int) AbstractC4863e.f20781B, 87, 235, 204);

    /* renamed from: e */
    private int f3750e = Color.argb(170, 0, (int) Opcodes.IRETURN, 146);

    /* renamed from: f */
    private float f3751f = 0.0f;

    /* renamed from: g */
    private boolean f3752g = true;

    /* renamed from: b */
    private final List<LatLng> f3747b = new ArrayList();

    public NavigateArrowOptions add(LatLng latLng) {
        this.f3747b.add(latLng);
        return this;
    }

    public NavigateArrowOptions add(LatLng... latLngArr) {
        this.f3747b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f3747b.add(latLng);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.f3747b;
    }

    @Deprecated
    public int getSideColor() {
        return this.f3750e;
    }

    public int getTopColor() {
        return this.f3749d;
    }

    public float getWidth() {
        return this.f3748c;
    }

    public float getZIndex() {
        return this.f3751f;
    }

    public boolean isVisible() {
        return this.f3752g;
    }

    @Deprecated
    public NavigateArrowOptions sideColor(int i) {
        this.f3750e = i;
        return this;
    }

    public NavigateArrowOptions topColor(int i) {
        this.f3749d = i;
        return this;
    }

    public NavigateArrowOptions visible(boolean z) {
        this.f3752g = z;
        return this;
    }

    public NavigateArrowOptions width(float f) {
        this.f3748c = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3747b);
        parcel.writeFloat(this.f3748c);
        parcel.writeInt(this.f3749d);
        parcel.writeInt(this.f3750e);
        parcel.writeFloat(this.f3751f);
        parcel.writeByte((byte) (this.f3752g ? 1 : 0));
        parcel.writeString(this.f3746a);
    }

    public NavigateArrowOptions zIndex(float f) {
        this.f3751f = f;
        return this;
    }
}
