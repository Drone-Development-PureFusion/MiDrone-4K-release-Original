package com.fimi.soul.drone;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.droneconnection.connection.C2796d;
import com.fimi.soul.drone.droneconnection.connection.C2804g;
import com.fimi.soul.drone.p193d.AbstractC2682a;
import com.fimi.soul.drone.p203i.C2870aa;
import com.fimi.soul.drone.p203i.C2871ab;
import com.fimi.soul.drone.p203i.C2872ac;
import com.fimi.soul.drone.p203i.C2873ad;
import com.fimi.soul.drone.p203i.C2874ae;
import com.fimi.soul.drone.p203i.C2875af;
import com.fimi.soul.drone.p203i.C2876ag;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2878ai;
import com.fimi.soul.drone.p203i.C2879aj;
import com.fimi.soul.drone.p203i.C2880ak;
import com.fimi.soul.drone.p203i.C2881al;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.drone.p203i.C2883an;
import com.fimi.soul.drone.p203i.C2884ao;
import com.fimi.soul.drone.p203i.C2885ap;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2887ar;
import com.fimi.soul.drone.p203i.C2888as;
import com.fimi.soul.drone.p203i.C2889at;
import com.fimi.soul.drone.p203i.C2890au;
import com.fimi.soul.drone.p203i.C2891av;
import com.fimi.soul.drone.p203i.C2892aw;
import com.fimi.soul.drone.p203i.C2893ax;
import com.fimi.soul.drone.p203i.C2894ay;
import com.fimi.soul.drone.p203i.C2895az;
import com.fimi.soul.drone.p203i.C2897ba;
import com.fimi.soul.drone.p203i.C2898bb;
import com.fimi.soul.drone.p203i.C2899bc;
import com.fimi.soul.drone.p203i.C2900bd;
import com.fimi.soul.drone.p203i.C2901be;
import com.fimi.soul.drone.p203i.C2902bf;
import com.fimi.soul.drone.p203i.C2903bg;
import com.fimi.soul.drone.p203i.C2904bh;
import com.fimi.soul.drone.p203i.C2905bi;
import com.fimi.soul.drone.p203i.C2906bj;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2909d;
import com.fimi.soul.drone.p203i.C2910e;
import com.fimi.soul.drone.p203i.C2911f;
import com.fimi.soul.drone.p203i.C2912g;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2927k;
import com.fimi.soul.drone.p203i.C2928l;
import com.fimi.soul.drone.p203i.C2929m;
import com.fimi.soul.drone.p203i.C2930n;
import com.fimi.soul.drone.p203i.C2931o;
import com.fimi.soul.drone.p203i.C2932p;
import com.fimi.soul.drone.p203i.C2934r;
import com.fimi.soul.drone.p203i.C2935s;
import com.fimi.soul.drone.p203i.C2936t;
import com.fimi.soul.drone.p203i.C2937u;
import com.fimi.soul.drone.p203i.C2938v;
import com.fimi.soul.drone.p203i.C2939w;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.drone.p203i.C2941y;
import com.fimi.soul.drone.p203i.C2942z;
import com.fimi.soul.drone.p203i.p204a.C2861a;
import com.fimi.soul.drone.p203i.p204a.C2863b;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.drone.p203i.p204a.C2865d;
import com.fimi.soul.drone.p203i.p204a.C2867f;
import com.fimi.soul.drone.p203i.p204a.C2869h;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3707w;
import com.fimi.soul.utils.C3709x;
import com.fimi.soul.utils.FlyLogTools;
import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.fimi.soul.drone.a */
/* loaded from: classes.dex */
public class C2657a implements AbstractC2675c {

    /* renamed from: Z */
    private final C2804g.AbstractC2805a f9227Z;

    /* renamed from: aL */
    private C2660b f9240aL;

    /* renamed from: ac */
    private boolean f9244ac;

    /* renamed from: ag */
    private AMap f9248ag;

    /* renamed from: ah */
    private boolean f9249ah;

    /* renamed from: ak */
    private boolean f9252ak;

    /* renamed from: an */
    private boolean f9255an;

    /* renamed from: ao */
    private C2913h f9256ao;

    /* renamed from: ap */
    private LatLng f9257ap;

    /* renamed from: aq */
    private float f9258aq;

    /* renamed from: ar */
    private boolean f9259ar;

    /* renamed from: as */
    private int f9260as;

    /* renamed from: at */
    private Location f9261at;

    /* renamed from: au */
    private boolean f9262au;

    /* renamed from: b */
    FlyLogTools f9268b;

    /* renamed from: c */
    public AbstractC2682a f9269c;

