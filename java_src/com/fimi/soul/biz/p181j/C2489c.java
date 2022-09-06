package com.fimi.soul.biz.p181j;

import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3684m;
import it.p235a.p236a.AbstractC4863e;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.fimi.soul.biz.j.c */
/* loaded from: classes.dex */
public class C2489c implements C2678d.AbstractC2680b {

    /* renamed from: a */
    private static final int f8578a = 4000000;

    /* renamed from: q */
    private static final int f8579q = 1000000;

    /* renamed from: b */
    private LatLng f8580b;

    /* renamed from: c */
    private CircleOptions f8581c;

    /* renamed from: d */
    private CircleOptions f8582d;

    /* renamed from: e */
    private CircleOptions f8583e;

    /* renamed from: f */
    private CircleOptions f8584f;

    /* renamed from: g */
    private AMap f8585g;

    /* renamed from: h */
    private C2657a f8586h;

    /* renamed from: p */
    private int f8594p;

    /* renamed from: i */
    private final List<LatLng> f8587i = new CopyOnWriteArrayList();

    /* renamed from: j */
    private final List<LatLng> f8588j = new CopyOnWriteArrayList();

    /* renamed from: k */
    private final List<LatLng> f8589k = new CopyOnWriteArrayList();

    /* renamed from: l */
    private final List<Circle> f8590l = new CopyOnWriteArrayList();

    /* renamed from: m */
    private List<Circle> f8591m = new CopyOnWriteArrayList();

    /* renamed from: n */
    private List<Circle> f8592n = new CopyOnWriteArrayList();

    /* renamed from: r */
    private int f8595r = 5;

    /* renamed from: s */
    private List<Circle> f8596s = C2499g.m11911c().m11910d();

    /* renamed from: o */
    private C2501h f8593o = C2501h.m11907a();

    public C2489c(AMap aMap, C2657a c2657a) {
        this.f8585g = aMap;
        this.f8586h = c2657a;
        c2657a.mo11219a(this);
        m11955c();
    }

    /* renamed from: a */
    private LatLng m11969a(double d, double d2) {
        C3639ai m7726a = C3633ac.m7726a(d, d2);
        return new LatLng(m7726a.m7702a(), m7726a.m7700b());
    }

    /* renamed from: a */
    private void m11968a(LatLng latLng, int i, CircleOptions circleOptions) {
        if (!this.f8589k.contains(latLng)) {
            this.f8589k.add(latLng);
            Circle addCircle = this.f8585g.addCircle(circleOptions.center(latLng).radius(i));
            if (this.f8591m.contains(addCircle)) {
                return;
            }
            this.f8591m.add(addCircle);
        }
    }

