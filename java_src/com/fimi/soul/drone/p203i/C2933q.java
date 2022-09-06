package com.fimi.soul.drone.p203i;

import com.amap.api.maps.model.LatLng;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.drone.i.q */
/* loaded from: classes.dex */
public class C2933q extends C2822e {

    /* renamed from: b */
    List<LatLng> f11078b = new ArrayList();

    public C2933q(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: b */
    private void m10191b() {
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATELINE);
    }

    /* renamed from: a */
    public List<LatLng> m10194a() {
        return this.f11078b;
    }

    /* renamed from: a */
    public void m10193a(LatLng latLng) {
        this.f11078b.remove(latLng);
        m10191b();
    }

    /* renamed from: a */
    public void m10192a(List<LatLng> list) {
        for (LatLng latLng : list) {
            this.f11078b.add(latLng);
        }
        m10191b();
    }

    /* renamed from: b */
    public void m10190b(List<LatLng> list) {
        list.removeAll(list);
    }
}
