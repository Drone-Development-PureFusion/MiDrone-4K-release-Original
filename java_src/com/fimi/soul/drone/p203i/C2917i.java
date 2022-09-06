package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.i */
/* loaded from: classes.dex */
public class C2917i extends AbstractC2860a {

    /* renamed from: a */
    private boolean f10993a = true;

    /* renamed from: b */
    private EnumC2921d f10994b = EnumC2921d.Mid;

    /* renamed from: c */
    private EnumC2923f f10995c = EnumC2923f.DateTime;

    /* renamed from: d */
    private EnumC2922e f10996d = EnumC2922e._1280x720_120p_16vs9;

    /* renamed from: e */
    private EnumC2918a f10997e = EnumC2918a._13M_4128X3096_4vs3;

    /* renamed from: f */
    private EnumC2920c f10998f = EnumC2920c.Normal;

    /* renamed from: g */
    private EnumC2919b f10999g = EnumC2919b.DateTime;

    /* renamed from: h */
    private boolean f11000h = true;

    /* renamed from: i */
    private boolean f11001i = true;

    /* renamed from: j */
    private boolean f11002j = true;

    /* renamed from: k */
    private int f11003k = 0;

    /* renamed from: l */
    private short f11004l = 0;

    /* renamed from: m */
    private short f11005m = 0;

    /* renamed from: com.fimi.soul.drone.i.i$a */
    /* loaded from: classes.dex */
    public enum EnumC2918a {
        _16M_4068x3456_4vs3,
        _13M_4128X3096_4vs3,
        _8M_3264X2448_4vs3,
        _5M_2560X1920_4vs3
    }

    /* renamed from: com.fimi.soul.drone.i.i$b */
    /* loaded from: classes.dex */
    public enum EnumC2919b {
        Date,
        Time,
        DateTime
    }

    /* renamed from: com.fimi.soul.drone.i.i$c */
    /* loaded from: classes.dex */
    public enum EnumC2920c {
        Normal,
        TimeLapse,
        BurstShot
    }

    /* renamed from: com.fimi.soul.drone.i.i$d */
    /* loaded from: classes.dex */
    public enum EnumC2921d {
        High,
        Mid,
        Low
    }

    /* renamed from: com.fimi.soul.drone.i.i$e */
    /* loaded from: classes.dex */
    public enum EnumC2922e {
        _1920x1080_60p_16vs9,
        _1920x1080_30p_16vs9,
        _1920x1080_48p_16vs9,
        _1920x1080_24p_16vs9,
        _1280x960_60p_4vs3,
        _1280x960_48p_4vs3,
        _1280x720_60p_16vs9,
        _1280x720_48p_16vs9,
        _1280x720_120p_16vs9,
        _848x480_240p_16vs9
    }

    /* renamed from: com.fimi.soul.drone.i.i$f */
    /* loaded from: classes.dex */
    public enum EnumC2923f {
        Date,
        Time,
        DateTime
    }

    /* renamed from: a */
    private EnumC2921d m10283a(byte b) {
        if (b == 1) {
            return EnumC2921d.High;
        }
        if (b != 2 && b == 3) {
            return EnumC2921d.Low;
        }
        return EnumC2921d.Mid;
    }

    /* renamed from: b */
    private EnumC2923f m10273b(byte b) {
        if (b == 1) {
            return EnumC2923f.Date;
        }
        if (b == 2) {
            return EnumC2923f.Time;
        }
        if (b == 3) {
            return EnumC2923f.DateTime;
        }
        EnumC2923f enumC2923f = this.f10995c;
        return EnumC2923f.Date;
    }

    /* renamed from: c */
    private EnumC2922e m10268c(byte b) {
        if (b == 1) {
            return EnumC2922e._1920x1080_60p_16vs9;
        }
        if (b == 2) {
            return EnumC2922e._1920x1080_30p_16vs9;
        }
        if (b == 3) {
            return EnumC2922e._1920x1080_48p_16vs9;
        }
        if (b == 4) {
            return EnumC2922e._1920x1080_24p_16vs9;
        }
        if (b == 5) {
            return EnumC2922e._1280x960_60p_4vs3;
        }
        if (b == 6) {
            return EnumC2922e._1280x960_48p_4vs3;
        }
        if (b == 7) {
            return EnumC2922e._1280x720_60p_16vs9;
        }
        if (b == 8) {
            return EnumC2922e._1280x720_48p_16vs9;
        }
        if (b != 9 && b == 10) {
            return EnumC2922e._848x480_240p_16vs9;
        }
        return EnumC2922e._1280x720_120p_16vs9;
    }

    /* renamed from: d */
    private EnumC2918a m10265d(byte b) {
        return b == 1 ? EnumC2918a._16M_4068x3456_4vs3 : b == 2 ? EnumC2918a._13M_4128X3096_4vs3 : b == 3 ? EnumC2918a._8M_3264X2448_4vs3 : b == 4 ? EnumC2918a._5M_2560X1920_4vs3 : EnumC2918a._16M_4068x3456_4vs3;
    }

