package com.fimi.soul.module.calibcompass;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2927k;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.calibcompass.BaseCaliCompassFragment;
import com.fimi.soul.module.calibcompass.CaliComPassFirstFragment;
import com.fimi.soul.module.calibcompass.CaliComPassThirdFragment;
import com.fimi.soul.module.calibcompass.CaliCompassErrorFragment;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.p211a.C3627b;
import com.fimi.soul.view.CompassMeterView;
import com.fimi.soul.view.DialogC3800f;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.Iterator;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* loaded from: classes.dex */
public class CaliCompassActivity extends BaseActivity implements View.OnClickListener, BaseCaliCompassFragment.AbstractC3058a, CaliComPassFirstFragment.AbstractC3061a, CaliComPassThirdFragment.AbstractC3063a, CaliCompassErrorFragment.AbstractC3070a {

    /* renamed from: a */
    private CaliComPassFirstFragment f11409a;

    /* renamed from: b */
    private CaliCompassSecondFragment f11410b;

    /* renamed from: c */
    private CaliCompassErrorFragment f11411c;

    /* renamed from: d */
    private CaliComPassThirdFragment f11412d;

    /* renamed from: e */
    private CaliCompassFourFragment f11413e;

    /* renamed from: f */
    private CaliCompassErrorVertialFragment f11414f;

    /* renamed from: g */
    private CaliCompassStatusFragment f11415g;

    /* renamed from: h */
    private FragmentManager f11416h;

    /* renamed from: i */
    private boolean f11417i;

    /* renamed from: j */
    private boolean f11418j;

    /* renamed from: l */
    private boolean f11420l;

    /* renamed from: p */
    private boolean f11424p;

    /* renamed from: q */
    private TextView f11425q;

    /* renamed from: r */
    private Button f11426r;

    /* renamed from: t */
    private CompassMeterView f11428t;

    /* renamed from: u */
    private RelativeLayout f11429u;

    /* renamed from: v */
    private TextView f11430v;

    /* renamed from: k */
    private boolean f11419k = true;

    /* renamed from: m */
    private final int f11421m = 11;

    /* renamed from: n */
    private final int f11422n = 12;

    /* renamed from: o */
    private final int f11423o = 13;

    /* renamed from: s */
    private Handler f11427s = new Handler() { // from class: com.fimi.soul.module.calibcompass.CaliCompassActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 11:
                default:
                    return;
                case 12:
                    if (CaliCompassActivity.this.f11409a == null) {
                        return;
                    }
                    CaliCompassActivity.this.f11424p = true;
                    CaliCompassActivity.this.f11409a.m9794a(true);
                    return;
                case 13:
                    if (!CaliCompassActivity.this.drone.mo11216ac() && CaliCompassActivity.this.drone.mo11217ab().mo10898a()) {
                        CaliCompassActivity.this.m9788a(C2300R.C2303string.GC_caliFail_discon_drone, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
                        return;
                    } else if (CaliCompassActivity.this.drone.mo11217ab().mo10898a()) {
                        return;
                    } else {
                        CaliCompassActivity.this.m9788a(C2300R.C2303string.GC_caliFail_discon, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
                        return;
                    }
            }
        }
    };

