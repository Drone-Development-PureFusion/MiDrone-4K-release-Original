package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.amap.api.mapcore.util.AbstractC0766af;
import com.amap.api.mapcore.util.C0949ek;
import com.amap.api.mapcore.util.C1089i;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.VMapDataCache;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.fimi.soul.biz.camera.C2427e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.b */
/* loaded from: classes.dex */
public class C0802b implements GLSurfaceView.Renderer, AbstractC1115l {

    /* renamed from: ap */
    private static boolean f2187ap = false;

    /* renamed from: A */
    private int f2188A;

    /* renamed from: B */
    private int f2189B;

    /* renamed from: J */
    private MapCore f2197J;

    /* renamed from: K */
    private Context f2198K;

    /* renamed from: L */
    private C0760a f2199L;

    /* renamed from: M */
    private MapProjection f2200M;

    /* renamed from: N */
    private C0895de f2201N;

    /* renamed from: O */
    private AMap.OnMyLocationChangeListener f2202O;

    /* renamed from: P */
    private AMap.OnMarkerClickListener f2203P;

    /* renamed from: Q */
    private AMap.OnPolylineClickListener f2204Q;

    /* renamed from: R */
    private AMap.OnMarkerDragListener f2205R;

    /* renamed from: S */
    private AMap.OnMapLoadedListener f2206S;

    /* renamed from: T */
    private AMap.OnCameraChangeListener f2207T;

    /* renamed from: U */
    private AMap.OnMapClickListener f2208U;

    /* renamed from: V */
    private AMap.OnMapTouchListener f2209V;

    /* renamed from: W */
    private AMap.OnPOIClickListener f2210W;

    /* renamed from: X */
    private AMap.OnMapLongClickListener f2211X;

    /* renamed from: Y */
    private AMap.OnInfoWindowClickListener f2212Y;

    /* renamed from: Z */
    private AMap.OnIndoorBuildingActiveListener f2213Z;

    /* renamed from: aF */
    private Thread f2220aF;

    /* renamed from: ad */
    private AMapGestureListener f2225ad;

    /* renamed from: ag */
    private LocationSource f2228ag;

    /* renamed from: ai */
    private C0891da f2230ai;

    /* renamed from: al */
    private Location f2233al;

    /* renamed from: aw */
    private C0909dp f2243aw;

    /* renamed from: b */
    C1097j f2247b;

    /* renamed from: c */
    C1089i f2248c;

    /* renamed from: d */
    AbstractC1116m f2249d;

    /* renamed from: e */
    C1120q f2250e;

    /* renamed from: f */
    C1128v f2251f;

    /* renamed from: g */
    C0958em f2252g;

    /* renamed from: h */
    C1062h f2253h;

    /* renamed from: j */
    AbstractC0880cq f2255j;

    /* renamed from: m */
    Runnable f2258m;

    /* renamed from: o */
    CustomRenderer f2260o;

    /* renamed from: v */
    private boolean f2267v;

    /* renamed from: w */
    private boolean f2268w;

    /* renamed from: p */
    private int f2261p = -1;

    /* renamed from: q */
    private int f2262q = -1;

    /* renamed from: r */
    private Bitmap f2263r = null;

    /* renamed from: s */
    private Bitmap f2264s = null;

    /* renamed from: a */
    int f2214a = -1;

    /* renamed from: t */
    private float f2265t = 1.0f;

    /* renamed from: u */
    private int f2266u = 0;

    /* renamed from: x */
    private boolean f2269x = false;

    /* renamed from: y */
    private boolean f2270y = false;

    /* renamed from: z */
    private boolean f2271z = false;

    /* renamed from: C */
    private MyTrafficStyle f2190C = null;

    /* renamed from: D */
    private C1089i.EnumC1096c f2191D = C1089i.EnumC1096c.DAY;

    /* renamed from: E */
    private C1089i.EnumC1094a f2192E = C1089i.EnumC1094a.NORAML;

    /* renamed from: F */
    private C1089i.EnumC1095b f2193F = C1089i.EnumC1095b.NORMAL;

    /* renamed from: G */
    private int f2194G = -1;

    /* renamed from: H */
    private CopyOnWriteArrayList<C1125s> f2195H = new CopyOnWriteArrayList<>();

    /* renamed from: I */
    private int f2196I = 1;

    /* renamed from: ab */
    private AMap.onMapPrintScreenListener f2223ab = null;

    /* renamed from: ac */
    private AMap.OnMapScreenShotListener f2224ac = null;

    /* renamed from: ah */
    private Rect f2229ah = new Rect();

    /* renamed from: aj */
    private AMap.CancelableCallback f2231aj = null;

    /* renamed from: ak */
    private int f2232ak = 0;

    /* renamed from: i */
    C0784aq f2254i = null;

    /* renamed from: am */
    private boolean f2234am = true;

    /* renamed from: an */
    private boolean f2235an = false;

    /* renamed from: ao */
    private boolean f2236ao = false;

    /* renamed from: aq */
    private boolean f2237aq = false;

    /* renamed from: ar */
    private Boolean f2238ar = false;

    /* renamed from: as */
    private boolean f2239as = false;

    /* renamed from: at */
    private boolean f2240at = false;

    /* renamed from: au */
    private boolean f2241au = false;

    /* renamed from: av */
    private MapConfig f2242av = new MapConfig(true);

    /* renamed from: k */
    int f2256k = 10;

    /* renamed from: l */
    int f2257l = 10;

    /* renamed from: ay */
    private volatile boolean f2245ay = false;

    /* renamed from: az */
    private boolean f2246az = false;

    /* renamed from: aA */
    private boolean f2215aA = false;

    /* renamed from: aB */
    private Marker f2216aB = null;

    /* renamed from: aC */
    private AbstractC0881cr f2217aC = null;

    /* renamed from: aD */
    private boolean f2218aD = false;

    /* renamed from: aE */
    private boolean f2219aE = false;

