package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p169b.C2370a;
import com.fimi.soul.biz.p178g.C2459j;
import com.fimi.soul.biz.p185n.C2599u;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2729br;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.drone.p199e.C2827e;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2938v;
import com.fimi.soul.entity.BatteryOverDischange;
import com.fimi.soul.entity.CameraMountState;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.setting.newhand.C3531c;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3674d;
import com.fimi.soul.view.EVview;
import com.fimi.soul.view.LightView;
import com.fimi.soul.view.marknumberprogress.EvProgressBar;
import com.fimi.soul.view.marknumberprogress.NumberMarkProgressBar;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.smile.SmileConstants;
import org.p318d.AbstractC5756f;
/* loaded from: classes.dex */
public class ShowDroneStatusFragment extends Fragment implements C2678d.AbstractC2680b {

    /* renamed from: aa */
    private static final int f11694aa = 1;

    /* renamed from: ab */
    private static final int f11695ab = 0;

    /* renamed from: ah */
    private static final double f11696ah = 0.20000000298023224d;

    /* renamed from: ai */
    private static final double f11697ai = 0.4000000059604645d;

    /* renamed from: al */
    private static final int f11698al = 1;

    /* renamed from: am */
    private static final int f11699am = 2;

    /* renamed from: an */
    private static final int f11700an = 3;

    /* renamed from: b */
    public static float f11701b;

    /* renamed from: f */
    public static int f11702f;

    /* renamed from: A */
    private TextView f11703A;

    /* renamed from: B */
    private TextView f11704B;

    /* renamed from: C */
    private TextView f11705C;

    /* renamed from: D */
    private TextView f11706D;

    /* renamed from: E */
    private TextView f11707E;

    /* renamed from: F */
    private TextView f11708F;

    /* renamed from: G */
    private Context f11709G;

    /* renamed from: H */
    private C2657a f11710H;

    /* renamed from: I */
    private DroidPlannerApp f11711I;

    /* renamed from: K */
    private int f11713K;

    /* renamed from: L */
    private EVview f11714L;

    /* renamed from: M */
    private LinearLayout f11715M;

    /* renamed from: N */
    private TextView f11716N;

    /* renamed from: O */
    private LightView f11717O;

    /* renamed from: P */
    private NumberMarkProgressBar f11718P;

    /* renamed from: Q */
    private EvProgressBar f11719Q;

    /* renamed from: R */
    private RelativeLayout f11720R;

    /* renamed from: S */
    private TextView f11721S;

    /* renamed from: T */
    private TextView f11722T;

    /* renamed from: U */
    private TextView f11723U;

    /* renamed from: a */
    C2599u f11729a;

    /* renamed from: aj */
    private BatteryOverDischange f11735aj;

    /* renamed from: ak */
    private C3674d f11736ak;

    /* renamed from: ao */
    private String[] f11737ao;

    /* renamed from: as */
    private Timer f11741as;

    /* renamed from: au */
    private int f11743au;

    /* renamed from: av */
    private int f11744av;

    /* renamed from: ax */
    private double f11746ax;

    /* renamed from: ay */
    private double f11747ay;

    /* renamed from: az */
    private FlightActivity.AbstractC3281a f11748az;

    /* renamed from: c */
    Timer f11749c;

    /* renamed from: d */
    Timer f11750d;

    /* renamed from: e */
    C3531c f11751e;

    /* renamed from: h */
    private TextView f11753h;

    /* renamed from: i */
    private TextView f11754i;

    /* renamed from: j */
    private TextView f11755j;

    /* renamed from: k */
    private TextView f11756k;

    /* renamed from: l */
    private TextView f11757l;

    /* renamed from: m */
    private TextView f11758m;

    /* renamed from: n */
    private TextView f11759n;

    /* renamed from: o */
    private TextView f11760o;

    /* renamed from: p */
    private TextView f11761p;

    /* renamed from: q */
    private TextView f11762q;

    /* renamed from: r */
    private TextView f11763r;

    /* renamed from: s */
    private TextView f11764s;

    /* renamed from: t */
    private TextView f11765t;

    /* renamed from: u */
    private TextView f11766u;

    /* renamed from: v */
    private TextView f11767v;

    /* renamed from: w */
    private TextView f11768w;

    /* renamed from: x */
    private TextView f11769x;

    /* renamed from: y */
    private TextView f11770y;

    /* renamed from: z */
    private TextView f11771z;

    /* renamed from: J */
    private boolean f11712J = true;

    /* renamed from: V */
    private double f11724V = 0.0d;

