package com.fimi.soul.module.update;

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
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.AbstractC2636b;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.p167b.C2346i;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3680i;
import com.fimi.soul.view.TranslationView;
import com.fimi.x1bh.module.main.CloudTerraceMainActivity;
import java.util.List;
/* loaded from: classes.dex */
public class FindOnlineFirmwareAvtivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    TranslationView f14370a;

    /* renamed from: b */
    TextView f14371b;

    /* renamed from: c */
    TextView f14372c;

    /* renamed from: e */
    private Button f14374e;

    /* renamed from: f */
    private Button f14375f;

    /* renamed from: g */
    private Button f14376g;

    /* renamed from: h */
    private Boolean f14377h;

    /* renamed from: i */
    private ListView f14378i;

    /* renamed from: j */
    private TextView f14379j;

    /* renamed from: k */
    private C2346i f14380k;

    /* renamed from: l */
    private boolean f14381l;

    /* renamed from: d */
    List<UpdateVersonBean> f14373d = null;

    /* renamed from: m */
    private String f14382m = C2353b.f7920K;

    /* renamed from: a */
    public void m8048a() {
        if (!C3658ar.m7601b(this)) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        }
        if (!C3658ar.m7593c(this)) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_download_wifi_tip);
            this.f14379j.setText(getString(C2300R.C2303string.network_download_wifi_tip));
        } else if (!m8043f()) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        } else if (!C3658ar.m7586e()) {
            C2284z.m12697a(this, (int) C2300R.C2303string.network_disable_download2);
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
            return;
        } else {
            this.f14379j.setText(getString(C2300R.C2303string.network_download_confirm_tip));
        }
        m8047b();
    }

    /* renamed from: b */
    public void m8047b() {
        Intent intent = new Intent(this, DowningActivity.class);
        intent.putExtra("isForce", this.f14381l);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: c */
    public void m8046c() {
        this.f14374e = (Button) findViewById(C2300R.C2302id.btn_down_after);
        C3658ar.m7612a(getAssets(), this.f14374e);
        this.f14374e.setOnClickListener(this);
        this.f14375f = (Button) findViewById(C2300R.C2302id.btn_down);
        C3658ar.m7612a(getAssets(), this.f14375f);
        this.f14375f.setOnClickListener(this);
        this.f14376g = (Button) findViewById(C2300R.C2302id.btn_down2);
        C3658ar.m7612a(getAssets(), this.f14376g);
        this.f14376g.setOnClickListener(this);
        this.f14370a = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f14370a.setVisibility(0);
        this.f14370a.m7244a();
        this.f14371b = (TextView) findViewById(C2300R.C2302id.update_firmware_title);
        C3658ar.m7612a(getAssets(), this.f14371b);
        this.f14372c = (TextView) findViewById(C2300R.C2302id.down_firmwares_detail_ex);
        C3658ar.m7612a(getAssets(), this.f14372c);
        this.f14379j = (TextView) findViewById(C2300R.C2302id.confirm_tv);
        C3658ar.m7612a(getAssets(), this.f14379j);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2300R.C2303string.update_firmware_title));
        String string = getString(C2300R.C2303string.down_firmwares_detail_ex);
        if (this.f14381l) {
            this.f14374e.setVisibility(8);
            this.f14375f.setVisibility(8);
            this.f14376g.setVisibility(0);
            sb.append(getString(C2300R.C2303string.update_firmware_title_ex));
        } else {
            this.f14374e.setVisibility(0);
            this.f14375f.setVisibility(0);
            this.f14376g.setVisibility(8);
        }
        this.f14371b.setText(sb.toString());
        this.f14372c.setText(String.format(string, C2654j.m11359c()));
        this.f14378i = (ListView) findViewById(C2300R.C2302id.testListView);
    }

    /* renamed from: d */
    public void m8045d() {
        if (!C3658ar.m7601b(this)) {
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else if (!C3658ar.m7593c(this)) {
            this.f14379j.setText(getString(C2300R.C2303string.network_download_wifi_tip));
        } else if (!m8043f()) {
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else if (!C3658ar.m7586e()) {
            this.f14379j.setText(getString(C2300R.C2303string.network_disable_download2));
        } else {
            this.f14379j.setText(getString(C2300R.C2303string.network_download_confirm_tip));
        }
    }

    /* renamed from: e */
    public void m8044e() {
        this.f14380k = new C2346i(this, this.f14373d);
        this.f14378i.setAdapter((ListAdapter) this.f14380k);
    }

    /* renamed from: f */
    public boolean m8043f() {
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
                if (this.f14377h.booleanValue()) {
                    this.preferencesUtil.m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                    this.dpa.m12521d();
                    return;
                } else if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                    startActivity(new Intent(this, FlightActivity.class));
                    return;
                } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
                    return;
                } else {
                    startActivity(new Intent(this, CloudTerraceMainActivity.class));
                    return;
                }
            case C2300R.C2302id.btn_down /* 2131493109 */:
                m8048a();
                return;
            case C2300R.C2302id.btn_down2 /* 2131493110 */:
                m8048a();
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
        this.f14382m = C2353b.f7920K;
        this.f14377h = Boolean.valueOf(this.preferencesUtil.m12787a().getBoolean(this.f14382m, false));
        this.f14373d = C2238c.m13125c().mo13111b(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, UpdateVersonBean.class);
        while (true) {
            int i2 = i;
            if (i2 >= this.f14373d.size()) {
                break;
            } else if ("2".equals(this.f14373d.get(i2).getForceSign())) {
                this.f14381l = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        m8046c();
        m8044e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f14370a != null) {
            this.f14370a.m7236c();
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f14381l) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C2462a.m12098a().m12091a(getLocalClassName(), 1, this.drone);
        m8045d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
