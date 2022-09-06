package com.fimi.soul.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.fimi.soul.module.login.LoginActivity;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.fimi.soul.utils.ar */
/* loaded from: classes.dex */
public class C3658ar {

    /* renamed from: a */
    private static Typeface f14851a = null;

    /* renamed from: b */
    private static Typeface f14852b = null;

    /* renamed from: c */
    private static MediaPlayer f14853c = null;

    /* renamed from: d */
    private static MediaPlayer f14854d = null;

    /* renamed from: e */
    private static MediaPlayer f14855e = null;

    /* renamed from: a */
    public static int m7622a(byte b) {
        return (b >> 4) & 15;
    }

    /* renamed from: a */
    public static int m7621a(int i, int i2) {
        return Math.abs(((1 << i2) & i) >> i2);
    }

    /* renamed from: a */
    public static Bitmap m7611a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: a */
    public static Typeface m7615a(AssetManager assetManager) {
        if (f14851a == null) {
            f14851a = Typeface.createFromAsset(assetManager, "lanting.TTF");
        }
        return f14851a;
    }

    /* renamed from: a */
    public static String m7623a() {
        return Build.MODEL;
    }

    /* renamed from: a */
    public static String m7620a(long j) {
        return new SimpleDateFormat(C2353b.f7954l).format(new Date(j));
    }

