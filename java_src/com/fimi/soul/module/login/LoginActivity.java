package com.fimi.soul.module.login;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.p001v4.view.PagerAdapter;
import android.support.p001v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentLinearLayout;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.p139b.C2096d;
import com.fimi.p139b.C2100e;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2090a;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.p139b.p142c.AbstractC2093a;
import com.fimi.p139b.p142c.AbstractC2094b;
import com.fimi.p139b.p142c.AbstractC2095c;
import com.fimi.p147d.AbstractC2118a;
import com.fimi.p151f.C2139b;
import com.fimi.p151f.C2145d;
import com.fimi.p152g.C2148b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p176e.C2440a;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.p181j.C2496e;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.login.LoginFragment;
import com.fimi.soul.module.login.PrivacyAgreementView;
import com.fimi.soul.module.login.UsbConnectFragment;
import com.fimi.soul.module.push.MessageDetailActivity;
import com.fimi.soul.module.setting.newhand.NewHandActivity;
import com.fimi.soul.module.update.FindNewFirmwareAvtivity;
import com.fimi.soul.module.update.FindOnlineFirmwareAvtivity;
import com.fimi.soul.module.update.UpdateConnectDefeaFrgment;
import com.fimi.soul.service.QueryDynamicFlyZoneSetvice;
import com.fimi.soul.service.UsbStatus;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.HackyViewPager;
import com.fimi.soul.view.TranslationView;
import com.fimi.x1bh.module.X1bhBaseActivity;
import com.fimi.x1bh.module.main.CloudTerraceMainActivity;
import com.fimi.x1bh.module.update.X1bhFindNewFirmwareAvtivity;
/* loaded from: classes.dex */
public class LoginActivity extends X1bhBaseActivity implements ViewPager.OnPageChangeListener, AbstractC2388f<X11RespCmd>, C2678d.AbstractC2680b, LoginFragment.AbstractC3353a, UsbConnectFragment.AbstractC3371a, UpdateConnectDefeaFrgment.AbstractC3566a {

    /* renamed from: H */
    private static final int f12998H = 3;

    /* renamed from: I */
    private static final int f12999I = 4;

    /* renamed from: M */
    private static final int f13000M = 8;

    /* renamed from: T */
    private static final int f13001T = 0;

    /* renamed from: V */
    private static final String f13002V = "LoginActivity";

    /* renamed from: A */
    private ImageView[] f13003A;

    /* renamed from: B */
    private int[] f13004B;

    /* renamed from: C */
    private ViewGroup f13005C;

    /* renamed from: D */
    private ImageView[] f13006D;

    /* renamed from: F */
    private ValueAnimator f13008F;

    /* renamed from: J */
    private boolean f13010J;

    /* renamed from: L */
    private EnumC2091b f13012L;

    /* renamed from: P */
    private ImageView f13015P;

    /* renamed from: S */
    private AbstractC2093a f13018S;

    /* renamed from: U */
    private AbstractC2094b f13019U;

    /* renamed from: X */
    private float f13021X;

    /* renamed from: b */
    C2277v f13024b;

    /* renamed from: d */
    Drawable f13026d;

    /* renamed from: f */
    private UpdateConnectDefeaFrgment f13028f;

    /* renamed from: g */
    private LoginFragment f13029g;

    /* renamed from: h */
    private UsbConnectFragment f13030h;

    /* renamed from: i */
    private ImageView f13031i;

    /* renamed from: j */
    private AnimationDrawable f13032j;

    /* renamed from: k */
    private TranslationView f13033k;

    /* renamed from: l */
    private ProgressView f13034l;

    /* renamed from: m */
    private TextView f13035m;

    /* renamed from: n */
    private TextView f13036n;

    /* renamed from: o */
    private TextView f13037o;

    /* renamed from: p */
    private TextView f13038p;

    /* renamed from: q */
    private ImageView f13039q;

    /* renamed from: r */
    private TextView f13040r;

    /* renamed from: s */
    private TextView f13041s;

    /* renamed from: t */
    private TextView f13042t;

    /* renamed from: u */
    private ImageView f13043u;

    /* renamed from: v */
    private ProgressBar f13044v;

    /* renamed from: w */
    private RelativeLayout f13045w;

    /* renamed from: x */
    private ImageView f13046x;

