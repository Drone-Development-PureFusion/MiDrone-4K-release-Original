package com.amap.api.maps.model;

import com.amap.api.mapcore.util.C0924ds;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* renamed from: com.amap.api.maps.model.a */
/* loaded from: classes.dex */
class C1144a {

    /* renamed from: a */
    private final C0924ds f3818a;

    /* renamed from: b */
    private final int f3819b;

    /* renamed from: c */
    private List<WeightedLatLng> f3820c;

    /* renamed from: d */
    private List<C1144a> f3821d;

    private C1144a(double d, double d2, double d3, double d4, int i) {
        this(new C0924ds(d, d2, d3, d4), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1144a(C0924ds c0924ds) {
        this(c0924ds, 0);
    }

    private C1144a(C0924ds c0924ds, int i) {
        this.f3821d = null;
        this.f3818a = c0924ds;
        this.f3819b = i;
    }

    /* renamed from: a */
    private void m17377a() {
        this.f3821d = new ArrayList(4);
        this.f3821d.add(new C1144a(this.f3818a.f2835a, this.f3818a.f2839e, this.f3818a.f2836b, this.f3818a.f2840f, this.f3819b + 1));
        this.f3821d.add(new C1144a(this.f3818a.f2839e, this.f3818a.f2837c, this.f3818a.f2836b, this.f3818a.f2840f, this.f3819b + 1));
        this.f3821d.add(new C1144a(this.f3818a.f2835a, this.f3818a.f2839e, this.f3818a.f2840f, this.f3818a.f2838d, this.f3819b + 1));
        this.f3821d.add(new C1144a(this.f3818a.f2839e, this.f3818a.f2837c, this.f3818a.f2840f, this.f3818a.f2838d, this.f3819b + 1));
        List<WeightedLatLng> list = this.f3820c;
        this.f3820c = null;
        for (WeightedLatLng weightedLatLng : list) {
            m17376a(weightedLatLng.getPoint().f4726x, weightedLatLng.getPoint().f4727y, weightedLatLng);
        }
    }

    /* renamed from: a */
    private void m17376a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.f3821d == null) {
            if (this.f3820c == null) {
                this.f3820c = new ArrayList();
            }
            this.f3820c.add(weightedLatLng);
            if (this.f3820c.size() <= 50 || this.f3819b >= 40) {
                return;
            }
            m17377a();
        } else if (d2 < this.f3818a.f2840f) {
            if (d < this.f3818a.f2839e) {
                this.f3821d.get(0).m17376a(d, d2, weightedLatLng);
            } else {
                this.f3821d.get(1).m17376a(d, d2, weightedLatLng);
            }
        } else if (d < this.f3818a.f2839e) {
            this.f3821d.get(2).m17376a(d, d2, weightedLatLng);
        } else {
            this.f3821d.get(3).m17376a(d, d2, weightedLatLng);
        }
    }

    /* renamed from: a */
    private void m17374a(C0924ds c0924ds, Collection<WeightedLatLng> collection) {
        if (!this.f3818a.m18475a(c0924ds)) {
            return;
        }
        if (this.f3821d != null) {
            for (C1144a c1144a : this.f3821d) {
                c1144a.m17374a(c0924ds, collection);
            }
        } else if (this.f3820c != null) {
            if (c0924ds.m18473b(this.f3818a)) {
                collection.addAll(this.f3820c);
                return;
            }
            for (WeightedLatLng weightedLatLng : this.f3820c) {
                if (c0924ds.m18474a(weightedLatLng.getPoint())) {
                    collection.add(weightedLatLng);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Collection<WeightedLatLng> m17375a(C0924ds c0924ds) {
        ArrayList arrayList = new ArrayList();
        m17374a(c0924ds, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m17373a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f3818a.m18477a(point.f4726x, point.f4727y)) {
            m17376a(point.f4726x, point.f4727y, weightedLatLng);
        }
    }
}
