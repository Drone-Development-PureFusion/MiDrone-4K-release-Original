package com.amap.api.services.district;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1234e;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.HandlerC1246p;
import java.util.HashMap;
/* loaded from: classes.dex */
public class DistrictSearch {

    /* renamed from: f */
    private static HashMap<Integer, DistrictResult> f4218f;

    /* renamed from: a */
    private Context f4219a;

    /* renamed from: b */
    private DistrictSearchQuery f4220b;

    /* renamed from: c */
    private OnDistrictSearchListener f4221c;

    /* renamed from: d */
    private DistrictSearchQuery f4222d;

    /* renamed from: e */
    private int f4223e;

    /* renamed from: g */
    private Handler f4224g = HandlerC1246p.m16952a();

    /* loaded from: classes.dex */
    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        this.f4219a = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m16879a(DistrictResult districtResult) {
        f4218f = new HashMap<>();
        if (this.f4220b == null || districtResult == null || this.f4223e <= 0 || this.f4223e <= this.f4220b.getPageNum()) {
            return;
        }
        f4218f.put(Integer.valueOf(this.f4220b.getPageNum()), districtResult);
    }

    /* renamed from: a */
    private boolean m16881a() {
        return this.f4220b != null;
    }

    /* renamed from: a */
    private boolean m16880a(int i) {
        return i < this.f4223e && i >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public DistrictResult m16877b() {
        DistrictResult pageLocal;
        DistrictResult districtResult = new DistrictResult();
        C1241l.m16960a(this.f4219a);
        if (!m16881a()) {
            this.f4220b = new DistrictSearchQuery();
        }
        districtResult.setQuery(this.f4220b.m21742clone());
        if (!this.f4220b.weakEquals(this.f4222d)) {
            this.f4223e = 0;
            this.f4222d = this.f4220b.m21742clone();
            if (f4218f != null) {
                f4218f.clear();
            }
        }
        if (this.f4223e == 0) {
            pageLocal = new C1234e(this.f4219a, this.f4220b.m21742clone()).g();
            if (pageLocal != null) {
                this.f4223e = pageLocal.getPageCount();
                m16879a(pageLocal);
            }
        } else {
            pageLocal = getPageLocal(this.f4220b.getPageNum());
            if (pageLocal == null) {
                pageLocal = new C1234e(this.f4219a, this.f4220b.m21742clone()).g();
                if (this.f4220b != null && pageLocal != null && this.f4223e > 0 && this.f4223e > this.f4220b.getPageNum()) {
                    f4218f.put(Integer.valueOf(this.f4220b.getPageNum()), pageLocal);
                }
            }
        }
        return pageLocal;
    }

    protected DistrictResult getPageLocal(int i) {
        if (!m16880a(i)) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        return f4218f.get(Integer.valueOf(i));
    }

    public DistrictSearchQuery getQuery() {
        return this.f4220b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.district.DistrictSearch$1] */
    public void searchDistrictAnsy() {
        new Thread() { // from class: com.amap.api.services.district.DistrictSearch.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                DistrictResult districtResult = new DistrictResult();
                districtResult.setQuery(DistrictSearch.this.f4220b);
                try {
                    try {
                        districtResult = DistrictSearch.this.m16877b();
                        if (districtResult != null) {
                            districtResult.setAMapException(new AMapException());
                        }
                    } catch (AMapException e) {
                        C1233d.m17031a(e, "DistrictSearch", "searchDistrictAnsy");
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = DistrictSearch.this.f4221c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle);
                        if (DistrictSearch.this.f4224g == null) {
                            return;
                        }
                        DistrictSearch.this.f4224g.sendMessage(obtainMessage);
                    }
                } finally {
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = DistrictSearch.this.f4221c;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle2);
                    if (DistrictSearch.this.f4224g != null) {
                        DistrictSearch.this.f4224g.sendMessage(obtainMessage);
                    }
                }
            }
        }.start();
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        this.f4221c = onDistrictSearchListener;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f4220b = districtSearchQuery;
    }
}
