package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.C2292c;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.setting.C3489d;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3796e;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class ShowDroneControlFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: F */
    private static final int f11638F = 17;

    /* renamed from: G */
    private static final int f11639G = 18;

    /* renamed from: A */
    private ImageView f11640A;

    /* renamed from: B */
    private ImageView f11641B;

    /* renamed from: C */
    private DialogC3800f.C3801a f11642C;

    /* renamed from: E */
    private int f11644E;

    /* renamed from: I */
    private int f11646I;

    /* renamed from: K */
    private Dialog f11648K;

    /* renamed from: L */
    private FlightActivity.AbstractC3281a f11649L;

    /* renamed from: a */
    private PercentRelativeLayout f11650a;

    /* renamed from: b */
    private PercentRelativeLayout f11651b;

    /* renamed from: c */
    private PercentRelativeLayout f11652c;

    /* renamed from: d */
    private PercentRelativeLayout f11653d;

    /* renamed from: e */
    private PercentRelativeLayout f11654e;

    /* renamed from: f */
    private PercentRelativeLayout f11655f;

    /* renamed from: g */
    private PercentRelativeLayout f11656g;

    /* renamed from: h */
    private ImageButton f11657h;

    /* renamed from: i */
    private Context f11658i;

    /* renamed from: j */
    private DroidPlannerApp f11659j;

    /* renamed from: k */
    private C2657a f11660k;

    /* renamed from: l */
    private C3057d f11661l;

    /* renamed from: m */
    private TextView f11662m;

    /* renamed from: n */
    private TextView f11663n;

    /* renamed from: o */
    private TextView f11664o;

    /* renamed from: p */
    private TextView f11665p;

    /* renamed from: q */
    private TextView f11666q;

    /* renamed from: r */
    private TextView f11667r;

    /* renamed from: s */
    private TextView f11668s;

    /* renamed from: t */
    private int f11669t;

    /* renamed from: v */
    private ImageView f11671v;

    /* renamed from: w */
    private ImageView f11672w;

    /* renamed from: x */
    private ImageView f11673x;

    /* renamed from: y */
    private ImageView f11674y;

    /* renamed from: z */
    private ImageView f11675z;

    /* renamed from: u */
    private int f11670u = 20;

    /* renamed from: D */
    private EnumC3116a f11643D = EnumC3116a.IDLE;

    /* renamed from: H */
    private int f11645H = 0;

    /* renamed from: J */
    private Handler f11647J = new Handler() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 17) {
                C2292c.m12665a().mo12687a();
            } else if (message.what != 18) {
            } else {
                if (ShowDroneControlFragment.this.f11645H >= 2) {
                    C2292c.m12665a().mo12676c();
                    return;
                }
                ShowDroneControlFragment.m9644b(ShowDroneControlFragment.this);
                C3489d.m8302a(ShowDroneControlFragment.this.f11660k).m8303a(ShowDroneControlFragment.this.f11644E);
                ShowDroneControlFragment.this.f11647J.sendEmptyMessageDelayed(18, 2000L);
            }
        }
    };

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneControlFragment$a */
    /* loaded from: classes.dex */
    public enum EnumC3116a {
        IDLE,
        LEFT,
        RIGHT
    }

    /* renamed from: a */
    private void m9650a(int i, int i2) {
        if (!this.f11660k.mo11217ab().mo10898a() || !this.f11660k.mo11216ac()) {
            return;
        }
        if (!this.f11660k.m11320al()) {
            if (this.f11660k.m11312at().m10700g().isEnforcementAtti()) {
                m9651a(1.0f, false, this.f11650a);
                m9651a(0.3f, false, this.f11674y, this.f11662m);
            } else {
                m9651a(1.0f, true, this.f11650a, this.f11674y, this.f11662m);
            }
            m9651a(0.3f, false, this.f11675z, this.f11640A, this.f11664o, this.f11663n, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11671v, this.f11665p, this.f11668s, this.f11641B);
            m9651a(1.0f, false, this.f11651b, this.f11652c, this.f11654e, this.f11655f, this.f11653d, this.f11656g);
            return;
        }
        m9651a(0.3f, false, this.f11674y, this.f11662m);
        m9651a(1.0f, false, this.f11650a);
        if (this.f11660k.m11312at().m10700g().isLightStream() || this.f11660k.m11312at().m10700g().isEnforcementAtti()) {
            if (this.f11660k.m11312at().m10700g().isEnforcementAtti()) {
                m9651a(0.3f, false, this.f11675z, this.f11663n);
                m9651a(1.0f, false, this.f11651b);
            } else {
                m9651a(1.0f, true, this.f11651b, this.f11675z, this.f11663n);
            }
            m9651a(0.3f, false, this.f11672w, this.f11666q, this.f11673x, this.f11667r, this.f11671v, this.f11665p, this.f11640A, this.f11664o, this.f11668s, this.f11641B);
            m9651a(1.0f, false, this.f11655f, this.f11653d, this.f11654e, this.f11655f, this.f11652c, this.f11656g);
        } else if (!this.f11660k.m11312at().m10700g().judgeNoAction() || this.f11660k.m11310av().m10574c()) {
            m9651a(1.0f, true, this.f11640A, this.f11664o, this.f11652c, this.f11651b, this.f11675z, this.f11663n);
            m9651a(0.3f, false, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11665p, this.f11671v, this.f11668s, this.f11641B);
            m9651a(1.0f, false, this.f11653d, this.f11654e, this.f11655f, this.f11656g);
        } else if (this.f11660k.m11318an().m10121T() || this.f11660k.m11312at().m10704c() == 3 || this.f11660k.m11312at().m10707a() == 5) {
            m9645b();
        } else if (this.f11660k.m11312at().m10700g().isGoHome()) {
            m9640d();
        } else if (this.f11660k.m11312at().m10700g().isLanding()) {
            m9642c();
        } else {
            m9638e();
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m9644b(ShowDroneControlFragment showDroneControlFragment) {
        int i = showDroneControlFragment.f11645H;
        showDroneControlFragment.f11645H = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m9652a() {
        m9651a(1.0f, false, this.f11650a, this.f11651b, this.f11652c, this.f11653d, this.f11654e, this.f11655f, this.f11656g);
        m9651a(0.3f, false, this.f11675z, this.f11674y, this.f11640A, this.f11662m, this.f11664o, this.f11663n, this.f11668s);
        m9651a(0.3f, false, this.f11671v, this.f11665p, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11641B);
    }

    /* renamed from: a */
    public void m9651a(float f, boolean z, View... viewArr) {
        for (int i = 0; i < viewArr.length; i++) {
            View view = viewArr[i];
            if (view.getAlpha() != f) {
                view.setAlpha(f);
            }
            if (view.isEnabled() != z) {
                viewArr[i].setEnabled(z);
            }
        }
    }

    /* renamed from: a */
    public void m9649a(EnumC3116a enumC3116a) {
        if (this.f11643D == enumC3116a) {
            return;
        }
        this.f11643D = enumC3116a;
    }

    /* renamed from: a */
    public void m9646a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11649L = abstractC3281a;
    }

    /* renamed from: b */
    public void m9645b() {
        m9651a(1.0f, true, this.f11640A, this.f11664o, this.f11652c, this.f11651b, this.f11675z, this.f11663n);
        m9651a(0.3f, false, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11665p, this.f11671v, this.f11668s, this.f11641B);
        m9651a(1.0f, false, this.f11653d, this.f11654e, this.f11655f, this.f11656g);
    }

    /* renamed from: c */
    public void m9642c() {
        m9651a(1.0f, true, this.f11640A, this.f11664o, this.f11652c);
        m9651a(1.0f, false, this.f11651b, this.f11653d, this.f11654e, this.f11655f, this.f11656g);
        m9651a(0.3f, false, this.f11675z, this.f11663n, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11665p, this.f11671v, this.f11668s, this.f11641B);
    }

    /* renamed from: d */
    public void m9640d() {
        m9651a(1.0f, true, this.f11651b, this.f11675z, this.f11663n);
        m9651a(1.0f, false, this.f11652c, this.f11653d, this.f11654e, this.f11655f, this.f11656g);
        m9651a(0.3f, false, this.f11640A, this.f11664o, this.f11672w, this.f11673x, this.f11666q, this.f11667r, this.f11665p, this.f11671v, this.f11668s, this.f11641B);
    }

    /* renamed from: e */
    public void m9638e() {
        m9651a(1.0f, true, this.f11640A, this.f11664o, this.f11652c, this.f11651b, this.f11675z, this.f11663n);
        if (this.f11643D == EnumC3116a.LEFT) {
            m9651a(1.0f, true, this.f11653d, this.f11671v, this.f11665p, this.f11672w, this.f11654e, this.f11666q, this.f11667r, this.f11673x, this.f11655f, this.f11656g, this.f11668s, this.f11641B);
        } else if (this.f11643D != EnumC3116a.RIGHT) {
        } else {
            m9640d();
        }
    }

    /* renamed from: f */
    public void m9636f() {
        int m7921b = C3579a.m7971a().m7970a(0).m7921b();
        if (m7921b <= 0 || m7921b >= 1894 || C2367d.m12459a().m12438k()) {
            return;
        }
        if (this.f11648K == null) {
            DialogC3796e.C3797a c3797a = new DialogC3796e.C3797a(getActivity());
            c3797a.m7045a(getString(C2300R.C2303string.fc_version_compare_tip));
            c3797a.m7043a(false);
            c3797a.m7044a(getString(C2300R.C2303string.finish), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.f11648K = c3797a.m7049a();
            this.f11648K.setCanceledOnTouchOutside(false);
        }
        this.f11648K.show();
    }

    /* renamed from: g */
    public boolean m9634g() {
        if (this.f11648K == null) {
            return false;
        }
        return this.f11648K.isShowing();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11658i = activity.getApplicationContext();
        this.f11659j = (DroidPlannerApp) activity.getApplication();
        this.f11660k = this.f11659j.f7895a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x046f -> B:109:0x0010). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0488 -> B:109:0x0010). Please submit an issue!!! */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2913h c2913h;
        switch (view.getId()) {
            case C2300R.C2302id.closebutton /* 2131493401 */:
                this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROLClose);
                return;
            case C2300R.C2302id.takeoffrl /* 2131493402 */:
                C2477h.m12020a(getActivity().getApplicationContext()).m12021a(0);
                if (!this.f11660k.m11320al()) {
                    if (this.f11670u == 2) {
                        this.f11642C.m7031a(getString(C2300R.C2303string.takeoffpromptlightstream));
                    } else if (this.f11670u != 1) {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.wrongtakeoff, 2000);
                        return;
                    } else {
                        this.f11642C.m7031a(getString(C2300R.C2303string.takeoffpromptgps));
                    }
                    this.f11642C.m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ShowDroneControlFragment.this.f11661l.m9835a();
                            dialogInterface.dismiss();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).m7035a().show();
                } else {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.wrongtakeoff, 2000);
                }
                this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                return;
            case C2300R.C2302id.landingpl /* 2131493405 */:
                C2477h.m12020a(getActivity().getApplicationContext()).m12021a(0);
                if (this.f11660k.m11320al()) {
                    this.f11642C.m7031a(getString(C2300R.C2303string.landprompt));
                    this.f11642C.m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.9
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ShowDroneControlFragment.this.f11661l.m9821b();
                            dialogInterface.dismiss();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.8
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).m7035a().show();
                } else {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.wrongLanding, 2000);
                }
                this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                return;
            case C2300R.C2302id.gohomepl /* 2131493408 */:
                C2477h.m12020a(getActivity().getApplicationContext()).m12021a(0);
                boolean isLightStream = this.f11660k.m11312at().m10700g().isLightStream();
                double m10498g = (this.f11660k.mo11202w().m10498g() - 677216.0d) / 10.0d;
                double m10497h = this.f11660k.mo11202w().m10497h();
                if (!this.f11660k.m11320al()) {
                    m10497h = 0.0d;
                }
                String m12756h = C2238c.m13123e().m12756h();
                if (this.f11660k.m11310av().m10574c()) {
                    if (m10498g < 30.0d) {
                        this.f11644E = 30;
                    } else {
                        this.f11644E = (int) Math.round(m10498g);
                    }
                } else if (m10498g < Integer.valueOf(m12756h).intValue()) {
                    this.f11644E = Integer.valueOf(m12756h).intValue();
                } else {
                    this.f11644E = (int) Math.round(m10498g);
                }
                final int i = this.f11644E;
                if (!this.f11660k.m11320al() || isLightStream) {
                    if (isLightStream) {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.lightstreamgohome, 3000);
                    } else {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.wrongbackhome, 2000);
                    }
                } else if (m10497h >= 10.0d) {
                    DialogC3800f.C3809c c3809c = new DialogC3800f.C3809c(getActivity());
                    c3809c.m6983c(120).m6987b(getActivity().getResources().getColor(C2300R.color.dialog_ensure_hot)).m6979d(30).m6989a(getActivity().getString(C2300R.C2303string.horizonal_screen_return_height_msg)).m6994a(this.f11644E).m6993a(new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.12
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            if (i == ShowDroneControlFragment.this.f11644E) {
                                ShowDroneControlFragment.this.f11661l.m9818c();
                                return;
                            }
                            ShowDroneControlFragment.this.f11645H = 0;
                            ShowDroneControlFragment.this.f11647J.sendEmptyMessageDelayed(17, 1000L);
                            ShowDroneControlFragment.this.f11647J.sendEmptyMessageDelayed(18, 2000L);
                            C3489d.m8302a(ShowDroneControlFragment.this.f11660k).m8303a(ShowDroneControlFragment.this.f11644E);
                        }
                    }).m6986b(new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).m6992a(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.10
                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                            ShowDroneControlFragment.this.f11644E = i2;
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    if (!this.f11660k.m11310av().m10574c()) {
                        c3809c.m6982c(new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.13
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).m6995a().show();
                    } else {
                        c3809c.m6995a().show();
                    }
                } else {
                    this.f11642C.m7031a(getString(C2300R.C2303string.gohomeprompt3));
                    this.f11642C.m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            ShowDroneControlFragment.this.f11661l.m9818c();
                            dialogInterface.dismiss();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneControlFragment.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    }).m7035a().show();
                }
                this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                return;
            case C2300R.C2302id.detoruingpointpl /* 2131493411 */:
                if ((this.f11660k.m11290j() != null && this.f11660k.m11290j().m10721b() == 1) || this.f11660k.m11318an().m10080g()) {
                    C2284z.m12695a(this.f11658i, getString(C2300R.C2303string.show_drone_control_no_zoom_auto_flight));
                    return;
                } else if (!this.f11660k.m11312at().m10700g().isGps()) {
                    C2284z.m12697a(getActivity(), (int) C2300R.C2303string.cant_action_interest);
                    return;
                } else {
                    m9636f();
                    if (m9634g()) {
                        return;
                    }
                    this.f11649L.mo8854d();
                    C2472d.m12036p().m12058a(false);
                    C2477h.m12020a(getActivity().getApplicationContext()).m12021a(3);
                    this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                    return;
                }
            case C2300R.C2302id.takephonemyselfpl /* 2131493414 */:
                if ((this.f11660k.m11290j() != null && this.f11660k.m11290j().m10721b() == 1) || this.f11660k.m11318an().m10080g()) {
                    C2284z.m12695a(this.f11658i, getString(C2300R.C2303string.show_drone_control_no_zoom_auto_flight));
                    return;
                } else if (!this.f11660k.m11312at().m10700g().isGps()) {
                    C2284z.m12697a(getActivity(), (int) C2300R.C2303string.cant_action_tajephoto);
                    this.f11649L.mo8857a();
                    return;
                } else if (this.f11660k.m11318an().m10066u()) {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.discongc, 3000);
                    return;
                } else if (this.f11660k.m11318an().m10067t()) {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.gcunready, 3000);
                    return;
                } else if (!C2367d.m12459a().m12436m()) {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.no_connect_camera, 3000);
                    return;
                } else {
                    try {
                        c2913h = (C2913h) this.f11660k.f9269c;
                    } catch (Exception e) {
                    }
                    if (c2913h.m10286f() == C2913h.EnumC2914a.NoSDCard) {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.tf_remove_error, 3000);
                    } else if (c2913h.m10286f() == C2913h.EnumC2914a.FullSDCard) {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.tf_full_error, 3000);
                    } else if (c2913h.m10286f() == C2913h.EnumC2914a.Error) {
                        C2284z.m12696a(getActivity(), (int) C2300R.C2303string.tf_io_error, 3000);
                    } else {
                        if (c2913h.m10286f() == C2913h.EnumC2914a.LOW_SPEED_CARD) {
                            C2284z.m12696a(getActivity(), (int) C2300R.C2303string.tf_low_speed_error, 3000);
                        }
                        m9636f();
                        if (!m9634g()) {
                            C2477h.m12020a(getActivity().getApplicationContext()).m12021a(4);
                            this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                            this.f11649L.mo8857a();
                        }
                    }
                    return;
                }
            case C2300R.C2302id.setwaypointpl /* 2131493417 */:
                if ((this.f11660k.m11290j() != null && this.f11660k.m11290j().m10721b() == 1) || this.f11660k.m11318an().m10080g()) {
                    C2284z.m12695a(this.f11658i, getString(C2300R.C2303string.show_drone_control_no_zoom_auto_flight));
                    return;
                } else if (!this.f11660k.m11312at().m10700g().isGps()) {
                    C2284z.m12697a(getActivity(), (int) C2300R.C2303string.cant_action_waypoint);
                    return;
                } else {
                    m9636f();
                    if (m9634g()) {
                        return;
                    }
                    this.f11649L.mo8854d();
                    C2472d.m12036p().m12058a(false);
                    C2477h.m12020a(getActivity().getApplicationContext()).m12021a(1);
                    this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                    return;
                }
            case C2300R.C2302id.setdestination /* 2131493420 */:
                if ((this.f11660k.m11290j() != null && this.f11660k.m11290j().m10721b() == 1) || this.f11660k.m11318an().m10080g()) {
                    C2284z.m12695a(this.f11658i, getString(C2300R.C2303string.show_drone_control_no_zoom_auto_flight));
                    return;
                } else if (!this.f11660k.m11312at().m10700g().isGps()) {
                    C2284z.m12697a(getActivity(), (int) C2300R.C2303string.cant_action_flyto);
                    return;
                } else {
                    m9636f();
                    if (m9634g()) {
                        return;
                    }
                    this.f11649L.mo8854d();
                    C2472d.m12036p().m12058a(false);
                    C2477h.m12020a(getActivity().getApplicationContext()).m12021a(2);
                    this.f11660k.mo11220a(C2678d.EnumC2679a.CLOSEDRAWCONTROL);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11642C = new DialogC3800f.C3801a(getActivity());
    }

    @Override // android.support.p001v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.dronecontrol, (ViewGroup) null);
        this.f11656g = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.takephonemyselfpl);
        this.f11668s = (TextView) inflate.findViewById(C2300R.C2302id.takephonetext);
        this.f11641B = (ImageView) inflate.findViewById(C2300R.C2302id.takephoneicon);
        this.f11657h = (ImageButton) inflate.findViewById(C2300R.C2302id.closebutton);
        this.f11650a = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.takeoffrl);
        this.f11651b = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.landingpl);
        this.f11652c = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.gohomepl);
        this.f11653d = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.detoruingpointpl);
        this.f11654e = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.setwaypointpl);
        this.f11655f = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.setdestination);
        for (View view : new View[]{this.f11656g, this.f11650a, this.f11651b, this.f11652c, this.f11653d, this.f11654e, this.f11655f, this.f11657h}) {
            view.setOnClickListener(this);
        }
        this.f11661l = C3057d.m9823a(this.f11660k);
        this.f11662m = (TextView) inflate.findViewById(C2300R.C2302id.takeofftext);
        this.f11664o = (TextView) inflate.findViewById(C2300R.C2302id.gohometext);
        this.f11663n = (TextView) inflate.findViewById(C2300R.C2302id.landingtext);
        this.f11665p = (TextView) inflate.findViewById(C2300R.C2302id.controlfourtext);
        this.f11666q = (TextView) inflate.findViewById(C2300R.C2302id.waypointtext);
        this.f11667r = (TextView) inflate.findViewById(C2300R.C2302id.targetplacetext);
        C3658ar.m7612a(getActivity().getAssets(), this.f11662m, this.f11664o, this.f11665p, this.f11666q, this.f11667r, this.f11668s);
        this.f11674y = (ImageView) inflate.findViewById(C2300R.C2302id.takeofficon);
        this.f11675z = (ImageView) inflate.findViewById(C2300R.C2302id.landingicon);
        this.f11640A = (ImageView) inflate.findViewById(C2300R.C2302id.gohomeicon);
        this.f11671v = (ImageView) inflate.findViewById(C2300R.C2302id.detoruingpointicon);
        this.f11672w = (ImageView) inflate.findViewById(C2300R.C2302id.setwaypointicon);
        this.f11673x = (ImageView) inflate.findViewById(C2300R.C2302id.setdestinationicon);
        m9652a();
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11660k.mo11214b(this);
        if (this.f11648K != null) {
            this.f11648K = null;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11660k.mo11214b(this);
        if (this.f11642C != null) {
            this.f11642C = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case HEARDATA:
                this.f11669t = c2657a.m11312at().m10702e();
                this.f11670u = c2657a.m11312at().m10703d();
                m9650a(this.f11669t, this.f11670u);
                return;
            case CLEANALLOBJ:
                m9652a();
                return;
            case Remotecontrol:
                if (c2657a.mo11216ac()) {
                    return;
                }
                m9652a();
                return;
            case HOME_RIGHT:
                m9649a(EnumC3116a.RIGHT);
                return;
            case HOME_LEFT:
                m9649a(EnumC3116a.LEFT);
                return;
            case RETURN_HEIGHT:
                if (!isResumed()) {
                    return;
                }
                if (c2657a.mo11207r().m10208b() != C3489d.f13751d) {
                    if (c2657a.mo11207r().m10208b() != C3489d.f13752e || c2657a.mo11207r().m10204d() != C3489d.f13753f) {
                        return;
                    }
                    C2238c.m13123e().m12777b(((int) c2657a.mo11207r().m10206c()) + "");
                    return;
                } else if (c2657a.mo11207r().m10204d() == C3489d.f13753f) {
                    C2238c.m13123e().m12777b(((int) c2657a.mo11207r().m10206c()) + "");
                    this.f11661l.m9818c();
                    C2292c.m12665a().mo12676c();
                    this.f11647J.removeMessages(17);
                    this.f11647J.removeMessages(18);
                    return;
                } else if (this.f11645H >= 2) {
                    this.f11661l.m9818c();
                    C2292c.m12665a().mo12676c();
                    return;
                } else {
                    C3489d.m8302a(c2657a).m8303a(this.f11644E);
                    this.f11647J.sendEmptyMessageDelayed(18, 2000L);
                    return;
                }
            case NEWFRONEMODEL:
                this.f11646I = c2657a.m11312at().m10699h();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11660k.mo11219a(this);
    }
}
