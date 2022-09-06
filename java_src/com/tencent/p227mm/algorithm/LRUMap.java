package com.tencent.p227mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* renamed from: com.tencent.mm.algorithm.LRUMap */
/* loaded from: classes.dex */
public class LRUMap<K, O> {

    /* renamed from: c */
    private Map<K, LRUMap<K, O>.TimeVal<O>> f17742c;

    /* renamed from: d */
    private int f17743d;

    /* renamed from: e */
    private int f17744e;

    /* renamed from: f */
    private PreRemoveCallback<K, O> f17745f;

    /* renamed from: com.tencent.mm.algorithm.LRUMap$OnClearListener */
    /* loaded from: classes.dex */
    public interface OnClearListener<K, O> {
        void onClear(K k, O o);
    }

    /* renamed from: com.tencent.mm.algorithm.LRUMap$PreRemoveCallback */
    /* loaded from: classes.dex */
    public interface PreRemoveCallback<K, O> {
        void preRemoveCallback(K k, O o);
    }

    /* renamed from: com.tencent.mm.algorithm.LRUMap$TimeVal */
    /* loaded from: classes.dex */
    public class TimeVal<OO> {
        public OO obj;

        /* renamed from: t */
        public Long f17748t;

        public TimeVal(OO oo) {
            this.obj = oo;
            UpTime();
        }

        public void UpTime() {
            this.f17748t = Long.valueOf(System.currentTimeMillis());
        }
    }

    public LRUMap(int i) {
        this(i, null);
    }

    public LRUMap(int i, PreRemoveCallback<K, O> preRemoveCallback) {
        this.f17742c = null;
        this.f17745f = null;
        this.f17743d = i;
        this.f17744e = 0;
        this.f17745f = preRemoveCallback;
        this.f17742c = new HashMap();
    }

    public boolean check(K k) {
        return this.f17742c.containsKey(k);
    }

    public boolean checkAndUpTime(K k) {
        if (this.f17742c.containsKey(k)) {
            this.f17742c.get(k).UpTime();
            return true;
        }
        return false;
    }

    public void clear() {
        this.f17742c.clear();
    }

    public void clear(OnClearListener<K, O> onClearListener) {
        if (this.f17742c != null) {
            if (onClearListener != null) {
                for (Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry : this.f17742c.entrySet()) {
                    onClearListener.onClear(entry.getKey(), entry.getValue().obj);
                }
            }
            this.f17742c.clear();
        }
    }

    public O get(K k) {
        LRUMap<K, O>.TimeVal<O> timeVal = this.f17742c.get(k);
        if (timeVal == null) {
            return null;
        }
        return timeVal.obj;
    }

    public O getAndUptime(K k) {
        LRUMap<K, O>.TimeVal<O> timeVal = this.f17742c.get(k);
        if (timeVal == null) {
            return null;
        }
        this.f17742c.get(k).UpTime();
        return timeVal.obj;
    }

    public void remove(K k) {
        if (!this.f17742c.containsKey(k)) {
            return;
        }
        if (this.f17745f != null) {
            this.f17745f.preRemoveCallback(k, this.f17742c.get(k).obj);
        }
        this.f17742c.remove(k);
    }

    public void setMaxSize(int i) {
        if (i > 0) {
            this.f17743d = i;
        }
    }

    public void setPerDeleteSize(int i) {
        if (i > 0) {
            this.f17744e = i;
        }
    }

    public int size() {
        return this.f17742c.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void update(K k, O o) {
        int i;
        if (this.f17742c.get(k) != null) {
            this.f17742c.get(k).UpTime();
            this.f17742c.get(k).obj = o;
            return;
        }
        this.f17742c.put(k, new TimeVal<>(o));
        if (this.f17742c.size() <= this.f17743d) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f17742c.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<K, LRUMap<K, O>.TimeVal<O>>>() { // from class: com.tencent.mm.algorithm.LRUMap.1
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Map.Entry) ((Map.Entry) obj), (Map.Entry) ((Map.Entry) obj2));
            }

            public int compare(Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry, Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry2) {
                return entry.getValue().f17748t.compareTo(entry2.getValue().f17748t);
            }
        });
        if (this.f17744e <= 0) {
            i = this.f17743d / 10;
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = this.f17744e;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                return;
            }
            remove(((Map.Entry) it2.next()).getKey());
            i = i2 - 1;
            if (i <= 0) {
                return;
            }
        }
    }
}
