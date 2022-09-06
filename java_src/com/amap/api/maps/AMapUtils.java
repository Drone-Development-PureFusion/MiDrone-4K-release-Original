package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amap.api.mapcore.util.C0975ex;
import com.amap.api.mapcore.util.C0976ey;
import com.amap.api.mapcore.util.C0985fa;
import com.amap.api.mapcore.util.C0996fh;
import com.amap.api.mapcore.util.C1022g;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
/* loaded from: classes.dex */
public class AMapUtils {
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.maps.AMapUtils$a */
    /* loaded from: classes.dex */
    public static class C1136a extends Thread {

        /* renamed from: a */
        String f3585a;

        /* renamed from: b */
        Context f3586b;

        public C1136a(String str, Context context) {
            this.f3585a = "";
            this.f3585a = str;
            if (context != null) {
                this.f3586b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f3586b != null) {
                try {
                    C0985fa.m18155a(this.f3586b, new C0996fh.C0998a(this.f3585a, "4.1.2", C1022g.f3202d).m18060a(new String[]{"com.amap.api.maps"}).m18063a());
                    interrupt();
                } catch (C0975ex e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static String m17426a(NaviPara naviPara, Context context) {
        return String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d", C0976ey.m18170b(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    /* renamed from: a */
    private static String m17425a(PoiPara poiPara, Context context) {
        String format = String.format("androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0", C0976ey.m18170b(context), poiPara.getKeywords());
        return poiPara.getCenter() != null ? format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude : format;
    }

    /* renamed from: a */
    private static void m17423a(RoutePara routePara, Context context, int i) {
        String str;
        if (m17427a(context)) {
            if (!m17424a(routePara)) {
                throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(m17422b(routePara, context, i)));
                intent.setPackage("com.autonavi.minimap");
                new C1136a("oan", context).start();
                context.startActivity(intent);
                return;
            } finally {
                AMapException aMapException = new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        }
        throw new AMapException(str);
    }

    /* renamed from: a */
    private static boolean m17427a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.autonavi.minimap", 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m17424a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    /* renamed from: b */
    private static String m17422b(RoutePara routePara, Context context, int i) {
        String format = String.format("androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d", C0976ey.m18170b(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i));
        return i == 1 ? format + "&m=" + routePara.getTransitRouteStyle() : i == 2 ? format + "&m=" + routePara.getDrivingRouteStyle() : format;
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
        double d = (latLng2.longitude - latLng.longitude) / 360.0d;
        if (d < 0.0d) {
            d += 1.0d;
        }
        return (float) (d * 6378137.0d * 6.283185307179586d * 6378137.0d * sin);
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        double d = latLng.longitude;
        double d2 = d * 0.01745329251994329d;
        double d3 = latLng.latitude * 0.01745329251994329d;
        double d4 = latLng2.longitude * 0.01745329251994329d;
        double d5 = latLng2.latitude * 0.01745329251994329d;
        double sin = Math.sin(d2);
        double sin2 = Math.sin(d3);
        double cos = Math.cos(d2);
        double cos2 = Math.cos(d3);
        double sin3 = Math.sin(d4);
        double sin4 = Math.sin(d5);
        double cos3 = Math.cos(d4);
        double cos4 = Math.cos(d5);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double[] dArr2 = {cos4 * cos3, cos4 * sin3, sin4};
        return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new C1136a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) {
        m17423a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) {
        String str;
        if (m17427a(context)) {
            if (naviPara.getTargetPoint() == null) {
                throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(m17426a(naviPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new C1136a("oan", context).start();
                context.startActivity(intent);
                return;
            } finally {
                AMapException aMapException = new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        }
        throw new AMapException(str);
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) {
        String str;
        if (m17427a(context)) {
            if (poiPara.getKeywords() == null || poiPara.getKeywords().trim().length() <= 0) {
                throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(m17425a(poiPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new C1136a("oan", context).start();
                context.startActivity(intent);
                return;
            } finally {
                AMapException aMapException = new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        }
        throw new AMapException(str);
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) {
        m17423a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) {
        m17423a(routePara, context, 4);
    }
}
