package com.tencent.map.p226b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.tencent.map.b.g */
/* loaded from: classes.dex */
public final class C4252g {

    /* renamed from: a */
    private Context f17684a = null;

    /* renamed from: b */
    private WifiManager f17685b = null;

    /* renamed from: c */
    private C4254a f17686c = null;

    /* renamed from: d */
    private Handler f17687d = null;

    /* renamed from: e */
    private Runnable f17688e = new Runnable() { // from class: com.tencent.map.b.g.1
        @Override // java.lang.Runnable
        public final void run() {
            C4252g.m5712a(C4252g.this);
        }
    };

    /* renamed from: f */
    private int f17689f = 1;

    /* renamed from: g */
    private AbstractC4256c f17690g = null;

    /* renamed from: h */
    private C4255b f17691h = null;

    /* renamed from: i */
    private boolean f17692i = false;

    /* renamed from: j */
    private byte[] f17693j = new byte[0];

    /* renamed from: com.tencent.map.b.g$a */
    /* loaded from: classes.dex */
    public class C4254a extends BroadcastReceiver {

        /* renamed from: a */
        private int f17695a = 4;

        /* renamed from: b */
        private List<ScanResult> f17696b = null;

        /* renamed from: c */
        private boolean f17697c = false;

        public C4254a() {
        }

        /* renamed from: a */
        private void m5704a(List<ScanResult> list) {
            if (list == null) {
                return;
            }
            if (!this.f17697c) {
                if (this.f17696b == null) {
                    this.f17696b = new ArrayList();
                } else {
                    this.f17696b.clear();
                }
                for (ScanResult scanResult : list) {
                    this.f17696b.add(scanResult);
                }
                return;
            }
            if (this.f17696b == null) {
                this.f17696b = new ArrayList();
            }
            int size = this.f17696b.size();
            for (ScanResult scanResult2 : list) {
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (this.f17696b.get(i).BSSID.equals(scanResult2.BSSID)) {
                        this.f17696b.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
                this.f17696b.add(scanResult2);
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                this.f17695a = intent.getIntExtra("wifi_state", 4);
                if (C4252g.this.f17690g != null) {
                    C4252g.this.f17690g.mo5701b(this.f17695a);
                }
            }
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS") || intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                List<ScanResult> list = null;
                if (C4252g.this.f17685b != null) {
                    list = C4252g.this.f17685b.getScanResults();
                }
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    if (list == null) {
                        return;
                    }
                    if (list != null && list.size() == 0) {
                        return;
                    }
                }
                if (!this.f17697c && this.f17696b != null && this.f17696b.size() >= 4 && list != null && list.size() <= 2) {
                    m5704a(list);
                    this.f17697c = true;
                    C4252g.this.m5714a(0L);
                    return;
                }
                m5704a(list);
                this.f17697c = false;
                C4252g.this.f17691h = new C4255b(C4252g.this, this.f17696b, System.currentTimeMillis(), this.f17695a);
                if (C4252g.this.f17690g != null) {
                    C4252g.this.f17690g.mo5702a(C4252g.this.f17691h);
                }
                C4252g.this.m5714a(C4252g.this.f17689f * 20000);
            }
        }
    }

    /* renamed from: com.tencent.map.b.g$b */
    /* loaded from: classes.dex */
    public class C4255b implements Cloneable {

        /* renamed from: a */
        private List<ScanResult> f17699a;

        public C4255b(C4252g c4252g, List<ScanResult> list, long j, int i) {
            this.f17699a = null;
            if (list != null) {
                this.f17699a = new ArrayList();
                for (ScanResult scanResult : list) {
                    this.f17699a.add(scanResult);
                }
            }
        }

        /* renamed from: a */
        public final List<ScanResult> m5703a() {
            return this.f17699a;
        }

        public final Object clone() {
            C4255b c4255b;
            try {
                c4255b = (C4255b) super.clone();
            } catch (Exception e) {
                c4255b = null;
            }
            if (this.f17699a != null) {
                c4255b.f17699a = new ArrayList();
                c4255b.f17699a.addAll(this.f17699a);
            }
            return c4255b;
        }
    }

    /* renamed from: com.tencent.map.b.g$c */
    /* loaded from: classes.dex */
    public interface AbstractC4256c {
        /* renamed from: a */
        void mo5702a(C4255b c4255b);

        /* renamed from: b */
        void mo5701b(int i);
    }

    /* renamed from: a */
    static /* synthetic */ void m5712a(C4252g c4252g) {
        if (c4252g.f17685b == null || !c4252g.f17685b.isWifiEnabled()) {
            return;
        }
        c4252g.f17685b.startScan();
    }

    /* renamed from: a */
    public final void m5715a() {
        synchronized (this.f17693j) {
            if (!this.f17692i) {
                return;
            }
            if (this.f17684a == null || this.f17686c == null) {
                return;
            }
            try {
                this.f17684a.unregisterReceiver(this.f17686c);
            } catch (Exception e) {
            }
            this.f17687d.removeCallbacks(this.f17688e);
            this.f17692i = false;
        }
    }

    /* renamed from: a */
    public final void m5714a(long j) {
        if (this.f17687d == null || !this.f17692i) {
            return;
        }
        this.f17687d.removeCallbacks(this.f17688e);
        this.f17687d.postDelayed(this.f17688e, j);
    }

    /* renamed from: a */
    public final boolean m5713a(Context context, AbstractC4256c abstractC4256c, int i) {
        synchronized (this.f17693j) {
            if (this.f17692i) {
                return true;
            }
            if (context == null || abstractC4256c == null) {
                return false;
            }
            this.f17687d = new Handler(Looper.getMainLooper());
            this.f17684a = context;
            this.f17690g = abstractC4256c;
            this.f17689f = 1;
            try {
                this.f17685b = (WifiManager) this.f17684a.getSystemService("wifi");
                IntentFilter intentFilter = new IntentFilter();
                this.f17686c = new C4254a();
                if (this.f17685b == null || this.f17686c == null) {
                    return false;
                }
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                this.f17684a.registerReceiver(this.f17686c, intentFilter);
                m5714a(0L);
                this.f17692i = true;
                return this.f17692i;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final boolean m5710b() {
        return this.f17692i;
    }

    /* renamed from: c */
    public final boolean m5708c() {
        if (this.f17684a == null || this.f17685b == null) {
            return false;
        }
        return this.f17685b.isWifiEnabled();
    }
}
