package com.autonavi.amap.mapcore;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C0761aa;
import com.amap.api.mapcore.util.C0762ab;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Poi;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class MapCore {
    public static final int AM_DATA_BMP_BASEMAP = 2;
    public static final int AM_DATA_GEO_BUILDING = 1;
    public static final int AM_DATA_GUIDE = 11;
    public static final int AM_DATA_INDOOR = 10;
    public static final int AM_DATA_MODEL = 6;
    public static final int AM_DATA_POI = 8;
    public static final int AM_DATA_ROADMAP = 0;
    public static final int AM_DATA_SATELLITE = 3;
    public static final int AM_DATA_SCENIC_WIDGET = 101;
    public static final int AM_DATA_SCREEN = 5;
    public static final int AM_DATA_STANDARD = 7;
    public static final int AM_DATA_VEC_TMC = 4;
    public static final int AM_DATA_VERSION = 9;
    public static final int MAPRENDER_BASEMAPBEGIN = 1;
    public static final int MAPRENDER_BUILDINGBEGIN = 2;
    public static final int MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER = 999;
    public static final int MAPRENDER_ENTER = 0;
    public static final int MAPRENDER_GRID_CAN_FILL = 11;
    public static final int MAPRENDER_LABELSBEGIN = 3;
    public static final int MAPRENDER_LABELSEND = 4;
    public static final int MAPRENDER_NOMORENEEDRENDER = 6;
    public static final int MAPRENDER_ORTHOPROJECTION = 7;
    public static final int MAPRENDER_RENDEROVER = 5;
    public static final int TEXTURE_BACKGROUND = 1;
    public static final int TEXTURE_ICON = 0;
    public static final int TEXTURE_RAILWAY = 8;
    public static final int TEXTURE_ROADARROW = 2;
    public static final int TEXTURE_ROADROUND = 3;
    public static final int TEXTURE_TMC_BLACK = 7;
    public static final int TEXTURE_TMC_GREEN = 6;
    public static final int TEXTURE_TMC_RED = 4;
    public static final int TEXTURE_TMC_YELLOW = 5;
    Context mContext;
    IAMap mMap;
    byte[] tmp_3072bytes_data;
    private IMapCallback mMapcallback = null;
    private TextTextureGenerator textTextureGenerator = null;
    private CopyOnWriteArrayList<MapMessage> mStateMessageList = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<MapMessage> mGestureMessageList = new CopyOnWriteArrayList<>();
    long native_instance = 0;
    long native_mapprojection_instance = 0;
    private C0762ab map_anims_mgr = null;
    private int surface_height = 0;
    private int surface_width = 0;
    GL10 mGL = null;
    private int browserCount = 0;
    private int map_gesture_count = 0;
    boolean isMoveCameraStep = false;
    boolean isAnimationStep = false;
    boolean isGestureStep = false;

    static {
        try {
            System.loadLibrary("gdinamapv4sdk752");
            System.loadLibrary("gdinamapv4sdk752ex");
        } catch (Throwable th) {
        }
    }

    public MapCore(Context context, IAMap iAMap) {
        this.mMap = null;
        this.mContext = context;
        this.mMap = iAMap;
        MapTilsCacheAndResManager.getInstance(context).checkDir();
    }

    private byte[] OnMapCharsWidthsRequired(int[] iArr, int i, int i2) {
        if (this.mMapcallback != null) {
            return this.mMapcallback.OnMapCharsWidthsRequired(this, iArr, i, i2);
        }
        return null;
    }

    private void OnMapDestory() {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapDestory(this.mGL, this);
        }
    }

    private void OnMapProcessEvent() {
        if (this.map_anims_mgr.m19112b() > 0) {
            MapProjection mapstate = getMapstate();
            mapstate.recalculate();
            this.map_anims_mgr.m19113a(mapstate);
            setMapstate(mapstate);
            mapstate.recycle();
            this.isAnimationStep = true;
        } else if (this.isAnimationStep) {
            this.isAnimationStep = false;
            if (this.mGestureMessageList.size() <= 0) {
                this.mMap.onChangeFinish();
            }
        }
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapProcessEvent(this);
        }
    }

    private synchronized void OnMapReferencechanged(String str, String str2) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapReferencechanged(this, str, str2);
        }
    }

    private void OnMapSufaceChanged(int i, int i2) {
        this.surface_width = i;
        this.surface_height = i2;
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSufaceChanged(this.mGL, this, i, i2);
        }
    }

    private void OnMapSurfaceCreate() {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSurfaceCreate(this.mGL, this);
        }
    }

    private void OnMapSurfaceRenderer(int i) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSurfaceRenderer(this.mGL, this, i);
        }
    }

    private void gestureBegin() {
        this.map_gesture_count++;
    }

    private void gestureEnd() {
        this.map_gesture_count--;
    }

    private static native void nativeAddPoiFilter(long j, int i, int i2, int i3, float f, float f2, String str);

    private static native boolean nativeCanStopRenderMap(long j);

    private static native void nativeChangeMapEnv(long j, String str);

    private static native void nativeClearPoiFilter(long j);

    private static native void nativeDestroy(long j, MapCore mapCore);

    private static native int nativeGetMapStateInstance(long j);

    private static native long nativeGetMapstate(long j);

    private static native void nativeGetScreenGrids(long j, byte[] bArr, int i);

    private static native int nativeGetSelectedMapPois(long j, int i, int i2, int i3, byte[] bArr);

    private static native long nativeNewInstance(String str, String str2);

    private static native void nativePutCharbitmap(long j, int i, byte[] bArr);

    private static native int nativePutMapdata(long j, int i, byte[] bArr);

    private static native int nativePutMapdata(long j, int i, byte[] bArr, int i2);

    private static native void nativeRemovePoiFilter(long j, String str);

    private static native int nativeSelectMapPois(long j, int i, int i2, int i3, byte[] bArr);

    private static native void nativeSetCityBound(long j, byte[] bArr);

    private static native void nativeSetIndoorBuildingToBeActive(long j, String str, int i, String str2);

    private static native void nativeSetInternalTexture(long j, byte[] bArr, int i);

    private static native void nativeSetInternaltexture(long j, byte[] bArr, int i);

    private static native void nativeSetMapstate(long j, long j2);

    private static native void nativeSetParmater(long j, int i, int i2, int i3, int i4, int i5);

    private static native void nativeSetStyleData(long j, byte[] bArr, int i, int i2);

    private static native void nativeSetparameter(long j, int i, int i2, int i3, int i4, int i5);

    private static native void nativeSurfaceChange(long j, MapCore mapCore, int i, int i2);

    private static native void nativeSurfaceCreate(long j, MapCore mapCore);

    private static native void nativeSurfaceRenderMap(long j, MapCore mapCore);

    private void processGestureMessage() {
        MapMessage remove;
        if (this.mGestureMessageList.size() <= 0) {
            if (!this.isGestureStep) {
                return;
            }
            this.isGestureStep = false;
            if (this.map_anims_mgr.m19112b() > 0) {
                return;
            }
            this.mMap.onChangeFinish();
            return;
        }
        this.isGestureStep = true;
        MapProjection mapstate = getMapstate();
        if (mapstate == null) {
            return;
        }
        mapstate.recalculate();
        while (this.mGestureMessageList.size() > 0 && (remove = this.mGestureMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.surface_width;
            }
            if (remove.height == 0) {
                remove.height = this.surface_height;
            }
            int mapGestureState = remove.getMapGestureState();
            if (mapGestureState == 100) {
                gestureBegin();
            } else if (mapGestureState == 101) {
                remove.runCameraUpdate(mapstate);
            } else if (mapGestureState == 102) {
                gestureEnd();
            }
        }
        setMapstate(mapstate);
        mapstate.recycle();
    }

    private void processMessage() {
        try {
            processGestureMessage();
            if (this.mGestureMessageList.size() <= 0) {
                processStateMapMessage();
            } else if (this.mStateMessageList.size() > 0) {
                this.mStateMessageList.clear();
            }
        } catch (Exception e) {
        }
    }

    private void processStateMapMessage() {
        MapMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (!this.isMoveCameraStep) {
                return;
            }
            this.isMoveCameraStep = false;
            this.mMap.onChangeFinish();
            return;
        }
        this.isMoveCameraStep = true;
        MapProjection mapstate = getMapstate();
        if (mapstate == null) {
            return;
        }
        while (this.mStateMessageList.size() > 0 && (remove = this.mStateMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.surface_width;
            }
            if (remove.height == 0) {
                remove.height = this.surface_height;
            }
            mapstate.recalculate();
            remove.runCameraUpdate(mapstate);
        }
        setMapstate(mapstate);
        mapstate.recycle();
    }

    public void OnMapDataRequired(int i, String[] strArr) {
        if (this.mMapcallback != null) {
            try {
                this.mMapcallback.OnMapDataRequired(this, i, strArr);
            } catch (Throwable th) {
            }
        }
    }

    public void OnMapLabelsRequired(int[] iArr, int i) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapLabelsRequired(this, iArr, i);
        }
    }

    public synchronized void addGestureMessage(MapMessage mapMessage) {
        if (mapMessage != null) {
            this.mGestureMessageList.add(mapMessage);
        }
    }

    public boolean addMapAnimation(ADGLAnimation aDGLAnimation) {
        if (this.map_anims_mgr == null || aDGLAnimation == null || !aDGLAnimation.isValid()) {
            return false;
        }
        this.map_anims_mgr.m19114a(aDGLAnimation);
        return true;
    }

    public synchronized void addMessage(MapMessage mapMessage) {
        if (mapMessage != null) {
            this.mStateMessageList.add(mapMessage);
        }
    }

    public boolean canStopRenderMap() {
        if (this.native_instance != 0) {
            return nativeCanStopRenderMap(this.native_instance);
        }
        return false;
    }

    public synchronized void clearAllGestureMessage() {
        this.mGestureMessageList.clear();
        this.map_gesture_count = 0;
    }

    public synchronized void clearAllMessages() {
        clearAllGestureMessage();
        this.mStateMessageList.clear();
    }

    public synchronized void clearAnimations() {
        this.map_anims_mgr.m19115a();
    }

    public void destroy() {
        if (this.native_instance != 0) {
            nativeDestroy(this.native_instance, this);
            this.native_instance = 0L;
            this.textTextureGenerator = null;
            this.tmp_3072bytes_data = null;
        }
    }

    public void drawFrame(GL10 gl10) {
        if (this.native_instance != 0) {
            processMessage();
            nativeSurfaceRenderMap(this.native_instance, this);
        }
    }

    public void fillCurGridListWithDataType(ArrayList<MapSourceGridData> arrayList, int i) {
        if (this.native_instance != 0) {
            nativeGetScreenGrids(this.native_instance, this.tmp_3072bytes_data, i);
            byte b = this.tmp_3072bytes_data[0];
            if (b <= 0 || b > 100 || arrayList == null) {
                return;
            }
            arrayList.clear();
            int i2 = 0;
            int i3 = 1;
            while (i2 < b && i3 < 3072) {
                int i4 = i3 + 1;
                byte b2 = this.tmp_3072bytes_data[i3];
                if (b2 > 0 && b2 <= 20 && i4 + b2 <= 3072) {
                    String str = new String(this.tmp_3072bytes_data, i4, b2, "utf-8");
                    int i5 = i4 + b2;
                    if (i == 10) {
                        short s = Convert.getShort(this.tmp_3072bytes_data, i5);
                        i4 = i5 + 2 + 1;
                        arrayList.add(new MapSourceGridData(str, i, s, 0));
                    } else {
                        i4 = i5 + 1;
                        arrayList.add(new MapSourceGridData(str, i));
                    }
                }
                i2++;
                i3 = i4;
            }
        }
    }

    public synchronized int getAnimateionsCount() {
        return this.map_anims_mgr.m19112b();
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getInstanceHandle() {
        return this.native_instance;
    }

    public synchronized int getMapCount() {
        return this.mStateMessageList.size();
    }

    public synchronized MapProjection getMapstate() {
        return (this.native_instance == 0 || this.native_mapprojection_instance == 0) ? null : new MapProjection(this.native_mapprojection_instance, this);
    }

    public Poi getPoiItem(int i, int i2, int i3) {
        if (!this.mMap.isMaploaded()) {
            return null;
        }
        try {
            SelectedMapPoi selectedMapPoi = getSelectedMapPoi(i, i2, i3);
            if (selectedMapPoi == null) {
                return null;
            }
            DPoint dPoint = new DPoint();
            MapProjection.geo2LonLat(selectedMapPoi.mapx, selectedMapPoi.mapy, dPoint);
            return new Poi(selectedMapPoi.name, new LatLng(dPoint.f4727y, dPoint.f4726x, false), selectedMapPoi.poiid);
        } catch (Throwable th) {
            return null;
        }
    }

    public SelectedMapPoi getSelectedMapPoi(int i, int i2, int i3) {
        if (this.native_instance != 0) {
            byte[] bArr = new byte[1024];
            int nativeGetSelectedMapPois = nativeGetSelectedMapPois(this.native_instance, i, i2, i3, bArr);
            if (nativeGetSelectedMapPois == 0) {
                return null;
            }
            if (nativeGetSelectedMapPois > 0) {
                SelectedMapPoi selectedMapPoi = new SelectedMapPoi();
                selectedMapPoi.winx = Convert.getInt(bArr, 0);
                selectedMapPoi.winy = Convert.getInt(bArr, 4);
                selectedMapPoi.mapx = Convert.getInt(bArr, 8);
                selectedMapPoi.mapy = Convert.getInt(bArr, 12);
                selectedMapPoi.iconXmin = Convert.getInt(bArr, 16);
                selectedMapPoi.iconXmax = Convert.getInt(bArr, 20);
                selectedMapPoi.iconYmin = Convert.getInt(bArr, 24);
                selectedMapPoi.iconYmax = Convert.getInt(bArr, 28);
                byte b = bArr[32];
                StringBuffer stringBuffer = new StringBuffer();
                int i4 = 33;
                for (int i5 = 0; i5 < b; i5++) {
                    i4 += 2;
                    stringBuffer.append((char) Convert.getShort(bArr, i4));
                }
                selectedMapPoi.name = stringBuffer.toString();
                byte b2 = bArr[i4];
                StringBuffer stringBuffer2 = new StringBuffer();
                int i6 = i4 + 1;
                for (int i7 = 0; i7 < b2; i7++) {
                    char c = (char) Convert.getShort(bArr, i6);
                    i6 += 2;
                    if (c == 0) {
                        break;
                    }
                    stringBuffer2.append(c);
                }
                selectedMapPoi.poiid = stringBuffer2.toString();
                return selectedMapPoi;
            }
        }
        return null;
    }

    public synchronized MapMessage getStateMessage() {
        MapMessage mapMessage;
        if (getMapCount() == 0) {
            mapMessage = null;
        } else {
            mapMessage = this.mStateMessageList.get(0);
            this.mStateMessageList.remove(mapMessage);
        }
        return mapMessage;
    }

    public synchronized int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    public boolean isMapEngineValid() {
        return this.native_instance != 0;
    }

    public void newMap() {
        MapTilsCacheAndResManager.getInstance(this.mContext).checkDir();
        String baseMapPath = MapTilsCacheAndResManager.getInstance(this.mContext).getBaseMapPath();
        this.map_anims_mgr = new C0762ab();
        this.textTextureGenerator = new TextTextureGenerator();
        this.tmp_3072bytes_data = ByteBuffer.allocate(3072).array();
        this.native_instance = nativeNewInstance(baseMapPath, this.textTextureGenerator.getFontVersion());
        if (this.native_instance != 0) {
            this.native_mapprojection_instance = nativeGetMapstate(this.native_instance);
        }
    }

    public void onIndoorBuildingActivity(byte[] bArr) {
        if (this.mMapcallback != null) {
            try {
                this.mMapcallback.onIndoorBuildingActivity(this, bArr);
            } catch (Throwable th) {
            }
        }
    }

    public void onIndoorDataRequired(int i, String[] strArr, int[] iArr, int[] iArr2) {
        if (this.mMapcallback != null) {
            try {
                this.mMapcallback.onIndoorDataRequired(this, i, strArr, iArr, iArr2);
            } catch (Throwable th) {
            }
        }
    }

    public void putCharbitmap(int i, byte[] bArr) {
        if (this.native_instance != 0) {
            nativePutCharbitmap(this.native_instance, i, bArr);
        }
    }

    public boolean putMapData(byte[] bArr, int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.native_instance != 0) {
            if (bArr.length != i2 || i != 0) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (nativePutMapdata(this.native_instance, i3, bArr2) <= 0) {
                    z = false;
                }
            } else if (nativePutMapdata(this.native_instance, i3, bArr) <= 0) {
                z = false;
            }
            if (this.mMapcallback == null) {
                return z;
            }
            this.mMapcallback.requestRender();
            return z;
        }
        return false;
    }

    public void setGL(GL10 gl10) {
        this.mGL = gl10;
    }

    public void setIndoorBuildingToBeActive(String str, int i, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        nativeSetIndoorBuildingToBeActive(this.native_instance, str, i, str2);
    }

    public void setInternaltexture(byte[] bArr, int i) {
        if (this.native_instance == 0 || bArr == null || bArr.length <= 0) {
            return;
        }
        nativeSetInternaltexture(this.native_instance, bArr, i);
    }

    public void setMapCallback(IMapCallback iMapCallback) {
        this.mMapcallback = iMapCallback;
    }

    public void setMapstate(MapProjection mapProjection) {
        MapConfig mapConfig;
        LatLngBounds limitLatLngBounds;
        int i;
        int i2;
        if (this.native_instance != 0) {
            if (this.mMap != null && this.mMap.getMapConfig() != null && (limitLatLngBounds = (mapConfig = this.mMap.getMapConfig()).getLimitLatLngBounds()) != null) {
                IPoint[] limitIPoints = mapConfig.getLimitIPoints();
                if (limitIPoints == null) {
                    IPoint iPoint = new IPoint();
                    MapProjection.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, iPoint);
                    IPoint iPoint2 = new IPoint();
                    MapProjection.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, iPoint2);
                    limitIPoints = new IPoint[]{iPoint, iPoint2};
                    mapConfig.setLimitIPoints(limitIPoints);
                }
                IPoint[] iPointArr = limitIPoints;
                MapProjection mapProjection2 = new MapProjection(this);
                float m18337a = C0945eh.m18337a(mapProjection2, mapConfig, iPointArr[0], iPointArr[1], this.surface_width, this.surface_height);
                mapProjection2.recycle();
                this.mMap.getMapConfig().setMinZoomLevel(m18337a);
                this.mMap.getMapConfig().setLimitZoomLevel(m18337a);
                this.mMap.getMapConfig().setLimitIPoints(iPointArr);
                mapProjection.setMapZoomer(mapProjection.getMapZoomer());
                mapProjection.recalculate();
                IPoint iPoint3 = new IPoint();
                mapProjection.getGeoCenter(iPoint3);
                int i3 = iPoint3.f4730x;
                int i4 = iPoint3.f4731y;
                mapProjection.recalculate();
                FPoint[] m18336a = C0945eh.m18336a(this.mMap, false, mapProjection);
                IPoint[] iPointArr2 = new IPoint[m18336a.length];
                for (int i5 = 0; i5 < m18336a.length; i5++) {
                    IPoint iPoint4 = new IPoint();
                    mapProjection.map2Geo(m18336a[i5].f4728x, m18336a[i5].f4729y, iPoint4);
                    iPointArr2[i5] = iPoint4;
                }
                Integer[] m18324a = C0945eh.m18324a(iPointArr, iPointArr2, i3, i4);
                if (m18324a == null || m18324a.length != 2) {
                    i = i4;
                    i2 = i3;
                } else {
                    i2 = m18324a[0].intValue();
                    i = m18324a[1].intValue();
                }
                mapProjection.setGeoCenter(i2, i);
            }
            nativeSetMapstate(this.native_instance, mapProjection.getInstanceHandle());
        }
    }

    public void setParameter(int i, int i2, int i3, int i4, int i5) {
        if (this.native_instance != 0) {
            nativeSetparameter(this.native_instance, i, i2, i3, i4, i5);
        }
    }

    public void setStyleData(byte[] bArr, int i, int i2) {
        if (this.native_instance == 0 || bArr == null || bArr.length <= 0) {
            return;
        }
        nativeSetStyleData(this.native_instance, bArr, i, i2);
    }

    public void startMapSlidAnim(final IPoint iPoint, final float f, final float f2) {
        this.mMap.onFling();
        this.mMap.getMainHandler().post(new Runnable() { // from class: com.autonavi.amap.mapcore.MapCore.1
            @Override // java.lang.Runnable
            public void run() {
                float f3;
                float f4;
                MapCore.this.clearAnimations();
                if (iPoint == null) {
                    return;
                }
                MapProjection mapProjection = new MapProjection(MapCore.this);
                mapProjection.recalculate();
                float f5 = f;
                float f6 = f2;
                float abs = Math.abs(f5);
                float abs2 = Math.abs(f6);
                if ((abs > abs2 ? abs : abs2) <= 12000) {
                    f3 = f5;
                    f4 = f6;
                } else if (abs > abs2) {
                    float f7 = f6 * (12000 / abs);
                    f3 = f5 > 0.0f ? 12000 : -12000;
                    f4 = f7;
                } else {
                    float f8 = (12000 / abs2) * f5;
                    f4 = f6 > 0.0f ? 12000 : -12000;
                    f3 = f8;
                }
                C0761aa c0761aa = new C0761aa(500, MapCore.this.surface_width / 2, MapCore.this.surface_height / 2);
                c0761aa.m19117a(f3, f4);
                c0761aa.m19116a(mapProjection);
                mapProjection.recycle();
                MapCore.this.map_anims_mgr.m19114a(c0761aa);
            }
        });
    }

    public void surfaceChange(GL10 gl10, int i, int i2) {
        int i3;
        int i4;
        int i5 = 120;
        int i6 = 50;
        if (this.native_instance != 0) {
            nativeSurfaceChange(this.native_instance, this, i, i2);
            int i7 = this.mContext.getResources().getDisplayMetrics().densityDpi;
            float f = this.mContext.getResources().getDisplayMetrics().density;
            int i8 = 100;
            if (i7 <= 120) {
                i3 = 1;
            } else if (i7 <= 160) {
                if (Math.max(i, i2) <= 480) {
                    i4 = 120;
                } else {
                    i4 = 100;
                    i5 = 160;
                }
                i3 = 1;
                i6 = i5;
                i8 = i4;
            } else if (i7 <= 240) {
                if (Math.min(i, i2) >= 1000) {
                    i8 = 60;
                    i6 = 200;
                    i3 = 2;
                } else {
                    i8 = 70;
                    i6 = 150;
                    i3 = 2;
                }
            } else if (i7 <= 320) {
                i3 = 3;
                i8 = 50;
                i6 = 180;
            } else if (i7 <= 480) {
                i3 = 3;
                i8 = 50;
                i6 = 300;
            } else {
                i8 = 40;
                i6 = 360;
                i3 = 4;
            }
            setParameter(2051, i8, i6, (int) (f * 100.0f), i3);
            this.mMap.setZoomScaleParam(i8 / 100.0f);
            setParameter(1001, 0, 0, 0, 0);
            setParameter(1023, 1, 0, 0, 0);
        }
    }

    public void surfaceCreate(GL10 gl10) {
        if (this.native_instance != 0) {
            nativeSurfaceCreate(this.native_instance, this);
        }
    }
}
