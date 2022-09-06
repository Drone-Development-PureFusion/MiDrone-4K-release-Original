package com.tencent.p227mm.sdk.platformtools;

import android.os.Build;
import android.widget.Toast;
import com.tencent.p227mm.algorithm.MD5;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
/* renamed from: com.tencent.mm.sdk.platformtools.Log */
/* loaded from: classes.dex */
public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;

    /* renamed from: ar */
    private static PrintStream f17819ar;

    /* renamed from: at */
    private static final String f17821at;
    private static int level = 0;

    /* renamed from: as */
    private static byte[] f17820as = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb.append("] BOARD:[" + Build.BOARD);
        sb.append("] DEVICE:[" + Build.DEVICE);
        sb.append("] DISPLAY:[" + Build.DISPLAY);
        sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb.append("] HOST:[" + Build.HOST);
        sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb.append("] MODEL:[" + Build.MODEL);
        sb.append("] PRODUCT:[" + Build.PRODUCT);
        sb.append("] TAGS:[" + Build.TAGS);
        sb.append("] TYPE:[" + Build.TYPE);
        sb.append("] USER:[" + Build.USER + "]");
        f17821at = sb.toString();
    }

    protected Log() {
    }

    /* renamed from: d */
    public static void m5649d(String str, String str2) {
        m5648d(str, str2, null);
    }

    /* renamed from: d */
    public static void m5648d(String str, String str2, Object... objArr) {
        if (level <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.d(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "D/" + str, str2);
        }
    }

    /* renamed from: e */
    public static void m5647e(String str, String str2) {
        m5646e(str, str2, null);
    }

    /* renamed from: e */
    public static void m5646e(String str, String str2, Object... objArr) {
        if (level <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.e(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "E/" + str, str2);
        }
    }

    /* renamed from: f */
    public static void m5645f(String str, String str2) {
        m5644f(str, str2, null);
    }

    /* renamed from: f */
    public static void m5644f(String str, String str2, Object... objArr) {
        if (level <= 5) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.e(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "F/" + str, str2);
            Toast.makeText(MMApplicationContext.getContext(), str2, 1).show();
        }
    }

    public static int getLevel() {
        return level;
    }

    public static String getSysInfo() {
        return f17821at;
    }

    /* renamed from: i */
    public static void m5643i(String str, String str2) {
        m5642i(str, str2, null);
    }

    /* renamed from: i */
    public static void m5642i(String str, String str2, Object... objArr) {
        if (level <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.i(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "I/" + str, str2);
        }
    }

    public static void reset() {
        f17819ar = null;
        f17820as = null;
    }

    public static void setLevel(int i, boolean z) {
        level = i;
        android.util.Log.w("MicroMsg.SDK.Log", "new log level: " + i);
        if (z) {
            android.util.Log.e("MicroMsg.SDK.Log", "no jni log level support");
        }
    }

    public static void setOutputPath(String str, String str2, String str3, int i) {
        if (str == null || str.length() == 0 || str3 == null || str3.length() == 0) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            FileInputStream fileInputStream = file.length() > 0 ? new FileInputStream(str) : null;
            setOutputStream(fileInputStream, new FileOutputStream(str, true), str2, str3, i);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setOutputStream(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        long currentTimeMillis;
        try {
            f17819ar = new PrintStream(new BufferedOutputStream(outputStream));
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String trim = bufferedReader.readLine().substring(2).trim();
                str2 = bufferedReader.readLine().substring(2).trim();
                currentTimeMillis = Util.getLong(bufferedReader.readLine().trim().substring(2), 0L);
                m5648d("MicroMsg.SDK.Log", "using provided info, type=%s, user=%s, createtime=%d", trim, str2, Long.valueOf(currentTimeMillis));
            } else {
                currentTimeMillis = System.currentTimeMillis();
                LogHelper.initLogHeader(f17819ar, str, str2, currentTimeMillis, i);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(currentTimeMillis);
            stringBuffer.append("dfdhgc");
            f17820as = MD5.getMessageDigest(stringBuffer.toString().getBytes()).substring(7, 21).getBytes();
            android.util.Log.d("MicroMsg.SDK.Log", "set up out put stream");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: v */
    public static void m5641v(String str, String str2) {
        m5640v(str, str2, null);
    }

    /* renamed from: v */
    public static void m5640v(String str, String str2, Object... objArr) {
        if (level <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.v(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "V/" + str, str2);
        }
    }

    /* renamed from: w */
    public static void m5639w(String str, String str2) {
        m5638w(str, str2, null);
    }

    /* renamed from: w */
    public static void m5638w(String str, String str2, Object... objArr) {
        if (level <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.w(str, str2);
            LogHelper.writeToStream(f17819ar, f17820as, "W/" + str, str2);
        }
    }
}
