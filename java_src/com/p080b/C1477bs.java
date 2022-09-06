package com.p080b;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.fimi.soul.utils.C3686n;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Random;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0302d;
/* renamed from: com.b.bs */
/* loaded from: classes.dex */
public class C1477bs {

    /* renamed from: a */
    private static int f5168a = 0;

    /* renamed from: b */
    private static String[] f5169b = null;

    /* renamed from: c */
    private static Hashtable<String, Long> f5170c = new Hashtable<>();

    /* renamed from: d */
    private static DecimalFormat f5171d = null;

    /* renamed from: e */
    private static SimpleDateFormat f5172e = null;

    private C1477bs() {
    }

    /* renamed from: a */
    public static float m16005a(AmapLoc amapLoc, AmapLoc amapLoc2) {
        return m15998a(new double[]{amapLoc.m16520i(), amapLoc.m16522h(), amapLoc2.m16520i(), amapLoc2.m16522h()});
    }

    /* renamed from: a */
    public static float m15998a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    /* renamed from: a */
    public static int m16018a(int i) {
        return (i * 2) - 113;
    }

    /* renamed from: a */
    public static int m16017a(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    /* renamed from: a */
    public static int m16011a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static int m16009a(CellLocation cellLocation, Context context) {
        if (!m16013a(context) && cellLocation != null) {
            if (cellLocation instanceof GsmCellLocation) {
                return 1;
            }
            try {
                Class.forName("android.telephony.cdma.CdmaCellLocation");
                return 2;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "Utils", "getCellLocT");
                return 9;
            }
        }
        return 9;
    }

