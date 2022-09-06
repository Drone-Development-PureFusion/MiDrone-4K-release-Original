package com.fimi.soul.module.setting.newhand;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.setting.C3489d;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class GpsSettingActivity extends BaseActivity implements View.OnClickListener, SwitchButton.AbstractC2291a, C2678d.AbstractC2680b {

    /* renamed from: B */
    private static final int f13957B = 1;

    /* renamed from: C */
    private static final int f13958C = 2;

    /* renamed from: D */
    private static final int f13959D = 3;

    /* renamed from: E */
    private static final int f13960E = 4;

    /* renamed from: F */
    private static final int f13961F = 1000;

    /* renamed from: G */
    private static final float f13962G = 0.3f;

    /* renamed from: H */
    private static final float f13963H = 1.0f;

    /* renamed from: I */
    private static final int f13964I = 300;

    /* renamed from: J */
    private static final int f13965J = 3000;

    /* renamed from: b */
    public static final String f13966b = "newhand_mode";

    /* renamed from: c */
    public static final String f13967c = "optical_flow_mode";

    /* renamed from: d */
    public static final String f13968d = "force_attitude_mode";

    /* renamed from: a */
    TextView f13975a;

    /* renamed from: e */
    private RelativeLayout f13976e;

    /* renamed from: f */
    private RelativeLayout f13977f;

    /* renamed from: g */
    private RelativeLayout f13978g;

    /* renamed from: h */
    private TextView f13979h;

    /* renamed from: i */
    private TextView f13980i;

    /* renamed from: j */
    private TextView f13981j;

    /* renamed from: k */
    private TextView f13982k;

    /* renamed from: l */
    private TextView f13983l;

    /* renamed from: m */
    private TextView f13984m;

    /* renamed from: n */
    private ImageView f13985n;

    /* renamed from: o */
    private ImageView f13986o;

    /* renamed from: p */
    private SwitchButton f13987p;

    /* renamed from: q */
    private Context f13988q;

    /* renamed from: r */
    private AbstractC3544d f13989r;

    /* renamed from: s */
    private C3580b f13990s;

    /* renamed from: t */
    private boolean f13991t;

    /* renamed from: u */
    private C2657a f13992u;

    /* renamed from: w */
    private int f13994w;

    /* renamed from: x */
    private int f13995x;

    /* renamed from: y */
    private int f13996y;

    /* renamed from: z */
    private int f13997z;

    /* renamed from: v */
    private boolean f13993v = false;

    /* renamed from: A */
    private boolean f13969A = false;

    /* renamed from: K */
    private boolean f13970K = false;

    /* renamed from: L */
    private boolean f13971L = false;

    /* renamed from: M */
    private boolean f13972M = false;

    /* renamed from: N */
    private boolean f13973N = false;

    /* renamed from: O */
    private Handler f13974O = new Handler() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    C3489d.m8302a(GpsSettingActivity.this.f13992u).m8304a();
                    return;
                case 2:
                    GpsSettingActivity.this.f13989r.mo8118a();
                    return;
                case 3:
                    GpsSettingActivity.this.f13989r.mo8111b();
                    return;
                case 4:
                    if (!GpsSettingActivity.this.f13970K) {
                        Toast.makeText(GpsSettingActivity.this.f13988q, (int) C2300R.C2303string.gps_setting_get_return_height_fail, 0).show();
                        GpsSettingActivity.this.f13983l.setText(C3530b.f14164ao);
                    }
                    if (!GpsSettingActivity.this.f13972M) {
                        Toast.makeText(GpsSettingActivity.this.f13988q, (int) C2300R.C2303string.gps_setting_flight_distance_fail, 0).show();
                        if (GpsSettingActivity.this.f13987p.getToggleOn()) {
                            GpsSettingActivity.this.f13987p.m12667a(false, true);
                            GpsSettingActivity.this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
                        }
                    }
                    if (GpsSettingActivity.this.f13971L) {
                        return;
                    }
                    Toast.makeText(GpsSettingActivity.this.f13988q, (int) C2300R.C2303string.get_setting_flight_speed_fail, 0).show();
                    GpsSettingActivity.this.f13982k.setText(C3530b.f14164ao);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: a */
    private void m8180a() {
        this.f13976e = (RelativeLayout) findViewById(C2300R.C2302id.flight_speed_rl);
        this.f13977f = (RelativeLayout) findViewById(C2300R.C2302id.flight_distance_rl);
        this.f13978g = (RelativeLayout) findViewById(C2300R.C2302id.flight_back_height_rl);
        this.f13976e.setOnClickListener(this);
        this.f13977f.setOnClickListener(this);
        this.f13978g.setOnClickListener(this);
        this.f13979h = (TextView) findViewById(C2300R.C2302id.flight_speed_setting_coontent_tv);
        this.f13980i = (TextView) findViewById(C2300R.C2302id.flight_distance_settig_coontent_tv);
        this.f13984m = (TextView) findViewById(C2300R.C2302id.flight_distance_settig_child_coontent_tv);
        this.f13981j = (TextView) findViewById(C2300R.C2302id.flight_back_height_coontent_tv);
        this.f13982k = (TextView) findViewById(C2300R.C2302id.flight_speed_setting_delcare);
        this.f13983l = (TextView) findViewById(C2300R.C2302id.flight_back_height_setting_delcare);
        TextView textView = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        textView.setText(getString(C2300R.C2303string.setting_gps_mode));
        this.f13975a = (TextView) findViewById(C2300R.C2302id.is_connect_tv);
        C3658ar.m7612a(getAssets(), this.f13979h, this.f13980i, this.f13984m, this.f13981j, this.f13982k, this.f13983l, textView, this.f13975a);
        this.f13985n = (ImageView) findViewById(C2300R.C2302id.flight_speed_setting_more_iv);
        this.f13986o = (ImageView) findViewById(C2300R.C2302id.flight_back_height_setting_more_iv);
        this.f13987p = (SwitchButton) findViewById(C2300R.C2302id.flight_distance_switch_btn);
        this.f13987p.setOnSwitchListener(this);
        this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
        findViewById(C2300R.C2302id.black_btn).setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GpsSettingActivity.this.finish();
            }
        });
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m8176a(boolean z) {
        float f = z ? f13962G : 1.0f;
        this.f13979h.setAlpha(f);
        this.f13982k.setAlpha(f);
        this.f13985n.setAlpha(f);
        this.f13980i.setAlpha(f);
        this.f13984m.setAlpha(f);
        this.f13987p.setAlpha(f);
        if (z) {
            this.f13976e.setBackgroundColor(getResources().getColor(C2300R.color.list_nomal));
            this.f13977f.setBackgroundColor(getResources().getColor(C2300R.color.list_nomal));
            return;
        }
        this.f13976e.setBackground(getResources().getDrawable(C2300R.C2301drawable.list_setting_selector));
        this.f13977f.setBackground(getResources().getDrawable(C2300R.C2301drawable.list_setting_selector));
    }

    @TargetApi(16)
    /* renamed from: b */
    private void m8173b(boolean z) {
        float f = z ? f13962G : 1.0f;
        this.f13981j.setAlpha(f);
        this.f13983l.setAlpha(f);
        this.f13986o.setAlpha(f);
        if (z) {
            this.f13973N = true;
            this.f13978g.setBackgroundColor(getResources().getColor(C2300R.color.list_nomal));
            return;
        }
        this.f13973N = false;
        this.f13978g.setBackground(getResources().getDrawable(C2300R.C2301drawable.list_setting_selector));
    }

    /* renamed from: a */
    public void m8179a(int i, boolean z) {
        if (!z) {
            this.f13996y = i;
            C2238c.m13123e().m12773c(this.f13996y + "");
        }
        if (i <= 6) {
            this.f13982k.setText(i + this.f13988q.getString(C2300R.C2303string.speed_unit_m) + this.f13988q.getString(C2300R.C2303string.setting_speed_low));
        } else if (i <= 6 || i > 10) {
            this.f13982k.setText(i + this.f13988q.getString(C2300R.C2303string.speed_unit_m) + this.f13988q.getString(C2300R.C2303string.setting_speed_hight));
        } else {
            this.f13982k.setText(i + this.f13988q.getString(C2300R.C2303string.speed_unit_m) + this.f13988q.getString(C2300R.C2303string.setting_speed_standard));
        }
    }

    @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
    /* renamed from: a */
    public void mo6579a(View view, boolean z) {
        if (view.getId() == C2300R.C2302id.flight_distance_switch_btn) {
            if (z) {
                this.f13987p.m12667a(false, false);
            } else {
                this.f13987p.m12667a(true, false);
            }
            if (this.f13993v) {
                return;
            }
            this.f13989r.mo8115a(this.f13997z, new AbstractC3545e() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.8
                @Override // com.fimi.soul.module.setting.newhand.AbstractC3545e
                /* renamed from: a */
                public void mo8106a(int i) {
                    GpsSettingActivity.this.f13997z = i;
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.flight_speed_rl /* 2131493014 */:
                if (this.f13993v) {
                    return;
                }
                this.f13989r.mo8109b(this.f13996y, new AbstractC3545e() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.3
                    @Override // com.fimi.soul.module.setting.newhand.AbstractC3545e
                    /* renamed from: a */
                    public void mo8106a(int i) {
                        GpsSettingActivity.this.f13996y = i;
                    }
                });
                return;
            case C2300R.C2302id.flight_distance_rl /* 2131493018 */:
                if (this.f13993v) {
                    return;
                }
                this.f13989r.mo8115a(this.f13997z, new AbstractC3545e() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.4
                    @Override // com.fimi.soul.module.setting.newhand.AbstractC3545e
                    /* renamed from: a */
                    public void mo8106a(int i) {
                        GpsSettingActivity.this.f13997z = i;
                    }
                });
                return;
            case C2300R.C2302id.flight_back_height_rl /* 2131493022 */:
                if (this.f13973N) {
                    return;
                }
                if (!C2367d.m12459a().m12438k() && this.f13994w < C3489d.f13754g) {
                    C2284z.m12694a(this.f13988q, this.f13988q.getString(C2300R.C2303string.please_update_the_last_flight_version), 0);
                    return;
                } else if (!this.f13992u.mo11216ac()) {
                    C2284z.m12696a(this.f13988q, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
                    return;
                } else if (!C2367d.m12459a().m12438k() || !this.f13992u.m11320al() || !(this.f13992u.m11312at().m10702e() == 7 || this.f13992u.m11312at().m10702e() == 8)) {
                    new DialogC3800f.C3804b(this.f13988q).m7003c(this.f13988q.getString(C2300R.C2303string.return_height)).m7010b(120).m7017a(30).m7013a(this.f13988q.getString(C2300R.C2303string.distance_unit_m)).m7008b(this.f13988q.getString(C2300R.C2303string.dialog_height_unit)).m7002d(this.f13988q.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7005c(Integer.parseInt(C2238c.m13123e().m12756h())).m7012a(this.f13988q.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7007b(this.f13988q.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C3489d.m8302a(GpsSettingActivity.this.f13992u).m8303a(GpsSettingActivity.this.f13995x);
                        }
                    }).m7016a(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.module.setting.newhand.GpsSettingActivity.5
                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                            GpsSettingActivity.this.f13995x = i + 30;
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    }).m7018a().show();
                    return;
                } else {
                    C2284z.m12694a(this.f13988q, this.f13988q.getString(C2300R.C2303string.not_set_back_back_height), C2284z.f7606b);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_gps_setting);
        getWindow().setFlags(128, 128);
        m8180a();
        this.f13988q = this;
        this.f13992u = ((DroidPlannerApp) getApplication()).f7895a;
        if (getIntent().getBooleanExtra(f13966b, true)) {
            m8179a(6, true);
            this.f13983l.setText(30 + getString(C2300R.C2303string.distance_unit_m));
        }
        if (this.f13992u.mo11216ac()) {
            this.f13975a.setVisibility(4);
            if (getIntent().getBooleanExtra(f13966b, true) || getIntent().getBooleanExtra(f13968d, false)) {
                m8176a(true);
                m8173b(true);
                this.f13993v = true;
            }
        } else {
            this.f13975a.setVisibility(0);
            m8176a(true);
            m8173b(true);
            this.f13993v = true;
            this.f13969A = true;
        }
        if (this.f13992u.m11312at().m10702e() == 7 || this.f13992u.m11312at().m10702e() == 8) {
            m8173b(true);
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case NEW_HAND_OPERATE:
                if (c2657a.m11310av().m10573d() == 51) {
                    if (c2657a.m11310av().m10571f() != 2) {
                        return;
                    }
                    if (c2657a.m11310av().m10568i() != 0) {
                        C2284z.m12697a(this.f13988q, (int) C2300R.C2303string.set_model_fail);
                        return;
                    }
                    C2284z.m12697a(this.f13988q, (int) C2300R.C2303string.set_model_success);
                    if (c2657a.m11310av().m10570g() != 7) {
                        if (c2657a.m11310av().m10570g() != 3) {
                            return;
                        }
                        this.f13974O.sendEmptyMessageDelayed(3, 1000L);
                        m8179a(c2657a.m11310av().m10569h(), false);
                        return;
                    }
                    this.f13974O.sendEmptyMessageDelayed(2, 1000L);
                    if (c2657a.m11310av().m10569h() == 10000) {
                        this.f13987p.m12667a(true, true);
                        this.f13984m.setText(C2300R.C2303string.gps_setting_distance_unlimt);
                        this.f13997z = 10000;
                        return;
                    }
                    this.f13987p.m12667a(false, true);
                    this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
                    this.f13997z = 500;
                    return;
                } else if (c2657a.m11310av().m10573d() != 34 || c2657a.m11310av().m10571f() != 2) {
                    return;
                } else {
                    if (c2657a.m11310av().m10570g() != 7) {
                        if (c2657a.m11310av().m10570g() != 3) {
                            return;
                        }
                        this.f13971L = true;
                        int m10569h = c2657a.m11310av().m10569h();
                        if (m10569h != 0) {
                            m8179a(m10569h, false);
                            return;
                        } else {
                            m8179a(10, false);
                            return;
                        }
                    }
                    this.f13972M = true;
                    int m10569h2 = c2657a.m11310av().m10569h();
                    if (m10569h2 != 0) {
                        C2238c.m13123e().m12783a(m10569h2 + "");
                    }
                    if (m10569h2 == 10000) {
                        this.f13987p.m12667a(true, true);
                        this.f13984m.setText(C2300R.C2303string.gps_setting_distance_unlimt);
                        this.f13997z = 10000;
                        return;
                    }
                    this.f13987p.m12667a(false, true);
                    this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
                    this.f13997z = 500;
                    return;
                }
            case RETURN_HEIGHT:
                if (c2657a.mo11207r().m10208b() == C3489d.f13751d) {
                    if (c2657a.mo11207r().m10204d() == C3489d.f13753f) {
                        C2284z.m12697a(this.f13988q, (int) C2300R.C2303string.set_model_success);
                        int m10206c = (int) c2657a.mo11207r().m10206c();
                        C2238c.m13123e().m12777b(m10206c + "");
                        this.f13995x = m10206c;
                        this.f13983l.setText(this.f13995x + this.f13988q.getString(C2300R.C2303string.distance_unit_m));
                    } else {
                        C2284z.m12697a(this.f13988q, (int) C2300R.C2303string.set_model_fail);
                    }
                    this.f13974O.sendEmptyMessageDelayed(1, 1000L);
                    return;
                } else if (c2657a.mo11207r().m10208b() != C3489d.f13752e) {
                    return;
                } else {
                    this.f13970K = true;
                    if (c2657a.mo11207r().m10204d() != C3489d.f13753f) {
                        return;
                    }
                    int m10206c2 = (int) c2657a.mo11207r().m10206c();
                    C2238c.m13123e().m12777b(m10206c2 + "");
                    this.f13995x = m10206c2;
                    this.f13983l.setText(this.f13995x + this.f13988q.getString(C2300R.C2303string.distance_unit_m));
                    return;
                }
            case CLEANALLOBJ:
            case Remotecontrol:
                if (!c2657a.mo11216ac()) {
                    this.f13983l.setText(C3530b.f14164ao);
                    this.f13982k.setText(C3530b.f14164ao);
                    this.f13987p.m12667a(false, false);
                    this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
                    this.f13975a.setVisibility(0);
                    m8176a(true);
                    m8173b(true);
                    this.f13993v = true;
                    this.f13969A = true;
                    return;
                }
                if (getIntent().getBooleanExtra(f13966b, true) || getIntent().getBooleanExtra(f13968d, false)) {
                    m8176a(true);
                    m8173b(true);
                    this.f13993v = true;
                } else {
                    if (c2657a.m11312at().m10702e() == 7 || c2657a.m11312at().m10702e() == 8) {
                        m8173b(true);
                    } else {
                        m8173b(false);
                    }
                    m8176a(false);
                    this.f13993v = false;
                }
                this.f13975a.setVisibility(4);
                if (!this.f13969A) {
                    return;
                }
                this.f13969A = false;
                this.f13989r.mo8111b();
                this.f13989r.mo8118a();
                this.f13974O.sendEmptyMessageDelayed(2, 300L);
                this.f13974O.sendEmptyMessageDelayed(3, 300L);
                this.f13974O.sendEmptyMessageDelayed(2, 600L);
                this.f13974O.sendEmptyMessageDelayed(3, 600L);
                if (!this.f13991t && this.f13994w < C3489d.f13754g) {
                    return;
                }
                C3489d.m8302a(c2657a).m8304a();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f13992u.mo11219a(this);
        this.f13990s = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        this.f13991t = C2367d.m12459a().m12438k();
        if (this.f13989r == null) {
            this.f13989r = new C3531c(this.f13992u, this.f13988q);
        }
        if (this.f13990s != null) {
            this.f13994w = this.f13990s.m7959a();
        }
        this.f13989r.mo8111b();
        this.f13989r.mo8118a();
        this.f13974O.sendEmptyMessageDelayed(2, 300L);
        this.f13974O.sendEmptyMessageDelayed(3, 300L);
        this.f13974O.sendEmptyMessageDelayed(2, 600L);
        this.f13974O.sendEmptyMessageDelayed(3, 600L);
        this.f13974O.sendEmptyMessageDelayed(2, 900L);
        this.f13974O.sendEmptyMessageDelayed(3, 900L);
        this.f13974O.sendEmptyMessageDelayed(2, 1200L);
        this.f13974O.sendEmptyMessageDelayed(3, 1200L);
        if (C2367d.m12459a().m12438k() || this.f13994w >= C3489d.f13754g) {
            C3489d.m8302a(this.f13992u).m8304a();
            this.f13974O.sendEmptyMessageDelayed(1, 300L);
            this.f13974O.sendEmptyMessageDelayed(1, 600L);
            this.f13974O.sendEmptyMessageDelayed(1, 900L);
            this.f13974O.sendEmptyMessageDelayed(1, 1200L);
            this.f13970K = false;
        } else {
            this.f13970K = true;
        }
        this.f13996y = Integer.parseInt(C2238c.m13123e().m12753i());
        m8179a(this.f13996y, true);
        this.f13983l.setText(C2238c.m13123e().m12756h() + this.f13988q.getString(C2300R.C2303string.distance_unit_m));
        this.f13997z = Integer.parseInt(C2238c.m13123e().m12759g());
        if (this.f13997z == 10000) {
            this.f13987p.m12667a(true, false);
            this.f13984m.setText(C2300R.C2303string.gps_setting_distance_unlimt);
        } else {
            this.f13987p.m12667a(false, false);
            this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
        }
        if (this.f13992u.mo11216ac()) {
            this.f13974O.sendEmptyMessageDelayed(4, 3000L);
            return;
        }
        this.f13983l.setText(C3530b.f14164ao);
        this.f13982k.setText(C3530b.f14164ao);
        this.f13987p.m12667a(false, false);
        this.f13984m.setText(C2300R.C2303string.gps_setting_distance_limit_500m);
    }

    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
