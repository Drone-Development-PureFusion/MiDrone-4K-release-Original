package com.fimi.soul.module.droneFragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.BaseFragment;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2386d;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.biz.p184m.C2545a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2924j;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.CameraMountState;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.entity.DroneFilghtState;
import com.fimi.soul.entity.VideoStatusCode;
import com.fimi.soul.media.player.FermiPlayerUtils;
import com.fimi.soul.module.droneFragment.SectorProgressBar;
import com.fimi.soul.module.droneFragment.View$OnTouchListenerC3156b;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.flyplannermedia.DroneMediaTabActivity;
import com.fimi.soul.module.p206a.C3049f;
import com.fimi.soul.module.p206a.View$OnClickListenerC3047e;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3676e;
import com.fimi.soul.utils.C3680i;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.soul.view.UpDownSliding;
import com.p219mi.live.openlivesdk.C4098c;
import com.p219mi.live.openlivesdk.p220a.AbstractC4094a;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class ShowDroneUiFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener, AbstractC2386d<X11RespCmd>, AbstractC2388f<X11RespCmd>, AbstractC2390c.AbstractC2403d, C2678d.AbstractC2680b {

    /* renamed from: I */
    private static final int f11827I = 1;

    /* renamed from: J */
    private static final int f11828J = 2;

    /* renamed from: K */
    private static final int f11829K = 3;

    /* renamed from: L */
    private static final int f11830L = 4;

    /* renamed from: M */
    private static final int f11831M = 5;

    /* renamed from: N */
    private static final int f11832N = 6;

    /* renamed from: O */
    private static final int f11833O = 7;

    /* renamed from: P */
    private static final int f11834P = 8;

    /* renamed from: R */
    private static final int f11835R = 9;

    /* renamed from: S */
    private static final int f11836S = 10;

    /* renamed from: T */
    private static final int f11837T = 11;

    /* renamed from: U */
    private static final int f11838U = 12;

    /* renamed from: V */
    private static final int f11839V = 13;

    /* renamed from: W */
    private static final int f11840W = 15;

    /* renamed from: aw */
    private static final int f11841aw = 10;

    /* renamed from: B */
    private UpDownSliding f11843B;

    /* renamed from: C */
    private C4098c f11844C;

    /* renamed from: E */
    private UpDownSliding.EnumC3756b f11846E;

    /* renamed from: F */
    private View$OnTouchListenerC3156b f11847F;

    /* renamed from: G */
    private ShowDroneStatusLineFragment f11848G;

    /* renamed from: H */
    private ShowDroneStatusFragment f11849H;

    /* renamed from: X */
    private C2924j.EnumC2925a f11851X;

    /* renamed from: Y */
    private long f11852Y;

    /* renamed from: aC */
    private C2545a f11857aC;

    /* renamed from: aE */
    private DroneFilghtState f11859aE;

    /* renamed from: aH */
    private AbstractC3146d f11862aH;

    /* renamed from: aI */
    private C2477h f11863aI;

    /* renamed from: aJ */
    private int f11864aJ;

    /* renamed from: aK */
    private int f11865aK;

    /* renamed from: aM */
    private C2205c f11867aM;

    /* renamed from: aN */
    private String f11868aN;

    /* renamed from: ac */
    private Timer f11874ac;

    /* renamed from: ad */
    private Timer f11875ad;

    /* renamed from: ae */
    private Button f11876ae;

    /* renamed from: af */
    private Button f11877af;

    /* renamed from: ag */
    private PercentRelativeLayout f11878ag;

    /* renamed from: ak */
    private DialogC3800f.C3801a f11882ak;

    /* renamed from: al */
    private DialogC3800f.C3815d f11883al;

    /* renamed from: am */
    private ImageButton f11884am;

    /* renamed from: an */
    private View$OnClickListenerC3047e f11885an;

    /* renamed from: ao */
    private boolean f11886ao;

    /* renamed from: ap */
    private boolean f11887ap;

    /* renamed from: aq */
    private int f11888aq;

    /* renamed from: ar */
    private float f11889ar;

    /* renamed from: as */
    private float f11890as;

    /* renamed from: at */
    private float f11891at;

    /* renamed from: au */
    private float f11892au;

    /* renamed from: av */
    private int f11893av;

    /* renamed from: ax */
    private double f11894ax;

    /* renamed from: ay */
    private double f11895ay;

    /* renamed from: az */
    private int f11896az;

    /* renamed from: d */
    private SectorProgressBar f11899d;

    /* renamed from: e */
    private SectorProgressBar f11900e;

    /* renamed from: f */
    private SectorProgressBar f11901f;

    /* renamed from: g */
    private SectorProgressBar f11902g;

    /* renamed from: h */
    private ImageButton f11903h;

    /* renamed from: i */
    private ImageButton f11904i;

    /* renamed from: j */
    private ImageButton f11905j;

    /* renamed from: k */
    private ImageButton f11906k;

    /* renamed from: l */
    private ImageButton f11907l;

    /* renamed from: m */
    private TextView f11908m;

    /* renamed from: n */
    private TextView f11909n;

    /* renamed from: o */
    private TextView f11910o;

    /* renamed from: p */
    private TextView f11911p;

    /* renamed from: q */
    private RelativeLayout f11912q;

    /* renamed from: r */
    private RelativeLayout f11913r;

    /* renamed from: s */
    private View f11914s;

    /* renamed from: t */
    private Context f11915t;

    /* renamed from: u */
    private C2657a f11916u;

    /* renamed from: v */
    private DroidPlannerApp f11917v;

    /* renamed from: w */
    private PercentRelativeLayout f11918w;

    /* renamed from: x */
    private ImageView f11919x;

    /* renamed from: y */
    private ImageView f11920y;

    /* renamed from: z */
    private EnumC3145c f11921z = EnumC3145c.MAP;

    /* renamed from: D */
    private boolean f11845D = false;

    /* renamed from: Q */
    private boolean f11850Q = false;

    /* renamed from: Z */
    private boolean f11853Z = false;

    /* renamed from: aa */
    private boolean f11872aa = false;

    /* renamed from: ab */
    private boolean f11873ab = false;

    /* renamed from: ah */
    private boolean f11879ah = false;

    /* renamed from: ai */
    private boolean f11880ai = false;

    /* renamed from: aj */
    private boolean f11881aj = false;

    /* renamed from: aA */
    private boolean f11855aA = false;

    /* renamed from: aB */
    private EnumC3143a f11856aB = EnumC3143a.FIRSTSTATUS;

    /* renamed from: aD */
    private boolean f11858aD = true;

    /* renamed from: aF */
    private boolean f11860aF = false;

    /* renamed from: aG */
    private EnumC3147e f11861aG = EnumC3147e.Record;

    /* renamed from: aL */
    private EnumC3144b f11866aL = EnumC3144b.FIRSTSTATE;

    /* renamed from: a */
    String f11854a = null;

    /* renamed from: b */
    Handler f11897b = new Handler() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                long currentTimeMillis = System.currentTimeMillis() - ShowDroneUiFragment.this.f11852Y;
                if (ShowDroneUiFragment.this.f11848G != null && ShowDroneUiFragment.this.getActivity() != null) {
                    ShowDroneUiFragment.this.f11848G.m9593a(true);
                    ShowDroneUiFragment.this.f11868aN = FermiPlayerUtils.getTimelineString(currentTimeMillis);
                    ShowDroneUiFragment.this.f11848G.m9594a(ShowDroneUiFragment.this.f11868aN);
                }
            } else if (message.what != 2) {
                if (message.what == 7) {
                    if (!ShowDroneUiFragment.this.f11873ab && ShowDroneUiFragment.this.a().mo12680b().isShowing()) {
                        ShowDroneUiFragment.this.a().mo12676c();
                        ShowDroneUiFragment.this.m9530b(true);
                    }
                    ShowDroneUiFragment.this.f11897b.sendEmptyMessageDelayed(2, 2000L);
                } else if (message.what == 3) {
                    ShowDroneUiFragment.this.m9537a(true);
                    ShowDroneUiFragment.this.f11897b.sendEmptyMessageDelayed(2, 2000L);
                } else if (message.what == 8) {
                    ShowDroneUiFragment.this.f11850Q = true;
                    ShowDroneUiFragment.this.f11900e.m9656a(1000, 0);
                    ShowDroneUiFragment.this.f11902g.m9656a(1000, 0);
                    ShowDroneUiFragment.this.f11901f.m9656a(1000, 0);
                    ShowDroneUiFragment.this.f11899d.m9656a(1000, 0);
                    ShowDroneUiFragment.this.f11897b.sendEmptyMessageDelayed(9, 3000L);
                } else if (message.what == 9) {
                    ShowDroneUiFragment.this.f11900e.m9658a();
                    ShowDroneUiFragment.this.f11902g.m9658a();
                    ShowDroneUiFragment.this.f11901f.m9658a();
                    ShowDroneUiFragment.this.f11899d.m9658a();
                } else if (message.what == 10) {
                    ShowDroneUiFragment.this.f11879ah = false;
                } else if (message.what == 11) {
                    ShowDroneUiFragment.this.f11880ai = false;
                } else if (message.what == 12) {
                    ShowDroneUiFragment.this.f11853Z = false;
                }
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: c */
    public final int f11898c = 0;

    /* renamed from: aO */
    private Handler f11869aO = new Handler() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.arg1) {
                case 0:
                    C2284z.m12697a(ShowDroneUiFragment.this.getActivity(), (int) C2300R.C2303string.network_disable_live);
                    return;
                case 1:
                    ShowDroneUiFragment.this.f11842A.m12233u().m12287f();
                    ShowDroneUiFragment.this.f11844C.m6208a(ShowDroneUiFragment.this.getActivity());
                    ShowDroneUiFragment.this.f11847F.m9409n();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: aP */
    private CameraMountState f11870aP = CameraMountState.IDLE;

    /* renamed from: aQ */
    private View$OnClickListenerC3047e.AbstractC3048a f11871aQ = new View$OnClickListenerC3047e.AbstractC3048a() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.5
        @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3047e.AbstractC3048a
        /* renamed from: a */
        public void mo9471a() {
            ShowDroneUiFragment.this.m9475w();
        }

        @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3047e.AbstractC3048a
        /* renamed from: a */
        public void mo9470a(int i, String str) {
            if (i != 0 || !ShowDroneUiFragment.this.f11858aD) {
                String m9853a = new C3049f().m9853a(i);
                if (m9853a.equals("")) {
                    return;
                }
                if (ShowDroneUiFragment.this.f11842A.e()) {
                    ShowDroneUiFragment.this.f11842A.m12233u().m12298a(m9853a, str);
                } else {
                    C2284z.m12694a(ShowDroneUiFragment.this.f11915t, ShowDroneUiFragment.this.f11915t.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                }
            }
        }
    };

    /* renamed from: A */
    private C2423d f11842A = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneUiFragment$a */
    /* loaded from: classes.dex */
    private enum EnumC3143a {
        FIRSTSTATUS,
        SECONDSTATUS
    }

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneUiFragment$b */
    /* loaded from: classes.dex */
    private enum EnumC3144b {
        FIRSTSTATE,
        SECONDSTATE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneUiFragment$c */
    /* loaded from: classes.dex */
    public enum EnumC3145c {
        MAP,
        CAMER
    }

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneUiFragment$d */
    /* loaded from: classes.dex */
    public interface AbstractC3146d {
        /* renamed from: a */
        void mo8895a();
    }

    /* renamed from: com.fimi.soul.module.droneFragment.ShowDroneUiFragment$e */
    /* loaded from: classes.dex */
    public enum EnumC3147e {
        Record,
        ContinueCapture,
        TakePhoto,
        Live
    }

    public ShowDroneUiFragment() {
        this.f11842A.c(new AbstractC2221d() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.1
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
                Log.d("Good", str);
            }
        });
        this.f11842A.a((AbstractC2386d) this);
    }

    /* renamed from: E */
    private void m9564E() {
        boolean z = false;
        if (C2277v.m12784a(this.f11915t).m12742s() == DeviceType.DEVICE_4K) {
            z = true;
        }
        if (!z || m9563F() < 2016) {
            short m10533c = this.f11916u.mo11221Z().m10533c();
            if (this.f11865aK - m10533c < 0) {
                this.f11864aJ = ((m10533c - 255) * 90) / 255;
            } else {
                this.f11864aJ = ((m10533c * 90) / 255) - 90;
            }
            this.f11865aK = m10533c;
        } else {
            this.f11864aJ = this.f11916u.mo11221Z().m10520j();
        }
        this.f11908m.setText(String.valueOf(this.f11864aJ) + this.f11915t.getString(C2300R.C2303string.degree_unit));
    }

    /* renamed from: F */
    private int m9563F() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7955c() <= 0) {
            return 0;
        }
        return c3580b.m7955c();
    }

    /* renamed from: G */
    private void m9562G() {
        short m10333g = this.f11916u.mo11200y().m10333g();
        if (m10333g < 0) {
            m10333g = 0;
        }
        this.f11896az = (int) ((m10333g / this.f11894ax) * 100.0d);
        if (this.f11896az < 0) {
            return;
        }
        if (this.f11896az > 100) {
            this.f11894ax = 0.0d;
        } else {
            this.f11909n.setText(String.valueOf(this.f11896az) + "%");
        }
    }

    /* renamed from: H */
    private void m9561H() {
        this.f11842A.m12230x().mo12253a(C2427e.EnumC2428a.StopRecord);
        if (this.f11921z.equals(EnumC3145c.CAMER)) {
            this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.recording));
        }
        C2284z.m12689b(getActivity(), getString(C2300R.C2303string.record_end), C2284z.f7606b);
        if (!this.f11880ai) {
            this.f11880ai = true;
            C3658ar.m7571k(getActivity());
            this.f11897b.sendEmptyMessageDelayed(11, 2000L);
        }
        this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
        m9553P();
        if (this.f11867aM == null) {
            this.f11867aM = C2205c.m13235a(C2238c.m13131a());
        }
        this.f11867aM.m13224e();
    }

    /* renamed from: I */
    private void m9560I() {
        this.f11842A.m12230x().mo12253a(C2427e.EnumC2428a.TakePhote);
        if (this.f11842A.g() == AbstractC2390c.EnumC2400a.Recoding) {
            C2284z.m12689b(getActivity(), getString(C2300R.C2303string.capture_success), C2284z.f7606b);
        } else {
            if (this.f11921z.equals(EnumC3145c.CAMER)) {
                this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.recording));
            }
            C2284z.m12691b(getActivity(), (int) C2300R.C2303string.take_photo_success, C2284z.f7606b);
            if (this.f11848G != null) {
                this.f11848G.m9594a(this.f11868aN);
            }
            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
            this.f11847F.m9413j();
        }
        if (!this.f11879ah) {
            this.f11879ah = true;
            C3658ar.m7569m(getActivity());
            this.f11897b.sendEmptyMessageDelayed(10, 1500L);
        }
        m9543a(EnumC3147e.TakePhoto);
        this.f11842A.a(true);
    }

    /* renamed from: J */
    private void m9559J() {
        if (this.f11845D) {
            this.f11844C.m6205b(getActivity());
        } else if (!C3658ar.m7601b(getActivity())) {
            C2284z.m12697a(getActivity(), (int) C2300R.C2303string.network_disable_live);
        } else if (!m9477u()) {
            C2284z.m12697a(getActivity(), (int) C2300R.C2303string.network_disable_live);
        } else if (!C3658ar.m7586e()) {
            C2284z.m12697a(getActivity(), (int) C2300R.C2303string.network_disable_live);
        } else {
            this.f11842A.m12233u().m12287f();
            this.f11844C.m6208a(getActivity());
            this.f11847F.m9409n();
        }
    }

    /* renamed from: K */
    private void m9558K() {
        this.f11921z = EnumC3145c.CAMER;
        this.f11843B.setVisibility(0);
        this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.camer_btn_selector));
        if (this.f11857aC != null) {
            this.f11857aC.m11734a(C2300R.C2301drawable.photo);
        }
        this.f11903h.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.map));
        this.f11907l.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.map_1080));
        m9555N();
        this.f11847F.m9430a(this.f11842A.e());
        ((FlightActivity) getActivity()).m8882d();
        this.f11847F.m9421d();
        this.f11847F.m9415h();
        if (this.f11916u.mo11215ae()) {
            this.f11916u.mo11220a(C2678d.EnumC2679a.SHOW_FULL_SCREEN_LEAD);
        }
    }

    /* renamed from: L */
    private void m9557L() {
        if (C2238c.m13123e().m12751j()) {
            if (this.f11882ak == null) {
                this.f11882ak = new DialogC3800f.C3801a(getActivity());
            }
            if (this.f11882ak.m7028b().isShowing()) {
                return;
            }
            this.f11882ak.m7031a(getString(C2300R.C2303string.check_tf_card_must_format)).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.13
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C2238c.m13127b().mo12687a();
                    ShowDroneUiFragment.this.f11842A.m12233u().m12293c();
                }
            }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C2238c.m13123e().m12772c(false);
                }
            }).m7035a().show();
        }
    }

    /* renamed from: M */
    private void m9556M() {
        if (C2238c.m13123e().m12750k()) {
            if (this.f11883al == null) {
                this.f11883al = new DialogC3800f.C3815d(getActivity());
            }
            if (this.f11883al.m6971b().isShowing()) {
                return;
            }
            this.f11883al.m6974a(getString(C2300R.C2303string.tf_card_no_use_please_change)).m6973a(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C2238c.m13123e().m12768d(false);
                }
            }).m6977a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m9555N() {
        boolean z = true;
        if (this.f11842A.g() == AbstractC2390c.EnumC2400a.ContinueCapturing || this.f11842A.g() == AbstractC2390c.EnumC2400a.Recoding || this.f11845D) {
            z = false;
        }
        m9515d(z);
        if (this.f11921z.equals(EnumC3145c.MAP)) {
            return;
        }
        if (this.f11861aG != EnumC3147e.Record) {
            if (this.f11842A.j().isContinueCaptureMode()) {
                m9543a(EnumC3147e.ContinueCapture);
            }
            if (AbstractC2390c.EnumC2400a.Recoding == this.f11842A.g()) {
                m9543a(EnumC3147e.Record);
            }
        }
        m9552Q();
        m9554O();
    }

    /* renamed from: O */
    private void m9554O() {
        if (!isAdded()) {
            return;
        }
        if (this.f11845D) {
            this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.btn_live_stop));
            return;
        }
        switch (this.f11842A.g()) {
            case Recoding:
                this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.recording_on));
                this.f11843B.setEnabled(false);
                return;
            case ContinueCapturing:
                this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.recording_on));
                this.f11843B.setEnabled(false);
                return;
            case IDLE:
                this.f11843B.setEnabled(true);
                return;
            case Normal:
                this.f11843B.setEnabled(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: P */
    private void m9553P() {
        try {
            if (this.f11874ac != null) {
                this.f11874ac.cancel();
                this.f11874ac = null;
            }
            if (this.f11848G == null || getActivity() == null) {
                return;
            }
            this.f11848G.m9593a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: Q */
    private void m9552Q() {
        if (isAdded() && !this.f11921z.equals(EnumC3145c.MAP)) {
            switch (this.f11861aG) {
                case Record:
                    this.f11843B.setState(UpDownSliding.EnumC3756b.Record);
                    this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.video_btn_selector));
                    if (this.f11849H == null) {
                        return;
                    }
                    this.f11849H.m9625a(false);
                    return;
                case ContinueCapture:
                    this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.video_btn_selector));
                    return;
                case TakePhoto:
                    this.f11843B.setState(UpDownSliding.EnumC3756b.TakePhoto);
                    this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.camer_btn_selector));
                    if (this.f11849H == null) {
                        return;
                    }
                    this.f11849H.m9625a(false);
                    return;
                case Live:
                    this.f11843B.setState(UpDownSliding.EnumC3756b.Live);
                    this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.btn_live_play));
                    if (this.f11849H == null) {
                        return;
                    }
                    this.f11849H.m9625a(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m9549a(TextView textView, String str) {
        if (!textView.getText().toString().equals(str)) {
            textView.setText(str);
        }
    }

    /* renamed from: a */
    private void m9547a(C2657a c2657a) {
        double m10498g = (c2657a.mo11202w().m10498g() - 677216.0d) / 10.0d;
        if (!c2657a.m11320al()) {
            m10498g = 0.0d;
        }
        if (m10498g < 0.0d) {
            this.f11899d.setProgress(0.0f);
        } else if (m10498g >= 100.0d) {
            this.f11899d.setProgress(100.0f);
            this.f11899d.m9657a(70.0f);
        } else {
            this.f11899d.setProgress((float) (m10498g * 0.7d));
            this.f11899d.m9657a((float) (m10498g * 0.7d));
        }
    }

    /* renamed from: a */
    private void m9546a(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        double d = 30.0d;
        switch (enumC2679a) {
            case NEWFRONEMODEL:
                if (c2657a.m11312at().m10701f() == 4) {
                    m9549a(this.f11877af, getString(C2300R.C2303string.actionresume));
                } else if (c2657a.m11312at().m10701f() == 2) {
                    m9549a(this.f11877af, getString(C2300R.C2303string.actionpause));
                }
                if (c2657a.m11312at().m10700g().isExceAction()) {
                    if (C2477h.m12020a(getActivity().getApplicationContext()).m12022a().get() == 2 || c2657a.m11312at().m10702e() == 4) {
                        if (this.f11921z.equals(EnumC3145c.CAMER)) {
                            if (this.f11878ag.isShown()) {
                                this.f11878ag.setVisibility(8);
                            }
                        } else if (!this.f11878ag.isShown()) {
                            this.f11878ag.setVisibility(0);
                        }
                    } else if (!this.f11878ag.isShown()) {
                        this.f11878ag.setVisibility(0);
                    }
                } else if (this.f11878ag.isShown()) {
                    this.f11878ag.setVisibility(8);
                }
                double m10498g = (c2657a.mo11202w().m10498g() - 677216.0d) / 10.0d;
                String m12756h = C2238c.m13123e().m12756h();
                if (!c2657a.m11310av().m10574c()) {
                    d = m10498g < ((double) Integer.valueOf(m12756h).intValue()) ? Integer.valueOf(m12756h).intValue() : (int) Math.round(m10498g);
                } else if (m10498g >= 30.0d) {
                    d = (int) Math.round(m10498g);
                }
                double m10497h = c2657a.mo11202w().m10497h();
                if (!c2657a.m11320al()) {
                    m10497h = 0.0d;
                }
                if (m10497h < 10.0d || !c2657a.m11320al() || !(c2657a.m11312at().m10702e() == 7 || c2657a.m11312at().m10702e() == 8)) {
                    this.f11860aF = false;
                    return;
                }
                if (!this.f11860aF) {
                    C2284z.m12695a(this.f11915t, getString(C2300R.C2303string.show_drone_ui_return_home, String.valueOf(Math.round(d)) + this.f11915t.getString(C2300R.C2303string.distance_unit_m)));
                }
                this.f11860aF = true;
                return;
            case DISCONNECTVIDEO:
            default:
                return;
            case ENTRYTAKEPHOTOMODEL:
                m9558K();
                return;
            case SENDHOVERWAYPOINT:
                C3057d.m9823a(c2657a).m9811f(147);
                m9511e(c2657a);
                return;
            case HEARDDAY:
                if (this.f11857aC != null && this.f11857aC.m11726f()) {
                    if (this.f11921z.equals(EnumC3145c.MAP)) {
                        this.f11857aC.m11730b();
                    } else {
                        this.f11857aC.m11734a(C2300R.C2301drawable.photo);
                    }
                    if (this.f11857aC.m11729c() == C2545a.EnumC2548a.DRONEPRESS) {
                        this.f11857aC.m11727e();
                    }
                }
                m9547a(c2657a);
                m9534b(c2657a);
                if (!c2657a.m11318an().m10066u()) {
                    return;
                }
                this.f11908m.setText(getString(C2300R.C2303string.no_use));
                return;
            case PTZ_GAIN:
                if (!c2657a.mo11215ae()) {
                    return;
                }
                m9564E();
                return;
            case NOTIFYPBATTERY:
                m9527c(c2657a);
                return;
            case Remotecontrol:
                m9523c(c2657a.mo11216ac());
                m9519d(c2657a);
                return;
            case CONNECTSUCESS:
                m9537a(c2657a.mo11215ae());
                m9555N();
                return;
            case ERROR_CODE:
                m9545a(c2657a.m11318an());
                return;
            case BATTERY:
                m9562G();
                return;
            case BATTERYINFO:
                this.f11894ax = c2657a.mo11237J().m10321e();
                this.f11895ay = c2657a.mo11237J().m10322d();
                return;
        }
    }

    /* renamed from: a */
    private void m9545a(C2940x c2940x) {
        if (c2940x.m10108ad() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_super_heat));
        } else if (c2940x.m10106af() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_sevo_stal));
        } else if (c2940x.m10100al() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.land_GC_PREHEAT));
        } else if (c2940x.m10067t() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.land_GC_UNREADY));
        } else if (c2940x.m10109ac() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.gc_fault));
        } else if (c2940x.m10107ae() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_self_fail));
        } else if (c2940x.m10105ag() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_gc_heat_error));
        } else if (c2940x.m10104ah() && !c2940x.m10066u()) {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_ahrs));
        } else if (!c2940x.m10066u() || this.f11916u.mo11215ae()) {
            this.f11847F.m9426b((String) null);
        } else {
            this.f11847F.m9426b(getString(C2300R.C2303string.fault_camera));
            m9551a(C2300R.C2303string.fault_camera);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9543a(EnumC3147e enumC3147e) {
        if (!this.f11845D) {
            this.f11861aG = enumC3147e;
        }
    }

    /* renamed from: b */
    private void m9534b(C2657a c2657a) {
        float f = 100.0f;
        double m10497h = c2657a.mo11202w().m10497h();
        if (!c2657a.m11320al()) {
            m10497h = 0.0d;
        }
        if (m10497h <= 0.0d) {
            this.f11900e.setProgress(0.0f);
            return;
        }
        SectorProgressBar sectorProgressBar = this.f11900e;
        if (((float) m10497h) <= 100.0f) {
            f = (float) (m10497h * 0.7d);
        }
        sectorProgressBar.setProgress(f);
        this.f11900e.m9657a((float) (m10497h * 0.7d));
    }

    /* renamed from: b */
    private void m9533b(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        C2924j c2924j = (C2924j) c2657a.f9269c;
        if (!this.f11872aa && c2924j.m10238e() != C2924j.EnumC2925a.StopQuicklyShot) {
            a().mo12676c();
            this.f11897b.removeMessages(7);
        }
        if (c2924j.m10238e() == C2924j.EnumC2925a.StartRecord) {
            m9505f(c2657a);
        } else if (c2924j.m10238e() == C2924j.EnumC2925a.StopRecrod) {
            m9561H();
        } else if (c2924j.m10238e() == C2924j.EnumC2925a.NormalShot) {
            m9560I();
        }
        m9555N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: b */
    public void m9530b(boolean z) {
        if (this.f11921z.equals(EnumC3145c.CAMER)) {
            m9523c(z);
            m9515d(z);
        }
    }

    /* renamed from: c */
    private void m9527c(C2657a c2657a) {
        double d = ShowDroneStatusFragment.f11702f;
        if (0.0d >= d || d >= 30.0d) {
            this.f11901f.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightTop);
        } else {
            this.f11901f.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightToplow);
        }
        this.f11901f.setProgress((float) d);
        this.f11901f.m9657a((float) (d * 0.7d));
    }

    /* renamed from: c */
    private void m9526c(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case OnRecivedCloudCameraCommandInfo:
                int mo10745a = c2657a.f9269c.mo10745a();
                if (mo10745a != 50) {
                    if (mo10745a != 49) {
                        return;
                    }
                    m9533b(enumC2679a, c2657a);
                    return;
                }
                C2913h c2913h = (C2913h) c2657a.f9269c;
                if (c2913h.m10286f() != C2913h.EnumC2914a.NoSDCard) {
                    this.f11842A.b(true);
                } else {
                    this.f11842A.b(false);
                }
                if (this.f11842A.m12230x().mo12252b()) {
                    switch (c2913h.m10286f()) {
                        case VideoRecording:
                            if (this.f11842A.e()) {
                                m9543a(EnumC3147e.Record);
                                this.f11842A.a(AbstractC2390c.EnumC2400a.Recoding);
                                if (c2913h.m10288d() != 0) {
                                    m9550a(System.currentTimeMillis() - c2913h.m10288d());
                                }
                                this.f11842A.a(true);
                                break;
                            }
                            break;
                    }
                } else {
                    switch (c2913h.m10286f()) {
                        case VideoRecording:
                            if (this.f11842A.e()) {
                                m9543a(EnumC3147e.Record);
                                this.f11842A.a(AbstractC2390c.EnumC2400a.Recoding);
                                if (c2913h.m10288d() != 0) {
                                    m9550a(System.currentTimeMillis() - c2913h.m10288d());
                                }
                                this.f11842A.a(true);
                                break;
                            }
                            break;
                        case PhotoShoting:
                            m9543a(EnumC3147e.ContinueCapture);
                            this.f11842A.a(AbstractC2390c.EnumC2400a.ContinueCapturing);
                            if (this.f11848G != null) {
                                this.f11848G.m9594a(c2913h.m10288d() + "张");
                            }
                            this.f11842A.a(true);
                            break;
                        case NormalReady:
                            if (this.f11848G != null) {
                                this.f11848G.m9594a(this.f11868aN);
                            }
                            m9553P();
                            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
                            break;
                        case NoSDCard:
                            m9551a(C2300R.C2303string.tf_remove_error);
                            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
                            break;
                        case FullSDCard:
                            m9551a(C2300R.C2303string.tf_full_error);
                            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
                            break;
                        case OUTSDCard:
                            m9551a(C2300R.C2303string.tf_out_error);
                            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
                            break;
                        case WIFIINIT:
                            m9551a(C2300R.C2303string.tf_camera_init_wifi);
                            break;
                        case CAMERASTART:
                            m9551a(C2300R.C2303string.tf_camera_start);
                            break;
                        case Error:
                            m9551a(C2300R.C2303string.fault_camera);
                            this.f11842A.l().getFileList().clear();
                            m9553P();
                            break;
                        case SAVEPHOTO:
                            this.f11872aa = true;
                            m9551a(C2300R.C2303string.tf_save_photo);
                            break;
                        case LOW_SPEED_CARD:
                        case CardNoPropose:
                        case CardNoProposeAndParamerr:
                        case CardWriteLow:
                        case CardWriteLowAndParamerr:
                            m9551a(C2300R.C2303string.tf_low_speed_error);
                            break;
                        case CardSetroot:
                            m9551a(C2300R.C2303string.tf_io_error);
                            break;
                        case CardFileSysError:
                        case CardParametersError:
                            m9551a(C2300R.C2303string.tf_io_error);
                            break;
                        case Formating:
                            m9551a(C2300R.C2303string.formating);
                            break;
                        case MachineException:
                            m9551a(C2300R.C2303string.camera_exception);
                            break;
                    }
                    m9555N();
                }
                switch (c2913h.m10286f()) {
                    case LOW_SPEED_CARD:
                    case CardNoPropose:
                    case CardNoProposeAndParamerr:
                    case CardWriteLow:
                    case CardWriteLowAndParamerr:
                        m9556M();
                        break;
                    case CardFileSysError:
                    case CardParametersError:
                        m9557L();
                        break;
                }
                m9555N();
                return;
            default:
                return;
        }
    }

    @TargetApi(16)
    /* renamed from: c */
    private void m9523c(boolean z) {
        if (this.f11916u.mo11215ae() && this.f11848G != null && this.f11870aP == CameraMountState.MOUNT && this.f11848G.m9603a() == C2300R.C2303string.fault_camera) {
            m9551a(C2300R.C2303string.tf_normal);
        }
        if (!this.f11921z.equals(EnumC3145c.CAMER)) {
            this.f11905j.setEnabled(true);
            this.f11905j.setImageAlpha(255);
            return;
        }
        this.f11905j.setEnabled(z);
        if (z) {
            this.f11905j.setImageAlpha(255);
        } else {
            this.f11905j.setImageAlpha(85);
        }
    }

    /* renamed from: d */
    private void m9520d(int i) {
        m9507e(false);
        new DialogC3800f.C3815d(getActivity()).m6974a(C2238c.m13124d().getString(C2300R.C2303string.live_stopped) + getString(i)).m6973a(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }).m6977a().show();
    }

    /* renamed from: d */
    private void m9519d(C2657a c2657a) {
        if (c2657a.m11312at().m10700g().isLightStream()) {
            if (this.f11902g.getProgress() == 0.0f) {
                return;
            }
            this.f11902g.setProgress(0.0f);
            this.f11902g.m9657a(0.0f);
            return;
        }
        byte m10501d = c2657a.mo11202w().m10501d();
        if (m10501d <= 4) {
            return;
        }
        if (m10501d <= 8) {
            this.f11902g.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightBottomSatt);
        } else {
            this.f11902g.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightBottom);
        }
        if (m10501d <= 8) {
            this.f11902g.setProgress(m10501d * 4.2f);
            this.f11902g.m9657a(m10501d * 2.87f);
        } else if (m10501d <= 8 || m10501d > 13) {
            this.f11902g.setProgress((m10501d * 4.7f) + 5.0f);
            this.f11902g.m9657a((float) ((m10501d * 3.29f) + 3.2d));
        } else {
            this.f11902g.setProgress((m10501d * 5.5f) - 11.0f);
            this.f11902g.m9657a((float) ((m10501d * 4.6f) - 13.8d));
        }
    }

    /* renamed from: d */
    private void m9518d(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11216ac() || c2657a.m11318an().m10066u()) {
            m9551a(C2300R.C2303string.fault_camera);
            this.f11868aN = getString(C2300R.C2303string.tf_normal);
            this.f11842A.l().getFileList().clear();
            this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
            m9507e(false);
            m9555N();
            m9523c(false);
            this.f11847F.m9426b((String) null);
            this.f11842A.a(true);
            m9555N();
            return;
        }
        switch (enumC2679a) {
            case OnRecivedCloudCameraCommandInfo:
                if (c2657a.f9269c.mo10745a() != 50) {
                    return;
                }
                if (((C2913h) c2657a.f9269c).m10286f() != C2913h.EnumC2914a.NoSDCard) {
                    this.f11842A.b(true);
                } else {
                    this.f11842A.b(false);
                }
                switch (r0.m10286f()) {
                    case WIFIINIT:
                        m9551a(C2300R.C2303string.tf_camera_init_wifi);
                        return;
                    case CAMERASTART:
                        m9551a(C2300R.C2303string.tf_camera_start);
                        return;
                    case Error:
                        m9551a(C2300R.C2303string.fault_camera);
                        this.f11842A.l().getFileList().clear();
                        return;
                    case SAVEPHOTO:
                    case Formating:
                    default:
                        return;
                    case LOW_SPEED_CARD:
                    case CardNoPropose:
                    case CardNoProposeAndParamerr:
                    case CardWriteLow:
                    case CardWriteLowAndParamerr:
                        m9551a(C2300R.C2303string.tf_low_speed_error);
                        m9556M();
                        return;
                    case CardSetroot:
                        m9551a(C2300R.C2303string.tf_io_error);
                        return;
                    case CardFileSysError:
                    case CardParametersError:
                        m9551a(C2300R.C2303string.tf_io_error);
                        m9557L();
                        return;
                    case MachineException:
                        m9551a(C2300R.C2303string.camera_exception);
                        return;
                }
            default:
                return;
        }
    }

    @TargetApi(16)
    /* renamed from: d */
    private void m9515d(boolean z) {
        if (this.f11921z.equals(EnumC3145c.MAP)) {
            this.f11906k.setEnabled(true);
            this.f11906k.setImageAlpha(255);
        } else {
            this.f11906k.setEnabled(z);
            if (z) {
                this.f11906k.setImageAlpha(255);
            } else {
                this.f11906k.setImageAlpha(85);
            }
        }
        this.f11904i.setEnabled(z);
        if (z) {
            this.f11904i.setImageAlpha(255);
        } else {
            this.f11904i.setImageAlpha(85);
        }
    }

    /* renamed from: e */
    private void m9512e(int i) {
    }

    /* renamed from: e */
    private void m9511e(C2657a c2657a) {
        byte m10427a = c2657a.mo11231P().m10427a();
        if (m10427a == 80) {
            if (!getString(C2300R.C2303string.actionpause).equals(this.f11877af.getText().toString())) {
                return;
            }
            m9549a(this.f11877af, getString(C2300R.C2303string.actionresume));
        } else if (m10427a == 82) {
            m9549a(this.f11877af, getString(C2300R.C2303string.actionpause));
        } else {
            if (this.f11878ag.isShown()) {
                this.f11878ag.setVisibility(8);
            }
            switch (this.f11863aI.m12022a().get()) {
                case 1:
                    c2657a.mo11220a(C2678d.EnumC2679a.SHOWINFORWINDOW);
                    break;
                case 2:
                    c2657a.mo11220a(C2678d.EnumC2679a.SHOWQUITDOUBLEINFRWINDOW);
                    break;
                case 3:
                    c2657a.mo11220a(C2678d.EnumC2679a.SHOWDOUBLEPOI);
                    break;
                case 4:
                    c2657a.mo11220a(C2678d.EnumC2679a.QUITTAKEPHOTOFLY);
                    break;
            }
            this.f11863aI.m12021a(0);
            m9549a(this.f11877af, getString(C2300R.C2303string.actionpause));
        }
    }

    /* renamed from: e */
    private void m9510e(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CLEANALLOBJ:
                if (c2657a.m11318an().m10066u()) {
                    this.f11908m.setText(getString(C2300R.C2303string.no_use));
                }
                m9537a(false);
                m9553P();
                if (this.f11878ag.isShown()) {
                    this.f11878ag.setVisibility(8);
                    break;
                }
                break;
        }
        if (!c2657a.mo11217ab().mo10898a()) {
            if (this.f11900e.getProgress() != 0.0f) {
                this.f11900e.setProgress(0.0f);
                this.f11900e.m9657a(0.0f);
            }
            if (this.f11902g.getProgress() != 0.0f) {
                this.f11902g.setProgress(0.0f);
                this.f11902g.m9657a(0.0f);
            }
            if (this.f11901f.getProgress() != 0.0f) {
                this.f11901f.setProgress(0.0f);
                this.f11901f.m9657a(0.0f);
            }
            if (this.f11899d.getProgress() != 0.0f) {
                this.f11899d.setProgress(0.0f);
                this.f11899d.m9657a(0.0f);
            }
        }
        if (!c2657a.mo11215ae()) {
            m9537a(false);
        }
        if (!c2657a.mo11216ac() && this.f11857aC != null) {
            if (this.f11921z.equals(EnumC3145c.MAP)) {
                this.f11857aC.m11730b();
            } else {
                this.f11857aC.m11734a(C2300R.C2301drawable.photo);
            }
        }
        this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
        m9507e(false);
        m9555N();
        m9523c(false);
        this.f11847F.m9426b((String) null);
        this.f11842A.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: e */
    public void m9507e(boolean z) {
        boolean z2 = true;
        int i = 0;
        this.f11845D = z;
        if (this.f11921z.equals(EnumC3145c.CAMER)) {
            if (C2238c.m13124d() != null) {
                this.f11905j.setImageDrawable(C2238c.m13124d().getResources().getDrawable(!z ? C2300R.C2301drawable.btn_live_play : C2300R.C2301drawable.btn_live_stop));
            }
            this.f11904i.setEnabled(!z);
            this.f11906k.setEnabled(!z);
            if (z) {
                this.f11906k.setImageAlpha(85);
                this.f11904i.setImageAlpha(85);
            } else {
                this.f11904i.setImageAlpha(255);
                this.f11906k.setImageAlpha(255);
            }
        }
        UpDownSliding upDownSliding = this.f11843B;
        if (z) {
            z2 = false;
        }
        upDownSliding.setEnabled(z2);
        if (this.f11849H != null) {
            ShowDroneStatusFragment showDroneStatusFragment = this.f11849H;
            if (!z) {
                i = 8;
            }
            showDroneStatusFragment.m9617d(i);
        }
        if (this.f11848G != null) {
            this.f11848G.m9586b(z);
        }
    }

    /* renamed from: f */
    private void m9505f(C2657a c2657a) {
        this.f11842A.m12230x().mo12253a(C2427e.EnumC2428a.StartRecord);
        if (this.f11921z.equals(EnumC3145c.CAMER)) {
            this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.recording));
        }
        this.f11842A.a(AbstractC2390c.EnumC2400a.Recoding);
        if (!this.f11853Z) {
            this.f11853Z = true;
            C3658ar.m7570l(getActivity());
            this.f11897b.sendEmptyMessageDelayed(12, 2000L);
        }
        C2284z.m12689b(getActivity(), getString(C2300R.C2303string.record_start), C2284z.f7606b);
        m9550a(System.currentTimeMillis());
        c2657a.mo11220a(C2678d.EnumC2679a.CAMERARECORD);
        if (this.f11867aM == null) {
            this.f11867aM = C2205c.m13235a(C2238c.m13131a());
        }
        this.f11867aM.m13225d();
    }

    /* renamed from: A */
    public void m9568A() {
        if (this.f11885an != null) {
            this.f11885an.m9862a();
        }
    }

    /* renamed from: B */
    public void m9567B() {
        if ("off".equals("") || !this.f11842A.e() || C2277v.m12784a(C2238c.m13131a()).m12742s() != DeviceType.DEVICE_4K) {
            return;
        }
        this.f11842A.m12233u().m12298a("menu_album", "off");
    }

    /* renamed from: C */
    public void m9566C() {
        String ae_bias = this.f11842A.j().getAe_bias();
        if (ae_bias == null || ae_bias.equals("")) {
            return;
        }
        ShowDroneStatusFragment.f11701b = Float.valueOf(ae_bias.replace("EV", "").replace(" ", "")).floatValue();
    }

    /* renamed from: D */
    public boolean m9565D() {
        return this.f11921z == EnumC3145c.MAP;
    }

    /* renamed from: a */
    public void m9551a(int i) {
        if (this.f11848G == null || getActivity() == null) {
            return;
        }
        this.f11848G.m9584c(i);
    }

    /* renamed from: a */
    public void m9550a(long j) {
        this.f11852Y = j;
        if (this.f11874ac == null) {
            this.f11874ac = new Timer();
            this.f11874ac.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (ShowDroneUiFragment.this.f11842A.g() == AbstractC2390c.EnumC2400a.Recoding) {
                        ShowDroneUiFragment.this.f11897b.sendEmptyMessage(1);
                    } else if (ShowDroneUiFragment.this.f11874ac == null) {
                        ShowDroneUiFragment.this.f11874ac = null;
                    } else {
                        ShowDroneUiFragment.this.f11874ac.cancel();
                        ShowDroneUiFragment.this.f11874ac = null;
                    }
                }
            }, 0L, 1000L);
        }
    }

    @Override // com.fimi.soul.biz.camera.AbstractC2390c.AbstractC2403d
    /* renamed from: a */
    public void mo9548a(AbstractC2390c.EnumC2400a enumC2400a, AbstractC2390c.EnumC2400a enumC2400a2) {
        C2284z.m12694a(getActivity(), "状态变化啦" + enumC2400a + "-->" + enumC2400a2, 1000);
    }

    /* renamed from: a */
    public void m9544a(ShowDroneStatusLineFragment showDroneStatusLineFragment, ShowDroneStatusFragment showDroneStatusFragment) {
        this.f11848G = showDroneStatusLineFragment;
        this.f11849H = showDroneStatusFragment;
    }

    /* renamed from: a */
    public void m9537a(boolean z) {
        if (this.f11921z.equals(EnumC3145c.CAMER)) {
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (this.f11848G != null) {
            X11RespCmd.NotificationType notificationType = x11RespCmd.getNotificationType();
            if (notificationType == X11RespCmd.NotificationType.CardRemoved) {
                this.f11842A.a(true);
                this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
            } else if (notificationType == X11RespCmd.NotificationType.PhotoFinish) {
                m9537a(true);
            }
            if (!z) {
                switch (x11RespCmd.getRval()) {
                    case -4:
                        this.f11842A.a(-4);
                        this.f11842A.m12231w().m12240b();
                        break;
                }
            }
            switch (x11RespCmd.getMsg_id()) {
                case 2:
                    m9514d(z, x11RespCmd);
                    if (!z) {
                        if (x11RespCmd.getType() != null) {
                            C2284z.m12694a(this.f11915t, this.f11915t.getString(C2300R.C2303string.setting_false), C2284z.f7607c);
                        }
                        C2238c.m13127b().mo12676c();
                        return;
                    }
                    if (!C2427e.f8252bB.equals(x11RespCmd.getType())) {
                    }
                    if (!C2427e.f8332cd.equals(x11RespCmd.getType())) {
                        return;
                    }
                    m9568A();
                    return;
                case 3:
                    if (EnumC3145c.CAMER == this.f11921z && isAdded()) {
                        m9555N();
                    }
                    m9566C();
                    return;
                case 4:
                    if (z) {
                        C2284z.m12694a(this.f11915t, getString(C2300R.C2303string.format_success), C2284z.f7607c);
                        this.f11842A.m12233u().m12290d(C2427e.f8324cU);
                        this.f11842A.a(true);
                    } else {
                        C2284z.m12694a(this.f11915t, this.f11915t.getString(C2300R.C2303string.format_fail), C2284z.f7607c);
                    }
                    C2238c.m13127b().mo12676c();
                    return;
                case 257:
                    m9537a(true);
                    this.f11842A.l().getFileList().clear();
                    if (getActivity() != null) {
                        m9551a(C2300R.C2303string.tf_normal);
                    }
                    if (!z) {
                        return;
                    }
                    this.f11842A.m12233u().m12296b();
                    return;
                case C2427e.f8177G /* 260 */:
                    this.f11842A.m12233u().m12289e();
                    if (this.f11845D) {
                        this.f11842A.m12233u().m12285g();
                    } else {
                        this.f11842A.m12233u().m12284h();
                    }
                    m9555N();
                    return;
                case C2427e.f8233aj /* 7829367 */:
                    C3676e.m7493a().m7492a(" changeMountState --->" + CameraMountState.DISMOUNT);
                    if (!isAdded()) {
                        return;
                    }
                    m9479s();
                    return;
                case C2427e.f8232ai /* 10066329 */:
                    if (this.f11916u.mo11215ae() && this.f11842A.g() != AbstractC2390c.EnumC2400a.Recoding && this.f11870aP == CameraMountState.MOUNT) {
                        m9537a(true);
                    }
                    this.f11897b.sendEmptyMessageDelayed(2, 2000L);
                    if (this.f11842A.e()) {
                        return;
                    }
                    this.f11842A.m12231w().m12240b();
                    return;
                case C2427e.f8235al /* 25725064 */:
                    C3676e.m7493a().m7492a(" changeMountState --->" + CameraMountState.MOUNT);
                    m9480r();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public void m9535b(int i) {
        this.f11918w.setVisibility(i);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2386d
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo6637b(boolean z, X11RespCmd x11RespCmd) {
        C3676e.m7493a().m7492a(" changeMountState onMount ");
        m9480r();
    }

    /* renamed from: c */
    public void m9528c(int i) {
        if (i == 0) {
            this.f11912q.setVisibility(0);
            this.f11913r.setVisibility(0);
            return;
        }
        this.f11912q.setVisibility(4);
        this.f11913r.setVisibility(4);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2386d
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public void mo6635c(boolean z, X11RespCmd x11RespCmd) {
        C3676e.m7493a().m7492a(" changeMountState onDisMount ");
        m9479s();
    }

    /* renamed from: d */
    public void m9521d() {
        if (!this.f11916u.m11292h().m10142c() || this.f11847F == null) {
            return;
        }
        this.f11847F.m9408o();
    }

    /* renamed from: d */
    public void m9514d(boolean z, X11RespCmd x11RespCmd) {
        if (!z || !"ae_bias".equals(x11RespCmd.getType())) {
            return;
        }
        m9475w();
    }

    /* renamed from: e */
    public void m9513e() {
        if (this.f11847F != null) {
            this.f11847F.m9406q();
        }
    }

    /* renamed from: f */
    public void m9506f() {
        if (C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_4K) {
            m9502g();
        } else if (C2277v.m12784a(getActivity()).m12742s() != DeviceType.DEVICE_1080P) {
        } else {
            m9500h();
        }
    }

    /* renamed from: g */
    public void m9502g() {
        this.f11903h.setVisibility(0);
        this.f11914s.setVisibility(0);
        this.f11884am.setVisibility(0);
        this.f11907l.setVisibility(8);
    }

    /* renamed from: h */
    public void m9500h() {
        this.f11903h.setVisibility(8);
        this.f11914s.setVisibility(8);
        this.f11884am.setVisibility(8);
        this.f11907l.setVisibility(0);
    }

    /* renamed from: i */
    public void m9498i() {
        this.f11844C = new C4098c(C2353b.f7968z, C2353b.f7910A, 1, new AbstractC4094a() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.10
            @Override // com.p219mi.live.openlivesdk.p220a.AbstractC4094a
            /* renamed from: a */
            public void mo6213a() {
                ShowDroneUiFragment.this.f11842A.m12233u().m12284h();
                ShowDroneUiFragment.this.m9507e(false);
                C3676e.m7493a().m7492a(" onEndLiveSuccess ");
                ShowDroneUiFragment.this.f11847F.m9419e();
            }

            @Override // com.p219mi.live.openlivesdk.p220a.AbstractC4094a
            /* renamed from: a */
            public void mo6212a(int i, String str) {
                switch (i) {
                    case -3:
                        C2284z.m12696a(ShowDroneUiFragment.this.getActivity(), (int) C2300R.C2303string.stream_live_version_error, 2000);
                        return;
                    case -2:
                        C2284z.m12696a(ShowDroneUiFragment.this.getActivity(), (int) C2300R.C2303string.stream_live_uninstall_error, 2000);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.p219mi.live.openlivesdk.p220a.AbstractC4094a
            /* renamed from: a */
            public void mo6211a(String str) {
                ShowDroneUiFragment.this.f11854a = str;
                ShowDroneUiFragment.this.f11842A.m12233u().m12285g();
                ShowDroneUiFragment.this.f11847F.m9432a(str);
                ShowDroneUiFragment.this.m9507e(true);
            }

            @Override // com.p219mi.live.openlivesdk.p220a.AbstractC4094a
            /* renamed from: b */
            public void mo6210b(int i, String str) {
                switch (i) {
                    case -3:
                        C2284z.m12696a(ShowDroneUiFragment.this.getActivity(), (int) C2300R.C2303string.stream_live_version_error, 2000);
                        return;
                    case -2:
                        C2284z.m12696a(ShowDroneUiFragment.this.getActivity(), (int) C2300R.C2303string.stream_live_uninstall_error, 2000);
                        C3676e.m7493a().m7492a(" stream_live_uninstall_error ");
                        ShowDroneUiFragment.this.m9507e(false);
                        return;
                    default:
                        return;
                }
            }
        }, this.f11917v);
        this.f11847F.m9435a(new View$OnTouchListenerC3156b.AbstractC3162c() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.11
            @Override // com.fimi.soul.module.droneFragment.View$OnTouchListenerC3156b.AbstractC3162c
            /* renamed from: a */
            public void mo9401a(int i, int i2, int i3) {
                ShowDroneUiFragment.this.f11897b.obtainMessage(VideoStatusCode.STATUS_CODE, new VideoStatusCode(i, i2, i3)).sendToTarget();
            }
        });
    }

    /* renamed from: j */
    public void m9496j() {
        if (this.f11842A != null) {
            this.f11842A.n();
        }
    }

    @TargetApi(16)
    /* renamed from: k */
    public void m9494k() {
        if (this.f11921z.equals(EnumC3145c.MAP)) {
            if ((C2477h.m12020a(getActivity().getApplicationContext()).m12022a().get() == 2 || this.f11916u.m11312at().m10702e() == 4) && this.f11878ag.isShown()) {
                this.f11878ag.setVisibility(8);
            }
            m9558K();
            m9478t();
            ((FlightActivity) getActivity()).m8868k();
        } else {
            this.f11921z = EnumC3145c.MAP;
            m9478t();
            this.f11843B.setVisibility(8);
            this.f11905j.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.navigabutton));
            if (this.f11857aC != null) {
                this.f11857aC.m11730b();
            }
            this.f11903h.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.video));
            this.f11907l.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.video_1080));
            ((FlightActivity) getActivity()).m8880e();
            this.f11847F.m9429b();
            this.f11906k.setEnabled(true);
            this.f11906k.setImageAlpha(255);
            this.f11847F.m9417f();
            this.f11847F.m9414i();
            ((FlightActivity) getActivity()).m8868k();
        }
        m9523c(this.f11916u.mo11216ac());
    }

    /* renamed from: l */
    public void m9492l() {
        this.f11847F.m9426b(getString(C2300R.C2303string.fault_camera));
        m9551a(C2300R.C2303string.fault_camera);
    }

    /* renamed from: m */
    public void m9490m() {
        if (this.f11847F != null) {
            this.f11847F.m9408o();
        }
    }

    /* renamed from: n */
    public void m9488n() {
        this.f11903h.performClick();
    }

    /* renamed from: o */
    public void m9486o() {
        if (!this.f11921z.equals(EnumC3145c.MAP)) {
            this.f11903h.performClick();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11867aM = C2205c.m13235a(getActivity());
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11915t = activity.getApplicationContext();
        this.f11917v = (DroidPlannerApp) activity.getApplication();
        this.f11862aH = (AbstractC3146d) activity;
        this.f11916u = this.f11917v.f7895a;
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(16)
    public void onClick(View view) {
        String videoResolution;
        switch (view.getId()) {
            case C2300R.C2302id.view_camera /* 2131493515 */:
                if (this.f11842A.g() != AbstractC2390c.EnumC2400a.Recoding || (videoResolution = this.f11842A.j().getVideoResolution()) == null || "".equals(videoResolution) || C2427e.f8338cj.contains(videoResolution) || C2427e.f8342cn.contains(videoResolution) || C2427e.f8343co.contains(videoResolution)) {
                    return;
                }
                if (a().mo12680b() != null && a().mo12680b().isShowing()) {
                    return;
                }
                a().mo12687a();
                if (a().mo12680b() != null) {
                    a().mo12680b().setCancelable(false);
                }
                this.f11842A.m12230x().mo12244k();
                this.f11897b.sendEmptyMessageDelayed(7, 4000L);
                return;
            case C2300R.C2302id.cameraButton_1080 /* 2131493862 */:
                m9494k();
                return;
            case C2300R.C2302id.camerButton /* 2131493863 */:
                m9494k();
                return;
            case C2300R.C2302id.setttingbutton /* 2131493869 */:
                this.f11862aH.mo8895a();
                return;
            case C2300R.C2302id.rightcenterbutton /* 2131493870 */:
                if (this.f11921z.equals(EnumC3145c.MAP)) {
                    if (!this.f11916u.m11312at().m10700g().judgeOpenDrawLayout()) {
                        return;
                    }
                    this.f11916u.mo11220a(C2678d.EnumC2679a.OPENDRAWCONTROL);
                    return;
                }
                int i = 4000;
                if (a().mo12680b() != null && a().mo12680b().isShowing()) {
                    return;
                }
                if (this.f11861aG == EnumC3147e.Live) {
                    m9559J();
                    return;
                }
                a().mo12687a();
                if (a().mo12680b() != null) {
                    a().mo12680b().setCancelable(false);
                }
                switch (this.f11861aG) {
                    case Record:
                        if (this.f11842A.g() != AbstractC2390c.EnumC2400a.Recoding) {
                            this.f11842A.m12230x().mo12248f();
                            break;
                        } else {
                            this.f11842A.m12230x().mo12247g();
                            this.f11897b.sendEmptyMessageDelayed(2, 2000L);
                            break;
                        }
                    case ContinueCapture:
                        if (this.f11842A.g() != AbstractC2390c.EnumC2400a.ContinueCapturing) {
                            Log.d("Good", "开始连拍");
                            this.f11842A.m12230x().mo12249e();
                            break;
                        } else {
                            Log.d("Good", "连拍中--》停止连拍");
                            i = 13000;
                            this.f11872aa = true;
                            m9530b(false);
                            this.f11842A.m12230x().mo12250d();
                            break;
                        }
                    case TakePhoto:
                        if (C2427e.f8304cA.equals(this.f11842A.j().getImage_format())) {
                            i = 10000;
                        }
                        this.f11842A.m12230x().mo12251c();
                        break;
                }
                this.f11897b.removeMessages(7);
                this.f11897b.sendEmptyMessageDelayed(7, i);
                return;
            case C2300R.C2302id.locationbutton /* 2131493871 */:
                if (this.f11921z.equals(EnumC3145c.MAP)) {
                    if (this.f11857aC == null) {
                        return;
                    }
                    this.f11857aC.m11728d();
                    return;
                }
                m9537a(false);
                this.f11847F.m9410m();
                Intent intent = new Intent();
                intent.setClass(getActivity(), DroneMediaTabActivity.class);
                getActivity().startActivityForResult(intent, 1000);
                return;
            case C2300R.C2302id.left_pause_btn /* 2131493876 */:
                C3057d.m9823a(this.f11916u).m9816d();
                return;
            case C2300R.C2302id.right_pause_btn /* 2131493877 */:
                if (getString(C2300R.C2303string.actionpause).equals(this.f11877af.getText().toString())) {
                    C3057d.m9823a(this.f11916u).m9812f();
                    return;
                } else {
                    C3057d.m9823a(this.f11916u).m9814e();
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11863aI = C2477h.m12020a(getActivity());
    }

    @Override // com.fimi.kernel.BaseFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.showdroncontral, (ViewGroup) null);
        this.f11918w = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.showui);
        this.f11859aE = new DroneFilghtState();
        this.f11884am = (ImageButton) inflate.findViewById(C2300R.C2302id.cameraMenuButton);
        this.f11884am.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShowDroneUiFragment.this.m9474x();
            }
        });
        this.f11912q = (RelativeLayout) inflate.findViewById(C2300R.C2302id.gimal_angle_rl);
        this.f11913r = (RelativeLayout) inflate.findViewById(C2300R.C2302id.electivity_rl);
        this.f11908m = (TextView) inflate.findViewById(C2300R.C2302id.gimal_angle_tv);
        this.f11910o = (TextView) inflate.findViewById(C2300R.C2302id.gimal_angle_label_tv);
        this.f11909n = (TextView) inflate.findViewById(C2300R.C2302id.electivity_tv);
        this.f11911p = (TextView) inflate.findViewById(C2300R.C2302id.electivity_lable_tv);
        m9478t();
        View findViewById = inflate.findViewById(C2300R.C2302id.view_camera);
        this.f11847F = new View$OnTouchListenerC3156b(getActivity(), findViewById);
        findViewById.setOnClickListener(this);
        findViewById.setOnTouchListener(this);
        this.f11919x = (ImageView) this.f11918w.findViewById(C2300R.C2302id.leftbg);
        this.f11920y = (ImageView) this.f11918w.findViewById(C2300R.C2302id.rghtbg);
        this.f11899d = (SectorProgressBar) this.f11918w.findViewById(C2300R.C2302id.spb_leftTop);
        this.f11899d.setSectorProgressBarType(SectorProgressBar.EnumC3102a.LeftTop);
        this.f11900e = (SectorProgressBar) this.f11918w.findViewById(C2300R.C2302id.spb_leftBottom);
        this.f11900e.setSectorProgressBarType(SectorProgressBar.EnumC3102a.LeftBottom);
        this.f11901f = (SectorProgressBar) this.f11918w.findViewById(C2300R.C2302id.spb_rightTop);
        if (ShowDroneStatusFragment.f11702f > 30 || ShowDroneStatusFragment.f11702f == 0) {
            this.f11901f.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightTop);
        } else {
            this.f11901f.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightToplow);
        }
        this.f11902g = (SectorProgressBar) this.f11918w.findViewById(C2300R.C2302id.spb_rightBottom);
        this.f11902g.setSectorProgressBarType(SectorProgressBar.EnumC3102a.RightBottom);
        this.f11878ag = (PercentRelativeLayout) this.f11918w.findViewById(C2300R.C2302id.status_action_vg);
        this.f11876ae = (Button) this.f11918w.findViewById(C2300R.C2302id.left_pause_btn);
        this.f11877af = (Button) this.f11918w.findViewById(C2300R.C2302id.right_pause_btn);
        C3658ar.m7612a(getActivity().getAssets(), this.f11876ae, this.f11877af, this.f11909n, this.f11911p, this.f11910o, this.f11908m);
        this.f11903h = (ImageButton) this.f11918w.findViewById(C2300R.C2302id.camerButton);
        this.f11907l = (ImageButton) this.f11918w.findViewById(C2300R.C2302id.cameraButton_1080);
        this.f11914s = this.f11918w.findViewById(C2300R.C2302id.camerdived);
        this.f11904i = (ImageButton) this.f11918w.findViewById(C2300R.C2302id.setttingbutton);
        this.f11905j = (ImageButton) this.f11918w.findViewById(C2300R.C2302id.rightcenterbutton);
        this.f11906k = (ImageButton) this.f11918w.findViewById(C2300R.C2302id.locationbutton);
        for (View view : new View[]{this.f11903h, this.f11907l, this.f11904i, this.f11905j, this.f11906k, this.f11876ae, this.f11877af}) {
            view.setOnClickListener(this);
        }
        this.f11843B = (UpDownSliding) this.f11918w.findViewById(C2300R.C2302id.up_down_slid);
        if (this.f11843B.getCurrentState() == UpDownSliding.EnumC3756b.Record) {
            m9543a(EnumC3147e.Record);
        } else if (this.f11843B.getCurrentState() == UpDownSliding.EnumC3756b.TakePhoto) {
            m9543a(EnumC3147e.TakePhoto);
        } else if (this.f11843B.getCurrentState() == UpDownSliding.EnumC3756b.Live) {
            m9543a(EnumC3147e.Live);
        }
        this.f11843B.setOnUpDownSliding(new UpDownSliding.AbstractC3757c() { // from class: com.fimi.soul.module.droneFragment.ShowDroneUiFragment.8
            @Override // com.fimi.soul.view.UpDownSliding.AbstractC3757c
            /* renamed from: a */
            public void mo7158a(UpDownSliding.EnumC3756b enumC3756b) {
                Log.i("ljh", "current mode : " + enumC3756b);
                if (enumC3756b == UpDownSliding.EnumC3756b.TakePhoto) {
                    ShowDroneUiFragment.this.m9543a(EnumC3147e.TakePhoto);
                } else if (enumC3756b == UpDownSliding.EnumC3756b.Live) {
                    ShowDroneUiFragment.this.m9543a(EnumC3147e.Live);
                } else if (enumC3756b == UpDownSliding.EnumC3756b.Record) {
                    ShowDroneUiFragment.this.m9543a(EnumC3147e.Record);
                }
                ShowDroneUiFragment.this.m9555N();
                if (ShowDroneUiFragment.this.f11848G != null) {
                    ShowDroneStatusLineFragment unused = ShowDroneUiFragment.this.f11848G;
                    if (!ShowDroneStatusLineFragment.f11782a || !ShowDroneUiFragment.this.f11916u.mo11215ae()) {
                        return;
                    }
                    EnumC3147e enumC3147e = ShowDroneUiFragment.this.f11861aG;
                    EnumC3147e unused2 = ShowDroneUiFragment.this.f11861aG;
                    if (enumC3147e == EnumC3147e.Record) {
                        if (ShowDroneUiFragment.this.f11848G.m9603a() != 0) {
                            return;
                        }
                        ShowDroneUiFragment.this.f11848G.m9594a(ShowDroneUiFragment.this.getString(C2300R.C2303string.tf_normal));
                        return;
                    }
                    EnumC3147e enumC3147e2 = ShowDroneUiFragment.this.f11861aG;
                    EnumC3147e unused3 = ShowDroneUiFragment.this.f11861aG;
                    if (enumC3147e2 == EnumC3147e.ContinueCapture) {
                        ShowDroneUiFragment.this.f11848G.m9594a("0张");
                        return;
                    }
                    if (ShowDroneUiFragment.this.f11861aG != EnumC3147e.TakePhoto || ShowDroneUiFragment.this.f11848G.m9603a() == 0) {
                    }
                }
            }
        });
        this.f11868aN = getString(C2300R.C2303string.tf_normal);
        m9506f();
        this.f11893av = ViewConfiguration.get(this.f11915t).getScaledTouchSlop();
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11916u.mo11214b(this);
        this.f11873ab = true;
        this.f11899d.m9654b();
        this.f11900e.m9654b();
        this.f11901f.m9654b();
        this.f11902g.m9654b();
        this.f11844C.m6209a();
        if (this.f11874ac != null) {
            this.f11874ac.cancel();
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (enumC2679a == C2678d.EnumC2679a.Show9Grid) {
            if (this.f11847F != null && this.f11921z == EnumC3145c.CAMER) {
                this.f11847F.m9415h();
            }
        } else if (enumC2679a == C2678d.EnumC2679a.hide9Grid && this.f11847F != null) {
            this.f11847F.m9414i();
        }
        if (!c2657a.mo11216ac() || !c2657a.mo11217ab().mo10898a()) {
            m9510e(enumC2679a, c2657a);
        } else {
            m9546a(enumC2679a, c2657a);
        }
        if (c2657a.mo11215ae()) {
            m9526c(enumC2679a, c2657a);
        } else {
            m9518d(enumC2679a, c2657a);
            m9510e(enumC2679a, c2657a);
        }
        switch (enumC2679a) {
            case EMERGENCY:
                if (!C2367d.m12459a().m12438k()) {
                    return;
                }
                m9521d();
                return;
            case NEWFRONEMODEL:
                if (this.f11859aE == null || !this.f11859aE.isFilghtPhaseFinish(c2657a.m11312at().m10705b())) {
                    return;
                }
                m9513e();
                return;
            case DISCONNECTVIDEO:
                if (this.f11847F == null) {
                    return;
                }
                this.f11847F.m9407p();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f11843B.m7166b(getActivity());
        boolean m12438k = C2367d.m12459a().m12438k();
        if (m12438k != C2367d.m12459a().m12438k() && m12438k) {
            this.f11861aG = EnumC3147e.TakePhoto;
        }
        this.f11842A.c(true);
        if (!this.f11850Q) {
            this.f11897b.sendEmptyMessage(8);
        }
        m9506f();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f11857aC == null) {
            this.f11857aC = C2545a.m11735a();
            this.f11857aC.m11733a(this.f11906k, this.f11916u);
        }
        this.f11880ai = false;
        this.f11879ah = false;
        this.f11916u.mo11219a(this);
        this.f11842A.a((AbstractC2390c.AbstractC2403d) this);
        this.f11842A.a((AbstractC2388f<X11RespCmd>) this);
        if (!this.f11842A.e() && this.f11916u.mo11215ae()) {
            this.f11842A.m12231w().m12240b();
        }
        if (this.f11842A.e()) {
            this.f11842A.m12233u().m12296b();
        }
        this.f11847F.m9411l();
        m9537a(true);
        this.f11897b.sendEmptyMessageDelayed(2, 2000L);
        this.f11881aj = C2367d.m12459a().m12438k();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f11847F.m9412k();
        m9537a(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f11886ao = false;
                this.f11887ap = true;
                this.f11855aA = false;
                this.f11888aq = 1;
                this.f11891at = 0.0f;
                this.f11892au = 0.0f;
                this.f11889ar = 0.0f;
                this.f11890as = 0.0f;
                break;
            case 1:
                if (!this.f11886ao && !this.f11845D) {
                    float abs = Math.abs(this.f11889ar) - Math.abs(this.f11891at);
                    float abs2 = Math.abs(this.f11890as) - Math.abs(this.f11892au);
                    if (Math.sqrt(Math.pow(abs, 2.0d) + Math.pow(abs2, 2.0d)) > this.f11893av * 10) {
                        if (Math.abs(abs) <= Math.abs(abs2)) {
                            abs = abs2;
                        }
                        if (abs <= 0.0f) {
                            this.f11916u.mo11220a(C2678d.EnumC2679a.HIDE_FULL_SCREEN);
                        } else if (this.f11916u.mo11215ae()) {
                            this.f11916u.mo11220a(C2678d.EnumC2679a.SHOW_FULL_SCREEN);
                        }
                    }
                    this.f11888aq = 0;
                    if (this.f11855aA) {
                        return true;
                    }
                }
                break;
            case 2:
                if (this.f11888aq == 2) {
                    if (this.f11887ap) {
                        this.f11891at = motionEvent.getX(1) - motionEvent.getX(0);
                        this.f11892au = motionEvent.getY(1) - motionEvent.getY(0);
                        this.f11887ap = false;
                    }
                    this.f11889ar = motionEvent.getX(1) - motionEvent.getX(0);
                    this.f11890as = motionEvent.getY(1) - motionEvent.getY(0);
                    break;
                }
                break;
            case 3:
                this.f11886ao = true;
                break;
            case 5:
                this.f11888aq++;
                if (this.f11888aq > 1) {
                    this.f11855aA = true;
                    break;
                }
                break;
            case 6:
                this.f11888aq--;
                break;
        }
        return false;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11847F.m9424c();
        m9498i();
    }

    /* renamed from: p */
    public void m9484p() {
        this.f11847F.m9405r();
    }

    /* renamed from: q */
    public boolean m9482q() {
        return this.f11921z.equals(EnumC3145c.MAP);
    }

    /* renamed from: r */
    public void m9480r() {
        ((FlightActivity) getActivity()).m8876g();
        m9567B();
        this.f11847F.m9426b((String) null);
        m9551a(C2300R.C2303string.tf_normal);
        this.f11870aP = CameraMountState.MOUNT;
        m9478t();
        if (this.f11849H != null) {
            this.f11849H.m9633a();
        }
        this.f11847F.m9428b(this.f11870aP);
    }

    /* renamed from: s */
    public void m9479s() {
        m9473y();
        this.f11842A.a(AbstractC2390c.EnumC2400a.Normal);
        m9537a(false);
        m9555N();
        m9492l();
        this.f11847F.m9426b(getString(C2300R.C2303string.fault_camera));
        this.f11847F.m9437a(CameraMountState.DISMOUNT);
        this.f11870aP = CameraMountState.DISMOUNT;
        m9478t();
        if (this.f11849H != null) {
            this.f11849H.m9624b();
        }
        this.f11847F.m9428b(this.f11870aP);
    }

    /* renamed from: t */
    public void m9478t() {
        if (!C2367d.m12459a().m12438k() || !this.f11916u.mo11216ac() || this.f11870aP != CameraMountState.MOUNT || this.f11921z != EnumC3145c.CAMER) {
            this.f11884am.setClickable(false);
            this.f11884am.setAlpha((int) (0.5f * 255.0f));
            return;
        }
        this.f11884am.setClickable(true);
        this.f11884am.setAlpha(255);
    }

    /* renamed from: u */
    public boolean m9477u() {
        C3680i c3680i = new C3680i(C2353b.f7942af);
        c3680i.start();
        try {
            c3680i.join(500L);
        } catch (Exception e) {
        }
        return c3680i.m7484a() != null;
    }

    /* renamed from: v */
    public void m9476v() {
        this.f11847F.m9404s();
        this.f11842A.a((AbstractC2386d) null);
        this.f11842A.r();
    }

    /* renamed from: w */
    public void m9475w() {
        this.f11842A.m12233u().m12296b();
    }

    /* renamed from: x */
    public void m9474x() {
        ((FlightActivity) getActivity()).m8876g();
        if (this.f11842A.e()) {
            this.f11842A.m12233u().m12296b();
        }
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b != null && c3580b.m7935m() > 0 && c3580b.m7935m() < 1063 && this.f11870aP == CameraMountState.MOUNT) {
            C2284z.m12694a(this.f11915t, this.f11915t.getString(C2300R.C2303string.camera_menu_update_tip), C2284z.f7606b);
            return;
        }
        this.f11858aD = ((FlightActivity) getActivity()).m8878f();
        this.f11885an = new View$OnClickListenerC3047e(getActivity(), this.f11871aQ, this.f11858aD);
        this.f11885an.m9854b(new String[]{this.f11842A.j().getAe_bias(), this.f11842A.j().getSaturation(), this.f11842A.j().getContrast(), this.f11842A.j().getSharpness(), this.f11842A.j().getAwb()});
    }

    /* renamed from: y */
    public void m9473y() {
        if (this.f11885an != null) {
            this.f11885an.m9855b();
        }
    }

    /* renamed from: z */
    public void m9472z() {
        m9473y();
    }
}
