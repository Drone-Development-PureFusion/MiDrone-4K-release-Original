package com.fimi.soul.drone.p203i;

import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.drone.i.x */
/* loaded from: classes.dex */
public class C2940x extends C2822e {

    /* renamed from: b */
    private int f11110b;

    /* renamed from: c */
    private int f11111c;

    /* renamed from: d */
    private int f11112d;

    /* renamed from: f */
    private int f11114f;

    /* renamed from: g */
    private int f11115g;

    /* renamed from: h */
    private int f11116h;

    /* renamed from: i */
    private int f11117i;

    /* renamed from: j */
    private int f11118j;

    /* renamed from: k */
    private int f11119k;

    /* renamed from: e */
    private int f11113e = 0;

    /* renamed from: l */
    private int[] f11120l = {C2300R.C2303string.self_error_gps, C2300R.C2303string.self_error_nofly, C2300R.C2303string.self_error_compass1, C2300R.C2303string.self_error_compass2, C2300R.C2303string.self_error_accelerometer, C2300R.C2303string.self_error_gyroscope, C2300R.C2303string.self_error_barometer, C2300R.C2303string.self_error_battery, C2300R.C2303string.self_error_battery_copyright, C2300R.C2303string.self_error_unknown, C2300R.C2303string.self_error_Optic_flow, C2300R.C2303string.self_error_Optic_flow_not_found, C2300R.C2303string.self_error_optic_flow_sonar, C2300R.C2303string.self_error_optic_flow_camera, C2300R.C2303string.self_error_gc, C2300R.C2303string.self_error_gc_not_found};

    /* renamed from: m */
    private int[] f11121m = {C2300R.C2303string.fault_gps, C2300R.C2303string.fault_compass, C2300R.C2303string.fault_accelerometer, C2300R.C2303string.fault_level, C2300R.C2303string.fault_gyroscope, C2300R.C2303string.fault_gesture, C2300R.C2303string.fault_back_battery, C2300R.C2303string.fault_low_battery, C2300R.C2303string.fault_power_hightlemp, C2300R.C2303string.fault_ultrasonic_data_invalid, C2300R.C2303string.fault_Optic_flow_invalid, C2300R.C2303string.fault_Optic_flow_bad, C2300R.C2303string.fault_accelerometer_data_invalid, C2300R.C2303string.fault_barometer_data_invalid, C2300R.C2303string.fault_hight_data_invalid, C2300R.C2303string.fault_texture_quality, C2300R.C2303string.fault_gc, C2300R.C2303string.fault_super_heat, C2300R.C2303string.fault_self_fail, C2300R.C2303string.fault_sevo_stal, C2300R.C2303string.fault_gc_heat_error, C2300R.C2303string.fault_ahrs, C2300R.C2303string.fault_short_life_battery, C2300R.C2303string.fault_max_hight, C2300R.C2303string.fault_max_distance, C2300R.C2303string.fault_gc_pre_heart, C2300R.C2303string.fault_bat_pre_heart};

    public C2940x() {
    }

