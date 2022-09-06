package com.amap.api.mapcore.util;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.ADGLAnimation;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.aa */
/* loaded from: classes.dex */
public class C0761aa extends ADGLAnimation {

    /* renamed from: a */
    private float f2012a;

    /* renamed from: b */
    private float f2013b;

    /* renamed from: c */
    private IPoint f2014c;

    /* renamed from: d */
    private C1135z f2015d = null;

    /* renamed from: e */
    private boolean f2016e;

    /* renamed from: f */
    private boolean f2017f;

    /* renamed from: g */
    private int f2018g;

    /* renamed from: h */
    private int f2019h;

    /* renamed from: i */
    private int f2020i;

    /* renamed from: j */
    private int f2021j;

    public C0761aa(int i, int i2, int i3) {
        this.f2018g = i2;
        this.f2019h = i3;
        this.f2020i = i2;
        this.f2021j = i3;
        m19118a();
        this._duration = i;
    }

    /* renamed from: a */
    public void m19118a() {
        if (this.f2015d != null) {
            this.f2015d.mo17437a();
        }
        this.f2012a = 0.0f;
        this.f2013b = 0.0f;
        this.f2017f = false;
        this.f2016e = false;
    }

    /* renamed from: a */
    public void m19117a(float f, float f2) {
        this.f2015d = null;
        this.f2012a = f;
        this.f2013b = f2;
        this.f2015d = new C1135z();
        this.f2015d.a(2, 1.2f);
        this.f2017f = false;
        this.f2016e = false;
    }

    /* renamed from: a */
    public void m19116a(Object obj) {
        MapProjection mapProjection = (MapProjection) obj;
        if (mapProjection == null) {
            return;
        }
        this.f2016e = false;
        this._isOver = true;
        int i = (int) ((this.f2012a * this._duration) / 2000.0f);
        int i2 = (int) ((this.f2013b * this._duration) / 2000.0f);
        if (Math.abs(i) != 0 && Math.abs(i2) != 0) {
            if (this.f2014c == null) {
                this.f2014c = new IPoint();
            }
            mapProjection.getGeoCenter(this.f2014c);
            this._isOver = false;
            this.f2015d.m17436a(this.f2018g, this.f2019h);
            this.f2015d.m17435b(this.f2018g - i, this.f2019h - i2);
            this.f2017f = this.f2015d.b();
        }
        if (this.f2017f) {
        }
        this.f2016e = true;
        this._startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.amap.mapcore.ADGLAnimation
    public void doAnimation(Object obj) {
        MapProjection mapProjection = (MapProjection) obj;
        if (mapProjection == null) {
            return;
        }
        if (!this.f2016e) {
            m19116a(obj);
        }
        if (this._isOver) {
            return;
        }
        this._offsetTime = SystemClock.uptimeMillis() - this._startTime;
        float f = ((float) this._offsetTime) / this._duration;
        if (f > 1.0f) {
            this._isOver = true;
            f = 1.0f;
        }
        if (f < 0.0f || f > 1.0f || !this.f2017f) {
            return;
        }
        this.f2015d.b(f);
        int m17429i = (int) this.f2015d.m17429i();
        int m17428j = (int) this.f2015d.m17428j();
        FPoint fPoint = new FPoint();
        mapProjection.win2Map((this.f2018g + m17429i) - this.f2020i, (this.f2019h + m17428j) - this.f2021j, fPoint);
        mapProjection.setMapCenter(fPoint.f4728x, fPoint.f4729y);
        this.f2020i = m17429i;
        this.f2021j = m17428j;
    }
}
