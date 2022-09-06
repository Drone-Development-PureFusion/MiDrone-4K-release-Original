package com.fimi.soul.biz.update;

import android.content.Context;
import android.os.Message;
import android.support.p001v4.app.FragmentManager;
import android.widget.Toast;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2609x;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.p195a.C2737bz;
import com.fimi.soul.drone.p199e.C2829g;
import com.fimi.soul.drone.p199e.C2837o;
import com.fimi.soul.drone.p199e.C2840r;
import com.fimi.soul.drone.p199e.C2841s;
import com.fimi.soul.drone.p199e.C2842t;
import com.fimi.soul.drone.p202h.C2858f;
import com.fimi.soul.drone.p203i.C2893ax;
import com.fimi.soul.drone.p203i.C2903bg;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2924j;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.entity.UpgradeResultInfo;
import com.fimi.soul.module.dronemanage.C3260m;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.service.InitAppService;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.fimi.soul.biz.update.d */
/* loaded from: classes.dex */
public class C2639d extends AbstractC2636b implements C2678d.AbstractC2680b {

    /* renamed from: A */
    public static C2858f f9141A = null;

    /* renamed from: I */
    private static int f9143I = 0;

    /* renamed from: R */
    private static C2737bz f9144R = null;

    /* renamed from: f */
    static AbstractC2651g f9145f = null;

    /* renamed from: h */
    public static final int f9146h = 300;

    /* renamed from: i */
    public static final int f9147i = -1;

    /* renamed from: j */
    public static final String f9148j = "firmware_info";

    /* renamed from: l */
    public static final String f9150l = "sp_upgrading";

    /* renamed from: m */
    public static final int f9151m = 2;

    /* renamed from: n */
    public static final int f9152n = 3;

    /* renamed from: o */
    public static final int f9153o = 10;

    /* renamed from: p */
    public static final int f9154p = 5;

    /* renamed from: q */
    public static final int f9155q = 9;

    /* renamed from: r */
    public static final int f9156r = 100;

    /* renamed from: s */
    public static final int f9157s = 10;

    /* renamed from: B */
    List<C2858f> f9163B;

    /* renamed from: C */
    C3579a f9164C;

    /* renamed from: D */
    int f9165D;

    /* renamed from: E */
    private Timer f9166E;

    /* renamed from: F */
    private Context f9167F;

    /* renamed from: G */
    private C2657a f9168G;

    /* renamed from: J */
    private FragmentManager f9169J;

    /* renamed from: K */
    private boolean f9170K;

    /* renamed from: L */
    private Timer f9171L;

    /* renamed from: M */
    private long f9172M;

    /* renamed from: N */
    private boolean f9173N;

    /* renamed from: O */
    private int f9174O;

    /* renamed from: P */
    private AbstractC2648c f9175P;

    /* renamed from: Q */
    private int f9176Q;

    /* renamed from: S */
    private int f9177S;

    /* renamed from: g */
    public AbstractC2647b f9178g;

    /* renamed from: t */
    public int f9179t;

    /* renamed from: y */
    public C2423d f9180y;

    /* renamed from: H */
    private static int f9142H = 0;

    /* renamed from: k */
    public static int f9149k = 0;

    /* renamed from: u */
    public static boolean f9158u = false;

    /* renamed from: v */
    public static boolean f9159v = false;

    /* renamed from: w */
    public static boolean f9160w = false;

    /* renamed from: x */
    public static boolean f9161x = false;

    /* renamed from: z */
    static Queue<C2737bz> f9162z = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.update.d$a */
    /* loaded from: classes.dex */
    public class C2646a extends TimerTask {

        /* renamed from: b */
        private C2770c f9190b;

        /* renamed from: c */
        private C2657a f9191c;

        public C2646a(C2770c c2770c, C2657a c2657a) {
            this.f9190b = c2770c;
            this.f9191c = c2657a;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C2639d.m11381p();
            this.f9191c.mo11217ab().mo10897a(this.f9190b);
            if (C2639d.f9142H == 20) {
                if (C2639d.this.f9166E != null) {
                    C2639d.this.f9166E.cancel();
                }
                if (C2639d.f9145f == null) {
                    return;
                }
                C2639d.f9145f.mo6430a(false, 0L, 0L, -1);
            }
        }
    }

