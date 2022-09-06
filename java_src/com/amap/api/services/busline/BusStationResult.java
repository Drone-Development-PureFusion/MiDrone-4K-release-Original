package com.amap.api.services.busline;

import com.amap.api.services.core.C1194b;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class BusStationResult {

    /* renamed from: a */
    private int f3933a;

    /* renamed from: b */
    private ArrayList<BusStationItem> f3934b;

    /* renamed from: c */
    private BusStationQuery f3935c;

    /* renamed from: d */
    private List<String> f3936d;

    /* renamed from: e */
    private List<SuggestionCity> f3937e;

    /* JADX WARN: Multi-variable type inference failed */
    private BusStationResult(C1194b c1194b, ArrayList<?> arrayList) {
        this.f3934b = new ArrayList<>();
        this.f3936d = new ArrayList();
        this.f3937e = new ArrayList();
        this.f3935c = (BusStationQuery) c1194b.m17171c();
        this.f3933a = m17298a(c1194b.m17170d());
        this.f3937e = c1194b.m17169f();
        this.f3936d = c1194b.m17172b_();
        this.f3934b = arrayList;
    }

    /* renamed from: a */
    private int m17298a(int i) {
        int pageSize = this.f3935c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static BusStationResult m17297a(C1194b c1194b, ArrayList<?> arrayList) {
        return new BusStationResult(c1194b, arrayList);
    }

    public List<BusStationItem> getBusStations() {
        return this.f3934b;
    }

    public int getPageCount() {
        return this.f3933a;
    }

    public BusStationQuery getQuery() {
        return this.f3935c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f3937e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f3936d;
    }
}
