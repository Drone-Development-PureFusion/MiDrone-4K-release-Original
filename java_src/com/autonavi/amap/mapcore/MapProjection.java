package com.autonavi.amap.mapcore;

import android.graphics.Point;
/* loaded from: classes.dex */
public class MapProjection {
    private MapCore mMapCore;
    private boolean m_bNewInstance;
    long native_instance;

    public MapProjection(long j, MapCore mapCore) {
        this.native_instance = 0L;
        this.m_bNewInstance = false;
        this.mMapCore = mapCore;
        this.native_instance = j;
        this.m_bNewInstance = false;
    }

    public MapProjection(MapCore mapCore) {
        this.native_instance = 0L;
        this.m_bNewInstance = false;
        this.mMapCore = mapCore;
        long instanceHandle = mapCore.getInstanceHandle();
        if (instanceHandle != 0) {
            this.native_instance = nativeNewInstance(instanceHandle);
            this.m_bNewInstance = true;
        }
    }

    public static void geo2LonLat(int i, int i2, DPoint dPoint) {
        DPoint PixelsToLatLong = VirtualEarthProjection.PixelsToLatLong(i, i2, 20);
        dPoint.f4726x = PixelsToLatLong.f4726x;
        dPoint.f4727y = PixelsToLatLong.f4727y;
    }

    public static void lonlat2Geo(double d, double d2, IPoint iPoint) {
        Point LatLongToPixels = VirtualEarthProjection.LatLongToPixels(d2, d, 20);
        iPoint.f4730x = LatLongToPixels.x;
        iPoint.f4731y = LatLongToPixels.y;
    }

    private static native void nativeDestroy(long j);

    private static native void nativeGeo2LonLat(int i, int i2, DPoint dPoint);

    private static native void nativeGeo2Map(long j, int i, int i2, FPoint fPoint);

    private static native void nativeGetBound(long j, IPoint iPoint);

    private static native float nativeGetCameraHeaderAngle(long j);

    private static native void nativeGetCenterMap(long j, FPoint fPoint);

    private static native void nativeGetGeoCenter(long j, IPoint iPoint);

    private static native float nativeGetMapAngle(long j);

    private static native void nativeGetMapCenter(long j, FPoint fPoint);

    private static native float nativeGetMapLenWithGeo(long j, int i);

    private static native float nativeGetMapLenWithWin(long j, int i);

    private static native float nativeGetMapLenWithWinbyY(long j, int i, int i2);

    private static native float nativeGetMapZoomer(long j);

    private static native void nativeLonLat2Geo(double d, double d2, IPoint iPoint);

    private static native void nativeMap2Geo(long j, float f, float f2, IPoint iPoint);

    private static native void nativeMap2Win(long j, float f, float f2, IPoint iPoint);

    private static native long nativeNewInstance(long j);

    private static native void nativeRecalculate(long j);

    private static native void nativeSetCameraHeaderAngle(long j, float f);

    private static native void nativeSetCenterWithMap(long j, float f, float f2);

    private static native void nativeSetGeoCenter(long j, int i, int i2);

    private static native void nativeSetMapAngle(long j, float f);

    private static native void nativeSetMapCenter(long j, float f, float f2);

    private static native void nativeSetMapZoomer(long j, float f);

    private static native void nativeWin2Map(long j, int i, int i2, FPoint fPoint);

    public void geo2Map(int i, int i2, FPoint fPoint) {
        if (this.native_instance != 0) {
            nativeGeo2Map(this.native_instance, i, i2, fPoint);
        }
    }

    public void getBound(IPoint iPoint) {
        if (this.native_instance != 0) {
            nativeGetBound(this.native_instance, iPoint);
        }
    }

    public float getCameraHeaderAngle() {
        if (this.native_instance != 0) {
            return nativeGetCameraHeaderAngle(this.native_instance);
        }
        return 0.0f;
    }

    public void getCenterMap(FPoint fPoint) {
        if (this.native_instance != 0) {
            nativeGetCenterMap(this.native_instance, fPoint);
        }
    }

