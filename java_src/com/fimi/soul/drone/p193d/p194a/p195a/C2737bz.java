package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.util.Arrays;
/* renamed from: com.fimi.soul.drone.d.a.a.bz */
/* loaded from: classes.dex */
public class C2737bz extends AbstractC2769b {

    /* renamed from: a */
    public static final int f10023a = 201;
    private static final long serialVersionUID = 201;

    /* renamed from: c */
    public int f10024c;

    /* renamed from: d */
    public short f10025d;

    /* renamed from: e */
    public byte f10026e;

    /* renamed from: f */
    public byte[] f10027f;

    public C2737bz() {
        this.f10260b = 201;
    }

    public C2737bz(C2770c c2770c) {
        this.f10260b = 201;
        mo11074a(c2770c.f10264d);
    }

    /* renamed from: a */
    public void m11177a(int i) {
        this.f10027f = new byte[i];
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10025d = c2771d.m11049e();
    }

    /* renamed from: a */
    public byte[] m11178a() {
        return this.f10027f;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = this.f10024c;
        c2770c.f10263c = 201;
        c2770c.f10264d.m11055b(this.f10026e);
        c2770c.f10264d.m11057a(this.f10025d);
        for (int i = 0; i < this.f10027f.length; i++) {
            c2770c.f10264d.m11055b(this.f10027f[i]);
        }
        return c2770c;
    }

    /* renamed from: b */
    public void m11176b(int i) {
        this.f10024c = i;
    }

    /* renamed from: c */
    public int m11175c() {
        return this.f10024c;
    }

    public String toString() {
        return "updatedrone [Packet_sequence=" + ((int) this.f10025d) + ", data=" + Arrays.toString(this.f10027f) + "]";
    }
}
