package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.dc */
/* loaded from: classes.dex */
public class C0893dc implements AbstractC0885cv {

    /* renamed from: u */
    private static float f2562u = 1.0E10f;

    /* renamed from: b */
    private AbstractC1115l f2564b;

    /* renamed from: e */
    private String f2567e;

    /* renamed from: f */
    private float f2568f;

    /* renamed from: g */
    private int f2569g;

    /* renamed from: h */
    private int f2570h;

    /* renamed from: i */
    private List<LatLng> f2571i;

    /* renamed from: l */
    private FloatBuffer f2574l;

    /* renamed from: m */
    private FloatBuffer f2575m;

    /* renamed from: c */
    private float f2565c = 0.0f;

    /* renamed from: d */
    private boolean f2566d = true;

    /* renamed from: j */
    private CopyOnWriteArrayList<IPoint> f2572j = new CopyOnWriteArrayList<>();

    /* renamed from: k */
    private List<FPoint> f2573k = new ArrayList();

    /* renamed from: n */
    private int f2576n = 0;

    /* renamed from: o */
    private int f2577o = 0;

    /* renamed from: p */
    private LatLngBounds f2578p = null;

    /* renamed from: q */
    private boolean f2579q = false;

    /* renamed from: r */
    private float f2580r = 0.0f;

    /* renamed from: s */
    private Object f2581s = new Object();

    /* renamed from: a */
    FPointBounds f2563a = null;

    /* renamed from: t */
    private float f2582t = 0.0f;

    public C0893dc(AbstractC1115l abstractC1115l) {
        this.f2564b = abstractC1115l;
        try {
            this.f2567e = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "PolygonDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m18648a(FPoint fPoint, FPoint fPoint2) {
        return Math.abs(fPoint2.f4728x - fPoint.f4728x) >= this.f2580r || Math.abs(fPoint2.f4729y - fPoint.f4729y) >= this.f2580r;
    }

    /* renamed from: a */
    static FPoint[] m18646a(FPoint[] fPointArr) {
        int length = fPointArr.length;
        float[] fArr = new float[length * 2];
        for (int i = 0; i < length; i++) {
            fArr[i * 2] = fPointArr[i].f4728x * f2562u;
            fArr[(i * 2) + 1] = fPointArr[i].f4729y * f2562u;
        }
        C0944eg m18469a = new C0925dt().m18469a(fArr);
        int i2 = m18469a.f2898b;
        FPoint[] fPointArr2 = new FPoint[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fPointArr2[i3] = new FPoint();
            fPointArr2[i3].f4728x = fArr[m18469a.m18370a(i3) * 2] / f2562u;
            fPointArr2[i3].f4729y = fArr[(m18469a.m18370a(i3) * 2) + 1] / f2562u;
        }
        return fPointArr2;
    }

    /* renamed from: b */
    private void m18645b(List<FPoint> list) {
        m18643d();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size < 2) {
            return;
        }
        FPoint fPoint = list.get(0);
        arrayList.add(fPoint);
        int i = 1;
        while (true) {
            int i2 = i;
            FPoint fPoint2 = fPoint;
            if (i2 >= size - 1) {
                break;
            }
            fPoint = list.get(i2);
            if (m18648a(fPoint2, fPoint)) {
                arrayList.add(fPoint);
            } else {
                fPoint = fPoint2;
            }
            i = i2 + 1;
        }
        arrayList.add(list.get(size - 1));
        float[] fArr = new float[arrayList.size() * 3];
        FPoint[] fPointArr = new FPoint[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            FPoint fPoint3 = (FPoint) it2.next();
            fArr[i3 * 3] = fPoint3.f4728x;
            fArr[(i3 * 3) + 1] = fPoint3.f4729y;
            fArr[(i3 * 3) + 2] = 0.0f;
            fPointArr[i3] = fPoint3;
            i3++;
        }
        FPoint[] m18646a = m18646a(fPointArr);
        if (m18646a.length == 0) {
            if (f2562u == 1.0E10f) {
                f2562u = 1.0E8f;
            } else {
                f2562u = 1.0E10f;
            }
            m18646a = m18646a(fPointArr);
        }
        float[] fArr2 = new float[m18646a.length * 3];
        int i4 = 0;
        for (FPoint fPoint4 : m18646a) {
            fArr2[i4 * 3] = fPoint4.f4728x;
            fArr2[(i4 * 3) + 1] = fPoint4.f4729y;
            fArr2[(i4 * 3) + 2] = 0.0f;
            i4++;
        }
        this.f2576n = fPointArr.length;
        this.f2577o = m18646a.length;
        this.f2574l = C0945eh.m18327a(fArr);
        this.f2575m = C0945eh.m18327a(fArr2);
    }

