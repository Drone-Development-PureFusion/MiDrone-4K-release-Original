package com.fimi.soul.utils;

import android.graphics.Point;
import com.amap.api.maps.AMap;
import com.amap.api.maps.Projection;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MapProjection extends SupportMapFragment {
    /* renamed from: a */
    public static List<LatLng> m7771a(List<Point> list, AMap aMap) {
        ArrayList arrayList = new ArrayList();
        Projection projection = aMap.getProjection();
        for (Point point : list) {
            arrayList.add(projection.fromScreenLocation(point));
        }
        return arrayList;
    }
}
