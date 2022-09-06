package com.fimi.soul.module.droneTrack;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.FragmentManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.drone.p203i.C2876ag;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2894ay;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2909d;
import com.fimi.soul.drone.p203i.C2910e;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.drone.p203i.p204a.C2867f;
import com.fimi.soul.entity.ErrorMode;
import com.fimi.soul.module.droneTrack.p208a.C3202a;
import com.fimi.soul.module.droneTrack.p208a.C3203b;
import com.fimi.soul.module.droneTrack.p208a.C3204c;
import com.fimi.soul.module.droneTrack.p209b.C3213a;
import com.fimi.soul.module.droneui.DialogC3297a;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.RemotesimulatorView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class PlayBackDroneTrackActivity extends BaseActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AbstractC3216e, AbstractC3217f {

    /* renamed from: I */
    private static final int f12200I = 3;

    /* renamed from: A */
    private TextView f12201A;

    /* renamed from: B */
    private PercentRelativeLayout f12202B;

    /* renamed from: C */
    private PercentRelativeLayout f12203C;

    /* renamed from: D */
    private PalyBackMapFragment f12204D;

    /* renamed from: E */
    private FragmentManager f12205E;

    /* renamed from: F */
    private RemotesimulatorView f12206F;

    /* renamed from: G */
    private C3204c f12207G;

    /* renamed from: M */
    private C3202a f12212M;

    /* renamed from: N */
    private Timer f12213N;

    /* renamed from: P */
    private boolean f12215P;

    /* renamed from: Q */
    private TextView f12216Q;

    /* renamed from: R */
    private RelativeLayout f12217R;

    /* renamed from: S */
    private TextView f12218S;

    /* renamed from: T */
    private TextView f12219T;

    /* renamed from: U */
    private TextView f12220U;

    /* renamed from: V */
    private TextView f12221V;

    /* renamed from: W */
    private TextView f12222W;

    /* renamed from: X */
    private TextView f12223X;

    /* renamed from: Y */
    private TextView f12224Y;

    /* renamed from: Z */
    private TextView f12225Z;

    /* renamed from: a */
    PercentRelativeLayout f12226a;

    /* renamed from: aa */
    private TextView f12227aa;

    /* renamed from: ab */
    private TextView f12228ab;

    /* renamed from: ac */
    private TextView f12229ac;

    /* renamed from: ad */
    private TextView f12230ad;

    /* renamed from: ae */
    private boolean f12231ae;

    /* renamed from: ai */
    private DialogC3297a f12235ai;

    /* renamed from: d */
    private ImageView f12239d;

    /* renamed from: e */
    private ImageView f12240e;

    /* renamed from: f */
    private ImageView f12241f;

    /* renamed from: g */
    private ImageView f12242g;

    /* renamed from: h */
    private ImageView f12243h;

    /* renamed from: i */
    private ImageView f12244i;

    /* renamed from: j */
    private ImageView f12245j;

    /* renamed from: k */
    private ImageView f12246k;

    /* renamed from: l */
    private ImageView f12247l;

    /* renamed from: m */
    private ImageView f12248m;

    /* renamed from: n */
    private TextView f12249n;

    /* renamed from: o */
    private TextView f12250o;

    /* renamed from: p */
    private TextView f12251p;

    /* renamed from: q */
    private SeekBar f12252q;

    /* renamed from: r */
    private TextView f12253r;

    /* renamed from: s */
    private TextView f12254s;

    /* renamed from: t */
    private TextView f12255t;

    /* renamed from: u */
    private TextView f12256u;

    /* renamed from: v */
    private TextView f12257v;

    /* renamed from: w */
    private TextView f12258w;

    /* renamed from: x */
    private TextView f12259x;

    /* renamed from: y */
    private TextView f12260y;

    /* renamed from: z */
    private TextView f12261z;

    /* renamed from: H */
    private final int f12208H = 100;

    /* renamed from: J */
    private int f12209J = 1000;

    /* renamed from: K */
    private int f12210K = 0;

    /* renamed from: L */
    private C3203b f12211L = C3203b.m9155a();

    /* renamed from: O */
    private final int f12214O = 1;

    /* renamed from: af */
    private EnumC3199a f12232af = EnumC3199a.Payback;

    /* renamed from: ag */
    private int f12233ag = 0;

    /* renamed from: ah */
    private Handler f12234ah = new Handler() { // from class: com.fimi.soul.module.droneTrack.PlayBackDroneTrackActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!PlayBackDroneTrackActivity.this.f12231ae) {
                if (message.what == 100) {
                    PlayBackDroneTrackActivity.this.f12215P = true;
                    if (PlayBackDroneTrackActivity.this.f12226a.isShown()) {
                        PlayBackDroneTrackActivity.this.f12226a.setVisibility(8);
                    }
                    PlayBackDroneTrackActivity.this.f12233ag = C3203b.m9155a().m9148b().size();
                    PlayBackDroneTrackActivity.this.f12201A.setText(PlayBackDroneTrackActivity.m9217b((PlayBackDroneTrackActivity.this.f12233ag * 1000) + ""));
                    PlayBackDroneTrackActivity.this.f12252q.setMax(PlayBackDroneTrackActivity.this.f12233ag);
                    PlayBackDroneTrackActivity.this.f12261z.setText(PlayBackDroneTrackActivity.m9217b((PlayBackDroneTrackActivity.this.f12210K * 1000) + ""));
                } else if (message.what != 3) {
                    if (message.what != 1) {
                        return;
                    }
                    PlayBackDroneTrackActivity.this.m9223b();
                } else {
                    PlayBackDroneTrackActivity.m9201g(PlayBackDroneTrackActivity.this);
                    PlayBackDroneTrackActivity.this.f12252q.setProgress(PlayBackDroneTrackActivity.this.f12210K);
                    PlayBackDroneTrackActivity.this.f12261z.setText(PlayBackDroneTrackActivity.m9217b((PlayBackDroneTrackActivity.this.f12210K * 1000) + ""));
                    PlayBackDroneTrackActivity.this.m9222b(PlayBackDroneTrackActivity.this.f12210K);
                    if (PlayBackDroneTrackActivity.this.f12210K == 1) {
                        PlayBackDroneTrackActivity.this.f12204D.m9246b();
                        PlayBackDroneTrackActivity.this.f12211L.m9145c().clear();
                    }
                    if (PlayBackDroneTrackActivity.this.f12210K <= PlayBackDroneTrackActivity.this.f12252q.getMax()) {
                        PlayBackDroneTrackActivity.this.f12234ah.sendEmptyMessageDelayed(3, PlayBackDroneTrackActivity.this.f12209J);
                        return;
                    }
                    PlayBackDroneTrackActivity.this.f12210K = 0;
                    PlayBackDroneTrackActivity.this.f12252q.setProgress(PlayBackDroneTrackActivity.this.f12210K);
                    PlayBackDroneTrackActivity.this.f12261z.setText(PlayBackDroneTrackActivity.m9217b((PlayBackDroneTrackActivity.this.f12210K * 1000) + ""));
                    PlayBackDroneTrackActivity.this.m9198i((int) C2300R.mipmap.btn_playback_play);
                    PlayBackDroneTrackActivity.this.f12232af = EnumC3199a.Payback;
                }
            }
        }
    };

    /* renamed from: b */
    int f12237b = 0;

    /* renamed from: c */
    int f12238c = 0;

    /* renamed from: aj */
    private double f12236aj = 0.0d;

    /* renamed from: com.fimi.soul.module.droneTrack.PlayBackDroneTrackActivity$a */
    /* loaded from: classes.dex */
    enum EnumC3199a {
        Payback,
        Stop
    }

    /* renamed from: a */
    private float m9224a(double[] dArr, boolean z, float f) {
        if (z) {
            if (f < dArr[0]) {
                return 0.0f;
            }
            if (f >= dArr[0] && f < dArr[1]) {
                return (f - 3.15f) / 0.32f;
            }
            if (f >= dArr[1] && f < dArr[2]) {
                return (f - 3.47f) / 0.17f;
            }
            if (f >= dArr[2] && f < dArr[3]) {
                return (f - 3.64f) / 0.15f;
            }
            if (f >= dArr[3]) {
            }
            return 0.0f;
        } else if (f < dArr[0]) {
            return 0.0f;
        } else {
            if (f >= dArr[0] && f < dArr[1]) {
                return (f - 3.43f) / 0.3f;
            }
            if (f >= dArr[1] && f < dArr[2]) {
                return (f - 3.73f) / 0.15f;
            }
            if (f >= dArr[2] && f < dArr[3]) {
                return (f - 3.88f) / 0.14f;
            }
            if (f >= dArr[3]) {
            }
            return 0.0f;
        }
    }

    /* renamed from: a */
    private String m9241a(double d) {
        return String.format("%.2f", Double.valueOf(d));
    }

    /* renamed from: a */
    private void m9240a(double d, boolean z) {
    }

    /* renamed from: a */
    private void m9239a(int i, int i2, int i3) {
        if (this.f12235ai != null && this.f12235ai.isShowing()) {
            this.f12235ai.dismiss();
            this.f12235ai = null;
        }
        this.f12235ai = new DialogC3297a(this, getString(i), getString(i2), i3, 3, false, new DialogC3297a.AbstractC3300a() { // from class: com.fimi.soul.module.droneTrack.PlayBackDroneTrackActivity.2
            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: a */
            public void mo8080a() {
                if (PlayBackDroneTrackActivity.this.f12235ai != null) {
                    PlayBackDroneTrackActivity.this.f12235ai.dismiss();
                    PlayBackDroneTrackActivity.this.f12235ai = null;
                }
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: b */
            public void mo8079b() {
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: c */
            public void mo8078c() {
            }

            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: d */
            public void mo8077d() {
                if (PlayBackDroneTrackActivity.this.f12235ai != null) {
                    PlayBackDroneTrackActivity.this.f12235ai.dismiss();
                    PlayBackDroneTrackActivity.this.f12235ai = null;
                }
            }
        });
        this.f12235ai.setCancelable(true);
        this.f12235ai.show();
    }

    /* renamed from: a */
    private void m9238a(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }

    /* renamed from: a */
    private void m9237a(TextView textView) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(AsyncImageView.f21295a));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText().toString());
        spannableStringBuilder.setSpan(foregroundColorSpan, 1, 3, 33);
        textView.setText(spannableStringBuilder);
    }

    /* renamed from: a */
    private void m9236a(C2867f c2867f) {
        m9221b(c2867f.m10703d(), c2867f.m10702e(), c2867f.m10701f());
    }

    /* renamed from: a */
    private void m9235a(C2876ag c2876ag) {
        double m12793a = C2275t.m12793a(c2876ag.m10644a() / 100.0d, 2);
        double m12793a2 = C2275t.m12793a(c2876ag.m10638b() / 100.0d, 2);
        this.f12254s.setText(m12793a + "m/s");
        this.f12256u.setText(m12793a2 + "m/s");
        this.f12204D.m9255a((float) (c2876ag.m10620k() / 10.0d));
    }

    /* renamed from: a */
    private void m9234a(C2882am c2882am) {
        C2908c m9135k = this.f12211L.m9135k();
        C3658ar.m7621a(c2882am.m10561b(), 12);
        int m7621a = C3658ar.m7621a(c2882am.m10561b(), 13);
        if (m9135k != null) {
            if (m7621a == 1) {
                this.f12206F.m7259a((int) c2882am.m10546i(), (int) c2882am.m10548h(), (int) c2882am.m10550g(), (int) c2882am.m10552f());
            } else {
                this.f12206F.m7259a((int) c2882am.m10546i(), (int) c2882am.m10550g(), (int) c2882am.m10548h(), (int) c2882am.m10552f());
            }
        }
    }

    /* renamed from: a */
    private void m9233a(C2886aq c2886aq) {
        double d = -999.0d;
        double m10498g = (c2886aq.m10498g() - 677216.0d) / 10.0d;
        if (m10498g < 3000.0d) {
            if (m10498g >= 100.0d || m10498g < 0.0d) {
                if (m10498g >= -999.0d) {
                    d = m10498g;
                }
                m9225a(d < 100.0d ? C2275t.m12793a(d, 1) + C0413a.f922b : ((int) d) + C0413a.f922b, this.f12258w);
            } else {
                m9225a(C2275t.m12793a(m10498g, 1) + C0413a.f922b, this.f12258w);
            }
        }
        double m10497h = c2886aq.m10497h();
        if (m10497h > -50.0d && m10497h < 10000.0d && !this.drone.m11312at().m10700g().isLightStream()) {
            if (m10497h >= 100.0d) {
                m9225a(((int) m10497h) + C0413a.f922b, this.f12260y);
            } else {
                m9225a(C2275t.m12793a(m10497h, 1) + C0413a.f922b, this.f12260y);
            }
        }
        m9202g(c2886aq.m10501d());
    }

    /* renamed from: a */
    private void m9232a(C2894ay c2894ay) {
        m9200h(c2894ay.m10447a());
    }

    /* renamed from: a */
    private void m9231a(C2909d c2909d) {
        this.f12218S.setText((c2909d.m10331i() - 60) + getString(C2300R.C2303string.temp_unit));
        this.f12219T.setText(m9241a(Math.abs((int) c2909d.m10332h()) / 1000.0d) + "A");
        this.f12220U.setText(m9241a((c2909d.m10340a() / 100.0d) + 2.0d) + "V");
        this.f12221V.setText(m9241a((c2909d.m10338b() / 100.0d) + 2.0d) + "V");
        this.f12222W.setText(m9241a((c2909d.m10337c() / 100.0d) + 2.0d) + "V");
        this.f12223X.setText(m9241a((c2909d.m10336d() / 100.0d) + 2.0d) + "V");
    }

    /* renamed from: a */
    private void m9225a(String str, TextView textView) {
        if (str == null || str.equals(textView.getText().toString())) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: b */
    public static String m9217b(String str) {
        return new SimpleDateFormat("mm:ss").format(new Date(new Long(str).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9223b() {
        ErrorMode m9094a;
        if (this.f12212M == null || (m9094a = C3213a.m9095a().m9094a(this.f12212M)) == null) {
            return;
        }
        ArrayList lightErrorList = m9094a.getLightErrorList();
        if (lightErrorList.size() <= this.f12237b) {
            this.f12237b = 0;
        }
        if (this.drone.m11320al()) {
            if (this.drone.m11318an().m10118W()) {
                this.f12238c++;
                if (this.f12238c >= 3) {
                    m9239a(C2300R.C2303string.title_sky_bat_lowpower_dangerous, C2300R.C2303string.des_sky_bat_lowpower_dangerous, C2300R.C2301drawable.plane_fall_bg);
                    this.f12238c = 0;
                }
            } else if (this.drone.m11318an().m10121T()) {
                this.f12238c++;
                if (this.f12238c >= 7) {
                    m9239a(C2300R.C2303string.title_sky_landing_BAT_LOWPOWER, C2300R.C2303string.des_sky_landing_BAT_LOWPOWER, C2300R.C2301drawable.plane_fall_bg);
                    this.f12238c = 0;
                }
            }
        }
        if (lightErrorList == null || lightErrorList.size() <= 0) {
            m9212c("");
            m9216c();
        } else {
            m9211d();
            this.f12251p.setTextColor(getResources().getColor(C2300R.color.warmtextcl));
            m9212c(getText(((Integer) lightErrorList.get(this.f12237b)).intValue()).toString());
        }
        this.f12237b++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9222b(int i) {
        C2864c c2864c;
        List<Object> list = this.f12211L.m9148b().get(Integer.valueOf(i));
        if (list != null) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof C2886aq) {
                        C2886aq c2886aq = (C2886aq) obj;
                        if (c2886aq != null) {
                            this.f12212M.m9176a(c2886aq);
                            this.f12204D.m9249a(c2886aq);
                            m9233a(c2886aq);
                        }
                    } else if (obj instanceof C2877ah) {
                        C2877ah c2877ah = (C2877ah) obj;
                        if (c2877ah != null && this.f12204D != null) {
                            this.f12212M.m9179a(c2877ah);
                            this.f12204D.m9250a(c2877ah);
                        }
                    } else if (obj instanceof C2876ag) {
                        C2876ag c2876ag = (C2876ag) obj;
                        if (c2876ag != null) {
                            m9235a(c2876ag);
                            this.f12212M.m9180a(c2876ag);
                        }
                    } else if (obj instanceof C2894ay) {
                        C2894ay c2894ay = (C2894ay) obj;
                        if (c2894ay != null) {
                            m9232a(c2894ay);
                            this.f12212M.m9175a(c2894ay);
                        }
                    } else if (obj instanceof C2910e) {
                        C2910e c2910e = (C2910e) obj;
                        if (c2910e != null) {
                            this.f12212M.m9172a(c2910e);
                        }
                    } else if (obj instanceof C2909d) {
                        C2909d c2909d = (C2909d) obj;
                        if (c2909d != null) {
                            this.f12212M.m9173a(c2909d);
                            m9220b(c2909d);
                            m9231a(c2909d);
                        }
                    } else if (obj instanceof C2867f) {
                        C2867f c2867f = (C2867f) obj;
                        if (c2867f != null) {
                            this.f12212M.m9181a(c2867f);
                            m9236a(c2867f);
                        }
                    } else if (obj instanceof C2882am) {
                        C2882am c2882am = (C2882am) obj;
                        if (c2882am != null) {
                            this.f12212M.m9177a(c2882am);
                            m9234a(c2882am);
                        }
                    } else if (obj instanceof C2940x) {
                        C2940x c2940x = (C2940x) obj;
                        if (c2940x != null) {
                            this.f12212M.m9171a(c2940x);
                        }
                    } else if ((obj instanceof C2864c) && (c2864c = (C2864c) obj) != null) {
                        this.f12212M.m9182a(c2864c);
                        if (c2864c.m10721b() != 4 && c2864c.m10721b() != 5 && c2864c.m10721b() != 6) {
                            this.f12204D.m9251a(c2864c);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m9221b(int i, int i2, int i3) {
        if (i == 2 && !this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.lightstreamfly);
            m9210d(C2300R.C2301drawable.icon_flight_model_vpu3x);
        } else if (i == 1 && !this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.gpsfly);
            m9210d(C2300R.C2301drawable.icon_flight_model_gps3x);
        } else if (i == 0 && !this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.attibase);
            m9210d(C2300R.C2301drawable.icon_flight_model_atti3x);
        } else if (i == 2 && this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.lightstreamfling);
            m9210d(C2300R.C2301drawable.icon_flight_model_vpu3x);
        } else if (i == 1 && this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.gpsfling);
            m9210d(C2300R.C2301drawable.icon_flight_model_gps3x);
        } else if (i == 0 && this.f12212M.m9161j() && i2 == 1) {
            m9215c(C2300R.C2303string.attfling);
            m9210d(C2300R.C2301drawable.icon_flight_model_atti3x);
        } else if (i2 == 7) {
            m9215c(C2300R.C2303string.tohome);
            m9210d(C2300R.C2301drawable.sailround_icon);
        } else if (i2 == 8) {
            m9215c(C2300R.C2303string.returntohome);
            m9210d(C2300R.C2301drawable.sailround_icon);
        } else if (i2 == 3) {
            m9215c(C2300R.C2303string.landing);
            m9210d(C2300R.C2301drawable.landing_icon);
        } else if (i2 == 9) {
            m9215c(C2300R.C2303string.lowlanding);
            m9210d(C2300R.C2301drawable.landing_icon);
        } else if (i2 == 2) {
            m9215c(C2300R.C2303string.take_off);
            m9210d(C2300R.C2301drawable.takeoff_icon);
        } else if (i2 == 4) {
            if (i3 == 4) {
                m9215c(C2300R.C2303string.stopflyto);
                m9210d(C2300R.C2301drawable.destination_icon);
            } else if (i3 != 2) {
            } else {
                m9215c(C2300R.C2303string.flyto);
                m9210d(C2300R.C2301drawable.destination_icon);
            }
        } else if (i2 == 5) {
            if (i3 == 4) {
                m9215c(C2300R.C2303string.stop_poi_fly);
                m9210d(C2300R.C2301drawable.detouringpoint_icon);
            } else if (i3 != 2) {
            } else {
                m9215c(C2300R.C2303string.interestFly);
                m9210d(C2300R.C2301drawable.detouringpoint_icon);
            }
        } else if (i2 == 6) {
            if (i3 == 4) {
                m9215c(C2300R.C2303string.stopwaypoint);
                m9210d(C2300R.C2301drawable.icon_fly_airline);
            } else if (i3 != 2) {
            } else {
                m9215c(C2300R.C2303string.execuwaypoint);
                m9210d(C2300R.C2301drawable.icon_fly_airline);
            }
        } else if (i2 != 10) {
            m9215c(C2300R.C2303string.condrone);
            m9210d(C2300R.C2301drawable.normal_icon);
        } else if (i3 == 4) {
            m9215c(C2300R.C2303string.stoptake_photo);
            m9210d(C2300R.mipmap.icon_fly_mode_selfie);
        } else if (i3 != 2) {
        } else {
            m9215c(C2300R.C2303string.take_photo_fly);
            m9210d(C2300R.mipmap.icon_fly_mode_selfie);
        }
    }

    /* renamed from: b */
    private void m9220b(C2909d c2909d) {
        int i = 100;
        C2910e m9162i = this.f12212M.m9162i();
        double m10322d = m9162i.m10322d();
        double m10321e = m9162i.m10321e();
        int m10333g = 0.0d != m10321e ? (int) ((c2909d.m10333g() / m10321e) * 100.0d) : (int) ((c2909d.m10333g() / 5200.0d) * 100.0d);
        int m10333g2 = 0.0d != m10322d ? (int) ((c2909d.m10333g() / m10322d) * 100.0d) : (int) ((c2909d.m10333g() / 5200.0d) * 100.0d);
        if (m10333g < 0 || m10333g2 < 0) {
            return;
        }
        if (m10333g2 > 100) {
            m10333g2 = 100;
        }
        if (m10333g <= 100) {
            i = m10333g;
        }
        if (m10333g2 <= 0 || m10333g2 >= 30) {
            this.f12250o.setTextColor(getResources().getColor(C2300R.color.white));
            this.f12250o.setText(i + "%");
            return;
        }
        this.f12250o.setText(m10333g2 + "%");
        this.f12250o.setTextColor(getResources().getColor(C2300R.color.battery_except));
    }

    /* renamed from: c */
    private void m9216c() {
        this.f12241f.setVisibility(4);
    }

    /* renamed from: c */
    private void m9215c(int i) {
        if (i == 0 || getString(i).equals(this.f12249n.getText().toString())) {
            return;
        }
        this.f12249n.setText(i);
    }

    /* renamed from: c */
    private void m9212c(String str) {
        if (str == null || str.equals(this.f12251p.getText().toString())) {
            return;
        }
        this.f12251p.setText(str, TextView.BufferType.NORMAL);
    }

    /* renamed from: d */
    private void m9211d() {
        this.f12241f.setVisibility(0);
    }

    /* renamed from: d */
    private void m9210d(int i) {
        if (getString(C2300R.C2303string.self_error_result).equals(this.f12249n.getText().toString())) {
            this.f12240e.setImageResource(C2300R.C2301drawable.notnormal_icon);
            this.f12240e.setTag(Integer.valueOf((int) C2300R.C2301drawable.notnormal_icon));
        } else if (this.f12240e.getTag() == null) {
            this.f12240e.setImageResource(i);
            this.f12240e.setTag(Integer.valueOf(i));
        } else if (i == ((Integer) this.f12240e.getTag()).intValue()) {
        } else {
            this.f12240e.setImageResource(i);
            this.f12240e.setTag(Integer.valueOf(i));
        }
    }

    /* renamed from: e */
    private void m9207e() {
        this.f12248m = (ImageView) findViewById(C2300R.C2302id.show_more_battery_status);
        this.f12203C = (PercentRelativeLayout) findViewById(C2300R.C2302id.dront_battery_RL);
        this.f12224Y = (TextView) findViewById(C2300R.C2302id.battery_tem_des);
        this.f12225Z = (TextView) findViewById(C2300R.C2302id.battery_electricity_des);
        this.f12227aa = (TextView) findViewById(C2300R.C2302id.battery_voltage_one);
        this.f12228ab = (TextView) findViewById(C2300R.C2302id.battery_voltage_sencond);
        this.f12229ac = (TextView) findViewById(C2300R.C2302id.battery_voltage_three);
        this.f12230ad = (TextView) findViewById(C2300R.C2302id.battery_voltage_four);
        this.f12218S = (TextView) findViewById(C2300R.C2302id.battery_tem_des_value);
        this.f12219T = (TextView) findViewById(C2300R.C2302id.battery_electricity_des_value);
        this.f12220U = (TextView) findViewById(C2300R.C2302id.battery_voltage_one_value);
        this.f12221V = (TextView) findViewById(C2300R.C2302id.battery_voltage_sencond_value);
        this.f12222W = (TextView) findViewById(C2300R.C2302id.battery_voltage_three_value);
        this.f12223X = (TextView) findViewById(C2300R.C2302id.battery_voltage_four_value);
        this.f12217R = (RelativeLayout) findViewById(C2300R.C2302id.play_back_start);
        this.f12216Q = (TextView) findViewById(C2300R.C2302id.drone_gps_number);
        this.f12226a = (PercentRelativeLayout) findViewById(C2300R.C2302id.progress_loading);
        this.f12206F = (RemotesimulatorView) findViewById(C2300R.C2302id.remote_simulator);
        this.f12202B = (PercentRelativeLayout) findViewById(C2300R.C2302id.drone_more_status);
        this.f12251p = (TextView) findViewById(C2300R.C2302id.dronerrorcode);
        this.f12251p.requestFocus();
        this.f12252q = (SeekBar) findViewById(C2300R.C2302id.paly_seebar);
        this.f12252q.setOnSeekBarChangeListener(this);
        this.f12247l = (ImageView) findViewById(C2300R.C2302id.paly_btn);
        this.f12247l.setOnClickListener(this);
        this.f12239d = (ImageView) findViewById(C2300R.C2302id.back_btn);
        this.f12240e = (ImageView) findViewById(C2300R.C2302id.headview);
        this.f12241f = (ImageView) findViewById(C2300R.C2302id.divide_line2);
        this.f12242g = (ImageView) findViewById(C2300R.C2302id.remote_signal);
        this.f12243h = (ImageView) findViewById(C2300R.C2302id.gps_signal);
        this.f12244i = (ImageView) findViewById(C2300R.C2302id.show_more_status);
        this.f12245j = (ImageView) findViewById(C2300R.C2302id.show_more_remote_status);
        this.f12246k = (ImageView) findViewById(C2300R.C2302id.show_more_gps_status);
        this.f12249n = (TextView) findViewById(C2300R.C2302id.dronestuts);
        this.f12250o = (TextView) findViewById(C2300R.C2302id.drone_signal_value);
        this.f12253r = (TextView) findViewById(C2300R.C2302id.hs_des);
        this.f12254s = (TextView) findViewById(C2300R.C2302id.hs_value);
        this.f12255t = (TextView) findViewById(C2300R.C2302id.vs_des);
        this.f12256u = (TextView) findViewById(C2300R.C2302id.vs_value);
        this.f12257v = (TextView) findViewById(C2300R.C2302id.height_des);
        this.f12258w = (TextView) findViewById(C2300R.C2302id.height_des_value);
        this.f12259x = (TextView) findViewById(C2300R.C2302id.distance_des);
        this.f12260y = (TextView) findViewById(C2300R.C2302id.distance_des_value);
        this.f12261z = (TextView) findViewById(C2300R.C2302id.play_back_progress_fact);
        this.f12201A = (TextView) findViewById(C2300R.C2302id.play_back_progress_all);
        C3658ar.m7598b(getAssets(), this.f12250o, this.f12254s, this.f12256u, this.f12258w, this.f12260y, this.f12261z, this.f12201A, this.f12224Y, this.f12225Z, this.f12227aa, this.f12228ab, this.f12229ac, this.f12230ad);
        C3658ar.m7612a(getAssets(), this.f12249n, this.f12253r, this.f12255t, this.f12257v, this.f12259x, this.f12251p, this.f12218S, this.f12219T, this.f12220U, this.f12221V, this.f12222W, this.f12223X);
        for (View view : new View[]{this.f12239d, this.f12247l, this.f12246k, this.f12245j, this.f12217R, this.f12244i, this.f12248m}) {
            view.setOnClickListener(this);
        }
        m9237a(this.f12257v);
        m9237a(this.f12259x);
    }

    /* renamed from: e */
    private void m9206e(int i) {
        C2864c c2864c;
        List<LatLng> m9145c = C3203b.m9155a().m9145c();
        m9145c.clear();
        for (int i2 = 0; i2 < i; i2++) {
            List<Object> list = this.f12211L.m9148b().get(Integer.valueOf(i2));
            if (list != null) {
                for (Object obj : list) {
                    if (obj != null) {
                        if (obj instanceof C2886aq) {
                            C2886aq c2886aq = (C2886aq) obj;
                            if (c2886aq != null) {
                                this.f12212M.m9176a(c2886aq);
                                C3639ai m7726a = C3633ac.m7726a(c2886aq.m10499f(), c2886aq.m10500e());
                                LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
                                if (!m9145c.contains(latLng)) {
                                    m9145c.add(latLng);
                                }
                            }
                        } else if (obj instanceof C2877ah) {
                            C2877ah c2877ah = (C2877ah) obj;
                            if (c2877ah != null && this.f12204D != null) {
                                this.f12212M.m9179a(c2877ah);
                            }
                        } else if (obj instanceof C2876ag) {
                            C2876ag c2876ag = (C2876ag) obj;
                            if (c2876ag != null) {
                                this.f12212M.m9180a(c2876ag);
                            }
                        } else if (obj instanceof C2894ay) {
                            C2894ay c2894ay = (C2894ay) obj;
                            if (c2894ay != null) {
                                this.f12212M.m9175a(c2894ay);
                            }
                        } else if (obj instanceof C2910e) {
                            C2910e c2910e = (C2910e) obj;
                            if (c2910e != null) {
                                this.f12212M.m9172a(c2910e);
                            }
                        } else if (obj instanceof C2909d) {
                            C2909d c2909d = (C2909d) obj;
                            if (c2909d != null) {
                                this.f12212M.m9173a(c2909d);
                                m9220b(c2909d);
                            }
                        } else if (obj instanceof C2867f) {
                            C2867f c2867f = (C2867f) obj;
                            if (c2867f != null) {
                                this.f12212M.m9181a(c2867f);
                            }
                        } else if (obj instanceof C2882am) {
                            C2882am c2882am = (C2882am) obj;
                            if (c2882am != null) {
                                this.f12212M.m9177a(c2882am);
                                m9234a(c2882am);
                            }
                        } else if (obj instanceof C2910e) {
                            C2910e c2910e2 = (C2910e) obj;
                            if (c2910e2 != null) {
                                this.f12212M.m9172a(c2910e2);
                            }
                        } else if (obj instanceof C2908c) {
                            C2908c c2908c = (C2908c) obj;
                            if (c2908c != null) {
                                this.f12212M.m9174a(c2908c);
                            }
                        } else if (obj instanceof C2910e) {
                            C2910e c2910e3 = (C2910e) obj;
                            if (c2910e3 != null) {
                                this.f12212M.m9172a(c2910e3);
                            }
                        } else if (obj instanceof C2908c) {
                            C2908c c2908c2 = (C2908c) obj;
                            if (c2908c2 != null) {
                                this.f12212M.m9174a(c2908c2);
                            }
                        } else if ((obj instanceof C2864c) && (c2864c = (C2864c) obj) != null) {
                            this.f12212M.m9182a(c2864c);
                        }
                    }
                }
            }
            if (i2 == i - 1 && m9145c.size() > 0) {
                this.f12204D.m9252a(m9145c.get(m9145c.size() - 1), m9145c);
            }
        }
    }

    /* renamed from: f */
    private void m9204f(int i) {
        if (i == 1) {
            m9238a(this.f12246k, C2300R.C2301drawable.btn_playback_satellite_map_normal);
        } else {
            m9238a(this.f12246k, C2300R.C2301drawable.btn_playback_satellite_map_checked);
        }
    }

    /* renamed from: g */
    static /* synthetic */ int m9201g(PlayBackDroneTrackActivity playBackDroneTrackActivity) {
        int i = playBackDroneTrackActivity.f12210K;
        playBackDroneTrackActivity.f12210K = i + 1;
        return i;
    }

    /* renamed from: g */
    private void m9202g(int i) {
        this.f12216Q.setText(i + "");
        if (i < 2) {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_0);
        } else if (i >= 2 && i < 4) {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_1);
        } else if (i >= 4 && i < 8) {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_2);
        } else if (i >= 8 && i < 12) {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_3);
        } else if (i >= 12 && i < 16) {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_4);
        } else if (i < 16) {
        } else {
            m9238a(this.f12243h, C2300R.mipmap.icon_playback_signal_5);
        }
    }

    /* renamed from: h */
    private void m9200h(int i) {
        if (i < 25) {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_0);
        } else if (i >= 25 && i < 35) {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_1);
        } else if (i >= 35 && i < 50) {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_2);
        } else if (i >= 50 && i < 65) {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_3);
        } else if (i >= 65 && i < 80) {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_4);
        } else if (i < 80) {
        } else {
            m9238a(this.f12242g, C2300R.mipmap.icon_playback_signal_5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m9198i(int i) {
        this.f12247l.setImageResource(i);
    }

    @Override // com.fimi.soul.module.droneTrack.AbstractC3217f
    /* renamed from: a */
    public void mo9083a() {
        this.f12234ah.sendEmptyMessage(100);
    }

    @Override // com.fimi.soul.module.droneTrack.AbstractC3216e
    /* renamed from: a */
    public void mo9084a(int i) {
        m9204f(i);
    }

    @Override // com.fimi.soul.module.droneTrack.AbstractC3217f
    /* renamed from: a */
    public void mo9082a(String str) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.back_btn /* 2131493144 */:
                finish();
                return;
            case C2300R.C2302id.play_back_start /* 2131493368 */:
            case C2300R.C2302id.paly_btn /* 2131493375 */:
                if (!this.f12215P) {
                    C2284z.m12694a(this, "正在加载数据", 3000);
                    return;
                } else if (this.f12232af != EnumC3199a.Payback) {
                    this.f12234ah.removeMessages(3);
                    m9198i(C2300R.mipmap.btn_playback_play);
                    this.f12232af = EnumC3199a.Payback;
                    return;
                } else {
                    if (this.f12210K != this.f12252q.getMax()) {
                        m9198i(C2300R.C2301drawable.btn_playback_pause);
                        this.f12232af = EnumC3199a.Stop;
                    } else {
                        this.f12210K = 0;
                        m9198i(C2300R.mipmap.btn_playback_play);
                    }
                    this.f12234ah.sendEmptyMessage(3);
                    return;
                }
            case C2300R.C2302id.show_more_status /* 2131493371 */:
                if (this.f12202B.isShown()) {
                    m9238a(this.f12244i, C2300R.C2301drawable.btn_playback_more_normal);
                    this.f12202B.setVisibility(8);
                    this.f12202B.setAnimation(AnimationUtils.loadAnimation(this, C2300R.anim.more_drone_status_detial));
                    return;
                }
                m9238a(this.f12244i, C2300R.C2301drawable.btn_playback_more_checked);
                this.f12202B.setVisibility(0);
                this.f12202B.setAnimation(AnimationUtils.loadAnimation(this, 17432578));
                return;
            case C2300R.C2302id.show_more_remote_status /* 2131493372 */:
                if (this.f12206F.isShown()) {
                    m9238a(this.f12245j, C2300R.C2301drawable.btn_playback_rc_normal);
                    this.f12206F.setVisibility(8);
                    this.f12206F.setAnimation(AnimationUtils.loadAnimation(this, 17432579));
                    return;
                }
                m9238a(this.f12245j, C2300R.C2301drawable.btn_playback_rc_checked);
                this.f12206F.setVisibility(0);
                this.f12206F.setAnimation(AnimationUtils.loadAnimation(this, C2300R.anim.more_remote_detial));
                return;
            case C2300R.C2302id.show_more_gps_status /* 2131493373 */:
                m9204f(this.f12204D.m9256a());
                return;
            case C2300R.C2302id.show_more_battery_status /* 2131493374 */:
                if (this.f12203C.isShown()) {
                    m9238a(this.f12248m, C2300R.C2301drawable.btn_playback_battery_info_normal);
                    this.f12203C.setVisibility(8);
                    this.f12203C.setAnimation(AnimationUtils.loadAnimation(this, C2300R.anim.more_drone_status_detial));
                    return;
                }
                m9238a(this.f12248m, C2300R.C2301drawable.btn_playback_battery_info_checked);
                this.f12203C.setVisibility(0);
                this.f12203C.setAnimation(AnimationUtils.loadAnimation(this, 17432578));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12231ae = false;
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.drone_paly_back_main);
        m9207e();
        this.f12205E = getSupportFragmentManager();
        this.f12204D = (PalyBackMapFragment) this.f12205E.findFragmentById(C2300R.C2302id.mapFragment);
        if (this.f12204D == null) {
            this.f12204D = new PalyBackMapFragment();
            this.f12205E.beginTransaction().add(C2300R.C2302id.mapFragment, this.f12204D).commit();
        }
        this.f12207G = C3204c.m9133a();
        if (getIntent() != null) {
            this.f12207G.m9129a(getIntent().getStringExtra("path"), this);
        }
        this.f12212M = new C3202a();
        if (this.f12213N == null) {
            this.f12213N = new Timer();
            this.f12213N.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneTrack.PlayBackDroneTrackActivity.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    PlayBackDroneTrackActivity.this.f12234ah.sendEmptyMessage(1);
                }
            }, 0L, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f12231ae = true;
        if (this.f12212M != null) {
            this.f12212M = null;
        }
        if (this.f12234ah.hasMessages(3)) {
            this.f12234ah.removeMessages(3);
        }
        this.f12215P = false;
        if (this.f12213N != null) {
            this.f12213N.cancel();
        }
        C3214c.m9087b();
        this.f12207G.m9127b();
        super.onDestroy();
        setContentView(C2300R.layout.empty_layout);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.f12234ah.hasMessages(3)) {
            this.f12234ah.removeMessages(3);
        }
        this.f12210K = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f12215P || this.f12226a.isShown()) {
            return;
        }
        this.f12226a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f12232af == EnumC3199a.Stop) {
            this.f12234ah.removeMessages(3);
            m9198i(C2300R.mipmap.btn_playback_play);
            this.f12232af = EnumC3199a.Payback;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.f12232af == EnumC3199a.Stop && !this.f12234ah.hasMessages(3)) {
            this.f12234ah.sendEmptyMessageDelayed(3, this.f12209J);
        }
        this.f12261z.setText(m9217b((seekBar.getProgress() * 1000) + ""));
        m9206e(seekBar.getProgress());
    }
}
