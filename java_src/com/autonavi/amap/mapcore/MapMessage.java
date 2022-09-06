package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
public abstract class MapMessage {
    public static final int GESTURE_STATE_BEGIN = 100;
    public static final int GESTURE_STATE_CHANGE = 101;
    public static final int GESTURE_STATE_END = 102;
    public static final int MAX_CAMERA_HEADER_DEGREE = 65;
    protected static final int MAX_FARCLIPANGLE_CAMERAHEADERANGLE = 40;
    public static final int MSGTYPE_GESTURE_HOVER = 33;
    public static final int MSGTYPE_GESTURE_MOVE = 32;
    public static final int MSGTYPE_GESTURE_ROTATE = 31;
    public static final int MSGTYPE_GESTURE_SCALE = 30;
    public static final int MSGTYPE_NAVIOVERLAY_STATE = 13;
    public static final int MSGTYPE_PARAMETER_SET = 19;
    public int anchorX;
    public int anchorY;
    public IPoint geoPoint;
    public MapConfig mapConfig;
    public int width = 0;
    public int height = 0;
    public boolean isChangeFinished = false;
    public boolean isUseAnchor = false;
    public float tilt = Float.NaN;
    public float bearing = Float.NaN;
    public float zoom = Float.NaN;
    protected int state_ = 0;

    public ADGLMapAnimGroup generateMapAnimation(MapProjection mapProjection, int i) {
        runCameraUpdate(mapProjection);
        ADGLMapAnimGroup aDGLMapAnimGroup = new ADGLMapAnimGroup(i);
        aDGLMapAnimGroup.setToCameraDegree(mapProjection.getCameraHeaderAngle(), 0);
        aDGLMapAnimGroup.setToMapAngle(mapProjection.getMapAngle(), 0);
        aDGLMapAnimGroup.setToMapLevel(mapProjection.getMapZoomer(), 0);
        IPoint iPoint = new IPoint();
        mapProjection.getGeoCenter(iPoint);
        aDGLMapAnimGroup.setToMapCenterGeo(iPoint.f4730x, iPoint.f4731y, 0);
        return aDGLMapAnimGroup;
    }

    public int getMapGestureState() {
        return this.state_;
    }

    public void mergeCameraUpdateDelegate(MapMessage mapMessage) {
    }

    public abstract void runCameraUpdate(MapProjection mapProjection);

    /* JADX INFO: Access modifiers changed from: protected */
    public void win2geo(MapProjection mapProjection, int i, int i2, IPoint iPoint) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        mapProjection.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
    }
}
