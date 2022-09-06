package com.fimi.soul.module.login;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.fimi.kernel.p163c.C2241c;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.login.f */
/* loaded from: classes.dex */
public class C3389f {

    /* renamed from: a */
    public static final int f13209a = 1;

    /* renamed from: b */
    public static final int f13210b = 2;

    /* renamed from: c */
    public static final int f13211c = 3;

    /* renamed from: d */
    public static final int f13212d = 7;

    /* renamed from: e */
    public static final int f13213e = 8;

    /* renamed from: f */
    public static final int f13214f = 1314;

    /* renamed from: g */
    public static final int f13215g = 9;

    /* renamed from: h */
    public static final String f13216h = "DENY_REQUEST_EXTERNAL_STORAGE";

    /* renamed from: m */
    private static final int f13221m = 4;

    /* renamed from: n */
    private static final int f13222n = 5;

    /* renamed from: o */
    private static final int f13223o = 6;

    /* renamed from: i */
    public static String[] f13217i = {"android.permission.ACCESS_COARSE_LOCATION"};

    /* renamed from: j */
    public static String[] f13218j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: k */
    public static String[] f13219k = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};

    /* renamed from: l */
    public static String[] f13220l = {"android.permission.RECORD_AUDIO"};

    /* renamed from: p */
    private static String[] f13224p = {"android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: q */
    private static final String[] f13225q = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: r */
    private static List<String> f13226r = new ArrayList();

    /* renamed from: a */
    public static void m8531a(Activity activity) {
        if (!m8532a() && ActivityCompat.m8677a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* renamed from: a */
    public static boolean m8532a() {
        return C2241c.m13122a().m13110b(f13216h, false);
    }

    /* renamed from: a */
    private static boolean m8530a(Activity activity, String str) {
        return ActivityCompat.m8677a((Context) activity, str) == -1;
    }

    /* renamed from: a */
    public static boolean m8529a(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (m8530a(activity, str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static final boolean m8528a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return locationManager.isProviderEnabled(C3947a.f16908s) || locationManager.isProviderEnabled(GeocodeSearch.GPS);
        }
        return true;
    }

    /* renamed from: b */
    public static void m8527b() {
        C2241c.m13122a().mo13114a(f13216h, true);
    }

    /* renamed from: b */
    public static void m8526b(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2);
        }
    }

    /* renamed from: b */
    public static boolean m8525b(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m8524c(Activity activity) {
        return ActivityCompat.m8677a((Context) activity, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* renamed from: d */
    public static boolean m8523d(Activity activity) {
        return ActivityCompat.m8679a(activity, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* renamed from: e */
    public static void m8522e(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
        }
    }

    /* renamed from: f */
    public static void m8521f(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 3);
        }
    }

    /* renamed from: g */
    public static void m8520g(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.INTERNET") != 0) {
            ActivityCompat.m8678a(activity, f13224p, 1);
        }
    }

    /* renamed from: h */
    public static void m8519h(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.BLUETOOTH") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.BLUETOOTH"}, 5);
        }
    }

    /* renamed from: i */
    public static void m8518i(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.BLUETOOTH_ADMIN") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.BLUETOOTH_ADMIN"}, 6);
        }
    }

    /* renamed from: j */
    public static void m8517j(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.CAMERA") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.CAMERA"}, 7);
        }
    }

    /* renamed from: k */
    public static void m8516k(Activity activity) {
        if (ActivityCompat.m8677a((Context) activity, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.m8678a(activity, new String[]{"android.permission.RECORD_AUDIO"}, 8);
        }
    }

    /* renamed from: l */
    public static void m8515l(Activity activity) {
        String[] strArr;
        for (String str : f13225q) {
            if (ActivityCompat.m8677a((Context) activity, str) != 0) {
                f13226r.add(str);
            }
        }
        if (f13226r.size() > 0) {
            ActivityCompat.m8678a(activity, (String[]) f13226r.toArray(new String[f13226r.size()]), 9);
        }
    }
}
