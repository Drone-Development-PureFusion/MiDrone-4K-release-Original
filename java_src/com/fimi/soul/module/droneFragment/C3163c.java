package com.fimi.soul.module.droneFragment;

import android.os.Message;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Marker;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p192c.C2676a;
import com.fimi.soul.drone.p192c.C2677b;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.fimi.soul.module.droneFragment.c */
/* loaded from: classes.dex */
public class C3163c extends AbstractC2180b {

    /* renamed from: a */
    public static final int f12017a = 0;

    /* renamed from: b */
    public static final int f12018b = 1;

    /* renamed from: f */
    private static Marker f12021f;

    /* renamed from: e */
    private C2657a f12023e;

    /* renamed from: g */
    private AMap f12024g;

    /* renamed from: i */
    private Runnable f12025i = new Runnable() { // from class: com.fimi.soul.module.droneFragment.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (C3163c.f12021f != null) {
                C3163c.this.f12026j = true;
                C3163c.f12019c.set(1);
                C3163c.f12021f.destroy();
                Marker unused = C3163c.f12021f = null;
            }
        }
    };

    /* renamed from: j */
    private boolean f12026j = true;

    /* renamed from: c */
    private static AtomicInteger f12019c = new AtomicInteger(0);

    /* renamed from: d */
    private static AtomicInteger f12020d = new AtomicInteger(1);

    /* renamed from: h */
    private static final C3163c f12022h = new C3163c();

    private C3163c() {
    }

    /* renamed from: a */
    public static void m9400a(int i) {
        f12020d.set(i);
    }

    /* renamed from: b */
    public static AtomicInteger m9395b() {
        return f12020d;
    }

    /* renamed from: c */
    public static C3163c m9393c() {
        return f12022h;
    }

    /* renamed from: d */
    public static AtomicInteger m9392d() {
        return f12019c;
    }

    /* renamed from: f */
    public static void m9390f() {
        if (f12021f != null) {
            f12021f.destroy();
            f12021f = null;
        }
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
    }

    /* renamed from: a */
    public void m9397a(C2657a c2657a) {
        if (c2657a.m11312at().m10700g().isLightStream()) {
            return;
        }
        this.f12023e = c2657a;
        this.f12024g = c2657a.m11323ai();
        if (!c2657a.mo11217ab().mo10898a() || !c2657a.mo11216ac() || ((c2657a.m11313as().latitude <= 1.0d || c2657a.m11313as().longitude <= 1.0d || f12019c.get() != 0) && f12020d.get() != 0)) {
            if (f12021f == null) {
                return;
            }
            f12021f.setPosition(c2657a.m11313as());
        } else if (f12020d.get() != 0) {
            if (f12021f == null) {
                return;
            }
            f12021f.setPosition(c2657a.m11313as());
        } else {
            f12020d.set(1);
            if (f12021f == null) {
                f12021f = this.f12024g.addMarker(C2676a.m11198a(c2657a.m11313as()).icon(BitmapDescriptorFactory.fromBitmap(C2677b.m11193b((int) C2300R.C2301drawable.handpiece_aspect_infor, c2657a.f9270d.getResources().getString(C2300R.C2303string.flighthead), "", c2657a.f9270d))));
            }
            this.f12024g.animateCamera(CameraUpdateFactory.newLatLngZoom(c2657a.m11313as(), 18.0f));
            if (f12021f == null || !this.f12026j) {
                return;
            }
            this.f12026j = false;
            a().postDelayed(this.f12025i, 5000L);
        }
    }

    /* renamed from: b */
    public void m9394b(int i) {
        f12019c.set(i);
    }

    /* renamed from: e */
    public void m9391e() {
        this.f12026j = true;
    }
}
