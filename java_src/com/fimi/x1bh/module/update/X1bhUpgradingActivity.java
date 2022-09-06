package com.fimi.x1bh.module.update;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.p139b.p140a.C2088d;
import com.fimi.p147d.AbstractC2120c;
import com.fimi.p153h.C2151c;
import com.fimi.p154i.C2162c;
import com.fimi.p154i.C2163d;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.camera.p173c.C2416d;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.AbstractC2651g;
import com.fimi.soul.biz.update.C2629a;
import com.fimi.soul.biz.update.C2638c;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.module.update.C3588c;
import com.fimi.soul.module.update.UpgradeResultActivity;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3658ar;
import com.fimi.x1bh.module.X1bhBaseActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class X1bhUpgradingActivity extends X1bhBaseActivity implements AbstractC2388f<X11RespCmd>, C3588c.AbstractC3590a {

    /* renamed from: H */
    private static final String f16830H = "X1bhUpgradingActivity";

    /* renamed from: a */
    public static final String f16831a = "sp_upgrade_skip";

    /* renamed from: m */
    private static final int f16832m = 153;

    /* renamed from: n */
    private static final int f16833n = 256;

    /* renamed from: o */
    private static final int f16834o = 136;

    /* renamed from: p */
    private static final int f16835p = 50;

    /* renamed from: r */
    private static int f16836r = 1;

    /* renamed from: s */
    private static final int f16837s = 119;

    /* renamed from: t */
    private static final int f16838t = 102;

    /* renamed from: A */
    private boolean f16839A;

    /* renamed from: C */
    private boolean f16841C;

    /* renamed from: D */
    private TextView f16842D;

    /* renamed from: E */
    private boolean f16843E;

    /* renamed from: F */
    private C2151c f16844F;

    /* renamed from: G */
    private List<C2162c> f16845G;

    /* renamed from: J */
    private Toast f16847J;

    /* renamed from: b */
    List<FirmwareInfo> f16848b;

    /* renamed from: e */
    long f16851e;

    /* renamed from: f */
    private ProgressView f16852f;

    /* renamed from: g */
    private TextView f16853g;

    /* renamed from: h */
    private ImageView f16854h;

    /* renamed from: i */
    private C2657a f16855i;

    /* renamed from: j */
    private TextView f16856j;

    /* renamed from: k */
    private TextView f16857k;

    /* renamed from: l */
    private TextView f16858l;

    /* renamed from: u */
    private boolean f16860u;

    /* renamed from: z */
    private C2638c f16865z;

    /* renamed from: q */
    private final int f16859q = 32;

    /* renamed from: v */
    private int f16861v = 0;

    /* renamed from: w */
    private int f16862w = 0;

    /* renamed from: x */
    private int f16863x = 0;

    /* renamed from: c */
    C2629a f16849c = null;

    /* renamed from: y */
    private C2423d f16864y = null;

    /* renamed from: d */
    C3588c f16850d = null;

    /* renamed from: B */
    private StringBuffer f16840B = null;

    /* renamed from: I */
    private AbstractC2120c f16846I = new AbstractC2120c() { // from class: com.fimi.x1bh.module.update.X1bhUpgradingActivity.4
        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6429a() {
            Log.i("update", "onFileNotFind: ");
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6428a(long j, long j2) {
            Log.i("update", "onProcess:" + j + " " + j2 + " " + ((int) ((100 * j2) / j)));
            X1bhUpgradingActivity.this.m6458a(153, (int) j2, (int) j);
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6427a(String str) {
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6426a(String str, List<C2162c> list) {
            Log.i("update", "onRestart: ");
            Message message = new Message();
            message.what = 102;
            X1bhUpgradingActivity.this.getHandler().sendMessage(message);
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6425a(List<C2162c> list) {
            Log.i("update", "onUpdateSuccess: ");
            for (int i = 0; i < list.size(); i++) {
                for (int i2 = 0; i2 < X1bhUpgradingActivity.this.f16848b.size(); i2++) {
                    if (list.get(i).m13356e() == X1bhUpgradingActivity.this.f16848b.get(i2).getSysId()) {
                        Log.i("update", "onRestart: index:" + i);
                        X1bhUpgradingActivity.this.f16848b.get(i2).setIsUpgradeSuccess(Boolean.valueOf(list.get(i).m13367a()));
                    }
                }
            }
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: a */
        public void mo6424a(boolean z, String str) {
            Log.i("update", "onResult: ");
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: b */
        public void mo6423b(String str) {
            Log.i("update", "onSendError: msg:" + str);
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: c */
        public void mo6422c(String str) {
            if (X1bhUpgradingActivity.this.m6460a()) {
                X1bhUpgradingActivity.m6443c(X1bhUpgradingActivity.this);
            }
            X1bhUpgradingActivity.this.getHandler().sendEmptyMessage(119);
            Log.i("update", "onCurrentUpgrade: info:" + str);
        }

        @Override // com.fimi.p147d.AbstractC2120c
        /* renamed from: d */
        public void mo6421d(String str) {
            Log.i("update", "onInterrupt: ");
            Message message = new Message();
            message.what = 6;
            message.obj = str;
            X1bhUpgradingActivity.this.getHandler().sendMessage(message);
            X1bhUpgradingActivity.this.f16844F = null;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6458a(int i, int i2, int i3) {
        if (System.currentTimeMillis() - this.f16851e > 500 || i2 == i3 || i == 256) {
            Log.i(f16830H, "updateProgress: ");
            this.f16851e = System.currentTimeMillis();
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            getHandler().sendMessageDelayed(message, 50L);
        }
    }

    /* renamed from: b */
    private void m6449b() {
        this.f16848b = C3579a.m7971a().m7963d();
        if (this.f16848b == null || this.f16848b.size() == 0) {
            finish();
            return;
        }
        this.f16858l.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f16848b.get(0).getSysName());
        this.f16863x = this.f16848b.size();
        this.f16861v = this.f16848b.size() * 100;
        this.f16852f.setMaxCount(this.f16861v);
        FirmwareInfo firmwareInfo = this.f16848b.get(0);
        if (firmwareInfo.getSysId() != 4 && firmwareInfo.getSysId() != 13) {
            m6453a(this.f16848b);
            return;
        }
        this.f16850d.m7884a();
        m6448b(firmwareInfo.getSysId());
    }

    /* renamed from: b */
    private void m6448b(final int i) {
        new Thread(new Runnable() { // from class: com.fimi.x1bh.module.update.X1bhUpgradingActivity.1
            @Override // java.lang.Runnable
            public void run() {
                C2654j.m11357c("request camera upgrade:" + i);
                if (i == 13) {
                    X1bhUpgradingActivity.this.f16862w = 1;
                    C2416d m12232v = X1bhUpgradingActivity.this.f16864y.m12232v();
                    C2638c unused = X1bhUpgradingActivity.this.f16865z;
                    m12232v.m12254h(C2638c.m11409c());
                }
            }
        }).start();
    }

    /* renamed from: b */
    private void m6445b(boolean z) {
        Log.i(f16830H, "upgradeNextFirmware: ");
        this.f16848b.get(0).setIsUpgradeSuccess(Boolean.valueOf(z));
        if (this.f16863x > 1) {
            m6453a(this.f16848b);
        } else {
            m6440e();
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m6443c(X1bhUpgradingActivity x1bhUpgradingActivity) {
        int i = x1bhUpgradingActivity.f16862w;
        x1bhUpgradingActivity.f16862w = i + 1;
        return i;
    }

    /* renamed from: c */
    private void m6444c() {
        this.f16850d = new C3588c(0, this);
        this.f16840B = new StringBuffer();
        f16836r = 1;
        this.f16849c = new C2629a();
        this.f16865z = new C2638c();
        this.f16864y = (C2423d) C2379b.m12410a().m12394d();
        this.f16841C = false;
        this.f16864y.c(false);
        this.f16864y.a(this);
        this.f16864y.c(new AbstractC2221d() { // from class: com.fimi.x1bh.module.update.X1bhUpgradingActivity.2
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
            }
        });
        this.f16864y.m12232v().m12275a(new AbstractC2651g() { // from class: com.fimi.x1bh.module.update.X1bhUpgradingActivity.3
            @Override // com.fimi.soul.biz.update.AbstractC2651g
            /* renamed from: a */
            public void mo6430a(boolean z, long j, long j2, int i) {
                C2654j.m11357c("uplaod file progress:" + ((100 * j) / j2) + "%");
                if (!X1bhUpgradingActivity.this.f16864y.m12232v().m12257g()) {
                    X1bhUpgradingActivity.this.f16850d.m7881b();
                    X1bhUpgradingActivity.this.m6458a(153, (int) j, (int) j2);
                }
            }
        });
        C2654j.m11349f();
        this.f16855i = ((DroidPlannerApp) getApplication()).f7895a;
    }

    /* renamed from: d */
    private void m6442d() {
        C2654j.m11357c(C2427e.f8278bb);
        this.f16841C = true;
        m6445b(true);
    }

    /* renamed from: e */
    private void m6440e() {
        Log.i(f16830H, "sendOverPackage: ");
        this.f16864y.m12232v().m12262d("");
        m6434i();
    }

    /* renamed from: f */
    private void m6438f() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f16836r = 0;
        m6434i();
    }

    /* renamed from: g */
    private void m6436g() {
        if (this.f16839A) {
            C2284z.m12695a(this, this.f16840B.toString() + getResources().getString(C2300R.C2303string.updatefail));
        } else {
            C2284z.m12697a(this, (int) C2300R.C2303string.upgrade_firmware_success);
        }
    }

    /* renamed from: h */
    private void m6435h() {
        this.f16839A = true;
        this.f16841C = true;
        this.f16864y.m12232v().m12270a(true);
        getHandler().sendEmptyMessageDelayed(32, 50L);
    }

    /* renamed from: i */
    private void m6434i() {
        Intent intent = new Intent(this, UpgradeResultActivity.class);
        intent.putExtra(UpgradeResultActivity.f14407a, (Serializable) this.f16848b);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: j */
    private void m6433j() {
        if (this.f16850d != null) {
            this.f16850d.m7878d();
        }
    }

    /* renamed from: k */
    private void m6432k() {
        if (!this.f16860u) {
            this.f16860u = true;
            this.f16847J = Toast.makeText(getApplicationContext(), (int) C2300R.C2303string.upgrading_not_disconnect, 0);
            this.f16847J.show();
            getHandler().sendEmptyMessageDelayed(136, 2000L);
            return;
        }
        this.f16864y.m12232v().m12270a(true);
        this.f16847J.cancel();
        startActivity(new Intent(this, X1bhFindNewFirmwareAvtivity.class));
        DroidPlannerApp.f7891f = false;
        finish();
    }

    /* renamed from: a */
    public void m6459a(int i) {
        this.f16862w = i;
    }

    /* renamed from: a */
    public void m6453a(List<FirmwareInfo> list) {
        this.f16845G = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f16844F = new C2151c(this.f16845G);
                this.f16844F.m13417a(this.f16846I);
                this.f16844F.m13420a();
                return;
            }
            if (list.get(i2).getSysId() != 13) {
                C2162c c2162c = new C2162c();
                c2162c.m13365a(list.get(i2).getSysId());
                if (c2162c.m13356e() == C2088d.f6980a) {
                    c2162c.m13366a((byte) 2);
                    c2162c.m13363a(C2163d.m13353a().m13352a(C2088d.f6980a));
                    c2162c.m13359b(list.get(i2).getFwPath());
                } else if (c2162c.m13356e() == C2088d.f6981b) {
                    c2162c.m13366a((byte) 3);
                    c2162c.m13363a(C2163d.m13353a().m13352a(C2088d.f6981b));
                    c2162c.m13359b(list.get(i2).getFwPath());
                } else if (c2162c.m13356e() == C2088d.f6982c) {
                    c2162c.m13366a((byte) 2);
                    c2162c.m13363a(C2163d.m13353a().m13352a(C2088d.f6982c));
                    c2162c.m13359b(list.get(i2).getFwPath());
                }
                this.f16845G.add(c2162c);
            }
            i = i2 + 1;
        }
    }

    @Override // com.fimi.soul.module.update.C3588c.AbstractC3590a
    /* renamed from: a */
    public void mo6452a(boolean z) {
        if (z) {
            this.f16841C = true;
            m6445b(false);
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (z) {
            x11RespCmd.getMsg_id();
            if (!x11RespCmd.isNotification()) {
                return;
            }
            if (C2427e.f8223aZ.equals(x11RespCmd.getType())) {
                Log.i("camera", "onProcessed:put_file_complete ");
                this.f16850d.m7881b();
                C2654j.m11357c(C2427e.f8223aZ);
            }
            if (C2427e.f8279bc.equals(x11RespCmd.getType())) {
                Log.i("camera", "onProcessed:fw_upgrade_complete ");
                this.f16850d.m7878d();
                if (this.f16841C) {
                    this.f16848b.get(0).setIsUpgradeSuccess(true);
                } else {
                    m6442d();
                }
            }
            if (C2427e.f8280bd.equals(x11RespCmd.getType())) {
                Log.i("camera", "onProcessed:fw_unzip_finish ");
            }
            if (C2427e.f8283bg.equals(x11RespCmd.getType())) {
                Log.i("camera", "onProcessed:fw_unzipping ");
                C2654j.m11357c(C2427e.f8283bg);
            }
            if (x11RespCmd.getType().contains(C2427e.f8281be)) {
                Log.i("camera", "onProcessed:progress ");
            }
            if (!x11RespCmd.getType().contains(C2427e.f8277ba)) {
                return;
            }
            Log.i("camera", "onProcessed:put_file_fail ");
            this.f16850d.m7878d();
            this.f16841C = true;
            m6445b(false);
        }
    }

    /* renamed from: a */
    public boolean m6460a() {
        return this.f16863x > this.f16862w;
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
        super.mo6446b(str);
        m6434i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DroidPlannerApp.f7891f = true;
        CameraValue.isUpdate = true;
        this.dpa.m12523b(this);
        this.preferencesUtil = C2277v.m12784a(this);
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_upgrading);
        this.f16843E = getIntent().getBooleanExtra("isForce", false);
        this.f16852f = (ProgressView) findViewById(C2300R.C2302id.progress_view);
        this.f16853g = (TextView) findViewById(C2300R.C2302id.tv_progress);
        C3658ar.m7598b(getAssets(), this.f16853g);
        this.f16854h = (ImageView) findViewById(C2300R.C2302id.img_anim);
        this.f16858l = (TextView) findViewById(C2300R.C2302id.upgrade_result);
        this.f16842D = (TextView) findViewById(C2300R.C2302id.upgrading_warning);
        C3658ar.m7612a(getAssets(), this.f16858l, this.f16842D);
        this.f16856j = (TextView) findViewById(C2300R.C2302id.tv_percent);
        this.f16857k = (TextView) findViewById(C2300R.C2302id.upgrading_warning);
        this.f16857k.setText(C2300R.C2303string.clould_upgrade_check_warm_prompt);
        C3658ar.m7598b(getAssets(), this.f16856j, this.f16857k);
        this.f16862w = 0;
        m6444c();
        m6449b();
        C2462a.m12098a().m12092a(getLocalClassName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m6433j();
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        if (message.what == 153) {
            this.f16858l.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f16848b.get(this.f16862w - 1).getSysName());
            int i = ((int) (((message.arg1 * 1.0f) / message.arg2) * 100.0f)) + ((this.f16862w - 1) * 100);
            this.f16853g.setText(((i * 100) / this.f16861v) + "");
            Log.i(f16830H, "onHandleMessage: progress:" + i + ",arg1:" + message.arg1 + ",arg2:" + message.arg2 + ",seq:" + this.f16862w + ",maxCount:" + this.f16861v);
            this.f16852f.setCurrentCount(i);
        } else if (message.what != 256 && message.what == 119) {
            this.f16858l.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f16848b.get(this.f16862w - 1).getSysName());
        }
        if (message.what == 136) {
            this.f16860u = false;
        }
        if (message.what == 102) {
            if (this.f16848b.get(0).getSysId() == 13) {
                Log.i(f16830H, "onHandleMessage: sUPGRADE_SUCCESS");
                this.f16864y.m12232v().m12262d("");
            }
            m6434i();
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f16843E) {
                m6432k();
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (f16836r == 0) {
            f16836r = 0;
            m6434i();
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
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f16854h.setBackgroundResource(C2300R.C2301drawable.update_anim);
        ((AnimationDrawable) this.f16854h.getBackground()).start();
    }
}
