package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.ew */
/* loaded from: classes.dex */
public class C0974ew {
    /* renamed from: a */
    private static double m18177a(TraceLocation traceLocation, TraceLocation traceLocation2, TraceLocation traceLocation3) {
        double longitude;
        double latitude;
        double longitude2 = traceLocation.getLongitude() - traceLocation2.getLongitude();
        double latitude2 = traceLocation.getLatitude() - traceLocation2.getLatitude();
        double longitude3 = traceLocation3.getLongitude() - traceLocation2.getLongitude();
        double latitude3 = traceLocation3.getLatitude() - traceLocation2.getLatitude();
        double d = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        if (d < 0.0d || (traceLocation2.getLongitude() == traceLocation3.getLongitude() && traceLocation2.getLatitude() == traceLocation3.getLatitude())) {
            longitude = traceLocation2.getLongitude();
            latitude = traceLocation2.getLatitude();
        } else if (d > 1.0d) {
            longitude = traceLocation3.getLongitude();
            latitude = traceLocation3.getLatitude();
        } else {
            longitude = traceLocation2.getLongitude() + (longitude3 * d);
            latitude = (d * latitude3) + traceLocation2.getLatitude();
        }
        return AMapUtils.calculateLineDistance(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()), new LatLng(latitude, longitude));
    }

    /* renamed from: a */
    public static List<TraceLocation> m18176a(List<TraceLocation> list, float f) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d = 0.0d;
        ArrayList arrayList = new ArrayList();
        TraceLocation traceLocation = list.get(0);
        TraceLocation traceLocation2 = list.get(list.size() - 1);
        int i = 0;
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            double m18177a = m18177a(list.get(i2), traceLocation, traceLocation2);
            if (m18177a > d) {
                i = i2;
                d = m18177a;
            }
        }
        if (d < f) {
            arrayList.add(traceLocation);
            arrayList.add(traceLocation2);
            return arrayList;
        }
        List<TraceLocation> m18176a = m18176a(list.subList(0, i + 1), f);
        List<TraceLocation> m18176a2 = m18176a(list.subList(i, list.size()), f);
        arrayList.addAll(m18176a);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(m18176a2);
        return arrayList;
    }
}
