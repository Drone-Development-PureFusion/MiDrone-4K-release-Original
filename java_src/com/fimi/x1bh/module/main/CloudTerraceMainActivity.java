package com.fimi.x1bh.module.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p147d.AbstractC2118a;
import com.fimi.p148e.p149a.C2122a;
import com.fimi.p148e.p149a.C2123b;
import com.fimi.p151f.C2145d;
import com.fimi.p152g.C2148b;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.view.StrokeTextView;
import com.fimi.x1bh.module.X1bhBaseActivity;
import com.fimi.x1bh.module.main.AbstractC3916a;
import com.fimi.x1bh.module.main.CloudBatteryVoltageView;
import com.fimi.x1bh.p213b.C3893a;
/* loaded from: classes.dex */
public class CloudTerraceMainActivity extends X1bhBaseActivity implements View.OnClickListener, AbstractC3916a.AbstractC3917a {

    /* renamed from: v */
    private static final int f16680v = 3;

    /* renamed from: w */
    private static final int f16681w = 4;

    /* renamed from: x */
    private static final String f16682x = "CloudTerraceMainActivit";

    /* renamed from: b */
    private View f16684b;

    /* renamed from: c */
    private ImageButton f16685c;

    /* renamed from: d */
    private ImageButton f16686d;

    /* renamed from: e */
    private ImageButton f16687e;

    /* renamed from: f */
    private ImageButton f16688f;

    /* renamed from: g */
    private RelativeLayout f16689g;

    /* renamed from: h */
    private ImageView f16690h;

    /* renamed from: i */
    private StrokeTextView f16691i;

    /* renamed from: j */
    private StrokeTextView f16692j;

    /* renamed from: k */
    private StrokeTextView f16693k;

    /* renamed from: l */
    private StrokeTextView f16694l;

    /* renamed from: m */
    private CloudBatteryVoltageView f16695m;

    /* renamed from: n */
    private ImageView f16696n;

    /* renamed from: o */
    private C2122a f16697o;

    /* renamed from: p */
    private C2123b f16698p;

    /* renamed from: q */
    private AbstractC3916a f16699q;

    /* renamed from: r */
    private Toast f16700r;

    /* renamed from: s */
    private boolean f16701s;

    /* renamed from: t */
    private C3893a f16702t;

    /* renamed from: u */
    private boolean f16703u = false;

