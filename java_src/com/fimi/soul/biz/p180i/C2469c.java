package com.fimi.soul.biz.p180i;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.FragmentManager;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p178g.C2447c;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2890au;
import com.fimi.soul.drone.p203i.C2899bc;
import com.fimi.soul.drone.p203i.p204a.C2861a;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.module.droneFragment.FlyActionSettingFragment;
import com.fimi.soul.module.dronemanage.C3239e;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
import java.util.Observable;
/* renamed from: com.fimi.soul.biz.i.c */
/* loaded from: classes.dex */
public class C2469c extends Observable implements C2678d.AbstractC2680b {

    /* renamed from: r */
    private static final int f8495r = 11;

    /* renamed from: a */
    private C2477h f8496a;

    /* renamed from: b */
    private C2474e f8497b;

    /* renamed from: c */
    private C2485o f8498c;

    /* renamed from: d */
    private C2468b f8499d;

    /* renamed from: e */
    private C2480k f8500e;

    /* renamed from: f */
    private C3239e f8501f;

    /* renamed from: g */
    private C2657a f8502g;

    /* renamed from: h */
    private int f8503h;

    /* renamed from: i */
    private int f8504i;

    /* renamed from: p */
    private boolean f8511p;

    /* renamed from: q */
    private FragmentManager f8512q;

    /* renamed from: j */
    private boolean f8505j = true;

    /* renamed from: k */
    private boolean f8506k = true;

    /* renamed from: l */
    private boolean f8507l = true;

    /* renamed from: m */
    private boolean f8508m = true;

    /* renamed from: n */
    private int f8509n = 1000;

    /* renamed from: o */
    private boolean f8510o = true;

