package com.fimi.soul.biz.p178g;

import com.fimi.kernel.p164d.C2244b;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2876ag;
/* renamed from: com.fimi.soul.biz.g.f */
/* loaded from: classes.dex */
public class C2454f implements C2678d.AbstractC2680b {

    /* renamed from: a */
    private C2657a f8450a;

    /* renamed from: b */
    private C2244b f8451b;

    /* renamed from: c */
    private boolean f8452c;

    /* renamed from: d */
    private int f8453d;

    /* renamed from: e */
    private int f8454e;

    /* renamed from: f */
    private boolean f8455f;

    public C2454f(C2657a c2657a) {
        this.f8450a = c2657a;
        c2657a.mo11219a(this);
        this.f8451b = C2244b.m13099b(c2657a.f9270d);
    }

    /* renamed from: a */
    private synchronized void m12135a(C2876ag c2876ag) {
        boolean z = true;
        synchronized (this) {
            if ((c2876ag.m10627g() & 15) != 1) {
                z = false;
            }
            if (!this.f8452c && z && !this.f8450a.m11320al()) {
                switch (this.f8454e) {
                    case 0:
                        m12134a(m12136a(C2300R.C2303string.can_takeOff_ATTi));
                        break;
                    case 1:
                        m12134a(m12136a(C2300R.C2303string.can_takeOff_GLOBAL));
                        break;
                    case 2:
                        m12134a(m12136a(C2300R.C2303string.can_takeOff_Local));
                        break;
                }
            }
            if (this.f8452c && !z && !this.f8450a.m11320al()) {
                if (this.f8450a.m11310av().m10567j()) {
                    m12134a(m12136a(C2300R.C2303string.can_takeOff_ATTi));
                } else {
                    m12134a(m12136a(C2300R.C2303string.self_error_result));
                }
            }
            if (this.f8452c != z) {
                this.f8452c = z;
            }
        }
    }

    /* renamed from: c */
    private synchronized void m12132c() {
        if (!this.f8455f) {
            this.f8455f = true;
            this.f8453d = this.f8454e;
        }
        if (this.f8453d != this.f8454e) {
            switch (this.f8454e) {
                case 0:
                    m12134a(m12136a(C2300R.C2303string.change_contype_ATTi));
                    break;
                case 1:
                    m12134a(m12136a(C2300R.C2303string.change_contype_GLOBAL));
                    break;
                case 2:
                    m12134a(m12136a(C2300R.C2303string.change_contype_Local));
                    break;
            }
            this.f8453d = this.f8454e;
        }
    }

    /* renamed from: a */
    public String m12136a(int i) {
        return this.f8450a.f9270d.getResources().getString(i);
    }

    /* renamed from: a */
    public void m12137a() {
        this.f8450a.mo11214b(this);
        this.f8452c = false;
    }

    /* renamed from: a */
    public void m12134a(String str) {
        this.f8451b.m13103a(str);
    }

    /* renamed from: b */
    public void m12133b() {
        this.f8450a.mo11219a(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case NEWFRONEMODEL:
                this.f8454e = c2657a.m11312at().m10703d();
                C2876ag mo11205t = c2657a.mo11205t();
                m12132c();
                m12135a(mo11205t);
                return;
            default:
                return;
        }
    }
}
