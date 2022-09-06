package com.fimi.soul.biz.camera;

import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11SystemConfig;
import com.fimi.soul.biz.camera.entity.X11SystemConfigOption;
import com.fimi.soul.biz.camera.p171a.C2377b;
import com.fimi.soul.biz.camera.p172b.AbstractC2383a;
import com.fimi.soul.biz.camera.p172b.AbstractC2385c;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.module.login.C3384c;
import com.fimi.soul.utils.C3681j;
import java.io.File;
import java.text.SimpleDateFormat;
/* renamed from: com.fimi.soul.biz.camera.b */
/* loaded from: classes.dex */
public class C2379b {

    /* renamed from: b */
    private static C2379b f8042b = new C2379b();

    /* renamed from: d */
    private static final String f8043d = "SP_KEY_IsDownloadAndDelete";

    /* renamed from: e */
    private static final String f8044e = "SP_KEY_IsTakePhotoByAPI";

    /* renamed from: a */
    private EnumC2382b f8045a = EnumC2382b.X11;

    /* renamed from: f */
    private AbstractC2375a[] f8047f = new AbstractC2375a[EnumC2382b.values().length];

    /* renamed from: c */
    private AbstractC2385c f8046c = new C2377b();

    /* renamed from: com.fimi.soul.biz.camera.b$a */
    /* loaded from: classes.dex */
    public enum EnumC2381a {
        Thumbnail,
        Video,
        Image,
        Other
    }

    /* renamed from: com.fimi.soul.biz.camera.b$b */
    /* loaded from: classes.dex */
    public enum EnumC2382b {
        X11,
        Ant,
        GoPro
    }

    private C2379b() {
    }

    /* renamed from: a */
    public static synchronized C2379b m12410a() {
        C2379b c2379b;
        synchronized (C2379b.class) {
            if (f8042b == null) {
                f8042b = new C2379b();
            }
            c2379b = f8042b;
        }
        return c2379b;
    }

    /* renamed from: a */
    public static String m12408a(X11FileInfo x11FileInfo) {
        return String.format("THUMB_%s", x11FileInfo.getName());
    }

    /* renamed from: a */
    public static String m12404a(String str) {
        return String.format("http://%s/%s", C2427e.m12221a(), str);
    }

    /* renamed from: a */
    public static String m12403a(String str, String str2) {
        return String.format("%s", str);
    }

    /* renamed from: a */
    public static void m12409a(DroidPlannerApp droidPlannerApp) {
        droidPlannerApp.f7895a.mo11219a(((C2423d) m12410a().m12394d()).m12230x());
    }

    /* renamed from: a */
    private static void m12407a(X11SystemConfig x11SystemConfig, String str, int i, String[] strArr) {
        m12406a(x11SystemConfig, str, i, strArr, strArr);
    }

    /* renamed from: a */
    private static void m12406a(X11SystemConfig x11SystemConfig, String str, int i, String[] strArr, String[] strArr2) {
        X11SystemConfigOption x11SystemConfigOption = new X11SystemConfigOption();
        x11SystemConfigOption.setType(str);
        x11SystemConfigOption.setOptions(strArr2);
        x11SystemConfigOption.setOptionsText(strArr);
        x11SystemConfigOption.setDefaultOption(strArr2[i]);
        x11SystemConfig.getSystemConfigOptions().put(str, x11SystemConfigOption);
    }

    /* renamed from: a */
    public static boolean m12405a(WifiDistanceFile wifiDistanceFile) {
        return m12395c(m12400b(wifiDistanceFile));
    }

    /* renamed from: b */
    public static String m12400b(WifiDistanceFile wifiDistanceFile) {
        String[] split = wifiDistanceFile.getName().split("\\.");
        try {
            Log.d("Good", "count" + split.length + "");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddhhmmss");
            Log.d("Good", "date:" + wifiDistanceFile.getDateString());
            String format = String.format("%s_%s.%s", simpleDateFormat2.format(simpleDateFormat.parse(wifiDistanceFile.getDateString())), split[0], split[1]);
            Log.d("Good", "target file download:" + format);
            return format;
        } catch (Exception e) {
            return wifiDistanceFile.getName();
        }
    }

    /* renamed from: b */
    public static boolean m12399b(String str) {
        return new File(m12391e(str)).exists();
    }

    /* renamed from: c */
    public static String m12396c(WifiDistanceFile wifiDistanceFile) {
        return String.format("%s%s", C3681j.m7458u(), m12400b(wifiDistanceFile));
    }

    /* renamed from: c */
    public static boolean m12395c(String str) {
        File file = new File(m12393d(str));
        return file.exists() && file.length() > 0;
    }

    /* renamed from: d */
    public static String m12393d(String str) {
        return String.format("%s%s", C3681j.m7458u(), str);
    }

    /* renamed from: e */
    public static String m12391e(String str) {
        return String.format("%s%s", C3681j.m7465n(), str);
    }

    /* renamed from: f */
    public static EnumC2381a m12389f(String str) {
        if (str.toUpperCase().contains("THUMB_")) {
            return EnumC2381a.Thumbnail;
        }
        if (str.toLowerCase().contains(C3384c.f13187o)) {
            return EnumC2381a.Video;
        }
        if (!str.toLowerCase().contains(".jpg")) {
            return null;
        }
        return EnumC2381a.Image;
    }

    /* renamed from: a */
    public void m12402a(boolean z) {
        C2238c.m13125c().mo13114a(f8044e, z);
    }

    /* renamed from: b */
    public void m12398b(boolean z) {
        C2238c.m13125c().mo13114a(f8043d, z);
    }

    /* renamed from: b */
    public boolean m12401b() {
        return C2238c.m13125c().mo13108d(f8044e);
    }

    /* renamed from: c */
    public boolean m12397c() {
        return C2238c.m13125c().mo13108d(f8043d);
    }

    /* renamed from: d */
    public AbstractC2383a m12394d() {
        int ordinal = this.f8045a.ordinal();
        switch (this.f8045a) {
            case X11:
                if (this.f8047f[ordinal] == null) {
                    this.f8047f[ordinal] = new C2423d(m12392e());
                    break;
                }
                break;
        }
        return this.f8047f[ordinal];
    }

    /* renamed from: e */
    public AbstractC2385c m12392e() {
        return this.f8046c;
    }

    /* renamed from: f */
    public EnumC2382b m12390f() {
        return this.f8045a;
    }
}
