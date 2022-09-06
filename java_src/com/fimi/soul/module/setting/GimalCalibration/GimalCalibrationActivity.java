package com.fimi.soul.module.setting.GimalCalibration;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.module.setting.GimalCalibration.C3450a;
import com.fimi.soul.module.setting.GimalCalibration.GimalCaliIngFragment;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class GimalCalibrationActivity extends BaseActivity implements View.OnClickListener, GimalCaliIngFragment.AbstractC3447a, C3450a.AbstractC3452a {

    /* renamed from: a */
    TextView f13549a;

    /* renamed from: b */
    TextView f13550b;

    /* renamed from: c */
    Button f13551c;

    /* renamed from: d */
    Button f13552d;

    /* renamed from: e */
    ProgressView f13553e;

    /* renamed from: f */
    C3450a f13554f;

    /* renamed from: g */
    private ImageView f13555g;

    /* renamed from: h */
    private GimalCaliIngFragment f13556h;

    /* renamed from: i */
    private FragmentManager f13557i;

    /* renamed from: j */
    private PercentRelativeLayout f13558j;

    /* renamed from: k */
    private boolean f13559k;

    /* renamed from: a */
    private void m8442a(TextView textView, int i, Button button, int i2, ImageView imageView, int i3) {
        imageView.setImageResource(i3);
        if (!textView.getText().toString().equals(getString(i))) {
            textView.setText(i);
        }
        button.setEnabled(false);
        m8443a(button, i2);
    }

    /* renamed from: f */
    private void m8440f() {
        this.f13555g = (ImageView) findViewById(C2300R.C2302id.img_calibration_plane);
        this.f13549a = (TextView) findViewById(C2300R.C2302id.tv_tips);
        this.f13551c = (Button) findViewById(C2300R.C2302id.btn_start_calibration);
        this.f13551c.setOnClickListener(this);
        this.f13551c.setEnabled(false);
        this.f13550b = (TextView) findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13550b.setText(C2300R.C2303string.gimbal_calibration);
        this.f13552d = (Button) findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13552d.setOnClickListener(this);
        this.f13553e = (ProgressView) findViewById(C2300R.C2302id.pro_calibration);
        this.f13553e.setMaxCount(C3450a.f13575a);
        C3658ar.m7612a(getAssets(), this.f13549a, this.f13551c, this.f13550b);
        this.f13554f = new C3450a(this, this.drone);
        m8439g();
    }

    /* renamed from: g */
    private void m8439g() {
        if (!this.drone.mo11217ab().mo10898a()) {
            m8442a(this.f13549a, C2300R.C2303string.calidisconremote, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (!this.drone.mo11216ac()) {
            m8442a(this.f13549a, C2300R.C2303string.calisiacondrone, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (this.drone.mo11216ac() && this.drone.m11320al()) {
            m8442a(this.f13549a, C2300R.C2303string.caligcremider, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (this.drone.m11318an().m10098an()) {
            m8442a(this.f13549a, C2300R.C2303string.calicompasscoming, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (this.drone.m11318an().m10066u()) {
            m8442a(this.f13549a, C2300R.C2303string.discongc, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.img_no_pan_tilt_calibration_plane);
        } else if (this.drone.m11318an().m10108ad()) {
            m8442a(this.f13549a, C2300R.C2303string.gcpreheat, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (this.drone.m11318an().m10067t()) {
            m8442a(this.f13549a, C2300R.C2303string.gcunready, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
        } else if (this.drone.m11318an().m10124Q()) {
            m8442a(this.f13549a, C2300R.C2303string.compasscgerror, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.img_pan_tilt_calibration_jiggly);
        } else {
            if (!this.f13551c.isEnabled()) {
                C2244b.m13099b(this).m13103a(getResources().getString(C2300R.C2303string.reminder_calibration_canStart));
            }
            this.f13549a.setText(m8438h());
            this.f13551c.setEnabled(true);
            m8443a(this.f13551c, AbstractC4863e.f20785F);
            this.f13555g.setImageResource(C2300R.C2301drawable.imh_pan_tilt_calibration_plane);
        }
    }

    /* renamed from: h */
    private SpannableString m8438h() {
        String string = getString(C2300R.C2303string.gc_calbration_tips);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.gc_calibration_tips)), 0, 11, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.white)), 11, 15, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.gc_calibration_tips)), 16, string.length(), 33);
        return spannableString;
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.GimalCaliIngFragment.AbstractC3447a
    /* renamed from: a */
    public void mo8444a() {
        if (this.f13556h == null || !this.f13556h.isVisible()) {
            return;
        }
        DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(this);
        c3801a.m7031a(getString(C2300R.C2303string.interruptcaliremote));
        c3801a.m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.GimalCalibration.GimalCalibrationActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.GimalCalibration.GimalCalibrationActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                GimalCalibrationActivity.this.f13554f.m8423d();
                GimalCalibrationActivity.this.finish();
            }
        }).m7035a().show();
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: a */
    public void mo8233a(int i) {
        if (this.f13556h != null) {
            this.f13556h.m8446a(i);
        }
        if (!this.f13559k) {
            this.f13559k = true;
            C2244b.m13099b(this).m13103a(getString(C2300R.C2303string.GC_calibrationing));
        }
    }

    /* renamed from: a */
    public void m8443a(TextView textView, int i) {
        textView.setTextColor(textView.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    public void m8441a(Class cls, int i, String str) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(ResultCalibrationActivity.f13564c, i);
        intent.putExtra(ResultCalibrationActivity.f13565d, str);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: a */
    public void mo8230a(String str) {
        if (str == null) {
            m8441a(ResultCalibrationActivity.class, 1, this.drone.f9270d.getString(C2300R.C2303string.GC_califail));
        } else {
            m8441a(ResultCalibrationActivity.class, 1, str);
        }
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: b */
    public void mo8228b() {
        if (this.f13556h == null || this.f13556h.isVisible()) {
            return;
        }
        this.f13557i.beginTransaction().show(this.f13556h).commitAllowingStateLoss();
        this.f13558j.setVisibility(8);
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: b */
    public void mo8227b(int i) {
        m8442a(this.f13549a, i, this.f13551c, 75, this.f13555g, C2300R.C2301drawable.gimbal_calibration_plane);
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: c */
    public void mo8225c() {
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: d */
    public void mo8223d() {
        m8441a(ResultCalibrationActivity.class, 0, getString(C2300R.C2303string.GC_caliSucess));
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: e */
    public void mo8221e() {
        m8439g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f13551c) {
            this.f13554f.m8432a();
        }
        if (view == this.f13552d) {
            finish();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(128, 128);
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_gc_calibration);
        this.f13558j = (PercentRelativeLayout) findViewById(C2300R.C2302id.activity_PL);
        this.f13557i = getSupportFragmentManager();
        this.f13556h = (GimalCaliIngFragment) this.f13557i.findFragmentById(C2300R.C2302id.caligamble);
        if (this.f13556h == null) {
            this.f13556h = new GimalCaliIngFragment();
        }
        if (!this.f13556h.isAdded()) {
            this.f13557i.beginTransaction().add(C2300R.C2302id.caligamble, this.f13556h).hide(this.f13556h).commitAllowingStateLoss();
        } else {
            this.f13557i.beginTransaction().hide(this.f13556h).commitAllowingStateLoss();
        }
        m8440f();
        this.f13559k = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f13554f.m8418g();
        this.f13554f.m8419f();
        if (this.f13554f != null) {
            this.f13554f = null;
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f13556h == null || !this.f13556h.isVisible()) {
            return super.onKeyDown(i, keyEvent);
        }
        mo8444a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f13554f.m8420e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
