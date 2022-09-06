package com.p080b;

import android.content.Context;
import android.os.Looper;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.b.bb */
/* loaded from: classes.dex */
public class C1452bb {

    /* renamed from: b */
    C1454a f5038b;

    /* renamed from: c */
    private Context f5039c;

    /* renamed from: d */
    private int f5040d;

    /* renamed from: g */
    private TelephonyManager f5043g;

    /* renamed from: h */
    private Object f5044h;

    /* renamed from: j */
    private JSONObject f5046j;

    /* renamed from: k */
    private PhoneStateListener f5047k;

    /* renamed from: l */
    private CellLocation f5048l;

    /* renamed from: e */
    private ArrayList<C1451ba> f5041e = new ArrayList<>();

    /* renamed from: f */
    private int f5042f = -113;

    /* renamed from: i */
    private long f5045i = 0;

    /* renamed from: a */
    Looper f5037a = null;

    /* renamed from: m */
    private boolean f5049m = false;

    /* renamed from: n */
    private Object f5050n = new Object();

    /* renamed from: com.b.bb$a */
    /* loaded from: classes.dex */
    class C1454a extends Thread {
        C1454a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                synchronized (C1452bb.this.f5050n) {
                    if (!C1452bb.this.f5049m) {
                        Looper.prepare();
                        C1452bb.this.f5037a = Looper.myLooper();
                        C1452bb.this.m16148q();
                        super.run();
                    }
                }
                if (C1452bb.this.f5037a != null) {
                    Looper.loop();
                }
                if (C1452bb.this.f5043g != null && C1452bb.this.f5047k != null) {
                    try {
                        C1452bb.this.f5043g.listen(C1452bb.this.f5047k, 0);
                        C1452bb.this.f5047k = null;
                    } catch (Throwable th) {
                    }
                }
                synchronized (C1452bb.this.f5050n) {
                    if (C1452bb.this.f5037a != null) {
                        C1452bb.this.f5037a.quit();
                        C1452bb.this.f5037a = null;
                    }
                }
            } catch (Throwable th2) {
                try {
                    C1514cx.m15728a(th2, "CgiManager", "ListenerThread");
                    if (C1452bb.this.f5043g != null && C1452bb.this.f5047k != null) {
                        try {
                            C1452bb.this.f5043g.listen(C1452bb.this.f5047k, 0);
                            C1452bb.this.f5047k = null;
                        } catch (Throwable th3) {
                        }
                    }
                    synchronized (C1452bb.this.f5050n) {
                        if (C1452bb.this.f5037a != null) {
                            C1452bb.this.f5037a.quit();
                            C1452bb.this.f5037a = null;
                        }
                    }
                } catch (Throwable th4) {
                    if (C1452bb.this.f5043g != null && C1452bb.this.f5047k != null) {
                        try {
                            C1452bb.this.f5043g.listen(C1452bb.this.f5047k, 0);
                            C1452bb.this.f5047k = null;
                        } catch (Throwable th5) {
                        }
                    }
                    synchronized (C1452bb.this.f5050n) {
                        if (C1452bb.this.f5037a != null) {
                            C1452bb.this.f5037a.quit();
                            C1452bb.this.f5037a = null;
                        }
                        throw th4;
                    }
                }
            }
        }
    }

    public C1452bb(Context context, JSONObject jSONObject) {
        this.f5040d = 9;
        this.f5038b = null;
        if (context == null) {
        }
        m16149p();
        this.f5043g = (TelephonyManager) C1477bs.m16012a(context, "phone");
        this.f5046j = jSONObject;
        this.f5039c = context;
        try {
            this.f5040d = C1477bs.m16009a(this.f5043g.getCellLocation(), context);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "CgiManager", "CgiManager");
            this.f5040d = 9;
        }
        if (this.f5038b == null) {
            this.f5038b = new C1454a();
            this.f5038b.setName("listener");
            this.f5038b.start();
        }
    }

    /* renamed from: a */
    private CellLocation m16177a(List<?> list) {
        char c;
        CdmaCellLocation cdmaCellLocation;
        GsmCellLocation gsmCellLocation;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        GsmCellLocation gsmCellLocation2 = null;
        int i = 0;
        char c2 = 0;
        CdmaCellLocation cdmaCellLocation2 = null;
        while (true) {
            if (i >= list.size()) {
                c = c2;
                cdmaCellLocation = cdmaCellLocation2;
                gsmCellLocation = gsmCellLocation2;
                break;
            }
            Object obj = list.get(i);
            if (obj != null) {
                try {
                    Class<?> loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class<?> loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class<?> loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class<?> loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    c = loadClass.isInstance(obj) ? (char) 1 : loadClass2.isInstance(obj) ? (char) 2 : loadClass3.isInstance(obj) ? (char) 3 : loadClass4.isInstance(obj) ? (char) 4 : (char) 0;
                    if (c > 0) {
                        Object obj2 = null;
                        if (c == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Throwable th) {
                                th = th;
                                c2 = c;
                                C1514cx.m15728a(th, "CgiManager", "getCgi");
                                i++;
                            }
                        } else if (c == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (c == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (c == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        Object m16030a = C1475bq.m16030a(obj2, "getCellIdentity", new Object[0]);
                        if (m16030a == null) {
                            c2 = c;
                        } else if (c == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(C1475bq.m16027b(m16030a, "getBasestationId", new Object[0]), C1475bq.m16027b(m16030a, "getLatitude", new Object[0]), C1475bq.m16027b(m16030a, "getLongitude", new Object[0]), C1475bq.m16027b(m16030a, "getSystemId", new Object[0]), C1475bq.m16027b(m16030a, "getNetworkId", new Object[0]));
                                gsmCellLocation = gsmCellLocation2;
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                cdmaCellLocation2 = cdmaCellLocation;
                                c2 = c;
                                C1514cx.m15728a(th, "CgiManager", "getCgi");
                                i++;
                            }
                        } else if (c == 3) {
                            int m16027b = C1475bq.m16027b(m16030a, "getTac", new Object[0]);
                            int m16027b2 = C1475bq.m16027b(m16030a, "getCi", new Object[0]);
                            GsmCellLocation gsmCellLocation3 = new GsmCellLocation();
                            try {
                                gsmCellLocation3.setLacAndCid(m16027b, m16027b2);
                                CdmaCellLocation cdmaCellLocation3 = cdmaCellLocation2;
                                gsmCellLocation = gsmCellLocation3;
                                cdmaCellLocation = cdmaCellLocation3;
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                                gsmCellLocation2 = gsmCellLocation3;
                                c2 = c;
                                C1514cx.m15728a(th, "CgiManager", "getCgi");
                                i++;
                            }
                        } else {
                            int m16027b3 = C1475bq.m16027b(m16030a, "getLac", new Object[0]);
                            int m16027b4 = C1475bq.m16027b(m16030a, "getCid", new Object[0]);
                            GsmCellLocation gsmCellLocation4 = new GsmCellLocation();
                            try {
                                gsmCellLocation4.setLacAndCid(m16027b3, m16027b4);
                                CdmaCellLocation cdmaCellLocation4 = cdmaCellLocation2;
                                gsmCellLocation = gsmCellLocation4;
                                cdmaCellLocation = cdmaCellLocation4;
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                gsmCellLocation2 = gsmCellLocation4;
                                c2 = c;
                                C1514cx.m15728a(th, "CgiManager", "getCgi");
                                i++;
                            }
                        }
                    } else {
                        c2 = c;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            i++;
        }
        return c != 4 ? gsmCellLocation : cdmaCellLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16184a(int i) {
        if (i == -113) {
            this.f5042f = -113;
            return;
        }
        this.f5042f = i;
        switch (this.f5040d) {
            case 1:
            case 2:
                if (this.f5041e.isEmpty()) {
                    return;
                }
                try {
                    this.f5041e.get(0).f5035j = this.f5042f;
                    return;
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "hdlCgiSigStrenChange");
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: b */
    private C1451ba m16172b(NeighboringCellInfo neighboringCellInfo) {
        if (C1477bs.m15990c() < 5) {
            return null;
        }
        try {
            C1451ba c1451ba = new C1451ba(1);
            String[] m16008a = C1477bs.m16008a(this.f5043g);
            c1451ba.f5026a = m16008a[0];
            c1451ba.f5027b = m16008a[1];
            c1451ba.f5028c = C1475bq.m16027b(neighboringCellInfo, "getLac", new Object[0]);
            c1451ba.f5029d = neighboringCellInfo.getCid();
            c1451ba.f5035j = C1477bs.m16018a(neighboringCellInfo.getRssi());
            return c1451ba;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    /* renamed from: b */
    private void m16173b(CellLocation cellLocation) {
        C1451ba m16172b;
        if (cellLocation == null || this.f5043g == null) {
            return;
        }
        this.f5041e.clear();
        if (!m16183a(cellLocation)) {
            return;
        }
        this.f5040d = 1;
        this.f5041e.add(m16166d(cellLocation));
        List<NeighboringCellInfo> neighboringCellInfo = this.f5043g.getNeighboringCellInfo();
        if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
            return;
        }
        for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
            if (m16182a(neighboringCellInfo2) && (m16172b = m16172b(neighboringCellInfo2)) != null && !this.f5041e.contains(m16172b)) {
                this.f5041e.add(m16172b);
            }
        }
    }

    /* renamed from: c */
    private void m16169c(CellLocation cellLocation) {
        boolean z;
        boolean z2 = false;
        if (cellLocation == null) {
            return;
        }
        this.f5041e.clear();
        if (C1477bs.m15990c() < 5) {
            return;
        }
        try {
            if (this.f5044h != null) {
                Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                if (gsmCellLocation == null || !m16183a(gsmCellLocation)) {
                    z = false;
                } else {
                    m16173b(gsmCellLocation);
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (!m16183a(cellLocation)) {
                return;
            }
            this.f5040d = 2;
            String[] m16008a = C1477bs.m16008a(this.f5043g);
            C1451ba c1451ba = new C1451ba(2);
            c1451ba.f5026a = m16008a[0];
            c1451ba.f5027b = m16008a[1];
            c1451ba.f5032g = C1475bq.m16027b(cellLocation, "getSystemId", new Object[0]);
            c1451ba.f5033h = C1475bq.m16027b(cellLocation, "getNetworkId", new Object[0]);
            c1451ba.f5034i = C1475bq.m16027b(cellLocation, "getBaseStationId", new Object[0]);
            c1451ba.f5035j = this.f5042f;
            c1451ba.f5030e = C1475bq.m16027b(cellLocation, "getBaseStationLatitude", new Object[0]);
            c1451ba.f5031f = C1475bq.m16027b(cellLocation, "getBaseStationLongitude", new Object[0]);
            if (c1451ba.f5030e < 0 || c1451ba.f5031f < 0) {
                c1451ba.f5030e = 0;
                c1451ba.f5031f = 0;
            } else if (c1451ba.f5030e == Integer.MAX_VALUE) {
                c1451ba.f5030e = 0;
                c1451ba.f5031f = 0;
            } else if (c1451ba.f5031f == Integer.MAX_VALUE) {
                c1451ba.f5030e = 0;
                c1451ba.f5031f = 0;
            } else if (c1451ba.f5030e != c1451ba.f5031f || c1451ba.f5030e <= 0) {
                z2 = true;
            } else {
                c1451ba.f5030e = 0;
                c1451ba.f5031f = 0;
            }
            if (!z2) {
            }
            if (this.f5041e.contains(c1451ba)) {
                return;
            }
            this.f5041e.add(c1451ba);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "CgiManager", "hdlCdmaLocChange");
        }
    }

    /* renamed from: d */
    private C1451ba m16166d(CellLocation cellLocation) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        C1451ba c1451ba = new C1451ba(1);
        String[] m16008a = C1477bs.m16008a(this.f5043g);
        c1451ba.f5026a = m16008a[0];
        c1451ba.f5027b = m16008a[1];
        c1451ba.f5028c = gsmCellLocation.getLac();
        c1451ba.f5029d = gsmCellLocation.getCid();
        c1451ba.f5035j = this.f5042f;
        return c1451ba;
    }

    /* renamed from: k */
    public static int m16154k() {
        int i = 0;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Throwable th) {
        }
        if (i == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                return 2;
            } catch (Throwable th2) {
                return i;
            }
        }
        return i;
    }

    /* renamed from: l */
    private synchronized void m16153l() {
        if (!C1477bs.m16013a(this.f5039c) && this.f5043g != null) {
            CellLocation m16152m = m16152m();
            if (!m16183a(m16152m)) {
                m16152m = m16151n();
            }
            if (m16183a(m16152m)) {
                this.f5048l = m16152m;
            }
        }
        if (m16183a(this.f5048l)) {
            switch (C1477bs.m16009a(this.f5048l, this.f5039c)) {
                case 1:
                    m16173b(this.f5048l);
                    break;
                case 2:
                    m16169c(this.f5048l);
                    break;
            }
        }
    }

    /* renamed from: m */
    private CellLocation m16152m() {
        CellLocation cellLocation;
        TelephonyManager telephonyManager = this.f5043g;
        if (telephonyManager == null) {
            return null;
        }
        try {
            cellLocation = telephonyManager.getCellLocation();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "CgiManager", "getSim1Cgi4");
            cellLocation = null;
        }
        if (m16183a(cellLocation)) {
            return cellLocation;
        }
        try {
            cellLocation = m16177a((List) C1475bq.m16030a(telephonyManager, "getAllCellInfo", new Object[0]));
        } catch (NoSuchMethodException e) {
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "CgiManager", "getSim1Cgi2");
        }
        if (m16183a(cellLocation)) {
            return cellLocation;
        }
        try {
            Object m16030a = C1475bq.m16030a(telephonyManager, "getCellLocationExt", 1);
            cellLocation = m16030a != null ? (CellLocation) m16030a : cellLocation;
        } catch (NoSuchMethodException e2) {
        } catch (Throwable th3) {
            C1514cx.m15728a(th3, "CgiManager", "getSim1Cgi1");
        }
        if (m16183a(cellLocation)) {
            return cellLocation;
        }
        try {
            Object m16030a2 = C1475bq.m16030a(telephonyManager, "getCellLocationGemini", 1);
            cellLocation = m16030a2 != null ? (CellLocation) m16030a2 : cellLocation;
        } catch (NoSuchMethodException e3) {
        } catch (Throwable th4) {
            C1514cx.m15728a(th4, "CgiManager", "getSim1Cgi");
        }
        if (m16183a(cellLocation)) {
        }
        return cellLocation;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CellLocation m16151n() {
        CellLocation cellLocation;
        Object obj;
        Object obj2;
        List<?> list;
        Object obj3 = this.f5044h;
        if (obj3 == null) {
            return null;
        }
        try {
            Class<?> m16150o = m16150o();
            if (m16150o.isInstance(obj3)) {
                Object cast = m16150o.cast(obj3);
                try {
                    obj2 = C1475bq.m16030a(cast, "getCellLocation", new Object[0]);
                } catch (NoSuchMethodException e) {
                    obj2 = null;
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "getSim2Cgi15");
                    obj2 = null;
                }
                if (obj2 == null) {
                    try {
                        obj2 = C1475bq.m16030a(cast, "getCellLocation", 1);
                    } catch (NoSuchMethodException e2) {
                    } catch (Throwable th2) {
                        C1514cx.m15728a(th2, "CgiManager", "getSim2Cgi14");
                    }
                }
                if (obj2 == null) {
                    try {
                        obj = C1475bq.m16030a(cast, "getCellLocationGemini", 1);
                    } catch (NoSuchMethodException e3) {
                        obj = obj2;
                    } catch (Throwable th3) {
                        C1514cx.m15728a(th3, "CgiManager", "getSim2Cgi13");
                    }
                    if (obj == null) {
                        try {
                            list = (List) C1475bq.m16030a(cast, "getAllCellInfo", new Object[0]);
                        } catch (NoSuchMethodException e4) {
                            C1514cx.m15728a(e4, "CgiManager", "getSim2Cgi12");
                            list = null;
                        } catch (Throwable th4) {
                            C1514cx.m15728a(th4, "CgiManager", "getSim2Cgi1");
                            list = null;
                        }
                        obj = m16177a(list);
                        if (obj != null) {
                        }
                    }
                }
                obj = obj2;
                if (obj == null) {
                }
            } else {
                obj = null;
            }
        } catch (Throwable th5) {
            C1514cx.m15728a(th5, "CgiManager", "getSim2Cgi");
        }
        if (obj != null) {
            cellLocation = obj;
            return cellLocation;
        }
        cellLocation = null;
        return cellLocation;
    }

    /* renamed from: o */
    private Class<?> m16150o() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (m16154k()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m16149p() {
        boolean z = true;
        JSONObject jSONObject = this.f5046j;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("cellupdate")) {
                    if (jSONObject.getString("cellupdate").equals("0")) {
                        z = false;
                    }
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "CgiManager", "updateCgi1");
            }
        }
        if (z) {
            try {
                CellLocation.requestLocationUpdate();
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, "CgiManager", "updateCgi");
            }
            this.f5045i = C1477bs.m15997b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m16148q() {
        this.f5047k = new PhoneStateListener() { // from class: com.b.bb.1
            @Override // android.telephony.PhoneStateListener
            public void onCellLocationChanged(CellLocation cellLocation) {
                try {
                    if (!C1452bb.this.m16183a(cellLocation)) {
                        return;
                    }
                    C1452bb.this.f5048l = cellLocation;
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "initPhoneStateListener7");
                }
            }

            @Override // android.telephony.PhoneStateListener
            public void onServiceStateChanged(ServiceState serviceState) {
                try {
                    switch (serviceState.getState()) {
                        case 0:
                            C1452bb.this.m16149p();
                            break;
                        case 1:
                            C1452bb.this.m16147r();
                            break;
                    }
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "initPhoneStateListener4");
                }
            }

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthChanged(int i) {
                int i2 = -113;
                try {
                    switch (C1452bb.this.f5040d) {
                        case 1:
                            i2 = C1477bs.m16018a(i);
                            break;
                        case 2:
                            i2 = C1477bs.m16018a(i);
                            break;
                    }
                    C1452bb.this.m16184a(i2);
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "initPhoneStateListener6");
                }
            }

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength == null) {
                    return;
                }
                int i = -113;
                try {
                    switch (C1452bb.this.f5040d) {
                        case 1:
                            i = C1477bs.m16018a(signalStrength.getGsmSignalStrength());
                            break;
                        case 2:
                            i = signalStrength.getCdmaDbm();
                            break;
                    }
                    C1452bb.this.m16184a(i);
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "CgiManager", "initPhoneStateListener5");
                }
            }
        };
        int i = 0;
        if (C1477bs.m15990c() < 7) {
            try {
                i = C1475bq.m16026b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTH");
            } catch (Throwable th) {
                C1514cx.m15728a(th, "CgiManager", "initPhoneStateListener3");
            }
        } else {
            try {
                i = C1475bq.m16026b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, "CgiManager", "initPhoneStateListener2");
            }
        }
        if (i == 0) {
            this.f5043g.listen(this.f5047k, 16);
        } else {
            try {
                this.f5043g.listen(this.f5047k, i | 16);
            } catch (Throwable th3) {
                C1514cx.m15728a(th3, "CgiManager", "initPhoneStateListener1");
            }
        }
        try {
            switch (m16154k()) {
                case 0:
                    this.f5044h = C1477bs.m16012a(this.f5039c, "phone2");
                    return;
                case 1:
                    this.f5044h = C1477bs.m16012a(this.f5039c, "phone_msim");
                    return;
                case 2:
                    this.f5044h = C1477bs.m16012a(this.f5039c, "phone2");
                    return;
                default:
                    return;
            }
        } catch (Throwable th4) {
            C1514cx.m15728a(th4, "CgiManager", "initPhoneStateListener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m16147r() {
        this.f5048l = null;
        this.f5040d = 9;
        this.f5041e.clear();
    }

    /* renamed from: a */
    public ArrayList<C1451ba> m16185a() {
        return this.f5041e;
    }

    /* renamed from: a */
    public void m16176a(JSONObject jSONObject) {
        this.f5046j = jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r6.getCid() < 268435455) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (com.p080b.C1475bq.m16027b(r6, "getBaseStationId", new java.lang.Object[0]) < 0) goto L8;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m16183a(CellLocation cellLocation) {
        boolean z = false;
        if (cellLocation != null) {
            switch (C1477bs.m16009a(cellLocation, this.f5039c)) {
                case 1:
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    if (gsmCellLocation.getLac() != -1) {
                        if (gsmCellLocation.getLac() != 0) {
                            if (gsmCellLocation.getLac() <= 65535) {
                                if (gsmCellLocation.getCid() != -1) {
                                    if (gsmCellLocation.getCid() != 0) {
                                        if (gsmCellLocation.getCid() != 65535) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    try {
                        if (C1475bq.m16027b(cellLocation, "getSystemId", new Object[0]) > 0 && C1475bq.m16027b(cellLocation, "getNetworkId", new Object[0]) >= 0) {
                            break;
                        }
                    } catch (Throwable th) {
                        C1514cx.m15728a(th, "CgiManager", "cgiUseful");
                        z = true;
                        break;
                    }
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                this.f5040d = 9;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m16182a(NeighboringCellInfo neighboringCellInfo) {
        return (neighboringCellInfo == null || neighboringCellInfo.getLac() == -1 || neighboringCellInfo.getLac() == 0 || neighboringCellInfo.getLac() > 65535 || neighboringCellInfo.getCid() == -1 || neighboringCellInfo.getCid() == 0 || neighboringCellInfo.getCid() == 65535 || neighboringCellInfo.getCid() >= 268435455) ? false : true;
    }

    /* renamed from: a */
    public boolean m16175a(boolean z) {
        return !z && this.f5045i != 0 && C1477bs.m15997b() - this.f5045i >= 30000;
    }

    /* renamed from: b */
    public C1451ba m16174b() {
        ArrayList<C1451ba> arrayList = this.f5041e;
        if (arrayList.size() >= 1) {
            return arrayList.get(0);
        }
        return null;
    }

    /* renamed from: c */
    public int m16170c() {
        return this.f5040d;
    }

    /* renamed from: d */
    public CellLocation m16167d() {
        CellLocation cellLocation = null;
        if (this.f5043g != null) {
            try {
                cellLocation = this.f5043g.getCellLocation();
                if (m16183a(cellLocation)) {
                    this.f5048l = cellLocation;
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "CgiManager", "getCellLocation");
            }
        }
        return cellLocation;
    }

    /* renamed from: e */
    public TelephonyManager m16164e() {
        return this.f5043g;
    }

    /* renamed from: f */
    public void m16162f() {
        m16153l();
    }

    /* renamed from: g */
    public void m16160g() {
        m16147r();
    }

    /* renamed from: h */
    public void m16158h() {
        m16149p();
    }

    /* renamed from: i */
    public void m16156i() {
        if (this.f5043g != null && this.f5047k != null) {
            try {
                this.f5043g.listen(this.f5047k, 0);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "CgiManager", "destroy");
            }
        }
        this.f5047k = null;
        synchronized (this.f5050n) {
            this.f5049m = true;
            if (this.f5037a != null) {
                this.f5037a.quit();
                this.f5037a = null;
            }
        }
        this.f5038b = null;
        this.f5041e.clear();
        this.f5042f = -113;
        this.f5043g = null;
        this.f5044h = null;
    }

    /* renamed from: j */
    public void m16155j() {
        switch (this.f5040d) {
            case 1:
                if (!this.f5041e.isEmpty()) {
                    return;
                }
                this.f5040d = 9;
                return;
            case 2:
                if (!this.f5041e.isEmpty()) {
                    return;
                }
                this.f5040d = 9;
                return;
            default:
                return;
        }
    }
}
