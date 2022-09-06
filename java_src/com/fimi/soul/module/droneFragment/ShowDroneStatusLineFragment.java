package com.fimi.soul.module.droneFragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.Fragment;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2277v;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.p178g.AbstractC2453e;
import com.fimi.soul.biz.p178g.C2446b;
import com.fimi.soul.biz.p178g.C2448d;
import com.fimi.soul.biz.p178g.C2457h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2940x;
import com.fimi.soul.entity.ErrorMode;
import com.fimi.soul.module.calibcompass.CaliCompassActivity;
import com.fimi.soul.module.droneui.DialogC3297a;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.remote.RemoteCalibration;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3662as;
import com.fimi.soul.view.AutoScrollTextView;
import com.fimi.soul.view.C3793d;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class ShowDroneStatusLineFragment extends Fragment implements Handler.Callback, View.OnClickListener, AbstractC2453e, C2678d.AbstractC2680b {

    /* renamed from: a */
    public static boolean f11782a = false;

    /* renamed from: A */
    private C3057d f11783A;

    /* renamed from: C */
    private Timer f11785C;

    /* renamed from: D */
    private Button f11786D;

    /* renamed from: E */
    private ImageView f11787E;

    /* renamed from: F */
    private C2448d f11788F;

    /* renamed from: G */
    private C2457h f11789G;

    /* renamed from: H */
    private C3793d f11790H;

    /* renamed from: I */
    private C2446b f11791I;

    /* renamed from: J */
    private String f11792J;

    /* renamed from: L */
    private ErrorMode f11794L;

    /* renamed from: M */
    private boolean f11795M;

    /* renamed from: N */
    private FlightActivity.AbstractC3281a f11796N;

    /* renamed from: b */
    C2277v f11797b;

    /* renamed from: i */
    private DroidPlannerApp f11804i;

    /* renamed from: j */
    private C2657a f11805j;

    /* renamed from: k */
    private DialogC3297a f11806k;

    /* renamed from: l */
    private Context f11807l;

    /* renamed from: m */
    private TextView f11808m;

    /* renamed from: n */
    private TextView f11809n;

    /* renamed from: o */
    private AutoScrollTextView f11810o;

    /* renamed from: p */
    private Button f11811p;

    /* renamed from: q */
    private ImageView f11812q;

    /* renamed from: r */
    private ImageView f11813r;

    /* renamed from: s */
    private ImageView f11814s;

    /* renamed from: t */
    private ImageView f11815t;

    /* renamed from: u */
    private ImageView f11816u;

    /* renamed from: v */
    private ImageView f11817v;

    /* renamed from: w */
    private final int f11818w = 0;

    /* renamed from: x */
    private final int f11819x = 1;

    /* renamed from: y */
    private final int f11820y = 2;

    /* renamed from: z */
    private Handler f11821z = new Handler(this);

    /* renamed from: B */
    private boolean f11784B = false;

    /* renamed from: K */
    private Observer f11793K = new Observer() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusLineFragment.1
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            Point point = new Point();
            Display defaultDisplay = ShowDroneStatusLineFragment.this.getActivity().getWindow().getWindowManager().getDefaultDisplay();
            defaultDisplay.getSize(point);
            if (ShowDroneStatusLineFragment.this.f11786D.isShown() || ShowDroneStatusLineFragment.this.f11811p.isShown()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ShowDroneStatusLineFragment.this.f11810o.getLayoutParams();
                layoutParams.width = defaultDisplay.getWidth() * 0;
                layoutParams.addRule(0, ShowDroneStatusLineFragment.this.f11814s.getId());
                layoutParams.setMargins((int) (defaultDisplay.getHeight() * 0.01851d), (int) (defaultDisplay.getHeight() * 0.036d), (int) (defaultDisplay.getHeight() * 0.01851d), 0);
                layoutParams.addRule(1, ShowDroneStatusLineFragment.this.f11816u.getId());
                ShowDroneStatusLineFragment.this.f11810o.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ShowDroneStatusLineFragment.this.f11810o.getLayoutParams();
            layoutParams2.width = defaultDisplay.getWidth() * 0;
            layoutParams2.addRule(0, ShowDroneStatusLineFragment.this.f11815t.getId());
            layoutParams2.setMargins((int) (defaultDisplay.getHeight() * 0.01851d), (int) (defaultDisplay.getHeight() * 0.036d), (int) (defaultDisplay.getHeight() * 0.01851d), 0);
            layoutParams2.addRule(1, ShowDroneStatusLineFragment.this.f11816u.getId());
            ShowDroneStatusLineFragment.this.f11810o.setLayoutParams(layoutParams2);
        }
    };

    /* renamed from: c */
    int f11798c = 0;

    /* renamed from: d */
    int f11799d = 0;

    /* renamed from: e */
    long f11800e = 0;

    /* renamed from: f */
    boolean f11801f = false;

    /* renamed from: g */
    int f11802g = 0;

    /* renamed from: h */
    int f11803h = 0;

    /* renamed from: a */
    private void m9600a(int i, int i2, int i3) {
        if (this.f11806k != null && this.f11806k.isShowing()) {
            this.f11806k.dismiss();
            this.f11806k = null;
        }
        this.f11806k = new DialogC3297a(getActivity(), getString(i), getString(i2), i3, 3, false, new DialogC3297a.AbstractC3300a() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusLineFragment.4
            @Override // com.fimi.soul.module.droneui.DialogC3297a.AbstractC3300a
            /* renamed from: a */
            public void mo8080a() {
                if (ShowDroneStatusLineFragment.this.f11806k != null) {
                    ShowDroneStatusLineFragment.this.f11806k.dismiss();
                    ShowDroneStatusLineFragment.this.f11806k = null;
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
                if (ShowDroneStatusLineFragment.this.f11806k != null) {
                    ShowDroneStatusLineFragment.this.f11806k.dismiss();
                    ShowDroneStatusLineFragment.this.f11806k = null;
                }
            }
        });
        this.f11806k.setCancelable(true);
        this.f11806k.show();
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m9599a(C2940x c2940x) {
        int i;
        int i2;
        int i3;
        int i4 = C2300R.C2303string.des_sky_landing_BAT_LOWPOWER;
        int i5 = 0;
        if (c2940x.m10121T()) {
            if (this.f11805j.m11312at().m10702e() == 7 || this.f11805j.m11312at().m10702e() == 8) {
                i3 = C2300R.C2303string.sky_lowpower_return;
                i4 = C2300R.C2303string.sky_lowpower_return_result;
            } else if (this.f11805j.m11312at().m10702e() == 9) {
                i3 = C2300R.C2303string.sky_landing_BAT_LOWPOWER;
            } else {
                i3 = C2300R.C2303string.sky_LOWPOWER;
                i4 = C2300R.C2303string.sky_LOWPOWER_result;
            }
            i = C2300R.C2301drawable.low_battery;
            i5 = i3;
            i2 = C2300R.C2303string.sky_LOWPOWER_title;
        } else if (this.f11805j.m11290j() != null && (this.f11805j.m11290j().m10721b() == 1 || this.f11805j.m11290j().m10721b() == 3)) {
            switch (this.f11805j.m11290j().m10721b()) {
                case 1:
                    i5 = C2300R.C2303string.sky_no_fly_error;
                    i2 = C2300R.C2303string.sky_no_fly_error_title;
                    i4 = C2300R.C2303string.sky_no_fly_result;
                    break;
                case 2:
                    i5 = C2300R.C2303string.restricted_alttiude_zone;
                    i2 = C2300R.C2303string.restricted_alttiude_zone_title;
                    i4 = C2300R.C2303string.sky_no_fly_result;
                    break;
                case 3:
                    i2 = C2300R.C2303string.sky_land_error_title;
                    i5 = C2300R.C2303string.sky_land_error;
                    break;
                default:
                    i4 = C2300R.C2303string.fault_back_battery_des;
                    i2 = 0;
                    break;
            }
            i = C2300R.C2301drawable.no_fly_zone;
        } else if (c2940x.m10074m()) {
            i5 = C2300R.C2303string.sky_BATTERY_ERROR;
            i2 = C2300R.C2303string.sky_BATTERY_ERROR_title;
            i4 = C2300R.C2303string.sky_BATTERY_ERROR_result;
            i = C2300R.C2301drawable.battery_abnormal;
        } else if (c2940x.m10081f() && !this.f11805j.m11312at().m10700g().isLightStream()) {
            i5 = C2300R.C2303string.sky_GPS_ERROR;
            i2 = C2300R.C2303string.sky_GPS_ERROR_title;
            i4 = C2300R.C2303string.sky_GPS_ERROR_result;
            i = C2300R.C2301drawable.plane_fall_bg;
        } else if (c2940x.m10135F()) {
            i5 = C2300R.C2303string.sky_bat_damage;
            i2 = C2300R.C2303string.title_bat_damage;
            i4 = C2300R.C2303string.result_bat_damage;
            i = C2300R.C2301drawable.battery_abnormal;
        } else if (c2940x.m10136E()) {
            i5 = C2300R.C2303string.sky_bat_dischage_warning;
            i2 = C2300R.C2303string.title_bat_dischage_warning;
            i4 = C2300R.C2303string.result_bat_dischage_warning;
            i = C2300R.C2301drawable.battery_abnormal;
        } else if (c2940x.m10133H()) {
            i5 = C2300R.C2303string.sky_desc_bat_comm_error;
            i2 = C2300R.C2303string.sky_bat_comm_error;
            i4 = C2300R.C2303string.sky_desc_bat_comm_error2;
            i = C2300R.C2301drawable.battery_abnormal;
        } else if (c2940x.m10103ai()) {
            i5 = C2300R.C2303string.shortlife_sky_BATTERY_ERROR;
            i2 = C2300R.C2303string.shortlife_sky__BATTERY_ERROR_title;
            i4 = C2300R.C2303string.shortlife_sky__BATTERY_ERROR_result;
            i = C2300R.C2301drawable.battery_abnormal;
        } else if (this.f11805j.m11312at().m10700g().isLightStream() && c2940x.m10071p()) {
            i5 = C2300R.C2303string.sky_VPS_ERROR;
            i2 = C2300R.C2303string.sky_VPS_ERROR_title;
            i4 = C2300R.C2303string.sky_VPS_ERROR_result;
            i = C2300R.C2301drawable.plane_fall_bg;
        } else if (c2940x.m10122S()) {
            i5 = C2300R.C2303string.sky_LP_RETURN;
            i2 = C2300R.C2303string.sky_LP_RETURN_title;
            i4 = C2300R.C2303string.sky_LP_RETURN_result;
            i = C2300R.C2301drawable.plane_fall_bg;
        } else if (c2940x.m10123R()) {
            i5 = C2300R.C2303string.sky_BAT_light_LOWPOWER;
            i2 = C2300R.C2303string.sky_BAT_light_LOWPOWER_title;
            i4 = C2300R.C2303string.sky_BAT_light_LOWPOWER_result;
            i = C2300R.C2301drawable.plane_fall_bg;
        } else if (!c2940x.m10117X()) {
            this.f11799d = 0;
            return;
        } else {
            i = C2300R.C2301drawable.img_warning_rocker;
            i2 = C2300R.C2303string.stick_move_warning_title;
            i4 = C2300R.C2303string.stick_move_warning_result;
            i5 = C2300R.C2303string.stick_move_warning_des;
        }
        if (this.f11799d != i5 && i != 0 && i2 != 0) {
            m9600a(i2, i4, i);
        }
        this.f11799d = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public float m9587b(String str) {
        new DisplayMetrics();
        float f = getResources().getDisplayMetrics().density;
        TextPaint textPaint = new TextPaint();
        Rect rect = new Rect();
        textPaint.setTextSize(13.0f);
        textPaint.getTextBounds(str, 0, str.length(), rect);
        return f * rect.width();
    }

    /* renamed from: b */
    private void m9592b() {
        this.f11816u.setVisibility(0);
    }

    /* renamed from: b */
    private void m9590b(int i, int i2) {
        this.f11811p.setVisibility(i2);
        if (!getString(i).equals(this.f11811p.getText().toString())) {
            this.f11811p.setText(i);
        }
        this.f11814s.setVisibility(i2);
        this.f11811p.setEnabled(true);
        this.f11791I.m12159a(true);
    }

    /* renamed from: c */
    private void m9585c() {
        this.f11816u.setVisibility(4);
    }

    /* renamed from: c */
    private void m9583c(int i, int i2) {
        this.f11811p.setVisibility(i2);
        if (!"".equals(this.f11811p.getText().toString())) {
            this.f11811p.setText("");
        }
        this.f11814s.setVisibility(i2);
        this.f11811p.setEnabled(false);
        this.f11791I.m12159a(false);
    }

    /* renamed from: c */
    private void m9580c(boolean z) {
        int i = 0;
        this.f11786D.setVisibility(z ? 0 : 4);
        this.f11791I.m12159a(z);
        ImageView imageView = this.f11787E;
        if (!z) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    /* renamed from: c */
    private boolean m9581c(String str) {
        if (str == null || !str.contains(":")) {
            return false;
        }
        try {
            Integer.valueOf(str.split(":")[0]).intValue();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    private void m9579d() {
        int i;
        int i2;
        if (!isAdded()) {
            return;
        }
        if (!this.f11805j.mo11216ac() && !this.f11805j.m11332aC()) {
            C2244b.m13099b(C2238c.m13124d()).m13100b();
            return;
        }
        this.f11794L = this.f11789G.m12124a(this.f11805j);
        ArrayList lightErrorList = this.f11794L.getLightErrorList();
        if (lightErrorList.size() <= this.f11798c) {
            this.f11798c = 0;
        }
        if (this.f11805j.m11320al()) {
            if (this.f11805j.m11318an().m10118W()) {
                this.f11803h++;
                if (this.f11803h >= 3) {
                    m9600a(C2300R.C2303string.title_sky_bat_lowpower_dangerous, C2300R.C2303string.des_sky_bat_lowpower_dangerous, C2300R.C2301drawable.plane_fall_bg);
                    C2244b.m13099b(C2238c.m13124d()).m13103a(C2238c.m13124d().getString(C2300R.C2303string.sky_bat_lowpower_dangerous));
                    C3662as.m7563a(C2238c.m13124d(), 2000L);
                    this.f11803h = 0;
                }
            } else if (this.f11805j.m11318an().m10121T()) {
                this.f11803h++;
                if (this.f11803h >= 4) {
                    if (this.f11805j.m11312at().m10702e() == 7 || this.f11805j.m11312at().m10702e() == 8) {
                        i = C2300R.C2303string.sky_lowpower_return;
                        i2 = C2300R.C2303string.sky_lowpower_return_result;
                    } else if (this.f11805j.m11312at().m10702e() == 9) {
                        i = C2300R.C2303string.sky_landing_BAT_LOWPOWER;
                        i2 = C2300R.C2303string.des_sky_landing_BAT_LOWPOWER;
                    } else {
                        i = C2300R.C2303string.sky_LOWPOWER;
                        i2 = C2300R.C2303string.sky_LOWPOWER_result;
                    }
                    m9600a(C2300R.C2303string.title_sky_landing_BAT_LOWPOWER, i2, C2300R.C2301drawable.plane_fall_bg);
                    C2244b.m13099b(C2238c.m13124d()).m13103a(C2238c.m13124d().getString(i));
                    C3662as.m7563a(C2238c.m13124d(), 2000L);
                    this.f11803h = 0;
                }
            }
        }
        if (lightErrorList == null || lightErrorList.size() <= 0) {
            m9576d("");
            m9585c();
        } else {
            m9592b();
            this.f11810o.setTextColor(getResources().getColor(C2300R.color.warmtextcl));
            m9576d(getText(((Integer) lightErrorList.get(this.f11798c)).intValue()).toString());
        }
        this.f11798c++;
        if ((this.f11794L.isCompassFault() || this.f11794L.isMiddleFault()) && !this.f11805j.m11320al()) {
            m9580c(true);
            this.f11786D.setText(getString(C2300R.C2303string.platform_correct));
            this.f11817v.setVisibility(4);
            return;
        }
        m9580c(false);
        if (this.f11794L.getSeriousErrorList().size() <= 0 || this.f11811p.getVisibility() == 0) {
            this.f11817v.setVisibility(4);
        } else {
            this.f11817v.setVisibility(0);
        }
    }

    /* renamed from: d */
    private void m9578d(int i) {
        if (isAdded()) {
            if (getString(C2300R.C2303string.self_error_result).equals(this.f11808m.getText().toString())) {
                this.f11812q.setImageResource(C2300R.C2301drawable.notnormal_icon);
                this.f11812q.setTag(Integer.valueOf((int) C2300R.C2301drawable.notnormal_icon));
            } else if (this.f11812q.getTag() == null) {
                this.f11812q.setImageResource(i);
                this.f11812q.setTag(Integer.valueOf(i));
            } else if (i == ((Integer) this.f11812q.getTag()).intValue()) {
            } else {
                this.f11812q.setImageResource(i);
                this.f11812q.setTag(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: d */
    private void m9576d(String str) {
        if (str == null || str.equals(this.f11810o.getText().toString())) {
            return;
        }
        this.f11810o.setText(str, TextView.BufferType.NORMAL);
    }

    /* renamed from: e */
    private void m9575e(int i) {
        if (this.f11821z.hasMessages(0) || getString(i).equals(this.f11810o.getText())) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = Integer.valueOf(i);
        this.f11821z.sendMessageDelayed(obtain, 2500L);
    }

    /* renamed from: f */
    private void m9573f(int i) {
        if (i == 0 || getString(i).equals(this.f11808m.getText().toString())) {
            return;
        }
        this.f11808m.setText(i);
    }

    /* renamed from: a */
    public int m9603a() {
        return this.f11802g;
    }

    @Override // com.fimi.soul.biz.p178g.AbstractC2453e
    /* renamed from: a */
    public void mo9602a(int i) {
        m9573f(i);
    }

    @Override // com.fimi.soul.biz.p178g.AbstractC2453e
    /* renamed from: a */
    public void mo9601a(int i, int i2) {
        if (i > 0) {
            m9590b(i, i2);
        } else {
            m9583c(i, i2);
        }
    }

    /* renamed from: a */
    public void m9595a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11796N = abstractC3281a;
    }

    /* renamed from: a */
    public void m9594a(String str) {
        if (m9581c(str)) {
            if (getActivity() != null) {
                C3658ar.m7598b(getActivity().getAssets(), this.f11809n);
            }
            this.f11809n.setTextSize(1, 16.5f);
            this.f11809n.setPadding(0, 0, 0, 0);
            this.f11813r.setVisibility(0);
        } else {
            if (getActivity() != null) {
                C3658ar.m7612a(getActivity().getAssets(), this.f11809n);
            }
            this.f11809n.setTextSize(1, 13.0f);
            this.f11809n.setTextColor(-1);
            this.f11809n.setPadding(0, (int) ((14.0f * getResources().getDisplayMetrics().density) / 3.0f), 0, 0);
            this.f11813r.setVisibility(4);
        }
        this.f11809n.setText(str);
    }

    /* renamed from: a */
    public void m9593a(boolean z) {
        if (z && System.currentTimeMillis() - this.f11800e >= 800) {
            this.f11800e = System.currentTimeMillis();
            if (this.f11801f) {
                this.f11801f = false;
                this.f11813r.setImageDrawable(null);
            } else {
                this.f11801f = true;
                this.f11813r.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.record_time_red_dot));
            }
            this.f11809n.setAlpha(1.0f);
            this.f11813r.invalidate();
        }
        if (!z) {
            this.f11813r.setImageDrawable(getResources().getDrawable(C2300R.C2301drawable.gray_point));
            this.f11809n.setAlpha(0.3f);
        }
    }

    @Override // com.fimi.soul.biz.p178g.AbstractC2453e
    /* renamed from: b */
    public void mo9591b(int i) {
        m9578d(i);
    }

    /* renamed from: b */
    public void m9586b(boolean z) {
        this.f11795M = z;
    }

    /* renamed from: c */
    public void m9584c(int i) {
        if (i <= 0) {
            return;
        }
        this.f11802g = i;
        m9594a(getString(i));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            if (!this.f11805j.mo11216ac()) {
                return false;
            }
            m9576d(getString(((Integer) message.obj).intValue()));
            return false;
        } else if (message.what == 1) {
            m9579d();
            return false;
        } else if (message.what != 2) {
            return false;
        } else {
            m9578d(C2300R.C2301drawable.normal_icon);
            this.f11808m.setText(getString(C2300R.C2303string.self_vps_ok_result));
            return false;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11804i = (DroidPlannerApp) activity.getApplication();
        this.f11805j = this.f11804i.f7895a;
        this.f11807l = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.fault_bnt /* 2131493879 */:
                this.f11794L = this.f11789G.m12124a(this.f11805j);
                this.f11790H.m7052a(this.f11794L.getSeriousErrorList(), view, (int) getResources().getDimension(C2300R.dimen.popuwindows_xoff), (int) getResources().getDimension(C2300R.dimen.popuwindows_yoff));
                return;
            case C2300R.C2302id.linecalibration /* 2131493880 */:
            case C2300R.C2302id.lineend /* 2131493883 */:
            case C2300R.C2302id.camertime /* 2131493884 */:
            default:
                return;
            case C2300R.C2302id.dronemoelbutton /* 2131493881 */:
                if (this.f11805j.mo11217ab().mo10898a() && this.f11805j.mo11216ac()) {
                    this.f11783A.m9816d();
                    this.f11805j.mo11220a(C2678d.EnumC2679a.NOTIDRONEAIR);
                    return;
                }
                this.f11797b.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
                ((C2423d) C2379b.m12410a().m12394d()).n();
                Intent intent = new Intent(this.f11807l, LoginActivity.class);
                intent.putExtra(AbstractC2089b.f6992j, 2);
                intent.putExtra("login", false);
                startActivity(intent);
                return;
            case C2300R.C2302id.compass_calibration /* 2131493882 */:
                if (this.f11794L != null && this.f11794L.isMiddleFault()) {
                    startActivity(new Intent(getActivity(), RemoteCalibration.class));
                    return;
                } else if (this.f11794L == null || !this.f11794L.isCompassFault()) {
                    return;
                } else {
                    Intent intent2 = new Intent(getActivity(), CaliCompassActivity.class);
                    intent2.putExtra(C2353b.f7926Q, true);
                    startActivity(intent2);
                    return;
                }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11789G = C2457h.m12125a();
        this.f11791I = new C2446b();
        this.f11791I.addObserver(this.f11793K);
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.showstatusline, (ViewGroup) null);
        this.f11808m = (TextView) inflate.findViewById(C2300R.C2302id.dronestuts);
        this.f11808m.getPaint().setFakeBoldText(true);
        this.f11816u = (ImageView) inflate.findViewById(C2300R.C2302id.divide_line);
        this.f11810o = (AutoScrollTextView) inflate.findViewById(C2300R.C2302id.dronerrorcode);
        this.f11809n = (TextView) inflate.findViewById(C2300R.C2302id.camertime);
        this.f11809n.setOnClickListener(this);
        this.f11811p = (Button) inflate.findViewById(C2300R.C2302id.dronemoelbutton);
        this.f11811p.setOnClickListener(this);
        this.f11786D = (Button) inflate.findViewById(C2300R.C2302id.compass_calibration);
        this.f11786D.setOnClickListener(this);
        this.f11812q = (ImageView) inflate.findViewById(C2300R.C2302id.headview);
        this.f11813r = (ImageView) inflate.findViewById(C2300R.C2302id.camericon);
        this.f11814s = (ImageView) inflate.findViewById(C2300R.C2302id.linestart);
        this.f11815t = (ImageView) inflate.findViewById(C2300R.C2302id.lineend);
        this.f11787E = (ImageView) inflate.findViewById(C2300R.C2302id.linecalibration);
        this.f11817v = (ImageView) inflate.findViewById(C2300R.C2302id.fault_bnt);
        this.f11817v.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f11808m, this.f11810o, this.f11811p);
        C3658ar.m7598b(getActivity().getAssets(), this.f11809n);
        this.f11783A = C3057d.m9823a(this.f11805j);
        m9584c(C2300R.C2303string.fault_camera);
        this.f11790H = new C3793d(getActivity(), (int) getResources().getDimension(C2300R.dimen.popuwindows_w), 400);
        f11782a = true;
        this.f11810o.m7380a(0.0f);
        this.f11810o.setEnabled(false);
        this.f11810o.addTextChangedListener(new TextWatcher() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusLineFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!"".equals(charSequence.toString())) {
                    ShowDroneStatusLineFragment.this.f11792J = charSequence.toString();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("".equals(charSequence.toString()) || charSequence.toString().equals(ShowDroneStatusLineFragment.this.f11792J)) {
                    return;
                }
                int measuredWidth = ShowDroneStatusLineFragment.this.f11810o.getMeasuredWidth();
                new Paint().setTextSize(ShowDroneStatusLineFragment.this.f11810o.getTextSize());
                if (ShowDroneStatusLineFragment.this.m9587b(charSequence.toString()) <= measuredWidth) {
                    ShowDroneStatusLineFragment.this.f11810o.m7379b();
                } else if (ShowDroneStatusLineFragment.this.f11810o.f15145b) {
                } else {
                    ShowDroneStatusLineFragment.this.f11810o.m7381a();
                }
            }
        });
        this.f11785C = new Timer();
        this.f11785C.schedule(new TimerTask() { // from class: com.fimi.soul.module.droneFragment.ShowDroneStatusLineFragment.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ShowDroneStatusLineFragment.this.f11821z.sendEmptyMessage(1);
            }
        }, 0L, 3000L);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11791I.deleteObserver(this.f11793K);
        this.f11805j.mo11214b(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (c2657a.mo11216ac() && c2657a.mo11217ab().mo10898a()) {
            this.f11784B = true;
            if (getResources().getColor(C2300R.color.white) != this.f11808m.getCurrentTextColor()) {
                this.f11808m.setTextColor(getResources().getColor(C2300R.color.white));
            }
            switch (enumC2679a) {
                case Remotecontrol:
                case NOFLYZONE:
                default:
                    return;
                case ERROR_CODE:
                    C2940x m11318an = c2657a.m11318an();
                    if (m11318an.m10114a() < 0 && c2657a.m11290j() == null) {
                        this.f11799d = 0;
                        this.f11817v.setVisibility(4);
                        return;
                    } else if (c2657a.m11320al()) {
                        m9599a(m11318an);
                        return;
                    } else {
                        this.f11799d = 0;
                        return;
                    }
            }
        }
        switch (enumC2679a) {
            case Remotecontrol:
                if (!c2657a.mo11216ac()) {
                    C3630aa.m7737d();
                    this.f11808m.setTextColor(getResources().getColor(C2300R.color.white));
                    m9578d(C2300R.C2301drawable.notnormal_icon);
                    this.f11808m.setText(C2300R.C2303string.uncondrone);
                    this.f11811p.setVisibility(4);
                    if (this.f11794L != null && !this.f11794L.isMiddleFault()) {
                        m9580c(false);
                    }
                    this.f11814s.setVisibility(4);
                    break;
                }
                break;
            case CLEANALLOBJ:
                C3630aa.m7737d();
                this.f11808m.setText(C2300R.C2303string.dis_connect_phone);
                m9576d("");
                m9578d(C2300R.C2301drawable.notnormal_red_icon);
                this.f11808m.setTextColor(getResources().getColor(C2300R.color.errortextcl));
                this.f11811p.setVisibility(0);
                m9580c(false);
                m9590b(C2300R.C2303string.connectagain, 0);
                this.f11814s.setVisibility(0);
                if (this.f11784B && c2657a.m11320al()) {
                    this.f11784B = false;
                    C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.dis_connect_phone));
                    break;
                }
                break;
        }
        m9576d("");
        this.f11816u.setVisibility(4);
        if (this.f11794L != null && this.f11794L.getLightErrorList().size() == 0) {
            m9576d("");
            m9585c();
            this.f11810o.m7380a(0.0f);
            this.f11810o.m7379b();
        }
        this.f11817v.setVisibility(4);
        this.f11802g = 0;
        this.f11799d = 0;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11797b = C2277v.m12784a(getActivity());
        if (this.f11788F == null) {
            this.f11788F = new C2448d(this, this.f11805j, getActivity());
        }
        this.f11805j.mo11219a(this);
        this.f11788F.m12150c();
        this.f11788F.m12146e();
        if (this.f11805j.mo11216ac() || this.f11805j.mo11217ab().mo10898a()) {
            return;
        }
        m9590b(C2300R.C2303string.connect_rn, 0);
        this.f11808m.setText(C2300R.C2303string.connectdefault);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f11788F.m12148d();
    }
}
