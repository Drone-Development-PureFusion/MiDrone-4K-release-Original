package com.fimi.soul.module.login;

import android.os.Build;
/* renamed from: com.fimi.soul.module.login.c */
/* loaded from: classes.dex */
public class C3384c {

    /* renamed from: A */
    public static final int f13164A = 4;

    /* renamed from: B */
    public static final int f13165B = 5;

    /* renamed from: C */
    public static final int f13166C = 6;

    /* renamed from: D */
    public static final int f13167D = 7;

    /* renamed from: E */
    public static final String f13168E = "com.fimi.app.changelanguge";

    /* renamed from: H */
    public static final int f13171H = 13;

    /* renamed from: I */
    public static final int f13172I = 0;

    /* renamed from: a */
    public static final boolean f13173a = false;

    /* renamed from: d */
    public static final boolean f13176d = true;

    /* renamed from: m */
    public static final String f13185m = "manufacturer_mode_key";

    /* renamed from: n */
    public static final String f13186n = "gh2_newbie_guide_key";

    /* renamed from: o */
    public static final String f13187o = ".mp4";

    /* renamed from: q */
    public static final String f13189q = "video_resolution_key";

    /* renamed from: r */
    public static final int f13190r = 0;

    /* renamed from: s */
    public static final int f13191s = 4;

    /* renamed from: t */
    public static final String f13192t = "select_languagetype";

    /* renamed from: u */
    public static final String f13193u = "ServiceCode";

    /* renamed from: v */
    public static final String f13194v = "CountryCode";

    /* renamed from: w */
    public static final String f13195w = "service_item_key";

    /* renamed from: x */
    public static final int f13196x = 1;

    /* renamed from: y */
    public static final int f13197y = 2;

    /* renamed from: z */
    public static final int f13198z = 3;

    /* renamed from: b */
    static final EnumC3385a f13174b = EnumC3385a.Online;

    /* renamed from: c */
    public static boolean f13175c = true;

    /* renamed from: e */
    public static boolean f13177e = false;

    /* renamed from: f */
    public static boolean f13178f = false;

    /* renamed from: g */
    public static boolean f13179g = true;

    /* renamed from: h */
    public static boolean f13180h = true;

    /* renamed from: i */
    public static final EnumC3390g f13181i = EnumC3390g.GH2;

    /* renamed from: j */
    public static int f13182j = 14;

    /* renamed from: k */
    public static int f13183k = 35;

    /* renamed from: l */
    public static final String[] f13184l = {"samsungSM-A9000", "xiaomiRedmi Note 5A"};

    /* renamed from: p */
    public static String f13188p = "support4k_key";

    /* renamed from: F */
    public static String f13169F = "x9_begnner_guide";

    /* renamed from: G */
    public static String f13170G = "x9_begnner_guide_setting";

    /* renamed from: com.fimi.soul.module.login.c$a */
    /* loaded from: classes.dex */
    public enum EnumC3385a {
        Online,
        Factory
    }

    /* renamed from: a */
    public static boolean m8544a() {
        return f13174b.equals(EnumC3385a.Factory);
    }

    /* renamed from: b */
    public static boolean m8543b() {
        for (String str : f13184l) {
            if (str.contentEquals(Build.BRAND + Build.MODEL)) {
                return true;
            }
        }
        return false;
    }
}
