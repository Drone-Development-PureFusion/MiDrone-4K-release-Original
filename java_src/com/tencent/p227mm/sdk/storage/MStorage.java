package com.tencent.p227mm.sdk.storage;

import android.os.Looper;
import org.p318d.AbstractC5756f;
/* renamed from: com.tencent.mm.sdk.storage.MStorage */
/* loaded from: classes2.dex */
public abstract class MStorage {

    /* renamed from: bM */
    private final MStorageEvent<IOnStorageChange, String> f17906bM = new MStorageEvent<IOnStorageChange, String>() { // from class: com.tencent.mm.sdk.storage.MStorage.1
        @Override // com.tencent.p227mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(IOnStorageChange iOnStorageChange, String str) {
            MStorage mStorage = MStorage.this;
            iOnStorageChange.onNotifyChange(str);
        }
    };

    /* renamed from: bN */
    private final MStorageEvent<IOnStorageLoaded, String> f17907bN = new MStorageEvent<IOnStorageLoaded, String>() { // from class: com.tencent.mm.sdk.storage.MStorage.2
        @Override // com.tencent.p227mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(IOnStorageLoaded iOnStorageLoaded, String str) {
            MStorage mStorage = MStorage.this;
            iOnStorageLoaded.onNotifyLoaded();
        }
    };

    /* renamed from: com.tencent.mm.sdk.storage.MStorage$IOnStorageChange */
    /* loaded from: classes2.dex */
    public interface IOnStorageChange {
        void onNotifyChange(String str);
    }

    /* renamed from: com.tencent.mm.sdk.storage.MStorage$IOnStorageLoaded */
    /* loaded from: classes2.dex */
    public interface IOnStorageLoaded {
        void onNotifyLoaded();
    }

    public void add(IOnStorageChange iOnStorageChange) {
        this.f17906bM.add(iOnStorageChange, Looper.getMainLooper());
    }

    public void addLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.f17907bN.add(iOnStorageLoaded, Looper.getMainLooper());
    }

    public void doNotify() {
        this.f17906bM.event(AbstractC5756f.f23062a);
        this.f17906bM.doNotify();
    }

    public void doNotify(String str) {
        this.f17906bM.event(str);
        this.f17906bM.doNotify();
    }

    public void lock() {
        this.f17906bM.lock();
    }

    public void remove(IOnStorageChange iOnStorageChange) {
        this.f17906bM.remove(iOnStorageChange);
    }

    public void removeLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.f17907bN.remove(iOnStorageLoaded);
    }

    public void unlock() {
        this.f17906bM.unlock();
    }
}
