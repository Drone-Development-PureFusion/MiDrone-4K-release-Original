package com.fimi.soul.biz.p178g;

import android.content.Context;
import android.os.Handler;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.DroneModelBean;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.droneFragment.C3185g;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.DialogC3650an;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
/* renamed from: com.fimi.soul.biz.g.d */
/* loaded from: classes.dex */
public class C2448d implements C2678d.AbstractC2680b {

    /* renamed from: a */
    private DroneModelBean f8428a;

    /* renamed from: b */
    private AbstractC2453e f8429b;

    /* renamed from: c */
    private C2657a f8430c;

    /* renamed from: d */
    private int f8431d;

    /* renamed from: h */
    private int f8435h;

    /* renamed from: i */
    private DialogC3650an f8436i;

    /* renamed from: k */
    private WeakReference<Context> f8438k;

    /* renamed from: l */
    private C2454f f8439l;

    /* renamed from: o */
    private C2477h f8442o;

    /* renamed from: p */
    private boolean f8443p;

    /* renamed from: r */
    private int f8445r;

    /* renamed from: e */
    private int f8432e = 20;

    /* renamed from: f */
    private int f8433f = 20;

    /* renamed from: g */
    private int f8434g = 100;

    /* renamed from: j */
    private boolean f8437j = true;

    /* renamed from: m */
    private Handler f8440m = new Handler();

    /* renamed from: n */
    private Runnable f8441n = new Runnable() { // from class: com.fimi.soul.biz.g.d.1
        @Override // java.lang.Runnable
        public void run() {
            C2448d.this.m12150c();
        }
    };

