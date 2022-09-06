package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.io.Serializable;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.drone.d.a.a.r */
/* loaded from: classes.dex */
public class C2760r extends AbstractC2769b implements Serializable {

    /* renamed from: a */
    public static final byte f10172a = 115;

    /* renamed from: c */
    public static final byte f10173c = 1;

    /* renamed from: d */
    public static final byte f10174d = 0;

    /* renamed from: e */
    public static final byte f10175e = 1;

    /* renamed from: f */
    public static final byte f10176f = 2;

    /* renamed from: g */
    public byte f10177g;

    /* renamed from: h */
    public byte f10178h;

    /* renamed from: i */
    public byte f10179i;

    /* renamed from: j */
    public byte f10180j;

    /* renamed from: k */
    private final byte f10181k = SmileConstants.TOKEN_KEY_LONG_STRING;

    /* renamed from: l */
    private byte f10182l = 0;

    public C2760r() {
        this.f10260b = 52;
    }

    /* renamed from: a */
    public void m11080a(byte b) {
        switch (b) {
            case 0:
                this.f10182l = (byte) 0;
                return;
            case 1:
                this.f10182l = (byte) 1;
                return;
            case 2:
                this.f10182l = (byte) 2;
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m11079a(C2770c c2770c) {
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10177g = c2771d.m11050d();
        this.f10178h = c2771d.m11050d();
        this.f10179i = c2771d.m11050d();
        this.f10180j = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 52;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 1);
        return c2770c;
    }
}
