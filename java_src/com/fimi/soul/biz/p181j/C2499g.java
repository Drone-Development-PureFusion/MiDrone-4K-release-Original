package com.fimi.soul.biz.p181j;

import com.amap.api.maps.model.Circle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.fimi.soul.biz.j.g */
/* loaded from: classes.dex */
public class C2499g {

    /* renamed from: a */
    private List<Circle> f8633a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private List<Circle> f8634b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private List<Circle> f8635c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private List<Circle> f8636d = new CopyOnWriteArrayList();

    /* renamed from: com.fimi.soul.biz.j.g$a */
    /* loaded from: classes.dex */
    static class C2500a {

        /* renamed from: a */
        private static final C2499g f8637a = new C2499g();

        C2500a() {
        }
    }

    /* renamed from: c */
    public static C2499g m11911c() {
        return C2500a.f8637a;
    }

    /* renamed from: a */
    public List<Circle> m11914a() {
        return this.f8635c;
    }

    /* renamed from: a */
    public void m11913a(List<Circle> list) {
        this.f8634b = list;
    }

    /* renamed from: b */
    public List<Circle> m11912b() {
        return this.f8636d;
    }

    /* renamed from: d */
    public List<Circle> m11910d() {
        return this.f8633a;
    }

    /* renamed from: e */
    public List<Circle> m11909e() {
        return this.f8634b;
    }
}
