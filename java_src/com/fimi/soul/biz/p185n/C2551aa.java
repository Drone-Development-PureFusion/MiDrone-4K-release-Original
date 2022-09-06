package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2527t;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.CityInfo;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.aa */
/* loaded from: classes.dex */
public class C2551aa implements Handler.Callback, GeocodeSearch.OnGeocodeSearchListener {

    /* renamed from: a */
    private static C2551aa f8749a = null;

    /* renamed from: b */
    private static final int f8750b = 0;

    /* renamed from: d */
    private C2527t f8752d;

    /* renamed from: e */
    private Context f8753e;

    /* renamed from: g */
    private GeocodeSearch f8755g;

    /* renamed from: h */
    private C2571k f8756h;

    /* renamed from: f */
    private Handler f8754f = new Handler(this);

    /* renamed from: c */
    private HashMap<Integer, AbstractC2538k> f8751c = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.aa$a */
    /* loaded from: classes.dex */
    class RunnableC2552a implements Runnable {

        /* renamed from: b */
        private int f8758b;

        /* renamed from: c */
        private CityInfo f8759c;

        public RunnableC2552a(int i, CityInfo cityInfo) {
            this.f8758b = i;
            this.f8759c = cityInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2551aa.this.f8754f.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8758b == 0) {
                planeMsg = C2551aa.this.f8752d.mo11741a(C2551aa.this.f8753e, this.f8759c);
            }
            obtainMessage.what = this.f8758b;
            obtainMessage.obj = planeMsg;
            C2551aa.this.f8754f.sendMessage(obtainMessage);
        }
    }

    public C2551aa(Context context) {
        this.f8753e = null;
        this.f8752d = new C2527t(context);
        this.f8753e = context;
        this.f8755g = new GeocodeSearch(context);
        this.f8755g.setOnGeocodeSearchListener(this);
    }

    /* renamed from: a */
    public static C2551aa m11720a(Context context) {
        if (f8749a == null) {
            f8749a = new C2551aa(context);
        }
        return f8749a;
    }

    /* renamed from: a */
    public void m11719a(Location location, AbstractC2538k abstractC2538k) {
        this.f8755g.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(location.getLatitude(), location.getLongitude()), 200.0f, GeocodeSearch.AMAP));
        this.f8751c.put(0, abstractC2538k);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8751c.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return true;
        }
        return true;
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i != 0 || regeocodeResult == null || regeocodeResult.getRegeocodeAddress() == null || regeocodeResult.getRegeocodeAddress().getFormatAddress() == null) {
            return;
        }
        String city = regeocodeResult.getRegeocodeAddress().getCity();
        String district = regeocodeResult.getRegeocodeAddress().getDistrict();
        CityInfo cityInfo = new CityInfo();
        cityInfo.setTown(city);
        cityInfo.setCity(district);
        C2281x.m12702b(new RunnableC2552a(0, cityInfo));
    }
}
