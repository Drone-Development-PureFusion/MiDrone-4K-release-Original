package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.kernel.utils.C2258f;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2917i;
import com.fimi.soul.module.dronemanage.C3231a;
import com.fimi.soul.module.dronemanage.C3260m;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.fimi.soul.drone.d.a.a.f */
/* loaded from: classes.dex */
public class C2746f {

    /* renamed from: a */
    public static final int f10080a = 49;

    /* renamed from: b */
    public static final int f10081b = 51;

    /* renamed from: c */
    public static final int f10082c = 50;

    /* renamed from: d */
    public static final int f10083d = 51;

    /* renamed from: e */
    private static C2746f f10084e;

    /* renamed from: f */
    private C2657a f10085f;

    /* renamed from: g */
    private C3231a f10086g;

    /* renamed from: h */
    private C3231a f10087h;

    /* renamed from: i */
    private C3231a f10088i;

    /* renamed from: j */
    private C3231a f10089j;

    /* renamed from: k */
    private SimpleDateFormat f10090k = new SimpleDateFormat(C2258f.f7530e);

    /* renamed from: com.fimi.soul.drone.d.a.a.f$a */
    /* loaded from: classes.dex */
    public enum EnumC2748a {
        StartRecord,
        TakePhoto,
        StopRecord
    }

    private C2746f() {
    }

    /* renamed from: a */
    public static synchronized C2746f m11170a(C2657a c2657a) {
        C2746f c2746f;
        synchronized (C2746f.class) {
            if (f10084e == null) {
                f10084e = new C2746f();
                f10084e.f10085f = c2657a;
            }
            c2746f = f10084e;
        }
        return c2746f;
    }

    /* renamed from: a */
    private void m11172a(int i, byte[] bArr) {
        m11168a(C2750h.m11140a(i, bArr));
    }

    /* renamed from: a */
    private void m11168a(C2770c c2770c) {
        m11146n().mo11217ab().mo10897a(c2770c);
    }