    /* renamed from: d */
    public Context f9270d;

    /* renamed from: e */
    private final C2671b f9271e;

    /* renamed from: ad */
    private double f9245ad = 0.0d;

    /* renamed from: ae */
    private long f9246ae = 0;

    /* renamed from: af */
    private long f9247af = 0;

    /* renamed from: ai */
    private boolean f9250ai = true;

    /* renamed from: aj */
    private double f9251aj = 0.0d;

    /* renamed from: a */
    SharedPreferences f9228a = null;

    /* renamed from: aG */
    private boolean f9235aG = false;

    /* renamed from: aM */
    private volatile EnumC2659a f9241aM = EnumC2659a.normal;

    /* renamed from: f */
    private final C2871ab f9272f = new C2871ab(this);

    /* renamed from: g */
    private final C2929m f9273g = new C2929m(this);

    /* renamed from: h */
    private final C2891av f9274h = new C2891av(this);

    /* renamed from: i */
    private final C2892aw f9275i = new C2892aw(this);

    /* renamed from: j */
    private final C2889at f9276j = new C2889at(this);

    /* renamed from: k */
    private final C2899bc f9277k = new C2899bc(this);

    /* renamed from: l */
    private final C2890au f9278l = new C2890au(this);

    /* renamed from: m */
    private final C2876ag f9279m = new C2876ag(this);

    /* renamed from: n */
    private final C2872ac f9280n = new C2872ac(this);

    /* renamed from: o */
    private final C2888as f9281o = new C2888as(this);

    /* renamed from: p */
    private final C2886aq f9282p = new C2886aq(this);

    /* renamed from: q */
    private final C2877ah f9283q = new C2877ah(this);

    /* renamed from: r */
    private final C2909d f9284r = new C2909d(this);

    /* renamed from: s */
    private final C2878ai f9285s = new C2878ai(this);

    /* renamed from: t */
    private final C2879aj f9286t = new C2879aj(this);

    /* renamed from: u */
    private final C2879aj f9287u = new C2879aj(this);

    /* renamed from: v */
    private final C2880ak f9288v = new C2880ak(this);

    /* renamed from: w */
    private final C2880ak f9289w = new C2880ak(this);

    /* renamed from: x */
    private final C2928l f9290x = new C2928l(this);

    /* renamed from: y */
    private final C2928l f9291y = new C2928l(this);

    /* renamed from: z */
    private final C2865d f9292z = new C2865d(this);

    /* renamed from: A */
    private final C2870aa f9202A = new C2870aa(this);

    /* renamed from: B */
    private final C2869h f9203B = new C2869h(this);

    /* renamed from: C */
    private final C2910e f9204C = new C2910e(this);

    /* renamed from: D */
    private final C2901be f9205D = new C2901be(this);

    /* renamed from: E */
    private final C2941y f9206E = new C2941y(this);

    /* renamed from: F */
    private final C2885ap f9207F = new C2885ap(this);

    /* renamed from: G */
    private final C2897ba f9208G = new C2897ba(this);

    /* renamed from: H */
    private final C2942z f9209H = new C2942z(this);

    /* renamed from: I */
    private final C2898bb f9210I = new C2898bb(this);

    /* renamed from: J */
    private final C2894ay f9211J = new C2894ay(this);

    /* renamed from: K */
    private final C2908c f9212K = new C2908c(this);

    /* renamed from: L */
    private final C2900bd f9213L = new C2900bd(this);

    /* renamed from: M */
    private final C2906bj f9214M = new C2906bj(this);

    /* renamed from: N */
    private final C2905bi f9215N = new C2905bi(this);

    /* renamed from: O */
    private final C2904bh f9216O = new C2904bh(this);

    /* renamed from: P */
    private final C2902bf f9217P = new C2902bf(this);

    /* renamed from: Q */
    private final C2903bg f9218Q = new C2903bg(this);

    /* renamed from: T */
    private final C2875af f9221T = new C2875af(this);

    /* renamed from: U */
    private final C2883an f9222U = new C2883an(this);

    /* renamed from: aa */
    private C2912g f9242aa = new C2912g(this);

    /* renamed from: R */
    private final C2893ax f9219R = new C2893ax(this);

    /* renamed from: S */
    private final C2895az f9220S = new C2895az(this);

    /* renamed from: ab */
    private C2940x f9243ab = new C2940x(this);

    /* renamed from: al */
    private C2930n f9253al = new C2930n(this);

    /* renamed from: aw */
    private C2864c f9264aw = new C2864c(this);

    /* renamed from: av */
    private C2927k f9263av = new C2927k(this);

