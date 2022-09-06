package com.fimi.p152g;

import android.util.Log;
import com.fimi.p147d.AbstractC2118a;
import com.fimi.p151f.C2141c;
import com.fimi.p151f.C2145d;
import com.fimi.soul.entity.CameraValue;
import java.net.InetSocketAddress;
import java.net.Socket;
/* renamed from: com.fimi.g.a */
/* loaded from: classes.dex */
public class RunnableC2147a implements Runnable {

    /* renamed from: e */
    private static final String f7202e = "ConnectThread";

    /* renamed from: a */
    Socket f7203a;

    /* renamed from: b */
    private final String f7204b = "192.168.42.1";

    /* renamed from: c */
    private AbstractC2118a f7205c;

    /* renamed from: d */
    private boolean f7206d;

    public RunnableC2147a(AbstractC2118a abstractC2118a) {
        this.f7205c = abstractC2118a;
    }

    /* renamed from: a */
    public void m13442a() {
        this.f7206d = true;
    }

    /* renamed from: a */
    public boolean m13441a(String str) {
        boolean z = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ping -c 1 -W 1 " + str);
            if (process.waitFor() == 0) {
                z = true;
            }
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e) {
            if (process != null) {
                process.destroy();
            }
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.f7206d) {
            boolean m13441a = m13441a("192.168.42.1");
            Log.d(f7202e, "run: isAutoConnect:" + CameraValue.isAutoConnect + ",hasSession:" + CameraValue.hasSession);
            if (!m13441a || C2145d.m13447b().m13444d() || !CameraValue.isAutoConnect || !CameraValue.hasSession) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    this.f7206d = true;
                    e.printStackTrace();
                }
            } else {
                try {
                    this.f7203a = new Socket();
                    this.f7203a.connect(new InetSocketAddress("192.168.42.1", 12080), 5000);
                    C2141c c2141c = new C2141c(this.f7203a);
                    c2141c.mo13464a();
                    C2145d.m13447b().m13450a(c2141c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f7205c.mo6556c("Socket Exception" + e2.toString());
                }
            }
        }
    }
}
