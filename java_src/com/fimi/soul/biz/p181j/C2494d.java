package com.fimi.soul.biz.p181j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3658ar;
import it.p235a.p236a.AbstractC4863e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.fimi.soul.biz.j.d */
/* loaded from: classes.dex */
public class C2494d {

    /* renamed from: a */
    private AsyncTask f8601a;

    /* renamed from: e */
    private SQLiteDatabase f8605e;

    /* renamed from: f */
    private AMap f8606f;

    /* renamed from: i */
    private CircleOptions f8609i;

    /* renamed from: j */
    private CircleOptions f8610j;

    /* renamed from: k */
    private CircleOptions f8611k;

    /* renamed from: l */
    private CircleOptions f8612l;

    /* renamed from: n */
    private List<DynamicDYZ_Entity> f8614n;

    /* renamed from: o */
    private Context f8615o;

    /* renamed from: b */
    private final List<LatLng> f8602b = new ArrayList();

    /* renamed from: c */
    private final List<LatLng> f8603c = new ArrayList();

    /* renamed from: d */
    private final List<LatLng> f8604d = new ArrayList();

    /* renamed from: g */
    private List<Circle> f8607g = C2499g.m11911c().m11910d();

    /* renamed from: p */
    private final List<Circle> f8616p = C2499g.m11911c().m11909e();

    /* renamed from: h */
    private List<Circle> f8608h = C2499g.m11911c().m11914a();

    /* renamed from: m */
    private ExecutorService f8613m = C2281x.m12705a();

    public C2494d(Context context, AMap aMap) {
        this.f8615o = context;
        this.f8606f = aMap;
        m11946a(context);
        m11937c();
    }

