package com.fimi.soul.drone.p190a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3585g;
import java.util.List;
/* renamed from: com.fimi.soul.drone.a.a */
/* loaded from: classes.dex */
public class C2661a {

    /* renamed from: c */
    private Context f9302c;

    /* renamed from: d */
    private C2277v f9303d;

    /* renamed from: f */
    private boolean f9305f;

    /* renamed from: g */
    private C2657a f9306g;

    /* renamed from: h */
    private C2367d f9307h;

    /* renamed from: i */
    private C2423d f9308i;

    /* renamed from: j */
    private C3585g f9309j;

    /* renamed from: p */
    private AbstractC2665a f9315p;

    /* renamed from: e */
    private String f9304e = C2353b.f7918I;

    /* renamed from: k */
    private List<FirmwareInfo> f9310k = null;

    /* renamed from: l */
    private float f9311l = 0.0f;

    /* renamed from: m */
    private final int f9312m = 400;

    /* renamed from: n */
    private final int f9313n = 10;

    /* renamed from: o */
    private final int f9314o = 1;

    /* renamed from: q */
    private EnumC2666b f9316q = EnumC2666b.FLIGHT;

    /* renamed from: a */
    Runnable f9300a = new Runnable() { // from class: com.fimi.soul.drone.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            C2661a.m11284b(C2661a.this);
            Message obtainMessage = C2661a.this.f9301b.obtainMessage();
            obtainMessage.obj = Float.valueOf(C2661a.this.f9311l);
            obtainMessage.what = 1;
            C2661a.this.f9301b.sendMessage(obtainMessage);
        }
    };

    /* renamed from: b */
    Handler f9301b = new Handler() { // from class: com.fimi.soul.drone.a.a.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            float floatValue = message.obj != null ? ((Float) message.obj).floatValue() : 0.0f;
            C2661a.this.f9315p.m11269a(floatValue);
            if (!C2661a.this.f9306g.mo11217ab().mo10898a()) {
                C2661a.this.f9315p.m11267a(C2661a.this.f9302c.getString(C2300R.C2303string.disconnect_titlefaile), C2661a.this.f9302c.getString(C2300R.C2303string.disconnect_reson));
            } else if (!C2661a.this.f9306g.mo11216ac()) {
                C2661a.this.f9315p.m11267a(C2661a.this.f9302c.getString(C2300R.C2303string.unconnectdrone), C2661a.this.f9302c.getString(C2300R.C2303string.fc_tip_error));
            } else if (floatValue == 390.0f) {
                if (!C2661a.this.m11275g()) {
                    C2661a.this.f9301b.postDelayed(C2661a.this.f9300a, 10L);
                } else {
                    C2661a.this.f9315p.m11268a(C2661a.this.f9316q);
                }
            } else if (floatValue < 400.0f) {
                if (C2661a.this.f9311l <= 0.0f) {
                    return;
                }
                C2661a.this.f9301b.postDelayed(C2661a.this.f9300a, 10L);
            } else {
                C2661a.this.f9301b.removeCallbacks(C2661a.this.f9300a);
                if (!C2661a.this.f9305f) {
                    C2661a.this.f9315p.m11268a(C2661a.this.f9316q);
                    return;
                }
                C2661a.this.f9303d.m12787a().edit().putBoolean(C2661a.this.f9304e, true).commit();
                C2661a.this.f9316q = EnumC2666b.SETTING;
                C2661a.this.f9315p.m11268a(C2661a.this.f9316q);
            }
        }
    };

    /* renamed from: com.fimi.soul.drone.a.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC2665a {
        /* renamed from: a */
        void m11269a(float f);

        /* renamed from: a */
        void m11268a(EnumC2666b enumC2666b);

        /* renamed from: a */
        void m11267a(String str, String str2);
    }

    /* renamed from: com.fimi.soul.drone.a.a$b */
    /* loaded from: classes.dex */
    public enum EnumC2666b {
        FIND_ONLINE_FIRMWARE,
        FIND_NEW_FIRMWARE,
        FLIGHT,
        SETTING
    }

    public C2661a(Context context, AbstractC2665a abstractC2665a) {
        this.f9302c = context;
        this.f9315p = abstractC2665a;
        m11288a();
    }

    /* renamed from: b */
    static /* synthetic */ float m11284b(C2661a c2661a) {
        float f = c2661a.f9311l;
        c2661a.f9311l = 1.0f + f;
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m11275g() {
        new StringBuffer();
        List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
        if (m7962e != null && m7962e.size() > 0) {
            C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) m7962e);
            this.f9301b.removeCallbacks(this.f9300a);
            this.f9316q = EnumC2666b.FIND_ONLINE_FIRMWARE;
            return true;
        }
        this.f9310k = C3579a.m7971a().m7963d();
        if (this.f9310k == null || this.f9310k.size() <= 0) {
            return false;
        }
        C2241c.m13122a().mo13115a("upgrade_firmwares", (List) this.f9310k);
        this.f9301b.removeCallbacks(this.f9300a);
        this.f9316q = EnumC2666b.FIND_NEW_FIRMWARE;
        return true;
    }

    /* renamed from: a */
    public void m11288a() {
        this.f9303d = C2277v.m12784a(this.f9302c);
        this.f9304e = C2353b.f7918I;
        this.f9305f = C2238c.m13125c().mo13108d(C2353b.f7920K);
        C3579a.m7971a().m7964c();
        this.f9306g = ((DroidPlannerApp) DroidPlannerApp.m12520g()).f7895a;
        C2367d.m12459a().m12452b((String) null);
        C2364c.m12469a().m12464b((String) null);
        this.f9308i = (C2423d) C2379b.m12410a().m12394d();
        this.f9308i.m12231w().m12240b();
        if (this.f9308i.e()) {
            this.f9308i.m12233u().m12281k();
        }
        this.f9309j = new C3585g(this.f9302c, this.f9306g);
    }

    /* renamed from: b */
    public void m11285b() {
        new Thread(new Runnable() { // from class: com.fimi.soul.drone.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                for (int i = 0; i < 5; i++) {
                    C2661a.this.f9309j.m7887c();
                }
            }
        }).start();
        this.f9301b.postDelayed(this.f9300a, 200L);
    }

    /* renamed from: c */
    public void m11283c() {
        this.f9301b.removeMessages(1);
    }

    /* renamed from: d */
    public void m11281d() {
        this.f9309j.m7885e();
        this.f9301b.removeCallbacks(this.f9300a);
    }

    /* renamed from: e */
    public void m11279e() {
        this.f9301b.removeMessages(1);
        this.f9301b.removeCallbacks(this.f9300a);
    }

    /* renamed from: f */
    public void m11277f() {
        if (this.f9311l > 0.0f) {
            this.f9301b.postDelayed(this.f9300a, 10L);
        }
    }
}
