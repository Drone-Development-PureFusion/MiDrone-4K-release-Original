package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import com.fimi.soul.media.player.FimiMediaMeta;
import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.fimi.soul.biz.n.u */
/* loaded from: classes.dex */
public class C2599u implements Handler.Callback {

    /* renamed from: b */
    private static C2599u f8981b = null;

    /* renamed from: h */
    private static final int f8982h = 1;

    /* renamed from: a */
    private AbstractC2601a f8983a;

    /* renamed from: c */
    private long f8984c = 0;

    /* renamed from: d */
    private long f8985d = 0;

    /* renamed from: e */
    private Handler f8986e = new Handler(this);

    /* renamed from: f */
    private Context f8987f;

    /* renamed from: g */
    private Timer f8988g;

    /* renamed from: com.fimi.soul.biz.n.u$a */
    /* loaded from: classes.dex */
    public interface AbstractC2601a {
        /* renamed from: a */
        void mo9604a(String str, String str2);
    }

    public C2599u(Context context) {
        this.f8987f = null;
        this.f8987f = context;
    }

    /* renamed from: a */
    public static C2599u m11573a(Context context) {
        if (f8981b == null) {
            f8981b = new C2599u(context);
        }
        return f8981b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m11568c() {
        long j = 0;
        long totalRxBytes = TrafficStats.getUidRxBytes(this.f8987f.getApplicationInfo().uid) == -1 ? 0L : TrafficStats.getTotalRxBytes() / FimiMediaMeta.AV_CH_SIDE_RIGHT;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f8985d;
        if (j2 != 0) {
            j = (((totalRxBytes - this.f8984c) * 1000) / 8) / j2;
        }
        this.f8985d = currentTimeMillis;
        this.f8984c = totalRxBytes;
        return String.valueOf(j) + " KB/s";
    }

    /* renamed from: a */
    public void m11574a() {
        if (this.f8988g != null) {
            this.f8988g.cancel();
        }
    }

    /* renamed from: a */
    public void m11572a(AbstractC2601a abstractC2601a) {
        this.f8983a = abstractC2601a;
        this.f8984c = TrafficStats.getUidRxBytes(this.f8987f.getApplicationInfo().uid) == -1 ? 0L : TrafficStats.getTotalRxBytes() / FimiMediaMeta.AV_CH_SIDE_RIGHT;
        this.f8985d = System.currentTimeMillis();
        this.f8988g = new Timer();
        this.f8988g.schedule(new TimerTask() { // from class: com.fimi.soul.biz.n.u.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                String m11568c = C2599u.this.m11568c();
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = m11568c;
                C2599u.this.f8986e.sendMessage(obtain);
            }
        }, 1000L, 2000L);
    }

    /* renamed from: b */
    public String m11570b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8987f.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WiFi";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : subtypeName;
                }
            }
        }
        return "";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            this.f8983a.mo9604a((String) message.obj, m11570b());
            return false;
        }
        return false;
    }
}
