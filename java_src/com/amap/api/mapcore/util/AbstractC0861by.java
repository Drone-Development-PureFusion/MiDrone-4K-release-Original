package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.C0977ez;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.by */
/* loaded from: classes.dex */
public abstract class AbstractC0861by<T, V> {

    /* renamed from: a */
    protected T f2402a;

    /* renamed from: b */
    protected int f2403b = 3;

    /* renamed from: c */
    protected Context f2404c;

    public AbstractC0861by(Context context, T t) {
        m18732a(context, t);
    }

    /* renamed from: a */
    private void m18732a(Context context, T t) {
        this.f2404c = context;
        this.f2402a = t;
    }

    /* renamed from: a */
    protected abstract String mo18733a();

    /* renamed from: a */
    protected abstract JSONObject mo18731a(C0977ez.C0978a c0978a);

    /* renamed from: b */
    protected abstract V mo18729b(JSONObject jSONObject);

    /* renamed from: b */
    protected abstract Map<String, String> mo18730b();

    /* renamed from: c */
    public V m18728c() {
        if (this.f2402a != null) {
            return m18727d();
        }
        return null;
    }

    /* renamed from: d */
    protected V m18727d() {
        int i;
        String str;
        AMapException aMapException;
        int i2 = 0;
        V v = null;
        C0977ez.C0978a c0978a = null;
        while (i2 < this.f2403b) {
            try {
                c0978a = C0977ez.m18164a(this.f2404c, C0945eh.m18310e(), mo18733a(), mo18730b());
                v = mo18729b(mo18731a(c0978a));
                i2 = this.f2403b;
            } finally {
                if (i2 < i) {
                    continue;
                }
            }
        }
        return v;
    }
}
