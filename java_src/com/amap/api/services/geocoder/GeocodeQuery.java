package com.amap.api.services.geocoder;
/* loaded from: classes.dex */
public class GeocodeQuery {

    /* renamed from: a */
    private String f4245a;

    /* renamed from: b */
    private String f4246b;

    public GeocodeQuery(String str, String str2) {
        this.f4245a = str;
        this.f4246b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
            if (this.f4246b == null) {
                if (geocodeQuery.f4246b != null) {
                    return false;
                }
            } else if (!this.f4246b.equals(geocodeQuery.f4246b)) {
                return false;
            }
            return this.f4245a == null ? geocodeQuery.f4245a == null : this.f4245a.equals(geocodeQuery.f4245a);
        }
        return false;
    }

    public String getCity() {
        return this.f4246b;
    }

    public String getLocationName() {
        return this.f4245a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4246b == null ? 0 : this.f4246b.hashCode()) + 31) * 31;
        if (this.f4245a != null) {
            i = this.f4245a.hashCode();
        }
        return hashCode + i;
    }

    public void setCity(String str) {
        this.f4246b = str;
    }

    public void setLocationName(String str) {
        this.f4245a = str;
    }
}
