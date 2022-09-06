package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
public class FPoint {

    /* renamed from: x */
    public float f4728x;

    /* renamed from: y */
    public float f4729y;

    public FPoint() {
    }

    public FPoint(float f, float f2) {
        this.f4728x = f;
        this.f4729y = f2;
    }

    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        return fPoint != null && this.f4728x == fPoint.f4728x && this.f4729y == fPoint.f4729y;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.f4728x) * 37;
        return Float.floatToIntBits(this.f4729y) * 37;
    }
}