    /* renamed from: y */
    private ImageView f13047y;

    /* renamed from: z */
    private HackyViewPager f13048z;

    /* renamed from: E */
    private final int f13007E = 600;

    /* renamed from: G */
    private int f13009G = 0;

    /* renamed from: a */
    boolean f13023a = true;

    /* renamed from: K */
    private boolean f13011K = false;

    /* renamed from: N */
    private boolean f13013N = false;

    /* renamed from: O */
    private boolean f13014O = false;

    /* renamed from: Q */
    private int f13016Q = 0;

    /* renamed from: R */
    private boolean f13017R = false;

    /* renamed from: c */
    public Handler f13025c = new Handler() { // from class: com.fimi.soul.module.login.LoginActivity.1
        @Override // android.os.Handler
        @TargetApi(16)
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 3:
                    LoginActivity.this.m8638a(false);
                    return;
                case 4:
                    if (LoginActivity.this.f13031i == null) {
                        return;
                    }
                    LoginActivity.this.f13031i.setBackground(LoginActivity.this.f13026d);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: W */
    private Runnable f13020W = new Runnable() { // from class: com.fimi.soul.module.login.LoginActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (LoginActivity.this.f13030h.isAdded() || LoginActivity.this.isFinishing()) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isEnterLoginFragment", true);
            LoginActivity.this.f13030h.setArguments(bundle);
            LoginActivity.this.m8648A();
            LoginActivity.this.getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, LoginActivity.this.f13030h).commitAllowingStateLoss();
        }
    };

    /* renamed from: e */
    public AbstractC2095c f13027e = new AbstractC2095c() { // from class: com.fimi.soul.module.login.LoginActivity.10
        @Override // com.fimi.p139b.p142c.AbstractC2095c
        /* renamed from: a */
        public void mo8603a(float f) {
            float f2 = 600.0f;
            if (f == 200.0f) {
                Log.d("moweiru", "progress:" + f);
                LoginActivity.this.f13018S.mo6659g();
            }
            float currentCount = f < 390.0f ? LoginActivity.this.f13034l.getCurrentCount() + LoginActivity.this.f13021X : 200.0f + f;
            if (currentCount <= 600.0f) {
                f2 = currentCount;
            }
            LoginActivity.this.f13034l.setCurrentCount(f2);
        }

        @Override // com.fimi.p139b.p142c.AbstractC2095c
        /* renamed from: a */
        public void mo8602a(EnumC2090a enumC2090a) {
            if (LoginActivity.this.f13018S != null) {
                LoginActivity.this.f13018S.mo6665d();
                LoginActivity.this.f13018S = null;
            }
            if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH && ((C2423d) C2379b.m12410a().m12394d()).f() == -3) {
                LoginActivity.this.m8645a(C2300R.C2303string.rc_tip_error_x1bh_occupied, C2300R.C2303string.unconnetremote_x1bh);
                return;
            }
            LoginActivity.this.m8646a(1);
            switch (C33432.f13051a[enumC2090a.ordinal()]) {
                case 1:
                    LoginActivity.this.m8640a(FindOnlineFirmwareAvtivity.class);
                    return;
                case 2:
                    if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                        LoginActivity.this.m8640a(FindNewFirmwareAvtivity.class);
                        return;
                    } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
                        return;
                    } else {
                        LoginActivity.this.m8640a(X1bhFindNewFirmwareAvtivity.class);
                        return;
                    }
                case 3:
                    if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
                        LoginActivity.this.m8640a(FlightActivity.class);
                        return;
                    } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
                        return;
                    } else {
                        LoginActivity.this.m8640a(CloudTerraceMainActivity.class);
                        return;
                    }
                case 4:
                    LoginActivity.this.dpa.m12521d();
                    return;
                default:
                    return;
            }
        }

        @Override // com.fimi.p139b.p142c.AbstractC2095c
        /* renamed from: a */
        public void mo8601a(String str, String str2) {
            LoginActivity.this.f13018S = null;
            LoginActivity.this.m8639a(str, str2);
        }
    };

    /* renamed from: Y */
    private int f13022Y = 0;

    /* renamed from: com.fimi.soul.module.login.LoginActivity$2 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C33432 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13051a = new int[EnumC2090a.values().length];

        static {
            try {
                f13051a[EnumC2090a.FIND_ONLINE_FIRMWARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13051a[EnumC2090a.FIND_NEW_FIRMWARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13051a[EnumC2090a.FLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13051a[EnumC2090a.SETTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class MyAdapter extends PagerAdapter {
        public MyAdapter() {
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public int getCount() {
            return LoginActivity.this.f13003A.length;
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            try {
                ((HackyViewPager) view).addView(LoginActivity.this.f13003A[i % LoginActivity.this.f13003A.length], 0);
            } catch (Exception e) {
            }
            return LoginActivity.this.f13003A[i % LoginActivity.this.f13003A.length];
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m8648A() {
        if (this.f13030h != null) {
            if (C2110f.m13670a().m13668b() != EnumC2091b.DRONE) {
                this.f13030h.m8580a(true);
            } else {
                this.f13030h.m8580a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8639a(String str, String str2) {
        boolean m8609u = m8609u();
        if (this.f13028f == null) {
            this.f13028f = new UpdateConnectDefeaFrgment();
        }
        if (this.f13014O) {
            return;
        }
        if (m8609u) {
            getFragmentManager().beginTransaction().show(this.f13028f);
        } else {
            getFragmentManager().beginTransaction().add(C2300R.C2302id.main_layout, this.f13028f).commitAllowingStateLoss();
        }
        this.f13028f.m8040a(str);
        this.f13028f.m8038b(str2);
        this.f13028f.m8036c(getString(C2300R.C2303string.no_connect));
        this.f13028f.m8035c(false);
        this.f13028f.m8039a(false);
        getFragmentManager().beginTransaction().setCustomAnimations(17432576, 17432577);
    }

    /* renamed from: b */
    private void m8634b(Class<?> cls) {
        startActivity(new Intent(this, cls));
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: b */
    private void m8633b(boolean z) {
        Log.d(f13002V, "showUsbConnecting: " + z);
        this.f13045w.setVisibility(z ? 0 : 8);
    }

    /* renamed from: c */
    private void m8632c(int i) {
        for (int i2 = 0; i2 < this.f13006D.length; i2++) {
            if (i2 == i) {
                this.f13006D[i2].setBackgroundResource(C2300R.C2301drawable.page_indicator_focused);
            } else {
                this.f13006D[i2].setBackgroundResource(C2300R.C2301drawable.page_indicator_unfocused);
            }
        }
    }

    /* renamed from: c */
    private void m8630c(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isenterLoginFragment", z);
        this.f13030h.setArguments(bundle);
        m8648A();
        getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commit();
    }

    /* renamed from: d */
    private void m8628d(boolean z) {
        int i = 0;
        this.f13036n.setVisibility(z ? 0 : 8);
        ProgressView progressView = this.f13034l;
        if (!z) {
            i = 8;
        }
        progressView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m8614p() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.login.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                C2571k.m11651a(LoginActivity.this).m11648a(new C2571k.AbstractC2573a() { // from class: com.fimi.soul.module.login.LoginActivity.4.1
                    @Override // com.fimi.soul.biz.p185n.C2571k.AbstractC2573a
                    /* renamed from: a */
                    public void mo8600a(AMapLocation aMapLocation) {
                    }
                });
                if (LoginActivity.this.getIntent().getBooleanExtra("islaunchexit", false)) {
                }
                LoginActivity.this.speakTTs = C2244b.m13105a(LoginActivity.this);
                LoginActivity.this.speakTTs.m13106a();
                QueryDynamicFlyZoneSetvice.m7809a(LoginActivity.this.getApplicationContext());
            }
        });
    }

    /* renamed from: q */
    private void m8613q() {
        this.f13015P = (ImageView) findViewById(C2300R.C2302id.login_mask_iv);
        this.f13033k = (TranslationView) findViewById(C2300R.C2302id.translationview);
        this.f13029g = new LoginFragment();
        this.f13030h = new UsbConnectFragment();
        this.f13008F = ValueAnimator.ofFloat(0.0f, 200.0f);
        this.f13008F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.module.login.LoginActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoginActivity.this.f13034l.setCurrentCount(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        m8607w();
        this.f13034l = (ProgressView) findViewById(C2300R.C2302id.checkFirmwareprogress);
        this.f13035m = (TextView) findViewById(C2300R.C2302id.tv_x1bh_camera_hint);
        this.f13035m.setVisibility(8);
        this.f13034l.setMaxCount(600.0f);
        this.f13036n = (TextView) findViewById(C2300R.C2302id.checking_hard_tv);
        C3658ar.m7612a(getAssets(), this.f13036n, this.f13035m);
        m8612r();
        m8611s();
        m8647a();
    }

    /* renamed from: r */
    private void m8612r() {
        int m12746o = C2238c.m13123e().m12746o();
        this.f13005C = (ViewGroup) findViewById(C2300R.C2302id.viewGroup);
        this.f13048z = (HackyViewPager) findViewById(C2300R.C2302id.view_pager);
        this.f13046x = (ImageView) findViewById(C2300R.C2302id.iv_right_slide);
        this.f13047y = (ImageView) findViewById(C2300R.C2302id.iv_left_slide);
        this.f13004B = new int[]{C2300R.C2301drawable.select_device_flight, C2300R.C2301drawable.select_device_cloud};
        this.f13006D = new ImageView[this.f13004B.length];
        for (int i = 0; i < this.f13006D.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new PercentLinearLayout.LayoutParams(10, 10));
            this.f13006D[i] = imageView;
            if (i == 0) {
                this.f13006D[i].setBackgroundResource(C2300R.C2301drawable.page_indicator_focused);
            } else {
                this.f13006D[i].setBackgroundResource(C2300R.C2301drawable.page_indicator_unfocused);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            this.f13005C.addView(imageView, layoutParams);
        }
        this.f13003A = new ImageView[this.f13004B.length];
        for (int i2 = 0; i2 < this.f13003A.length; i2++) {
            ImageView imageView2 = new ImageView(this);
            this.f13003A[i2] = imageView2;
            imageView2.setBackgroundResource(this.f13004B[i2]);
        }
        this.f13048z.setAdapter(new MyAdapter());
        this.f13048z.setOnPageChangeListener(this);
        this.f13048z.setCurrentItem(m12746o, false);
        this.f13048z.setOverScrollMode(2);
    }

    /* renamed from: s */
    private void m8611s() {
        switch (getIntent().getExtras().getInt(AbstractC2089b.f6992j, 4)) {
            case 2:
                C2110f.m13670a().m13669a(EnumC2091b.DRONE);
                this.f13048z.setVisibility(0);
                this.f13005C.setVisibility(0);
                this.f13047y.setVisibility(0);
                this.f13046x.setVisibility(0);
                this.f13048z.setCurrentItem(0);
                m8630c(true);
                getWindow().setFlags(128, 128);
                m8636b(0);
                return;
            case 3:
                C2110f.m13670a().m13669a(EnumC2091b.X1BH);
                this.f13048z.setVisibility(0);
                this.f13005C.setVisibility(0);
                this.f13047y.setVisibility(0);
                this.f13046x.setVisibility(0);
                this.f13048z.setCurrentItem(1);
                m8630c(true);
                getWindow().setFlags(128, 128);
                m8636b(1);
                return;
            case 4:
                ((ViewStub) findViewById(C2300R.C2302id.login_animation_vs)).inflate();
                this.f13031i = (ImageView) findViewById(C2300R.C2302id.login_animation_iv);
                this.f13031i.setVisibility(0);
                m8646a(0);
                getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13029g).commit();
                this.f13015P.setAlpha(0.0f);
                this.f13048z.setVisibility(8);
                this.f13005C.setVisibility(8);
                this.f13047y.setVisibility(8);
                this.f13046x.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: t */
    private void m8610t() {
        switch (getIntent().getExtras().getInt(AbstractC2089b.f6992j, 4)) {
            case 2:
                C2110f.m13670a().m13669a(EnumC2091b.DRONE);
                this.f13033k.setVisibility(0);
                this.f13033k.m7244a();
                m8630c(true);
                getWindow().setFlags(128, 128);
                this.f13015P.setAlpha(1.0f);
                return;
            case 3:
                C2110f.m13670a().m13669a(EnumC2091b.X1BH);
                this.f13033k.setVisibility(0);
                this.f13033k.m7244a();
                m8630c(true);
                getWindow().setFlags(128, 128);
                this.f13015P.setAlpha(1.0f);
                return;
            case 4:
                ((ViewStub) findViewById(C2300R.C2302id.login_animation_vs)).inflate();
                this.f13031i = (ImageView) findViewById(C2300R.C2302id.login_animation_iv);
                this.f13031i.setVisibility(0);
                m8646a(0);
                getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13029g).commit();
                this.f13015P.setAlpha(0.0f);
                return;
            default:
                return;
        }
    }

    /* renamed from: u */
    private boolean m8609u() {
        try {
            this.f13028f = (UpdateConnectDefeaFrgment) getFragmentManager().findFragmentById(C2300R.C2302id.main_layout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f13028f != null;
    }

    /* renamed from: v */
    private void m8608v() {
        C2462a.m12098a().m12092a(getLocalClassName());
        this.dpa.m12521d();
        this.dpa.m12523b(this);
        startService(new Intent(this, UsbStatus.class));
        if (!getIntent().getBooleanExtra("islaunchexit", false) || C2241c.m13122a().mo13108d("USER_PROTOCOL")) {
        }
        this.f13024b = C2277v.m12784a(this);
        this.f13013N = this.f13024b.m12787a().getBoolean(C2353b.f7920K, false);
        this.drone.mo11219a(this);
        this.f13016Q = getIntent().getIntExtra("sp_upgrade_skip", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("launchBundle");
        if (bundleExtra != null) {
            Intent intent = new Intent(this, MessageDetailActivity.class);
            intent.putExtra("redirectURL", bundleExtra.getString("redirectURL"));
            startActivity(intent);
        }
        ((C2423d) C2379b.m12410a().m12394d()).a(this);
    }

    /* renamed from: w */
    private void m8607w() {
        this.f13045w = (RelativeLayout) findViewById(C2300R.C2302id.usb_connecting_rl);
        this.f13037o = (TextView) findViewById(C2300R.C2302id.connecting_return_height_title_tv);
        this.f13038p = (TextView) findViewById(C2300R.C2302id.connecting_return_height_content_tv);
        this.f13039q = (ImageView) findViewById(C2300R.C2302id.connecting_return_height_iv);
        this.f13040r = (TextView) findViewById(C2300R.C2302id.connecting_emergency_stop_blade_title_tv);
        this.f13041s = (TextView) findViewById(C2300R.C2302id.connecting_emergency_stop_blade_content_tv);
        this.f13042t = (TextView) findViewById(C2300R.C2302id.connecting_emergency_stop_blade_content_child_tv);
        this.f13043u = (ImageView) findViewById(C2300R.C2302id.cloud_connecting_iv);
        this.f13044v = (ProgressBar) findViewById(C2300R.C2302id.cloud_connecting_pb);
        C3658ar.m7612a(getAssets(), this.f13037o, this.f13038p, this.f13040r, this.f13041s, this.f13042t);
    }

    /* renamed from: x */
    private void m8606x() {
        int i = 0;
        if (C2110f.m13670a().m13668b() != EnumC2091b.DRONE) {
            this.f13045w.setBackgroundResource(C2300R.C2301drawable.check_connect_bg);
            this.f13037o.setVisibility(8);
            this.f13038p.setVisibility(8);
            this.f13039q.setVisibility(8);
            this.f13040r.setVisibility(8);
            this.f13041s.setVisibility(8);
            this.f13042t.setVisibility(8);
            this.f13044v.setVisibility(0);
            this.f13043u.setVisibility(0);
            return;
        }
        boolean z = Math.random() > 0.5d;
        this.f13045w.setBackgroundResource(z ? C2300R.C2301drawable.connect_return_height_bg : C2300R.C2301drawable.connect_emergency_bg);
        this.f13037o.setVisibility(z ? 0 : 8);
        this.f13038p.setVisibility(z ? 0 : 8);
        this.f13039q.setVisibility(z ? 0 : 8);
        this.f13040r.setVisibility(z ? 8 : 0);
        this.f13041s.setVisibility(z ? 8 : 0);
        TextView textView = this.f13042t;
        if (z) {
            i = 8;
        }
        textView.setVisibility(i);
        this.f13044v.setVisibility(8);
        this.f13043u.setVisibility(8);
    }

    /* renamed from: y */
    private void m8605y() {
        if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
            m8634b(FlightActivity.class);
        } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
        } else {
            m8634b(CloudTerraceMainActivity.class);
        }
    }

    /* renamed from: z */
    private void m8604z() {
        if (this.f13010J) {
            finish();
            return;
        }
        this.f13010J = true;
        C2284z.m12696a(getApplicationContext(), (int) C2300R.C2303string.again_exit, C2284z.f7606b);
        this.f13025c.sendEmptyMessageDelayed(3, 2000L);
    }

    /* renamed from: a */
    public void m8647a() {
        this.f13015P.setBackgroundResource(C2300R.C2301drawable.login_mask);
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.login.LoginActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (LoginActivity.this.getIntent().getExtras().getInt(AbstractC2089b.f6992j) == 4) {
                    LoginActivity.this.f13026d = LoginActivity.this.getResources().getDrawable(C2300R.C2301drawable.login_anim);
                    LoginActivity.this.f13032j = (AnimationDrawable) LoginActivity.this.f13026d;
                    LoginActivity.this.f13032j.setOneShot(true);
                    LoginActivity.this.f13025c.sendEmptyMessage(4);
                }
            }
        });
    }

    /* renamed from: a */
    public void m8646a(int i) {
        this.f13022Y = i;
    }

    /* renamed from: a */
    public void m8645a(int i, int i2) {
        m8639a(getString(i), getString(i2));
    }

    /* renamed from: a */
    public void m8640a(Class<?> cls) {
        startActivity(new Intent(this, cls));
        overridePendingTransition(17432576, 17432577);
        if (this.f13019U != null) {
            this.f13019U.mo6641i();
        }
    }

    /* renamed from: a */
    public void m8638a(boolean z) {
        this.f13010J = true;
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        x11RespCmd.getMsg_id();
    }

    @Override // com.fimi.soul.module.login.LoginFragment.AbstractC3353a
    /* renamed from: b */
    public void mo8595b() {
        if (this.f13032j == null) {
            return;
        }
        m8646a(1);
        this.f13032j.stop();
        this.f13032j.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.module.login.LoginActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoginActivity.this.f13015P.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(720L);
        ofFloat.start();
        getWindow().setFlags(128, 128);
        this.f13025c.postDelayed(this.f13020W, 1100L);
    }

    /* renamed from: b */
    public void m8636b(int i) {
        this.f13019U = null;
        m8646a(1);
        if (i == 0) {
            if (this.f13031i != null) {
                this.f13031i.setVisibility(8);
            }
            m8633b(false);
            getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commitAllowingStateLoss();
            C2110f.m13670a().m13669a(EnumC2091b.DRONE);
            C2238c.m13123e().m12770d(0);
            if (this.f13019U == null) {
                this.f13019U = new C2100e(this, this.drone, C2110f.m13670a().m13668b());
            }
            this.f13019U.mo6654a(C2440a.m12171b());
            C2427e.m12221a();
            this.f13008F.setDuration(this.f13019U.mo6651c());
        } else if (i == 1) {
            if (this.f13031i != null) {
                this.f13031i.setVisibility(8);
            }
            C2441a.C2443a.f8422a.m12167a(2);
            m8633b(false);
            getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commitAllowingStateLoss();
            C2110f.m13670a().m13669a(EnumC2091b.X1BH);
            C2238c.m13123e().m12770d(1);
            if (this.f13019U == null) {
                this.f13019U = new C2100e(this, this.drone, C2110f.m13670a().m13668b());
            }
            this.f13019U.mo6654a(C2440a.m12171b());
            C2427e.m12221a();
            this.f13008F.setDuration(this.f13019U.mo6651c());
        }
        m8648A();
    }

    @Override // com.fimi.soul.module.login.LoginFragment.AbstractC3353a
    /* renamed from: c */
    public void mo8594c() {
        this.f13017R = true;
        startActivity(new Intent(this, NewHandActivity.class));
        overridePendingTransition(17432576, 17432577);
    }

    @Override // com.fimi.soul.module.login.LoginFragment.AbstractC3353a
    /* renamed from: d */
    public void mo8593d() {
        if (C2238c.m13123e().m12746o() == 0) {
            m8636b(0);
        } else {
            m8636b(1);
        }
        this.f13048z.setVisibility(0);
        this.f13005C.setVisibility(0);
        this.f13047y.setVisibility(0);
        this.f13046x.setVisibility(0);
    }

    @Override // com.fimi.soul.module.login.UsbConnectFragment.AbstractC3371a
    /* renamed from: e */
    public void mo8567e() {
        if (this.f13019U != null) {
            this.f13019U.mo6649d();
        }
        m8646a(2);
        if (this.f13031i != null) {
            this.f13031i.setVisibility(8);
        }
        m8633b(true);
        m8606x();
        if (this.f13019U != null) {
            this.f13019U.mo6645f();
        }
        this.f13009G = 0;
        this.f13015P.setAlpha(0.0f);
        m8628d(true);
        if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
            this.f13035m.setVisibility(0);
        }
        this.f13008F.start();
        m8648A();
        this.f13005C.setVisibility(8);
        this.f13048z.setVisibility(8);
        this.f13047y.setVisibility(8);
        this.f13046x.setVisibility(8);
        getFragmentManager().beginTransaction().remove(this.f13030h).commitAllowingStateLoss();
    }

    @Override // com.fimi.soul.module.login.UsbConnectFragment.AbstractC3371a
    /* renamed from: f */
    public void mo8566f() {
        if (!this.f13013N) {
            m8605y();
        } else if (this.f13012L != C2110f.m13670a().m13668b()) {
            m8605y();
        } else {
            this.f13024b.m12787a().edit().putBoolean(C2353b.f7918I, false).commit();
            this.dpa.m12521d();
        }
    }

    @Override // com.fimi.soul.module.update.UpdateConnectDefeaFrgment.AbstractC3566a
    /* renamed from: g */
    public void mo8034g() {
        if (this.f13013N) {
            this.f13024b.m12787a().edit().putBoolean(C2353b.f7918I, false);
            this.dpa.m12521d();
        } else if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
            startActivity(new Intent(this, FlightActivity.class));
        } else if (C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
        } else {
            startActivity(new Intent(this, CloudTerraceMainActivity.class));
        }
    }

    @Override // com.fimi.soul.module.update.UpdateConnectDefeaFrgment.AbstractC3566a
    /* renamed from: h */
    public void mo8033h() {
        m8646a(1);
        getFragmentManager().beginTransaction().remove(this.f13028f).commit();
        this.f13023a = true;
        this.f13036n.setVisibility(4);
        this.f13034l.setVisibility(4);
        this.f13035m.setVisibility(4);
        this.f13048z.setVisibility(0);
        this.f13005C.setVisibility(0);
        this.f13047y.setVisibility(0);
        this.f13046x.setVisibility(0);
        m8633b(false);
        m8648A();
        getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commit();
    }

    /* renamed from: i */
    public void m8623i() {
    }

    /* renamed from: j */
    public void m8621j() {
        this.f13036n.setText(getString(C2300R.C2303string.checking_hard));
        if (this.f13008F.isRunning()) {
            this.f13008F.cancel();
        }
        m8646a(1);
        this.f13023a = true;
        if (this.f13019U != null) {
            this.f13019U.mo6643g();
        }
        this.f13036n.setVisibility(4);
        this.f13034l.setVisibility(4);
        this.f13035m.setVisibility(4);
        m8633b(false);
        m8648A();
        getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commitAllowingStateLoss();
        this.f13005C.setVisibility(0);
        this.f13048z.setVisibility(0);
        this.f13047y.setVisibility(0);
        this.f13046x.setVisibility(0);
        if (this.f13018S != null) {
            this.f13018S.mo6663e();
            this.f13018S = null;
        }
    }

    /* renamed from: k */
    public void m8619k() {
        startActivity(new Intent(this, FlightActivity.class));
        finish();
    }

    /* renamed from: l */
    public void m8618l() {
        C2139b.m13469a();
        C2145d.m13452a();
        C2148b.m13440a().m13439a(new AbstractC2118a() { // from class: com.fimi.soul.module.login.LoginActivity.9
            @Override // com.fimi.p147d.AbstractC2118a
            /* renamed from: a */
            public void mo6477a(String str) {
            }

            @Override // com.fimi.p147d.AbstractC2118a
            /* renamed from: b */
            public void mo6446b(String str) {
            }

            @Override // com.fimi.p147d.AbstractC2118a
            /* renamed from: c */
            public void mo6556c(String str) {
            }
        });
        this.f13018S = new C2096d(this, C2110f.m13670a().m13668b(), this.f13027e);
        this.f13021X = (600.0f - this.f13034l.getCurrentCount()) / 400.0f;
        this.f13018S.mo6669b();
    }

    /* renamed from: m */
    public void m8617m() {
        this.dpa.m12524b();
        this.dpa.m12523b(this);
        m8616n();
    }

    /* renamed from: n */
    public void m8616n() {
        if (this.f13008F.isRunning()) {
            this.f13008F.cancel();
        }
    }

    /* renamed from: o */
    public int m8615o() {
        return this.f13022Y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            this.f13023a = true;
            this.f13036n.setVisibility(4);
            this.f13034l.setVisibility(4);
            this.f13035m.setVisibility(4);
            m8633b(false);
            if (this.f13031i != null) {
                this.f13031i.setVisibility(4);
            }
            this.f13033k.setVisibility(0);
            this.f13033k.m7244a();
            m8648A();
            getFragmentManager().beginTransaction().replace(C2300R.C2302id.main_layout, this.f13030h).commit();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    @TargetApi(16)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_login);
        m8608v();
        m8613q();
        C2496e.m11922a().m11920a(C2496e.EnumC2497a.IDEL);
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Log.d(f13002V, "onDestroy: ");
        this.f13014O = true;
        if (this.f13033k != null) {
            this.f13033k.m7236c();
        }
        this.drone.mo11214b(this);
        if (this.f13019U != null) {
            this.f13019U.mo13734a();
        }
        if (this.f13019U != null) {
            this.f13019U.mo6642h();
        }
        if (this.f13018S != null) {
            this.f13018S.mo6667c();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            switch (this.f13022Y) {
                case 0:
                    if (this.f13013N) {
                        finish();
                        return false;
                    }
                    m8604z();
                    return false;
                case 1:
                    if (this.f13011K) {
                        m8604z();
                        return false;
                    } else if (this.f13013N) {
                        finish();
                        return false;
                    } else {
                        m8604z();
                        return false;
                    }
                case 2:
                    if (this.f13019U != null) {
                        this.f13019U.mo6642h();
                        this.f13019U.mo13734a();
                    }
                    m8621j();
                    return false;
                case 3:
                    m8621j();
                    return false;
                case 4:
                    mo8033h();
                    return false;
                case 5:
                    if (this.f13013N) {
                        finish();
                        return false;
                    }
                    m8604z();
                    return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        m8632c(i);
        CameraValue.isAutoConnect = false;
        if (i == 0) {
            m8636b(0);
        } else {
            m8636b(1);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        if (!C2241c.m13122a().mo13108d("USER_PROTOCOL")) {
            PrivacyAgreementView.m8589a(this, new PrivacyAgreementView.AbstractC3360a() { // from class: com.fimi.soul.module.login.LoginActivity.3
                @Override // com.fimi.soul.module.login.PrivacyAgreementView.AbstractC3360a
                /* renamed from: a */
                public void mo8585a() {
                    LoginActivity.this.finish();
                }

                @Override // com.fimi.soul.module.login.PrivacyAgreementView.AbstractC3360a
                /* renamed from: b */
                public void mo8584b() {
                    C2241c.m13122a().mo13114a("USER_PROTOCOL", true);
                    LoginActivity.this.m8614p();
                }
            });
        } else {
            QueryDynamicFlyZoneSetvice.m7809a(getApplicationContext());
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f13016Q == 20) {
            m8639a(getString(C2300R.C2303string.phone_unconect_flight), getString(C2300R.C2303string.remote_noconnect_plane));
        }
        if (this.f13018S != null) {
            this.f13018S.mo6661f();
        }
        if (this.f13017R) {
            this.f13017R = false;
            if (C2238c.m13123e().m12746o() == 0) {
                m8636b(0);
            } else {
                m8636b(1);
            }
            this.f13048z.setVisibility(0);
            this.f13005C.setVisibility(0);
            this.f13047y.setVisibility(0);
            this.f13046x.setVisibility(0);
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f13019U != null) {
            this.f13019U.mo6654a(C2440a.m12171b());
        }
        this.f13014O = false;
    }

    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f13014O = true;
        this.f13025c.removeCallbacks(this.f13020W);
        if (this.f13018S != null) {
            this.f13018S.mo6665d();
        }
    }
}
