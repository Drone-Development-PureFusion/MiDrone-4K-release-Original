package com.tencent.p227mm.sdk.storage;

import android.os.Handler;
import android.os.Looper;
import com.tencent.p227mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* renamed from: com.tencent.mm.sdk.storage.MStorageEvent */
/* loaded from: classes2.dex */
public abstract class MStorageEvent<T, E> {

    /* renamed from: bP */
    private int f17910bP = 0;

    /* renamed from: bQ */
    private final Hashtable<T, Object> f17911bQ = new Hashtable<>();

    /* renamed from: bR */
    private final CopyOnWriteArraySet<E> f17912bR = new CopyOnWriteArraySet<>();

    /* renamed from: e */
    private void m5612e() {
        HashSet hashSet = new HashSet(this.f17911bQ.keySet());
        if (hashSet.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (final E e : hashSet) {
            Object obj = this.f17911bQ.get(e);
            Iterator<E> it2 = this.f17912bR.iterator();
            while (it2.hasNext()) {
                final E next = it2.next();
                if (next != null) {
                    if (obj == null) {
                        Log.m5645f("MicroMsg.SDK.MStorageEvent", "handle listener fatal unknown bug");
                    } else if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        Handler handler = (Handler) hashMap.get(looper);
                        if (handler == null) {
                            handler = new Handler(looper);
                            hashMap.put(looper, handler);
                        }
                        handler.post(new Runnable() { // from class: com.tencent.mm.sdk.storage.MStorageEvent.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                MStorageEvent.this.processEvent(e, next);
                            }
                        });
                    } else {
                        processEvent(e, next);
                    }
                }
            }
        }
        this.f17912bR.clear();
    }

    public void add(T t, Looper looper) {
        if (!this.f17911bQ.containsKey(t)) {
            if (looper != null) {
                this.f17911bQ.put(t, looper);
            } else {
                this.f17911bQ.put(t, new Object());
            }
        }
    }

    public void doNotify() {
        if (!isLocked()) {
            m5612e();
        }
    }

    public boolean event(E e) {
        return this.f17912bR.add(e);
    }

    public boolean isLocked() {
        return this.f17910bP > 0;
    }

    public void lock() {
        this.f17910bP++;
    }

    protected abstract void processEvent(T t, E e);

    public void remove(T t) {
        this.f17911bQ.remove(t);
    }

    public void removeAll() {
        this.f17911bQ.clear();
    }

    public void unlock() {
        this.f17910bP--;
        if (this.f17910bP <= 0) {
            this.f17910bP = 0;
            m5612e();
        }
    }
}
