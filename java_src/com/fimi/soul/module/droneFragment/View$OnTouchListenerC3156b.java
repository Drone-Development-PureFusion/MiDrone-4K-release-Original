package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.entity.CameraMountState;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.media.player.widget.FimiVideoView;
import com.fimi.soul.module.setting.C3495f;
import com.fimi.soul.utils.C3676e;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.C3689q;
import com.fimi.soul.utils.C3696t;
import com.fimi.soul.view.WriteCamera9Grid;
import java.io.File;
/* renamed from: com.fimi.soul.module.droneFragment.b */
/* loaded from: classes.dex */
public class View$OnTouchListenerC3156b implements View.OnTouchListener, FimiVideoView.OnFimiPreviewCallBackListener {

    /* renamed from: b */
    private FimiVideoView f11984b;

    /* renamed from: c */
    private View f11985c;

    /* renamed from: d */
    private Activity f11986d;

    /* renamed from: e */
    private int f11987e;

    /* renamed from: f */
    private int f11988f;

    /* renamed from: g */
    private View f11989g;

    /* renamed from: h */
    private TextView f11990h;

    /* renamed from: k */
    private WriteCamera9Grid f11993k;

    /* renamed from: p */
    private SharedPreferences f11998p;

    /* renamed from: r */
    private boolean f12000r;

    /* renamed from: s */
    private boolean f12001s;

    /* renamed from: t */
    private boolean f12002t;

    /* renamed from: u */
    private int f12003u;

    /* renamed from: w */
    private C3160a f12005w;

    /* renamed from: x */
    private boolean f12006x;

    /* renamed from: z */
    private boolean f12008z;

    /* renamed from: l */
    private EnumC3161b f11994l = EnumC3161b.IDLE;

    /* renamed from: m */
    private String f11995m = null;

    /* renamed from: n */
    private CameraMountState f11996n = CameraMountState.IDLE;

    /* renamed from: o */
    private CameraMountState f11997o = CameraMountState.IDLE;

    /* renamed from: a */
    DisplayMetrics f11983a = new DisplayMetrics();

    /* renamed from: q */
    private int f11999q = -1;

    /* renamed from: v */
    private final int f12004v = 30;

    /* renamed from: y */
    private long f12007y = System.currentTimeMillis();

    /* renamed from: A */
    private long f11982A = System.currentTimeMillis();

    /* renamed from: i */
    private float f11991i = this.f11983a.widthPixels;

    /* renamed from: j */
    private float f11992j = this.f11983a.heightPixels;

