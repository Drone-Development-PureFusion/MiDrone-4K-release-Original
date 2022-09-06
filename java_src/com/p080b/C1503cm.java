package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cm */
/* loaded from: classes.dex */
public final class C1503cm extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C1499ci f5375a;

    private C1503cm(C1499ci c1499ci) {
        this.f5375a = c1499ci;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1503cm(C1499ci c1499ci, byte b) {
        this(c1499ci);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        WifiManager wifiManager;
        Timer timer;
        List list;
        WifiManager wifiManager2;
        List list2;
        Timer timer2;
        Timer timer3;
        int i;
        Timer timer4;
        List list3;
        if (context == null || intent == null) {
            return;
        }
        try {
            wifiManager = this.f5375a.f5355i;
            if (wifiManager == null) {
                return;
            }
            timer = this.f5375a.f5347F;
            if (timer == null) {
                return;
            }
            list = this.f5375a.f5346E;
            if (list == null || intent.getAction() == null || !"android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                return;
            }
            wifiManager2 = this.f5375a.f5355i;
            List<ScanResult> scanResults = wifiManager2.getScanResults();
            synchronized (this) {
                list2 = this.f5375a.f5346E;
                list2.clear();
                this.f5375a.f5370x = System.currentTimeMillis();
                if (scanResults != null && scanResults.size() > 0) {
                    for (int i2 = 0; i2 < scanResults.size(); i2++) {
                        list3 = this.f5375a.f5346E;
                        list3.add(scanResults.get(i2));
                    }
                }
            }
            C1504cn c1504cn = new C1504cn(this);
            synchronized (this) {
                timer2 = this.f5375a.f5347F;
                if (timer2 != null) {
                    timer4 = this.f5375a.f5347F;
                    timer4.cancel();
                    this.f5375a.f5347F = null;
                }
                this.f5375a.f5347F = new Timer();
                timer3 = this.f5375a.f5347F;
                i = C1499ci.f5336I;
                timer3.schedule(c1504cn, i);
            }
        } catch (Exception e) {
        }
    }
}
