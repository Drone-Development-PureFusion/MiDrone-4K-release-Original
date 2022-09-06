package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.p001v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.cj */
/* loaded from: classes.dex */
public class C0873cj implements AbstractC0877cn {

    /* renamed from: a */
    float f2408a;

    /* renamed from: b */
    float f2409b;

    /* renamed from: c */
    float f2410c;

    /* renamed from: d */
    float f2411d;

    /* renamed from: e */
    private LatLng f2412e;

    /* renamed from: f */
    private LatLng f2413f;

    /* renamed from: g */
    private LatLng f2414g;

    /* renamed from: l */
    private String f2419l;

    /* renamed from: m */
    private AbstractC1115l f2420m;

    /* renamed from: n */
    private float[] f2421n;

    /* renamed from: h */
    private float f2415h = 10.0f;

    /* renamed from: i */
    private int f2416i = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: j */
    private float f2417j = 0.0f;

    /* renamed from: k */
    private boolean f2418k = true;

    /* renamed from: o */
    private int f2422o = 0;

    /* renamed from: p */
    private boolean f2423p = false;

    /* renamed from: q */
    private double f2424q = 0.0d;

    /* renamed from: r */
    private double f2425r = 0.0d;

    /* renamed from: s */
    private double f2426s = 0.0d;

