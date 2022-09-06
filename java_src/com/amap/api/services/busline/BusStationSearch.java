package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1194b;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.HandlerC1246p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BusStationSearch {

    /* renamed from: a */
    private Context f3938a;

    /* renamed from: b */
    private OnBusStationSearchListener f3939b;

    /* renamed from: c */
    private BusStationQuery f3940c;

    /* renamed from: d */
    private BusStationQuery f3941d;

    /* renamed from: f */
    private int f3943f;

    /* renamed from: e */
    private ArrayList<BusStationResult> f3942e = new ArrayList<>();

    /* renamed from: g */
    private Handler f3944g = HandlerC1246p.m16952a();

    /* loaded from: classes.dex */
    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        this.f3938a = context.getApplicationContext();
        this.f3940c = busStationQuery;
    }

    /* renamed from: a */
    private void m17295a(BusStationResult busStationResult) {
        this.f3942e = new ArrayList<>();
        for (int i = 0; i <= this.f3943f; i++) {
            this.f3942e.add(null);
        }
        if (this.f3943f > 0) {
            this.f3942e.set(this.f3940c.getPageNumber(), busStationResult);
        }
    }

    /* renamed from: a */
    private boolean m17296a(int i) {
        return i <= this.f3943f && i >= 0;
    }

    /* renamed from: b */
    private BusStationResult m17293b(int i) {
        if (!m17296a(i)) {
            throw new IllegalArgumentException("page out of range");
        }
        return this.f3942e.get(i);
    }

    public BusStationQuery getQuery() {
        return this.f3940c;
    }

    public BusStationResult searchBusStation() {
        C1241l.m16960a(this.f3938a);
        if (!this.f3940c.weakEquals(this.f3941d)) {
            this.f3941d = this.f3940c.m21741clone();
            this.f3943f = 0;
            if (this.f3942e != null) {
                this.f3942e.clear();
            }
        }
        if (this.f3943f == 0) {
            C1194b c1194b = new C1194b(this.f3938a, this.f3940c);
            BusStationResult m17297a = BusStationResult.m17297a(c1194b, c1194b.g());
            this.f3943f = m17297a.getPageCount();
            m17295a(m17297a);
            return m17297a;
        }
        BusStationResult m17293b = m17293b(this.f3940c.getPageNumber());
        if (m17293b != null) {
            return m17293b;
        }
        C1194b c1194b2 = new C1194b(this.f3938a, this.f3940c);
        BusStationResult m17297a2 = BusStationResult.m17297a(c1194b2, c1194b2.g());
        this.f3942e.set(this.f3940c.getPageNumber(), m17297a2);
        return m17297a2;
    }

    public void searchBusStationAsyn() {
        new Thread(new Runnable() { // from class: com.amap.api.services.busline.BusStationSearch.1
            @Override // java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                try {
                    try {
                        BusStationResult searchBusStation = BusStationSearch.this.searchBusStation();
                        obtainMessage.arg1 = 7;
                        obtainMessage.what = 0;
                        HandlerC1246p.C1248b c1248b = new HandlerC1246p.C1248b();
                        c1248b.f4173a = searchBusStation;
                        c1248b.f4174b = BusStationSearch.this.f3939b;
                        obtainMessage.obj = c1248b;
                        BusStationSearch.this.f3944g.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "BusStationSearch", "searchBusStationAsyn");
                        obtainMessage.what = e.getErrorCode();
                        BusStationSearch.this.f3944g.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    BusStationSearch.this.f3944g.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }).start();
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        this.f3939b = onBusStationSearchListener;
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.f3940c)) {
            this.f3940c = busStationQuery;
        }
    }
}
