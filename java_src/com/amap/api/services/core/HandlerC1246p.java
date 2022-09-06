package com.amap.api.services.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import java.util.ArrayList;
/* renamed from: com.amap.api.services.core.p */
/* loaded from: classes.dex */
public class HandlerC1246p extends Handler {

    /* renamed from: a */
    private static HandlerC1246p f4170a;

    /* renamed from: com.amap.api.services.core.p$a */
    /* loaded from: classes.dex */
    public static class C1247a {

        /* renamed from: a */
        public BusLineResult f4171a;

        /* renamed from: b */
        public BusLineSearch.OnBusLineSearchListener f4172b;
    }

    /* renamed from: com.amap.api.services.core.p$b */
    /* loaded from: classes.dex */
    public static class C1248b {

        /* renamed from: a */
        public BusStationResult f4173a;

        /* renamed from: b */
        public BusStationSearch.OnBusStationSearchListener f4174b;
    }

    /* renamed from: com.amap.api.services.core.p$c */
    /* loaded from: classes.dex */
    public static class C1249c {

        /* renamed from: a */
        public GeocodeResult f4175a;

        /* renamed from: b */
        public GeocodeSearch.OnGeocodeSearchListener f4176b;
    }

    /* renamed from: com.amap.api.services.core.p$d */
    /* loaded from: classes.dex */
    public static class C1250d {

        /* renamed from: a */
        public PoiItemDetail f4177a;

        /* renamed from: b */
        public PoiSearch.OnPoiSearchListener f4178b;
    }

    /* renamed from: com.amap.api.services.core.p$e */
    /* loaded from: classes.dex */
    public static class C1251e {

        /* renamed from: a */
        public PoiResult f4179a;

        /* renamed from: b */
        public PoiSearch.OnPoiSearchListener f4180b;
    }

    /* renamed from: com.amap.api.services.core.p$f */
    /* loaded from: classes.dex */
    public static class C1252f {

        /* renamed from: a */
        public RegeocodeResult f4181a;

        /* renamed from: b */
        public GeocodeSearch.OnGeocodeSearchListener f4182b;
    }

    HandlerC1246p() {
    }

    HandlerC1246p(Looper looper) {
        super(looper);
    }

    /* renamed from: a */
    public static synchronized HandlerC1246p m16952a() {
        HandlerC1246p handlerC1246p;
        synchronized (HandlerC1246p.class) {
            if (f4170a == null) {
                if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                    f4170a = new HandlerC1246p(Looper.getMainLooper());
                } else {
                    f4170a = new HandlerC1246p();
                }
            }
            handlerC1246p = f4170a;
        }
        return handlerC1246p;
    }

    /* renamed from: a */
    private void m16951a(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        C1248b c1248b = (C1248b) message.obj;
        if (c1248b == null || (onBusStationSearchListener = c1248b.f4174b) == null) {
            return;
        }
        onBusStationSearchListener.onBusStationSearched(message.what == 0 ? c1248b.f4173a : null, message.what);
    }

    /* renamed from: b */
    private void m16950b(Message message) {
        C1250d c1250d;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        if (message.what == 60) {
            C1251e c1251e = (C1251e) message.obj;
            if (c1251e == null || (onPoiSearchListener = c1251e.f4180b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(c1251e.f4179a, data.getInt("errorCode"));
        } else if (message.what != 61 || (c1250d = (C1250d) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = c1250d.f4178b;
            Bundle data2 = message.getData();
            if (data2 == null) {
                return;
            }
            onPoiSearchListener2.onPoiItemDetailSearched(c1250d.f4177a, data2.getInt("errorCode"));
        }
    }

    /* renamed from: c */
    private void m16949c(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        ArrayList arrayList = null;
        if (message.what == 0) {
            arrayList = message.getData().getParcelableArrayList("result");
        }
        inputtipsListener.onGetInputtips(arrayList, message.what);
    }

    /* renamed from: d */
    private void m16948d(Message message) {
        C1249c c1249c;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        if (message.what == 21) {
            C1252f c1252f = (C1252f) message.obj;
            if (c1252f == null || (onGeocodeSearchListener2 = c1252f.f4182b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(c1252f.f4181a, message.arg2);
        } else if (message.what != 20 || (c1249c = (C1249c) message.obj) == null || (onGeocodeSearchListener = c1249c.f4176b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(c1249c.f4175a, message.arg2);
        }
    }

    /* renamed from: e */
    private void m16947e(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
    }

    /* renamed from: f */
    private void m16946f(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        C1247a c1247a = (C1247a) message.obj;
        if (c1247a == null || (onBusLineSearchListener = c1247a.f4172b) == null) {
            return;
        }
        onBusLineSearchListener.onBusLineSearched(message.what == 0 ? c1247a.f4171a : null, message.what);
    }

    /* renamed from: g */
    private void m16945g(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        if (message.what == 10) {
            Bundle data2 = message.getData();
            if (data2 == null) {
                return;
            }
            onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
        } else if (message.what == 11) {
            Bundle data3 = message.getData();
            if (data3 == null) {
                return;
            }
            onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
        } else if (message.what != 12 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.arg1) {
                case 1:
                    m16945g(message);
                    break;
                case 2:
                    m16948d(message);
                    break;
                case 3:
                    m16946f(message);
                    break;
                case 4:
                    m16947e(message);
                    break;
                case 5:
                    m16949c(message);
                    break;
                case 6:
                    m16950b(message);
                    break;
                case 7:
                    m16951a(message);
                    break;
            }
        } catch (Throwable th) {
            C1233d.m17031a(th, "MessageHandler", "handleMessage");
        }
    }
}
