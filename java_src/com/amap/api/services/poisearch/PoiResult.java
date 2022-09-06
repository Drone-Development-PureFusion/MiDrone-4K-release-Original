package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PoiResult {

    /* renamed from: a */
    private int f4367a;

    /* renamed from: b */
    private ArrayList<PoiItem> f4368b;

    /* renamed from: c */
    private C1288j f4369c;

    private PoiResult(C1288j c1288j, ArrayList<PoiItem> arrayList) {
        this.f4368b = new ArrayList<>();
        this.f4369c = c1288j;
        this.f4367a = m16850a(c1288j.m16808i());
        this.f4368b = arrayList;
    }

    /* renamed from: a */
    private int m16850a(int i) {
        int m16809f = this.f4369c.m16809f();
        int i2 = ((i + m16809f) - 1) / m16809f;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static PoiResult m16849a(C1288j c1288j, ArrayList<PoiItem> arrayList) {
        return new PoiResult(c1288j, arrayList);
    }

    public PoiSearch.SearchBound getBound() {
        return this.f4369c.m16806k();
    }

    public int getPageCount() {
        return this.f4367a;
    }

    public ArrayList<PoiItem> getPois() {
        return this.f4368b;
    }

    public PoiSearch.Query getQuery() {
        return this.f4369c.m16807j();
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f4369c.m16804m();
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f4369c.m16805l();
    }
}