    /* renamed from: com.fimi.soul.module.droneFragment.b$a */
    /* loaded from: classes.dex */
    public class C3160a extends Thread {
        public C3160a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!View$OnTouchListenerC3156b.this.f12006x) {
                if (View$OnTouchListenerC3156b.this.f12003u != 0 && View$OnTouchListenerC3156b.this.f11996n == CameraMountState.MOUNT) {
                    C3676e.m7493a().m7492a(" 进入自动拉流线程----");
                    View$OnTouchListenerC3156b.this.f11984b.restart();
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.fimi.soul.module.droneFragment.b$b */
    /* loaded from: classes.dex */
    public enum EnumC3161b {
        IDLE,
        START,
        STOP
    }

    /* renamed from: com.fimi.soul.module.droneFragment.b$c */
    /* loaded from: classes.dex */
    public interface AbstractC3162c {
        /* renamed from: a */
        void mo9401a(int i, int i2, int i3);
    }

    public View$OnTouchListenerC3156b(Activity activity, View view) {
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.f11983a);
        m9438a(view);
        this.f11986d = activity;
        this.f11989g = view;
        m9429b();
        if (this.f11998p == null && activity != null) {
            this.f11998p = C2277v.m12784a(activity).m12787a();
        }
        this.f12005w = new C3160a();
        this.f12005w.start();
    }

    /* renamed from: a */
    private void m9438a(View view) {
        this.f11984b = (FimiVideoView) view.findViewById(C2300R.C2302id.ids_video_view);
        this.f11984b.setKeepScreenOn(true);
        this.f11984b.setZOrderMediaOverlay(true);
        this.f11984b.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.fimi.soul.module.droneFragment.b.1
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                return false;
            }
        });
        this.f11985c = view.findViewById(C2300R.C2302id.control_cantairn);
        this.f11985c.setVisibility(0);
        view.setOnTouchListener(this);
        this.f11990h = (TextView) view.findViewById(C2300R.C2302id.gc_error_text);
        this.f11993k = (WriteCamera9Grid) view.findViewById(C2300R.C2302id.gridviewCamera);
        this.f11984b.setOnPreviewCallBackListener(this);
    }

    /* renamed from: u */
    private void m9402u() {
        this.f11984b.startLiveVideo(this.f11995m);
        this.f12001s = false;
    }

    /* renamed from: a */
    public Activity m9439a() {
        return this.f11986d;
    }

    /* renamed from: a */
    public void m9437a(CameraMountState cameraMountState) {
        this.f11996n = cameraMountState;
        C3676e.m7493a().m7492a("---stopPreview-----CoordinatorState-" + this.f11994l);
        if (this.f11994l == EnumC3161b.IDLE) {
            return;
        }
        this.f11985c.setVisibility(0);
        C3676e.m7493a().m7492a("---stopPreview----1");
        this.f12003u = 0;
        this.f11984b.clearUri();
        this.f11984b.stopPlay();
        this.f11984b.stopFlightVideo();
        if (this.f11995m == null) {
            return;
        }
        this.f11984b.stopLiveVideo();
    }

    /* renamed from: a */
    public void m9436a(CameraMountState cameraMountState, boolean z, boolean z2) {
        this.f12003u = 0;
        this.f11996n = cameraMountState;
        if (this.f11994l == EnumC3161b.IDLE) {
            return;
        }
        if (cameraMountState != CameraMountState.MOUNT) {
            this.f11984b.clearUri();
        } else {
            this.f11984b.setVideoPath(C2427e.m12218d());
        }
        C3676e.m7493a().m7492a("---startPreview---CoordinatorState-" + this.f11994l);
        this.f11984b.startPreview();
    }

    /* renamed from: a */
    public void m9435a(AbstractC3162c abstractC3162c) {
        this.f11984b.setLiveVideoCallBackListener(abstractC3162c);
    }

    /* renamed from: a */
    public void m9432a(String str) {
        this.f12001s = true;
        this.f11995m = str;
    }

    /* renamed from: a */
    public void m9431a(String str, int i) {
        File[] m7428a = new C3696t().m7428a(C3681j.m7464o(), C3495f.f13782a);
        File[] fileArr = new File[i];
        if (m7428a != null) {
            for (int i2 = 0; i2 < i && i2 < m7428a.length; i2++) {
                fileArr[i2] = m7428a[i2];
            }
        }
        new C3689q(fileArr, str).m7439a();
    }

    /* renamed from: a */
    public void m9430a(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.f11989g.getLayoutParams();
        if (this.f11987e <= 10 || this.f11988f <= 10) {
            layoutParams.height = this.f11983a.heightPixels;
            layoutParams.width = this.f11983a.widthPixels;
        } else {
            layoutParams.height = this.f11988f;
            layoutParams.width = this.f11987e;
        }
        this.f11984b.setDecodeType(0);
        if (this.f11996n != CameraMountState.MOUNT) {
            C3676e.m7493a().m7492a("clearUri");
            this.f11984b.clearUri();
        } else {
            C3676e.m7493a().m7492a("X11CmdConstants.getX11_RTSP_ADDR() " + C2427e.m12218d());
            this.f11984b.setVideoPath(C2427e.m12218d());
        }
        this.f11989g.setLayoutParams(layoutParams);
        if (!z || this.f11996n != CameraMountState.MOUNT || !this.f11984b.isPlaying()) {
            this.f11985c.setVisibility(0);
        } else {
            this.f11985c.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void m9429b() {
        ViewGroup.LayoutParams layoutParams = this.f11989g.getLayoutParams();
        this.f11988f = layoutParams.height;
        this.f11987e = layoutParams.width;
        layoutParams.height = 10;
        layoutParams.width = 10;
        this.f11989g.setLayoutParams(layoutParams);
        this.f11985c.setVisibility(0);
    }

    /* renamed from: b */
    public void m9428b(CameraMountState cameraMountState) {
        this.f11996n = cameraMountState;
        if (cameraMountState == CameraMountState.DISMOUNT) {
            this.f11997o = this.f11996n;
        }
        if (cameraMountState == CameraMountState.MOUNT) {
            this.f11984b.setUri(C2427e.m12218d());
        }
        if (this.f11999q == 1 && cameraMountState == CameraMountState.MOUNT) {
            C3676e.m7493a().m7492a("onCameraState startPreview");
            CameraValue.isFindFirmware = false;
            CameraValue.isUpdate = false;
            m9436a(CameraMountState.MOUNT, true, true);
        }
    }

    /* renamed from: b */
    public void m9426b(String str) {
        if (str == null) {
            this.f11990h.setVisibility(8);
            return;
        }
        this.f11990h.setVisibility(0);
        this.f11990h.setText(str);
    }

    /* renamed from: b */
    public void m9425b(String str, int i) {
        C3696t c3696t = new C3696t();
        File[] m7426c = c3696t.m7426c(C3681j.m7463p() + "/" + str);
        if (m7426c == null || m7426c.length <= i) {
            return;
        }
        while (i < m7426c.length) {
            c3696t.m7430a(m7426c[i]);
            i++;
        }
    }

    /* renamed from: c */
    public String m9422c(String str) {
        C3696t c3696t;
        String m7429a;
        String m7427b;
        if (!this.f11984b.isPlaying() || (m7429a = (c3696t = new C3696t()).m7429a(C3681j.m7466m())) == null || (m7427b = c3696t.m7427b(m7429a + "/DroneData")) == null) {
            return null;
        }
        File file = new File(C3681j.m7463p() + "/" + str + "/" + m7427b);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    public void m9424c() {
    }

    /* renamed from: d */
    public void m9421d() {
        if (this.f11994l != EnumC3161b.IDLE) {
            return;
        }
        this.f11994l = EnumC3161b.START;
        this.f11984b.setVisibility(0);
        this.f11984b.start();
        this.f11984b.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.fimi.soul.module.droneFragment.b.2
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                C3676e.m7493a().m7492a("onPrepared=====playerErrorCount " + View$OnTouchListenerC3156b.this.f12003u);
            }

            @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
            public void onStartStream() {
                View$OnTouchListenerC3156b.this.f12003u = 0;
                View$OnTouchListenerC3156b.this.f11985c.setVisibility(8);
                C3676e.m7493a().m7492a("onPrepared=====onStartStream ");
            }
        });
        this.f11984b.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.fimi.soul.module.droneFragment.b.3
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                View$OnTouchListenerC3156b.this.f11984b.toggleAspectRatio();
                return false;
            }
        });
    }

    /* renamed from: e */
    public void m9419e() {
        this.f11984b.stopLiveVideo();
        this.f11995m = null;
    }

    /* renamed from: f */
    public void m9417f() {
        this.f11994l = EnumC3161b.STOP;
        this.f11985c.setVisibility(0);
        if (this.f11984b.isPlaying()) {
        }
    }

    /* renamed from: g */
    public void m9416g() {
        this.f11985c.setVisibility(0);
        this.f11984b.setVisibility(8);
    }

    /* renamed from: h */
    public void m9415h() {
        if (this.f11998p == null || !C2238c.m13123e().m12749l() || this.f11993k == null || this.f11993k.isShown()) {
            return;
        }
        this.f11993k.setVisibility(0);
    }

    /* renamed from: i */
    public void m9414i() {
        if (this.f11993k == null || !this.f11993k.isShown()) {
            return;
        }
        this.f11993k.setVisibility(8);
    }

    /* renamed from: j */
    public void m9413j() {
        if (!C2367d.m12459a().m12438k() || System.currentTimeMillis() - this.f12007y <= 1000) {
            return;
        }
        this.f12007y = System.currentTimeMillis();
        C3676e.m7493a().m7492a("4K拍照断流 restart release");
        this.f11984b.restart();
    }

    /* renamed from: k */
    public void m9412k() {
        this.f12008z = true;
    }

    /* renamed from: l */
    public void m9411l() {
        if (this.f12008z) {
            return;
        }
        if (this.f11994l == EnumC3161b.IDLE) {
            CameraValue.isCameraParameterChange = false;
            return;
        }
        if (CameraValue.isCameraParameterChange) {
            C3676e.m7493a().m7492a("restartByCameraParameter restart");
            this.f11984b.restart();
        }
        CameraValue.isCameraParameterChange = false;
    }

    /* renamed from: m */
    public void m9410m() {
        if (this.f11994l == EnumC3161b.IDLE) {
            return;
        }
        this.f11985c.setVisibility(0);
        C3676e.m7493a().m7492a("---stopPreview----2");
        this.f11984b.stopPlay();
        this.f11984b.stopFlightVideo();
        if (this.f11995m == null) {
            return;
        }
        this.f11984b.stopLiveVideo();
    }

    /* renamed from: n */
    public void m9409n() {
        this.f12002t = true;
        m9410m();
    }

    /* renamed from: o */
    public void m9408o() {
        if (this.f11984b != null && System.currentTimeMillis() - this.f11982A > 5000) {
            this.f11982A = System.currentTimeMillis();
            String m9422c = m9422c(C3681j.m7462q());
            if (m9422c != null && this.f11984b.isPlaying()) {
                m9431a(m9422c, 2);
            }
        }
        m9425b(C3681j.m7462q(), 5);
    }

    @Override // com.fimi.soul.media.player.widget.FimiVideoView.OnFimiPreviewCallBackListener
    public void onCompletion(int i) {
        C3676e.m7493a().m7492a("--- playerErrorCount " + this.f12003u + " code = " + i);
        if (i != 100 || this.f11996n != CameraMountState.MOUNT || CameraValue.isFindFirmware || this.f12003u >= 30 || CameraValue.isCameraParameterChange) {
            return;
        }
        C3676e.m7493a().m7492a("---onCompletion----restart playerErrorCount " + this.f12003u);
        if (this.f11995m != null) {
            this.f11984b.stopLiveVideo();
        }
        this.f11984b.restart();
        this.f12003u++;
    }

    @Override // com.fimi.soul.media.player.widget.FimiVideoView.OnFimiPreviewCallBackListener
    public void onSurfaceState(int i) {
        this.f11999q = i;
        C3676e.m7493a().m7492a("onSurfaceState 22222222222 " + i + " " + this.f11996n + " " + this.f12000r);
        if (i == 1 && CameraMountState.MOUNT == this.f11996n) {
            CameraValue.isFindFirmware = false;
            CameraValue.isUpdate = false;
            if (this.f11997o != CameraMountState.MOUNT) {
                C3676e.m7493a().m7492a("onSurfaceState 1 " + i + " " + this.f11996n + " " + this.f12000r);
                this.f11997o = this.f11996n;
                if (this.f12003u != 0) {
                    this.f11984b.restart();
                } else if (!this.f12008z || !CameraValue.isCameraParameterChange) {
                    m9436a(CameraMountState.MOUNT, true, true);
                } else {
                    this.f12008z = false;
                    m9411l();
                }
                if (!this.f12001s) {
                    this.f12008z = false;
                    return;
                }
                m9402u();
                this.f12002t = false;
            } else if (this.f12000r) {
                C3676e.m7493a().m7492a("onSurfaceState 2 " + i + " " + this.f11996n + " " + this.f12000r);
                m9436a(CameraMountState.MOUNT, true, true);
                this.f12000r = false;
                this.f12008z = false;
            } else if (this.f12001s) {
                C3676e.m7493a().m7492a("onSurfaceState 3 " + i + " " + this.f11996n + " ");
                m9436a(CameraMountState.MOUNT, true, true);
                m9402u();
                this.f12002t = false;
            } else if (this.f12002t) {
                C3676e.m7493a().m7492a("onSurfaceState 4 " + i + " " + this.f11996n + " ");
                m9436a(CameraMountState.MOUNT, true, true);
                this.f12002t = false;
            } else {
                if (this.f12008z && CameraValue.isCameraParameterChange) {
                    C3676e.m7493a().m7492a("onSurfaceState 555555555555 " + i + " " + this.f11996n + " " + this.f12000r);
                    if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
                        this.f12008z = false;
                    }
                    m9411l();
                }
                this.f12008z = false;
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x < this.f11991i / 3.0f || x > (this.f11991i * 2.0f) / 3.0f || y < this.f11992j / 3.0f || y > (this.f11992j * 2.0f) / 3.0f;
    }

    /* renamed from: p */
    public void m9407p() {
        if (this.f11984b != null && System.currentTimeMillis() - this.f11982A > 5000) {
            this.f11982A = System.currentTimeMillis();
            String m9422c = m9422c(C3681j.m7460s());
            if (m9422c != null && this.f11984b.isPlaying()) {
                m9431a(m9422c, 5);
            }
        }
        m9425b(C3681j.m7460s(), 5);
    }

    /* renamed from: q */
    public void m9406q() {
        if (this.f11984b != null && System.currentTimeMillis() - this.f11982A > 5000) {
            this.f11982A = System.currentTimeMillis();
            String m9422c = m9422c(C3681j.m7461r());
            if (m9422c != null && this.f11984b.isPlaying()) {
                m9431a(m9422c, 4);
            }
        }
        m9425b(C3681j.m7461r(), 3);
    }

    /* renamed from: r */
    public void m9405r() {
        this.f12000r = true;
    }

    /* renamed from: s */
    public void m9404s() {
        m9403t();
        this.f11984b.release(true);
    }

    /* renamed from: t */
    public void m9403t() {
        if (this.f12005w != null) {
            this.f12006x = true;
            this.f12005w.isInterrupted();
        }
    }
}
