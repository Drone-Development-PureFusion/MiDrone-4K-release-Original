package com.fimi.soul.module.setting.GimalCalibration;

import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.module.dronemanage.C3255k;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.module.setting.GimalCalibration.a */
/* loaded from: classes.dex */
public class C3450a implements C2678d.AbstractC2680b, C3255k.AbstractC3258a {

    /* renamed from: a */
    public static int f13575a = 100;

    /* renamed from: b */
    public static final byte f13576b = 7;

    /* renamed from: c */
    public static final byte f13577c = 8;

    /* renamed from: d */
    public static final byte f13578d = 6;

    /* renamed from: e */
    public static final byte f13579e = 5;

    /* renamed from: f */
    public static final int f13580f = 2;

    /* renamed from: j */
    private static final byte f13581j = 0;

    /* renamed from: h */
    AbstractC3452a f13583h;

    /* renamed from: i */
    C2657a f13584i;

    /* renamed from: q */
    private boolean f13591q;

    /* renamed from: g */
    C3255k f13582g = null;

    /* renamed from: k */
    private final int f13585k = 0;

    /* renamed from: l */
    private final int f13586l = 1;

    /* renamed from: m */
    private final int f13587m = 2;

    /* renamed from: n */
    private final int f13588n = 3;

    /* renamed from: o */
    private final int f13589o = 4;

    /* renamed from: p */
    private final int f13590p = 5;

    /* renamed from: com.fimi.soul.module.setting.GimalCalibration.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC3452a {
        /* renamed from: a */
        void mo8233a(int i);

        /* renamed from: a */
        void mo8230a(String str);

        /* renamed from: b */
        void mo8228b();

        /* renamed from: b */
        void mo8227b(int i);

        /* renamed from: c */
        void mo8225c();

        /* renamed from: d */
        void mo8223d();