    /* renamed from: q */
    private Observer f8444q = new Observer() { // from class: com.fimi.soul.biz.g.d.2
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            C2448d.this.m12153b();
            switch (C2448d.this.f8432e) {
                case 1:
                case 2:
                    if (C2448d.this.f8428a.getCurrentFlightModel() == 7 && C2448d.this.f8432e != 2) {
                        C2448d.this.f8429b.mo9602a(C2300R.C2303string.comtohome);
                        C2448d.this.f8439l.m12134a(C2448d.this.f8430c.f9270d.getString(C2300R.C2303string.comtohome));
                        C2448d.this.f8430c.mo11220a(C2678d.EnumC2679a.NOTIDRONEFLOOR);
                        return;
                    } else if (C2448d.this.f8428a.getCurrentFlightModel() != 3) {
                        C2448d.this.f8429b.mo9602a(C2300R.C2303string.comtakeoff);
                        C2448d.this.f8439l.m12134a(C2448d.this.f8430c.f9270d.getString(C2300R.C2303string.comtakeoff));
                        return;
                    } else {
                        C2448d.this.f8429b.mo9602a(C2300R.C2303string.comalding);
                        C2448d.this.f8439l.m12134a(C2448d.this.f8430c.f9270d.getString(C2300R.C2303string.comalding));
                        C2448d.this.f8430c.mo11220a(C2678d.EnumC2679a.NOTIDRONEFLOOR);
                        return;
                    }
                default:
                    return;
            }
        }
    };

    public C2448d(AbstractC2453e abstractC2453e, C2657a c2657a, Context context) {
        this.f8429b = abstractC2453e;
        this.f8428a = new DroneModelBean(c2657a);
        this.f8428a.addObserver(this.f8444q);
        this.f8430c = c2657a;
        this.f8438k = new WeakReference<>(context);
        this.f8439l = new C2454f(c2657a);
        this.f8442o = C2477h.m12020a(context);
    }

    /* renamed from: a */
    private void m12156a(int i) {
        this.f8429b.mo9602a(i);
    }

    /* renamed from: b */
    private void m12152b(int i) {
        this.f8429b.mo9591b(i);
    }

    /* renamed from: f */
    private void m12144f() {
        if (this.f8430c.m11312at().m10700g().judgeNoAction()) {
            m12140i();
            m12139j();
        }
    }

    /* renamed from: g */
    private void m12142g() {
        if ((!this.f8430c.m11312at().m10700g().isEnterModel() || this.f8430c.m11291i().m10544k() || this.f8433f == 0) && !m12157a()) {
            if (this.f8445r != 0) {
                this.f8445r = 0;
            }
            this.f8429b.mo9601a(0, 4);
            return;
        }
        this.f8445r++;
        if (this.f8445r <= 3) {
            return;
        }
        this.f8429b.mo9601a(C2300R.C2303string.exit, 0);
        this.f8445r = 0;
    }

    /* renamed from: h */
    private void m12141h() {
        if (!this.f8430c.m11320al() && !this.f8430c.m11316ap()) {
            if (!this.f8430c.m11310av().m10567j() || this.f8430c.m11312at().m10707a() != 0) {
                m12156a(C2300R.C2303string.self_error_result);
                m12152b(C2300R.C2301drawable.notnormal_icon);
                return;
            }
            m12156a(C2300R.C2303string.attibase);
            m12152b(C2300R.C2301drawable.icon_flight_model_atti3x);
        } else if (this.f8432e == 2 && !this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.lightstreamfly);
            m12152b(C2300R.C2301drawable.icon_flight_model_vpu3x);
        } else if (this.f8432e == 1 && !this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.gpsfly);
            this.f8443p = false;
            m12152b(C2300R.C2301drawable.icon_flight_model_gps3x);
        } else if (this.f8432e == 0 && !this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.attibase);
            m12152b(C2300R.C2301drawable.icon_flight_model_atti3x);
        } else if (this.f8432e == 2 && this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.lightstreamfling);
            m12152b(C2300R.C2301drawable.icon_flight_model_vpu3x);
        } else if (this.f8432e == 1 && this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.gpsfling);
            m12152b(C2300R.C2301drawable.icon_flight_model_gps3x);
            m12138k();
        } else if (this.f8432e == 0 && this.f8430c.m11320al() && this.f8431d == 1) {
            m12156a(C2300R.C2303string.attfling);
            m12152b(C2300R.C2301drawable.icon_flight_model_atti3x);
        } else if (this.f8431d == 7) {
            m12156a(C2300R.C2303string.tohome);
            m12152b(C2300R.C2301drawable.sailround_icon);
            if (!this.f8430c.m11291i().m10544k()) {
                return;
            }
            m12144f();
        } else if (this.f8431d == 8) {
            m12144f();
            m12156a(C2300R.C2303string.returntohome);
            m12152b(C2300R.C2301drawable.sailround_icon);
            if (!this.f8437j || this.f8436i != null) {
                return;
            }
            this.f8437j = false;
            this.f8439l.m12134a(this.f8430c.f9270d.getResources().getString(C2300R.C2303string.returntohome));
            this.f8436i = new DialogC3650an(this.f8438k.get(), new DialogC3650an.AbstractC3652a() { // from class: com.fimi.soul.biz.g.d.3
                @Override // com.fimi.soul.utils.DialogC3650an.AbstractC3652a
                /* renamed from: a */
                public void mo7661a() {
                    if (C2448d.this.f8436i != null) {
                        C2448d.this.f8436i.dismiss();
                        C2448d.this.f8436i = null;
                    }
                }
            }, 3);
            this.f8436i.setCancelable(true);
            this.f8436i.show();
        } else if (this.f8431d == 3) {
            m12156a(C2300R.C2303string.landing);
            m12152b(C2300R.C2301drawable.landing_icon);
            m12144f();
        } else if (this.f8431d == 9) {
            m12144f();
            if (C3658ar.m7622a((byte) this.f8435h) == 3) {
                m12156a(C2300R.C2303string.low_power_landing);
            } else if (C3658ar.m7622a((byte) this.f8435h) == 4) {
                m12156a(C2300R.C2303string.lowlanding);
            } else {
                m12156a(C2300R.C2303string.lowlanding);
            }
            m12152b(C2300R.C2301drawable.landing_icon);
        } else if (this.f8431d == 2) {
            m12156a(C2300R.C2303string.take_off);
            m12152b(C2300R.C2301drawable.takeoff_icon);
        } else if (this.f8431d == 4) {
            this.f8443p = true;
            if (this.f8433f == 4) {
                m12156a(C2300R.C2303string.stopflyto);
                m12152b(C2300R.C2301drawable.destination_icon);
            } else if (this.f8433f != 2) {
            } else {
                m12156a(C2300R.C2303string.flyto);
                m12152b(C2300R.C2301drawable.destination_icon);
            }
        } else if (this.f8431d == 5) {
            if (this.f8433f == 4) {
                m12156a(C2300R.C2303string.stop_poi_fly);
                m12152b(C2300R.C2301drawable.detouringpoint_icon);
            } else if (this.f8433f != 2) {
            } else {
                m12156a(C2300R.C2303string.interestFly);
                m12152b(C2300R.C2301drawable.detouringpoint_icon);
            }
        } else if (this.f8431d == 6) {
            this.f8443p = true;
            if (this.f8433f == 4) {
                m12156a(C2300R.C2303string.stopwaypoint);
                m12152b(C2300R.C2301drawable.icon_fly_airline);
            } else if (this.f8433f != 2) {
            } else {
                m12156a(C2300R.C2303string.execuwaypoint);
                m12152b(C2300R.C2301drawable.icon_fly_airline);
            }
        } else if (this.f8431d != 10) {
            m12156a(C2300R.C2303string.condrone);
            m12152b(C2300R.C2301drawable.normal_icon);
        } else if (this.f8433f == 4) {
            m12156a(C2300R.C2303string.stoptake_photo);
            m12152b(C2300R.mipmap.icon_fly_mode_selfie);
        } else if (this.f8433f != 2) {
        } else {
            m12156a(C2300R.C2303string.take_photo_fly);
            m12152b(C2300R.mipmap.icon_fly_mode_selfie);
        }
    }

    /* renamed from: i */
    private void m12140i() {
        this.f8430c.mo11220a(C2678d.EnumC2679a.CLOSEFLYACTIONFRAGMENT);
    }

    /* renamed from: j */
    private void m12139j() {
        this.f8443p = false;
        this.f8430c.mo11220a(C2678d.EnumC2679a.NOTIDRONEFLOOR);
        this.f8430c.mo11220a(C2678d.EnumC2679a.HOME_RIGHT);
    }

    /* renamed from: k */
    private void m12138k() {
        if (!this.f8443p) {
            this.f8443p = true;
            this.f8430c.mo11220a(C2678d.EnumC2679a.NOTIDRONEAIR);
        }
        this.f8430c.mo11220a(C2678d.EnumC2679a.HOME_LEFT);
    }

    /* renamed from: a */
    public boolean m12157a() {
        return C3658ar.m7622a((byte) this.f8435h) == 3;
    }

    /* renamed from: b */
    public void m12153b() {
        C3185g.m9308a(false);
        this.f8440m.postDelayed(this.f8441n, 5000L);
    }

    /* renamed from: c */
    public void m12150c() {
        C3185g.m9308a(true);
    }

    /* renamed from: d */
    public void m12148d() {
        if (this.f8439l != null) {
            this.f8439l.m12137a();
        }
        this.f8430c.mo11214b(this);
    }

    /* renamed from: e */
    public void m12146e() {
        if (this.f8439l != null) {
            this.f8439l.m12133b();
        }
        this.f8430c.mo11219a(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11216ac() || !c2657a.mo11217ab().mo10898a()) {
            return;
        }
        switch (enumC2679a) {
            case DRONEERRORACTIONCODE:
            default:
                return;
            case SENDHOVERWAYPOINT:
                C3074a.m9756a().m9754a("147");
                return;
            case RETAKEUP:
                C3074a.m9756a().m9754a("146");
                return;
            case RELANDING:
                C3074a.m9756a().m9754a("145");
                c2657a.mo11220a(C2678d.EnumC2679a.NOTIDRONEFLOOR);
                return;
            case REHOME:
                C3074a.m9756a().m9754a("144");
                c2657a.mo11220a(C2678d.EnumC2679a.NOTIDRONEFLOOR);
                return;
            case NEWFRONEMODEL:
                this.f8431d = c2657a.m11312at().m10702e();
                this.f8435h = c2657a.m11312at().m10699h();
                this.f8432e = c2657a.m11312at().m10703d();
                this.f8433f = c2657a.m11312at().m10701f();
                this.f8428a.setFlightModel(this.f8431d, this.f8432e);
                m12142g();
                if (this.f8431d != 8) {
                    this.f8437j = true;
                }
                if (C3185g.m9303d().get()) {
                    m12141h();
                }
                if (this.f8434g == 5 && this.f8431d != 5) {
                    this.f8439l.m12134a(c2657a.f9270d.getString(C2300R.C2303string.poi_point_com));
                }
                if (this.f8434g != 10 && this.f8431d == 10) {
                    c2657a.mo11220a(C2678d.EnumC2679a.ENTRYTAKEPHOTOMODEL);
                }
                this.f8434g = this.f8431d;
                return;
        }
    }
}
