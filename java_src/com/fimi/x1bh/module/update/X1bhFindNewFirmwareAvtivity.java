package com.fimi.x1bh.module.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
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
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p148e.p149a.C2122a;
import com.fimi.p151f.C2145d;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.p167b.C2327d;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.soul.view.TranslationView;
import com.fimi.x1bh.module.X1bhBaseActivity;
import com.fimi.x1bh.module.main.CloudTerraceMainActivity;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class X1bhFindNewFirmwareAvtivity extends X1bhBaseActivity implements View.OnClickListener, AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    public static final String f16778a = "upgrade_firmwares";

    /* renamed from: x */
    private static final int f16779x = 135;

    /* renamed from: y */
    private static final String f16780y = "X1bhFindNewFirmwareAvti";

    /* renamed from: d */
    TranslationView f16783d;

    /* renamed from: e */
    TextView f16784e;

    /* renamed from: f */
    TextView f16785f;

    /* renamed from: g */
    private Button f16786g;

    /* renamed from: h */
    private Button f16787h;

    /* renamed from: i */
    private Button f16788i;

    /* renamed from: j */
    private Context f16789j;

    /* renamed from: k */
    private int f16790k;

    /* renamed from: l */
    private Boolean f16791l;

    /* renamed from: n */
    private boolean f16793n;

    /* renamed from: o */
    private C2277v f16794o;

    /* renamed from: q */
    private C2122a f16796q;

    /* renamed from: r */
    private ListView f16797r;

    /* renamed from: s */
    private TextView f16798s;

    /* renamed from: t */
    private C2327d f16799t;

    /* renamed from: u */
    private boolean f16800u;

    /* renamed from: v */
    private boolean f16801v;

    /* renamed from: b */
    boolean f16781b = false;

    /* renamed from: m */
    private C2423d f16792m = null;

    /* renamed from: c */
    List<FirmwareInfo> f16782c = null;

    /* renamed from: p */
    private String f16795p = C2353b.f7920K;

    /* renamed from: w */
    private EnumC3934a f16802w = EnumC3934a.IDILE;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity$a */
    /* loaded from: classes.dex */
    public enum EnumC3934a {
        IDILE,
        TF_CARD_NO_UPGRADE_PLEASE_REPLACE,
        TF_CARD_ERROR_NO_UPGRADE,
        CAMERA_RECORDING,
        TF_CARD_CAPACITY,
        HAND_LOW_BATTERY,
        NO_TF_CARD_NO_UPGRADE,
        CARD_PARAMETERS_ERROR,
        UPGRADING,
        CALIBRATION,
        DIS_CONNECT_HANDLE
    }

    /* renamed from: a */
    private void m6480a(EnumC3934a enumC3934a) {
        Log.i(f16780y, "cleanState: " + enumC3934a + ",mState:" + this.f16802w);
        if (this.f16802w == enumC3934a) {
            Log.i(f16780y, "cleanState1: " + this.f16802w);
            this.f16798s.setText(C2300R.C2303string.confirm_all_connection2);
            this.f16802w = EnumC3934a.IDILE;
            m6468i();
        }
    }

    /* renamed from: a */
    private void m6479a(EnumC3934a enumC3934a, int i) {
        if (this.f16802w == enumC3934a) {
            return;
        }
        Log.i(f16780y, "setState: state:" + enumC3934a);
        this.f16802w = enumC3934a;
        this.f16798s.setText(i);
        m6467j();
    }

    /* renamed from: f */
    private void m6471f() {
        int i;
        if (this.f16782c == null || this.f16782c.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.f16782c.size(); i2++) {
                FirmwareInfo firmwareInfo = this.f16782c.get(i2);
                if (firmwareInfo.getSysId() == 4 || firmwareInfo.getSysId() == 13) {
                    this.f16781b = true;
                }
                i += firmwareInfo.getUpdateTime();
            }
        }
        this.f16793n = C2367d.m12459a().m12438k();
        this.f16792m = (C2423d) C2379b.m12410a().m12394d();
        this.f16792m.a(this);
        if (!this.f16792m.e() && this.drone.mo11215ae()) {
            this.f16792m.m12231w().m12240b();
        }
        if (this.f16781b && this.f16792m.e()) {
            this.f16792m.m12233u().m12290d(C2427e.f8324cU);
        }
        String string = getString(C2300R.C2303string.down_firmwares_detail_ex);
        getString(C2300R.C2303string.update_firmwares_detail_ex);
        C2654j.m11372a(i);
        this.f16785f.setText(String.format(string, C2654j.m11355d()));
    }

    /* renamed from: g */
    private void m6470g() {
        if (this.f16802w == EnumC3934a.CARD_PARAMETERS_ERROR) {
            m6472e();
            return;
        }
        Intent intent = new Intent(this.f16789j, X1bhUpgradingActivity.class);
        intent.putExtra("isForce", this.f16800u);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: h */
    private void m6469h() {
        m6480a(EnumC3934a.CAMERA_RECORDING);
        m6480a(EnumC3934a.NO_TF_CARD_NO_UPGRADE);
        m6480a(EnumC3934a.TF_CARD_NO_UPGRADE_PLEASE_REPLACE);
        m6480a(EnumC3934a.TF_CARD_ERROR_NO_UPGRADE);
        m6480a(EnumC3934a.CARD_PARAMETERS_ERROR);
        m6480a(EnumC3934a.UPGRADING);
        if (this.f16792m.j().getFreeKBSpace() == 0) {
            this.f16792m.m12233u().m12290d(C2427e.f8324cU);
        } else if (!m6475b()) {
            m6479a(EnumC3934a.TF_CARD_CAPACITY, C2300R.C2303string.camera_tf_space_detail);
        } else {
            m6480a(EnumC3934a.TF_CARD_CAPACITY);
        }
    }

    /* renamed from: i */
    private void m6468i() {
        this.f16787h.setTextColor(-419430401);
        this.f16788i.setTextColor(-419430401);
        this.f16787h.setClickable(true);
        this.f16788i.setClickable(true);
    }

    /* renamed from: j */
    private void m6467j() {
        this.f16787h.setTextColor(872415231);
        this.f16788i.setTextColor(872415231);
        this.f16787h.setClickable(false);
        this.f16788i.setClickable(false);
    }

    /* renamed from: a */
    public void m6482a() {
        if (this.f16801v) {
            this.f16798s.setText(getString(C2300R.C2303string.confirm_all_connection3));
        } else {
            this.f16798s.setText(getString(C2300R.C2303string.confirm_all_connection2));
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
                getHandler().obtainMessage(135, (C2122a) m13702g).sendToTarget();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: a */
    public void mo6477a(String str) {
        super.mo6477a(str);
        m6480a(EnumC3934a.DIS_CONNECT_HANDLE);
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
                    m6480a(EnumC3934a.CARD_PARAMETERS_ERROR);
                    C2259g.m12987b(new File(C3681j.m7465n()));
                    C2284z.m12694a(this, getString(C2300R.C2303string.format_success), C2284z.f7607c);
                    this.f16792m.m12233u().m12290d(C2427e.f8324cU);
                    this.f16792m.a(true);
                } else {
                    C2284z.m12694a(this, getString(C2300R.C2303string.format_fail), C2284z.f7607c);
                }
                C2238c.m13127b().mo12676c();
                return;
            case 5:
            case 6:
            default:
                return;
            case 7:
                if (!this.f16781b || !C2427e.f8333ce.equals(x11RespCmd.getType())) {
                    return;
                }
                if (C2427e.f8209aL.equals(x11RespCmd.getCard_status())) {
                    m6479a(EnumC3934a.NO_TF_CARD_NO_UPGRADE, C2300R.C2303string.tf_card_no_check_no_upgrade);
                    return;
                } else if (C2427e.f8328cY.equals(x11RespCmd.getCam_status())) {
                    m6479a(EnumC3934a.CAMERA_RECORDING, C2300R.C2303string.findnewfimware_camera_update_no_ugrade);
                    return;
                } else if (C2427e.f8213aP.equals(x11RespCmd.getCard_status()) || C2427e.f8219aV.equals(x11RespCmd.getCard_status())) {
                    if (this.f16802w == EnumC3934a.CARD_PARAMETERS_ERROR) {
                        return;
                    }
                    this.f16802w = EnumC3934a.CARD_PARAMETERS_ERROR;
                    this.f16798s.setText(C2300R.C2303string.please_format_tf_card_upgraded);
                    return;
                } else if (C2427e.f8217aT.equals(x11RespCmd.getCard_status()) || C2427e.f8218aU.equals(x11RespCmd.getCard_status()) || C2427e.f8215aR.equals(x11RespCmd.getCard_status()) || C2427e.f8216aS.equals(x11RespCmd.getCard_status()) || C2427e.f8206aI.equals(x11RespCmd.getCard_status())) {
                    m6479a(EnumC3934a.TF_CARD_NO_UPGRADE_PLEASE_REPLACE, C2300R.C2303string.tf_card_no_upgrade_please_change);
                    return;
                } else {
                    m6469h();
                    return;
                }
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
        super.mo6446b(str);
        m6479a(EnumC3934a.DIS_CONNECT_HANDLE, C2300R.C2303string.cloud_confirm_all_connection);
    }

    /* renamed from: b */
    public boolean m6475b() {
        return !this.f16781b || this.f16792m.j().getFreeKBSpace() > 81920;
    }

    /* renamed from: c */
    public void m6474c() {
        this.f16786g = (Button) findViewById(C2300R.C2302id.btn_after);
        C3658ar.m7612a(getAssets(), this.f16786g);
        this.f16786g.setOnClickListener(this);
        this.f16787h = (Button) findViewById(C2300R.C2302id.btn_upgrade);
        C3658ar.m7612a(getAssets(), this.f16787h);
        this.f16787h.setOnClickListener(this);
        this.f16788i = (Button) findViewById(C2300R.C2302id.btn_upgrade2);
        C3658ar.m7612a(getAssets(), this.f16788i);
        this.f16788i.setOnClickListener(this);
        this.f16783d = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f16783d.setVisibility(0);
        this.f16783d.m7244a();
        this.f16784e = (TextView) findViewById(C2300R.C2302id.update_firmware_title);
        C3658ar.m7612a(getAssets(), this.f16784e);
        this.f16785f = (TextView) findViewById(C2300R.C2302id.down_firmwares_detail_ex);
        C3658ar.m7612a(getAssets(), this.f16785f);
        this.f16798s = (TextView) findViewById(C2300R.C2302id.confirm_tv);
        C3658ar.m7612a(getAssets(), this.f16798s);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2300R.C2303string.refreshupdate));
        if (this.f16800u) {
            this.f16786g.setVisibility(8);
            this.f16787h.setVisibility(8);
            this.f16788i.setVisibility(0);
            sb.append(getString(C2300R.C2303string.update_firmware_title_ex));
        } else {
            this.f16786g.setVisibility(0);
            this.f16787h.setVisibility(0);
            this.f16788i.setVisibility(8);
        }
        m6468i();
        this.f16784e.setText(sb.toString());
        this.f16797r = (ListView) findViewById(C2300R.C2302id.testListView);
    }

    /* renamed from: d */
    public void m6473d() {
        if (this.f16782c == null || this.f16782c.size() <= 0) {
            return;
        }
        this.f16799t = new C2327d(this, this.f16782c);
        this.f16797r.setAdapter((ListAdapter) this.f16799t);
    }

    /* renamed from: e */
    public void m6472e() {
        new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.check_tf_card_must_format)).m7029a(false).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C2238c.m13127b().mo12687a();
                X1bhFindNewFirmwareAvtivity.this.f16792m.m12233u().m12293c();
            }
        }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).m7035a().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.btn_after /* 2131492991 */:
                if (this.f16790k == 1) {
                    finish();
                    return;
                } else if (!this.f16791l.booleanValue()) {
                    startActivity(new Intent(this, CloudTerraceMainActivity.class));
                    return;
                } else {
                    this.f16794o.m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                    this.dpa.m12521d();
                    return;
                }
            case C2300R.C2302id.btn_upgrade /* 2131492992 */:
                m6470g();
                return;
            case C2300R.C2302id.btn_upgrade2 /* 2131492993 */:
                m6470g();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.dpa.m12523b(this);
        this.f16794o = C2277v.m12784a(this);
        this.f16795p = C2353b.f7920K;
        this.f16791l = Boolean.valueOf(this.f16794o.m12787a().getBoolean(this.f16795p, false));
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_find_new_firmware_avtivity);
        C3658ar.m7612a(getAssets(), this.f16787h);
        this.f16789j = this;
        this.f16790k = getIntent().getIntExtra(C2353b.f7915F, 0);
        this.f16782c = C3579a.m7971a().m7963d();
        while (true) {
            int i2 = i;
            if (i2 >= this.f16782c.size()) {
                break;
            }
            if ("2".equals(this.f16782c.get(i2).getForceSign())) {
                this.f16800u = true;
            }
            if (this.f16782c.get(i2).isVersionError()) {
                this.f16800u = true;
                this.f16801v = true;
                break;
            }
            i = i2 + 1;
        }
        m6474c();
        m6471f();
        m6473d();
        m6482a();
        if (!C2145d.m13447b().m13444d()) {
            m6479a(EnumC3934a.DIS_CONNECT_HANDLE, C2300R.C2303string.cloud_confirm_all_connection);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f16783d != null) {
            this.f16783d.m7236c();
        }
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message.what == 135) {
            this.f16796q = (C2122a) message.obj;
            if (this.f16796q.m13605k() < 20) {
                m6479a(EnumC3934a.HAND_LOW_BATTERY, C2300R.C2303string.cloud_upgrade_check_low_battery_alarm);
            } else {
                m6480a(EnumC3934a.HAND_LOW_BATTERY);
            }
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f16800u) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f16781b) {
            this.f16792m.m12230x().mo12246i();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
