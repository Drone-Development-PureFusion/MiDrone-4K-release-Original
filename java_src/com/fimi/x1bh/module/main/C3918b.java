package com.fimi.x1bh.module.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.p139b.C2092c;
import com.fimi.p139b.C2114g;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.module.flyplannermedia.DroneMediaTabActivity;
import com.fimi.soul.module.p206a.View$OnClickListenerC3047e;
import com.fimi.soul.utils.C3658ar;
import com.fimi.x1bh.module.main.AbstractC3916a;
import com.fimi.x1bh.module.setting.CloudTerraceSettingActivity;
import com.fimi.x1bh.p213b.AbstractC3895b;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.x1bh.module.main.b */
/* loaded from: classes.dex */
public class C3918b implements AbstractC2388f<X11RespCmd>, AbstractC3916a {

    /* renamed from: l */
    private static final int f16709l = 5;

    /* renamed from: m */
    private static final int f16710m = 7;

    /* renamed from: n */
    private static final int f16711n = 5000;

    /* renamed from: o */
    private static final String f16712o = "CloudTerraceMainInterac";

    /* renamed from: a */
    long f16713a;

    /* renamed from: b */
    private AbstractC3916a.AbstractC3917a f16714b;

    /* renamed from: c */
    private AbstractC3895b f16715c;

    /* renamed from: d */
    private boolean f16716d;

    /* renamed from: f */
    private Context f16718f;

    /* renamed from: j */
    private View$OnClickListenerC3047e f16722j;

    /* renamed from: p */
    private C2205c f16724p;

    /* renamed from: e */
    private boolean f16717e = false;

    /* renamed from: k */
    private HandlerC3921b f16723k = new HandlerC3921b();

    /* renamed from: g */
    private C2114g f16719g = new C2114g();

    /* renamed from: h */
    private C2092c f16720h = new C2092c();

