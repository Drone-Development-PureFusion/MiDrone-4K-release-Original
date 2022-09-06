package com.fimi.soul.biz.p185n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.fimi.soul.base.C2353b;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.biz.n.k */
/* loaded from: classes.dex */
public class C2571k {

    /* renamed from: a */
    private static final int f8863a = 10000;

    /* renamed from: b */
    private static final int f8864b = 2;

    /* renamed from: c */
    private static C2571k f8865c = null;

    /* renamed from: g */
    private static final int f8866g = 120000;

    /* renamed from: l */
    private static int f8867l = 60000;

    /* renamed from: e */
    private AMapLocation f8869e;

    /* renamed from: f */
    private Context f8870f;

    /* renamed from: h */
    private AMapLocationClient f8871h;

    /* renamed from: i */
    private AMapLocationClientOption f8872i;

    /* renamed from: d */
    private AMapLocation f8868d = null;

    /* renamed from: j */
    private List<AbstractC2573a> f8873j = new ArrayList();

    /* renamed from: k */
    private final AMapLocationListener f8874k = new AMapLocationListener() { // from class: com.fimi.soul.biz.n.k.1
        @Override // com.amap.api.location.AMapLocationListener
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null && 0.0d != aMapLocation.getLatitude() && 0.0d != aMapLocation.getLongitude()) {
                if (C2571k.this.f8868d == null) {
                    C2571k.this.m11642b(aMapLocation);
                } else if (C2571k.this.m11649a(aMapLocation, C2571k.this.f8868d)) {
                    C2571k.this.m11642b(aMapLocation);
                } else {
                    C2571k.this.m11642b(C2571k.this.f8868d);
                }
            }
            C2353b.m12509a("====location:" + aMapLocation.getLatitude() + " | " + aMapLocation.getLongitude(), C2571k.class);
        }
    };

    /* renamed from: com.fimi.soul.biz.n.k$a */
    /* loaded from: classes.dex */
    public interface AbstractC2573a {
        /* renamed from: a */
        void mo8600a(AMapLocation aMapLocation);
    }

    @SuppressLint({"ServiceCast"})
    private C2571k(Context context) {
        this.f8870f = context;
        this.f8869e = m11643b(context);
    }

    /* renamed from: a */
    public static C2571k m11651a(Context context) {
        if (f8865c == null) {
            f8865c = new C2571k(context);
        }
        return f8865c;
    }

    /* renamed from: a */
    private boolean m11645a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: b */
    private AMapLocation m11643b(Context context) {
        if (this.f8871h != null) {
            return this.f8871h.getLastKnownLocation();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11642b(AMapLocation aMapLocation) {
        this.f8868d = aMapLocation;
        for (AbstractC2573a abstractC2573a : this.f8873j) {
            abstractC2573a.mo8600a(aMapLocation);
        }
    }

    /* renamed from: a */
    public double m11652a() {
        if (this.f8869e == null) {
            this.f8869e = m11643b(this.f8870f);
        }
        if (this.f8869e != null) {
            return this.f8869e.getLatitude();
        }
        return -1.0d;
    }

    /* renamed from: a */
    public void m11650a(AMapLocation aMapLocation) {
        this.f8869e = aMapLocation;
    }

    /* renamed from: a */
    public void m11648a(AbstractC2573a abstractC2573a) {
        if (!this.f8873j.contains(abstractC2573a)) {
            this.f8873j.add(abstractC2573a);
        }
        this.f8871h = new AMapLocationClient(this.f8870f);
        this.f8871h.setLocationListener(this.f8874k);
        this.f8872i = new AMapLocationClientOption();
        this.f8872i.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        this.f8872i.setGpsFirst(true);
        this.f8872i.setInterval(1000L);
        this.f8872i.setNeedAddress(true);
        this.f8872i.setOnceLocation(false);
        this.f8871h.setLocationOption(this.f8872i);
        this.f8871h.startLocation();
    }

    /* renamed from: a */
    protected boolean m11649a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return true;
        }
        long time = aMapLocation.getTime() - aMapLocation2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (aMapLocation.getAccuracy() - aMapLocation2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean m11645a = m11645a(aMapLocation.getProvider(), aMapLocation2.getProvider());
        if (z5) {
            return true;
        }
        if (z3 && !z4) {
            return true;
        }
        return z3 && !z6 && m11645a;
    }

    /* renamed from: b */
    public double m11644b() {
        if (this.f8869e == null) {
            this.f8869e = m11643b(this.f8870f);
        }
        if (this.f8869e != null) {
            return this.f8869e.getLongitude();
        }
        return -1.0d;
    }

    /* renamed from: b */
    public void m11641b(AbstractC2573a abstractC2573a) {
        if (this.f8873j.contains(abstractC2573a)) {
            this.f8873j.remove(abstractC2573a);
        }
    }

    /* renamed from: c */
    public void m11640c() {
        if (this.f8871h != null) {
            this.f8871h.onDestroy();
            this.f8871h = null;
        }
    }

    /* renamed from: d */
    public Location m11639d() {
        return this.f8868d == null ? m11643b(this.f8870f) : this.f8868d;
    }
}
