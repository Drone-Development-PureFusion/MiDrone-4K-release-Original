package com.fimi.soul.biz.p181j;

import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.fimi.soul.biz.j.a */
/* loaded from: classes.dex */
public class C2487a {

    /* renamed from: b */
    public static C2487a f8574b;

    /* renamed from: a */
    List<Circle> f8575a = new CopyOnWriteArrayList();

    private C2487a() {
    }

    /* renamed from: a */
    public static C2487a m11979a() {
        if (f8574b == null) {
            synchronized (C2487a.class) {
                if (f8574b == null) {
                    f8574b = new C2487a();
                }
            }
        }
        return f8574b;
    }

    /* renamed from: a */
    public void m11978a(Circle circle) {
        if (!this.f8575a.contains(circle)) {
            this.f8575a.add(circle);
        }
    }

    /* renamed from: a */
    public boolean m11977a(LatLng latLng) {
        boolean z = false;
        Iterator<Circle> it2 = this.f8575a.iterator();
        while (it2.hasNext() && !(z = it2.next().contains(latLng))) {
        }
        return z;
    }

    /* renamed from: b */
    public void m11976b() {
        this.f8575a.clear();
    }
}
