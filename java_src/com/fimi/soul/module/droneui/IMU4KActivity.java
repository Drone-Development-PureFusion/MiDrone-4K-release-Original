package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2858f;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class IMU4KActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: U */
    private static int f12691U = 1;

    /* renamed from: V */
    private static int f12692V = 2;

    /* renamed from: W */
    private static int f12693W = 3;

    /* renamed from: X */
    private static int f12694X = 4;

    /* renamed from: Y */
    private static int f12695Y = 24;

    /* renamed from: Z */
    private static int f12696Z = 7;

    /* renamed from: a */
    static C2858f f12697a;

    /* renamed from: A */
    private TextView f12698A;

    /* renamed from: B */
    private TextView f12699B;

    /* renamed from: C */
    private TextView f12700C;

    /* renamed from: D */
    private TextView f12701D;

    /* renamed from: E */
    private TextView f12702E;

    /* renamed from: F */
    private TextView f12703F;

    /* renamed from: G */
    private TextView f12704G;

    /* renamed from: H */
    private TextView f12705H;

    /* renamed from: I */
    private TextView f12706I;

    /* renamed from: J */
    private TextView f12707J;

    /* renamed from: K */
    private TextView f12708K;

    /* renamed from: L */
    private TextView f12709L;

    /* renamed from: M */
    private TextView f12710M;

    /* renamed from: N */
    private TextView f12711N;

    /* renamed from: O */
    private TextView f12712O;

    /* renamed from: P */
    private TextView f12713P;

    /* renamed from: Q */
    private TextView f12714Q;

    /* renamed from: R */
    private TextView f12715R;

    /* renamed from: S */
    private TextView f12716S;

    /* renamed from: T */
    private TextView f12717T;

    /* renamed from: aa */
    private C3057d f12718aa;

    /* renamed from: ab */
    private C2858f f12719ab;

    /* renamed from: ae */
    private boolean f12722ae;

    /* renamed from: ag */
    private C3580b f12724ag;

    /* renamed from: f */
    byte f12729f;

    /* renamed from: g */
    byte f12730g;

    /* renamed from: j */
    private Button f12733j;

    /* renamed from: k */
    private Button f12734k;

    /* renamed from: l */
    private TextView f12735l;

    /* renamed from: m */
    private TextView f12736m;

    /* renamed from: n */
    private TextView f12737n;

    /* renamed from: o */
    private TextView f12738o;

    /* renamed from: p */
    private TextView f12739p;

    /* renamed from: q */
    private TextView f12740q;

    /* renamed from: r */
    private TextView f12741r;

    /* renamed from: s */
    private TextView f12742s;

    /* renamed from: t */
    private TextView f12743t;

    /* renamed from: u */
    private TextView f12744u;

    /* renamed from: v */
    private TextView f12745v;

    /* renamed from: w */
    private TextView f12746w;

    /* renamed from: x */
    private TextView f12747x;

    /* renamed from: y */
    private TextView f12748y;

    /* renamed from: z */
    private TextView f12749z;

    /* renamed from: ac */
    private boolean f12720ac = false;

    /* renamed from: ad */
    private int f12721ad = 0;

    /* renamed from: af */
    private Handler f12723af = new Handler() { // from class: com.fimi.soul.module.droneui.IMU4KActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == IMU4KActivity.f12691U) {
                if (IMU4KActivity.this.f12718aa == null) {
                    return;
                }
                IMU4KActivity.this.f12718aa.m9834a((byte) 1);
            } else if (message.what == IMU4KActivity.f12692V) {
                if (IMU4KActivity.this.f12718aa == null) {
                    return;
                }
                IMU4KActivity.this.f12718aa.m9834a((byte) 2);
            } else if (message.what == IMU4KActivity.f12693W) {
                if (IMU4KActivity.this.f12718aa == null) {
                    return;
                }
                IMU4KActivity.this.f12718aa.m9834a((byte) 3);
            } else if (message.what == IMU4KActivity.f12694X) {
                if (IMU4KActivity.this.f12718aa == null) {
                    return;
                }
                IMU4KActivity.this.f12718aa.m9834a((byte) 4);
            } else if (message.what == IMU4KActivity.f12695Y) {
                IMU4KActivity.this.m8837a();
            } else if (message.what != IMU4KActivity.f12696Z) {
            } else {
                if ((IMU4KActivity.this.f12729f & SmileConstants.BYTE_MARKER_END_OF_CONTENT) != 0 && !IMU4KActivity.this.f12727d) {
                    IMU4KActivity.this.f12718aa.m9834a((byte) 5);
                }
                if ((IMU4KActivity.this.f12730g & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 0 || IMU4KActivity.this.f12728e) {
                    return;
                }
                IMU4KActivity.this.f12718aa.m9834a((byte) 6);
            }
        }
    };

    /* renamed from: b */
    int f12725b = -1;

    /* renamed from: c */
    int f12726c = -1;

    /* renamed from: d */
    boolean f12727d = false;

    /* renamed from: e */
    boolean f12728e = true;

    /* renamed from: h */
    RunnableC3290a f12731h = null;

    /* renamed from: i */
    boolean f12732i = true;

    /* renamed from: com.fimi.soul.module.droneui.IMU4KActivity$a */
    /* loaded from: classes.dex */
    class RunnableC3290a implements Runnable {
        RunnableC3290a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IMU4KActivity.this.f12721ad != 1) {
                IMU4KActivity.this.f12721ad = 0;
                IMU4KActivity.this.f12725b = -1;
                IMU4KActivity.this.f12726c = -1;
                IMU4KActivity.this.f12732i = true;
                IMU4KActivity.this.m8834a(IMU4KActivity.this.f12708K, IMU4KActivity.this.getResources().getColor(C2300R.color.white_90), IMU4KActivity.this.getResources().getString(C2300R.C2303string.imu_detection_retry));
                if (IMU4KActivity.this.f12719ab == null) {
                    return;
                }
                IMU4KActivity.this.f12719ab.m10746f();
            }
        }
    }

    /* renamed from: a */
    private boolean m8836a(int i, byte b) {
        return i == 0 && b == 0;
    }

    /* renamed from: l */
    private void m8817l() {
        this.f12733j = (Button) findViewById(C2300R.C2302id.back_btn);
        this.f12733j.setOnClickListener(this);
        this.f12735l = (TextView) findViewById(C2300R.C2302id.aboutTitle);
        this.f12736m = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_x);
        this.f12737n = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_y);
        this.f12738o = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_z);
        this.f12739p = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_mod);
        this.f12740q = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_x);
        this.f12741r = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_y);
        this.f12742s = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_z);
        this.f12743t = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_mod);
        this.f12744u = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_two_x);
        this.f12745v = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_two_y);
        this.f12746w = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_two_z);
        this.f12747x = (TextView) findViewById(C2300R.C2302id.imu_gyroscope_two_mod);
        this.f12748y = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_two_x);
        this.f12749z = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_two_y);
        this.f12698A = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_two_z);
        this.f12699B = (TextView) findViewById(C2300R.C2302id.imu_accelerometer_two_mod);
        this.f12700C = (TextView) findViewById(C2300R.C2302id.imu_compass_one_x);
        this.f12701D = (TextView) findViewById(C2300R.C2302id.imu_compass_one_y);
        this.f12702E = (TextView) findViewById(C2300R.C2302id.imu_compass_one_z);
        this.f12703F = (TextView) findViewById(C2300R.C2302id.imu_compass_one_mod);
        this.f12704G = (TextView) findViewById(C2300R.C2302id.imu_compass_two_x);
        this.f12705H = (TextView) findViewById(C2300R.C2302id.imu_compass_two_y);
        this.f12706I = (TextView) findViewById(C2300R.C2302id.imu_compass_two_z);
        this.f12707J = (TextView) findViewById(C2300R.C2302id.imu_compass_two_mod);
        this.f12708K = (TextView) findViewById(C2300R.C2302id.tv_imu_error);
        this.f12734k = (Button) findViewById(C2300R.C2302id.btn_imu_detection);
        this.f12734k.setOnClickListener(this);
        this.f12709L = (TextView) findViewById(C2300R.C2302id.tv_imu_hint);
        this.f12710M = (TextView) findViewById(C2300R.C2302id.tv_x);
        this.f12711N = (TextView) findViewById(C2300R.C2302id.tv_y);
        this.f12712O = (TextView) findViewById(C2300R.C2302id.tv_z);
        this.f12710M = (TextView) findViewById(C2300R.C2302id.tv_mod);
        this.f12714Q = (TextView) findViewById(C2300R.C2302id.tv_gyroscope);
        this.f12715R = (TextView) findViewById(C2300R.C2302id.tv_accelerometer);
        this.f12716S = (TextView) findViewById(C2300R.C2302id.tv_compass_one);
        this.f12717T = (TextView) findViewById(C2300R.C2302id.tv_compass_two);
        if (!this.drone.mo11216ac()) {
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.connect_aircraft_hint));
        } else if (this.drone.mo11246A().m10596a() != 2) {
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.hint_one));
        } else {
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.state_flight_hint));
            m8835a(this.f12734k, getResources().getColor(C2300R.color.white_half), false);
        }
    }

    /* renamed from: m */
    private void m8816m() {
        this.f12718aa = C3057d.m9823a(this.drone);
        this.f12718aa.m9834a((byte) 1);
        this.f12718aa.m9834a((byte) 2);
        this.f12718aa.m9834a((byte) 3);
        this.f12718aa.m9834a((byte) 4);
        m8837a();
    }

    /* renamed from: a */
    public void m8837a() {
        if (this.drone.mo11216ac() && this.drone.mo11246A().m10596a() != 2 && this.f12722ae) {
            if (this.f12720ac && this.f12721ad != 1) {
                m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.hint_one));
                this.f12720ac = false;
            } else if (!this.f12708K.getText().toString().equals(getResources().getString(C2300R.C2303string.detection_hint))) {
                m8835a(this.f12734k, getResources().getColor(C2300R.color.white_90), true);
            }
            this.f12744u.setText(this.drone.mo11246A().m10593b() + "");
            this.f12745v.setText(this.drone.mo11246A().m10592c() + "");
            this.f12746w.setText(this.drone.mo11246A().m10591d() + "");
            this.f12747x.setText(this.drone.mo11246A().m10590e() + "");
            this.f12748y.setText(this.drone.mo11246A().m10589f() + "");
            this.f12749z.setText(this.drone.mo11246A().m10588g() + "");
            this.f12698A.setText(this.drone.mo11246A().m10587h() + "");
            this.f12699B.setText(this.drone.mo11246A().m10586i() + "");
            this.f12736m.setText(this.drone.mo11245B().m10593b() + "");
            this.f12737n.setText(this.drone.mo11245B().m10592c() + "");
            this.f12738o.setText(this.drone.mo11245B().m10591d() + "");
            this.f12739p.setText(this.drone.mo11245B().m10590e() + "");
            this.f12740q.setText(this.drone.mo11245B().m10589f() + "");
            this.f12741r.setText(this.drone.mo11245B().m10588g() + "");
            this.f12742s.setText(this.drone.mo11245B().m10587h() + "");
            this.f12743t.setText(this.drone.mo11245B().m10586i() + "");
            this.f12700C.setText(this.drone.mo11242E().m10224a() + "");
            this.f12701D.setText(this.drone.mo11242E().m10221b() + "");
            this.f12702E.setText(this.drone.mo11242E().m10220c() + "");
            this.f12703F.setText(this.drone.mo11242E().m10219d() + "");
            this.f12704G.setText(this.drone.mo11241F().m10224a() + "");
            this.f12705H.setText(this.drone.mo11241F().m10221b() + "");
            this.f12706I.setText(this.drone.mo11241F().m10220c() + "");
            this.f12707J.setText(this.drone.mo11241F().m10219d() + "");
            return;
        }
        if (this.drone.mo11246A().m10596a() == 2) {
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.state_flight_hint));
        } else if (!this.drone.mo11216ac()) {
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_90), getResources().getString(C2300R.C2303string.connect_aircraft_hint));
        }
        m8835a(this.f12734k, getResources().getColor(C2300R.color.white_half), false);
        this.f12736m.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12737n.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12738o.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12739p.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12740q.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12741r.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12742s.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12743t.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12744u.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12745v.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12746w.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12747x.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12748y.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12749z.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12698A.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12699B.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12700C.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12701D.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12702E.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12703F.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12704G.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12705H.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12706I.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12707J.setText(getResources().getString(C2300R.C2303string.no_use));
        this.f12720ac = true;
        this.f12721ad = 0;
    }

    /* renamed from: a */
    public void m8835a(Button button, int i, boolean z) {
        button.setEnabled(z);
        button.setTextColor(i);
    }

    /* renamed from: a */
    public void m8834a(TextView textView, int i, String str) {
        textView.setTextColor(i);
        textView.setText(str);
    }

    /* renamed from: b */
    public void m8831b() {
        this.f12725b = this.drone.mo11244C().m10585a();
        byte m10583b = this.drone.mo11244C().m10583b();
        if (m10583b == 1 && this.f12729f == 1) {
            this.f12728e = true;
            return;
        }
        if (m10583b == 0) {
            this.f12728e = false;
            this.f12727d = true;
            this.f12729f = m10583b;
        } else {
            this.f12728e = true;
            this.f12729f = m10583b;
        }
        this.f12726c = this.drone.mo11243D().m10585a();
        byte m10583b2 = this.drone.mo11243D().m10583b();
        if (m10583b2 == 1 && this.f12730g == 1) {
            this.f12727d = true;
            return;
        }
        if (m10583b2 == 0) {
            this.f12727d = false;
            this.f12728e = true;
            this.f12730g = m10583b2;
        } else {
            this.f12727d = false;
            this.f12730g = m10583b2;
        }
        C3057d.m9823a(this.drone).m9811f(154);
        if (this.f12719ab != null) {
            this.f12719ab.m10746f();
        }
        if (m8836a(this.f12725b, this.f12729f) && m8836a(this.f12726c, this.f12730g)) {
            this.f12721ad = 1;
            m8835a(this.f12734k, getResources().getColor(C2300R.color.white_90), true);
            m8834a(this.f12708K, getResources().getColor(C2300R.color.battery_green), getResources().getString(C2300R.C2303string.imu_normal));
        } else if (1 == this.f12721ad) {
        } else {
            this.f12721ad = 1;
            this.f12725b = -1;
            this.f12726c = -1;
            m8835a(this.f12734k, getResources().getColor(C2300R.color.white_90), true);
            m8834a(this.f12708K, getResources().getColor(C2300R.color.insurance_white), getResources().getString(C2300R.C2303string.imu_exception));
        }
    }

    /* renamed from: c */
    public void m8829c() {
        if (f12697a != null) {
            f12697a.m10751c();
            return;
        }
        f12697a = new C2858f(1000, new Runnable() { // from class: com.fimi.soul.module.droneui.IMU4KActivity.2
            @Override // java.lang.Runnable
            public void run() {
                IMU4KActivity.this.f12723af.sendEmptyMessage(IMU4KActivity.f12691U);
                IMU4KActivity.this.f12723af.sendEmptyMessage(IMU4KActivity.f12692V);
                IMU4KActivity.this.f12723af.sendEmptyMessage(IMU4KActivity.f12693W);
                IMU4KActivity.this.f12723af.sendEmptyMessage(IMU4KActivity.f12694X);
            }
        });
        f12697a.m10749d();
    }

    /* renamed from: d */
    public void m8827d() {
        if (this.f12719ab != null) {
            this.f12719ab.m10751c();
            return;
        }
        this.f12719ab = new C2858f(1500, new Runnable() { // from class: com.fimi.soul.module.droneui.IMU4KActivity.3
            @Override // java.lang.Runnable
            public void run() {
                IMU4KActivity.this.f12723af.sendEmptyMessage(IMU4KActivity.f12696Z);
            }
        });
        this.f12719ab.m10749d();
    }

    /* renamed from: e */
    public boolean m8825e() {
        if (this.f12724ag == null) {
            this.f12724ag = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        }
        boolean z = this.f12724ag != null && this.f12724ag.m7959a() > 0 && this.f12724ag.m7959a() >= 1067;
        if (!z) {
            C2284z.m12694a(this, getString(C2300R.C2303string.fc_update_tip), C2284z.f7606b);
        }
        return z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2300R.C2302id.back_btn) {
            finish();
        } else if (id != C2300R.C2302id.btn_imu_detection) {
        } else {
            this.f12727d = false;
            this.f12728e = true;
            this.f12730g = (byte) 1;
            this.f12729f = (byte) 1;
            this.drone.mo11244C().m10584a(1, (byte) 1);
            this.drone.mo11243D().m10584a(1, (byte) 1);
            m8835a(this.f12734k, getResources().getColor(C2300R.color.white_half), false);
            m8834a(this.f12708K, getResources().getColor(C2300R.color.white_half), getResources().getString(C2300R.C2303string.detection_hint));
            this.f12721ad = 0;
            this.f12725b = -1;
            this.f12726c = -1;
            this.f12732i = false;
            m8827d();
            if (this.f12731h != null) {
                this.f12723af.removeCallbacks(this.f12731h);
            }
            this.f12731h = new RunnableC3290a();
            this.f12723af.postDelayed(this.f12731h, 350000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_imu_4k);
        m8817l();
        C3658ar.m7612a(getAssets(), this.f12733j, this.f12734k, this.f12735l, this.f12736m, this.f12737n, this.f12738o, this.f12739p, this.f12740q, this.f12741r, this.f12742s, this.f12743t, this.f12744u, this.f12745v, this.f12746w, this.f12747x, this.f12748y, this.f12749z, this.f12698A, this.f12699B, this.f12700C, this.f12701D, this.f12702E, this.f12703F, this.f12704G, this.f12705H, this.f12706I, this.f12707J, this.f12708K, this.f12709L, this.f12710M, this.f12711N, this.f12712O, this.f12713P, this.f12714Q, this.f12715R, this.f12716S, this.f12717T);
        this.drone.mo11219a(this);
        this.f12722ae = m8825e();
        m8816m();
        m8829c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.drone.mo11214b(this);
        if (this.f12719ab != null) {
            this.f12719ab.m10746f();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case IMU_INFO:
                this.f12723af.sendEmptyMessage(f12695Y);
                return;
            case IMU_COMPASS:
                this.f12723af.sendEmptyMessage(f12695Y);
                return;
            case IMU_WORKSTATE:
                if (this.f12732i) {
                    return;
                }
                m8831b();
                return;
            case CLEANALLOBJ:
                this.f12723af.sendEmptyMessage(f12695Y);
                return;
            default:
                return;
        }
    }
}
