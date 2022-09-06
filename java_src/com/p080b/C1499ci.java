package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TreeMap;
/* renamed from: com.b.ci */
/* loaded from: classes.dex */
public final class C1499ci {

    /* renamed from: f */
    private Context f5352f;

    /* renamed from: g */
    private TelephonyManager f5353g;

    /* renamed from: h */
    private LocationManager f5354h;

    /* renamed from: i */
    private WifiManager f5355i;

    /* renamed from: j */
    private SensorManager f5356j;

    /* renamed from: k */
    private String f5357k;

    /* renamed from: l */
    private String f5358l;

    /* renamed from: m */
    private String f5359m;

    /* renamed from: n */
    private boolean f5360n;

    /* renamed from: s */
    private String f5365s;

    /* renamed from: t */
    private int f5366t;

    /* renamed from: u */
    private int f5367u;

    /* renamed from: v */
    private int f5368v;

    /* renamed from: w */
    private String f5369w;

    /* renamed from: z */
    private static C1499ci f5341z = null;

    /* renamed from: I */
    private static int f5336I = 10000;

    /* renamed from: a */
    static String f5338a = "";

    /* renamed from: b */
    protected static boolean f5339b = true;

    /* renamed from: c */
    protected static boolean f5340c = false;

    /* renamed from: J */
    private static String[] f5337J = {"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};

    /* renamed from: o */
    private int f5361o = 0;

    /* renamed from: p */
    private boolean f5362p = false;

    /* renamed from: q */
    private long f5363q = -1;

    /* renamed from: r */
    private String f5364r = "";

    /* renamed from: x */
    private long f5370x = 0;

    /* renamed from: y */
    private long f5371y = 0;

    /* renamed from: A */
    private C1501ck f5342A = null;

    /* renamed from: B */
    private C1502cl f5343B = null;

    /* renamed from: C */
    private CellLocation f5344C = null;

    /* renamed from: D */
    private C1503cm f5345D = null;

    /* renamed from: E */
    private List f5346E = new ArrayList();

    /* renamed from: F */
    private Timer f5347F = null;

    /* renamed from: G */
    private Thread f5348G = null;

    /* renamed from: H */
    private Looper f5349H = null;

    /* renamed from: d */
    Object f5350d = new Object();

    /* renamed from: e */
    boolean f5351e = false;

    private C1499ci(Context context) {
        this.f5352f = null;
        this.f5353g = null;
        this.f5354h = null;
        this.f5355i = null;
        this.f5356j = null;
        this.f5357k = "";
        this.f5358l = "";
        this.f5359m = "";
        this.f5360n = false;
        this.f5365s = "";
        this.f5366t = 0;
        this.f5367u = 0;
        this.f5368v = 0;
        this.f5369w = "";
        if (context == null) {
            return;
        }
        this.f5352f = context;
        this.f5357k = Build.MODEL;
        this.f5353g = (TelephonyManager) context.getSystemService("phone");
        this.f5354h = (LocationManager) context.getSystemService("location");
        this.f5355i = (WifiManager) context.getSystemService("wifi");
        this.f5356j = (SensorManager) context.getSystemService("sensor");
        if (this.f5353g == null || this.f5355i == null) {
            return;
        }
        try {
            this.f5358l = this.f5353g.getDeviceId();
        } catch (Exception e) {
        }
        this.f5359m = this.f5353g.getSubscriberId();
        if (this.f5355i.getConnectionInfo() != null) {
            this.f5365s = this.f5355i.getConnectionInfo().getMacAddress();
            if (this.f5365s != null && this.f5365s.length() > 0) {
                this.f5365s = this.f5365s.replace(":", "");
            }
        }
        String[] m15807b = m15807b(this.f5353g);
        this.f5366t = Integer.parseInt(m15807b[0]);
        this.f5367u = Integer.parseInt(m15807b[1]);
        this.f5368v = this.f5353g.getNetworkType();
        this.f5369w = context.getPackageName();
        this.f5360n = this.f5353g.getPhoneType() == 2;
    }

    /* renamed from: A */
    private CellLocation m15840A() {
        CellLocation cellLocation;
        if (this.f5353g == null) {
            return null;
        }
        try {
            cellLocation = m15800b((List) C1496cf.m15857a(this.f5353g, "getAllCellInfo", new Object[0]));
        } catch (NoSuchMethodException e) {
            cellLocation = null;
        } catch (Exception e2) {
            cellLocation = null;
        }
        return cellLocation;
    }

    /* renamed from: a */
    private static int m15831a(CellLocation cellLocation, Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 || cellLocation == null) {
            return 9;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Exception e) {
            return 9;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1499ci m15835a(Context context) {
        boolean z;
        if (f5341z == null && m15797c(context)) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager != null) {
                for (String str : locationManager.getAllProviders()) {
                    if (str.equals("passive") || str.equals(GeocodeSearch.GPS)) {
                        z = true;
                        break;
                    }
                    while (r1.hasNext()) {
                    }
                }
            }
            z = false;
            if (z) {
                f5341z = new C1499ci(context);
            }
        }
        return f5341z;
    }