    /* renamed from: b */
    private boolean m18644b(FPoint[] fPointArr) {
        if (this.f2564b != null) {
            this.f2582t = this.f2564b.mo17512o();
            m18643d();
            if (this.f2582t <= 10.0f) {
                return false;
            }
            try {
                if (C0945eh.m18341a(this.f2563a.northeast, fPointArr)) {
                    if (C0945eh.m18341a(this.f2563a.southwest, fPointArr)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m18643d() {
        float mo17512o = this.f2564b.mo17512o();
        if (this.f2572j.size() <= 5000 || mo17512o > 12.0f) {
            this.f2580r = this.f2564b.mo17530c().getMapLenWithWin(10);
            return;
        }
        float f = (mo17512o / 2.0f) + (this.f2568f / 2.0f);
        if (f > 200.0f) {
            f = 200.0f;
        }
        this.f2580r = this.f2564b.mo17530c().getMapLenWithWin((int) f);
    }

    /* renamed from: a */
    void m18647a(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.f2572j.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.f2564b.mo17555a(latLng.latitude, latLng.longitude, iPoint);
                    this.f2572j.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.f2572j.size();
            if (size > 1) {
                IPoint iPoint2 = this.f2572j.get(0);
                IPoint iPoint3 = this.f2572j.get(size - 1);
                if (iPoint2.f4730x == iPoint3.f4730x && iPoint2.f4731y == iPoint3.f4731y) {
                    this.f2572j.remove(size - 1);
                }
            }
        }
        this.f2578p = builder.build();
        if (this.f2574l != null) {
            this.f2574l.clear();
        }
        if (this.f2575m != null) {
            this.f2575m.clear();
        }
        this.f2576n = 0;
        this.f2577o = 0;
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2572j == null || this.f2572j.size() == 0) {
            return;
        }
        if (this.f2574l == null || this.f2575m == null || this.f2576n == 0 || this.f2577o == 0) {
            mo18600b();
        }
        List<FPoint> list = this.f2573k;
        FPoint[] mo17511p = this.f2564b.mo17511p();
        if (m18644b(mo17511p)) {
            synchronized (this.f2581s) {
                list = C0945eh.m18325a(mo17511p, this.f2573k, true);
            }
        }
        if (list.size() > 2) {
            m18645b(list);
            if (this.f2574l != null && this.f2575m != null && this.f2576n > 0 && this.f2577o > 0) {
                C0926du.m18460a(gl10, this.f2569g, this.f2570h, this.f2574l, this.f2568f, this.f2575m, this.f2576n, this.f2577o);
            }
        }
        this.f2579q = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        synchronized (this.f2581s) {
            this.f2573k.clear();
            this.f2579q = false;
            FPointBounds.Builder builder = new FPointBounds.Builder();
            Iterator<IPoint> it2 = this.f2572j.iterator();
            while (it2.hasNext()) {
                IPoint next = it2.next();
                FPoint fPoint = new FPoint();
                this.f2564b.mo17534b(next.f4731y, next.f4730x, fPoint);
                this.f2573k.add(fPoint);
                builder.include(fPoint);
            }
            this.f2563a = builder.build();
            m18643d();
        }
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2579q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public boolean contains(LatLng latLng) {
        try {
            return C0945eh.m18345a(latLng, getPoints());
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            if (this.f2574l != null) {
                this.f2574l.clear();
                this.f2574l = null;
            }
            if (this.f2575m == null) {
                return;
            }
            this.f2575m = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolygonDelegateImp destroy");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public int getFillColor() {
        return this.f2569g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2567e == null) {
            this.f2567e = C1097j.m17627a(PoiSearch.SearchBound.POLYGON_SHAPE);
        }
        return this.f2567e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public List<LatLng> getPoints() {
        return this.f2571i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public int getStrokeColor() {
        return this.f2570h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public float getStrokeWidth() {
        return this.f2568f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2565c;
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
        return this.f2566d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2564b.mo17540a(getId());
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setFillColor(int i) {
        this.f2569g = i;
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setPoints(List<LatLng> list) {
        synchronized (this.f2581s) {
            this.f2571i = list;
            m18647a(list);
            mo18600b();
            this.f2564b.setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setStrokeColor(int i) {
        this.f2570h = i;
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setStrokeWidth(float f) {
        this.f2568f = f;
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2566d = z;
        this.f2564b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2565c = f;
        this.f2564b.mo17509r();
        this.f2564b.setRunLowFrame(false);
    }
}
