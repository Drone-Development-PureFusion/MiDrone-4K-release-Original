package com.tencent.p227mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;
/* renamed from: com.tencent.mm.sdk.platformtools.TrafficStats */
/* loaded from: classes.dex */
public final class TrafficStats {
    public static final String DEV_FILE = "/proc/self/net/dev";
    public static final String GPRSLINE = "rmnet0";
    public static final String WIFILINE = "tiwlan0";

    /* renamed from: bl */
    private static long f17872bl;

    /* renamed from: bm */
    private static long f17873bm;

    /* renamed from: bn */
    private static long f17874bn;

    /* renamed from: bo */
    private static long f17875bo;

    /* renamed from: bp */
    private static long f17876bp;

    /* renamed from: bq */
    private static long f17877bq;

    /* renamed from: br */
    private static long f17878br;

    /* renamed from: bs */
    private static long f17879bs;

    private TrafficStats() {
    }

    public static long getMobileRx(long j) {
        return f17877bq > j ? f17877bq : j;
    }

    public static long getMobileTx(long j) {
        return f17876bp > j ? f17876bp : j;
    }

    public static long getWifiRx(long j) {
        return f17879bs > j ? f17879bs : j;
    }

    public static long getWifiTx(long j) {
        return f17878br > j ? f17878br : j;
    }

    public static void reset() {
        f17872bl = -1L;
        f17873bm = -1L;
        f17874bn = -1L;
        f17875bo = -1L;
        update();
    }

    public static void update() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        try {
            Scanner scanner = new Scanner(new File("/proc/" + Process.myPid() + "/net/dev"));
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split("[ :\t]+");
                int i = split[0].length() == 0 ? 1 : 0;
                if (!split[0].equals("lo") && split[i + 0].startsWith("rmnet")) {
                    j += Long.parseLong(split[i + 9]);
                    j2 += Long.parseLong(split[i + 1]);
                }
                if (!split[i + 0].equals("lo") && !split[i + 0].startsWith("rmnet")) {
                    j3 += Long.parseLong(split[i + 9]);
                    j4 += Long.parseLong(split[i + 1]);
                }
            }
            scanner.close();
            if (f17872bl < 0) {
                f17872bl = j;
                Log.m5640v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", Long.valueOf(j));
            }
            if (f17873bm < 0) {
                f17873bm = j2;
                Log.m5640v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", Long.valueOf(j2));
            }
            if (f17874bn < 0) {
                f17874bn = j3;
                Log.m5640v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", Long.valueOf(j3));
            }
            if (f17875bo < 0) {
                f17875bo = j4;
                Log.m5640v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", Long.valueOf(j4));
            }
            if (j4 - f17875bo < 0) {
                Log.m5640v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j4 - f17875bo));
            }
            if (j3 - f17874bn < 0) {
                Log.m5640v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j3 - f17874bn));
            }
            f17876bp = j >= f17872bl ? j - f17872bl : j;
            f17877bq = j2 >= f17873bm ? j2 - f17873bm : j2;
            f17878br = j3 >= f17874bn ? j3 - f17874bn : j3;
            f17879bs = j4 >= f17875bo ? j4 - f17875bo : j4;
            f17872bl = j;
            f17873bm = j2;
            f17874bn = j3;
            f17875bo = j4;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.m5648d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", Long.valueOf(f17879bs), Long.valueOf(f17878br), Long.valueOf(f17877bq), Long.valueOf(f17876bp));
    }

    public static long updateMobileRx(long j) {
        update();
        return getMobileRx(j);
    }

    public static long updateMobileTx(long j) {
        update();
        return getMobileTx(j);
    }

    public static long updateWifiRx(long j) {
        update();
        return getWifiRx(j);
    }

    public static long updateWifiTx(long j) {
        update();
        return getWifiTx(j);
    }
}
