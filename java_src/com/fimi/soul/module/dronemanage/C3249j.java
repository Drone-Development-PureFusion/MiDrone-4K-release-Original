package com.fimi.soul.module.dronemanage;

import android.content.Context;
import android.graphics.Point;
import android.os.Message;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p192c.C2676a;
import com.fimi.soul.drone.p192c.C2677b;
import com.fimi.soul.drone.p199e.C2823a;
import com.fimi.soul.drone.p199e.C2826d;
import com.fimi.soul.drone.p199e.C2835m;
import com.fimi.soul.drone.p202h.C2858f;
import com.fimi.soul.drone.p203i.C2892aw;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.MapProjection;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.dronemanage.j */
/* loaded from: classes.dex */
public class C3249j extends AbstractC3247i implements C2678d.AbstractC2680b {

    /* renamed from: j */
    private static C2858f f12510j = null;

    /* renamed from: k */
    private static C2858f f12511k = null;

    /* renamed from: m */
    private static int f12512m = 0;

    /* renamed from: n */
    private static final int f12513n = 2;

    /* renamed from: f */
    private AMap f12518f;

    /* renamed from: g */
    private Context f12519g;

    /* renamed from: l */
    private C2657a f12522l;

    /* renamed from: r */
    private C3243f f12526r;

    /* renamed from: s */
    private AbstractC3253a f12527s;

    /* renamed from: a */
    List<C2907bk> f12514a = new ArrayList();

    /* renamed from: d */
    private List<Polyline> f12516d = new ArrayList();

    /* renamed from: e */
    private List<Marker> f12517e = new ArrayList();

    /* renamed from: h */
    private int f12520h = 1;

    /* renamed from: i */
    private int f12521i = 1;

    /* renamed from: o */
    private EnumC3254b f12523o = EnumC3254b.NORMAL;

    /* renamed from: p */
    private int f12524p = 1;

    /* renamed from: q */
    private int f12525q = 20;

    /* renamed from: c */
    ArrayList<BitmapDescriptor> f12515c = new ArrayList<>();

