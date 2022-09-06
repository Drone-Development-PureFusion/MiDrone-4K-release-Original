package com.fimi.soul.biz.p180i;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p181j.C2487a;
import com.fimi.soul.biz.p181j.C2499g;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.e */
/* loaded from: classes.dex */
public class C2474e implements AbstractC2467a {

    /* renamed from: a */
    private AMap f8536a;

    /* renamed from: b */
    private Context f8537b;

    /* renamed from: c */
    private C2657a f8538c;

    /* renamed from: d */
    private C2472d f8539d = C2472d.m12036p();

    /* renamed from: e */
    private Marker f8540e;

    /* renamed from: f */
    private Polyline f8541f;

    public C2474e(AMap aMap, Context context, C2657a c2657a) {
        this.f8538c = c2657a;
        this.f8536a = aMap;
        this.f8537b = context;
    }

    /* renamed from: a */
    public void m12032a() {
        if (this.f8540e != null) {
            if (this.f8540e.isInfoWindowShown()) {
                this.f8540e.hideInfoWindow();
            }
            this.f8540e.setDraggable(false);
        }
    }

    /* renamed from: a */
    public void m12031a(LatLng latLng) {
        List<LatLng> m12054c = C2472d.m12036p().m12054c();
        if (m12054c == null || m12054c.contains(latLng)) {
            return;
        }
        m12054c.add(latLng);
        if (m12054c.size() < 2) {
            return;
        }
        if (this.f8541f == null) {
            this.f8541f = this.f8536a.addPolyline(C2478i.m12016a(m12054c, 4, this.f8537b.getResources().getColor(C2300R.color.drone_inface_line)).zIndex(50.0f));
        } else {
            this.f8541f.setPoints(m12054c);
        }
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2467a
    /* renamed from: a */
    public void mo11993a(LatLng latLng, int i) {
        for (Circle circle : C2499g.m11911c().m11910d()) {
            if (circle.contains(latLng) && !C2487a.m11979a().m11977a(latLng) && C3632ab.m7729c(latLng, circle.getCenter()).m7698a() <= circle.getRadius()) {
                C2284z.m12696a(this.f8538c.f9270d, (int) C2300R.C2303string.flyzonwaypoint, 3000);
                return;
            }
        }
        C3639ai m7726a = C3633ac.m7726a(this.f8538c.mo11201x().m10612b(), this.f8538c.mo11201x().m10611c());
        double m7698a = C3632ab.m7729c(latLng, new LatLng(m7726a.m7702a(), m7726a.m7700b())).m7698a();
        if (m7698a > 500.0d) {
            if (m7698a <= 500.0d) {
                return;
            }
            C2284z.m12697a(this.f8537b, (int) C2300R.C2303string.outterwaypoint);
            return;
        }
        List<FlyActionBean> m12042j = this.f8539d.m12042j();
        if (this.f8540e != null) {
            ((FlyActionBean) this.f8540e.getObject()).setLatLng(latLng);
            this.f8540e.setPosition(latLng);
            return;
        }
        FlyActionBean m12037o = C2472d.m12036p().m12037o();
        if (m12037o == null) {
            m12037o = new FlyActionBean();
        }
        m12037o.setLatLng(latLng);
        m12037o.setDrawableRes(i);
        m12037o.setCanclick(true);
        m12037o.setType(2);
        C2472d.m12036p().m12064a(2);
        m12037o.setModelType(2);
        m12037o.setStyleInfo(1);
        m12037o.setHeight(this.f8539d.m12041k());
        m12037o.setSpeek(this.f8539d.m12035q());
        this.f8540e = this.f8536a.addMarker(C2478i.m12017a(latLng, this.f8538c.f9270d, this.f8539d.m12041k(), true, i));
        this.f8540e.setObject(m12037o);
        this.f8540e.setZIndex(1000.0f);
        this.f8540e.setAnchor(0.2f, 0.8f);
        this.f8539d.m12052c(m12037o);
        if (!m12042j.contains(m12037o)) {
            m12042j.add(m12037o);
        }
        List<Marker> m12043i = this.f8539d.m12043i();
        if (m12043i != null && !m12043i.contains(this.f8540e)) {
            m12043i.add(this.f8540e);
        }
        this.f8538c.mo11220a(C2678d.EnumC2679a.SHOWHEIGHTVIEW);
    }

    /* renamed from: b */
    public void m12030b() {
        if (this.f8540e != null) {
            this.f8540e.remove();
            this.f8540e = null;
        }
        if (this.f8541f != null) {
            this.f8541f.remove();
            this.f8541f = null;
        }
        this.f8539d.m12042j().clear();
        this.f8538c.mo11220a(C2678d.EnumC2679a.HIDEHEIGHTVALUE);
    }

    /* renamed from: c */
    public void m12029c() {
        if (this.f8540e != null) {
            this.f8540e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_red));
        }
        C2477h.m12020a(this.f8537b).m12021a(0);
    }

    /* renamed from: d */
    public void m12028d() {
        if (this.f8540e != null) {
            FlyActionBean flyActionBean = (FlyActionBean) this.f8540e.getObject();
            if (flyActionBean != null) {
                flyActionBean.setStyleInfo(1);
            }
            this.f8540e.setTitle(this.f8538c.f9270d.getString(C2300R.C2303string.delete_marker));
            this.f8540e.showInfoWindow();
        }
    }

    /* renamed from: e */
    public void m12027e() {
        FlyActionBean flyActionBean;
        if (this.f8540e == null || (flyActionBean = (FlyActionBean) this.f8540e.getObject()) == null || flyActionBean.getModelType() != 2) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        this.f8540e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
        this.f8540e.setTitle(this.f8538c.f9270d.getString(C2300R.C2303string.delete_marker));
        this.f8540e.showInfoWindow();
    }

    /* renamed from: f */
    public void m12026f() {
        FlyActionBean flyActionBean;
        if (this.f8540e == null || (flyActionBean = (FlyActionBean) this.f8540e.getObject()) == null) {
            return;
        }
        flyActionBean.setType(1);
        this.f8540e.setIcon(C2479j.m12013a(this.f8538c.f9270d, C2300R.C2301drawable.img_fly_flag_blue, flyActionBean.getHeight(), false));
    }

    /* renamed from: g */
    public void m12025g() {
        FlyActionBean flyActionBean;
        if (this.f8540e == null || (flyActionBean = (FlyActionBean) this.f8540e.getObject()) == null || flyActionBean.getModelType() != 2 || 1 != flyActionBean.getType()) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(false);
        this.f8540e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
        this.f8540e.setTitle(this.f8538c.f9270d.getString(C2300R.C2303string.delete_marker));
        this.f8540e.showInfoWindow();
    }

    /* renamed from: h */
    public void m12024h() {
        FlyActionBean flyActionBean;
        if (this.f8540e == null || (flyActionBean = (FlyActionBean) this.f8540e.getObject()) == null || C2472d.m12036p().m12065a() != 2 || 1 != flyActionBean.getType()) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(true);
        this.f8540e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
        this.f8540e.setTitle(this.f8538c.f9270d.getString(C2300R.C2303string.delete_marker));
        this.f8540e.showInfoWindow();
    }
}
