package com.fimi.soul.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2276u;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.biz.p188q.C2624a;
import com.fimi.soul.biz.update.AbstractC2636b;
import com.fimi.soul.biz.update.AbstractC2651g;
import com.fimi.soul.biz.update.AbstractC2653i;
import com.fimi.soul.biz.update.C2629a;
import com.fimi.soul.biz.update.C2638c;
import com.fimi.soul.biz.update.C2639d;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.receiver.SpeekSignReceiver;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.FlyLogTools;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class InitAppService extends Service {

    /* renamed from: a */
    public static final String f14690a = "sp_down_firmware";

    /* renamed from: b */
    private volatile int f14691b = 0;

    /* renamed from: c */
    private C2629a f14692c = new C2629a();

    /* renamed from: d */
    private C2638c f14693d = new C2638c();

    /* renamed from: e */
    private C2639d f14694e = new C2639d();

    /* renamed from: f */
    private AbstractC2651g f14695f;

    /* renamed from: g */
    private AbstractC2653i<UpdateVersonBean> f14696g;

    /* renamed from: h */
    private AbstractC2651g f14697h;

    /* renamed from: i */
    private SpeekSignReceiver f14698i;

    /* renamed from: j */
    private C2624a f14699j;

    /* renamed from: k */
    private AbstractC2651g f14700k;

    /* renamed from: com.fimi.soul.service.InitAppService$a */
    /* loaded from: classes.dex */
    public class BinderC3610a extends Binder {
        public BinderC3610a() {
        }

        /* renamed from: a */
        public InitAppService m7810a() {
            return InitAppService.this;
        }
    }

    /* renamed from: a */
    public static void m7829a(Activity activity) {
        if (!m7830a()) {
            return;
        }
        activity.startService(new Intent(activity, InitAppService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7827a(C2639d c2639d, final UpdateVersonBean updateVersonBean) {
        m7815f();
        updateVersonBean.getSysname();
        File file = new File(C3681j.m7457v());
        if (!file.exists()) {
            file.mkdir();
        }
        final String fileEncode = updateVersonBean.getFileEncode();
        String m11388e = c2639d.m11388e(updateVersonBean);
        File file2 = new File(m11388e);
        boolean z = false;
        if (file2.exists()) {
            String m12789a = C2276u.m12789a(file2);
            if (!C2269n.m12889b(fileEncode) && fileEncode.equals(m12789a)) {
                z = true;
                if (updateVersonBean.getSysid() == 24) {
                    C2277v.m12784a(getBaseContext()).m12765e(fileEncode);
                }
            }
        }
        if (!z) {
            c2639d.m11395b(updateVersonBean, m11388e, new AbstractC2651g() { // from class: com.fimi.soul.service.InitAppService.3
                @Override // com.fimi.soul.biz.update.AbstractC2651g
                /* renamed from: a */
                public void mo6430a(boolean z2, long j, long j2, int i) {
                    if (!z2) {
                        return;
                    }
                    if (updateVersonBean.getSysid() == 24) {
                        C2277v.m12784a(InitAppService.this.getBaseContext()).m12765e(fileEncode);
                    }
                    InitAppService.this.m7814g();
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m7830a() {
        return C2241c.m13122a().mo13108d("USER_PROTOCOL");
    }

    /* renamed from: f */
    private synchronized void m7815f() {
        this.f14691b++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m7814g() {
        this.f14691b--;
    }

    /* renamed from: h */
    private void m7813h() {
        if (C3658ar.m7593c(getBaseContext())) {
            if (m7819c()) {
                return;
            }
            m7817d();
        } else if (C3658ar.m7601b(getBaseContext())) {
            m7816e();
        } else {
            Log.d("Good", "没有网络");
        }
    }

    /* renamed from: i */
    private void m7812i() {
        final C2639d c2639d = new C2639d();
        c2639d.m11403a(new C2639d.AbstractC2648c() { // from class: com.fimi.soul.service.InitAppService.2
            @Override // com.fimi.soul.biz.update.C2639d.AbstractC2648c
            /* renamed from: a */
            public void mo7811a(List<UpdateVersonBean> list) {
                InitAppService.this.m7822a(list);
                if (list == null || list.size() < 1) {
                    return;
                }
                AbstractC2636b.f9127c = false;
                AbstractC2636b.f9126b = false;
                List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
                if (m7962e != null && m7962e.size() > 0) {
                    for (UpdateVersonBean updateVersonBean : m7962e) {
                        InitAppService.this.m7827a(c2639d, updateVersonBean);
                    }
                }
                InitAppService.this.m7828a(c2639d);
            }
        });
    }

    /* renamed from: a */
    public void m7828a(C2639d c2639d) {
        UpdateVersonBean m7960g = C3579a.m7971a().m7960g();
        if (m7960g != null) {
            m7827a(c2639d, m7960g);
        }
    }

    /* renamed from: a */
    public void m7826a(AbstractC2651g abstractC2651g) {
        this.f14700k = abstractC2651g;
    }

    /* renamed from: a */
    public void m7825a(AbstractC2653i<UpdateVersonBean> abstractC2653i) {
        this.f14696g = abstractC2653i;
    }

    /* renamed from: a */
    public void m7822a(List<UpdateVersonBean> list) {
        if (list == null || list.size() < 1) {
            C2238c.m13125c().mo13117a(f14690a, (Object) "");
        } else {
            C2238c.m13125c().mo13115a(f14690a, (List) list);
        }
    }

    /* renamed from: b */
    public void m7821b() {
        this.f14695f = null;
        this.f14696g = null;
        this.f14697h = null;
    }

    /* renamed from: b */
    public void m7820b(AbstractC2651g abstractC2651g) {
        this.f14697h = abstractC2651g;
    }

    /* renamed from: c */
    public void m7818c(AbstractC2651g abstractC2651g) {
        this.f14695f = abstractC2651g;
    }

    /* renamed from: c */
    public synchronized boolean m7819c() {
        return this.f14691b > 0;
    }

    /* renamed from: d */
    public synchronized void m7817d() {
        if (!m7819c() && C3658ar.m7593c(getBaseContext())) {
            m7812i();
        }
    }

    /* renamed from: e */
    public void m7816e() {
        this.f14694e.m11403a(new C2639d.AbstractC2648c() { // from class: com.fimi.soul.service.InitAppService.1
            @Override // com.fimi.soul.biz.update.C2639d.AbstractC2648c
            /* renamed from: a */
            public void mo7811a(List<UpdateVersonBean> list) {
                InitAppService.this.m7822a(list);
            }
        });
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BinderC3610a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14698i = new SpeekSignReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f14698i, intentFilter);
        this.f14699j = C2624a.m11460a(getBaseContext());
        this.f14699j.m11461a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f14698i != null) {
            unregisterReceiver(this.f14698i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        C2639d.m11383n();
        m7813h();
        FlyLogTools.m7776a(this).m7773a((FlyLogTools.AbstractC3620a) null);
        return super.onStartCommand(intent, i, i2);
    }
}
