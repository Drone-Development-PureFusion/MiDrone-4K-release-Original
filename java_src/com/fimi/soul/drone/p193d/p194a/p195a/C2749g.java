package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.AbstractC2682a;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.drone.d.a.a.g */
/* loaded from: classes.dex */
public class C2749g<T extends AbstractC2682a> extends AbstractC2769b {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private T f10100a;

    public C2749g(T t) {
        this.f10100a = t;
    }

    /* renamed from: a */
    public T m11144a() {
        return this.f10100a;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        if (this.f10100a != null) {
            this.f10100a.mo10248a(c2771d);
        }
    }

    /* renamed from: a */
    public void m11143a(T t) {
        this.f10100a = t;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    @Deprecated
    /* renamed from: b */
    public C2770c mo11073b() {
        return null;
    }
}
