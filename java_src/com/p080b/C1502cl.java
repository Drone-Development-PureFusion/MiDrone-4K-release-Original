package com.p080b;

import android.location.GpsStatus;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cl */
/* loaded from: classes.dex */
public final class C1502cl implements GpsStatus.NmeaListener {

    /* renamed from: a */
    private /* synthetic */ C1499ci f5374a;

    private C1502cl(C1499ci c1499ci) {
        this.f5374a = c1499ci;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1502cl(C1499ci c1499ci, byte b) {
        this(c1499ci);
    }

    @Override // android.location.GpsStatus.NmeaListener
    public final void onNmeaReceived(long j, String str) {
        try {
            this.f5374a.f5363q = j;
            this.f5374a.f5364r = str;
        } catch (Exception e) {
        }
    }
}
