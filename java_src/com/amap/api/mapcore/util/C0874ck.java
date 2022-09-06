package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.support.p001v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.ck */
/* loaded from: classes.dex */
public class C0874ck implements AbstractC0878co {

    /* renamed from: m */
    private static float f2427m = 4.0075016E7f;

    /* renamed from: n */
    private static int f2428n = 256;

    /* renamed from: o */
    private static int f2429o = 20;

    /* renamed from: h */
    private String f2437h;

    /* renamed from: i */
    private AbstractC1115l f2438i;

    /* renamed from: j */
    private FloatBuffer f2439j;

    /* renamed from: a */
    private LatLng f2430a = null;

    /* renamed from: b */
    private double f2431b = 0.0d;

    /* renamed from: c */
    private float f2432c = 10.0f;

    /* renamed from: d */
    private int f2433d = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: e */
    private int f2434e = 0;

    /* renamed from: f */
    private float f2435f = 0.0f;

    /* renamed from: g */
    private boolean f2436g = true;

    /* renamed from: k */
    private int f2440k = 0;

    /* renamed from: l */
    private boolean f2441l = false;

    public C0874ck(AbstractC1115l abstractC1115l) {
        this.f2438i = abstractC1115l;
        try {
            this.f2437h = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private float m18707a(double d) {
        return (float) ((Math.cos((3.141592653589793d * d) / 180.0d) * f2427m) / (f2428n << f2429o));
    }

    /* renamed from: b */
    private double m18706b(double d) {
        return 1.0d / m18707a(d);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2430a == null || this.f2431b <= 0.0d || !this.f2436g) {
            return;
        }
        if (this.f2439j == null || this.f2440k == 0) {
            mo18600b();
        }
        if (this.f2439j != null && this.f2440k > 0) {
            C0926du.m18459b(gl10, this.f2434e, this.f2433d, this.f2439j, this.f2432c, this.f2440k);
        }
        this.f2441l = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        this.f2441l = false;
        LatLng latLng = this.f2430a;
        if (latLng != null) {
            FPoint[] fPointArr = new FPoint[360];
            float[] fArr = new float[fPointArr.length * 3];
            double m18706b = m18706b(this.f2430a.latitude) * this.f2431b;
            IPoint iPoint = new IPoint();
            MapProjection mo17530c = this.f2438i.mo17530c();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            for (int i = 0; i < 360; i++) {
                double d = (i * 3.141592653589793d) / 180.0d;
                FPoint fPoint = new FPoint();
                mo17530c.geo2Map((int) ((Math.sin(d) * m18706b) + iPoint.f4730x), (int) ((Math.cos(d) * m18706b) + iPoint.f4731y), fPoint);
                fPointArr[i] = fPoint;
                fArr[i * 3] = fPointArr[i].f4728x;
                fArr[(i * 3) + 1] = fPointArr[i].f4729y;
                fArr[(i * 3) + 2] = 0.0f;
            }
            this.f2440k = fPointArr.length;
            this.f2439j = C0945eh.m18327a(fArr);
            return true;
        }
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2441l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public boolean contains(LatLng latLng) {
        return this.f2431b >= ((double) AMapUtils.calculateLineDistance(this.f2430a, latLng));
    }

    /* renamed from: d */
    void m18705d() {
        this.f2440k = 0;
        if (this.f2439j != null) {
            this.f2439j.clear();
        }
        this.f2438i.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.f2430a = null;
            if (this.f2439j == null) {
                return;
            }
            this.f2439j.clear();
            this.f2439j = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public LatLng getCenter() {
        return this.f2430a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getFillColor() {
        return this.f2434e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2437h == null) {
            this.f2437h = C1097j.m17627a("Circle");
        }
        return this.f2437h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public double getRadius() {
        return this.f2431b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getStrokeColor() {
        return this.f2433d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public float getStrokeWidth() {
        return this.f2432c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2435f;
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
        return this.f2436g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2438i.mo17540a(getId());
        this.f2438i.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setCenter(LatLng latLng) {
        this.f2430a = latLng;
        m18705d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setFillColor(int i) {
        this.f2434e = i;
        this.f2438i.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setRadius(double d) {
        this.f2431b = d;
        m18705d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeColor(int i) {
        this.f2433d = i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeWidth(float f) {
        this.f2432c = f;
        this.f2438i.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2436g = z;
        this.f2438i.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2435f = f;
        this.f2438i.mo17509r();
        this.f2438i.setRunLowFrame(false);
    }
}