    /* renamed from: i */
    private C2423d f16721i = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: q */
    private EnumC3920a f16725q = EnumC3920a.IDLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.main.b$a */
    /* loaded from: classes.dex */
    public enum EnumC3920a {
        VF,
        IDLE,
        RECORD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.main.b$b */
    /* loaded from: classes.dex */
    public class HandlerC3921b extends Handler {
        private HandlerC3921b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 5:
                    C3918b.this.m6519m();
                    return;
                case 6:
                default:
                    return;
                case 7:
                    if (C3918b.this.f16714b == null) {
                        return;
                    }
                    C3918b.this.f16714b.mo6550d();
                    return;
            }
        }
    }

    public C3918b(Context context, AbstractC3916a.AbstractC3917a abstractC3917a) {
        this.f16714b = abstractC3917a;
        this.f16718f = context;
    }

    /* renamed from: a */
    private static String m6542a(long j, boolean z) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j3 / 60;
        long j5 = j3 - (60 * j4);
        long j6 = j2 - (j3 * 60);
        StringBuilder sb = new StringBuilder();
        if (j4 > 0) {
            if (j4 < 10) {
                sb.append('0');
            }
            sb.append(j4);
            sb.append(C0359h.f671A);
        } else {
            sb.append('0');
            sb.append('0');
            sb.append(C0359h.f671A);
        }
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
        sb.append(C0359h.f671A);
        if (j6 < 10) {
            sb.append('0');
        }
        sb.append(j6);
        if (z) {
            sb.append(C0359h.f677G);
            long j7 = (j - (j2 * 1000)) / 10;
            if (j7 < 10) {
                sb.append('0');
            }
            sb.append(j7);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m6543a(long j) {
        this.f16713a = SystemClock.uptimeMillis() - (1000 * j);
    }

    /* renamed from: a */
    private void m6541a(X11RespCmd x11RespCmd) {
        if (!C2427e.f8333ce.equals(x11RespCmd.getType())) {
            if (!C2427e.f8334cf.equals(x11RespCmd.getType())) {
                return;
            }
            this.f16714b.mo6546e(x11RespCmd.getParam().toString().replace("EV", "").replace(" ", ""));
            return;
        }
        if (C2427e.f8209aL.equals(x11RespCmd.getCard_status())) {
            this.f16721i.b(false);
        } else {
            this.f16721i.b(true);
        }
        m6537a(x11RespCmd.getCard_status());
        if (C2427e.f8328cY.equals(x11RespCmd.getCam_status())) {
            if (this.f16725q == EnumC3920a.RECORD) {
                return;
            }
            this.f16721i.m12229y().m12243m();
            return;
        }
        if (this.f16725q == EnumC3920a.RECORD) {
            this.f16723k.removeMessages(5);
            this.f16714b.mo6553b(false);
        }
        this.f16725q = EnumC3920a.VF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m6519m() {
        this.f16725q = EnumC3920a.RECORD;
        this.f16714b.mo6549d(m6542a(SystemClock.uptimeMillis() - this.f16713a, false));
        this.f16723k.sendEmptyMessageDelayed(5, 1000L);
    }

    /* renamed from: n */
    private void m6518n() {
        this.f16721i.m12233u().m12296b();
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: a */
    public void mo6544a() {
        if (this.f16717e) {
            this.f16714b.mo6552c();
        } else {
            this.f16714b.mo6554b();
        }
        this.f16717e = !this.f16717e;
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: a */
    public void mo6540a(AbstractC3895b abstractC3895b) {
        this.f16715c = abstractC3895b;
    }

    /* renamed from: a */
    public void m6538a(Class<?> cls) {
        this.f16718f.startActivity(new Intent(this.f16718f, cls));
        ((Activity) this.f16718f).overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: a */
    public void m6537a(String str) {
        if (this.f16714b != null) {
            this.f16714b.mo6545f(str);
        }
    }

    /* renamed from: a */
    public void m6536a(boolean z) {
        this.f16717e = true;
        this.f16723k.removeMessages(7);
        if (!z) {
            C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.record_fail), C2284z.f7606b);
            this.f16714b.mo6553b(false);
            return;
        }
        C3658ar.m7570l(this.f16718f);
        C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.record_start), C2284z.f7606b);
        m6543a(0L);
        m6519m();
        this.f16714b.mo6553b(true);
        if (this.f16724p == null) {
            this.f16724p = C2205c.m13235a(C2238c.m13131a());
        }
        this.f16724p.m13225d();
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        switch (x11RespCmd.getMsg_id()) {
            case 1:
                if (!z || !"ae_bias".equals(x11RespCmd.getType().toString())) {
                    return;
                }
                this.f16714b.mo6546e(x11RespCmd.getParam().toString().replace("EV", "").replace(" ", ""));
                return;
            case 2:
                m6531b(z, x11RespCmd);
                return;
            case 3:
                m6531b(z, x11RespCmd);
                m6537a(this.f16721i.j().getSDState());
                this.f16721i.m12229y().m12243m();
                this.f16721i.m12233u().m12300a("ae_bias");
                return;
            case 7:
                m6541a(x11RespCmd);
                return;
            case C2427e.f8179I /* 513 */:
                m6536a(z);
                return;
            case 514:
                m6532b(z);
                return;
            case C2427e.f8181K /* 515 */:
                if (x11RespCmd.getParam() == null) {
                    return;
                }
                long parseLong = Long.parseLong(x11RespCmd.getParam().toString());
                if (parseLong == 0) {
                    return;
                }
                this.f16723k.removeMessages(5);
                m6543a(parseLong);
                m6519m();
                return;
            case C2427e.f8183M /* 769 */:
                m6529c(z);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: b */
    public void mo6534b() {
        m6520l();
        this.f16723k.sendEmptyMessageDelayed(7, 5000L);
    }

    /* renamed from: b */
    public void m6532b(boolean z) {
        this.f16717e = true;
        this.f16723k.removeMessages(7);
        if (!z) {
            C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.record_stop_fail), C2284z.f7606b);
            return;
        }
        C3658ar.m7571k(this.f16718f);
        C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.record_end), C2284z.f7606b);
        this.f16723k.removeMessages(5);
        this.f16714b.mo6553b(false);
        this.f16725q = EnumC3920a.IDLE;
        if (this.f16724p == null) {
            this.f16724p = C2205c.m13235a(C2238c.m13131a());
        }
        this.f16724p.m13224e();
    }

    /* renamed from: b */
    public void m6531b(boolean z, X11RespCmd x11RespCmd) {
        if (!z || !"ae_bias".equals(x11RespCmd.getType())) {
            return;
        }
        m6518n();
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: c */
    public void mo6530c() {
        m6521k();
        this.f16723k.sendEmptyMessageDelayed(7, 5000L);
    }

    /* renamed from: c */
    public void m6529c(boolean z) {
        this.f16723k.removeMessages(7);
        if (this.f16714b != null) {
            this.f16714b.mo6547e();
        }
        if (this.f16725q == EnumC3920a.RECORD) {
            if (!z) {
                this.f16714b.mo6548d(false);
                return;
            }
            C3658ar.m7569m(this.f16718f);
            C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.capture_success), C2284z.f7606b);
            this.f16714b.mo6548d(true);
        } else if (!z) {
            C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.take_photo_false), C2284z.f7606b);
            this.f16714b.mo6551c(false);
        } else {
            C3658ar.m7569m(this.f16718f);
            C2284z.m12694a(this.f16718f, this.f16718f.getString(C2300R.C2303string.take_photo_success), C2284z.f7606b);
            this.f16714b.mo6551c(true);
        }
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: d */
    public void mo6528d() {
        this.f16715c.mo6632f();
        m6538a(DroneMediaTabActivity.class);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: e */
    public void mo6527e() {
        m6538a(CloudTerraceSettingActivity.class);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: f */
    public void mo6526f() {
        String videoResolution;
        if (this.f16725q != EnumC3920a.RECORD || (videoResolution = this.f16721i.j().getVideoResolution()) == null || "".equals(videoResolution) || C2427e.f8338cj.contains(videoResolution) || C2427e.f8342cn.contains(videoResolution) || C2427e.f8343co.contains(videoResolution)) {
            return;
        }
        m6521k();
        this.f16723k.sendEmptyMessageDelayed(7, 5000L);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: g */
    public void mo6525g() {
        m6518n();
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: h */
    public void mo6524h() {
        this.f16723k.removeMessages(5);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a
    /* renamed from: i */
    public void mo6523i() {
        this.f16716d = false;
    }

    /* renamed from: j */
    public void m6522j() {
        this.f16721i.a(this);
    }

    /* renamed from: k */
    public void m6521k() {
        this.f16721i.m12229y().mo12251c();
    }

    /* renamed from: l */
    public void m6520l() {
        if (this.f16725q == EnumC3920a.RECORD) {
            this.f16721i.m12229y().mo12247g();
        } else {
            this.f16721i.m12229y().mo12248f();
        }
    }
}
