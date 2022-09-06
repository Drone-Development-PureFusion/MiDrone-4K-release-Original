package com.fimi.soul.module.update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class DownFailedActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private TextView f14300a;

    /* renamed from: b */
    private TextView f14301b;

    /* renamed from: c */
    private Button f14302c;

    /* renamed from: d */
    private Button f14303d;

    /* renamed from: e */
    private ImageView f14304e;

    /* renamed from: f */
    private Boolean f14305f;

    /* renamed from: g */
    private Boolean f14306g;

    /* renamed from: h */
    private C2277v f14307h;

    /* renamed from: i */
    private String f14308i = C2353b.f7920K;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.download_later /* 2131492965 */:
                if (!this.f14305f.booleanValue()) {
                    startActivity(new Intent(this, FlightActivity.class));
                    return;
                }
                this.f14307h.m12787a().edit().putBoolean(C2353b.f7918I, true).commit();
                this.dpa.m12521d();
                return;
            case C2300R.C2302id.retry_btn /* 2131492966 */:
                if (!C3658ar.m7601b(this)) {
                    C2284z.m12697a(this, (int) C2300R.C2303string.no_available_network);
                    return;
                }
                startActivity(new Intent(this, DowningActivity.class));
                finish();
                overridePendingTransition(17432576, 17432577);
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
        this.f14307h = C2277v.m12784a(this);
        this.f14308i = C2353b.f7920K;
        getWindow().setFlags(128, 128);
        this.f14305f = Boolean.valueOf(this.f14307h.m12787a().getBoolean(this.f14308i, false));
        setContentView(C2300R.layout.activity_down_failed);
        this.f14300a = (TextView) findViewById(C2300R.C2302id.downResult);
        this.f14301b = (TextView) findViewById(C2300R.C2302id.downFailedText);
        C3658ar.m7612a(getAssets(), this.f14300a, this.f14301b);
        this.f14303d = (Button) findViewById(C2300R.C2302id.download_later);
        this.f14303d.setOnClickListener(this);
        this.f14302c = (Button) findViewById(C2300R.C2302id.retry_btn);
        this.f14302c.setOnClickListener(this);
        this.f14304e = (ImageView) findViewById(C2300R.C2302id.upgrade_iv);
        this.f14306g = Boolean.valueOf(getIntent().getBooleanExtra(C2353b.f7918I, true));
        this.f14301b.setText(getIntent().getStringExtra("DownLoadFailedInfo"));
    }
}
