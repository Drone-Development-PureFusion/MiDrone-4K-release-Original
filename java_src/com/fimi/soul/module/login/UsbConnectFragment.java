package com.fimi.soul.module.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.utils.C2284z;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3758a;
/* loaded from: classes.dex */
public class UsbConnectFragment extends Fragment implements Handler.Callback, View.OnClickListener {

    /* renamed from: a */
    WifiManager f13104a;

    /* renamed from: c */
    private TextView f13106c;

    /* renamed from: d */
    private TextView f13107d;

    /* renamed from: e */
    private RelativeLayout f13108e;

    /* renamed from: f */
    private RelativeLayout f13109f;

    /* renamed from: g */
    private RelativeLayout f13110g;

    /* renamed from: h */
    private RelativeLayout f13111h;

    /* renamed from: i */
    private RelativeLayout f13112i;

    /* renamed from: j */
    private Context f13113j;

    /* renamed from: k */
    private Button f13114k;

    /* renamed from: l */
    private Button f13115l;

    /* renamed from: m */
    private Button f13116m;

    /* renamed from: n */
    private TextView f13117n;

    /* renamed from: o */
    private TextView f13118o;

    /* renamed from: p */
    private TextView f13119p;

    /* renamed from: q */
    private TextView f13120q;

    /* renamed from: r */
    private TextView f13121r;

    /* renamed from: s */
    private TextView f13122s;

    /* renamed from: t */
    private AbstractC3371a f13123t;

    /* renamed from: u */
    private Handler f13124u;

    /* renamed from: v */
    private C2657a f13125v;

    /* renamed from: w */
    private int f13126w = 100;