    /* renamed from: a */
    private void m11946a(Context context) {
        try {
            File file = new File(C3658ar.m7568n(context));
            if (!file.exists()) {
                return;
            }
            this.f8605e = SQLiteDatabase.openDatabase(file.getPath(), null, 0);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11945a(LatLng latLng, int i, CircleOptions circleOptions) {
        if (!this.f8602b.contains(latLng)) {
            this.f8602b.add(latLng);
            Circle addCircle = this.f8606f.addCircle(circleOptions.center(latLng).radius(i));
            if (this.f8607g.contains(addCircle)) {
                return;
            }
            this.f8607g.add(addCircle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11940b(LatLng latLng, int i, CircleOptions circleOptions) {
        if (!this.f8603c.contains(latLng)) {
            this.f8603c.add(latLng);
            Circle addCircle = this.f8606f.addCircle(circleOptions.center(latLng).radius(i));
            if (this.f8616p.contains(addCircle)) {
                return;
            }
            this.f8616p.add(addCircle);
        }
    }

    /* renamed from: c */
    private void m11937c() {
        this.f8609i = C2498f.m11915a(8000, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 0.0f, 100);
        this.f8610j = C2498f.m11915a(8000, Color.argb(99, 255, 79, 0), Color.argb(26, 255, 36, 0), 0.0f, 100);
        this.f8611k = C2498f.m11915a(8000, Color.argb(99, (int) AbstractC4863e.f20783D, (int) Opcodes.FNEG, 0), Color.argb(26, 255, 138, 0), 0.0f, 100);
        this.f8612l = C2498f.m11915a(8000, Color.argb(99, (int) AbstractC4863e.f20783D, (int) Opcodes.FNEG, 0), Color.argb(26, 255, 138, 0), 0.0f, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11936c(LatLng latLng, int i, CircleOptions circleOptions) {
        if (!this.f8604d.contains(latLng)) {
            this.f8604d.add(latLng);
            Circle addCircle = this.f8606f.addCircle(circleOptions.center(latLng).radius(i));
            if (this.f8608h.contains(addCircle)) {
                return;
            }
            this.f8608h.add(addCircle);
        }
    }

    /* renamed from: d */
    private void m11933d(LatLng latLng, int i, CircleOptions circleOptions) {
    }

    /* renamed from: a */
    public void m11947a() {
        this.f8613m.execute(new Runnable() { // from class: com.fimi.soul.biz.j.d.1
            /* renamed from: a */
            private void m11923a(List<Circle> list, List<LatLng> list2) {
                C2488b m11975a = C2488b.m11975a();
                if (list.size() > 5) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size() - 5) {
                            return;
                        }
                        Circle circle = list.get(i2);
                        if (list2.contains(circle.getCenter()) && !m11975a.m11972b(circle.getCenter())) {
                            list2.remove(circle.getCenter());
                            circle.remove();
                            list.remove(i2);
                        }
                        i = i2 + 1;
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                int i3;
                try {
                    if (C2494d.this.f8606f.getCameraPosition().zoom <= 8.0f) {
                        ArrayList arrayList = new ArrayList();
                        for (Circle circle : C2494d.this.f8607g) {
                            if (!C2488b.m11975a().m11972b(circle.getCenter())) {
                                arrayList.add(circle);
                                circle.remove();
                            }
                        }
                        C2494d.this.f8607g.removeAll(arrayList);
                        for (Circle circle2 : C2494d.this.f8616p) {
                            circle2.remove();
                        }
                        for (Circle circle3 : C2494d.this.f8608h) {
                            circle3.remove();
                        }
                        C2494d.this.f8602b.clear();
                        C2494d.this.f8616p.clear();
                        C2494d.this.f8603c.clear();
                        C2494d.this.f8608h.clear();
                        C2494d.this.f8604d.clear();
                        return;
                    }
                    m11923a(C2494d.this.f8607g, C2494d.this.f8602b);
                    m11923a(C2494d.this.f8616p, C2494d.this.f8603c);
                    m11923a(C2494d.this.f8608h, C2494d.this.f8604d);
                    LatLng fromScreenLocation = C2494d.this.f8606f.getProjection().fromScreenLocation(new Point(0, 0));
                    LatLng latLng = C2494d.this.f8606f.getCameraPosition().target;
                    if (latLng == null) {
                        return;
                    }
                    C3639ai m7725a = C3633ac.m7725a(1.0d, latLng.latitude, latLng.longitude);
                    double m7698a = C3632ab.m7729c(fromScreenLocation, latLng).m7698a();
                    if (m7698a < 20000.0d) {
                        m7698a = 35000.0d;
                    }
                    if (m7698a > 500000.0d) {
                        m7698a = 500000.0d;
                    }
                    double d = m7698a / 111000.0d;
                    if (C2494d.this.f8605e == null) {
                        return;
                    }
                    String str = "SELECT LAT,LON,CLASS from dmz_tb where LAT > " + (m7725a.m7702a() - d) + " and LAT <" + (m7725a.m7702a() + d) + " and LON >" + (m7725a.m7700b() - d) + " and LON < " + (m7725a.m7700b() + d);
                    if (C2367d.m12459a().m12438k()) {
                        str = "select LAT,LON,WarnRadius,NoFlyRadius,HLRadius from dmz_tbv10 where LAT> " + (m7725a.m7702a() - d) + " and LAT <" + (m7725a.m7702a() + d) + " and LON >" + (m7725a.m7700b() - d) + " and LON < " + (m7725a.m7700b() + d);
                    }
                    Cursor rawQuery = C2494d.this.f8605e.rawQuery(str, null);
                    if (rawQuery != null && rawQuery.getCount() > 0) {
                        while (rawQuery.moveToNext()) {
                            double d2 = rawQuery.getFloat(rawQuery.getColumnIndex("LAT"));
                            double d3 = rawQuery.getFloat(rawQuery.getColumnIndex("LON"));
                            if (C2367d.m12459a().m12438k()) {
                                int i4 = rawQuery.getInt(rawQuery.getColumnIndex("NoFlyRadius"));
                                i = (rawQuery.getInt(rawQuery.getColumnIndex("WarnRadius")) + i4) * 10;
                                i3 = rawQuery.getInt(rawQuery.getColumnIndex("HLRadius")) * 10;
                                i2 = i4 * 10;
                                int i5 = i3 + 1500;
                            } else {
                                byte b = (byte) rawQuery.getInt(rawQuery.getColumnIndex("CLASS"));
                                int i6 = b & 3;
                                i = 0;
                                i2 = (((b & 63) == 30 ? 127 : b & 63) + 1) * 1000;
                                i3 = 0;
                            }
                            if (d2 >= 3.52d && d2 <= 53.0d && d3 >= 73.0d && d3 <= 136.0d) {
                                C3639ai m7726a = C3633ac.m7726a(d2, d3);
                                LatLng latLng2 = new LatLng(m7726a.m7702a(), m7726a.m7700b());
                                if (C2367d.m12459a().m12438k()) {
                                    if (i2 < i3) {
                                        C2494d.this.m11936c(latLng2, i3, C2494d.this.f8611k);
                                    }
                                    C2494d.this.m11940b(latLng2, i, C2494d.this.f8610j);
                                }
                                C2494d.this.m11945a(latLng2, i2, C2494d.this.f8609i);
                            }
                        }
                    }
                    if (C2494d.this.f8614n != null && C2494d.this.f8614n.size() > 0) {
                        for (DynamicDYZ_Entity dynamicDYZ_Entity : C2494d.this.f8614n) {
                            C3639ai m7726a2 = C3633ac.m7726a(dynamicDYZ_Entity.getLatitude(), dynamicDYZ_Entity.getLogitude());
                            C2494d.this.m11945a(new LatLng(m7726a2.m7702a(), m7726a2.m7700b()), dynamicDYZ_Entity.getRadius() * 1000, C2494d.this.f8610j);
                        }
                    }
                    if (rawQuery == null) {
                        return;
                    }
                    rawQuery.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* renamed from: a */
    public void m11942a(List<DynamicDYZ_Entity> list) {
        this.f8614n = list;
    }

    /* renamed from: b */
    public void m11941b() {
        if (this.f8605e == null || !this.f8605e.isOpen()) {
            return;
        }
        this.f8605e.close();
    }
}
