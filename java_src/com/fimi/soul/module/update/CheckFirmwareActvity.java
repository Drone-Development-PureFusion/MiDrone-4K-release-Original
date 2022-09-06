package com.fimi.soul.module.update;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2355b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.calibcompass.CaliCompassActivity;
import com.fimi.soul.module.droneui.DialogC3297a;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.module.setting.newhand.NewHandActivity;
import com.fimi.soul.module.update.UpdateConnectDefeaFrgment;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3585g;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* loaded from: classes.dex */
public class CheckFirmwareActvity extends BaseActivity implements C2678d.AbstractC2680b, UpdateConnectDefeaFrgment.AbstractC3566a {

    /* renamed from: b */
    C2423d f14270b;

    /* renamed from: c */
    C3585g f14271c;

    /* renamed from: d */
    C2367d f14272d;

    /* renamed from: h */
    private ProgressView f14276h;

    /* renamed from: n */
    private UpdateConnectDefeaFrgment f14282n;

    /* renamed from: o */
    private AutoSelfErrorFrgment f14283o;

    /* renamed from: r */
    private TextView f14286r;

    /* renamed from: t */
    private DialogC3297a f14288t;

    /* renamed from: v */
    private C2657a f14290v;

    /* renamed from: x */
    private ProgressBar f14292x;

    /* renamed from: y */
    private boolean f14293y;

    /* renamed from: z */
    private C2277v f14294z;

    /* renamed from: i */
    private boolean f14277i = false;

    /* renamed from: j */
    private final int f14278j = 400;

    /* renamed from: k */
    private final int f14279k = 10;

    /* renamed from: l */
    private final int f14280l = 1;

    /* renamed from: m */
    private final int f14281m = 2;

    /* renamed from: p */
    private float f14284p = 0.0f;

    /* renamed from: q */
    private final int f14285q = 1536;

    /* renamed from: s */
    private boolean f14287s = false;

    /* renamed from: a */
    List<FirmwareInfo> f14269a = null;

    /* renamed from: u */
    private C2355b f14289u = null;

    /* renamed from: w */
    private boolean f14291w = false;

    /* renamed from: A */
    private String f14268A = C2353b.f7918I;

