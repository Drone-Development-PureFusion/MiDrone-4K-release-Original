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
public class BusLineSearch {

    /* renamed from: a */
    private Context f3915a;

    /* renamed from: b */
    private OnBusLineSearchListener f3916b;

    /* renamed from: c */
    private BusLineQuery f3917c;

    /* renamed from: d */
    private BusLineQuery f3918d;

    /* renamed from: e */
    private int f3919e;

    /* renamed from: f */
    private ArrayList<BusLineResult> f3920f = new ArrayList<>();

    /* renamed from: g */
    private Handler f3921g;

    /* loaded from: classes.dex */
    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        this.f3921g = null;
        this.f3915a = context.getApplicationContext();
        this.f3917c = busLineQuery;
        this.f3918d = busLineQuery.m21740clone();
        this.f3921g = HandlerC1246p.m16952a();
    }

    /* renamed from: a */
    private void m17304a(BusLineResult busLineResult) {
        this.f3920f = new ArrayList<>();
        for (int i = 0; i < this.f3919e; i++) {
            this.f3920f.add(null);
        }
        if (this.f3919e < 0 || !m17305a(this.f3917c.getPageNumber())) {
            return;
        }
        this.f3920f.set(this.f3917c.getPageNumber(), busLineResult);
    }

    /* renamed from: a */
    private boolean m17305a(int i) {
        return i < this.f3919e && i >= 0;
    }

    /* renamed from: b */
    private BusLineResult m17302b(int i) {
        if (!m17305a(i)) {
            throw new IllegalArgumentException("page out of range");
        }
        return this.f3920f.get(i);
    }

    public BusLineQuery getQuery() {
        return this.f3917c;
    }

    public BusLineResult searchBusLine() {
        C1241l.m16960a(this.f3915a);
        if (!this.f3917c.weakEquals(this.f3918d)) {
            this.f3918d = this.f3917c.m21740clone();
            this.f3919e = 0;
            if (this.f3920f != null) {
                this.f3920f.clear();
            }
        }
        if (this.f3919e == 0) {
            C1194b c1194b = new C1194b(this.f3915a, this.f3917c.m21740clone());
            BusLineResult m17306a = BusLineResult.m17306a(c1194b, c1194b.g());
            this.f3919e = m17306a.getPageCount();
            m17304a(m17306a);
            return m17306a;
        }
        BusLineResult m17302b = m17302b(this.f3917c.getPageNumber());
        if (m17302b != null) {
            return m17302b;
        }
        C1194b c1194b2 = new C1194b(this.f3915a, this.f3917c);
        BusLineResult m17306a2 = BusLineResult.m17306a(c1194b2, c1194b2.g());
        this.f3920f.set(this.f3917c.getPageNumber(), m17306a2);
        return m17306a2;
    }

    public void searchBusLineAsyn() {
        new Thread(new Runnable() { // from class: com.amap.api.services.busline.BusLineSearch.1
            @Override // java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                try {
                    try {
                        BusLineResult searchBusLine = BusLineSearch.this.searchBusLine();
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 0;
                        HandlerC1246p.C1247a c1247a = new HandlerC1246p.C1247a();
                        c1247a.f4171a = searchBusLine;
                        c1247a.f4172b = BusLineSearch.this.f3916b;
                        obtainMessage.obj = c1247a;
                        BusLineSearch.this.f3921g.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "BusLineSearch", "searchBusLineAsyn");
                        obtainMessage.what = e.getErrorCode();
                        BusLineSearch.this.f3921g.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    BusLineSearch.this.f3921g.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }).start();
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        this.f3916b = onBusLineSearchListener;
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.f3917c.weakEquals(busLineQuery)) {
            this.f3917c = busLineQuery;
            this.f3918d = busLineQuery.m21740clone();
        }
    }
}