        /* renamed from: e */
        void mo8221e();
    }

    public C3450a(AbstractC3452a abstractC3452a, C2657a c2657a) {
        this.f13583h = abstractC3452a;
        this.f13584i = c2657a;
    }

    /* renamed from: b */
    private void m8428b(byte b) {
        String m8431a = m8431a(b);
        if (this.f13583h != null) {
            this.f13591q = false;
            if (m8431a != null) {
                this.f13583h.mo8230a(m8431a);
            } else {
                this.f13583h.mo8230a(this.f13584i.f9270d.getString(C2300R.C2303string.GC_califail));
            }
        }
    }

    /* renamed from: c */
    private void m8425c(byte b) {
        String m8422d = m8422d(b);
        if (this.f13583h != null) {
            this.f13591q = false;
            if (m8422d != null) {
                this.f13583h.mo8230a(m8422d);
            } else {
                this.f13583h.mo8230a((String) null);
            }
        }
    }

    /* renamed from: d */
    private C2770c m8421d(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 1;
        c2770c.f10263c = 122;
        c2770c.f10264d.m11055b((byte) i);
        return c2770c;
    }

    /* renamed from: d */
    private String m8422d(byte b) {
        for (int i = 0; i < 8; i++) {
            if (C3658ar.m7621a(b, i) > 0) {
                switch (i) {
                    case 0:
                        return m8427b(C2300R.C2303string.gmail_hight_temp_tune);
                    case 1:
                        return m8427b(C2300R.C2303string.gmail_low_temp_tune);
                    case 2:
                        return m8427b(C2300R.C2303string.gmail_temperature_low_accuracy_tune);
                    case 3:
                        return m8427b(C2300R.C2303string.GC_horLine_uneven);
                    case 4:
                        return m8427b(C2300R.C2303string.GC_hight_Vibrator);
                    case 5:
                        return m8427b(C2300R.C2303string.GC_wrong_angle);
                }
            }
        }
        return null;
    }

    /* renamed from: h */
    private void m8417h() {
        int m10671b = this.f13584i.m11311au().m10671b() & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (m10671b > 0) {
            m8428b((byte) m10671b);
            return;
        }
        byte m10668d = this.f13584i.m11311au().m10668d();
        this.f13583h.mo8233a(m10668d);
        if (m10668d != f13575a) {
            return;
        }
        this.f13591q = false;
        m8419f();
        this.f13583h.mo8223d();
    }

    /* renamed from: i */
    private void m8416i() {
        byte m10671b = this.f13584i.m11311au().m10671b();
        if (m10671b > 0) {
            m8425c(m10671b);
            return;
        }
        this.f13583h.mo8233a(this.f13584i.m11311au().m10668d());
    }

    /* renamed from: a */
    public String m8431a(byte b) {
        for (int i = 0; i < 8; i++) {
            if (C3658ar.m7621a(b, i) > 0) {
                switch (i) {
                    case 0:
                        return m8427b(C2300R.C2303string.GC_hight_temperature);
                    case 1:
                        return m8427b(C2300R.C2303string.GC_low_temperature);
                    case 2:
                        return m8427b(C2300R.C2303string.GC_temperature_low_accuracy);
                    case 3:
                        return m8427b(C2300R.C2303string.GC_horLine_uneven);
                    case 4:
                        return m8427b(C2300R.C2303string.GC_hight_Vibrator);
                    case 5:
                        return m8427b(C2300R.C2303string.GC_wrong_angle);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m8432a() {
        C2770c m8426c = m8426c();
        this.f13584i.mo11217ab().mo10897a(m8426c);
        if (this.f13582g == null) {
            this.f13582g = C3255k.m8929a(this);
        }
        this.f13582g.m8930a(this.f13584i, m8426c);
        this.f13582g.m8928b();
        this.f13591q = true;
    }

    @Override // com.fimi.soul.module.dronemanage.C3255k.AbstractC3258a
    /* renamed from: a */
    public void mo8430a(int i) {
    }

    /* renamed from: b */
    public String m8427b(int i) {
        return this.f13584i.f9270d.getResources().getString(i);
    }

    /* renamed from: b */
    public void m8429b() {
        if (this.f13582g != null) {
            this.f13583h.mo8228b();
            this.f13582g.m8926d();
            this.f13582g.m8927c();
            this.f13582g = null;
        }
    }

    /* renamed from: c */
    public C2770c m8426c() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 2;
        c2770c.f10263c = 122;
        c2770c.f10264d.m11055b((byte) 8);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: c */
    public void m8424c(int i) {
        this.f13584i.mo11217ab().mo10897a(m8421d(i));
    }

    /* renamed from: d */
    public void m8423d() {
        C3057d.m9823a(this.f13584i).m9799r();
    }

    /* renamed from: e */
    public void m8420e() {
        this.f13584i.mo11219a(this);
    }

    /* renamed from: f */
    public void m8419f() {
        this.f13584i.mo11214b(this);
    }

    /* renamed from: g */
    public void m8418g() {
        if (this.f13583h != null) {
            this.f13583h = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case GimbalCalibration:
                if (c2657a.m11311au().m10669c() == 8) {
                    m8429b();
                    m8417h();
                    return;
                } else if (c2657a.m11311au().m10669c() == 6) {
                    m8416i();
                    return;
                } else if (c2657a.m11311au().m10669c() != 5 || this.f13583h == null) {
                    return;
                } else {
                    this.f13583h.mo8225c();
                    return;
                }
            case CLEANALLOBJ:
                if (this.f13583h == null || !this.f13591q) {
                    return;
                }
                this.f13583h.mo8230a(m8427b(C2300R.C2303string.GC_caliFail_discon));
                return;
            case Remotecontrol:
                if (this.f13583h != null && !this.f13591q) {
                    this.f13583h.mo8221e();
                    return;
                } else if (this.f13583h != null && !c2657a.mo11216ac() && this.f13591q) {
                    this.f13583h.mo8230a(m8427b(C2300R.C2303string.GC_caliFail_discon_drone));
                    return;
                } else if (this.f13583h == null || !this.f13591q) {
                    return;
                } else {
                    if (c2657a.m11318an().m10108ad()) {
                        this.f13583h.mo8230a(m8427b(C2300R.C2303string.GC_hight_temperature));
                        return;
                    } else if (!c2657a.m11318an().m10066u()) {
                        return;
                    } else {
                        this.f13583h.mo8230a(m8427b(C2300R.C2303string.discongc));
                        return;
                    }
                }
            default:
                return;
        }
    }
}