    /* renamed from: a */
    public static boolean m11169a(AbstractC2769b abstractC2769b, C2657a c2657a) {
        if (abstractC2769b.f10260b == 49 || abstractC2769b.f10260b == 50 || abstractC2769b.f10260b == 51) {
            c2657a.f9269c = ((C2749g) abstractC2769b).m11144a();
            if (abstractC2769b.f10260b == 50) {
                c2657a.m11337a((C2913h) c2657a.f9269c);
            }
            c2657a.mo11220a(C2678d.EnumC2679a.OnRecivedCloudCameraCommandInfo);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private byte[] m11173a(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = 0;
        }
        return bArr;
    }

    /* renamed from: n */
    private C2657a m11146n() {
        return this.f10085f;
    }

    /* renamed from: o */
    private byte[] m11145o() {
        return new byte[10];
    }

    /* renamed from: a */
    public void m11174a() {
        C2770c m11140a = C2750h.m11140a(50, new byte[]{0});
        if (this.f10086g == null) {
            this.f10086g = new C3231a();
        }
        this.f10086g.m9038a(this.f10085f, m11140a);
        this.f10086g.m9037b();
    }

    /* renamed from: a */
    public void m11171a(C2427e.EnumC2428a enumC2428a) {
        if (enumC2428a == C2427e.EnumC2428a.StartRecord) {
            if (this.f10088i == null) {
                this.f10088i = new C3231a();
            }
            this.f10088i.m9036c();
        }
        if (enumC2428a == C2427e.EnumC2428a.StopRecord) {
            if (this.f10089j == null) {
                this.f10089j = new C3231a();
            }
            this.f10089j.m9036c();
        }
        if (enumC2428a == C2427e.EnumC2428a.TakePhote) {
            if (this.f10087h == null) {
                this.f10087h = new C3231a();
            }
            this.f10087h.m9036c();
        }
    }

    /* renamed from: a */
    public void m11167a(C2917i.EnumC2918a enumC2918a) {
        byte[] m11173a = m11173a(13);
        switch (enumC2918a) {
            case _8M_3264X2448_4vs3:
                m11173a[3] = -63;
                break;
            case _13M_4128X3096_4vs3:
                m11173a[3] = -62;
                break;
            case _16M_4068x3456_4vs3:
                m11173a[3] = -61;
                break;
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11166a(C2917i.EnumC2920c enumC2920c) {
        byte[] m11173a = m11173a(13);
        switch (enumC2920c) {
            case BurstShot:
                m11173a[4] = -63;
                break;
            case Normal:
                m11173a[4] = -62;
                break;
            case TimeLapse:
                m11173a[4] = -61;
                break;
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11165a(C2917i.EnumC2921d enumC2921d) {
        byte[] m11173a = m11173a(13);
        switch (enumC2921d) {
            case Mid:
                m11173a[0] = -63;
                break;
            case High:
                m11173a[0] = -62;
                break;
            case Low:
                m11173a[0] = -61;
                break;
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11164a(C2917i.EnumC2922e enumC2922e) {
        byte[] m11173a = m11173a(13);
        switch (enumC2922e) {
            case _1920x1080_60p_16vs9:
                m11173a[2] = -63;
                break;
            case _1920x1080_30p_16vs9:
                m11173a[2] = -62;
                break;
            case _1920x1080_48p_16vs9:
                m11173a[2] = -61;
                break;
            case _1920x1080_24p_16vs9:
                m11173a[2] = -60;
                break;
            case _1280x960_60p_4vs3:
                m11173a[2] = -59;
                break;
            case _1280x960_48p_4vs3:
                m11173a[2] = -58;
                break;
            case _1280x720_60p_16vs9:
                m11173a[2] = -57;
                break;
            case _1280x720_48p_16vs9:
                m11173a[2] = -56;
                break;
            case _1280x720_120p_16vs9:
                m11173a[2] = -55;
                break;
            case _848x480_240p_16vs9:
                m11173a[2] = -54;
                break;
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11163a(C2917i.EnumC2923f enumC2923f) {
        byte[] m11173a = m11173a(13);
        switch (enumC2923f) {
            case Date:
                m11173a[1] = -63;
                break;
            case Time:
                m11173a[1] = -62;
                break;
            case DateTime:
                m11173a[1] = -61;
                break;
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11162a(Date date) {
        byte[] m11173a = m11173a(13);
        byte[] array = ByteBuffer.allocate(4).putInt(Integer.parseInt(this.f10090k.format(date))).array();
        for (int i = 0; i < array.length; i++) {
            m11173a[(m11173a.length - array.length) + i] = array[i];
        }
        m11168a(C2750h.m11140a(50, m11173a));
    }

    /* renamed from: a */
    public void m11161a(boolean z) {
        byte[] m11173a = m11173a(13);
        if (z) {
            m11173a[6] = -63;
        } else {
            m11173a[6] = -62;
        }
        m11168a(C2750h.m11140a(50, new byte[]{1, 0, 0, 0}));
    }

    /* renamed from: b */
    public void m11160b() {
        C2770c m11140a = C2750h.m11140a(49, new byte[]{1, 0, 0, 0});
        if (this.f10088i == null) {
            this.f10088i = new C3231a();
        }
        this.f10088i.m9038a(this.f10085f, m11140a);
        this.f10088i.m9039a();
    }

    /* renamed from: b */
    public void m11159b(boolean z) {
        m11168a(C2750h.m11140a(49, new byte[]{1, 0, 0, 0}));
    }

    /* renamed from: c */
    public void m11158c() {
        this.f10085f.mo11217ab().mo10897a(C2750h.m11140a(51, new byte[]{1, 0, 0, 0}));
    }

    /* renamed from: c */
    public void m11157c(boolean z) {
        m11168a(C2750h.m11140a(50, new byte[]{1, 0, 0, 0}));
    }

    /* renamed from: d */
    public void m11156d() {
        C2770c m11140a = C2750h.m11140a(49, new byte[]{2, 0, 0, 0});
        if (this.f10089j == null) {
            this.f10089j = new C3231a();
        }
        this.f10089j.m9038a(this.f10085f, m11140a);
        this.f10089j.m9039a();
    }

    /* renamed from: e */
    public void m11155e() {
        m11168a(C2750h.m11140a(49, new byte[]{3, 0, 0, 0}));
    }

    /* renamed from: f */
    public void m11154f() {
        C2770c m11140a = C2750h.m11140a(49, new byte[]{4, 0, 0, 0});
        if (this.f10087h == null) {
            this.f10087h = new C3231a();
        }
        this.f10087h.m9038a(this.f10085f, m11140a);
        this.f10087h.m9039a();
    }

    /* renamed from: g */
    public void m11153g() {
        C3260m.m8921a(this.f10085f, C2750h.m11140a(49, new byte[]{8, 0, 0, 0}));
        C3260m.m8922a();
    }

    /* renamed from: h */
    public void m11152h() {
        C3260m.m8921a(this.f10085f, C2750h.m11140a(49, new byte[]{9, 0, 0, 0}));
        C3260m.m8922a();
    }

    /* renamed from: i */
    public void m11151i() {
        C3260m.m8921a(this.f10085f, C2750h.m11140a(49, new byte[]{6, 0, 0, 0}));
        C3260m.m8922a();
    }

    /* renamed from: j */
    public void m11150j() {
        m11168a(C2750h.m11140a(49, new byte[]{0, 1, 0, 0}));
    }

    /* renamed from: k */
    public void m11149k() {
        m11168a(C2750h.m11140a(49, new byte[]{0, 2, 0, 0}));
    }

    /* renamed from: l */
    public void m11148l() {
        m11168a(C2750h.m11140a(49, new byte[]{1, 0, 1, 0}));
    }

    /* renamed from: m */
    public void m11147m() {
        m11168a(C2750h.m11140a(49, new byte[]{1, 0, 0, 1}));
    }
}
