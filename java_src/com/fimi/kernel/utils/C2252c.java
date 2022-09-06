package com.fimi.kernel.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.fimi.kernel.p156a.C2175c;
import com.fimi.kernel.p156a.C2176d;
import com.fimi.kernel.p156a.C2178f;
import com.fimi.kernel.p156a.C2179g;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p007a.p019j.C0189k;
/* renamed from: com.fimi.kernel.utils.c */
/* loaded from: classes.dex */
public class C2252c {

    /* renamed from: a */
    public static List<String[]> f7514a = null;

    /* renamed from: a */
    public static int m13071a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.fimi.kernel.utils.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: a */
    public static C2178f m13070a(int i) {
        C2178f c2178f = new C2178f();
        if (f7514a == null) {
            f7514a = m13058c();
        }
        int size = f7514a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            String[] strArr = f7514a.get(i2);
            String str = strArr[0];
            if (str != null && Integer.parseInt(str) == i) {
                c2178f.f7315c = Integer.parseInt(strArr[0]);
                c2178f.f7317e = strArr[2];
                c2178f.f7318f = strArr[3];
                c2178f.f7319g = strArr[4];
                long j = 0;
                if (strArr[6].indexOf("M") != -1) {
                    j = Long.parseLong(strArr[6].replace("M", "")) * 1000 * FimiMediaMeta.AV_CH_SIDE_RIGHT;
                } else if (strArr[6].indexOf("K") != -1) {
                    j = Long.parseLong(strArr[6].replace("K", "")) * 1000;
                } else if (strArr[6].indexOf("G") != -1) {
                    j = Long.parseLong(strArr[6].replace("G", "")) * 1000 * FimiMediaMeta.AV_CH_SIDE_RIGHT * FimiMediaMeta.AV_CH_SIDE_RIGHT;
                }
                c2178f.f7316d = j;
                c2178f.f7313a = strArr[8];
                c2178f.f7314b = strArr[9];
            } else {
                i2++;
            }
        }
        return c2178f;
    }

    /* renamed from: a */
    public static C2179g m13064a(String str) {
        for (C2179g c2179g : m13062b()) {
            if (str.equals(c2179g.f7321b)) {
                return c2179g;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m13063a(String[] strArr, String str) {
        String str2;
        Exception e;
        byte[] bArr;
        C2266k.m12947a(C2252c.class, "#" + strArr);
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            if (str != null) {
                processBuilder.directory(new File(str));
            }
            processBuilder.redirectErrorStream(true);
            InputStream inputStream = processBuilder.start().getInputStream();
            str2 = "";
            while (inputStream.read(new byte[1024]) != -1) {
                try {
                    str2 = str2 + new String(bArr);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str2;
                }
            }
            inputStream.close();
        } catch (Exception e3) {
            str2 = "";
            e = e3;
        }
        return str2;
    }

    /* renamed from: a */
    public static void m13068a(Context context, int i, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        try {
            if (str.indexOf(":") != -1) {
                str = str.split(":")[0];
            }
            activityManager.killBackgroundProcesses(str);
            Method declaredMethod = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activityManager, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m13067a(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m13066a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static boolean m13069a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m13065a(Context context, String str, int i) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        InputStream inputStream2 = null;
        fileOutputStream2 = null;
        try {
            File file = new File("/data/data/" + context.getPackageName() + "/databases/" + str);
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                inputStream = context.getResources().openRawResource(i);
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    inputStream2 = inputStream;
                } catch (Exception e2) {
                    fileOutputStream2 = fileOutputStream;
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (inputStream == null) {
                        return false;
                    }
                    try {
                        inputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    fileOutputStream2 = fileOutputStream;
                    th = th2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } else {
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e7) {
                }
            }
            if (inputStream2 == null) {
                return true;
            }
            try {
                inputStream2.close();
                return true;
            } catch (Exception e8) {
                return true;
            }
        } catch (Exception e9) {
            e = e9;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    /* renamed from: b */
    public static C2178f m13059b(String str) {
        C2178f c2178f = new C2178f();
        if (f7514a == null) {
            f7514a = m13058c();
        }
        Iterator<String[]> it2 = f7514a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String[] next = it2.next();
            String str2 = next[9];
            if (str2 != null && str2.equals(str)) {
                c2178f.f7315c = Integer.parseInt(next[0]);
                c2178f.f7317e = next[2];
                c2178f.f7318f = next[3];
                c2178f.f7319g = next[4];
                long j = 0;
                if (next[6].indexOf("M") != -1) {
                    j = Long.parseLong(next[6].replace("M", "")) * 1000 * FimiMediaMeta.AV_CH_SIDE_RIGHT;
                } else if (next[6].indexOf("K") != -1) {
                    j = Long.parseLong(next[6].replace("K", "")) * 1000;
                } else if (next[6].indexOf("G") != -1) {
                    j = Long.parseLong(next[6].replace("G", "")) * 1000 * FimiMediaMeta.AV_CH_SIDE_RIGHT * FimiMediaMeta.AV_CH_SIDE_RIGHT;
                }
                c2178f.f7316d = j;
                c2178f.f7313a = next[8];
                c2178f.f7314b = next[9];
            }
        }
        if (c2178f.f7316d == 0) {
            C2266k.m12947a(C2252c.class, "##" + str + ",top -n 1未找到");
        }
        return c2178f;
    }

    /* renamed from: b */
    public static List<C2179g> m13062b() {
        new ArrayList();
        String[] split = m13055c("ps").split("\n");
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            C2179g c2179g = new C2179g(str);
            if (c2179g.f7320a != null) {
                arrayList.add(c2179g);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m13061b(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled(GeocodeSearch.GPS);
    }

    /* renamed from: b */
    public static boolean m13060b(Context context, String str) {
        boolean z = false;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            z = str.equals(runningServiceInfo.service.getClassName()) ? true : z;
        }
        return z;
    }

    /* renamed from: c */
    public static String m13055c(String str) {
        try {
            final Process exec = Runtime.getRuntime().exec(str);
            final StringBuilder sb = new StringBuilder();
            Thread thread = new Thread(new Runnable() { // from class: com.fimi.kernel.utils.c.2
                @Override // java.lang.Runnable
                public void run() {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                sb.append(readLine).append("\n");
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                try {
                                    return;
                                } catch (IOException e3) {
                                    return;
                                }
                            }
                        } finally {
                            try {
                                bufferedReader.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                    }
                }
            });
            thread.start();
            final StringBuilder sb2 = new StringBuilder();
            Thread thread2 = new Thread(new Runnable() { // from class: com.fimi.kernel.utils.c.3
                @Override // java.lang.Runnable
                public void run() {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()), 8192);
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                sb2.append(readLine).append("\n");
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                try {
                                    return;
                                } catch (IOException e3) {
                                    return;
                                }
                            }
                        } finally {
                            try {
                                bufferedReader.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                    }
                }
            });
            thread2.start();
            exec.waitFor();
            while (thread.isAlive()) {
                Thread.sleep(50L);
            }
            if (thread2.isAlive()) {
                thread2.interrupt();
            }
            String sb3 = sb.toString();
            return sb3 + sb2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static List<String[]> m13058c() {
        try {
            return m13051d(m13054d());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m13057c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    /* renamed from: c */
    public static boolean m13056c(Context context, String str) {
        Intent intent;
        try {
            intent = new Intent(context, Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            intent = null;
        }
        if (intent != null) {
            return context.stopService(intent);
        }
        return false;
    }

    /* renamed from: d */
    public static ApplicationInfo m13052d(Context context, String str) {
        if (str == null) {
            return null;
        }
        for (ApplicationInfo applicationInfo : context.getApplicationContext().getPackageManager().getInstalledApplications(8192)) {
            if (str.equals(applicationInfo.processName)) {
                return applicationInfo;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static DisplayMetrics m13053d(Context context) {
        return (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics();
    }

    /* renamed from: d */
    public static String m13054d() {
        try {
            return m13063a(new String[]{"/system/bin/top", "-n", "1"}, "/system/bin/");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static List<String[]> m13051d(String str) {
        String[] split;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("[\n]+")) {
            if (str2.indexOf("PID") != -1) {
                z = true;
            } else if (z) {
                String[] split2 = str2.trim().split("[ ]+");
                if (split2.length == 10 && !split2[9].startsWith("/system/bin/")) {
                    arrayList.add(split2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static C2176d m13050e() {
        try {
            return m13048e(m13054d());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static C2176d m13048e(String str) {
        String[] split;
        C2176d c2176d = new C2176d();
        for (String str2 : str.split("[\n]+")) {
            if (str2.indexOf("User") != -1 && str2.indexOf("System") != -1) {
                String[] split2 = str2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (int i = 0; i < split2.length; i++) {
                    String[] split3 = split2[i].trim().split(" ");
                    if (i == 0) {
                        c2176d.f7307a = split3[1];
                    } else if (i == 1) {
                        c2176d.f7308b = split3[1];
                    } else if (i == 2) {
                        c2176d.f7309c = split3[1];
                    } else if (i == 3) {
                        c2176d.f7310d = split3[1];
                    }
                }
            }
        }
        return c2176d;
    }

    /* renamed from: e */
    public static void m13049e(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    /* renamed from: f */
    public static void m13047f(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null || ((Activity) context).getCurrentFocus() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 2);
    }

    /* renamed from: g */
    public static PackageInfo m13046g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public static List<C2175c> m13045h(Context context) {
        Exception exc;
        ArrayList arrayList;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            ArrayList arrayList2 = new ArrayList();
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                m13046g(context);
                if (f7514a != null) {
                    f7514a.clear();
                }
                f7514a = m13058c();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    C2175c c2175c = new C2175c(runningAppProcessInfo.processName, runningAppProcessInfo.pid, runningAppProcessInfo.uid);
                    ApplicationInfo m13052d = m13052d(context, runningAppProcessInfo.processName);
                    if (m13052d != null) {
                        Drawable loadIcon = m13052d.loadIcon(packageManager);
                        String charSequence = m13052d.loadLabel(packageManager).toString();
                        c2175c.f7302e = loadIcon;
                        c2175c.f7298a = charSequence;
                    } else {
                        if (runningAppProcessInfo.processName.indexOf(":") != -1) {
                            c2175c.f7302e = m13052d(context, runningAppProcessInfo.processName.split(":")[0]).loadIcon(packageManager);
                        }
                        c2175c.f7298a = runningAppProcessInfo.processName;
                    }
                    C2178f m13059b = m13059b(runningAppProcessInfo.processName);
                    c2175c.f7303f = m13059b.f7316d;
                    c2175c.f7304g = m13059b.f7317e;
                    c2175c.f7305h = m13059b.f7318f;
                    c2175c.f7306i = m13059b.f7319g;
                    arrayList2.add(c2175c);
                }
                return arrayList2;
            } catch (Exception e) {
                arrayList = arrayList2;
                exc = e;
                exc.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            exc = e2;
            arrayList = null;
        }
    }

    /* renamed from: i */
    public static boolean m13044i(Context context) {
        Process process;
        DataOutputStream dataOutputStream = null;
        try {
            String str = "chmod 777 " + context.getPackageCodePath();
            process = Runtime.getRuntime().exec("su");
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(process.getOutputStream());
                try {
                    dataOutputStream2.writeBytes(str + "\n");
                    dataOutputStream2.writeBytes("exit\n");
                    dataOutputStream2.flush();
                    process.waitFor();
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    process.destroy();
                    return true;
                } catch (Exception e2) {
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    process.destroy();
                    return false;
                } catch (Throwable th) {
                    dataOutputStream = dataOutputStream2;
                    th = th;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    process.destroy();
                    throw th;
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
    }

    /* renamed from: j */
    public static long m13043j(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: k */
    public static long m13042k(Context context) {
        long j;
        Exception e;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                C2266k.m12947a(C2252c.class, split[i] + C0189k.f315b);
            }
            j = Integer.valueOf(split[1]).intValue() * 1024;
        } catch (Exception e2) {
            j = 0;
            e = e2;
        }
        try {
            bufferedReader.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return j;
        }
        return j;
    }
}
