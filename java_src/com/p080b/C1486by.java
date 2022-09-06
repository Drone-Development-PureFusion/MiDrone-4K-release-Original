package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.tencent.open.GameAppOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* renamed from: com.b.by */
/* loaded from: classes.dex */
public class C1486by {

    /* renamed from: k */
    private static C1486by f5260k;

    /* renamed from: l */
    private boolean f5274l;

    /* renamed from: p */
    private Context f5278p;

    /* renamed from: q */
    private LocationManager f5279q;

    /* renamed from: r */
    private C1499ci f5280r;

    /* renamed from: s */
    private C1513cw f5281s;

    /* renamed from: t */
    private C1521dd f5282t;

    /* renamed from: u */
    private C1496cf f5283u;

    /* renamed from: v */
    private C1520dc f5284v;

    /* renamed from: w */
    private C1512cv f5285w;

    /* renamed from: a */
    protected static boolean f5251a = false;

    /* renamed from: b */
    protected static boolean f5252b = true;

    /* renamed from: d */
    private static int f5253d = 10;

    /* renamed from: e */
    private static int f5254e = 2;

    /* renamed from: f */
    private static int f5255f = 10;

    /* renamed from: g */
    private static int f5256g = 10;

    /* renamed from: h */
    private static int f5257h = 50;

    /* renamed from: i */
    private static int f5258i = 200;

    /* renamed from: j */
    private static Object f5259j = new Object();

    /* renamed from: M */
    private static float f5240M = 1.1f;

    /* renamed from: N */
    private static float f5241N = 2.2f;

    /* renamed from: O */
    private static float f5242O = 2.3f;

    /* renamed from: P */
    private static float f5243P = 3.8f;

    /* renamed from: Q */
    private static int f5244Q = 3;

    /* renamed from: R */
    private static int f5245R = 10;

    /* renamed from: S */
    private static int f5246S = 2;

    /* renamed from: T */
    private static int f5247T = 7;

    /* renamed from: U */
    private static int f5248U = 20;

    /* renamed from: V */
    private static int f5249V = 70;

    /* renamed from: W */
    private static int f5250W = 120;

    /* renamed from: m */
    private int f5275m = -1;

    /* renamed from: n */
    private int f5276n = 0;

    /* renamed from: o */
    private int f5277o = 0;

    /* renamed from: y */
    private Thread f5287y = null;

    /* renamed from: z */
    private Looper f5288z = null;

    /* renamed from: A */
    private C1510ct f5261A = null;

    /* renamed from: B */
    private volatile Handler f5262B = null;

    /* renamed from: c */
    Object f5273c = new Object();

    /* renamed from: C */
    private C1511cu f5263C = new C1511cu(this);

    /* renamed from: D */
    private LocationListener f5264D = new C1505co(this);

    /* renamed from: E */
    private BroadcastReceiver f5265E = new C1506cp(this);

    /* renamed from: F */
    private BroadcastReceiver f5266F = new C1507cq(this);

    /* renamed from: G */
    private GpsStatus f5267G = null;

    /* renamed from: H */
    private int f5268H = 0;

    /* renamed from: I */
    private int f5269I = 0;

    /* renamed from: J */
    private HashMap f5270J = null;

    /* renamed from: K */
    private int f5271K = 0;

    /* renamed from: L */
    private int f5272L = 0;

    /* renamed from: x */
    private C1487bz f5286x = new C1487bz();

