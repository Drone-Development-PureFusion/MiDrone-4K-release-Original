package com.fimi.soul.utils;
/* loaded from: classes.dex */
public class GPointUtil {
    static {
        System.loadLibrary("chineseshit");
    }

    public static native double[] transformFromGCJToWGS(double d, double d2);

    public static native double[] transformFromWGSToGCJ(double d, double d2);
}
