package com.p080b;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.b.bc */
/* loaded from: classes.dex */
public class C1455bc {

    /* renamed from: a */
    private WifiManager f5053a;

    /* renamed from: b */
    private JSONObject f5054b;

    /* renamed from: c */
    private Context f5055c;

    public C1455bc(Context context, WifiManager wifiManager, JSONObject jSONObject) {
        this.f5053a = wifiManager;
        this.f5054b = jSONObject;
        this.f5055c = context;
    }

    /* renamed from: a */
    private boolean m16144a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getBSSID()) && wifiInfo.getSSID() != null && !wifiInfo.getBSSID().equals("00:00:00:00:00:00") && !wifiInfo.getBSSID().contains(" :") && !TextUtils.isEmpty(wifiInfo.getSSID());
    }

    /* renamed from: a */
    public List<ScanResult> m16146a() {
        try {
            if (this.f5053a == null) {
                return null;
            }
            return this.f5053a.getScanResults();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "WifiManagerWrapper", "getScanResults");
            return null;
        }
    }

    /* renamed from: a */
    public void m16143a(JSONObject jSONObject) {
        this.f5054b = jSONObject;
    }

    /* renamed from: a */
    public void m16142a(boolean z) {
        Context context = this.f5055c;
        if (this.f5053a == null || context == null || !z || C1477bs.m15990c() <= 17) {
            return;
        }
        if (C1477bs.m16000a(this.f5054b, "autoenablewifialwaysscan")) {
            try {
                if ("0".equals(this.f5054b.getString("autoenablewifialwaysscan"))) {
                    return;
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "WifiManagerWrapper", "enableWifiAlwaysScan1");
            }
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) C1475bq.m16028a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() != 0) {
                return;
            }
            C1475bq.m16028a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (m16144a(r2.getConnectionInfo()) != false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m16145a(ConnectivityManager connectivityManager) {
        boolean z = true;
        WifiManager wifiManager = this.f5053a;
        if (wifiManager != null && m16137f()) {
            try {
                if (C1467bl.m16068a(connectivityManager.getActiveNetworkInfo()) == 1) {
                }
                z = false;
                return z;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "WifiManagerWrapper", "wifiAccess");
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public WifiInfo m16141b() {
        if (this.f5053a != null) {
            return this.f5053a.getConnectionInfo();
        }
        return null;
    }

    /* renamed from: c */
    public int m16140c() {
        if (this.f5053a != null) {
            return this.f5053a.getWifiState();
        }
        return 4;
    }

    /* renamed from: d */
    public boolean m16139d() {
        if (this.f5053a != null) {
            return this.f5053a.startScan();
        }
        return false;
    }

    /* renamed from: e */
    public boolean m16138e() {
        try {
            return String.valueOf(C1475bq.m16030a(this.f5053a, "startScanActive", new Object[0])).equals("true");
        } catch (Throwable th) {
            C1514cx.m15728a(th, "WifiManagerWrapper", "startScanActive");
            return false;
        }
    }

    /* renamed from: f */
    public boolean m16137f() {
        boolean z = false;
        WifiManager wifiManager = this.f5053a;
        if (wifiManager == null) {
            return false;
        }
        try {
            z = wifiManager.isWifiEnabled();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "WifiManagerWrapper", "wifiEnabled1");
        }
        if (z || C1477bs.m15990c() <= 17) {
            return z;
        }
        try {
            return String.valueOf(C1475bq.m16030a(wifiManager, "isScanAlwaysAvailable", new Object[0])).equals("true");
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "WifiManagerWrapper", "wifiEnabled");
            return z;
        }
    }
}