    /* renamed from: a */
    public static String m7619a(Context context) {
        return "" + Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: a */
    public static String m7618a(Context context, Bitmap bitmap) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, (String) null, (String) null)), new String[]{"_data"}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                String string = query.getString(columnIndexOrThrow);
                if (query == null) {
                    return string;
                }
                query.close();
                return string;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static String m7616a(Context context, String str) {
        String str2 = "";
        try {
            str2 = String.valueOf(context.getPackageManager().getPackageArchiveInfo(str, 2).versionName);
        } catch (Exception e) {
        }
        C2353b.m12509a("findAppVersionName version=" + str2, C3658ar.class);
        return str2;
    }

    /* renamed from: a */
    public static String m7607a(String str) {
        return TextUtils.isEmpty(str) ? str : m7620a(Long.parseLong(str));
    }

    /* renamed from: a */
    public static void m7614a(AssetManager assetManager, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getClass().equals(TextView.class)) {
                    m7612a(assetManager, childAt);
                }
                m7614a(assetManager, childAt);
            }
        }
    }

    /* renamed from: a */
    public static void m7613a(AssetManager assetManager, ViewGroup viewGroup) {
        if (f14851a == null) {
            f14851a = Typeface.createFromAsset(assetManager, "lanting.TTF");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof Button) {
                    ((Button) childAt).setTypeface(f14851a);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(f14851a);
                } else if (childAt instanceof EditText) {
                    ((EditText) childAt).setTypeface(f14851a);
                } else if (childAt instanceof ViewGroup) {
                    m7613a(assetManager, (ViewGroup) childAt);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m7612a(AssetManager assetManager, View... viewArr) {
        if (f14851a == null) {
            f14851a = Typeface.createFromAsset(assetManager, "lanting.TTF");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view instanceof Button) {
                    ((Button) view).setTypeface(f14851a);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTypeface(f14851a);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(f14851a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m7609a(TextView textView) {
        textView.getPaint().setFakeBoldText(true);
    }

    /* renamed from: a */
    public static boolean m7617a(Context context, Class cls) {
        ComponentName resolveActivity = new Intent(context, cls).resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
                if (runningTaskInfo.baseActivity.equals(resolveActivity)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7610a(Bitmap bitmap, String str) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, false));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m7608a(File file) {
        if (file != null) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            file.renameTo(file2);
            return file2.delete();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7606a(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.getName().equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7605a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m7603b(byte b) {
        return b & 15;
    }

    /* renamed from: b */
    public static Typeface m7599b(AssetManager assetManager) {
        if (f14852b == null) {
            f14852b = Typeface.createFromAsset(assetManager, "DIN Alternate Bold.ttf");
        }
        return f14852b;
    }

    /* renamed from: b */
    public static String m7604b() {
        return Build.MANUFACTURER;
    }

    /* renamed from: b */
    public static String m7602b(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    /* renamed from: b */
    public static String m7596b(String str) {
        return TextUtils.isEmpty(str) ? str : m7602b(Long.parseLong(str));
    }

    /* renamed from: b */
    public static void m7598b(AssetManager assetManager, View... viewArr) {
        if (f14852b == null) {
            f14852b = Typeface.createFromAsset(assetManager, "DIN Alternate Bold.ttf");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view instanceof Button) {
                    ((Button) view).setTypeface(f14852b);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTypeface(f14852b);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(f14852b);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m7597b(File file) {
        if (file.isFile()) {
            m7608a(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                m7608a(file);
                return;
            }
            for (File file2 : listFiles) {
                m7597b(file2);
            }
            m7608a(file);
        }
    }

    /* renamed from: b */
    public static boolean m7601b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7600b(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(50)) {
            if (runningServiceInfo.service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static WifiDistanceFile m7591c(String str) {
        String replace;
        if (str != null) {
            HashMap hashMap = new HashMap();
            String str2 = "/media";
            WifiDistanceFile wifiDistanceFile = new WifiDistanceFile(str2);
            wifiDistanceFile.setType(0);
            wifiDistanceFile.setParentStrDir("/");
            hashMap.put(str2, wifiDistanceFile);
            String[] split = str.split("\n");
            int i = 0;
            while (i < split.length) {
                String str3 = split[i];
                C2353b.m12509a("line=" + str3, C3658ar.class);
                String[] m7577g = m7577g(str3);
                if (m7577g.length <= 1 || str3.startsWith("/")) {
                    replace = "/media/:".equalsIgnoreCase(str3) ? "/media" : str3.replace(":", "");
                } else {
                    WifiDistanceFile wifiDistanceFile2 = new WifiDistanceFile(m7577g[2]);
                    wifiDistanceFile2.setSize(Long.parseLong(m7577g[1]));
                    wifiDistanceFile2.setParentStrDir(str2);
                    if (m7577g[0].startsWith(C0477f.f1054a)) {
                        wifiDistanceFile.setType(0);
                        hashMap.put(str2 + "/" + m7577g[2], wifiDistanceFile2);
                    } else {
                        wifiDistanceFile.setType(0);
                    }
                    WifiDistanceFile wifiDistanceFile3 = (WifiDistanceFile) hashMap.get(str2);
                    if (wifiDistanceFile3 != null) {
                        wifiDistanceFile3.addFile(wifiDistanceFile2);
                        wifiDistanceFile2.setParentDir(wifiDistanceFile3);
                    } else {
                        wifiDistanceFile2.setParentDir(null);
                    }
                    replace = str2;
                }
                i++;
                str2 = replace;
            }
            return wifiDistanceFile;
        }
        return null;
    }

    /* renamed from: c */
    public static String m7595c() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    /* renamed from: c */
    public static String m7594c(long j) {
        if (j == 0) {
            return "0.00B";
        }
        new DecimalFormat("#.00");
        return j < FimiMediaMeta.AV_CH_SIDE_RIGHT ? C2275t.m12790b(j, 2) + "B" : j < 1048576 ? C2275t.m12790b(j / 1024.0d, 2) + "KB" : j < FimiMediaMeta.AV_CH_STEREO_RIGHT ? C2275t.m12790b(j / 1048576.0d, 2) + "MB" : C2275t.m12790b(j / 1.073741824E9d, 2) + "GB";
    }

    /* renamed from: c */
    public static boolean m7593c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
    }

    /* renamed from: c */
    public static boolean m7592c(Context context, String str) {
        boolean z = false;
        AssetManager assets = context.getAssets();
        if (str == null) {
            return false;
        }
        try {
            String[] list = assets.list("");
            for (String str2 : list) {
                if (str2.equals(str.trim())) {
                    System.out.println(str + "文件存在！！！！");
                    z = true;
                    return true;
                }
                System.out.println(str + "不存在啦！！！！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("不存在！");
        return z;
    }

    /* renamed from: d */
    public static String m7590d() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: d */
    public static String m7589d(Context context) {
        String str = "";
        try {
            str = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception e) {
        }
        C2353b.m12509a("findAppVersionName version=" + str, C3658ar.class);
        return str;
    }

    /* renamed from: d */
    public static boolean m7588d(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m7587d(String str) {
        boolean z = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ping -c 1 -W 1 " + str);
            if (process.waitFor() == 0) {
                z = true;
            }
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e) {
            if (process != null) {
                process.destroy();
            }
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
        return z;
    }

    /* renamed from: e */
    public static String m7585e(Context context) {
        String str = "";
        try {
            str = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
        }
        C2353b.m12509a("findAppVersionName versionCode=" + str, C3658ar.class);
        return str;
    }

    /* renamed from: e */
    public static boolean m7586e() {
        try {
            return Runtime.getRuntime().exec("ping -c 1 -w 100 www.baidu.com").waitFor() == 0;
        } catch (IOException e) {
            return false;
        } catch (InterruptedException e2) {
            return false;
        } catch (UnknownHostException e3) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m7584e(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            if (runningAppProcesses.get(i).processName.equals(str)) {
                Log.i("NotificationLaunch", String.format("the %s is running, isAppAlive return true", str));
                return true;
            }
        }
        Log.i("NotificationLaunch", String.format("the %s is not running, isAppAlive return false", str));
        return false;
    }

    /* renamed from: e */
    public static boolean m7583e(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* renamed from: f */
    public static String m7581f(Context context) {
        int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
    }

    /* renamed from: f */
    public static String m7580f(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyy-MMM-dd_HH:mm:ss", Locale.ENGLISH).parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m7582f() {
        try {
            return InetAddress.getByName("192.168.100.1").isReachable(50);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: g */
    public static void m7578g(Context context) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            C2353b.m12509a("error : ", C3658ar.class);
        }
        ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000, PendingIntent.getActivity(context, 0, new Intent(context.getApplicationContext(), LoginActivity.class), 268435456));
    }

    /* renamed from: g */
    private static String[] m7577g(String str) {
        String[] strArr = new String[3];
        String[] split = str.split(" ");
        if (split.length > 9) {
            String str2 = "";
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!"".equalsIgnoreCase(split[i2])) {
                    i++;
                    if (i == 1) {
                        strArr[0] = split[i2];
                    } else if (i == 5) {
                        strArr[1] = split[i2];
                    } else if (i >= 9) {
                        str2 = "".equalsIgnoreCase(str2) ? str2 + split[i2] : str2 + " " + split[i2];
                    }
                }
            }
            strArr[2] = str2;
            return strArr;
        }
        return split;
    }

    /* renamed from: h */
    public static Boolean m7575h(Context context) {
        String[] strArr;
        String[] strArr2;
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Method[] declaredMethods = connectivityManager.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                strArr = null;
                break;
            }
            Method method = declaredMethods[i];
            if (method.getName().equals("getTetheredIfaces")) {
                try {
                    strArr = (String[]) method.invoke(connectivityManager, new Object[0]);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
            i++;
        }
        int length2 = declaredMethods.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                strArr2 = null;
                break;
            }
            Method method2 = declaredMethods[i2];
            if (method2.getName().equals("getTetherableUsbRegexs")) {
                try {
                    strArr2 = (String[]) method2.invoke(connectivityManager, new Object[0]);
                    break;
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
            }
            i2++;
        }
        if (strArr == null) {
            return true;
        }
        if (strArr2 != null) {
            z = false;
            for (String str : strArr) {
                int length3 = strArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length3) {
                        break;
                    } else if (str.matches(strArr2[i3])) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: i */
    public static boolean m7573i(Context context) {
        String packageName = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
        return !TextUtils.isEmpty(packageName) && packageName.equals(context.getPackageName());
    }

    /* renamed from: j */
    public static void m7572j(Context context) {
        f14853c = MediaPlayer.create(context, (int) C2300R.raw.video_record_end);
        f14853c.setVolume(1.0f, 1.0f);
        f14854d = MediaPlayer.create(context, (int) C2300R.raw.video_record_start);
        f14854d.setVolume(1.0f, 1.0f);
        f14855e = MediaPlayer.create(context, (int) C2300R.raw.camera_click);
        f14855e.setVolume(1.0f, 1.0f);
    }

    /* renamed from: k */
    public static void m7571k(Context context) {
        if (f14853c != null) {
            C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.utils.ar.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!C3658ar.f14853c.isPlaying()) {
                        C3658ar.f14853c.start();
                    }
                }
            });
        }
    }

    /* renamed from: l */
    public static void m7570l(Context context) {
        if (f14854d != null) {
            C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.utils.ar.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!C3658ar.f14854d.isPlaying()) {
                        C3658ar.f14854d.start();
                    }
                }
            });
        }
    }

    /* renamed from: m */
    public static void m7569m(Context context) {
        if (f14855e != null) {
            C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.utils.ar.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!C3658ar.f14855e.isPlaying()) {
                        C3658ar.f14855e.start();
                    }
                }
            });
        }
    }

    /* renamed from: n */
    public static String m7568n(Context context) {
        return "/data/data/" + context.getPackageName() + "/databases/NoFlyZone-V1.0.0-DB.sqlite";
    }

    /* renamed from: o */
    public static boolean m7567o(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled(GeocodeSearch.GPS) || locationManager.isProviderEnabled(C3947a.f16908s);
    }

    /* renamed from: p */
    public static boolean m7566p(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: q */
    public static boolean m7565q(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance != 100;
                }
            }
        }
        return false;
    }

    /* renamed from: r */
    public static PackageInfo m7564r(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