    /* renamed from: a */
    private void m11967a(LatLng latLng, int i, CircleOptions circleOptions, boolean z) {
        if (!this.f8587i.contains(latLng)) {
            this.f8587i.add(latLng);
        }
        Circle addCircle = this.f8585g.addCircle(circleOptions.center(latLng).radius(i));
        if (!this.f8592n.contains(addCircle)) {
            this.f8592n.add(addCircle);
        }
        if (!this.f8596s.contains(addCircle)) {
            this.f8596s.add(addCircle);
            C2488b.m11975a().m11974a(addCircle.getCenter());
        }
        if (z) {
            C2487a.m11979a().m11978a(addCircle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11961a(DynamicDYZ_Entity dynamicDYZ_Entity) {
        int limitRadius = (int) (dynamicDYZ_Entity.getLimitRadius() * 10.0d);
        int radius = dynamicDYZ_Entity.getRadius() * 10;
        int warinRadius = ((int) (dynamicDYZ_Entity.getWarinRadius() * 10.0d)) + radius;
        LatLng m11969a = m11969a(dynamicDYZ_Entity.getLatitude(), dynamicDYZ_Entity.getLogitude());
        if (radius < limitRadius) {
            m11968a(m11969a, limitRadius, this.f8583e);
        }
        m11958b(m11969a, warinRadius, this.f8582d);
        if (dynamicDYZ_Entity.getPushType() == 1.0d && dynamicDYZ_Entity.getNoFlyType() == 1.0d) {
            m11967a(m11969a, radius, this.f8584f, true);
        } else {
            m11967a(m11969a, radius, this.f8581c, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11960a(List<DynamicDYZ_Entity> list) {
        if (this.f8580b != null) {
            m11952d();
            for (DynamicDYZ_Entity dynamicDYZ_Entity : list) {
                if (C3632ab.m7729c(this.f8580b, m11969a(dynamicDYZ_Entity.getLatitude(), dynamicDYZ_Entity.getLogitude())).m7698a() <= 4000000.0d) {
                    m11961a(dynamicDYZ_Entity);
                }
            }
        }
    }

    /* renamed from: b */
    private void m11958b(LatLng latLng, int i, CircleOptions circleOptions) {
        if (!this.f8588j.contains(latLng)) {
            this.f8588j.add(latLng);
            Circle addCircle = this.f8585g.addCircle(circleOptions.center(latLng).radius(i));
            if (!this.f8590l.contains(addCircle)) {
                this.f8590l.add(addCircle);
            }
            if (this.f8596s.contains(addCircle)) {
                return;
            }
            this.f8596s.add(addCircle);
            C2488b.m11975a().m11974a(addCircle.getCenter());
        }
    }

    /* renamed from: b */
    private void m11956b(List<DynamicDYZ_Entity> list) {
        m11952d();
        for (DynamicDYZ_Entity dynamicDYZ_Entity : list) {
            if (((int) dynamicDYZ_Entity.getDistance()) <= f8578a) {
                m11961a(dynamicDYZ_Entity);
            }
        }
    }

    /* renamed from: c */
    private void m11955c() {
        this.f8581c = C2498f.m11915a(8000, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 0.0f, 100);
        this.f8582d = C2498f.m11915a(8000, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 0.0f, 100);
        this.f8583e = C2498f.m11915a(8000, Color.argb(99, (int) AbstractC4863e.f20783D, (int) Opcodes.FNEG, 0), Color.argb(26, 255, 138, 0), 0.0f, 100);
        this.f8584f = C2498f.m11915a(8000, Color.argb(99, 27, 242, (int) Opcodes.IUSHR), Color.argb(99, 27, 242, (int) Opcodes.IUSHR), 0.0f, 1000);
    }

    /* renamed from: c */
    private void m11953c(List<Circle> list) {
        for (Circle circle : list) {
            if (this.f8596s.contains(circle)) {
                this.f8596s.remove(circle);
                C2488b.m11975a().m11971c(circle.getCenter());
            }
            circle.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11952d() {
        m11953c(this.f8592n);
        m11953c(this.f8590l);
        m11953c(this.f8591m);
        this.f8592n.clear();
        this.f8587i.clear();
        this.f8590l.clear();
        this.f8588j.clear();
        this.f8591m.clear();
        this.f8589k.clear();
        C2487a.m11979a().m11976b();
    }

    /* renamed from: e */
    private void m11950e() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.j.c.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                LatLng latLng;
                List<DynamicDYZ_Entity> m7450a = C3684m.m7449a(C2489c.this.f8586h.f9270d).m7450a(1, new Date().getTime());
                if (m7450a == null || m7450a.size() <= 0) {
                    return;
                }
                ArrayList<DynamicDYZ_Entity> arrayList = new ArrayList();
                long time = new Date().getTime();
                for (DynamicDYZ_Entity dynamicDYZ_Entity : m7450a) {
                    if (dynamicDYZ_Entity.getStartDate() <= time && time <= dynamicDYZ_Entity.getEndDate()) {
                        arrayList.add(dynamicDYZ_Entity);
                    }
                }
                boolean z2 = false;
                String m12758g = C2277v.m12784a(C2489c.this.f8586h.f9270d).m12758g(C2502i.f8641a);
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(m12758g)) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        z = z2;
                        if (!it2.hasNext()) {
                            break;
                        }
                        DynamicDYZ_Entity dynamicDYZ_Entity2 = (DynamicDYZ_Entity) it2.next();
                        String fcIds = dynamicDYZ_Entity2.getFcIds();
                        String whileRange = dynamicDYZ_Entity2.getWhileRange();
                        if (!TextUtils.isEmpty(fcIds)) {
                            String[] split = fcIds.split(";");
                            if (dynamicDYZ_Entity2.getPushType() == 1.0d) {
                                int i = 1;
                                if (!TextUtils.isEmpty(whileRange)) {
                                    try {
                                        i = Integer.parseInt(whileRange);
                                    } catch (Exception e) {
                                    }
                                    if (i == 1) {
                                        int length = split.length;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= length) {
                                                break;
                                            } else if (split[i2].equals(m12758g)) {
                                                z = true;
                                                break;
                                            } else {
                                                arrayList2.add(dynamicDYZ_Entity2);
                                                i2++;
                                            }
                                        }
                                    } else if (i == 0) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    int length2 = split.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length2) {
                                            break;
                                        } else if (split[i3].equals(m12758g)) {
                                            z = true;
                                            break;
                                        } else {
                                            arrayList2.add(dynamicDYZ_Entity2);
                                            i3++;
                                        }
                                    }
                                }
                            } else {
                                continue;
                            }
                        } else if (dynamicDYZ_Entity2.getPushType() == 1.0d) {
                            int i4 = 1;
                            if (!TextUtils.isEmpty(whileRange)) {
                                try {
                                    i4 = Integer.parseInt(whileRange);
                                } catch (Exception e2) {
                                }
                                if (i4 == 0) {
                                    z = true;
                                }
                            }
                        }
                        z2 = z;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    arrayList.removeAll(arrayList2);
                }
                if (arrayList.size() <= 0) {
                    C2489c.this.m11952d();
                    return;
                }
                C2489c.this.f8593o.m11898e();
                if (C2489c.this.f8586h.mo11202w().m10500e() <= 0.5d || C2489c.this.f8586h.mo11202w().m10499f() <= 0.5d) {
                    Location m11305b = C2489c.this.f8586h.m11305b();
                    latLng = m11305b != null ? new LatLng(m11305b.getLatitude(), m11305b.getLongitude()) : null;
                } else {
                    C2886aq mo11202w = C2489c.this.f8586h.mo11202w();
                    latLng = new LatLng(mo11202w.m10499f(), mo11202w.m10500e());
                }
                if (latLng == null) {
                    return;
                }
                for (DynamicDYZ_Entity dynamicDYZ_Entity3 : arrayList) {
                    double m7698a = C3632ab.m7729c(latLng, new LatLng(dynamicDYZ_Entity3.getLatitude(), dynamicDYZ_Entity3.getLogitude())).m7698a();
                    dynamicDYZ_Entity3.setDistance(m7698a);
                    if (m7698a <= 1000000.0d) {
                        C2489c.this.f8593o.m11900c(dynamicDYZ_Entity3);
                    }
                }
                C2489c.this.m11970a();
            }
        });
    }

    /* renamed from: a */
    public void m11970a() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.j.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<DynamicDYZ_Entity> m11899d = C2501h.m11907a().m11899d();
                if (m11899d != null) {
                    C2489c.this.f8594p = m11899d.size();
                    if (C2489c.this.f8594p > C2489c.this.f8595r) {
                        C2489c.this.f8580b = C2489c.this.f8585g.getCameraPosition().target;
                        C2489c.this.m11960a(m11899d);
                        return;
                    }
                    C2489c.this.m11952d();
                    for (DynamicDYZ_Entity dynamicDYZ_Entity : m11899d) {
                        C2489c.this.m11961a(dynamicDYZ_Entity);
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public int m11959b() {
        return this.f8594p;
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case DRAWSYNCFLYZONE:
                C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.j.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        List<DynamicDYZ_Entity> m11899d = C2489c.this.f8593o.m11899d();
                        if (m11899d == null || m11899d.size() <= 0) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        long time = new Date().getTime();
                        for (DynamicDYZ_Entity dynamicDYZ_Entity : m11899d) {
                            if (dynamicDYZ_Entity.getStartDate() <= time && time <= dynamicDYZ_Entity.getEndDate()) {
                                arrayList.add(dynamicDYZ_Entity);
                            }
                        }
                        C2489c.this.f8593o.m11905a(arrayList);
                        if (arrayList.size() <= 0) {
                            return;
                        }
                        C2489c.this.m11970a();
                    }
                });
                return;
            case DRAWSYNCFLYZONEBYDB:
                m11950e();
                return;
            case CLEARSYNEFLYZONE:
                m11952d();
                return;
            default:
                return;
        }
    }
}
