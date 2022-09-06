package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4480b;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4797b;
import com.xiaomi.xmpush.thrift.C4807i;
import com.xiaomi.xmpush.thrift.C4812l;
import com.xiaomi.xmpush.thrift.C4814m;
import com.xiaomi.xmpush.thrift.C4830v;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/* renamed from: com.xiaomi.mipush.sdk.d */
/* loaded from: classes2.dex */
public class C4526d extends C4484f.AbstractRunnableC4485a {

    /* renamed from: g */
    private Context f18632g;

    /* renamed from: a */
    private final int f18626a = 30;

    /* renamed from: b */
    private final int f18627b = -1;

    /* renamed from: c */
    private final int f18628c = 3600;

    /* renamed from: d */
    private final String f18629d = MiPushClient.PREF_EXTRA;

    /* renamed from: e */
    private final String f18630e = "GeoFenceNetInfoUpdateJob";

    /* renamed from: f */
    private final String f18631f = "last_upload_lbs_data_timestamp";

    /* renamed from: h */
    private Comparator<ScanResult> f18633h = new C4527e(this);

    public C4526d(Context context) {
        this.f18632g = context;
    }

    /* renamed from: a */
    private Location m4878a(Location location, Location location2) {
        return location == null ? location2 : (location2 == null || location.getTime() > location2.getTime()) ? location : location2;
    }

    /* renamed from: a */
    private boolean m4879a(long j) {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f18632g.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).getLong("last_upload_lbs_data_timestamp", -1L)) / 1000 > j;
    }

    /* renamed from: c */
    private boolean m4876c() {
        if (C4497d.m4983f(this.f18632g)) {
            return true;
        }
        int m4397a = C4609ah.m4394a(this.f18632g).m4397a(EnumC4803e.UploadNOWIFIGeoLocFrequency.m3437a(), 3600);
        if (C4497d.m4982g(this.f18632g) && m4879a(m4397a)) {
            return true;
        }
        if (C4497d.m4981h(this.f18632g) && m4879a(m4397a)) {
            return true;
        }
        return C4497d.m4980i(this.f18632g) && m4879a((long) m4397a);
    }

    /* renamed from: d */
    private C4814m m4875d() {
        C4814m c4814m = new C4814m();
        c4814m.m3363a(m4874e());
        c4814m.m3360b(m4873f());
        c4814m.m3365a(m4872g());
        return c4814m;
    }

    /* renamed from: e */
    private List<C4830v> m4874e() {
        try {
            List<ScanResult> scanResults = ((WifiManager) this.f18632g.getSystemService("wifi")).getScanResults();
            if (C4480b.m5030a(scanResults)) {
                return null;
            }
            Collections.sort(scanResults, this.f18633h);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Math.min(30, scanResults.size()); i++) {
                ScanResult scanResult = scanResults.get(i);
                if (scanResult != null) {
                    C4830v c4830v = new C4830v();
                    c4830v.m3241a(TextUtils.isEmpty(scanResult.BSSID) ? "" : scanResult.BSSID);
                    c4830v.m3243a(scanResult.level);
                    c4830v.m3237b(scanResult.SSID);
                    arrayList.add(c4830v);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: f */
    private List<C4797b> m4873f() {
        try {
            List neighboringCellInfo = ((TelephonyManager) this.f18632g.getSystemService("phone")).getNeighboringCellInfo();
            int i = 0;
            ArrayList arrayList = null;
            while (i < neighboringCellInfo.size()) {
                NeighboringCellInfo neighboringCellInfo2 = (NeighboringCellInfo) neighboringCellInfo.get(i);
                ArrayList arrayList2 = new ArrayList();
                if (neighboringCellInfo2.getLac() > 0 || neighboringCellInfo2.getCid() > 0) {
                    C4797b c4797b = new C4797b();
                    c4797b.m3467a(neighboringCellInfo2.getCid());
                    c4797b.m3463b((neighboringCellInfo2.getRssi() * 2) - 113);
                    arrayList2.add(c4797b);
                }
                i++;
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: g */
    private C4807i m4872g() {
        Location m4871h;
        if (m4877b() && (m4871h = m4871h()) != null) {
            C4812l c4812l = new C4812l();
            c4812l.m3373b(m4871h.getLatitude());
            c4812l.m3377a(m4871h.getLongitude());
            C4807i c4807i = new C4807i();
            c4807i.m3430a(m4871h.getAccuracy());
            c4807i.m3427a(c4812l);
            c4807i.m3426a(m4871h.getProvider());
            c4807i.m3429a(new Date().getTime() - m4871h.getTime());
            return c4807i;
        }
        return null;
    }

    /* renamed from: h */
    private Location m4871h() {
        Location location;
        Location location2;
        Location location3;
        LocationManager locationManager = (LocationManager) this.f18632g.getSystemService("location");
        try {
            location = locationManager.getLastKnownLocation(C3947a.f16908s);
        } catch (Exception e) {
            location = null;
        }
        try {
            location2 = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
        } catch (Exception e2) {
            location2 = null;
        }
        try {
            location3 = locationManager.getLastKnownLocation("passive");
        } catch (Exception e3) {
            location3 = null;
        }
        return m4878a(location3, m4878a(location, location2));
    }

    /* renamed from: i */
    private void m4870i() {
        SharedPreferences.Editor edit = this.f18632g.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).edit();
        edit.putLong("last_upload_lbs_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4484f.AbstractRunnableC4485a
    /* renamed from: a */
    public int mo4276a() {
        return 14;
    }

    /* renamed from: b */
    protected boolean m4877b() {
        PackageManager packageManager = this.f18632g.getPackageManager();
        String packageName = this.f18632g.getPackageName();
        return (packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName) == 0) || (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!C4497d.m4984e(this.f18632g)) {
            AbstractC4478b.m5036d("GeoFenceNetInfoUpdateJobNetwork.is not Connected");
        } else if (!m4876c()) {
            AbstractC4478b.m5036d("GeoFenceNetInfoUpdateJobverifyUploadData");
        } else {
            byte[] m3471a = C4796aq.m3471a(m4875d());
            C4772ae c4772ae = new C4772ae("-1", false);
            c4772ae.m3695c(EnumC4818o.GeoUpdateLoc.f20376N);
            c4772ae.m3701a(m3471a);
            C4545u.m4818a(this.f18632g).m4807a(c4772ae, EnumC4763a.Notification, true, null);
            m4870i();
            AbstractC4478b.m5041a("GeoFenceNetInfoUpdateJob: update_loc_data");
        }
    }
}
