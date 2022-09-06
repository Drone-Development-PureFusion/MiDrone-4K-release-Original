package com.amap.api.services.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.p318d.AbstractC5756f;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: com.amap.api.services.core.z */
/* loaded from: classes.dex */
public class C1262z {

    /* renamed from: a */
    private static String f4201a = null;

    /* renamed from: b */
    private static boolean f4202b = false;

    /* renamed from: c */
    private static String f4203c = null;

    /* renamed from: d */
    private static String f4204d = null;

    /* renamed from: e */
    private static String f4205e = null;

    /* renamed from: f */
    private static String f4206f = null;

    /* renamed from: com.amap.api.services.core.z$a */
    /* loaded from: classes.dex */
    static class C1263a extends DefaultHandler {
        C1263a() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            if (C1262z.f4202b) {
                String unused = C1262z.f4201a = new String(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            boolean unused = C1262z.f4202b = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("string") || !"UTDID".equals(attributes.getValue("name"))) {
                return;
            }
            boolean unused = C1262z.f4202b = true;
        }
    }

    /* renamed from: a */
    public static String m16907a(Context context) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (f4201a == null || "".equals(f4201a)) {
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f4201a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (f4201a != null && !"".equals(f4201a)) {
                return f4201a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C1263a());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ParserConfigurationException e3) {
                e3.printStackTrace();
            } catch (SAXException e4) {
                e4.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return f4201a;
        }
        return f4201a;
    }

    /* renamed from: a */
    private static List<ScanResult> m16905a(List<ScanResult> list) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m16903b(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
            } catch (Throwable th) {
                C1190ay.m17177a(th, "DeviceInfo", "getWifiMacs");
                th.printStackTrace();
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults == null || scanResults.size() == 0) {
                        return sb.toString();
                    }
                    List<ScanResult> m16905a = m16905a(scanResults);
                    boolean z = true;
                    for (int i = 0; i < m16905a.size() && i < 10; i++) {
                        ScanResult scanResult = m16905a.get(i);
                        if (z) {
                            z = false;
                        } else {
                            sb.append("||");
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
    /* renamed from: c */
    public static String m16902c(Context context) {
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getDeviceMac");
            th.printStackTrace();
        }
        if ((f4203c == null || "".equals(f4203c)) && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            f4203c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f4203c;
        }
        return f4203c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m16901d(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "cellInfo");
            th.printStackTrace();
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return sb.toString();
        }
        CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            sb.append(gsmCellLocation.getLac()).append("||").append(gsmCellLocation.getCid()).append("&bt=gsm");
        } else if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            int systemId = cdmaCellLocation.getSystemId();
            int networkId = cdmaCellLocation.getNetworkId();
            int baseStationId = cdmaCellLocation.getBaseStationId();
            if (systemId < 0 || networkId < 0 || baseStationId < 0) {
            }
            sb.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static String m16900e(Context context) {
        try {
            return m16883v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static int m16899f(Context context) {
        try {
            return m16882w(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: g */
    public static int m16898g(Context context) {
        try {
            return m16884u(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getActiveNetWorkType");
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static int m16897h(Context context) {
        try {
            return m16884u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static String m16896i(Context context) {
        String str;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getNetworkExtraInfo");
            th.printStackTrace();
            str = null;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return null;
        }
        str = activeNetworkInfo.getExtraInfo();
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static String m16895j(Context context) {
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getReslution");
            th.printStackTrace();
        }
        if (f4204d == null || "".equals(f4204d)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f4204d = i2 > i ? i + AbstractC5756f.f23062a + i2 : i2 + AbstractC5756f.f23062a + i;
            return f4204d;
        }
        return f4204d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static String m16894k(Context context) {
        try {
            return m16885t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static String m16893l(Context context) {
        try {
            return m16885t(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getActiveNetworkTypeName");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static String m16892m(Context context) {
        try {
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getDeviceID");
            th.printStackTrace();
        }
        if ((f4205e == null || "".equals(f4205e)) && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            f4205e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f4205e;
        }
        return f4205e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static String m16891n(Context context) {
        try {
            return m16887r(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getSubscriberId");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static String m16890o(Context context) {
        try {
            return m16886s(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DeviceInfo", "getNetworkOperatorName");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static String m16889p(Context context) {
        try {
            return m16886s(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static String m16888q(Context context) {
        try {
            return m16887r(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: r */
    private static String m16887r(Context context) {
        if ((f4206f == null || "".equals(f4206f)) && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            f4206f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return f4206f;
        }
        return f4206f;
    }

    /* renamed from: s */
    private static String m16886s(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    /* renamed from: t */
    private static String m16885t(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
    }

    /* renamed from: u */
    private static int m16884u(Context context) {
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

    /* renamed from: v */
    private static String m16883v(Context context) {
        String m16891n = m16891n(context);
        return (m16891n == null || m16891n.length() < 5) ? "" : m16891n.substring(3, 5);
    }

    /* renamed from: w */
    private static int m16882w(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }
}
