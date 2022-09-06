package com.fimi.soul.module.dronemanage;

import android.content.Context;
import android.support.p001v4.app.FragmentActivity;
import android.widget.Toast;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.fimi.soul.drone.C2657a;
import java.lang.ref.WeakReference;
/* renamed from: com.fimi.soul.module.dronemanage.g */
/* loaded from: classes.dex */
public class C3244g {

    /* renamed from: a */
    private Context f12494a;

    /* renamed from: b */
    private C3249j f12495b;

    /* renamed from: c */
    private C3234b f12496c;

    /* renamed from: d */
    private C3245h f12497d;

    /* renamed from: e */
    private C3239e f12498e;

    /* renamed from: f */
    private WeakReference<Context> f12499f;

    /* renamed from: g */
    private WeakReference<C2657a> f12500g;

    public C3244g(C2657a c2657a, FragmentActivity fragmentActivity, FlightMapFragment flightMapFragment) {
        this.f12499f = new WeakReference<>(fragmentActivity);
        this.f12500g = new WeakReference<>(c2657a);
        this.f12494a = this.f12499f.get();
        m8987a(this.f12494a, c2657a.m11323ai(), this.f12500g.get(), flightMapFragment);
    }

    /* renamed from: a */
    private void m8987a(Context context, AMap aMap, C2657a c2657a, FlightMapFragment flightMapFragment) {
        this.f12495b = new C3249j(c2657a, context, flightMapFragment);
        this.f12496c = new C3234b(aMap, context, c2657a);
        this.f12497d = new C3245h(aMap, context, c2657a);
        this.f12498e = new C3239e(aMap, context, c2657a);
        this.f12498e.m9007a(this.f12495b);
        this.f12498e.m9010a(this.f12496c);
    }

    /* renamed from: a */
    public void m8990a() {
        this.f12495b.m8948d();
        this.f12497d.m8972c();
        this.f12496c.m9031b();
        if (this.f12496c.m9028d().size() < 1) {
            Toast.makeText(this.f12494a, "请设置指定航点", 0);
        }
    }

    /* renamed from: a */
    public void m8989a(int i) {
        if (C3259l.m8924a() == 1 || C3259l.m8924a() == 6 || C3259l.m8924a() == 7 || i == 6) {
            this.f12495b.m8950c(i);
        } else if (C3259l.m8924a() == 2) {
            this.f12496c.m9027e();
        } else if (C3259l.m8924a() == 3) {
            this.f12497d.m8970e();
        }
        this.f12495b.m8940k();
        this.f12496c.m9025g();
        this.f12497d.m8968g();
        m8981g().m9016a();
        m8981g().m9002d();
    }

    /* renamed from: a */
    public void m8988a(int i, LatLng latLng) {
        switch (C3259l.m8924a()) {
            case 2:
                this.f12496c.m9033a(latLng);
                if (i != 4) {
                    return;
                }
                this.f12496c.m9034a();
                return;
            case 3:
                this.f12497d.m8976a(latLng);
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
                this.f12495b.m8960a(latLng, 0);
                return;
        }
    }

    /* renamed from: b */
    public void m8986b() {
        this.f12495b.m8948d();
        this.f12496c.m9029c();
        this.f12497d.m8974b();
    }

    /* renamed from: c */
    public void m8985c() {
        this.f12495b.m8951c();
        this.f12496c.m9029c();
        this.f12497d.m8972c();
    }

    /* renamed from: d */
    public void m8984d() {
        this.f12495b.m8948d();
        this.f12496c.m9029c();
        this.f12497d.m8972c();
    }

    /* renamed from: e */
    public void m8983e() {
        this.f12495b.m8941j();
        this.f12496c.m9026f();
        this.f12497d.m8969f();
        this.f12498e.m9006b();
    }

    /* renamed from: f */
    public C3234b m8982f() {
        return this.f12496c;
    }

    /* renamed from: g */
    public C3239e m8981g() {
        return this.f12498e;
    }

    /* renamed from: h */
    public C3245h m8980h() {
        return this.f12497d;
    }

    /* renamed from: i */
    public C3249j m8979i() {
        return this.f12495b;
    }

    /* renamed from: j */
    public void m8978j() {
        this.f12498e.m9004c();
    }
}
