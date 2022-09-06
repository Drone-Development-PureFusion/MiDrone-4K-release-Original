package com.fimi.soul.module.update.p210a;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p178g.C2444a;
import com.fimi.soul.biz.update.C2639d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p199e.C2828f;
import com.fimi.soul.drone.p203i.C2871ab;
import com.fimi.soul.drone.p203i.C2924j;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.DroneInfoBean;
import com.fimi.soul.module.p207b.C3057d;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.module.update.a.g */
/* loaded from: classes.dex */
public class C3585g implements C2678d.AbstractC2680b {

    /* renamed from: a */
    Context f14527a;

    /* renamed from: b */
    C2657a f14528b;

    /* renamed from: c */
    C3579a f14529c = C3579a.m7971a();

    /* renamed from: d */
    C2423d f14530d = (C2423d) C2379b.m12410a().m12394d();

    public C3585g(Context context, C2657a c2657a) {
        this.f14527a = context;
        this.f14528b = c2657a;
        c2657a.mo11219a(this);
        C2238c.m13125c().mo13118a(C2639d.f9148j, DroneInfoBean.class);
    }

    public C3585g(C2657a c2657a) {
        this.f14528b = c2657a;
        c2657a.mo11219a(this);
        C2238c.m13125c().mo13118a(C2639d.f9148j, DroneInfoBean.class);
    }

    /* renamed from: a */
    private void m7889a(C2871ab c2871ab) {
        int m10689c = c2871ab.m10689c() & 65535;
        char m10690b = c2871ab.m10690b();
        int m10692a = c2871ab.m10692a() & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        byte m10688d = c2871ab.m10688d();
        long m10687e = c2871ab.m10687e();
        long m10686f = c2871ab.m10686f();
        long m10685g = c2871ab.m10685g();
        long m10684h = c2871ab.m10684h();
        if (m10689c > 0) {
            this.f14529c.m7968a(new C3583e(m10692a, m10688d, m10689c, String.valueOf(Long.valueOf(m10690b)), m10687e, m10686f, m10685g, m10684h));
            this.f14529c.m7969a(m10692a, m10689c);
        }
        if (c2871ab.m10692a() == 0) {
            C2444a.m12164a().m12163a(c2871ab);
        }
    }

    /* renamed from: a */
    public void m7890a() {
        if (this.f14528b.f9269c.mo10745a() == 51) {
            C2924j c2924j = (C2924j) this.f14528b.f9269c;
            this.f14530d.j().setDvVersion(c2924j.m10239d() + "");
            this.f14530d.j().setCameraType(c2924j.m10244b());
            if (C2367d.m12459a().m12438k()) {
                this.f14529c.m7969a(13, c2924j.m10239d());
                this.f14529c.m7968a(new C3583e("", 13, c2924j.m10239d()));
            } else {
                this.f14529c.m7969a(4, c2924j.m10239d());
                this.f14529c.m7968a(new C3583e("", 4, c2924j.m10239d()));
            }
            CameraValue.version = c2924j.m10239d();
        }
    }

    /* renamed from: b */
    public void m7888b() {
        this.f14530d.m12230x().mo12245j();
        if (!C3579a.m7971a().m7966b().containsKey(3)) {
            C3057d.m9823a(this.f14528b).m9819b(3);
            C2828f.m10860c(this.f14528b);
        }
    }

    /* renamed from: c */
    public void m7887c() {
        C2828f.m10851l(this.f14528b);
        this.f14530d.m12230x().mo12245j();
    }

    /* renamed from: d */
    public void m7886d() {
        C2828f.m10852k(this.f14528b);
        this.f14530d.m12230x().mo12245j();
    }

    /* renamed from: e */
    public void m7885e() {
        this.f14528b.mo11214b(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case FCVERSION2:
                m7889a(c2657a.mo11213l());
                return;
            case OnRecivedCloudCameraCommandInfo:
                m7890a();
                return;
            default:
                return;
        }
    }
}