    public void getGeoCenter(IPoint iPoint) {
        if (this.native_instance != 0) {
            nativeGetGeoCenter(this.native_instance, iPoint);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getInstanceHandle() {
        return this.native_instance;
    }

    public void getLatLng2Pixel(double d, double d2, IPoint iPoint) {
        recalculate();
        IPoint iPoint2 = new IPoint();
        FPoint fPoint = new FPoint();
        lonlat2Geo(d2, d, iPoint2);
        geo2Map(iPoint2.f4730x, iPoint2.f4731y, fPoint);
        map2Win(fPoint.f4728x, fPoint.f4729y, iPoint);
    }

    public float getMapAngle() {
        if (this.native_instance != 0) {
            return nativeGetMapAngle(this.native_instance);
        }
        return 0.0f;
    }

    public void getMapCenter(FPoint fPoint) {
        if (this.native_instance != 0) {
            nativeGetMapCenter(this.native_instance, fPoint);
        }
    }

    public float getMapLenWithGeo(int i) {
        if (this.native_instance != 0) {
            return nativeGetMapLenWithGeo(this.native_instance, i);
        }
        return 0.0f;
    }

    public float getMapLenWithWin(int i) {
        if (this.native_instance != 0) {
            return nativeGetMapLenWithWin(this.native_instance, i);
        }
        return 0.0f;
    }

    public float getMapLenWithWinbyY(int i, int i2) {
        if (this.native_instance != 0) {
            return nativeGetMapLenWithWinbyY(this.native_instance, i, i2);
        }
        return 0.0f;
    }

    public float getMapZoomer() {
        if (this.native_instance != 0) {
            return nativeGetMapZoomer(this.native_instance);
        }
        return 0.0f;
    }

    public void map2Geo(float f, float f2, IPoint iPoint) {
        if (this.native_instance != 0) {
            nativeMap2Geo(this.native_instance, f, f2, iPoint);
        }
    }

    public void map2Win(float f, float f2, IPoint iPoint) {
        if (this.native_instance != 0) {
            nativeMap2Win(this.native_instance, f, f2, iPoint);
        }
    }

    public void recalculate() {
        if (this.native_instance != 0) {
            nativeRecalculate(this.native_instance);
        }
    }

    public void recycle() {
        if (this.m_bNewInstance) {
            nativeDestroy(this.native_instance);
        }
    }

    public void setCameraHeaderAngle(float f) {
        if (this.native_instance != 0) {
            nativeSetCameraHeaderAngle(this.native_instance, f);
        }
    }

    public void setCenterWithMap(float f, float f2) {
        if (this.native_instance != 0) {
            nativeSetCenterWithMap(this.native_instance, f, f2);
        }
    }

    public void setGeoCenter(int i, int i2) {
        if (this.native_instance != 0) {
            nativeSetGeoCenter(this.native_instance, i, i2);
        }
    }

    public void setMapAngle(float f) {
        if (this.native_instance != 0) {
            nativeSetMapAngle(this.native_instance, f);
        }
    }

    public void setMapCenter(float f, float f2) {
        if (this.native_instance != 0) {
            nativeSetMapCenter(this.native_instance, f, f2);
        }
    }

    public synchronized void setMapZoomer(float f) {
        if (this.mMapCore != null && this.mMapCore.mMap != null && this.mMapCore.mMap.getMapConfig() != null) {
            float limitZoomLevel = this.mMapCore.mMap.getMapConfig().getLimitZoomLevel();
            if (limitZoomLevel <= 0.0f || f >= limitZoomLevel) {
                limitZoomLevel = f;
            }
            if (this.mMapCore.mMap.getMapConfig().isSetLimitZoomLevel()) {
                f = this.mMapCore.mMap.getMapConfig().getMaxZoomLevel();
                float minZoomLevel = this.mMapCore.mMap.getMapConfig().getMinZoomLevel();
                if (limitZoomLevel <= f) {
                    if (limitZoomLevel < minZoomLevel) {
                        f = minZoomLevel;
                    }
                }
            }
            f = limitZoomLevel;
        }
        if (this.native_instance != 0) {
            nativeSetMapZoomer(this.native_instance, f);
        }
    }

    public void win2Map(int i, int i2, FPoint fPoint) {
        if (this.native_instance != 0) {
            nativeWin2Map(this.native_instance, i, i2, fPoint);
        }
    }
}
