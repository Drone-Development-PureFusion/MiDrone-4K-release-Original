package com.amap.api.services.busline;

import com.amap.api.services.core.C1194b;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class BusLineResult {

    /* renamed from: a */
    private int f3910a;

    /* renamed from: b */
    private ArrayList<BusLineItem> f3911b;

    /* renamed from: c */
    private BusLineQuery f3912c;

    /* renamed from: d */
    private List<String> f3913d;

    /* renamed from: e */
    private List<SuggestionCity> f3914e;

    /* JADX WARN: Multi-variable type inference failed */
    private BusLineResult(C1194b c1194b, ArrayList<?> arrayList) {
        this.f3911b = new ArrayList<>();
        this.f3913d = new ArrayList();
        this.f3914e = new ArrayList();
        this.f3912c = (BusLineQuery) c1194b.m17171c();
        this.f3910a = m17307a(c1194b.m17170d());
        this.f3914e = c1194b.m17169f();
        this.f3913d = c1194b.m17172b_();
        this.f3911b = arrayList;
    }

    /* renamed from: a */
    private int m17307a(int i) {
        int pageSize = this.f3912c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static BusLineResult m17306a(C1194b c1194b, ArrayList<?> arrayList) {
        return new BusLineResult(c1194b, arrayList);
    }

    public List<BusLineItem> getBusLines() {
        return this.f3911b;
    }

    public int getPageCount() {
        return this.f3910a;
    }

    public BusLineQuery getQuery() {
        return this.f3912c;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f3914e;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f3913d;
    }
}
