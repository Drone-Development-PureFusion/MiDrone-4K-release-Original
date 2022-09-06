package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class CameraFullScreenShowLeadFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    private TextView f11555a;

    /* renamed from: b */
    private ImageView f11556b;

    /* renamed from: c */
    private ImageView f11557c;

    /* renamed from: d */
    private PercentRelativeLayout f11558d;

    /* renamed from: e */
    private C2657a f11559e;

    /* renamed from: a */
    private void m9689a() {
        m9687a(getArguments().getBoolean("isOpen", true));
        this.f11559e.mo11219a(this);
    }

    /* renamed from: a */
    private void m9688a(View view) {
        this.f11558d = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.root_layout);
        this.f11555a = (TextView) view.findViewById(C2300R.C2302id.prompt_tv);
        this.f11556b = (ImageView) view.findViewById(C2300R.C2302id.guide_full_sliding_open_iv);
        this.f11557c = (ImageView) view.findViewById(C2300R.C2302id.guide_full_sliding_close_iv);
        this.f11558d.setOnClickListener(this);
        C3658ar.m7612a(getResources().getAssets(), this.f11555a);
    }

    /* renamed from: a */
    public void m9687a(boolean z) {
        if (z) {
            this.f11556b.setVisibility(0);
            this.f11557c.setVisibility(4);
            this.f11555a.setText(getString(C2300R.C2303string.camera_show_lead_promat_open));
            return;
        }
        this.f11556b.setVisibility(4);
        this.f11557c.setVisibility(0);
        this.f11555a.setText(getString(C2300R.C2303string.camera_show_lead_promat_close));
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11559e = ((DroidPlannerApp) activity.getApplication()).f7895a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C2300R.C2302id.root_layout == view.getId()) {
            this.f11559e.mo11220a(C2678d.EnumC2679a.CLOSE_FULL_SCREEN_LEAD);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = View.inflate(getActivity(), C2300R.layout.fragment_camera_full_screen_show_lead, null);
        m9688a(inflate);
        m9689a();
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11559e.mo11214b(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }
}
