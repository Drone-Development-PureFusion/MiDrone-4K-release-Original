package com.fimi.soul.biz.p186o;

import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.entity.ChangeWifiPAs;
import com.fimi.soul.entity.CommadBean;
import com.fimi.soul.entity.Fwap;
import com.fimi.soul.utils.C3637ag;
/* renamed from: com.fimi.soul.biz.o.a */
/* loaded from: classes.dex */
public class C2616a {

    /* renamed from: a */
    private volatile String f9076a;

    /* renamed from: b */
    private volatile String f9077b;

    /* renamed from: com.fimi.soul.biz.o.a$a */
    /* loaded from: classes.dex */
    private static class C2618a {

        /* renamed from: a */
        private static final C2616a f9079a = new C2616a();

        private C2618a() {
        }
    }

    /* renamed from: a */
    public static C2616a m11502a() {
        return C2618a.f9079a;
    }

    /* renamed from: a */
    public void m11500a(String str) {
        this.f9076a = str;
    }

    /* renamed from: b */
    public void m11499b() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.o.a.1
            @Override // java.lang.Runnable
            public void run() {
                CommadBean commadBean = new CommadBean();
                commadBean.setType("0");
                commadBean.setData("fwdap");
                commadBean.setName("modify");
                Fwap fwap = new Fwap();
                fwap.setKey(C2616a.this.f9077b);
                fwap.setSsid(C2616a.this.f9076a);
                C2225c m12434o = C2367d.m12459a().m12434o();
                ChangeWifiPAs changeWifiPAs = new ChangeWifiPAs();
                changeWifiPAs.setmCommadBean(commadBean);
                changeWifiPAs.setmFwap(fwap);
                m12434o.m13181a(C3637ag.m7710a(changeWifiPAs).getBytes());
            }
        });
    }

    /* renamed from: b */
    public void m11497b(String str) {
        this.f9077b = str;
    }

    /* renamed from: c */
    public String m11496c() {
        return this.f9076a;
    }

    /* renamed from: d */
    public String m11495d() {
        return this.f9077b;
    }
}
