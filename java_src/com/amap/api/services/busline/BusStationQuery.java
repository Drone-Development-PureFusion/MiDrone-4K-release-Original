package com.amap.api.services.busline;

import com.amap.api.services.core.C1233d;
/* loaded from: classes.dex */
public class BusStationQuery {

    /* renamed from: a */
    private String f3929a;

    /* renamed from: b */
    private String f3930b;

    /* renamed from: c */
    private int f3931c = 10;

    /* renamed from: d */
    private int f3932d = 0;

    public BusStationQuery(String str, String str2) {
        this.f3929a = str;
        this.f3930b = str2;
        if (!m17299a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    /* renamed from: a */
    private boolean m17299a() {
        return !C1233d.m17032a(this.f3929a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public BusStationQuery m21741clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f3929a, this.f3930b);
        busStationQuery.setPageNumber(this.f3932d);
        busStationQuery.setPageSize(this.f3931c);
        return busStationQuery;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationQuery busStationQuery = (BusStationQuery) obj;
            if (this.f3930b == null) {
                if (busStationQuery.f3930b != null) {
                    return false;
                }
            } else if (!this.f3930b.equals(busStationQuery.f3930b)) {
                return false;
            }
            if (this.f3932d == busStationQuery.f3932d && this.f3931c == busStationQuery.f3931c) {
                return this.f3929a == null ? busStationQuery.f3929a == null : this.f3929a.equals(busStationQuery.f3929a);
            }
            return false;
        }
        return false;
    }

    public String getCity() {
        return this.f3930b;
    }

    public int getPageNumber() {
        return this.f3932d;
    }

    public int getPageSize() {
        return this.f3931c;
    }

    public String getQueryString() {
        return this.f3929a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f3930b == null ? 0 : this.f3930b.hashCode()) + 31) * 31) + this.f3932d) * 31) + this.f3931c) * 31;
        if (this.f3929a != null) {
            i = this.f3929a.hashCode();
        }
        return hashCode + i;
    }

    public void setCity(String str) {
        this.f3930b = str;
    }

    public void setPageNumber(int i) {
        this.f3932d = i;
    }

    public void setPageSize(int i) {
        int i2 = 20;
        if (i <= 20) {
            i2 = i;
        }
        if (i2 <= 0) {
            i2 = 10;
        }
        this.f3931c = i2;
    }

    public void setQueryString(String str) {
        this.f3929a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        if (this.f3930b == null) {
            if (busStationQuery.f3930b != null) {
                return false;
            }
        } else if (!this.f3930b.equals(busStationQuery.f3930b)) {
            return false;
        }
        if (this.f3931c != busStationQuery.f3931c) {
            return false;
        }
        return this.f3929a == null ? busStationQuery.f3929a == null : this.f3929a.equals(busStationQuery.f3929a);
    }
}
