package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.al */
/* loaded from: classes.dex */
public class C2881al extends C2822e {

    /* renamed from: b */
    public static final int f10767b = 0;

    /* renamed from: c */
    public static final int f10768c = 1;

    /* renamed from: d */
    public static final int f10769d = 2;

    /* renamed from: e */
    public static final int f10770e = 3;

    /* renamed from: f */
    public byte f10771f;

    /* renamed from: g */
    public byte f10772g;

    /* renamed from: h */
    public byte f10773h;

    /* renamed from: i */
    public byte f10774i;

    /* renamed from: j */
    public int f10775j;

    /* renamed from: k */
    public byte f10776k;

    /* renamed from: m */
    private boolean f10778m;

    /* renamed from: n */
    private boolean f10779n = false;

    /* renamed from: o */
    private boolean f10780o = true;

    /* renamed from: l */
    public byte f10777l = 0;

    public C2881al() {
    }

    public C2881al(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: k */
    private void m10566k() {
        if (this.f10771f != 34) {
            if (this.f10771f != 51 || this.f10773h != 3 || this.f10774i != 4) {
                return;
            }
            if (this.f10775j == 1) {
                this.f10778m = true;
            } else {
                this.f10778m = false;
            }
        } else if (this.f10773h != 1 && this.f10773h != 3) {
        } else {
            if ((this.f10775j & 1) == 1) {
                this.f10778m = false;
            }
            if ((this.f10775j & 2) == 2) {
                this.f10778m = false;
                this.f10779n = true;
            }
            if ((this.f10775j & 4) != 4) {
                return;
            }
            this.f10778m = true;
            this.f10779n = false;
        }
    }

    /* renamed from: a */
    public void m10581a(byte b) {
        this.f10777l = b;
    }

    /* renamed from: a */
    public void m10580a(byte b, byte b2, byte b3, byte b4, int i, byte b5) {
        this.f10771f = b;
        this.f10772g = b2;
        this.f10773h = b3;
        this.f10774i = b4;
        this.f10775j = i;
        this.f10776k = b5;
        this.f10431a.mo11220a(C2678d.EnumC2679a.NEW_HAND_OPERATE);
    }

    /* renamed from: a */
    public void m10579a(C2770c c2770c) {
        C2771d c2771d = c2770c.f10264d;
        c2771d.m11052c();
        this.f10771f = c2771d.m11050d();
        this.f10772g = c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        c2771d.m11050d();
        this.f10776k = c2771d.m11050d();
        this.f10431a.mo11220a(C2678d.EnumC2679a.NEW_HAND_OPERATE);
    }

    /* renamed from: a */
    public void m10578a(boolean z) {
        this.f10780o = z;
    }

    /* renamed from: a */
    public boolean m10582a() {
        return this.f10779n;
    }

    /* renamed from: b */
    public byte m10577b() {
        return this.f10777l;
    }

    /* renamed from: b */
    public void m10576b(C2770c c2770c) {
        C2771d c2771d = c2770c.f10264d;
        c2771d.m11052c();
        this.f10771f = c2771d.m11050d();
        this.f10772g = c2771d.m11050d();
        this.f10773h = c2771d.m11050d();
        this.f10774i = c2771d.m11050d();
        this.f10775j = c2771d.m11048f();
        this.f10776k = c2771d.m11050d();
        m10566k();
        this.f10431a.mo11220a(C2678d.EnumC2679a.NEW_HAND_OPERATE);
    }

    /* renamed from: b */
    public void m10575b(boolean z) {
        this.f10778m = z;
    }

    /* renamed from: c */
    public boolean m10574c() {
        return this.f10780o;
    }

    /* renamed from: d */
    public byte m10573d() {
        return this.f10771f;
    }

    /* renamed from: e */
    public byte m10572e() {
        return this.f10772g;
    }

    /* renamed from: f */
    public byte m10571f() {
        return this.f10773h;
    }

    /* renamed from: g */
    public byte m10570g() {
        return this.f10774i;
    }

    /* renamed from: h */
    public int m10569h() {
        return this.f10775j;
    }

    /* renamed from: i */
    public byte m10568i() {
        return this.f10776k;
    }

    /* renamed from: j */
    public boolean m10567j() {
        return this.f10778m;
    }

    public String toString() {
        return "NewHandDroneVariable{report=" + ((int) this.f10776k) + ", valueToBeOperate=" + this.f10775j + ", byteCode=" + ((int) this.f10774i) + ", targetByteID=" + ((int) this.f10773h) + ", pilotMode=" + ((int) this.f10772g) + ", operation=" + ((int) this.f10771f) + C0359h.f726w;
    }
}
