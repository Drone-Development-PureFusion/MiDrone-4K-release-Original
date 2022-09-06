package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.C0942ee;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1007fo;
/* loaded from: classes.dex */
public final class CameraPosition implements Parcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private LatLng f3654a;

        /* renamed from: b */
        private float f3655b;

        /* renamed from: c */
        private float f3656c;

        /* renamed from: d */
        private float f3657d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public Builder bearing(float f) {
            this.f3657d = f;
            return this;
        }

        public CameraPosition build() {
            CameraPosition cameraPosition = null;
            try {
                if (this.f3654a == null) {
                    Log.w("CameraPosition", "target is null");
                } else {
                    cameraPosition = new CameraPosition(this.f3654a, this.f3655b, this.f3656c, this.f3657d);
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "CameraPosition", "build");
            }
            return cameraPosition;
        }

        public Builder target(LatLng latLng) {
            this.f3654a = latLng;
            return this;
        }

        public Builder tilt(float f) {
            this.f3656c = f;
            return this;
        }

        public Builder zoom(float f) {
            this.f3655b = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        boolean z = false;
        if (latLng == null) {
            Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null");
        }
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !C0942ee.m18374a(latLng.latitude, latLng.longitude) ? true : z;
        } else {
            this.isAbroad = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return C0945eh.m18322a(C0945eh.m18333a("target", this.target), C0945eh.m18333a("zoom", Float.valueOf(this.zoom)), C0945eh.m18333a("tilt", Float.valueOf(this.tilt)), C0945eh.m18333a("bearing", Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }
}