    /* renamed from: b */
    public Handler f13105b = new Handler() { // from class: com.fimi.soul.module.login.UsbConnectFragment.8
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C2284z.m12696a(UsbConnectFragment.this.getActivity(), (int) C2300R.C2303string.connectRcWifi, 3000);
        }
    };

    /* renamed from: com.fimi.soul.module.login.UsbConnectFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3371a {
        /* renamed from: e */
        void mo8567e();

        /* renamed from: f */
        void mo8566f();
    }

    /* renamed from: a */
    private void m8583a() {
        DialogC3758a.C3761b c3761b = new DialogC3758a.C3761b(getActivity());
        c3761b.m7142a(getString(C2300R.C2303string.good), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.login.UsbConnectFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (C2441a.m12168a().m12166b() != 1) {
                    if (UsbConnectFragment.this.f13125v.mo11217ab().mo10898a()) {
                        UsbConnectFragment.this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
                        return;
                    }
                    if (!UsbConnectFragment.this.f13104a.isWifiEnabled()) {
                        UsbConnectFragment.this.f13104a.setWifiEnabled(true);
                    }
                    UsbConnectFragment.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), UsbConnectFragment.this.f13126w);
                    return;
                }
                try {
                    if (UsbConnectFragment.this.getActivity() == null || Build.VERSION.SDK_INT >= 24 || !C3658ar.m7575h(UsbConnectFragment.this.getActivity()).booleanValue()) {
                        try {
                            Intent intent = new Intent();
                            intent.setClassName("com.android.settings", "com.android.settings.TetherSettings");
                            if (UsbConnectFragment.this.getActivity() != null) {
                                UsbConnectFragment.this.startActivityForResult(intent, 0);
                            }
                        } catch (Exception e) {
                            Intent intent2 = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                            if (UsbConnectFragment.this.getActivity() != null) {
                                UsbConnectFragment.this.startActivityForResult(intent2, 0);
                            }
                        }
                    } else {
                        UsbConnectFragment.this.m8579b();
                        UsbConnectFragment.this.f13123t.mo8567e();
                    }
                } catch (Exception e2) {
                    Intent intent3 = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                    if (UsbConnectFragment.this.getActivity() == null) {
                        return;
                    }
                    UsbConnectFragment.this.startActivityForResult(intent3, 0);
                }
            }
        });
        c3761b.m7148a().show();
    }

    /* renamed from: a */
    private void m8582a(View view) {
        this.f13117n = (TextView) view.findViewById(C2300R.C2302id.declare_one_tv);
        this.f13118o = (TextView) view.findViewById(C2300R.C2302id.declare_two_tv);
        this.f13119p = (TextView) view.findViewById(C2300R.C2302id.declare_three_tv);
        this.f13120q = (TextView) view.findViewById(C2300R.C2302id.declare_four_tv);
        this.f13121r = (TextView) view.findViewById(C2300R.C2302id.declare_two_child_tv);
        this.f13122s = (TextView) view.findViewById(C2300R.C2302id.declare_three_child_tv);
        C3658ar.m7612a(this.f13113j.getAssets(), this.f13117n, this.f13118o, this.f13119p, this.f13120q, this.f13121r, this.f13122s, this.f13114k, this.f13115l, this.f13106c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8579b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13106c, "translationX", 0.0f, 1000.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13108e, "translationX", 0.0f, 1000.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f13109f, "translationX", 0.0f, 1000.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f13110g, "translationX", 0.0f, 1000.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f13111h, "translationX", 0.0f, 1000.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f13112i, "translationX", 0.0f, 1000.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat6).with(ofFloat5).with(ofFloat4).with(ofFloat2).with(ofFloat3).with(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    /* renamed from: b */
    private void m8578b(View view) {
        this.f13114k = (Button) view.findViewById(C2300R.C2302id.next_bt);
        this.f13114k.setOnClickListener(this);
        this.f13115l = (Button) view.findViewById(C2300R.C2302id.noconnect_bt);
        this.f13115l.setOnClickListener(this);
        this.f13108e = (RelativeLayout) view.findViewById(C2300R.C2302id.usbconnect_one_rl);
        this.f13109f = (RelativeLayout) view.findViewById(C2300R.C2302id.usbconnect_two_rl);
        this.f13110g = (RelativeLayout) view.findViewById(C2300R.C2302id.usbconnect_three_rl);
        this.f13111h = (RelativeLayout) view.findViewById(C2300R.C2302id.usbconnect_four_rl);
        this.f13112i = (RelativeLayout) view.findViewById(C2300R.C2302id.usbconnect_button_rl);
        this.f13106c = (TextView) view.findViewById(C2300R.C2302id.connectplane_tv);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13106c, "translationX", 800.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13108e, "translationX", 800.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f13109f, "translationX", 800.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f13110g, "translationX", 800.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f13111h, "translationX", 800.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f13112i, "translationX", 800.0f, 0.0f);
        this.f13116m = (Button) view.findViewById(C2300R.C2302id.next_bt);
        this.f13116m.setOnClickListener(this);
        ofFloat.setStartDelay(0L);
        ofFloat2.setStartDelay(70L);
        ofFloat3.setStartDelay(140L);
        ofFloat4.setStartDelay(210L);
        ofFloat5.setStartDelay(280L);
        ofFloat6.setStartDelay(350L);
        ofFloat.setDuration(250L);
        ofFloat2.setDuration(250L);
        ofFloat3.setDuration(250L);
        ofFloat4.setDuration(250L);
        ofFloat5.setDuration(250L);
        ofFloat6.setDuration(250L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13106c.setVisibility(0);
            }
        });
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13108e.setVisibility(0);
            }
        });
        ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13109f.setVisibility(0);
            }
        });
        ofFloat4.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13110g.setVisibility(0);
            }
        });
        ofFloat5.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13111h.setVisibility(0);
            }
        });
        ofFloat6.addListener(new AnimatorListenerAdapter() { // from class: com.fimi.soul.module.login.UsbConnectFragment.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                UsbConnectFragment.this.f13112i.setVisibility(0);
            }
        });
        if (getArguments() == null || !getArguments().getBoolean("isEnterLoginFragment", false)) {
            this.f13106c.setVisibility(0);
            this.f13108e.setVisibility(0);
            this.f13109f.setVisibility(0);
            this.f13110g.setVisibility(0);
            this.f13111h.setVisibility(0);
            this.f13112i.setVisibility(0);
            return;
        }
        ofFloat.start();
        ofFloat2.start();
        ofFloat3.start();
        ofFloat4.start();
        ofFloat5.start();
        ofFloat6.start();
    }

    /* renamed from: a */
    public void m8580a(boolean z) {
        if (this.f13106c == null) {
            return;
        }
        if (z) {
            this.f13106c.setText(C2300R.C2303string.usb_connect_camera_title);
            this.f13117n.setText(C2300R.C2303string.usb_connect_camera_one);
            this.f13118o.setText(C2300R.C2303string.usb_connect_camera_two);
            this.f13121r.setVisibility(8);
            this.f13119p.setText(C2300R.C2303string.usb_connect_camera_three);
            this.f13122s.setText(C2300R.C2303string.usb_connect_camera_three_child);
            this.f13120q.setText(C2300R.C2303string.usb_connect_camera_four);
            return;
        }
        this.f13106c.setText(C2300R.C2303string.please_connect_micraft);
        this.f13117n.setText(C2300R.C2303string.connect_hardware);
        this.f13118o.setText(C2300R.C2303string.open_remote_batter);
        this.f13121r.setText(C2300R.C2303string.short_long_batter);
        this.f13121r.setVisibility(0);
        this.f13119p.setText(C2300R.C2303string.open_micraft_batter);
        this.f13122s.setText(C2300R.C2303string.short_long_micraft);
        this.f13120q.setText(C2300R.C2303string.connect_ipone_remote);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        m8579b();
        this.f13123t.mo8567e();
        return false;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
            } else if (C3658ar.m7575h(this.f13113j).booleanValue()) {
                this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
                this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
            }
        } else if (i == this.f13126w) {
            if (!C3658ar.m7593c(getActivity().getApplicationContext())) {
                C2284z.m12696a(getActivity(), (int) C2300R.C2303string.connectRcWifi, 3000);
            } else {
                this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
            }
        }
        if (intent == null) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13113j = activity;
        this.f13123t = (AbstractC3371a) activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.noconnect_bt /* 2131493126 */:
                if (this.f13123t != null) {
                    this.f13123t.mo8566f();
                }
                CameraValue.isAutoConnect = false;
                return;
            case C2300R.C2302id.next_bt /* 2131493601 */:
                if (C2110f.m13670a().m13668b() != EnumC2091b.DRONE) {
                    if (!this.f13104a.isWifiEnabled()) {
                        this.f13104a.setWifiEnabled(true);
                    }
                    startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), this.f13126w);
                    CameraValue.isAutoConnect = true;
                    return;
                } else if (this.f13125v == null || (!this.f13125v.mo11217ab().mo10898a() && !this.f13125v.mo11216ac())) {
                    m8583a();
                    return;
                } else {
                    this.f13124u.sendMessageDelayed(Message.obtain(), 300L);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13104a = (WifiManager) this.f13113j.getSystemService("wifi");
        this.f13125v = ((DroidPlannerApp) getActivity().getApplication()).f7895a;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_usbconnect, viewGroup, false);
        m8578b(inflate);
        m8582a(inflate);
        if (C2110f.m13670a().m13668b() != EnumC2091b.DRONE) {
            m8580a(true);
        } else {
            m8580a(false);
        }
        this.f13124u = new Handler(this);
        return inflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean m8524c = C3389f.m8524c(getActivity());
        Log.i("UsbConnectFragment", "onResume, hasLocaltionPermissions: " + m8524c);
        if (!m8524c) {
            C3389f.m8521f(getActivity());
        }
    }
}
