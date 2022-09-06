package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.RemoteException;
import android.support.p001v4.view.ViewCompat;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.dd */
/* loaded from: classes.dex */
public class C0894dd implements AbstractC0886cw {

    /* renamed from: H */
    private float f2590H;

    /* renamed from: I */
    private float f2591I;

    /* renamed from: J */
    private float f2592J;

    /* renamed from: K */
    private float f2593K;

    /* renamed from: N */
    private float[] f2596N;

    /* renamed from: O */
    private int[] f2597O;

    /* renamed from: P */
    private int[] f2598P;

    /* renamed from: U */
    private PolylineOptions f2603U;

    /* renamed from: e */
    private C1097j f2610e;

    /* renamed from: f */
    private String f2611f;

    /* renamed from: n */
    private FloatBuffer f2619n;

    /* renamed from: g */
    private List<IPoint> f2612g = new ArrayList();

    /* renamed from: h */
    private List<FPoint> f2613h = new ArrayList();

    /* renamed from: i */
    private List<LatLng> f2614i = new ArrayList();

    /* renamed from: j */
    private List<BitmapDescriptor> f2615j = new ArrayList();

    /* renamed from: k */
    private List<Integer> f2616k = new ArrayList();

    /* renamed from: l */
    private List<Integer> f2617l = new ArrayList();

    /* renamed from: m */
    private List<Integer> f2618m = new ArrayList();

    /* renamed from: o */
    private BitmapDescriptor f2620o = null;

    /* renamed from: p */
    private LatLngBounds f2621p = null;

    /* renamed from: q */
    private Object f2622q = new Object();

    /* renamed from: r */
    private boolean f2623r = true;

    /* renamed from: s */
    private boolean f2624s = true;

    /* renamed from: t */
    private boolean f2625t = false;

    /* renamed from: u */
    private boolean f2626u = false;

    /* renamed from: v */
    private boolean f2627v = false;

    /* renamed from: w */
    private boolean f2628w = true;

    /* renamed from: x */
    private boolean f2629x = false;

    /* renamed from: y */
    private boolean f2630y = false;

    /* renamed from: z */
    private boolean f2631z = true;

    /* renamed from: A */
    private int f2583A = 0;

    /* renamed from: B */
    private int f2584B = 0;

    /* renamed from: C */
    private int f2585C = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: D */
    private int f2586D = 0;

    /* renamed from: E */
    private float f2587E = 10.0f;

    /* renamed from: F */
    private float f2588F = 0.0f;

    /* renamed from: G */
    private float f2589G = 0.0f;

    /* renamed from: L */
    private float f2594L = 1.0f;

    /* renamed from: M */
    private float f2595M = 0.0f;

    /* renamed from: Q */
    private double f2599Q = 5.0d;

    /* renamed from: R */
    private boolean f2600R = false;

    /* renamed from: S */
    private final int f2601S = 2;

    /* renamed from: T */
    private FPointBounds f2602T = null;

    /* renamed from: V */
    private int f2604V = 0;

    /* renamed from: W */
    private int f2605W = 2;

    /* renamed from: a */
    int f2606a = 0;

    /* renamed from: b */
    int f2607b = 0;

    /* renamed from: c */
    ArrayList<FPoint> f2608c = new ArrayList<>();

    /* renamed from: d */
    long f2609d = 0;