    /* renamed from: am */
    private final C2867f f9254am = new C2867f(this);

    /* renamed from: V */
    private final C2873ad f9223V = new C2873ad(this);

    /* renamed from: W */
    private final C2874ae f9224W = new C2874ae(this);

    /* renamed from: X */
    private final C2881al f9225X = new C2881al(this);

    /* renamed from: ax */
    private C2882am f9265ax = new C2882am(this);

    /* renamed from: ay */
    private C2884ao f9266ay = new C2884ao(this);

    /* renamed from: aD */
    private C2931o f9232aD = new C2931o(this);

    /* renamed from: aF */
    private C2861a f9234aF = new C2861a(this);

    /* renamed from: aA */
    private C2938v f9229aA = new C2938v(this);

    /* renamed from: az */
    private C2934r f9267az = new C2934r(this);

    /* renamed from: Y */
    private final C2887ar f9226Y = new C2887ar(this);

    /* renamed from: aE */
    private C2932p f9233aE = new C2932p();

    /* renamed from: aB */
    private C2911f f9230aB = new C2911f();

    /* renamed from: aC */
    private C2939w f9231aC = new C2939w();

    /* renamed from: aH */
    private C2936t f9236aH = new C2936t(this);

    /* renamed from: aI */
    private C2937u f9237aI = new C2937u(this);

    /* renamed from: aJ */
    private C2935s f9238aJ = new C2935s(this);

    /* renamed from: aK */
    private C2863b f9239aK = new C2863b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.drone.a$a */
    /* loaded from: classes.dex */
    public enum EnumC2659a {
        normal,
        inSky,
        onLand,
        disCon
    }

