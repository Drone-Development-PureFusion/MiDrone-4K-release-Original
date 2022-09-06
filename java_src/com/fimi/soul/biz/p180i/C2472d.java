package com.fimi.soul.biz.p180i;

import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.fimi.soul.entity.FlyActionBean;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.d */
/* loaded from: classes.dex */
public class C2472d {

    /* renamed from: e */
    private int f8520e;

    /* renamed from: f */
    private Circle f8521f;

    /* renamed from: i */
    private Polyline f8524i;

    /* renamed from: l */
    private volatile FlyActionBean f8527l;

    /* renamed from: m */
    private volatile FlyActionBean f8528m;

    /* renamed from: n */
    private volatile FlyActionBean f8529n;

    /* renamed from: p */
    private Marker f8531p;

    /* renamed from: q */
    private boolean f8532q;

    /* renamed from: a */
    private int f8516a = 5;

    /* renamed from: b */
    private int f8517b = 4;

    /* renamed from: c */
    private int f8518c = 4;

    /* renamed from: d */
    private int f8519d = 4;

    /* renamed from: g */
    private volatile List<LatLng> f8522g = new ArrayList();

    /* renamed from: h */
    private volatile List<LatLng> f8523h = new ArrayList();

    /* renamed from: j */
    private int f8525j = 20;

    /* renamed from: k */
    private int f8526k = 1;

    /* renamed from: o */
    private volatile int f8530o = 30;

    /* renamed from: r */
    private List<Marker> f8533r = new ArrayList();

    /* renamed from: s */
    private volatile List<FlyActionBean> f8534s = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.i.d$a */
    /* loaded from: classes.dex */
    public static class C2473a {

        /* renamed from: a */
        static final C2472d f8535a = new C2472d();

        C2473a() {
        }
    }

    /* renamed from: p */
    public static C2472d m12036p() {
        return C2473a.f8535a;
    }

    /* renamed from: a */
    public int m12065a() {
        return this.f8520e;
    }

    /* renamed from: a */
    public void m12064a(int i) {
        this.f8520e = i;
    }

    /* renamed from: a */
    public void m12063a(Circle circle) {
        this.f8521f = circle;
    }

    /* renamed from: a */
    public void m12062a(Marker marker) {
        this.f8531p = marker;
    }

    /* renamed from: a */
    public void m12061a(Polyline polyline) {
        this.f8524i = polyline;
    }

    /* renamed from: a */
    public void m12060a(FlyActionBean flyActionBean) {
        this.f8528m = flyActionBean;
    }

    /* renamed from: a */
    public void m12059a(List<FlyActionBean> list) {
        this.f8534s = list;
    }

    /* renamed from: a */
    public void m12058a(boolean z) {
        this.f8532q = z;
    }

    /* renamed from: b */
    public Circle m12057b() {
        return this.f8521f;
    }

    /* renamed from: b */
    public void m12056b(int i) {
        this.f8525j = i;
    }

    /* renamed from: b */
    public void m12055b(FlyActionBean flyActionBean) {
        this.f8527l = flyActionBean;
    }

    /* renamed from: c */
    public List<LatLng> m12054c() {
        return this.f8522g;
    }

    /* renamed from: c */
    public void m12053c(int i) {
        this.f8526k = i;
    }

    /* renamed from: c */
    public void m12052c(FlyActionBean flyActionBean) {
        this.f8529n = flyActionBean;
    }

    /* renamed from: d */
    public int m12051d() {
        return this.f8525j;
    }

    /* renamed from: d */
    public void m12050d(int i) {
        if (i < this.f8516a) {
            i = this.f8516a;
        }
        this.f8530o = i;
    }

    /* renamed from: e */
    public int m12049e() {
        return this.f8526k;
    }

    /* renamed from: e */
    public void m12048e(int i) {
        this.f8517b = i;
    }

    /* renamed from: f */
    public FlyActionBean m12047f() {
        return this.f8528m;
    }

    /* renamed from: f */
    public void m12046f(int i) {
        this.f8518c = i;
    }

    /* renamed from: g */
    public Marker m12045g() {
        return this.f8531p;
    }

    /* renamed from: h */
    public boolean m12044h() {
        return this.f8532q;
    }

    /* renamed from: i */
    public List<Marker> m12043i() {
        return this.f8533r;
    }

    /* renamed from: j */
    public List<FlyActionBean> m12042j() {
        return this.f8534s;
    }

    /* renamed from: k */
    public int m12041k() {
        return this.f8530o;
    }

    /* renamed from: l */
    public List<LatLng> m12040l() {
        return this.f8523h;
    }

    /* renamed from: m */
    public Polyline m12039m() {
        return this.f8524i;
    }

    /* renamed from: n */
    public FlyActionBean m12038n() {
        return this.f8527l;
    }

    /* renamed from: o */
    public FlyActionBean m12037o() {
        return this.f8529n;
    }

    /* renamed from: q */
    public int m12035q() {
        return this.f8517b;
    }

    /* renamed from: r */
    public int m12034r() {
        return this.f8518c;
    }

    /* renamed from: s */
    public void m12033s() {
        if (this.f8533r != null) {
            for (Marker marker : this.f8533r) {
                marker.remove();
            }
            this.f8533r.clear();
        }
        if (this.f8524i != null) {
            this.f8524i.remove();
            this.f8524i = null;
        }
        this.f8523h.clear();
        this.f8534s.clear();
        this.f8522g.clear();
    }
}
