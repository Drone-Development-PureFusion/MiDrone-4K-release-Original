package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.q */
/* loaded from: classes.dex */
public class C1120q {

    /* renamed from: a */
    AbstractC1115l f3501a;

    /* renamed from: e */
    private IPoint f3505e;

    /* renamed from: f */
    private AbstractC0881cr f3506f;

    /* renamed from: c */
    private CopyOnWriteArrayList<AbstractC0884cu> f3503c = new CopyOnWriteArrayList<>(new ArrayList(500));

    /* renamed from: d */
    private CopyOnWriteArrayList<Integer> f3504d = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    C1123a f3502b = new C1123a();

    /* renamed from: g */
    private Handler f3507g = new Handler();

    /* renamed from: h */
    private Runnable f3508h = new Runnable() { // from class: com.amap.api.mapcore.util.q.1
        @Override // java.lang.Runnable
        public synchronized void run() {
            C1120q.this.m17479i();
        }
    };

    /* renamed from: i */
    private boolean f3509i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.q$a */
    /* loaded from: classes.dex */
    public static class C1123a implements Serializable, Comparator<Object> {
        C1123a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            AbstractC0884cu abstractC0884cu = (AbstractC0884cu) obj;
            AbstractC0884cu abstractC0884cu2 = (AbstractC0884cu) obj2;
            if (abstractC0884cu != null && abstractC0884cu2 != null) {
                try {
                    if (abstractC0884cu.getZIndex() > abstractC0884cu2.getZIndex()) {
                        return 1;
                    }
                    if (abstractC0884cu.getZIndex() < abstractC0884cu2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "MapOverlayImageView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public C1120q(Context context, AbstractC1115l abstractC1115l) {
        this.f3501a = abstractC1115l;
    }

    /* renamed from: d */
    private void m17485d(AbstractC0884cu abstractC0884cu) {
        try {
            this.f3503c.add(abstractC0884cu);
            m17481g();
        } catch (OutOfMemoryError e) {
            C1007fo.m18012b(e, "MapOverlayImageView", "addMarker");
        }
    }

    /* renamed from: e */
    private boolean m17483e(AbstractC0884cu abstractC0884cu) {
        switch (this.f3501a.mo17558A()) {
            case -1:
            case 1:
            default:
                return true;
            case 0:
                return !abstractC0884cu.mo18558m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m17479i() {
        try {
            ArrayList arrayList = new ArrayList(this.f3503c);
            Collections.sort(arrayList, this.f3502b);
            this.f3503c = new CopyOnWriteArrayList<>(arrayList);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    /* renamed from: a */
    public int m17497a(IMarkerAction iMarkerAction, Rect rect) {
        int displayLevel;
        Rect mo18563h;
        int displayLevel2 = iMarkerAction.getDisplayLevel();
        int i = 0;
        if (displayLevel2 == 0) {
            return 0;
        }
        Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                return i2;
            }
            AbstractC0884cu next = it2.next();
            IMarkerAction iMarkerAction2 = next.getIMarkerAction();
            if (iMarkerAction2 == null || (displayLevel = iMarkerAction2.getDisplayLevel()) == 0 || displayLevel2 <= displayLevel || (mo18563h = next.mo18563h()) == null || !Rect.intersects(rect, mo18563h)) {
                i = i2;
            } else if (i2 == 0) {
                i = displayLevel;
            } else {
                if (i2 > displayLevel) {
                    i2 = displayLevel;
                }
                i = i2;
            }
        }
    }

    /* renamed from: a */
    public AbstractC0881cr m17503a(MotionEvent motionEvent) {
        for (int size = this.f3503c.size() - 1; size >= 0; size--) {
            AbstractC0884cu abstractC0884cu = this.f3503c.get(size);
            if ((abstractC0884cu instanceof C0889cz) && C0945eh.m18353a(abstractC0884cu.mo18563h(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f3506f = (AbstractC0881cr) abstractC0884cu;
                return this.f3506f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC1115l m17504a() {
        return this.f3501a;
    }

    /* renamed from: a */
    public Marker m17499a(MarkerOptions markerOptions) {
        Marker marker;
        if (markerOptions == null) {
            return null;
        }
        synchronized (this) {
            C0889cz c0889cz = new C0889cz(markerOptions, this);
            m17485d(c0889cz);
            marker = new Marker(c0889cz);
        }
        return marker;
    }

    /* renamed from: a */
    public Text m17498a(TextOptions textOptions) {
        Text text;
        if (textOptions == null) {
            return null;
        }
        synchronized (this) {
            C0897df c0897df = new C0897df(textOptions, this);
            m17485d(c0897df);
            text = new Text(c0897df);
        }
        return text;
    }

    /* renamed from: a */
    public ArrayList<Marker> m17494a(ArrayList<MarkerOptions> arrayList, boolean z) {
        int i;
        MarkerOptions markerOptions;
        int i2 = 0;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() != 1 || (markerOptions = arrayList.get(0)) == null) {
                final LatLngBounds.Builder builder = LatLngBounds.builder();
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    MarkerOptions markerOptions2 = arrayList.get(i3);
                    if (arrayList.get(i3) != null) {
                        arrayList2.add(m17499a(markerOptions2));
                        if (markerOptions2.getPosition() != null) {
                            builder.include(markerOptions2.getPosition());
                            i = i2 + 1;
                            i3++;
                            i2 = i;
                        }
                    }
                    i = i2;
                    i3++;
                    i2 = i;
                }
                if (z && i2 > 0) {
                    this.f3501a.getMainHandler().postDelayed(new Runnable() { // from class: com.amap.api.mapcore.util.q.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C1120q.this.f3501a.mo17542a(C0768ag.m19098a(builder.build(), 50));
                            } catch (Throwable th) {
                            }
                        }
                    }, 50L);
                }
            } else {
                arrayList2.add(m17499a(markerOptions));
                if (z && markerOptions.getPosition() != null) {
                    this.f3501a.mo17542a(C0768ag.m19099a(markerOptions.getPosition(), 18.0f));
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    /* renamed from: a */
    public void m17502a(AbstractC0881cr abstractC0881cr) {
        if (this.f3505e == null) {
            this.f3505e = new IPoint();
        }
        Rect h = abstractC0881cr.h();
        this.f3505e = new IPoint(h.left + (h.width() / 2), h.top);
        this.f3506f = abstractC0881cr;
        try {
            this.f3501a.mo17546a(this.f3506f);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m17496a(Integer num) {
        if (num.intValue() != 0) {
            this.f3504d.add(num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[Catch: RemoteException -> 0x002c, all -> 0x0041, TRY_ENTER, TryCatch #1 {RemoteException -> 0x002c, blocks: (B:28:0x0003, B:5:0x000e, B:7:0x0016, B:8:0x001c, B:10:0x0022, B:12:0x003b, B:16:0x0044, B:17:0x004a, B:19:0x0050, B:22:0x0060), top: B:27:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[Catch: RemoteException -> 0x002c, all -> 0x0041, TryCatch #1 {RemoteException -> 0x002c, blocks: (B:28:0x0003, B:5:0x000e, B:7:0x0016, B:8:0x001c, B:10:0x0022, B:12:0x003b, B:16:0x0044, B:17:0x004a, B:19:0x0050, B:22:0x0060), top: B:27:0x0003, outer: #0 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m17495a(String str) {
        boolean z;
        if (str != null) {
            try {
            } catch (RemoteException e) {
                C1007fo.m18012b(e, "MapOverlayImageView", "clear");
                e.printStackTrace();
            }
            if (str.trim().length() != 0) {
                z = false;
                this.f3506f = null;
                this.f3505e = null;
                if (!z) {
                    Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
                    while (it2.hasNext()) {
                        it2.next().remove();
                    }
                    this.f3503c.clear();
                } else {
                    Iterator<AbstractC0884cu> it3 = this.f3503c.iterator();
                    while (it3.hasNext()) {
                        AbstractC0884cu next = it3.next();
                        if (!str.equals(next.getId())) {
                            next.remove();
                        }
                    }
                }
            }
        }
        z = true;
        this.f3506f = null;
        this.f3505e = null;
        if (!z) {
        }
    }

    /* renamed from: a */
    public void m17493a(GL10 gl10) {
        Iterator<Integer> it2 = this.f3504d.iterator();
        while (it2.hasNext()) {
            gl10.glDeleteTextures(1, new int[]{it2.next().intValue()}, 0);
        }
        this.f3504d.clear();
        Iterator<AbstractC0884cu> it3 = this.f3503c.iterator();
        while (it3.hasNext()) {
            AbstractC0884cu next = it3.next();
            if (m17483e(next)) {
                this.f3509i = next.mo18561j();
                if (next.mo18560k() || next.isInfoWindowShown()) {
                    next.mo18568a(gl10, this.f3501a);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m17501a(AbstractC0884cu abstractC0884cu) {
        m17487c(abstractC0884cu);
        return this.f3503c.remove(abstractC0884cu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized int m17492b() {
        return this.f3503c.size();
    }

    /* renamed from: b */
    public synchronized void m17490b(AbstractC0884cu abstractC0884cu) {
        try {
            if (this.f3503c.remove(abstractC0884cu)) {
                m17479i();
                this.f3503c.add(abstractC0884cu);
            }
        } finally {
        }
    }

    /* renamed from: b */
    public void m17489b(GL10 gl10) {
        Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
        while (it2.hasNext()) {
            AbstractC0884cu next = it2.next();
            if (next.mo18558m()) {
                this.f3509i = next.mo18561j();
                if (next.mo18560k() || next.isInfoWindowShown()) {
                    next.mo18568a(gl10, this.f3501a);
                }
            }
        }
    }

    /* renamed from: b */
    public boolean m17491b(MotionEvent motionEvent) {
        Rect mo18563h;
        boolean m18353a;
        for (int size = this.f3503c.size() - 1; size >= 0; size--) {
            AbstractC0884cu abstractC0884cu = this.f3503c.get(size);
            if ((abstractC0884cu instanceof C0889cz) && abstractC0884cu.isVisible() && ((C0889cz) abstractC0884cu).isClickable() && (m18353a = C0945eh.m18353a((mo18563h = abstractC0884cu.mo18563h()), (int) motionEvent.getX(), (int) motionEvent.getY()))) {
                this.f3505e = new IPoint(mo18563h.left + (mo18563h.width() / 2), mo18563h.top);
                this.f3506f = (AbstractC0881cr) abstractC0884cu;
                return m18353a;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m17488c() {
        synchronized (this) {
            Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
            while (it2.hasNext()) {
                AbstractC0884cu next = it2.next();
                if (next.isVisible()) {
                    next.mo18562i();
                }
            }
        }
    }

    /* renamed from: c */
    public void m17487c(AbstractC0884cu abstractC0884cu) {
        try {
            if (abstractC0884cu.isInfoWindowShown()) {
                this.f3501a.mo17513n();
                this.f3506f = null;
            } else if (this.f3506f != null && this.f3506f.getId() == abstractC0884cu.getId()) {
                this.f3506f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    public AbstractC0881cr m17486d() {
        return this.f3506f;
    }

    /* renamed from: e */
    public synchronized void m17484e() {
        try {
            Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
            while (it2.hasNext()) {
                AbstractC0884cu next = it2.next();
                if (next != null) {
                    next.destroy();
                }
            }
            m17495a((String) null);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
    }

    /* renamed from: f */
    public synchronized List<Marker> m17482f() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
        while (it2.hasNext()) {
            AbstractC0884cu next = it2.next();
            if ((next instanceof C0889cz) && next.mo18560k()) {
                arrayList.add(new Marker((IMarker) next));
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public synchronized void m17481g() {
        this.f3507g.removeCallbacks(this.f3508h);
        this.f3507g.postDelayed(this.f3508h, 10L);
    }

    /* renamed from: h */
    public void m17480h() {
        Iterator<AbstractC0884cu> it2 = this.f3503c.iterator();
        while (it2.hasNext()) {
            AbstractC0884cu next = it2.next();
            if (next != null) {
                next.mo18559l();
            }
        }
    }
}
