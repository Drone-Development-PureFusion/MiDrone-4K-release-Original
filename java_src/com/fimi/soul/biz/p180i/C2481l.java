package com.fimi.soul.biz.p180i;

import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.l */
/* loaded from: classes.dex */
public class C2481l implements AbstractC2482m {

    /* renamed from: a */
    private C2657a f8559a;

    public C2481l(C2657a c2657a) {
        this.f8559a = c2657a;
    }

    /* renamed from: a */
    public void m11998a() {
        C3057d.m9823a(this.f8559a).m9829a(1, 0.0d, 0.0d, 0, 22, 0, 0, 0, 0, 0);
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2482m
    /* renamed from: a */
    public void mo11981a(List<FlyActionBean> list) {
        if (list == null || list.size() <= 0) {
            C2284z.m12697a(this.f8559a.f9270d, (int) C2300R.C2303string.no_poipoint);
            return;
        }
        FlyActionBean flyActionBean = list.get(0);
        C3639ai m7725a = C3633ac.m7725a(0.1d, flyActionBean.getLatLng().latitude, flyActionBean.getLatLng().longitude);
        C3057d.m9823a(this.f8559a).m9829a(1, m7725a.m7700b(), m7725a.m7702a(), flyActionBean.getHeight() * 10, flyActionBean.getOpration_Code(), flyActionBean.getRidus() * 10, flyActionBean.getSpeek() * 10, (flyActionBean.getPara1() == 0 || flyActionBean.getPara1() == 1) ? (short) ((360 - flyActionBean.getStart_point_agle()) / 1.412d) : (short) (flyActionBean.getStart_point_agle() / 1.412d), flyActionBean.getPara1(), flyActionBean.getYaw_mode());
    }
}
