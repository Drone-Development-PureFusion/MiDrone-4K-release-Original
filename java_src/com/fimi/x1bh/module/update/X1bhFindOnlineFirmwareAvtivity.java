package com.fimi.x1bh.module.update;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.AbstractC2636b;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.update.DowningActivity;
import com.fimi.soul.p167b.C2346i;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3680i;
import com.fimi.soul.view.TranslationView;
import java.util.List;
/* loaded from: classes.dex */
public class X1bhFindOnlineFirmwareAvtivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    TranslationView f16817a;

    /* renamed from: b */
    TextView f16818b;

    /* renamed from: c */
    TextView f16819c;

    /* renamed from: e */
    private Button f16821e;

    /* renamed from: f */
    private Button f16822f;

    /* renamed from: g */
    private Button f16823g;

    /* renamed from: h */
    private Boolean f16824h;

    /* renamed from: i */
    private ListView f16825i;

    /* renamed from: j */
    private TextView f16826j;

    /* renamed from: k */
    private C2346i f16827k;

    /* renamed from: l */
    private boolean f16828l;

    /* renamed from: d */
    List<UpdateVersonBean> f16820d = null;

    /* renamed from: m */
    private String f16829m = C2353b.f7920K;

    /* renamed from: a */
    public void m6466a() {
        if (!C3658ar.m7601b(this)) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        }
        if (!C3658ar.m7593c(this)) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_download_wifi_tip);
            this.f16826j.setText(getString(C2300R.C2303string.network_download_wifi_tip));
        } else if (!m6461f()) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        } else if (!C3658ar.m7586e()) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        } else {
            this.f16826j.setText(getString(C2300R.C2303string.network_download_confirm_tip));
        }
        m6465b();
    }

    /* renamed from: b */
    public void m6465b() {
        Intent intent = new Intent(this, DowningActivity.class);
        intent.putExtra("isForce", this.f16828l);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: c */
    public void m6464c() {
        this.f16821e = (Button) findViewById(C2300R.C2302id.btn_down_after);
        C3658ar.m7612a(getAssets(), this.f16821e);
        this.f16821e.setOnClickListener(this);
        this.f16822f = (Button) findViewById(C2300R.C2302id.btn_down);
        C3658ar.m7612a(getAssets(), this.f16822f);
        this.f16822f.setOnClickListener(this);
        this.f16823g = (Button) findViewById(C2300R.C2302id.btn_down2);
        C3658ar.m7612a(getAssets(), this.f16823g);
        this.f16823g.setOnClickListener(this);
        this.f16817a = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f16817a.setVisibility(0);
        this.f16817a.m7244a();
        this.f16818b = (TextView) findViewById(C2300R.C2302id.update_firmware_title);
        C3658ar.m7612a(getAssets(), this.f16818b);
        this.f16819c = (TextView) findViewById(C2300R.C2302id.down_firmwares_detail_ex);
        C3658ar.m7612a(getAssets(), this.f16819c);
        this.f16826j = (TextView) findViewById(C2300R.C2302id.confirm_tv);
        C3658ar.m7612a(getAssets(), this.f16826j);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2300R.C2303string.update_firmware_title));
        String string = getString(C2300R.C2303string.down_firmwares_detail_ex);
        if (this.f16828l) {
            this.f16821e.setVisibility(8);
            this.f16822f.setVisibility(8);
            this.f16823g.setVisibility(0);
            sb.append(getString(C2300R.C2303string.update_firmware_title_ex));
        } else {
            this.f16821e.setVisibility(0);
            this.f16822f.setVisibility(0);
            this.f16823g.setVisibility(8);
        }
        this.f16818b.setText(sb.toString());
        this.f16819c.setText(String.format(string, C2654j.m11359c()));
        this.f16825i = (ListView) findViewById(C2300R.C2302id.testListView);
    }

    /* renamed from: d */
    public void m6463d() {
        if (!C3658ar.m7601b(this)) {
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else if (!C3658ar.m7593c(this)) {
            this.f16826j.setText(getString(C2300R.C2303string.network_download_wifi_tip));
        } else if (!m6461f()) {
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else if (!C3658ar.m7586e()) {
            this.f16826j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else {
            this.f16826j.setText(getString(C2300R.C2303string.network_download_confirm_tip));
        }
    }

    /* renamed from: e */
    public void m6462e() {
        this.f16827k = new C2346i(this, this.f16820d);
        this.f16825i.setAdapter((ListAdapter) this.f16827k);
    }

    /* renamed from: f */
    public boolean m6461f() {
        C3680i c3680i = new C3680i(C2353b.f7942af);
        c3680i.start();
        try {
            c3680i.join(500L);
        } catch (Exception e) {
        }
        return c3680i.m7484a() != null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.btn_down_after /* 2131493108 */:
                if (!this.f16824h.booleanValue()) {
                    startActivity(new Intent(this, FlightActivity.class));
                    return;
                }
                this.preferencesUtil.m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                this.dpa.m12521d();
                return;
            case C2300R.C2302id.btn_down /* 2131493109 */:
                m6466a();
                return;
            case C2300R.C2302id.btn_down2 /* 2131493110 */:
                m6466a();
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
        C2462a.m12098a().m12092a(getLocalClassName());
        setContentView(C2300R.layout.activity_online_new_firmware);
        getWindow().setFlags(128, 128);
        AbstractC2636b.f9127c = true;
        AbstractC2636b.f9126b = true;
        this.preferencesUtil = C2277v.m12784a(this);
        this.f16829m = C2353b.f7920K;
        this.f16824h = Boolean.valueOf(this.preferencesUtil.m12787a().getBoolean(this.f16829m, false));
        this.f16820d = C2238c.m13125c().mo13111b(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, UpdateVersonBean.class);
        while (true) {
            int i2 = i;
            if (i2 >= this.f16820d.size()) {
                break;
            } else if ("2".equals(this.f16820d.get(i2).getForceSign())) {
                this.f16828l = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        m6464c();
        m6462e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f16817a != null) {
            this.f16817a.m7236c();
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f16828l) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C2462a.m12098a().m12091a(getLocalClassName(), 1, this.drone);
        m6463d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
