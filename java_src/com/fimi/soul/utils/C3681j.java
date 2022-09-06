package com.fimi.soul.utils;

import android.os.Environment;
/* renamed from: com.fimi.soul.utils.j */
/* loaded from: classes.dex */
public class C3681j {
    /* renamed from: a */
    public static String m7482a() {
        return Environment.getExternalStorageDirectory().getPath() + "/MiDrone/";
    }

    /* renamed from: a */
    public static String m7481a(String str) {
        return m7477b(m7465n(), str);
    }

    /* renamed from: a */
    public static String m7480a(String str, String str2) {
        return m7465n() + "THUMB_VIDEO_" + (str2 != null ? str2.replaceAll(" ", "") : "") + "_" + str.substring(0, str.lastIndexOf(".")) + ".jpg";
    }

    /* renamed from: b */
    public static String m7479b() {
        return m7482a() + "/Parameters/";
    }

    /* renamed from: b */
    public static String m7478b(String str) {
        return m7477b(m7458u(), str);
    }

    /* renamed from: b */
    private static String m7477b(String str, String str2) {
        return String.format("%s%s", str, str2);
    }

    /* renamed from: c */
    public static String m7476c() {
        return m7482a() + "/Waypoints/";
    }

    /* renamed from: d */
    public static String m7475d() {
        return m7482a() + "/GCP/";
    }

    /* renamed from: e */
    public static String m7474e() {
        return m7482a() + "/Logs/";
    }

    /* renamed from: f */
    public static String m7473f() {
        return m7482a() + "/Maps/";
    }

    /* renamed from: g */
    public static String m7472g() {
        return m7482a() + "/CameraInfo/";
    }

    /* renamed from: h */
    public static String m7471h() {
        return m7482a() + "/LogCat/";
    }

    /* renamed from: i */
    public static String m7470i() {
        return m7482a() + "/update/";
    }

    /* renamed from: j */
    public static String m7469j() {
        return m7482a() + "/wifi/";
    }

    /* renamed from: k */
    public static String m7468k() {
        return m7482a() + "/ErrorCode/";
    }

    /* renamed from: l */
    public static String m7467l() {
        return m7482a() + "PlaneMedia/";
    }

    /* renamed from: m */
    public static String m7466m() {
        return m7482a() + "LOGDOWN/";
    }

    /* renamed from: n */
    public static String m7465n() {
        return m7467l() + "cache/";
    }

    /* renamed from: o */
    public static String m7464o() {
        return m7482a() + "rlgv/";
    }

    /* renamed from: p */
    public static String m7463p() {
        return m7482a() + "lgv";
    }

    /* renamed from: q */
    public static String m7462q() {
        return "ev";
    }

    /* renamed from: r */
    public static String m7461r() {
        return "sv";
    }

    /* renamed from: s */
    public static String m7460s() {
        return "ds";
    }

    /* renamed from: t */
    public static String m7459t() {
        return m7482a() + "/cameraprivew/";
    }

    /* renamed from: u */
    public static String m7458u() {
        return Environment.getExternalStorageDirectory().getPath() + "/DCIM/MiDrone/";
    }

    /* renamed from: v */
    public static String m7457v() {
        return m7482a() + "/firmware/";
    }

    /* renamed from: w */
    public static String m7456w() {
        return m7482a() + "/CameraCmdLog/log.txt";
    }
}
