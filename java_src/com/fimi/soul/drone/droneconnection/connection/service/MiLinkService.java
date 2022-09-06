package com.fimi.soul.drone.droneconnection.connection.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2777a;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2803f;
import com.fimi.soul.drone.droneconnection.connection.C2807h;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class MiLinkService extends Service {

    /* renamed from: a */
    private static final String f10402a = MiLinkService.class.getSimpleName();

    /* renamed from: b */
    private final BinderC2812a f10403b = new BinderC2812a(this);

    /* renamed from: c */
    private AbstractC2777a f10404c;

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.service.MiLinkService$a */
    /* loaded from: classes.dex */
    public static class BinderC2812a extends Binder {

        /* renamed from: a */
        private final WeakReference<MiLinkService> f10405a;

        BinderC2812a(MiLinkService miLinkService) {
            this.f10405a = new WeakReference<>(miLinkService);
        }

        /* renamed from: a */
        public int m10908a() {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null) {
                return 0;
            }
            return miLinkService.f10404c.i();
        }

        /* renamed from: a */
        public void m10907a(C2770c c2770c) {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null || miLinkService.f10404c == null || miLinkService.f10404c.i() == 0) {
                return;
            }
            miLinkService.f10404c.a(c2770c);
        }

        /* renamed from: a */
        public void m10906a(String str) {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null || miLinkService.f10404c == null) {
                return;
            }
            miLinkService.f10404c.a(str);
        }

        /* renamed from: a */
        public void m10905a(String str, AbstractC2803f abstractC2803f) {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null || miLinkService.f10404c == null) {
                return;
            }
            miLinkService.f10404c.a(str, abstractC2803f);
        }

        /* renamed from: a */
        public void m10904a(boolean z) {
            if (this.f10405a.get().f10404c != null) {
                this.f10405a.get().f10404c.m11030a(z);
            }
        }

        /* renamed from: a */
        public void m10903a(byte[] bArr) {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null || miLinkService.f10404c == null || miLinkService.f10404c.i() == 0) {
                return;
            }
            miLinkService.f10404c.c(bArr);
        }

        /* renamed from: b */
        public void m10902b() {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null) {
                return;
            }
            miLinkService.m10913a();
        }

        /* renamed from: b */
        public void m10901b(boolean z) {
            if (this.f10405a.get().f10404c != null) {
                this.f10405a.get().f10404c.m11029b(z);
            }
        }

        /* renamed from: c */
        public void m10900c() {
            MiLinkService miLinkService = this.f10405a.get();
            if (miLinkService == null) {
                return;
            }
            miLinkService.stopSelf();
            miLinkService.m10911b();
        }

        /* renamed from: d */
        public boolean m10899d() {
            if (this.f10405a.get().f10404c != null) {
                return this.f10405a.get().f10404c.m11028c();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10913a() {
        C2807h.EnumC2809a valueOf = C2807h.EnumC2809a.valueOf(C2778a.m11027a());
        if (this.f10404c == null || this.f10404c.j() != valueOf.m10917a()) {
            this.f10404c = valueOf.mo10915a(this);
        }
        if (this.f10404c != null) {
            try {
                this.f10404c.mo10934e();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f10404c.i() != 2) {
            this.f10404c.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10911b() {
        Log.d(f10402a, "Pre disconnect");
        if (this.f10404c == null || this.f10404c.i() == 0) {
            return;
        }
        this.f10404c.h();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10403b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m10911b();
    }
}
