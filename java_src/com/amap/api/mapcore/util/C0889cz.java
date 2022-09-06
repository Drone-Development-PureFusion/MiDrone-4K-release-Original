package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES10;
import android.os.Build;
import android.util.Log;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.fimi.soul.biz.camera.C2427e;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.cz */
/* loaded from: classes.dex */
public class C0889cz implements AbstractC0881cr, IAnimation, IMarkerAction {

    /* renamed from: G */
    private float f2471G;

    /* renamed from: H */
    private float f2472H;

    /* renamed from: K */
    private String f2475K;

    /* renamed from: L */
    private LatLng f2476L;

    /* renamed from: M */
    private LatLng f2477M;

    /* renamed from: N */
    private String f2478N;

    /* renamed from: O */
    private String f2479O;

    /* renamed from: T */
    private C1120q f2484T;

    /* renamed from: U */
    private FloatBuffer f2485U;

    /* renamed from: V */
    private Object f2486V;

    /* renamed from: a */
    C0902di f2491a;

    /* renamed from: ae */
    private int f2496ae;

    /* renamed from: af */
    private int f2497af;

    /* renamed from: m */
    private int f2513m;

    /* renamed from: n */
    private int f2514n;

    /* renamed from: p */
    private float[] f2516p;

    /* renamed from: v */
    private MarkerOptions f2522v;

    /* renamed from: b */
    private static int f2466b = 0;

    /* renamed from: D */
    private static CopyOnWriteArrayList<Float> f2464D = new CopyOnWriteArrayList<>();

    /* renamed from: E */
    private static CopyOnWriteArrayList<Float> f2465E = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private boolean f2503c = false;

    /* renamed from: d */
    private boolean f2504d = false;

    /* renamed from: e */
    private boolean f2505e = false;

    /* renamed from: f */
    private float f2506f = 0.0f;

    /* renamed from: g */
    private float f2507g = 0.0f;

    /* renamed from: h */
    private boolean f2508h = false;

    /* renamed from: i */
    private int f2509i = 0;

    /* renamed from: j */
    private int f2510j = 0;

    /* renamed from: k */
    private int f2511k = 0;

    /* renamed from: l */
    private int f2512l = 0;

    /* renamed from: o */
    private FPoint f2515o = new FPoint();

    /* renamed from: q */
    private int[] f2517q = null;

    /* renamed from: r */
    private float f2518r = 0.0f;

    /* renamed from: s */
    private float f2519s = 1.0f;

    /* renamed from: t */
    private float f2520t = 1.0f;

    /* renamed from: u */
    private float f2521u = 1.0f;

    /* renamed from: w */
    private boolean f2523w = false;

    /* renamed from: x */
    private boolean f2524x = true;

    /* renamed from: y */
    private int f2525y = 5;

    /* renamed from: z */
    private boolean f2526z = true;

    /* renamed from: A */
    private boolean f2467A = true;

    /* renamed from: B */
    private boolean f2468B = false;

    /* renamed from: C */
    private boolean f2469C = true;

    /* renamed from: F */
    private FPoint f2470F = new FPoint();

    /* renamed from: I */
    private boolean f2473I = false;

    /* renamed from: J */
    private FloatBuffer f2474J = null;

    /* renamed from: P */
    private float f2480P = 0.5f;

    /* renamed from: Q */
    private float f2481Q = 1.0f;

    /* renamed from: R */
    private boolean f2482R = false;

    /* renamed from: S */
    private boolean f2483S = true;

    /* renamed from: W */
    private boolean f2487W = false;

    /* renamed from: X */
    private CopyOnWriteArrayList<BitmapDescriptor> f2488X = null;

    /* renamed from: Y */
    private boolean f2489Y = false;

    /* renamed from: Z */
    private boolean f2490Z = false;

    /* renamed from: aa */
    private boolean f2492aa = true;

    /* renamed from: ab */
    private int f2493ab = 0;

    /* renamed from: ac */
    private int f2494ac = 20;

    /* renamed from: ad */
    private boolean f2495ad = false;