    /* renamed from: e */
    Handler f14273e = new Handler() { // from class: com.fimi.soul.module.update.CheckFirmwareActvity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            float floatValue = message.obj != null ? ((Float) message.obj).floatValue() : 0.0f;
            CheckFirmwareActvity.this.f14276h.setCurrentCount(floatValue);
            if (!CheckFirmwareActvity.this.f14290v.mo11217ab().mo10898a()) {
                CheckFirmwareActvity.this.m8091a(CheckFirmwareActvity.this.getString(C2300R.C2303string.disconnect_titlefaile), CheckFirmwareActvity.this.getString(C2300R.C2303string.disconnect_reson), false, false, false);
            } else if (!CheckFirmwareActvity.this.f14290v.mo11216ac()) {
                CheckFirmwareActvity.this.m8091a(CheckFirmwareActvity.this.getString(C2300R.C2303string.unconnectdrone), CheckFirmwareActvity.this.getString(C2300R.C2303string.fc_tip_error), false, false, false);
            } else if (floatValue == 390.0f) {
                if (CheckFirmwareActvity.this.m8090b()) {
                    return;
                }
                if (C2238c.m13125c().mo13108d(C2353b.f7960r)) {
                    CheckFirmwareActvity.this.f14273e.postDelayed(CheckFirmwareActvity.this.f14274f, 10L);
                    return;
                }
                CheckFirmwareActvity.this.f14273e.removeCallbacks(CheckFirmwareActvity.this.f14274f);
                CheckFirmwareActvity.this.startActivity(new Intent(CheckFirmwareActvity.this, NewHandActivity.class));
                CheckFirmwareActvity.this.finish();
                CheckFirmwareActvity.this.overridePendingTransition(17432576, 17432577);
            } else if (floatValue < 400.0f) {
                if (CheckFirmwareActvity.this.f14284p <= 0.0f) {
                    return;
                }
                CheckFirmwareActvity.this.f14273e.postDelayed(CheckFirmwareActvity.this.f14274f, 10L);
            } else {
                CheckFirmwareActvity.this.f14273e.removeCallbacks(CheckFirmwareActvity.this.f14274f);
                if (!CheckFirmwareActvity.this.f14293y) {
                    CheckFirmwareActvity.this.startActivity(new Intent(CheckFirmwareActvity.this, FlightActivity.class));
                    return;
                }
                CheckFirmwareActvity.this.f14294z.m12787a().edit().putBoolean(CheckFirmwareActvity.this.f14268A, true).commit();
                CheckFirmwareActvity.this.dpa.m12521d();
            }
        }
    };

    /* renamed from: f */
    Runnable f14274f = new Runnable() { // from class: com.fimi.soul.module.update.CheckFirmwareActvity.3
        @Override // java.lang.Runnable
        public void run() {
            CheckFirmwareActvity.m8081h(CheckFirmwareActvity.this);
            Message obtainMessage = CheckFirmwareActvity.this.f14273e.obtainMessage();
            obtainMessage.obj = Float.valueOf(CheckFirmwareActvity.this.f14284p);
            obtainMessage.what = 1;
            CheckFirmwareActvity.this.f14273e.sendMessage(obtainMessage);
        }
    };

    /* renamed from: g */
    int f14275g = 0;

    /* renamed from: a */
    private void m8095a(C2940x c2940x) {
        String string;
        int i = 5;
        String string2 = getString(C2300R.C2303string.self_error_result);
        if (!this.f14290v.m11316ap()) {
        }
        if (c2940x.m10073n()) {
            string = getString(C2300R.C2303string.self_error_battery_copyright);
            i = 1;
        } else if (c2940x.m10074m()) {
            string = getString(C2300R.C2303string.self_error_battery);
            i = 2;
        } else if (c2940x.m10103ai()) {
            string = getString(C2300R.C2303string.fault_short_life_battery);
            i = 3;
        } else if (c2940x.m10121T()) {
            string = getString(C2300R.C2303string.fault_low_battery);
            i = 4;
        } else if (c2940x.m10081f()) {
            string = getString(C2300R.C2303string.land_GPS_ERROR);
        } else if (c2940x.m10077j()) {
            string = getString(C2300R.C2303string.land_IMUACCEL_ERROR);
        } else if (c2940x.m10076k()) {
            string = getString(C2300R.C2303string.land_IMUGYRO_ERROR);
        } else if (c2940x.m10075l()) {
            string = getString(C2300R.C2303string.land_BRO_ERROR);
        } else if ((c2940x.m10079h() || c2940x.m10078i()) && !c2940x.m10128M()) {
            string = getString(C2300R.C2303string.land_CAMP1_ERROR);
            i = 6;
        } else if (c2940x.m10099am()) {
            string = getString(C2300R.C2303string.fault_bat_pre_heart_des);
            i = 7;
        } else if (c2940x.m10128M()) {
            string = getString(C2300R.C2303string.fault_compass);
            i = 8;
            this.f14287s = true;
        } else {
            if (c2940x.m10127N()) {
            }
            if (c2940x.m10126O()) {
            }
            if (c2940x.m10125P()) {
            }
            if (c2940x.m10124Q()) {
                string = getString(C2300R.C2303string.fault_gesture);
                i = 12;
            } else if (this.f14290v.mo11230Q().m10438g()) {
                string = getString(C2300R.C2303string.rc_low_battery);
                i = 13;
            } else if (!c2940x.m10071p()) {
                if (!this.f14277i) {
                    this.f14277i = false;
                    return;
                }
                getFragmentManager().beginTransaction().remove(this.f14282n).commit();
                m8092a(getString(C2300R.C2303string.self_error_auto_result_title), getString(C2300R.C2303string.self_error_auto_result), false, true);
                this.f14277i = false;
                this.f14275g = 0;
                return;
            } else {
                string2 = getString(C2300R.C2303string.fault_vps_tip);
                string = getString(C2300R.C2303string.fault_vps_des);
                i = 14;
            }
        }
        this.f14277i = true;
        if (this.f14275g < i && this.f14275g != 0) {
            getFragmentManager().beginTransaction().remove(this.f14282n).commit();
            m8092a(getString(C2300R.C2303string.self_error_auto_result_title), getString(C2300R.C2303string.self_error_auto_result), false, true);
            this.f14275g = i;
        }
        if (this.f14275g == i || c2940x.m10114a() < 0) {
            return;
        }
        if (this.f14282n != null && this.f14282n.isVisible()) {
            return;
        }
        this.f14275g = i;
        m8091a(string2, string, true, false, this.f14287s);
    }

    /* renamed from: a */
    private void m8092a(String str, String str2, boolean z, boolean z2) {
        this.f14284p = 0.0f;
        this.f14273e.removeCallbacks(this.f14274f);
        if (this.f14283o == null) {
            this.f14283o = new AutoSelfErrorFrgment();
        }
        this.f14283o.m8101a(str2);
        this.f14283o.m8099b(str);
        this.f14283o.m8098b(z);
        this.f14283o.m8100a(z2);
        getFragmentManager().beginTransaction().setCustomAnimations(17432576, 17432577);
        getFragmentManager().beginTransaction().add(C2300R.C2302id.contrain_layout, this.f14283o).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8091a(String str, String str2, boolean z, boolean z2, boolean z3) {
        this.f14284p = 0.0f;
        this.f14273e.removeCallbacks(this.f14274f);
        boolean m8088c = m8088c();
        if (this.f14282n == null) {
            this.f14282n = new UpdateConnectDefeaFrgment();
        }
        if (!m8088c) {
            getFragmentManager().beginTransaction().replace(C2300R.C2302id.contrain_layout, this.f14282n).commitAllowingStateLoss();
        } else if (this.f14282n.isAdded()) {
            getFragmentManager().beginTransaction().remove(this.f14282n).commit();
            this.f14282n = new UpdateConnectDefeaFrgment();
            getFragmentManager().beginTransaction().add(C2300R.C2302id.contrain_layout, this.f14282n).commitAllowingStateLoss();
        }
        this.f14282n.m8040a(str2);
        this.f14282n.m8038b(str);
        this.f14282n.m8036c(getString(C2300R.C2303string.no_connect));
        this.f14282n.m8035c(z);
        this.f14282n.m8039a(z2);
        this.f14282n.m8037b(z3);
        getFragmentManager().beginTransaction().setCustomAnimations(17432576, 17432577);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m8090b() {
        new StringBuffer();
        List<UpdateVersonBean> m7962e = C3579a.m7971a().m7962e();
        if (m7962e != null && m7962e.size() > 0) {
            C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) m7962e);
            this.f14273e.removeCallbacks(this.f14274f);
            startActivity(new Intent(this, FindOnlineFirmwareAvtivity.class));
            finish();
            overridePendingTransition(17432576, 17432577);
            return true;
        }
        this.f14269a = C3579a.m7971a().m7963d();
        if (this.f14269a == null || this.f14269a.size() <= 0) {
            return false;
        }
        this.f14273e.removeCallbacks(this.f14274f);
        Intent intent = new Intent(this, FindNewFirmwareAvtivity.class);
        C2241c.m13122a().mo13115a("upgrade_firmwares", (List) this.f14269a);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
        return true;
    }

    /* renamed from: c */
    private boolean m8088c() {
        try {
            this.f14282n = (UpdateConnectDefeaFrgment) getFragmentManager().findFragmentById(C2300R.C2302id.main_layout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f14282n != null;
    }

    /* renamed from: d */
    private DialogC3297a.AbstractC3300a m8086d() {
        return new DialogC3297a.AbstractC3300a() { // from class: com.fimi.soul.module.update.CheckFirmwareActvity.4
            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: a */
            public void mo8080a() {
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: b */
            public void mo8079b() {
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: c */
            public void mo8078c() {
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: d */
            public void mo8077d() {
                Intent intent = new Intent(CheckFirmwareActvity.this, LoginActivity.class);
                if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                    intent.putExtra(AbstractC2089b.f6992j, 2);
                } else {
                    intent.putExtra(AbstractC2089b.f6992j, 3);
                }
                CheckFirmwareActvity.this.startActivity(intent);
                CheckFirmwareActvity.this.finish();
            }
        };
    }

    /* renamed from: h */
    static /* synthetic */ float m8081h(CheckFirmwareActvity checkFirmwareActvity) {
        float f = checkFirmwareActvity.f14284p;
        checkFirmwareActvity.f14284p = 1.0f + f;
        return f;
    }

    /* renamed from: a */
    public void m8096a() {
        this.f14286r = (TextView) findViewById(C2300R.C2302id.tv_check_firmware);
        C3658ar.m7612a(getAssets(), this.f14286r);
        this.f14276h = (ProgressView) findViewById(C2300R.C2302id.checkFirmwareprogress);
        this.f14276h.setMaxCount(400.0f);
        C3579a.m7971a().m7964c();
        this.f14290v = ((DroidPlannerApp) getApplication()).f7895a;
        C2367d.m12459a().m12452b((String) null);
        this.f14270b = (C2423d) C2379b.m12410a().m12394d();
        this.f14270b.m12231w().m12240b();
        if (this.f14270b.e()) {
            this.f14270b.m12233u().m12281k();
        }
        this.f14292x = (ProgressBar) findViewById(C2300R.C2302id.checkFirmwareProgressBar);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.f14292x.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }

    @Override // com.fimi.soul.module.update.UpdateConnectDefeaFrgment.AbstractC3566a
    /* renamed from: g */
    public void mo8034g() {
        if (!this.f14290v.mo11216ac() || m8090b()) {
            if (this.f14290v.mo11216ac()) {
                return;
            }
            startActivity(new Intent(this, FlightActivity.class));
        } else if (!this.f14293y) {
            startActivity(new Intent(this, FlightActivity.class));
        } else {
            this.f14294z.m12787a().edit().putBoolean(this.f14268A, false).commit();
            this.dpa.m12521d();
        }
    }

    @Override // com.fimi.soul.module.update.UpdateConnectDefeaFrgment.AbstractC3566a
    /* renamed from: h */
    public void mo8033h() {
        if (this.f14287s) {
            startActivity(new Intent(this, CaliCompassActivity.class));
            finish();
            overridePendingTransition(17432576, 17432577);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2462a.m12098a().m12092a(getLocalClassName());
        this.dpa.m12523b(this);
        this.f14294z = C2277v.m12784a(this);
        this.f14268A = C2353b.f7918I;
        this.f14293y = C2238c.m13125c().mo13108d(C2353b.f7920K);
        this.f14277i = false;
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_check_firmware_actvity);
        m8096a();
        this.f14271c = new C3585g(this, this.f14290v);
        new Thread(new Runnable() { // from class: com.fimi.soul.module.update.CheckFirmwareActvity.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                for (int i = 0; i < 5; i++) {
                    CheckFirmwareActvity.this.f14271c.m7887c();
                }
            }
        }).start();
        this.f14273e.postDelayed(this.f14274f, 200L);
        this.f14290v.mo11219a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f14273e.removeMessages(1);
        this.f14290v.mo11214b(this);
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case ERROR_CODE:
                c2657a.m11318an();
                if (this.f14284p > 200.0f || this.f14277i) {
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14284p > 0.0f) {
            this.f14273e.postDelayed(this.f14274f, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f14271c.m7885e();
        this.f14273e.removeCallbacks(this.f14274f);
    }
}
