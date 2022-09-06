package com.fimi.soul.biz.p180i;

import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2891av;
import com.fimi.soul.drone.p203i.C2892aw;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.p */
/* loaded from: classes.dex */
public class C2486p implements AbstractC2482m {

    /* renamed from: a */
    private List<FlyActionBean> f8571a;

    /* renamed from: b */
    private C2657a f8572b;

    /* renamed from: c */
    private volatile int f8573c = 1;

    public C2486p(C2657a c2657a) {
        this.f8572b = c2657a;
    }

    /* renamed from: a */
    public void m11984a() {
        C2891av mo11211n = this.f8572b.mo11211n();
        if (mo11211n.m10470a() >= this.f8573c && this.f8573c == mo11211n.m10470a() && mo11211n.m10463g() == 0.0d && this.f8571a != null && this.f8573c <= this.f8571a.size()) {
            if (mo11211n.m10470a() == this.f8571a.size()) {
                C3057d.m9823a(this.f8572b).m9800q();
                return;
            }
            this.f8573c++;
            m11983a(this.f8573c);
        }
    }

    /* renamed from: a */
    public void m11983a(int i) {
        if (this.f8571a.size() < 1 || i > this.f8571a.size()) {
            return;
        }
        FlyActionBean flyActionBean = this.f8571a.get(i - 1);
        C3639ai m7725a = C3633ac.m7725a(0.1d, flyActionBean.getLatLng().latitude, flyActionBean.getLatLng().longitude);
        LatLng latLng = new LatLng(m7725a.m7702a(), m7725a.m7700b());
        C3057d.m9823a(this.f8572b).m9827a(i, latLng.longitude, latLng.latitude, (short) flyActionBean.getHeight(), (short) this.f8571a.size(), flyActionBean.getSpeek());
    }

    /* renamed from: a */
    public void m11982a(C2892aw c2892aw) {
        List<LatLng> m12040l = C2472d.m12036p().m12040l();
        List<FlyActionBean> m12042j = C2472d.m12036p().m12042j();
        C3639ai m7726a = C3633ac.m7726a(c2892aw.m10457c(), c2892aw.m10458b());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        if (m12040l != null && !m12040l.contains(latLng) && c2892aw.m10452h() != 0) {
            m12040l.add(latLng);
            FlyActionBean flyActionBean = new FlyActionBean();
            flyActionBean.setLatLng(latLng);
            flyActionBean.setHeight((int) c2892aw.m10456d());
            flyActionBean.setType(1);
            flyActionBean.setModelType(1);
            flyActionBean.setSpeek((int) c2892aw.m10453g());
            if (m12042j != null && !m12042j.contains(flyActionBean)) {
                m12042j.add(flyActionBean);
            }
        }
        if (c2892aw.m10452h() <= m12040l.size()) {
            this.f8572b.mo11220a(C2678d.EnumC2679a.RESHWAYPOINT);
        } else {
            m11980b(c2892aw.m10460a() + 1);
        }
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2482m
    /* renamed from: a */
    public void mo11981a(List<FlyActionBean> list) {
        if (list != null && list.size() <= 0) {
            C2284z.m12697a(this.f8572b.f9270d, (int) C2300R.C2303string.no_waypoint);
            return;
        }
        this.f8573c = 1;
        this.f8571a = list;
        m11983a(this.f8573c);
    }

    /* renamed from: b */
    public void m11980b(int i) {
        C3057d.m9823a(this.f8572b).m9830a(i);
    }
}
