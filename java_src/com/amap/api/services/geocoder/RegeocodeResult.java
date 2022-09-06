package com.amap.api.services.geocoder;
/* loaded from: classes.dex */
public class RegeocodeResult {

    /* renamed from: a */
    private RegeocodeQuery f4273a;

    /* renamed from: b */
    private RegeocodeAddress f4274b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f4273a = regeocodeQuery;
        this.f4274b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f4274b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f4273a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f4274b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f4273a = regeocodeQuery;
    }
}
