package com.amap.api.services.geocoder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1236g;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.C1256t;
import com.amap.api.services.core.HandlerC1246p;
import java.util.List;
/* loaded from: classes.dex */
public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String GPS = "gps";

    /* renamed from: a */
    private Context f4249a;

    /* renamed from: b */
    private OnGeocodeSearchListener f4250b;

    /* renamed from: c */
    private Handler f4251c = HandlerC1246p.m16952a();

    /* loaded from: classes.dex */
    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        this.f4249a = context.getApplicationContext();
    }

    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) {
        C1241l.m16960a(this.f4249a);
        return new C1256t(this.f4249a, regeocodeQuery).g();
    }

    public void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        new Thread(new Runnable() { // from class: com.amap.api.services.geocoder.GeocodeSearch.1
            @Override // java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                try {
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 21;
                        RegeocodeAddress fromLocation = GeocodeSearch.this.getFromLocation(regeocodeQuery);
                        obtainMessage.arg2 = 0;
                        HandlerC1246p.C1252f c1252f = new HandlerC1246p.C1252f();
                        c1252f.f4182b = GeocodeSearch.this.f4250b;
                        c1252f.f4181a = new RegeocodeResult(regeocodeQuery, fromLocation);
                        obtainMessage.obj = c1252f;
                        GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "GeocodeSearch", "getFromLocationAsyn");
                        obtainMessage.arg2 = e.getErrorCode();
                        GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }).start();
    }

    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) {
        C1241l.m16960a(this.f4249a);
        return new C1236g(this.f4249a, geocodeQuery).g();
    }

    public void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        new Thread(new Runnable() { // from class: com.amap.api.services.geocoder.GeocodeSearch.2
            @Override // java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                try {
                    try {
                        obtainMessage.what = 20;
                        obtainMessage.arg1 = 2;
                        List<GeocodeAddress> fromLocationName = GeocodeSearch.this.getFromLocationName(geocodeQuery);
                        obtainMessage.arg2 = 0;
                        HandlerC1246p.C1249c c1249c = new HandlerC1246p.C1249c();
                        c1249c.f4176b = GeocodeSearch.this.f4250b;
                        c1249c.f4175a = new GeocodeResult(geocodeQuery, fromLocationName);
                        obtainMessage.obj = c1249c;
                        GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "GeocodeSearch", "getFromLocationNameAsyn");
                        obtainMessage.arg2 = e.getErrorCode();
                        GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    GeocodeSearch.this.f4251c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }).start();
    }

    public void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f4250b = onGeocodeSearchListener;
    }
}
