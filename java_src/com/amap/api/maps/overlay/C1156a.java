package com.amap.api.maps.overlay;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.maps.overlay.a */
/* loaded from: classes.dex */
class C1156a {

    /* renamed from: a */
    public static int f3882a = 2048;

    /* renamed from: a */
    public static LatLng m17312a(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    /* renamed from: a */
    public static ArrayList<LatLng> m17311a(List<LatLonPoint> list) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        for (LatLonPoint latLonPoint : list) {
            arrayList.add(m17312a(latLonPoint));
        }
        return arrayList;
    }
}