    /* renamed from: a */
    private void m15836a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || this.f5352f == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.f5352f.registerReceiver(broadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15834a(GpsStatus.NmeaListener nmeaListener) {
        if (this.f5354h == null || nmeaListener == null) {
            return;
        }
        this.f5354h.removeNmeaListener(nmeaListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m15833a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return;
        }
        try {
            C1496cf.m15857a(wifiManager, "startScanActive", new Object[0]);
        } catch (Exception e) {
            wifiManager.startScan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15830a(PhoneStateListener phoneStateListener) {
        if (this.f5353g == null) {
            return;
        }
        this.f5353g.listen(phoneStateListener, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m15825a(C1499ci c1499ci, GpsStatus.NmeaListener nmeaListener) {
        if (c1499ci.f5354h == null || nmeaListener == null) {
            return;
        }
        c1499ci.f5354h.addNmeaListener(nmeaListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m15821a(C1499ci c1499ci, PhoneStateListener phoneStateListener) {
        if (c1499ci.f5353g != null) {
            c1499ci.f5353g.listen(phoneStateListener, 273);
        }
    }

    /* renamed from: a */
    private static void m15814a(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            ScanResult scanResult = (ScanResult) list.get(i2);
            if (scanResult.SSID == null) {
                scanResult.SSID = "null";
            }
            hashMap.put(Integer.valueOf(scanResult.level), scanResult);
            i = i2 + 1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        treeMap.putAll(hashMap);
        list.clear();
        for (Object obj : treeMap.keySet()) {
            list.add(treeMap.get(obj));
        }
        hashMap.clear();
        treeMap.clear();
    }

    /* renamed from: a */
    private boolean m15832a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        switch (m15831a(cellLocation, this.f5352f)) {
            case 1:
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                if (gsmCellLocation.getLac() == -1 || gsmCellLocation.getLac() == 0 || gsmCellLocation.getLac() > 65535 || gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == 0 || gsmCellLocation.getCid() == 65535 || gsmCellLocation.getCid() >= 268435455) {
                    return false;
                }
                break;
            case 2:
                try {
                    if (C1496cf.m15849b(cellLocation, "getSystemId", new Object[0]) <= 0 || C1496cf.m15849b(cellLocation, "getNetworkId", new Object[0]) < 0) {
                        return false;
                    }
                    if (C1496cf.m15849b(cellLocation, "getBaseStationId", new Object[0]) < 0) {
                        return false;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m15815a(Object obj) {
        try {
            Method declaredMethod = WifiManager.class.getDeclaredMethod("isScanAlwaysAvailable", null);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(obj, null)).booleanValue();
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: b */
    private static int m15801b(Object obj) {
        try {
            Method declaredMethod = Sensor.class.getDeclaredMethod("getMinDelay", null);
            if (declaredMethod != null) {
                return ((Integer) declaredMethod.invoke(obj, null)).intValue();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c8, code lost:
        if (r6 == 4) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static CellLocation m15800b(List list) {
        char c;
        CdmaCellLocation cdmaCellLocation;
        CdmaCellLocation cdmaCellLocation2;
        if (list != null && !list.isEmpty()) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            CdmaCellLocation cdmaCellLocation3 = null;
            int i = 0;
            char c2 = 0;
            CdmaCellLocation cdmaCellLocation4 = null;
            while (true) {
                if (i >= list.size()) {
                    c = c2;
                    cdmaCellLocation = cdmaCellLocation4;
                    cdmaCellLocation4 = cdmaCellLocation3;
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
                                } catch (Exception e) {
                                    c2 = c;
                                    cdmaCellLocation2 = cdmaCellLocation3;
                                }
                            } else if (c == 2) {
                                obj2 = loadClass2.cast(obj);
                            } else if (c == 3) {
                                obj2 = loadClass3.cast(obj);
                            } else if (c == 4) {
                                obj2 = loadClass4.cast(obj);
                            }
                            Object m15857a = C1496cf.m15857a(obj2, "getCellIdentity", new Object[0]);
                            if (m15857a == null) {
                                c2 = c;
                                cdmaCellLocation2 = cdmaCellLocation3;
                            } else if (c == 4) {
                                cdmaCellLocation = new CdmaCellLocation();
                                try {
                                    cdmaCellLocation.setCellLocationData(C1496cf.m15849b(m15857a, "getBasestationId", new Object[0]), C1496cf.m15849b(m15857a, "getLatitude", new Object[0]), C1496cf.m15849b(m15857a, "getLongitude", new Object[0]), C1496cf.m15849b(m15857a, "getSystemId", new Object[0]), C1496cf.m15849b(m15857a, "getNetworkId", new Object[0]));
                                    cdmaCellLocation4 = cdmaCellLocation3;
                                    break;
                                } catch (Exception e2) {
                                    cdmaCellLocation4 = cdmaCellLocation;
                                    cdmaCellLocation2 = cdmaCellLocation3;
                                    c2 = c;
                                }
                            } else {
                                try {
                                    if (c == 3) {
                                        int m15849b = C1496cf.m15849b(m15857a, "getTac", new Object[0]);
                                        int m15849b2 = C1496cf.m15849b(m15857a, "getCi", new Object[0]);
                                        GsmCellLocation gsmCellLocation = new GsmCellLocation();
                                        gsmCellLocation.setLacAndCid(m15849b, m15849b2);
                                        cdmaCellLocation = cdmaCellLocation4;
                                        cdmaCellLocation4 = gsmCellLocation;
                                        cdmaCellLocation2 = gsmCellLocation;
                                    } else {
                                        int m15849b3 = C1496cf.m15849b(m15857a, "getLac", new Object[0]);
                                        int m15849b4 = C1496cf.m15849b(m15857a, "getCid", new Object[0]);
                                        GsmCellLocation gsmCellLocation2 = new GsmCellLocation();
                                        gsmCellLocation2.setLacAndCid(m15849b3, m15849b4);
                                        cdmaCellLocation = cdmaCellLocation4;
                                        cdmaCellLocation4 = gsmCellLocation2;
                                        cdmaCellLocation2 = gsmCellLocation2;
                                    }
                                } catch (Exception e3) {
                                    c2 = c;
                                }
                            }
                        } else {
                            c2 = c;
                            cdmaCellLocation2 = cdmaCellLocation3;
                        }
                    } catch (Exception e4) {
                        cdmaCellLocation2 = cdmaCellLocation3;
                    }
                } else {
                    cdmaCellLocation2 = cdmaCellLocation3;
                }
                i++;
                cdmaCellLocation3 = cdmaCellLocation2;
            }
        } else {
            return null;
        }
    }

    /* renamed from: b */
    private void m15809b(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || this.f5352f == null) {
            return;
        }
        try {
            this.f5352f.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static boolean m15808b(Context context) {
        boolean z;
        boolean z2;
        if (context == null) {
            return true;
        }
        if (!Settings.Secure.getString(context.getContentResolver(), "mock_location").equals("0")) {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
            String packageName = context.getPackageName();
            z = false;
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (z) {
                    break;
                }
                try {
                    String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (!strArr[i].equals("android.permission.ACCESS_MOCK_LOCATION")) {
                                i++;
                            } else if (!applicationInfo.packageName.equals(packageName)) {
                                z2 = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    z2 = z;
                }
            }
        } else {
            z = false;
        }
        return z;
        z = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String[] m15807b(TelephonyManager telephonyManager) {
        int i = 0;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = {"0", "0"};
        if (TextUtils.isDigitsOnly(str) && str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] charArray = str.substring(3).toCharArray();
            while (i < charArray.length && Character.isDigit(charArray[i])) {
                i++;
            }
            strArr[1] = str.substring(3, i + 3);
        }
        return strArr;
    }

    /* renamed from: c */
    private static boolean m15797c(Context context) {
        boolean z;
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (int i = 0; i < f5337J.length; i++) {
                String str = f5337J[i];
                if (strArr != null && str != null) {
                    for (String str2 : strArr) {
                        if (str2.equals(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: z */
    private void m15759z() {
        if (this.f5355i == null) {
            return;
        }
        try {
            if (!f5339b) {
                return;
            }
            m15833a(this.f5355i);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final List m15838a(float f) {
        CellLocation cellLocation;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (m15799c() && (cellLocation = (CellLocation) m15775j().get(1)) != null && (cellLocation instanceof GsmCellLocation)) {
            arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getLac()));
            arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getCid()));
            if (currentTimeMillis - ((Long) m15775j().get(0)).longValue() <= 50000.0d / f) {
                arrayList.add(1);
            } else {
                arrayList.add(0);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
        if ((java.lang.System.currentTimeMillis() - r8.f5370x < 3500) != false) goto L6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m15813a(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (m15793d()) {
            ArrayList arrayList2 = new ArrayList();
            synchronized (this) {
                if (!z) {
                }
                arrayList2.add(Long.valueOf(this.f5370x));
                for (int i = 0; i < this.f5346E.size(); i++) {
                    arrayList.add(this.f5346E.get(i));
                }
                arrayList2.add(arrayList);
            }
            return arrayList2;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m15839a() {
        m15812b();
        this.f5351e = true;
        this.f5348G = new C1500cj(this, "");
        this.f5348G.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m15837a(int i) {
        if (i == f5336I) {
            return;
        }
        synchronized (this) {
            this.f5346E.clear();
        }
        if (this.f5345D != null) {
            m15809b((BroadcastReceiver) this.f5345D);
            this.f5345D = null;
        }
        if (this.f5347F != null) {
            this.f5347F.cancel();
            this.f5347F = null;
        }
        if (i < 5000) {
            return;
        }
        f5336I = i;
        this.f5347F = new Timer();
        this.f5345D = new C1503cm(this, (byte) 0);
        m15836a((BroadcastReceiver) this.f5345D);
        m15759z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final String m15810b(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        return (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null || sensorList.get(i).getName() == null || sensorList.get(i).getName().length() <= 0) ? "null" : sensorList.get(i).getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final List m15811b(float f) {
        CellLocation cellLocation;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (m15799c() && (cellLocation = (CellLocation) m15775j().get(1)) != null && (cellLocation instanceof CdmaCellLocation)) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            arrayList.add(Integer.valueOf(cdmaCellLocation.getSystemId()));
            arrayList.add(Integer.valueOf(cdmaCellLocation.getNetworkId()));
            arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationId()));
            arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLongitude()));
            arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLatitude()));
            if (currentTimeMillis - ((Long) m15775j().get(0)).longValue() <= 50000.0d / f) {
                arrayList.add(1);
            } else {
                arrayList.add(0);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m15812b() {
        synchronized (this.f5350d) {
            this.f5351e = false;
            if (this.f5342A != null) {
                m15830a((PhoneStateListener) this.f5342A);
                this.f5342A = null;
            }
            if (this.f5343B != null) {
                m15834a((GpsStatus.NmeaListener) this.f5343B);
                this.f5343B = null;
            }
            if (this.f5347F != null) {
                this.f5347F.cancel();
                this.f5347F = null;
            }
            if (this.f5349H != null) {
                this.f5349H.quit();
                this.f5349H = null;
            }
            if (this.f5348G != null) {
                this.f5348G.interrupt();
                this.f5348G = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final double m15798c(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        if (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null) {
            return 0.0d;
        }
        return sensorList.get(i).getMaximumRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean m15799c() {
        CellLocation cellLocation = null;
        if (this.f5353g == null || this.f5353g.getSimState() != 5 || !this.f5362p) {
            if (this.f5353g != null) {
                try {
                    cellLocation = this.f5353g.getCellLocation();
                } catch (Exception e) {
                }
                if (cellLocation != null) {
                    this.f5371y = System.currentTimeMillis();
                    this.f5344C = cellLocation;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final int m15792d(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        if (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null) {
            return 0;
        }
        return m15801b(sensorList.get(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean m15793d() {
        return this.f5355i != null && (this.f5355i.isWifiEnabled() || m15815a((Object) this.f5355i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final int m15789e(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        if (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null) {
            return 0;
        }
        return (int) (sensorList.get(i).getPower() * 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final boolean m15790e() {
        try {
            if (this.f5354h != null) {
                if (this.f5354h.isProviderEnabled(GeocodeSearch.GPS)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final double m15786f(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        if (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null) {
            return 0.0d;
        }
        return sensorList.get(i).getResolution();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final String m15787f() {
        if (this.f5357k == null) {
            this.f5357k = Build.MODEL;
        }
        return this.f5357k != null ? this.f5357k : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final byte m15783g(int i) {
        new ArrayList();
        if (this.f5356j == null) {
            return Byte.MAX_VALUE;
        }
        List<Sensor> sensorList = this.f5356j.getSensorList(-1);
        if (sensorList != null && sensorList.get(i) != null && sensorList.get(i).getType() <= 127) {
            return (byte) sensorList.get(i).getType();
        }
        return Byte.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final String m15784g() {
        if (this.f5358l == null && this.f5352f != null) {
            this.f5353g = (TelephonyManager) this.f5352f.getSystemService("phone");
            if (this.f5353g != null) {
                try {
                    this.f5358l = this.f5353g.getDeviceId();
                } catch (Exception e) {
                }
            }
        }
        return this.f5358l != null ? this.f5358l : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final String m15781h() {
        if (this.f5359m == null && this.f5352f != null) {
            this.f5353g = (TelephonyManager) this.f5352f.getSystemService("phone");
            if (this.f5353g != null) {
                this.f5359m = this.f5353g.getSubscriberId();
            }
        }
        return this.f5359m != null ? this.f5359m : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final String m15780h(int i) {
        List<Sensor> sensorList;
        new ArrayList();
        return (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null || sensorList.get(i) == null || sensorList.get(i).getVendor() == null || sensorList.get(i).getVendor().length() <= 0) ? "null" : sensorList.get(i).getVendor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public final byte m15777i(int i) {
        new ArrayList();
        if (this.f5356j == null) {
            return Byte.MAX_VALUE;
        }
        List<Sensor> sensorList = this.f5356j.getSensorList(-1);
        if (sensorList != null && sensorList.get(i) != null && sensorList.get(i).getType() <= 127) {
            return (byte) sensorList.get(i).getVersion();
        }
        return Byte.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public final boolean m15778i() {
        return this.f5360n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final List m15775j() {
        CellLocation cellLocation;
        if (Settings.System.getInt(this.f5352f.getContentResolver(), "airplane_mode_on", 0) != 1 && m15799c()) {
            ArrayList arrayList = new ArrayList();
            if (!m15832a(this.f5344C)) {
                cellLocation = m15840A();
                if (m15832a(cellLocation)) {
                    this.f5371y = System.currentTimeMillis();
                    arrayList.add(Long.valueOf(this.f5371y));
                    arrayList.add(cellLocation);
                    return arrayList;
                }
            }
            cellLocation = this.f5344C;
            arrayList.add(Long.valueOf(this.f5371y));
            arrayList.add(cellLocation);
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public final byte m15774k() {
        if (m15799c()) {
            return (byte) this.f5361o;
        }
        return Byte.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final List m15773l() {
        ArrayList arrayList = new ArrayList();
        if (this.f5353g != null && m15799c() && this.f5353g.getSimState() != 1) {
            int i = 0;
            for (NeighboringCellInfo neighboringCellInfo : this.f5353g.getNeighboringCellInfo()) {
                if (i > 15) {
                    break;
                } else if (neighboringCellInfo.getLac() != 0 && neighboringCellInfo.getLac() != 65535 && neighboringCellInfo.getCid() != 65535 && neighboringCellInfo.getCid() != 268435455) {
                    arrayList.add(neighboringCellInfo);
                    i++;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public final List m15772m() {
        long j;
        String str;
        ArrayList arrayList = new ArrayList();
        if (m15790e()) {
            j = this.f5363q;
            str = this.f5364r;
        } else {
            j = -1;
            str = "";
        }
        if (j <= 0) {
            j = System.currentTimeMillis() / 1000;
        }
        if (j > 2147483647L) {
            j /= 1000;
        }
        arrayList.add(Long.valueOf(j));
        arrayList.add(str);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final long m15771n() {
        long j = 0;
        long j2 = this.f5363q;
        if (j2 > 0) {
            j = j2;
            int length = String.valueOf(j2).length();
            while (length != 13) {
                j = length > 13 ? j / 10 : j * 10;
                length = String.valueOf(j).length();
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public final String m15770o() {
        if (this.f5365s == null && this.f5352f != null) {
            this.f5355i = (WifiManager) this.f5352f.getSystemService("wifi");
            if (this.f5355i != null && this.f5355i.getConnectionInfo() != null) {
                this.f5365s = this.f5355i.getConnectionInfo().getMacAddress();
                if (this.f5365s != null && this.f5365s.length() > 0) {
                    this.f5365s = this.f5365s.replace(":", "");
                }
            }
        }
        return this.f5365s != null ? this.f5365s : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final int m15769p() {
        return this.f5366t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q */
    public final int m15768q() {
        return this.f5367u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public final int m15767r() {
        return this.f5368v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public final String m15766s() {
        if (this.f5369w == null && this.f5352f != null) {
            this.f5369w = this.f5352f.getPackageName();
        }
        return this.f5369w != null ? this.f5369w : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public final List m15765t() {
        ArrayList arrayList = new ArrayList();
        if (m15793d()) {
            List m15813a = m15813a(true);
            List list = (List) m15813a.get(1);
            long longValue = ((Long) m15813a.get(0)).longValue();
            m15814a(list);
            arrayList.add(Long.valueOf(longValue));
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (arrayList.size() - 1 >= 40) {
                        break;
                    }
                    if (scanResult != null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(scanResult.BSSID.replace(":", ""));
                        arrayList2.add(Integer.valueOf(scanResult.level));
                        arrayList2.add(scanResult.SSID);
                        arrayList.add(arrayList2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public final void m15764u() {
        synchronized (this) {
            this.f5346E.clear();
        }
        if (this.f5345D != null) {
            m15809b((BroadcastReceiver) this.f5345D);
            this.f5345D = null;
        }
        if (this.f5347F != null) {
            this.f5347F.cancel();
            this.f5347F = null;
        }
        this.f5347F = new Timer();
        this.f5345D = new C1503cm(this, (byte) 0);
        m15836a((BroadcastReceiver) this.f5345D);
        m15759z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public final void m15763v() {
        synchronized (this) {
            this.f5346E.clear();
        }
        if (this.f5345D != null) {
            m15809b((BroadcastReceiver) this.f5345D);
            this.f5345D = null;
        }
        if (this.f5347F != null) {
            this.f5347F.cancel();
            this.f5347F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public final byte m15762w() {
        List<Sensor> sensorList;
        new ArrayList();
        if (this.f5356j == null || (sensorList = this.f5356j.getSensorList(-1)) == null) {
            return (byte) 0;
        }
        return (byte) sensorList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final Context m15761x() {
        return this.f5352f;
    }
}
