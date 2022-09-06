package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p180i.C2472d;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.FlyActionBean;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3796e;
/* loaded from: classes.dex */
public class FlyActionSettingFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    private Button f11590a;

    /* renamed from: b */
    private Button f11591b;

    /* renamed from: c */
    private TextView f11592c;

    /* renamed from: d */
    private AMap f11593d;

    /* renamed from: e */
    private C2657a f11594e;

    /* renamed from: f */
    private PercentRelativeLayout f11595f;

    /* renamed from: g */
    private C2477h f11596g;

    /* renamed from: h */
    private C2277v f11597h;

    /* renamed from: i */
    private View$OnClickListenerC3165d f11598i;

    /* renamed from: j */
    private C3184f f11599j;

    /* renamed from: k */
    private ImageButton f11600k;

    /* renamed from: l */
    private boolean f11601l;

    /* renamed from: m */
    private View$OnClickListenerC3148a f11602m;

    /* renamed from: n */
    private View f11603n;

    /* renamed from: o */
    private Dialog f11604o;

    /* renamed from: p */
    private FlightActivity.AbstractC3281a f11605p;

    /* renamed from: a */
    private void m9669a(View view) {
        this.f11600k = (ImageButton) view.findViewById(C2300R.C2302id.toggleaction);
        this.f11600k.setOnClickListener(this);
        this.f11595f = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.changgeHeight_view);
        this.f11590a = (Button) view.findViewById(C2300R.C2302id.fly_action_cancal_btn);
        this.f11590a.setOnClickListener(this);
        this.f11591b = (Button) view.findViewById(C2300R.C2302id.fly_action_execute_btn);
        this.f11591b.setOnClickListener(this);
        this.f11592c = (TextView) view.findViewById(C2300R.C2302id.title);
        C3658ar.m7612a(getActivity().getAssets(), this.f11590a, this.f11591b, this.f11592c);
        C3658ar.m7598b(getActivity().getAssets(), new View[0]);
    }

    /* renamed from: a */
    private void m9666a(String str) {
        if (this.f11604o != null && this.f11604o.isShowing()) {
            this.f11604o.dismiss();
            this.f11604o = null;
        }
        DialogC3796e.C3797a c3797a = new DialogC3796e.C3797a(getActivity());
        c3797a.m7045a(str);
        c3797a.m7043a(true);
        c3797a.m7044a(getString(C2300R.C2303string.finish), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.FlyActionSettingFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (FlyActionSettingFragment.this.f11596g.m12022a().get() == 2) {
                    C2284z.m12696a(FlyActionSettingFragment.this.getActivity(), (int) C2300R.C2303string.promtt_fly_to, 2000);
                } else if (FlyActionSettingFragment.this.f11596g.m12022a().get() == 1) {
                    C2284z.m12696a(FlyActionSettingFragment.this.getActivity(), (int) C2300R.C2303string.promtt_waypoint, 2000);
                } else if (FlyActionSettingFragment.this.f11596g.m12022a().get() != 3) {
                } else {
                    FlyActionSettingFragment.this.f11598i.m9382a();
                }
            }
        });
        this.f11604o = c3797a.m7049a();
        this.f11604o.setCanceledOnTouchOutside(false);
        this.f11604o.show();
    }

    /* renamed from: b */
    private boolean m9664b(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return ((float) (view.getBottom() - rect.bottom)) > view.getResources().getDisplayMetrics().density * 100.0f;
    }

    /* renamed from: c */
    private void m9662c() {
        this.f11594e.mo11220a(C2678d.EnumC2679a.DISPLAYLIMITCIRCLE);
        this.f11594e.mo11220a(C2678d.EnumC2679a.CLEARTAKEPHOTO);
    }

    /* renamed from: d */
    private void m9661d() {
        if (this.f11596g.m12022a().get() == 1) {
            this.f11592c.setText(C2300R.C2303string.settingwaypoint);
            this.f11602m.m9455c(C2300R.C2303string.delete_wraypoint);
            this.f11598i.m9356e();
            this.f11600k.setVisibility(8);
            if (!this.f11597h.m12787a().getBoolean(C2854c.f10577bC, false)) {
                m9666a(getString(C2300R.C2303string.fly_action_tip));
            } else if (isVisible()) {
                C2284z.m12696a(getActivity(), (int) C2300R.C2303string.promtt_waypoint, 2000);
            }
        } else if (this.f11596g.m12022a().get() == 2) {
            this.f11592c.setText(C2300R.C2303string.settingtargetplace);
            this.f11602m.m9455c(C2300R.C2303string.delete_flytopoint);
            this.f11598i.m9356e();
            this.f11600k.setVisibility(8);
            if (!this.f11597h.m12787a().getBoolean(C2854c.f10578bD, false)) {
                m9666a(getString(C2300R.C2303string.fly_action_flyto_tip));
            } else {
                C2284z.m12696a(getActivity(), (int) C2300R.C2303string.promtt_fly_to, 2000);
            }
        } else if (this.f11596g.m12022a().get() == 3) {
            this.f11592c.setText(C2300R.C2303string.set_interest_point);
            this.f11600k.setVisibility(0);
            if (!this.f11597h.m12787a().getBoolean(C2854c.f10579bE, false)) {
                m9666a(getString(C2300R.C2303string.fly_action_poi_tip));
            } else {
                this.f11598i.m9382a();
            }
        }
        int m10498g = (int) ((this.f11594e.mo11202w().m10498g() - 677216.0d) / 10.0d);
        this.f11602m.m9468a(m10498g);
        C2472d.m12036p().m12050d(m10498g);
        C2472d.m12036p().m12033s();
        this.f11594e.mo11220a(C2678d.EnumC2679a.CLEARDATA);
        this.f11602m.m9460b();
    }

    /* renamed from: e */
    private void m9660e() {
        if (C2472d.m12036p().m12042j().size() > 0) {
            this.f11591b.setBackgroundResource(C2300R.C2301drawable.flyaction_bg);
        } else {
            this.f11591b.setBackgroundResource(C2300R.C2301drawable.fly_action_cancal_bg);
        }
    }

    /* renamed from: f */
    private void m9659f() {
        this.f11591b.setBackgroundResource(C2300R.C2301drawable.fly_action_cancal_bg);
    }

    /* renamed from: a */
    public void m9670a() {
        this.f11598i.m9359d();
        this.f11598i.m9356e();
        this.f11599j.m9312b();
        this.f11600k.setImageResource(C2300R.C2301drawable.switch_action_poi);
        this.f11601l = false;
        C2472d.m12036p().m12033s();
        C2477h.m12020a(getActivity().getApplicationContext()).m12021a(0);
        this.f11594e.mo11220a(C2678d.EnumC2679a.CANCALFLYACTION);
        this.f11605p.mo8851g();
    }

    /* renamed from: a */
    public void m9667a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11605p = abstractC3281a;
    }

    /* renamed from: b */
    public boolean m9665b() {
        if (this.f11604o == null || !this.f11604o.isShowing()) {
            return m9664b(this.f11603n);
        }
        return false;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11594e = ((DroidPlannerApp) activity.getApplication()).f7895a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.fly_action_cancal_btn /* 2131493379 */:
                m9670a();
                return;
            case C2300R.C2302id.fly_action_execute_btn /* 2131493380 */:
                if (this.f11594e.m11312at().m10700g().isLightStream()) {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.in_light_stream, 3000);
                    return;
                } else if (this.f11594e.m11312at().m10700g().isEnforcementAtti()) {
                    C2284z.m12696a(getActivity(), (int) C2300R.C2303string.in_Atti, 3000);
                    return;
                } else if (this.f11596g.m12022a().get() == 1) {
                    this.f11594e.mo11220a(C2678d.EnumC2679a.UPWAYPOINT);
                    return;
                } else if (this.f11596g.m12022a().get() == 2) {
                    this.f11594e.mo11220a(C2678d.EnumC2679a.ASSIGNWAYPOINT);
                    return;
                } else if (this.f11596g.m12022a().get() != 3) {
                    return;
                } else {
                    this.f11594e.mo11220a(C2678d.EnumC2679a.INTERESTWAYPOINT);
                    return;
                }
            case C2300R.C2302id.toggleaction /* 2131493469 */:
                if (!this.f11601l) {
                    this.f11601l = true;
                    this.f11600k.setImageResource(C2300R.C2301drawable.switch_poi_map);
                } else {
                    this.f11601l = false;
                    this.f11599j.m9312b();
                    this.f11600k.setImageResource(C2300R.C2301drawable.switch_action_poi);
                }
                this.f11605p.mo8853e();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11596g = C2477h.m12020a(this.f11594e.f9270d);
        this.f11597h = C2277v.m12784a(getActivity());
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fly_drone_action, (ViewGroup) null);
        this.f11603n = inflate.getRootView();
        this.f11598i = new View$OnClickListenerC3165d(inflate, this.f11594e);
        this.f11599j = new C3184f(inflate, this.f11594e.f9270d);
        this.f11602m = new View$OnClickListenerC3148a(this.f11594e, inflate);
        m9669a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11594e.mo11214b(this);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f11598i != null) {
            this.f11598i = null;
        }
        if (this.f11599j != null) {
            this.f11599j = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CLEARDATATAKEPHOTO:
                m9670a();
                return;
            case CREATEPOI:
                this.f11601l = false;
                this.f11599j.m9312b();
                this.f11605p.mo8852f();
                this.f11600k.setImageResource(C2300R.C2301drawable.switch_action_poi);
                return;
            case NOTIFICHANGECIECLERIDUS:
            default:
                return;
            case CHANGESTARTMARKER:
                if (this.f11598i == null) {
                    return;
                }
                this.f11598i.m9369a(false);
                return;
            case SHOWHEIGHTVIEW:
                this.f11602m.m9469a();
                FlyActionBean flyActionBean = null;
                if (C2472d.m12036p().m12065a() == 2) {
                    flyActionBean = C2472d.m12036p().m12037o();
                } else if (C2472d.m12036p().m12065a() == 1) {
                    flyActionBean = C2472d.m12036p().m12038n();
                } else if (C2472d.m12036p().m12065a() == 3) {
                    flyActionBean = C2472d.m12036p().m12047f();
                }
                if (flyActionBean != null) {
                    this.f11602m.m9468a(flyActionBean.getHeight());
                    this.f11602m.m9452d(flyActionBean.getSpeek());
                }
                m9660e();
                return;
            case HIDEHEIGHTVALUE:
                m9660e();
                this.f11602m.m9460b();
                return;
            case CLOSEFLYACTIONFRAGMENT:
                if (!isVisible() || !c2657a.m11312at().m10700g().judgeNoAction()) {
                    return;
                }
                m9661d();
                m9662c();
                return;
            case SHOWPOIOPERA:
                m9660e();
                this.f11598i.m9352g();
                return;
            case CLEANALLOBJ:
                if (this.f11598i == null) {
                    return;
                }
                this.f11598i.m9359d();
                return;
            case CLEARPOIDATA:
                if (this.f11598i == null) {
                    return;
                }
                this.f11598i.m9359d();
                return;
            case CLOSECARMERPOI:
                this.f11599j.m9312b();
                this.f11598i.m9346j();
                this.f11600k.setImageResource(C2300R.C2301drawable.switch_action_poi);
                this.f11601l = false;
                return;
            case CLEARDATA:
                m9660e();
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (isAdded()) {
            if (!z) {
                m9659f();
                m9661d();
                m9662c();
                return;
            }
            if (this.f11604o != null) {
                this.f11604o.dismiss();
            }
            this.f11601l = false;
            if (this.f11599j != null) {
                this.f11599j.m9312b();
            }
            if (this.f11600k == null) {
                return;
            }
            this.f11600k.setImageResource(C2300R.C2301drawable.switch_action_poi);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11594e.mo11219a(this);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
