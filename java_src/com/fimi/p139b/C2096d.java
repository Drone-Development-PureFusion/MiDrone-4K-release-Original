package com.fimi.p139b;

import android.content.Context;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.p139b.p142c.AbstractC2093a;
import com.fimi.p139b.p142c.AbstractC2095c;
import com.fimi.soul.drone.p190a.C2667b;
import com.fimi.x1bh.p212a.C3885a;
/* renamed from: com.fimi.b.d */
/* loaded from: classes.dex */
public class C2096d implements AbstractC2093a {

    /* renamed from: a */
    private AbstractC2084a f7009a;

    public C2096d(Context context, EnumC2091b enumC2091b, AbstractC2095c abstractC2095c) {
        switch (enumC2091b) {
            case DRONE:
                this.f7009a = new C2667b(context, abstractC2095c);
                return;
            case X1BH:
                this.f7009a = new C3885a(context, abstractC2095c);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: a */
    public void mo6672a() {
        this.f7009a.a();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: b */
    public void mo6669b() {
        this.f7009a.b();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: c */
    public void mo6667c() {
        this.f7009a.c();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: d */
    public void mo6665d() {
        this.f7009a.d();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: e */
    public void mo6663e() {
        this.f7009a.e();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: f */
    public void mo6661f() {
        this.f7009a.f();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: g */
    public void mo6659g() {
        this.f7009a.g();
    }
}
