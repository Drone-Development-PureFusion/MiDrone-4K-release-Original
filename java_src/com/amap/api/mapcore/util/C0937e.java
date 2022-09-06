package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource;
/* renamed from: com.amap.api.mapcore.util.e */
/* loaded from: classes.dex */
class C0937e implements LocationSource.OnLocationChangedListener {

    /* renamed from: a */
    Location f2879a;

    /* renamed from: b */
    private AbstractC1115l f2880b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0937e(AbstractC1115l abstractC1115l) {
        this.f2880b = abstractC1115l;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        this.f2879a = location;
        try {
            if (!this.f2880b.isMyLocationEnabled()) {
                return;
            }
            this.f2880b.mo17548a(location);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
