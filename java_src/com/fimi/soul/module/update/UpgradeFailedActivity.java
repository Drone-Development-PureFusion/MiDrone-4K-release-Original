package com.fimi.soul.module.update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.drone.p199e.C2837o;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class UpgradeFailedActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private TextView f14399a;

    /* renamed from: b */
    private TextView f14400b;

    /* renamed from: c */
    private Button f14401c;

    /* renamed from: d */
    private Button f14402d;

    /* renamed from: e */
    private ImageView f14403e;

    /* renamed from: f */
    private Boolean f14404f;

    /* renamed from: g */
    private Boolean f14405g;

    /* renamed from: h */
    private C2277v f14406h;

    /* renamed from: a */
    public void m8032a() {
        C2837o.f10459a.f9714d = (byte) 0;
        C2837o.f10459a.f9715e = (byte) 2;
        this.drone.mo11217ab().mo10897a(C2837o.f10459a.mo11073b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.retry_btn /* 2131492966 */:
                if (!this.drone.mo11217ab().mo10898a()) {
                    finish();
                    return;
                }
                startActivity(new Intent(this, UpgradingActivity.class));
                finish();
                overridePendingTransition(17432576, 17432577);
                return;
            case C2300R.C2302id.noconnect_bt /* 2131493126 */:
                if (!this.f14404f.booleanValue()) {
                    startActivity(new Intent(this, FlightActivity.class));
                    return;
                }
                C2277v.m12784a(this).m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                this.dpa.m12521d();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dpa.m12523b(this);
        this.f14406h = C2277v.m12784a(this);
        getWindow().setFlags(128, 128);
        this.f14404f = Boolean.valueOf(this.f14406h.m12787a().getBoolean(C2353b.f7920K, false));
        setContentView(C2300R.layout.activity_upgrade_failed);
        this.f14399a = (TextView) findViewById(C2300R.C2302id.upgradeResult);
        C3658ar.m7612a(getAssets(), this.f14399a);
        this.f14400b = (TextView) findViewById(C2300R.C2302id.failedText);
        C3658ar.m7612a(getAssets(), this.f14400b);
        this.f14402d = (Button) findViewById(C2300R.C2302id.noconnect_bt);
        this.f14402d.setOnClickListener(this);
        this.f14401c = (Button) findViewById(C2300R.C2302id.retry_btn);
        this.f14401c.setOnClickListener(this);
        this.f14403e = (ImageView) findViewById(C2300R.C2302id.upgrade_iv);
        this.f14405g = Boolean.valueOf(getIntent().getBooleanExtra(C2353b.f7918I, true));
        if (!this.f14405g.booleanValue()) {
            this.f14400b.setText(getIntent().getStringExtra("reson"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m8032a();
    }
}
