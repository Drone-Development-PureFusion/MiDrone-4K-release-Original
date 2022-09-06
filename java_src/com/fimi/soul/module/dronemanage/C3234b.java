package com.fimi.soul.module.dronemanage;

import android.content.Context;
import android.os.Message;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p192c.C2676a;
import com.fimi.soul.drone.p192c.C2677b;
import com.fimi.soul.drone.p199e.C2830h;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.dronemanage.b */
/* loaded from: classes.dex */
public class C3234b extends AbstractC3247i implements C2678d.AbstractC2680b {

    /* renamed from: g */
    private static final int f12416g = 1;

    /* renamed from: c */
    private AMap f12418c;

    /* renamed from: d */
    private Context f12419d;

    /* renamed from: e */
    private C2657a f12420e;

    /* renamed from: a */
    List<C2907bk> f12417a = new ArrayList();

    /* renamed from: f */
    private List<Marker> f12421f = new ArrayList();

    public C3234b(AMap aMap, Context context, C2657a c2657a) {
        this.f12418c = aMap;
        this.f12419d = context;
        this.f12420e = c2657a;
        c2657a.mo11219a(this);
    }

    /* renamed from: j */
    private void m9024j() {
        if (this.f12417a.size() > 0) {
            C2907bk c2907bk = this.f12417a.get(0);
            c2907bk.m10352c(1);
            m9032a(c2907bk);
        }
    }

    /* renamed from: k */
    private void m9023k() {
        if (this.f12417a == null || this.f12417a.size() <= 0) {
            return;
        }
        for (C2907bk c2907bk : this.f12417a) {
            c2907bk.m10352c(0);
        }
        m9031b();
    }

    /* renamed from: a */
    public void m9034a() {
        m9023k();
        if (this.f12417a.size() <= 0) {
            C2284z.m12694a(this.f12419d, this.f12419d.getResources().getString(C2300R.C2303string.insterassingfly), 0);
            return;
        }
        C2907bk c2907bk = this.f12417a.get(0);
        C3639ai m7725a = C3633ac.m7725a(0.1d, c2907bk.m10355b().latitude, c2907bk.m10355b().longitude);
        LatLng latLng = new LatLng(m7725a.m7702a(), m7725a.m7700b());
        C2830h.f10446a.f10202g = (float) latLng.latitude;
        C2830h.f10446a.f10201f = (float) latLng.longitude;
        C2830h.f10446a.f10203h = (short) c2907bk.m10353c();
        C2830h.m10848a(this.f12420e);
        C3260m.m8921a(this.f12420e, C2830h.f10446a.mo11073b());
        C3260m.m8922a();
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: a */
    protected void mo8961a(Message message) {
    }

    /* renamed from: a */
    public void m9033a(LatLng latLng) {
        this.f12417a.clear();
        m9029c();
        C2907bk c2907bk = new C2907bk();
        c2907bk.m10357a(latLng);
        c2907bk.m10350d(2);
        if (!this.f12417a.contains(c2907bk)) {
            this.f12417a.add(c2907bk);
        }
        m9032a(c2907bk);
    }

    /* renamed from: a */
    public void m9032a(C2907bk c2907bk) {
        Marker addMarker = c2907bk.m10349e() == 0 ? this.f12418c.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.hd_1, "", "", this.f12419d)))) : this.f12418c.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.hd_2, "", "", this.f12419d))));
        if (!this.f12421f.contains(addMarker)) {
            this.f12421f.add(addMarker);
        }
        addMarker.setObject(c2907bk);
    }

    /* renamed from: b */
    public void m9031b() {
        m9029c();
        for (C2907bk c2907bk : this.f12417a) {
            m9032a(c2907bk);
        }
    }

    /* renamed from: b */
    public void m9030b(C2907bk c2907bk) {
        this.f12417a.remove(c2907bk);
        m9031b();
    }

    /* renamed from: c */
    public void m9029c() {
        if (this.f12421f == null || this.f12421f.size() <= 0) {
            return;
        }
        for (Marker marker : this.f12421f) {
            if (marker != null) {
                marker.destroy();
            }
        }
        this.f12421f.clear();
    }

    /* renamed from: d */
    public List<C2907bk> m9028d() {
        return this.f12417a;
    }

    /* renamed from: e */
    public void m9027e() {
        if (this.f12417a.size() > 0) {
            m9031b();
        }
    }

    /* renamed from: f */
    public void m9026f() {
        this.f12420e.mo11214b(this);
    }

    /* renamed from: g */
    public void m9025g() {
        this.f12420e.mo11219a(this);
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo8942h() {
        super.mo8942h();
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case RETURNASSIGNWAYPOINT:
                C3260m.m8920b();
                m9024j();
                return;
            case ASSIGNWAYPOINT:
                m9034a();
                return;
            default:
                return;
        }
    }
}
