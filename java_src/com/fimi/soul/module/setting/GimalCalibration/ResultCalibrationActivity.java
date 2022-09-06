package com.fimi.soul.module.setting.GimalCalibration;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.utils.C3658ar;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class ResultCalibrationActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    public static final int f13562a = 0;

    /* renamed from: b */
    public static final int f13563b = 1;

    /* renamed from: c */
    public static final String f13564c = "calibration_result";

    /* renamed from: d */
    public static final String f13565d = "calibration_result_reson";

    /* renamed from: e */
    private TextView f13566e;

    /* renamed from: f */
    private Button f13567f;

    /* renamed from: g */
    private Button f13568g;

    /* renamed from: h */
    private Button f13569h;

    /* renamed from: i */
    private Button f13570i;

    /* renamed from: j */
    private ImageView f13571j;

    /* renamed from: k */
    private TextView f13572k;

    /* renamed from: l */
    private TextView f13573l;

    /* renamed from: m */
    private int f13574m;

    /* renamed from: a */
    private void m8437a() {
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra(f13564c, 0);
            String stringExtra = intent.getStringExtra(f13565d);
            if (intExtra == 1) {
                this.f13572k.setText(C2300R.C2303string.califail);
                C2244b.m13099b(this).m13103a(getString(C2300R.C2303string.calibration_failure));
                if (stringExtra != null) {
                    this.f13573l.setText(stringExtra);
                }
                PercentRelativeLayout.LayoutParams layoutParams = (PercentRelativeLayout.LayoutParams) this.f13571j.getLayoutParams();
                layoutParams.setMargins(0, (int) (this.f13574m * 0.12592f), 0, 0);
                this.f13571j.setLayoutParams(layoutParams);
                this.f13571j.setImageResource(C2300R.C2301drawable.icon_calibration_defeat);
                m8434c();
                return;
            }
            this.f13572k.setText(getString(C2300R.C2303string.calisucess));
            C2244b.m13099b(this).m13103a(getString(C2300R.C2303string.calisucess));
            if (stringExtra != null) {
                this.f13573l.setText("");
            }
            PercentRelativeLayout.LayoutParams layoutParams2 = (PercentRelativeLayout.LayoutParams) this.f13571j.getLayoutParams();
            layoutParams2.setMargins(0, (int) (this.f13574m * 0.1111f), 0, 0);
            this.f13571j.setLayoutParams(layoutParams2);
            this.f13571j.setImageResource(C2300R.C2301drawable.icon_calibration_succeed);
            m8433d();
        }
    }

    /* renamed from: b */
    private void m8435b() {
        this.f13571j = (ImageView) findViewById(C2300R.C2302id.tagIcon);
        this.f13566e = (TextView) findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13566e.setText(C2300R.C2303string.gccalisucess);
        this.f13567f = (Button) findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13567f.setOnClickListener(this);
        this.f13568g = (Button) findViewById(C2300R.C2302id.quit);
        this.f13568g.setOnClickListener(this);
        this.f13569h = (Button) findViewById(C2300R.C2302id.again);
        this.f13569h.setOnClickListener(this);
        this.f13570i = (Button) findViewById(C2300R.C2302id.sucesscomplete);
        this.f13570i.setOnClickListener(this);
        this.f13572k = (TextView) findViewById(C2300R.C2302id.destitle);
        this.f13573l = (TextView) findViewById(C2300R.C2302id.calireason);
        m8436a(this.f13568g, 128);
        m8436a(this.f13569h, AbstractC4863e.f20785F);
        C3658ar.m7612a(getAssets(), this.f13566e, this.f13567f, this.f13568g, this.f13569h, this.f13570i, this.f13572k, this.f13573l);
    }

    /* renamed from: c */
    private void m8434c() {
        this.f13568g.setVisibility(0);
        this.f13569h.setVisibility(0);
        this.f13570i.setVisibility(8);
    }

    /* renamed from: d */
    private void m8433d() {
        this.f13568g.setVisibility(8);
        this.f13569h.setVisibility(8);
        this.f13570i.setVisibility(0);
    }

    /* renamed from: a */
    public void m8436a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.quit /* 2131492875 */:
                finish();
                return;
            case C2300R.C2302id.again /* 2131493220 */:
                startActivity(new Intent(this, GimalCalibrationActivity.class));
                finish();
                return;
            case C2300R.C2302id.sucesscomplete /* 2131493221 */:
                finish();
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(128, 128);
        super.onCreate(bundle);
        setContentView(C2300R.layout.caliremotesucess);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f13574m = displayMetrics.heightPixels;
        m8435b();
        m8437a();
    }
}
