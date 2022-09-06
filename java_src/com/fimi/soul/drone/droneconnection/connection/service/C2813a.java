package com.fimi.soul.drone.droneconnection.connection.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2803f;
import com.fimi.soul.drone.droneconnection.connection.C2804g;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.droneconnection.connection.service.MiLinkService;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.service.a */
/* loaded from: classes.dex */
public class C2813a implements C2804g.AbstractC2805a {

    /* renamed from: a */
    private static final String f10406a = C2813a.class.getSimpleName();

    /* renamed from: b */
    private boolean f10407b;

    /* renamed from: c */
    private final Handler f10408c = new Handler();

    /* renamed from: d */
    private final AtomicReference<String> f10409d = new AtomicReference<>();

    /* renamed from: e */
    private final AbstractC2803f f10410e = new AbstractC2803f() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1

        /* renamed from: b */
        private final Runnable f10418b = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.1
            @Override // java.lang.Runnable
            public void run() {
                C2813a.this.f10413h.mo10919e();
            }
        };

        /* renamed from: c */
        private final Runnable f10419c = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.2
            @Override // java.lang.Runnable
            public void run() {
                C2813a.this.f10407b = false;
                C2813a.this.f10413h.mo10918f();
                C2813a.this.m10881g();
            }
        };

        /* renamed from: d */
        private final Runnable f10420d = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.3
            @Override // java.lang.Runnable
            public void run() {
                C2813a.this.f10408c.removeCallbacks(this);
                C2813a.this.f10407b = false;
                String str = (String) C2813a.this.f10409d.get();
                if (str != null) {
                    Log.e(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, str);
                }
            }
        };

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: a */
        public void mo10876a() {
            C2813a.this.f10408c.post(this.f10418b);
        }

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: a */
        public void mo10875a(final AbstractC2769b abstractC2769b) {
            C2813a.this.f10408c.post(new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.4
                @Override // java.lang.Runnable
                public void run() {
                    C2813a.this.f10407b = true;
                    C2813a.this.f10413h.mo10922a(abstractC2769b);
                }
            });
        }

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: a */
        public void mo10874a(String str) {
            C2813a.this.f10409d.set(str);
            C2813a.this.f10408c.post(this.f10420d);
        }

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: a */
        public void mo10873a(final boolean z) {
            C2813a.this.f10408c.post(new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.5
                @Override // java.lang.Runnable
                public void run() {
                    C2813a.this.f10413h.mo10921a(z);
                }
            });
        }

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: b */
        public void mo10872b() {
            C2813a.this.f10408c.post(this.f10419c);
        }

        @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2803f
        /* renamed from: b */
        public void mo10871b(final boolean z) {
            C2813a.this.f10408c.post(new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.1.6
                @Override // java.lang.Runnable
                public void run() {
                    C2813a.this.f10407b = z;
                    C2813a.this.f10413h.mo10920b(z);
                }
            });
        }
    };

    /* renamed from: f */
    private final ServiceConnection f10411f = new ServiceConnection() { // from class: com.fimi.soul.drone.droneconnection.connection.service.a.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2813a.this.f10414i = (MiLinkService.BinderC2812a) iBinder;
            C2813a.this.m10878j();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C2813a.this.m10877k();
        }
    };

    /* renamed from: g */
    private final Context f10412g;

    /* renamed from: h */
    private final C2804g.AbstractC2806b f10413h;

    /* renamed from: i */
    private MiLinkService.BinderC2812a f10414i;

    /* renamed from: j */
    private boolean f10415j;

    /* renamed from: k */
    private boolean f10416k;

    public C2813a(Context context, C2804g.AbstractC2806b abstractC2806b) {
        this.f10412g = context;
        this.f10413h = abstractC2806b;
    }

    /* renamed from: h */
    private void m10880h() {
        if (this.f10415j) {
            m10879i();
        } else {
            this.f10412g.bindService(new Intent(this.f10412g, MiLinkService.class), this.f10411f, 1);
        }
    }

    /* renamed from: i */
    private void m10879i() {
        this.f10414i.m10902b();
        this.f10414i.m10905a(f10406a, this.f10410e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10878j() {
        this.f10415j = true;
        m10879i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10877k() {
        this.f10407b = false;
        this.f10415j = false;
        this.f10413h.mo10918f();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: a */
    public void mo10897a(C2770c c2770c) {
        if (!mo10898a()) {
            return;
        }
        this.f10414i.m10907a(c2770c);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: a */
    public void mo10893a(boolean z) {
        this.f10414i.m10904a(z);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: a */
    public void mo10892a(byte[] bArr) {
        if (!mo10898a()) {
            return;
        }
        this.f10414i.m10903a(bArr);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: a */
    public boolean mo10898a() {
        return this.f10407b;
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: b */
    public void mo10891b() {
        if (mo10898a()) {
            m10881g();
        } else {
            m10880h();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: b */
    public void mo10889b(boolean z) {
        this.f10414i.m10901b(z);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: c */
    public void mo10888c() {
        if (mo10898a()) {
            this.f10413h.mo10919e();
        } else {
            this.f10413h.mo10918f();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: d */
    public void mo10886d() {
        m10881g();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: e */
    public String mo10884e() {
        return C2778a.m11027a();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.C2804g.AbstractC2805a
    /* renamed from: f */
    public boolean mo10882f() {
        return this.f10414i.m10899d();
    }

    /* renamed from: g */
    public void m10881g() {
        if (this.f10415j) {
            if (this.f10414i.m10908a() == 2) {
                this.f10414i.m10900c();
            }
            this.f10414i.m10906a(f10406a);
            try {
                this.f10412g.unbindService(this.f10411f);
            } catch (Exception e) {
            }
            m10877k();
        }
    }
}
