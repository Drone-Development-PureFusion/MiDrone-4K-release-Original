package com.amap.api.services.poisearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.C1255s;
import com.amap.api.services.core.HandlerC1246p;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: i */
    private static HashMap<Integer, PoiResult> f4370i;

    /* renamed from: a */
    private SearchBound f4371a;

    /* renamed from: b */
    private Query f4372b;

    /* renamed from: c */
    private Context f4373c;

    /* renamed from: d */
    private OnPoiSearchListener f4374d;

    /* renamed from: e */
    private String f4375e = "zh-CN";

    /* renamed from: f */
    private Query f4376f;

    /* renamed from: g */
    private SearchBound f4377g;

    /* renamed from: h */
    private int f4378h;

    /* renamed from: j */
    private Handler f4379j;

    /* loaded from: classes.dex */
    public interface OnPoiSearchListener {
        void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    /* loaded from: classes.dex */
    public static class Query implements Cloneable {

        /* renamed from: a */
        private String f4383a;

        /* renamed from: b */
        private String f4384b;

        /* renamed from: c */
        private String f4385c;

        /* renamed from: d */
        private int f4386d;

        /* renamed from: e */
        private int f4387e;

        /* renamed from: f */
        private boolean f4388f;

        /* renamed from: g */
        private boolean f4389g;

        /* renamed from: h */
        private String f4390h;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.f4386d = 0;
            this.f4387e = 20;
            this.f4390h = "zh-CN";
            this.f4383a = str;
            this.f4384b = str2;
            this.f4385c = str3;
        }

        /* renamed from: a */
        private String m16840a() {
            return "";
        }

        /* renamed from: clone */
        public Query m21743clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f4383a, this.f4384b, this.f4385c);
            query.setPageNum(this.f4386d);
            query.setPageSize(this.f4387e);
            query.setLimitDiscount(this.f4389g);
            query.setLimitGroupbuy(this.f4388f);
            query.setQueryLanguage(this.f4390h);
            return query;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Query query = (Query) obj;
                if (this.f4384b == null) {
                    if (query.f4384b != null) {
                        return false;
                    }
                } else if (!this.f4384b.equals(query.f4384b)) {
                    return false;
                }
                if (this.f4385c == null) {
                    if (query.f4385c != null) {
                        return false;
                    }
                } else if (!this.f4385c.equals(query.f4385c)) {
                    return false;
                }
                if (this.f4389g == query.f4389g && this.f4388f == query.f4388f) {
                    if (this.f4390h == null) {
                        if (query.f4390h != null) {
                            return false;
                        }
                    } else if (!this.f4390h.equals(query.f4390h)) {
                        return false;
                    }
                    if (this.f4386d == query.f4386d && this.f4387e == query.f4387e) {
                        return this.f4383a == null ? query.f4383a == null : this.f4383a.equals(query.f4383a);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public String getCategory() {
            return (this.f4384b == null || this.f4384b.equals("00") || this.f4384b.equals("00|")) ? m16840a() : this.f4384b;
        }

        public String getCity() {
            return this.f4385c;
        }

        public int getPageNum() {
            return this.f4386d;
        }

        public int getPageSize() {
            return this.f4387e;
        }

        protected String getQueryLanguage() {
            return this.f4390h;
        }

        public String getQueryString() {
            return this.f4383a;
        }

        public boolean hasDiscountLimit() {
            return this.f4389g;
        }

        public boolean hasGroupBuyLimit() {
            return this.f4388f;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.f4389g ? 1231 : 1237) + (((this.f4385c == null ? 0 : this.f4385c.hashCode()) + (((this.f4384b == null ? 0 : this.f4384b.hashCode()) + 31) * 31)) * 31)) * 31;
            if (!this.f4388f) {
                i = 1237;
            }
            int hashCode2 = ((((((this.f4390h == null ? 0 : this.f4390h.hashCode()) + ((hashCode + i) * 31)) * 31) + this.f4386d) * 31) + this.f4387e) * 31;
            if (this.f4383a != null) {
                i2 = this.f4383a.hashCode();
            }
            return hashCode2 + i2;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.m16841b(query.f4383a, this.f4383a) && PoiSearch.m16841b(query.f4384b, this.f4384b) && PoiSearch.m16841b(query.f4390h, this.f4390h) && PoiSearch.m16841b(query.f4385c, this.f4385c) && query.f4387e == this.f4387e;
        }

        public void setLimitDiscount(boolean z) {
            this.f4389g = z;
        }

        public void setLimitGroupbuy(boolean z) {
            this.f4388f = z;
        }

        public void setPageNum(int i) {
            this.f4386d = i;
        }

        public void setPageSize(int i) {
            this.f4387e = i;
        }

        protected void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f4390h = "en";
            } else {
                this.f4390h = "zh-CN";
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a */
        private LatLonPoint f4391a;

        /* renamed from: b */
        private LatLonPoint f4392b;

        /* renamed from: c */
        private int f4393c;

        /* renamed from: d */
        private LatLonPoint f4394d;

        /* renamed from: e */
        private String f4395e;

        /* renamed from: f */
        private boolean f4396f;

        /* renamed from: g */
        private List<LatLonPoint> f4397g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f4396f = true;
            this.f4395e = BOUND_SHAPE;
            this.f4393c = i;
            this.f4394d = latLonPoint;
            m16835a(latLonPoint, C1233d.m17034a(i), C1233d.m17034a(i));
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f4396f = true;
            this.f4395e = BOUND_SHAPE;
            this.f4393c = i;
            this.f4394d = latLonPoint;
            m16835a(latLonPoint, C1233d.m17034a(i), C1233d.m17034a(i));
            this.f4396f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f4396f = true;
            this.f4395e = RECTANGLE_SHAPE;
            m16834a(latLonPoint, latLonPoint2);
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f4396f = true;
            this.f4391a = latLonPoint;
            this.f4392b = latLonPoint2;
            this.f4393c = i;
            this.f4394d = latLonPoint3;
            this.f4395e = str;
            this.f4397g = list;
            this.f4396f = z;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f4396f = true;
            this.f4395e = POLYGON_SHAPE;
            this.f4397g = list;
        }

        /* renamed from: a */
        private void m16835a(LatLonPoint latLonPoint, double d, double d2) {
            double d3 = d / 2.0d;
            double d4 = d2 / 2.0d;
            double latitude = latLonPoint.getLatitude();
            double longitude = latLonPoint.getLongitude();
            m16834a(new LatLonPoint(latitude - d3, longitude - d4), new LatLonPoint(d3 + latitude, d4 + longitude));
        }

        /* renamed from: a */
        private void m16834a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f4391a = latLonPoint;
            this.f4392b = latLonPoint2;
            if (this.f4391a.getLatitude() >= this.f4392b.getLatitude() || this.f4391a.getLongitude() >= this.f4392b.getLongitude()) {
                throw new IllegalArgumentException("invalid rect ");
            }
            this.f4394d = new LatLonPoint((this.f4391a.getLatitude() + this.f4392b.getLatitude()) / 2.0d, (this.f4391a.getLongitude() + this.f4392b.getLongitude()) / 2.0d);
        }

        /* renamed from: clone */
        public SearchBound m21744clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C1233d.m17031a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f4391a, this.f4392b, this.f4393c, this.f4394d, this.f4395e, this.f4397g, this.f4396f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                if (this.f4394d == null) {
                    if (searchBound.f4394d != null) {
                        return false;
                    }
                } else if (!this.f4394d.equals(searchBound.f4394d)) {
                    return false;
                }
                if (this.f4396f != searchBound.f4396f) {
                    return false;
                }
                if (this.f4391a == null) {
                    if (searchBound.f4391a != null) {
                        return false;
                    }
                } else if (!this.f4391a.equals(searchBound.f4391a)) {
                    return false;
                }
                if (this.f4392b == null) {
                    if (searchBound.f4392b != null) {
                        return false;
                    }
                } else if (!this.f4392b.equals(searchBound.f4392b)) {
                    return false;
                }
                if (this.f4397g == null) {
                    if (searchBound.f4397g != null) {
                        return false;
                    }
                } else if (!this.f4397g.equals(searchBound.f4397g)) {
                    return false;
                }
                if (this.f4393c != searchBound.f4393c) {
                    return false;
                }
                return this.f4395e == null ? searchBound.f4395e == null : this.f4395e.equals(searchBound.f4395e);
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f4394d;
        }

        public double getLatSpanInMeter() {
            if (!RECTANGLE_SHAPE.equals(getShape())) {
                return 0.0d;
            }
            return this.f4392b.getLatitude() - this.f4391a.getLatitude();
        }

        public double getLonSpanInMeter() {
            if (!RECTANGLE_SHAPE.equals(getShape())) {
                return 0.0d;
            }
            return this.f4392b.getLongitude() - this.f4391a.getLongitude();
        }

        public LatLonPoint getLowerLeft() {
            return this.f4391a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f4397g;
        }

        public int getRange() {
            return this.f4393c;
        }

        public String getShape() {
            return this.f4395e;
        }

        public LatLonPoint getUpperRight() {
            return this.f4392b;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f4397g == null ? 0 : this.f4397g.hashCode()) + (((this.f4392b == null ? 0 : this.f4392b.hashCode()) + (((this.f4391a == null ? 0 : this.f4391a.hashCode()) + (((this.f4396f ? 1231 : 1237) + (((this.f4394d == null ? 0 : this.f4394d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + this.f4393c) * 31;
            if (this.f4395e != null) {
                i = this.f4395e.hashCode();
            }
            return hashCode + i;
        }

        public boolean isDistanceSort() {
            return this.f4396f;
        }
    }

    public PoiSearch(Context context, Query query) {
        this.f4379j = null;
        this.f4373c = context.getApplicationContext();
        setQuery(query);
        this.f4379j = HandlerC1246p.m16952a();
    }

    /* renamed from: a */
    private void m16846a(PoiResult poiResult) {
        f4370i = new HashMap<>();
        if (this.f4372b == null || poiResult == null || this.f4378h <= 0 || this.f4378h <= this.f4372b.getPageNum()) {
            return;
        }
        f4370i.put(Integer.valueOf(this.f4372b.getPageNum()), poiResult);
    }

    /* renamed from: a */
    private boolean m16848a() {
        return !C1233d.m17032a(this.f4372b.f4383a) || !C1233d.m17032a(this.f4372b.f4384b);
    }

    /* renamed from: a */
    private boolean m16847a(int i) {
        return i <= this.f4378h && i >= 0;
    }

    /* renamed from: b */
    private boolean m16843b() {
        SearchBound bound = getBound();
        return bound != null && bound.getShape().equals(SearchBound.BOUND_SHAPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m16841b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            return str.equals(str2);
        }
        return false;
    }

    public SearchBound getBound() {
        return this.f4371a;
    }

    public String getLanguage() {
        return this.f4375e;
    }

    protected PoiResult getPageLocal(int i) {
        if (!m16847a(i)) {
            throw new IllegalArgumentException("page out of range");
        }
        return f4370i.get(Integer.valueOf(i));
    }

    public Query getQuery() {
        return this.f4372b;
    }

    public PoiResult searchPOI() {
        C1241l.m16960a(this.f4373c);
        if (m16843b() || m16848a()) {
            this.f4372b.setQueryLanguage(this.f4375e);
            if ((!this.f4372b.queryEquals(this.f4376f) && this.f4371a == null) || (!this.f4372b.queryEquals(this.f4376f) && !this.f4371a.equals(this.f4377g))) {
                this.f4378h = 0;
                this.f4376f = this.f4372b.m21743clone();
                if (this.f4371a != null) {
                    this.f4377g = this.f4371a.m21744clone();
                }
                if (f4370i != null) {
                    f4370i.clear();
                }
            }
            SearchBound searchBound = null;
            if (this.f4371a != null) {
                searchBound = this.f4371a.m21744clone();
            }
            if (this.f4378h == 0) {
                C1288j c1288j = new C1288j(this.f4373c, new C1255s(this.f4372b.m21743clone(), searchBound));
                c1288j.m16815a(this.f4372b.f4386d);
                c1288j.m16812b(this.f4372b.f4387e);
                PoiResult m16849a = PoiResult.m16849a(c1288j, c1288j.g());
                m16846a(m16849a);
                return m16849a;
            }
            PoiResult pageLocal = getPageLocal(this.f4372b.getPageNum());
            if (pageLocal != null) {
                return pageLocal;
            }
            C1288j c1288j2 = new C1288j(this.f4373c, new C1255s(this.f4372b.m21743clone(), searchBound));
            c1288j2.m16815a(this.f4372b.f4386d);
            c1288j2.m16812b(this.f4372b.f4387e);
            PoiResult m16849a2 = PoiResult.m16849a(c1288j2, c1288j2.g());
            f4370i.put(Integer.valueOf(this.f4372b.f4386d), m16849a2);
            return m16849a2;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.poisearch.PoiSearch$1] */
    public void searchPOIAsyn() {
        new Thread() { // from class: com.amap.api.services.poisearch.PoiSearch.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = PoiSearch.this.f4379j.obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 60;
                Bundle bundle = new Bundle();
                PoiResult poiResult = null;
                try {
                    try {
                        poiResult = PoiSearch.this.searchPOI();
                        bundle.putInt("errorCode", 0);
                        HandlerC1246p.C1251e c1251e = new HandlerC1246p.C1251e();
                        c1251e.f4180b = PoiSearch.this.f4374d;
                        c1251e.f4179a = poiResult;
                        obtainMessage.obj = c1251e;
                        obtainMessage.setData(bundle);
                        PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "PoiSearch", "searchPOIAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        HandlerC1246p.C1251e c1251e2 = new HandlerC1246p.C1251e();
                        c1251e2.f4180b = PoiSearch.this.f4374d;
                        c1251e2.f4179a = poiResult;
                        obtainMessage.obj = c1251e2;
                        obtainMessage.setData(bundle);
                        PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    HandlerC1246p.C1251e c1251e3 = new HandlerC1246p.C1251e();
                    c1251e3.f4180b = PoiSearch.this.f4374d;
                    c1251e3.f4179a = poiResult;
                    obtainMessage.obj = c1251e3;
                    obtainMessage.setData(bundle);
                    PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }.start();
    }

    public PoiItemDetail searchPOIDetail(String str) {
        C1241l.m16960a(this.f4373c);
        return new C1287i(this.f4373c, str, this.f4375e).g();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.poisearch.PoiSearch$2] */
    public void searchPOIDetailAsyn(final String str) {
        new Thread() { // from class: com.amap.api.services.poisearch.PoiSearch.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 61;
                Bundle bundle = new Bundle();
                PoiItemDetail poiItemDetail = null;
                try {
                    try {
                        poiItemDetail = PoiSearch.this.searchPOIDetail(str);
                        bundle.putInt("errorCode", 0);
                        HandlerC1246p.C1250d c1250d = new HandlerC1246p.C1250d();
                        c1250d.f4178b = PoiSearch.this.f4374d;
                        c1250d.f4177a = poiItemDetail;
                        obtainMessage.obj = c1250d;
                        obtainMessage.setData(bundle);
                        PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "PoiSearch", "searchPOIDetailAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        HandlerC1246p.C1250d c1250d2 = new HandlerC1246p.C1250d();
                        c1250d2.f4178b = PoiSearch.this.f4374d;
                        c1250d2.f4177a = poiItemDetail;
                        obtainMessage.obj = c1250d2;
                        obtainMessage.setData(bundle);
                        PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    HandlerC1246p.C1250d c1250d3 = new HandlerC1246p.C1250d();
                    c1250d3.f4178b = PoiSearch.this.f4374d;
                    c1250d3.f4177a = poiItemDetail;
                    obtainMessage.obj = c1250d3;
                    obtainMessage.setData(bundle);
                    PoiSearch.this.f4379j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        }.start();
    }

    public void setBound(SearchBound searchBound) {
        this.f4371a = searchBound;
    }

    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f4375e = "en";
        } else {
            this.f4375e = "zh-CN";
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        this.f4374d = onPoiSearchListener;
    }

    public void setQuery(Query query) {
        this.f4372b = query;
    }
}
