package com.fimi.kernel.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.util.List;
/* renamed from: com.fimi.kernel.utils.q */
/* loaded from: classes.dex */
public class C2272q {
    /* renamed from: a */
    public static ScanResult m12846a(Context context, String str) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.startScan()) {
            m12846a(context, str);
        }
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults != null) {
            ScanResult scanResult = null;
            for (int i = 0; i < scanResults.size(); i++) {
                scanResult = scanResults.get(i);
                if (scanResult.BSSID.equals(str)) {
                    return scanResult;
                }
            }
            return scanResult;
        }
        return null;
    }

    /* renamed from: a */
    public static void m12845a(Context context, boolean z) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (z) {
            wifiManager.setWifiEnabled(true);
        } else {
            wifiManager.setWifiEnabled(false);
        }
    }

    /* renamed from: a */
    public static boolean m12847a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 3;
    }

    /* renamed from: b */
    public static boolean m12844b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: c */
    public static List<ScanResult> m12843c(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.startScan()) {
            m12843c(context);
            return null;
        }
        return wifiManager.getScanResults();
    }

    /* renamed from: d */
    public static WifiInfo m12842d(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
    }
}