    /* renamed from: ag */
    private long f2498ag = 0;

    /* renamed from: ah */
    private float f2499ah = Float.MAX_VALUE;

    /* renamed from: ai */
    private float f2500ai = Float.MIN_VALUE;

    /* renamed from: aj */
    private float f2501aj = Float.MAX_VALUE;

    /* renamed from: ak */
    private float f2502ak = Float.MIN_VALUE;

    public C0889cz(MarkerOptions markerOptions, C1120q c1120q) {
        this.f2484T = c1120q;
        setMarkerOptions(markerOptions);
    }

    /* renamed from: a */
    private int m18688a(GL10 gl10) {
        int[] iArr = {0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: a */
    private static String m18690a(String str) {
        f2466b++;
        return str + f2466b;
    }

    /* renamed from: a */
    private void m18695a(float f, float f2, IPoint iPoint) {
        float f3 = (float) ((3.141592653589793d * this.f2506f) / 180.0d);
        iPoint.f4730x = (int) ((f * Math.cos(f3)) + (f2 * Math.sin(f3)));
        iPoint.f4731y = (int) ((f2 * Math.cos(f3)) - (Math.sin(f3) * f));
    }

    /* renamed from: a */
    private void m18694a(int i, int i2) {
        this.f2513m = i;
        this.f2514n = i2;
        DPoint dPoint = new DPoint();
        MapProjection.geo2LonLat(this.f2513m, this.f2514n, dPoint);
        this.f2476L = new LatLng(dPoint.f4727y, dPoint.f4726x, false);
        this.f2484T.m17504a().mo17530c().geo2Map(this.f2513m, this.f2514n, this.f2515o);
    }

    /* renamed from: a */
    private void m18693a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i == 0 || floatBuffer == null || floatBuffer2 == null) {
            return;
        }
        GLES10.glEnable(3042);
        GLES10.glTexEnvf(8960, 8704, 8448.0f);
        GLES10.glBlendFunc(C2427e.f8184N, 771);
        GLES10.glColor4f(1.0f, 1.0f, 1.0f, this.f2521u);
        GLES10.glEnable(3553);
        GLES10.glEnableClientState(32884);
        GLES10.glEnableClientState(32888);
        GLES10.glBindTexture(3553, i);
        GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
        GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
        GLES10.glDrawArrays(6, 0, 4);
        GLES10.glDisableClientState(32884);
        GLES10.glDisableClientState(32888);
        GLES10.glDisable(3553);
        GLES10.glDisable(3042);
    }

    /* renamed from: a */
    private void m18692a(C0902di c0902di) {
        if (c0902di instanceof C0908do) {
            if (this.f2495ad) {
                this.f2476L = getPosition();
                setPosition(this.f2476L);
                this.f2495ad = true;
            }
            if (this.f2495ad) {
                ((C0908do) c0902di).f2786a = this.f2496ae;
                ((C0908do) c0902di).f2787b = this.f2497af;
                IPoint iPoint = new IPoint();
                this.f2484T.m17504a().mo17537b(((C0908do) c0902di).f2789w, ((C0908do) c0902di).f2788c, iPoint);
                ((C0908do) c0902di).f2788c = iPoint.f4730x;
                ((C0908do) c0902di).f2789w = iPoint.f4731y;
                return;
            }
            ((C0908do) c0902di).f2786a = this.f2513m;
            ((C0908do) c0902di).f2787b = this.f2514n;
            IPoint iPoint2 = new IPoint();
            MapProjection.lonlat2Geo(((C0908do) c0902di).f2788c, ((C0908do) c0902di).f2789w, iPoint2);
            ((C0908do) c0902di).f2788c = iPoint2.f4730x;
            ((C0908do) c0902di).f2789w = iPoint2.f4731y;
        }
    }