    /* renamed from: com.fimi.soul.biz.update.d$b */
    /* loaded from: classes.dex */
    public interface AbstractC2647b {
        /* renamed from: a */
        void mo7977a(int i);

        /* renamed from: a */
        void mo7976a(boolean z);
    }

    /* renamed from: com.fimi.soul.biz.update.d$c */
    /* loaded from: classes.dex */
    public interface AbstractC2648c {
        /* renamed from: a */
        void mo7811a(List<UpdateVersonBean> list);
    }

    public C2639d() {
        this.f9166E = new Timer();
        this.f9179t = 1500;
        this.f9163B = new ArrayList();
        this.f9171L = new Timer();
        this.f9174O = -1;
    }

    public C2639d(Context context, C2657a c2657a) {
        this.f9166E = new Timer();
        this.f9179t = 1500;
        this.f9163B = new ArrayList();
        this.f9171L = new Timer();
        this.f9174O = -1;
        this.f9167F = context;
        this.f9168G = c2657a;
        c2657a.mo11219a(this);
        this.f9180y = (C2423d) C2379b.m12410a().m12394d();
        this.f9164C = C3579a.m7971a();
    }

    /* renamed from: a */
    private void m11406a(byte b) {
        try {
            if (this.f9168G.mo11227T().m10363a() != f9144R.f10025d) {
                return;
            }
            if (f9141A != null) {
                f9141A.m10747e();
            }
            Message message = new Message();
            message.what = 5;
            message.arg1 = f9149k;
            message.arg2 = 300;
            if (this.f9168G.mo11227T().m10363a() != f9143I) {
                this.f9165D = this.f9168G.mo11227T().m10363a();
                a().sendMessage(message);
                if (f9162z.size() <= 0) {
                    return;
                }
                m11398b();
                return;
            }
            this.f9165D = this.f9168G.mo11227T().m10363a();
            a().sendMessage(message);
            f9159v = false;
            this.f9170K = true;
            if (this.f9166E != null) {
                this.f9166E.cancel();
            }
            f9142H = 1;
            C2841s.f10465a.f10043d = b;
            this.f9166E = new Timer();
            this.f9166E.schedule(new C2646a(C2841s.f10465a.mo11073b(), this.f9168G), 100L, 1000L);
        } catch (Exception e) {
            if (f9145f == null) {
                return;
            }
            f9145f.mo6430a(false, 0L, 0L, -1);
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m11396b(C2639d c2639d) {
        int i = c2639d.f9177S;
        c2639d.f9177S = i + 1;
        return i;
    }

    /* renamed from: n */
    public static void m11383n() {
        try {
            final UpgradeResultInfo upgradeResultInfo = (UpgradeResultInfo) C2238c.m13125c().mo13118a("upgradeResultInfo", UpgradeResultInfo.class);
            if (C2238c.m13131a() == null || upgradeResultInfo == null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.fimi.soul.biz.update.d.4
                @Override // java.lang.Runnable
                public void run() {
                    C2609x.m11537a(C2238c.m13131a()).m11535a(new AbstractC2538k() { // from class: com.fimi.soul.biz.update.d.4.1
                        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                        /* renamed from: a */
                        public void mo6501a(PlaneMsg planeMsg, File file) {
                            if (planeMsg.isSuccess()) {
                                C2238c.m13125c().mo13117a("upgradeResultInfo", (Object) "");
                            }
                        }
                    }, UpgradeResultInfo.this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    static /* synthetic */ int m11381p() {
        int i = f9142H;
        f9142H = i + 1;
        return i;
    }

    /* renamed from: r */
    private long m11379r() {
        f9143I = this.f9164C.m7961f().mo7900a();
        f9162z = this.f9164C.m7961f().mo7895b();
        return f9143I;
    }

    /* renamed from: s */
    private void m11378s() {
        f9141A = new C2858f(this.f9179t, new Runnable() { // from class: com.fimi.soul.biz.update.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (C2639d.f9144R != null) {
                    C2639d.this.f9168G.mo11217ab().mo10897a(C2639d.f9144R.mo11073b());
                }
                C2639d.m11396b(C2639d.this);
                if (C2639d.this.f9177S >= 10) {
                    C2639d.this.a().sendEmptyMessage(2);
                }
            }
        });
        if (!this.f9163B.contains(f9141A)) {
            this.f9163B.add(f9141A);
        }
    }

    /* renamed from: a */
    public void m11405a(int i) {
        this.f9164C.m7965b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.biz.update.AbstractC2636b, com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    public void mo9399a(Message message) {
        super.mo9399a(message);
        switch (message.what) {
            case 2:
                if (f9141A != null) {
                    f9141A.m10747e();
                    f9141A.m10746f();
                }
                this.f9177S = 0;
                f9145f.mo6430a(false, 0L, 0L, -1);
                return;
            case 3:
                f9145f.mo6430a(false, 0L, 0L, -1);
                return;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return;
            case 5:
                if (f9145f == null || message.arg2 != 300) {
                    return;
                }
                if (C2241c.m13122a().mo13112b(f9150l) == 5) {
                    f9145f.mo6430a(false, this.f9165D / 2, f9143I, f9149k);
                    return;
                } else {
                    f9145f.mo6430a(false, this.f9165D, f9143I, f9149k);
                    return;
                }
            case 10:
                f9145f.mo6430a(false, 0L, 0L, -1);
                return;
        }
    }

    /* renamed from: a */
    public void m11404a(AbstractC2647b abstractC2647b) {
        this.f9178g = abstractC2647b;
    }

    /* renamed from: a */
    public void m11403a(final AbstractC2648c abstractC2648c) {
        if (InitAppService.m7830a() && C2238c.m13131a() != null) {
            C2609x.m11537a(C2238c.m13131a()).m11532b(new AbstractC2538k() { // from class: com.fimi.soul.biz.update.d.1
                @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                /* renamed from: a */
                public void mo6501a(PlaneMsg planeMsg, File file) {
                    if (planeMsg.isSuccess()) {
                        abstractC2648c.mo7811a((List) planeMsg.getData());
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m11401a(AbstractC2651g abstractC2651g) {
        f9145f = abstractC2651g;
    }

    /* renamed from: a */
    public void m11400a(FirmwareInfo firmwareInfo) {
        this.f9164C.m7969a(firmwareInfo.getSysId(), Integer.valueOf(firmwareInfo.getVersion()).intValue());
        this.f9164C.m7970a(firmwareInfo.getSysId()).m7920b(Integer.valueOf(firmwareInfo.getVersion()).intValue());
    }

    /* renamed from: a */
    public void m11399a(FirmwareInfo firmwareInfo, int i) {
        if (this.f9166E != null) {
            this.f9166E.cancel();
        }
        f9149k = i;
        this.f9179t = 1500;
        this.f9173N = false;
        this.f9174O = -1;
        C2241c.m13122a().mo13120a(f9150l, firmwareInfo.getSysId());
        m11405a(firmwareInfo.getSysId());
        m11397b(firmwareInfo.getSysId());
    }

    /* renamed from: b */
    public void m11398b() {
        f9144R = f9162z.poll();
        if (f9144R == null || f9145f == null) {
            return;
        }
        this.f9168G.mo11217ab().mo10897a(f9144R.mo11073b());
        if (f9141A.m10753b()) {
            return;
        }
        f9141A.m10751c();
    }

    /* renamed from: b */
    public void m11397b(int i) {
        try {
            if (((int) m11379r()) <= 0) {
                Toast.makeText(this.f9167F, this.f9167F.getResources().getString(C2300R.C2303string.firmware_file_not_exist), 1).show();
                return;
            }
            if (this.f9166E != null) {
                this.f9166E.cancel();
                this.f9166E = null;
            }
            f9142H = 1;
            f9161x = false;
            this.f9171L = new Timer();
            C2837o.f10459a.f9714d = (byte) i;
            C2837o.f10459a.f9715e = (byte) 1;
            this.f9168G.mo11217ab().mo10897a(C2837o.f10459a.mo11073b());
            this.f9171L.schedule(new C2646a(C2837o.f10459a.mo11073b(), this.f9168G), 200L, 2000L);
        } catch (Exception e) {
            f9145f.mo6430a(false, 0L, 0L, -1);
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m11395b(UpdateVersonBean updateVersonBean, String str, AbstractC2651g abstractC2651g) {
        a(updateVersonBean, str, abstractC2651g);
    }

    /* renamed from: c */
    public boolean m11394c() {
        if (this.f9168G != null) {
            return this.f9168G.m11320al();
        }
        return false;
    }

    /* renamed from: d */
    public void m11392d() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public String m11388e(UpdateVersonBean updateVersonBean) {
        return d(updateVersonBean);
    }

    /* renamed from: e */
    public void m11390e() {
        if (this.f9166E != null) {
            this.f9166E.cancel();
            this.f9166E = null;
        }
        if (this.f9171L != null) {
            this.f9171L.cancel();
            this.f9171L = null;
        }
        if (f9141A != null) {
            f9141A.m10747e();
            f9141A = null;
        }
        f9145f = null;
        f9149k = 1;
        if (this.f9163B == null || this.f9163B.size() <= 0) {
            return;
        }
        for (C2858f c2858f : this.f9163B) {
            if (c2858f != null) {
                c2858f.m10747e();
                c2858f.m10746f();
            }
        }
    }

    /* renamed from: f */
    public void m11387f() {
        if (f9141A != null) {
            f9141A.m10747e();
        }
        f9141A = null;
    }

    /* renamed from: k */
    public void m11386k() {
        C2829g.f10444a.f9718d = (byte) 1;
        this.f9168G.mo11217ab().mo10897a(C2829g.f10444a.mo11073b());
    }

    /* renamed from: l */
    public void m11385l() {
        this.f9168G.mo11214b(this);
    }

    /* renamed from: m */
    public void m11384m() {
        try {
            UpgradeResultInfo m11371a = C2654j.m11371a(this.f9167F);
            if (m11371a != null) {
                C2238c.m13125c().mo13117a("upgradeResultInfo", m11371a);
            }
            if (C2238c.m13131a() == null) {
                return;
            }
            C2609x.m11537a(C2238c.m13131a()).m11535a(new AbstractC2538k() { // from class: com.fimi.soul.biz.update.d.3
                @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                /* renamed from: a */
                public void mo6501a(PlaneMsg planeMsg, File file) {
                    if (planeMsg.isSuccess()) {
                        C2238c.m13125c().mo13117a("upgradeResultInfo", (Object) "");
                    }
                }
            }, m11371a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        boolean z = false;
        switch (enumC2679a) {
            case RELEASECHAIN:
                C2893ax m11325ag = c2657a.m11325ag();
                if (m11325ag.f10858d != 0) {
                    return;
                }
                if (m11325ag.f10857c == 1 && !f9161x) {
                    f9161x = true;
                    f9142H = 1;
                    if (this.f9171L != null) {
                        this.f9171L.cancel();
                    }
                    this.f9166E = new Timer();
                    C2840r.f10464a.f10016d = (byte) m11325ag.f10856b;
                    C2840r.f10464a.f10017e = (byte) 0;
                    C2840r.f10464a.f10018f = (byte) 1;
                    if (System.currentTimeMillis() - this.f9172M > 800) {
                        c2657a.mo11217ab().mo10897a(C2840r.f10464a.mo11073b());
                        this.f9166E.schedule(new C2646a(C2840r.f10464a.mo11073b(), c2657a), 200L, 2000L);
                    }
                }
                this.f9172M = System.currentTimeMillis();
                if (m11325ag.f10857c != 2 || f9145f == null || f9158u) {
                    return;
                }
                C2842t.f10466a.f10048d = (byte) C2241c.m13122a().mo13112b(f9150l);
                C2842t.f10466a.f10049e = (byte) 1;
                f9158u = true;
                f9142H = 1;
                if (this.f9166E == null) {
                    return;
                }
                this.f9166E.cancel();
                this.f9166E = new Timer();
                this.f9166E.schedule(new C2646a(C2842t.f10466a.mo11073b(), c2657a), 100L, 1000L);
                return;
            case OnRecivedCloudCameraCommandInfo:
                int mo10745a = c2657a.f9269c.mo10745a();
                if (mo10745a == 51) {
                    this.f9180y.j().setDvVersion(((C2924j) c2657a.f9269c).m10239d() + "");
                    return;
                } else if (mo10745a != 50) {
                    return;
                } else {
                    C2913h c2913h = (C2913h) c2657a.f9269c;
                    switch (c2913h.m10286f()) {
                        case UPDATEPRO:
                            if (this.f9178g == null) {
                                return;
                            }
                            this.f9178g.mo7977a(c2913h.m10287e());
                            if (c2913h.m10287e() != 100) {
                                return;
                            }
                            this.f9178g.mo7976a(true);
                            return;
                        case UPDATEFAILE:
                            if (this.f9178g == null) {
                                return;
                            }
                            this.f9178g.mo7976a(false);
                            return;
                        default:
                            return;
                    }
                }
            case UPDATEDRONEORDERREPORT:
                if (!f9161x) {
                    return;
                }
                f9161x = false;
                f9142H = 1;
                if (this.f9166E != null) {
                    this.f9166E.cancel();
                }
                this.f9176Q = c2657a.mo11226U().m10366a();
                if (C2840r.f10464a.f10016d != this.f9176Q) {
                    return;
                }
                byte m10364b = c2657a.mo11226U().m10364b();
                if (m10364b != 0 && m10364b != 4) {
                    f9145f.mo6430a(false, 0L, 0L, -1);
                    return;
                }
                this.f9177S = 0;
                if (f9141A == null) {
                    m11378s();
                    f9141A.m10749d();
                }
                m11398b();
                return;
            case UPDATEDRONEREPORT:
                this.f9177S = 0;
                byte m10361b = c2657a.mo11227T().m10361b();
                if (m10361b != 0 && m10361b != 4) {
                    f9145f.mo6430a(false, 0L, 0L, -1);
                    return;
                }
                this.f9179t = 300;
                m11406a(c2657a.mo11227T().f10907b);
                return;
            case UPDATEDRONEFINISHREPORTCRC:
                C2903bg mo11223X = c2657a.mo11223X();
                f9142H = 0;
                if (this.f9166E != null) {
                    this.f9166E.cancel();
                    this.f9166E = null;
                }
                if (mo11223X.f10900b != 1) {
                    return;
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (f9145f == null) {
                    return;
                }
                if (this.f9170K) {
                    if (C2241c.m13122a().mo13112b(f9150l) == 5) {
                        this.f9173N = true;
                        f9145f.mo6430a(false, f9143I / 2, f9143I, f9149k);
                    } else {
                        f9145f.mo6430a(true, f9143I, f9143I, f9149k);
                    }
                    this.f9170K = false;
                }
                for (int i = 0; i < 4; i++) {
                    C2842t.m10835a(c2657a, 2, C2241c.m13122a().mo13112b(f9150l));
                    m11392d();
                }
                return;
            case UPDATEDRONEFINISHREPORT:
                a().sendEmptyMessage(9);
                C3260m.m8920b();
                f9158u = false;
                f9142H = 1;
                if (f9159v) {
                    return;
                }
                f9159v = true;
                C2837o.f10459a.f9714d = c2657a.mo11224W().f10899c;
                C2837o.f10459a.f9715e = (byte) 2;
                if (this.f9166E != null) {
                    this.f9166E.cancel();
                }
                this.f9166E = new Timer();
                this.f9166E.schedule(new C2646a(C2837o.f10459a.mo11073b(), c2657a), 100L, 1000L);
                return;
            case PowerBatteryProgress:
                if (f9145f == null || C2241c.m13122a().mo13112b(f9150l) != 5 || !this.f9173N || this.f9174O == 100) {
                    return;
                }
                AbstractC2651g abstractC2651g = f9145f;
                if (c2657a.m11334aA().m10496a() == 100) {
                    z = true;
                }
                abstractC2651g.mo6430a(z, (c2657a.m11334aA().m10496a() / 2) + 50, 100L, f9149k);
                this.f9174O = (c2657a.m11334aA().m10496a() / 2) + 50;
                return;
            default:
                return;
        }
    }
}
