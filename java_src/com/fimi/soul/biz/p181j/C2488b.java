package com.fimi.soul.biz.p181j;

import com.amap.api.maps.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.fimi.soul.biz.j.b */
/* loaded from: classes.dex */
public class C2488b {

    /* renamed from: b */
    public static C2488b f8576b;

    /* renamed from: a */
    List<LatLng> f8577a = new CopyOnWriteArrayList();

    private C2488b() {
    }

    /* renamed from: a */
    public static C2488b m11975a() {
        if (f8576b == null) {
            synchronized (C2488b.class) {
                if (f8576b == null) {
                    f8576b = new C2488b();
                }
            }
        }
        return f8576b;
    }

    /* renamed from: a */
    public void m11974a(LatLng latLng) {
        if (!this.f8577a.contains(latLng)) {
            this.f8577a.add(latLng);
        }
    }

    /* renamed from: b */
    public void m11973b() {
        this.f8577a.clear();
    }

    /* renamed from: b */
    public boolean m11972b(LatLng latLng) {
        return this.f8577a.contains(latLng);
    }

    /* renamed from: c */
    public void m11971c(LatLng latLng) {
        this.f8577a.remove(latLng);
    }
}
