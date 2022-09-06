package com.fimi.soul.drone.p190a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.p139b.AbstractC2084a;
import com.fimi.p139b.p141b.EnumC2090a;
import com.fimi.p139b.p142c.AbstractC2095c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3585g;
import java.util.List;
/* renamed from: com.fimi.soul.drone.a.b */
/* loaded from: classes.dex */
public class C2667b extends AbstractC2084a {

    /* renamed from: f */
    private Context f9327f;

    /* renamed from: g */
    private C2657a f9328g;

    /* renamed from: h */
    private C2367d f9329h;

    /* renamed from: i */
    private C3585g f9330i;

    /* renamed from: o */
    private AbstractC2095c f9336o;

    /* renamed from: j */
    private List<FirmwareInfo> f9331j = null;

    /* renamed from: k */
    private float f9332k = 0.0f;

    /* renamed from: l */
    private final int f9333l = 400;

    /* renamed from: m */
    private final int f9334m = 10;

    /* renamed from: n */
    private final int f9335n = 1;

    /* renamed from: p */
    private EnumC2090a f9337p = EnumC2090a.FLIGHT;

    /* renamed from: d */
    Runnable f9325d = new Runnable() { // from class: com.fimi.soul.drone.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            C2667b.m11264b(C2667b.this);
            Message obtainMessage = C2667b.this.f9326e.obtainMessage();
            obtainMessage.obj = Float.valueOf(C2667b.this.f9332k);
            obtainMessage.what = 1;
            C2667b.this.f9326e.sendMessage(obtainMessage);
        }
    };

    /* renamed from: e */
    Handler f9326e = new Handler() { // from class: com.fimi.soul.drone.a.b.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            float floatValue = message.obj != null ? ((Float) message.obj).floatValue() : 0.0f;
            C2667b.this.f9336o.mo8603a(floatValue);
            if (!C2667b.this.f9328g.mo11217ab().mo10898a()) {
                C2667b.this.f9336o.mo8601a(C2667b.this.f9327f.getString(C2300R.C2303string.disconnect_titlefaile), C2667b.this.f9327f.getString(C2300R.C2303string.disconnect_reson));
            } else if (!C2667b.this.f9328g.mo11216ac()) {
                C2667b.this.f9336o.mo8601a(C2667b.this.f9327f.getString(C2300R.C2303string.unconnectdrone), C2667b.this.f9327f.getString(C2300R.C2303string.fc_tip_error));
            } else if (floatValue == 390.0f) {
                if (!C2667b.this.m11258h()) {
                    C2667b.this.f9326e.postDelayed(C2667b.this.f9325d, 10L);
                } else {
                    C2667b.this.f9336o.mo8602a(C2667b.this.f9337p);
                }
            } else if (floatValue < 400.0f) {
                if (C2667b.this.f9332k <= 0.0f) {
                    return;
                }
                C2667b.this.f9326e.postDelayed(C2667b.this.f9325d, 10L);
            } else {
                C2667b.this.f9326e.removeCallbacks(C2667b.this.f9325d);
                if (!C2667b.this.f6967b) {
                    C2667b.this.f9336o.mo8602a(C2667b.this.f9337p);
                    return;
                }
                C2667b.this.f6968c.m12787a().edit().putBoolean(C2667b.this.f6966a, true).commit();
                C2667b.this.f9337p = EnumC2090a.SETTING;
                C2667b.this.f9336o.mo8602a(C2667b.this.f9337p);
            }
        }
    };

    public C2667b(Context context, AbstractC2095c abstractC2095c) {
        super(context, abstractC2095c);
        this.f9327f = context;
        this.f9336o = abstractC2095c;
        mo6672a();
    }

    /* renamed from: b */
    static /* synthetic */ float m11264b(C2667b c2667b) {
        float f = c2667b.f9332k;
        c2667b.f9332k = 1.0f + f;
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m11258h() {
        new StringBuffer();
        List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
        if (m7962e != null && m7962e.size() > 0) {
            C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) m7962e);
            this.f9326e.removeCallbacks(this.f9325d);
            this.f9337p = EnumC2090a.FIND_ONLINE_FIRMWARE;
            return true;
        }
        this.f9331j = C3579a.m7971a().m7963d();
        if (this.f9331j == null || this.f9331j.size() <= 0) {
            return false;
        }
        C2241c.m13122a().mo13115a("upgrade_firmwares", (List) this.f9331j);
        this.f9326e.removeCallbacks(this.f9325d);
        this.f9337p = EnumC2090a.FIND_NEW_FIRMWARE;
        return true;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: a */
    public void mo6672a() {
        super.m13740a(this.f9327f);
        mo6655j_();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: b */
    public void mo6669b() {
        new Thread(new Runnable() { // from class: com.fimi.soul.drone.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                for (int i = 0; i < 5; i++) {
                    C2667b.this.f9330i.m7887c();
                }
            }
        }).start();
        this.f9326e.postDelayed(this.f9325d, 200L);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: c */
    public void mo6667c() {
        this.f9326e.removeMessages(1);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: d */
    public void mo6665d() {
        this.f9330i.m7885e();
        this.f9326e.removeCallbacks(this.f9325d);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: e */
    public void mo6663e() {
        this.f9326e.removeMessages(1);
        this.f9326e.removeCallbacks(this.f9325d);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: f */
    public void mo6661f() {
        if (this.f9332k > 0.0f) {
            this.f9326e.postDelayed(this.f9325d, 10L);
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: g */
    public void mo6659g() {
    }

    @Override // com.fimi.p139b.AbstractC2084a
    /* renamed from: j_ */
    public void mo6655j_() {
        this.f9328g = ((DroidPlannerApp) DroidPlannerApp.m12520g()).f7895a;
        this.f9330i = new C3585g(this.f9327f, this.f9328g);
    }
}
