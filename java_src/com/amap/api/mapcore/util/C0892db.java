package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.p001v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.db */
/* loaded from: classes.dex */
public class C0892db implements AbstractC0882cs {

    /* renamed from: a */
    float f2541a;

    /* renamed from: b */
    float f2542b;

    /* renamed from: c */
    float f2543c;

    /* renamed from: d */
    float f2544d;

    /* renamed from: e */
    float f2545e;

    /* renamed from: f */
    float f2546f;

    /* renamed from: g */
    float f2547g;

    /* renamed from: h */
    float f2548h;

    /* renamed from: j */
    float[] f2550j;

    /* renamed from: k */
    private AbstractC1115l f2551k;

    /* renamed from: q */
    private String f2557q;

    /* renamed from: l */
    private float f2552l = 10.0f;

    /* renamed from: m */
    private int f2553m = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: n */
    private int f2554n = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: o */
    private float f2555o = 0.0f;

    /* renamed from: p */
    private boolean f2556p = true;

    /* renamed from: r */
    private CopyOnWriteArrayList<IPoint> f2558r = new CopyOnWriteArrayList<>();

    /* renamed from: s */
    private int f2559s = 0;

    /* renamed from: t */
    private boolean f2560t = false;

    /* renamed from: u */
    private LatLngBounds f2561u = null;

    /* renamed from: i */
    FPointBounds f2549i = null;

    public C0892db(AbstractC1115l abstractC1115l) {
        this.f2551k = abstractC1115l;
        try {
            this.f2557q = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "NavigateArrowDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private List<LatLng> m18649d() {
        if (this.f2558r != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<IPoint> it2 = this.f2558r.iterator();
            while (it2.hasNext()) {
                IPoint next = it2.next();
                if (next != null) {
                    DPoint dPoint = new DPoint();
                    this.f2551k.mo17535b(next.f4730x, next.f4731y, dPoint);
                    arrayList.add(new LatLng(dPoint.f4727y, dPoint.f4726x));
                }
            }
            return arrayList;
        }
        return null;
    }

    /* renamed from: a */
    void m18650a(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.f2558r.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (latLng != null && !latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.f2551k.mo17555a(latLng.latitude, latLng.longitude, iPoint);
                    this.f2558r.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
        }
        this.f2561u = builder.build();
        this.f2559s = 0;
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2558r == null || this.f2558r.size() == 0 || this.f2552l <= 0.0f) {
            return;
        }
        if (this.f2559s == 0) {
            mo18600b();
        }
        if (this.f2550j != null && this.f2559s > 0) {
            float mapLenWithWin = this.f2551k.mo17530c().getMapLenWithWin((int) this.f2552l);
            this.f2551k.mo17530c().getMapLenWithWin(1);
            AMapNativeRenderer.nativeDrawLineByTextureID(this.f2550j, this.f2550j.length, mapLenWithWin, this.f2551k.mo17538b(), this.f2542b, this.f2543c, this.f2544d, this.f2541a, 0.0f, false, true, true);
        }
        this.f2560t = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        if (this.f2549i != null) {
            return C0945eh.m18341a(this.f2549i.northeast, this.f2551k.mo17511p()) || C0945eh.m18341a(this.f2549i.southwest, this.f2551k.mo17511p());
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        int i = 0;
        this.f2560t = false;
        FPoint fPoint = new FPoint();
        FPointBounds.Builder builder = new FPointBounds.Builder();
        this.f2550j = new float[this.f2558r.size() * 3];
        Iterator<IPoint> it2 = this.f2558r.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                this.f2549i = builder.build();
                this.f2559s = this.f2558r.size();
                return true;
            }
            IPoint next = it2.next();
            this.f2551k.mo17534b(next.f4731y, next.f4730x, fPoint);
            this.f2550j[i2 * 3] = fPoint.f4728x;
            this.f2550j[(i2 * 3) + 1] = fPoint.f4729y;
            this.f2550j[(i2 * 3) + 2] = 0.0f;
            i = i2 + 1;
            builder.include(fPoint);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2560t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            if (this.f2550j == null) {
                return;
            }
            this.f2550j = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2557q == null) {
            this.f2557q = C1097j.m17627a("NavigateArrow");
        }
        return this.f2557q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public List<LatLng> getPoints() {
        return m18649d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public int getSideColor() {
        return this.f2554n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public int getTopColor() {
        return this.f2553m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public float getWidth() {
        return this.f2552l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2555o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f2556p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2551k.mo17540a(getId());
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setPoints(List<LatLng> list) {
        m18650a(list);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setSideColor(int i) {
        this.f2554n = i;
        this.f2545e = Color.alpha(i) / 255.0f;
        this.f2546f = Color.red(i) / 255.0f;
        this.f2547g = Color.green(i) / 255.0f;
        this.f2548h = Color.blue(i) / 255.0f;
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setTopColor(int i) {
        this.f2553m = i;
        this.f2541a = Color.alpha(i) / 255.0f;
        this.f2542b = Color.red(i) / 255.0f;
        this.f2543c = Color.green(i) / 255.0f;
        this.f2544d = Color.blue(i) / 255.0f;
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2556p = z;
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setWidth(float f) {
        this.f2552l = f;
        this.f2551k.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2555o = f;
        this.f2551k.mo17509r();
        this.f2551k.setRunLowFrame(false);
    }
}