    private C1486by(Context context) {
        this.f5274l = false;
        this.f5278p = context;
        this.f5280r = C1499ci.m15835a(context);
        this.f5281s = new C1513cw(this.f5280r);
        this.f5283u = new C1496cf(context);
        this.f5282t = new C1521dd(this.f5283u);
        this.f5284v = new C1520dc(this.f5283u);
        this.f5279q = (LocationManager) this.f5278p.getSystemService("location");
        this.f5285w = C1512cv.m15752a(this.f5278p);
        this.f5285w.m15751a(this.f5263C);
        m15882o();
        List<String> allProviders = this.f5279q.getAllProviders();
        this.f5274l = allProviders != null && allProviders.contains(GeocodeSearch.GPS) && allProviders.contains("passive");
        if (context != null) {
            C1499ci.f5338a = context.getPackageName();
        } else {
            Log.d(C1499ci.f5338a, "Error: No SD Card!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m15921a(C1486by c1486by, C1523df c1523df, int i) {
        if (c1486by.f5271K >= f5245R) {
            return 1;
        }
        if (c1486by.f5271K <= f5244Q) {
            return 4;
        }
        double m15706c = c1523df.m15706c();
        if (m15706c <= f5240M) {
            return 1;
        }
        if (m15706c >= f5241N) {
            return 4;
        }
        double m15707b = c1523df.m15707b();
        if (m15707b <= f5242O) {
            return 1;
        }
        if (m15707b >= f5243P) {
            return 4;
        }
        if (i >= f5247T) {
            return 1;
        }
        if (i <= f5246S) {
            return 4;
        }
        if (c1486by.f5270J == null) {
            return 3;
        }
        return c1486by.m15916a(c1486by.f5270J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m15916a(HashMap hashMap) {
        double[] m15915a;
        if (this.f5268H > 4) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            Iterator it2 = hashMap.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (!it2.hasNext()) {
                    break;
                }
                List list = (List) ((Map.Entry) it2.next()).getValue();
                if (list == null || (m15915a = m15915a(list)) == null) {
                    i = i2;
                } else {
                    arrayList.add(m15915a);
                    i = i2 + 1;
                    arrayList2.add(Integer.valueOf(i2));
                }
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    double[] dArr2 = (double[]) arrayList.get(i3);
                    int intValue = ((Integer) arrayList2.get(i3)).intValue();
                    dArr2[0] = dArr2[0] * intValue;
                    dArr2[1] = dArr2[1] * intValue;
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr[1] + dArr2[1];
                }
                dArr[0] = dArr[0] / size;
                dArr[1] = dArr[1] / size;
                double d = dArr[0];
                double d2 = dArr[1];
                double[] dArr3 = {Math.sqrt((d * d) + (d2 * d2)), d2 == 0.0d ? d > 0.0d ? 90.0d : d < 0.0d ? 270.0d : 0.0d : Math.toDegrees(Math.atan(d / d2))};
                String.format(Locale.CHINA, "%d,%d,%d,%d", Long.valueOf(Math.round(dArr[0] * 100.0d)), Long.valueOf(Math.round(dArr[1] * 100.0d)), Long.valueOf(Math.round(dArr3[0] * 100.0d)), Long.valueOf(Math.round(dArr3[1] * 100.0d)));
                if (dArr3[0] <= f5249V) {
                    return 1;
                }
                if (dArr3[0] >= f5250W) {
                    return 4;
                }
            }
        }
        return 3;
    }

    /* renamed from: a */
    public static C1486by m15929a(Context context) {
        if (f5260k == null) {
            synchronized (f5259j) {
                if (f5260k == null) {
                    f5260k = new C1486by(context);
                }
            }
        }
        return f5260k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ String m15920a(C1486by c1486by, String str) {
        return str;
    }

    /* renamed from: a */
    public static String m15917a(String str) {
        if (str.equals(GameAppOperation.QQFAV_DATALINE_VERSION)) {
            return "V1.0.0r";
        }
        if (!str.equals("date")) {
            return null;
        }
        return "COL.15.0929r";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m15925a(C1486by c1486by, Location location, int i, long j) {
        C1485bx c1485bx;
        C1485bx c1485bx2;
        System.currentTimeMillis();
        boolean m15736a = c1486by.f5281s.m15736a(location);
        if (m15736a) {
            c1486by.f5281s.f5404b.f5427b = new Location(location);
        }
        boolean m15734b = c1486by.f5281s.m15734b(location);
        if (m15734b) {
            c1486by.f5281s.f5403a.f5440b = new Location(location);
        }
        int i2 = 0;
        if (m15736a) {
            i2 = 1;
            if (m15734b) {
                i2 = 3;
            }
        } else if (m15734b) {
            i2 = 2;
        }
        try {
            C1487bz c1487bz = c1486by.f5286x;
            c1485bx = C1487bz.m15881a(location, c1486by.f5280r, i2, (byte) c1486by.f5272L, j, false);
        } catch (Exception e) {
            c1485bx = null;
        }
        if (c1485bx != null && c1486by.f5280r != null) {
            List m15772m = c1486by.f5280r.m15772m();
            Long l = 0L;
            if (m15772m != null && m15772m.size() > 0) {
                l = (Long) m15772m.get(0);
            }
            c1486by.f5282t.m15710a(l.longValue(), c1485bx.m15933a());
        }
        if (c1486by.f5278p == null || c1486by.f5286x == null) {
            return;
        }
        SharedPreferences sharedPreferences = c1486by.f5278p.getSharedPreferences("app_pref", 0);
        if (sharedPreferences.getString("get_sensor", "").equals("true")) {
            return;
        }
        try {
            C1487bz c1487bz2 = c1486by.f5286x;
            c1485bx2 = C1487bz.m15881a(null, c1486by.f5280r, i2, (byte) c1486by.f5272L, j, true);
        } catch (Exception e2) {
            c1485bx2 = null;
        }
        if (c1485bx2 == null || c1486by.f5280r == null) {
            return;
        }
        List m15772m2 = c1486by.f5280r.m15772m();
        Long l2 = 0L;
        if (m15772m2 != null && m15772m2.size() > 0) {
            l2 = (Long) m15772m2.get(0);
        }
        c1486by.f5282t.m15710a(l2.longValue(), c1485bx2.m15933a());
        sharedPreferences.edit().putString("get_sensor", "true").commit();
    }

    /* renamed from: a */
    private double[] m15915a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            GpsSatellite gpsSatellite = (GpsSatellite) it2.next();
            if (gpsSatellite != null) {
                double elevation = 90.0f - gpsSatellite.getElevation();
                double azimuth = gpsSatellite.getAzimuth();
                double[] dArr2 = {Math.sin(Math.toRadians(azimuth)) * elevation, elevation * Math.cos(Math.toRadians(azimuth))};
                dArr[0] = dArr[0] + dArr2[0];
                dArr[1] = dArr[1] + dArr2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / size;
        dArr[1] = dArr[1] / size;
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ int m15895h(C1486by c1486by) {
        int i = c1486by.f5269I;
        c1486by.f5269I = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m15882o() {
        this.f5276n = this.f5285w.m15748b() * 1000;
        this.f5277o = this.f5285w.m15744c();
        C1513cw c1513cw = this.f5281s;
        int i = this.f5276n;
        int i2 = this.f5277o;
        C1513cw.m15738a();
    }

    /* renamed from: a */
    public void m15931a() {
        C1499ci.f5339b = true;
        if (!this.f5274l || this.f5280r == null || f5251a) {
            return;
        }
        f5251a = true;
        IntentFilter intentFilter = new IntentFilter("android.location.GPS_ENABLED_CHANGE");
        intentFilter.addAction("android.location.GPS_FIX_CHANGE");
        f5252b = true;
        this.f5278p.registerReceiver(this.f5266F, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.setPriority(1000);
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter2.addDataScheme("file");
        this.f5278p.registerReceiver(this.f5265E, intentFilter2);
        this.f5279q.removeGpsStatusListener(this.f5261A);
        this.f5279q.removeNmeaListener(this.f5261A);
        this.f5261A = null;
        this.f5279q.removeUpdates(this.f5264D);
        if (this.f5288z != null) {
            this.f5288z.quit();
            this.f5288z = null;
        }
        if (this.f5287y != null) {
            this.f5287y.interrupt();
            this.f5287y = null;
        }
        this.f5287y = new C1508cr(this, "");
        this.f5287y.start();
        this.f5280r.m15839a();
    }

    /* renamed from: a */
    public void m15930a(int i) {
        if (i == 256 || i == 8736 || i == 768) {
            this.f5283u.m15862a(i);
            return;
        }
        throw new RuntimeException("invalid Size! must be COLLECTOR_SMALL_SIZE or COLLECTOR_BIG_SIZE or COLLECTOR_MEDIUM_SIZE");
    }

    /* renamed from: a */
    public void m15918a(C1495ce c1495ce, String str) {
        NetworkInfo activeNetworkInfo;
        if (C1499ci.f5340c) {
            return;
        }
        boolean m15750a = this.f5285w.m15750a(str);
        if (c1495ce == null) {
            return;
        }
        byte[] m15867a = c1495ce.m15867a();
        if (m15750a && m15867a != null && (activeNetworkInfo = ((ConnectivityManager) this.f5278p.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                this.f5285w.m15754a(m15867a.length + this.f5285w.m15741e());
            } else {
                this.f5285w.m15747b(m15867a.length + this.f5285w.m15740f());
            }
        }
        c1495ce.m15866a(m15750a);
        this.f5284v.m15714a(c1495ce);
    }

    /* renamed from: b */
    public void m15914b() {
        C1499ci.f5339b = false;
        this.f5262B = null;
        C1499ci.f5340c = false;
        if (!this.f5274l || this.f5280r == null || !f5251a) {
            return;
        }
        if (this.f5266F != null) {
            try {
                this.f5278p.unregisterReceiver(this.f5266F);
                this.f5278p.unregisterReceiver(this.f5265E);
            } catch (Exception e) {
            }
        }
        if (this.f5280r != null) {
            this.f5280r.m15763v();
        }
        synchronized (this.f5273c) {
            f5251a = false;
            this.f5279q.removeGpsStatusListener(this.f5261A);
            this.f5279q.removeNmeaListener(this.f5261A);
            this.f5261A = null;
            this.f5279q.removeUpdates(this.f5264D);
            if (this.f5288z != null) {
                this.f5288z.quit();
                this.f5288z = null;
            }
            if (this.f5287y != null) {
                this.f5287y.interrupt();
                this.f5287y = null;
            }
        }
        this.f5280r.m15812b();
    }

    /* renamed from: b */
    public void m15913b(int i) {
        if (this.f5280r == null) {
            return;
        }
        this.f5280r.m15837a(i);
    }

    /* renamed from: c */
    public void m15909c() {
        if (!this.f5274l) {
            return;
        }
        m15914b();
    }

    /* renamed from: d */
    public boolean m15906d() {
        return f5251a;
    }

    /* renamed from: e */
    public C1495ce m15903e() {
        if (this.f5284v == null) {
            return null;
        }
        m15900f();
        if (this.f5285w.m15755a() && !C1499ci.f5340c) {
            return this.f5284v.m15717a(this.f5285w.m15742d());
        }
        return null;
    }

    /* renamed from: f */
    public boolean m15900f() {
        List m15772m;
        if (this.f5280r == null || (m15772m = this.f5280r.m15772m()) == null || m15772m.size() <= 0) {
            return false;
        }
        return this.f5283u.m15850b(((Long) m15772m.get(0)).longValue());
    }

    /* renamed from: g */
    public int m15898g() {
        if (this.f5284v != null) {
            return this.f5284v.m15718a();
        }
        return 0;
    }
}
