package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.p227mm.sdk.platformtools.PhoneUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.p318d.AbstractC5756f;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: com.amap.api.mapcore.util.fc */
/* loaded from: classes.dex */
public class C0989fc {

    /* renamed from: a */
    private static String f3114a = "";

    /* renamed from: b */
    private static boolean f3115b = false;

    /* renamed from: c */
    private static String f3116c = "";

    /* renamed from: d */
    private static String f3117d = "";

    /* renamed from: e */
    private static String f3118e = "";

    /* renamed from: f */
    private static String f3119f = "";

    /* renamed from: com.amap.api.mapcore.util.fc$a */
    /* loaded from: classes.dex */
    static class C0990a extends DefaultHandler {
        C0990a() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            if (C0989fc.f3115b) {
                String unused = C0989fc.f3114a = new String(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            boolean unused = C0989fc.f3115b = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("string") || !"UTDID".equals(attributes.getValue("name"))) {
                return;
            }
            boolean unused = C0989fc.f3115b = true;
        }
    }

    /* renamed from: a */
    public static String m18134a(Context context) {
        try {
            return m18109u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static List<ScanResult> m18131a(List<ScanResult> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size - 1) {
                int i3 = 1;
                while (true) {
                    int i4 = i3;
                    if (i4 < size - i2) {
                        if (list.get(i4 - 1).level > list.get(i4).level) {
                            list.set(i4 - 1, list.get(i4));
                            list.set(i4, list.get(i4 - 1));
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                return list;
            }
        }
    }

    /* renamed from: a */
    public static void m18135a() {
        try {
            if (Build.VERSION.SDK_INT <= 14) {
                return;
            }
            TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "setTraficTag");
        }
    }

    /* renamed from: a */
    private static boolean m18133a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static String m18128b(Context context) {
        try {
            return m18106x(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static int m18127c(Context context) {
        try {
            return m18105y(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: d */
    public static int m18126d(Context context) {
        try {
            return m18108v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: e */
    public static String m18125e(Context context) {
        try {
            return m18110t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public static String m18124f(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getUTDID");
        }
        if (f3114a == null || "".equals(f3114a)) {
            if (m18133a(context, "android.permission.WRITE_SETTINGS")) {
                f3114a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (f3114a != null && !"".equals(f3114a)) {
                return f3114a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C0990a());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th2) {
                C1002fl.m18028a(th2, "DeviceInfo", "getUTDID");
            }
            return f3114a == null ? "" : f3114a;
        }
        return f3114a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static String m18123g(Context context) {
        String str;
        WifiManager wifiManager;
        if (context != null) {
            try {
            } catch (Throwable th) {
                C1002fl.m18028a(th, "DeviceInfo", "getWifiMacs");
            }
            if (!m18133a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                return "";
            }
            if (wifiManager.isWifiEnabled()) {
                str = wifiManager.getConnectionInfo().getBSSID();
                return str;
            }
            str = "";
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static String m18122h(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
            } catch (Throwable th) {
                C1002fl.m18028a(th, "DeviceInfo", "getWifiMacs");
            }
            if (m18133a(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return "";
                }
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults == null || scanResults.size() == 0) {
                        return sb.toString();
                    }
                    List<ScanResult> m18131a = m18131a(scanResults);
                    boolean z = true;
                    for (int i = 0; i < m18131a.size() && i < 7; i++) {
                        ScanResult scanResult = m18131a.get(i);
                        if (z) {
                            z = false;
                        } else {
                            sb.append(";");
                        }
                        sb.append(scanResult.BSSID);
                    }
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }

    /* renamed from: i */
    public static String m18121i(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getDeviceMac");
        }
        if ((f3116c == null || "".equals(f3116c)) && m18133a(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f3116c = wifiManager.getConnectionInfo().getMacAddress();
            return f3116c;
        }
        return f3116c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0041 -> B:10:0x0020). Please submit an issue!!! */
    /* renamed from: j */
    public static String[] m18120j(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "cellInfo");
        }
        if (!m18133a(context, "android.permission.READ_PHONE_STATE") || !m18133a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return new String[]{"", ""};
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new String[]{"", ""};
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            return new String[]{gsmCellLocation.getLac() + "||" + gsmCellLocation.getCid(), PhoneUtil.CELL_GSM};
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            int systemId = cdmaCellLocation.getSystemId();
            int networkId = cdmaCellLocation.getNetworkId();
            int baseStationId = cdmaCellLocation.getBaseStationId();
            if (systemId < 0 || networkId < 0 || baseStationId < 0) {
            }
            return new String[]{systemId + "||" + networkId + "||" + baseStationId, PhoneUtil.CELL_CDMA};
        }
        return new String[]{"", ""};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static String m18119k(Context context) {
        TelephonyManager m18104z;
        try {
            if (m18133a(context, "android.permission.READ_PHONE_STATE") && (m18104z = m18104z(context)) != null) {
                String networkOperator = m18104z.getNetworkOperator();
                return (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3) ? "" : networkOperator.substring(3);
            }
            return "";
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getMNC");
            return "";
        }
    }

    /* renamed from: l */
    public static int m18118l(Context context) {
        try {
            return m18105y(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getNetWorkType");
            return -1;
        }
    }

    /* renamed from: m */
    public static int m18117m(Context context) {
        try {
            return m18108v(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getActiveNetWorkType");
            return -1;
        }
    }

    /* renamed from: n */
    public static NetworkInfo m18116n(Context context) {
        ConnectivityManager m18107w;
        if (m18133a(context, "android.permission.ACCESS_NETWORK_STATE") && (m18107w = m18107w(context)) != null) {
            return m18107w.getActiveNetworkInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static String m18115o(Context context) {
        try {
            NetworkInfo m18116n = m18116n(context);
            if (m18116n != null) {
                return m18116n.getExtraInfo();
            }
            return null;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getNetworkExtraInfo");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static String m18114p(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getReslution");
        }
        if (f3117d == null || "".equals(f3117d)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f3117d = i2 > i ? i + AbstractC5756f.f23062a + i2 : i2 + AbstractC5756f.f23062a + i;
            return f3117d;
        }
        return f3117d;
    }

    /* renamed from: q */
    public static String m18113q(Context context) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getDeviceID");
        }
        if ((f3118e == null || "".equals(f3118e)) && m18133a(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager m18104z = m18104z(context);
            if (m18104z == null) {
                return "";
            }
            f3118e = m18104z.getDeviceId();
            if (f3118e == null) {
                f3118e = "";
            }
            return f3118e;
        }
        return f3118e;
    }

    /* renamed from: r */
    public static String m18112r(Context context) {
        try {
            return m18110t(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static String m18111s(Context context) {
        try {
            return m18109u(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DeviceInfo", "getNetworkOperatorName");
            return "";
        }
    }

    /* renamed from: t */
    private static String m18110t(Context context) {
        if ((f3119f == null || "".equals(f3119f)) && m18133a(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager m18104z = m18104z(context);
            if (m18104z == null) {
                return "";
            }
            f3119f = m18104z.getSubscriberId();
            if (f3119f == null) {
                f3119f = "";
            }
            return f3119f;
        }
        return f3119f;
    }

    /* renamed from: u */
    private static String m18109u(Context context) {
        if (!m18133a(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        TelephonyManager m18104z = m18104z(context);
        if (m18104z == null) {
            return "";
        }
        String simOperatorName = m18104z.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? m18104z.getNetworkOperatorName() : simOperatorName;
    }

    /* renamed from: v */
    private static int m18108v(Context context) {
        ConnectivityManager m18107w;
        NetworkInfo activeNetworkInfo;
        if (context == null || !m18133a(context, "android.permission.ACCESS_NETWORK_STATE") || (m18107w = m18107w(context)) == null || (activeNetworkInfo = m18107w.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: w */
    private static ConnectivityManager m18107w(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* renamed from: x */
    private static String m18106x(Context context) {
        String m18112r = m18112r(context);
        return (m18112r == null || m18112r.length() < 5) ? "" : m18112r.substring(3, 5);
    }

    /* renamed from: y */
    private static int m18105y(Context context) {
        TelephonyManager m18104z;
        if (m18133a(context, "android.permission.READ_PHONE_STATE") && (m18104z = m18104z(context)) != null) {
            return m18104z.getNetworkType();
        }
        return -1;
    }

    /* renamed from: z */
    private static TelephonyManager m18104z(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }
}