    /* renamed from: W */
    private int f11725W = 1;

    /* renamed from: X */
    private boolean f11726X = false;

    /* renamed from: Y */
    private boolean f11727Y = false;

    /* renamed from: Z */
    private EnumC3123a f11728Z = EnumC3123a.none_model;

    /* renamed from: ac */
    private final int f11730ac = 2;

    /* renamed from: ad */
    private boolean f11731ad = false;

    /* renamed from: ae */
    private boolean f11732ae = false;

    /* renamed from: af */
    private boolean f11733af = false;

    /* renamed from: ag */
    private boolean f11734ag = false;

    /* renamed from: ap */
    private int f11738ap = 0;

    /* renamed from: aq */
    private int f11739aq = 0;

    /* renamed from: ar */
    private CameraMountState f11740ar = CameraMountState.IDLE;

    /* renamed from: at */
    private Handler f11742at = new Handler() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    ShowDroneStatusFragment.this.f11715M.setVisibility(8);
                    return;
                case 1:
                    C2284z.m12696a(ShowDroneStatusFragment.this.f11709G, (int) C2300R.C2303string.show_drone_status_picture_carlton_toast, 1);
                    return;
                case 2:
                    ShowDroneStatusFragment.this.f11748az.mo8847k();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: aw */
    private boolean f11745aw = true;

    /* renamed from: g */
    boolean f11752g = false;

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment$a */
    /* loaded from: classes.dex */
    private enum EnumC3123a {
        none_model,
        light_model,
        ev_model
    }

    /* renamed from: a */
    private void m9630a(View view) {
        this.f11720R = (RelativeLayout) view.findViewById(C2300R.C2302id.blightness_ev_rl);
        this.f11718P = (NumberMarkProgressBar) view.findViewById(C2300R.C2302id.light_markbar);
        this.f11719Q = (EvProgressBar) view.findViewById(C2300R.C2302id.mEvProgressBar);
        this.f11721S = (TextView) view.findViewById(C2300R.C2302id.info_tv);
        this.f11722T = (TextView) view.findViewById(C2300R.C2302id.info_ev_tv);
        this.f11723U = (TextView) view.findViewById(C2300R.C2302id.model_tv);
        this.f11718P.setEnabled(false);
        this.f11719Q.setEnabled(false);
        this.f11737ao = getActivity().getResources().getStringArray(C2300R.array.ev);
    }

