package com.autonavi.amap.mapcore;

import com.amap.api.maps.model.LatLngBounds;
/* loaded from: classes.dex */
public class MapConfig implements Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 19.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 18;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 16;
    public static final int MSG_CALLBACK_SCREENSHOT = 17;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 12;
    public static final int MSG_CAMERAUPDATE_NEWBOUNDS = 11;
    public static final int MSG_CAMERAUPDATE_UPDATEBOUNDS = 13;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 15;
    public static final int MSG_INFOWINDOW_UPDATE = 21;
    public static final int MSG_TILEOVERLAY_REFRESH = 19;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 14;
    private static final int TILE_SIZE_POW = 8;
    private boolean isSetLimitZoomLevel;
    MapConfig last_mapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private float limitZoomLevel;
    private float mapPerPixelUnitLength;
    public float maxZoomLevel = 19.0f;
    public float minZoomLevel = 3.0f;
    private FPoint[] mapRect = null;
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private int s_x = 221010267;
    private int s_y = 101697799;
    private float s_z = 10.0f;
    private float s_c = 0.0f;
    private float s_r = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private volatile int changedCounter = 0;
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int grid_x = 0;
    private int grid_y = 0;

    public MapConfig(boolean z) {
        this.last_mapconfig = null;
        if (z) {
            this.last_mapconfig = new MapConfig(false);
            this.last_mapconfig.setGridXY(0, 0);
            this.last_mapconfig.setS_x(0);
            this.last_mapconfig.setS_y(0);
            this.last_mapconfig.setS_z(0.0f);
            this.last_mapconfig.setS_c(0.0f);
            this.last_mapconfig.setS_r(0.0f);
        }
    }

    private void changeRatio() {
        float f = 1.0f;
        double d = 1.0d;
        int s_x = this.last_mapconfig.getS_x();
        int s_y = this.last_mapconfig.getS_y();
        float s_z = this.last_mapconfig.getS_z();
        float s_c = this.last_mapconfig.getS_c();
        float s_r = this.last_mapconfig.getS_r();
        this.changeRatio = Math.abs(this.s_x - s_x) + Math.abs(this.s_y - s_y);
        this.changeRatio = (s_z == this.s_z ? 1.0d : Math.abs(s_z - this.s_z)) * this.changeRatio;
        float abs = s_c == this.s_c ? 1.0f : Math.abs(s_c - this.s_c);
        if (s_r != this.s_r) {
            f = Math.abs(s_r - this.s_r);
        }
        this.changeRatio *= abs;
        this.changeRatio *= f;
        this.changeGridRatio = Math.abs(this.last_mapconfig.getGrid_X() - this.grid_x) + (this.last_mapconfig.getGrid_Y() - this.grid_y);
        if (this.changeGridRatio != 0.0d) {
            d = this.changeGridRatio;
        }
        this.changeGridRatio = d;
        this.changeGridRatio = abs * this.changeGridRatio;
        this.changeGridRatio *= f;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter;
    }

    protected int getGrid_X() {
        return this.grid_x;
    }

    protected int getGrid_Y() {
        return this.grid_y;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public float getLimitZoomLevel() {
        return this.limitZoomLevel;
    }

    public float getMapPerPixelUnitLength() {
        return this.mapPerPixelUnitLength;
    }

    public FPoint[] getMapRect() {
        return this.mapRect;
    }

    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float getS_c() {
        return this.s_c;
    }

    public float getS_r() {
        return this.s_r;
    }

    public int getS_x() {
        return this.s_x;
    }

    public int getS_y() {
        return this.s_y;
    }

    public float getS_z() {
        return this.s_z;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapStateChange() {
        if (this.last_mapconfig != null) {
            int s_x = this.last_mapconfig.getS_x();
            int s_y = this.last_mapconfig.getS_y();
            float s_z = this.last_mapconfig.getS_z();
            float s_c = this.last_mapconfig.getS_c();
            float s_r = this.last_mapconfig.getS_r();
            this.isCenterChanged = s_x != this.s_x;
            this.isCenterChanged = s_y != this.s_y ? true : this.isCenterChanged;
            this.isZoomChanged = s_z != this.s_z;
            if (this.isZoomChanged) {
                if (s_z <= this.minZoomLevel || this.s_z <= this.minZoomLevel || s_z >= this.maxZoomLevel || this.s_z >= this.maxZoomLevel) {
                    this.isNeedUpdateZoomControllerState = true;
                } else {
                    this.isNeedUpdateZoomControllerState = false;
                }
            }
            this.isTiltChanged = s_c != this.s_c;
            this.isBearingChanged = s_r != this.s_r;
            boolean z = this.isCenterChanged || this.isZoomChanged || this.isTiltChanged || this.isBearingChanged || this.isNeedUpdateMapRectNextFrame;
            if (z) {
                this.isNeedUpdateMapRectNextFrame = false;
                this.changedCounter++;
                int i = (int) this.s_z;
                setGridXY(this.s_x >> ((20 - i) + 8), this.s_y >> ((20 - i) + 8));
                changeRatio();
            }
            return z;
        }
        return false;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter = 0;
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 19.0f;
        this.isSetLimitZoomLevel = false;
    }

    public void setBuildingEnable(boolean z) {
        this.isBuildingEnable = z;
    }

    protected void setGridXY(int i, int i2) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setGridXY(this.grid_x, this.grid_y);
        }
        this.grid_x = i;
        this.grid_y = i2;
    }

    public void setIndoorEnable(boolean z) {
        this.isIndoorEnable = z;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            setLimitZoomLevel(0.0f);
            resetMinMaxZoomPreference();
        }
    }

    public void setLimitZoomLevel(float f) {
        this.limitZoomLevel = f;
    }

    public void setMapPerPixelUnitLength(float f) {
        this.mapPerPixelUnitLength = f;
    }

    public void setMapRect(FPoint[] fPointArr) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setMapRect(fPointArr);
        }
        this.mapRect = fPointArr;
    }

    public void setMapTextEnable(boolean z) {
        this.isMapTextEnable = z;
    }

    public void setMaxZoomLevel(float f) {
        float f2 = 19.0f;
        float f3 = 3.0f;
        if (f <= 19.0f) {
            f2 = f;
        }
        if (f2 >= 3.0f) {
            f3 = f2;
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f3;
    }

    public void setMinZoomLevel(float f) {
        float f2 = 19.0f;
        float f3 = 3.0f;
        if (f >= 3.0f) {
            f3 = f;
        }
        if (f3 <= 19.0f) {
            f2 = f3;
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f2;
    }

    public void setS_c(float f) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setS_c(this.s_c);
        }
        this.s_c = f;
    }

    public void setS_r(float f) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setS_r(this.s_r);
        }
        this.s_r = f;
    }

    public void setS_x(int i) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setS_x(this.s_x);
        }
        this.s_x = i;
    }

    public void setS_y(int i) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setS_y(this.s_y);
        }
        this.s_y = i;
    }

    public void setS_z(float f) {
        if (this.last_mapconfig != null) {
            this.last_mapconfig.setS_z(this.s_z);
        }
        this.s_z = f;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public String toString() {
        return " s_x: " + this.s_x + " s_y: " + this.s_y + " s_z: " + this.s_z + " s_c: " + this.s_c + " s_r: " + this.s_r;
    }

    public void updateMapRectNextFrame(boolean z) {
        this.isNeedUpdateMapRectNextFrame = z;
    }
}
