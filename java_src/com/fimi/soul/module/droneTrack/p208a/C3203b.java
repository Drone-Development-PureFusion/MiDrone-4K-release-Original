package com.fimi.soul.module.droneTrack.p208a;

import com.amap.api.maps.model.LatLng;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2910e;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.fimi.soul.module.droneTrack.a.b */
/* loaded from: classes.dex */
public class C3203b {

    /* renamed from: a */
    public static C3203b f12306a;

    /* renamed from: d */
    private volatile LinkedHashMap<Integer, List<Object>> f12309d;

    /* renamed from: e */
    private volatile List<LatLng> f12310e;

    /* renamed from: f */
    private boolean f12311f;

    /* renamed from: g */
    private boolean f12312g;

    /* renamed from: h */
    private boolean f12313h;

    /* renamed from: i */
    private boolean f12314i;

    /* renamed from: j */
    private double[] f12315j = {3.15d, 3.47d, 3.64d, 3.79d, 4.1d};

    /* renamed from: k */
    private double[] f12316k = {3.43d, 3.73d, 3.88d, 4.02d, 4.16d};

    /* renamed from: b */
    C2910e f12307b = new C2910e();

    /* renamed from: c */
    C2908c f12308c = new C2908c();

    /* renamed from: a */
    public static C3203b m9155a() {
        if (f12306a == null) {
            synchronized (C3203b.class) {
                if (f12306a == null) {
                    f12306a = new C3203b();
                }
            }
        }
        return f12306a;
    }

    /* renamed from: a */
    private void m9149a(boolean... zArr) {
        for (boolean z : zArr) {
        }
    }

    /* renamed from: a */
    public void m9154a(C2908c c2908c) {
        this.f12308c = c2908c;
    }

    /* renamed from: a */
    public void m9153a(C2910e c2910e) {
        this.f12307b = c2910e;
    }

    /* renamed from: a */
    public void m9152a(List<LatLng> list) {
        this.f12310e = list;
    }

    /* renamed from: a */
    public void m9151a(boolean z) {
        this.f12314i = z;
    }

    /* renamed from: a */
    public void m9150a(double[] dArr) {
        this.f12316k = dArr;
    }

    /* renamed from: b */
    public LinkedHashMap<Integer, List<Object>> m9148b() {
        if (this.f12309d == null) {
            this.f12309d = new LinkedHashMap<>();
        }
        return this.f12309d;
    }

    /* renamed from: b */
    public void m9147b(boolean z) {
        this.f12313h = z;
    }

    /* renamed from: b */
    public void m9146b(double[] dArr) {
        this.f12315j = dArr;
    }

    /* renamed from: c */
    public List<LatLng> m9145c() {
        if (this.f12310e == null) {
            this.f12310e = new LinkedList();
        }
        return this.f12310e;
    }

    /* renamed from: c */
    public void m9144c(boolean z) {
        this.f12312g = z;
    }

    /* renamed from: d */
    public void m9143d() {
        this.f12309d = null;
        this.f12310e = null;
        m9149a(this.f12311f, this.f12312g, this.f12313h, this.f12314i);
    }

    /* renamed from: d */
    public void m9142d(boolean z) {
        this.f12311f = z;
    }

    /* renamed from: e */
    public boolean m9141e() {
        return this.f12314i;
    }

    /* renamed from: f */
    public boolean m9140f() {
        return this.f12313h;
    }

    /* renamed from: g */
    public boolean m9139g() {
        return this.f12312g;
    }

    /* renamed from: h */
    public boolean m9138h() {
        return this.f12311f;
    }

    /* renamed from: i */
    public double[] m9137i() {
        return this.f12316k;
    }

    /* renamed from: j */
    public double[] m9136j() {
        return this.f12315j;
    }

    /* renamed from: k */
    public C2908c m9135k() {
        return this.f12308c;
    }

    /* renamed from: l */
    public C2910e m9134l() {
        return this.f12307b;
    }
}
