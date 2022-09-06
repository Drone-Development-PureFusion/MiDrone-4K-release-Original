package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RegeocodeQuery {

    /* renamed from: a */
    private LatLonPoint f4270a;

    /* renamed from: b */
    private float f4271b;

    /* renamed from: c */
    private String f4272c = GeocodeSearch.AMAP;

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.f4270a = latLonPoint;
        this.f4271b = f;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
            if (this.f4272c == null) {
                if (regeocodeQuery.f4272c != null) {
                    return false;
                }
            } else if (!this.f4272c.equals(regeocodeQuery.f4272c)) {
                return false;
            }
            if (this.f4270a == null) {
                if (regeocodeQuery.f4270a != null) {
                    return false;
                }
            } else if (!this.f4270a.equals(regeocodeQuery.f4270a)) {
                return false;
            }
            return Float.floatToIntBits(this.f4271b) == Float.floatToIntBits(regeocodeQuery.f4271b);
        }
        return false;
    }

    public String getLatLonType() {
        return this.f4272c;
    }

    public LatLonPoint getPoint() {
        return this.f4270a;
    }

    public float getRadius() {
        return this.f4271b;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4272c == null ? 0 : this.f4272c.hashCode()) + 31) * 31;
        if (this.f4270a != null) {
            i = this.f4270a.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.f4271b);
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (!str.equals(GeocodeSearch.AMAP) && !str.equals(GeocodeSearch.GPS)) {
                return;
            }
            this.f4272c = str;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f4270a = latLonPoint;
    }

    public void setRadius(float f) {
        this.f4271b = f;
    }
}