    /* renamed from: a */
    public static long m16020a() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    public static Object m16012a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "getServ");
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized String m16014a(long j, String str) {
        String format;
        synchronized (C1477bs.class) {
            if (TextUtils.isEmpty(str)) {
                str = "yyyy-MM-dd HH:mm:ss";
            }
            if (f5172e == null) {
                f5172e = new SimpleDateFormat(str, Locale.CHINA);
            } else {
                f5172e.applyPattern(str);
            }
            if (j <= 0) {
                j = m16020a();
            }
            format = f5172e == null ? AbstractC0302d.f567k : f5172e.format(Long.valueOf(j));
        }
        return format;
    }

    /* renamed from: a */
    public static String m16003a(Object obj, String str) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        if (f5171d == null) {
            f5171d = new DecimalFormat("#", decimalFormatSymbols);
        }
        f5171d.applyPattern(str);
        return f5171d.format(obj);
    }

    /* renamed from: a */
    public static String m16001a(String str, int i) {
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "str2Base64");
        }
        return Base64.encodeToString(bArr, i);
    }

    /* renamed from: a */
    public static boolean m16019a(double d) {
        return d <= 180.0d && d >= -180.0d;
    }

    /* renamed from: a */
    public static synchronized boolean m16015a(long j, long j2) {
        boolean z;
        synchronized (C1477bs.class) {
            z = false;
            if (f5172e == null) {
                f5172e = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            } else {
                f5172e.applyPattern("yyyyMMdd");
            }
            if (f5172e != null) {
                z = f5172e.format(Long.valueOf(j)).equals(f5172e.format(Long.valueOf(j2)));
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m16013a(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (m15990c() < 17) {
            try {
                return ((Integer) C1475bq.m16028a("android.provider.Settings$System", "getInt", new Object[]{contentResolver, ((String) C1475bq.m16029a("android.provider.Settings$System", "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "Utils", "airPlaneModeOn part");
                return false;
            }
        }
        try {
            if (((Integer) C1475bq.m16028a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, ((String) C1475bq.m16029a("android.provider.Settings$Global", "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() != 1) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "Utils", "airPlaneModeOn");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m16010a(ScanResult scanResult) {
        return scanResult != null && !TextUtils.isEmpty(scanResult.BSSID) && !scanResult.BSSID.equals("00:00:00:00:00:00") && !scanResult.BSSID.contains(" :");
    }

    /* renamed from: a */
    public static boolean m16007a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            double longitude = aMapLocation.getLongitude();
            double latitude = aMapLocation.getLatitude();
            return !(longitude == 0.0d && latitude == 0.0d && ((double) aMapLocation.getAccuracy()) == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16006a(AmapLoc amapLoc) {
        if (amapLoc != null && !amapLoc.m16512m().equals(C3686n.f15084m) && !amapLoc.m16512m().equals("5") && !amapLoc.m16512m().equals("6")) {
            double m16522h = amapLoc.m16522h();
            double m16520i = amapLoc.m16520i();
            return !(m16522h == 0.0d && m16520i == 0.0d && ((double) amapLoc.m16518j()) == 0.0d) && m16522h <= 180.0d && m16520i <= 90.0d && m16522h >= -180.0d && m16520i >= -90.0d;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16002a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            return ",111,123,134,199,202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,560,598,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,665,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,850,901,".contains(Constants.ACCEPT_TIME_SEPARATOR_SP + str + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16000a(JSONObject jSONObject, String str) {
        return C1552dw.m15557a(jSONObject, str);
    }

    /* renamed from: a */
    public static byte[] m16016a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((j >> (i * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static final byte[] m16004a(File file) {
        if (file == null || !file.exists()) {
            throw new IOException("can't operate on null");
        }
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                fileInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static byte[] m15999a(byte[] bArr) {
        try {
            return C1552dw.m15556a(bArr);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "gz");
            return null;
        }
    }

    /* renamed from: a */
    public static String[] m16008a(TelephonyManager telephonyManager) {
        int i;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = {"0", "0"};
        if (TextUtils.isEmpty(str) ? false : !TextUtils.isDigitsOnly(str) ? false : str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] charArray = str.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr[1] = str.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr[0] = "0";
        }
        if (strArr[0].equals("0") || strArr[1].equals("0")) {
            return (!strArr[0].equals("0") || !strArr[1].equals("0") || f5169b == null) ? strArr : f5169b;
        }
        f5169b = strArr;
        return strArr;
    }

    /* renamed from: b */
    public static long m15997b() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public static final long m15991b(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        }
        return j;
    }

    /* renamed from: b */
    public static String m15994b(Context context) {
        PackageInfo packageInfo;
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(C1514cx.f5416k)) {
            return C1514cx.f5416k;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 64);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(C1514cx.f5417l)) {
                C1514cx.f5417l = null;
            }
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        if (!TextUtils.isEmpty(C1514cx.f5413h)) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(C1514cx.f5413h);
        }
        if (!TextUtils.isEmpty(C1514cx.f5417l)) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(C1514cx.f5417l);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m15993b(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return C1514cx.f5423r.get(i, "UNKWN");
    }

    /* renamed from: b */
    public static boolean m15996b(double d) {
        return d <= 90.0d && d >= -90.0d;
    }

    /* renamed from: b */
    public static byte[] m15995b(int i) {
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m15992b(String str) {
        byte[] bArr = new byte[6];
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            bArr[i] = (byte) Integer.parseInt(split[i], 16);
        }
        return bArr;
    }

    /* renamed from: c */
    public static int m15990c() {
        if (f5168a > 0) {
            return f5168a;
        }
        try {
            return C1475bq.m16026b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable th) {
            try {
                return Integer.parseInt(C1475bq.m16029a("android.os.Build$VERSION", "SDK").toString());
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, "Utils", "getSdk");
                return 0;
            }
        }
    }

    /* renamed from: c */
    public static final int m15986c(byte[] bArr) {
        return ((bArr[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: c */
    public static NetworkInfo m15988c(Context context) {
        try {
            return C1542dq.m15618n(context);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    /* renamed from: c */
    public static String m15987c(String str) {
        return m16001a(str, 0);
    }

    /* renamed from: c */
    public static byte[] m15989c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: d */
    public static final int m15982d(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        }
        return i;
    }

    /* renamed from: d */
    public static String m15985d() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /* renamed from: d */
    public static String m15983d(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "base642Str");
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m15984d(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance != 100;
                }
            }
            return false;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    /* renamed from: e */
    public static String m15981e() {
        StringBuilder sb = new StringBuilder();
        sb.append(m15985d()).append(File.separator);
        sb.append("amaplocationapi").append(File.separator);
        return sb.toString();
    }

    /* renamed from: e */
    public static byte[] m15980e(String str) {
        return m15995b(Integer.parseInt(str));
    }

    /* renamed from: f */
    public static String m15979f() {
        return Build.MODEL;
    }

    /* renamed from: f */
    public static byte[] m15978f(String str) {
        return m15989c(Integer.parseInt(str));
    }

    /* renamed from: g */
    public static String m15977g() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: h */
    public static boolean m15976h() {
        return m16017a(0, 1) == 1;
    }

    /* renamed from: i */
    public static void m15975i() {
        f5170c.clear();
    }

    /* renamed from: j */
    public static String m15974j() {
        try {
            return C1544dr.m15602b(C1514cx.f5411f.getBytes("UTF-8")).substring(20);
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: k */
    public static boolean m15973k() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
