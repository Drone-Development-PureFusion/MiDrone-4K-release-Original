package com.fimi.soul.module.update;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.p151f.C2145d;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.AbstractC2636b;
import com.fimi.soul.biz.update.AbstractC2651g;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.x1bh.module.main.CloudTerraceMainActivity;
import com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class DowningActivity extends BaseActivity {

    /* renamed from: g */
    private static final int f14309g = 100;

    /* renamed from: h */
    private static final int f14310h = 0;

    /* renamed from: m */
    private static final int f14311m = 1;

    /* renamed from: b */
    List<UpdateVersonBean> f14313b;

    /* renamed from: c */
    private ImageView f14314c;

    /* renamed from: d */
    private ProgressView f14315d;

    /* renamed from: e */
    private TextView f14316e;

    /* renamed from: k */
    private long f14320k;

    /* renamed from: l */
    private boolean f14321l;

    /* renamed from: n */
    private C2657a f14322n;

    /* renamed from: o */
    private TextView f14323o;

    /* renamed from: p */
    private TextView f14324p;

    /* renamed from: q */
    private boolean f14325q;

    /* renamed from: r */
    private Toast f14326r;

    /* renamed from: f */
    private int f14317f = 0;

    /* renamed from: a */
    C3578a f14312a = null;

    /* renamed from: i */
    private long f14318i = 0;

    /* renamed from: j */
    private int f14319j = 1;

    /* renamed from: a */
    private void m8075a(UpdateVersonBean updateVersonBean) {
        this.f14312a.m7973b(updateVersonBean, this.f14312a.m7972e(updateVersonBean), new AbstractC2651g() { // from class: com.fimi.soul.module.update.DowningActivity.1
            @Override // com.fimi.soul.biz.update.AbstractC2651g
            /* renamed from: a */
            public void mo6430a(boolean z, long j, long j2, int i) {
                if (!z) {
                    Message message = new Message();
                    message.what = 100;
                    message.arg1 = (int) j;
                    message.arg2 = (int) j2;
                    DowningActivity.this.getHandler().sendMessageDelayed(message, 300L);
                } else if (j == -2) {
                    DowningActivity.this.m8069c();
                } else if (DowningActivity.this.f14319j < DowningActivity.this.f14317f) {
                    DowningActivity.this.getHandler().sendEmptyMessageDelayed(0, 300L);
                } else if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                    if (DowningActivity.this.f14322n.mo11216ac()) {
                        DowningActivity.this.m8073a(FindNewFirmwareAvtivity.class);
                        return;
                    }
                    C2284z.m12697a(DowningActivity.this, (int) C2300R.C2303string.finish_down);
                    DowningActivity.this.m8073a(FlightActivity.class);
                } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
                } else {
                    if (C2145d.m13447b().m13444d()) {
                        DowningActivity.this.m8073a(X1bhFindNewFirmwareAvtivity.class);
                        return;
                    }
                    C2284z.m12697a(DowningActivity.this, (int) C2300R.C2303string.cloud_finish_down);
                    DowningActivity.this.m8073a(CloudTerraceMainActivity.class);
                }
            }
        });
    }

    /* renamed from: a */
    private void m8072a(List<UpdateVersonBean> list) {
        File file = new File(C3681j.m7457v());
        if (!file.exists()) {
            file.mkdir();
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f14317f = list.size();
        this.f14312a = new C3578a();
        this.f14318i = C2654j.m11365a(list);
        this.f14315d.setMaxCount((float) this.f14318i);
        m8075a(list.get(0));
    }

    /* renamed from: d */
    private void m8067d() {
        if (this.f14321l) {
            AbstractC2636b.f9126b = true;
            this.f14326r.cancel();
            m8073a(FindOnlineFirmwareAvtivity.class);
            finish();
            return;
        }
        this.f14321l = true;
        this.f14326r = Toast.makeText(getApplicationContext(), (int) C2300R.C2303string.cancel_downing, 0);
        this.f14326r.show();
        getHandler().sendEmptyMessageDelayed(1, 2000L);
    }

    /* renamed from: a */
    public void m8076a() {
        this.f14323o = (TextView) findViewById(C2300R.C2302id.upgrade_result);
        this.f14324p = (TextView) findViewById(C2300R.C2302id.upgrading_warning);
        C3658ar.m7612a(getAssets(), this.f14323o);
        C3658ar.m7612a(getAssets(), this.f14324p);
    }

    /* renamed from: a */
    public void m8073a(Class cls) {
        startActivity(new Intent(this, cls));
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: b */
    public void m8071b() {
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2300R.C2303string.down_ing2));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f14313b.size()) {
                this.f14324p.setText(sb.toString());
                return;
            }
            sb.append(this.f14313b.get(i2).getSysname());
            if (i2 != this.f14313b.size() - 1) {
                sb.append(getString(C2300R.C2303string.upgrade_symbol));
            }
            i = i2 + 1;
        }
    }

    /* renamed from: c */
    public void m8069c() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.f14319j - 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f14313b.size()) {
                Intent intent = new Intent(this, DownFailedActivity.class);
                intent.putExtra("DownLoadFailedInfo", stringBuffer.toString().substring(0, stringBuffer.length() - 1));
                startActivity(intent);
                finish();
                overridePendingTransition(17432576, 17432577);
                return;
            }
            stringBuffer.append(this.f14313b.get(i2).getSysname());
            if (i2 != this.f14313b.size() - 1) {
                stringBuffer.append(getString(C2300R.C2303string.upgrade_symbol));
            } else {
                stringBuffer.append(getString(C2300R.C2303string.downfail1));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dpa.m12523b(this);
        setContentView(C2300R.layout.activity_downing);
        getWindow().setFlags(128, 128);
        this.f14325q = getIntent().getBooleanExtra("isForce", false);
        this.f14314c = (ImageView) findViewById(C2300R.C2302id.down_img_anim);
        this.f14315d = (ProgressView) findViewById(C2300R.C2302id.down_progress_view);
        this.f14316e = (TextView) findViewById(C2300R.C2302id.tv_down_progress);
        AbstractC2636b.f9126b = false;
        AbstractC2636b.f9127c = false;
        this.f14313b = C2238c.m13125c().mo13111b(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, UpdateVersonBean.class);
        m8072a(this.f14313b);
        this.f14322n = this.dpa.f7895a;
        m8076a();
        m8071b();
        C2462a.m12098a().m12092a(getLocalClassName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC2636b.f9127c = true;
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message.what == 100) {
            long j = this.f14320k + message.arg1;
            this.f14316e.setText(((100 * j) / this.f14318i) + "");
            this.f14315d.setCurrentCount((float) j);
        }
        if (message.what == 0) {
            this.f14320k = Long.valueOf(this.f14313b.get(this.f14319j - 1).getSize()).longValue() + this.f14320k;
            this.f14319j++;
            m8075a(this.f14313b.get(this.f14319j));
        }
        if (message.what == 1) {
            this.f14321l = false;
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f14325q) {
                m8067d();
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C2462a.m12098a().m12091a(getLocalClassName(), 1, this.f14322n);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f14314c.setBackgroundResource(C2300R.C2301drawable.update_anim);
        ((AnimationDrawable) this.f14314c.getBackground()).start();
    }
}
