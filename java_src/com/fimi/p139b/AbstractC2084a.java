package com.fimi.p139b;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.p139b.p142c.AbstractC2093a;
import com.fimi.p139b.p142c.AbstractC2095c;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.module.update.p210a.C3579a;
/* renamed from: com.fimi.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC2084a implements AbstractC2093a {

    /* renamed from: a */
    protected String f6966a = C2353b.f7918I;

    /* renamed from: b */
    protected boolean f6967b;

    /* renamed from: c */
    protected C2277v f6968c;

    /* renamed from: d */
    private C2423d f6969d;

    public AbstractC2084a(Context context, AbstractC2095c abstractC2095c) {
    }

    /* renamed from: a */
    public void m13740a(Context context) {
        this.f6968c = C2277v.m12784a(context);
        this.f6966a = C2353b.f7918I;
        this.f6967b = C2238c.m13125c().mo13108d(C2353b.f7920K);
        C3579a.m7971a().m7964c();
        C2367d.m12459a().m12452b((String) null);
        C2364c.m12469a().m12464b((String) null);
        this.f6969d = (C2423d) C2379b.m12410a().m12394d();
        this.f6969d.m12231w().m12240b();
        if (this.f6969d.e()) {
            this.f6969d.m12233u().m12281k();
        }
    }

    /* renamed from: j_ */
    public abstract void mo6655j_();
}