    /* renamed from: a */
    private void m9626a(String str, TextView textView) {
        if (str == null || str.equals(textView.getText().toString())) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: d */
    private double m9618d() {
        double[] dArr = {(this.f11710H.mo11200y().m10340a() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10338b() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10337c() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10336d() / 100.0d) + 2.0d};
        double d = 0.0d;
        int i = 0;
        while (i < 4) {
            double d2 = d;
            for (int i2 = i + 1; i2 < 4; i2++) {
                if (Math.abs(dArr[i2] - dArr[i]) > d2) {
                    d2 = Math.abs(dArr[i2] - dArr[i]);
                }
            }
            i++;
            d = d2;
        }
        return d;
    }

    /* renamed from: e */
    private String m9614e(int i) {
        return C2275t.m12790b((i / 100.0d) + 2.0d, 2);
    }

    /* renamed from: e */
    private boolean m9615e() {
        double[] dArr = {(this.f11710H.mo11200y().m10340a() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10338b() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10337c() / 100.0d) + 2.0d, (this.f11710H.mo11200y().m10336d() / 100.0d) + 2.0d};
        for (int i = 0; i < 4; i++) {
            if (dArr[i] < 3.0d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m9612f() {
        this.f11751e.mo8107d();
        m9605j();
    }

    /* renamed from: f */
    private void m9611f(int i) {
        if (this.f11736ak == null) {
            this.f11736ak = C3674d.m7498a(this.f11709G);
        }
        this.f11735aj = new BatteryOverDischange();
        this.f11735aj.setVoltage(C2275t.m12790b(((((this.f11710H.mo11200y().m10340a() + this.f11710H.mo11200y().m10338b()) + this.f11710H.mo11200y().m10337c()) + this.f11710H.mo11200y().m10336d()) / 100.0d) + 8.0d, 2));
        short m10333g = this.f11710H.mo11200y().m10333g();
        if (m10333g < 0) {
            m10333g = 0;
        }
        this.f11735aj.setBatteryCurrent(((int) m10333g) + "");
        this.f11735aj.setTemperature((this.f11710H.mo11200y().m10331i() - 60) + "");
        this.f11746ax = this.f11710H.mo11237J().m10321e();
        this.f11747ay = this.f11710H.mo11237J().m10322d();
        this.f11735aj.setBatteryFull((this.f11747ay > this.f11746ax ? (int) this.f11747ay : (int) this.f11746ax) + "");
        f11702f = (int) ((m10333g / this.f11746ax) * 100.0d);
        if (f11702f <= 30) {
            this.f11735aj.setBatteryLevel(f11702f + "%");
        } else {
            this.f11735aj.setBatteryLevel(f11702f + "%");
        }
        this.f11735aj.setUserId(C2353b.m12507c(this.f11709G).getUserID());
        this.f11735aj.setBatteryId(C3579a.m7971a().m7970a(5).m7905i() == null ? "0" : C3579a.m7971a().m7970a(5).m7905i());
        this.f11735aj.setBatteryLevel(((int) this.f11710H.mo11200y().m10330j()) + "");
        this.f11735aj.setBatteryOne(m9614e(this.f11710H.mo11200y().m10340a()));
        this.f11735aj.setBatteryTwo(m9614e(this.f11710H.mo11200y().m10338b()));
        this.f11735aj.setBatteryThree(m9614e(this.f11710H.mo11200y().m10337c()));
        this.f11735aj.setBatteryFour(m9614e(this.f11710H.mo11200y().m10336d()));
        this.f11735aj.setBatteryRecyle(((int) this.f11710H.mo11237J().m10323c()) + "");
        this.f11735aj.setVersion(C3579a.m7971a().m7970a(5).m7921b() + "");
        this.f11735aj.setAppType("0");
        this.f11735aj.setAccidentType(i);
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b != null) {
            this.f11735aj.setFcVersion(String.valueOf(c3580b.m7959a()));
        }
        this.f11735aj.setUpdateTimes(String.valueOf((int) this.f11710H.mo11200y().m10327m()));
        this.f11735aj.setUpdateTimes(String.valueOf(-this.f11710H.mo11200y().m10332h()));
        new C2370a(getActivity()).m12429a(this.f11735aj);
    }

    /* renamed from: g */
    private float m9609g(int i) {
        if (i < 0 || i > 78) {
            if (i > 78 && i <= 156) {
                return -1.7f;
            }
            if (i > 156 && i <= 234) {
                return -1.3f;
            }
            if (i > 234 && i <= 312) {
                return -1.0f;
            }
            if (i > 312 && i <= 390) {
                return -0.7f;
            }
            if (i > 390 && i <= 468) {
                return -0.3f;
            }
            if (i > 468 && i <= 546) {
                return 0.0f;
            }
            if (i > 546 && i <= 624) {
                return 0.3f;
            }
            if (i > 624 && i <= 702) {
                return 0.7f;
            }
            if (i > 702 && i <= 780) {
                return 1.0f;
            }
            if (i > 780 && i <= 858) {
                return 1.3f;
            }
            if (i > 858 && i <= 936) {
                return 1.7f;
            }
            return (i <= 936 || i > 1024) ? 0.0f : 2.0f;
        }
        return -2.0f;
    }

    /* renamed from: g */
    private void m9610g() {
        boolean z = false;
        if (C2277v.m12784a(this.f11709G).m12742s() == DeviceType.DEVICE_4K) {
            z = true;
        }
        if (!z || m9608h() < 2016) {
            short m10533c = this.f11710H.mo11221Z().m10533c();
            if (this.f11744av - m10533c < 0) {
                this.f11743au = ((m10533c - 255) * 90) / 255;
            } else {
                this.f11743au = ((m10533c * 90) / 255) - 90;
            }
            this.f11744av = m10533c;
        } else {
            this.f11743au = this.f11710H.mo11221Z().m10520j();
        }
        this.f11708F.setText(String.valueOf(this.f11743au) + this.f11709G.getString(C2300R.C2303string.degree_unit));
    }

    /* renamed from: h */
    private float m9607h(int i) {
        if (i < 0 || i > 156) {
            if (i > 156 && i <= 312) {
                return -1.3f;
            }
            if (i > 312 && i <= 468) {
                return -0.7f;
            }
            if (i > 468 && i <= 546) {
                return 0.0f;
            }
            if (i > 546 && i <= 702) {
                return 0.7f;
            }
            if (i > 702 && i <= 858) {
                return 1.3f;
            }
            return (i <= 858 || i > 1024) ? 0.0f : 2.0f;
        }
        return -2.0f;
    }

    /* renamed from: h */
    private int m9608h() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7955c() <= 0) {
            return 0;
        }
        return c3580b.m7955c();
    }

    /* renamed from: i */
    private void m9606i() {
        if (this.f11746ax > 0.0d) {
            short m10333g = this.f11710H.mo11200y().m10333g();
            if (m10333g < 0) {
                m10333g = 0;
            }
            f11702f = (int) ((m10333g / this.f11746ax) * 100.0d);
            if (f11702f < 0) {
                return;
            }
            if (f11702f > 100) {
                this.f11745aw = true;
                this.f11746ax = 0.0d;
                return;
            }
            if (f11702f <= 0 || f11702f >= 30) {
                this.f11759n.setTextColor(getResources().getColor(C2300R.color.changebetery));
                this.f11755j.setTextColor(getResources().getColor(C2300R.color.changebetery));
                this.f11763r.setTextColor(getResources().getColor(C2300R.color.changebetery));
                this.f11764s.setTextColor(getResources().getColor(C2300R.color.changebetery));
            } else {
                this.f11759n.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
                this.f11755j.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
                this.f11763r.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
                this.f11764s.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
            }
            if (f11702f <= 30) {
                this.f11755j.setText(f11702f + "");
            } else {
                this.f11755j.setText(f11702f + "");
            }
            this.f11764s.setVisibility(8);
            this.f11763r.setVisibility(0);
            m9626a("%", this.f11763r);
            m9626a(getString(C2300R.C2303string.electricity), this.f11759n);
            this.f11763r.setTextSize(16.0f);
            this.f11710H.mo11220a(C2678d.EnumC2679a.NOTIFYPBATTERY);
        }
    }

    /* renamed from: j */
    private void m9605j() {
        C2729br c2729br = new C2729br();
        c2729br.f9966d = C2760r.f10172a;
        c2729br.f9967e = (byte) 1;
        c2729br.f9968f = (byte) 0;
        this.f11710H.mo11217ab().mo10897a(c2729br.mo11073b());
    }

    /* renamed from: a */
    public int m9627a(String str) {
        if (str.equals("unknown")) {
            return 6;
        }
        int i = 0;
        while (true) {
            if (i >= this.f11737ao.length) {
                i = 6;
                break;
            } else if (str.contains(this.f11737ao[i])) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public void m9633a() {
        this.f11740ar = CameraMountState.MOUNT;
    }

    /* renamed from: a */
    public void m9632a(float f) {
        if (this.f11748az != null) {
            this.f11748az.mo8848j();
        }
        String str = "";
        if (f > 0.0f) {
            str = AbstractC5756f.f23063b;
        }
        String str2 = str + f;
        this.f11719Q.setProgress(m9627a(str2));
        this.f11722T.setTextSize(0, this.f11738ap);
        this.f11722T.setTextColor(getActivity().getResources().getColor(C2300R.color.white));
        this.f11722T.setText(getString(C2300R.C2303string.ev2) + "" + str2);
    }

    /* renamed from: a */
    public void m9631a(int i) {
        if (i == 0) {
            this.f11720R.setBackgroundResource(C2300R.C2301drawable.blightness_ev_bg1);
            this.f11721S.setVisibility(i);
        } else {
            this.f11720R.setBackgroundResource(C2300R.C2301drawable.blightness_ev_bg2);
            this.f11721S.setVisibility(4);
        }
        this.f11718P.setVisibility(i);
        this.f11723U.setVisibility(i);
    }

    /* renamed from: a */
    public void m9628a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11748az = abstractC3281a;
    }

    /* renamed from: a */
    public void m9625a(boolean z) {
        if (z) {
            this.f11715M.setVisibility(8);
            this.f11706D.setVisibility(8);
            this.f11707E.setVisibility(8);
        }
        this.f11752g = z;
    }

    /* renamed from: b */
    public void m9624b() {
        this.f11740ar = CameraMountState.DISMOUNT;
    }

    /* renamed from: b */
    public void m9623b(int i) {
        this.f11719Q.setVisibility(i);
        this.f11722T.setVisibility(i);
    }

    /* renamed from: c */
    public void m9621c() {
        if (this.f11741as != null) {
            this.f11741as.cancel();
            this.f11741as = null;
        }
        if (this.f11741as == null) {
            this.f11741as = new Timer();
        }
        this.f11741as.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ShowDroneStatusFragment.this.f11742at.sendEmptyMessage(2);
            }
        }, 200L);
    }

    /* renamed from: c */
    public void m9620c(int i) {
        this.f11718P.setProgressAndInvalidate(i);
        this.f11721S.setText(getString(C2300R.C2303string.blightness) + "" + i + "%");
        this.f11721S.setTextColor(getActivity().getResources().getColor(C2300R.color.front_light_info_text_color));
        this.f11721S.setTextSize(0, this.f11739aq);
    }

    /* renamed from: d */
    public void m9617d(int i) {
        this.f11705C.setVisibility(i);
        this.f11704B.setVisibility(i);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11709G = activity.getApplicationContext();
        this.f11711I = (DroidPlannerApp) activity.getApplication();
        this.f11729a = C2599u.m11573a(getActivity());
    }

    @Override // android.support.p001v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.showdronestates, (ViewGroup) null);
        if (C2238c.m13123e().m12771d()) {
            inflate.findViewById(C2300R.C2302id.bottom_state_rl).setVisibility(0);
        } else {
            inflate.findViewById(C2300R.C2302id.bottom_state_rl).setVisibility(4);
        }
        if (C2238c.m13123e().m12767e()) {
            inflate.findViewById(C2300R.C2302id.bottom_state_rl2).setVisibility(0);
        } else {
            inflate.findViewById(C2300R.C2302id.bottom_state_rl2).setVisibility(4);
        }
        this.f11765t = (TextView) inflate.findViewById(C2300R.C2302id.deslevelspeek);
        this.f11766u = (TextView) inflate.findViewById(C2300R.C2302id.levelspeek);
        this.f11714L = (EVview) inflate.findViewById(C2300R.C2302id.ev_v);
        this.f11717O = (LightView) inflate.findViewById(C2300R.C2302id.light_v);
        m9630a(inflate);
        this.f11708F = (TextView) inflate.findViewById(C2300R.C2302id.gimbal_angle);
        this.f11716N = (TextView) inflate.findViewById(C2300R.C2302id.ev_title);
        this.f11767v = (TextView) inflate.findViewById(C2300R.C2302id.desverticalspeek);
        this.f11768w = (TextView) inflate.findViewById(C2300R.C2302id.verticalspeek);
        this.f11769x = (TextView) inflate.findViewById(C2300R.C2302id.desremotesign);
        this.f11770y = (TextView) inflate.findViewById(C2300R.C2302id.remotesign);
        this.f11771z = (TextView) inflate.findViewById(C2300R.C2302id.desimagetransmission);
        this.f11703A = (TextView) inflate.findViewById(C2300R.C2302id.imagetransmission);
        this.f11704B = (TextView) inflate.findViewById(C2300R.C2302id.network_text);
        this.f11705C = (TextView) inflate.findViewById(C2300R.C2302id.network);
        this.f11706D = (TextView) inflate.findViewById(C2300R.C2302id.ev_text);
        this.f11707E = (TextView) inflate.findViewById(C2300R.C2302id.ev_value_tv);
        this.f11715M = (LinearLayout) inflate.findViewById(C2300R.C2302id.ev_layout);
        this.f11757l = (TextView) inflate.findViewById(C2300R.C2302id.texthight);
        this.f11757l.getPaint().setFakeBoldText(true);
        this.f11758m = (TextView) inflate.findViewById(C2300R.C2302id.textdistance);
        this.f11758m.getPaint().setFakeBoldText(true);
        this.f11759n = (TextView) inflate.findViewById(C2300R.C2302id.textpower);
        this.f11759n.getPaint().setFakeBoldText(true);
        this.f11761p = (TextView) inflate.findViewById(C2300R.C2302id.texthightbelowafter);
        this.f11760o = (TextView) inflate.findViewById(C2300R.C2302id.textsign);
        this.f11760o.getPaint().setFakeBoldText(true);
        this.f11756k = (TextView) inflate.findViewById(C2300R.C2302id.textsignbelow);
        this.f11762q = (TextView) inflate.findViewById(C2300R.C2302id.textdistancenum);
        this.f11763r = (TextView) inflate.findViewById(C2300R.C2302id.textpowernumbelow);
        this.f11764s = (TextView) inflate.findViewById(C2300R.C2302id.textpowernumbelowsec);
        this.f11753h = (TextView) inflate.findViewById(C2300R.C2302id.texthightbelow);
        this.f11753h.getPaint().setFakeBoldText(true);
        this.f11755j = (TextView) inflate.findViewById(C2300R.C2302id.textpowernum);
        this.f11755j.getPaint().setFakeBoldText(true);
        this.f11754i = (TextView) inflate.findViewById(C2300R.C2302id.textdistancenumbelow);
        this.f11754i.getPaint().setFakeBoldText(true);
        this.f11756k = (TextView) inflate.findViewById(C2300R.C2302id.textsignbelow);
        this.f11756k.getPaint().setFakeBoldText(true);
        C3658ar.m7598b(getActivity().getAssets(), this.f11753h, this.f11754i, this.f11755j, this.f11761p, this.f11762q, this.f11763r, this.f11766u, this.f11768w);
        C3658ar.m7612a(getActivity().getAssets(), this.f11756k, this.f11757l, this.f11758m, this.f11759n, this.f11760o, this.f11764s, this.f11765t, this.f11767v, this.f11769x, this.f11771z, this.f11770y, this.f11703A, this.f11704B, this.f11705C);
        this.f11710H = this.f11711I.f7895a;
        this.f11729a.m11572a(new C2599u.AbstractC2601a() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment.2
            @Override // com.fimi.soul.biz.p185n.C2599u.AbstractC2601a
            /* renamed from: a */
            public void mo9604a(String str, String str2) {
                ShowDroneStatusFragment.this.f11705C.setText(str);
            }
        });
        this.f11739aq = getActivity().getResources().getDimensionPixelOffset(C2300R.dimen.progress_text_tile_size);
        this.f11738ap = getActivity().getResources().getDimensionPixelOffset(C2300R.dimen.progress_text_tile2_size);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11710H.mo11214b(this);
        this.f11729a.m11574a();
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11216ac() || !c2657a.mo11217ab().mo10898a()) {
            this.f11732ae = false;
            this.f11733af = false;
            this.f11734ag = false;
            this.f11764s.setVisibility(8);
            this.f11763r.setVisibility(0);
            m9626a("0.0", this.f11754i);
            m9626a("0.0", this.f11753h);
            m9626a("0", this.f11755j);
            m9626a("0.0m/s", this.f11766u);
            m9626a("0.0m/s", this.f11768w);
            m9626a(getString(C2300R.C2303string.electricity), this.f11759n);
            m9626a("%", this.f11763r);
            m9626a(getString(C2300R.C2303string.nothing), this.f11756k);
            m9626a(getString(C2300R.C2303string.nothing), this.f11770y);
            m9626a(getString(C2300R.C2303string.nothing), this.f11703A);
            this.f11708F.setText(getString(C2300R.C2303string.no_use));
            if (c2657a.mo11216ac()) {
                return;
            }
            this.f11746ax = 0.0d;
            this.f11745aw = true;
            this.f11732ae = false;
            this.f11733af = false;
            this.f11734ag = false;
            return;
        }
        switch (enumC2679a) {
            case HEARDATA:
                if (c2657a.mo11216ac() && this.f11745aw) {
                    C2827e.m10865a(c2657a);
                }
                double m12793a = C2275t.m12793a(c2657a.mo11205t().m10644a() / 100.0d, 1);
                double m12793a2 = C2275t.m12793a(c2657a.mo11205t().m10638b() / 100.0d, 1);
                m9626a(m12793a + "m/s", this.f11766u);
                m9626a(m12793a2 + "m/s", this.f11768w);
                if (!this.f11732ae && m9618d() > f11696ah && m9618d() <= f11697ai) {
                    this.f11732ae = true;
                    m9611f(1);
                }
                if (!this.f11733af && m9618d() > f11697ai) {
                    this.f11733af = true;
                    m9611f(2);
                }
                if (this.f11734ag || !m9615e()) {
                    return;
                }
                this.f11734ag = true;
                m9611f(3);
                return;
            case Remotecontrol:
                byte m10447a = c2657a.mo11230Q().m10447a();
                if (30 <= m10447a && m10447a < 80) {
                    m9626a(getString(C2300R.C2303string.remotrmid), this.f11770y);
                    return;
                } else if (m10447a >= 80) {
                    m9626a(getString(C2300R.C2303string.strong), this.f11770y);
                    return;
                } else if (5 >= m10447a || m10447a >= 30) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11770y);
                    return;
                } else {
                    m9626a(getString(C2300R.C2303string.remotelow), this.f11770y);
                    return;
                }
            case SIMULATORINFO:
            default:
                return;
            case NEWREMOTEMODEL:
                this.f11724V = c2657a.m11291i().m10554e();
                if (!this.f11726X || this.f11727Y) {
                    return;
                }
                this.f11707E.setVisibility(8);
                this.f11706D.setVisibility(8);
                int i = (int) ((this.f11724V * 100.0d) / 1024.0d);
                this.f11717O.setLightPercent(this.f11725W);
                m9620c(this.f11725W);
                if (i == this.f11725W || this.f11728Z != EnumC3123a.light_model) {
                    return;
                }
                this.f11715M.setVisibility(0);
                this.f11717O.setVisibility(0);
                m9631a(0);
                m9623b(8);
                if (this.f11748az != null) {
                    this.f11748az.mo8848j();
                }
                this.f11725W = i;
                this.f11742at.removeMessages(0);
                if (this.f11750d != null) {
                    this.f11750d.cancel();
                    this.f11750d = null;
                }
                if (this.f11750d == null) {
                    this.f11750d = new Timer();
                }
                this.f11750d.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        ShowDroneStatusFragment.this.f11742at.sendEmptyMessage(0);
                    }
                }, 3000L);
                return;
            case HEARDDAY:
                double m10498g = (c2657a.mo11202w().m10498g() - 677216.0d) / 10.0d;
                if (!c2657a.m11320al()) {
                    m10498g = 0.0d;
                }
                if (m10498g < 3000.0d) {
                    if (m10498g >= 100.0d || m10498g < 0.0d) {
                        double d = m10498g < -999.0d ? -999.0d : m10498g;
                        m9626a(d < 100.0d ? C2275t.m12793a(d, 1) + "" : ((int) d) + "", this.f11753h);
                        m10498g = d;
                    } else {
                        m9626a(C2275t.m12793a(m10498g, 1) + "", this.f11753h);
                    }
                }
                double m10497h = c2657a.mo11202w().m10497h();
                if (!c2657a.m11320al()) {
                    m10497h = 0.0d;
                }
                if (m10497h > -50.0d && m10497h < 10000.0d && !c2657a.m11312at().m10700g().isLightStream()) {
                    if (m10497h >= 100.0d) {
                        m9626a(((int) m10497h) + "", this.f11754i);
                    } else {
                        m9626a(C2275t.m12793a(m10497h, 1) + "", this.f11754i);
                    }
                }
                if (c2657a.m11320al()) {
                    C2459j m12118a = C2459j.m12118a();
                    m12118a.m12106d(m10497h);
                    m12118a.m12109c(m10498g);
                    m12118a.m12116a((int) c2657a.mo11202w().m10502c());
                }
                C2367d m12459a = C2367d.m12459a();
                int m12444f = m12459a.m12444f();
                if (!C2367d.m12459a().m12436m() || m12444f >= 50 || m10497h >= 300.0d || c2657a.m11312at().m10700g().isLightStream()) {
                    this.f11731ad = false;
                } else if (!this.f11731ad && !C2367d.m12459a().m12438k()) {
                    this.f11742at.sendEmptyMessage(1);
                    this.f11731ad = true;
                }
                if (!m12459a.m12435n() || !m12459a.m12436m()) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11703A);
                } else if (this.f11740ar != CameraMountState.MOUNT) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11703A);
                } else if (20 <= m12444f && m12444f < 45) {
                    m9626a(getString(C2300R.C2303string.remotrmid), this.f11703A);
                } else if (m12444f >= 45) {
                    m9626a(getString(C2300R.C2303string.strong), this.f11703A);
                } else if (m12444f <= 0 || m12444f >= 20) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11703A);
                } else {
                    m9626a(getString(C2300R.C2303string.remotelow), this.f11703A);
                }
                if (c2657a.m11312at().m10700g().isLightStream()) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11756k);
                    return;
                }
                byte m10501d = c2657a.mo11202w().m10501d();
                if (m10501d > 13) {
                    m9626a(((int) m10501d) + " ", this.f11756k);
                } else if (8 < m10501d && m10501d <= 13) {
                    m9626a(((int) m10501d) + " ", this.f11756k);
                } else if (m10501d > 8 || m10501d <= 4) {
                    m9626a(getString(C2300R.C2303string.nothing), this.f11756k);
                } else {
                    m9626a(((int) m10501d) + " ", this.f11756k);
                }
                if (m10501d <= 8) {
                    this.f11756k.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
                    this.f11760o.setTextColor(getResources().getColor(C2300R.color.changebeterylow));
                } else {
                    this.f11756k.setTextColor(getResources().getColor(C2300R.color.changebetery));
                    this.f11760o.setTextColor(getResources().getColor(C2300R.color.changebetery));
                }
                if (!c2657a.m11318an().m10066u()) {
                    return;
                }
                this.f11708F.setText(getString(C2300R.C2303string.no_use));
                return;
            case BATTERYINFO:
                this.f11745aw = false;
                this.f11746ax = c2657a.mo11237J().m10321e();
                this.f11747ay = c2657a.mo11237J().m10322d();
                return;
            case NEW_HAND_OPERATE:
                if (c2657a.m11310av().m10571f() == 3 && c2657a.m11310av().m10573d() == 51 && c2657a.m11310av().m10570g() == 4) {
                    if (c2657a.m11310av().m10569h() == 1) {
                        this.f11727Y = true;
                        this.f11715M.setVisibility(8);
                    } else {
                        this.f11727Y = false;
                        if (this.f11728Z == EnumC3123a.light_model) {
                            this.f11715M.setVisibility(0);
                        }
                        this.f11742at.sendEmptyMessageDelayed(0, 2000L);
                    }
                }
                if (c2657a.m11310av().m10573d() != 34) {
                    return;
                }
                if (c2657a.m11310av().m10571f() != 1 && c2657a.m11310av().m10571f() != 3) {
                    return;
                }
                if (c2657a.m11310av().m10573d() == 34) {
                    if ((c2657a.m11310av().m10569h() & 4) == 4) {
                        this.f11727Y = true;
                        this.f11715M.setVisibility(8);
                    } else {
                        this.f11727Y = false;
                        if (this.f11728Z == EnumC3123a.light_model) {
                            this.f11715M.setVisibility(0);
                        }
                        this.f11742at.sendEmptyMessageDelayed(0, 2000L);
                    }
                }
                if (c2657a.m11310av().m10571f() != 1 || c2657a.m11310av().m10572e() != 0) {
                    return;
                }
                this.f11727Y = false;
                m9605j();
                return;
            case BATTERY:
                m9606i();
                return;
            case backControl:
                C2908c mo11229R = c2657a.mo11229R();
                if (mo11229R == null || mo11229R.m10343b() != 115 || mo11229R.f10925c != 2) {
                    return;
                }
                switch (mo11229R.f10926d) {
                    case 1:
                        if (!this.f11752g) {
                            m9625a(false);
                        }
                        this.f11716N.setText(getString(C2300R.C2303string.ev_value));
                        this.f11726X = false;
                        this.f11717O.setVisibility(8);
                        this.f11714L.setVisibility(0);
                        this.f11706D.setVisibility(0);
                        m9631a(8);
                        m9623b(0);
                        this.f11707E.setVisibility(0);
                        this.f11707E.setText(String.valueOf(f11701b));
                        return;
                    case 2:
                        if (this.f11727Y) {
                            return;
                        }
                        m9625a(false);
                        this.f11716N.setText(getString(C2300R.C2303string.light_ev));
                        this.f11717O.setVisibility(0);
                        this.f11714L.setVisibility(8);
                        m9631a(0);
                        m9623b(8);
                        this.f11726X = true;
                        this.f11728Z = EnumC3123a.light_model;
                        return;
                    default:
                        return;
                }
            case EV_VALUE:
                this.f11728Z = EnumC3123a.ev_model;
                C2938v m11296f = c2657a.m11296f();
                if (m11296f.m10152c() != 2) {
                    return;
                }
                int m10150d = m11296f.m10150d() & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int m10148e = m11296f.m10148e() & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                float m9609g = m9609g((m10148e << 8) | m10150d);
                this.f11716N.setText(getString(C2300R.C2303string.ev_value));
                if (f11701b == m9609g) {
                    return;
                }
                if (m10148e == 255 && m10150d == 255) {
                    return;
                }
                this.f11742at.removeMessages(0);
                this.f11742at.removeMessages(2);
                f11701b = m9609g;
                this.f11707E.setText(String.valueOf(f11701b));
                this.f11714L.m7332a(m9609g);
                m9632a(m9609g);
                if (this.f11715M.getVisibility() == 8 && !this.f11752g) {
                    this.f11707E.setVisibility(0);
                    this.f11706D.setVisibility(0);
                    this.f11715M.setVisibility(0);
                }
                if (this.f11749c != null) {
                    this.f11749c.cancel();
                    this.f11749c = null;
                }
                if (this.f11749c == null) {
                    this.f11749c = new Timer();
                }
                this.f11749c.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusFragment.4
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        ShowDroneStatusFragment.this.f11742at.sendEmptyMessage(0);
                    }
                }, 3000L);
                m9621c();
                return;
            case PTZ_GAIN:
                if (c2657a.m11318an().m10066u()) {
                    return;
                }
                m9610g();
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
        m9612f();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11710H.mo11219a(this);
        this.f11751e = new C3531c(this.f11710H, this.f11709G);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
