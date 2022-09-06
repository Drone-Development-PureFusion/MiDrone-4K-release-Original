package com.fimi.soul.module.droneTrack.p209b;

import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p178g.C2456g;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.ErrorMode;
import com.fimi.soul.module.droneTrack.p208a.C3202a;
import java.util.Hashtable;
import java.util.Map;
/* renamed from: com.fimi.soul.module.droneTrack.b.a */
/* loaded from: classes.dex */
public class C3213a {

    /* renamed from: a */
    private static C3213a f12340a;

    /* renamed from: b */
    private static Map<Integer, C2456g> f12341b = new Hashtable();

    /* renamed from: a */
    public static C3213a m9095a() {
        if (f12340a == null) {
            f12340a = new C3213a();
        }
        return f12340a;
    }

    /* renamed from: b */
    public static Map<Integer, C2456g> m9091b() {
        return f12341b;
    }

    /* renamed from: a */
    public ErrorMode m9094a(C3202a c3202a) {
        C2940x m9169b = c3202a.m9169b();
        if (m9169b == null) {
            return null;
        }
        boolean m9161j = c3202a.m9161j();
        boolean m9158m = c3202a.m9158m();
        boolean m9157n = c3202a.m9157n();
        ErrorMode errorMode = new ErrorMode();
        errorMode.setIsMiddleFault(m9157n);
        if (m9158m) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_rc_low_battery));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_rc_low_battery));
            }
            m9093a(m9161j, false, C2300R.C2303string.land_rc_low_battery);
        } else {
            m9092a(C2300R.C2303string.land_rc_low_battery);
        }
        if (m9157n) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_rc_middle_fault));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_rc_middle_fault));
            }
        }
        if ((c3202a.m9183a().m10704c() == 4 || c3202a.m9183a().m10707a() == 12) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_OVERFLOW));
        }
        if ((m9169b.m10097ao() || c3202a.m9183a().m10704c() == 5 || c3202a.m9183a().m10707a() == 8) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_LOGIC));
        }
        if (c3202a.m9183a().m10704c() == 6 && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_MOTOR_LOCK));
        }
        if (c3202a.m9183a().m10704c() == 9 && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NO_WAY_POINT));
        }
        if ((c3202a.m9183a().m10704c() == 17 || c3202a.m9183a().m10707a() == 4) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_HOME_NOT_SET));
        }
        if ((m9169b.m10098an() || c3202a.m9183a().m10704c() == 21 || c3202a.m9183a().m10707a() == 14) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NO_CALI));
        }
        if (c3202a.m9183a().m10704c() == 11 && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_INVALID_CMD));
        }
        errorMode.setIsCompassFault(m9169b.m10128M());
        if (!m9169b.m10081f() || c3202a.m9183a().m10700g().isLightStream()) {
            int[] iArr = new int[1];
            iArr[0] = m9161j ? C2300R.C2303string.sky_GPS_ERROR : C2300R.C2303string.land_GPS_ERROR;
            m9092a(iArr);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_GPS_ERROR));
            m9093a(true, false, C2300R.C2303string.sky_GPS_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_GPS_ERROR));
            m9093a(false, false, C2300R.C2303string.land_GPS_ERROR);
        }
        if (!m9169b.m10080g() && (c3202a.m9168c() == null || c3202a.m9168c().m10721b() != 3)) {
            m9092a(C2300R.C2303string.sky_no_fly_error, C2300R.C2303string.land_no_fly_error);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_no_fly_error));
            m9093a(true, false, C2300R.C2303string.sky_no_fly_error);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_no_fly_error));
            m9093a(false, false, C2300R.C2303string.land_no_fly_error);
        }
        if (c3202a.m9168c() != null && c3202a.m9168c().m10721b() == 1) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_no_fly_buffer_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_no_fly_buffer_error));
            }
        }
        if (m9169b.m10079h() || m9169b.m10078i()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_camp_err));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_CAMP1_ERROR));
            }
        }
        if (m9169b.m10077j()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imuaccel_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUACCEL_ERROR));
            }
        }
        if (m9169b.m10076k()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imugro_error));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUGYRO_ERROR));
            }
        }
        if (m9169b.m10075l()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BRO_ERROR));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BRO_ERROR));
            }
        }
        if (!m9169b.m10074m()) {
            m9092a(C2300R.C2303string.sky_BATTERY_ERROR, C2300R.C2303string.land_BATTERY_ERROR);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_ERROR));
            m9093a(true, false, C2300R.C2303string.sky_BATTERY_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_ERROR));
            m9093a(false, false, C2300R.C2303string.land_BATTERY_ERROR);
        }
        if (m9169b.m10073n() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_UNATHORIZED));
        }
        if ((m9169b.m10072o() || c3202a.m9183a().m10704c() == 22 || c3202a.m9183a().m10707a() == 15) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_log_error));
        }
        if (!m9169b.m10071p() || !c3202a.m9183a().m10700g().isLightStream()) {
            m9092a(C2300R.C2303string.sky_VPS_ERROR);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_VPS_ERROR));
            m9093a(true, false, C2300R.C2303string.sky_VPS_ERROR);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_VPS_ERROR));
        }
        if (!m9169b.m10070q() || !c3202a.m9183a().m10700g().isLightStream()) {
            m9092a(C2300R.C2303string.sky_VPS_LOWACCURATE);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_VPS_LOWACCURATE));
            m9093a(false, false, C2300R.C2303string.sky_VPS_LOWACCURATE);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_VPS_LOWACCURATE));
        }
        if ((m9169b.m10069r() || c3202a.m9183a().m10704c() == 12 || c3202a.m9183a().m10707a() == 6) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RC_RETURN));
        }
        if (m9169b.m10063x() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BATTERY_UPDATED_FAIL));
        }
        if (c3202a.m9183a().m10704c() == 13 || c3202a.m9183a().m10707a() == 1) {
            if (!m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_RPT_NON_AUTO_MODE));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_RPT_NON_AUTO_MODE));
            }
        } else if (m9169b.m10129L() && !c3202a.m9183a().m10700g().isLightStream()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_GPS_NOSIG));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_GPS_NOSIG));
            }
        }
        if (m9169b.m10128M()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_CAMP_NCAL));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_CAMP_NCAL));
            }
        }
        if (m9169b.m10127N() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUACCEL_NCAL));
        }
        if (m9169b.m10126O() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_ORTH_NCAL));
        }
        if (m9169b.m10125P() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_IMUGYRO_NCAL));
        }
        if ((m9169b.m10124Q() || c3202a.m9183a().m10704c() == 2 || c3202a.m9183a().m10707a() == 7) && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_G_ATT_INV));
        }
        if (c3202a.m9183a().m10704c() == 19 || c3202a.m9183a().m10707a() == 10) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.str_ap_rpt_app_unconnected));
        }
        if (m9169b.m10121T() || c3202a.m9183a().m10704c() == 3 || c3202a.m9183a().m10707a() == 5) {
            if (m9161j) {
                if (c3202a.m9183a().m10702e() == 9) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_landing_BAT_LOWPOWER));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_LOWPOWER));
                }
                m9093a(true, false, C2300R.C2303string.sky_LOWPOWER);
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_LOWPOWER));
                m9093a(false, false, C2300R.C2303string.land_LOWPOWER);
            }
            m9092a(C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.land_BAT_LOWPOWER, C2300R.C2303string.sky_LP_RETURN);
        } else if (m9169b.m10123R()) {
            m9092a(C2300R.C2303string.sky_LOWPOWER, C2300R.C2303string.land_LOWPOWER, C2300R.C2303string.sky_LP_RETURN);
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BAT_light_LOWPOWER));
                m9093a(true, false, C2300R.C2303string.sky_BAT_light_LOWPOWER);
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BAT_LOWPOWER));
                m9093a(false, false, C2300R.C2303string.land_BAT_LOWPOWER);
            }
        } else if (m9169b.m10122S()) {
            m9092a(C2300R.C2303string.sky_LOWPOWER, C2300R.C2303string.land_LOWPOWER, C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.land_BAT_LOWPOWER);
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_LP_RETURN));
                m9093a(true, false, C2300R.C2303string.sky_LP_RETURN);
            }
        } else {
            m9092a(C2300R.C2303string.sky_BAT_light_LOWPOWER, C2300R.C2303string.sky_LP_RETURN, C2300R.C2303string.land_BAT_LOWPOWER, C2300R.C2303string.sky_landing_BAT_LOWPOWER, C2300R.C2303string.sky_LOWPOWER);
        }
        if (m9169b.m10120U()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_POWER_HIGHTEMP));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_POWER_HIGHTEMP));
            }
            m9093a(false, false, m9161j ? C2300R.C2303string.sky_POWER_HIGHTEMP : C2300R.C2303string.land_POWER_HIGHTEMP);
        } else {
            int[] iArr2 = new int[1];
            iArr2[0] = m9161j ? C2300R.C2303string.sky_POWER_HIGHTEMP : C2300R.C2303string.land_POWER_HIGHTEMP;
            m9092a(iArr2);
        }
        if (!m9169b.m10103ai()) {
            m9092a(C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky, C2300R.C2303string.sky_BATTERY_SHORTLIFE);
        } else if (!m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_SHORTLIFE));
            m9093a(false, false, C2300R.C2303string.sky_BATTERY_SHORTLIFE);
        } else {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky));
            m9093a(true, false, C2300R.C2303string.sky_BATTERY_SHORTLIFE_InSky);
        }
        if (!m9169b.m10102aj()) {
            m9092a(C2300R.C2303string.sky_MAXIMUM_ALTITUDE);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_MAXIMUM_ALTITUDE));
            m9093a(false, false, C2300R.C2303string.sky_MAXIMUM_ALTITUDE);
        }
        if (!m9169b.m10101ak()) {
            m9092a(C2300R.C2303string.sky_MAXIMUM_DISTANCE);
        } else if (m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_MAXIMUM_DISTANCE));
            m9093a(false, false, C2300R.C2303string.sky_MAXIMUM_DISTANCE);
        }
        if (!m9169b.m10100al() || !m9161j) {
        }
        if (m9169b.m10099am() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_BAT_PREHEAT));
        }
        if (m9169b.m10065v()) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_NfzDataInvalid));
            m9093a(false, false, C2300R.C2303string.land_NfzDataInvalid);
        } else {
            m9092a(C2300R.C2303string.land_NfzDataInvalid);
        }
        if (!m9169b.m10119V()) {
            m9092a(C2300R.C2303string.land_single_cell_battery);
        } else if (!m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_single_cell_battery));
            m9093a(false, false, C2300R.C2303string.land_single_cell_battery);
        }
        if (m9169b.m10061z()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imag_interface));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_imag_interface));
            }
        }
        if (m9169b.m10064w()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_imu_overtemperature));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_imu_overtemperature));
            }
        }
        if (m9161j) {
            if (m9169b.m10117X()) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.stick_move_warning_result));
                m9093a(false, false, C2300R.C2303string.stick_move_warning_des);
            } else {
                m9092a(C2300R.C2303string.stick_move_warning_des);
            }
        }
        if ((c3202a.m9183a().m10700g().isEnforcementAtti() || c3202a.m9183a().m10700g().isLightStream()) && c3202a.m9156o().m10582a()) {
            if (m9169b.m10116Y()) {
                if (m9161j) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sonar_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sonar_error));
                }
            }
            if (m9169b.m10115Z()) {
                if (m9161j) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.camera_disconnect_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.camera_disconnect));
                }
            }
            if (m9169b.m10111aa()) {
                if (m9161j) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.imagequality_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.imagequality_error));
                }
            }
            if (!m9169b.m10096ap() || !m9161j) {
            }
            if (m9169b.m10110ab()) {
                if (m9161j) {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.estimatexy_error_sky));
                } else {
                    errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.estimatexy_error));
                }
            }
        }
        if (!m9161j && m9169b.m10062y()) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.str_at_rpt_bat_err));
        }
        if (m9169b.m10095aq()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.is_min_hight));
                m9093a(false, false, C2300R.C2303string.is_min_hight);
            } else {
                m9092a(C2300R.C2303string.is_min_hight);
            }
        }
        if (m9169b.m10094ar() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_calidata_invalid));
        }
        if (m9169b.m10093as() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_warning_up));
        }
        if (m9169b.m10092at()) {
            if (m9161j) {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_cooling_down));
            } else {
                errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_cooling_down));
            }
        }
        if (m9169b.m10091au() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_bat_v_rp_mismatch));
        }
        if (m9169b.m10090av() && m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.sky_above_nfz_limit_height));
        }
        if (m9169b.m10089aw() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_dnfz_updating));
        }
        if (m9169b.m10088ax() && !m9161j) {
            errorMode.getLightErrorList().add(Integer.valueOf((int) C2300R.C2303string.land_ahrs_not_ready));
        }
        return errorMode;
    }

    /* renamed from: a */
    public void m9093a(boolean z, boolean z2, int i) {
        if (!f12341b.containsKey(Integer.valueOf(i))) {
            f12341b.put(Integer.valueOf(i), new C2456g(z, z2, i));
        }
    }

    /* renamed from: a */
    public void m9092a(int... iArr) {
        for (int i : iArr) {
            if (f12341b.containsKey(Integer.valueOf(i))) {
                f12341b.remove(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: c */
    public void m9090c() {
        m9092a(C2300R.C2303string.sky_landing_BAT_LOWPOWER, C2300R.C2303string.sky_LP_RETURN);
    }
}