    /* renamed from: com.fimi.soul.module.dronemanage.j$a */
    /* loaded from: classes.dex */
    public interface AbstractC3253a {
        /* renamed from: a */
        void mo8932a(List<C2907bk> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.dronemanage.j$b */
    /* loaded from: classes.dex */
    public enum EnumC3254b {
        NORMAL,
        SENDING,
        SENDCOM
    }

    public C3249j(C2657a c2657a, Context context, FlightMapFragment flightMapFragment) {
        this.f12518f = c2657a.m11323ai();
        this.f12519g = context;
        this.f12522l = c2657a;
        this.f12527s = flightMapFragment;
        this.f12526r = new C3243f(this.f12518f);
        c2657a.mo11219a(this);
    }

    /* renamed from: d */
    private void m8947d(int i) {
        if (this.f12525q != 6 || i < 1 || i > this.f12517e.size() || this.f12517e.size() < 1) {
            return;
        }
        this.f12517e.get(i - 1).setIcons(m8945e(i));
        if (i < 2) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i - 1) {
                return;
            }
            this.f12517e.get(i3).setIcon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_hd_gray, (i3 + 1) + "", "", this.f12519g)));
            i2 = i3 + 1;
        }
    }

    /* renamed from: e */
    private ArrayList<BitmapDescriptor> m8945e(int i) {
        this.f12515c.clear();
        this.f12515c.add(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_wp_map2, i + "", "", this.f12519g)));
        this.f12515c.add(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_wp_map, i + "", "", this.f12519g)));
        return this.f12515c;
    }

    /* renamed from: l */
    static /* synthetic */ int m8939l() {
        int i = f12512m;
        f12512m = i + 1;
        return i;
    }

    /* renamed from: n */
    private void m8937n() {
        if (this.f12514a == null || this.f12514a.size() <= 0) {
            return;
        }
        for (C2907bk c2907bk : this.f12514a) {
            c2907bk.m10352c(0);
        }
        m8951c();
    }

    /* renamed from: o */
    private void m8936o() {
        for (Marker marker : this.f12517e) {
            marker.setDraggable(true);
        }
    }

    /* renamed from: p */
    private void m8935p() {
        this.f12524p++;
        C2892aw mo11210o = this.f12522l.mo11210o();
        m8960a(new LatLng(mo11210o.m10457c(), mo11210o.m10458b()), 1);
        if (this.f12524p <= mo11210o.m10452h() || f12511k == null) {
            return;
        }
        f12511k.m10747e();
        f12511k.m10746f();
        this.f12524p = 1;
        m8951c();
    }

    /* renamed from: q */
    private void m8934q() {
        f12512m = 0;
        if (f12510j != null) {
            f12510j.m10747e();
        }
        int m10470a = this.f12522l.mo11211n().m10470a();
        if (this.f12521i == m10470a && this.f12514a.size() >= 1 && this.f12517e.size() >= 1) {
            this.f12514a.get(m10470a - 1).m10352c(1);
            this.f12517e.get(m10470a - 1).setIcon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_wp_map2, m10470a + "", "", this.f12519g)));
            this.f12517e.get(m10470a - 1).setDraggable(false);
        }
        if (m10470a != this.f12514a.size()) {
            this.f12521i++;
            m8962a(this.f12521i);
            return;
        }
        this.f12523o = EnumC3254b.SENDCOM;
        C2823a.m10869a(this.f12522l);
        C3260m.m8921a(this.f12522l, C2823a.f10433b.mo11073b());
        C3260m.m8922a();
    }

    /* renamed from: r */
    private void m8933r() {
        f12511k = new C2858f(300, new Runnable() { // from class: com.fimi.soul.module.dronemanage.j.2
            @Override // java.lang.Runnable
            public void run() {
                C3249j.this.m8955b(C3249j.this.f12524p);
            }
        });
        f12511k.m10749d();
    }

    /* renamed from: a */
    public void m8963a() {
        f12510j = new C2858f(300, new Runnable() { // from class: com.fimi.soul.module.dronemanage.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (C3249j.this.f12522l.mo11211n().f10839b != C3249j.this.f12521i) {
                    C2835m.m10842a(C3249j.this.f12522l);
                }
                C3249j.m8939l();
                if (C3249j.f12512m >= 10) {
                    C3249j.this.i().sendEmptyMessage(2);
                }
            }
        });
    }

    /* renamed from: a */
    public void m8962a(int i) {
        if (this.f12514a.size() < 1 || i > this.f12514a.size()) {
            return;
        }
        C2907bk c2907bk = this.f12514a.get(i - 1);
        C3639ai m7725a = C3633ac.m7725a(0.1d, c2907bk.m10355b().latitude, c2907bk.m10355b().longitude);
        LatLng latLng = new LatLng(m7725a.m7702a(), m7725a.m7700b());
        C2835m.f10456b.f9937f = (float) latLng.latitude;
        C2835m.f10456b.f9936e = (float) latLng.longitude;
        C2835m.f10456b.f9938g = (short) c2907bk.m10353c();
        C2835m.f10456b.f9935d = (short) i;
        C2835m.m10842a(this.f12522l);
        if (f12510j.m10753b()) {
            return;
        }
        f12510j.m10751c();
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: a */
    protected void mo8961a(Message message) {
        switch (message.what) {
            case 2:
                f12512m = 0;
                f12510j.m10747e();
                f12510j.m10746f();
                C2284z.m12694a(this.f12519g, this.f12519g.getResources().getString(C2300R.C2303string.updataerror), 0);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m8960a(LatLng latLng, int i) {
        if (this.f12514a.size() >= 20) {
            C2284z.m12694a(this.f12519g, this.f12519g.getResources().getString(C2300R.C2303string.maxwp), 3000);
            return;
        }
        C2907bk c2907bk = new C2907bk();
        c2907bk.m10357a(latLng);
        c2907bk.m10350d(1);
        if (i == 1) {
            c2907bk.m10352c(1);
        } else {
            c2907bk.m10352c(0);
        }
        if (!this.f12514a.contains(c2907bk)) {
            this.f12514a.add(c2907bk);
        }
        this.f12527s.mo8932a(this.f12514a);
        m8959a(c2907bk);
    }

    /* renamed from: a */
    public void m8959a(C2907bk c2907bk) {
        Polyline addPolyline = this.f12518f.addPolyline(this.f12508b.add(c2907bk.m10355b()));
        if (this.f12514a.size() > 1) {
            this.f12526r.m8991a(this.f12514a.get(this.f12514a.size() - 2).m10355b(), this.f12514a.get(this.f12514a.size() - 1).m10355b());
        }
        Marker addMarker = c2907bk.m10349e() == 0 ? this.f12518f.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_wp_map, this.f12520h + "", "", this.f12519g)))) : this.f12518f.addMarker(C2676a.m11198a(c2907bk.m10355b()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_wp_map2, this.f12520h + "", "", this.f12519g))));
        if (!this.f12516d.contains(addPolyline)) {
            this.f12516d.add(addPolyline);
        }
        if (!this.f12517e.contains(addMarker)) {
            this.f12517e.add(addMarker);
        }
        c2907bk.m10354b(this.f12520h);
        addMarker.setObject(c2907bk);
        this.f12520h++;
    }

    /* renamed from: a */
    public void m8957a(List<C2907bk> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() == 0) {
            this.f12514a.clear();
        }
        for (C2907bk c2907bk : this.f12514a) {
            if (!list.contains(c2907bk)) {
                arrayList.add(c2907bk);
            }
        }
        this.f12514a.removeAll(arrayList);
        m8951c();
    }

    /* renamed from: b */
    public List<C2907bk> m8952b(List<Point> list) {
        List<LatLng> m7771a;
        int i = 0;
        if (list.size() >= 20) {
            int size = this.f12514a != null ? 20 - this.f12514a.size() : 20;
            ArrayList arrayList = new ArrayList();
            while (i < size) {
                arrayList.add(list.get(i));
                i++;
            }
            m7771a = MapProjection.m7771a(arrayList, this.f12518f);
        } else {
            int size2 = this.f12514a != null ? list.size() > 20 - this.f12514a.size() ? 20 - this.f12514a.size() : list.size() : 0;
            ArrayList arrayList2 = new ArrayList();
            while (i < size2) {
                arrayList2.add(list.get(i));
                i++;
            }
            m7771a = MapProjection.m7771a(arrayList2, this.f12518f);
        }
        if (m7771a.size() > 0) {
            for (LatLng latLng : m7771a) {
                C2907bk c2907bk = new C2907bk();
                c2907bk.m10350d(1);
                c2907bk.m10357a(latLng);
                this.f12514a.add(c2907bk);
                if (this.f12514a.size() > 20) {
                    break;
                }
            }
        }
        m8951c();
        return this.f12514a;
    }

    /* renamed from: b */
    public void m8956b() {
        this.f12521i = 1;
        m8937n();
        if (f12510j == null) {
            m8963a();
        }
        m8962a(this.f12521i);
        this.f12523o = EnumC3254b.SENDING;
    }

    /* renamed from: b */
    public void m8955b(int i) {
        C2826d.f10438a.f9905d = (short) i;
        C2826d.m10866a(this.f12522l);
    }

    /* renamed from: b */
    public void m8954b(C2907bk c2907bk) {
        this.f12514a.remove(c2907bk);
        m8951c();
    }

    /* renamed from: c */
    public void m8951c() {
        m8948d();
        for (C2907bk c2907bk : this.f12514a) {
            m8959a(c2907bk);
        }
    }

    /* renamed from: c */
    public void m8950c(int i) {
        this.f12525q = i;
        this.f12522l.mo11219a(this);
        if (this.f12514a.size() >= 1 || this.f12525q != 6) {
            m8951c();
        } else {
            m8933r();
        }
    }

    /* renamed from: d */
    public void m8948d() {
        this.f12520h = 1;
        if (this.f12517e != null && this.f12517e.size() > 0) {
            for (Marker marker : this.f12517e) {
                if (marker != null) {
                    marker.destroy();
                }
            }
            this.f12517e.clear();
        }
        m8946e();
    }

    /* renamed from: e */
    public void m8946e() {
        this.f12526r.m8993a();
        if (this.f12516d != null && this.f12516d.size() > 0) {
            for (Polyline polyline : this.f12516d) {
                if (polyline != null) {
                    polyline.remove();
                }
            }
            this.f12516d.clear();
        }
        mo8942h();
    }

    /* renamed from: f */
    public void m8944f() {
        for (C2907bk c2907bk : this.f12514a) {
            Polyline addPolyline = this.f12518f.addPolyline(this.f12508b.add(c2907bk.m10355b()));
            if (!this.f12516d.contains(addPolyline)) {
                this.f12516d.add(addPolyline);
            }
        }
    }

    /* renamed from: g */
    public List<C2907bk> m8943g() {
        return this.f12514a;
    }

    @Override // com.fimi.soul.module.dronemanage.AbstractC3247i
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo8942h() {
        super.mo8942h();
    }

    /* renamed from: j */
    public void m8941j() {
        this.f12522l.mo11214b(this);
    }

    /* renamed from: k */
    public void m8940k() {
        this.f12522l.mo11219a(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case RECEIVERWAYPOINTS:
                m8934q();
                return;
            case HOMEPOINT:
                m8947d(c2657a.mo11201x().m10609e());
                return;
            case HEARDATA:
                this.f12525q = c2657a.m11312at().m10702e();
                if (this.f12517e.size() <= 0 || this.f12517e.get(this.f12517e.size() - 1).getIcons().size() == 1 || this.f12525q == 6) {
                    return;
                }
                this.f12517e.get(this.f12517e.size() - 1).setIcon(BitmapDescriptorFactory.fromBitmap(C2677b.m11196a((int) C2300R.C2301drawable.ic_hd_gray, this.f12517e.size() + "", "", this.f12519g)));
                m8936o();
                return;
            case RECEIVERPOINTS:
                m8935p();
                return;
            case HEARDDAY:
            default:
                return;
            case DRAHMARKER:
                m8936o();
                return;
        }
    }
}
