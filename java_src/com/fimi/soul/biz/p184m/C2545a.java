package com.fimi.soul.biz.p184m;

import android.location.Location;
import android.widget.ImageButton;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLng;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import java.lang.ref.WeakReference;
/* renamed from: com.fimi.soul.biz.m.a */
/* loaded from: classes.dex */
public class C2545a {

    /* renamed from: e */
    private static C2545a f8725e;

    /* renamed from: b */
    private ImageButton f8727b;

    /* renamed from: c */
    private C2657a f8728c;

    /* renamed from: f */
    private WeakReference<ImageButton> f8730f;

    /* renamed from: a */
    public volatile EnumC2548a f8726a = EnumC2548a.DRONE;

    /* renamed from: d */
    private int f8729d = 0;

    /* renamed from: g */
    private volatile boolean f8731g = true;

    /* renamed from: h */
    private int f8732h = 18;

    /* renamed from: com.fimi.soul.biz.m.a$a */
    /* loaded from: classes.dex */
    public enum EnumC2548a {
        PEOPLE,
        DRONE,
        DRONEPRESS,
        CACHESTATUS
    }

    /* renamed from: a */
    public static C2545a m11735a() {
        if (f8725e == null) {
            f8725e = new C2545a();
        }
        return f8725e;
    }

    /* renamed from: a */
    public void m11734a(int i) {
        if (this.f8727b == null || this.f8729d == i) {
            return;
        }
        this.f8727b.setImageResource(i);
        this.f8729d = i;
    }

    /* renamed from: a */
    public void m11733a(ImageButton imageButton, C2657a c2657a) {
        this.f8730f = new WeakReference<>(imageButton);
        this.f8727b = this.f8730f.get();
        this.f8728c = c2657a;
        m11730b();
    }

    /* renamed from: a */
    public void m11732a(EnumC2548a enumC2548a) {
        this.f8726a = enumC2548a;
    }

    /* renamed from: a */
    public void m11731a(boolean z) {
        this.f8731g = z;
    }

    /* renamed from: b */
    public void m11730b() {
        if (!this.f8728c.mo11216ac() || this.f8728c.mo11202w().m10501d() < 3) {
            m11732a(EnumC2548a.PEOPLE);
            m11734a(C2300R.C2301drawable.locationbutton);
        } else if (this.f8726a == EnumC2548a.DRONEPRESS) {
            m11732a(EnumC2548a.DRONEPRESS);
            m11734a(C2300R.mipmap.btn_fly_location_plane_checked);
        } else {
            m11732a(EnumC2548a.DRONE);
            m11734a(C2300R.mipmap.btn_fly_location_plane_normal);
        }
    }

    /* renamed from: c */
    public EnumC2548a m11729c() {
        return this.f8726a;
    }

    /* renamed from: d */
    public void m11728d() {
        AMap m11323ai = this.f8728c.m11323ai();
        if (m11323ai != null) {
            switch (this.f8726a) {
                case DRONE:
                    m11734a(C2300R.mipmap.btn_fly_location_plane_checked);
                    m11732a(EnumC2548a.DRONEPRESS);
                    m11323ai.animateCamera(CameraUpdateFactory.zoomBy(this.f8732h));
                    return;
                case PEOPLE:
                    Location m11305b = this.f8728c.m11305b();
                    if (m11305b == null) {
                        return;
                    }
                    m11323ai.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(m11305b.getLatitude(), m11305b.getLongitude()), 18.0f));
                    return;
                case DRONEPRESS:
                    m11734a(C2300R.mipmap.btn_fly_location_plane_normal);
                    m11732a(EnumC2548a.DRONE);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: e */
    public void m11727e() {
        LatLng m11313as;
        AMap m11323ai = this.f8728c.m11323ai();
        if (m11323ai == null || (m11313as = this.f8728c.m11313as()) == null) {
            return;
        }
        m11323ai.animateCamera(CameraUpdateFactory.changeLatLng(m11313as), 300L, new AMap.CancelableCallback() { // from class: com.fimi.soul.biz.m.a.1
            @Override // com.amap.api.maps.AMap.CancelableCallback
            public void onCancel() {
            }

            @Override // com.amap.api.maps.AMap.CancelableCallback
            public void onFinish() {
            }
        });
    }

    /* renamed from: f */
    public boolean m11726f() {
        return this.f8731g;
    }
}