    /* renamed from: a */
    private void m18691a(AbstractC1115l abstractC1115l) {
        float[] m18348a = C0945eh.m18348a(abstractC1115l, this.f2508h ? 1 : 0, this.f2515o, this.f2506f, (int) (this.f2519s * m18678o()), (int) (this.f2520t * m18677p()), this.f2480P, this.f2481Q);
        this.f2516p = (float[]) m18348a.clone();
        if (this.f2474J == null) {
            this.f2474J = C0945eh.m18327a(m18348a);
        } else {
            this.f2474J = C0945eh.m18326a(m18348a, this.f2474J);
        }
        if (this.f2488X == null || this.f2488X.size() <= 0) {
            return;
        }
        this.f2493ab++;
        if (this.f2493ab >= this.f2494ac * this.f2488X.size()) {
            this.f2493ab = 0;
        }
        if (this.f2494ac == 0) {
            this.f2494ac = 1;
        }
        int i = this.f2493ab / this.f2494ac;
        if (!this.f2492aa) {
            m18674s();
        }
        if (this.f2517q == null || this.f2517q.length <= 0) {
            return;
        }
        m18693a(this.f2517q[i % this.f2488X.size()], this.f2474J, this.f2485U);
    }

    /* renamed from: a */
    private synchronized void m18686a(FPoint[] fPointArr) {
        if (fPointArr != null) {
            m18671v();
            if (this.f2471G > 0.0f && this.f2472H > 0.0f) {
                for (FPoint fPoint : fPointArr) {
                    if (fPoint.f4728x > this.f2500ai) {
                        this.f2500ai = fPoint.f4728x;
                    }
                    if (fPoint.f4728x < this.f2499ah) {
                        this.f2499ah = fPoint.f4728x;
                    }
                    if (fPoint.f4729y > this.f2502ak) {
                        this.f2502ak = fPoint.f4729y;
                    }
                    if (fPoint.f4729y < this.f2501aj) {
                        this.f2501aj = fPoint.f4729y;
                    }
                }
                if (this.f2515o.f4728x < (this.f2499ah + this.f2500ai) / 2.0f) {
                    this.f2470F.f4728x = this.f2515o.f4728x + (this.f2471G / 2.0f);
                } else {
                    this.f2470F.f4728x = this.f2515o.f4728x - (this.f2471G / 2.0f);
                }
                if (this.f2515o.f4729y < (this.f2502ak + this.f2501aj) / 2.0f) {
                    this.f2470F.f4729y = this.f2515o.f4729y;
                } else {
                    this.f2470F.f4729y = this.f2515o.f4729y - this.f2472H;
                }
            }
        }
    }

    /* renamed from: s */
    private void m18674s() {
        if (this.f2484T.m17504a() != null) {
            this.f2484T.m17504a().setRunLowFrame(false);
        }
    }

