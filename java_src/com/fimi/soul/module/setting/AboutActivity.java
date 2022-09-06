package com.fimi.soul.module.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p187p.C2619a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.module.update.p210a.C3585g;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: H */
    private static final int f13455H = 1;

    /* renamed from: I */
    private static final int f13456I = 0;

    /* renamed from: J */
    private static final int f13457J = 1;

    /* renamed from: A */
    private TextView f13458A;

    /* renamed from: B */
    private TextView f13459B;

    /* renamed from: C */
    private TextView f13460C;

    /* renamed from: D */
    private TextView f13461D;

    /* renamed from: E */
    private TextView f13462E;

    /* renamed from: F */
    private TextView f13463F;

    /* renamed from: G */
    private C2423d f13464G;

    /* renamed from: K */
    private int f13465K = 0;

    /* renamed from: L */
    private C2657a f13466L;

    /* renamed from: a */
    C3585g f13467a;

    /* renamed from: b */
    private Button f13468b;

    /* renamed from: c */
    private Button f13469c;

    /* renamed from: d */
    private TextView f13470d;

    /* renamed from: e */
    private TextView f13471e;

    /* renamed from: f */
    private TextView f13472f;

    /* renamed from: g */
    private TextView f13473g;

    /* renamed from: h */
    private ImageView f13474h;

    /* renamed from: i */
    private TextView f13475i;

    /* renamed from: j */
    private C3580b f13476j;

    /* renamed from: k */
    private TextView f13477k;

    /* renamed from: l */
    private TextView f13478l;

    /* renamed from: m */
    private TextView f13479m;

    /* renamed from: n */
    private TextView f13480n;

    /* renamed from: o */
    private TextView f13481o;

    /* renamed from: p */
    private TextView f13482p;

    /* renamed from: q */
    private TextView f13483q;

    /* renamed from: r */
    private TextView f13484r;

    /* renamed from: s */
    private TextView f13485s;

    /* renamed from: t */
    private TextView f13486t;

    /* renamed from: u */
    private TextView f13487u;

    /* renamed from: v */
    private TextView f13488v;

    /* renamed from: w */
    private TextView f13489w;

    /* renamed from: x */
    private TextView f13490x;

    /* renamed from: y */
    private TextView f13491y;

    /* renamed from: z */
    private TextView f13492z;

    /* renamed from: a */
    private String m8464a(int i) {
        return String.valueOf(i);
    }

    /* renamed from: a */
    private void m8465a() {
        this.f13468b = (Button) findViewById(C2300R.C2302id.aboutBtn);
        this.f13468b.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.AboutActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AboutActivity.this.finish();
            }
        });
    }

    /* renamed from: b */
    private void m8463b() {
        this.f13475i = (TextView) findViewById(C2300R.C2302id.copyright);
        this.f13470d = (TextView) findViewById(C2300R.C2302id.aboutVersion);
        this.f13471e = (TextView) findViewById(C2300R.C2302id.agreementshengming_tv);
        this.f13471e.setOnClickListener(this);
        this.f13471e.getPaint().setFlags(8);
        this.f13471e.getPaint().setAntiAlias(true);
        this.f13472f = (TextView) findViewById(C2300R.C2302id.agreementProtocol_tv);
        this.f13472f.setOnClickListener(this);
        this.f13472f.getPaint().setFlags(8);
        this.f13472f.getPaint().setAntiAlias(true);
        this.f13473g = (TextView) findViewById(C2300R.C2302id.agreementPrivacy_tv);
        this.f13473g.setOnClickListener(this);
        this.f13473g.getPaint().setFlags(8);
        this.f13473g.getPaint().setAntiAlias(true);
        this.f13470d.setText(getString(C2300R.C2303string.about_version, new Object[]{C3658ar.m7589d(this)}));
        this.f13469c = (Button) findViewById(C2300R.C2302id.scoreBtn);
        this.f13469c.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.AboutActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + AboutActivity.this.getPackageName()));
                intent.addFlags(268435456);
                AboutActivity.this.startActivity(intent);
            }
        });
        this.f13474h = (ImageView) findViewById(C2300R.C2302id.aboutImg);
        this.f13481o = (TextView) findViewById(C2300R.C2302id.tv_camera);
        this.f13477k = (TextView) findViewById(C2300R.C2302id.tv_fc);
        this.f13479m = (TextView) findViewById(C2300R.C2302id.tv_x2);
        this.f13478l = (TextView) findViewById(C2300R.C2302id.tv_battery);
        this.f13480n = (TextView) findViewById(C2300R.C2302id.tv_rc);
        this.f13482p = (TextView) findViewById(C2300R.C2302id.tv_gimbal);
        this.f13483q = (TextView) findViewById(C2300R.C2302id.tv_servo);
        this.f13484r = (TextView) findViewById(C2300R.C2302id.tv_nofly);
        this.f13488v = (TextView) findViewById(C2300R.C2302id.tv_fc_tip);
        this.f13489w = (TextView) findViewById(C2300R.C2302id.tv_battery_tip);
        this.f13490x = (TextView) findViewById(C2300R.C2302id.tv_x2_tip);
        this.f13491y = (TextView) findViewById(C2300R.C2302id.tv_rc_tip);
        this.f13492z = (TextView) findViewById(C2300R.C2302id.tv_camera_tip);
        this.f13458A = (TextView) findViewById(C2300R.C2302id.tv_gimbal_tip);
        this.f13459B = (TextView) findViewById(C2300R.C2302id.tv_servo_tip);
        this.f13460C = (TextView) findViewById(C2300R.C2302id.tv_nofly_tip);
        this.f13485s = (TextView) findViewById(C2300R.C2302id.tv_rc_x6);
        this.f13486t = (TextView) findViewById(C2300R.C2302id.tv_fc_x6);
        this.f13461D = (TextView) findViewById(C2300R.C2302id.tv_fc_x6_tip);
        this.f13462E = (TextView) findViewById(C2300R.C2302id.tv_rc_x6_tip);
        if (!C2367d.m12459a().m12438k()) {
            this.f13461D.setVisibility(8);
            this.f13486t.setVisibility(8);
        }
        this.f13463F = (TextView) findViewById(C2300R.C2302id.tv_fc_bootloader_tip);
        this.f13487u = (TextView) findViewById(C2300R.C2302id.tv_fc_bootloader_version);
        this.f13487u.setVisibility(8);
        this.f13463F.setVisibility(8);
        this.f13467a = new C3585g(this, this.f13466L);
    }

    /* renamed from: c */
    private void m8462c() {
        C2619a m11493a = C2619a.m11493a();
        this.f13476j = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (this.f13476j != null && this.f13476j.m7957b() > 0) {
            this.f13480n.setText(m8464a(this.f13476j.m7957b()) + m11493a.m11487b(1));
        } else if (this.f13465K == 1) {
            this.f13480n.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7959a() > 0) {
            this.f13477k.setText(m8464a(this.f13476j.m7959a()) + m11493a.m11487b(0));
        } else if (this.f13465K == 1) {
            this.f13477k.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7955c() > 0) {
            this.f13482p.setText(m8464a(this.f13476j.m7955c()) + m11493a.m11487b(3));
        } else if (this.f13465K == 1) {
            this.f13482p.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7945h() > 0) {
            this.f13483q.setText(m8464a(this.f13476j.m7945h()) + m11493a.m11487b(6));
        } else if (this.f13465K == 1) {
            this.f13483q.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7949f() > 0) {
            this.f13479m.setText(m8464a(this.f13476j.m7949f()) + m11493a.m11487b(9));
        } else if (this.f13465K == 1) {
            this.f13479m.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7947g() > 0) {
            this.f13484r.setText(m8464a(this.f13476j.m7947g()) + m11493a.m11487b(10));
        } else if (this.f13465K == 1) {
            this.f13484r.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7951e() > 0) {
            this.f13485s.setText(m8464a(this.f13476j.m7951e()) + m11493a.m11487b(10));
        } else if (this.f13465K == 1) {
            this.f13485s.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7933n() > 0) {
            this.f13481o.setText(this.f13476j.m7933n() + "" + m11493a.m11487b(4));
        } else if (this.f13465K == 1) {
            this.f13481o.setText(C2300R.C2303string.no_get_versin);
        }
        if (!TextUtils.isEmpty(C2364c.m12469a().m12461e()) && Integer.valueOf(C2364c.m12469a().m12461e()).intValue() > 0) {
            this.f13486t.setText(C2364c.m12469a().m12461e() + "");
        } else if (this.f13465K == 1) {
            this.f13486t.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7937l() > 0) {
            this.f13478l.setText(m8464a(this.f13476j.m7937l()));
        } else if (this.f13465K == 1) {
            this.f13478l.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13476j != null && this.f13476j.m7931o() > 0) {
            this.f13487u.setText(m8464a(this.f13476j.m7931o()));
        } else if (this.f13465K == 1) {
            this.f13487u.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f13465K != 1) {
            m8461d();
        }
    }

    /* renamed from: d */
    private void m8461d() {
        this.f13465K = 1;
        new Thread(new Runnable() { // from class: com.fimi.soul.module.setting.AboutActivity.3
            @Override // java.lang.Runnable
            public void run() {
                AboutActivity.this.f13467a.m7886d();
            }
        }).start();
        getHandler().sendEmptyMessageDelayed(1, 2200L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this, ShowTextActivity.class);
        switch (view.getId()) {
            case C2300R.C2302id.agreementshengming_tv /* 2131492947 */:
                intent.putExtra(ShowTextActivity.f13679c, C2353b.f7949g);
                intent.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_shengming);
                intent.putExtra(ShowTextActivity.f13678b, "file:///android_asset/statement.html");
                startActivity(intent);
                return;
            case C2300R.C2302id.agreementProtocol_tv /* 2131492948 */:
                intent.putExtra(ShowTextActivity.f13679c, C2353b.f7950h);
                intent.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_protocol);
                intent.putExtra(ShowTextActivity.f13678b, "file:///android_asset/protocol.html");
                startActivity(intent);
                return;
            case C2300R.C2302id.agreementPrivacy_tv /* 2131492949 */:
                intent.putExtra(ShowTextActivity.f13679c, C2353b.f7950h);
                intent.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_privacy);
                intent.putExtra(ShowTextActivity.f13678b, "file:///android_asset/privacy.html");
                startActivity(intent);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_about);
        this.f13466L = ((DroidPlannerApp) getApplication()).f7895a;
        this.f13464G = (C2423d) C2379b.m12410a().m12394d();
        m8465a();
        m8463b();
        m8462c();
        C3658ar.m7612a(getAssets(), this.f13470d, this.f13471e, this.f13472f, this.f13473g, this.f13468b, this.f13475i, this.f13477k, this.f13478l, this.f13479m, this.f13480n, this.f13481o, this.f13482p, this.f13483q, this.f13484r, this.f13488v, this.f13489w, this.f13490x, this.f13491y, this.f13492z, this.f13458A, this.f13459B, this.f13460C, this.f13485s, this.f13486t, this.f13461D, this.f13462E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f13466L.mo11214b(this);
        if (this.f13467a != null) {
            this.f13467a.m7885e();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (enumC2679a == C2678d.EnumC2679a.ENDQUESTNOTIFY) {
            m8462c();
        }
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        if (message.what == 1) {
            m8462c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f13466L.mo11219a(this);
    }
}
