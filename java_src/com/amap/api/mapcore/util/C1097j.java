package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.j */
/* loaded from: classes.dex */
public class C1097j {

    /* renamed from: c */
    private static int f3428c = 0;

    /* renamed from: a */
    AbstractC1115l f3429a;

    /* renamed from: d */
    private CopyOnWriteArrayList<AbstractC0883ct> f3431d = new CopyOnWriteArrayList<>(new ArrayList(500));

    /* renamed from: e */
    private CopyOnWriteArrayList<Integer> f3432e = new CopyOnWriteArrayList<>();

    /* renamed from: f */
    private Handler f3433f = new Handler();

    /* renamed from: g */
    private Runnable f3434g = new Runnable() { // from class: com.amap.api.mapcore.util.j.1
        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                synchronized (C1097j.this) {
                    ArrayList arrayList = new ArrayList(C1097j.this.f3431d);
                    Collections.sort(arrayList, C1097j.this.f3430b);
                    C1097j.this.f3431d = new CopyOnWriteArrayList(arrayList);
                }
            } finally {
            }
        }
    };

    /* renamed from: b */
    C1099a f3430b = new C1099a();

    /* renamed from: com.amap.api.mapcore.util.j$a */
    /* loaded from: classes.dex */
    static class C1099a implements Serializable, Comparator<Object> {
        C1099a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            AbstractC0883ct abstractC0883ct = (AbstractC0883ct) obj;
            AbstractC0883ct abstractC0883ct2 = (AbstractC0883ct) obj2;
            if (abstractC0883ct != null && abstractC0883ct2 != null) {
                try {
                    if (abstractC0883ct.getZIndex() > abstractC0883ct2.getZIndex()) {
                        return 1;
                    }
                    if (abstractC0883ct.getZIndex() < abstractC0883ct2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "GLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public C1097j(AbstractC1115l abstractC1115l) {
        this.f3429a = abstractC1115l;
    }

    /* renamed from: a */
    public static String m17627a(String str) {
        f3428c++;
        return str + f3428c;
    }

    /* renamed from: a */
    public static void m17639a() {
        f3428c = 0;
    }

    /* renamed from: a */
    private void m17638a(AbstractC0883ct abstractC0883ct) {
        this.f3431d.add(abstractC0883ct);
        m17622c();
    }

    /* renamed from: a */
    public synchronized AbstractC0877cn m17635a(ArcOptions arcOptions) {
        C0873cj c0873cj;
        if (arcOptions == null) {
            c0873cj = null;
        } else {
            c0873cj = new C0873cj(this.f3429a);
            c0873cj.setStrokeColor(arcOptions.getStrokeColor());
            c0873cj.m18713a(arcOptions.getStart());
            c0873cj.m18711b(arcOptions.getPassed());
            c0873cj.m18710c(arcOptions.getEnd());
            c0873cj.setVisible(arcOptions.isVisible());
            c0873cj.setStrokeWidth(arcOptions.getStrokeWidth());
            c0873cj.setZIndex(arcOptions.getZIndex());
            m17638a(c0873cj);
        }
        return c0873cj;
    }

    /* renamed from: a */
    public synchronized AbstractC0878co m17634a(CircleOptions circleOptions) {
        C0874ck c0874ck;
        if (circleOptions == null) {
            c0874ck = null;
        } else {
            c0874ck = new C0874ck(this.f3429a);
            c0874ck.setFillColor(circleOptions.getFillColor());
            c0874ck.setCenter(circleOptions.getCenter());
            c0874ck.setVisible(circleOptions.isVisible());
            c0874ck.setStrokeWidth(circleOptions.getStrokeWidth());
            c0874ck.setZIndex(circleOptions.getZIndex());
            c0874ck.setStrokeColor(circleOptions.getStrokeColor());
            c0874ck.setRadius(circleOptions.getRadius());
            m17638a(c0874ck);
        }
        return c0874ck;
    }

    /* renamed from: a */
    public synchronized AbstractC0879cp m17633a(GroundOverlayOptions groundOverlayOptions) {
        C0876cm c0876cm;
        if (groundOverlayOptions == null) {
            c0876cm = null;
        } else {
            c0876cm = new C0876cm(this.f3429a);
            c0876cm.m18704a(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
            c0876cm.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
            c0876cm.setImage(groundOverlayOptions.getImage());
            c0876cm.setPosition(groundOverlayOptions.getLocation());
            c0876cm.setPositionFromBounds(groundOverlayOptions.getBounds());
            c0876cm.setBearing(groundOverlayOptions.getBearing());
            c0876cm.setTransparency(groundOverlayOptions.getTransparency());
            c0876cm.setVisible(groundOverlayOptions.isVisible());
            c0876cm.setZIndex(groundOverlayOptions.getZIndex());
            m17638a(c0876cm);
        }
        return c0876cm;
    }

    /* renamed from: a */
    public synchronized AbstractC0882cs m17631a(NavigateArrowOptions navigateArrowOptions) {
        C0892db c0892db;
        if (navigateArrowOptions == null) {
            c0892db = null;
        } else {
            c0892db = new C0892db(this.f3429a);
            c0892db.setTopColor(navigateArrowOptions.getTopColor());
            c0892db.setPoints(navigateArrowOptions.getPoints());
            c0892db.setVisible(navigateArrowOptions.isVisible());
            c0892db.setWidth(navigateArrowOptions.getWidth());
            c0892db.setZIndex(navigateArrowOptions.getZIndex());
            m17638a(c0892db);
        }
        return c0892db;
    }

    /* renamed from: a */
    public synchronized AbstractC0883ct m17632a(LatLng latLng) {
        AbstractC0883ct abstractC0883ct;
        Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                abstractC0883ct = null;
                break;
            }
            abstractC0883ct = it2.next();
            if (abstractC0883ct != null && abstractC0883ct.mo18595c() && (abstractC0883ct instanceof AbstractC0886cw) && ((AbstractC0886cw) abstractC0883ct).mo18641a(latLng)) {
                break;
            }
        }
        return abstractC0883ct;
    }

    /* renamed from: a */
    public synchronized AbstractC0885cv m17630a(PolygonOptions polygonOptions) {
        C0893dc c0893dc;
        if (polygonOptions == null) {
            c0893dc = null;
        } else {
            c0893dc = new C0893dc(this.f3429a);
            c0893dc.setFillColor(polygonOptions.getFillColor());
            c0893dc.setPoints(polygonOptions.getPoints());
            c0893dc.setVisible(polygonOptions.isVisible());
            c0893dc.setStrokeWidth(polygonOptions.getStrokeWidth());
            c0893dc.setZIndex(polygonOptions.getZIndex());
            c0893dc.setStrokeColor(polygonOptions.getStrokeColor());
            m17638a(c0893dc);
        }
        return c0893dc;
    }

    /* renamed from: a */
    public synchronized AbstractC0886cw m17629a(PolylineOptions polylineOptions) {
        C0894dd c0894dd;
        if (polylineOptions == null) {
            c0894dd = null;
        } else {
            c0894dd = new C0894dd(this, polylineOptions);
            m17638a(c0894dd);
        }
        return c0894dd;
    }

    /* renamed from: a */
    public void m17628a(Integer num) {
        if (num.intValue() != 0) {
            this.f3432e.add(num);
        }
    }

    /* renamed from: a */
    public void m17626a(GL10 gl10) {
        Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
        while (it2.hasNext()) {
            AbstractC0883ct next = it2.next();
            try {
                if (next.isVisible() && next.isAboveMaskLayer() && next.mo18613a()) {
                    next.mo18604a(gl10);
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLOverlayLayer", "draw");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m17625a(GL10 gl10, boolean z, int i) {
        Iterator<Integer> it2 = this.f3432e.iterator();
        while (it2.hasNext()) {
            gl10.glDeleteTextures(1, new int[]{it2.next().intValue()}, 0);
        }
        this.f3432e.clear();
        int size = this.f3431d.size();
        Iterator<AbstractC0883ct> it3 = this.f3431d.iterator();
        while (it3.hasNext()) {
            AbstractC0883ct next = it3.next();
            try {
                if (next.isVisible()) {
                    if (size > 20) {
                        if (next.mo18613a()) {
                            if (z) {
                                if (next.getZIndex() <= i) {
                                    next.mo18604a(gl10);
                                }
                            } else if (next.getZIndex() > i) {
                                next.mo18604a(gl10);
                            }
                        }
                    } else if (z) {
                        if (next.getZIndex() <= i) {
                            next.mo18604a(gl10);
                        }
                    } else if (next.getZIndex() > i) {
                        next.mo18604a(gl10);
                    }
                }
            } catch (RemoteException e) {
                C1007fo.m18012b(e, "GLOverlayLayer", "draw");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public synchronized void m17624b() {
        try {
            Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            m17623b(null);
        } finally {
        }
    }

    /* renamed from: b */
    public synchronized void m17623b(String str) {
        if (str != null) {
            try {
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLOverlayLayer", "clear");
                th.printStackTrace();
                Log.d("amapApi", "GLOverlayLayer clear erro" + th.getMessage());
            }
            if (str.trim().length() != 0) {
                Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
                while (it2.hasNext()) {
                    AbstractC0883ct next = it2.next();
                    if (!str.equals(next.getId())) {
                        this.f3431d.remove(next);
                    }
                }
            }
        }
        this.f3431d.clear();
        m17639a();
    }

    /* renamed from: c */
    synchronized AbstractC0883ct m17621c(String str) {
        AbstractC0883ct abstractC0883ct;
        Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                abstractC0883ct = null;
                break;
            }
            abstractC0883ct = it2.next();
            if (abstractC0883ct != null && abstractC0883ct.getId().equals(str)) {
                break;
            }
        }
        return abstractC0883ct;
    }

    /* renamed from: c */
    public synchronized void m17622c() {
        this.f3433f.removeCallbacks(this.f3434g);
        this.f3433f.postDelayed(this.f3434g, 10L);
    }

    /* renamed from: d */
    public synchronized void m17620d() {
        Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
        while (it2.hasNext()) {
            AbstractC0883ct next = it2.next();
            if (next != null) {
                try {
                    next.mo18600b();
                } catch (RemoteException e) {
                    C1007fo.m18012b(e, "GLOverlayLayer", "calMapFPoint");
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    public synchronized boolean m17619d(String str) {
        AbstractC0883ct m17621c;
        m17621c = m17621c(str);
        return m17621c != null ? this.f3431d.remove(m17621c) : false;
    }

    /* renamed from: e */
    public AbstractC1115l m17618e() {
        return this.f3429a;
    }

    /* renamed from: f */
    public void m17617f() {
        Iterator<AbstractC0883ct> it2 = this.f3431d.iterator();
        while (it2.hasNext()) {
            AbstractC0883ct next = it2.next();
            if (next != null) {
                if (next instanceof AbstractC0886cw) {
                    ((AbstractC0886cw) next).mo18622d();
                } else if (next instanceof AbstractC0879cp) {
                    ((AbstractC0879cp) next).mo18697d();
                }
            }
        }
    }
}
