package com.fimi.soul.biz.p180i;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.fimi.kernel.p164d.C2244b;
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
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.o */
/* loaded from: classes.dex */
public class C2485o implements AbstractC2467a {

    /* renamed from: a */
    private AMap f8565a;

    /* renamed from: b */
    private Context f8566b;

    /* renamed from: c */
    private volatile Polyline f8567c;

    /* renamed from: d */
    private C2472d f8568d = C2472d.m12036p();

    /* renamed from: e */
    private C2657a f8569e;

    /* renamed from: f */
    private volatile Polyline f8570f;

    public C2485o(AMap aMap, Context context, C2657a c2657a) {
        this.f8569e = c2657a;
        this.f8565a = aMap;
        this.f8566b = context;
    }

    /* renamed from: a */
    public synchronized void m11996a() {
        List<Marker> m12043i = C2472d.m12036p().m12043i();
        if (C2472d.m12036p().m12042j().size() > 0 && m12043i.size() == 0) {
            for (FlyActionBean flyActionBean : C2472d.m12036p().m12042j()) {
                Marker addMarker = this.f8565a.addMarker(C2478i.m12018a(flyActionBean.getLatLng(), C2300R.C2301drawable.img_fly_origin_blue));
                addMarker.setObject(flyActionBean);
                addMarker.setAnchor(0.5f, 0.88f);
                addMarker.hideInfoWindow();
                if (!m12043i.contains(addMarker)) {
                    m12043i.add(addMarker);
                }
            }
        }
        if (m12043i != null && m12043i.size() >= 1) {
            for (int i = 0; i < m12043i.size(); i++) {
                Marker marker = m12043i.get(i);
                FlyActionBean flyActionBean2 = (FlyActionBean) marker.getObject();
                if (i == m12043i.size() - 1) {
                    marker.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
                    flyActionBean2.setStyleInfo(2);
                    flyActionBean2.setCanclick(true);
                    flyActionBean2.setDrawableRes(C2300R.C2301drawable.img_fly_flag_blue);
                    marker.setAnchor(0.1f, 0.9f);
                } else {
                    flyActionBean2.setCanclick(false);
                    marker.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_origin_blue));
                    flyActionBean2.setDrawableRes(C2300R.C2301drawable.img_fly_origin_blue);
                    marker.setAnchor(0.5f, 0.7f);
                }
                flyActionBean2.setModelType(1);
                marker.setDraggable(false);
                if (marker.isInfoWindowShown()) {
                    marker.hideInfoWindow();
                }
            }
        } else if (m12043i.size() > 0) {
            Marker marker2 = m12043i.get(0);
            FlyActionBean flyActionBean3 = (FlyActionBean) marker2.getObject();
            marker2.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
            flyActionBean3.setStyleInfo(2);
            flyActionBean3.setCanclick(true);
            flyActionBean3.setDrawableRes(C2300R.C2301drawable.img_fly_flag_blue);
            marker2.setAnchor(0.1f, 0.9f);
        }
        List<LatLng> m12040l = this.f8568d.m12040l();
        if (m12040l != null && m12040l.size() > 0) {
            if (this.f8567c == null) {
                this.f8567c = this.f8565a.addPolyline(C2478i.m12016a(m12040l, 4, this.f8566b.getResources().getColor(C2300R.color.polyline_coclor)));
            } else {
                this.f8567c.setPoints(m12040l);
            }
            this.f8568d.m12061a(this.f8567c);
        }
        if (this.f8570f != null) {
            this.f8570f.remove();
            this.f8570f = null;
        }
        if (C2472d.m12036p().m12054c() != null) {
            C2472d.m12036p().m12054c().clear();
        }
    }

    /* renamed from: a */
    public void m11995a(int i) {
        if (this.f8569e.m11312at().m10702e() == 6) {
            List<Marker> m12043i = this.f8568d.m12043i();
            if (m12043i.size() < 1 || i > m12043i.size() || i < 1) {
                return;
            }
            if (i <= m12043i.size() - 1) {
                Marker marker = m12043i.get(i - 1);
                marker.setIcons(C2479j.m12012a(this.f8569e.f9270d, ((FlyActionBean) marker.getObject()).getHeight(), false, C2300R.C2301drawable.img_fly_origin_blue_m, C2300R.C2301drawable.img_fly_origin_flash));
                marker.setAnchor(0.5f, 0.8f);
            } else if (i == m12043i.size()) {
                Marker marker2 = m12043i.get(m12043i.size() - 1);
                marker2.setIcon(C2479j.m12013a(this.f8569e.f9270d, C2300R.C2301drawable.img_fly_flag_blue, ((FlyActionBean) marker2.getObject()).getHeight(), false));
                marker2.setAnchor(0.15f, 0.9f);
            }
            if (i < 2) {
                return;
            }
            for (int i2 = 0; i2 < i - 1; i2++) {
                Marker marker3 = m12043i.get(i2);
                marker3.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_origin_red));
                marker3.setAnchor(0.5f, 0.7f);
            }
        }
    }

    /* renamed from: a */
    public void m11994a(LatLng latLng) {
        List<LatLng> m12054c = C2472d.m12036p().m12054c();
        if (m12054c == null || m12054c.contains(latLng)) {
            return;
        }
        m12054c.add(latLng);
        if (m12054c.size() < 2) {
            return;
        }
        if (this.f8570f == null) {
            this.f8570f = this.f8565a.addPolyline(C2478i.m12016a(m12054c, 4, this.f8566b.getResources().getColor(C2300R.color.drone_inface_line)).zIndex(50.0f));
        } else {
            this.f8570f.setPoints(m12054c);
        }
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2467a
    /* renamed from: a */
    public void mo11993a(LatLng latLng, int i) {
        List<LatLng> m12040l = this.f8568d.m12040l();
        List<Marker> m12043i = this.f8568d.m12043i();
        if (m12043i != null && m12043i.size() >= 20) {
            C2284z.m12696a(this.f8569e.f9270d, (int) C2300R.C2303string.waypointCountOut, 3000);
            return;
        }
        for (Circle circle : C2499g.m11911c().m11910d()) {
            if (circle.contains(latLng) && !C2487a.m11979a().m11977a(latLng) && C3632ab.m7729c(latLng, circle.getCenter()).m7698a() <= circle.getRadius()) {
                C2284z.m12696a(this.f8569e.f9270d, (int) C2300R.C2303string.flyzonwaypoint, 3000);
                return;
            }
        }
        C3639ai m7726a = C3633ac.m7726a(this.f8569e.mo11201x().m10612b(), this.f8569e.mo11201x().m10611c());
        double m7698a = C3632ab.m7729c(latLng, new LatLng(m7726a.m7702a(), m7726a.m7700b())).m7698a();
        if (m7698a > 500.0d) {
            if (m7698a <= 500.0d) {
                return;
            }
            C2284z.m12697a(this.f8566b, (int) C2300R.C2303string.outterwaypoint);
            return;
        }
        FlyActionBean flyActionBean = new FlyActionBean();
        flyActionBean.setLatLng(latLng);
        flyActionBean.setDrawableRes(i);
        flyActionBean.setCanclick(true);
        flyActionBean.setType(2);
        flyActionBean.setModelType(1);
        flyActionBean.setHeight(this.f8568d.m12041k());
        flyActionBean.setSpeek(this.f8568d.m12034r());
        Marker addMarker = this.f8565a.addMarker(C2478i.m12017a(latLng, this.f8569e.f9270d, this.f8568d.m12041k(), true, i));
        addMarker.setAnchor(0.5f, 0.88f);
        addMarker.setObject(flyActionBean);
        addMarker.setZIndex(1000.0f);
        C2472d.m12036p().m12064a(1);
        this.f8568d.m12055b(flyActionBean);
        if (m12043i != null && !m12043i.contains(addMarker)) {
            for (Marker marker : m12043i) {
                marker.setIcon(C2479j.m12013a(this.f8569e.f9270d, C2300R.C2301drawable.icon_fly_waypoint_blue, ((FlyActionBean) marker.getObject()).getHeight(), false));
            }
            m12043i.add(addMarker);
            this.f8569e.mo11220a(C2678d.EnumC2679a.SHOWHEIGHTVIEW);
        }
        List<FlyActionBean> m12042j = this.f8568d.m12042j();
        if (m12042j != null && !m12042j.contains(flyActionBean)) {
            m12042j.add(flyActionBean);
        }
        if (m12040l == null || m12040l.contains(m12040l)) {
            return;
        }
        m12040l.add(latLng);
        if (this.f8567c == null) {
            this.f8567c = this.f8565a.addPolyline(C2478i.m12016a(m12040l, 4, this.f8566b.getResources().getColor(C2300R.color.polyline_coclor)));
        } else {
            this.f8567c.setPoints(m12040l);
        }
        this.f8568d.m12061a(this.f8567c);
    }

    /* renamed from: a */
    public void m11992a(FlyActionBean flyActionBean) {
        int i = 0;
        List<LatLng> m12040l = this.f8568d.m12040l();
        List<FlyActionBean> m12042j = this.f8568d.m12042j();
        List<Marker> m12043i = this.f8568d.m12043i();
        if (flyActionBean != null && m12042j.contains(flyActionBean)) {
            i = m12042j.indexOf(flyActionBean);
            m12042j.remove(flyActionBean);
        }
        int i2 = i;
        if (m12040l != null && m12040l.contains(flyActionBean.getLatLng())) {
            m12040l.remove(flyActionBean.getLatLng());
            if (this.f8567c == null || m12040l.size() <= 0) {
                this.f8569e.mo11220a(C2678d.EnumC2679a.HIDEHEIGHTVALUE);
            } else {
                this.f8567c.setPoints(m12040l);
            }
        }
        if (m12043i != null) {
            Iterator<Marker> it2 = m12043i.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Marker next = it2.next();
                if (next.getObject().equals(flyActionBean)) {
                    next.remove();
                    m12043i.remove(next);
                    break;
                }
            }
        }
        if (m12042j.size() >= 1 && i2 <= m12042j.size() && i2 > 0) {
            this.f8568d.m12055b(m12042j.get(i2 - 1));
        } else if (m12042j.size() >= 1) {
            this.f8568d.m12055b(m12042j.get(m12042j.size() - 1));
        }
        if (m12043i.size() >= 1 && i2 <= m12043i.size() && i2 > 0) {
            m12043i.get(i2 - 1).setIcon(C2479j.m12013a(this.f8569e.f9270d, C2300R.C2301drawable.icon_fly_waypoint_red, flyActionBean.getHeight(), true));
        } else if (m12043i.size() < 1) {
        } else {
            m12043i.get(m12043i.size() - 1).setIcon(C2479j.m12013a(this.f8569e.f9270d, C2300R.C2301drawable.icon_fly_waypoint_red, flyActionBean.getHeight(), true));
        }
    }

    /* renamed from: b */
    public void m11991b() {
        if (this.f8567c != null) {
            this.f8567c.remove();
            this.f8567c = null;
        }
        if (this.f8570f != null) {
            this.f8570f.remove();
            this.f8570f = null;
        }
    }

    /* renamed from: c */
    public void m11990c() {
        List<Marker> m12043i = C2472d.m12036p().m12043i();
        List<LatLng> m12040l = C2472d.m12036p().m12040l();
        this.f8569e.mo11201x().m10609e();
        if (m12043i == null || m12043i.size() <= 0 || m12040l == null) {
            return;
        }
        C2284z.m12696a(this.f8569e.f9270d, (int) C2300R.C2303string.excute_waypoint_com, 3000);
        C2244b.m13099b(this.f8569e.f9270d).m13103a(this.f8569e.f9270d.getString(C2300R.C2303string.excute_waypoint_com));
        m12043i.get(m12043i.size() - 1).setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_red));
        C2477h.m12020a(this.f8569e.f9270d).m12021a(0);
        this.f8569e.mo11220a(C2678d.EnumC2679a.SHOWINFORWINDOW);
    }

    /* renamed from: d */
    public void m11989d() {
        List<LatLng> m12040l = C2472d.m12036p().m12040l();
        List<FlyActionBean> m12042j = C2472d.m12036p().m12042j();
        if (m12040l == null || m12042j == null) {
            return;
        }
        m12040l.clear();
        for (FlyActionBean flyActionBean : m12042j) {
            if (!m12040l.contains(flyActionBean.getLatLng())) {
                m12040l.add(flyActionBean.getLatLng());
            }
        }
        if (this.f8567c == null) {
            return;
        }
        this.f8567c.setPoints(m12040l);
    }

    /* renamed from: e */
    public void m11988e() {
        List<Marker> m12043i = this.f8568d.m12043i();
        if (m12043i == null || m12043i.size() <= 0) {
            return;
        }
        Marker marker = m12043i.get(m12043i.size() - 1);
        FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
        if (flyActionBean == null || flyActionBean.getModelType() != 1) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(true);
        marker.setTitle("");
        marker.showInfoWindow();
    }

    /* renamed from: f */
    public void m11987f() {
        List<Marker> m12043i = this.f8568d.m12043i();
        if (m12043i == null || m12043i.size() <= 0) {
            return;
        }
        Marker marker = m12043i.get(m12043i.size() - 1);
        FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
        if (marker == null || flyActionBean == null || flyActionBean.getModelType() != 1) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(false);
        marker.setTitle(this.f8569e.f9270d.getString(C2300R.C2303string.delete_marker));
        marker.showInfoWindow();
    }

    /* renamed from: g */
    public void m11986g() {
        List<Marker> m12043i = this.f8568d.m12043i();
        if (m12043i == null || m12043i.size() <= 0) {
            return;
        }
        Marker marker = m12043i.get(m12043i.size() - 1);
        FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
        if (flyActionBean == null || flyActionBean.getModelType() != 1) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(true);
        marker.setTitle("");
        marker.showInfoWindow();
    }

    /* renamed from: h */
    public void m11985h() {
        List<Marker> m12043i = this.f8568d.m12043i();
        if (m12043i == null || m12043i.size() <= 0) {
            return;
        }
        Marker marker = m12043i.get(m12043i.size() - 1);
        if (!marker.isInfoWindowShown()) {
            return;
        }
        marker.hideInfoWindow();
    }
}