    /* renamed from: s */
    private Handler f8513s = new Handler() { // from class: com.fimi.soul.biz.i.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == C2469c.this.f8509n) {
                C2469c.this.f8510o = false;
            } else if (message.what != 11) {
            } else {
                C2469c.this.f8511p = false;
            }
        }
    };

    public C2469c(C2657a c2657a, AMap aMap, Context context, FragmentManager fragmentManager) {
        this.f8512q = fragmentManager;
        this.f8502g = c2657a;
        c2657a.mo11219a(this);
        this.f8496a = C2477h.m12020a(c2657a.f9270d);
        this.f8497b = new C2474e(aMap, context, c2657a);
        this.f8498c = new C2485o(aMap, context, c2657a);
        this.f8500e = new C2480k(aMap, context, c2657a);
        this.f8501f = new C3239e(aMap, context, c2657a);
        this.f8499d = new C2468b(aMap, context, c2657a);
    }

    /* renamed from: e */
    private void m12069e() {
        if (this.f8503h == 4 && this.f8504i == 1 && !this.f8511p) {
            this.f8497b.m12029c();
            C2284z.m12696a(this.f8502g.f9270d, (int) C2300R.C2303string.excute_direction_com, 3000);
            C2244b.m13099b(this.f8502g.f9270d).m13103a(this.f8502g.f9270d.getString(C2300R.C2303string.excute_direction_com));
            this.f8497b.m12028d();
        }
        this.f8503h = this.f8504i;
    }

    /* renamed from: f */
    private void m12068f() {
        if (this.f8503h == 10 && this.f8504i == 1 && !this.f8511p) {
            C2284z.m12696a(this.f8502g.f9270d, (int) C2300R.C2303string.excute_takephoto_com, 3000);
            C2244b.m13099b(this.f8502g.f9270d).m13103a(this.f8502g.f9270d.getString(C2300R.C2303string.excute_takephoto_com));
            C2477h.m12020a(this.f8502g.f9270d).m12021a(0);
        }
        this.f8503h = this.f8504i;
    }

    /* renamed from: g */
    private void m12067g() {
        C2886aq mo11202w = this.f8502g.mo11202w();
        C3639ai m7726a = C3633ac.m7726a(mo11202w.m10499f(), mo11202w.m10500e());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        if (this.f8496a.m12022a().get() == 1) {
            this.f8498c.m11994a(latLng);
        } else if (this.f8496a.m12022a().get() == 2) {
            this.f8497b.m12031a(latLng);
        } else if (this.f8496a.m12022a().get() == 3) {
            this.f8500e.m12008a(latLng);
        } else if (this.f8496a.m12022a().get() != 4) {
        } else {
            this.f8499d.m12084b(latLng);
        }
    }

    /* renamed from: h */
    private void m12066h() {
        int m10609e = this.f8502g.mo11201x().m10609e();
        if (this.f8503h == 6 && this.f8504i == 1) {
            this.f8498c.m11990c();
        } else if (this.f8503h == 7 && this.f8504i == 1 && this.f8502g.m11320al()) {
            this.f8502g.mo11220a(C2678d.EnumC2679a.NOTIDRONEAIR);
        }
        this.f8503h = this.f8504i;
        if (this.f8504i == 6) {
            m12067g();
            if (this.f8510o) {
                return;
            }
            this.f8498c.m11995a(m10609e);
        }
    }

    /* renamed from: a */
    public void m12078a() {
        int m12065a = C2472d.m12036p().m12065a();
        if (m12065a != 0) {
            switch (m12065a) {
                case 1:
                    FlyActionBean m12038n = C2472d.m12036p().m12038n();
                    if (2 == m12038n.getType()) {
                        this.f8498c.m11992a(m12038n);
                    } else {
                        C2472d.m12036p().m12033s();
                        this.f8502g.mo11220a(C2678d.EnumC2679a.CLEARDATA);
                    }
                    this.f8502g.mo11220a(C2678d.EnumC2679a.SHOWHEIGHTVIEW);
                    return;
                case 2:
                    this.f8497b.m12030b();
                    return;
                case 3:
                    this.f8500e.m11999i();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void m12077a(LatLng latLng, int i) {
        if (!C2472d.m12036p().m12044h()) {
            if (this.f8496a.m12022a().get() == 1) {
                this.f8498c.mo11993a(latLng, i);
                return;
            } else if (this.f8496a.m12022a().get() == 2) {
                this.f8497b.mo11993a(latLng, i);
                return;
            } else {
                if (this.f8496a.m12022a().get() == 3) {
                }
                return;
            }
        }
        Marker m12045g = C2472d.m12036p().m12045g();
        if (m12045g == null) {
            return;
        }
        m12045g.hideInfoWindow();
        FlyActionBean flyActionBean = (FlyActionBean) m12045g.getObject();
        if (flyActionBean.getModelType() == 1) {
            m12045g.setIcon(C2479j.m12013a(this.f8502g.f9270d, C2300R.C2301drawable.icon_fly_waypoint_blue, flyActionBean.getHeight(), false));
        }
        C2472d.m12036p().m12062a((Marker) null);
        C2472d.m12036p().m12058a(false);
    }

    /* renamed from: a */
    public void m12076a(Marker marker) {
        FlyActionSettingFragment flyActionSettingFragment = (FlyActionSettingFragment) this.f8512q.findFragmentById(C2300R.C2302id.flyaction);
        FlyActionBean flyActionBean = (FlyActionBean) marker.getObject();
        List<Marker> m12043i = C2472d.m12036p().m12043i();
        if (m12043i == null || flyActionBean == null) {
            return;
        }
        if (flyActionBean.getModelType() == 1) {
            C2472d.m12036p().m12055b(flyActionBean);
        } else if (flyActionBean.getModelType() == 2) {
            C2472d.m12036p().m12052c(flyActionBean);
        } else if (flyActionBean.getModelType() == 3) {
            C2472d.m12036p().m12060a(flyActionBean);
        }
        for (Marker marker2 : m12043i) {
            FlyActionBean flyActionBean2 = (FlyActionBean) marker2.getObject();
            if (marker2.getObject().equals(flyActionBean)) {
                if (flyActionSettingFragment != null) {
                    if (flyActionSettingFragment.isVisible()) {
                        this.f8502g.mo11220a(C2678d.EnumC2679a.SHOWHEIGHTVIEW);
                        if (flyActionBean.getModelType() == 1) {
                            flyActionBean2.setDrawableRes(C2300R.C2301drawable.icon_fly_waypoint_red);
                            marker.setIcon(C2479j.m12013a(this.f8502g.f9270d, C2300R.C2301drawable.icon_fly_waypoint_red, flyActionBean2.getHeight(), true));
                            C2472d.m12036p().m12058a(true);
                            C2472d.m12036p().m12055b(flyActionBean2);
                            C2472d.m12036p().m12062a(marker2);
                        }
                    } else if (flyActionBean.getModelType() == 1) {
                        this.f8498c.m11988e();
                    } else if (C2472d.m12036p().m12065a() == 2) {
                        marker.setTitle(this.f8502g.f9270d.getString(C2300R.C2303string.delete_marker));
                        marker.showInfoWindow();
                    } else if (flyActionBean.getModelType() == 3) {
                        marker.setTitle(this.f8502g.f9270d.getString(C2300R.C2303string.delete_marker));
                        marker.showInfoWindow();
                    }
                }
            } else if (flyActionSettingFragment != null && flyActionSettingFragment.isVisible() && 2 == flyActionBean.getType()) {
                marker2.setIcon(C2479j.m12013a(this.f8502g.f9270d, C2300R.C2301drawable.icon_fly_waypoint_blue, flyActionBean2.getHeight(), false));
                flyActionBean2.setDrawableRes(C2300R.C2301drawable.icon_fly_waypoint_blue);
            }
        }
    }

    /* renamed from: b */
    public void m12073b() {
        if (this.f8496a.m12022a().get() == 1) {
            this.f8498c.m11989d();
            return;
        }
        if (this.f8496a.m12022a().get() == 2 || this.f8496a.m12022a().get() == 3) {
        }
    }

    /* renamed from: c */
    public void m12071c() {
        this.f8505j = true;
        this.f8506k = true;
        this.f8507l = true;
        this.f8508m = true;
        C2472d.m12036p().m12040l().clear();
    }

    /* renamed from: d */
    public void m12070d() {
        this.f8502g.mo11219a(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CLEARTAKEPHOTO:
                this.f8499d.m12083c();
                return;
            case CREATEPOI:
                this.f8500e.m12010a();
                return;
            case CLEANALLOBJ:
                m12071c();
                this.f8505j = true;
                C2472d.m12036p().m12033s();
                this.f8498c.m11991b();
                this.f8497b.m12030b();
                this.f8500e.m11999i();
                this.f8499d.m12083c();
                return;
            case SHOWINFORWINDOW:
                this.f8498c.m11988e();
                return;
            case RETURNASSIGNWAYPOINT:
                this.f8511p = true;
                if (!this.f8513s.hasMessages(11)) {
                    this.f8513s.sendEmptyMessageDelayed(11, 2000L);
                } else {
                    this.f8513s.removeMessages(11);
                    this.f8513s.sendEmptyMessageDelayed(11, 2000L);
                }
                C2899bc mo11208q = c2657a.mo11208q();
                if (mo11208q.m10411e() == 51) {
                    List<Marker> m12043i = C2472d.m12036p().m12043i();
                    if (m12043i != null && m12043i.size() == 0) {
                        C3639ai m7726a = C3633ac.m7726a(mo11208q.m10408h(), mo11208q.m10418b());
                        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
                        C2472d.m12036p().m12050d((int) mo11208q.m10408h());
                        C2472d.m12036p().m12048e(mo11208q.m10407i());
                        this.f8497b.mo11993a(latLng, C2300R.C2301drawable.img_fly_flag_blue);
                    }
                    this.f8497b.m12032a();
                }
                C2447c.m12158a(mo11208q.m10413d());
                C3057d.m9823a(c2657a).m9811f(133);
                return;
            case RESHWAYPOINT:
                this.f8510o = true;
                if (!this.f8513s.hasMessages(this.f8509n)) {
                    this.f8513s.sendEmptyMessageDelayed(this.f8509n, 3000L);
                }
                this.f8498c.m11996a();
                return;
            case HEARDATA:
                this.f8504i = c2657a.m11312at().m10702e();
                return;
            case CLEARDATA:
            case CANCALFLYACTION:
                this.f8498c.m11991b();
                this.f8497b.m12030b();
                this.f8500e.m11999i();
                C2472d.m12036p().m12033s();
                c2657a.mo11220a(C2678d.EnumC2679a.CLEARPOIDATA);
                return;
            case ExecuteWaypoint:
                this.f8510o = true;
                if (!this.f8513s.hasMessages(this.f8509n)) {
                    this.f8513s.sendEmptyMessageDelayed(this.f8509n, 3000L);
                }
                this.f8498c.m11996a();
                return;
            case HEARDDAY:
                if (this.f8496a.m12022a().get() == 1) {
                    if (!this.f8505j || C2472d.m12036p().m12040l().size() >= 1 || this.f8504i != 6) {
                        m12066h();
                        return;
                    }
                    this.f8505j = false;
                    c2657a.mo11220a(C2678d.EnumC2679a.READWAYPOINT);
                    return;
                } else if (this.f8496a.m12022a().get() == 2) {
                    if (this.f8506k && C2472d.m12036p().m12040l().size() < 1 && this.f8504i == 4) {
                        this.f8506k = false;
                        c2657a.mo11220a(C2678d.EnumC2679a.READFLYTO);
                        return;
                    }
                    if (this.f8504i == 4) {
                        m12067g();
                        this.f8497b.m12026f();
                    }
                    m12069e();
                    return;
                } else if (this.f8496a.m12022a().get() == 3) {
                    if (this.f8507l && C2472d.m12036p().m12040l().size() < 1 && this.f8504i == 5) {
                        this.f8507l = false;
                        c2657a.mo11220a(C2678d.EnumC2679a.READPOI);
                        return;
                    } else if (this.f8504i != 5) {
                        return;
                    } else {
                        m12067g();
                        return;
                    }
                } else if (this.f8496a.m12022a().get() != 4) {
                    this.f8503h = 0;
                    return;
                } else if (this.f8508m && this.f8499d.m12079g() && this.f8504i == 10) {
                    this.f8508m = false;
                    C3057d.m9823a(c2657a).m9832a((byte) 19, (byte) 0, (short) 0, (short) 0, (byte) 0, (short) 0, 0.0f, 0.0f);
                    return;
                } else {
                    if (this.f8504i == 10) {
                        m12067g();
                    }
                    m12068f();
                    return;
                }
            case DRONEINFLOOR:
            case NOTIDRONEFLOOR:
                this.f8498c.m11987f();
                this.f8497b.m12025g();
                this.f8500e.m12003e();
                return;
            case NOTIDRONEAIR:
                this.f8498c.m11986g();
                this.f8497b.m12024h();
                this.f8500e.m12002f();
                return;
            case HIDEINFORWINDOW:
                this.f8498c.m11985h();
                return;
            case SHOWQUITDOUBLEINFRWINDOW:
                this.f8511p = true;
                this.f8497b.m12027e();
                return;
            case DELETE_WAYPOINT:
                m12078a();
                return;
            case RETURNINTERESTWAYPOIT:
                C2890au mo11206s = c2657a.mo11206s();
                if (mo11206s.m10472j() == 22 && C2472d.m12036p().m12040l().size() < 1 && this.f8504i == 5) {
                    FlyActionBean flyActionBean = new FlyActionBean();
                    flyActionBean.setYaw_mode(mo11206s.m10480b() / 10);
                    C3639ai m7726a2 = C3633ac.m7726a(mo11206s.m10474h(), mo11206s.m10473i());
                    flyActionBean.setLatLng(new LatLng(m7726a2.m7702a(), m7726a2.m7700b()));
                    flyActionBean.setDrawableRes(C2300R.C2301drawable.img_fly_flag_blue);
                    flyActionBean.setCanclick(true);
                    flyActionBean.setType(1);
                    flyActionBean.setModelType(3);
                    flyActionBean.setStyleInfo(2);
                    flyActionBean.setStart_point_agle((short) (mo11206s.m10478d() * 1.412d));
                    flyActionBean.setSpeek(mo11206s.m10477e() / 10);
                    flyActionBean.setRidus(mo11206s.m10476f() / 10);
                    flyActionBean.setPara1(mo11206s.m10479c());
                    flyActionBean.setHeight(((int) mo11206s.m10475g()) / 10);
                    this.f8500e.m12007a(flyActionBean);
                } else {
                    this.f8500e.m12001g();
                }
                c2657a.mo11220a(C2678d.EnumC2679a.CLOSECARMERPOI);
                return;
            case SHOWDOUBLEPOI:
                this.f8500e.m12002f();
                return;
            case TAKEPHOTOBACKDATA:
                C2861a m11306az = c2657a.m11306az();
                if (m11306az.m10733j() != 18) {
                    C3639ai m7726a3 = C3633ac.m7726a(m11306az.m10740c(), m11306az.m10738e());
                    this.f8499d.m12086a(new LatLng(m7726a3.m7702a(), m7726a3.m7700b()));
                    this.f8499d.m12085b();
                    return;
                }
                this.f8511p = true;
                if (!this.f8513s.hasMessages(11)) {
                    this.f8513s.sendEmptyMessageDelayed(11, 2000L);
                    return;
                }
                this.f8513s.removeMessages(11);
                this.f8513s.sendEmptyMessageDelayed(11, 2000L);
                return;
            case QUITTAKEPHOTOFLY:
                this.f8511p = true;
                return;
            case CLEARMARKERTAKEPHOTO:
                this.f8499d.m12083c();
                return;
            case ENTRYTAKEPHOTOMODEL:
                this.f8499d.m12087a();
                return;
            case CHANGETAKEPHOTOMARKERCOLOR:
                this.f8499d.m12085b();
                return;
            default:
                return;
        }
    }
}
