package com.fimi.soul.drone.droneconnection.connection;

import android.util.Log;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p176e.C2440a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.b */
/* loaded from: classes.dex */
public class C2779b {

    /* renamed from: f */
    private static boolean f10295f = false;

    /* renamed from: g */
    private static boolean f10296g = false;

    /* renamed from: j */
    private static boolean f10297j = false;

    /* renamed from: i */
    private boolean f10304i;

    /* renamed from: h */
    private boolean f10303h = true;

    /* renamed from: k */
    private EnumC2782b f10305k = EnumC2782b.IDLE;

    /* renamed from: b */
    public DroidPlannerApp f10299b = DroidPlannerApp.m12519h();

    /* renamed from: a */
    public C2657a f10298a = this.f10299b.f7895a;

    /* renamed from: d */
    private C2367d f10301d = C2367d.m12459a();

    /* renamed from: e */
    private C2364c f10302e = C2364c.m12469a();

    /* renamed from: c */
    private C2440a f10300c = C2440a.m12171b();

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.b$a */
    /* loaded from: classes.dex */
    public class RunnableC2781a implements Runnable {
        public RunnableC2781a() {
        }

        public void a() {
            switch (C2779b.this.f10305k) {
                case IDLE:
                    C2779b.this.m11020a(" 中继心跳需要两秒钟1 ");
                    if (C2779b.this.f10300c.m12170c()) {
                        C2779b.this.f10305k = EnumC2782b.RELAYCONNECT;
                        return;
                    }
                    C2779b.this.m11020a(" 中继心跳需要两秒钟2 ");
                    if (C3658ar.m7587d(C2854c.m10763b())) {
                        C2779b.this.m11020a(" Wifi 已经连接");
                        C2779b.this.f10300c.m12173a();
                        C2779b.this.m11020a(" 中继心跳需要两秒钟 3");
                        C2779b.this.f10302e.m12466b();
                        C2779b.this.m11020a(" 中继心跳需要两秒钟 4");
                    }
                    C2779b.this.m11024a(3000);
                    return;
                case RELAYCONNECT:
                    if (C2779b.this.f10298a.mo11217ab().mo10898a()) {
                        C2779b.this.f10305k = EnumC2782b.RCCONNECTED;
                        return;
                    }
                    C2779b.this.m11007f();
                    C2779b.this.f10305k = EnumC2782b.HANDSHAKE;
                    return;
                case HANDSHAKE:
                    if (C2779b.m11018b()) {
                        C2779b.this.m11024a(3000);
                        return;
                    }
                    C2779b.this.m11024a(1500);
                    C2779b.this.f10305k = EnumC2782b.RCCONNECTED;
                    return;
                case RCCONNECTED:
                    C2779b.this.m11024a(3000);
                    if (C2779b.this.f10298a.mo11217ab().mo10898a()) {
                        return;
                    }
                    C2779b.this.f10305k = EnumC2782b.IDLE;
                    C2779b.this.f10300c.m12172a(false);
                    return;
                default:
                    return;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!C2779b.this.f10304i) {
                if (C2779b.m11015c()) {
                    C2779b.this.m11020a(" 连接界面在连接。。。。");
                    C2779b.this.m11024a(3000);
                } else if (C2779b.m11025a()) {
                    a();
                } else {
                    C2779b.this.m11020a(" ping run threadSleep 没有事情做---等待中");
                    C2779b.this.m11024a(3000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.drone.droneconnection.connection.b$b */
    /* loaded from: classes.dex */
    public enum EnumC2782b {
        IDLE,
        RELAYCONNECT,
        HANDSHAKE,
        RCCONNECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11024a(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m11020a("" + System.currentTimeMillis() + " DroidConnectProcess handshake=" + f10295f + " state=" + this.f10305k + " MavClient().isConnected()=" + this.f10298a.mo11217ab().mo10898a());
    }

    /* renamed from: a */
    public static synchronized void m11019a(boolean z) {
        synchronized (C2779b.class) {
            f10297j = z;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m11025a() {
        boolean z;
        synchronized (C2779b.class) {
            z = f10297j;
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized void m11016b(boolean z) {
        synchronized (C2779b.class) {
            f10295f = z;
        }
    }

    /* renamed from: b */
    public static synchronized boolean m11018b() {
        boolean z;
        synchronized (C2779b.class) {
            z = f10295f;
        }
        return z;
    }

    /* renamed from: c */
    public static synchronized void m11013c(boolean z) {
        synchronized (C2779b.class) {
            f10296g = z;
        }
    }

    /* renamed from: c */
    public static synchronized boolean m11015c() {
        boolean z;
        synchronized (C2779b.class) {
            z = f10296g;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m11007f() {
        m11016b(true);
        m11020a(" tryConnetDrone " + f10295f + " " + this.f10305k + " ");
        C2778a.m11026a(C2854c.f10616d);
        this.f10298a.mo11217ab().mo10891b();
    }

    /* renamed from: a */
    public void m11020a(String str) {
        if (this.f10303h) {
            Log.i("zdy", str);
        }
    }

    /* renamed from: d */
    public void m11012d() {
        m11009e();
        new Thread(new RunnableC2781a()).start();
    }

    /* renamed from: d */
    public void m11010d(boolean z) {
        this.f10304i = z;
    }

    /* renamed from: e */
    public void m11009e() {
        if (m11025a()) {
            if (this.f10300c.m12170c()) {
                this.f10305k = EnumC2782b.RELAYCONNECT;
            }
            if (this.f10305k != EnumC2782b.RELAYCONNECT || !this.f10298a.mo11216ac()) {
                return;
            }
            this.f10305k = EnumC2782b.RCCONNECTED;
        }
    }
}
