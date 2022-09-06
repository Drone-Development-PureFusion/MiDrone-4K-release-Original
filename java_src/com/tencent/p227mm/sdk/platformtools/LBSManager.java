package com.tencent.p227mm.sdk.platformtools;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.p227mm.sdk.platformtools.MTimerHandler;
import com.tencent.p227mm.sdk.platformtools.PhoneUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.tencent.mm.sdk.platformtools.LBSManager */
/* loaded from: classes.dex */
public class LBSManager extends BroadcastReceiver {
    public static final String FILTER_GPS = "filter_gps";
    public static final int INVALID_ACC = -1000;
    public static final float INVALID_LAT = -1000.0f;
    public static final float INVALID_LNG = -1000.0f;
    public static final int MM_SOURCE_HARDWARE = 0;
    public static final int MM_SOURCE_NET = 1;
    public static final int MM_SOURCE_REPORT_HARWARE = 3;
    public static final int MM_SOURCE_REPORT_NETWORK = 4;

    /* renamed from: ab */
    private static LocationCache f17801ab;

    /* renamed from: R */
    private Context f17802R;

    /* renamed from: ac */
    private OnLocationGotListener f17803ac;

    /* renamed from: ad */
    private LocationManager f17804ad;

    /* renamed from: ae */
    private PendingIntent f17805ae;

    /* renamed from: af */
    private boolean f17806af = false;

    /* renamed from: ah */
    boolean f17808ah = false;

    /* renamed from: ai */
    boolean f17809ai = false;

    /* renamed from: ak */
    private MTimerHandler f17811ak = new MTimerHandler(new MTimerHandler.CallBack() { // from class: com.tencent.mm.sdk.platformtools.LBSManager.1
        @Override // com.tencent.p227mm.sdk.platformtools.MTimerHandler.CallBack
        public boolean onTimerExpired() {
            Log.m5641v("MicroMsg.LBSManager", "get location by GPS failed.");
            LBSManager.this.f17807ag = true;
            LBSManager.this.start();
            LBSManager.this.f17806af = false;
            return false;
        }
    }, false);

    /* renamed from: ag */
    boolean f17807ag = false;

    /* renamed from: aj */
    int f17810aj = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.sdk.platformtools.LBSManager$LocationCache */
    /* loaded from: classes.dex */
    public static class LocationCache {
        long time;

        /* renamed from: am */
        float f17814am = -1000.0f;

        /* renamed from: an */
        float f17815an = -1000.0f;

        /* renamed from: ao */
        int f17816ao = -1000;

        /* renamed from: I */
        int f17813I = 1;

        LocationCache() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.LBSManager$OnLocationGotListener */
    /* loaded from: classes.dex */
    public interface OnLocationGotListener {
        void onLocationGot(float f, float f2, int i, int i2, String str, String str2, boolean z);
    }

    public LBSManager(Context context, OnLocationGotListener onLocationGotListener) {
        this.f17803ac = onLocationGotListener;
        this.f17802R = context;
        PhoneUtil.getSignalStrength(context);
        this.f17804ad = (LocationManager) context.getSystemService("location");
        m5653b();
        this.f17805ae = PendingIntent.getBroadcast(context, 0, new Intent(FILTER_GPS), 134217728);
    }

    /* renamed from: b */
    private boolean m5653b() {
        if (this.f17804ad != null) {
            try {
                this.f17804ad.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                this.f17804ad.sendExtraCommand(GeocodeSearch.GPS, "force_time_injection", null);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m5652c() {
        this.f17811ak.stopTimer();
        this.f17807ag = true;
    }

    public static void setLocationCache(float f, float f2, int i, int i2) {
        if (i == 0) {
            return;
        }
        Log.m5641v("MicroMsg.LBSManager", "setLocationCache [" + f + Constants.ACCEPT_TIME_SEPARATOR_SP + f2 + "] acc:" + i + " source:" + i2);
        if (f17801ab == null) {
            f17801ab = new LocationCache();
        }
        f17801ab.f17814am = f;
        f17801ab.f17815an = f2;
        f17801ab.f17816ao = i;
        f17801ab.time = System.currentTimeMillis();
        f17801ab.f17813I = i2;
    }

    public String getTelLocation() {
        return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(this.f17802R));
    }

    public String getWIFILocation() {
        WifiManager wifiManager = (WifiManager) this.f17802R.getSystemService("wifi");
        if (wifiManager == null) {
            Log.m5647e("MicroMsg.LBSManager", "no wifi service");
            return "";
        } else if (wifiManager.getConnectionInfo() == null) {
            Log.m5647e("MicroMsg.LBSManager", "WIFILocation wifi info null");
            return "";
        } else {
            LinkedList linkedList = new LinkedList();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= scanResults.size()) {
                        break;
                    }
                    linkedList.add(new PhoneUtil.MacInfo(scanResults.get(i2).BSSID, new StringBuilder().append(scanResults.get(i2).level).toString()));
                    i = i2 + 1;
                }
            }
            return PhoneUtil.getMacXml(linkedList);
        }
    }

