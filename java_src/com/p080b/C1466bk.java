package com.p080b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.b.bk */
/* loaded from: classes.dex */
public class C1466bk<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f5087a;

    /* renamed from: b */
    private int f5088b;

    /* renamed from: c */
    private int f5089c;

    public C1466bk(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f5089c = i;
        this.f5087a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m16079a(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f5088b < 0 || (this.f5087a.isEmpty() && this.f5088b != 0)) {
                    break;
                } else if (this.f5088b <= i) {
                    return;
                } else {
                    Iterator<Map.Entry<K, V>> it2 = this.f5087a.entrySet().iterator();
                    Map.Entry<K, V> entry = null;
                    while (it2.hasNext()) {
                        entry = it2.next();
                    }
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f5087a.remove(key);
                    this.f5088b -= m16072c(key, value);
                }
            }
            mo16076a(true, key, value, null);
        }
    }

    /* renamed from: c */
    private int m16072c(K k, V v) {
        int mo16077a = mo16077a(k, v);
        if (mo16077a < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return mo16077a;
    }

    /* renamed from: a */
    protected int mo16077a(K k, V v) {
        return 1;
    }

    /* renamed from: a */
    protected V m16078a(K k) {
        return null;
    }

    /* renamed from: a */
    public final void m16080a() {
        m16079a(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16076a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    public final V m16075b(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f5087a.get(k);
            if (v != null) {
                return v;
            }
            V m16078a = m16078a((C1466bk<K, V>) k);
            if (m16078a == null) {
                return null;
            }
            synchronized (this) {
                put = this.f5087a.put(k, m16078a);
                if (put != null) {
                    this.f5087a.put(k, put);
                } else {
                    this.f5088b += m16072c(k, m16078a);
                }
            }
            if (put != null) {
                mo16076a(false, k, m16078a, put);
                return put;
            }
            m16079a(this.f5089c);
            return m16078a;
        }
    }

    /* renamed from: b */
    public final V m16074b(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f5088b += m16072c(k, v);
            put = this.f5087a.put(k, v);
            if (put != null) {
                this.f5088b -= m16072c(k, put);
            }
        }
        if (put != null) {
            mo16076a(false, k, put, v);
        }
        m16079a(this.f5089c);
        return put;
    }

    /* renamed from: c */
    public final V m16073c(K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f5087a.remove(k);
            if (remove != null) {
                this.f5088b -= m16072c(k, remove);
            }
        }
        if (remove != null) {
            mo16076a(false, k, remove, null);
        }
        return remove;
    }
}
