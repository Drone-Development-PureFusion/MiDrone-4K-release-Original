package com.fimi.kernel.utils;

import android.content.Context;
import android.content.SharedPreferences;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.fimi.kernel.utils.v */
/* loaded from: classes.dex */
public class C2277v {

    /* renamed from: a */
    public static final int f7557a = 0;

    /* renamed from: b */
    public static final int f7558b = 1;

    /* renamed from: d */
    private static C2277v f7559d = null;

    /* renamed from: e */
    private static final String f7560e = "miserver_preferen_";

    /* renamed from: f */
    private static final String f7561f = "bottomstateshow";

    /* renamed from: g */
    private static final String f7562g = "flight_distance";

    /* renamed from: h */
    private static final String f7563h = "flight_return_height";

    /* renamed from: i */
    private static final String f7564i = "flight_h_v_speed";

    /* renamed from: j */
    private static final String f7565j = "flight_h_v_height";

    /* renamed from: k */
    private static final String f7566k = "optical_flow_apply";

    /* renamed from: l */
    private static final String f7567l = "pip_format_dialog";

    /* renamed from: m */
    private static final String f7568m = "pip_tf_card_fault_dialog";

    /* renamed from: n */
    private static final String f7569n = "show_9_guid";

    /* renamed from: o */
    private static final String f7570o = "force_attitude_dialog_show_count";

    /* renamed from: p */
    private static final String f7571p = "foot_open";

    /* renamed from: q */
    private static final String f7572q = "emergency_stop_pulp";

    /* renamed from: r */
    private static final String f7573r = "select_device";

    /* renamed from: s */
    private static final String f7574s = "calibration_angle";

    /* renamed from: t */
    private static final String f7575t = "gimal_sensitivity";

    /* renamed from: u */
    private static final String f7576u = "open_full_screen_lead_page";

    /* renamed from: v */
    private static final String f7577v = "close_full_screen_lead_page";

    /* renamed from: c */
    private SharedPreferences f7578c;

    /* renamed from: w */
    private String f7579w;

    /* renamed from: x */
    private C2247a f7580x;

    public C2277v(Context context) {
        this.f7578c = null;
        this.f7579w = "";
        if (this.f7578c == null) {
            this.f7578c = context.getSharedPreferences("miserver_preferen_", 0);
        }
        this.f7579w = PreferenceSecretKey.getSecretKey();
    }

    /* renamed from: a */
    public static C2277v m12784a(Context context) {
        if (f7559d == null) {
            f7559d = new C2277v(context);
        }
        return f7559d;
    }

    /* renamed from: a */
    public SharedPreferences m12787a() {
        return this.f7578c;
    }

    /* renamed from: a */
    public void m12786a(int i) {
        this.f7578c.edit().putInt("cameraplaystate", i).commit();
    }

    /* renamed from: a */
    public void m12785a(long j) {
        this.f7578c.edit().putLong("play_index", j).commit();
    }

    /* renamed from: a */
    public void m12783a(String str) {
        this.f7578c.edit().putString(f7562g, str).commit();
    }