    /* renamed from: w */
    private boolean f11431w = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9788a(int i, String str, boolean z, boolean z2) {
        m9783a(getString(C2300R.C2303string.calicompassesucess));
        if (this.f11419k) {
            Iterator<Fragment> it2 = this.f11416h.getFragments().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Fragment next = it2.next();
                if (next != null && next.isVisible()) {
                    Fragment findFragmentByTag = this.f11416h.findFragmentByTag(str);
                    if ((findFragmentByTag instanceof CaliCompassErrorFragment) && findFragmentByTag.isHidden()) {
                        ((CaliCompassErrorFragment) findFragmentByTag).m9773a(getString(i), z, z2);
                        this.f11416h.beginTransaction().hide(next).show(findFragmentByTag).commitAllowingStateLoss();
                    }
                }
            }
        }
        this.f11415g.m9757a(false);
    }

    /* renamed from: a */
    private void m9787a(Bundle bundle) {
        this.f11416h = getSupportFragmentManager();
        if (bundle == null) {
            this.f11415g = (CaliCompassStatusFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_begin);
            if (this.f11415g == null) {
                this.f11415g = new CaliCompassStatusFragment();
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_begin, this.f11415g, "begin").commitAllowingStateLoss();
            this.f11409a = (CaliComPassFirstFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_first);
            if (this.f11409a == null) {
                this.f11409a = new CaliComPassFirstFragment();
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_first, this.f11409a, "first").hide(this.f11409a).commitAllowingStateLoss();
            this.f11410b = (CaliCompassSecondFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_second);
            if (this.f11410b == null) {
                this.f11410b = new CaliCompassSecondFragment();
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_second, this.f11410b, "second").hide(this.f11410b).commitAllowingStateLoss();
            this.f11411c = (CaliCompassErrorFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_error);
            if (this.f11411c == null) {
                this.f11411c = new CaliCompassErrorFragment();
                this.f11411c.m9772a(this.f11417i);
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_error, this.f11411c, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2).hide(this.f11411c).commitAllowingStateLoss();
            this.f11412d = (CaliComPassThirdFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_thrid);
            if (this.f11412d == null) {
                this.f11412d = new CaliComPassThirdFragment();
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_thrid, this.f11412d, "thrid").hide(this.f11412d).commitAllowingStateLoss();
            this.f11413e = (CaliCompassFourFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_four);
            if (this.f11413e == null) {
                this.f11413e = new CaliCompassFourFragment();
            }
            this.f11413e.m9761a(this.f11417i);
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_four, this.f11413e, "four").hide(this.f11413e).commitAllowingStateLoss();
            this.f11414f = (CaliCompassErrorVertialFragment) this.f11416h.findFragmentById(C2300R.C2302id.compass_error_vertail);
            if (this.f11414f == null) {
                this.f11414f = new CaliCompassErrorVertialFragment();
            }
            this.f11416h.beginTransaction().add(C2300R.C2302id.compass_error_vertail, this.f11414f, "errortratil").hide(this.f11414f).commitAllowingStateLoss();
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment.AbstractC3058a
    /* renamed from: a */
    public void mo9790a() {
        new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.interruptcaliremote)).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.calibcompass.CaliCompassActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.calibcompass.CaliCompassActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (CaliCompassActivity.this.f11411c != null) {
                    CaliCompassActivity.this.f11420l = true;
                    CaliCompassActivity.this.f11411c.m9776a();
                }
                CaliCompassActivity.this.finish();
            }
        }).m7035a().show();
    }

    /* renamed from: a */
    public void m9789a(float f) {
        Log.i("istep", "" + f);
        float abs = Math.abs(1.0f - (f / 10.0f));
        this.f11428t.setEngine(true);
        this.f11428t.setCurrentProgress((int) (100.0f * abs));
        if (0.4d < abs && abs <= 1.0d) {
            this.f11430v.setText(getString(C2300R.C2303string.magnetic_environment_C));
            this.f11430v.setTextColor(getResources().getColor(C2300R.color.magnetic_environment_C));
        } else if (0.2d >= abs || abs > 0.4d) {
            this.f11430v.setText(getString(C2300R.C2303string.magnetic_environment_A));
            this.f11430v.setTextColor(getResources().getColor(C2300R.color.magnetic_environment_A));
        } else {
            this.f11430v.setText(getString(C2300R.C2303string.magnetic_environment_B));
            this.f11430v.setTextColor(getResources().getColor(C2300R.color.magnetic_environment_B));
        }
    }

    /* renamed from: a */
    public void m9783a(String str) {
        this.f11425q.setText(str);
    }

    @Override // com.fimi.soul.module.calibcompass.CaliComPassThirdFragment.AbstractC3063a
    /* renamed from: a */
    public void mo9782a(boolean z) {
        if (!z && this.f11427s.hasMessages(13)) {
            this.f11427s.removeMessages(13);
        }
        this.f11431w = z;
    }

    @Override // com.fimi.soul.module.calibcompass.CaliComPassFirstFragment.AbstractC3061a
    /* renamed from: b */
    public void mo9781b() {
    }

    /* renamed from: c */
    public void m9778c() {
        this.f11428t = (CompassMeterView) findViewById(C2300R.C2302id.campass_meter_h_view);
        this.f11430v = (TextView) findViewById(C2300R.C2302id.campass_info_tv);
        this.f11428t.setTitle(getString(C2300R.C2303string.compass_magnetic_h));
        this.f11429u = (RelativeLayout) findViewById(C2300R.C2302id.leftView);
        this.f11425q = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f11425q.setText(C2300R.C2303string.compass_calibration);
        this.f11426r = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f11426r.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.calibcompass.CaliCompassErrorFragment.AbstractC3070a
    /* renamed from: d */
    public void mo9767d() {
        this.f11418j = true;
        this.f11416h.beginTransaction().hide(this.f11411c).show(this.f11416h.findFragmentByTag("begin")).commitAllowingStateLoss();
    }

    @Override // com.fimi.soul.module.calibcompass.CaliCompassErrorFragment.AbstractC3070a
    /* renamed from: e */
    public void mo9766e() {
        if (this.f11413e != null) {
            this.f11413e.m9764a();
        }
    }

    /* renamed from: f */
    public void m9777f() {
        this.f11430v.setText(C2300R.C2303string.no_use);
        this.f11430v.setTextColor(getResources().getColor(C2300R.color.meter_text));
        this.f11428t.setEngine(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.black_btn /* 2131493817 */:
                if (this.f11415g == null || this.f11415g.isVisible() || this.f11411c == null || this.f11411c.isVisible()) {
                    finish();
                    return;
                } else {
                    mo9790a();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(128, 128);
        super.onCreate(bundle);
        setContentView(C2300R.layout.calicompassmain);
        m9778c();
        this.f11417i = getIntent().getBooleanExtra(C2353b.f7926Q, false);
        m9787a(bundle);
        this.dpa.m12523b(this);
        this.f11427s.sendEmptyMessageDelayed(12, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f11431w = false;
        if (this.speakTTs != null) {
            this.speakTTs.m13092e();
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        switch (enumC2679a) {
            case Remotecontrol:
                if (!c2657a.mo11216ac() && this.f11415g != null && !this.f11415g.isVisible()) {
                    if (!this.f11431w) {
                        m9788a(C2300R.C2303string.GC_caliFail_discon_drone, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
                    } else if (!this.f11427s.hasMessages(13)) {
                        this.f11427s.sendEmptyMessageDelayed(13, AbstractC0517a.f1169e);
                    }
                }
                if (!c2657a.mo11216ac()) {
                    m9777f();
                    break;
                }
                break;
            case HEARDDAY:
                m9789a(c2657a.mo11202w().m10506a());
                break;
            case CLEANALLOBJ:
                m9777f();
                break;
        }
        if (enumC2679a == C2678d.EnumC2679a.CLEANALLOBJ && this.f11415g != null && !this.f11415g.isVisible()) {
            m9788a(C2300R.C2303string.GC_caliFail_discon, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
            m9777f();
        }
        if (this.f11415g == null || this.f11415g.isVisible() || enumC2679a != C2678d.EnumC2679a.CaliCompass) {
            return;
        }
        C2927k m11289k = c2657a.m11289k();
        if (this.f11424p && ((m11289k.m10228d() == 1 || m11289k.m10228d() == 2) && m11289k.m10226e() == 1 && m11289k.m10232b() == 1 && m11289k.m10230c() == 3)) {
            m9788a(C2300R.C2303string.calierrordata, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
        } else if (this.f11418j && ((m11289k.m10228d() == 1 || m11289k.m10228d() == 0) && m11289k.m10226e() == 1 && m11289k.m10232b() == 1 && (m11289k.m10230c() == 1 || m11289k.m10230c() == 0))) {
            this.f11418j = false;
            this.f11419k = true;
            C3057d.m9823a(c2657a).m9833a((byte) 1, (byte) 1, (byte) 1);
        } else if (m11289k.m10230c() != 4) {
            if (m11289k.m10230c() != 5) {
                return;
            }
            m9788a(0, "errortratil", false, false);
        } else if (this.f11420l) {
            m9788a(C2300R.C2303string.calierror, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, true);
        } else {
            m9788a(C2300R.C2303string.calierror, XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, false, false);
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f11415g == null || this.f11415g.isVisible() || this.f11411c == null || this.f11411c.isVisible()) {
            return super.onKeyDown(i, keyEvent);
        }
        mo9790a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (C2277v.m12784a(this).m12742s() != DeviceType.DEVICE_4K) {
            if (C2277v.m12784a(this).m12742s() != DeviceType.DEVICE_1080P) {
                return;
            }
            this.f11429u.setVisibility(8);
        } else if (new C3627b().m7750b(this, this.drone, 1069)) {
            this.f11429u.setVisibility(0);
        } else {
            this.f11429u.setVisibility(8);
        }
    }
}
