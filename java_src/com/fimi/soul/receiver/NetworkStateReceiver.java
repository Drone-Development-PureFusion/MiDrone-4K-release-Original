package com.fimi.soul.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public abstract class NetworkStateReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static final String f14608a = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: com.fimi.soul.receiver.NetworkStateReceiver$a */
    /* loaded from: classes.dex */
    public enum EnumC3591a {
        Wifi,
        Mobile,
        None
    }

    /* renamed from: a */
    private boolean m7877a(NetworkInfo.State state) {
        return state != null && NetworkInfo.State.CONNECTED == state;
    }

    /* renamed from: a */
    public abstract void mo7774a(EnumC3591a enumC3591a, Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo.State state = connectivityManager.getNetworkInfo(1).getState();
            if (connectivityManager.getNetworkInfo(0) == null) {
                return;
            }
            NetworkInfo.State state2 = connectivityManager.getNetworkInfo(0).getState();
            if (m7877a(state)) {
                mo7774a(EnumC3591a.Wifi, context);
            } else if (m7877a(state2)) {
                mo7774a(EnumC3591a.Mobile, context);
            } else {
                mo7774a(EnumC3591a.None, context);
            }
        }
    }
}
