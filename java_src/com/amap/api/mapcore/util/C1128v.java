package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.v */
/* loaded from: classes.dex */
public class C1128v {

    /* renamed from: a */
    CopyOnWriteArrayList<AbstractC0888cy> f3533a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    C1130a f3534b = new C1130a();

    /* renamed from: c */
    CopyOnWriteArrayList<Integer> f3535c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    C0898dg f3536d;

    /* renamed from: e */
    private AbstractC1115l f3537e;

    /* renamed from: f */
    private Context f3538f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.v$a */
    /* loaded from: classes.dex */
    public static class C1130a implements Serializable, Comparator<Object> {
        C1130a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            AbstractC0888cy abstractC0888cy = (AbstractC0888cy) obj;
            AbstractC0888cy abstractC0888cy2 = (AbstractC0888cy) obj2;
            if (abstractC0888cy != null && abstractC0888cy2 != null) {
                try {
                    if (abstractC0888cy.getZIndex() > abstractC0888cy2.getZIndex()) {
                        return 1;
                    }
                    if (abstractC0888cy.getZIndex() < abstractC0888cy2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "TileOverlayView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public C1128v(Context context, AbstractC1115l abstractC1115l) {
        this.f3536d = null;
        this.f3537e = abstractC1115l;
        this.f3538f = context;
        this.f3536d = new C0898dg(new TileOverlayOptions().tileProvider(new AbstractC0922dr(256, 256) { // from class: com.amap.api.mapcore.util.v.1
            @Override // com.amap.api.mapcore.util.AbstractC0922dr
            /* renamed from: a */
            public String mo17454a(int i, int i2, int i3) {
                try {
                    return String.format("http://grid.amap.com/grid/%d/%d/%d?dpiType=webrd&lang=zh_cn&pack=%s&ds=0", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), C1022g.f3200b);
                } catch (Throwable th) {
                    return null;
                }
            }
        }), this, true);
    }

    /* renamed from: a */
    public AbstractC1115l m17468a() {
        return this.f3537e;
    }

    /* renamed from: a */
    public TileOverlay m17465a(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        C0898dg c0898dg = new C0898dg(tileOverlayOptions, this);
        m17466a(c0898dg);
        this.f3537e.setRunLowFrame(false);
        return new TileOverlay(c0898dg);
    }

    /* renamed from: a */
    public void m17467a(int i) {
        this.f3535c.add(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m17466a(AbstractC0888cy abstractC0888cy) {
        m17461b(abstractC0888cy);
        this.f3533a.add(abstractC0888cy);
        m17459c();
    }

    /* renamed from: a */
    public void m17464a(GL10 gl10) {
        try {
            Iterator<Integer> it2 = this.f3535c.iterator();
            while (it2.hasNext()) {
                C0945eh.m18331a(gl10, it2.next().intValue());
            }
            this.f3535c.clear();
            if (C1022g.f3201c == 0 && this.f3536d != null) {
                this.f3536d.mo18549a(gl10);
            }
            Iterator<AbstractC0888cy> it3 = this.f3533a.iterator();
            while (it3.hasNext()) {
                AbstractC0888cy next = it3.next();
                if (next.isVisible()) {
                    next.mo18549a(gl10);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void m17463a(boolean z) {
        try {
            if (C1022g.f3201c == 0) {
                CameraPosition cameraPosition = this.f3537e.getCameraPosition();
                if (cameraPosition == null || cameraPosition.zoom <= 10.0f || !cameraPosition.isAbroad || this.f3537e.getMapType() != 1) {
                    if (this.f3536d != null) {
                        this.f3536d.m18543c();
                    }
                } else if (this.f3536d != null) {
                    this.f3536d.mo18547a(z);
                }
            }
            Iterator<AbstractC0888cy> it2 = this.f3533a.iterator();
            while (it2.hasNext()) {
                AbstractC0888cy next = it2.next();
                if (next != null && next.isVisible()) {
                    next.mo18547a(z);
                }
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TileOverlayView", "refresh");
        }
    }

    /* renamed from: b */
    public void m17462b() {
        Iterator<AbstractC0888cy> it2 = this.f3533a.iterator();
        while (it2.hasNext()) {
            AbstractC0888cy next = it2.next();
            if (next != null) {
                next.remove();
            }
        }
        this.f3533a.clear();
    }

    /* renamed from: b */
    public void m17460b(boolean z) {
        if (this.f3536d != null) {
            this.f3536d.mo18544b(z);
        }
        Iterator<AbstractC0888cy> it2 = this.f3533a.iterator();
        while (it2.hasNext()) {
            AbstractC0888cy next = it2.next();
            if (next != null) {
                next.mo18544b(z);
            }
        }
    }

    /* renamed from: b */
    public boolean m17461b(AbstractC0888cy abstractC0888cy) {
        return this.f3533a.remove(abstractC0888cy);
    }

    /* renamed from: c */
    public void m17459c() {
        Object[] array = this.f3533a.toArray();
        Arrays.sort(array, this.f3534b);
        this.f3533a.clear();
        for (Object obj : array) {
            this.f3533a.add((AbstractC0888cy) obj);
        }
    }

    /* renamed from: d */
    public void m17458d() {
        if (this.f3536d != null) {
            this.f3536d.mo18557a();
        }
        Iterator<AbstractC0888cy> it2 = this.f3533a.iterator();
        while (it2.hasNext()) {
            AbstractC0888cy next = it2.next();
            if (next != null) {
                next.mo18557a();
            }
        }
    }

    /* renamed from: e */
    public Context m17457e() {
        return this.f3538f;
    }

    /* renamed from: f */
    public void m17456f() {
        m17462b();
        if (this.f3536d != null) {
            this.f3536d.remove();
        }
        this.f3536d = null;
    }

    /* renamed from: g */
    public void m17455g() {
        if (this.f3536d != null) {
            this.f3536d.mo18546b();
        }
        Iterator<AbstractC0888cy> it2 = this.f3533a.iterator();
        while (it2.hasNext()) {
            AbstractC0888cy next = it2.next();
            if (next != null) {
                next.mo18546b();
            }
        }
    }
}
