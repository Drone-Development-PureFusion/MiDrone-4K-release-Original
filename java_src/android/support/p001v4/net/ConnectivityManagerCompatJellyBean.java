package android.support.p001v4.net;

import android.net.ConnectivityManager;
/* renamed from: android.support.v4.net.ConnectivityManagerCompatJellyBean */
/* loaded from: classes.dex */
class ConnectivityManagerCompatJellyBean {
    ConnectivityManagerCompatJellyBean() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
