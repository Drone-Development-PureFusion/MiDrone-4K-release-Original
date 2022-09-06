package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMap;
import com.amap.api.maps.SupportMapFragment;
/* loaded from: classes.dex */
public class OfflineMapFragment extends SupportMapFragment {

    /* renamed from: a */
    private AMap f12804a;

    /* renamed from: a */
    private void m8795a() {
        if (this.f12804a == null) {
            this.f12804a = getMap();
        }
        if (this.f12804a != null) {
            AMap aMap = this.f12804a;
            AMap aMap2 = this.f12804a;
            aMap.setMapType(2);
            this.f12804a.getUiSettings().setZoomControlsEnabled(false);
            this.f12804a.getUiSettings().setCompassEnabled(false);
        }
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m8795a();
        return onCreateView;
    }
}
