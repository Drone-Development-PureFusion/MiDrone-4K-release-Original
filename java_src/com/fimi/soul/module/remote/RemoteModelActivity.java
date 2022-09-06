package com.fimi.soul.module.remote;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class RemoteModelActivity extends BaseActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    public static final String f13406a = "remodel";

    /* renamed from: n */
    private static final String f13407n = "RemoteModelActivity";

    /* renamed from: b */
    private PercentRelativeLayout f13408b;

    /* renamed from: c */
    private Button f13409c;

    /* renamed from: d */
    private Button f13410d;

    /* renamed from: e */
    private Button f13411e;

    /* renamed from: f */
    private TextView f13412f;

    /* renamed from: g */
    private TextView f13413g;

    /* renamed from: h */
    private TextView f13414h;

    /* renamed from: i */
    private ImageView f13415i;

    /* renamed from: j */
    private ImageView f13416j;

    /* renamed from: k */
    private C3057d f13417k;

    /* renamed from: l */
    private boolean f13418l;

    /* renamed from: m */
    private C2277v f13419m;

    /* renamed from: a */
    private void m8474a() {
        this.f13418l = false;
        this.f13415i.setImageResource(C2300R.C2301drawable.switchover_japan_right);
        this.f13416j.setImageResource(C2300R.C2301drawable.switchover_japan__leftbg);
        m8473a(this.f13411e, 75);
        m8473a(this.f13410d, 255);
        this.f13411e.setBackgroundResource(C2300R.C2301drawable.btn_switchover_left);
        this.f13410d.setBackgroundResource(C2300R.C2301drawable.btn_switchover_right_on);
    }

    /* renamed from: b */
    private void m8471b() {
        this.f13418l = true;
        this.f13415i.setImageResource(C2300R.C2301drawable.switchover_usa_right_bg);
        this.f13416j.setImageResource(C2300R.C2301drawable.switchover_usa_left_bg);
        m8473a(this.f13411e, 255);
        m8473a(this.f13410d, 75);
        this.f13411e.setBackgroundResource(C2300R.C2301drawable.btn_switchover_left_on);
        this.f13410d.setBackgroundResource(C2300R.C2301drawable.btn_switchover_right);
    }

    /* renamed from: a */
    public void m8473a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.usabutton /* 2131493428 */:
                if (this.f13418l) {
                    return;
                }
                if (!this.drone.mo11217ab().mo10898a()) {
                    C2284z.m12694a(this, getString(C2300R.C2303string.switch_mode_fail_please_connect_remote), C2284z.f7606b);
                    return;
                } else if (this.drone.mo11216ac()) {
                    C2284z.m12694a(this, getString(C2300R.C2303string.close_plane_switch_rocket), C2284z.f7606b);
                    return;
                } else {
                    new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.choose_recoker_mode_msg)).m7023c(17).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteModelActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            RemoteModelActivity.this.f13417k.m9809h();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteModelActivity.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                    return;
                }
            case C2300R.C2302id.jpabutton /* 2131493429 */:
                if (!this.f13418l) {
                    return;
                }
                if (!this.drone.mo11217ab().mo10898a()) {
                    C2284z.m12694a(this, getString(C2300R.C2303string.switch_mode_fail_please_connect_remote), C2284z.f7606b);
                    return;
                } else if (this.drone.mo11216ac()) {
                    C2284z.m12694a(this, getString(C2300R.C2303string.close_plane_switch_rocket), C2284z.f7606b);
                    return;
                } else {
                    new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.choose_recoker_mode_msg)).m7023c(17).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteModelActivity.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            RemoteModelActivity.this.f13417k.m9808i();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.remote.RemoteModelActivity.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                    return;
                }
            case C2300R.C2302id.black_btn /* 2131493817 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.droneremotemodel);
        getWindow().setFlags(128, 128);
        this.f13408b = (PercentRelativeLayout) findViewById(C2300R.C2302id.heardView);
        this.f13409c = (Button) this.f13408b.findViewById(C2300R.C2302id.black_btn);
        this.f13409c.setOnClickListener(this);
        this.f13411e = (Button) findViewById(C2300R.C2302id.usabutton);
        this.f13411e.setOnClickListener(this);
        this.f13410d = (Button) findViewById(C2300R.C2302id.jpabutton);
        this.f13410d.setOnClickListener(this);
        this.f13415i = (ImageView) findViewById(C2300R.C2302id.remoteviewright);
        this.f13416j = (ImageView) findViewById(C2300R.C2302id.remoteviewleft);
        this.f13412f = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13413g = (TextView) findViewById(C2300R.C2302id.leftremotetext);
        this.f13414h = (TextView) findViewById(C2300R.C2302id.rightremotetext);
        this.f13412f.setText(C2300R.C2303string.switch_remote_mode);
        C3658ar.m7612a(getAssets(), this.f13412f, this.f13413g, this.f13414h, this.f13411e, this.f13410d);
        this.f13419m = C2277v.m12784a(this);
        if (this.f13419m.m12787a().getInt(f13406a, 0) == 0) {
            m8471b();
        } else {
            m8474a();
        }
        this.f13417k = C3057d.m9823a(this.drone);
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        switch (enumC2679a) {
            case backControl:
                C3074a.m9756a().m9754a("98");
                if (c2657a.mo11229R().m10343b() != 114 || c2657a.mo11229R().m10342c() != 2) {
                    return;
                }
                if (c2657a.mo11229R().m10341d() == 2) {
                    this.f13419m.m12787a().edit().putInt(f13406a, 1).commit();
                    m8474a();
                    return;
                } else if (c2657a.mo11229R().m10341d() != 1) {
                    return;
                } else {
                    this.f13419m.m12787a().edit().putInt(f13406a, 0).commit();
                    m8471b();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.drone.mo11219a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.drone.mo11214b(this);
    }
}
