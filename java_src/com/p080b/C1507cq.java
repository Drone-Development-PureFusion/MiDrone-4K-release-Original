package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cq */
/* loaded from: classes.dex */
public final class C1507cq extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1507cq(C1486by c1486by) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (!intent.getAction().equals("android.location.GPS_FIX_CHANGE")) {
                    return;
                }
                C1486by.f5252b = false;
            } catch (Exception e) {
            }
        }
    }
}
