package com.tencent.stat.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.tencent.stat.StatConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.common.k */
/* loaded from: classes2.dex */
public class C4420k {

    /* renamed from: a */
    private static String f18456a = null;

    /* renamed from: b */
    private static String f18457b = null;

    /* renamed from: c */
    private static String f18458c = null;

    /* renamed from: d */
    private static String f18459d = null;

    /* renamed from: e */
    private static Random f18460e = null;

    /* renamed from: f */
    private static StatLogger f18461f = null;

    /* renamed from: g */
    private static String f18462g = null;

    /* renamed from: h */
    private static C4421l f18463h = null;

    /* renamed from: i */
    private static C4423n f18464i = null;

    /* renamed from: j */
    private static String f18465j = "__MTA_FIRST_ACTIVATE__";

    /* renamed from: k */
    private static int f18466k = -1;

    /* renamed from: A */
    public static String m5212A(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sensorList.size(); i++) {
                    sb.append(sensorList.get(i).getType());
                    if (i != sensorList.size() - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                return sb.toString();
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return "";
    }

    /* renamed from: B */
    public static WifiInfo m5211B(Context context) {
        WifiManager wifiManager;
        if (!m5202a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    /* renamed from: C */
    public static String m5210C(Context context) {
        try {
            WifiInfo m5211B = m5211B(context);
            if (m5211B != null) {
                return m5211B.getBSSID();
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return null;
    }

    /* renamed from: D */
    public static String m5209D(Context context) {
        try {
            WifiInfo m5211B = m5211B(context);
            if (m5211B != null) {
                return m5211B.getSSID();
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return null;
    }

    /* renamed from: E */
    public static synchronized int m5208E(Context context) {
        int i;
        synchronized (C4420k.class) {
            if (f18466k != -1) {
                i = f18466k;
            } else {
                m5207F(context);
                i = f18466k;
            }
        }
        return i;
    }

    /* renamed from: F */
    public static void m5207F(Context context) {
        f18466k = C4425p.m5154a(context, f18465j, 1);
        f18461f.m5236e(Integer.valueOf(f18466k));
        if (f18466k == 1) {
            C4425p.m5151b(context, f18465j, 0);
        }
    }

    /* renamed from: G */
    private static long m5206G(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static int m5205a() {
        return m5181h().nextInt(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static Long m5200a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long l2 = 0L;
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf = Long.valueOf(i * (l2.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                l2 = valueOf;
            }
            return l2;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    /* renamed from: a */
    public static String m5204a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    /* renamed from: a */
    public static String m5201a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:10:0x0004). Please submit an issue!!! */
    /* renamed from: a */
    public static HttpHost m5203a(Context context) {
        HttpHost httpHost;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            httpHost = null;
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                httpHost = null;
            } else if (activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    httpHost = null;
                } else if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                    httpHost = new HttpHost("10.0.0.172", 80);
                } else {
                    if (extraInfo.equals("ctwap")) {
                        httpHost = new HttpHost("10.0.0.200", 80);
                    }
                    httpHost = null;
                }
            } else {
                httpHost = null;
            }
        }
        return httpHost;
    }

    /* renamed from: a */
    public static void m5199a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() <= 0) {
                    return;
                }
                jSONObject.put(str, str2);
            } catch (Throwable th) {
                f18461f.m5236e(th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m5202a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            f18461f.m5236e(th);
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m5198a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    /* renamed from: b */
    public static long m5194b(String str) {
        return m5200a(str, ".", 100, 3, 0L).longValue();
    }

    /* renamed from: b */
    public static synchronized StatLogger m5197b() {
        StatLogger statLogger;
        synchronized (C4420k.class) {
            if (f18461f == null) {
                f18461f = new StatLogger("MtaSDK");
                f18461f.setDebugEnable(false);
            }
            statLogger = f18461f;
        }
        return statLogger;
    }

    /* renamed from: b */
    public static synchronized String m5196b(Context context) {
        String str;
        synchronized (C4420k.class) {
            if (f18456a == null || f18456a.trim().length() == 0) {
                f18456a = m5175l(context);
                if (f18456a == null || f18456a.trim().length() == 0) {
                    f18456a = Integer.toString(m5181h().nextInt(Integer.MAX_VALUE));
                }
                str = f18456a;
            } else {
                str = f18456a;
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m5195b(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (f18462g == null) {
                f18462g = m5166u(context);
            }
            return f18462g != null ? str + "_" + f18462g : str;
        }
        return str;
    }

    /* renamed from: c */
    public static long m5193c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() + Util.MILLSECONDS_OF_DAY;
        } catch (Throwable th) {
            f18461f.m5236e(th);
            return System.currentTimeMillis() + Util.MILLSECONDS_OF_DAY;
        }
    }

    /* renamed from: c */
    public static synchronized String m5192c(Context context) {
        String str;
        synchronized (C4420k.class) {
            if (f18458c == null || "" == f18458c) {
                f18458c = m5184f(context);
            }
            str = f18458c;
        }
        return str;
    }

    /* renamed from: c */
    public static String m5191c(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C4416g.m5216b(C4414e.m5226a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            f18461f.m5236e(th);
            return str;
        }
    }

    /* renamed from: d */
    public static int m5190d() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: d */
    public static DisplayMetrics m5189d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: d */
    public static String m5188d(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C4414e.m5224b(C4416g.m5218a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            f18461f.m5236e(th);
            return str;
        }
    }

    /* renamed from: e */
    public static String m5187e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + "/" + String.valueOf(m5185f() / 1000000);
    }

    /* renamed from: e */
    public static boolean m5186e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        if (!m5202a(context, "android.permission.ACCESS_WIFI_STATE")) {
            f18461f.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public static long m5185f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    /* renamed from: f */
    public static String m5184f(Context context) {
        if (!m5202a(context, "android.permission.ACCESS_WIFI_STATE")) {
            f18461f.m5236e("Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            f18461f.m5237e(e);
            return "";
        }
    }

    /* renamed from: g */
    public static boolean m5182g(Context context) {
        try {
            if (!m5202a(context, "android.permission.INTERNET") || !m5202a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                f18461f.warn("can not get the permisson of android.permission.INTERNET");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
                }
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return false;
    }

    /* renamed from: h */
    private static synchronized Random m5181h() {
        Random random;
        synchronized (C4420k.class) {
            if (f18460e == null) {
                f18460e = new Random();
            }
            random = f18460e;
        }
        return random;
    }

    /* renamed from: h */
    public static boolean m5180h(Context context) {
        try {
            if (!m5202a(context, "android.permission.INTERNET") || !m5202a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                f18461f.warn("can not get the permisson of android.permission.INTERNET");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    f18461f.m5233w("Network error");
                    return false;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* renamed from: i */
    private static long m5179i() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
            return j;
        } catch (IOException e) {
            return j;
        }
    }

    /* renamed from: i */
    public static String m5178i(Context context) {
        if (f18457b != null) {
            return f18457b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f18457b = string;
                    return string;
                }
                f18461f.m5233w("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f18461f.m5233w("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: j */
    public static String m5177j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f18461f.m5233w("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f18461f.m5236e("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: k */
    public static String m5176k(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    /* renamed from: l */
    public static String m5175l(Context context) {
        try {
            if (m5202a(context, "android.permission.READ_PHONE_STATE")) {
                String str = "";
                if (m5172o(context)) {
                    str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                }
                if (str != null) {
                    return str;
                }
            } else {
                f18461f.m5236e("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return null;
    }

    /* renamed from: m */
    public static String m5174m(Context context) {
        try {
            if (!m5202a(context, "android.permission.READ_PHONE_STATE")) {
                f18461f.m5236e("Could not get permission of android.permission.READ_PHONE_STATE");
                return null;
            } else if (!m5172o(context)) {
                return null;
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? telephonyManager.getSimOperator() : null;
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0020
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: n */
    public static java.lang.String m5173n(android.content.Context r5) {
        /*
            java.lang.String r1 = ""
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L16
            r3 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r2, r3)     // Catch: java.lang.Throwable -> L16
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L15
            java.lang.String r0 = ""
        L15:
            return r0
        L16:
            r0 = move-exception
            r4 = r0
            r0 = r1
            r1 = r4
        L1a:
            com.tencent.stat.common.StatLogger r2 = com.tencent.stat.common.C4420k.f18461f
            r2.m5236e(r1)
            goto L15
        L20:
            r1 = move-exception
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C4420k.m5173n(android.content.Context):java.lang.String");
    }

    /* renamed from: o */
    public static boolean m5172o(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    /* renamed from: p */
    public static String m5171p(Context context) {
        try {
            if (!m5202a(context, "android.permission.INTERNET") || !m5202a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                f18461f.m5236e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        return typeName.equalsIgnoreCase("WIFI") ? "WIFI" : typeName.equalsIgnoreCase("MOBILE") ? extraInfo == null ? "MOBILE" : extraInfo : extraInfo == null ? typeName : extraInfo;
                    }
                }
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return null;
    }

    /* renamed from: q */
    public static Integer m5170q(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: r */
    public static String m5169r(Context context) {
        String str;
        Throwable th;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    f18461f.m5236e(th);
                    return str;
                }
            }
            return "unknown";
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
    }

    /* renamed from: s */
    public static int m5168s(Context context) {
        try {
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return C4424o.m5156a() ? 1 : 0;
    }

    /* renamed from: t */
    public static String m5167t(Context context) {
        String path;
        String str = null;
        try {
            if (m5202a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
                    StatFs statFs = new StatFs(path);
                    str = String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
                }
            } else {
                f18461f.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            }
        } catch (Throwable th) {
            f18461f.m5236e(th);
        }
        return str;
    }

    /* renamed from: u */
    static String m5166u(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: v */
    public static String m5165v(Context context) {
        return m5195b(context, StatConstants.f18409a);
    }

    /* renamed from: w */
    public static synchronized Integer m5164w(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (C4420k.class) {
            int m5154a = C4425p.m5154a(context, "MTA_EVENT_INDEX", 0);
            if (m5154a < 2147483646) {
                i = m5154a;
            }
            C4425p.m5151b(context, "MTA_EVENT_INDEX", i + 1);
            valueOf = Integer.valueOf(i + 1);
        }
        return valueOf;
    }

    /* renamed from: x */
    public static String m5163x(Context context) {
        return String.valueOf(m5206G(context) / 1000000) + "/" + String.valueOf(m5179i() / 1000000);
    }

    /* renamed from: y */
    public static synchronized C4421l m5162y(Context context) {
        C4421l c4421l;
        synchronized (C4420k.class) {
            if (f18463h == null) {
                f18463h = new C4421l();
            }
            c4421l = f18463h;
        }
        return c4421l;
    }

    /* renamed from: z */
    public static JSONObject m5161z(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            m5162y(context);
            int m5159b = C4421l.m5159b();
            if (m5159b > 0) {
                jSONObject.put("fx", m5159b / 1000000);
            }
            m5162y(context);
            int m5158c = C4421l.m5158c();
            if (m5158c > 0) {
                jSONObject.put("fn", m5158c / 1000000);
            }
            m5162y(context);
            int m5160a = C4421l.m5160a();
            if (m5160a > 0) {
                jSONObject.put("n", m5160a);
            }
            m5162y(context);
            String m5157d = C4421l.m5157d();
            if (m5157d != null && m5157d.length() == 0) {
                m5162y(context);
                jSONObject.put("na", C4421l.m5157d());
            }
        } catch (Exception e) {
            f18461f.m5237e(e);
        }
        return jSONObject;
    }
}
