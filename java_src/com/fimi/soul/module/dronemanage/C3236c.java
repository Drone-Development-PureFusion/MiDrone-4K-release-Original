package com.fimi.soul.module.dronemanage;

import android.content.Context;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.module.dronemanage.c */
/* loaded from: classes.dex */
public class C3236c {

    /* renamed from: F */
    private static C3236c f12423F;

    /* renamed from: E */
    private Context f12428E;

    /* renamed from: a */
    private final int f12429a = 0;

    /* renamed from: b */
    private final int f12430b = 1;

    /* renamed from: c */
    private final int f12431c = 2;

    /* renamed from: d */
    private final int f12432d = 3;

    /* renamed from: e */
    private final int f12433e = 4;

    /* renamed from: f */
    private final int f12434f = 5;

    /* renamed from: g */
    private final int f12435g = 6;

    /* renamed from: h */
    private final int f12436h = 7;

    /* renamed from: i */
    private final int f12437i = 8;

    /* renamed from: j */
    private final int f12438j = 9;

    /* renamed from: k */
    private final int f12439k = 10;

    /* renamed from: l */
    private final int f12440l = 11;

    /* renamed from: m */
    private final int f12441m = 12;

    /* renamed from: n */
    private final int f12442n = 13;

    /* renamed from: o */
    private final int f12443o = 14;

    /* renamed from: p */
    private final int f12444p = 15;

    /* renamed from: q */
    private final int f12445q = 16;

    /* renamed from: r */
    private final int f12446r = 17;

    /* renamed from: s */
    private final int f12447s = 18;

    /* renamed from: t */
    private final int f12448t = 19;

    /* renamed from: u */
    private final int f12449u = 20;

    /* renamed from: v */
    private final int f12450v = 21;

    /* renamed from: w */
    private final int f12451w = 22;

    /* renamed from: x */
    private final int f12452x = 23;

    /* renamed from: y */
    private final int f12453y = 24;

    /* renamed from: z */
    private final int f12454z = 25;

    /* renamed from: A */
    private final int f12424A = 26;

    /* renamed from: B */
    private final int f12425B = 27;

    /* renamed from: C */
    private final int f12426C = 28;

    /* renamed from: D */
    private final int f12427D = 29;

    /* renamed from: a */
    public static C3236c m9022a() {
        if (f12423F == null) {
            f12423F = new C3236c();
        }
        return f12423F;
    }

    /* renamed from: a */
    private void m9021a(int i) {
        C2284z.m12696a(this.f12428E, i, 3000);
    }

    /* renamed from: a */
    public void m9020a(int i, Context context) {
        this.f12428E = context;
        switch (i) {
            case 0:
            case 29:
            default:
                return;
            case 1:
                m9021a(C2300R.C2303string.Not_IN_AIR);
                return;
            case 2:
                m9021a(C2300R.C2303string.AP_RPT_ATTITUDE);
                return;
            case 3:
                m9021a(C2300R.C2303string.LOW_POWER);
                return;
            case 4:
                m9021a(C2300R.C2303string.AP_RPT_LOG_START_FAILED);
                return;
            case 5:
                m9021a(C2300R.C2303string.AT_RPT_LOGIC);
                return;
            case 6:
                m9021a(C2300R.C2303string.AP_RPT_MOTOR_LOCK);
                return;
            case 7:
                m9021a(C2300R.C2303string.AP_RPT_HAS_TAKEN_OFF);
                return;
            case 8:
                m9021a(C2300R.C2303string.AP_RPT_ATT_OVERFLOW);
                return;
            case 9:
                m9021a(C2300R.C2303string.AP_RPT_NO_WAY_POINT);
                return;
            case 10:
                m9021a(C2300R.C2303string.AP_RPT_RTH_ING);
                return;
            case 11:
                m9021a(C2300R.C2303string.AP_RPT_INVALID_CMD);
                return;
            case 12:
                m9021a(C2300R.C2303string.AP_RPT_RTH_KEY_SET);
                return;
            case 13:
                m9021a(C2300R.C2303string.AP_RPT_NON_AUTO_MODE);
                return;
            case 14:
                m9021a(C2300R.C2303string.AP_RPT_RC_LOST);
                return;
            case 15:
                m9021a(C2300R.C2303string.AP_RPT_Vpu);
                return;
            case 16:
                m9021a(C2300R.C2303string.AP_RPT_DATA_INVALID);
                return;
            case 17:
                m9021a(C2300R.C2303string.AP_RPT_Home_Not_Set);
                return;
            case 18:
                m9021a(C2300R.C2303string.AP_RPT_Is_LANDING);
                return;
            case 19:
                m9021a(C2300R.C2303string.AP_RPT_APP_UNCONNECT);
                return;
            case 20:
                m9021a(C2300R.C2303string.AP_RPT_Compass_Err);
                return;
            case 21:
                m9021a(C2300R.C2303string.AP_RPT_ON_Calibration);
                return;
            case 22:
                m9021a(C2300R.C2303string.AP_RPT_LOG_START_FAILED);
                return;
            case 23:
                m9021a(C2300R.C2303string.AP_RPT_CYRO_ERROR);
                return;
            case 24:
                m9021a(C2300R.C2303string.AP_RPT_ACCEL_ERR);
                return;
            case 25:
                m9021a(C2300R.C2303string.AP_RPT_BARO_ERR);
                return;
            case 26:
                m9021a(C2300R.C2303string.AP_RPT_GPS_ERR);
                return;
            case 27:
                m9021a(C2300R.C2303string.AP_RPT_NO_FLY_ZONE);
                return;
            case 28:
                m9021a(C2300R.C2303string.AT_RPT_STICK_NEUTAL);
                return;
        }
    }
}
