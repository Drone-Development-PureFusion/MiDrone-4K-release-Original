package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p199e.C2827e;
import com.fimi.soul.drone.p199e.C2828f;
import com.fimi.soul.drone.p203i.C2871ab;
import com.fimi.soul.entity.BatteryUpdateSize;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.module.update.p210a.C3583e;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.p211a.C3625a;
import com.fimi.soul.view.BatteryCapacityView;
import com.fimi.soul.view.BatteryVoltageView;
import com.xiaomi.mipush.sdk.Constants;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class BatteryInfoActivity extends BaseActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: A */
    private static int f12562A = 1;

    /* renamed from: C */
    private static final int f12563C = 1340;

    /* renamed from: w */
    private static final int f12564w = 75;

    /* renamed from: x */
    private static final int f12565x = 10;

    /* renamed from: D */
    private C3579a f12567D;

    /* renamed from: F */
    private float f12569F;

    /* renamed from: G */
    private float f12570G;

    /* renamed from: a */
    private Button f12572a;

    /* renamed from: b */
    private TextView f12573b;

    /* renamed from: c */
    private TextView f12574c;

    /* renamed from: d */
    private TextView f12575d;

    /* renamed from: e */
    private TextView f12576e;

    /* renamed from: f */
    private TextView f12577f;

    /* renamed from: g */
    private TextView f12578g;

    /* renamed from: h */
    private TextView f12579h;

    /* renamed from: i */
    private TextView f12580i;

    /* renamed from: j */
    private TextView f12581j;

    /* renamed from: k */
    private TextView f12582k;

    /* renamed from: l */
    private TextView f12583l;

    /* renamed from: m */
    private TextView f12584m;

    /* renamed from: n */
    private ImageView f12585n;

    /* renamed from: o */
    private BatteryCapacityView f12586o;

    /* renamed from: p */
    private BatteryVoltageView f12587p;

    /* renamed from: q */
    private BatteryVoltageView f12588q;

    /* renamed from: r */
    private BatteryVoltageView f12589r;

    /* renamed from: s */
    private BatteryVoltageView f12590s;

    /* renamed from: t */
    private C3625a f12591t;

    /* renamed from: v */
    private C3580b f12593v;

    /* renamed from: u */
    private boolean f12592u = false;

    /* renamed from: y */
    private int f12594y = 0;

    /* renamed from: z */
    private boolean f12595z = true;

    /* renamed from: B */
    private boolean f12566B = true;

    /* renamed from: E */
    private Handler f12568E = new Handler() { // from class: com.fimi.soul.module.droneui.BatteryInfoActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != BatteryInfoActivity.f12562A || BatteryInfoActivity.this.f12566B) {
                return;
            }
            C2828f.m10854i(BatteryInfoActivity.this.drone);
        }
    };

    /* renamed from: H */
    private boolean f12571H = true;

    /* renamed from: a */
    private String m8916a(int i) {
        return C2275t.m12790b((i / 100.0d) + 2.0d, 2) + " V";
    }

    /* renamed from: a */
    private void m8915a(C2871ab c2871ab) {
        int m10689c = c2871ab.m10689c() & 65535;
        char m10690b = c2871ab.m10690b();
        int m10692a = c2871ab.m10692a() & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        byte m10688d = c2871ab.m10688d();
        long m10687e = c2871ab.m10687e();
        long m10686f = c2871ab.m10686f();
        long m10685g = c2871ab.m10685g();
        long m10684h = c2871ab.m10684h();
        if (m10689c > 0) {
            this.f12567D.m7968a(new C3583e(m10692a, m10688d, m10689c, String.valueOf(Long.valueOf(m10690b)), m10687e, m10686f, m10685g, m10684h));
            this.f12567D.m7969a(m10692a, m10689c);
        }
    }

    /* renamed from: b */
    private void m8913b() {
        String str;
        if (this.drone.mo11216ac()) {
            if (this.f12571H) {
                C2827e.m10865a(this.drone);
            }
            String str2 = (this.drone.mo11200y().m10331i() - 60) + getString(C2300R.C2303string.temp_unit);
            if (this.drone.mo11200y().m10331i() - 60 >= 75) {
                str = str2 + getString(C2300R.C2303string.battery_high_temperature);
                this.f12573b.setTextColor(getResources().getColor(C2300R.color.battery_except));
            } else if (this.drone.mo11200y().m10331i() - 60 < 10) {
                str = str2 + getString(C2300R.C2303string.battery_low_temperature);
                this.f12573b.setTextColor(getResources().getColor(C2300R.color.battery_low_temperature));
            } else {
                str = str2 + getString(C2300R.C2303string.battery_nomal_temperature);
                this.f12573b.setTextColor(getResources().getColor(C2300R.color.white));
            }
            this.f12573b.setText(" " + str);
            m8911d();
        }
    }

    /* renamed from: c */
    private void m8912c() {
        this.f12572a = (Button) findViewById(C2300R.C2302id.back_btn);
        this.f12572a.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.droneui.BatteryInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BatteryInfoActivity.this.finish();
            }
        });
    }

    /* renamed from: d */
    private void m8911d() {
        this.f12569F = this.drone.mo11237J().m10321e();
        this.f12570G = this.drone.mo11237J().m10322d();
        if (this.f12569F > 0.0f) {
            this.f12580i.setText(" " + m8916a(this.drone.mo11200y().m10340a()));
            this.f12581j.setText(" " + m8916a(this.drone.mo11200y().m10338b()));
            this.f12582k.setText(" " + m8916a(this.drone.mo11200y().m10337c()));
            this.f12583l.setText(" " + m8916a(this.drone.mo11200y().m10336d()));
            this.f12579h.setText(" " + ((int) this.drone.mo11237J().f10942d) + "");
            short m10333g = this.drone.mo11200y().m10333g();
            if (m10333g < 0) {
                m10333g = 0;
            }
            int i = (int) ((m10333g / this.f12569F) * 100.0f);
            int i2 = (int) ((m10333g / this.f12570G) * 100.0f);
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            if (i2 <= 30) {
                this.f12586o.setPercent(i2);
            } else {
                this.f12586o.setPercent(i);
            }
            this.f12578g.setText(" " + ((int) this.f12569F) + " mAH");
            this.f12574c.setText(" " + ((int) m10333g) + " mAH");
            double d = 4.35d - 3.2d;
            BatteryVoltageView batteryVoltageView = this.f12587p;
            double m10340a = ((this.drone.mo11200y().m10340a() / 100.0d) + 2.0d) - 3.2d;
            batteryVoltageView.setPercent(m10340a > 0.0d ? (int) ((m10340a / d) * 100.0d) : 0);
            BatteryVoltageView batteryVoltageView2 = this.f12588q;
            double m10338b = ((this.drone.mo11200y().m10338b() / 100.0d) + 2.0d) - 3.2d;
            batteryVoltageView2.setPercent(m10338b > 0.0d ? (int) ((m10338b / d) * 100.0d) : 0);
            BatteryVoltageView batteryVoltageView3 = this.f12589r;
            double m10337c = ((this.drone.mo11200y().m10337c() / 100.0d) + 2.0d) - 3.2d;
            batteryVoltageView3.setPercent(m10337c > 0.0d ? (int) ((m10337c / d) * 100.0d) : 0);
            BatteryVoltageView batteryVoltageView4 = this.f12590s;
            double m10336d = ((this.drone.mo11200y().m10336d() / 100.0d) + 2.0d) - 3.2d;
            batteryVoltageView4.setPercent(m10336d > 0.0d ? (int) ((m10336d / d) * 100.0d) : 0);
            if (this.f12594y >= f12563C) {
                this.f12575d.setText(((int) this.drone.mo11200y().m10328l()) + "");
            }
            double m10340a2 = (this.drone.mo11200y().m10340a() / 100.0d) + 2.0d;
            double m10338b2 = (this.drone.mo11200y().m10338b() / 100.0d) + 2.0d;
            double m10337c2 = (this.drone.mo11200y().m10337c() / 100.0d) + 2.0d;
            double m10336d2 = 2.0d + (this.drone.mo11200y().m10336d() / 100.0d);
            double d2 = m10340a2 > m10338b2 ? m10340a2 : m10338b2;
            if (d2 <= m10337c2) {
                d2 = m10337c2;
            }
            if (d2 <= m10336d2) {
                d2 = m10336d2;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            if (m8917a(d2, m10340a2) > 0.2d || m10340a2 < 3.0d) {
                if (m8917a(d2, m10340a2) > 0.4d) {
                    this.f12580i.setTextColor(getResources().getColor(C2300R.color.battery_damage));
                    this.f12587p.m7354a(BatteryVoltageView.EnumC3712a.DAMAGE);
                    sb.append(getString(C2300R.C2303string.battery_one) + getString(C2300R.C2303string.battery_damage));
                } else if (m10340a2 < 3.0d) {
                    this.f12580i.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12587p.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_one) + getString(C2300R.C2303string.battery_over_dischange));
                } else {
                    this.f12580i.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12587p.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_one) + getString(C2300R.C2303string.battery_pressure_highter));
                }
                i3 = 1;
            } else {
                this.f12587p.m7354a(BatteryVoltageView.EnumC3712a.NOMAL);
                this.f12580i.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            }
            if (m8917a(d2, m10338b2) > 0.2d || m10338b2 < 3.0d) {
                if (i3 % 2 != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (m8917a(d2, m10338b2) > 0.4d) {
                    this.f12581j.setTextColor(getResources().getColor(C2300R.color.battery_damage));
                    this.f12588q.m7354a(BatteryVoltageView.EnumC3712a.DAMAGE);
                    sb.append(getString(C2300R.C2303string.battery_two) + getString(C2300R.C2303string.battery_damage));
                } else if (m10338b2 < 3.0d) {
                    this.f12581j.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12588q.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_two) + getString(C2300R.C2303string.battery_over_dischange));
                } else {
                    this.f12581j.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12588q.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_two) + getString(C2300R.C2303string.battery_pressure_highter));
                }
                i3++;
                if (i3 % 2 == 0) {
                    sb.append("\n");
                }
            } else {
                this.f12588q.m7354a(BatteryVoltageView.EnumC3712a.NOMAL);
                this.f12581j.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            }
            if (m8917a(d2, m10337c2) > 0.2d || m10337c2 < 3.0d) {
                if (i3 % 2 != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (m8917a(d2, m10337c2) > 0.4d) {
                    this.f12582k.setTextColor(getResources().getColor(C2300R.color.battery_damage));
                    this.f12589r.m7354a(BatteryVoltageView.EnumC3712a.DAMAGE);
                    sb.append(getString(C2300R.C2303string.battery_three) + getString(C2300R.C2303string.battery_damage));
                } else if (m10337c2 < 3.0d) {
                    this.f12582k.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12589r.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_three) + getString(C2300R.C2303string.battery_over_dischange));
                } else {
                    this.f12582k.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12589r.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_three) + getString(C2300R.C2303string.battery_pressure_highter));
                }
                i3++;
                if (i3 % 2 == 0) {
                    sb.append("\n");
                }
            } else {
                this.f12589r.m7354a(BatteryVoltageView.EnumC3712a.NOMAL);
                this.f12582k.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            }
            if (m8917a(d2, m10336d2) > 0.2d || m10336d2 < 3.0d) {
                if (i3 % 2 != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (m8917a(d2, m10336d2) > 0.4d) {
                    this.f12583l.setTextColor(getResources().getColor(C2300R.color.battery_damage));
                    this.f12590s.m7354a(BatteryVoltageView.EnumC3712a.DAMAGE);
                    sb.append(getString(C2300R.C2303string.battery_four) + getString(C2300R.C2303string.battery_damage));
                } else if (m10336d2 < 3.0d) {
                    this.f12583l.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12590s.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_four) + getString(C2300R.C2303string.battery_over_dischange));
                } else {
                    this.f12583l.setTextColor(getResources().getColor(C2300R.color.battery_except));
                    this.f12590s.m7354a(BatteryVoltageView.EnumC3712a.EXCEPT);
                    sb.append(getString(C2300R.C2303string.battery_four) + getString(C2300R.C2303string.battery_pressure_highter));
                }
                if ((i3 + 1) % 2 == 0) {
                    sb.append("\n");
                }
            } else {
                this.f12590s.m7354a(BatteryVoltageView.EnumC3712a.NOMAL);
                this.f12583l.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            }
            this.f12577f.setText(sb.toString());
        }
    }

    /* renamed from: e */
    private void m8910e() {
        if (this.f12594y < 1342 || this.f12592u) {
            return;
        }
        BatteryUpdateSize batteryUpdateSize = new BatteryUpdateSize();
        batteryUpdateSize.setBatteryId(C3579a.m7971a().m7970a(5).m7905i());
        if (TextUtils.isEmpty(batteryUpdateSize.getBatteryId())) {
            return;
        }
        batteryUpdateSize.setBatteryUpdateSize((this.drone.mo11200y().m10327m() / 20) * 20);
        if (batteryUpdateSize.getBatteryUpdateSize() < 20) {
            this.f12591t.m7752d(batteryUpdateSize);
            this.f12592u = false;
            return;
        }
        BatteryUpdateSize m7754b = this.f12591t.m7754b(batteryUpdateSize);
        if (m7754b == null) {
            batteryUpdateSize.setMessageHintSize(1);
            this.f12591t.m7755a(batteryUpdateSize);
            this.f12585n.setVisibility(0);
            this.f12592u = true;
        } else if (m7754b.getMessageHintSize() >= 3) {
        } else {
            batteryUpdateSize.setMessageHintSize(m7754b.getMessageHintSize() + 1);
            this.f12591t.m7753c(batteryUpdateSize);
            this.f12585n.setVisibility(0);
            this.f12592u = true;
        }
    }

    /* renamed from: a */
    public double m8917a(double d, double d2) {
        return ((d * 100.0d) - (d2 * 100.0d)) / 100.0d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.update_flag_iv /* 2131493188 */:
                if (this.f12584m.getVisibility() == 0) {
                    this.f12584m.setVisibility(8);
                    return;
                } else {
                    this.f12584m.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.battery_info);
        this.f12594y = C3579a.m7971a().m7970a(5).m7921b();
        this.f12577f = (TextView) findViewById(C2300R.C2302id.except_tv);
        this.f12573b = (TextView) findViewById(C2300R.C2302id.temperature);
        this.f12586o = (BatteryCapacityView) findViewById(C2300R.C2302id.residue_capacity);
        this.f12574c = (TextView) findViewById(C2300R.C2302id.current_capacity);
        this.f12578g = (TextView) findViewById(C2300R.C2302id.all_capacity);
        this.f12579h = (TextView) findViewById(C2300R.C2302id.discharge_times);
        this.f12580i = (TextView) findViewById(C2300R.C2302id.battery_one);
        this.f12581j = (TextView) findViewById(C2300R.C2302id.battery_two);
        this.f12582k = (TextView) findViewById(C2300R.C2302id.battery_three);
        this.f12583l = (TextView) findViewById(C2300R.C2302id.battery_four);
        this.f12587p = (BatteryVoltageView) findViewById(C2300R.C2302id.battery_voltage_view1);
        this.f12588q = (BatteryVoltageView) findViewById(C2300R.C2302id.battery_voltage_view2);
        this.f12589r = (BatteryVoltageView) findViewById(C2300R.C2302id.battery_voltage_view3);
        this.f12590s = (BatteryVoltageView) findViewById(C2300R.C2302id.battery_voltage_view4);
        this.f12575d = (TextView) findViewById(C2300R.C2302id.over_dischange_tv);
        this.f12576e = (TextView) findViewById(C2300R.C2302id.over_dischange_declare_tv);
        if (this.f12594y < f12563C) {
            this.f12575d.setVisibility(8);
            this.f12576e.setVisibility(8);
        }
        this.f12585n = (ImageView) findViewById(C2300R.C2302id.update_flag_iv);
        this.f12585n.setVisibility(8);
        this.f12585n.setOnClickListener(this);
        this.f12584m = (TextView) findViewById(C2300R.C2302id.battery_update_hint_tv);
        this.f12584m.setVisibility(8);
        m8912c();
        m8913b();
        C3658ar.m7614a(getAssets(), getWindow().getDecorView());
        this.drone.mo11219a(this);
        C2828f.m10854i(this.drone);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 200L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 400L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 600L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 800L);
        this.f12566B = false;
        this.f12574c.setSingleLine(true);
        this.f12574c.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f12574c.setMarqueeRepeatLimit(6);
        this.f12591t = C3625a.m7756a(this);
        this.f12567D = C3579a.m7971a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.drone.mo11214b(this);
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case BATTERYINFO:
                m8913b();
                this.f12571H = false;
                break;
            case BATTERY:
                m8913b();
                m8910e();
                break;
            case FCVERSION2:
                this.f12593v = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
                if (this.f12566B) {
                    return;
                }
                if (c2657a.mo11213l().m10692a() == 5) {
                    this.f12594y = c2657a.mo11213l().m10689c() & 65535;
                    this.f12566B = true;
                }
                m8915a(c2657a.mo11213l());
                if (this.f12594y < f12563C) {
                    this.f12575d.setVisibility(8);
                    this.f12576e.setVisibility(8);
                    break;
                } else {
                    this.f12575d.setVisibility(0);
                    this.f12576e.setVisibility(0);
                    break;
                }
        }
        if (!c2657a.mo11216ac()) {
            this.f12592u = false;
            this.f12584m.setVisibility(8);
            this.f12585n.setVisibility(8);
            this.f12571H = true;
            this.f12586o.setPercent(-1);
            this.f12587p.setPercent(0);
            this.f12588q.setPercent(0);
            this.f12589r.setPercent(0);
            this.f12590s.setPercent(0);
            this.f12580i.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12581j.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12582k.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12583l.setText(getResources().getString(C2300R.C2303string.no_use));
            this.f12580i.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            this.f12581j.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            this.f12582k.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            this.f12583l.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            this.f12573b.setTextColor(getResources().getColor(C2300R.color.battery_standar_text));
            this.f12574c.setText(getString(C2300R.C2303string.no_use));
            this.f12573b.setText(getString(C2300R.C2303string.no_use));
            this.f12579h.setText(getString(C2300R.C2303string.no_use));
            if (this.f12594y >= f12563C) {
                this.f12575d.setText(getString(C2300R.C2303string.no_use));
                this.f12575d.setVisibility(8);
                this.f12576e.setVisibility(8);
            }
            this.f12578g.setText(getString(C2300R.C2303string.no_use));
            this.f12577f.setText("");
            this.f12595z = false;
        }
        if (!c2657a.mo11216ac() || this.f12595z) {
            return;
        }
        this.f12566B = false;
        C2828f.m10854i(c2657a);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 200L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 400L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 600L);
        this.f12568E.sendEmptyMessageDelayed(f12562A, 800L);
        this.f12595z = true;
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
    }
}
