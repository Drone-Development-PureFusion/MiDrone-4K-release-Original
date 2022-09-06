package com.p080b;

import android.net.wifi.WifiManager;
import java.util.TimerTask;
/* renamed from: com.b.cn */
/* loaded from: classes.dex */
final class C1504cn extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C1503cm f5376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1504cn(C1503cm c1503cm) {
        this.f5376a = c1503cm;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        WifiManager wifiManager;
        WifiManager wifiManager2;
        try {
            if (!C1499ci.f5339b) {
                return;
            }
            wifiManager = this.f5376a.f5375a.f5355i;
            if (wifiManager == null) {
                return;
            }
            C1499ci c1499ci = this.f5376a.f5375a;
            wifiManager2 = this.f5376a.f5375a.f5355i;
            C1499ci.m15833a(wifiManager2);
        } catch (Exception e) {
        }
    }
}
