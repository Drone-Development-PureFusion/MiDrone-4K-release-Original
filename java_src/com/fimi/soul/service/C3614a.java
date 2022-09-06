package com.fimi.soul.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.service.CameraSocketService;
/* renamed from: com.fimi.soul.service.a */
/* loaded from: classes.dex */
public class C3614a {

    /* renamed from: a */
    private static CameraSocketService f14726a = null;

    /* renamed from: b */
    private static C3614a f14727b;

    /* renamed from: e */
    private static CameraSocketService.AbstractC3602h f14728e;

    /* renamed from: d */
    private Context f14730d;

    /* renamed from: c */
    private boolean f14729c = false;

    /* renamed from: f */
    private ServiceConnection f14731f = new ServiceConnection() { // from class: com.fimi.soul.service.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2353b.m12509a("onServiceConnected", CameraSocketService.class);
            CameraSocketService unused = C3614a.f14726a = ((CameraSocketService.BinderC3597c) iBinder).m7840a();
            C3614a.f14726a.m7874a(C3614a.f14728e);
            C3614a.f14726a.m7856e();
            if (C3614a.f14728e != null) {
                C3614a.f14728e.m7839a(1, true, "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C2353b.m12509a("onServiceDisconnected", CameraSocketService.class);
            CameraSocketService unused = C3614a.f14726a = null;
        }
    };

    public C3614a(Context context) {
        this.f14730d = context;
    }

    /* renamed from: a */
    public static C3614a m7796a(Context context) {
        if (f14727b == null) {
            f14727b = new C3614a(context);
        }
        if (f14726a == null) {
            f14727b.m7791c();
        } else if (!f14726a.m7852g()) {
            f14726a.m7856e();
        }
        return f14727b;
    }

    /* renamed from: a */
    public void m7797a() {
        if (f14726a != null) {
            f14726a.m7864b();
        }
    }

    /* renamed from: a */
    public void m7795a(CameraSocketService.AbstractC3602h abstractC3602h) {
        f14728e = abstractC3602h;
        if (f14726a != null) {
            f14726a.m7874a(f14728e);
        }
    }

    /* renamed from: a */
    public void m7793a(String str, String str2) {
        f14726a.m7866a(str, str2);
    }

    /* renamed from: b */
    public CameraSocketService.EnumC3596b m7792b() {
        return f14726a.m7860c();
    }

    /* renamed from: c */
    public synchronized void m7791c() {
        if (!this.f14729c) {
            this.f14729c = true;
            Intent intent = new Intent();
            intent.setClass(this.f14730d, CameraSocketService.class);
            this.f14730d.getApplicationContext().bindService(intent, this.f14731f, 1);
        }
    }

    /* renamed from: d */
    public synchronized void m7790d() {
        if (this.f14729c) {
            this.f14729c = false;
            new Intent().setClass(this.f14730d, CameraSocketService.class);
            this.f14730d.getApplicationContext().unbindService(this.f14731f);
            f14726a.m7858d();
            f14726a.onDestroy();
            f14726a = null;
            f14727b = null;
        }
    }

    /* renamed from: e */
    public void m7789e() {
        f14726a.m7876a();
    }

    /* renamed from: f */
    public String m7788f() {
        if (f14726a == null) {
            return null;
        }
        return f14726a.m7854f();
    }

    /* renamed from: g */
    public String m7787g() {
        StringBuffer stringBuffer = new StringBuffer();
        if (f14726a == null || !m7786h()) {
            return null;
        }
        stringBuffer.append("rtsp://");
        stringBuffer.append(f14726a.m7854f());
        stringBuffer.append("/media/stream1");
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public boolean m7786h() {
        if (f14726a == null) {
            return false;
        }
        return f14726a.m7852g();
    }

    /* renamed from: i */
    public void m7785i() {
        if (f14726a != null) {
            f14726a.m7856e();
        }
    }
}
