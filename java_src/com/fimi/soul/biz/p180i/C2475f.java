package com.fimi.soul.biz.p180i;

import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.f */
/* loaded from: classes.dex */
public class C2475f implements AbstractC2482m {

    /* renamed from: a */
    private C2657a f8542a;

    public C2475f(C2657a c2657a) {
        this.f8542a = c2657a;
    }

    /* renamed from: a */
    public void m12023a() {
        C3057d.m9823a(this.f8542a).m9828a(0, 0.0d, 0.0d, (short) 0, 170, 0);
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2482m
    /* renamed from: a */
    public void mo11981a(List<FlyActionBean> list) {
        if (list == null || list.size() <= 0) {
            C2284z.m12697a(this.f8542a.f9270d, (int) C2300R.C2303string.no_flytopoint);
            return;
        }
        FlyActionBean flyActionBean = list.get(0);
        C3639ai m7725a = C3633ac.m7725a(0.1d, flyActionBean.getLatLng().latitude, flyActionBean.getLatLng().longitude);
        LatLng latLng = new LatLng(m7725a.m7702a(), m7725a.m7700b());
        C3057d.m9823a(this.f8542a).m9828a(1, latLng.longitude, latLng.latitude, (short) flyActionBean.getHeight(), 85, flyActionBean.getSpeek());
    }
}