    /* renamed from: a */
    Handler f16683a = new Handler() { // from class: com.fimi.x1bh.module.main.CloudTerraceMainActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 3) {
                CloudTerraceMainActivity.this.f16697o = (C2122a) message.obj;
                byte m13605k = CloudTerraceMainActivity.this.f16697o.m13605k();
                CloudTerraceMainActivity.this.f16695m.setPercent(m13605k);
                if (m13605k >= 30) {
                    CloudTerraceMainActivity.this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.NOMAL);
                } else if (m13605k > 30 || m13605k <= 15) {
                    CloudTerraceMainActivity.this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.LOW);
                } else {
                    CloudTerraceMainActivity.this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.SERIOUS_LOW);
                }
            } else if (message.what != 4) {
            } else {
                CloudTerraceMainActivity.this.f16698p = (C2123b) message.obj;
                if (CloudTerraceMainActivity.this.f16698p.m13595k() == 0) {
                    CloudTerraceMainActivity.this.f16696n.setVisibility(8);
                } else {
                    CloudTerraceMainActivity.this.f16696n.setVisibility(0);
                }
                if (CloudTerraceMainActivity.this.f16698p.m13593m() == -1) {
                    CloudTerraceMainActivity.this.f16692j.setText("");
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 0) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_0);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 1) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_1);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 2) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_2);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 3) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_3);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 4) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_4);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 5) {
                    CloudTerraceMainActivity.this.f16692j.setText("");
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 6) {
                    CloudTerraceMainActivity.this.f16692j.setText("");
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 7) {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_7);
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() == 8) {
                    CloudTerraceMainActivity.this.f16692j.setText("");
                } else if (CloudTerraceMainActivity.this.f16698p.m13593m() != 9) {
                } else {
                    CloudTerraceMainActivity.this.f16692j.setText(C2300R.C2303string.cloud_cloud_error_9);
                }
            }
        }
    };

    /* renamed from: y */
    private AbstractC2118a f16704y = new AbstractC2118a() { // from class: com.fimi.x1bh.module.main.CloudTerraceMainActivity.2
        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: a */
        public void mo6477a(String str) {
        }

        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: b */
        public void mo6446b(String str) {
        }

        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: c */
        public void mo6556c(String str) {
        }
    };

    /* renamed from: z */
    private AbstractC2118a f16705z = new AbstractC2118a() { // from class: com.fimi.x1bh.module.main.CloudTerraceMainActivity.3
        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: a */
        public void mo6477a(String str) {
        }

        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: b */
        public void mo6446b(String str) {
        }

        @Override // com.fimi.p147d.AbstractC2118a
        /* renamed from: c */
        public void mo6556c(String str) {
        }
    };

    /* renamed from: g */
    private void m6561g(String str) {
        if (C2427e.f8209aL.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_remove_error));
        } else if (C2427e.f8210aM.equals(str)) {
            this.f16691i.setText("");
        } else if (C2427e.f8213aP.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_io_error));
        } else if (C2427e.f8219aV.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_io_error));
        } else if (C2427e.f8217aT.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_low_speed_error));
        } else if (C2427e.f8218aU.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_low_speed_error));
        } else if (C2427e.f8215aR.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_low_speed_error));
        } else if (C2427e.f8216aS.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_low_speed_error));
        } else if (C2427e.f8220aW.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.cloud_main_tf_will_runout));
        } else if (C2427e.f8206aI.equals(str)) {
            this.f16691i.setText(getString(C2300R.C2303string.tf_low_speed_error));
        } else if (!C2427e.f8204aG.equals(str)) {
        } else {
            this.f16691i.setText(getString(C2300R.C2303string.tf_full_error));
        }
    }

    /* renamed from: i */
    private void m6559i() {
        this.f16699q = new C3918b(this, this);
        m6562g();
    }

    /* renamed from: j */
    private void m6558j() {
        this.f16684b = findViewById(C2300R.C2302id.bg_view);
        this.f16688f = (ImageButton) findViewById(C2300R.C2302id.ibtn_thumbnail);
        this.f16685c = (ImageButton) findViewById(C2300R.C2302id.btn_switch_mode);
        this.f16686d = (ImageButton) findViewById(C2300R.C2302id.btn_shutter_camera);
        this.f16687e = (ImageButton) findViewById(C2300R.C2302id.btn_shutter_record);
        this.f16690h = (ImageView) findViewById(C2300R.C2302id.setting_iv);
        this.f16691i = (StrokeTextView) findViewById(C2300R.C2302id.tv_camera_tf_card);
        this.f16692j = (StrokeTextView) findViewById(C2300R.C2302id.tv_cloud_error);
        this.f16693k = (StrokeTextView) findViewById(C2300R.C2302id.record_time_tv);
        this.f16695m = (CloudBatteryVoltageView) findViewById(C2300R.C2302id.cloud_battery_voltage_view);
        this.f16696n = (ImageView) findViewById(C2300R.C2302id.handle_lock_iv);
        this.f16696n.setVisibility(8);
        this.f16694l = (StrokeTextView) findViewById(C2300R.C2302id.tv_camera_ev);
        this.f16689g = (RelativeLayout) findViewById(C2300R.C2302id.rl_capture);
        this.f16685c.setOnClickListener(this);
        this.f16686d.setOnClickListener(this);
        this.f16687e.setOnClickListener(this);
        this.f16688f.setOnClickListener(this);
        this.f16690h.setOnClickListener(this);
        this.f16689g.setOnClickListener(this);
    }

    /* renamed from: k */
    private void m6557k() {
        if (this.f16701s) {
            m6563f();
            this.f16700r.cancel();
            finish();
            Process.killProcess(Process.myPid());
            return;
        }
        this.f16701s = true;
        this.f16700r = Toast.makeText(getApplicationContext(), (int) C2300R.C2303string.again_exit, 0);
        this.f16700r.show();
        getHandler().sendEmptyMessageDelayed(0, 2000L);
    }

    /* renamed from: a */
    public void m6572a() {
        View findViewById = findViewById(C2300R.C2302id.view_camera);
        this.f16702t = new C3893a();
        this.f16702t.m6639a(this, findViewById);
        this.f16702t.m6638b();
        this.f16699q.mo6540a(this.f16702t);
        this.f16694l.setText(getString(C2300R.C2303string.cloud_main_ev_show) + "0.0");
    }

    /* renamed from: a */
    public void m6571a(int i) {
        if (i >= 30) {
            this.f16695m.setPercent(i);
            this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.NOMAL);
        } else if (i >= 30 || i < 15) {
            this.f16695m.setPercent(i);
            this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.SERIOUS_LOW);
        } else {
            this.f16695m.setPercent(i);
            this.f16695m.m6573a(CloudBatteryVoltageView.EnumC3912a.LOW);
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
        super.mo6481a(i, c2104c);
        switch (i) {
            case 65:
                AbstractC2103b m13702g = c2104c.m13702g();
                if (!(m13702g instanceof C2122a)) {
                    return;
                }
                this.f16683a.obtainMessage(3, (C2122a) m13702g).sendToTarget();
                return;
            case 125:
                AbstractC2103b m13702g2 = c2104c.m13702g();
                if (!(m13702g2 instanceof C2123b)) {
                    return;
                }
                this.f16683a.obtainMessage(4, (C2123b) m13702g2).sendToTarget();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: a */
    public void mo6477a(String str) {
        super.mo6477a(str);
        if (this.f16699q != null) {
            this.f16699q.mo6525g();
        }
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: a */
    public void mo6555a(boolean z) {
        if (z) {
            return;
        }
        this.f16691i.setVisibility(0);
        this.f16691i.setText(getString(C2300R.C2303string.tf_remove_error));
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: b */
    public void mo6554b() {
        this.f16703u = true;
        this.f16685c.setImageResource(C2300R.C2301drawable.cloud_select_record_selector);
        this.f16687e.setVisibility(0);
        this.f16686d.setVisibility(8);
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
        super.mo6446b(str);
        if (this.f16699q != null) {
            this.f16699q.mo6524h();
        }
        this.f16695m.setPercent(0);
        this.f16693k.setVisibility(8);
        this.f16688f.setVisibility(0);
        this.f16685c.setVisibility(0);
        this.f16690h.setVisibility(0);
        this.f16684b.setBackgroundResource(C2300R.color.main_menu_bg);
        this.f16694l.setText("");
        this.f16692j.setText("");
        if (!this.f16703u) {
            this.f16687e.setVisibility(8);
            this.f16686d.setVisibility(0);
            return;
        }
        this.f16687e.setVisibility(0);
        this.f16686d.setVisibility(8);
        this.f16687e.setBackgroundResource(C2300R.C2301drawable.btn_shutter_recorded);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: b */
    public void mo6553b(boolean z) {
        this.f16703u = true;
        getViewManager().mo12676c();
        this.f16685c.setImageResource(C2300R.C2301drawable.cloud_select_record_selector);
        this.f16687e.setVisibility(0);
        this.f16686d.setVisibility(8);
        this.f16687e.setEnabled(true);
        this.f16686d.setEnabled(true);
        this.f16689g.setEnabled(true);
        if (z) {
            this.f16687e.setBackgroundResource(C2300R.C2301drawable.btn_shutter_recording);
            this.f16684b.setBackgroundResource(C2300R.color.fcsensor);
            this.f16693k.setVisibility(0);
            this.f16688f.setVisibility(4);
            this.f16685c.setVisibility(4);
            this.f16690h.setVisibility(4);
            return;
        }
        this.f16687e.setBackgroundResource(C2300R.C2301drawable.btn_shutter_recorded);
        this.f16684b.setBackgroundResource(C2300R.color.main_menu_bg);
        this.f16693k.setVisibility(8);
        this.f16688f.setVisibility(0);
        this.f16685c.setVisibility(0);
        this.f16690h.setVisibility(0);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: c */
    public void mo6552c() {
        this.f16703u = false;
        this.f16685c.setImageResource(C2300R.C2301drawable.cloud_select_take_photo_selector);
        this.f16687e.setVisibility(8);
        this.f16686d.setVisibility(0);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: c */
    public void mo6551c(boolean z) {
        this.f16703u = false;
        this.f16689g.setEnabled(true);
        this.f16687e.setVisibility(8);
        this.f16686d.setVisibility(0);
        this.f16685c.setImageResource(C2300R.C2301drawable.cloud_select_take_photo_selector);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: d */
    public void mo6550d() {
        getViewManager().mo12676c();
        this.f16687e.setEnabled(true);
        this.f16686d.setEnabled(true);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: d */
    public void mo6549d(String str) {
        this.f16693k.setText(str);
        this.f16685c.setImageResource(C2300R.C2301drawable.cloud_select_take_photo_selector);
        this.f16687e.setVisibility(0);
        this.f16686d.setVisibility(8);
        this.f16687e.setEnabled(true);
        this.f16686d.setEnabled(true);
        this.f16687e.setBackgroundResource(C2300R.C2301drawable.btn_shutter_recording);
        this.f16684b.setBackgroundResource(C2300R.color.fcsensor);
        this.f16693k.setVisibility(0);
        this.f16688f.setVisibility(4);
        this.f16685c.setVisibility(4);
        this.f16690h.setVisibility(4);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: d */
    public void mo6548d(boolean z) {
        this.f16689g.setEnabled(true);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: e */
    public void mo6547e() {
        getViewManager().mo12676c();
        this.f16687e.setEnabled(true);
        this.f16686d.setEnabled(true);
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: e */
    public void mo6546e(String str) {
        if (this.f16694l.getText().toString().equals(str)) {
            return;
        }
        this.f16694l.setText(getString(C2300R.C2303string.cloud_main_ev_show) + str);
    }

    /* renamed from: f */
    public void m6563f() {
        C2148b.m13440a().m13437b();
        C2145d.m13447b().m13443e();
    }

    @Override // com.fimi.x1bh.module.main.AbstractC3916a.AbstractC3917a
    /* renamed from: f */
    public void mo6545f(String str) {
        m6561g(str);
    }

    /* renamed from: g */
    public void m6562g() {
        C2145d.m13447b().m13451a(this.f16704y);
    }

    /* renamed from: h */
    public void m6560h() {
        if (!"off".equals("")) {
            C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
            if (!c2423d.e() || C2277v.m12784a(C2238c.m13131a()).m12742s() != DeviceType.DEVICE_4K) {
                return;
            }
            c2423d.m12233u().m12298a("menu_album", "off");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.btn_switch_mode) {
            this.f16699q.mo6544a();
        } else if (view.getId() == C2300R.C2302id.btn_shutter_camera) {
            if (!((C2423d) C2379b.m12410a().m12394d()).s()) {
                C2284z.m12696a(this, (int) C2300R.C2303string.no_connect_camera, 3000);
                return;
            }
            this.f16699q.mo6530c();
            this.f16686d.setEnabled(false);
            getViewManager().mo12687a();
        } else if (view.getId() == C2300R.C2302id.btn_shutter_record) {
            if (!((C2423d) C2379b.m12410a().m12394d()).s()) {
                C2284z.m12696a(this, (int) C2300R.C2303string.no_connect_camera, 3000);
                return;
            }
            this.f16699q.mo6534b();
            this.f16687e.setEnabled(false);
            getViewManager().mo12687a();
        } else if (view.getId() == C2300R.C2302id.ibtn_thumbnail) {
            this.f16699q.mo6528d();
        } else if (view.getId() == C2300R.C2302id.setting_iv) {
            this.f16699q.mo6527e();
        } else if (view.getId() != C2300R.C2302id.rl_capture) {
        } else {
            this.f16689g.setEnabled(false);
            this.f16699q.mo6526f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_cloud_terrace_main);
        this.dpa.m12521d();
        this.dpa.m12523b(this);
        m6558j();
        m6559i();
        m6572a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f16702t != null) {
            this.f16702t.m6640a();
        }
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        this.f16701s = false;
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            m6557k();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((C3918b) this.f16699q).m6522j();
        this.f16699q.mo6525g();
    }

    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f16702t != null) {
            Log.d(f16682x, "onStart: ");
            this.f16702t.m6634d();
        }
    }
}
