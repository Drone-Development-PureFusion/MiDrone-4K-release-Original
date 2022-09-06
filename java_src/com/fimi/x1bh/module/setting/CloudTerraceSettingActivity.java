package com.fimi.x1bh.module.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.module.setting.C3509i;
import com.fimi.soul.module.update.FindOnlineFirmwareAvtivity;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.x1bh.module.X1bhBaseActivity;
import com.fimi.x1bh.module.about.CloudAboutActivity;
import com.fimi.x1bh.module.arrowkey.ArrowKeyActivity;
import com.fimi.x1bh.module.camerasetting.CloudCameraSettingActivity;
import com.fimi.x1bh.module.setting.C3928b;
import com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class CloudTerraceSettingActivity extends X1bhBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: j */
    private static int f16731j = 1;

    /* renamed from: k */
    private static final int f16732k = 5000;

    /* renamed from: n */
    private static final String f16733n = "CloudTerraceSettingActi";

    /* renamed from: b */
    List<UpdateVersonBean> f16735b;

    /* renamed from: c */
    private C3928b f16736c;

    /* renamed from: d */
    private C2613z f16737d;

    /* renamed from: e */
    private Button f16738e;

    /* renamed from: f */
    private TextView f16739f;

    /* renamed from: g */
    private ListView f16740g;

    /* renamed from: h */
    private List<C3927a> f16741h;

    /* renamed from: i */
    private C2423d f16742i;

    /* renamed from: a */
    List<FirmwareInfo> f16734a = null;

    /* renamed from: l */
    private Handler f16743l = new Handler() { // from class: com.fimi.x1bh.module.setting.CloudTerraceSettingActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == CloudTerraceSettingActivity.f16731j) {
                CloudTerraceSettingActivity.this.m6516a(CloudTerraceSettingActivity.this.f16742i);
                CloudTerraceSettingActivity.this.f16743l.sendEmptyMessageDelayed(CloudTerraceSettingActivity.f16731j, 5000L);
            }
        }
    };

    /* renamed from: m */
    private Observer f16744m = new Observer() { // from class: com.fimi.x1bh.module.setting.CloudTerraceSettingActivity.2
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (CloudTerraceSettingActivity.this.f16736c != null) {
                CloudTerraceSettingActivity.this.f16736c.m6485a(CloudTerraceSettingActivity.this.f16741h);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6516a(C2423d c2423d) {
        Log.i(f16733n, "enterMapSetting: ");
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 2;
        if ("menu_album".equals("") || !c2423d.e()) {
            return;
        }
        c2423d.m12233u().m12298a("menu_album", C2427e.f8308cE);
    }

    /* renamed from: c */
    private void m6511c() {
        C3928b.EnumC3930a[] values;
        this.f16736c = new C3928b(this);
        this.f16741h = new ArrayList();
        for (C3928b.EnumC3930a enumC3930a : C3928b.EnumC3930a.values()) {
            for (int i = 0; i < C3509i.f13894c.length; i++) {
            }
            C3927a c3927a = new C3927a();
            c3927a.addObserver(this.f16744m);
            c3927a.m6497a((Boolean) true);
            c3927a.m6498a(enumC3930a);
            this.f16741h.add(c3927a);
        }
        this.f16734a = C3579a.m7971a().m7963d();
        this.f16735b = C3579a.m7971a().m7962e();
        this.f16736c.m6485a(this.f16741h);
        m6509d();
        this.f16740g.setAdapter((ListAdapter) this.f16736c);
        this.f16740g.setOnItemClickListener(this);
        this.f16737d = C2613z.m11525a(this);
        this.f16742i = (C2423d) C2379b.m12410a().m12394d();
        m6516a(this.f16742i);
        this.f16743l.sendEmptyMessageDelayed(f16731j, 5000L);
        m6503g();
    }

    /* renamed from: d */
    private void m6509d() {
        this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.XIAOMI_ACCOUNT)).m6497a((Boolean) true);
        this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.XIAOMI_ACCOUNT)).m6496a(C2353b.m12507c(this).getXiaomiID());
    }

    /* renamed from: e */
    private void m6507e() {
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        this.f16738e = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f16739f = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f16740g = (ListView) findViewById(C2300R.C2302id.setting_lv);
        this.f16738e.setOnClickListener(this);
        C3658ar.m7612a(getAssets(), this.f16739f);
    }

    /* renamed from: f */
    private void m6505f() {
        if (this.preferencesUtil.m12787a().contains("isfirstloading")) {
            new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.log_out)).m7023c(17).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.exit), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.setting.CloudTerraceSettingActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C2353b.m12513a(CloudTerraceSettingActivity.this);
                    ((C3927a) CloudTerraceSettingActivity.this.f16741h.get(CloudTerraceSettingActivity.this.f16736c.m6488a(C3928b.EnumC3930a.XIAOMI_ACCOUNT))).m6497a((Boolean) false);
                    CloudTerraceSettingActivity.this.f16736c.m6485a(CloudTerraceSettingActivity.this.f16741h);
                    CloudTerraceSettingActivity.this.f16737d.m11513b(C2353b.m12507c(CloudTerraceSettingActivity.this), new AbstractC2538k() { // from class: com.fimi.x1bh.module.setting.CloudTerraceSettingActivity.4.1
                        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                        /* renamed from: a */
                        public void mo6501a(PlaneMsg planeMsg, File file) {
                        }
                    });
                    CloudTerraceSettingActivity.this.preferencesUtil.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
                    Intent intent = new Intent(CloudTerraceSettingActivity.this, LoginActivity.class);
                    intent.putExtra(AbstractC2089b.f6992j, 4);
                    CloudTerraceSettingActivity.this.startActivity(intent);
                    CloudTerraceSettingActivity.this.finish();
                    CloudTerraceSettingActivity.this.overridePendingTransition(17432576, 17432577);
                }
            }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.setting.CloudTerraceSettingActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).m7035a().show();
            return;
        }
        this.preferencesUtil.m12787a().edit().putBoolean(C2353b.f7920K, true).commit();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(AbstractC2089b.f6992j, 4);
        startActivity(intent);
    }

    /* renamed from: g */
    private void m6503g() {
        this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.FIRMWARE_UPDATE)).m6495a(true);
        if (m6502h() || (this.f16734a != null && this.f16734a.size() > 0)) {
            this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.FIRMWARE_UPDATE)).m6493b(true);
        } else {
            this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.FIRMWARE_UPDATE)).m6493b(false);
        }
    }

    /* renamed from: h */
    private boolean m6502h() {
        return this.f16735b != null && this.f16735b.size() > 0;
    }

    /* renamed from: a */
    public void m6517a() {
        Log.i(f16733n, "quitMapSetting: ");
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 0;
        if (!"menu_album".equals("")) {
            C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
            if (!c2423d.e()) {
                return;
            }
            c2423d.m12233u().m12298a("menu_album", "off");
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: a */
    public void mo6477a(String str) {
        super.mo6477a(str);
        Log.d(f16733n, "onConnected: " + Thread.currentThread().getName());
        this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.CONNECT_PLANE)).m6495a(false);
        this.f16736c.notifyDataSetChanged();
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
        super.mo6446b(str);
        Log.d(f16733n, "onDisconnect: " + Thread.currentThread().getName());
        this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.CONNECT_PLANE)).m6495a(true);
        this.f16736c.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.black_btn) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_cloud_terrace_setting);
        this.dpa.m12523b(this);
        m6507e();
        m6511c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f16743l != null) {
            this.f16743l.removeMessages(f16731j);
        }
        m6517a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3928b.EnumC3930a m6491d = this.f16741h.get(i).m6491d();
        if (m6491d == C3928b.EnumC3930a.XIAOMI_ACCOUNT) {
            m6505f();
        } else if (m6491d == C3928b.EnumC3930a.ARROW_KEY_SET) {
            startActivity(new Intent(this, ArrowKeyActivity.class));
        } else if (m6491d == C3928b.EnumC3930a.CAMERA_SETTING) {
            startActivity(new Intent(this, CloudCameraSettingActivity.class));
        } else if (m6491d == C3928b.EnumC3930a.CONNECT_PLANE) {
            if (!this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.CONNECT_PLANE)).m6490e()) {
                return;
            }
            C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
            c2423d.n();
            c2423d.a(-1);
            if (this.f16743l != null) {
                this.f16743l.removeMessages(f16731j);
            }
            m6517a();
            this.preferencesUtil.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
            Intent intent = new Intent(this, LoginActivity.class);
            if (C2238c.m13123e().m12746o() == 0) {
                intent.putExtra(AbstractC2089b.f6992j, 2);
            } else {
                intent.putExtra(AbstractC2089b.f6992j, 3);
            }
            startActivity(intent);
            overridePendingTransition(17432576, 17432577);
        } else if (m6491d != C3928b.EnumC3930a.FIRMWARE_UPDATE) {
            if (m6491d != C3928b.EnumC3930a.ABOUT) {
                return;
            }
            startActivity(new Intent(this, CloudAboutActivity.class));
        } else if (!this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.FIRMWARE_UPDATE)).m6490e()) {
        } else {
            if (m6502h()) {
                C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) this.f16735b);
                Intent intent2 = new Intent(this, FindOnlineFirmwareAvtivity.class);
                CameraValue.isFindFirmware = true;
                startActivity(intent2);
            } else if (this.f16734a == null || this.f16734a.size() <= 0) {
                C2284z.m12697a(this, (int) C2300R.C2303string.version_tip);
            } else {
                Intent intent3 = new Intent(this, X1bhFindNewFirmwareAvtivity.class);
                CameraValue.isFindFirmware = true;
                startActivity(intent3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (((C2423d) C2379b.m12410a().m12394d()).s()) {
            this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.CONNECT_PLANE)).m6495a(false);
        } else {
            this.f16741h.get(this.f16736c.m6488a(C3928b.EnumC3930a.CONNECT_PLANE)).m6495a(true);
        }
    }
}
