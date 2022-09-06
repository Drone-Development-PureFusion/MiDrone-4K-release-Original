package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.C0772ak;
import com.amap.api.mapcore.util.C0774al;
import com.amap.api.mapcore.util.C0778an;
import com.amap.api.mapcore.util.C0781ap;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
/* renamed from: com.amap.api.mapcore.util.h */
/* loaded from: classes.dex */
public class C1062h {

    /* renamed from: a */
    AbstractC1115l f3314a;

    /* renamed from: b */
    MapCore f3315b;

    /* renamed from: c */
    Context f3316c;

    /* renamed from: d */
    GestureDetector f3317d;

    /* renamed from: e */
    AMapGestureListener f3318e;

    /* renamed from: f */
    private C0778an f3319f;

    /* renamed from: g */
    private C0774al f3320g;

    /* renamed from: h */
    private C0772ak f3321h;

    /* renamed from: i */
    private C0781ap f3322i;

    /* renamed from: j */
    private boolean f3323j = false;

    /* renamed from: k */
    private int f3324k = 0;

    /* renamed from: l */
    private int f3325l = 0;

    /* renamed from: m */
    private int f3326m = 0;

    /* renamed from: n */
    private int f3327n = 0;

    /* renamed from: o */
    private int f3328o = 0;

    /* renamed from: p */
    private int f3329p = 0;

    /* renamed from: q */
    private boolean f3330q = false;

    /* renamed from: com.amap.api.mapcore.util.h$a */
    /* loaded from: classes.dex */
    private class GestureDetector$OnDoubleTapListenerC1064a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a */
        float f3331a;

        /* renamed from: b */
        long f3332b;

        /* renamed from: d */
        private int f3334d;

