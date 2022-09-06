package com.mob.tools.log;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NativeErrorHandler {
    private static final boolean ENABLE;
    private static final int MAX_LOG_SIZE = 100;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NativeCrashInfo {
        public int signal;
        public long time;

        private NativeCrashInfo() {
        }
    }

    static {
        boolean z = false;
        try {
            System.loadLibrary("neh");
            z = true;
        } catch (Throwable th) {
        }
        ENABLE = z;
    }

    private static String getCachePath(Context context) {
        File file = new File(ResHelper.getCacheRoot(context), "NativeCrashLogs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static native void nativePrepare(String str);

    private static ArrayList<NativeCrashInfo> parseIndex(String str) {
        File file = new File(str, ".ncl");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<NativeCrashInfo> arrayList = new ArrayList<>();
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            String[] split = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length >= 2) {
                NativeCrashInfo nativeCrashInfo = new NativeCrashInfo();
                nativeCrashInfo.time = ResHelper.parseLong(split[0]);
                nativeCrashInfo.signal = ResHelper.parseInt(split[1]);
                arrayList.add(nativeCrashInfo);
                readLine = bufferedReader.readLine();
            }
        }
        bufferedReader.close();
        return arrayList;
    }

    private static String parseLog(String str, NativeCrashInfo nativeCrashInfo) {
        File file = new File(str, "." + nativeCrashInfo.time);
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        LinkedList linkedList = new LinkedList();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            linkedList.add(readLine);
            if (linkedList.size() > 100) {
                linkedList.remove(0);
            }
        }
        bufferedReader.close();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            stringBuffer.append((String) it2.next()).append('\n');
        }
        return stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "";
    }

    public static boolean prepare(Context context) {
        if (ENABLE) {
            String cachePath = getCachePath(context);
            uploadCreashLog(cachePath);
            nativePrepare(cachePath);
        }
        return ENABLE;
    }

    private static void uploadCreashLog(String str) {
        try {
            Iterator<NativeCrashInfo> it2 = parseIndex(str).iterator();
            while (it2.hasNext()) {
                MobLog.getInstance().nativeCrashLog(parseLog(str, it2.next()));
            }
            ResHelper.deleteFileAndFolder(new File(str));
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }
}
