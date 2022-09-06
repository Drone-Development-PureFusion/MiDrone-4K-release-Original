package com.fimi.soul.biz.p178g;

import com.fimi.kernel.C2238c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.ErrorMode;
import com.fimi.soul.utils.C3662as;
import java.util.Hashtable;
import java.util.Map;
/* renamed from: com.fimi.soul.biz.g.h */
/* loaded from: classes.dex */
public class C2457h {

    /* renamed from: a */
    private static C2457h f8460a;

    /* renamed from: b */
    private static Map<Integer, C2456g> f8461b = new Hashtable();

    /* renamed from: a */
    public static C2457h m12125a() {
        if (f8460a == null) {
            f8460a = new C2457h();
        }
        return f8460a;
    }

    /* renamed from: b */
    public static Map<Integer, C2456g> m12121b() {
        return f8461b;
    }

    /* renamed from: d */
    private void m12119d() {
        if (m12121b().size() > 0) {
            for (Integer num : m12121b().keySet()) {
                C2456g c2456g = m12121b().get(num);
                if (c2456g != null && !c2456g.m12126c()) {
                    C2244b.m13099b(C2238c.m13131a()).m13103a(C2238c.m13131a().getString(c2456g.m12131a()));
                    m12121b().get(num).m12127b(true);
                    if (m12121b().get(num).m12128b() && C2238c.m13124d() != null) {
                        C3662as.m7563a(C2238c.m13124d(), 2000L);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public ErrorMode m12124a(C2657a c2657a) {
        boolean m10438g;
        boolean m10437h;
        C2940x m11318an = c2657a.m11318an();
        boolean m11320al = c2657a.m11320al();
        if (C2367d.m12459a().m12438k()) {
            m10438g = c2657a.m11291i().m10542m();
            m10437h = c2657a.m11291i().m10541n();
        } else {
            m10438g = c2657a.mo11230Q().m10438g();
            m10437h = c2657a.mo11230Q().m10437h();
        }
        ErrorMode errorMode = new ErrorMode();
        if (!c2657a.mo11217ab().mo10898a()) {
            return errorMode;
        }
        errorMode.setIsMiddleFault(m10437h);
        if (m10438g) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_rc_low_battery));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_rc_low_battery));
            }
            m12123a(m11320al, false, C2300R.C2303string.land_rc_low_battery);
        } else {
            m12122a(C2300R.C2303string.land_rc_low_battery);
        }
        if (m10437h) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_rc_middle_fault));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_rc_middle_fault));
            }
        }
        if (!c2657a.mo11216ac()) {
            return errorMode;
        }
        if ((c2657a.m11312at().m10704c() == 4 || c2657a.m11312at().m10707a() == 12) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_OVERFLOW));
        }
        if ((m11318an.m10097ao() || c2657a.m11312at().m10704c() == 5 || c2657a.m11312at().m10707a() == 8) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_LOGIC));
        }
        if (c2657a.m11312at().m10704c() == 6 && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_MOTOR_LOCK));
        }
        if (c2657a.m11312at().m10704c() == 9 && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NO_WAY_POINT));
        }
        if ((c2657a.m11312at().m10704c() == 17 || c2657a.m11312at().m10707a() == 4) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_HOME_NOT_SET));
        }
        if ((m11318an.m10098an() || c2657a.m11312at().m10704c() == 21 || c2657a.m11312at().m10707a() == 14) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NO_CALI));
        }
        if (c2657a.m11312at().m10704c() == 11 && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_INVALID_CMD));
        }
        errorMode.setIsCompassFault(m11318an.m10128M());
        if (!m11318an.m10081f() || c2657a.m11312at().m10700g().isLightStream()) {
            int[] iArr = new int[1];
            iArr[0] = m11320al ? C2300R.C2303string.sky_GPS_ERROR : C2300R.C2303string.land_GPS_ERROR;
            m12122a(iArr);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_GPS_ERROR));
            m12123a(true, false, C2300R.C2303string.sky_GPS_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_GPS_ERROR));
            m12123a(false, false, C2300R.C2303string.land_GPS_ERROR);
        }
        if (c2657a.m11290j() != null) {
            switch (c2657a.m11290j().m10721b()) {
                case 1:
                    if (!m11320al) {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_no_fly_warn));
                        m12123a(false, false, C2300R.C2303string.sky_no_fly_warn);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                        break;
                    } else {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_no_fly_error));
                        m12123a(true, false, C2300R.C2303string.sky_no_fly_error);
                        m12122a(C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                        break;
                    }
                case 2:
                    if (!m11320al) {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_no_hight_fly_warn));
                        m12123a(false, false, C2300R.C2303string.sky_no_hight_fly_warn);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                        break;
                    } else {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.restricted_alttiude_zone));
                        m12123a(false, false, C2300R.C2303string.restricted_alttiude_zone);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                        break;
                    }
                case 3:
                    if (!m11320al) {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_no_fly_warn));
                        m12123a(false, false, C2300R.C2303string.land_no_fly_warn);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.sky_forbin_error);
                        break;
                    } else {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_land_error));
                        m12123a(true, false, C2300R.C2303string.sky_land_error);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                        break;
                    }
                case 4:
                    if (!m11320al) {
                        errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_forbin_error));
                        m12123a(false, false, C2300R.C2303string.sky_forbin_error);
                        m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn);
                        break;
                    }
                    break;
                default:
                    m12122a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.sky_no_fly_warn, C2300R.C2303string.restricted_alttiude_zone, C2300R.C2303string.sky_no_hight_fly_warn, C2300R.C2303string.sky_land_error, C2300R.C2303string.land_no_fly_warn, C2300R.C2303string.sky_forbin_error);
                    break;
            }
        }
        if (m11318an.m10079h() || m11318an.m10078i()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_camp_err));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_CAMP1_ERROR));
            }
        }
        if (m11318an.m10077j()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imuaccel_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUACCEL_ERROR));
            }
        }
        if (m11318an.m10076k()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imugro_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUGYRO_ERROR));
            }
        }
        if (m11318an.m10075l()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BRO_ERROR));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BRO_ERROR));
            }
        }
        if (!m11318an.m10074m()) {
            m12122a(C2300R.C2303string.sky_BATTERY_ERROR, C2300R.C2303string.land_BATTERY_ERROR);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_ERROR));
            m12123a(true, false, C2300R.C2303string.sky_BATTERY_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_ERROR));
            m12123a(false, false, C2300R.C2303string.land_BATTERY_ERROR);
        }
        if (m11318an.m10073n() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_UNATHORIZED));
        }
        if ((m11318an.m10072o() || c2657a.m11312at().m10704c() == 22 || c2657a.m11312at().m10707a() == 15) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_log_error));
        }
        if (!m11318an.m10071p() || !c2657a.m11312at().m10700g().isLightStream()) {
            m12122a(C2300R.C2303string.sky_VPS_ERROR);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_VPS_ERROR));
            m12123a(true, false, C2300R.C2303string.sky_VPS_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_VPS_ERROR));
        }
        if (!m11318an.m10070q() || !c2657a.m11312at().m10700g().isLightStream()) {
            m12122a(C2300R.C2303string.sky_VPS_LOWACCURATE);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_VPS_LOWACCURATE));
            m12123a(false, false, C2300R.C2303string.sky_VPS_LOWACCURATE);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_VPS_LOWACCURATE));
        }
        if ((m11318an.m10069r() || c2657a.m11312at().m10704c() == 12 || c2657a.m11312at().m10707a() == 6) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RC_RETURN));
        }
        if (m11318an.m10068s() && !m11320al) {
            if (c2657a.m11308ax() == 4) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_tf_card_format_ERROR));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_NEUTRAL_POINT_ERROR));
            }
        }
        if (m11318an.m10063x() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_UPDATED_FAIL));
        }
        if (c2657a.m11312at().m10704c() == 13 || c2657a.m11312at().m10707a() == 1) {
            if (!m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NON_AUTO_MODE));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_RPT_NON_AUTO_MODE));
            }
        } else if (m11318an.m10129L() && !c2657a.m11312at().m10700g().isLightStream()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_GPS_NOSIG));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_GPS_NOSIG));
            }
        }
        if (m11318an.m10128M()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_CAMP_NCAL));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_CAMP_NCAL));
            }
        }
        if (m11318an.m10127N() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUACCEL_NCAL));
        }
        if (m11318an.m10126O() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_ORTH_NCAL));
        }
        if (m11318an.m10125P() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUGYRO_NCAL));
        }
        if ((m11318an.m10124Q() || c2657a.m11312at().m10704c() == 2 || c2657a.m11312at().m10707a() == 7) && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_G_ATT_INV));
        }
        if (c2657a.m11312at().m10704c() == 19 || c2657a.m11312at().m10707a() == 10) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.str_ap_rpt_app_unconnected));
        }
        if (m11318an.m10121T() || c2657a.m11312at().m10704c() == 3 || c2657a.m11312at().m10707a() == 5) {
            if (!m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_LOWPOWER));
                m12123a(false, false, C2300R.C2303string.land_LOWPOWER);
            } else if (c2657a.m11312at().m10702e() == 7 || c2657a.m11312at().m10702e() == 8) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_lowpower_return));
                m12123a(true, false, C2300R.C2303string.sky_lowpower_return);
            } else if (c2657a.m11312at().m10702e() == 9) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_landing_BAT_LOWPOWER));
                m12123a(true, false, C2300R.C2303string.sky_landing_BAT_LOWPOWER);
            } else if (c2657a.m11312at().m10702e() == 1) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_LOWPOWER_exit));
                m12123a(true, false, C2300R.C2303string.sky_LOWPOWER_exit);
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_LOWPOWER));
                m12123a(true, false, C2300R.C2303string.sky_LOWPOWER);
            }
            m12122a(C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.land_BAT_LOWPOWER, C2300R.C2303string.sky_LP_RETURN);
        } else if (m11318an.m10123R()) {
            m12122a(C2300R.C2303string.sky_LOWPOWER, C2300R.C2303string.land_LOWPOWER, C2300R.C2303string.sky_LP_RETURN, C2300R.C2303string.sky_lowpower_return);
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BAT_light_LOWPOWER));
                m12123a(true, false, C2300R.C2303string.sky_BAT_light_LOWPOWER);
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BAT_LOWPOWER));
                m12123a(false, false, C2300R.C2303string.land_BAT_LOWPOWER);
            }
        } else if (m11318an.m10122S()) {
            m12122a(C2300R.C2303string.sky_LOWPOWER, C2300R.C2303string.land_LOWPOWER, C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.land_BAT_LOWPOWER, C2300R.C2303string.sky_lowpower_return);
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_LP_RETURN));
                m12123a(true, false, C2300R.C2303string.sky_LP_RETURN);
            }
        } else {
            m12122a(C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.sky_LP_RETURN, C2300R.C2303string.land_BAT_LOWPOWER, C2300R.C2303string.sky_landing_BAT_LOWPOWER, C2300R.C2303string.sky_LOWPOWER, C2300R.C2303string.sky_lowpower_return);
        }
        if (m11318an.m10120U()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_POWER_HIGHTEMP));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_POWER_HIGHTEMP));
            }
            m12123a(false, false, m11320al ? C2300R.C2303string.sky_POWER_HIGHTEMP : C2300R.C2303string.land_POWER_HIGHTEMP);
        } else {
            int[] iArr2 = new int[1];
            iArr2[0] = m11320al ? C2300R.C2303string.sky_POWER_HIGHTEMP : C2300R.C2303string.land_POWER_HIGHTEMP;
            m12122a(iArr2);
        }
        if (!m11318an.m10103ai()) {
            m12122a(C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky, C2300R.C2303string.sky_BATTERY_SHORTLIFE);
        } else if (!m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_SHORTLIFE));
            m12123a(false, false, C2300R.C2303string.sky_BATTERY_SHORTLIFE);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky));
            m12123a(true, false, C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky);
        }
        if (!m11318an.m10102aj()) {
            m12122a(C2300R.C2303string.sky_MAXIMUM_ALTITUDE);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_MAXIMUM_ALTITUDE));
            m12123a(false, false, C2300R.C2303string.sky_MAXIMUM_ALTITUDE);
        }
        if (!m11318an.m10101ak()) {
            m12122a(C2300R.C2303string.sky_MAXIMUM_DISTANCE);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_MAXIMUM_DISTANCE));
            m12123a(false, false, C2300R.C2303string.sky_MAXIMUM_DISTANCE);
        }
        if (!m11318an.m10100al() || !m11320al) {
        }
        if (m11318an.m10099am() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BAT_PREHEAT));
        }
        if (!m11318an.m10065v()) {
            m12122a(C2300R.C2303string.land_NfzDataInvalid);
        } else if (!m11320al) {
            if (!DroidPlannerApp.f7891f) {
                m12123a(false, false, C2300R.C2303string.land_NfzDataInvalid);
            }
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_NfzDataInvalid));
        }
        if (!m11318an.m10119V()) {
            m12122a(C2300R.C2303string.land_single_cell_battery);
        } else if (!m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_single_cell_battery));
            m12123a(false, false, C2300R.C2303string.land_single_cell_battery);
        }
        if (!m11318an.m10118W()) {
            m12122a(C2300R.C2303string.sky_bat_lowpower_dangerous, C2300R.C2303string.land_bat_lowpower_dangerous);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_bat_lowpower_dangerous));
            m12123a(true, false, C2300R.C2303string.sky_bat_lowpower_dangerous);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_lowpower_dangerous));
            m12123a(true, false, C2300R.C2303string.land_bat_lowpower_dangerous);
        }
        if (m11318an.m10061z()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imag_interface));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_imag_interface));
            }
        }
        if (m11318an.m10064w()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imu_overtemperature));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_imu_overtemperature));
            }
        }
        if (m11318an.m10137D() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sensor_low_tempe));
        }
        if (!m11318an.m10136E()) {
            m12122a(C2300R.C2303string.sky_bat_dischage_warning);
        } else if (!m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_dischage_warning));
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_bat_dischage_warning));
            m12123a(true, false, C2300R.C2303string.sky_bat_dischage_warning);
        }
        if (!m11318an.m10135F()) {
            m12122a(C2300R.C2303string.sky_bat_damage);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_bat_damage));
            m12123a(true, false, C2300R.C2303string.sky_bat_damage);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_damage));
        }
        if (m11318an.m10134G() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_Bat_Low_Temp_And_Rp));
        }
        if (!m11318an.m10133H()) {
            m12122a(C2300R.C2303string.sky_bat_comm_error);
        } else if (m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_bat_comm_error));
            m12123a(true, false, C2300R.C2303string.sky_bat_comm_error);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_comm_error));
        }
        if (m11318an.m10132I()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_nfz_data_pos_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_nfz_data_pos_error));
            }
        }
        if (m11318an.m10131J()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_air_gauge_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_air_gauge_error));
            }
        }
        if (m11318an.m10130K() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_log_create_fail));
        }
        if (m11320al) {
            if (m11318an.m10117X()) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.stick_move_warning_result));
                m12123a(false, false, C2300R.C2303string.stick_move_warning_des);
            } else {
                m12122a(C2300R.C2303string.stick_move_warning_des);
            }
        }
        if ((c2657a.m11312at().m10700g().isEnforcementAtti() || c2657a.m11312at().m10700g().isLightStream()) && c2657a.m11310av().m10582a()) {
            if (m11318an.m10116Y()) {
                if (m11320al) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sonar_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sonar_error));
                }
            }
            if (m11318an.m10115Z()) {
                if (m11320al) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.camera_disconnect_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.camera_disconnect));
                }
            }
            if (m11318an.m10111aa()) {
                if (m11320al) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.imagequality_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.imagequality_error));
                }
            }
            if (m11318an.m10110ab()) {
                if (m11320al) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.estimatexy_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.estimatexy_error));
                }
            }
            if (!m11318an.m10096ap() || !m11320al) {
            }
        }
        if (!m11320al && m11318an.m10062y()) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.str_at_rpt_bat_err));
        }
        if (m11318an.m10095aq()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.is_min_hight));
                m12123a(false, false, C2300R.C2303string.is_min_hight);
            } else {
                m12122a(C2300R.C2303string.is_min_hight);
            }
        }
        if (m11318an.m10094ar() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_calidata_invalid));
        }
        if (m11318an.m10093as() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_warning_up));
        }
        if (m11318an.m10092at()) {
            if (m11320al) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_cooling_down));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_cooling_down));
            }
        }
        if (m11318an.m10091au() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_v_rp_mismatch));
        }
        if (m11318an.m10090av() && m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_above_nfz_limit_height));
        }
        if (m11318an.m10089aw() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_dnfz_updating));
        }
        if (m11318an.m10088ax() && !m11320al) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_ahrs_not_ready));
        }
        m12119d();
        return errorMode;
    }

    /* renamed from: a */
    public void m12123a(boolean z, boolean z2, int i) {
        if (!f8461b.containsKey(Integer.valueOf(i))) {
            f8461b.put(Integer.valueOf(i), new C2456g(z, z2, i));
        }
    }

    /* renamed from: a */
    public void m12122a(int... iArr) {
        for (int i : iArr) {
            if (f8461b.containsKey(Integer.valueOf(i))) {
                f8461b.remove(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: c */
    public void m12120c() {
        m12122a(C2300R.C2303string.sky_landing_BAT_LOWPOWER, C2300R.C2303string.sky_LP_RETURN);
    }
}
