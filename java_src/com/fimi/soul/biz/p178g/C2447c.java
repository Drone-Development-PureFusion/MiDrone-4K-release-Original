package com.fimi.soul.biz.p178g;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3662as;
/* renamed from: com.fimi.soul.biz.g.c */
/* loaded from: classes.dex */
public class C2447c {
    /* renamed from: a */
    public static void m12158a(int i) {
        int i2;
        Context m13131a = C2238c.m13131a();
        switch (i) {
            case 0:
            case 5:
            default:
                return;
            case 1:
                i2 = C2300R.C2303string.Not_IN_AIR;
                break;
            case 2:
                i2 = C2300R.C2303string.AP_RPT_ATTITUDE;
                break;
            case 3:
                i2 = C2300R.C2303string.LOW_POWER;
                break;
            case 4:
                i2 = C2300R.C2303string.AP_RPT_MODE_TRANS_REJECT;
                break;
            case 6:
                i2 = C2300R.C2303string.AP_RPT_MOTOR_LOCK;
                break;
            case 7:
                i2 = C2300R.C2303string.AP_RPT_HAS_TAKEN_OFF;
                break;
            case 8:
                i2 = C2300R.C2303string.AP_RPT_ATT_OVERFLOW;
                break;
            case 9:
                i2 = C2300R.C2303string.AP_RPT_NO_WAY_POINT;
                break;
            case 10:
                i2 = C2300R.C2303string.AP_RPT_RTH_ING;
                break;
            case 11:
                i2 = C2300R.C2303string.AP_RPT_INVALID_CMD;
                break;
            case 12:
                i2 = C2300R.C2303string.AP_RPT_RTH_KEY_SET;
                break;
            case 13:
                i2 = C2300R.C2303string.AP_RPT_NON_AUTO_MODE;
                break;
            case 14:
                i2 = C2300R.C2303string.AP_RPT_RC_LOST;
                break;
            case 15:
                i2 = C2300R.C2303string.AP_RPT_Vpu;
                break;
            case 16:
                i2 = C2300R.C2303string.AP_RPT_DATA_INVALID;
                break;
            case 17:
                i2 = C2300R.C2303string.AP_RPT_Home_Not_Set;
                break;
            case 18:
                i2 = C2300R.C2303string.AP_RPT_Is_LANDING;
                break;
            case 19:
                i2 = C2300R.C2303string.AP_RPT_APP_UNCONNECT;
                break;
            case 20:
                i2 = C2300R.C2303string.AP_RPT_Compass_Err;
                break;
            case 21:
                i2 = C2300R.C2303string.AP_RPT_ON_Calibration;
                break;
            case 22:
                i2 = C2300R.C2303string.AP_RPT_LOG_START_FAILED;
                break;
            case 23:
                i2 = C2300R.C2303string.AP_RPT_CYRO_ERROR;
                break;
            case 24:
                i2 = C2300R.C2303string.AP_RPT_ACCEL_ERR;
                break;
            case 25:
                i2 = C2300R.C2303string.AP_RPT_BARO_ERR;
                break;
            case 26:
                i2 = C2300R.C2303string.AP_RPT_GPS_ERR;
                break;
            case 27:
                i2 = C2300R.C2303string.AP_RPT_NO_FLY_ZONE;
                break;
            case 28:
                i2 = C2300R.C2303string.AP_RPT_NEED_NEW_COOR;
                break;
            case 29:
                i2 = C2300R.C2303string.AP_RPT_ERR_PILOT_MODE;
                break;
            case 30:
                i2 = C2300R.C2303string.AP_RPT_PARA_ERR;
                break;
            case 31:
                i2 = C2300R.C2303string.AP_RPT_LOGIC_ERROR;
                break;
            case 32:
                i2 = C2300R.C2303string.AP_RPT_STICKY_NEUTRAL;
                break;
            case 33:
                i2 = C2300R.C2303string.AP_RPT_NOT_IN_AP_MODE;
                break;
            case 34:
                i2 = C2300R.C2303string.AP_RPT_PHASE_TAKE_OFF;
                break;
            case 35:
                i2 = C2300R.C2303string.AP_RPT_PHASE_LANDING;
                break;
            case 36:
                i2 = C2300R.C2303string.AP_RPT_GEO_FENCE;
                break;
        }
        if (i2 != 0) {
            if (i2 == C2300R.C2303string.AP_RPT_NO_FLY_ZONE) {
                C2244b.m13099b(m13131a).m13103a(m13131a.getString(i2));
            } else if (i2 == C2300R.C2303string.AP_RPT_DATA_INVALID) {
                C2244b.m13099b(m13131a).m13103a(m13131a.getString(i2));
            } else if (i2 == C2300R.C2303string.LOW_POWER) {
                C2244b.m13099b(m13131a).m13103a(m13131a.getString(i2));
                C3662as.m7563a(C2238c.m13124d(), 2000L);
            }
            C2284z.m12694a(m13131a, m13131a.getString(i2), 3000);
        }
    }
}
