package com.fimi.soul.module.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2259g;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.p167b.C2327d;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.soul.view.TranslationView;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class FindNewFirmwareAvtivity extends BaseActivity implements View.OnClickListener, AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    public static final String f14328a = "upgrade_firmwares";

    /* renamed from: f */
    TranslationView f14333f;

    /* renamed from: g */
    TextView f14334g;

    /* renamed from: h */
    TextView f14335h;

    /* renamed from: i */
    private Button f14336i;

    /* renamed from: j */
    private Button f14337j;

    /* renamed from: k */
    private Button f14338k;

    /* renamed from: l */
    private Context f14339l;

    /* renamed from: m */
    private int f14340m;

    /* renamed from: n */
    private Boolean f14341n;

    /* renamed from: p */
    private boolean f14343p;

    /* renamed from: q */
    private C2277v f14344q;

    /* renamed from: s */
    private ListView f14346s;

    /* renamed from: t */
    private TextView f14347t;

    /* renamed from: u */
    private C2327d f14348u;

    /* renamed from: v */
    private boolean f14349v;

    /* renamed from: w */
    private boolean f14350w;

    /* renamed from: b */
    boolean f14329b = false;

    /* renamed from: o */
    private C2423d f14342o = null;

    /* renamed from: c */
    List<FirmwareInfo> f14330c = null;

    /* renamed from: r */
    private String f14345r = C2353b.f7920K;

    /* renamed from: d */
    boolean f14331d = false;

    /* renamed from: e */
    boolean f14332e = false;

    /* renamed from: x */
    private EnumC3564a f14351x = EnumC3564a.IDILE;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.update.FindNewFirmwareAvtivity$a */
    /* loaded from: classes.dex */
    public enum EnumC3564a {
        IDILE,
        TF_CARD_NO_UPGRADE_PLEASE_REPLACE,
        TF_CARD_ERROR_NO_UPGRADE,
        CAMERA_RECORDING,
        TF_CARD_CAPACITY,
        DRONE_SKY,
        DIS_CONNECT_DRONE,
        REMOTE_LOW_BATTERY,
        NO_TF_CARD_NO_UPGRADE,
        CARD_PARAMETERS_ERROR,
        FLIGHT_LOW_BATTERY,
        UPGRADING,
        CALIBRATION
    }

    /* renamed from: a */
    private void m8062a(EnumC3564a enumC3564a) {
        if (this.f14351x == enumC3564a) {
            this.f14347t.setText(C2300R.C2303string.confirm_all_connection2);
            this.f14351x = EnumC3564a.IDILE;
            m8050j();
        }
    }

    /* renamed from: a */
    private void m8061a(EnumC3564a enumC3564a, int i) {
        if (this.f14351x == enumC3564a) {
            return;
        }
        this.f14351x = enumC3564a;
        this.f14347t.setText(i);
        m8049k();
    }

    /* renamed from: g */
    private void m8053g() {
        int i;
        if (this.f14330c == null || this.f14330c.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.f14330c.size(); i2++) {
                FirmwareInfo firmwareInfo = this.f14330c.get(i2);
                if (firmwareInfo.getSysId() == 4 || firmwareInfo.getSysId() == 13) {
                    this.f14329b = true;
                } else if (firmwareInfo.getSysId() == 11 || firmwareInfo.getSysId() == 15 || firmwareInfo.getSysId() == 26) {
                    this.f14331d = true;
                } else if (firmwareInfo.getSysId() == 14 || firmwareInfo.getSysId() == 25) {
                    this.f14332e = true;
                }
                i += firmwareInfo.getUpdateTime();
            }
        }
        this.f14343p = C2367d.m12459a().m12438k();
        this.f14342o = (C2423d) C2379b.m12410a().m12394d();
        this.f14342o.a(this);
        if (!this.f14342o.e() && this.drone.mo11215ae()) {
            this.f14342o.m12231w().m12240b();
        }
        if (this.f14329b && this.f14342o.e()) {
            this.f14342o.m12233u().m12290d(C2427e.f8324cU);
        }
        String string = getString(C2300R.C2303string.down_firmwares_detail_ex);
        String string2 = getString(C2300R.C2303string.update_firmwares_detail_ex);
        C2654j.m11372a(i);
        this.f14335h.setText(String.format(string, C2654j.m11355d()) + " | " + String.format(string2, C2654j.m11372a(i)));
    }

    /* renamed from: h */
    private void m8052h() {
        if (this.f14351x == EnumC3564a.CARD_PARAMETERS_ERROR) {
            m8054f();
            return;
        }
        Intent intent = new Intent(this.f14339l, UpgradingActivity.class);
        intent.putExtra("isForce", this.f14349v);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: i */
    private void m8051i() {
        m8062a(EnumC3564a.CAMERA_RECORDING);
        m8062a(EnumC3564a.NO_TF_CARD_NO_UPGRADE);
        m8062a(EnumC3564a.TF_CARD_NO_UPGRADE_PLEASE_REPLACE);
        m8062a(EnumC3564a.TF_CARD_ERROR_NO_UPGRADE);
        m8062a(EnumC3564a.CARD_PARAMETERS_ERROR);
        m8062a(EnumC3564a.UPGRADING);
        if (this.f14342o.j().getFreeKBSpace() == 0) {
            this.f14342o.m12233u().m12290d(C2427e.f8324cU);
        } else if (!m8058b()) {
            m8061a(EnumC3564a.TF_CARD_CAPACITY, C2300R.C2303string.camera_tf_space_detail);
        } else {
            m8062a(EnumC3564a.TF_CARD_CAPACITY);
        }
    }

    /* renamed from: j */
    private void m8050j() {
        this.f14337j.setTextColor(-419430401);
        this.f14338k.setTextColor(-419430401);
        this.f14337j.setClickable(true);
        this.f14338k.setClickable(true);
    }

    /* renamed from: k */
    private void m8049k() {
        this.f14337j.setTextColor(872415231);
        this.f14338k.setTextColor(872415231);
        this.f14337j.setClickable(false);
        this.f14338k.setClickable(false);
    }

    /* renamed from: a */
    public void m8064a() {
        if (!this.drone.mo11216ac()) {
            m8061a(EnumC3564a.DIS_CONNECT_DRONE, C2300R.C2303string.confirm_all_connection);
        } else if (this.drone.mo11230Q().m10438g()) {
            m8061a(EnumC3564a.REMOTE_LOW_BATTERY, C2300R.C2303string.update_low_battery);
        } else if (this.f14330c != null && this.f14330c.size() > 0 && !this.drone.m11319am()) {
            m8061a(EnumC3564a.DRONE_SKY, C2300R.C2303string.motor_start_up);
        } else if (this.f14350w) {
            this.f14347t.setText(getString(C2300R.C2303string.confirm_all_connection3));
        } else {
            this.f14347t.setText(getString(C2300R.C2303string.confirm_all_connection2));
        }
    }

    /* renamed from: a */
    public void m8063a(C2678d.EnumC2679a enumC2679a) {
        switch (enumC2679a) {
            case OnRecivedCloudCameraCommandInfo:
                if (this.drone.f9269c.mo10745a() != 50) {
                    return;
                }
                if (((C2913h) this.drone.f9269c).m10286f() != C2913h.EnumC2914a.NoSDCard) {
                    this.f14342o.b(true);
                } else {
                    this.f14342o.b(false);
                }
                switch (r0.m10286f()) {
                    case VideoRecording:
                        m8061a(EnumC3564a.CAMERA_RECORDING, C2300R.C2303string.findnewfimware_camera_update_no_ugrade);
                        return;
                    case NoSDCard:
                        m8061a(EnumC3564a.NO_TF_CARD_NO_UPGRADE, C2300R.C2303string.tf_card_no_check_no_upgrade);
                        return;
                    case UPDATEPRO:
                        if (!m8057c()) {
                            return;
                        }
                        m8061a(EnumC3564a.UPGRADING, C2300R.C2303string.update_updating);
                        return;
                    case LOW_SPEED_CARD:
                    case CardNoPropose:
                    case CardNoProposeAndParamerr:
                    case CardWriteLow:
                    case CardWriteLowAndParamerr:
                        if (!this.f14343p) {
                            m8051i();
                            return;
                        } else {
                            m8061a(EnumC3564a.TF_CARD_NO_UPGRADE_PLEASE_REPLACE, C2300R.C2303string.tf_card_no_upgrade_please_change);
                            return;
                        }
                    case CardSetroot:
                        m8061a(EnumC3564a.TF_CARD_ERROR_NO_UPGRADE, C2300R.C2303string.tf_card_error_no_ugraded);
                        return;
                    case CardFileSysError:
                    case CardParametersError:
                        if (this.f14351x == EnumC3564a.CARD_PARAMETERS_ERROR) {
                            return;
                        }
                        this.f14351x = EnumC3564a.CARD_PARAMETERS_ERROR;
                        this.f14347t.setText(C2300R.C2303string.please_format_tf_card_upgraded);
                        return;
                    default:
                        m8051i();
                        return;
                }
            default:
                return;
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (isFinishing()) {
            return;
        }
        switch (x11RespCmd.getMsg_id()) {
            case 4:
                if (z) {
                    m8062a(EnumC3564a.CARD_PARAMETERS_ERROR);
                    C2259g.m12987b(new File(C3681j.m7465n()));
                    C2284z.m12694a(this, getString(C2300R.C2303string.format_success), C2284z.f7607c);
                    this.f14342o.m12233u().m12290d(C2427e.f8324cU);
                    this.f14342o.a(true);
                } else {
                    C2284z.m12694a(this, getString(C2300R.C2303string.format_fail), C2284z.f7607c);
                }
                C2238c.m13127b().mo12676c();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public boolean m8058b() {
        return this.f14329b && this.f14342o.j().getFreeKBSpace() > 81920;
    }

    /* renamed from: c */
    public boolean m8057c() {
        return this.f14329b || this.f14331d || this.f14332e;
    }

    /* renamed from: d */
    public void m8056d() {
        this.f14336i = (Button) findViewById(C2300R.C2302id.btn_after);
        C3658ar.m7612a(getAssets(), this.f14336i);
        this.f14336i.setOnClickListener(this);
        this.f14337j = (Button) findViewById(C2300R.C2302id.btn_upgrade);
        C3658ar.m7612a(getAssets(), this.f14337j);
        this.f14337j.setOnClickListener(this);
        this.f14338k = (Button) findViewById(C2300R.C2302id.btn_upgrade2);
        C3658ar.m7612a(getAssets(), this.f14338k);
        this.f14338k.setOnClickListener(this);
        this.f14333f = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f14333f.setVisibility(0);
        this.f14333f.m7244a();
        this.f14334g = (TextView) findViewById(C2300R.C2302id.update_firmware_title);
        C3658ar.m7612a(getAssets(), this.f14334g);
        this.f14335h = (TextView) findViewById(C2300R.C2302id.down_firmwares_detail_ex);
        C3658ar.m7612a(getAssets(), this.f14335h);
        this.f14347t = (TextView) findViewById(C2300R.C2302id.confirm_tv);
        C3658ar.m7612a(getAssets(), this.f14347t);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2300R.C2303string.refreshupdate));
        if (this.f14349v) {
            this.f14336i.setVisibility(8);
            this.f14337j.setVisibility(8);
            this.f14338k.setVisibility(0);
            sb.append(getString(C2300R.C2303string.update_firmware_title_ex));
        } else {
            this.f14336i.setVisibility(0);
            this.f14337j.setVisibility(0);
            this.f14338k.setVisibility(8);
        }
        this.f14334g.setText(sb.toString());
        this.f14346s = (ListView) findViewById(C2300R.C2302id.testListView);
    }

    /* renamed from: e */
    public void m8055e() {
        if (this.f14330c == null || this.f14330c.size() <= 0) {
            return;
        }
        this.f14348u = new C2327d(this, this.f14330c);
        this.f14346s.setAdapter((ListAdapter) this.f14348u);
    }

    /* renamed from: f */
    public void m8054f() {
        new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.check_tf_card_must_format)).m7029a(false).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.update.FindNewFirmwareAvtivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C2238c.m13127b().mo12687a();
                FindNewFirmwareAvtivity.this.f14342o.m12233u().m12293c();
            }
        }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.update.FindNewFirmwareAvtivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).m7035a().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.btn_after /* 2131492991 */:
                if (this.f14340m == 1) {
                    finish();
                    return;
                } else if (!this.f14341n.booleanValue()) {
                    startActivity(new Intent(this, FlightActivity.class));
                    return;
                } else {
                    this.f14344q.m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                    this.dpa.m12521d();
                    return;
                }
            case C2300R.C2302id.btn_upgrade /* 2131492992 */:
                m8052h();
                return;
            case C2300R.C2302id.btn_upgrade2 /* 2131492993 */:
                m8052h();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.dpa.m12523b(this);
        this.f14344q = C2277v.m12784a(this);
        this.f14345r = C2353b.f7920K;
        this.f14341n = Boolean.valueOf(this.f14344q.m12787a().getBoolean(this.f14345r, false));
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_find_new_firmware_avtivity);
        C3658ar.m7612a(getAssets(), this.f14337j);
        this.f14339l = this;
        this.f14340m = getIntent().getIntExtra(C2353b.f7915F, 0);
        this.f14330c = C3579a.m7971a().m7963d();
        while (true) {
            int i2 = i;
            if (i2 >= this.f14330c.size()) {
                break;
            }
            if ("2".equals(this.f14330c.get(i2).getForceSign())) {
                this.f14349v = true;
            }
            if (this.f14330c.get(i2).isVersionError()) {
                this.f14349v = true;
                this.f14350w = true;
                break;
            }
            i = i2 + 1;
        }
        m8056d();
        m8053g();
        m8055e();
        m8064a();
        C2462a.m12098a().m12092a(getLocalClassName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (!c2657a.mo11216ac()) {
            m8061a(EnumC3564a.DIS_CONNECT_DRONE, C2300R.C2303string.confirm_all_connection);
            return;
        }
        m8062a(EnumC3564a.DIS_CONNECT_DRONE);
        if (c2657a.m11318an().m10097ao() || C2367d.m12459a().m12441h() || C2364c.m12469a().m12462d()) {
            if (!m8057c()) {
                return;
            }
            m8061a(EnumC3564a.UPGRADING, C2300R.C2303string.update_updating);
            return;
        }
        m8062a(EnumC3564a.UPGRADING);
        if (c2657a.m11318an().m10098an()) {
            m8061a(EnumC3564a.CALIBRATION, C2300R.C2303string.update_calibration);
            return;
        }
        m8062a(EnumC3564a.CALIBRATION);
        if (c2657a.mo11230Q().m10438g()) {
            m8061a(EnumC3564a.REMOTE_LOW_BATTERY, C2300R.C2303string.update_low_battery);
            return;
        }
        m8062a(EnumC3564a.REMOTE_LOW_BATTERY);
        if (c2657a.m11318an().m10122S() || c2657a.m11318an().m10121T()) {
            m8061a(EnumC3564a.FLIGHT_LOW_BATTERY, C2300R.C2303string.update_flight_low_battery);
            return;
        }
        m8062a(EnumC3564a.FLIGHT_LOW_BATTERY);
        if (!c2657a.m11319am()) {
            m8061a(EnumC3564a.DRONE_SKY, C2300R.C2303string.motor_start_up);
            return;
        }
        m8062a(EnumC3564a.DRONE_SKY);
        if (!this.f14329b) {
            return;
        }
        m8063a(enumC2679a);
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f14349v) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f14329b) {
            this.f14342o.m12230x().mo12246i();
        }
        C2462a.m12098a().m12091a(getLocalClassName(), 1, this.drone);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
