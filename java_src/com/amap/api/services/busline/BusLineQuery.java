package com.amap.api.services.busline;

import com.amap.api.services.core.C1233d;
/* loaded from: classes.dex */
public class BusLineQuery {

    /* renamed from: a */
    private String f3904a;

    /* renamed from: b */
    private String f3905b;

    /* renamed from: c */
    private int f3906c = 10;

    /* renamed from: d */
    private int f3907d = 0;

    /* renamed from: e */
    private SearchType f3908e;

    /* loaded from: classes.dex */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f3904a = str;
        this.f3908e = searchType;
        this.f3905b = str2;
        if (!m17308a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    /* renamed from: a */
    private boolean m17308a() {
        return !C1233d.m17032a(this.f3904a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public BusLineQuery m21740clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f3904a, this.f3908e, this.f3905b);
        busLineQuery.setPageNumber(this.f3907d);
        busLineQuery.setPageSize(this.f3906c);
        return busLineQuery;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusLineQuery busLineQuery = (BusLineQuery) obj;
            if (this.f3908e != busLineQuery.f3908e) {
                return false;
            }
            if (this.f3905b == null) {
                if (busLineQuery.f3905b != null) {
                    return false;
                }
            } else if (!this.f3905b.equals(busLineQuery.f3905b)) {
                return false;
            }
            if (this.f3907d == busLineQuery.f3907d && this.f3906c == busLineQuery.f3906c) {
                return this.f3904a == null ? busLineQuery.f3904a == null : this.f3904a.equals(busLineQuery.f3904a);
            }
            return false;
        }
        return false;
    }

    public SearchType getCategory() {
        return this.f3908e;
    }

    public String getCity() {
        return this.f3905b;
    }

    public int getPageNumber() {
        return this.f3907d;
    }

    public int getPageSize() {
        return this.f3906c;
    }

    public String getQueryString() {
        return this.f3904a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f3905b == null ? 0 : this.f3905b.hashCode()) + (((this.f3908e == null ? 0 : this.f3908e.hashCode()) + 31) * 31)) * 31) + this.f3907d) * 31) + this.f3906c) * 31;
        if (this.f3904a != null) {
            i = this.f3904a.hashCode();
        }
        return hashCode + i;
    }

    public void setCategory(SearchType searchType) {
        this.f3908e = searchType;
    }

    public void setCity(String str) {
        this.f3905b = str;
    }

    public void setPageNumber(int i) {
        this.f3907d = i;
    }

    public void setPageSize(int i) {
        this.f3906c = i;
    }

    public void setQueryString(String str) {
        this.f3904a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean weakEquals(BusLineQuery busLineQuery) {
        return busLineQuery.getQueryString().equals(this.f3904a) && busLineQuery.getCity().equals(this.f3905b) && busLineQuery.getPageSize() == this.f3906c && busLineQuery.getCategory().compareTo(this.f3908e) == 0;
    }
}
