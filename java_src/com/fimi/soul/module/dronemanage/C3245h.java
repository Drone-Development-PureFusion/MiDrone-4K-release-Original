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
import com.fimi.soul.drone.p199e.C2834l;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.dronemanage.h */
/* loaded from: classes.dex */
public class C3245h extends AbstractC3247i implements C2678d.AbstractC2680b {

    /* renamed from: c */
    private AMap f12502c;

    /* renamed from: d */
    private Context f12503d;

    /* renamed from: e */
    private C2657a f12504e;

    /* renamed from: a */
    List<C2907bk> f12501a = new ArrayList();

    /* renamed from: f */
    private List<Marker> f12505f = new ArrayList();

    public C3245h(AMap aMap, Context context, C2657a c2657a) {
        this.f12502c = aMap;
        this.f12503d = context;
        this.f12504e = c2657a;
        c2657a.mo11219a(this);
    }

    /* renamed from: j */
    private void m8967j() {
        if (this.f12501a.size() > 0) {
            C2907bk c2907bk = this.f12501a.get(0);
            c2907bk.m10352c(1);
            m8975a(c2907bk);
        }
    }

    /* renamed from: k */
    private void m8966k() {
        if (this.f12501a == null || this.f12501a.size() <= 0) {
            return;
        }
        for (C2907bk c2907bk : this.f12501a) {
            c2907bk.m10352c(0);
        }
        m8974b();
    }

    /* renamed from: a */
    public void m8977a() {
        m8966k();
        if (this.f12501a.size() <= 0) {
            C2284z.m12694a(this.f12503d, this.f12503d.getResources().getString(C2300R.C2303string.insterinterfly), 0);
            return;
        }
        C2907bk c2907bk = this.f12501a.get(0);
        C3639ai m7725a = C3633ac.m7725a(0.1d, c2907bk.m10355b().latitude, c2907bk.m10355b().longitude);
        new LatLng(m7725a.m7702a(), m7725a.m7700b());
        C2834l.m10843a(this.f12504e);
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: a */
    protected void mo8961a(Message message) {
    }

    /* renamed from: a */
    public void m8976a(LatLng latLng) {
        this.f12501a.clear();
        m8972c();
        C2907bk c2907bk = new C2907bk();
        c2907bk.m10357a(latLng);
        c2907bk.m10350d(3);
        if (!this.f12501a.contains(c2907bk)) {
            this.f12501a.add(c2907bk);
        }
        m8975a(c2907bk);
    }

    /* renamed from: a */
    public void m8975a(C2907bk c2907bk) {
        Marker addMarker = c2907bk.m10349e() == 0 ? this.f12502c.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.xqd_1, "", "", this.f12503d)))) : this.f12502c.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.xqd_2, "", "", this.f12503d))));
        if (!this.f12505f.contains(addMarker)) {
            this.f12505f.add(addMarker);
        }
        addMarker.setObject(c2907bk);
    }

    /* renamed from: b */
    public void m8974b() {
        m8972c();
        for (C2907bk c2907bk : this.f12501a) {
            m8975a(c2907bk);
        }
    }

    /* renamed from: b */
    public void m8973b(C2907bk c2907bk) {
        this.f12501a.remove(c2907bk);
        m8974b();
    }

    /* renamed from: c */
    public void m8972c() {
        if (this.f12505f == null || this.f12505f.size() <= 0) {
            return;
        }
        for (Marker marker : this.f12505f) {
            if (marker != null) {
                marker.destroy();
            }
        }
        this.f12505f.clear();
    }

    /* renamed from: d */
    public List<C2907bk> m8971d() {
        return this.f12501a;
    }

    /* renamed from: e */
    public void m8970e() {
        if (this.f12501a.size() > 0) {
            m8974b();
        }
    }

    /* renamed from: f */
    public void m8969f() {
        this.f12504e.mo11214b(this);
    }

    /* renamed from: g */
    public void m8968g() {
        this.f12504e.mo11219a(this);
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo8942h() {
        super.mo8942h();
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case RETURNINTERESTWAYPOIT:
                m8967j();
                return;
            case INTERESTWAYPOINT:
                m8977a();
                return;
            default:
                return;
        }
    }
}