    /* renamed from: t */
    private void m18673t() {
        if (this.f2485U != null) {
            this.f2485U.clear();
        }
        try {
            BitmapDescriptor m18676q = m18676q();
            if (m18676q == null) {
                return;
            }
            int width = m18676q.getWidth();
            int height = m18676q.getHeight();
            int height2 = m18676q.getBitmap().getHeight();
            float width2 = width / m18676q.getBitmap().getWidth();
            float f = height / height2;
            this.f2485U = C0945eh.m18327a(new float[]{0.0f, f, width2, f, width2, 0.0f, 0.0f, 0.0f});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: u */
    private void m18672u() {
        if (this.f2469C || this.f2491a == null || this.f2491a.m18526l()) {
            this.f2519s = 1.0f;
            this.f2520t = 1.0f;
            this.f2469C = true;
            return;
        }
        m18674s();
        C0907dn c0907dn = new C0907dn();
        this.f2491a.mo18519a(AnimationUtils.currentAnimationTimeMillis(), c0907dn);
        if (c0907dn == null) {
            return;
        }
        if (!Double.isNaN(c0907dn.f2784e) && !Double.isNaN(c0907dn.f2785f)) {
            this.f2519s = (float) c0907dn.f2784e;
            this.f2520t = (float) c0907dn.f2785f;
        }
        if (!Double.isNaN(c0907dn.f2783d)) {
            setRotateAngle((float) c0907dn.f2783d);
        }
        if (!Double.isNaN(c0907dn.f2780a) && !Double.isNaN(c0907dn.f2781b)) {
            double d = c0907dn.f2780a;
            double d2 = c0907dn.f2781b;
            if (this.f2495ad) {
                FPoint fPoint = new FPoint();
                this.f2484T.m17504a().mo17530c().win2Map((int) d, (int) d2, fPoint);
                IPoint iPoint = new IPoint();
                this.f2484T.m17504a().mo17530c().map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
                m18694a(iPoint.f4730x, iPoint.f4731y);
                this.f2495ad = true;
            } else {
                m18694a((int) d, (int) d2);
            }
        }
        if (Double.isNaN(c0907dn.f2782c)) {
            return;
        }
        this.f2521u = (float) c0907dn.f2782c;
    }

    /* renamed from: v */
    private void m18671v() {
        if (this.f2484T.m17504a() == null || this.f2484T.m17504a().getMapConfig() == null) {
            return;
        }
        this.f2471G = this.f2484T.m17504a().getMapConfig().getMapPerPixelUnitLength() * m18678o();
        this.f2472H = this.f2484T.m17504a().getMapConfig().getMapPerPixelUnitLength() * m18677p();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: a */
    public FPoint mo18696a() {
        return this.f2515o;
    }

    /* renamed from: a */
    public synchronized void m18689a(ArrayList<BitmapDescriptor> arrayList) {
        m18679n();
        if (arrayList != null) {
            Iterator<BitmapDescriptor> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BitmapDescriptor next = it2.next();
                if (next != null) {
                    this.f2488X.add(next);
                }
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: a */
    public void mo18568a(GL10 gl10, AbstractC1115l abstractC1115l) {
        Bitmap bitmap;
        int i = 0;
        if (!this.f2483S || this.f2473I) {
            return;
        }
        if (this.f2476L == null && !this.f2495ad) {
            return;
        }
        if (m18676q() == null && this.f2488X == null) {
            return;
        }
        if (!this.f2490Z) {
            synchronized (this) {
                if (this.f2488X != null) {
                    this.f2517q = new int[this.f2488X.size()];
                    boolean z = Build.VERSION.SDK_INT >= 12;
                    Iterator<BitmapDescriptor> it2 = this.f2488X.iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        BitmapDescriptor next = it2.next();
                        if (z) {
                            i = abstractC1115l.mo17544a(next);
                        }
                        if (i == 0 && (bitmap = next.getBitmap()) != null && !bitmap.isRecycled()) {
                            i = m18688a(gl10);
                            if (z) {
                                abstractC1115l.mo17545a(new C1125s(next, i));
                            }
                            C0945eh.m18315b(gl10, i, bitmap, false);
                        }
                        int i3 = i;
                        this.f2517q[i2] = i3;
                        i2++;
                        i = i3;
                    }
                    if (this.f2488X.size() == 1) {
                        this.f2492aa = true;
                    } else {
                        this.f2492aa = false;
                    }
                    this.f2490Z = true;
                }
                mo18562i();
            }
        }
        try {
            if (!this.f2503c) {
                this.f2498ag = System.currentTimeMillis();
                this.f2503c = true;
            }
            if (this.f2495ad && this.f2467A) {
                abstractC1115l.mo17550a(this.f2496ae, this.f2497af, this.f2515o);
            }
            m18672u();
            m18691a(abstractC1115l);
            if (!this.f2505e || !isInfoWindowShown()) {
                return;
            }
            this.f2484T.m17504a().mo17515l();
            if (System.currentTimeMillis() - this.f2498ag <= 1000) {
                return;
            }
            this.f2505e = false;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MarkerDelegateImp", "drawMarker");
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: a */
    public void mo18687a(boolean z) {
        this.f2504d = z;
        this.f2505e = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: b */
    public LatLng mo18685b() {
        if (!this.f2495ad) {
            return this.f2489Y ? this.f2477M : this.f2476L;
        }
        this.f2484T.m17504a().mo17530c().win2Map(this.f2496ae, this.f2497af, this.f2515o);
        DPoint dPoint = new DPoint();
        this.f2484T.m17504a().mo17551a(this.f2496ae, this.f2497af, dPoint);
        return new LatLng(dPoint.f4727y, dPoint.f4727y);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: c */
    public int mo18684c() {
        return this.f2509i;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: d */
    public int mo18683d() {
        return this.f2510j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void destroy() {
        try {
            this.f2473I = true;
            remove();
            if (this.f2484T != null) {
                for (int i = 0; this.f2517q != null && i < this.f2517q.length; i++) {
                    this.f2484T.m17496a(Integer.valueOf(this.f2517q[i]));
                    this.f2484T.m17504a().mo17517g(this.f2517q[i]);
                }
            }
            for (int i2 = 0; this.f2488X != null && i2 < this.f2488X.size(); i2++) {
                this.f2488X.get(i2).recycle();
            }
            if (this.f2485U != null) {
                this.f2485U.clear();
                this.f2485U = null;
            }
            if (this.f2474J != null) {
                this.f2474J.clear();
                this.f2474J = null;
            }
            this.f2476L = null;
            this.f2486V = null;
            this.f2517q = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: e */
    public int mo18682e() {
        return this.f2511k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean equalsRemote(IOverlayImage iOverlayImage) {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: f */
    public int mo18681f() {
        return this.f2512l;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0881cr
    /* renamed from: g */
    public boolean mo18680g() {
        return this.f2495ad;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public float getAlpha() {
        return this.f2521u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorU() {
        return this.f2480P;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorV() {
        return this.f2481Q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public int getDisplayLevel() {
        return this.f2525y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public IPoint getGeoPoint() {
        IPoint iPoint = new IPoint();
        if (this.f2495ad) {
            this.f2484T.m17504a().mo17549a(this.f2496ae, this.f2497af, iPoint);
            return iPoint;
        }
        return new IPoint(this.f2513m, this.f2514n);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu, com.autonavi.amap.mapcore.interfaces.IMarker
    public IMarkerAction getIMarkerAction() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized ArrayList<BitmapDescriptor> getIcons() {
        ArrayList<BitmapDescriptor> arrayList;
        if (this.f2488X == null || this.f2488X.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList2 = new ArrayList<>();
            Iterator<BitmapDescriptor> it2 = this.f2488X.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next());
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public String getId() {
        if (this.f2475K == null) {
            this.f2475K = m18690a("Marker");
        }
        return this.f2475K;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public Object getObject() {
        return this.f2486V;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public MarkerOptions getOptions() {
        return this.f2522v;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public int getPeriod() {
        return this.f2494ac;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public LatLng getPosition() {
        if (!this.f2495ad || this.f2515o == null) {
            return this.f2476L;
        }
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        mo18562i();
        this.f2484T.m17504a().mo17554a(this.f2515o.f4728x, this.f2515o.f4729y, iPoint);
        MapProjection.geo2LonLat(iPoint.f4730x, iPoint.f4731y, dPoint);
        return new LatLng(dPoint.f4727y, dPoint.f4726x);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getRotateAngle() {
        return this.f2507g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public String getSnippet() {
        return this.f2479O;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public String getTitle() {
        return this.f2478N;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getZIndex() {
        return this.f2518r;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: h */
    public Rect mo18563h() {
        Rect rect;
        if (this.f2516p == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            MapProjection mo17530c = this.f2484T.m17504a().mo17530c();
            int m18678o = m18678o();
            int m18677p = m18677p();
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            mo17530c.map2Win(this.f2515o.f4728x, this.f2515o.f4729y, iPoint);
            if (this.f2508h) {
                mo17530c.map2Win(this.f2516p[0], this.f2516p[1], iPoint2);
                rect = new Rect(iPoint2.f4730x, iPoint2.f4731y, iPoint2.f4730x, iPoint2.f4731y);
                mo17530c.map2Win(this.f2516p[3], this.f2516p[4], iPoint2);
                rect.union(iPoint2.f4730x, iPoint2.f4731y);
                mo17530c.map2Win(this.f2516p[6], this.f2516p[7], iPoint2);
                rect.union(iPoint2.f4730x, iPoint2.f4731y);
                mo17530c.map2Win(this.f2516p[9], this.f2516p[10], iPoint2);
                rect.union(iPoint2.f4730x, iPoint2.f4731y);
            } else {
                m18695a((-this.f2480P) * m18678o, (this.f2481Q - 1.0f) * m18677p, iPoint2);
                rect = new Rect(iPoint.f4730x + iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y, iPoint.f4730x + iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y);
                m18695a((-this.f2480P) * m18678o, this.f2481Q * m18677p, iPoint2);
                rect.union(iPoint.f4730x + iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y);
                m18695a((1.0f - this.f2480P) * m18678o, this.f2481Q * m18677p, iPoint2);
                rect.union(iPoint.f4730x + iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y);
                m18695a((1.0f - this.f2480P) * m18678o, (this.f2481Q - 1.0f) * m18677p, iPoint2);
                rect.union(iPoint.f4730x + iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y);
            }
            this.f2511k = rect.centerX() - iPoint.f4730x;
            this.f2512l = rect.top - iPoint.f4731y;
            return rect;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.f2484T.m17487c(this);
            m18674s();
            this.f2504d = false;
        }
        this.f2505e = false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: i */
    public boolean mo18562i() {
        try {
            if (this.f2484T == null || this.f2484T.m17504a() == null || this.f2484T.m17504a().mo17530c() == null) {
                return false;
            }
            if (this.f2515o == null) {
                this.f2515o = new FPoint();
            }
            if (this.f2495ad) {
                this.f2484T.m17504a().mo17550a(this.f2496ae, this.f2497af, this.f2515o);
            } else {
                this.f2484T.m17504a().mo17534b(this.f2514n, this.f2513m, this.f2515o);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isClickable() {
        return this.f2526z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isDraggable() {
        return this.f2482R;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isFlat() {
        return this.f2508h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isInfoWindowAutoOverturn() {
        return this.f2523w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isInfoWindowEnable() {
        return this.f2524x;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isInfoWindowShown() {
        return this.f2504d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isPerspective() {
        return this.f2487W;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean isVisible() {
        return this.f2483S;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: j */
    public boolean mo18561j() {
        return this.f2492aa;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: k */
    public boolean mo18560k() {
        if (this.f2495ad) {
            return true;
        }
        if (this.f2515o != null) {
            this.f2470F.f4728x = this.f2515o.f4728x;
            this.f2470F.f4729y = this.f2515o.f4729y;
            FPoint[] mapRect = this.f2484T.m17504a().getMapConfig().getMapRect();
            m18686a(mapRect);
            if (C0945eh.m18341a(this.f2470F, mapRect)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: l */
    public void mo18559l() {
        this.f2490Z = false;
        if (this.f2517q != null) {
            Arrays.fill(this.f2517q, 0);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: m */
    public boolean mo18558m() {
        return this.f2468B;
    }

    /* renamed from: n */
    synchronized void m18679n() {
        if (this.f2488X == null) {
            this.f2488X = new CopyOnWriteArrayList<>();
        } else {
            this.f2488X.clear();
        }
    }

    /* renamed from: o */
    public int m18678o() {
        try {
            return m18676q().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: p */
    public int m18677p() {
        try {
            return m18676q().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: q */
    public synchronized BitmapDescriptor m18676q() {
        BitmapDescriptor bitmapDescriptor;
        try {
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            bitmapDescriptor = null;
        }
        if (this.f2488X == null || this.f2488X.size() == 0) {
            m18679n();
            this.f2488X.add(BitmapDescriptorFactory.defaultMarker());
        } else if (this.f2488X.get(0) == null) {
            this.f2488X.clear();
            bitmapDescriptor = m18676q();
        }
        bitmapDescriptor = this.f2488X.get(0);
        return bitmapDescriptor;
    }

    /* renamed from: r */
    public IAnimation m18675r() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean remove() {
        m18674s();
        this.f2483S = false;
        if (this.f2484T != null) {
            return this.f2484T.m17501a((AbstractC0884cu) this);
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void set2Top() {
        this.f2484T.m17490b(this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAlpha(float f) {
        this.f2521u = f;
        this.f2522v.alpha(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setAnchor(float f, float f2) {
        if (this.f2480P == f && this.f2481Q == f2) {
            return;
        }
        this.f2522v.anchor(f, f2);
        this.f2480P = f;
        this.f2481Q = f2;
        this.f2505e = true;
        m18674s();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAnimation
    public void setAnimation(C0902di c0902di) {
        if (c0902di == null) {
            return;
        }
        this.f2491a = c0902di;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setAnimation(Animation animation) {
        IAnimation m18675r = m18675r();
        if (m18675r != null) {
            m18675r.setAnimation(animation == null ? null : animation.glAnimation);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        if (this.f2491a != null) {
            this.f2491a.m18534a(animationListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAutoOverturnInfoWindow(boolean z) {
        this.f2523w = z;
        this.f2522v.autoOverturnInfoWindow(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setBelowMaskLayer(boolean z) {
        this.f2468B = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setClickable(boolean z) {
        this.f2526z = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setDisplayLevel(int i) {
        this.f2525y = i;
        this.f2522v.displayLevel(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setDraggable(boolean z) {
        this.f2482R = z;
        this.f2522v.draggable(z);
        m18674s();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setFixingPointEnable(boolean z) {
        this.f2467A = z;
        if (z) {
            if (!this.f2495ad || this.f2476L == null) {
                return;
            }
            IPoint iPoint = new IPoint();
            this.f2484T.m17504a().mo17530c().map2Win(this.f2515o.f4728x, this.f2515o.f4729y, iPoint);
            this.f2496ae = iPoint.f4730x;
            this.f2497af = iPoint.f4731y;
            return;
        }
        boolean z2 = false;
        if (this.f2495ad) {
            z2 = true;
        }
        this.f2476L = getPosition();
        setPosition(this.f2476L);
        if (!z2) {
            return;
        }
        this.f2495ad = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setFlat(boolean z) {
        this.f2508h = z;
        m18674s();
        this.f2522v.setFlat(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setGeoPoint(IPoint iPoint) {
        this.f2495ad = false;
        m18694a(iPoint.f4730x, iPoint.f4731y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.f2488X != null) {
                    this.f2488X.clear();
                    this.f2488X.add(bitmapDescriptor);
                    m18673t();
                    this.f2490Z = false;
                    this.f2503c = false;
                    m18674s();
                    this.f2505e = true;
                }
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.f2488X != null) {
                    m18689a(arrayList);
                    this.f2490Z = false;
                    this.f2503c = false;
                    m18673t();
                    m18674s();
                    this.f2505e = true;
                }
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setInfoWindowEnable(boolean z) {
        this.f2524x = z;
        this.f2522v.infoWindowEnable(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions == null) {
            return;
        }
        this.f2522v = markerOptions;
        this.f2476L = this.f2522v.getPosition();
        IPoint iPoint = new IPoint();
        this.f2489Y = this.f2522v.isGps();
        if (this.f2522v.getPosition() != null) {
            if (this.f2489Y) {
                try {
                    double[] m17653a = C1088hn.m17653a(this.f2522v.getPosition().longitude, this.f2522v.getPosition().latitude);
                    this.f2477M = new LatLng(m17653a[1], m17653a[0]);
                    MapProjection.lonlat2Geo(m17653a[0], m17653a[1], iPoint);
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "MarkerDelegateImp", "create");
                    this.f2477M = this.f2522v.getPosition();
                }
            } else {
                MapProjection.lonlat2Geo(this.f2476L.longitude, this.f2476L.latitude, iPoint);
            }
        }
        this.f2513m = iPoint.f4730x;
        this.f2514n = iPoint.f4731y;
        this.f2480P = this.f2522v.getAnchorU();
        this.f2481Q = this.f2522v.getAnchorV();
        this.f2509i = this.f2522v.getInfoWindowOffsetX();
        this.f2510j = this.f2522v.getInfoWindowOffsetY();
        this.f2494ac = this.f2522v.getPeriod();
        this.f2518r = this.f2522v.getZIndex();
        this.f2468B = this.f2522v.isBelowMaskLayer();
        mo18562i();
        m18689a(this.f2522v.getIcons());
        m18673t();
        this.f2483S = this.f2522v.isVisible();
        this.f2479O = this.f2522v.getSnippet();
        this.f2478N = this.f2522v.getTitle();
        this.f2482R = this.f2522v.isDraggable();
        this.f2475K = getId();
        this.f2487W = this.f2522v.isPerspective();
        this.f2508h = this.f2522v.isFlat();
        this.f2468B = this.f2522v.isBelowMaskLayer();
        this.f2521u = this.f2522v.getAlpha();
        setRotateAngle(this.f2522v.getRotateAngle());
        this.f2525y = this.f2522v.getDisplayLevel();
        this.f2523w = this.f2522v.isInfoWindowAutoOverturn();
        this.f2524x = this.f2522v.isInfoWindowEnable();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setObject(Object obj) {
        this.f2486V = obj;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPeriod(int i) {
        if (i <= 1) {
            this.f2494ac = 1;
        } else {
            this.f2494ac = i;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPerspective(boolean z) {
        this.f2487W = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            C1007fo.m18012b(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.f2476L = latLng;
        IPoint iPoint = new IPoint();
        if (this.f2489Y) {
            try {
                double[] m17653a = C1088hn.m17653a(latLng.longitude, latLng.latitude);
                this.f2477M = new LatLng(m17653a[1], m17653a[0]);
                MapProjection.lonlat2Geo(m17653a[0], m17653a[1], iPoint);
            } catch (Throwable th) {
                this.f2477M = latLng;
            }
        } else {
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        }
        this.f2513m = iPoint.f4730x;
        this.f2514n = iPoint.f4731y;
        this.f2495ad = false;
        mo18562i();
        m18674s();
        this.f2505e = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPositionByPixels(int i, int i2) {
        this.f2496ae = i;
        this.f2497af = i2;
        this.f2495ad = true;
        mo18562i();
        try {
            this.f2516p = C0945eh.m18348a(this.f2484T.m17504a(), this.f2508h ? 1 : 0, this.f2515o, this.f2506f, m18678o(), m18677p(), this.f2480P, this.f2481Q);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MarkerDelegateImp", "setPositionByPixels");
        }
        m18674s();
        this.f2505e = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setRotateAngle(float f) {
        this.f2522v.rotateAngle(f);
        this.f2507g = f;
        this.f2506f = (((-f) % 360.0f) + 360.0f) % 360.0f;
        this.f2505e = true;
        m18674s();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setRotateAngleNotUpdate(float f) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setSnippet(String str) {
        this.f2479O = str;
        m18674s();
        this.f2522v.snippet(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setTitle(String str) {
        this.f2478N = str;
        m18674s();
        this.f2522v.title(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setVisible(boolean z) {
        if (this.f2483S == z) {
            return;
        }
        this.f2522v.visible(z);
        this.f2483S = z;
        if (!z && isInfoWindowShown()) {
            this.f2484T.m17487c(this);
        }
        mo18562i();
        m18674s();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setZIndex(float f) {
        this.f2518r = f;
        this.f2522v.zIndex(f);
        this.f2484T.m17481g();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void showInfoWindow() {
        if (!this.f2483S) {
            return;
        }
        this.f2484T.m17502a((AbstractC0881cr) this);
        m18674s();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IAnimation
    public boolean startAnimation() {
        if (this.f2491a != null) {
            if (this.f2491a instanceof C0903dj) {
                C0903dj c0903dj = (C0903dj) this.f2491a;
                for (C0902di c0902di : c0903dj.m18512n()) {
                    m18692a(c0902di);
                    c0902di.mo18520a(c0903dj.mo18516f());
                }
            } else {
                m18692a(this.f2491a);
            }
            this.f2469C = false;
            this.f2491a.m18532c();
            m18674s();
        }
        return false;
    }
}