    /* renamed from: e */
    private EnumC2920c m10262e(byte b) {
        return b == 1 ? EnumC2920c.Normal : b == 2 ? EnumC2920c.TimeLapse : b == 3 ? EnumC2920c.BurstShot : EnumC2920c.Normal;
    }

    /* renamed from: f */
    private EnumC2919b m10260f(byte b) {
        return b == 1 ? EnumC2919b.Date : b == 2 ? EnumC2919b.Time : b == 3 ? EnumC2919b.DateTime : EnumC2919b.DateTime;
    }

    /* renamed from: g */
    private byte m10258g(byte b) {
        return (byte) (b & 63);
    }

    /* renamed from: h */
    private byte m10256h(byte b) {
        return (byte) ((b & 192) >>> 6);
    }

    @Override // com.fimi.soul.drone.p193d.AbstractC2682a
    /* renamed from: a */
    public void mo10248a(C2771d c2771d) {
        c2771d.m11052c();
        m10279a(m10283a(c2771d.m11050d()));
        m10277a(m10273b(c2771d.m11050d()));
        m10278a(m10268c(c2771d.m11050d()));
        m10282a(m10265d(c2771d.m11050d()));
        m10280a(m10262e(c2771d.m11050d()));
        m10281a(m10260f(c2771d.m11050d()));
        if (c2771d.m11050d() == 2) {
            m10267c(true);
        } else {
            m10267c(false);
        }
        if (c2771d.m11050d() == 2) {
            m10270b(true);
        } else {
            m10270b(false);
        }
        if (c2771d.m11050d() == 2) {
            m10267c(true);
        } else {
            m10267c(false);
        }
        if (a() == 51) {
            this.f11003k = c2771d.m11048f();
            this.f11004l = c2771d.m11049e();
            this.f11005m = c2771d.m11049e();
        }
    }

    /* renamed from: a */
    public void m10282a(EnumC2918a enumC2918a) {
        this.f10997e = enumC2918a;
    }

    /* renamed from: a */
    public void m10281a(EnumC2919b enumC2919b) {
        this.f10999g = enumC2919b;
    }

    /* renamed from: a */
    public void m10280a(EnumC2920c enumC2920c) {
        this.f10998f = enumC2920c;
    }

    /* renamed from: a */
    public void m10279a(EnumC2921d enumC2921d) {
        this.f10994b = enumC2921d;
    }

    /* renamed from: a */
    public void m10278a(EnumC2922e enumC2922e) {
        this.f10996d = enumC2922e;
    }

    /* renamed from: a */
    public void m10277a(EnumC2923f enumC2923f) {
        this.f10995c = enumC2923f;
    }

    /* renamed from: a */
    public void m10276a(short s) {
        this.f11004l = s;
    }

    /* renamed from: a */
    public void m10275a(boolean z) {
        this.f11000h = z;
    }

    /* renamed from: b */
    public EnumC2918a m10274b() {
        return this.f10997e;
    }

    /* renamed from: b */
    public void m10272b(int i) {
        this.f11003k = i;
    }

    /* renamed from: b */
    public void m10271b(short s) {
        this.f11005m = s;
    }

    /* renamed from: b */
    public void m10270b(boolean z) {
        this.f11001i = z;
    }

    /* renamed from: c */
    public EnumC2919b m10269c() {
        return this.f10999g;
    }

    /* renamed from: c */
    public void m10267c(boolean z) {
        this.f11002j = z;
    }

    /* renamed from: d */
    public void m10264d(boolean z) {
        this.f10993a = z;
    }

    /* renamed from: d */
    public boolean m10266d() {
        return this.f11000h;
    }

    /* renamed from: e */
    public boolean m10263e() {
        return this.f11001i;
    }

    /* renamed from: f */
    public boolean m10261f() {
        return this.f11002j;
    }

    /* renamed from: g */
    public EnumC2922e m10259g() {
        return this.f10996d;
    }

    /* renamed from: h */
    public boolean m10257h() {
        return this.f10993a;
    }

    /* renamed from: i */
    public EnumC2923f m10255i() {
        return this.f10995c;
    }

    /* renamed from: j */
    public EnumC2921d m10254j() {
        return this.f10994b;
    }

    /* renamed from: k */
    public EnumC2920c m10253k() {
        return this.f10998f;
    }

    /* renamed from: l */
    public int m10252l() {
        return this.f11003k;
    }

    /* renamed from: m */
    public short m10251m() {
        return this.f11004l;
    }

    /* renamed from: n */
    public short m10250n() {
        return this.f11005m;
    }

    public String toString() {
        return "CloudCameraVariable{isLenAC=" + this.f10993a + ", videoQualityType=" + this.f10994b + ", videoTimeStampType=" + this.f10995c + ", videoResolutionType=" + this.f10996d + ", imageResolutionType=" + this.f10997e + ", shotModeType=" + this.f10998f + ", photoTimeStampType=" + this.f10999g + ", enableAutoLowLight=" + this.f11000h + ", enableRecycleRecord=" + this.f11001i + ", enableAutoAC=" + this.f11002j + ", cameraTime=" + this.f11003k + ", cameraTotalStorage=" + ((int) this.f11004l) + ", cameraRemainStorage=" + ((int) this.f11005m) + C0359h.f726w;
    }
}
