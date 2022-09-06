package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cp */
/* loaded from: classes.dex */
public final class C1506cp extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1506cp(C1486by c1486by) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    C1499ci.f5340c = false;
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                    C1499ci.f5340c = true;
                }
                if (!action.equals("android.intent.action.MEDIA_EJECT")) {
                    return;
                }
                C1499ci.f5340c = true;
            } catch (Exception e) {
            }
        }
    }
}
