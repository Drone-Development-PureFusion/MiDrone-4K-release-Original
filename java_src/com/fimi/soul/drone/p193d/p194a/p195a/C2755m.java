package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import java.io.Serializable;
/* renamed from: com.fimi.soul.drone.d.a.a.m */
/* loaded from: classes.dex */
public class C2755m extends AbstractC2769b implements Serializable {

    /* renamed from: a */
    public final int f10141a = 137;

    /* renamed from: c */
    private final byte f10142c = 19;

    /* renamed from: d */
    private byte[] f10143d = new byte[2];

    /* renamed from: e */
    private byte[] f10144e;

    /* renamed from: f */
    private byte f10145f;

    public C2755m() {
        this.f10260b = 137;
    }

    /* renamed from: a */
    public void m11108a(byte b) {
        this.f10145f = b;
    }

    /* renamed from: a */
    public void m11107a(C2770c c2770c) {
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f10143d[0] = c2771d.m11050d();
        this.f10143d[1] = c2771d.m11050d();
        this.f10145f = c2771d.m11050d();
    }

    /* renamed from: a */
    public void m11106a(byte[] bArr) {
        this.f10143d = bArr;
    }

    /* renamed from: a */
    public byte[] m11109a() {
        return this.f10143d;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 137;
        c2770c.f10262b = 19;
        if (this.f10144e != null && this.f10144e.length > 0) {
            for (byte b : this.f10144e) {
                c2770c.f10264d.m11055b(b);
            }
        }
        return c2770c;
    }

    /* renamed from: b */
    public void m11105b(byte[] bArr) {
        this.f10144e = bArr;
    }

    /* renamed from: c */
    public byte m11104c() {
        return this.f10145f;
    }
}
