package com.autonavi.amap.mapcore;

import android.os.SystemClock;
import com.amap.api.mapcore.util.C1134y;
import com.amap.api.mapcore.util.C1135z;
/* loaded from: classes.dex */
public class ADGLMapAnimGroup extends ADGLAnimation {
    public static final int CAMERA_MAX_DEGREE = 60;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int _endZoomDuration;
    boolean _hasCheckParams;
    boolean _hasMidZoom;
    int _midZoomDuration;
    public boolean _needMove;
    boolean _needRotateCamera;
    boolean _needRotateMap;
    boolean _needZoom;
    int _startZoomDuration;
    C1134y _zoomStartParam = null;
    C1134y _zoomEndParam = null;
    C1135z _moveParam = null;
    C1134y _rotateMapParam = null;
    C1134y _rotateCameraParam = null;

    public ADGLMapAnimGroup(int i) {
        reset();
        this._duration = i;
    }

    public static boolean checkLevel(float f) {
        return f >= 3.0f && f <= 20.0f;
    }

    private void initZoomEndParam(float f, float f2, int i) {
        if (this._zoomEndParam == null) {
            this._zoomEndParam = new C1134y();
        }
        this._zoomEndParam.mo17437a();
        this._zoomEndParam.a(i, 1.0f);
        this._zoomEndParam.m17441d(f2);
        this._zoomEndParam.m17442c(f);
    }

    private void initZoomStartParam(float f, int i) {
        if (this._zoomStartParam == null) {
            this._zoomStartParam = new C1134y();
        }
        this._zoomStartParam.mo17437a();
        this._zoomStartParam.a(i, 1.0f);
        this._zoomStartParam.m17441d(f);
    }

