package com.amap.api.mapcore.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.eb */
/* loaded from: classes.dex */
public class C0939eb<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f2884a;

    /* renamed from: b */
    private int f2885b;

    /* renamed from: c */
    private int f2886c;

    /* renamed from: d */
    private int f2887d;

    /* renamed from: e */
    private int f2888e;

    /* renamed from: f */
    private int f2889f;

    /* renamed from: g */
    private int f2890g;

    /* renamed from: h */
    private int f2891h;

    public C0939eb(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2886c = i;
        this.f2884a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: a */
    private void m18390a(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f2885b < 0 || !this.f2884a.isEmpty() || this.f2885b != 0) {
                }
                if (this.f2885b <= i) {
                    return;
                }
                Iterator<Map.Entry<K, V>> it2 = this.f2884a.entrySet().iterator();
                Map.Entry<K, V> entry = null;
                while (it2.hasNext()) {
                    entry = it2.next();
                }
                if (entry == null) {
                    return;
                }
                key = entry.getKey();
                value = entry.getValue();
                this.f2884a.remove(key);
                this.f2885b -= m18384c(key, value);
                this.f2889f++;
            }
            mo18387a(true, key, value, null);
        }
    }

    /* renamed from: c */
    private int m18384c(K k, V v) {
        int mo18388a = mo18388a(k, v);
        if (mo18388a < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return mo18388a;
    }

    /* renamed from: a */
    protected int mo18388a(K k, V v) {
        return 1;
    }

    /* renamed from: a */
    public final V m18389a(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f2884a.get(k);
            if (v != null) {
                this.f2890g++;
                return v;
            }
            this.f2891h++;
            V m18386b = m18386b(k);
            if (m18386b == null) {
                return null;
            }
            synchronized (this) {
                this.f2888e++;
                put = this.f2884a.put(k, m18386b);
                if (put != null) {
                    this.f2884a.put(k, put);
                } else {
                    this.f2885b += m18384c(k, m18386b);
                }
            }
            if (put != null) {
                mo18387a(false, k, m18386b, put);
                return put;
            }
            m18390a(this.f2886c);
            return m18386b;
        }
    }

    /* renamed from: a */
    public final void m18391a() {
        m18390a(-1);
    }

    /* renamed from: a */
    protected void mo18387a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected V m18386b(K k) {
        return null;
    }

    /* renamed from: b */
    public final V m18385b(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2887d++;
            this.f2885b += m18384c(k, v);
            put = this.f2884a.put(k, v);
            if (put != null) {
                this.f2885b -= m18384c(k, put);
            }
        }
        if (put != null) {
            mo18387a(false, k, put, v);
        }
        m18390a(this.f2886c);
        return put;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f2890g + this.f2891h;
            if (i2 != 0) {
                i = (this.f2890g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2886c), Integer.valueOf(this.f2890g), Integer.valueOf(this.f2891h), Integer.valueOf(i));
        }
        return format;
    }
}
