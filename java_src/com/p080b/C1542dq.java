package com.p080b;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.p318d.AbstractC5756f;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: com.b.dq */
/* loaded from: classes.dex */
public class C1542dq {

    /* renamed from: a */
    private static String f5509a = "";

    /* renamed from: b */
    private static boolean f5510b = false;

    /* renamed from: c */
    private static String f5511c = "";

    /* renamed from: d */
    private static String f5512d = "";

    /* renamed from: e */
    private static String f5513e = "";

    /* renamed from: f */
    private static String f5514f = "";

    /* renamed from: com.b.dq$a */
    /* loaded from: classes.dex */
    static class C1543a extends DefaultHandler {
        C1543a() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            if (C1542dq.f5510b) {
                String unused = C1542dq.f5509a = new String(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            boolean unused = C1542dq.f5510b = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("string") || !"UTDID".equals(attributes.getValue("name"))) {
                return;
            }
            boolean unused = C1542dq.f5510b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m15635a(Context context) {
        try {
            return m15611u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static List<ScanResult> m15633a(List<ScanResult> list) {
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
    public static void m15636a() {
        try {
            if (Build.VERSION.SDK_INT <= 14) {
                return;
            }
            TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
        } catch (IllegalAccessException e) {
            C1450b.m16187a(e, "DeviceInfo", "setTraficTag");
        } catch (IllegalArgumentException e2) {
            C1450b.m16187a(e2, "DeviceInfo", "setTraficTag");
        } catch (NoSuchMethodException e3) {
            C1450b.m16187a(e3, "DeviceInfo", "setTraficTag");
        } catch (InvocationTargetException e4) {
            C1450b.m16187a(e4, "DeviceInfo", "setTraficTag");
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "setTraficTag");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m15630b(Context context) {
        try {
            return m15609w(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static int m15629c(Context context) {
        try {
            return m15608x(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static int m15628d(Context context) {
        try {
            return m15610v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static String m15627e(Context context) {
        try {
            return m15612t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public static String m15626f(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getUTDID");
        }
        if (f5509a == null || "".equals(f5509a)) {
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f5509a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (f5509a != null && !"".equals(f5509a)) {
                return f5509a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C1543a());
                    }
                }
            } catch (FileNotFoundException e) {
                C1450b.m16187a(e, "DeviceInfo", "getUTDID");
            } catch (IOException e2) {
                C1450b.m16187a(e2, "DeviceInfo", "getUTDID");
            } catch (ParserConfigurationException e3) {
                C1450b.m16187a(e3, "DeviceInfo", "getUTDID");
            } catch (SAXException e4) {
                C1450b.m16187a(e4, "DeviceInfo", "getUTDID");
            } catch (Throwable th2) {
                C1450b.m16187a(th2, "DeviceInfo", "getUTDID");
            }
            return f5509a;
        }
        return f5509a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static String m15625g(Context context) {
        if (context != null) {
            try {
            } catch (Throwable th) {
                C1450b.m16187a(th, "DeviceInfo", "getWifiMacs");
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    return wifiManager.getConnectionInfo().getBSSID();
                }
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static String m15624h(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
            } catch (Throwable th) {
                C1450b.m16187a(th, "DeviceInfo", "getWifiMacs");
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults == null || scanResults.size() == 0) {
                        return sb.toString();
                    }
                    List<ScanResult> m15633a = m15633a(scanResults);
                    boolean z = true;
                    for (int i = 0; i < m15633a.size() && i < 7; i++) {
                        ScanResult scanResult = m15633a.get(i);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static String m15623i(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getDeviceMac");
        }
        if ((f5511c == null || "".equals(f5511c)) && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            f5511c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f5511c;
        }
        return f5511c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0066 -> B:10:0x0020). Please submit an issue!!! */
    /* renamed from: j */
    public static String[] m15622j(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "cellInfo");
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return new String[]{"", ""};
        }
        CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
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
    public static String m15621k(Context context) {
        String str;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            C1450b.m16187a(th, "DeviceInfo", "getMNC");
            str = "";
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator) && networkOperator.length() < 3) {
            return "";
        }
        str = networkOperator.substring(3);
        return str;
    }

    /* renamed from: l */
    public static int m15620l(Context context) {
        try {
            return m15608x(context);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getNetWorkType");
            return -1;
        }
    }

    /* renamed from: m */
    public static int m15619m(Context context) {
        try {
            return m15610v(context);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getActiveNetWorkType");
            return -1;
        }
    }

    /* renamed from: n */
    public static NetworkInfo m15618n(Context context) {
        ConnectivityManager connectivityManager;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static String m15617o(Context context) {
        try {
            NetworkInfo m15618n = m15618n(context);
            if (m15618n != null) {
                return m15618n.getExtraInfo();
            }
            return null;
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getNetworkExtraInfo");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static String m15616p(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getReslution");
        }
        if (f5512d == null || "".equals(f5512d)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f5512d = i2 > i ? i + AbstractC5756f.f23062a + i2 : i2 + AbstractC5756f.f23062a + i;
            return f5512d;
        }
        return f5512d;
    }

    /* renamed from: q */
    public static String m15615q(Context context) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getDeviceID");
        }
        if ((f5513e == null || "".equals(f5513e)) && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            f5513e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (f5513e == null) {
                f5513e = "";
            }
            return f5513e;
        }
        return f5513e;
    }

    /* renamed from: r */
    public static String m15614r(Context context) {
        try {
            return m15612t(context);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static String m15613s(Context context) {
        try {
            return m15611u(context);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DeviceInfo", "getNetworkOperatorName");
            return "";
        }
    }

    /* renamed from: t */
    private static String m15612t(Context context) {
        if ((f5514f == null || "".equals(f5514f)) && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            f5514f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (f5514f == null) {
                f5514f = "";
            }
            return f5514f;
        }
        return f5514f;
    }

    /* renamed from: u */
    private static String m15611u(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String simOperatorName = telephonyManager.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? telephonyManager.getNetworkOperatorName() : simOperatorName;
    }

    /* renamed from: v */
    private static int m15610v(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return -1;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    /* renamed from: w */
    private static String m15609w(Context context) {
        String m15614r = m15614r(context);
        return (m15614r == null || m15614r.length() < 5) ? "" : m15614r.substring(3, 5);
    }

    /* renamed from: x */
    private static int m15608x(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }
}