        private GestureDetector$OnDoubleTapListenerC1064a() {
            this.f3334d = 0;
            this.f3331a = 0.0f;
            this.f3332b = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            C1062h.this.f3317d.setIsLongpressEnabled(false);
            this.f3334d = motionEvent.getPointerCount();
            if (C1062h.this.f3318e != null) {
                C1062h.this.f3318e.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            boolean z = true;
            if (this.f3334d < motionEvent.getPointerCount()) {
                this.f3334d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f3334d == 1) {
                try {
                    if (!C1062h.this.f3314a.mo17514m().isZoomGesturesEnabled()) {
                        return false;
                    }
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                if (action == 0) {
                    this.f3331a = motionEvent.getY();
                    C1062h.this.f3315b.addGestureMessage(new C0789av(100, 1.0f, 0, 0));
                    this.f3332b = SystemClock.uptimeMillis();
                } else if (action == 2) {
                    C1062h.this.f3330q = true;
                    float y = this.f3331a - motionEvent.getY();
                    if (Math.abs(y) >= 2.0f) {
                        float mapHeight = (4.0f * y) / C1062h.this.f3314a.getMapHeight();
                        if (y > 0.0f) {
                            C1062h.this.f3315b.addGestureMessage(new C0789av(101, mapHeight, 0, 0));
                        } else {
                            C1062h.this.f3315b.addGestureMessage(new C0789av(101, mapHeight, 0, 0));
                        }
                        this.f3331a = motionEvent.getY();
                    }
                } else {
                    C1062h.this.f3317d.setIsLongpressEnabled(true);
                    C1062h.this.f3315b.addGestureMessage(new C0789av(102, 1.0f, 0, 0));
                    if (action == 1) {
                        long uptimeMillis = SystemClock.uptimeMillis() - this.f3332b;
                        if (!C1062h.this.f3330q || uptimeMillis < 200) {
                            return C1062h.this.f3314a.mo17524d(motionEvent);
                        }
                        C1062h.this.f3330q = false;
                    } else {
                        C1062h.this.f3330q = false;
                    }
                }
            } else {
                z = false;
            }
            return z;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C1062h.this.f3330q = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (C1062h.this.f3318e != null) {
                C1062h.this.f3318e.onFling(f, f2);
            }
            try {
                if (C1062h.this.f3314a.mo17514m().isScrollGesturesEnabled() && C1062h.this.f3327n <= 0 && C1062h.this.f3325l <= 0 && C1062h.this.f3326m == 0) {
                    C1062h.this.f3315b.startMapSlidAnim(new IPoint((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (C1062h.this.f3329p == 1) {
                C1062h.this.f3314a.mo17533b(motionEvent);
                if (C1062h.this.f3318e == null) {
                    return;
                }
                C1062h.this.f3318e.onLongPress(motionEvent.getX(), motionEvent.getY());
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (C1062h.this.f3318e != null) {
                C1062h.this.f3318e.onScroll(f, f2);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (C1062h.this.f3329p == 1) {
                if (C1062h.this.f3318e != null) {
                    C1062h.this.f3318e.onSingleTap(motionEvent.getX(), motionEvent.getY());
                }
                return C1062h.this.f3314a.mo17528c(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.h$b */
    /* loaded from: classes.dex */
    private class C1065b implements C0772ak.AbstractC0773a {
        private C1065b() {
        }

        @Override // com.amap.api.mapcore.util.C0772ak.AbstractC0773a
        /* renamed from: a */
        public boolean mo17734a(C0772ak c0772ak) {
            boolean z = false;
            try {
                if (!C1062h.this.f3314a.mo17514m().isTiltGesturesEnabled()) {
                    return true;
                }
                if (C1062h.this.f3326m > 3) {
                    return false;
                }
                float f = c0772ak.m19073c().x;
                float f2 = c0772ak.m19073c().y;
                if (!C1062h.this.f3323j) {
                    PointF a = c0772ak.a(0);
                    PointF a2 = c0772ak.a(1);
                    if ((a.y > 10.0f && a2.y > 10.0f) || (a.y < -10.0f && a2.y < -10.0f)) {
                        z = true;
                    }
                    if (z && Math.abs(f2) > 10.0f && Math.abs(f) < 10.0f) {
                        C1062h.this.f3323j = true;
                    }
                }
                if (!C1062h.this.f3323j) {
                    return true;
                }
                C1062h.this.f3323j = true;
                float f3 = f2 / 6.0f;
                if (Math.abs(f3) <= 1.0f) {
                    return true;
                }
                C1062h.this.f3315b.addGestureMessage(new C0786as(101, f3));
                C1062h.m17735k(C1062h.this);
                return true;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.C0772ak.AbstractC0773a
        /* renamed from: b */
        public boolean mo17733b(C0772ak c0772ak) {
            try {
                if (C1062h.this.f3314a.mo17514m().isTiltGesturesEnabled()) {
                    C1062h.this.f3315b.addGestureMessage(new C0786as(100, C1062h.this.f3314a.getCameraAngle()));
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.C0772ak.AbstractC0773a
        /* renamed from: c */
        public void mo17732c(C0772ak c0772ak) {
            try {
                if (!C1062h.this.f3314a.mo17514m().isTiltGesturesEnabled()) {
                    return;
                }
                C1062h.this.f3323j = false;
                C1062h.this.f3315b.addGestureMessage(new C0786as(102, C1062h.this.f3314a.getCameraAngle()));
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.h$c */
    /* loaded from: classes.dex */
    private class C1066c implements C0774al.AbstractC0775a {

        /* renamed from: b */
        private final float f3337b;

        private C1066c() {
            this.f3337b = 1.0f;
        }

        @Override // com.amap.api.mapcore.util.C0774al.AbstractC0775a
        /* renamed from: a */
        public boolean mo17731a(C0774al c0774al) {
            try {
                if (!C1062h.this.f3314a.mo17514m().isScrollGesturesEnabled() || C1062h.this.f3323j) {
                    return true;
                }
                PointF m19072c = c0774al.m19072c();
                if (Math.abs(m19072c.x) <= 1.0f && Math.abs(m19072c.y) <= 1.0f) {
                    return false;
                }
                C1062h.this.f3315b.addGestureMessage(new C0787at(101, m19072c.x, m19072c.y));
                C1062h.m17736j(C1062h.this);
                return true;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.C0774al.AbstractC0775a
        /* renamed from: b */
        public boolean mo17730b(C0774al c0774al) {
            try {
                if (C1062h.this.f3314a.mo17514m().isScrollGesturesEnabled()) {
                    C1062h.this.f3315b.addGestureMessage(new C0787at(100, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.C0774al.AbstractC0775a
        /* renamed from: c */
        public void mo17729c(C0774al c0774al) {
            try {
                if (!C1062h.this.f3314a.mo17514m().isScrollGesturesEnabled()) {
                    return;
                }
                C1062h.this.f3315b.addGestureMessage(new C0787at(102, 0.0f, 0.0f));
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.h$d */
    /* loaded from: classes.dex */
    private class C1067d extends C0778an.AbstractC0779a {

        /* renamed from: b */
        private final float f3339b;

        /* renamed from: c */
        private final float f3340c;

        /* renamed from: d */
        private final float f3341d;

        /* renamed from: e */
        private final float f3342e;

        /* renamed from: f */
        private boolean f3343f;

        /* renamed from: g */
        private boolean f3344g;

        /* renamed from: h */
        private boolean f3345h;

        /* renamed from: i */
        private PointF f3346i;

        private C1067d() {
            this.f3339b = 0.06f;
            this.f3340c = 0.01f;
            this.f3341d = 4.0f;
            this.f3342e = 1.0f;
            this.f3343f = false;
            this.f3344g = false;
            this.f3345h = false;
            this.f3346i = null;
        }

        @Override // com.amap.api.mapcore.util.C0778an.AbstractC0779a
        /* renamed from: a */
        public boolean mo17728a(C0778an c0778an) {
            boolean z = false;
            float i = c0778an.i();
            int i2 = -1;
            int i3 = -1;
            if (C1062h.this.f3328o == 0) {
                i2 = (int) c0778an.a();
                i3 = (int) c0778an.b();
            }
            float abs = Math.abs(i2 - this.f3346i.x);
            float abs2 = Math.abs(i3 - this.f3346i.y);
            this.f3346i.x = i2;
            this.f3346i.y = i3;
            float log = (float) Math.log(i);
            if (C1062h.this.f3325l <= 0 && Math.abs(log) > 0.2d) {
                this.f3345h = true;
            }
            try {
                if (C1062h.this.f3314a.mo17514m().isZoomGesturesEnabled()) {
                    if (!this.f3343f && 0.06f < Math.abs(log)) {
                        this.f3343f = true;
                    }
                    if (this.f3343f && 0.01f < Math.abs(log)) {
                        z = true;
                        if ((abs <= 2.0f && abs2 <= 2.0f) || Math.abs(log) >= 0.02f) {
                            C1062h.m17739g(C1062h.this);
                            C1062h.this.f3315b.addGestureMessage(new C0789av(101, log, i2, i3));
                        }
                    }
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onScaleRotate");
                th.printStackTrace();
                z = z;
            }
            try {
                if (C1062h.this.f3314a.mo17514m().isRotateGesturesEnabled() && !this.f3345h) {
                    float m19056j = c0778an.m19056j();
                    if (!this.f3344g && Math.abs(m19056j) >= 4.0f) {
                        this.f3344g = true;
                    }
                    if (this.f3344g && 1.0f < Math.abs(m19056j)) {
                        if ((abs > 4.0f || abs2 > 4.0f) && Math.abs(m19056j) < 2.0f) {
                            return z;
                        }
                        C1062h.this.f3315b.addGestureMessage(new C0788au(101, m19056j, i2, i3));
                        C1062h.m17738h(C1062h.this);
                        return true;
                    }
                }
            } catch (Throwable th2) {
                C1007fo.m18012b(th2, "GLMapGestrureDetector", "onScaleRotate");
                th2.printStackTrace();
            }
            return z;
        }

        @Override // com.amap.api.mapcore.util.C0778an.AbstractC0779a
        /* renamed from: b */
        public boolean mo17727b(C0778an c0778an) {
            int a = (int) c0778an.a();
            int b = (int) c0778an.b();
            this.f3345h = false;
            this.f3346i = new PointF(a, b);
            this.f3343f = false;
            this.f3344g = false;
            C1062h.this.f3315b.addGestureMessage(new C0789av(100, 1.0f, a, b));
            try {
                if (!C1062h.this.f3314a.mo17514m().isRotateGesturesEnabled()) {
                    return true;
                }
                C1062h.this.f3315b.addGestureMessage(new C0788au(100, C1062h.this.f3314a.mo17507y(), a, b));
                return true;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.C0778an.AbstractC0779a
        /* renamed from: c */
        public void mo17726c(C0778an c0778an) {
            this.f3345h = false;
            C1062h.this.f3315b.addGestureMessage(new C0789av(102, 1.0f, 0, 0));
            try {
                if (!C1062h.this.f3314a.mo17514m().isRotateGesturesEnabled()) {
                    return;
                }
                C1062h.this.f3315b.addGestureMessage(new C0788au(102, C1062h.this.f3314a.mo17507y(), 0, 0));
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.h$e */
    /* loaded from: classes.dex */
    private class C1068e extends C0781ap.C0783b {
        private C1068e() {
        }

        @Override // com.amap.api.mapcore.util.C0781ap.C0783b, com.amap.api.mapcore.util.C0781ap.AbstractC0782a
        /* renamed from: a */
        public void mo17725a(C0781ap c0781ap) {
            try {
                if (!C1062h.this.f3314a.mo17514m().isZoomGesturesEnabled() || c0781ap.b() >= 100) {
                    return;
                }
                try {
                    C1062h.this.f3314a.mo17532b(C0768ag.m19094b());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public C1062h(Context context, AbstractC1115l abstractC1115l) {
        this.f3316c = context;
        this.f3314a = abstractC1115l;
        this.f3315b = abstractC1115l.mo17557a();
        GestureDetector$OnDoubleTapListenerC1064a gestureDetector$OnDoubleTapListenerC1064a = new GestureDetector$OnDoubleTapListenerC1064a();
        this.f3317d = new GestureDetector(this.f3316c, gestureDetector$OnDoubleTapListenerC1064a);
        this.f3317d.setOnDoubleTapListener(gestureDetector$OnDoubleTapListenerC1064a);
        this.f3319f = new C0778an(this.f3316c, new C1067d());
        this.f3320g = new C0774al(this.f3316c, new C1066c());
        this.f3321h = new C0772ak(this.f3316c, new C1065b());
        this.f3322i = new C0781ap(this.f3316c, new C1068e());
    }

    /* renamed from: g */
    static /* synthetic */ int m17739g(C1062h c1062h) {
        int i = c1062h.f3325l;
        c1062h.f3325l = i + 1;
        return i;
    }

    /* renamed from: h */
    static /* synthetic */ int m17738h(C1062h c1062h) {
        int i = c1062h.f3326m;
        c1062h.f3326m = i + 1;
        return i;
    }

    /* renamed from: j */
    static /* synthetic */ int m17736j(C1062h c1062h) {
        int i = c1062h.f3324k;
        c1062h.f3324k = i + 1;
        return i;
    }

    /* renamed from: k */
    static /* synthetic */ int m17735k(C1062h c1062h) {
        int i = c1062h.f3327n;
        c1062h.f3327n = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m17750a() {
        this.f3324k = 0;
        this.f3326m = 0;
        this.f3325l = 0;
        this.f3327n = 0;
        this.f3329p = 0;
    }

    /* renamed from: a */
    public void m17746a(AMapGestureListener aMapGestureListener) {
        this.f3318e = aMapGestureListener;
    }

    /* renamed from: a */
    public boolean m17749a(MotionEvent motionEvent) {
        if (this.f3329p < motionEvent.getPointerCount()) {
            this.f3329p = motionEvent.getPointerCount();
        }
        if (this.f3330q && this.f3329p >= 2) {
            this.f3330q = false;
        }
        try {
            if (this.f3318e != null) {
                if (motionEvent.getAction() == 0) {
                    this.f3318e.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f3318e.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f3317d.onTouchEvent(motionEvent);
            boolean a = this.f3321h.a(motionEvent);
            if (this.f3323j && this.f3327n > 0) {
                return a;
            }
            this.f3322i.a(motionEvent);
            if (this.f3330q) {
                return a;
            }
            this.f3319f.a(motionEvent);
            return this.f3320g.a(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }
}