    public C0894dd(C1097j c1097j, PolylineOptions polylineOptions) {
        this.f2610e = c1097j;
        setOptions(polylineOptions);
        try {
            this.f2611f = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private double m18642a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d5 - d3) * (d - d3)) + ((d6 - d4) * (d2 - d4));
        if (d7 <= 0.0d) {
            return Math.sqrt(((d - d3) * (d - d3)) + ((d2 - d4) * (d2 - d4)));
        }
        double d8 = ((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4));
        if (d7 >= d8) {
            return Math.sqrt(((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6)));
        }
        double d9 = d7 / d8;
        double d10 = ((d5 - d3) * d9) + d3;
        double d11 = (d9 * (d6 - d4)) + d4;
        return Math.sqrt(((d11 - d2) * (d11 - d2)) + ((d - d10) * (d - d10)));
    }

    /* renamed from: a */
    private double m18638a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return m18642a(fPoint.f4728x, fPoint.f4729y, fPoint2.f4728x, fPoint2.f4729y, fPoint3.f4728x, fPoint3.f4729y);
    }

    /* renamed from: a */
    private int m18633a(GL10 gl10, int i, boolean z, BitmapDescriptor bitmapDescriptor) {
        Bitmap bitmap;
        int mo17544a = z ? this.f2610e.m17618e().mo17544a(bitmapDescriptor) : i;
        if (mo17544a == 0 && (bitmap = bitmapDescriptor.getBitmap()) != null && !bitmap.isRecycled()) {
            mo17544a = m18624c(gl10);
            if (z) {
                this.f2610e.m17618e().mo17545a(new C1125s(bitmapDescriptor, mo17544a));
            }
            C0945eh.m18315b(gl10, mo17544a, bitmap, true);
        }
        return mo17544a;
    }

    /* renamed from: a */
    private void m18634a(GL10 gl10, float f) {
        if (!this.f2627v) {
            try {
                if (this.f2615j != null) {
                    this.f2598P = new int[this.f2615j.size()];
                    boolean z = Build.VERSION.SDK_INT >= 12;
                    int i = 0;
                    int i2 = 0;
                    for (BitmapDescriptor bitmapDescriptor : this.f2615j) {
                        int m18633a = m18633a(gl10, i, z, bitmapDescriptor);
                        this.f2598P[i2] = m18633a;
                        i2++;
                        i = m18633a;
                    }
                    this.f2627v = true;
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "MarkerDelegateImp", "loadtexture");
                return;
            }
        }
        FPoint[] mapRect = this.f2610e.m17618e().getMapConfig().getMapRect();
        try {
            List<FPoint> list = this.f2613h;
            if (m18631a(mapRect)) {
                synchronized (this.f2622q) {
                    list = C0945eh.m18314b(mapRect, this.f2613h, false);
                }
            }
            if (list.size() < 2) {
                return;
            }
            m18618e(list);
            int[] iArr = new int[this.f2618m.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int intValue = this.f2618m.get(i3).intValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                iArr[i3] = this.f2598P[intValue];
            }
            if (!(this.f2597O != null) || !(iArr != null)) {
                return;
            }
            AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.f2596N, this.f2606a, f, iArr, iArr.length, this.f2597O, this.f2597O.length, 1.0f - this.f2594L);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m18639a(FPoint fPoint, FPoint fPoint2) {
        return Math.abs(fPoint2.f4728x - fPoint.f4728x) >= this.f2595M || Math.abs(fPoint2.f4729y - fPoint.f4729y) >= this.f2595M;
    }

    /* renamed from: a */
    private boolean m18631a(FPoint[] fPointArr) {
        this.f2589G = this.f2610e.m17618e().mo17512o();
        m18619e();
        if (this.f2589G <= 10.0f) {
            return false;
        }
        try {
            if (this.f2610e.m17618e() == null) {
                return false;
            }
            if (C0945eh.m18341a(this.f2602T.northeast, fPointArr)) {
                if (C0945eh.m18341a(this.f2602T.southwest, fPointArr)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    private FPoint m18630b(LatLng latLng) {
        IPoint iPoint = new IPoint();
        this.f2610e.m17618e().mo17555a(latLng.latitude, latLng.longitude, iPoint);
        FPoint fPoint = new FPoint();
        this.f2610e.m17618e().mo17534b(iPoint.f4731y, iPoint.f4730x, fPoint);
        return fPoint;
    }

    /* renamed from: b */
    private void m18628b(GL10 gl10) {
        float mapLenWithWin = this.f2610e.m17618e().mo17530c().getMapLenWithWin((int) this.f2587E);
        switch (this.f2583A) {
            case 0:
                m18614f(gl10, mapLenWithWin);
                return;
            case 1:
                m18620d(gl10, mapLenWithWin);
                return;
            case 2:
                m18617e(gl10, mapLenWithWin);
                return;
            case 3:
                m18623c(gl10, mapLenWithWin);
                return;
            case 4:
                m18627b(gl10, mapLenWithWin);
                return;
            case 5:
                m18634a(gl10, mapLenWithWin);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m18627b(GL10 gl10, float f) {
        int[] iArr = new int[this.f2617l.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2617l.size()) {
                AMapNativeRenderer.nativeDrawGradientColorLine(this.f2596N, this.f2596N.length, f, iArr, this.f2617l.size(), this.f2597O, this.f2597O.length, this.f2610e.m17618e().mo17538b());
                return;
            } else {
                iArr[i2] = this.f2617l.get(i2).intValue();
                i = i2 + 1;
            }
        }
    }

    /* renamed from: c */
    private int m18624c(GL10 gl10) {
        int[] iArr = {0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: c */
    private void m18623c(GL10 gl10, float f) {
        int[] iArr = new int[this.f2617l.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2617l.size()) {
                AMapNativeRenderer.nativeDrawLineByMultiColor(this.f2596N, this.f2596N.length, f, this.f2610e.m17618e().mo17538b(), iArr, this.f2617l.size(), this.f2597O, this.f2597O.length);
                return;
            } else {
                iArr[i2] = this.f2617l.get(i2).intValue();
                i = i2 + 1;
            }
        }
    }

    /* renamed from: d */
    private void m18620d(GL10 gl10, float f) {
        boolean z = true;
        if (!this.f2627v) {
            synchronized (this) {
                if (this.f2620o != null) {
                    int[] iArr = {0};
                    if (Build.VERSION.SDK_INT < 12) {
                        z = false;
                    }
                    iArr[0] = m18633a(gl10, 0, z, this.f2620o);
                    this.f2584B = iArr[0];
                    this.f2627v = true;
                }
            }
        }
        try {
            MapConfig mapConfig = this.f2610e.m17618e().getMapConfig();
            if (mapConfig.getChangeRatio() == 0.0d && this.f2596N != null) {
                this.f2604V++;
                if (this.f2604V > this.f2605W) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.f2596N, this.f2606a, f, this.f2584B, this.f2591I, this.f2592J, this.f2593K, this.f2590H, 1.0f - this.f2594L, false, false, false);
                    return;
                }
            }
            this.f2604V = 0;
            FPoint[] mapRect = mapConfig.getMapRect();
            List<FPoint> list = this.f2613h;
            if (m18631a(mapRect)) {
                synchronized (this.f2622q) {
                    list = C0945eh.m18325a(mapRect, this.f2613h, false);
                }
            }
            if (list.size() < 2) {
                return;
            }
            m18618e(list);
            AMapNativeRenderer.nativeDrawLineByTextureID(this.f2596N, this.f2606a, f, this.f2584B, this.f2591I, this.f2592J, this.f2593K, this.f2590H, 1.0f - this.f2594L, false, false, false);
        } catch (Throwable th) {
        }
    }

    /* renamed from: e */
    private void m18619e() {
        if (this.f2586D <= 5000 || this.f2589G > 12.0f) {
            this.f2595M = this.f2610e.m17618e().mo17530c().getMapLenWithWin(10);
            return;
        }
        float f = (this.f2587E / 2.0f) + (this.f2589G / 2.0f);
        if (f > 200.0f) {
            f = 200.0f;
        }
        this.f2595M = this.f2610e.m17618e().mo17530c().getMapLenWithWin((int) f);
    }

    /* renamed from: e */
    private void m18618e(List<FPoint> list) {
        int i = 0;
        this.f2608c.clear();
        int size = list.size();
        if (size < 2) {
            return;
        }
        FPoint fPoint = list.get(0);
        this.f2608c.add(fPoint);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            FPoint fPoint2 = fPoint;
            if (i3 >= size - 1) {
                break;
            }
            fPoint = list.get(i3);
            if (m18639a(fPoint2, fPoint)) {
                this.f2608c.add(fPoint);
            } else {
                fPoint = fPoint2;
            }
            i2 = i3 + 1;
        }
        this.f2608c.add(list.get(size - 1));
        int size2 = this.f2608c.size() * 3;
        this.f2606a = size2;
        if (this.f2596N == null || this.f2596N.length < this.f2606a) {
            this.f2596N = new float[size2];
        }
        if (this.f2583A != 5) {
            Iterator<FPoint> it2 = this.f2608c.iterator();
            while (it2.hasNext()) {
                FPoint next = it2.next();
                this.f2596N[i * 3] = next.f4728x;
                this.f2596N[(i * 3) + 1] = next.f4729y;
                this.f2596N[(i * 3) + 2] = 0.0f;
                i++;
            }
            return;
        }
        int[] iArr = new int[this.f2608c.size()];
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size2 / 3; i6++) {
            FPoint3 fPoint3 = (FPoint3) this.f2608c.get(i6);
            this.f2596N[i6 * 3] = fPoint3.f4728x;
            this.f2596N[(i6 * 3) + 1] = fPoint3.f4729y;
            this.f2596N[(i6 * 3) + 2] = 0.0f;
            int i7 = fPoint3.colorIndex;
            if (i6 == 0) {
                arrayList.add(Integer.valueOf(i7));
            } else if (i7 != i5) {
                if (i7 != -1) {
                    i5 = i7;
                }
                arrayList.add(Integer.valueOf(i5));
                i7 = i5;
            }
            iArr[i4] = i6;
            i4++;
            i5 = i7;
        }
        this.f2597O = new int[arrayList.size()];
        System.arraycopy(iArr, 0, this.f2597O, 0, this.f2597O.length);
        this.f2618m = arrayList;
    }

    /* renamed from: e */
    private void m18617e(GL10 gl10, float f) {
        AMapNativeRenderer.nativeDrawLineByTextureID(this.f2596N, this.f2596N.length, f, this.f2610e.m17618e().mo17516k(), this.f2591I, this.f2592J, this.f2593K, this.f2590H, 0.0f, true, true, false);
    }

    /* renamed from: f */
    private ArrayList<FPoint> m18616f() {
        ArrayList<FPoint> arrayList = new ArrayList<>();
        int i = 0;
        while (i < this.f2596N.length) {
            float f = this.f2596N[i];
            int i2 = i + 1;
            arrayList.add(new FPoint(f, this.f2596N[i2]));
            i = i2 + 1 + 1;
        }
        return arrayList;
    }

    /* renamed from: f */
    private List<Integer> m18615f(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int intValue = list.get(i3).intValue();
            if (i3 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i2) {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i] = i3;
            i++;
            i2 = intValue;
        }
        this.f2597O = new int[arrayList.size()];
        System.arraycopy(iArr, 0, this.f2597O, 0, this.f2597O.length);
        return arrayList;
    }

    /* renamed from: f */
    private void m18614f(GL10 gl10, float f) {
        try {
            List<FPoint> list = this.f2613h;
            if (this.f2610e.m17618e() == null) {
                return;
            }
            if (this.f2610e.m17618e().getMapConfig().getChangeRatio() == 0.0d && this.f2596N != null) {
                this.f2604V++;
                if (this.f2604V > this.f2605W) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.f2596N, this.f2606a, f, this.f2610e.m17618e().mo17538b(), this.f2591I, this.f2592J, this.f2593K, this.f2590H, 0.0f, false, true, false);
                    return;
                }
            }
            this.f2604V = 0;
            FPoint[] mo17511p = this.f2610e.m17618e().mo17511p();
            if (m18631a(mo17511p)) {
                synchronized (this.f2622q) {
                    list = C0945eh.m18325a(mo17511p, this.f2613h, false);
                }
            }
            if (list.size() < 2) {
                return;
            }
            m18618e(list);
            AMapNativeRenderer.nativeDrawLineByTextureID(this.f2596N, this.f2606a, f, this.f2610e.m17618e().mo17538b(), this.f2591I, this.f2592J, this.f2593K, this.f2590H, 0.0f, false, true, false);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    IPoint m18637a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint iPoint4 = new IPoint();
        double d2 = iPoint2.f4730x - iPoint.f4730x;
        double d3 = iPoint2.f4731y - iPoint.f4731y;
        iPoint4.f4731y = (int) (((i * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + 1.0d)) + iPoint3.f4731y);
        iPoint4.f4730x = (int) (((d3 * (iPoint3.f4731y - iPoint4.f4731y)) / d2) + iPoint3.f4730x);
        return iPoint4;
    }

    /* renamed from: a */
    void m18640a(LatLng latLng, LatLng latLng2, List<IPoint> list, LatLngBounds.Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint iPoint = new IPoint();
        this.f2610e.m17618e().mo17555a(latLng.latitude, latLng.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f2610e.m17618e().mo17555a(latLng2.latitude, latLng2.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f2610e.m17618e().mo17555a(latLng3.latitude, latLng3.longitude, iPoint3);
        double cos = Math.cos(0.5d * abs);
        IPoint m18637a = m18637a(iPoint, iPoint2, iPoint3, Math.hypot(iPoint.f4730x - iPoint2.f4730x, iPoint.f4731y - iPoint2.f4731y) * 0.5d * Math.tan(0.5d * abs), i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iPoint);
        arrayList.add(m18637a);
        arrayList.add(iPoint2);
        m18635a(arrayList, list, cos);
    }

    /* renamed from: a */
    void m18636a(List<LatLng> list) {
        ArrayList arrayList = new ArrayList();
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            Iterator<LatLng> it2 = list.iterator();
            while (true) {
                LatLng latLng2 = latLng;
                if (!it2.hasNext()) {
                    break;
                }
                latLng = it2.next();
                if (!this.f2625t) {
                    IPoint iPoint = new IPoint();
                    this.f2610e.m17618e().mo17555a(latLng.latitude, latLng.longitude, iPoint);
                    arrayList.add(iPoint);
                    builder.include(latLng);
                } else if (latLng2 != null) {
                    if (Math.abs(latLng.longitude - latLng2.longitude) < 0.01d) {
                        IPoint iPoint2 = new IPoint();
                        this.f2610e.m17618e().mo17555a(latLng2.latitude, latLng2.longitude, iPoint2);
                        arrayList.add(iPoint2);
                        builder.include(latLng2);
                        IPoint iPoint3 = new IPoint();
                        this.f2610e.m17618e().mo17555a(latLng.latitude, latLng.longitude, iPoint3);
                        arrayList.add(iPoint3);
                        builder.include(latLng);
                    } else {
                        m18640a(latLng2, latLng, arrayList, builder);
                    }
                }
            }
        }
        this.f2612g = arrayList;
        this.f2586D = 0;
        if (this.f2612g.size() > 0) {
            this.f2621p = builder.build();
        }
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    /* renamed from: a */
    void m18635a(List<IPoint> list, List<IPoint> list2, double d) {
        if (list.size() != 3) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 10) {
                return;
            }
            float f = i2 / 10.0f;
            IPoint iPoint = new IPoint();
            double d2 = ((1.0d - f) * (1.0d - f) * list.get(0).f4730x) + (2.0f * f * (1.0d - f) * list.get(1).f4730x * d) + (list.get(2).f4730x * f * f);
            double d3 = ((1.0d - f) * (1.0d - f) * list.get(0).f4731y) + (2.0f * f * (1.0d - f) * list.get(1).f4731y * d) + (list.get(2).f4731y * f * f);
            iPoint.f4730x = (int) (d2 / ((((1.0d - f) * (1.0d - f)) + (((2.0f * f) * (1.0d - f)) * d)) + (f * f)));
            iPoint.f4731y = (int) (d3 / ((((1.0d - f) * (1.0d - f)) + (((2.0f * f) * (1.0d - f)) * d)) + (f * f)));
            list2.add(iPoint);
            i = (int) (i2 + 1.0f);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2612g == null || this.f2612g.size() == 0 || this.f2587E <= 0.0f || this.f2610e.m17618e() == null) {
            return;
        }
        if (this.f2628w) {
            mo18600b();
            this.f2628w = false;
        }
        if (this.f2596N != null && this.f2586D > 0) {
            if (this.f2631z) {
                m18628b(gl10);
            } else {
                if (this.f2619n == null) {
                    this.f2619n = C0945eh.m18327a(this.f2596N);
                }
                C0926du.m18461a(gl10, 3, this.f2585C, this.f2619n, this.f2587E, this.f2586D);
            }
        }
        this.f2630y = true;
    }

    /* renamed from: a */
    public void m18632a(boolean z) {
        this.f2631z = z;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0886cw
    /* renamed from: a */
    public boolean mo18641a(LatLng latLng) {
        float[] fArr = new float[this.f2596N.length];
        System.arraycopy(this.f2596N, 0, fArr, 0, this.f2596N.length);
        if (fArr.length / 3 < 2) {
            return false;
        }
        try {
            ArrayList<FPoint> m18616f = m18616f();
            if (m18616f != null) {
                if (m18616f.size() >= 1) {
                    double mapLenWithWin = this.f2610e.m17618e().mo17530c().getMapLenWithWin(((int) this.f2587E) / 4);
                    double mapLenWithWin2 = this.f2610e.m17618e().mo17530c().getMapLenWithWin((int) this.f2599Q);
                    FPoint m18630b = m18630b(latLng);
                    FPoint fPoint = null;
                    int i = 0;
                    while (i < m18616f.size() - 1) {
                        FPoint fPoint2 = i == 0 ? m18616f.get(i) : fPoint;
                        fPoint = m18616f.get(i + 1);
                        if ((mapLenWithWin2 + mapLenWithWin) - m18638a(m18630b, fPoint2, fPoint) >= 0.0d) {
                            m18616f.clear();
                            return true;
                        }
                        i++;
                    }
                    m18616f.clear();
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public void m18629b(List<BitmapDescriptor> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() <= 1) {
            setCustomTexture(list.get(0));
            return;
        }
        this.f2624s = false;
        this.f2583A = 5;
        this.f2615j = list;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    /* renamed from: b */
    public void m18626b(boolean z) {
        if (!z || this.f2617l == null || this.f2617l.size() <= 1) {
            return;
        }
        this.f2629x = z;
        this.f2583A = 4;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        synchronized (this.f2622q) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.f2613h.clear();
            this.f2630y = false;
            this.f2596N = new float[this.f2612g.size() * 3];
            this.f2606a = this.f2596N.length;
            int i = 0;
            for (IPoint iPoint : this.f2612g) {
                FPoint3 fPoint3 = new FPoint3();
                this.f2610e.m17618e().mo17534b(iPoint.f4731y, iPoint.f4730x, fPoint3);
                this.f2596N[i * 3] = fPoint3.f4728x;
                this.f2596N[(i * 3) + 1] = fPoint3.f4729y;
                this.f2596N[(i * 3) + 2] = 0.0f;
                if (this.f2616k != null && this.f2616k.size() > i) {
                    fPoint3.setColorIndex(this.f2616k.get(i).intValue());
                }
                this.f2613h.add(fPoint3);
                builder.include(fPoint3);
                i++;
            }
            this.f2602T = builder.build();
        }
        if (!this.f2631z) {
            this.f2619n = C0945eh.m18327a(this.f2596N);
        }
        this.f2586D = this.f2612g.size();
        m18619e();
        return true;
    }

    /* renamed from: c */
    public void m18625c(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f2616k = list;
        this.f2618m = m18615f(list);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2630y;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0886cw
    /* renamed from: d */
    public void mo18622d() {
        this.f2627v = false;
        this.f2584B = 0;
        if (this.f2598P != null) {
            Arrays.fill(this.f2598P, 0);
        }
    }

    /* renamed from: d */
    public void m18621d(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() <= 1) {
            setColor(list.get(0).intValue());
            return;
        }
        this.f2624s = false;
        this.f2617l = m18615f(list);
        this.f2583A = 3;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            remove();
            if (this.f2598P != null && this.f2598P.length > 0) {
                for (int i = 0; i < this.f2598P.length; i++) {
                    this.f2610e.m17628a(Integer.valueOf(this.f2598P[i]));
                    this.f2610e.m17618e().mo17517g(this.f2598P[i]);
                }
            }
            if (this.f2584B > 0) {
                this.f2610e.m17628a(Integer.valueOf(this.f2584B));
                this.f2610e.m17618e().mo17517g(this.f2584B);
            }
            if (this.f2596N != null) {
                this.f2596N = null;
            }
            if (this.f2619n != null) {
                this.f2619n.clear();
                this.f2619n = null;
            }
            if (this.f2615j != null && this.f2615j.size() > 0) {
                for (BitmapDescriptor bitmapDescriptor : this.f2615j) {
                    bitmapDescriptor.recycle();
                }
            }
            if (this.f2620o != null) {
                this.f2620o.recycle();
            }
            if (this.f2617l != null) {
                this.f2617l.clear();
                this.f2617l = null;
            }
            if (this.f2616k != null) {
                this.f2616k.clear();
                this.f2616k = null;
            }
            if (this.f2614i != null) {
                this.f2614i.clear();
                this.f2614i = null;
            }
            this.f2603U = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public int getColor() {
        return this.f2585C;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2611f == null) {
            this.f2611f = C1097j.m17627a("Polyline");
        }
        return this.f2611f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public LatLng getNearestLatLng(LatLng latLng) {
        float calculateLineDistance;
        int i;
        int i2 = 0;
        if (latLng == null) {
            return null;
        }
        if (this.f2614i == null || this.f2614i.size() == 0) {
            return null;
        }
        float f = 0.0f;
        int i3 = 0;
        while (i2 < this.f2614i.size()) {
            try {
                if (i2 == 0) {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.f2614i.get(i2));
                    i = i3;
                } else {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.f2614i.get(i2));
                    if (f > calculateLineDistance) {
                        i = i2;
                    } else {
                        calculateLineDistance = f;
                        i = i3;
                    }
                }
                i2++;
                i3 = i;
                f = calculateLineDistance;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return this.f2614i.get(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public PolylineOptions getOptions() {
        return this.f2603U;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public List<LatLng> getPoints() {
        return this.f2614i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public float getWidth() {
        return this.f2587E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2588F;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return this.f2600R;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isDottedLine() {
        return this.f2626u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isGeodesic() {
        return this.f2625t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f2623r;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2610e.m17619d(getId());
        setVisible(false);
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
        this.f2600R = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setColor(int i) {
        if (this.f2583A == 0 || this.f2583A == 2) {
            this.f2585C = i;
            this.f2590H = Color.alpha(i) / 255.0f;
            this.f2591I = Color.red(i) / 255.0f;
            this.f2592J = Color.green(i) / 255.0f;
            this.f2593K = Color.blue(i) / 255.0f;
            if (this.f2624s) {
                this.f2583A = 0;
            }
            this.f2610e.m17618e().setRunLowFrame(false);
        }
        this.f2603U.color(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.f2609d < 16) {
            return;
        }
        this.f2609d = nanoTime;
        if (bitmapDescriptor == null) {
            return;
        }
        synchronized (this) {
            if (this.f2620o != null && bitmapDescriptor != null && this.f2620o.equals(bitmapDescriptor)) {
                this.f2620o.recycle();
            }
            this.f2624s = false;
            this.f2627v = false;
            this.f2583A = 1;
            this.f2620o = bitmapDescriptor;
            this.f2610e.m17618e().setRunLowFrame(false);
            this.f2603U.setCustomTexture(bitmapDescriptor);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setDottedLine(boolean z) {
        if (this.f2583A == 2 || this.f2583A == 0) {
            this.f2626u = z;
            if (z && this.f2624s) {
                this.f2583A = 2;
            }
            this.f2610e.m17618e().setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setGeodesic(boolean z) {
        this.f2625t = z;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return;
        }
        this.f2603U = polylineOptions;
        try {
            setColor(polylineOptions.getColor());
            setGeodesic(polylineOptions.isGeodesic());
            setDottedLine(polylineOptions.isDottedLine());
            setAboveMaskLayer(polylineOptions.isAboveMaskLayer());
            setVisible(polylineOptions.isVisible());
            setWidth(polylineOptions.getWidth());
            setZIndex(polylineOptions.getZIndex());
            m18632a(polylineOptions.isUseTexture());
            setTransparency(polylineOptions.getTransparency());
            if (polylineOptions.getColorValues() != null) {
                m18621d(polylineOptions.getColorValues());
                m18626b(polylineOptions.isUseGradient());
            }
            if (polylineOptions.getCustomTexture() != null) {
                setCustomTexture(polylineOptions.getCustomTexture());
                mo18622d();
            }
            if (polylineOptions.getCustomTextureList() != null) {
                m18629b(polylineOptions.getCustomTextureList());
                m18625c(polylineOptions.getCustomTextureIndex());
                mo18622d();
            }
            setPoints(polylineOptions.getPoints());
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "PolylineDelegateImp", "setOptions");
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setPoints(List<LatLng> list) {
        try {
            this.f2614i = list;
            synchronized (this.f2622q) {
                m18636a(list);
            }
            this.f2628w = true;
            this.f2610e.m17618e().setRunLowFrame(false);
            this.f2603U.setPoints(list);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PolylineDelegateImp", "setPoints");
            this.f2612g.clear();
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setTransparency(float f) {
        this.f2594L = f;
        this.f2610e.m17618e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2623r = z;
        this.f2610e.m17618e().setRunLowFrame(false);
        this.f2603U.visible(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setWidth(float f) {
        this.f2587E = f;
        this.f2610e.m17618e().setRunLowFrame(false);
        this.f2603U.width(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2588F = f;
        this.f2610e.m17622c();
        this.f2610e.m17618e().setRunLowFrame(false);
        this.f2603U.zIndex(f);
    }
}
