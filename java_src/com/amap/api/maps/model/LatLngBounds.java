package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.C0945eh;
/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();

    /* renamed from: a */
    private final int f3704a;

    /* renamed from: b */
    private boolean f3705b;
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private double f3706a = Double.POSITIVE_INFINITY;

        /* renamed from: b */
        private double f3707b = Double.NEGATIVE_INFINITY;

        /* renamed from: c */
        private double f3708c = Double.NaN;

        /* renamed from: d */
        private double f3709d = Double.NaN;

        /* renamed from: a */
        private boolean m17384a(double d) {
            boolean z = false;
            if (this.f3708c <= this.f3709d) {
                return this.f3708c <= d && d <= this.f3709d;
            }
            if (this.f3708c <= d || d <= this.f3709d) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            if (Double.isNaN(this.f3708c)) {
                Log.w("LatLngBounds", "no included points");
                return null;
            }
            return new LatLngBounds(new LatLng(this.f3706a, this.f3708c, false), new LatLng(this.f3707b, this.f3709d, false));
        }

        public Builder include(LatLng latLng) {
            if (latLng != null) {
                this.f3706a = Math.min(this.f3706a, latLng.latitude);
                this.f3707b = Math.max(this.f3707b, latLng.latitude);
                double d = latLng.longitude;
                if (Double.isNaN(this.f3708c)) {
                    this.f3708c = d;
                    this.f3709d = d;
                } else if (!m17384a(d)) {
                    if (LatLngBounds.m17386c(this.f3708c, d) < LatLngBounds.m17385d(this.f3709d, d)) {
                        this.f3708c = d;
                    } else {
                        this.f3709d = d;
                    }
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        this.f3705b = true;
        if (latLng == null) {
            Log.w("LatLngBounds", "null southwest");
            this.f3705b = false;
        }
        if (latLng2 == null) {
            Log.w("LatLngBounds", "null northeast");
            this.f3705b = false;
        }
        if (latLng2.latitude <= latLng.latitude) {
            Log.w("LatLngBounds", "southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
            this.f3705b = false;
        }
        this.f3704a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* renamed from: a */
    private boolean m17391a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: a */
    private boolean m17389a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        if (this.f3705b) {
            return Math.abs(((latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude) < ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude && Math.abs(((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude) < ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        }
        Log.w("LatLngBounds", "this LatLngBounds is invalid!");
        return false;
    }

    /* renamed from: b */
    private boolean m17388b(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        }
        if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            z = true;
        }
        return z;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static double m17386c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static double m17385d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m17392a() {
        return this.f3704a;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.f3705b) {
            return m17391a(latLng.latitude) && m17388b(latLng.longitude);
        }
        Log.w("LatLngBounds", "this LatLngBounds is invalid!");
        return false;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.f3705b) {
            return contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
        }
        Log.w("LatLngBounds", "this LatLngBounds is invalid!");
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!this.f3705b) {
            Log.w("LatLngBounds", "this LatLngBounds is invalid!");
            return false;
        } else if (this == obj) {
            return true;
        } else {
            if (!(obj instanceof LatLngBounds)) {
                return false;
            }
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
                z = false;
            }
            return z;
        }
    }

    public int hashCode() {
        return C0945eh.m18323a(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        double d;
        if (latLng == null) {
            return this;
        }
        if (!this.f3705b) {
            Log.w("LatLngBounds", "this LatLngBounds is invalid!");
            return null;
        }
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (m17388b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m17386c(d3, d4) < m17385d(d2, d4)) {
            d = d2;
        } else {
            d = d4;
            d4 = d3;
        }
        return new LatLngBounds(new LatLng(min, d4, false), new LatLng(max, d, false));
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.f3705b) {
            return m17389a(latLngBounds) || latLngBounds.m17389a(this);
        }
        Log.w("LatLngBounds", "this LatLngBounds is invalid!");
        return false;
    }

    public String toString() {
        return C0945eh.m18322a(C0945eh.m18333a("southwest", this.southwest), C0945eh.m18333a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.m17383a(this, parcel, i);
    }
}
