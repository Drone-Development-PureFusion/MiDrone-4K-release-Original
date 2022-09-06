package com.autonavi.amap.mapcore;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    /* loaded from: classes.dex */
    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d) {
            boolean z = false;
            if (this.mWest <= this.mEast) {
                return ((double) this.mWest) <= d && d <= ((double) this.mEast);
            }
            if (this.mWest <= d || d <= this.mEast) {
                z = true;
            }
            return z;
        }

        public FPointBounds build() {
            return new FPointBounds(new FPoint(this.mWest, this.mSouth), new FPoint(this.mEast, this.mNorth));
        }

        public Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, fPoint.f4729y);
            this.mNorth = Math.max(this.mNorth, fPoint.f4729y);
            this.mWest = Math.min(this.mWest, fPoint.f4728x);
            this.mEast = Math.max(this.mEast, fPoint.f4728x);
            return this;
        }
    }

    FPointBounds(int i, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d) {
        boolean z = false;
        if (this.southwest.f4728x <= this.northeast.f4728x) {
            return ((double) this.southwest.f4728x) <= d && d <= ((double) this.northeast.f4728x);
        }
        if (this.southwest.f4728x <= d || d <= this.northeast.f4728x) {
            z = true;
        }
        return z;
    }

    private boolean containsy(double d) {
        return ((double) this.southwest.f4729y) <= d && d <= ((double) this.northeast.f4729y);
    }

    private boolean intersect(FPointBounds fPointBounds) {
        if (fPointBounds == null || fPointBounds.northeast == null || fPointBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        return Math.abs((double) (((fPointBounds.northeast.f4728x + fPointBounds.southwest.f4728x) - this.northeast.f4728x) - this.southwest.f4728x)) < ((double) (((this.northeast.f4728x - this.southwest.f4728x) + fPointBounds.northeast.f4728x) - this.southwest.f4728x)) && Math.abs((double) (((fPointBounds.northeast.f4729y + fPointBounds.southwest.f4729y) - this.northeast.f4729y) - this.southwest.f4729y)) < ((double) (((this.northeast.f4729y - this.southwest.f4729y) + fPointBounds.northeast.f4729y) - fPointBounds.southwest.f4729y));
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) fPoint.f4729y) && containsx((double) fPoint.f4728x);
    }

    public boolean contains(FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FPointBounds)) {
            return false;
        }
        FPointBounds fPointBounds = (FPointBounds) obj;
        return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public String toString() {
        return "southwest = (" + this.southwest.f4728x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.southwest.f4729y + ") northeast = (" + this.northeast.f4728x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.northeast.f4729y + ")";
    }
}
