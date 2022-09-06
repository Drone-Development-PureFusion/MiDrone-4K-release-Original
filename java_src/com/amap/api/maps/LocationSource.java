package com.amap.api.maps;

import android.location.Location;
/* loaded from: classes.dex */
public interface LocationSource {

    /* loaded from: classes.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