    public void commitAnimation(Object obj) {
        IPoint iPoint;
        this._isOver = true;
        this._hasCheckParams = false;
        MapProjection mapProjection = (MapProjection) obj;
        if (mapProjection == null) {
            return;
        }
        if (this._needZoom) {
            if (this._zoomStartParam == null) {
                this._hasCheckParams = true;
                return;
            }
            float mapZoomer = mapProjection.getMapZoomer();
            this._zoomStartParam.m17442c(mapZoomer);
            if (this._hasMidZoom) {
                float m17439f = this._zoomStartParam.m17439f() - mapZoomer;
                float m17440e = this._zoomEndParam.m17440e() - this._zoomEndParam.m17439f();
                if (Math.abs(m17439f) < 1.0E-6d || Math.abs(m17440e) < 1.0E-6d) {
                    this._hasMidZoom = false;
                    this._zoomStartParam.m17441d(this._zoomEndParam.m17439f());
                    this._zoomStartParam.b();
                    this._zoomEndParam = null;
                } else {
                    this._zoomStartParam.b();
                    this._zoomEndParam.b();
                }
            }
            if (!this._hasMidZoom && Math.abs(this._zoomStartParam.m17440e() - this._zoomStartParam.m17439f()) < 1.0E-6d) {
                this._needZoom = false;
            }
            if (this._needZoom) {
                if (this._hasMidZoom) {
                    this._startZoomDuration = (this._duration - this._midZoomDuration) >> 1;
                    this._endZoomDuration = this._startZoomDuration;
                } else {
                    this._startZoomDuration = this._duration;
                }
            }
        }
        if (this._needMove && this._moveParam != null) {
            mapProjection.getGeoCenter(new IPoint());
            this._moveParam.m17436a(iPoint.f4730x, iPoint.f4731y);
            this._needMove = this._moveParam.b();
        }
        if (this._needRotateMap && this._rotateMapParam != null) {
            float mapAngle = mapProjection.getMapAngle();
            float m17439f2 = this._rotateMapParam.m17439f();
            if (mapAngle > 180.0f && m17439f2 == 0.0f) {
                m17439f2 = 360.0f;
            }
            int i = ((int) m17439f2) - ((int) mapAngle);
            if (i > 180) {
                m17439f2 -= 360.0f;
            } else if (i < -180) {
                m17439f2 += 360.0f;
            }
            this._rotateMapParam.m17442c(mapAngle);
            this._rotateMapParam.m17441d(m17439f2);
            this._needRotateMap = this._rotateMapParam.b();
        }
        if (this._needRotateCamera && this._rotateCameraParam != null) {
            this._rotateCameraParam.m17442c(mapProjection.getCameraHeaderAngle());
            this._needRotateCamera = this._rotateCameraParam.b();
        }
        if (this._needMove || this._needZoom || this._needRotateMap || this._needRotateCamera) {
            this._isOver = false;
        } else {
            this._isOver = true;
        }
        this._hasCheckParams = true;
        this._startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.amap.mapcore.ADGLAnimation
    public void doAnimation(Object obj) {
        float m17438g;
        float f = 1.0f;
        MapProjection mapProjection = (MapProjection) obj;
        if (mapProjection == null) {
            return;
        }
        if (!this._hasCheckParams) {
            commitAnimation(obj);
        }
        if (this._isOver) {
            return;
        }
        this._offsetTime = SystemClock.uptimeMillis() - this._startTime;
        if (this._duration == 0.0f) {
            this._isOver = true;
            return;
        }
        float f2 = ((float) this._offsetTime) / this._duration;
        if (f2 > 1.0f) {
            this._isOver = true;
        } else if (f2 < 0.0f) {
            this._isOver = true;
            return;
        } else {
            f = f2;
        }
        if (this._needZoom) {
            mapProjection.getMapZoomer();
            if (this._hasMidZoom) {
                if (this._offsetTime <= this._startZoomDuration) {
                    this._zoomStartParam.b(((float) this._offsetTime) / this._startZoomDuration);
                    m17438g = this._zoomStartParam.m17438g();
                } else if (this._offsetTime <= this._startZoomDuration + this._midZoomDuration) {
                    m17438g = this._zoomStartParam.m17439f();
                } else {
                    this._zoomEndParam.b(((float) ((this._offsetTime - this._startZoomDuration) - this._midZoomDuration)) / this._endZoomDuration);
                    m17438g = this._zoomEndParam.m17438g();
                }
                if (this._isOver) {
                    m17438g = this._zoomEndParam.m17439f();
                }
            } else {
                this._zoomStartParam.b(f);
                m17438g = this._zoomStartParam.m17438g();
            }
            mapProjection.setMapZoomer(m17438g);
        }
        if (this._moveParam != null && this._needMove) {
            this._moveParam.b(f);
            float c = this._moveParam.c();
            mapProjection.setGeoCenter((int) this._moveParam.m17433e(), (int) this._moveParam.m17432f());
            FPoint fPoint = new FPoint();
            mapProjection.getMapCenter(fPoint);
            float f3 = fPoint.f4728x;
            float f4 = fPoint.f4729y;
            FPoint fPoint2 = new FPoint();
            mapProjection.geo2Map((int) this._moveParam.m17431g(), (int) this._moveParam.m17430h(), fPoint2);
            mapProjection.setMapCenter(f3 + ((fPoint2.f4728x - f3) * c), f4 + ((fPoint2.f4729y - f4) * c));
        }
        if (this._rotateMapParam != null && this._needRotateMap) {
            this._rotateMapParam.b(f);
            mapProjection.setMapAngle((int) this._rotateMapParam.m17438g());
        }
        if (this._rotateCameraParam == null || !this._needRotateCamera) {
            return;
        }
        this._rotateCameraParam.b(f);
        mapProjection.setCameraHeaderAngle((int) this._rotateCameraParam.m17438g());
    }

    @Override // com.autonavi.amap.mapcore.ADGLAnimation
    public boolean isValid() {
        return this._needRotateCamera || this._needRotateMap || this._needMove || this._needZoom;
    }

    public void reset() {
        this._isOver = false;
        this._hasCheckParams = false;
        this._needZoom = false;
        this._needMove = false;
        this._moveParam = null;
        this._needRotateMap = false;
        this._rotateMapParam = null;
        this._hasMidZoom = false;
        this._duration = 0;
        if (this._rotateMapParam != null) {
            this._rotateMapParam.mo17437a();
        }
        if (this._moveParam != null) {
            this._moveParam.mo17437a();
        }
        if (this._zoomStartParam != null) {
            this._zoomStartParam.mo17437a();
        }
        if (this._zoomEndParam != null) {
            this._zoomEndParam.mo17437a();
        }
        if (this._rotateCameraParam != null) {
            this._rotateCameraParam.mo17437a();
        }
    }

    public void setDuration(int i) {
        this._duration = i;
    }

    public void setToCameraDegree(float f, int i) {
        this._needRotateCamera = false;
        if (f > 60.0f || f < 0.0f) {
            return;
        }
        this._needRotateCamera = true;
        if (this._rotateCameraParam == null) {
            this._rotateCameraParam = new C1134y();
        }
        this._rotateCameraParam.mo17437a();
        this._rotateCameraParam.a(i, 1.0f);
        this._rotateCameraParam.m17441d(f);
    }

    public void setToMapAngle(float f, int i) {
        float f2 = f % 360.0f;
        this._needRotateMap = true;
        if (this._rotateMapParam == null) {
            this._rotateMapParam = new C1134y();
        }
        this._rotateMapParam.mo17437a();
        this._rotateMapParam.a(i, 1.0f);
        this._rotateMapParam.m17441d(f2);
    }

    public void setToMapCenterGeo(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this._needMove = true;
        if (this._moveParam == null) {
            this._moveParam = new C1135z();
        }
        this._moveParam.mo17437a();
        this._moveParam.a(i3, 1.0f);
        this._moveParam.m17435b(i, i2);
    }

    public void setToMapLevel(float f, float f2, int i) {
        this._needZoom = true;
        this._midZoomDuration = 0;
        this._hasMidZoom = false;
        if (i > 0 && i < this._duration) {
            this._midZoomDuration = i;
        }
        if (checkLevel(f) && checkLevel(f2)) {
            this._hasMidZoom = true;
            initZoomStartParam(f2, 0);
            initZoomEndParam(f2, f, 0);
        } else if (checkLevel(f)) {
            this._hasMidZoom = false;
            initZoomStartParam(f, 0);
        } else if (!checkLevel(f2)) {
            this._needZoom = false;
        } else {
            this._hasMidZoom = false;
            initZoomStartParam(f2, 0);
        }
    }

    public void setToMapLevel(float f, int i) {
        this._needZoom = true;
        this._midZoomDuration = 0;
        this._hasMidZoom = false;
        if (checkLevel(f)) {
            initZoomStartParam(f, i);
        } else {
            this._needZoom = false;
        }
    }

    public boolean typeEqueal(ADGLMapAnimGroup aDGLMapAnimGroup) {
        return this._needRotateCamera == aDGLMapAnimGroup._needRotateCamera && this._needRotateMap == aDGLMapAnimGroup._needRotateMap && this._needZoom == aDGLMapAnimGroup._needZoom && this._needMove == aDGLMapAnimGroup._needMove;
    }
}
