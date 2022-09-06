package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.C4425p;
import com.tencent.stat.common.StatLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
public class StatNativeCrashReport {
    public static final String PRE_TAG_TOMBSTONE_FNAME = "tombstone_";

    /* renamed from: d */
    private static boolean f18340d;

    /* renamed from: c */
    private volatile boolean f18343c = false;

    /* renamed from: b */
    private static StatLogger f18339b = C4420k.m5197b();

    /* renamed from: a */
    static StatNativeCrashReport f18338a = new StatNativeCrashReport();

    /* renamed from: e */
    private static boolean f18341e = false;

    /* renamed from: f */
    private static String f18342f = null;

    static {
        f18340d = false;
        try {
            System.loadLibrary("MtaNativeCrash");
        } catch (Throwable th) {
            f18340d = false;
            f18339b.m5233w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5277a(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append('\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
            f18339b.m5237e((Exception) e);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static LinkedHashSet<File> m5278a(Context context) {
        File file;
        File[] listFiles;
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet<>();
        String tombstonesDir = getTombstonesDir(context);
        if (tombstonesDir != null && (file = new File(tombstonesDir)) != null && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().startsWith(PRE_TAG_TOMBSTONE_FNAME) && file2.isFile()) {
                    f18339b.m5238d("get tombstone file:" + file2.getAbsolutePath().toString());
                    linkedHashSet.add(file2.getAbsoluteFile());
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static long m5276b(File file) {
        try {
            return Long.valueOf(file.getName().replace(PRE_TAG_TOMBSTONE_FNAME, "")).longValue();
        } catch (NumberFormatException e) {
            f18339b.m5237e((Exception) e);
            return 0L;
        }
    }

    public static void doNativeCrashTest() {
        f18338a.makeJniCrash();
    }

    public static String getTombstonesDir(Context context) {
        if (f18342f == null) {
            f18342f = C4425p.m5152a(context, "__mta_tombstone__", "");
        }
        return f18342f;
    }

    public static void initNativeCrash(Context context, String str) {
        if (f18338a.f18343c) {
            return;
        }
        if (str == null) {
            try {
                str = context.getDir("tombstones", 0).getAbsolutePath();
            } catch (Throwable th) {
                f18339b.m5233w(th);
                return;
            }
        }
        if (str.length() > 128) {
            f18339b.m5236e("The length of tombstones dir: " + str + " can't exceeds 200 bytes.");
            return;
        }
        f18342f = str;
        C4425p.m5149b(context, "__mta_tombstone__", str);
        setNativeCrashEnable(true);
        f18338a.initJNICrash(str);
        f18338a.f18343c = true;
        f18339b.m5238d("initNativeCrash success.");
    }

    public static boolean isNativeCrashDebugEnable() {
        return f18341e;
    }

    public static boolean isNativeCrashEnable() {
        return f18340d;
    }

    public static String onNativeCrashHappened() {
        try {
            new RuntimeException("MTA has caught a native crash, java stack:\n").printStackTrace();
            return "";
        } catch (RuntimeException e) {
            return e.toString();
        }
    }

    public static void setNativeCrashDebugEnable(boolean z) {
        try {
            f18338a.enableNativeCrashDebug(z);
            f18341e = z;
        } catch (Throwable th) {
            f18339b.m5233w(th);
        }
    }

    public static void setNativeCrashEnable(boolean z) {
        try {
            f18338a.enableNativeCrash(z);
            f18340d = z;
        } catch (Throwable th) {
            f18339b.m5233w(th);
        }
    }

    public native void enableNativeCrash(boolean z);

    public native void enableNativeCrashDebug(boolean z);

    public native boolean initJNICrash(String str);

    public native String makeJniCrash();

    public native String stringFromJNI();
}
