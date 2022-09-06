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
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.k */
/* loaded from: classes.dex */
public class C2480k implements AbstractC2467a {

    /* renamed from: a */
    private AMap f8553a;

    /* renamed from: b */
    private Context f8554b;

    /* renamed from: c */
    private C2657a f8555c;

    /* renamed from: d */
    private C2472d f8556d = C2472d.m12036p();

    /* renamed from: e */
    private Marker f8557e;

    /* renamed from: f */
    private Polyline f8558f;

    public C2480k(AMap aMap, Context context, C2657a c2657a) {
        this.f8555c = c2657a;
        this.f8553a = aMap;
        this.f8554b = context;
    }

    /* renamed from: a */
    public void m12010a() {
        C2886aq mo11202w = this.f8555c.mo11202w();
        m12009a(mo11202w.m10499f(), mo11202w.m10500e());
    }

    /* renamed from: a */
    public void m12009a(double d, double d2) {
        C3639ai m7726a = C3633ac.m7726a(d, d2);
        mo11993a(new LatLng(m7726a.m7702a(), m7726a.m7700b()), 0);
    }

    /* renamed from: a */
    public void m12008a(LatLng latLng) {
        List<LatLng> m12054c = C2472d.m12036p().m12054c();
        if (m12054c == null || m12054c.contains(latLng)) {
            return;
        }
        m12054c.add(latLng);
        if (m12054c.size() < 2) {
            return;
        }
        if (this.f8558f == null) {
            this.f8558f = this.f8553a.addPolyline(C2478i.m12016a(m12054c, 4, this.f8554b.getResources().getColor(C2300R.color.drone_inface_line)).zIndex(50.0f));
        } else {
            this.f8558f.setPoints(m12054c);
        }
    }

    @Override // com.fimi.soul.biz.p180i.AbstractC2467a
    /* renamed from: a */
    public void mo11993a(LatLng latLng, int i) {
        for (Circle circle : C2499g.m11911c().m11910d()) {
            if (!C2487a.m11979a().m11977a(latLng) && C3632ab.m7729c(latLng, circle.getCenter()).m7698a() <= circle.getRadius()) {
                C2284z.m12696a(this.f8555c.f9270d, (int) C2300R.C2303string.flyzonwaypoint, 3000);
                return;
            }
        }
        C3639ai m7726a = C3633ac.m7726a(this.f8555c.mo11201x().m10612b(), this.f8555c.mo11201x().m10611c());
        double m7698a = C3632ab.m7729c(latLng, new LatLng(m7726a.m7702a(), m7726a.m7700b())).m7698a();
        if (m7698a > 500.0d) {
            if (m7698a <= 500.0d) {
                return;
            }
            C2284z.m12697a(this.f8554b, (int) C2300R.C2303string.outterwaypoint);
            return;
        }
        List<FlyActionBean> m12042j = this.f8556d.m12042j();
        if (this.f8557e != null) {
            ((FlyActionBean) this.f8557e.getObject()).setLatLng(latLng);
            this.f8557e.setPosition(latLng);
            return;
        }
        FlyActionBean m12047f = C2472d.m12036p().m12047f();
        if (m12047f == null) {
            m12047f = new FlyActionBean();
        }
        m12047f.setLatLng(latLng);
        m12047f.setDrawableRes(C2300R.C2301drawable.img_fly_flag_blue);
        m12047f.setCanclick(true);
        m12047f.setType(2);
        m12047f.setModelType(3);
        m12047f.setStyleInfo(1);
        m12047f.setHeight(this.f8556d.m12041k());
        this.f8557e = this.f8553a.addMarker(C2478i.m12017a(latLng, this.f8555c.f9270d, this.f8556d.m12041k(), true, C2300R.C2301drawable.img_fly_flag_blue));
        this.f8557e.setObject(m12047f);
        this.f8557e.setZIndex(1000.0f);
        this.f8557e.setAnchor(0.2f, 0.8f);
        this.f8557e.setDraggable(false);
        this.f8556d.m12060a(m12047f);
        if (!m12042j.contains(m12047f)) {
            m12042j.add(m12047f);
        }
        List<Marker> m12043i = this.f8556d.m12043i();
        if (m12043i != null && !m12043i.contains(this.f8557e)) {
            m12043i.add(this.f8557e);
        }
        this.f8555c.mo11220a(C2678d.EnumC2679a.SHOWPOIOPERA);
    }