    /* renamed from: a */
    public void m12782a(String str, int i) {
        SharedPreferences.Editor edit = this.f7578c.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    /* renamed from: a */
    public void m12781a(String str, String str2) {
        try {
            this.f7578c.edit().putString(str, m12752i(str2)).commit();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m12780a(boolean z) {
        this.f7578c.edit().putBoolean(f7561f, z).commit();
    }

    /* renamed from: b */
    public Boolean m12779b() {
        return false;
    }

    /* renamed from: b */
    public void m12778b(int i) {
        this.f7578c.edit().putInt(f7575t, i).commit();
    }

    /* renamed from: b */
    public void m12777b(String str) {
        this.f7578c.edit().putString(f7563h, str).commit();
    }

    /* renamed from: b */
    public void m12776b(boolean z) {
        this.f7578c.edit().putBoolean(f7574s, z).commit();
    }

    /* renamed from: c */
    public int m12775c() {
        return this.f7578c.getInt("cameraplaystate", 0);
    }

    /* renamed from: c */
    public void m12774c(int i) {
        this.f7578c.edit().putInt(f7570o, i).commit();
    }

    /* renamed from: c */
    public void m12773c(String str) {
        this.f7578c.edit().putString(f7564i, str).commit();
    }

    /* renamed from: c */
    public void m12772c(boolean z) {
        this.f7578c.edit().putBoolean(f7567l, z).commit();
    }

    /* renamed from: d */
    public int m12769d(String str) {
        return this.f7578c.getInt(str, 0);
    }

    /* renamed from: d */
    public void m12770d(int i) {
        this.f7578c.edit().putInt(f7573r, i).commit();
    }

    /* renamed from: d */
    public void m12768d(boolean z) {
        this.f7578c.edit().putBoolean(f7568m, z).commit();
    }

    /* renamed from: d */
    public boolean m12771d() {
        return this.f7578c.getBoolean(f7561f, true);
    }

    /* renamed from: e */
    public void m12766e(int i) {
        this.f7578c.edit().putInt(f7572q, i).commit();
    }

    /* renamed from: e */
    public void m12765e(String str) {
        this.f7578c.edit().putString("appNoflyZoneMd5", str).commit();
    }

    /* renamed from: e */
    public void m12764e(boolean z) {
        this.f7578c.edit().putBoolean(f7569n, z).commit();
    }

    /* renamed from: e */
    public boolean m12767e() {
        return this.f7578c.getBoolean(f7574s, true);
    }

    /* renamed from: f */
    public int m12763f() {
        return this.f7578c.getInt(f7575t, 100);
    }

    /* renamed from: f */
    public void m12762f(int i) {
        this.f7578c.edit().putInt("deviceType", i).commit();
    }

    /* renamed from: f */
    public void m12761f(String str) {
        this.f7578c.edit().remove(str).commit();
    }

    /* renamed from: f */
    public void m12760f(boolean z) {
        this.f7578c.edit().putBoolean("flyZoneType", z).commit();
    }

    /* renamed from: g */
    public String m12759g() {
        return this.f7578c.getString(f7562g, "500");
    }

    /* renamed from: g */
    public String m12758g(String str) {
        try {
            return m12755h(this.f7578c.getString(str, ""));
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: g */
    public void m12757g(boolean z) {
        this.f7578c.edit().putBoolean(f7576u, z).commit();
    }

    /* renamed from: h */
    public String m12756h() {
        return this.f7578c.getString(f7563h, C0413a.f924d);
    }

    /* renamed from: h */
    public String m12755h(String str) {
        try {
            return C2273r.m12840a(str, this.f7579w);
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: h */
    public void m12754h(boolean z) {
        this.f7578c.edit().putBoolean(f7577v, z).commit();
    }

    /* renamed from: i */
    public String m12753i() {
        return this.f7578c.getString(f7564i, "10");
    }

    /* renamed from: i */
    public String m12752i(String str) {
        try {
            return C2273r.m12836b(str, this.f7579w);
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: j */
    public boolean m12751j() {
        return this.f7578c.getBoolean(f7567l, true);
    }

    /* renamed from: k */
    public boolean m12750k() {
        return this.f7578c.getBoolean(f7568m, true);
    }

    /* renamed from: l */
    public boolean m12749l() {
        return this.f7578c.getBoolean(f7569n, false);
    }

    /* renamed from: m */
    public int m12748m() {
        return this.f7578c.getInt(f7570o, 0);
    }

    /* renamed from: n */
    public long m12747n() {
        return this.f7578c.getLong("play_index", 0L);
    }

    /* renamed from: o */
    public int m12746o() {
        return this.f7578c.getInt(f7573r, 0);
    }

    /* renamed from: p */
    public int m12745p() {
        return this.f7578c.getInt(f7572q, 0);
    }

    /* renamed from: q */
    public boolean m12744q() {
        return this.f7578c.getBoolean("flyZoneType", false);
    }

    /* renamed from: r */
    public String m12743r() {
        return this.f7578c.getString("appNoflyZoneMd5", "");
    }

    /* renamed from: s */
    public int m12742s() {
        return this.f7578c.getInt("deviceType", 0);
    }

    /* renamed from: t */
    public boolean m12741t() {
        return this.f7578c.getBoolean(f7576u, false);
    }

    /* renamed from: u */
    public boolean m12740u() {
        return this.f7578c.getBoolean(f7577v, false);
    }
}
