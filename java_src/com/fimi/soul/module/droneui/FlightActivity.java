package com.fimi.soul.module.droneui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.widget.DrawerLayout;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2276u;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p169b.C2370a;
import com.fimi.soul.biz.p178g.C2457h;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2565h;
import com.fimi.soul.biz.p185n.C2582p;
import com.fimi.soul.biz.p185n.C2611y;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.droneconnection.connection.C2779b;
import com.fimi.soul.drone.p193d.p194a.p195a.C2729br;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.HistoryPushMessage;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.media.player.FimiMediaPlayer;
import com.fimi.soul.module.droneFragment.CameraFullScreenShowLeadFragment;
import com.fimi.soul.module.droneFragment.DroneTakePhotoFragment;
import com.fimi.soul.module.droneFragment.FlyActionSettingFragment;
import com.fimi.soul.module.droneFragment.ShowDroneControlFragment;
import com.fimi.soul.module.droneFragment.ShowDroneStatusFragment;
import com.fimi.soul.module.droneFragment.ShowDroneStatusLineFragment;
import com.fimi.soul.module.droneFragment.ShowDroneUiFragment;
import com.fimi.soul.module.dronemanage.FlightMapFragment;
import com.fimi.soul.module.insurance.ReceiveInsuranceActivity;
import com.fimi.soul.module.login.FirstLeadFragment;
import com.fimi.soul.module.push.MessageDetailActivity;
import com.fimi.soul.module.setting.C3489d;
import com.fimi.soul.module.setting.MapSettingFragment;
import com.fimi.soul.module.social.WebViewActivity;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.module.update.p210a.C3585g;
import com.fimi.soul.service.CheckCampassCaliService;
import com.fimi.soul.service.RequestVersionService;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.p211a.C3628c;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class FlightActivity extends BaseActivity implements C2678d.AbstractC2680b, ShowDroneUiFragment.AbstractC3146d, FlightMapFragment.AbstractC3229a, FirstLeadFragment.AbstractC3337a, MapSettingFragment.AbstractC3465a {

    /* renamed from: C */
    private static final int f12624C = 123;

    /* renamed from: O */
    private static final int f12625O = 15;

    /* renamed from: c */
    public static final int f12626c = 1000;

    /* renamed from: d */
    public static final int f12627d = 1001;

    /* renamed from: t */
    private static final int f12628t = 1;

    /* renamed from: A */
    private FlyActionSettingFragment f12629A;

    /* renamed from: B */
    private TextView f12630B;

    /* renamed from: E */
    private C2277v f12632E;

    /* renamed from: F */
    private C2779b f12633F;

    /* renamed from: G */
    private C3585g f12634G;

    /* renamed from: K */
    private boolean f12638K;

    /* renamed from: M */
    private boolean f12640M;

    /* renamed from: N */
    private Toast f12641N;

    /* renamed from: a */
    View f12643a;

    /* renamed from: f */
    C3282b f12646f;

    /* renamed from: g */
    private FragmentManager f12647g;

    /* renamed from: h */
    private FlightMapFragment f12648h;

    /* renamed from: i */
    private FirstLeadFragment f12649i;

    /* renamed from: j */
    private CameraFullScreenShowLeadFragment f12650j;

    /* renamed from: k */
    private ShowDroneUiFragment f12651k;

    /* renamed from: l */
    private ShowDroneStatusFragment f12652l;

    /* renamed from: m */
    private ShowDroneStatusLineFragment f12653m;

    /* renamed from: n */
    private DroneTakePhotoFragment f12654n;

    /* renamed from: o */
    private ShowDroneControlFragment f12655o;

    /* renamed from: p */
    private MapSettingFragment f12656p;

    /* renamed from: r */
    private FrameLayout f12658r;

    /* renamed from: s */
    private FrameLayout f12659s;

    /* renamed from: v */
    private ProgressBar f12661v;

    /* renamed from: w */
    private boolean f12662w;

    /* renamed from: x */
    private byte f12663x;

    /* renamed from: y */
    private RelativeLayout f12664y;

    /* renamed from: z */
    private DrawerLayout f12665z;

    /* renamed from: b */
    public EnumC3284c f12644b = EnumC3284c.EarthMap;

    /* renamed from: q */
    private boolean f12657q = false;

    /* renamed from: u */
    private boolean f12660u = true;

    /* renamed from: D */
    private int f12631D = 5;

    /* renamed from: H */
    private int f12635H = -1;

    /* renamed from: I */
    private boolean f12636I = false;

    /* renamed from: J */
    private boolean f12637J = false;

    /* renamed from: L */
    private Handler f12639L = new Handler() { // from class: com.fimi.soul.module.droneui.FlightActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && FlightActivity.this.f12660u) {
                if (C2477h.m12020a(FlightActivity.this.getApplicationContext()).m12022a().get() != 4) {
                    C2284z.m12696a(FlightActivity.this, (int) C2300R.C2303string.updataerror, 3000);
                } else if (((C2423d) C2379b.m12410a().m12394d()).g() != AbstractC2390c.EnumC2400a.Recoding) {
                    C2284z.m12696a(FlightActivity.this, (int) C2300R.C2303string.open_record_error, 3000);
                } else {
                    C2284z.m12696a(FlightActivity.this, (int) C2300R.C2303string.updateLoadtakephotoerror, 3000);
                }
                FlightActivity.this.f12647g.beginTransaction().hide(FlightActivity.this.f12654n).commitAllowingStateLoss();
                FlightActivity.this.m8894a(0);
                FlightActivity.this.f12661v.setVisibility(8);
            } else if (message.what != 123) {
                if (message.what != 15 || !FlightActivity.this.drone.mo11215ae() || !FlightActivity.this.drone.mo11216ac()) {
                    return;
                }
                FlightActivity.this.f12651k.m9537a(true);
            } else if (FlightActivity.this.f12631D <= 0) {
                FlightActivity.this.f12630B.setVisibility(8);
                FlightActivity.this.drone.mo11220a(C2678d.EnumC2679a.CHANGETAKEPHOTOMARKERCOLOR);
            } else {
                sendEmptyMessageDelayed(123, 1000L);
                FlightActivity.this.f12630B.setText(FlightActivity.this.f12631D + "");
                FlightActivity.this.f12630B.setVisibility(0);
                FlightActivity.m8875g(FlightActivity.this);
            }
        }
    };

    /* renamed from: e */
    Timer f12645e = null;

    /* renamed from: P */
    private AbstractC3281a f12642P = new AbstractC3281a() { // from class: com.fimi.soul.module.droneui.FlightActivity.7
        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: a */
        public void mo8857a() {
            FlightActivity.this.f12651k.m9488n();
            FlightActivity.this.m8894a(4);
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: b */
        public void mo8856b() {
            FlightActivity.this.m8894a(0);
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: c */
        public void mo8855c() {
            FlightActivity.this.m8894a(0);
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: d */
        public void mo8854d() {
            FlightActivity.this.m8894a(4);
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: e */
        public void mo8853e() {
            FlightActivity.this.f12651k.m9488n();
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: f */
        public void mo8852f() {
            FlightActivity.this.f12651k.m9486o();
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: g */
        public void mo8851g() {
            FlightActivity.this.m8894a(0);
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: h */
        public void mo8850h() {
            if (FlightActivity.this.f12637J) {
                FlightActivity.this.m8894a(0);
            }
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: i */
        public void mo8849i() {
            if (FlightActivity.this.f12651k.m9482q()) {
                return;
            }
            FlightActivity.this.m8894a(4);
            FlightActivity.this.f12662w = true;
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: j */
        public void mo8848j() {
            FlightActivity.this.f12651k.m9472z();
        }

        @Override // com.fimi.soul.module.droneui.FlightActivity.AbstractC3281a
        /* renamed from: k */
        public void mo8847k() {
            FlightActivity.this.f12651k.m9475w();
        }
    };

    /* renamed from: com.fimi.soul.module.droneui.FlightActivity$a */
    /* loaded from: classes.dex */
    public interface AbstractC3281a {
        /* renamed from: a */
        void mo8857a();

        /* renamed from: b */
        void mo8856b();

        /* renamed from: c */
        void mo8855c();

        /* renamed from: d */
        void mo8854d();

        /* renamed from: e */
        void mo8853e();

        /* renamed from: f */
        void mo8852f();

        /* renamed from: g */
        void mo8851g();

        /* renamed from: h */
        void mo8850h();

        /* renamed from: i */
        void mo8849i();

        /* renamed from: j */
        void mo8848j();

        /* renamed from: k */
        void mo8847k();
    }

    /* renamed from: com.fimi.soul.module.droneui.FlightActivity$b */
    /* loaded from: classes.dex */
    class C3282b extends BroadcastReceiver {
        C3282b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("rtsp", -1);
            if (intExtra == 0 && FlightActivity.this.f12645e != null) {
                FlightActivity.this.f12645e.cancel();
                FlightActivity.this.f12645e = null;
            } else if (intExtra != 1) {
            } else {
                if (FlightActivity.this.f12645e == null) {
                    FlightActivity.this.f12645e = new Timer();
                }
                FlightActivity.this.f12645e.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneui.FlightActivity.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        FlightActivity.this.f12639L.sendEmptyMessageDelayed(15, 3000L);
                    }
                }, 1000L, 5000L);
            }
        }
    }

    /* renamed from: com.fimi.soul.module.droneui.FlightActivity$c */
    /* loaded from: classes.dex */
    public enum EnumC3284c {
        EarthMap,
        Camera
    }

    /* renamed from: a */
    private synchronized void m8888a(boolean z) {
        if (z) {
            if (!C2277v.m12784a(this).m12741t()) {
                C2277v.m12784a(this).m12757g(true);
                if (this.f12650j == null) {
                    this.f12650j = new CameraFullScreenShowLeadFragment();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isOpen", true);
                this.f12650j.setArguments(bundle);
                this.f12647g.beginTransaction().add(C2300R.C2302id.camera_full_screen_layout, this.f12650j).commit();
            }
        } else if (!C2277v.m12784a(this).m12740u()) {
            C2277v.m12784a(this).m12754h(true);
            if (this.f12650j == null) {
                this.f12650j = new CameraFullScreenShowLeadFragment();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isOpen", false);
            this.f12650j.setArguments(bundle2);
            this.f12647g.beginTransaction().add(C2300R.C2302id.camera_full_screen_layout, this.f12650j).commit();
        }
    }

    /* renamed from: c */
    private void m8884c(int i) {
        if (!this.f12661v.isShown()) {
            this.f12661v.setVisibility(0);
            if (this.f12639L.hasMessages(1)) {
                this.f12639L.removeMessages(1);
            }
            this.f12660u = true;
            if (C2472d.m12036p().m12042j().size() < 1) {
                this.f12639L.sendEmptyMessageDelayed(1, i);
            } else {
                this.f12639L.sendEmptyMessageDelayed(1, C2472d.m12036p().m12042j().size() * 2000);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ int m8875g(FlightActivity flightActivity) {
        int i = flightActivity.f12631D;
        flightActivity.f12631D = i - 1;
        return i;
    }

    /* renamed from: p */
    private void m8864p() {
        boolean m12438k = C2367d.m12459a().m12438k();
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        int m7959a = c3580b != null ? c3580b.m7959a() : 0;
        if (m12438k || m7959a >= C3489d.f13754g) {
            C3489d.m8302a(this.drone).m8304a();
        }
    }

    /* renamed from: q */
    private void m8863q() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.droneui.FlightActivity.2
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(C3658ar.m7568n(FlightActivity.this.getApplicationContext()));
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        String str = C3681j.m7457v() + C3587b.f14553V;
                        InputStream fileInputStream = FlightActivity.this.m8890a(str) ? new FileInputStream(str) : FlightActivity.this.getAssets().open("NoFlyZone-V1.0.0-DB.sqlite");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                fileInputStream.close();
                                return;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: r */
    private void m8862r() {
    }

    /* renamed from: s */
    private void m8861s() {
        if (!this.f12664y.isShown()) {
            this.f12664y.setVisibility(0);
            this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
            if (this.f12654n.isVisible()) {
                this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
            }
            this.drone.mo11220a(C2678d.EnumC2679a.HIDEDISPLAYCIRCLE);
        }
    }

    /* renamed from: t */
    private void m8860t() {
        if (this.f12640M) {
            this.f12641N.cancel();
            finish();
            Process.killProcess(Process.myPid());
            this.f12651k.m9496j();
            return;
        }
        this.f12640M = true;
        this.f12641N = Toast.makeText(getApplicationContext(), (int) C2300R.C2303string.again_exit, 0);
        this.f12641N.show();
        getHandler().sendEmptyMessageDelayed(0, 2000L);
    }

    /* renamed from: u */
    private void m8859u() {
        C2565h.m11668a(this).m11667a(new AbstractC2538k() { // from class: com.fimi.soul.module.droneui.FlightActivity.6
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
                if (planeMsg.isSuccess()) {
                    final HistoryPushMessage historyPushMessage = (HistoryPushMessage) planeMsg.getData();
                    historyPushMessage.setTime(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
                    C3628c m7748a = C3628c.m7748a(FlightActivity.this);
                    if (m7748a.m7746b(historyPushMessage)) {
                        return;
                    }
                    m7748a.m7747a(historyPushMessage);
                    new DialogC3800f.C3801a(FlightActivity.this).m7031a(historyPushMessage.getTitle()).m7025b(historyPushMessage.getPayload()).m7034a(FlightActivity.this.getResources().getColor(C2300R.color.dialog_right_btn)).m7024b(FlightActivity.this.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneui.FlightActivity.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(FlightActivity.this, MessageDetailActivity.class);
                            intent.setFlags(268435456);
                            intent.putExtra("redirectURL", historyPushMessage.getRedirectURL());
                            FlightActivity.this.startActivity(intent);
                        }
                    }).m7020d(17).m7030a(FlightActivity.this.getString(C2300R.C2303string.dialog_close), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneui.FlightActivity.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                }
            }
        });
    }

    /* renamed from: v */
    private boolean m8858v() {
        if (this.f12662w) {
            if ((this.drone.m11312at().m10702e() != 7 && this.drone.m11312at().m10702e() != 8 && this.drone.m11312at().m10702e() != 3 && this.drone.m11312at().m10702e() != 9) || this.f12663x == 7 || this.f12663x == 8 || this.f12663x == 3 || this.f12663x == 9) {
                this.f12638K = false;
            } else {
                this.f12638K = true;
            }
            if (this.drone.m11312at().m10703d() == 1 || this.drone.m11312at().m10703d() == 2 || this.drone.m11312at().m10703d() == 0) {
                if (this.f12635H < 0 || this.f12635H == this.drone.m11312at().m10703d()) {
                    this.f12635H = this.drone.m11312at().m10703d();
                } else {
                    this.f12636I = true;
                }
            }
        } else {
            this.f12663x = this.drone.m11312at().m10702e();
            if (this.drone.m11312at().m10703d() == 1 || this.drone.m11312at().m10703d() == 2 || this.drone.m11312at().m10703d() == 0) {
                this.f12635H = this.drone.m11312at().m10703d();
            } else {
                this.f12635H = -1;
            }
            this.f12636I = false;
            this.f12638K = false;
        }
        C2940x m11318an = this.drone.m11318an();
        if (m11318an.m10121T() || this.drone.m11312at().m10704c() == 3 || this.drone.m11312at().m10707a() == 5) {
            return true;
        }
        if ((this.drone.m11290j() != null && (this.drone.m11290j().m10721b() == 1 || this.drone.m11290j().m10721b() == 3)) || m11318an.m10074m()) {
            return true;
        }
        if ((m11318an.m10081f() && !this.drone.m11312at().m10700g().isLightStream()) || m11318an.m10135F() || m11318an.m10136E() || m11318an.m10133H() || m11318an.m10103ai()) {
            return true;
        }
        return (this.drone.m11312at().m10700g().isLightStream() && m11318an.m10071p()) || m11318an.m10122S() || m11318an.m10123R() || m11318an.m10117X() || this.f12638K || this.f12636I;
    }

    @Override // com.fimi.soul.module.droneFragment.ShowDroneUiFragment.AbstractC3146d
    /* renamed from: a */
    public void mo8895a() {
        if (this.f12656p != null) {
            this.f12656p.m8386j();
            this.f12656p.m8384k();
            this.f12647g.beginTransaction().show(this.f12656p).commit();
        }
    }

    /* renamed from: a */
    public void m8894a(int i) {
        this.f12651k.m9535b(i);
        this.f12658r.setVisibility(i);
        this.f12659s.setVisibility(i);
    }

    /* renamed from: a */
    public void m8893a(EnumC3284c enumC3284c) {
        this.f12644b = enumC3284c;
    }

    @Override // com.fimi.soul.module.dronemanage.FlightMapFragment.AbstractC3229a
    /* renamed from: a */
    public void mo8889a(List<C2907bk> list) {
    }

    /* renamed from: a */
    public boolean m8890a(String str) {
        String m12743r = C2277v.m12784a(getBaseContext()).m12743r();
        File file = new File(str);
        return file.exists() && C2276u.m12789a(file).equals(m12743r);
    }

    /* renamed from: b */
    public EnumC3284c m8887b() {
        return this.f12644b;
    }

    /* renamed from: b */
    public void m8886b(int i) {
        this.f12651k.m9528c(i);
    }

    @Override // com.fimi.soul.module.setting.MapSettingFragment.AbstractC3465a
    /* renamed from: c */
    public void mo8373c() {
        if (this.f12656p != null) {
            this.f12647g.beginTransaction().hide(this.f12656p).commit();
            if (this.f12651k != null) {
                this.f12651k.onStart();
            }
        }
        if (this.f12648h != null) {
            this.f12648h.m9070a();
        }
        C2457h.m12121b().clear();
    }

    /* renamed from: d */
    public void m8882d() {
        this.f12647g.beginTransaction().hide(this.f12648h).commitAllowingStateLoss();
        this.f12647g.executePendingTransactions();
    }

    /* renamed from: e */
    public void m8880e() {
        this.f12647g.beginTransaction().show(this.f12648h).commitAllowingStateLoss();
    }

    /* renamed from: f */
    public boolean m8878f() {
        return this.f12656p.m8392g();
    }

    /* renamed from: g */
    public void m8876g() {
        if (this.f12634G != null) {
            this.f12634G.m7888b();
        }
    }

    /* renamed from: h */
    public void m8874h() {
        this.f12643a.setVisibility(4);
    }

    /* renamed from: i */
    public void m8872i() {
        this.f12643a.setVisibility(0);
    }

    /* renamed from: j */
    public void m8870j() {
        if (C2238c.m13123e().m12771d()) {
            findViewById(C2300R.C2302id.bottom_state_rl).setVisibility(0);
        } else {
            findViewById(C2300R.C2302id.bottom_state_rl).setVisibility(4);
        }
    }

    /* renamed from: k */
    public void m8868k() {
        if (!C2238c.m13123e().m12767e() || this.f12651k.m9565D()) {
            findViewById(C2300R.C2302id.bottom_state_rl2).setVisibility(4);
        } else {
            findViewById(C2300R.C2302id.bottom_state_rl2).setVisibility(0);
        }
    }

    /* renamed from: l */
    public void m8867l() {
        try {
            int m12745p = C2238c.m13123e().m12745p();
            if (m12745p >= 3) {
                return;
            }
            C2238c.m13123e().m12766e(m12745p + 1);
            DialogC3800f.C3817e c3817e = new DialogC3800f.C3817e(this);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C2300R.C2303string.dialog_emergency_stop_puple_content));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.setting_dialog_force_attitude)), 5, 8, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.setting_dialog_force_attitude)), 9, 16, 33);
            c3817e.m6963a(getString(C2300R.C2303string.dialog_emergency_stop_puple)).m6960b(getResources().getColor(C2300R.color.emergencystoppulp)).m6959b(spannableStringBuilder).m6961a(true).m6967a(C2300R.C2301drawable.img_rc_btn).m6962a(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneui.FlightActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).m6968a().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    public void m8866m() {
        final C2277v c2277v;
        final int m12769d;
        if (C3658ar.m7601b(this) && (m12769d = (c2277v = new C2277v(this)).m12769d("insurance_ret")) < 1 && m12769d > -1) {
            try {
                DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(this);
                c3801a.m7025b(getString(C2300R.C2303string.insurance_content));
                c3801a.m7031a(getString(C2300R.C2303string.insurance_title));
                c3801a.m7020d(17).m7034a(getResources().getColor(C2300R.color.dialog_right_btn)).m7024b(getString(C2300R.C2303string.insurance_confirm), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneui.FlightActivity.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (C3658ar.m7601b(FlightActivity.this)) {
                            c2277v.m12782a("insurance_ret", m12769d + 1);
                            Intent intent = new Intent(FlightActivity.this, WebViewActivity.class);
                            intent.putExtra("url", ReceiveInsuranceActivity.f12938a);
                            intent.putExtra("title", FlightActivity.this.getString(C2300R.C2303string.xiaomi_insurance));
                            FlightActivity.this.startActivity(intent);
                        } else {
                            C2284z.m12696a(FlightActivity.this, (int) C2300R.C2303string.login_result_net, 1000);
                        }
                        dialogInterface.dismiss();
                    }
                }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneui.FlightActivity.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        c2277v.m12782a("insurance_ret", m12769d - 1);
                        dialogInterface.dismiss();
                    }
                }).m7035a().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.fimi.soul.module.login.FirstLeadFragment.AbstractC3337a
    /* renamed from: n */
    public void mo8655n() {
        this.f12647g.beginTransaction().remove(this.f12649i).commit();
    }

    /* renamed from: o */
    public void m8865o() {
        if (!this.drone.mo11216ac() || this.f12657q) {
            return;
        }
        this.f12657q = true;
        new C2611y(this).m11529a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000 && i2 == 1001) {
            this.f12651k.m9484p();
        } else if (!this.f12632E.m12787a().getBoolean(C2353b.f7920K, false)) {
        } else {
            this.f12632E.m12787a().edit().putBoolean(C2353b.f7920K, true).commit();
            if (this.f12632E.m12787a().getBoolean(C2353b.f7918I, false) && this.f12656p != null && !this.f12656p.isHidden()) {
                this.f12647g.beginTransaction().hide(this.f12656p).commit();
            }
            this.f12632E.m12787a().edit().putBoolean(C2353b.f7918I, false).commit();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        this.f12634G = new C3585g(this.drone);
        getWindow().setFlags(128, 128);
        this.dpa.m12521d();
        this.dpa.m12523b(this);
        FimiMediaPlayer.loadLibrariesOnce(null);
        FimiMediaPlayer.native_profileBegin("libfmplayer.so");
        this.f12643a = findViewById(C2300R.C2302id.showStatus);
        setContentView(C2300R.layout.activity_main);
        this.f12632E = C2277v.m12784a(this);
        this.f12630B = (TextView) findViewById(C2300R.C2302id.reciprocal_value);
        this.f12649i = new FirstLeadFragment();
        this.f12649i.m8656a(this);
        this.f12661v = (ProgressBar) findViewById(C2300R.C2302id.progrebar);
        this.f12664y = (RelativeLayout) findViewById(C2300R.C2302id.normal_rla);
        this.f12665z = (DrawerLayout) findViewById(C2300R.C2302id.drawerview);
        this.f12665z.setDrawerLockMode(1);
        this.f12665z.setFocusableInTouchMode(false);
        if (C2582p.m11612a(this).m11610b()) {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 0);
        }
        m8864p();
        this.f12647g = getSupportFragmentManager();
        this.f12654n = (DroneTakePhotoFragment) this.f12647g.findFragmentById(C2300R.C2302id.takephoto);
        if (this.f12654n == null) {
            this.f12654n = new DroneTakePhotoFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.takephoto, this.f12654n, "takephoto").hide(this.f12654n).commitAllowingStateLoss();
        } else {
            this.f12647g.beginTransaction().hide(this.f12654n).commit();
        }
        this.f12629A = (FlyActionSettingFragment) this.f12647g.findFragmentById(C2300R.C2302id.flyaction);
        if (this.f12629A == null) {
            this.f12629A = new FlyActionSettingFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.flyaction, this.f12629A, "fly").hide(this.f12629A).commit();
        } else {
            this.f12647g.beginTransaction().hide(this.f12629A).commit();
        }
        this.f12648h = (FlightMapFragment) this.f12647g.findFragmentById(C2300R.C2302id.mapFragment);
        if (this.f12648h == null) {
            this.f12648h = new FlightMapFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.mapFragment, this.f12648h).commit();
        }
        this.f12653m = (ShowDroneStatusLineFragment) this.f12647g.findFragmentById(C2300R.C2302id.showBasedata);
        if (this.f12653m == null) {
            this.f12653m = new ShowDroneStatusLineFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.showBasedata, this.f12653m).commit();
        }
        this.f12652l = (ShowDroneStatusFragment) this.f12647g.findFragmentById(C2300R.C2302id.showStatus);
        if (this.f12652l == null) {
            this.f12652l = new ShowDroneStatusFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.showStatus, this.f12652l).commit();
        }
        this.f12651k = (ShowDroneUiFragment) this.f12647g.findFragmentById(C2300R.C2302id.handleWapoint);
        if (this.f12651k == null) {
            this.f12651k = new ShowDroneUiFragment();
            this.f12651k.m9544a(this.f12653m, this.f12652l);
            this.f12647g.beginTransaction().add(C2300R.C2302id.handleWapoint, this.f12651k).commit();
        }
        this.f12656p = (MapSettingFragment) this.f12647g.findFragmentById(C2300R.C2302id.activity_general_setting);
        if (this.f12656p == null) {
            this.f12656p = new MapSettingFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.activity_general_setting, this.f12656p).hide(this.f12656p).commit();
        }
        m8863q();
        startService(new Intent(this, CheckCampassCaliService.class));
        if (this.f12632E.m12787a().getInt("curModel", 1) == 1) {
            this.f12647g.beginTransaction().add(C2300R.C2302id.lead_layout, this.f12649i).commit();
        }
        new C2370a(this).m12431a();
        if (C3579a.m7971a().m7970a(0).m7921b() <= 0) {
            startService(new Intent(this, RequestVersionService.class));
        }
        m8859u();
        this.f12655o = (ShowDroneControlFragment) this.f12647g.findFragmentById(C2300R.C2302id.controlfragment);
        this.f12658r = (FrameLayout) findViewById(C2300R.C2302id.showBasedata);
        this.f12659s = (FrameLayout) findViewById(C2300R.C2302id.showStatus);
        this.f12655o.m9646a(this.f12642P);
        this.f12629A.m9667a(this.f12642P);
        this.f12654n.m9675a(this.f12642P);
        this.f12653m.m9595a(this.f12642P);
        this.f12652l.m9628a(this.f12642P);
        this.f12633F = new C2779b();
        this.f12633F.m11012d();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f12633F.m11010d(true);
        if (this.f12651k != null) {
            this.f12651k.m9537a(false);
            this.f12651k.m9476v();
        }
        this.f12634G.m7885e();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case QUITTAKEPHOTOFLY:
                if (this.f12639L.hasMessages(123)) {
                    this.f12639L.removeMessages(123);
                }
                if (this.f12639L.hasMessages(1)) {
                    this.f12639L.removeMessages(1);
                }
                this.f12630B.setVisibility(8);
                this.f12661v.setVisibility(8);
                this.f12660u = false;
                return;
            case ENTRYTAKEPHOTOMODEL:
                if (c2657a.m11306az().m10733j() == 18) {
                    if (!this.f12639L.hasMessages(123)) {
                        this.f12631D = 5;
                    }
                    this.f12639L.sendEmptyMessage(123);
                }
                if (this.f12639L.hasMessages(1)) {
                    this.f12639L.removeMessages(1);
                }
                this.f12661v.setVisibility(8);
                this.f12660u = false;
                return;
            case TAKEPHOTOBACKDATA:
                if (!this.f12664y.isShown()) {
                    this.f12664y.setVisibility(0);
                }
                if (!this.f12654n.isVisible()) {
                    return;
                }
                this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
                m8894a(0);
                return;
            case CLOSEOUTTIMEPROBAR:
                if (this.f12639L.hasMessages(1)) {
                    this.f12639L.removeMessages(1);
                }
                this.f12661v.setVisibility(8);
                this.f12660u = false;
                return;
            case SHOWOUTTIMEPROBAR:
                m8884c(5000);
                return;
            case Remotecontrol:
                if (!this.f12662w || c2657a.mo11215ae()) {
                    return;
                }
                c2657a.mo11220a(C2678d.EnumC2679a.HIDE_FULL_SCREEN);
                return;
            case HEARDATA:
                if (!c2657a.m11312at().m10700g().isExceAction()) {
                    this.f12637J = true;
                    return;
                }
                this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
                c2657a.mo11220a(C2678d.EnumC2679a.HIDEDISPLAYCIRCLE);
                this.f12642P.mo8850h();
                this.f12637J = false;
                return;
            case CANCALFLYACTION:
                this.f12664y.setVisibility(0);
                this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
                this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
                this.f12629A.setUserVisibleHint(true);
                c2657a.mo11220a(C2678d.EnumC2679a.HIDEDISPLAYCIRCLE);
                return;
            case SHOWCAMPASSCALI:
                if (!c2657a.mo11216ac() || !c2657a.m11320al()) {
                }
                return;
            case CLOSEDRAWCONTROLClose:
                this.f12665z.closeDrawer(GravityCompat.END);
                return;
            case CLOSEDRAWCONTROL:
                C2477h m12020a = C2477h.m12020a(getApplicationContext());
                if (!c2657a.m11320al() || m12020a.m12022a().get() == 0) {
                    this.f12664y.setVisibility(0);
                    this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
                    this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
                } else if (c2657a.m11312at().m10700g().judgeNoAction()) {
                    if (m12020a.m12022a().get() == 4) {
                        this.f12647g.beginTransaction().show(this.f12654n).commitAllowingStateLoss();
                    } else {
                        this.f12647g.beginTransaction().show(this.f12629A).commitAllowingStateLoss();
                    }
                }
                this.f12665z.closeDrawer(GravityCompat.END);
                return;
            case OPENDRAWCONTROL:
                this.f12665z.openDrawer(GravityCompat.END);
                return;
            case ChangeCameraOrMap:
                if (this.f12644b == EnumC3284c.Camera) {
                    m8880e();
                    return;
                } else {
                    m8882d();
                    return;
                }
            case CLOSEFLYACTIONFRAGMENT:
                if (!this.f12664y.isShown()) {
                    this.f12664y.setVisibility(0);
                }
                if (this.f12629A.isVisible()) {
                    this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
                    m8894a(0);
                }
                if (!this.f12654n.isVisible()) {
                    return;
                }
                this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
                m8894a(0);
                return;
            case XIAOMI_INSURENCE:
                m8866m();
                return;
            case DRONEINFLOOR:
                m8861s();
                return;
            case SHOWTAKEPHOTOFRAGMENT:
                m8861s();
                return;
            case CLEANALLOBJ:
                m8861s();
                this.f12657q = false;
                return;
            case SHOW_FULL_SCREEN:
                if ((C2477h.m12020a(getApplicationContext()).m12022a().get() != 0 && !c2657a.m11312at().m10700g().isExceAction()) || this.f12651k.m9482q() || m8858v()) {
                    return;
                }
                m8894a(4);
                m8886b(0);
                this.f12662w = true;
                m8888a(false);
                return;
            case HIDE_FULL_SCREEN:
                if (!this.f12662w) {
                    return;
                }
                this.f12662w = false;
                m8894a(0);
                m8886b(4);
                return;
            case SHOW_FULL_SCREEN_LEAD:
                if (C2477h.m12020a(getApplicationContext()).m12022a().get() != 0 && !c2657a.m11312at().m10700g().isExceAction()) {
                    return;
                }
                m8888a(true);
                return;
            case CLOSE_FULL_SCREEN_LEAD:
                if (this.f12650j == null) {
                    return;
                }
                this.f12647g.beginTransaction().remove(this.f12650j).commit();
                return;
            case ERROR_CODE:
                if (!this.f12662w || !m8858v()) {
                    return;
                }
                c2657a.mo11220a(C2678d.EnumC2679a.HIDE_FULL_SCREEN);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        this.f12640M = false;
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12662w) {
                this.f12662w = false;
                m8894a(0);
                m8886b(4);
                return true;
            } else if (this.f12665z.isDrawerOpen(GravityCompat.END)) {
                this.f12665z.closeDrawer(GravityCompat.END);
                return true;
            } else if (this.f12629A != null && this.f12629A.m9665b()) {
                return true;
            } else {
                if (this.f12654n != null && this.f12654n.m9677a()) {
                    return true;
                }
                if (this.f12629A != null && !this.f12629A.isHidden()) {
                    this.f12629A.m9670a();
                    if (!this.f12664y.isShown()) {
                        this.f12664y.setVisibility(0);
                    }
                    if (!this.f12629A.isVisible()) {
                        return true;
                    }
                    this.f12647g.beginTransaction().hide(this.f12629A).commitAllowingStateLoss();
                    return true;
                } else if (this.f12654n == null || this.f12654n.isHidden()) {
                    if (this.f12656p == null || this.f12656p.isHidden()) {
                        m8860t();
                        return false;
                    }
                    if (this.f12656p.m8383m()) {
                        this.f12647g.beginTransaction().hide(this.f12656p).commit();
                    }
                    return false;
                } else {
                    m8894a(0);
                    if (!this.f12664y.isShown()) {
                        this.f12664y.setVisibility(0);
                    }
                    if (!this.f12654n.isVisible()) {
                        return true;
                    }
                    this.f12647g.beginTransaction().hide(this.f12654n).commitAllowingStateLoss();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f12656p == null) {
            this.f12656p = new MapSettingFragment();
            this.f12647g.beginTransaction().add(C2300R.C2302id.activity_general_setting, this.f12656p).hide(this.f12656p).commit();
        }
        if (this.f12651k != null) {
            this.f12651k.m9537a(this.drone.mo11215ae());
        }
        C2457h.m12121b().clear();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.drone.mo11217ab().mo10898a() && this.drone.mo11216ac()) {
            C2729br c2729br = new C2729br();
            c2729br.f9966d = C2760r.f10172a;
            c2729br.f9967e = (byte) 1;
            c2729br.f9968f = (byte) 0;
            this.drone.mo11217ab().mo10897a(c2729br.mo11073b());
        }
        this.f12646f = new C3282b();
        registerReceiver(this.f12646f, new IntentFilter("resetRTSP"));
        C2462a.m12098a().m12091a(getLocalClassName(), 0, this.drone);
        m8865o();
    }

    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        FimiMediaPlayer.native_profileEnd();
        unregisterReceiver(this.f12646f);
        C2244b.m13099b(getApplicationContext()).m13097b(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m8862r();
    }
}