    /* renamed from: a */
    public void m12007a(FlyActionBean flyActionBean) {
        List<FlyActionBean> m12042j = this.f8556d.m12042j();
        LatLng latLng = flyActionBean.getLatLng();
        if (this.f8557e == null) {
            this.f8557e = this.f8553a.addMarker(C2478i.m12017a(latLng, this.f8555c.f9270d, this.f8556d.m12041k(), true, C2300R.C2301drawable.img_fly_flag_blue));
            this.f8557e.setObject(flyActionBean);
            this.f8557e.setZIndex(1000.0f);
            this.f8557e.setAnchor(0.2f, 0.8f);
            this.f8557e.setDraggable(false);
            this.f8556d.m12055b(flyActionBean);
            if (!m12042j.contains(flyActionBean)) {
                m12042j.add(flyActionBean);
            }
            List<Marker> m12043i = this.f8556d.m12043i();
            if (m12043i != null && !m12043i.contains(this.f8557e)) {
                m12043i.add(this.f8557e);
            }
            this.f8555c.mo11220a(C2678d.EnumC2679a.SHOWPOIOPERA);
        }
    }

    /* renamed from: b */
    public void m12006b() {
        if (this.f8557e != null) {
            this.f8557e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_red));
        }
        C2477h.m12020a(this.f8554b).m12021a(0);
    }

    /* renamed from: c */
    public void m12005c() {
        if (this.f8557e != null) {
            FlyActionBean flyActionBean = (FlyActionBean) this.f8557e.getObject();
            if (flyActionBean != null) {
                flyActionBean.setStyleInfo(1);
            }
            this.f8557e.setTitle(this.f8555c.f9270d.getString(C2300R.C2303string.delete_marker));
            this.f8557e.showInfoWindow();
        }
    }

    /* renamed from: d */
    public void m12004d() {
        FlyActionBean flyActionBean;
        if (this.f8557e == null || (flyActionBean = (FlyActionBean) this.f8557e.getObject()) == null) {
            return;
        }
        flyActionBean.setType(1);
        this.f8557e.setIcon(C2479j.m12013a(this.f8555c.f9270d, C2300R.C2301drawable.img_fly_flag_blue, flyActionBean.getHeight(), false));
    }

    /* renamed from: e */
    public void m12003e() {
        FlyActionBean flyActionBean;
        if (this.f8557e == null || (flyActionBean = (FlyActionBean) this.f8557e.getObject()) == null || flyActionBean.getModelType() != 3 || 1 != flyActionBean.getType()) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(false);
        this.f8557e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
        this.f8557e.setTitle(this.f8555c.f9270d.getString(C2300R.C2303string.delete_marker));
        this.f8557e.showInfoWindow();
    }

    /* renamed from: f */
    public void m12002f() {
        FlyActionBean flyActionBean;
        if (this.f8557e == null || (flyActionBean = (FlyActionBean) this.f8557e.getObject()) == null || flyActionBean.getModelType() != 3 || 1 != flyActionBean.getType()) {
            return;
        }
        flyActionBean.setStyleInfo(2);
        flyActionBean.setCanExcute(true);
        this.f8557e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_flag_blue));
        this.f8557e.setTitle(this.f8555c.f9270d.getString(C2300R.C2303string.delete_marker));
        this.f8557e.showInfoWindow();
    }

    /* renamed from: g */
    public void m12001g() {
        FlyActionBean m12047f = C2472d.m12036p().m12047f();
        if (m12047f != null) {
            m12047f.setType(1);
            C2472d.m12036p().m12064a(1);
        }
        if (this.f8557e != null) {
            this.f8557e.hideInfoWindow();
        }
    }

    /* renamed from: h */
    public void m12000h() {
        if (this.f8557e != null) {
            if (this.f8557e.isInfoWindowShown()) {
                this.f8557e.hideInfoWindow();
            }
            this.f8557e.setDraggable(false);
        }
    }

    /* renamed from: i */
    public void m11999i() {
        if (this.f8557e != null) {
            this.f8557e.remove();
            this.f8557e = null;
        }
        if (this.f8558f != null) {
            this.f8558f.remove();
            this.f8558f = null;
        }
        this.f8556d.m12042j().clear();
        this.f8555c.mo11220a(C2678d.EnumC2679a.HIDEHEIGHTVALUE);
    }
}
