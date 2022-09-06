package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.AbstractC2682a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2924j;
/* renamed from: com.fimi.soul.drone.d.a.a.h */
/* loaded from: classes.dex */
public final class C2750h {
    /* renamed from: a */
    public static C2749g m11141a(int i, C2770c c2770c) {
        AbstractC2682a c2924j;
        switch (i) {
            case 49:
                c2924j = new C2924j();
                break;
            case 50:
                c2924j = new C2913h();
                break;
            case 51:
                c2924j = new C2924j();
                break;
            default:
                c2924j = null;
                break;
        }
        if (c2924j != null) {
            c2924j.mo10744a(i);
            C2749g c2749g = new C2749g(c2924j);
            c2749g.f10260b = i;
            c2749g.mo11074a(c2770c.f10264d);
            return c2749g;
        }
        return null;
    }

    /* renamed from: a */
    public static C2770c m11142a(int i, int i2, C2771d c2771d) {
        C2770c c2770c = new C2770c(c2771d);
        c2770c.f10262b = i;
        c2770c.f10263c = i2;
        return c2770c;
    }

    /* renamed from: a */
    public static C2770c m11140a(int i, byte[] bArr) {
        C2770c c2770c = new C2770c(m11139a(bArr));
        c2770c.f10262b = bArr.length;
        c2770c.f10263c = i;
        return c2770c;
    }

    /* renamed from: a */
    public static C2771d m11139a(byte[] bArr) {
        C2771d c2771d = new C2771d();
        for (byte b : bArr) {
            c2771d.m11055b(b);
        }
        return c2771d;
    }
}
