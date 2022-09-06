package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.bl */
/* loaded from: classes.dex */
public class C2723bl extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9917a = 193;

    /* renamed from: c */
    public static final int f9918c = 10;
    private static final long serialVersionUID = 193;

    /* renamed from: d */
    public byte f9919d;

    /* renamed from: e */
    public byte f9920e;

    /* renamed from: f */
    public byte f9921f;

    /* renamed from: g */
    public byte f9922g;

    /* renamed from: j */
    public byte f9925j;

    /* renamed from: l */
    public byte f9927l;

    /* renamed from: h */
    public byte f9923h = 0;

    /* renamed from: i */
    public byte f9924i = 1;

    /* renamed from: k */
    public byte f9926k = 2;

    /* renamed from: m */
    public byte f9928m = 6;

    public C2723bl() {
        this.f10260b = 193;
    }

    public C2723bl(C2770c c2770c) {
        this.f10260b = 193;
        mo11074a(c2770c.f10264d);
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9919d = c2771d.m11050d();
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 10;
        c2770c.f10263c = 193;
        c2770c.f10264d.m11055b(this.f9919d);
        c2770c.f10264d.m11055b(this.f9920e);
        c2770c.f10264d.m11055b(this.f9921f);
        c2770c.f10264d.m11055b(this.f9922g);
        c2770c.f10264d.m11055b(this.f9923h);
        c2770c.f10264d.m11055b(this.f9924i);
        c2770c.f10264d.m11055b(this.f9925j);
        c2770c.f10264d.m11055b(this.f9926k);
        c2770c.f10264d.m11055b(this.f9927l);
        c2770c.f10264d.m11055b(this.f9928m);
        return c2770c;
    }

    public String toString() {
        return "msg_RequestVersionUplink{Type=" + ((int) this.f9919d) + ", app_main_version=" + ((int) this.f9920e) + ", app_sub_version=" + ((int) this.f9921f) + ", app_patch_version=" + ((int) this.f9922g) + ", reserved=" + ((int) this.f9923h) + ", app_project_id=" + ((int) this.f9924i) + ", reserved2=" + ((int) this.f9925j) + ", app_paform=" + ((int) this.f9926k) + ", app_type=" + ((int) this.f9927l) + ", app_compability=" + ((int) this.f9928m) + C0359h.f726w;
    }
}