    public boolean isGpsEnable() {
        try {
            return this.f17804ad.isProviderEnabled(GeocodeSearch.GPS);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNetworkPrividerEnable() {
        try {
            return this.f17804ad.isProviderEnabled(C3947a.f16908s);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Location location = (Location) intent.getExtras().get("location");
        this.f17810aj++;
        if (location != null) {
            boolean equals = GeocodeSearch.GPS.equals(location.getProvider());
            if (((!equals || location.getAccuracy() > 200.0f) && (equals || location.getAccuracy() > 1000.0f)) || location.getAccuracy() <= 0.0f) {
                return;
            }
            int i = equals ? 0 : 1;
            setLocationCache((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), i);
            if (this.f17803ac == null) {
                return;
            }
            if (this.f17807ag && this.f17808ah && this.f17809ai) {
                return;
            }
            String nullAsNil = Util.nullAsNil(getWIFILocation());
            String nullAsNil2 = Util.nullAsNil(getTelLocation());
            if (!this.f17807ag) {
                m5652c();
                this.f17807ag = true;
                Log.m5641v("MicroMsg.LBSManager", "location by provider ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.f17810aj + " isGpsProvider:" + equals);
                this.f17803ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), i, nullAsNil, nullAsNil2, true);
            } else if (!this.f17808ah && i == 0) {
                this.f17808ah = true;
                Log.m5641v("MicroMsg.LBSManager", "report location by GPS ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.f17810aj + " isGpsProvider:" + equals);
                this.f17803ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), 3, nullAsNil, nullAsNil2, true);
            } else if (this.f17809ai || i != 1) {
            } else {
                this.f17809ai = true;
                Log.m5641v("MicroMsg.LBSManager", "report location by Network ok:[" + location.getLatitude() + " , " + location.getLongitude() + "]  accuracy:" + location.getAccuracy() + "  retry count:" + this.f17810aj + " isGpsProvider:" + equals);
                this.f17803ac.onLocationGot((float) location.getLatitude(), (float) location.getLongitude(), (int) location.getAccuracy(), 4, nullAsNil, nullAsNil2, true);
            }
        }
    }

    public void removeGpsUpdate() {
        Log.m5641v("MicroMsg.LBSManager", "removed gps update");
        if (this.f17804ad != null) {
            this.f17804ad.removeUpdates(this.f17805ae);
        }
        try {
            this.f17802R.unregisterReceiver(this);
        } catch (Exception e) {
            Log.m5641v("MicroMsg.LBSManager", "location receiver has already unregistered");
        }
    }

    public void removeListener() {
        Log.m5641v("MicroMsg.LBSManager", "removed gps update on destroy");
        removeGpsUpdate();
        if (this.f17811ak != null) {
            m5652c();
        }
        this.f17803ac = null;
        this.f17802R = null;
        this.f17811ak = null;
        this.f17804ad = null;
    }

    public void requestGpsUpdate() {
        if (isGpsEnable() || isNetworkPrividerEnable()) {
            Log.m5641v("MicroMsg.LBSManager", "requested gps update");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(FILTER_GPS);
            this.f17802R.registerReceiver(this, intentFilter);
            if (isGpsEnable()) {
                this.f17804ad.requestLocationUpdates(GeocodeSearch.GPS, 500L, 0.0f, this.f17805ae);
            }
            if (!isNetworkPrividerEnable()) {
                return;
            }
            this.f17804ad.requestLocationUpdates(C3947a.f16908s, 500L, 0.0f, this.f17805ae);
        }
    }

    public void start() {
        String nullAsNil = Util.nullAsNil(getWIFILocation());
        String nullAsNil2 = Util.nullAsNil(getTelLocation());
        if ((isGpsEnable() || isNetworkPrividerEnable()) && !this.f17806af) {
            this.f17806af = true;
            this.f17810aj = 0;
            requestGpsUpdate();
            this.f17811ak.startTimer(3000L);
            return;
        }
        if (f17801ab == null ? false : System.currentTimeMillis() - f17801ab.time <= 180000 && f17801ab.f17816ao > 0) {
            if (this.f17803ac == null) {
                return;
            }
            this.f17807ag = true;
            Log.m5641v("MicroMsg.LBSManager", "location by GPS cache ok:[" + f17801ab.f17814am + " , " + f17801ab.f17815an + "]  accuracy:" + f17801ab.f17816ao + " source:" + f17801ab.f17813I);
            this.f17803ac.onLocationGot(f17801ab.f17814am, f17801ab.f17815an, f17801ab.f17816ao, f17801ab.f17813I, nullAsNil, nullAsNil2, true);
            return;
        }
        this.f17807ag = true;
        if (!nullAsNil.equals("") || !nullAsNil2.equals("")) {
            Log.m5641v("MicroMsg.LBSManager", "get location by network ok, macs : " + nullAsNil + " cell ids :" + nullAsNil2);
            if (this.f17803ac == null) {
                return;
            }
            this.f17803ac.onLocationGot(-1000.0f, -1000.0f, -1000, 0, nullAsNil, nullAsNil2, true);
            return;
        }
        Log.m5641v("MicroMsg.LBSManager", "get location by network failed");
        if (this.f17803ac == null) {
            return;
        }
        this.f17803ac.onLocationGot(-1000.0f, -1000.0f, -1000, 0, "", "", false);
    }
}
