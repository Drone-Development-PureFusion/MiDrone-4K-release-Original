package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3796e;
/* loaded from: classes.dex */
public class DronePanoramaFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    C2277v f11560a;

    /* renamed from: b */
    private Button f11561b;

    /* renamed from: c */
    private Button f11562c;

    /* renamed from: d */
    private TextView f11563d;

    /* renamed from: e */
    private TextView f11564e;

    /* renamed from: f */
    private TextView f11565f;

    /* renamed from: g */
    private TextView f11566g;

    /* renamed from: h */
    private TextView f11567h;

    /* renamed from: i */
    private ImageView f11568i;

    /* renamed from: j */
    private C3186h f11569j;

    /* renamed from: k */
    private C2657a f11570k;

    /* renamed from: l */
    private View f11571l;

    /* renamed from: m */
    private Context f11572m;

    /* renamed from: n */
    private Dialog f11573n;

    /* renamed from: o */
    private int f11574o;

    /* renamed from: p */
    private double f11575p;

    /* renamed from: q */
    private FlightActivity.AbstractC3281a f11576q;

    /* renamed from: a */
    private void m9685a(View view) {
        this.f11561b = (Button) view.findViewById(C2300R.C2302id.fly_action_cancal_btn);
        this.f11562c = (Button) view.findViewById(C2300R.C2302id.fly_action_execute_btn);
        this.f11563d = (TextView) view.findViewById(C2300R.C2302id.title);
        this.f11565f = (TextView) view.findViewById(C2300R.C2302id.show_flight_hight_des);
        this.f11564e = (TextView) view.findViewById(C2300R.C2302id.show_flight_hight);
        this.f11566g = (TextView) view.findViewById(C2300R.C2302id.show_camera_angle);
        this.f11567h = (TextView) view.findViewById(C2300R.C2302id.show_camera_angle_des);
        this.f11568i = (ImageView) view.findViewById(C2300R.C2302id.switch_iv);
        this.f11562c.setOnClickListener(this);
        this.f11561b.setOnClickListener(this);
        this.f11568i.setOnClickListener(this);
        C3658ar.m7612a(this.f11572m.getAssets(), this.f11561b, this.f11562c, this.f11563d, this.f11565f, this.f11564e, this.f11566g, this.f11567h);
    }

    /* renamed from: a */
    private void m9683a(String str) {
        if (this.f11573n != null && this.f11573n.isShowing()) {
            this.f11573n.dismiss();
            this.f11573n = null;
        }
        DialogC3796e.C3797a c3797a = new DialogC3796e.C3797a(getActivity());
        c3797a.m7045a(str);
        c3797a.m7043a(true);
        c3797a.m7044a(getString(C2300R.C2303string.finish), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.DronePanoramaFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.f11573n = c3797a.m7049a();
        this.f11573n.setCanceledOnTouchOutside(false);
        this.f11573n.show();
    }

    /* renamed from: b */
    private boolean m9681b(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return ((float) (view.getBottom() - rect.bottom)) > view.getResources().getDisplayMetrics().density * 100.0f;
    }

    /* renamed from: c */
    private void m9680c() {
        boolean z = false;
        if (C2277v.m12784a(this.f11572m).m12742s() == DeviceType.DEVICE_4K) {
            z = true;
        }
        if (!z || m9679d() <= 2016) {
            short m10533c = this.f11570k.mo11221Z().m10533c();
            if (this.f11574o - m10533c < 0) {
                this.f11575p = ((m10533c - 255) * 90) / 255;
            } else {
                this.f11575p = ((m10533c * 90) / 255) - 90;
            }
            this.f11574o = m10533c;
        } else {
            this.f11575p = this.f11570k.mo11221Z().m10520j();
        }
        this.f11566g.setText(String.valueOf(this.f11575p));
    }

    /* renamed from: d */
    private int m9679d() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7955c() <= 0) {
            return 0;
        }
        return c3580b.m7955c();
    }

    /* renamed from: e */
    private void m9678e() {
        double d = -999.0d;
        double m10498g = (this.f11570k.mo11202w().m10498g() - 677216.0d) / 10.0d;
        if (!this.f11570k.m11320al()) {
            m10498g = 0.0d;
        }
        if (m10498g < 3000.0d) {
            if (m10498g < 100.0d && m10498g >= 0.0d) {
                this.f11564e.setText(String.valueOf(C2275t.m12793a(m10498g, 1)) + this.f11572m.getString(C2300R.C2303string.distance_unit_M));
                return;
            }
            if (m10498g >= -999.0d) {
                d = m10498g;
            }
            this.f11564e.setText(d < 100.0d ? C2275t.m12793a(d, 1) + this.f11572m.getString(C2300R.C2303string.distance_unit_M) : ((int) d) + this.f11572m.getString(C2300R.C2303string.distance_unit_M));
        }
    }

    /* renamed from: a */
    public void m9684a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11576q = abstractC3281a;
    }

    /* renamed from: a */
    public boolean m9686a() {
        if (this.f11573n == null || !this.f11573n.isShowing()) {
            return m9681b(this.f11571l);
        }
        return false;
    }

    /* renamed from: b */
    public void m9682b() {
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11572m = activity;
        this.f11570k = ((DroidPlannerApp) activity.getApplication()).f7895a;
        this.f11560a = C2277v.m12784a(getActivity());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != C2300R.C2302id.fly_action_execute_btn && view.getId() != C2300R.C2302id.fly_action_cancal_btn && view.getId() == C2300R.C2302id.switch_iv) {
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_drone_panorama, (ViewGroup) null);
        this.f11571l = inflate;
        m9685a(this.f11571l);
        this.f11569j = new C3186h(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11570k.mo11214b(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CAMERARECORD:
                if (C2477h.m12020a(getActivity().getApplicationContext()).m12022a().get() == 4) {
                }
                return;
            case PTZ_GAIN:
                if (!c2657a.mo11215ae()) {
                    return;
                }
                m9680c();
                return;
            case WXCETAKEPHOTOAGAIN:
            default:
                return;
            case TAKEPHOTOBACKDATA:
                if (c2657a.m11306az().m10733j() == 19) {
                }
                return;
            case HEARDDAY:
                m9678e();
                return;
            case HEARDATA:
                if (c2657a.mo11215ae()) {
                    return;
                }
                this.f11566g.setText(getString(C2300R.C2303string.no_use));
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (isAdded()) {
            if (!z) {
                if (!this.f11560a.m12787a().getBoolean(C2854c.f10580bF, false)) {
                    m9683a(getString(C2300R.C2303string.fly_take_photo_tip));
                }
                this.f11569j.m9301b();
                this.f11570k.mo11220a(C2678d.EnumC2679a.CLEARMARKERTAKEPHOTO);
                this.f11570k.mo11220a(C2678d.EnumC2679a.CLEARDATA);
                return;
            }
            if (this.f11573n != null) {
                this.f11573n.dismiss();
            }
            if (this.f11569j == null) {
                return;
            }
            this.f11569j.m9302a();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11570k.mo11219a(this);
    }
}
