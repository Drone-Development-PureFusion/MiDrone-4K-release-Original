package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2858f;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* loaded from: classes.dex */
public class IMUActivity extends BaseActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: E */
    private static int f12755E = 2;

    /* renamed from: F */
    private static int f12756F = 3;

    /* renamed from: G */
    private static int f12757G = 1;

    /* renamed from: a */
    static C2858f f12758a;

    /* renamed from: A */
    private TextView f12759A;

    /* renamed from: B */
    private TextView f12760B;

    /* renamed from: C */
    private TextView f12761C;

    /* renamed from: D */
    private TextView f12762D;

    /* renamed from: H */
    private C3057d f12763H;

    /* renamed from: I */
    private C2858f f12764I;

    /* renamed from: J */
    private boolean f12765J = false;

    /* renamed from: K */
    private int f12766K = 0;

    /* renamed from: L */
    private Handler f12767L = new Handler() { // from class: com.fimi.soul.module.droneui.IMUActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == IMUActivity.f12755E) {
                if (IMUActivity.this.f12763H == null) {
                    return;
                }
                IMUActivity.this.f12763H.m9834a((byte) 4);
            } else if (message.what == IMUActivity.f12756F) {
                IMUActivity.this.m8815a();
            } else if (message.what != IMUActivity.f12757G) {
            } else {
                IMUActivity.this.f12763H.m9834a((byte) 7);
            }
        }
    };

    /* renamed from: b */
    private Button f12768b;

    /* renamed from: c */
    private Button f12769c;

    /* renamed from: d */
    private TextView f12770d;

    /* renamed from: e */
    private TextView f12771e;

    /* renamed from: f */
    private TextView f12772f;

    /* renamed from: g */
    private TextView f12773g;

    /* renamed from: h */
    private TextView f12774h;

    /* renamed from: i */
    private TextView f12775i;

    /* renamed from: j */
    private TextView f12776j;

    /* renamed from: k */
    private TextView f12777k;

    /* renamed from: l */
    private TextView f12778l;

    /* renamed from: m */
    private TextView f12779m;

    /* renamed from: n */
    private TextView f12780n;

    /* renamed from: o */
    private TextView f12781o;

    /* renamed from: p */
    private TextView f12782p;

    /* renamed from: q */
    private TextView f12783q;

    /* renamed from: r */
    private TextView f12784r;

    /* renamed from: s */
    private TextView f12785s;

    /* renamed from: t */
    private TextView f12786t;

    /* renamed from: u */
    private TextView f12787u;

    /* renamed from: v */
    private TextView f12788v;

    /* renamed from: w */
    private TextView f12789w;

    /* renamed from: x */
    private TextView f12790x;

    /* renamed from: y */
    private TextView f12791y;

    /* renamed from: z */
    private TextView f12792z;

    /* renamed from: h */
    private void m8800h() {
        this.f12768b = (Button) findViewById(C2300R.C2302id.back_btn);
        this.f12768b.setOnClickListener(this);
        this.f12770d = (TextView) findViewById(C2300R.C2302id.aboutTitle);
        this.f12771e = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_x);
        this.f12772f = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_y);
        this.f12773g = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_z);
        this.f12774h = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_mod);
        this.f12775i = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_x);
        this.f12776j = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_y);
        this.f12777k = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_z);
        this.f12778l = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_mod);
        this.f12779m = (TextView) findViewById(C2300R.C2302id.imu_compass_one_x);
        this.f12780n = (TextView) findViewById(C2300R.C2302id.imu_compass_one_y);
        this.f12781o = (TextView) findViewById(C2300R.C2302id.imu_compass_one_z);
        this.f12782p = (TextView) findViewById(C2300R.C2302id.imu_compass_one_mod);
        this.f12783q = (TextView) findViewById(C2300R.C2302id.imu_compass_two_x);
        this.f12784r = (TextView) findViewById(C2300R.C2302id.imu_compass_two_y);
        this.f12785s = (TextView) findViewById(C2300R.C2302id.imu_compass_two_z);
        this.f12786t = (TextView) findViewById(C2300R.C2302id.imu_compass_two_mod);
        this.f12787u = (TextView) findViewById(C2300R.C2302id.tv_imu_error);
        this.f12769c = (Button) findViewById(C2300R.C2302id.btn_imu_detection);
        this.f12769c.setOnClickListener(this);
        this.f12788v = (TextView) findViewById(C2300R.C2302id.tv_imu_hint);
        this.f12789w = (TextView) findViewById(C2300R.C2302id.tv_x);
        this.f12790x = (TextView) findViewById(C2300R.C2302id.tv_y);
        this.f12791y = (TextView) findViewById(C2300R.C2302id.tv_z);
        this.f12789w = (TextView) findViewById(C2300R.C2302id.tv_mod);
        this.f12759A = (TextView) findViewById(C2300R.C2302id.tv_gyroscope);
        this.f12760B = (TextView) findViewById(C2300R.C2302id.tv_accelerometer);
        this.f12761C = (TextView) findViewById(C2300R.C2302id.tv_compass_one);
        this.f12762D = (TextView) findViewById(C2300R.C2302id.tv_compass_two);
        if (!this.drone.mo11216ac()) {
            m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.connect_aircraft_hint));
        } else if (this.drone.mo11205t().m10633d() == 0) {
            m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.hint_one));
        } else {
            m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.state_flight_hint));
            m8814a(this.f12769c, getResources().getColor(C2300R.color.white_half), false);
        }
    }

    /* renamed from: i */
    private void m8799i() {
        this.f12763H = C3057d.m9823a(this.drone);
        this.f12763H.m9834a((byte) 4);
        this.f12763H.m9834a((byte) 5);
        m8815a();
    }

    /* renamed from: a */
    public void m8815a() {
        if (!this.drone.mo11216ac() || this.drone.m11320al()) {
            if (this.drone.mo11205t().m10633d() != 0) {
                m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.state_flight_hint));
            } else if (this.f12766K != 1) {
                m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.connect_aircraft_hint));
                this.f12765J = true;
            }
            m8814a(this.f12769c, getResources().getColor(C2300R.color.white_half), false);
            this.f12771e.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12772f.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12773g.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12774h.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12775i.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12776j.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12777k.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12778l.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12779m.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12780n.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12781o.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12782p.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12783q.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12784r.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12785s.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12786t.setText(getResources().getString(C2300R.C2303string.no_use));
            return;
        }
        if (this.f12765J && this.f12766K != 1) {
            m8813a(this.f12787u, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.hint_one));
            this.f12765J = false;
        } else if (!this.f12787u.getText().toString().equals(getResources().getString(C2300R.C2303string.detection_hint))) {
            m8814a(this.f12769c, getResources().getColor(C2300R.color.white_90), true);
        }
        this.f12771e.setText(this.drone.mo11199z().m10606a() + "");
        this.f12772f.setText(this.drone.mo11199z().m10603b() + "");
        this.f12773g.setText(this.drone.mo11199z().m10602c() + "");
        this.f12774h.setText(this.drone.mo11199z().m10601d() + "");
        this.f12775i.setText(this.drone.mo11199z().m10600e() + "");
        this.f12776j.setText(this.drone.mo11199z().m10599f() + "");
        this.f12777k.setText(this.drone.mo11199z().m10598g() + "");
        this.f12778l.setText(this.drone.mo11199z().m10597h() + "");
        this.f12779m.setText(this.drone.mo11242E().m10224a() + "");
        this.f12780n.setText(this.drone.mo11242E().m10221b() + "");
        this.f12781o.setText(this.drone.mo11242E().m10220c() + "");
        this.f12782p.setText(this.drone.mo11242E().m10219d() + "");
        this.f12783q.setText(this.drone.mo11242E().m10224a() + "");
        this.f12784r.setText(this.drone.mo11242E().m10221b() + "");
        this.f12785s.setText(this.drone.mo11242E().m10220c() + "");
        this.f12786t.setText(this.drone.mo11242E().m10219d() + "");
    }

    /* renamed from: a */
    public void m8814a(Button button, int i, boolean z) {
        button.setEnabled(z);
        button.setTextColor(i);
    }

    /* renamed from: a */
    public void m8813a(TextView textView, int i, String str) {
        textView.setTextColor(i);
        textView.setText(str);
    }

    /* renamed from: b */
    public void m8810b() {
        C3057d.m9823a(this.drone).m9811f(153);
        this.f12764I.m10746f();
        if (this.drone.mo11244C().m10585a() == 0) {
            this.f12766K = 1;
            m8814a(this.f12769c, getResources().getColor(C2300R.color.white_90), true);
            m8813a(this.f12787u, getResources().getColor(C2300R.color.battery_green), getResources().getString(C2300R.C2303string.imu_normal));
            return;
        }
        this.f12766K = 1;
        m8814a(this.f12769c, getResources().getColor(C2300R.color.white_90), true);
        m8813a(this.f12787u, getResources().getColor(C2300R.color.insurance_white), getResources().getString(C2300R.C2303string.imu_exception));
    }

    /* renamed from: c */
    public void m8808c() {
        if (f12758a != null) {
            f12758a.m10751c();
            return;
        }
        f12758a = new C2858f(5000, new Runnable() { // from class: com.fimi.soul.module.droneui.IMUActivity.3
            @Override // java.lang.Runnable
            public void run() {
                IMUActivity.this.f12767L.sendEmptyMessage(IMUActivity.f12755E);
            }
        });
        f12758a.m10749d();
    }

    /* renamed from: d */
    public void m8806d() {
        if (this.f12764I != null) {
            this.f12764I.m10751c();
            return;
        }
        this.f12764I = new C2858f(1000, new Runnable() { // from class: com.fimi.soul.module.droneui.IMUActivity.4
            @Override // java.lang.Runnable
            public void run() {
                IMUActivity.this.f12767L.sendEmptyMessage(IMUActivity.f12757G);
            }
        });
        this.f12764I.m10749d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2300R.C2302id.back_btn) {
            finish();
        } else if (id != C2300R.C2302id.btn_imu_detection) {
        } else {
            m8814a(this.f12769c, getResources().getColor(C2300R.color.white_half), false);
            m8813a(this.f12787u, getResources().getColor(C2300R.color.white_half), getResources().getString(C2300R.C2303string.detection_hint));
            this.f12766K = 0;
            m8806d();
            this.f12767L.postDelayed(new Runnable() { // from class: com.fimi.soul.module.droneui.IMUActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (IMUActivity.this.f12766K != 1) {
                        IMUActivity.this.f12766K = 0;
                        IMUActivity.this.m8813a(IMUActivity.this.f12787u, IMUActivity.this.getResources().getColor(C2300R.color.white_90), IMUActivity.this.getResources().getString(C2300R.C2303string.imu_detection_retry));
                        IMUActivity.this.f12764I.m10746f();
                    }
                }
            }, AbstractC0517a.f1169e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_imu);
        m8800h();
        C3658ar.m7612a(getAssets(), this.f12768b, this.f12769c, this.f12770d, this.f12771e, this.f12772f, this.f12773g, this.f12774h, this.f12775i, this.f12776j, this.f12777k, this.f12778l, this.f12779m, this.f12780n, this.f12781o, this.f12782p, this.f12783q, this.f12784r, this.f12785s, this.f12786t, this.f12787u, this.f12788v, this.f12789w, this.f12790x, this.f12791y, this.f12792z, this.f12759A, this.f12760B, this.f12761C, this.f12762D);
        this.drone.mo11219a(this);
        m8799i();
        m8808c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.drone.mo11214b(this);
        f12758a.m10746f();
        if (this.f12764I != null) {
            this.f12764I.m10746f();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case IMU_INFO:
                this.f12767L.sendEmptyMessage(f12756F);
                break;
            case IMU_WORKSTATE:
                m8810b();
                break;
            case CLEANALLOBJ:
                this.f12767L.sendEmptyMessage(f12756F);
                break;
        }
        this.f12767L.sendEmptyMessage(f12756F);
    }
}
