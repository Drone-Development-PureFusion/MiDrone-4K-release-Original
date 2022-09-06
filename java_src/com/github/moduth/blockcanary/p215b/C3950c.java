package com.github.moduth.blockcanary.p215b;

import android.app.ActivityManager;
import android.util.Log;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.github.moduth.blockcanary.C3953c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
/* renamed from: com.github.moduth.blockcanary.b.c */
/* loaded from: classes.dex */
public class C3950c {

    /* renamed from: a */
    private static final String f16937a = "PerformanceUtils";

    /* renamed from: b */
    private static int f16938b = 0;

    /* renamed from: c */
    private static long f16939c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.moduth.blockcanary.b.c$a */
    /* loaded from: classes.dex */
    public class C3951a implements FileFilter {
        C3951a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    private C3950c() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static int m6390a() {
        if (f16938b == 0) {
            try {
                f16938b = new File("/sys/devices/system/cpu/").listFiles(new C3951a()).length;
            } catch (Exception e) {
                Log.e(f16937a, "getNumCores exception", e);
                f16938b = 1;
            }
        }
        return f16938b;
    }

    /* renamed from: b */
    public static long m6389b() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) C3953c.m6380b().mo6365e().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / FimiMediaMeta.AV_CH_SIDE_RIGHT;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long m6388c() {
        IOException e;
        FileReader fileReader;
        long j;
        String readLine;
        if (f16939c == 0) {
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                        j = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                        try {
                            bufferedReader.close();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    Log.e(f16937a, "close localFileReader exception = ", e2);
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            Log.e(f16937a, "getTotalMemory exception = ", e);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e4) {
                                    Log.e(f16937a, "close localFileReader exception = ", e4);
                                }
                            }
                            f16939c = j;
                            return f16939c;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        j = -1;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileReader2.close();
                        } catch (IOException e6) {
                            Log.e(f16937a, "close localFileReader exception = ", e6);
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileReader = null;
                j = -1;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                throw th;
            }
            f16939c = j;
        }
        return f16939c;
    }
}
