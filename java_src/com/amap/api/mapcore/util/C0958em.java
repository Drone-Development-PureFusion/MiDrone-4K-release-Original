package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p001v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
/* renamed from: com.amap.api.mapcore.util.em */
/* loaded from: classes.dex */
public class C0958em extends ViewGroup implements AbstractC0880cq {

    /* renamed from: c */
    private AbstractC1115l f2954c;

    /* renamed from: d */
    private Context f2955d;

    /* renamed from: e */
    private C0962eo f2956e;

    /* renamed from: f */
    private C0956el f2957f;

    /* renamed from: g */
    private C0947ej f2958g;

    /* renamed from: h */
    private C0961en f2959h;

    /* renamed from: i */
    private C0946ei f2960i;

    /* renamed from: j */
    private C0949ek f2961j;

    /* renamed from: k */
    private C0963ep f2962k;

    /* renamed from: l */
    private View f2963l;

    /* renamed from: m */
    private View f2964m;

    /* renamed from: n */
    private TextView f2965n;

    /* renamed from: o */
    private TextView f2966o;

    /* renamed from: p */
    private AbstractC0881cr f2967p;

    /* renamed from: r */
    private AMap.InfoWindowAdapter f2969r;

    /* renamed from: q */
    private Drawable f2968q = null;

    /* renamed from: s */
    private boolean f2970s = true;

