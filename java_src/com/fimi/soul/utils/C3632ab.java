package com.fimi.soul.utils;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.ab */
/* loaded from: classes.dex */
public class C3632ab {

    /* renamed from: b */
    private static final double f14784b = 6372797.560856d;

    /* renamed from: a */
    public List<LatLng> f14785a;

    /* renamed from: a */
    public static LatLng m7733a(LatLng latLng, double d, double d2) {
        double d3 = latLng.latitude;
        double d4 = latLng.longitude;
        double radians = Math.toRadians(d3);
        double radians2 = Math.toRadians(d4);
        double radians3 = Math.toRadians(d);
        double d5 = d2 / f14784b;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new LatLng(Math.toDegrees(asin), Math.toDegrees(Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin))) + radians2));
    }

    /* renamed from: a */
    public static Double m7735a(double d) {
        return Double.valueOf(Math.toDegrees(d / 6378100.0d));
    }

    /* renamed from: a */
    public static Double m7732a(LatLng latLng, LatLng latLng2) {
        return Double.valueOf(Math.hypot(latLng.latitude - latLng2.latitude, latLng.longitude - latLng2.longitude));
    }

    /* renamed from: a */
    public static List<Polyline> m7734a(AMap aMap, ArrayList<LatLng> arrayList, int i) {
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < arrayList.size() - 1) {
            double m7727e = m7727e(arrayList.get(i2), arrayList.get(i2 + 1));
            if (m7727e >= 0.02d) {
                int i3 = (int) (m7727e / 0.02d);
                double d = (arrayList.get(i2 + 1).latitude - arrayList.get(i2).latitude) / i3;
                double d2 = (arrayList.get(i2 + 1).longitude - arrayList.get(i2).longitude) / i3;
                z = z2;
                LatLng latLng = new LatLng(arrayList.get(i2).latitude, arrayList.get(i2).longitude);
                int i4 = 0;
                while (i4 < i3) {
                    LatLng latLng2 = new LatLng(latLng.latitude + d, latLng.longitude + d2);
                    if (!z) {
                        arrayList2.add(aMap.addPolyline(new PolylineOptions().add(latLng).add(latLng2).color(i)));
                        z = true;
                    } else {
                        z = false;
                    }
                    i4++;
                    latLng = latLng2;
                }
            } else if (!z2) {
                arrayList2.add(aMap.addPolyline(new PolylineOptions().add(arrayList.get(i2)).add(arrayList.get(i2 + 1)).color(i)));
                z = true;
            } else {
                z = false;
            }
            i2++;
            z2 = z;
        }
        return arrayList2;
    }

    /* renamed from: b */
    public static double m7730b(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude - latLng2.latitude);
        double radians2 = Math.toRadians(latLng.longitude - latLng2.longitude);
        double sin = Math.sin(radians * 0.5d);
        double sin2 = Math.sin(radians2 * 0.5d);
        return Math.toDegrees(Math.asin(Math.sqrt((sin * sin) + (sin2 * sin2 * Math.cos(Math.toRadians(latLng.latitude)) * Math.cos(Math.toRadians(latLng2.latitude))))) * 2.0d);
    }

    /* renamed from: b */
    public static Double m7731b(double d) {
        return Double.valueOf(6378100.0d * Math.toRadians(d));
    }

    /* renamed from: c */
    public static C3640aj m7729c(LatLng latLng, LatLng latLng2) {
        return new C3640aj(f14784b * Math.toRadians(m7730b(latLng, latLng2)));
    }

    /* renamed from: d */
    public static double m7728d(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double degrees = Math.toDegrees(Math.atan2(Math.sin(radians4 - radians2) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4 - radians2))));
        return degrees >= 0.0d ? degrees : degrees + 360.0d;
    }

    /* renamed from: e */
    private static double m7727e(LatLng latLng, LatLng latLng2) {
        return new BigDecimal(m7729c(latLng, latLng2).m7698a()).setScale(3, RoundingMode.DOWN).doubleValue();
    }
}
