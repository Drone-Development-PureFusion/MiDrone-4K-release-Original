package com.fimi.soul.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.p185n.C2602v;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.droneconnection.connection.C2804g;
import com.fimi.soul.drone.droneconnection.connection.service.C2813a;
import com.fimi.soul.drone.p191b.C2673a;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.utils.C3679h;
import com.fimi.soul.utils.NetUtil;
import com.tencent.p227mm.sdk.platformtools.SystemProperty;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class DroidPlannerApp extends ErrorReportApp implements C2804g.AbstractC2806b {

    /* renamed from: e */
    static DroidPlannerApp f7890e = null;

    /* renamed from: f */
    public static boolean f7891f = false;

    /* renamed from: k */
    private static HashMap f7892k = new HashMap();

    /* renamed from: l */
    private static final int f7893l = 10;

    /* renamed from: m */
    private static final int f7894m = 3000;

    /* renamed from: a */
    public C2657a f7895a;

    /* renamed from: b */
    public C2673a f7896b;

    /* renamed from: d */
    public C2813a f7898d;

    /* renamed from: c */
    public boolean f7897c = true;

    /* renamed from: h */
    private C2277v f7900h = null;

    /* renamed from: i */
    private List<Activity> f7901i = new LinkedList();

    /* renamed from: j */
    private List<Activity> f7902j = new ArrayList();

    /* renamed from: g */
    Handler f7899g = new Handler() { // from class: com.fimi.soul.base.DroidPlannerApp.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10) {
                DroidPlannerApp.this.f7895a.mo11220a(C2678d.EnumC2679a.DISCONNECTVIDEO);
            }
        }
    };

    /* renamed from: c */
    public static HashMap<String, String> m12522c() {
        return f7892k;
    }

    /* renamed from: g */
    public static Context m12520g() {
        return f7890e;
    }

    /* renamed from: h */
    public static DroidPlannerApp m12519h() {
        return f7890e;
    }

    /* renamed from: i */
    private void m12518i() {
        boolean equals = "1".equals(SystemProperty.getProperty("ro.kernel.qemu"));
        ApplicationInfo applicationInfo = getApplicationInfo();
        int i = applicationInfo.flags & 2;
        applicationInfo.flags = i;
        if (i != 0 || Debug.isDebuggerConnected() || equals) {
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: j */
    private void m12517j() {
        new C2602v(m12520g()).m11567a();
    }

    /* renamed from: k */
    private boolean m12516k() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        String packageName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m12526a() {
        if (this.f7902j == null || this.f7902j.size() <= 0) {
            return;
        }
        for (Activity activity : this.f7902j) {
            activity.finish();
        }
        this.f7902j.clear();
    }

    /* renamed from: a */
    public void m12525a(Activity activity) {
        this.f7902j.add(activity);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2806b
    /* renamed from: a */
    public void mo10922a(AbstractC2769b abstractC2769b) {
        this.f7896b.m11247a(abstractC2769b);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2806b
    /* renamed from: a */
    public void mo10921a(boolean z) {
        boolean z2 = true;
        if (z != this.f7895a.mo11216ac()) {
            if (!z || this.f7895a.mo11216ac()) {
                if (!z && this.f7895a.mo11216ac()) {
                    this.f7899g.sendEmptyMessageDelayed(10, 3000L);
                }
            } else if (this.f7899g.hasMessages(10)) {
                this.f7899g.removeMessages(10);
            }
            C2657a c2657a = this.f7895a;
            if (!z && this.f7895a.mo11230Q().m10447a() <= 5) {
                z2 = false;
            }
            c2657a.m11303b(z2);
            if (!z) {
                return;
            }
            C2462a.m12098a().m12093a(this.f7895a);
        }
    }

    /* renamed from: b */
    public void m12524b() {
        if (this.f7901i == null || this.f7901i.size() <= 0) {
            return;
        }
        this.f7901i.clear();
    }

    /* renamed from: b */
    public void m12523b(Activity activity) {
        this.f7901i.add(activity);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2806b
    /* renamed from: b */
    public void mo10920b(boolean z) {
        this.f7895a.m11335a(z);
        if (!z) {
            this.f7895a.m11303b(false);
            this.f7895a.m11322aj();
            this.f7895a.mo11220a(C2678d.EnumC2679a.CLEANALLOBJ);
        }
    }

    /* renamed from: d */
    public void m12521d() {
        try {
            for (Activity activity : this.f7901i) {
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2806b
    /* renamed from: e */
    public void mo10919e() {
        this.f7895a.mo11220a(C2678d.EnumC2679a.CONNECTSUCESS);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2806b
    /* renamed from: f */
    public void mo10918f() {
        this.f7895a.mo11230Q().m10446a((byte) 0);
        this.f7895a.m11303b(false);
        this.f7895a.m11322aj();
        this.f7895a.mo11220a(C2678d.EnumC2679a.CLEANALLOBJ);
    }

    @Override // com.fimi.soul.base.ErrorReportApp, com.fimi.kernel.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        C3679h.m7485a(this);
        f7890e = this;
        this.f7898d = new C2813a(this, this);
        NetUtil.m7770a();
        this.f7900h = C2277v.m12784a(this);
        this.f7895a = new C2657a(this.f7898d, this, new Handler());
        this.f7896b = new C2673a(this.f7895a, m12520g());
        if (m12516k() && this.f7900h.m12787a().contains("isfirstloading")) {
            MiPushClient.registerPush(this, "2882303761517328945", C2353b.f7959q);
        }
        Logger.setLogger(this, new LoggerInterface() { // from class: com.fimi.soul.base.DroidPlannerApp.1
            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public void log(String str) {
                Log.d(C2353b.f7946d, str);
            }

            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public void log(String str, Throwable th) {
                Log.d(C2353b.f7946d, str, th);
            }

            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public void setTag(String str) {
            }
        });
        m12517j();
        C2379b.m12409a(this);
        C3630aa.m7745a();
    }

    @Override // com.fimi.kernel.BaseApplication, android.app.Application
    public void onTerminate() {
        super.onTerminate();
        C3630aa.m7739b();
    }
}
