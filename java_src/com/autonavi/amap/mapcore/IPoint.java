package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
public class IPoint implements Cloneable {

    /* renamed from: x */
    public int f4730x;

    /* renamed from: y */
    public int f4731y;

    public IPoint() {
    }

    public IPoint(int i, int i2) {
        this.f4730x = i;
        this.f4731y = i2;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
