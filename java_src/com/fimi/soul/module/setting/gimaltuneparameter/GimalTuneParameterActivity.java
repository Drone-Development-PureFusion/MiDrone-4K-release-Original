package com.fimi.soul.module.setting.gimaltuneparameter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.setting.GimalCalibration.C3450a;
import com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterView;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class GimalTuneParameterActivity extends BaseActivity implements View.OnClickListener, C3450a.AbstractC3452a, GimalTuneParameterView.AbstractC3505a {

    /* renamed from: k */
    private static final int f13813k = 1;

    /* renamed from: l */
    private static final int f13814l = 2;

    /* renamed from: m */
    private static final int f13815m = 3;

    /* renamed from: a */
    private Button f13816a;

    /* renamed from: b */
    private Button f13817b;

    /* renamed from: c */
    private Button f13818c;

    /* renamed from: d */
    private Button f13819d;

    /* renamed from: e */
    private TextView f13820e;

    /* renamed from: f */
    private TextView f13821f;

    /* renamed from: g */
    private TextView f13822g;

    /* renamed from: h */
    private GimalTuneParameterView f13823h;

    /* renamed from: i */
    private C3450a f13824i;

    /* renamed from: j */
    private C3507a f13825j;

    /* renamed from: n */
    private boolean f13826n = false;

    /* renamed from: o */
    private boolean f13827o = false;

    /* renamed from: p */
    private int f13828p = 1;

    /* renamed from: q */
    private boolean f13829q = true;

    /* renamed from: r */
    private boolean f13830r = true;

    /* renamed from: s */
    private Handler f13831s = new Handler() { // from class: com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                GimalTuneParameterActivity.this.f13825j.m8200a((byte) 2);
            } else if (message.what == 2) {
                if (GimalTuneParameterActivity.this.f13826n) {
                    return;
                }
                GimalTuneParameterActivity.this.f13824i.m8424c(5);
            } else if (message.what != 3) {
            } else {
                if (GimalTuneParameterActivity.this.f13827o) {
                    GimalTuneParameterActivity.this.f13818c.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_increase_selector);
                    GimalTuneParameterActivity.this.f13819d.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_reduce_selector);
                    GimalTuneParameterActivity.this.f13818c.setEnabled(true);
                    GimalTuneParameterActivity.this.f13819d.setEnabled(true);
                    GimalTuneParameterActivity.this.f13817b.setEnabled(true);
                    GimalTuneParameterActivity.this.f13817b.setAlpha(1.0f);
                    C2284z.m12695a(GimalTuneParameterActivity.this, GimalTuneParameterActivity.this.getString(C2300R.C2303string.gimal_tune_result_fault));
                }
                GimalTuneParameterActivity.this.f13827o = false;
                GimalTuneParameterActivity.this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
            }
        }
    };

    /* renamed from: a */
    private void m8229a(boolean z) {
        if (z) {
            this.f13818c.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_increase_selector);
            this.f13819d.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_reduce_selector);
            this.f13818c.setEnabled(true);
            this.f13819d.setEnabled(true);
            this.f13817b.setEnabled(true);
            this.f13817b.setAlpha(1.0f);
            return;
        }
        this.f13818c.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_increase_no);
        this.f13819d.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_reduce_no);
        this.f13818c.setEnabled(false);
        this.f13819d.setEnabled(false);
        this.f13817b.setEnabled(false);
        this.f13817b.setAlpha(0.3f);
    }

    /* renamed from: g */
    private void m8217g() {
        this.f13816a = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f13816a.setOnClickListener(this);
        this.f13820e = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13820e.setText(C2300R.C2303string.gimbal_tune_parameter);
        this.f13823h = (GimalTuneParameterView) findViewById(C2300R.C2302id.gimal_tune_parameter_view);
        this.f13822g = (TextView) findViewById(C2300R.C2302id.gimal_sensitivity_tv);
        this.f13818c = (Button) findViewById(C2300R.C2302id.increase_btn);
        this.f13819d = (Button) findViewById(C2300R.C2302id.reduce_btn);
        this.f13821f = (TextView) findViewById(C2300R.C2302id.prompt_tv);
        this.f13817b = (Button) findViewById(C2300R.C2302id.gimal_reset_btn);
        this.f13817b.setVisibility(0);
        this.f13817b.setOnClickListener(this);
        this.f13818c.setOnClickListener(this);
        this.f13819d.setOnClickListener(this);
        this.f13823h.setGimalTuneParameterListerner(this);
        C3658ar.m7612a(getAssets(), this.f13820e, this.f13822g, this.f13821f);
    }

    /* renamed from: h */
    private void m8215h() {
        this.f13824i = new C3450a(this, this.drone);
        this.f13822g.setText(getString(C2300R.C2303string.gimal_tune_para_tune_sensitivity, new Object[]{100}));
        this.f13824i.m8420e();
        this.f13823h.setProgress(C2238c.m13123e().m12763f());
        this.f13825j = new C3507a(this.drone);
        this.f13825j.m8200a((byte) 2);
        if (!this.drone.mo11216ac()) {
            this.f13830r = false;
            this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_connect_flight_prompt);
            this.f13823h.setState(GimalTuneParameterView.EnumC3506b.ALL_NO_OPERABLE);
            m8229a(false);
        } else if (this.drone.m11318an().m10066u()) {
            this.f13829q = false;
            this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_connect_gimal_prompt);
            this.f13823h.setState(GimalTuneParameterView.EnumC3506b.ALL_NO_OPERABLE);
            m8229a(false);
        } else {
            this.f13830r = true;
            this.f13829q = true;
            this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_no_move_gimal_prompt);
            m8229a(true);
        }
        C3579a.m7971a().m7970a(3).m7921b();
    }

    /* renamed from: i */
    private int m8213i() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7955c() <= 0) {
            return 0;
        }
        return c3580b.m7955c();
    }

    @Override // com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterView.AbstractC3505a
    /* renamed from: a */
    public void mo8202a() {
        if (m8213i() < 2016) {
            C2284z.m12695a(this, getString(C2300R.C2303string.gimal_please_upgrade_new_fimware));
        } else if (this.drone.m11320al()) {
            C2284z.m12695a(this, getString(C2300R.C2303string.gimal_tune_flight_hint));
        } else {
            this.f13824i.m8424c(6);
        }
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: a */
    public void mo8233a(int i) {
        if (this.drone.m11311au().m10669c() == 6) {
            if (i <= 0 || i == 100) {
                if (i != 100) {
                    return;
                }
                this.f13828p = 0;
                this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
                this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
                this.f13821f.setText(C2300R.C2303string.gimal_tune_para_tune_completed_prompt);
                m8229a(true);
                this.f13825j.m8200a((byte) 2);
                return;
            }
            this.f13828p++;
            if (this.f13828p <= 10) {
                this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_tuning) + ".");
            } else if (this.f13828p <= 20) {
                this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_tuning) + "..");
            } else if (this.f13828p <= 30) {
                this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_tuning) + "...");
            } else {
                this.f13828p = 0;
            }
            this.f13823h.setState(GimalTuneParameterView.EnumC3506b.AUTO_TUNE);
            this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_no_move_gimal_prompt);
            this.f13823h.setTuneProgress(i);
            m8229a(false);
        }
    }

    @Override // com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterView.AbstractC3505a
    /* renamed from: a */
    public void mo8201a(int i, boolean z) {
        if (!z) {
            this.f13822g.setText(getString(C2300R.C2303string.gimal_tune_para_tune_sensitivity, new Object[]{Integer.valueOf(i)}));
        } else if (m8213i() < 2016) {
            C2284z.m12695a(this, getString(C2300R.C2303string.gimal_please_upgrade_new_fimware));
        } else {
            this.f13817b.setEnabled(true);
            this.f13817b.setAlpha(1.0f);
            this.f13825j.m8199a((byte) 2, i, i, i);
        }
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: a */
    public void mo8230a(String str) {
        if (str != null) {
            this.f13821f.setText(str);
            return;
        }
        this.f13821f.setText(this.drone.f9270d.getString(C2300R.C2303string.GC_tune_fail));
        this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
        this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
        m8229a(true);
        this.f13825j.m8200a((byte) 2);
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: b */
    public void mo8228b() {
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: b */
    public void mo8227b(int i) {
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: c */
    public void mo8225c() {
        this.f13831s.removeMessages(1);
        this.f13826n = true;
        this.f13831s.sendEmptyMessageDelayed(1, 1000L);
        this.f13831s.sendEmptyMessageDelayed(1, 2000L);
        this.f13831s.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: d */
    public void mo8223d() {
    }

    @Override // com.fimi.soul.module.setting.GimalCalibration.C3450a.AbstractC3452a
    /* renamed from: e */
    public void mo8221e() {
    }

    /* renamed from: f */
    public void m8219f() {
        DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(this);
        c3801a.m7031a(getString(C2300R.C2303string.interrupt_tune));
        c3801a.m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                GimalTuneParameterActivity.this.f13824i.m8423d();
                GimalTuneParameterActivity.this.finish();
            }
        }).m7035a().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.black_btn) {
            if (this.f13823h.getState() == GimalTuneParameterView.EnumC3506b.AUTO_TUNE) {
                m8219f();
            } else {
                finish();
            }
        } else if (view.getId() == C2300R.C2302id.increase_btn) {
            int progress = this.f13823h.getProgress();
            if (progress >= 120) {
                return;
            }
            if (m8213i() < 2016) {
                C2284z.m12695a(this, getString(C2300R.C2303string.gimal_please_upgrade_new_fimware));
            } else {
                this.f13825j.m8199a((byte) 2, progress + 1, progress + 1, progress + 1);
            }
        } else if (view.getId() == C2300R.C2302id.reduce_btn) {
            int progress2 = this.f13823h.getProgress();
            if (progress2 <= 80) {
                return;
            }
            if (m8213i() < 2016) {
                C2284z.m12695a(this, getString(C2300R.C2303string.gimal_please_upgrade_new_fimware));
            } else {
                this.f13825j.m8199a((byte) 2, progress2 - 1, progress2 - 1, progress2 - 1);
            }
        } else if (view.getId() != C2300R.C2302id.gimal_reset_btn) {
        } else {
            if (m8213i() < 2016) {
                C2284z.m12695a(this, getString(C2300R.C2303string.gimal_please_upgrade_new_fimware));
                return;
            }
            this.f13824i.m8424c(5);
            this.f13817b.setEnabled(false);
            this.f13817b.setAlpha(0.3f);
            this.f13826n = false;
            this.f13827o = true;
            this.f13831s.removeMessages(2);
            this.f13831s.removeMessages(3);
            this.f13831s.sendEmptyMessageDelayed(2, 1000L);
            this.f13831s.sendEmptyMessageDelayed(3, 3000L);
            this.f13823h.setState(GimalTuneParameterView.EnumC3506b.ALL_NO_OPERABLE);
            m8229a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_gimal_tune_parameter);
        m8217g();
        m8215h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f13831s != null) {
            this.f13831s.removeCallbacksAndMessages(null);
        }
        this.f13824i.m8419f();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        switch (enumC2679a) {
            case GIMAL_PARAMETER_CONFIG:
                if (c2657a.mo11218aa().m10662b() != 0 || c2657a.mo11218aa().m10660c() != 2) {
                    return;
                }
                if (c2657a.mo11218aa().m10658d() == 5) {
                    this.f13817b.setEnabled(true);
                    this.f13817b.setAlpha(1.0f);
                }
                if (this.f13827o && c2657a.mo11218aa().m10656e() == 100) {
                    this.f13818c.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_increase_selector);
                    this.f13819d.setBackgroundResource(C2300R.C2301drawable.button_setup_adjust_reduce_selector);
                    this.f13818c.setEnabled(true);
                    this.f13819d.setEnabled(true);
                    this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
                    C2284z.m12695a(this, getString(C2300R.C2303string.gimal_tune_result_success));
                    this.f13827o = false;
                }
                if (c2657a.mo11218aa().m10656e() == 100) {
                    this.f13831s.removeMessages(1);
                }
                byte m10656e = c2657a.mo11218aa().m10656e();
                C2238c.m13123e().m12778b(m10656e);
                this.f13822g.setText(getString(C2300R.C2303string.gimal_tune_para_tune_sensitivity, new Object[]{Integer.valueOf(m10656e)}));
                this.f13823h.setProgress(m10656e);
                return;
            case CLEANALLOBJ:
            case Remotecontrol:
                if (!c2657a.mo11216ac() && this.f13830r) {
                    this.f13830r = false;
                    this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_connect_flight_prompt);
                    this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
                    this.f13823h.setState(GimalTuneParameterView.EnumC3506b.ALL_NO_OPERABLE);
                    m8229a(false);
                    return;
                } else if (c2657a.m11318an().m10066u() && this.f13829q) {
                    this.f13829q = false;
                    this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
                    this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_connect_gimal_prompt);
                    this.f13823h.setState(GimalTuneParameterView.EnumC3506b.ALL_NO_OPERABLE);
                    m8229a(false);
                    return;
                } else if (c2657a.mo11216ac() && !this.f13830r) {
                    this.f13830r = true;
                    this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
                    this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
                    this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_no_move_gimal_prompt);
                    this.f13825j.m8200a((byte) 2);
                    m8229a(true);
                    return;
                } else if (c2657a.m11318an().m10066u() || this.f13829q) {
                    return;
                } else {
                    this.f13829q = true;
                    this.f13823h.setCenterBtnText(getString(C2300R.C2303string.gimal_tune_para_auto_tune));
                    this.f13823h.setState(GimalTuneParameterView.EnumC3506b.NOMAL);
                    this.f13821f.setText(C2300R.C2303string.gimal_tune_parameter_no_move_gimal_prompt);
                    this.f13825j.m8200a((byte) 2);
                    m8229a(true);
                    return;
                }
            case PTZ_GAIN:
                if (this.f13823h == null) {
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f13823h.getState() == GimalTuneParameterView.EnumC3506b.AUTO_TUNE) {
            m8219f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
