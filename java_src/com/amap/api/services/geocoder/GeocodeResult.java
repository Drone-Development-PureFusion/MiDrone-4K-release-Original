package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GeocodeResult {

    /* renamed from: a */
    private GeocodeQuery f4247a;

    /* renamed from: b */
    private List<GeocodeAddress> f4248b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        this.f4248b = new ArrayList();
        this.f4247a = geocodeQuery;
        this.f4248b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f4248b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f4247a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f4248b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f4247a = geocodeQuery;
    }
}