    /* renamed from: t */
    private AMap.InfoWindowAdapter f2971t = new AMap.InfoWindowAdapter() { // from class: com.amap.api.mapcore.util.em.1
        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            try {
                if (C0958em.this.f2968q == null) {
                    C0958em.this.f2968q = C0940ec.m18383a(C0958em.this.f2955d, "infowindow_bg.9.png");
                }
                if (C0958em.this.f2964m == null) {
                    C0958em.this.f2964m = new LinearLayout(C0958em.this.f2955d);
                    C0958em.this.f2964m.setBackground(C0958em.this.f2968q);
                    C0958em.this.f2965n = new TextView(C0958em.this.f2955d);
                    C0958em.this.f2965n.setText(marker.getTitle());
                    C0958em.this.f2965n.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    C0958em.this.f2966o = new TextView(C0958em.this.f2955d);
                    C0958em.this.f2966o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    C0958em.this.f2966o.setText(marker.getSnippet());
                    ((LinearLayout) C0958em.this.f2964m).setOrientation(1);
                    ((LinearLayout) C0958em.this.f2964m).addView(C0958em.this.f2965n);
                    ((LinearLayout) C0958em.this.f2964m).addView(C0958em.this.f2966o);
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return C0958em.this.f2964m;
        }
    };

    /* renamed from: a */
    int f2952a = 0;

    /* renamed from: b */
    int f2953b = 0;

    /* renamed from: com.amap.api.mapcore.util.em$a */
    /* loaded from: classes.dex */
    public static class C0960a extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public FPoint f2973a;

        /* renamed from: b */
        public int f2974b;

        /* renamed from: c */
        public int f2975c;

        /* renamed from: d */
        public int f2976d;

        public C0960a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.f2973a = null;
            this.f2974b = 0;
            this.f2975c = 0;
            this.f2976d = 51;
            this.f2973a = fPoint;
            this.f2974b = i3;
            this.f2975c = i4;
            this.f2976d = i5;
        }
    }

    public C0958em(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        this.f2954c = abstractC1115l;
        this.f2955d = context;
        setBackgroundColor(-1);
        m18267a(context);
    }

    /* renamed from: a */
    private void m18267a(Context context) {
        this.f2956e = new C0962eo(context, this.f2954c);
        this.f2959h = new C0961en(context, this.f2954c);
        this.f2960i = new C0946ei(context);
        this.f2961j = new C0949ek(context);
        this.f2962k = new C0963ep(context, this.f2954c);
        this.f2957f = new C0956el(context, this.f2954c);
        this.f2958g = new C0947ej(context, this.f2954c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f2954c.mo17506z(), 0, layoutParams);
        addView(this.f2960i, 1, layoutParams);
        addView(this.f2956e, layoutParams);
        addView(this.f2959h, layoutParams);
        addView(this.f2961j, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f2962k, new C0960a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.f2957f, new C0960a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.f2958g, new C0960a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 51));
        this.f2958g.setVisibility(8);
        this.f2969r = this.f2971t;
        try {
            if (this.f2954c.mo17514m().isMyLocationButtonEnabled()) {
                return;
            }
            this.f2957f.setVisibility(8);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m18264a(View view, int i, int i2) {
        int i3;
        int i4 = -2;
        if (view == null) {
            return;
        }
        if (this.f2963l != null) {
            if (view == this.f2963l) {
                return;
            }
            this.f2963l.clearFocus();
            removeView(this.f2963l);
        }
        this.f2963l = view;
        ViewGroup.LayoutParams layoutParams = this.f2963l.getLayoutParams();
        this.f2963l.setDrawingCacheEnabled(true);
        this.f2963l.setDrawingCacheQuality(0);
        this.f2967p.h();
        if (layoutParams != null) {
            i3 = layoutParams.width;
            i4 = layoutParams.height;
        } else {
            i3 = -2;
        }
        addView(this.f2963l, new C0960a(i3, i4, this.f2967p.mo18696a(), i, i2, 81));
    }

    /* renamed from: a */
    private void m18263a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & 112;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 17) {
            i4 -= i2 / 2;
        } else if (i7 == 16) {
            i4 = (i4 / 2) - (i2 / 2);
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
    }

    /* renamed from: a */
    private void m18262a(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    /* renamed from: a */
    private void m18261a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        m18262a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof C0949ek) {
            m18263a(view, iArr[0], iArr[1], 20, (this.f2954c.mo17510q().y - 80) - iArr[1], 51);
        } else {
            m18263a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    /* renamed from: a */
    private void m18260a(View view, C0960a c0960a) {
        int[] iArr = new int[2];
        m18262a(view, c0960a.width, c0960a.height, iArr);
        if (view instanceof C0963ep) {
            m18263a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), c0960a.f2976d);
        } else if (view instanceof C0956el) {
            m18263a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c0960a.f2976d);
        } else if (view instanceof C0947ej) {
            m18263a(view, iArr[0], iArr[1], 0, 0, c0960a.f2976d);
        } else if (c0960a.f2973a == null) {
        } else {
            IPoint iPoint = new IPoint();
            this.f2954c.mo17530c().map2Win(c0960a.f2973a.f4728x, c0960a.f2973a.f4729y, iPoint);
            iPoint.f4730x += c0960a.f2974b;
            iPoint.f4731y += c0960a.f2975c;
            m18263a(view, iArr[0], iArr[1], iPoint.f4730x, iPoint.f4731y, c0960a.f2976d);
        }
    }

    /* renamed from: b */
    private View m18249b(AbstractC0881cr abstractC0881cr) {
        View view;
        Throwable th;
        Marker marker = new Marker(abstractC0881cr);
        try {
            if (this.f2968q == null) {
                this.f2968q = C0940ec.m18383a(this.f2955d, "infowindow_bg.9.png");
            }
        } catch (Throwable th2) {
            C1007fo.m18012b(th2, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
            th2.printStackTrace();
        }
        try {
            View infoWindow = this.f2969r.getInfoWindow(marker);
            if (infoWindow == null) {
                try {
                    infoWindow = this.f2969r.getInfoContents(marker);
                } catch (Throwable th3) {
                    view = infoWindow;
                    th = th3;
                    C1007fo.m18012b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                    th.printStackTrace();
                    return view;
                }
            }
            view = infoWindow == null ? this.f2971t.getInfoWindow(marker) : infoWindow;
        } catch (Throwable th4) {
            view = null;
            th = th4;
        }
        try {
            if (view.getBackground() == null) {
                view.setBackground(this.f2968q);
            }
        } catch (Throwable th5) {
            th = th5;
            C1007fo.m18012b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
            th.printStackTrace();
            return view;
        }
        return view;
    }

    /* renamed from: l */
    private void m18226l() {
        if (this.f2959h == null || this.f2959h.getVisibility() != 0) {
            return;
        }
        this.f2959h.invalidate();
    }

    /* renamed from: a */
    public Point m18271a() {
        if (this.f2956e == null) {
            return null;
        }
        return this.f2956e.m18217b();
    }

    /* renamed from: a */
    public void m18270a(float f) {
        if (this.f2962k != null) {
            this.f2962k.m18209a(f);
        }
    }

    /* renamed from: a */
    public void m18269a(int i) {
        if (this.f2962k != null) {
            this.f2962k.m18208a(i);
        }
    }

    /* renamed from: a */
    public void m18268a(int i, float f) {
        if (this.f2956e != null) {
            this.f2956e.m18219a(i, f);
            m18226l();
        }
    }

    /* renamed from: a */
    public void m18266a(Canvas canvas) {
        Bitmap drawingCache;
        if (this.f2963l == null || this.f2967p == null || (drawingCache = this.f2963l.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f2963l.getLeft(), this.f2963l.getTop(), new Paint());
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: a */
    public void mo18259a(AbstractC0881cr abstractC0881cr) {
        if (abstractC0881cr == null) {
            return;
        }
        try {
            if (abstractC0881cr.getTitle() == null && abstractC0881cr.getSnippet() == null) {
                return;
            }
            if (this.f2967p != null && !this.f2967p.getId().equals(abstractC0881cr.getId())) {
                mo18241d();
            }
            if (this.f2969r == null) {
                return;
            }
            this.f2967p = abstractC0881cr;
            abstractC0881cr.mo18687a(true);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void m18254a(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            this.f2969r = this.f2971t;
        } else {
            this.f2969r = infoWindowAdapter;
        }
    }

    /* renamed from: a */
    public void m18253a(CameraPosition cameraPosition) {
        if (C1022g.f3201c == 1) {
            return;
        }
        if (cameraPosition.zoom >= 10.0f && !C0942ee.m18374a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
            this.f2956e.setVisibility(8);
        } else if (this.f2954c.mo17558A() != -1) {
        } else {
            this.f2956e.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void m18252a(boolean z) {
        if (this.f2961j == null || !z || !this.f2954c.mo17519f()) {
            return;
        }
        this.f2961j.m18296a(true);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: a */
    public boolean mo18265a(MotionEvent motionEvent) {
        return (this.f2963l == null || this.f2967p == null || !C0945eh.m18353a(new Rect(this.f2963l.getLeft(), this.f2963l.getTop(), this.f2963l.getRight(), this.f2963l.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    /* renamed from: b */
    public C0961en m18251b() {
        return this.f2959h;
    }

    /* renamed from: b */
    public void m18250b(int i) {
        if (this.f2956e != null) {
            this.f2956e.m18220a(i);
            this.f2956e.invalidate();
            m18226l();
        }
    }

    /* renamed from: b */
    public void m18246b(boolean z) {
        if (this.f2962k == null) {
            return;
        }
        this.f2962k.m18206a(z);
    }

    /* renamed from: c */
    public C0946ei m18245c() {
        return this.f2960i;
    }

    /* renamed from: c */
    public void m18244c(int i) {
        if (this.f2956e != null) {
            this.f2956e.m18216b(i);
            m18226l();
        }
    }

    /* renamed from: c */
    public void m18242c(boolean z) {
        if (this.f2957f == null) {
            return;
        }
        if (z) {
            this.f2957f.setVisibility(0);
        } else {
            this.f2957f.setVisibility(8);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: d */
    public void mo18241d() {
        if (this.f2963l != null) {
            this.f2963l.clearFocus();
            removeView(this.f2963l);
            C0945eh.m18352a(this.f2963l.getBackground());
            C0945eh.m18352a(this.f2968q);
            this.f2963l = null;
        }
        if (this.f2967p != null) {
            this.f2967p.mo18687a(false);
        }
        this.f2967p = null;
        this.f2964m = null;
        this.f2965n = null;
        this.f2966o = null;
    }

    /* renamed from: d */
    public void m18240d(int i) {
        if (this.f2956e != null) {
            this.f2956e.m18214c(i);
            m18226l();
        }
    }

    /* renamed from: d */
    public void m18238d(boolean z) {
        if (this.f2958g == null) {
            return;
        }
        this.f2958g.m18306a(z);
    }

    /* renamed from: e */
    public float m18236e(int i) {
        if (this.f2956e != null) {
            m18226l();
            return this.f2956e.m18212d(i);
        }
        return 0.0f;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: e */
    public void mo18237e() {
        try {
            if (this.f2967p == null || !this.f2967p.k()) {
                if (this.f2963l == null || this.f2963l.getVisibility() != 0) {
                    return;
                }
                this.f2963l.setVisibility(8);
            } else if (!this.f2970s) {
            } else {
                int mo18682e = this.f2967p.mo18682e() + this.f2967p.mo18684c();
                int mo18681f = this.f2967p.mo18681f() + this.f2967p.mo18683d() + 2;
                if (this.f2967p.mo18680g() && mo18682e == this.f2952a && mo18681f == this.f2953b) {
                    return;
                }
                m18264a(m18249b(this.f2967p), mo18682e, mo18681f);
                this.f2967p.h();
                C0960a c0960a = (C0960a) this.f2963l.getLayoutParams();
                if (c0960a != null) {
                    c0960a.f2973a = this.f2967p.mo18696a();
                    c0960a.f2974b = mo18682e;
                    c0960a.f2975c = mo18681f;
                }
                onLayout(false, 0, 0, 0, 0);
                this.f2952a = mo18682e;
                this.f2953b = mo18681f;
                if (this.f2969r == this.f2971t) {
                    if (this.f2965n != null) {
                        this.f2965n.setText(this.f2967p.getTitle());
                    }
                    if (this.f2966o != null) {
                        this.f2966o.setText(this.f2967p.getSnippet());
                    }
                }
                if (this.f2963l.getVisibility() != 8) {
                    return;
                }
                this.f2963l.setVisibility(0);
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m18234e(boolean z) {
        if (this.f2959h == null) {
            return;
        }
        this.f2959h.m18222a(z);
    }

    /* renamed from: f */
    public C0949ek m18233f() {
        return this.f2961j;
    }

    /* renamed from: f */
    public void m18232f(boolean z) {
        if (this.f2956e == null || !z) {
            this.f2956e.m18218a(true);
        } else {
            this.f2956e.m18218a(false);
        }
    }

    /* renamed from: g */
    public C0956el m18231g() {
        return this.f2957f;
    }

    /* renamed from: h */
    public C0947ej m18230h() {
        return this.f2958g;
    }

    /* renamed from: i */
    public C0962eo m18229i() {
        return this.f2956e;
    }

    /* renamed from: j */
    public void m18228j() {
        mo18241d();
        C0945eh.m18352a(this.f2968q);
        removeAllViews();
        this.f2965n = null;
        this.f2966o = null;
        this.f2964m = null;
    }

    /* renamed from: k */
    public void m18227k() {
        this.f2952a = 0;
        this.f2953b = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt.getLayoutParams() instanceof C0960a) {
                    m18260a(childAt, (C0960a) childAt.getLayoutParams());
                } else {
                    m18261a(childAt, childAt.getLayoutParams());
                }
            }
        }
        this.f2956e.m18215c();
    }
}