    public C0873cj(AbstractC1115l abstractC1115l) {
        this.f2420m = abstractC1115l;
        try {
            this.f2419l = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private double m18714a(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d4) / this.f2424q;
        if (Math.abs(d5) > 1.0d) {
            d5 = Math.signum(d5);
        }
        double asin = Math.asin(d5);
        return asin >= 0.0d ? d3 < d ? 3.141592653589793d - Math.abs(asin) : asin : d3 < d ? 3.141592653589793d - asin : asin + 6.283185307179586d;
    }

    /* renamed from: a */
    private FPoint m18712a(MapProjection mapProjection, double d, double d2, double d3) {
        double cos = Math.cos(d) * this.f2424q;
        int i = (int) (((-Math.sin(d)) * this.f2424q) + d3);
        FPoint fPoint = new FPoint();
        mapProjection.geo2Map((int) (cos + d2), i, fPoint);
        return fPoint;
    }

    /* renamed from: d */
    private boolean m18709d() {
        return Math.abs(((this.f2412e.latitude - this.f2413f.latitude) * (this.f2413f.longitude - this.f2414g.longitude)) - ((this.f2412e.longitude - this.f2413f.longitude) * (this.f2413f.latitude - this.f2414g.latitude))) >= 1.0E-6d;
    }

    /* renamed from: e */
    private DPoint m18708e() {
        IPoint iPoint = new IPoint();
        this.f2420m.mo17555a(this.f2412e.latitude, this.f2412e.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f2420m.mo17555a(this.f2413f.latitude, this.f2413f.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f2420m.mo17555a(this.f2414g.latitude, this.f2414g.longitude, iPoint3);
        double d = iPoint.f4730x;
        double d2 = iPoint.f4731y;
        double d3 = iPoint2.f4730x;
        double d4 = iPoint2.f4731y;
        double d5 = iPoint3.f4730x;
        double d6 = iPoint3.f4731y;
        double d7 = (((d6 - d2) * ((((d4 * d4) - (d2 * d2)) + (d3 * d3)) - (d * d))) + ((d4 - d2) * ((((d2 * d2) - (d6 * d6)) + (d * d)) - (d5 * d5)))) / (((2.0d * (d3 - d)) * (d6 - d2)) - ((2.0d * (d5 - d)) * (d4 - d2)));
        double d8 = (((d5 - d) * ((((d3 * d3) - (d * d)) + (d4 * d4)) - (d2 * d2))) + ((d3 - d) * ((((d * d) - (d5 * d5)) + (d2 * d2)) - (d6 * d6)))) / (((2.0d * (d4 - d2)) * (d5 - d)) - ((2.0d * (d6 - d2)) * (d3 - d)));
        this.f2424q = Math.sqrt(((d - d7) * (d - d7)) + ((d2 - d8) * (d2 - d8)));
        this.f2425r = m18714a(d7, d8, d, d2);
        double m18714a = m18714a(d7, d8, d3, d4);
        this.f2426s = m18714a(d7, d8, d5, d6);
        if (this.f2425r < this.f2426s) {
            if (m18714a <= this.f2425r || m18714a >= this.f2426s) {
                this.f2426s -= 6.283185307179586d;
            }
        } else if (m18714a <= this.f2426s || m18714a >= this.f2425r) {
            this.f2426s += 6.283185307179586d;
        }
        return new DPoint(d7, d8);
    }

    /* renamed from: a */
    public void m18713a(LatLng latLng) {
        this.f2412e = latLng;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2412e == null || this.f2413f == null || this.f2414g == null || !this.f2418k) {
            return;
        }
        if (this.f2421n == null || this.f2422o == 0) {
            mo18600b();
        }
        if (this.f2421n != null && this.f2422o > 0) {
            float mapLenWithWin = this.f2420m.mo17530c().getMapLenWithWin((int) this.f2415h);
            this.f2420m.mo17530c().getMapLenWithWin(1);
            AMapNativeRenderer.nativeDrawLineByTextureID(this.f2421n, this.f2421n.length, mapLenWithWin, this.f2420m.mo17538b(), this.f2409b, this.f2410c, this.f2411d, this.f2408a, 0.0f, false, true, false);
        }
        this.f2423p = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        return true;
    }

    /* renamed from: b */
    public void m18711b(LatLng latLng) {
        this.f2413f = latLng;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        if (this.f2412e == null || this.f2413f == null || this.f2414g == null || !this.f2418k) {
            return false;
        }
        try {
            this.f2423p = false;
            MapProjection mo17530c = this.f2420m.mo17530c();
            if (!m18709d()) {
                this.f2421n = new float[r8.length * 3];
                FPoint fPoint = new FPoint();
                this.f2420m.mo17556a(this.f2412e.latitude, this.f2412e.longitude, fPoint);
                FPoint fPoint2 = new FPoint();
                this.f2420m.mo17556a(this.f2413f.latitude, this.f2413f.longitude, fPoint2);
                FPoint fPoint3 = new FPoint();
                this.f2420m.mo17556a(this.f2414g.latitude, this.f2414g.longitude, fPoint3);
                FPoint[] fPointArr = {fPoint, fPoint2, fPoint3};
                for (int i = 0; i < 3; i++) {
                    this.f2421n[i * 3] = fPointArr[i].f4728x;
                    this.f2421n[(i * 3) + 1] = fPointArr[i].f4729y;
                    this.f2421n[(i * 3) + 2] = 0.0f;
                }
                this.f2422o = fPointArr.length;
                return true;
            }
            DPoint m18708e = m18708e();
            int abs = (int) ((Math.abs(this.f2426s - this.f2425r) * 180.0d) / 3.141592653589793d);
            double d = (this.f2426s - this.f2425r) / abs;
            FPoint[] fPointArr2 = new FPoint[abs + 1];
            this.f2421n = new float[fPointArr2.length * 3];
            for (int i2 = 0; i2 <= abs; i2++) {
                if (i2 == abs) {
                    FPoint fPoint4 = new FPoint();
                    this.f2420m.mo17556a(this.f2414g.latitude, this.f2414g.longitude, fPoint4);
                    fPointArr2[i2] = fPoint4;
                } else {
                    fPointArr2[i2] = m18712a(mo17530c, (i2 * d) + this.f2425r, m18708e.f4726x, m18708e.f4727y);
                }
                fPointArr2[i2] = m18712a(mo17530c, (i2 * d) + this.f2425r, m18708e.f4726x, m18708e.f4727y);
                this.f2421n[i2 * 3] = fPointArr2[i2].f4728x;
                this.f2421n[(i2 * 3) + 1] = fPointArr2[i2].f4729y;
                this.f2421n[(i2 * 3) + 2] = 0.0f;
            }
            this.f2422o = fPointArr2.length;
            return true;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ArcDelegateImp", "calMapFPoint");
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public void m18710c(LatLng latLng) {
        this.f2414g = latLng;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2423p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.f2412e = null;
            this.f2413f = null;
            this.f2414g = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2419l == null) {
            this.f2419l = C1097j.m17627a("Arc");
        }
        return this.f2419l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public int getStrokeColor() {
        return this.f2416i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public float getStrokeWidth() {
        return this.f2415h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2417j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f2418k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2420m.mo17540a(getId());
        this.f2420m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeColor(int i) {
        this.f2416i = i;
        this.f2408a = Color.alpha(i) / 255.0f;
        this.f2409b = Color.red(i) / 255.0f;
        this.f2410c = Color.green(i) / 255.0f;
        this.f2411d = Color.blue(i) / 255.0f;
        this.f2420m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeWidth(float f) {
        this.f2415h = f;
        this.f2420m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2418k = z;
        this.f2420m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2417j = f;
        this.f2420m.mo17509r();
        this.f2420m.setRunLowFrame(false);
    }
}
