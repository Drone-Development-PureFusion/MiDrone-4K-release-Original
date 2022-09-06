package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.network.b */
/* loaded from: classes.dex */
public class C4553b extends Fallback {

    /* renamed from: i */
    Fallback f18706i;

    /* renamed from: j */
    final /* synthetic */ Fallback f18707j;

    /* renamed from: k */
    final /* synthetic */ HostManager f18708k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4553b(HostManager hostManager, String str, Fallback fallback) {
        super(str);
        this.f18708k = hostManager;
        this.f18707j = fallback;
        this.f18706i = this.f18707j;
        this.f18686b = this.f18686b;
        if (this.f18707j != null) {
            this.f18690f = this.f18707j.f18690f;
        }
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: a */
    public synchronized ArrayList<String> mo4737a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f18706i != null) {
            arrayList.addAll(this.f18706i.mo4737a(true));
        }
        synchronized (HostManager.mReservedHosts) {
            ArrayList<String> arrayList2 = HostManager.mReservedHosts.get(this.f18686b);
            if (arrayList2 != null) {
                ArrayList<String> mo4737a = this.f18706i != null ? this.f18706i.mo4737a(false) : arrayList;
                Iterator<String> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (mo4737a.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f18686b);
                arrayList.add(this.f18686b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: a */
    public synchronized void mo4738a(String str, AccessHistory accessHistory) {
        if (this.f18706i != null) {
            this.f18706i.mo4738a(str, accessHistory);
        }
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: b */
    public boolean mo4736b() {
        return false;
    }
}