    /* renamed from: n */
    final Handler f2259n = new Handler() { // from class: com.amap.api.mapcore.util.b.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            if (message == null || C0802b.this.f2238ar.booleanValue()) {
                return;
            }
            try {
                C0802b.this.m18966K();
                switch (message.what) {
                    case 2:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(C0977ez.f3051b);
                        }
                        sb.append("]");
                        Log.w("amapsdk", sb.toString());
                        break;
                    case 10:
                        CameraPosition cameraPosition = (CameraPosition) message.obj;
                        if (cameraPosition != null && C0802b.this.f2207T != null) {
                            C0802b.this.f2207T.onCameraChange(cameraPosition);
                            break;
                        }
                        break;
                    case 11:
                        AbstractC0766af abstractC0766af = (AbstractC0766af) message.obj;
                        if (abstractC0766af != null) {
                            C0802b.this.f2197J.addMessage(abstractC0766af);
                            break;
                        }
                        break;
                    case 12:
                        CameraPosition cameraPosition2 = C0802b.this.getCameraPosition();
                        if (cameraPosition2 != null && C0802b.this.f2252g != null) {
                            C0802b.this.f2252g.m18253a(cameraPosition2);
                        }
                        C0802b.this.m18917g(true);
                        if (C0802b.this.f2241au) {
                            C0802b.this.mo17515l();
                            C0802b.this.f2241au = false;
                        }
                        C0802b.this.m18934a(true, cameraPosition2);
                        if (C0802b.this.f2231aj != null) {
                            C0802b.this.f2231aj.onFinish();
                        }
                        if (C0802b.this.f2237aq) {
                            C0802b.this.f2237aq = false;
                            break;
                        } else {
                            C0802b.this.f2231aj = null;
                            break;
                        }
                        break;
                    case 14:
                        if (C0802b.this.f2252g != null) {
                            C0802b.this.f2252g.m18270a(C0802b.this.mo17512o());
                            break;
                        }
                        break;
                    case 15:
                        if (C0802b.this.f2252g != null) {
                            C0947ej m18230h = C0802b.this.f2252g.m18230h();
                            if (m18230h == null) {
                                return;
                            }
                            m18230h.m18307a();
                            break;
                        }
                        break;
                    case 16:
                        if (C0802b.this.f2209V != null) {
                            C0802b.this.f2209V.onTouch((MotionEvent) message.obj);
                            break;
                        }
                        break;
                    case 17:
                        Bitmap bitmap = (Bitmap) message.obj;
                        int i = message.arg1;
                        if (bitmap == null || C0802b.this.f2252g == null) {
                            if (C0802b.this.f2223ab != null) {
                                C0802b.this.f2223ab.onMapPrint(null);
                            }
                            if (C0802b.this.f2224ac != null) {
                                C0802b.this.f2224ac.onMapScreenShot(null);
                                C0802b.this.f2224ac.onMapScreenShot(null, i);
                            }
                        } else {
                            Canvas canvas = new Canvas(bitmap);
                            C0962eo m18229i = C0802b.this.f2252g.m18229i();
                            if (m18229i != null) {
                                m18229i.onDraw(canvas);
                            }
                            C0802b.this.f2252g.m18266a(canvas);
                            if (C0802b.this.f2223ab != null) {
                                C0802b.this.f2223ab.onMapPrint(new BitmapDrawable(C0802b.this.f2198K.getResources(), bitmap));
                            }
                            if (C0802b.this.f2224ac != null) {
                                C0802b.this.f2224ac.onMapScreenShot(bitmap);
                                C0802b.this.f2224ac.onMapScreenShot(bitmap, i);
                            }
                        }
                        C0802b.this.f2223ab = null;
                        C0802b.this.f2224ac = null;
                        break;
                    case 18:
                        if (C0802b.this.f2206S != null) {
                            C0802b.this.f2206S.onMapLoaded();
                            break;
                        }
                        break;
                    case 19:
                        if (C0802b.this.f2197J.getAnimateionsCount() == 0 && C0802b.this.f2251f != null) {
                            C0802b.this.f2251f.m17460b(false);
                        }
                        if (C0802b.this.f2251f != null) {
                            C1128v c1128v = C0802b.this.f2251f;
                            if (message.arg1 == 0) {
                                z = false;
                            }
                            c1128v.m17463a(z);
                            break;
                        }
                        break;
                    case 21:
                        if (C0802b.this.f2255j != null) {
                            C0802b.this.f2255j.mo18237e();
                            break;
                        }
                        break;
                }
                C0802b.this.m18966K();
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
        }
    };

    /* renamed from: aG */
    private AbstractRunnableC0827a f2221aG = new AbstractRunnableC0827a() { // from class: com.amap.api.mapcore.util.b.13
        @Override // com.amap.api.mapcore.util.C0802b.AbstractRunnableC0827a, java.lang.Runnable
        public void run() {
            super.run();
            C0802b.this.m18939a(this.f2314c, this.f2315d, this.f2316e);
        }
    };

    /* renamed from: af */
    private AbstractC1118o f2227af = new C1131w(this);

    /* renamed from: ae */
    private AbstractC1117n f2226ae = new C1126t(this);

    /* renamed from: aa */
    private C0937e f2222aa = new C0937e(this);

    /* renamed from: ax */
    private final C1124r f2244ax = new C1124r();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractRunnableC0827a implements Runnable {

        /* renamed from: b */
        boolean f2313b;

        /* renamed from: c */
        C1089i.EnumC1094a f2314c;

        /* renamed from: d */
        C1089i.EnumC1096c f2315d;

        /* renamed from: e */
        C1089i.EnumC1095b f2316e;

        private AbstractRunnableC0827a() {
            this.f2313b = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2313b = false;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$b */
    /* loaded from: classes.dex */
    private class C0828b implements C0949ek.AbstractC0955a {
        private C0828b() {
        }

        @Override // com.amap.api.mapcore.util.C0949ek.AbstractC0955a
        /* renamed from: a */
        public void mo18273a(int i) {
            if (C0802b.this.f2254i != null) {
                C0802b.this.f2254i.activeFloorIndex = C0802b.this.f2254i.floor_indexs[i];
                C0802b.this.f2254i.activeFloorName = C0802b.this.f2254i.floor_names[i];
                try {
                    C0802b.this.setIndoorBuildingInfo(C0802b.this.f2254i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.b$c */
    /* loaded from: classes.dex */
    public class RunnableC0829c implements Runnable {

        /* renamed from: b */
        private Context f2319b;

        /* renamed from: c */
        private AMap.OnCacheRemoveListener f2320c;

        public RunnableC0829c(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f2319b = context;
            this.f2320c = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof RunnableC0829c;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r9 = this;
                r0 = 1
                r1 = 0
                android.content.Context r2 = r9.f2319b     // Catch: java.lang.Throwable -> L4c
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L4c
                java.lang.String r3 = com.amap.api.mapcore.util.C0945eh.m18318b(r2)     // Catch: java.lang.Throwable -> L4c
                java.lang.String r4 = com.amap.api.mapcore.util.C0945eh.m18357a(r2)     // Catch: java.lang.Throwable -> L4c
                java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L4c
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L4c
                boolean r2 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r2)     // Catch: java.lang.Throwable -> L4c
                if (r2 == 0) goto L43
                r2 = r0
            L1c:
                if (r2 == 0) goto L45
                java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L9f
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L9f
                boolean r2 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r3)     // Catch: java.lang.Throwable -> L9f
                if (r2 == 0) goto L45
                r6 = r0
            L2a:
                com.amap.api.mapcore.util.b r0 = com.amap.api.mapcore.util.C0802b.this     // Catch: java.lang.Throwable -> L47
                com.autonavi.amap.mapcore.MapCore r0 = com.amap.api.mapcore.util.C0802b.m18926d(r0)     // Catch: java.lang.Throwable -> L47
                r1 = 2601(0xa29, float:3.645E-42)
                r2 = 1
                r3 = 0
                r4 = 0
                r5 = 0
                r0.setParameter(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L47
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L47
                if (r0 == 0) goto L42
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L47
                r0.onRemoveCacheFinish(r6)     // Catch: java.lang.Throwable -> L47
            L42:
                return
            L43:
                r2 = r1
                goto L1c
            L45:
                r6 = r1
                goto L2a
            L47:
                r0 = move-exception
                r0.printStackTrace()
                goto L42
            L4c:
                r1 = move-exception
                r8 = r1
                r1 = r0
                r0 = r8
            L50:
                java.lang.String r2 = "AMapDelegateImp"
                java.lang.String r3 = "RemoveCacheRunnable"
                com.amap.api.mapcore.util.C1007fo.m18012b(r0, r2, r3)     // Catch: java.lang.Throwable -> L9b
                r6 = 0
                com.amap.api.mapcore.util.b r0 = com.amap.api.mapcore.util.C0802b.this     // Catch: java.lang.Throwable -> L71
                com.autonavi.amap.mapcore.MapCore r0 = com.amap.api.mapcore.util.C0802b.m18926d(r0)     // Catch: java.lang.Throwable -> L71
                r1 = 2601(0xa29, float:3.645E-42)
                r2 = 1
                r3 = 0
                r4 = 0
                r5 = 0
                r0.setParameter(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L71
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L71
                if (r0 == 0) goto L42
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L71
                r0.onRemoveCacheFinish(r6)     // Catch: java.lang.Throwable -> L71
                goto L42
            L71:
                r0 = move-exception
                r0.printStackTrace()
                goto L42
            L76:
                r1 = move-exception
                r6 = r1
                r7 = r0
            L79:
                com.amap.api.mapcore.util.b r0 = com.amap.api.mapcore.util.C0802b.this     // Catch: java.lang.Throwable -> L92
                com.autonavi.amap.mapcore.MapCore r0 = com.amap.api.mapcore.util.C0802b.m18926d(r0)     // Catch: java.lang.Throwable -> L92
                r1 = 2601(0xa29, float:3.645E-42)
                r2 = 1
                r3 = 0
                r4 = 0
                r5 = 0
                r0.setParameter(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L92
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L92
                if (r0 == 0) goto L91
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r9.f2320c     // Catch: java.lang.Throwable -> L92
                r0.onRemoveCacheFinish(r7)     // Catch: java.lang.Throwable -> L92
            L91:
                throw r6
            L92:
                r0 = move-exception
                r0.printStackTrace()
                goto L91
            L97:
                r0 = move-exception
                r6 = r0
                r7 = r2
                goto L79
            L9b:
                r0 = move-exception
                r6 = r0
                r7 = r1
                goto L79
            L9f:
                r0 = move-exception
                r1 = r2
                goto L50
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0802b.RunnableC0829c.run():void");
        }
    }

    public C0802b(AbstractC1116m abstractC1116m, Context context, AttributeSet attributeSet) {
        this.f2247b = null;
        this.f2248c = null;
        this.f2249d = null;
        this.f2199L = null;
        this.f2253h = null;
        this.f2255j = null;
        C1022g.f3200b = C0976ey.m18169c(context);
        this.f2249d = abstractC1116m;
        this.f2198K = context.getApplicationContext();
        this.f2243aw = new C0909dp(abstractC1116m);
        this.f2197J = new MapCore(this.f2198K, this);
        this.f2199L = new C0760a(this);
        this.f2197J.setMapCallback(this.f2199L);
        this.f2249d.setRenderer(this);
        m18974C();
        this.f2248c = new C1089i(this, context);
        this.f2253h = new C1062h(this.f2198K, this);
        this.f2252g = new C0958em(this.f2198K, this);
        this.f2252g.m18233f().m18300a(new C0828b());
        this.f2220aF = new C0984f(this.f2198K, this);
        this.f2247b = new C1097j(this);
        this.f2250e = new C1120q(this.f2198K, this);
        this.f2251f = new C1128v(this.f2198K, this);
        this.f2230ai = new C0891da(this, context);
        this.f2255j = this.f2252g;
        this.f2201N = new C0895de(this, context);
    }

    /* renamed from: B */
    private void m18975B() {
        IPoint iPoint = new IPoint();
        if (this.f2200M != null) {
            this.f2200M.recalculate();
            this.f2200M.getGeoCenter(iPoint);
            this.f2242av.setS_x(iPoint.f4730x);
            this.f2242av.setS_y(iPoint.f4731y);
            this.f2242av.setS_z(this.f2200M.getMapZoomer());
            this.f2242av.setS_c(this.f2200M.getCameraHeaderAngle());
            this.f2242av.setS_r(this.f2200M.getMapAngle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m18974C() {
        if (!this.f2235an) {
            try {
                this.f2197J.newMap();
                this.f2199L.onResume(this.f2197J);
                this.f2200M = this.f2197J.getMapstate();
                this.f2200M.setGeoCenter(this.f2242av.getS_x(), this.f2242av.getS_y());
                this.f2200M.setMapAngle(this.f2242av.getS_r());
                this.f2200M.setMapZoomer(this.f2242av.getS_z());
                this.f2200M.setCameraHeaderAngle(this.f2242av.getS_c());
                this.f2197J.setMapstate(this.f2200M);
                if (this.f2242av.getLimitIPoints() != null) {
                    m18953X();
                }
                this.f2235an = true;
                this.f2243aw.m18506a(15);
                this.f2249d.setRenderMode(0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: D */
    private void m18973D() {
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.12
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2235an) {
                    try {
                        C0802b.this.f2197J.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    VMapDataCache.getInstance().reset();
                    C0802b.this.f2235an = false;
                }
            }
        });
    }

    /* renamed from: E */
    private void m18972E() {
        int i = 0;
        try {
            setIndoorEnabled(this.f2242av.isIndoorEnable());
            set3DBuildingEnabled(this.f2242av.isBuildingEnable());
            setMapTextEnable(this.f2242av.isMapTextEnable());
            setTrafficEnabled(this.f2242av.isTrafficEnabled());
            setMyTrafficStyle(this.f2190C);
            MapCore mapCore = this.f2197J;
            if (this.f2192E == C1089i.EnumC1094a.SATELLITE) {
                i = 1;
            }
            mapCore.setParameter(2011, i, 0, 0, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: F */
    private void m18971F() {
        this.f2202O = null;
        this.f2203P = null;
        this.f2204Q = null;
        this.f2205R = null;
        this.f2206S = null;
        this.f2207T = null;
        this.f2208U = null;
        this.f2209V = null;
        this.f2210W = null;
        this.f2211X = null;
        this.f2212Y = null;
        this.f2213Z = null;
        this.f2222aa = null;
        this.f2223ab = null;
        this.f2224ac = null;
    }

    /* renamed from: G */
    private void m18970G() {
        if (this.f2235an && this.f2243aw != null && !this.f2243aw.m18501c()) {
            this.f2249d.requestRender();
        }
    }

    /* renamed from: H */
    private void m18969H() {
        final C0946ei m18245c = this.f2252g.m18245c();
        if (m18245c == null || m18245c.getVisibility() == 8) {
            return;
        }
        if (!this.f2236ao) {
            this.f2259n.sendEmptyMessage(18);
            this.f2236ao = true;
            m18917g(true);
        }
        this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.17
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2267v) {
                    return;
                }
                try {
                    if (C0802b.this.f2254i != null) {
                        C0802b.this.setIndoorBuildingInfo(C0802b.this.f2254i);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                m18245c.m18308a(false);
            }
        });
    }

    /* renamed from: I */
    private void m18968I() {
        this.f2242av.setMapRect(C0945eh.m18347a((AbstractC1115l) this, true));
    }

    /* renamed from: J */
    private void m18967J() {
        if (this.f2214a != -1) {
            this.f2243aw.m18506a(this.f2214a);
            m18966K();
        } else if (this.f2197J.getAnimateionsCount() > 0) {
            this.f2243aw.m18506a(30);
            m18966K();
        } else if (this.f2256k > this.f2257l) {
            this.f2243aw.m18506a(15);
        } else {
            this.f2256k++;
            this.f2243aw.m18506a(30);
            this.f2243aw.m18503b(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m18966K() {
        if (this.f2243aw != null) {
            this.f2243aw.m18503b(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public synchronized void m18965L() {
        this.f2243aw.m18504b();
    }

    /* renamed from: M */
    private synchronized void m18964M() {
        this.f2243aw.m18507a();
    }

    /* renamed from: N */
    private synchronized void m18963N() {
        try {
            if (!this.f2245ay) {
                this.f2248c.m17651a();
                this.f2248c.m17647a(true);
                this.f2248c.m17644b(true);
                this.f2248c.m17640e(true);
                this.f2248c.m17641d(true);
                this.f2248c.m17642c(true);
                this.f2245ay = true;
            }
        } catch (OutOfMemoryError e) {
            C1007fo.m18012b(e, "AMapDelegateImp", "setInternaltexture");
            e.printStackTrace();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "setInternaltexture");
            th.printStackTrace();
        }
    }

    /* renamed from: O */
    private LatLng m18962O() {
        if (!this.f2235an || this.f2200M == null) {
            return null;
        }
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        this.f2200M.getGeoCenter(iPoint);
        MapProjection.geo2LonLat(iPoint.f4730x, iPoint.f4731y, dPoint);
        return new LatLng(dPoint.f4727y, dPoint.f4726x, false);
    }

    /* renamed from: P */
    private void m18961P() {
        if (this.f2219aE) {
            this.f2219aE = false;
        }
        if (this.f2218aD) {
            this.f2218aD = false;
            AbstractC0766af m19092c = C0768ag.m19092c();
            m19092c.isChangeFinished = true;
            this.f2197J.addMessage(m19092c);
        }
        if (this.f2246az) {
            this.f2246az = false;
            AbstractC0766af m19092c2 = C0768ag.m19092c();
            m19092c2.isChangeFinished = true;
            this.f2197J.addMessage(m19092c2);
        }
        this.f2215aA = false;
        if (this.f2205R == null || this.f2216aB == null) {
            return;
        }
        try {
            this.f2205R.onMarkerDragEnd(this.f2216aB);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        this.f2216aB = null;
    }

    /* renamed from: Q */
    private void m18960Q() {
        if (!f2187ap) {
            try {
                this.f2220aF.setName("AuthThread");
                this.f2220aF.start();
                f2187ap = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public void m18959R() {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        this.f2252g.m18232f((this.f2192E == C1089i.EnumC1094a.SATELLITE || this.f2191D == C1089i.EnumC1096c.NIGHT) ? false : true);
    }

    /* renamed from: S */
    private void m18958S() {
        if (this.f2195H != null) {
            this.f2195H.clear();
        }
        this.f2250e.m17480h();
        this.f2247b.m17617f();
        this.f2251f.m17455g();
    }

    /* renamed from: T */
    private void m18957T() {
        if (!this.f2235an) {
            return;
        }
        this.f2253h.m17750a();
        this.f2269x = true;
        this.f2197J.clearAllMessages();
        this.f2197J.clearAnimations();
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.10
            @Override // java.lang.Runnable
            public void run() {
                C0802b.this.f2197J.setParameter(4001, 1, 0, 0, 0);
            }
        });
    }

    /* renamed from: U */
    private void m18956U() {
        this.f2269x = true;
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.11
            @Override // java.lang.Runnable
            public void run() {
                C0802b.this.f2197J.setParameter(4001, 0, 0, 0, 0);
            }
        });
    }

    /* renamed from: V */
    private synchronized void m18955V() {
        Iterator<C1125s> it2 = this.f2195H.iterator();
        while (it2.hasNext()) {
            it2.next().m17474a().recycle();
        }
        this.f2195H.clear();
    }

    /* renamed from: W */
    private void m18954W() {
        LatLngBounds limitLatLngBounds = this.f2242av.getLimitLatLngBounds();
        if (limitLatLngBounds == null || this.f2197J == null) {
            this.f2242av.setLimitIPoints(null);
            this.f2242av.setLimitZoomLevel(0.0f);
            return;
        }
        MapProjection mapProjection = new MapProjection(this.f2197J);
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, iPoint);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, iPoint2);
        this.f2242av.setLimitIPoints(new IPoint[]{iPoint, iPoint2});
        mapProjection.recycle();
        m18953X();
    }

    /* renamed from: X */
    private void m18953X() {
        if (this.f2242av.getLimitIPoints() == null || this.f2242av.getLimitIPoints().length != 2) {
            return;
        }
        IPoint iPoint = this.f2242av.getLimitIPoints()[0];
        IPoint iPoint2 = this.f2242av.getLimitIPoints()[1];
        MapProjection mapProjection = new MapProjection(this.f2197J);
        float m18337a = C0945eh.m18337a(mapProjection, getMapConfig(), iPoint, iPoint2, getMapWidth(), getMapHeight());
        mapProjection.recycle();
        setMinZoomLevel(m18337a);
        this.f2242av.setLimitZoomLevel(m18337a);
    }

    /* renamed from: a */
    private void m18937a(MapProjection mapProjection, int i, int i2, DPoint dPoint) {
        if (this.f2235an) {
            FPoint fPoint = new FPoint();
            mapProjection.win2Map(i, i2, fPoint);
            IPoint iPoint = new IPoint();
            mapProjection.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
            MapProjection.geo2LonLat(iPoint.f4730x, iPoint.f4731y, dPoint);
        }
    }

    /* renamed from: a */
    private void m18935a(GL10 gl10) {
        if (this.f2239as) {
            int i = this.f2197J.canStopRenderMap() ? 1 : 0;
            Message obtainMessage = this.f2259n.obtainMessage(17, C0945eh.m18358a(0, 0, getMapWidth(), getMapHeight(), gl10));
            obtainMessage.arg1 = i;
            obtainMessage.sendToTarget();
            this.f2239as = false;
        }
    }

    /* renamed from: b */
    private void m18930b(GL10 gl10) {
        if (this.f2263r == null || this.f2263r.isRecycled()) {
            this.f2263r = C0945eh.m18356a(this.f2198K, "amap_sdk_lineTexture.png");
        }
        if (this.f2264s == null || this.f2264s.isRecycled()) {
            this.f2264s = C0945eh.m18356a(this.f2198K, "amap_sdk_lineDashTexture.png");
        }
        this.f2261p = C0945eh.m18329a(gl10, this.f2263r);
        this.f2262q = C0945eh.m18328a(gl10, this.f2264s, true);
    }

    /* renamed from: c */
    private void m18927c(MapMessage mapMessage) {
        mapMessage.isUseAnchor = this.f2271z;
        if (this.f2271z) {
            mapMessage.anchorX = this.f2188A;
            mapMessage.anchorY = this.f2189B;
        }
        if (mapMessage.width == 0) {
            mapMessage.width = getMapWidth();
        }
        if (mapMessage.height == 0) {
            mapMessage.height = getMapHeight();
        }
        mapMessage.mapConfig = this.f2242av;
    }

    /* renamed from: d */
    static /* synthetic */ MapCore m18926d(C0802b c0802b) {
        return c0802b.f2197J;
    }

    /* renamed from: e */
    private void m18925e(MotionEvent motionEvent) {
        if (!this.f2215aA || this.f2216aB == null || this.f2217aC == null) {
            return;
        }
        LatLng mo18685b = this.f2217aC.mo18685b();
        LatLng position = this.f2217aC.getPosition();
        DPoint dPoint = new DPoint();
        mo17551a((int) motionEvent.getX(), (int) (motionEvent.getY() - 60.0f), dPoint);
        this.f2216aB.setPosition(new LatLng((position.latitude + dPoint.f4727y) - mo18685b.latitude, (dPoint.f4726x + position.longitude) - mo18685b.longitude));
        this.f2205R.onMarkerDrag(this.f2216aB);
    }

    /* renamed from: f */
    private void m18923f(final MotionEvent motionEvent) {
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2210W == null) {
                    C0802b.this.m18919g(motionEvent);
                    return;
                }
                final Poi poiItem = C0802b.this.f2197J.getPoiItem((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                if (poiItem != null) {
                    C0802b.this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C0802b.this.f2210W.onPOIClick(poiItem);
                            } catch (Throwable th) {
                                C1007fo.m18012b(th, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                                th.printStackTrace();
                            }
                        }
                    });
                } else {
                    C0802b.this.m18919g(motionEvent);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m18919g(final MotionEvent motionEvent) {
        this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2208U != null) {
                    DPoint dPoint = new DPoint();
                    C0802b.this.mo17551a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                    try {
                        C0802b.this.f2208U.onMapClick(new LatLng(dPoint.f4727y, dPoint.f4726x));
                    } catch (Throwable th) {
                        C1007fo.m18012b(th, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: h */
    private boolean m18915h(MotionEvent motionEvent) {
        AbstractC0883ct m17632a;
        if (this.f2204Q != null) {
            DPoint dPoint = new DPoint();
            mo17551a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
            LatLng latLng = new LatLng(dPoint.f4727y, dPoint.f4726x);
            if (latLng != null && (m17632a = this.f2247b.m17632a(latLng)) != null) {
                this.f2204Q.onPolylineClick(new Polyline((AbstractC0886cw) m17632a));
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private boolean m18912i(MotionEvent motionEvent) {
        LatLng mo18685b;
        if (this.f2250e.m17491b(motionEvent)) {
            AbstractC0881cr m17486d = this.f2250e.m17486d();
            if (m17486d == null || !m17486d.isVisible()) {
                return true;
            }
            try {
                Marker marker = new Marker(m17486d);
                if (this.f2203P != null && (this.f2203P.onMarkerClick(marker) || this.f2250e.m17492b() <= 0)) {
                    this.f2250e.m17490b(m17486d);
                    return true;
                }
                mo17546a(m17486d);
                if (!m17486d.mo18680g() && (mo18685b = m17486d.mo18685b()) != null) {
                    IPoint iPoint = new IPoint();
                    mo17555a(mo18685b.latitude, mo18685b.longitude, iPoint);
                    mo17542a(C0768ag.m19095a(iPoint));
                }
                this.f2250e.m17490b(m17486d);
                return true;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: j */
    private boolean m18909j(MotionEvent motionEvent) {
        if (this.f2255j == null || !this.f2255j.mo18265a(motionEvent)) {
            return false;
        }
        if (this.f2212Y == null) {
            return true;
        }
        AbstractC0881cr m17486d = this.f2250e.m17486d();
        if (!m17486d.isVisible()) {
            return true;
        }
        this.f2212Y.onInfoWindowClick(new Marker(m17486d));
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: A */
    public int mo17558A() {
        return this.f2194G;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public float mo17553a(int i) {
        if (!this.f2235an || this.f2200M == null) {
            return 0.0f;
        }
        return this.f2200M.getMapLenWithWin(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        r0 = r0.m17473b();
     */
    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int mo17544a(BitmapDescriptor bitmapDescriptor) {
        int i;
        if (bitmapDescriptor != null) {
            if (bitmapDescriptor.getBitmap() != null && !bitmapDescriptor.getBitmap().isRecycled()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f2195H.size()) {
                        i = 0;
                        break;
                    }
                    C1125s c1125s = this.f2195H.get(i2);
                    if (c1125s.m17474a().equals(bitmapDescriptor)) {
                        break;
                    }
                    i2++;
                }
            }
        }
        i = 0;
        return i;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public int mo17541a(IMarkerAction iMarkerAction, Rect rect) {
        if (this.f2250e == null || iMarkerAction == null || rect == null) {
            return 0;
        }
        return this.f2250e.m17497a(iMarkerAction, rect);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public LatLngBounds mo17543a(LatLng latLng, float f, float f2, float f3) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.f2238ar.booleanValue()) {
            return null;
        }
        float m18340a = C0945eh.m18340a(this.f2242av, f);
        MapProjection mapProjection = new MapProjection(this.f2197J);
        if (latLng != null) {
            IPoint iPoint = new IPoint();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            mapProjection.setCameraHeaderAngle(0.0f);
            mapProjection.setMapAngle(0.0f);
            mapProjection.setGeoCenter(iPoint.f4730x, iPoint.f4731y);
            mapProjection.setMapZoomer(m18340a);
            mapProjection.recalculate();
        }
        DPoint dPoint = new DPoint();
        m18937a(mapProjection, 0, 0, dPoint);
        LatLng latLng2 = new LatLng(dPoint.f4727y, dPoint.f4726x, false);
        m18937a(mapProjection, mapWidth, mapHeight, dPoint);
        LatLng latLng3 = new LatLng(dPoint.f4727y, dPoint.f4726x, false);
        mapProjection.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public MapCore mo17557a() {
        return this.f2197J;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17556a(double d, double d2, FPoint fPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(d2, d, iPoint);
        this.f2200M.geo2Map(iPoint.f4730x, iPoint.f4731y, fPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17555a(double d, double d2, IPoint iPoint) {
        MapProjection.lonlat2Geo(d2, d, iPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17554a(float f, float f2, IPoint iPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        this.f2200M.map2Geo(f, f2, iPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17552a(int i, float f) {
        if (this.f2252g != null) {
            this.f2252g.m18268a(i, f);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17551a(int i, int i2, DPoint dPoint) {
        if (this.f2200M != null) {
            m18937a(this.f2200M, i, i2, dPoint);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17550a(int i, int i2, FPoint fPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        this.f2200M.win2Map(i, i2, fPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17549a(int i, int i2, IPoint iPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        FPoint fPoint = new FPoint();
        this.f2200M.win2Map(i, i2, fPoint);
        this.f2200M.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17548a(Location location) {
        if (location == null) {
            return;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        try {
            if (!this.f2234am || this.f2228ag == null) {
                if (this.f2230ai != null) {
                    this.f2230ai.m18664b();
                }
                this.f2230ai = null;
                return;
            }
            if (this.f2230ai == null || this.f2233al == null) {
                if (this.f2230ai == null) {
                    this.f2230ai = new C0891da(this, this.f2198K);
                }
                if (this.f2200M != null) {
                    mo17542a(C0768ag.m19099a(latLng, this.f2200M.getMapZoomer()));
                }
            }
            this.f2230ai.m18666a(location);
            if (this.f2202O != null && (this.f2233al == null || this.f2233al.equals(location))) {
                this.f2202O.onMyLocationChange(location);
            }
            this.f2233al = new Location(location);
            m18966K();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "AMapDelegateImp", "showMyLocationOverlay");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18952a(C0784aq c0784aq) {
        if (!this.f2242av.isIndoorEnable()) {
            return;
        }
        final C0949ek m18233f = this.f2252g.m18233f();
        if (c0784aq == null) {
            if (mo17519f()) {
                return;
            }
            if (this.f2213Z != null) {
                this.f2213Z.OnIndoorBuilding(c0784aq);
            }
            if (this.f2254i != null) {
                this.f2254i.f2123g = null;
            }
            if (m18233f.m18290c()) {
                this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        m18233f.setVisibility(8);
                    }
                });
            }
            this.f2242av.maxZoomLevel = this.f2242av.isSetLimitZoomLevel() ? this.f2242av.getMaxZoomLevel() : 19.0f;
            if (!this.f2227af.isZoomControlsEnabled()) {
                return;
            }
            m18916h();
        } else if (this.f2254i != null && this.f2254i.poiid.equals(c0784aq.poiid) && m18233f.m18290c()) {
        } else {
            if (this.f2254i == null || !this.f2254i.poiid.equals(c0784aq.poiid) || this.f2254i.f2123g == null) {
                this.f2254i = c0784aq;
                this.f2254i.f2123g = new IPoint();
                if (this.f2200M != null) {
                    this.f2200M.getGeoCenter(this.f2254i.f2123g);
                }
            }
            if (this.f2213Z != null) {
                this.f2213Z.OnIndoorBuilding(c0784aq);
            }
            this.f2242av.maxZoomLevel = this.f2242av.isSetLimitZoomLevel() ? this.f2242av.getMaxZoomLevel() : 20.0f;
            if (this.f2227af.isZoomControlsEnabled()) {
                m18916h();
            }
            if (this.f2227af.isIndoorSwitchEnabled() && !m18233f.m18290c()) {
                this.f2227af.setIndoorSwitchEnabled(true);
                this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            m18233f.m18295a(C0802b.this.f2254i.floor_names);
                            m18233f.m18297a(C0802b.this.f2254i.activeFloorName);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else if (this.f2227af.isIndoorSwitchEnabled() || !m18233f.m18290c()) {
            } else {
                this.f2227af.setIndoorSwitchEnabled(false);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17546a(AbstractC0881cr abstractC0881cr) {
        if (abstractC0881cr == null) {
            return;
        }
        if ((abstractC0881cr.getTitle() == null && abstractC0881cr.getSnippet() == null) || this.f2255j == null) {
            return;
        }
        this.f2255j.mo18259a(abstractC0881cr);
    }

    /* renamed from: a */
    public void m18940a(C1089i.EnumC1094a enumC1094a, C1089i.EnumC1096c enumC1096c) {
        m18939a(enumC1094a, enumC1096c, C1089i.EnumC1095b.NORMAL);
    }

    /* renamed from: a */
    public void m18939a(final C1089i.EnumC1094a enumC1094a, final C1089i.EnumC1096c enumC1096c, final C1089i.EnumC1095b enumC1095b) {
        if (this.f2191D == enumC1096c && this.f2192E == enumC1094a && this.f2193F == enumC1095b) {
            return;
        }
        if (!f2187ap) {
            this.f2191D = enumC1096c;
            this.f2192E = enumC1094a;
            this.f2193F = enumC1095b;
            return;
        }
        final C1089i.EnumC1096c enumC1096c2 = this.f2191D;
        final C1089i.EnumC1094a enumC1094a2 = this.f2192E;
        if (this.f2245ay && this.f2235an) {
            m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.18
                @Override // java.lang.Runnable
                public void run() {
                    String m17645b = C0802b.this.f2248c.m17645b();
                    String m17643c = C0802b.this.f2248c.m17643c();
                    C0802b.this.f2191D = enumC1096c;
                    C0802b.this.f2192E = enumC1094a;
                    C0802b.this.f2193F = enumC1095b;
                    String m17645b2 = C0802b.this.f2248c.m17645b();
                    String m17643c2 = C0802b.this.f2248c.m17643c();
                    if (C0802b.this.f2192E == C1089i.EnumC1094a.SATELLITE || C0802b.this.f2191D == C1089i.EnumC1096c.NIGHT || enumC1096c2 == C1089i.EnumC1096c.NIGHT || enumC1094a2 == C1089i.EnumC1094a.SATELLITE) {
                        C0802b.this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C0802b.this.m18959R();
                            }
                        });
                    }
                    C0802b.this.f2197J.setParameter(2501, 0, 0, 0, 0);
                    if (!m17645b.equals(m17645b2)) {
                        C0802b.this.f2248c.m17651a();
                    }
                    if (C0802b.this.f2192E == C1089i.EnumC1094a.SATELLITE || enumC1094a2 == C1089i.EnumC1094a.SATELLITE) {
                        C0802b.this.f2197J.setParameter(2011, C0802b.this.f2192E == C1089i.EnumC1094a.SATELLITE ? 1 : 0, 0, 0, 0);
                    }
                    if (C0802b.this.f2191D == C1089i.EnumC1096c.NIGHT || enumC1096c2 == C1089i.EnumC1096c.NIGHT) {
                        C0802b.this.f2197J.setParameter(2401, C0802b.this.f2191D == C1089i.EnumC1096c.NIGHT ? 1 : 0, 0, 0, 0);
                        C0802b.this.f2248c.m17641d(true);
                        C0802b.this.f2248c.m17642c(true);
                    }
                    if (!m17643c.equals(m17643c2)) {
                        C0802b.this.f2248c.m17647a(true);
                    }
                    C0802b.this.f2248c.m17644b(true);
                    if (C0802b.this.f2193F != null) {
                        C0802b.this.f2197J.setParameter(2013, C0802b.this.f2192E.ordinal(), C0802b.this.f2191D.ordinal(), C0802b.this.f2193F.ordinal(), 0);
                    }
                    C0802b.this.f2197J.setParameter(2501, 1, 1, 0, 0);
                }
            });
            return;
        }
        this.f2221aG.f2314c = enumC1094a;
        this.f2221aG.f2315d = enumC1096c;
        this.f2221aG.f2313b = true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public synchronized void mo17545a(C1125s c1125s) {
        if (c1125s != null) {
            if (c1125s.m17473b() != 0) {
                this.f2195H.add(c1125s);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17542a(MapMessage mapMessage) {
        if (this.f2197J == null || this.f2238ar.booleanValue()) {
            return;
        }
        if ((this.f2267v || this.f2268w) && this.f2197J.getStateMessageCount() > 0) {
            AbstractC0766af m19092c = C0768ag.m19092c();
            m19092c.f2023a = AbstractC0766af.EnumC0767a.changeGeoCenterZoomTiltBearing;
            m19092c.geoPoint = new IPoint(this.f2242av.getS_x(), this.f2242av.getS_y());
            m19092c.zoom = this.f2242av.getS_z();
            m19092c.bearing = this.f2242av.getS_r();
            m19092c.tilt = this.f2242av.getS_c();
            this.f2197J.addMessage(mapMessage);
            while (this.f2197J.getStateMessageCount() > 0) {
                if (((AbstractC0766af) this.f2197J.getStateMessage()) != null) {
                    mapMessage.mergeCameraUpdateDelegate(m19092c);
                }
            }
            mapMessage = m19092c;
        }
        m18966K();
        this.f2197J.clearAnimations();
        mapMessage.isChangeFinished = true;
        m18927c(mapMessage);
        this.f2197J.addMessage(mapMessage);
    }

    /* renamed from: a */
    public void m18938a(MapMessage mapMessage, long j, AMap.CancelableCallback cancelableCallback) {
        if (this.f2267v || this.f2268w) {
            mo17542a(mapMessage);
            return;
        }
        if (this.f2197J.getAnimateionsCount() > 0 && this.f2231aj != null) {
            try {
                this.f2231aj.onCancel();
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
        m18966K();
        if (cancelableCallback != null) {
            this.f2231aj = cancelableCallback;
        }
        m18927c(mapMessage);
        this.f2197J.clearAnimations();
        MapProjection mapProjection = new MapProjection(this.f2197J);
        this.f2197J.addMapAnimation(mapMessage.generateMapAnimation(mapProjection, (int) j));
        mapProjection.recycle();
    }

    /* renamed from: a */
    public void m18936a(Runnable runnable) {
        if (this.f2249d != null) {
            this.f2249d.queueEvent(runnable);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public void mo17539a(boolean z) {
        if (!this.f2238ar.booleanValue()) {
            this.f2252g.m18246b(z);
        }
    }

    /* renamed from: a */
    protected void m18934a(boolean z, CameraPosition cameraPosition) {
        if (this.f2242av == null || this.f2242av.getChangedCounter() == 0) {
            return;
        }
        this.f2242av.resetChangedCounter();
        if (this.f2225ad != null) {
            this.f2225ad.onMapStable();
        }
        if (this.f2207T == null || !this.f2249d.isEnabled()) {
            return;
        }
        if (cameraPosition == null) {
            try {
                cameraPosition = getCameraPosition();
            } catch (RemoteException e) {
                C1007fo.m18012b(e, "AMapDelegateImp", "cameraChangeFinish");
                e.printStackTrace();
            }
        }
        this.f2207T.onCameraChangeFinish(cameraPosition);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public boolean mo17547a(MotionEvent motionEvent) {
        if (!this.f2236ao) {
            return false;
        }
        m18966K();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f2270y = true;
                m18957T();
                break;
            case 1:
                this.f2270y = false;
                m18956U();
                m18961P();
                break;
        }
        if (motionEvent.getAction() == 2 && this.f2215aA) {
            try {
                m18925e(motionEvent);
            } catch (RemoteException e) {
                C1007fo.m18012b(e, "AMapDelegateImp", "onDragMarker");
                e.printStackTrace();
            }
            return true;
        }
        if (this.f2269x) {
            try {
                this.f2253h.m17749a(motionEvent);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f2209V != null) {
            this.f2259n.removeMessages(16);
            Message obtainMessage = this.f2259n.obtainMessage();
            obtainMessage.what = 16;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: a */
    public boolean mo17540a(String str) {
        m18966K();
        return this.f2247b.m17619d(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Arc addArc(ArcOptions arcOptions) {
        m18966K();
        AbstractC0877cn m17635a = this.f2247b.m17635a(arcOptions);
        if (m17635a != null) {
            return new Arc(m17635a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Circle addCircle(CircleOptions circleOptions) {
        m18966K();
        AbstractC0878co m17634a = this.f2247b.m17634a(circleOptions);
        if (m17634a != null) {
            return new Circle(m17634a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        m18966K();
        AbstractC0879cp m17633a = this.f2247b.m17633a(groundOverlayOptions);
        if (m17633a != null) {
            return new GroundOverlay(m17633a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Marker addMarker(MarkerOptions markerOptions) {
        m18966K();
        return this.f2250e.m17499a(markerOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) {
        m18966K();
        return this.f2250e.m17494a(arrayList, z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        m18966K();
        AbstractC0882cs m17631a = this.f2247b.m17631a(navigateArrowOptions);
        if (m17631a != null) {
            return new NavigateArrow(m17631a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        m18966K();
        AbstractC0885cv m17630a = this.f2247b.m17630a(polygonOptions);
        if (m17630a != null) {
            return new Polygon(m17630a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        m18966K();
        AbstractC0886cw m17629a = this.f2247b.m17629a(polylineOptions);
        if (m17629a != null) {
            return new Polyline(m17629a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Text addText(TextOptions textOptions) {
        m18966K();
        return this.f2250e.m17498a(textOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        return this.f2251f.m17465a(tileOverlayOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCamera(CameraUpdate cameraUpdate) {
        animateCameraWithCallback(cameraUpdate, null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) {
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        m18938a(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public int mo17538b() {
        return this.f2261p;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17537b(double d, double d2, IPoint iPoint) {
        if (this.f2235an) {
            MapProjection mapProjection = new MapProjection(this.f2197J);
            mapProjection.recalculate();
            IPoint iPoint2 = new IPoint();
            FPoint fPoint = new FPoint();
            MapProjection.lonlat2Geo(d2, d, iPoint2);
            mapProjection.geo2Map(iPoint2.f4730x, iPoint2.f4731y, fPoint);
            mapProjection.map2Win(fPoint.f4728x, fPoint.f4729y, iPoint);
            mapProjection.recycle();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17536b(int i) {
        if (this.f2252g != null) {
            this.f2252g.m18250b(i);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17535b(int i, int i2, DPoint dPoint) {
        MapProjection.geo2LonLat(i, i2, dPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17534b(int i, int i2, FPoint fPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        this.f2200M.geo2Map(i2, i, fPoint);
    }

    /* renamed from: b */
    public void m18933b(int i, int i2, IPoint iPoint) {
        if (!this.f2235an || this.f2200M == null) {
            return;
        }
        FPoint fPoint = new FPoint();
        this.f2200M.geo2Map(i, i2, fPoint);
        this.f2200M.map2Win(fPoint.f4728x, fPoint.f4729y, iPoint);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17533b(MotionEvent motionEvent) {
        try {
            this.f2218aD = false;
            this.f2217aC = this.f2250e.m17503a(motionEvent);
            if (this.f2205R != null && this.f2217aC != null && this.f2217aC.isDraggable()) {
                this.f2216aB = new Marker(this.f2217aC);
                LatLng position = this.f2216aB.getPosition();
                LatLng mo18685b = this.f2217aC.mo18685b();
                IPoint iPoint = new IPoint();
                mo17537b(mo18685b.latitude, mo18685b.longitude, iPoint);
                iPoint.f4731y -= 60;
                DPoint dPoint = new DPoint();
                mo17551a(iPoint.f4730x, iPoint.f4731y, dPoint);
                this.f2216aB.setPosition(new LatLng((position.latitude + dPoint.f4727y) - mo18685b.latitude, (dPoint.f4726x + position.longitude) - mo18685b.longitude));
                this.f2250e.m17490b(this.f2217aC);
                this.f2205R.onMarkerDragStart(this.f2216aB);
                this.f2215aA = true;
            } else if (this.f2211X != null) {
                DPoint dPoint2 = new DPoint();
                mo17551a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint2);
                this.f2211X.onMapLongClick(new LatLng(dPoint2.f4727y, dPoint2.f4726x));
                this.f2219aE = true;
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17532b(MapMessage mapMessage) {
        m18938a(mapMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: b */
    public void mo17531b(boolean z) {
        if (!this.f2238ar.booleanValue()) {
            this.f2252g.m18252a(z);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: c */
    public MapProjection mo17530c() {
        if (this.f2200M == null) {
            this.f2200M = this.f2197J.getMapstate();
        }
        return this.f2200M;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: c */
    public void mo17529c(int i) {
        if (this.f2252g != null) {
            this.f2252g.m18244c(i);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: c */
    public void mo17527c(boolean z) {
        if (!this.f2238ar.booleanValue()) {
            this.f2252g.m18242c(z);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: c */
    public boolean mo17528c(MotionEvent motionEvent) {
        this.f2218aD = false;
        if (this.f2219aE) {
            this.f2219aE = false;
        } else {
            try {
                if (!m18909j(motionEvent) && !m18912i(motionEvent) && !m18915h(motionEvent)) {
                    m18923f(motionEvent);
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "onSingleTapUp");
                th.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.f2235an || this.f2238ar.booleanValue()) {
            DPoint dPoint = new DPoint();
            MapProjection.geo2LonLat(mapConfig.getS_x(), mapConfig.getS_y(), dPoint);
            return new Pair<>(Float.valueOf(mapConfig.getS_z()), new LatLng(dPoint.f4727y, dPoint.f4726x));
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        MapProjection mapProjection = new MapProjection(this.f2197J);
        Pair<Float, IPoint> m18338a = C0945eh.m18338a(mapProjection, mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
        mapProjection.recycle();
        if (m18338a == null) {
            return null;
        }
        DPoint dPoint2 = new DPoint();
        MapProjection.geo2LonLat(((IPoint) m18338a.second).f4730x, ((IPoint) m18338a.second).f4731y, dPoint2);
        return new Pair<>(m18338a.first, new LatLng(dPoint2.f4727y, dPoint2.f4726x));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clear() {
        try {
            clear(false);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "clear");
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029 A[Catch: Throwable -> 0x0039, TryCatch #0 {Throwable -> 0x0039, blocks: (B:3:0x0001, B:6:0x000a, B:7:0x0016, B:9:0x0029, B:10:0x002e, B:14:0x0032), top: B:2:0x0001 }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clear(boolean z) {
        String str;
        String str2 = null;
        try {
            mo17513n();
            if (this.f2230ai != null) {
                if (z) {
                    str = this.f2230ai.m18661c();
                    str2 = this.f2230ai.m18659d();
                    this.f2247b.m17623b(str2);
                    this.f2251f.m17462b();
                    this.f2250e.m17495a(str);
                    if (this.f2252g != null) {
                        this.f2252g.m18227k();
                    }
                    m18966K();
                }
                this.f2230ai.m18658e();
            }
            str = null;
            this.f2247b.m17623b(str2);
            this.f2251f.m17462b();
            this.f2250e.m17495a(str);
            if (this.f2252g != null) {
            }
            m18966K();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: d */
    public void mo17526d() {
        if (this.f2266u == 1) {
            return;
        }
        this.f2266u = 1;
        this.f2267v = false;
        if (!this.f2235an) {
            m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C0802b.this.m18974C();
                        C0802b.this.m18965L();
                        if (C0802b.this.f2199L != null) {
                            C0802b.this.f2199L.onResume(C0802b.this.f2197J);
                            C0802b.this.m18966K();
                        }
                        if (C0802b.this.f2251f != null) {
                            C0802b.this.f2251f.m17458d();
                        }
                        if (C0802b.this.f2230ai == null) {
                            return;
                        }
                        C0802b.this.f2230ai.m18669a();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        if (this.f2249d instanceof C0863c) {
            ((C0863c) this.f2249d).onResume();
        } else {
            ((C0890d) this.f2249d).c();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: d */
    public void mo17525d(int i) {
        if (this.f2252g != null) {
            this.f2252g.m18240d(i);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: d */
    public void mo17523d(boolean z) {
        if (!this.f2238ar.booleanValue()) {
            this.f2252g.m18238d(z);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: d */
    public boolean mo17524d(MotionEvent motionEvent) {
        if ((this.f2200M != null ? this.f2200M.getMapZoomer() : this.f2242av.getS_z()) < getMaxZoomLevel()) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            try {
                if (this.f2227af.isZoomInByScreenCenter()) {
                    x = getMapWidth() / 2;
                    y = getMapHeight() / 2;
                }
                mo17532b(C0768ag.m19103a(1.0f, new Point(x, y)));
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroy() {
        this.f2238ar = true;
        try {
            m18964M();
            if (this.f2264s != null) {
                this.f2264s.recycle();
                this.f2264s = null;
            }
            if (this.f2263r != null) {
                this.f2263r.recycle();
                this.f2263r = null;
            }
            if (this.f2259n != null && this.f2258m != null) {
                this.f2259n.removeCallbacks(this.f2258m);
                this.f2258m = null;
            }
            if (this.f2247b != null) {
                this.f2247b.m17624b();
            }
            if (this.f2250e != null) {
                this.f2250e.m17484e();
            }
            if (this.f2251f != null) {
                this.f2251f.m17456f();
            }
            m18955V();
            if (this.f2220aF != null) {
                this.f2220aF.interrupt();
                this.f2220aF = null;
            }
            if (this.f2199L != null) {
                this.f2199L.OnMapDestory(this.f2197J);
                this.f2197J.setMapCallback(null);
                this.f2199L = null;
            }
            if (this.f2197J != null) {
                m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C0802b.this.f2197J.destroy();
                            C0802b.this.f2197J = null;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                Thread.sleep(200L);
            }
            if (this.f2252g != null) {
                this.f2252g.m18228j();
                this.f2252g = null;
            }
            if (this.f2230ai != null) {
                this.f2230ai.m18664b();
                this.f2230ai = null;
            }
            this.f2228ag = null;
            m18971F();
            this.f2190C = null;
            C1007fo.m18013b();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: e */
    public float mo17521e(int i) {
        if (this.f2252g != null) {
            return this.f2252g.m18236e(i);
        }
        return 0.0f;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: e */
    public void mo17522e() {
        if (this.f2266u != 1) {
            return;
        }
        this.f2266u = -1;
        m18975B();
        this.f2267v = true;
        try {
            C0946ei m18245c = this.f2252g.m18245c();
            if (m18245c != null) {
                m18245c.m18308a(true);
            }
            if (this.f2199L != null) {
                this.f2199L.destoryMap(this.f2197J);
            }
            m18964M();
            if (this.f2249d instanceof C0863c) {
                ((C0863c) this.f2249d).onPause();
            } else {
                ((C0890d) this.f2249d).b();
            }
            m18973D();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: e */
    public void mo17520e(boolean z) {
        if (!this.f2238ar.booleanValue()) {
            this.f2252g.m18234e(z);
        }
    }

    /* renamed from: f */
    public CameraPosition m18921f(boolean z) {
        LatLng m18962O;
        if (this.f2267v || this.f2200M == null) {
            DPoint dPoint = new DPoint();
            mo17535b(this.f2242av.getS_x(), this.f2242av.getS_y(), dPoint);
            return CameraPosition.builder().target(new LatLng(dPoint.f4727y, dPoint.f4726x)).bearing(this.f2242av.getS_r()).tilt(this.f2242av.getS_c()).zoom(this.f2242av.getS_z()).build();
        }
        if (z) {
            DPoint dPoint2 = new DPoint();
            mo17551a(this.f2188A, this.f2189B, dPoint2);
            m18962O = new LatLng(dPoint2.f4727y, dPoint2.f4726x, false);
        } else {
            m18962O = m18962O();
        }
        return CameraPosition.builder().target(m18962O).bearing(this.f2200M.getMapAngle()).tilt(this.f2200M.getCameraHeaderAngle()).zoom(this.f2200M.getMapZoomer()).build();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: f */
    public void mo17518f(int i) {
        if (this.f2252g != null) {
            this.f2252g.m18269a(i);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: f */
    public boolean mo17519f() {
        if (this.f2200M != null && this.f2200M.getMapZoomer() >= 17.0f && this.f2254i != null && this.f2254i.f2123g != null) {
            IPoint iPoint = new IPoint();
            m18933b(this.f2254i.f2123g.f4730x, this.f2254i.f2123g.f4731y, iPoint);
            if (this.f2229ah.contains(iPoint.f4730x, iPoint.f4731y)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    void m18920g() {
        this.f2259n.obtainMessage(15).sendToTarget();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: g */
    public synchronized void mo17517g(int i) {
        Iterator<C1125s> it2 = this.f2195H.iterator();
        while (it2.hasNext()) {
            C1125s next = it2.next();
            if (next.m17473b() == i) {
                this.f2195H.remove(next);
            }
        }
    }

    /* renamed from: g */
    void m18917g(boolean z) {
        this.f2259n.obtainMessage(19, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Projection getAMapProjection() {
        return new Projection(this.f2226ae);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public UiSettings getAMapUiSettings() {
        return new UiSettings(this.f2227af);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getCameraAngle() {
        return this.f2242av.getS_c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CameraPosition getCameraPosition() {
        return m18921f(this.f2271z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.f2201N);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Handler getMainHandler() {
        return this.f2259n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MapConfig getMapConfig() {
        return this.f2242av;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapHeight() {
        return this.f2249d.getHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        this.f2223ab = onmapprintscreenlistener;
        this.f2239as = true;
        m18966K();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public List<Marker> getMapScreenMarkers() {
        return !C0945eh.m18359a(getMapWidth(), getMapHeight()) ? new ArrayList() : this.f2250e.m17482f();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.f2224ac = onMapScreenShotListener;
        this.f2239as = true;
        m18966K();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapTextZIndex() {
        return this.f2232ak;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapType() {
        return this.f2196I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapWidth() {
        return this.f2249d.getWidth();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMaxZoomLevel() {
        return this.f2242av.getMaxZoomLevel();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMinZoomLevel() {
        return this.f2242av.getMinZoomLevel();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Location getMyLocation() {
        if (this.f2228ag != null) {
            return this.f2222aa.f2879a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getScalePerPixel() {
        try {
            LatLng latLng = getCameraPosition().target;
            float s_z = this.f2242av.getS_z();
            if (this.f2235an && this.f2200M != null) {
                s_z = this.f2200M.getMapZoomer();
            }
            return ((float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, s_z) * 256.0d))) * mo17508u();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public View getView() {
        return this.f2252g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.f2235an || this.f2238ar.booleanValue()) {
            return mapConfig.getS_z();
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        MapProjection mapProjection = new MapProjection(this.f2197J);
        Pair<Float, IPoint> m18338a = C0945eh.m18338a(mapProjection, mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
        mapProjection.recycle();
        return m18338a != null ? ((Float) m18338a.first).floatValue() : mapProjection.getMapZoomer();
    }

    /* renamed from: h */
    void m18916h() {
        this.f2259n.obtainMessage(14).sendToTarget();
    }

    /* renamed from: i */
    void m18913i() {
        this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2252g != null) {
                    C0802b.this.f2252g.m18251b().m18225a();
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isIndoorEnabled() {
        return this.f2242av.isIndoorEnable();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMaploaded() {
        return this.f2236ao;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMyLocationEnabled() {
        return this.f2234am;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTrafficEnabled() {
        return this.f2242av.isTrafficEnabled();
    }

    /* renamed from: j */
    public void m18910j() {
        if (this.f2242av.getMapRect() == null) {
            m18968I();
        }
        MapProjection mapstate = this.f2197J.getMapstate();
        if (mapstate != null) {
            IPoint iPoint = new IPoint();
            mapstate.getGeoCenter(iPoint);
            this.f2242av.setS_x(iPoint.f4730x);
            this.f2242av.setS_y(iPoint.f4731y);
            this.f2242av.setS_z(mapstate.getMapZoomer());
            this.f2242av.setS_c(mapstate.getCameraHeaderAngle());
            this.f2242av.setS_r(mapstate.getMapAngle());
            if (this.f2214a != -1) {
                this.f2243aw.m18506a(this.f2214a);
            } else if (this.f2197J.getAnimateionsCount() == 0) {
                this.f2243aw.m18506a(15);
            }
            if (!this.f2242av.isMapStateChange()) {
                return;
            }
            if (this.f2200M != null) {
                this.f2242av.setMapPerPixelUnitLength(this.f2200M.getMapLenWithWin(1));
            }
            DPoint dPoint = new DPoint();
            MapProjection.geo2LonLat(iPoint.f4730x, iPoint.f4731y, dPoint);
            CameraPosition cameraPosition = new CameraPosition(new LatLng(dPoint.f4727y, dPoint.f4726x, false), this.f2242av.getS_z(), this.f2242av.getS_c(), this.f2242av.getS_r());
            Message obtainMessage = this.f2259n.obtainMessage();
            obtainMessage.what = 10;
            obtainMessage.obj = cameraPosition;
            this.f2259n.sendMessage(obtainMessage);
            mo17515l();
            m18968I();
            try {
                if (this.f2227af.isZoomControlsEnabled() && this.f2242av.isNeedUpdateZoomControllerState()) {
                    m18916h();
                }
                if (this.f2242av.getChangeGridRatio() != 1.0d) {
                    m18917g(true);
                }
                if (this.f2227af.isCompassEnabled() && (this.f2242av.isTiltChanged() || this.f2242av.isBearingChanged())) {
                    m18920g();
                }
                if (!this.f2227af.isScaleControlsEnabled()) {
                    return;
                }
                m18913i();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: k */
    public int mo17516k() {
        return this.f2262q;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: l */
    public void mo17515l() {
        if (this.f2235an) {
            this.f2259n.sendEmptyMessage(21);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: m */
    public AbstractC1118o mo17514m() {
        return this.f2227af;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void moveCamera(CameraUpdate cameraUpdate) {
        if (cameraUpdate == null) {
            return;
        }
        mo17542a(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: n */
    public void mo17513n() {
        if (this.f2255j != null) {
            this.f2255j.mo18241d();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: o */
    public float mo17512o() {
        return this.f2200M != null ? this.f2200M.getMapZoomer() : this.f2242av.getS_z();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityPause() {
        m18975B();
        this.f2268w = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityResume() {
        this.f2268w = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onChangeFinish() {
        m18966K();
        Message obtainMessage = this.f2259n.obtainMessage();
        obtainMessage.what = 12;
        this.f2259n.sendMessage(obtainMessage);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f2238ar.booleanValue() || this.f2267v) {
            return;
        }
        try {
            if (!this.f2235an) {
                gl10.glClearColor(0.9453125f, 0.93359f, 0.9101f, 1.0f);
                return;
            }
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            gl10.glClear(16640);
            m18967J();
            this.f2197J.setGL(gl10);
            this.f2197J.drawFrame(gl10);
            this.f2251f.m17464a(gl10);
            if (this.f2194G == 1 && this.f2244ax != null) {
                this.f2244ax.m17475a(gl10, this.f2229ah.width(), this.f2229ah.height());
            }
            this.f2247b.m17625a(gl10, false, this.f2232ak);
            if (this.f2194G == 0 && this.f2244ax != null) {
                this.f2250e.m17489b(gl10);
                this.f2244ax.m17475a(gl10, this.f2229ah.width(), this.f2229ah.height());
                this.f2247b.m17626a(gl10);
            }
            this.f2250e.m17493a(gl10);
            if (this.f2201N != null && this.f2200M != null) {
                this.f2201N.m18602a(gl10, this.f2200M, getMapWidth(), getMapHeight());
            }
            m18935a(gl10);
            m18969H();
            m18910j();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onFling() {
        if (this.f2251f != null) {
            this.f2251f.m17460b(true);
        }
        this.f2241au = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        try {
            this.f2229ah = new Rect(0, 0, i, i2);
            this.f2197J.setGL(gl10);
            this.f2197J.surfaceChange(gl10, i, i2);
            if (this.f2242av != null) {
                this.f2242av.updateMapRectNextFrame(true);
            }
            m18972E();
            if (this.f2221aG.f2313b) {
                if (this.f2259n != null) {
                    this.f2259n.post(this.f2221aG);
                } else {
                    this.f2221aG.run();
                }
            }
            m18966K();
            if (this.f2260o == null) {
                return;
            }
            this.f2260o.onSurfaceChanged(gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        try {
            if (!this.f2235an) {
                m18974C();
            }
            this.f2245ay = false;
            this.f2197J.setGL(gl10);
            m18963N();
            if (this.f2191D == C1089i.EnumC1096c.NIGHT) {
                this.f2197J.setParameter(2401, 1, 0, 0, 0);
                this.f2252g.m18245c().m18309a(C0946ei.f2905b);
            } else {
                this.f2252g.m18245c().m18309a(C0946ei.f2904a);
            }
            this.f2197J.surfaceCreate(gl10);
            m18930b(gl10);
            this.f2240at = false;
            m18958S();
            m18965L();
            m18966K();
            m18960Q();
            if (this.f2260o == null) {
                return;
            }
            this.f2260o.onSurfaceCreated(gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: p */
    public FPoint[] mo17511p() {
        if (this.f2242av.getMapRect() == null) {
            this.f2242av.setMapRect(C0945eh.m18347a((AbstractC1115l) this, true));
        }
        return this.f2242av.getMapRect();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: q */
    public Point mo17510q() {
        return this.f2252g != null ? this.f2252g.m18271a() : new Point();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: r */
    public void mo17509r() {
        this.f2247b.m17622c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void reloadMap() {
        this.f2236ao = false;
        mo17522e();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mo17526d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache() {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) {
        if (this.f2259n != null) {
            try {
                this.f2197J.setParameter(2601, 0, 0, 0, 0);
                RunnableC0829c runnableC0829c = new RunnableC0829c(this.f2198K, onCacheRemoveListener);
                this.f2259n.removeCallbacks(runnableC0829c);
                this.f2259n.post(runnableC0829c);
            } catch (Throwable th) {
                C1007fo.m18012b(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetMinMaxZoomPreference() {
        this.f2242av.resetMinMaxZoomPreference();
    }

    /* renamed from: s */
    public void m18899s() {
        if (this.f2247b != null) {
            this.f2247b.m17620d();
        }
        if (this.f2250e != null) {
            this.f2250e.m17488c();
        }
        if (this.f2260o != null) {
            this.f2260o.OnMapReferencechanged();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void set3DBuildingEnabled(final boolean z) {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        this.f2242av.setBuildingEnable(z);
        m18966K();
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2197J != null) {
                    C0802b.this.f2197J.setParameter(1021, z ? 1 : 0, 0, 0, 0);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        this.f2225ad = aMapGestureListener;
        this.f2253h.m17746a(aMapGestureListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCenterToPixel(int i, int i2) {
        if (this.f2199L != null) {
            this.f2271z = true;
            this.f2188A = i;
            this.f2189B = i2;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomRenderer(CustomRenderer customRenderer) {
        this.f2260o = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) {
        if (this.f2238ar.booleanValue() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f2254i = (C0784aq) indoorBuildingInfo;
        m18966K();
        this.f2256k = 0;
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.9
            @Override // java.lang.Runnable
            public void run() {
                C0802b.this.f2197J.setIndoorBuildingToBeActive(C0802b.this.f2254i.activeFloorName, C0802b.this.f2254i.activeFloorIndex, C0802b.this.f2254i.poiid);
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorEnabled(final boolean z) {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        this.f2242av.setIndoorEnable(z);
        m18966K();
        if (z) {
            this.f2197J.setParameter(C2427e.f8186P, 1, 0, 0, 0);
        } else {
            this.f2197J.setParameter(C2427e.f8186P, 0, 0, 0, 0);
            this.f2242av.maxZoomLevel = this.f2242av.isSetLimitZoomLevel() ? this.f2242av.getMaxZoomLevel() : 19.0f;
            if (this.f2227af.isZoomControlsEnabled()) {
                m18916h();
            }
        }
        if (!this.f2227af.isIndoorSwitchEnabled()) {
            return;
        }
        this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.21
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    C0802b.this.mo17531b(true);
                } else if (C0802b.this.f2252g == null || C0802b.this.f2252g.m18233f() == null) {
                } else {
                    C0802b.this.f2252g.m18233f().m18296a(false);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        if (!(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            this.f2201N.destroy();
            this.f2255j = this.f2252g;
            this.f2252g.m18254a(infoWindowAdapter);
            return;
        }
        if (this.f2255j != null) {
            this.f2255j.mo18241d();
        }
        this.f2255j = this.f2201N;
        this.f2201N.m18607a((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLoadOfflineData(final boolean z) {
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.6
            @Override // java.lang.Runnable
            public void run() {
                C0802b.this.f2197J.setParameter(2601, z ? 1 : 0, 0, 0, 0);
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLocationSource(LocationSource locationSource) {
        try {
            if (!this.f2238ar.booleanValue()) {
                this.f2228ag = locationSource;
                if (locationSource != null) {
                    this.f2252g.m18231g().m18272a(true);
                } else {
                    this.f2252g.m18231g().m18272a(false);
                }
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        this.f2242av.setLimitLatLngBounds(latLngBounds);
        m18954W();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextEnable(final boolean z) {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        this.f2242av.setMapTextEnable(z);
        m18966K();
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.20
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2197J != null) {
                    C0802b.this.f2197J.setParameter(1024, z ? 1 : 0, 0, 0, 0);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextZIndex(int i) {
        this.f2232ak = i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapType(int i) {
        this.f2196I = i;
        try {
            if (i == 1) {
                m18940a(C1089i.EnumC1094a.NORAML, C1089i.EnumC1096c.DAY);
            } else if (i == 2) {
                m18940a(C1089i.EnumC1094a.SATELLITE, C1089i.EnumC1096c.DAY);
            } else if (i == 3) {
                m18939a(C1089i.EnumC1094a.NORAML, C1089i.EnumC1096c.NIGHT, C1089i.EnumC1095b.NAVI_CAR);
            } else if (i == 4) {
                m18939a(C1089i.EnumC1094a.NORAML, C1089i.EnumC1096c.DAY, C1089i.EnumC1095b.NAVI_CAR);
            } else {
                this.f2196I = 1;
                m18940a(C1089i.EnumC1094a.NORAML, C1089i.EnumC1096c.DAY);
            }
            m18966K();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "setMaptype");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaskLayerParams(int i, int i2, int i3, int i4, final int i5, long j) {
        C0901dh c0901dh;
        try {
            if (this.f2244ax == null) {
                return;
            }
            float f = i4 / 255.0f;
            if (i5 == -1) {
                c0901dh = new C0901dh(f, 0.0f);
                c0901dh.a(new Animation.AnimationListener() { // from class: com.amap.api.mapcore.util.b.14
                    @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                    public void onAnimationEnd() {
                        C0802b.this.f2259n.post(new Runnable() { // from class: com.amap.api.mapcore.util.b.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C0802b.this.f2194G = i5;
                                if (C0802b.this.f2252g != null) {
                                    C0802b.this.f2252g.m18229i().setVisibility(0);
                                }
                            }
                        });
                    }

                    @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                    public void onAnimationStart() {
                    }
                });
            } else {
                this.f2194G = i5;
                c0901dh = new C0901dh(0.0f, f);
                if (f > 0.2d) {
                    if (this.f2252g != null) {
                        this.f2252g.m18229i().setVisibility(4);
                    }
                } else if (this.f2252g != null) {
                    this.f2252g.m18229i().setVisibility(0);
                }
            }
            c0901dh.a(new LinearInterpolator());
            c0901dh.a(j);
            this.f2244ax.m17477a(i, i2, i3, i4);
            this.f2244ax.m17476a(c0901dh);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaxZoomLevel(float f) {
        this.f2242av.setMaxZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMinZoomLevel(float f) {
        this.f2242av.setMinZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationEnabled(boolean z) {
        try {
            if (this.f2252g != null) {
                C0956el m18231g = this.f2252g.m18231g();
                if (this.f2228ag == null) {
                    m18231g.m18272a(false);
                } else if (z) {
                    this.f2228ag.activate(this.f2222aa);
                    m18231g.m18272a(true);
                    if (this.f2230ai == null) {
                        this.f2230ai = new C0891da(this, this.f2198K);
                    }
                } else {
                    if (this.f2230ai != null) {
                        this.f2230ai.m18664b();
                        this.f2230ai = null;
                    }
                    this.f2233al = null;
                    this.f2228ag.deactivate();
                }
            }
            if (!z) {
                this.f2227af.setMyLocationButtonEnabled(z);
            }
            this.f2234am = z;
            m18966K();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationRotateAngle(float f) {
        if (this.f2230ai != null) {
            this.f2230ai.m18668a(f);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        if (this.f2230ai != null) {
            this.f2230ai.m18665a(myLocationStyle);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationType(int i) {
        if (this.f2230ai != null) {
            this.f2230ai.m18667a(i);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        if (!this.f2238ar.booleanValue() && this.f2235an && myTrafficStyle != null) {
            this.f2190C = myTrafficStyle;
            this.f2197J.setParameter(2201, 1, 1, 1, 1);
            this.f2197J.setParameter(2202, myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) {
        this.f2207T = onCameraChangeListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        this.f2213Z = onIndoorBuildingActiveListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f2212Y = onInfoWindowClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) {
        this.f2208U = onMapClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) {
        this.f2211X = onMapLongClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) {
        this.f2209V = onMapTouchListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        this.f2206S = onMapLoadedListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) {
        this.f2203P = onMarkerClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        this.f2205R = onMarkerDragListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f2202O = onMyLocationChangeListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) {
        this.f2210W = onPOIClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) {
        this.f2204Q = onPolylineClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderFps(int i) {
        try {
            this.f2214a = Math.max(10, Math.min(i, 40));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public synchronized void setRunLowFrame(boolean z) {
        if (!z) {
            m18970G();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficEnabled(final boolean z) {
        if (this.f2238ar.booleanValue()) {
            return;
        }
        this.f2242av.setTrafficEnabled(z);
        m18966K();
        m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.b.19
            @Override // java.lang.Runnable
            public void run() {
                if (C0802b.this.f2197J != null) {
                    C0802b.this.f2197J.setParameter(2010, z ? 1 : 0, 0, 0, 0);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setVisibilityEx(int i) {
        this.f2249d.setVisibility(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZOrderOnTop(boolean z) {
        this.f2249d.setZOrderOnTop(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZoomScaleParam(float f) {
        this.f2265t = f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void stopAnimation() {
        if (this.f2197J != null && this.f2197J.getAnimateionsCount() > 0) {
            m18934a(true, (CameraPosition) null);
            this.f2197J.clearAnimations();
            if (this.f2231aj != null) {
                try {
                    this.f2231aj.onCancel();
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "AMapDelegateImp", "CancelableCallback.onCancel");
                    th.printStackTrace();
                }
            }
            this.f2231aj = null;
        }
        m18966K();
    }

    /* renamed from: t */
    public Context m18897t() {
        return this.f2198K;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: u */
    public float mo17508u() {
        return this.f2265t;
    }

    /* renamed from: v */
    public C1089i.EnumC1096c m18894v() {
        return this.f2191D;
    }

    /* renamed from: w */
    public C1089i.EnumC1094a m18892w() {
        return this.f2192E;
    }

    /* renamed from: x */
    public C1089i.EnumC1095b m18890x() {
        return this.f2193F;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: y */
    public float mo17507y() {
        return this.f2242av.getS_r();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1115l
    /* renamed from: z */
    public View mo17506z() {
        return (View) this.f2249d;
    }
}