    /* renamed from: com.fimi.soul.drone.a$b */
    /* loaded from: classes.dex */
    class C2660b extends TimerTask {
        C2660b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2657a.this.f9268b.m7773a((FlyLogTools.AbstractC3620a) null);
        }
    }

    public C2657a(C2804g.AbstractC2805a abstractC2805a, Context context, Handler handler) {
        this.f9270d = context;
        this.f9227Z = abstractC2805a;
        this.f9271e = new C2671b(this, handler);
        this.f9268b = FlyLogTools.m7776a(context);
        Timer timer = new Timer();
        if (this.f9240aL == null) {
            this.f9240aL = new C2660b();
        }
        timer.schedule(this.f9240aL, 5000L, 180000L);
    }

    /* renamed from: a */
    private void m11343a(long j, double d) {
        C3707w m7410a = C3707w.m7410a(this.f9270d);
        C3709x c3709x = new C3709x();
        c3709x.m7404a(d);
        c3709x.m7403a(j / 1000);
        c3709x.m7399b(C2353b.m12507c(this.f9270d).getUserID());
        c3709x.m7396c(C3579a.m7971a().m7970a(0).m7905i());
        c3709x.m7402a(C2367d.m12459a().m12438k() ? "1" : "0");
        c3709x.m7400b(mo11202w().m10499f());
        c3709x.m7397c(mo11202w().m10500e());
        m7410a.m7409a(c3709x);
    }

    /* renamed from: a */
    private void m11342a(long j, long j2) {
        if (j > 1800000) {
            return;
        }
        m11343a(j, this.f9251aj);
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: A */
    public C2879aj mo11246A() {
        return this.f9286t;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: B */
    public C2879aj mo11245B() {
        return this.f9287u;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: C */
    public C2880ak mo11244C() {
        return this.f9288v;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: D */
    public C2880ak mo11243D() {
        return this.f9289w;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: E */
    public C2928l mo11242E() {
        return this.f9290x;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: F */
    public C2928l mo11241F() {
        return this.f9291y;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: G */
    public C2865d mo11240G() {
        return this.f9292z;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: H */
    public C2870aa mo11239H() {
        return this.f9202A;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: I */
    public C2869h mo11238I() {
        return this.f9203B;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: J */
    public C2910e mo11237J() {
        return this.f9204C;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: K */
    public C2901be mo11236K() {
        return this.f9205D;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: L */
    public C2941y mo11235L() {
        return this.f9206E;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: M */
    public C2885ap mo11234M() {
        return this.f9207F;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: N */
    public C2897ba mo11233N() {
        return this.f9208G;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: O */
    public C2942z mo11232O() {
        return this.f9209H;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: P */
    public C2898bb mo11231P() {
        return this.f9210I;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: Q */
    public C2894ay mo11230Q() {
        return this.f9211J;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: R */
    public C2908c mo11229R() {
        return this.f9212K;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: S */
    public C2900bd mo11228S() {
        return this.f9213L;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: T */
    public C2906bj mo11227T() {
        return this.f9214M;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: U */
    public C2905bi mo11226U() {
        return this.f9215N;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: V */
    public C2904bh mo11225V() {
        return this.f9216O;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: W */
    public C2902bf mo11224W() {
        return this.f9217P;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: X */
    public C2903bg mo11223X() {
        return this.f9218Q;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: Y */
    public C2875af mo11222Y() {
        return this.f9221T;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: Z */
    public C2883an mo11221Z() {
        return this.f9222U;
    }

    /* renamed from: a */
    public C2913h m11346a() {
        return this.f9256ao;
    }

    /* renamed from: a */
    public void m11345a(float f) {
        this.f9258aq = f;
    }

    /* renamed from: a */
    public void m11344a(int i) {
        this.f9253al.m10213a(this.f9270d.getResources().getString(i));
    }

    /* renamed from: a */
    public void m11341a(Location location) {
        this.f9261at = location;
    }

    /* renamed from: a */
    public void m11340a(AMap aMap) {
        this.f9248ag = aMap;
    }

    /* renamed from: a */
    public void m11339a(LatLng latLng) {
        this.f9257ap = latLng;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: a */
    public void mo11220a(C2678d.EnumC2679a enumC2679a) {
        this.f9271e.m11252a(enumC2679a);
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: a */
    public void mo11219a(C2678d.AbstractC2680b abstractC2680b) {
        this.f9271e.m11251a(abstractC2680b);
    }

    /* renamed from: a */
    public void m11338a(C2864c c2864c) {
        this.f9264aw = c2864c;
    }

    /* renamed from: a */
    public void m11337a(C2913h c2913h) {
        this.f9256ao = c2913h;
    }

    /* renamed from: a */
    public void m11336a(C2927k c2927k) {
        this.f9263av = c2927k;
    }

    /* renamed from: a */
    public void m11335a(boolean z) {
        this.f9262au = z;
    }

    /* renamed from: aA */
    public C2887ar m11334aA() {
        return this.f9226Y;
    }

    /* renamed from: aB */
    public C2932p m11333aB() {
        return this.f9233aE;
    }

    /* renamed from: aC */
    public boolean m11332aC() {
        return this.f9235aG;
    }

    /* renamed from: aD */
    public C2936t m11331aD() {
        return this.f9236aH;
    }

    /* renamed from: aE */
    public C2937u m11330aE() {
        return this.f9237aI;
    }

    /* renamed from: aF */
    public C2935s m11329aF() {
        return this.f9238aJ;
    }

    /* renamed from: aG */
    public C2863b m11328aG() {
        return this.f9239aK;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: aa */
    public C2874ae mo11218aa() {
        return this.f9224W;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: ab */
    public C2804g.AbstractC2805a mo11217ab() {
        return this.f9227Z;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: ac */
    public boolean mo11216ac() {
        return this.f9259ar;
    }

    /* renamed from: ad */
    public void m11327ad() {
        if (this.f9249ah) {
            this.f9241aM = EnumC2659a.disCon;
            m11321ak();
        }
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: ae */
    public boolean mo11215ae() {
        return C2367d.m12459a().m12436m();
    }

    /* renamed from: af */
    public C2912g m11326af() {
        return this.f9242aa;
    }

    /* renamed from: ag */
    public C2893ax m11325ag() {
        return this.f9219R;
    }

    /* renamed from: ah */
    public C2895az m11324ah() {
        return this.f9220S;
    }

    /* renamed from: ai */
    public AMap m11323ai() {
        return this.f9248ag;
    }

    /* renamed from: aj */
    public void m11322aj() {
        this.f9241aM = EnumC2659a.normal;
    }

    /* renamed from: ak */
    public void m11321ak() {
        C2796d.m10980a();
        switch (this.f9241aM) {
            case inSky:
                if (this.f9250ai) {
                    this.f9245ad = System.currentTimeMillis();
                    this.f9250ai = false;
                }
                if (System.currentTimeMillis() - this.f9247af < 1000) {
                    return;
                }
                this.f9247af = System.currentTimeMillis();
                this.f9251aj = Math.abs(C2275t.m12793a(mo11205t().m10644a() / 100.0d, 1)) + this.f9251aj;
                return;
            case disCon:
            case onLand:
                if (this.f9245ad <= 0.0d) {
                    return;
                }
                this.f9246ae = (long) (System.currentTimeMillis() - this.f9245ad);
                m11342a(this.f9246ae, (long) this.f9251aj);
                this.f9245ad = 0.0d;
                this.f9251aj = 0.0d;
                this.f9250ai = true;
                return;
            default:
                return;
        }
    }

    /* renamed from: al */
    public boolean m11320al() {
        return this.f9249ah;
    }

    /* renamed from: am */
    public boolean m11319am() {
        return this.f9241aM == EnumC2659a.onLand;
    }

    /* renamed from: an */
    public C2940x m11318an() {
        return this.f9243ab;
    }

    /* renamed from: ao */
    public float m11317ao() {
        return this.f9258aq;
    }

    /* renamed from: ap */
    public boolean m11316ap() {
        return this.f9252ak;
    }

    /* renamed from: aq */
    public String m11315aq() {
        return this.f9253al.m10214a();
    }

    /* renamed from: ar */
    public C2671b m11314ar() {
        return this.f9271e;
    }

    /* renamed from: as */
    public LatLng m11313as() {
        return this.f9257ap;
    }

    /* renamed from: at */
    public C2867f m11312at() {
        return this.f9254am;
    }

    /* renamed from: au */
    public C2873ad m11311au() {
        return this.f9223V;
    }

    /* renamed from: av */
    public C2881al m11310av() {
        return this.f9225X;
    }

    /* renamed from: aw */
    public boolean m11309aw() {
        return this.f9244ac;
    }

    /* renamed from: ax */
    public int m11308ax() {
        return this.f9260as;
    }

    /* renamed from: ay */
    public boolean m11307ay() {
        return this.f9255an;
    }

    /* renamed from: az */
    public C2861a m11306az() {
        return this.f9234aF;
    }

    /* renamed from: b */
    public Location m11305b() {
        return this.f9261at;
    }

    /* renamed from: b */
    public void m11304b(int i) {
        this.f9260as = i;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: b */
    public void mo11214b(C2678d.AbstractC2680b abstractC2680b) {
        this.f9271e.m11249b(abstractC2680b);
    }

    /* renamed from: b */
    public void m11303b(boolean z) {
        this.f9259ar = z;
    }

    /* renamed from: c */
    public void m11301c(boolean z) {
        this.f9249ah = z;
        if (z) {
            this.f9241aM = EnumC2659a.inSky;
        } else {
            this.f9241aM = EnumC2659a.onLand;
        }
        m11321ak();
    }

    /* renamed from: c */
    public boolean m11302c() {
        return this.f9262au;
    }

    /* renamed from: d */
    public C2934r m11300d() {
        return this.f9267az;
    }

    /* renamed from: d */
    public void m11299d(boolean z) {
        this.f9252ak = z;
    }

    /* renamed from: e */
    public C2884ao m11298e() {
        return this.f9266ay;
    }

    /* renamed from: e */
    public void m11297e(boolean z) {
        this.f9244ac = z;
    }

    /* renamed from: f */
    public C2938v m11296f() {
        return this.f9229aA;
    }

    /* renamed from: f */
    public void m11295f(boolean z) {
        this.f9255an = z;
    }

    /* renamed from: g */
    public C2911f m11294g() {
        return this.f9230aB;
    }

    /* renamed from: g */
    public void m11293g(boolean z) {
        this.f9235aG = z;
    }

    /* renamed from: h */
    public C2939w m11292h() {
        return this.f9231aC;
    }

    /* renamed from: i */
    public C2882am m11291i() {
        return this.f9265ax;
    }

    /* renamed from: j */
    public C2864c m11290j() {
        return this.f9264aw;
    }

    /* renamed from: k */
    public C2927k m11289k() {
        return this.f9263av;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: l */
    public C2871ab mo11213l() {
        return this.f9272f;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: m */
    public C2929m mo11212m() {
        return this.f9273g;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: n */
    public C2891av mo11211n() {
        return this.f9274h;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: o */
    public C2892aw mo11210o() {
        return this.f9275i;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: p */
    public C2889at mo11209p() {
        return this.f9276j;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: q */
    public C2899bc mo11208q() {
        return this.f9277k;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: r */
    public C2931o mo11207r() {
        return this.f9232aD;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: s */
    public C2890au mo11206s() {
        return this.f9278l;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: t */
    public C2876ag mo11205t() {
        return this.f9279m;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: u */
    public C2872ac mo11204u() {
        return this.f9280n;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: v */
    public C2888as mo11203v() {
        return this.f9281o;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: w */
    public C2886aq mo11202w() {
        return this.f9282p;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: x */
    public C2877ah mo11201x() {
        return this.f9283q;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: y */
    public C2909d mo11200y() {
        return this.f9284r;
    }

    @Override // com.fimi.soul.drone.AbstractC2675c
    /* renamed from: z */
    public C2878ai mo11199z() {
        return this.f9285s;
    }
}