    public C2940x(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: c */
    private int m10084c(int i) {
        for (int i2 = 0; i2 < 32; i2++) {
            if (C3658ar.m7621a(i, i2) > 0) {
                return i2;
            }
        }
        return -1;
    }

    @Deprecated
    /* renamed from: A */
    public boolean m10140A() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-21))) > 0;
    }

    /* renamed from: B */
    public boolean m10139B() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-22))) > 0;
    }

    /* renamed from: C */
    public boolean m10138C() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-23))) > 0;
    }

    /* renamed from: D */
    public boolean m10137D() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-24))) > 0;
    }

    /* renamed from: E */
    public boolean m10136E() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-25))) > 0;
    }

    /* renamed from: F */
    public boolean m10135F() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-26))) > 0;
    }

    /* renamed from: G */
    public boolean m10134G() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-27))) > 0;
    }

    /* renamed from: H */
    public boolean m10133H() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-28))) > 0;
    }

    /* renamed from: I */
    public boolean m10132I() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-29))) > 0;
    }

    /* renamed from: J */
    public boolean m10131J() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-30))) > 0;
    }

    /* renamed from: K */
    public boolean m10130K() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-31))) > 0;
    }

    /* renamed from: L */
    public boolean m10129L() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + 0)) > 0;
    }

    /* renamed from: M */
    public boolean m10128M() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-1))) > 0;
    }

    /* renamed from: N */
    public boolean m10127N() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-2))) > 0;
    }

    /* renamed from: O */
    public boolean m10126O() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-3))) > 0;
    }

    /* renamed from: P */
    public boolean m10125P() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-4))) > 0;
    }

    /* renamed from: Q */
    public boolean m10124Q() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-5))) > 0;
    }

    /* renamed from: R */
    public boolean m10123R() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-6))) > 0;
    }

    /* renamed from: S */
    public boolean m10122S() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-7))) > 0;
    }

    /* renamed from: T */
    public boolean m10121T() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-8))) > 0;
    }

    /* renamed from: U */
    public boolean m10120U() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-9))) > 0;
    }

    /* renamed from: V */
    public boolean m10119V() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-10))) > 0;
    }

    /* renamed from: W */
    public boolean m10118W() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-11))) > 0;
    }

    /* renamed from: X */
    public boolean m10117X() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-12))) > 0;
    }

    /* renamed from: Y */
    public boolean m10116Y() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-13))) > 0;
    }

    /* renamed from: Z */
    public boolean m10115Z() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-14))) > 0;
    }

    /* renamed from: a */
    public int m10114a() {
        return this.f11119k;
    }

    /* renamed from: a */
    public void m10113a(int i) {
        this.f11114f = i;
    }

    /* renamed from: a */
    public void m10112a(int i, int i2, short s, int i3) {
        this.f11110b = i;
        this.f11111c = i2;
        this.f11112d = i3;
        this.f11116h = m10084c(i);
        this.f11117i = m10084c(i2);
        this.f11118j = m10084c(i3);
        this.f11119k = this.f11116h;
        if (this.f11116h >= 0 || this.f11117i >= 0 || this.f11118j >= 0) {
            this.f11114f = C2300R.C2303string.self_error_result;
            if (this.f11116h >= 0 && this.f11116h < this.f11120l.length) {
                this.f11115g = this.f11120l[this.f11116h];
            }
            if (this.f11116h >= 0) {
                this.f11119k = this.f11116h;
            }
            if (this.f11117i >= 0 && this.f11117i < this.f11121m.length) {
                this.f11115g = this.f11121m[this.f11117i];
            }
            if (this.f11117i >= 0) {
                this.f11119k = this.f11117i;
            }
        }
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.ERROR_CODE);
        }
    }

    /* renamed from: aa */
    public boolean m10111aa() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-15))) > 0;
    }

    /* renamed from: ab */
    public boolean m10110ab() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-16))) > 0;
    }

    /* renamed from: ac */
    public boolean m10109ac() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-17))) > 0;
    }

    /* renamed from: ad */
    public boolean m10108ad() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-18))) > 0;
    }

    /* renamed from: ae */
    public boolean m10107ae() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-19))) > 0;
    }

    /* renamed from: af */
    public boolean m10106af() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-20))) > 0;
    }

    /* renamed from: ag */
    public boolean m10105ag() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-21))) > 0;
    }

    /* renamed from: ah */
    public boolean m10104ah() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-22))) > 0;
    }

    /* renamed from: ai */
    public boolean m10103ai() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-23))) > 0;
    }

    /* renamed from: aj */
    public boolean m10102aj() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-24))) > 0;
    }

    /* renamed from: ak */
    public boolean m10101ak() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-25))) > 0;
    }

    /* renamed from: al */
    public boolean m10100al() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-26))) > 0;
    }

    /* renamed from: am */
    public boolean m10099am() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-27))) > 0;
    }

    /* renamed from: an */
    public boolean m10098an() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-28))) > 0;
    }

    /* renamed from: ao */
    public boolean m10097ao() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-29))) > 0;
    }

    /* renamed from: ap */
    public boolean m10096ap() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-30))) > 0;
    }

    /* renamed from: aq */
    public boolean m10095aq() {
        return C3658ar.m7621a(this.f11111c, Math.abs(this.f11113e + (-31))) > 0;
    }

    /* renamed from: ar */
    public boolean m10094ar() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + 0)) > 0;
    }

    /* renamed from: as */
    public boolean m10093as() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-1))) > 0;
    }

    /* renamed from: at */
    public boolean m10092at() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-2))) > 0;
    }

    /* renamed from: au */
    public boolean m10091au() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-3))) > 0;
    }

    /* renamed from: av */
    public boolean m10090av() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-4))) > 0;
    }

    /* renamed from: aw */
    public boolean m10089aw() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-5))) > 0;
    }

    /* renamed from: ax */
    public boolean m10088ax() {
        return C3658ar.m7621a(this.f11112d, Math.abs(this.f11113e + (-6))) > 0;
    }

    /* renamed from: b */
    public int m10087b() {
        return this.f11116h;
    }

    /* renamed from: b */
    public void m10086b(int i) {
        this.f11115g = i;
    }

    /* renamed from: c */
    public int m10085c() {
        return this.f11117i;
    }

    /* renamed from: d */
    public int m10083d() {
        return this.f11114f;
    }

    /* renamed from: e */
    public int m10082e() {
        return this.f11115g;
    }

    /* renamed from: f */
    public boolean m10081f() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + 0)) > 0;
    }

    /* renamed from: g */
    public boolean m10080g() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-1))) > 0;
    }

    /* renamed from: h */
    public boolean m10079h() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-2))) > 0;
    }

    /* renamed from: i */
    public boolean m10078i() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-3))) > 0;
    }

    /* renamed from: j */
    public boolean m10077j() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-4))) > 0;
    }

    /* renamed from: k */
    public boolean m10076k() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-5))) > 0;
    }

    /* renamed from: l */
    public boolean m10075l() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-6))) > 0;
    }

    /* renamed from: m */
    public boolean m10074m() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-7))) > 0;
    }

    /* renamed from: n */
    public boolean m10073n() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-8))) > 0;
    }

    /* renamed from: o */
    public boolean m10072o() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-9))) > 0;
    }

    /* renamed from: p */
    public boolean m10071p() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-10))) > 0;
    }

    /* renamed from: q */
    public boolean m10070q() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-11))) > 0;
    }

    /* renamed from: r */
    public boolean m10069r() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-12))) > 0;
    }

    /* renamed from: s */
    public boolean m10068s() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-13))) > 0;
    }

    /* renamed from: t */
    public boolean m10067t() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-14))) > 0;
    }

    public String toString() {
        return "selftErrorIndex=" + this.f11116h + "faultErrorIndex=" + this.f11117i + " GPS模块损坏 =" + m10081f() + " 处于禁飞区=" + m10080g() + " 罗盘1损坏=" + m10079h() + " 罗盘2损坏=" + m10078i() + " 加速度计损坏=" + m10077j() + " 陀螺损坏=" + m10076k() + " 气压计损坏=" + m10075l() + " 电池损坏=" + m10074m() + " 电池非法=" + m10073n() + " 未知故障=" + m10072o() + " 光流损坏=" + m10071p() + " 未挂光流=" + m10070q() + " 未挂云台=" + m10066u() + " GPS无信号=" + m10129L() + " 罗盘待校准=" + m10128M() + " 加速度计待校准=" + m10127N() + " 水平校准=" + m10126O() + " 陀螺带校准=" + m10125P() + " 地面姿态偏移=" + m10124Q() + " 低于返航电量=" + m10122S() + " 低电告警=" + m10121T() + " 温度过高=" + m10120U() + " 单节电池电压异常=" + m10119V() + " 危险低电告警，可能导致电池损坏或坠机=" + m10118W() + " 纹理质量=" + m10110ab() + " 云台故障=" + m10109ac() + " 过热=" + m10108ad() + " 自检失败=" + m10107ae() + " 电机堵转=" + m10106af() + " 重心错误=" + m10105ag() + " AHRS不可用=" + m10104ah() + " 电池寿命不足=" + m10103ai() + " faultError =" + Integer.toBinaryString(this.f11111c) + " selfError=" + Integer.toBinaryString(this.f11110b);
    }

    /* renamed from: u */
    public boolean m10066u() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-15))) > 0;
    }

    /* renamed from: v */
    public boolean m10065v() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-16))) > 0;
    }

    /* renamed from: w */
    public boolean m10064w() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-17))) > 0;
    }

    /* renamed from: x */
    public boolean m10063x() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-18))) > 0;
    }

    /* renamed from: y */
    public boolean m10062y() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-19))) > 0;
    }

    /* renamed from: z */
    public boolean m10061z() {
        return C3658ar.m7621a(this.f11110b, Math.abs(this.f11113e + (-20))) > 0;
    }
}
