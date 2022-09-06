package com.fimi.x1bh.p212a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.p139b.AbstractC2084a;
import com.fimi.p139b.p141b.EnumC2090a;
import com.fimi.p139b.p142c.AbstractC2095c;
import com.fimi.p154i.C2158a;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.p210a.C3579a;
import java.util.List;
/* renamed from: com.fimi.x1bh.a.a */
/* loaded from: classes.dex */
public class C3885a extends AbstractC2084a {

    /* renamed from: d */
    C2158a f16537d;

    /* renamed from: g */
    private Context f16540g;

    /* renamed from: h */
    private C2657a f16541h;

    /* renamed from: i */
    private C2367d f16542i;

    /* renamed from: o */
    private AbstractC2095c f16548o;

    /* renamed from: j */
    private List<FirmwareInfo> f16543j = null;

    /* renamed from: k */
    private float f16544k = 0.0f;

    /* renamed from: l */
    private final int f16545l = 600;

    /* renamed from: m */
    private final int f16546m = 10;

    /* renamed from: n */
    private final int f16547n = 1;

    /* renamed from: p */
    private EnumC2090a f16549p = EnumC2090a.FLIGHT;

    /* renamed from: e */
    Runnable f16538e = new Runnable() { // from class: com.fimi.x1bh.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            C3885a.m6671a(C3885a.this);
            Message obtainMessage = C3885a.this.f16539f.obtainMessage();
            obtainMessage.obj = Float.valueOf(C3885a.this.f16544k);
            obtainMessage.what = 1;
            C3885a.this.f16539f.sendMessage(obtainMessage);
        }
    };

    /* renamed from: f */
    Handler f16539f = new Handler() { // from class: com.fimi.x1bh.a.a.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            float floatValue = message.obj != null ? ((Float) message.obj).floatValue() : 0.0f;
            C3885a.this.f16548o.mo8603a(floatValue);
            if (floatValue == 590.0f) {
                C3885a.this.f16537d.m13387a();
                if (!C3885a.this.m6657h()) {
                    C3885a.this.f16539f.postDelayed(C3885a.this.f16538e, 10L);
                } else {
                    C3885a.this.f16548o.mo8602a(C3885a.this.f16549p);
                }
            } else if (floatValue < 600.0f) {
                if (C3885a.this.f16544k <= 0.0f) {
                    return;
                }
                C3885a.this.f16539f.postDelayed(C3885a.this.f16538e, 10L);
            } else {
                C3885a.this.f16539f.removeCallbacks(C3885a.this.f16538e);
                if (!C3885a.this.f6967b) {
                    C3885a.this.f16548o.mo8602a(C3885a.this.f16549p);
                    return;
                }
                C3885a.this.f6968c.m12787a().edit().putBoolean(C3885a.this.f6966a, true).commit();
                C3885a.this.f16549p = EnumC2090a.SETTING;
                C3885a.this.f16548o.mo8602a(C3885a.this.f16549p);
            }
        }
    };

    public C3885a(Context context, AbstractC2095c abstractC2095c) {
        super(context, abstractC2095c);
        this.f16540g = context;
        this.f16548o = abstractC2095c;
        mo6672a();
    }

    /* renamed from: a */
    static /* synthetic */ float m6671a(C3885a c3885a) {
        float f = c3885a.f16544k;
        c3885a.f16544k = 1.0f + f;
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m6657h() {
        new StringBuffer();
        List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
        if (m7962e != null && m7962e.size() > 0) {
            C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) m7962e);
            this.f16539f.removeCallbacks(this.f16538e);
            this.f16549p = EnumC2090a.FIND_ONLINE_FIRMWARE;
            return true;
        }
        this.f16543j = C3579a.m7971a().m7963d();
        if (this.f16543j == null || this.f16543j.size() <= 0) {
            return false;
        }
        C2241c.m13122a().mo13115a("upgrade_firmwares", (List) this.f16543j);
        this.f16539f.removeCallbacks(this.f16538e);
        this.f16549p = EnumC2090a.FIND_NEW_FIRMWARE;
        return true;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: a */
    public void mo6672a() {
        super.m13740a(this.f16540g);
        mo6655j_();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: b */
    public void mo6669b() {
        this.f16539f.postDelayed(this.f16538e, 200L);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: c */
    public void mo6667c() {
        this.f16539f.removeMessages(1);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: d */
    public void mo6665d() {
        this.f16539f.removeCallbacks(this.f16538e);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: e */
    public void mo6663e() {
        this.f16539f.removeMessages(1);
        this.f16539f.removeCallbacks(this.f16538e);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: f */
    public void mo6661f() {
        if (this.f16544k > 0.0f) {
            this.f16539f.postDelayed(this.f16538e, 10L);
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2093a
    /* renamed from: g */
    public void mo6659g() {
        this.f16537d.m13383b();
    }

    @Override // com.fimi.p139b.AbstractC2084a
    /* renamed from: j_ */
    public void mo6655j_() {
        this.f16541h = ((DroidPlannerApp) DroidPlannerApp.m12520g()).f7895a;
        this.f16537d = new C2158a();
    }
}
