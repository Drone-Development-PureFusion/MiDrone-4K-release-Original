package com.fimi.soul.module.remote;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MidView;
/* loaded from: classes.dex */
public class RemoteMidCalibrationFragment extends BaseRemoteFragment {

    /* renamed from: f */
    EnumC3422a f13389f;

    /* renamed from: g */
    private PercentRelativeLayout f13390g;

    /* renamed from: h */
    private Button f13391h;

    /* renamed from: i */
    private Button f13392i;

    /* renamed from: j */
    private TextView f13393j;

    /* renamed from: k */
    private TextView f13394k;

    /* renamed from: l */
    private TextView f13395l;

    /* renamed from: m */
    private MidView f13396m;

    /* renamed from: n */
    private MidView f13397n;

    /* renamed from: com.fimi.soul.module.remote.RemoteMidCalibrationFragment$a */
    /* loaded from: classes.dex */
    enum EnumC3422a {
        jap,
        usa
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.nextbutton /* 2131493208 */:
                this.f13335c.beginTransaction().hide(this.f13335c.findFragmentById(C2300R.C2302id.midcalibreation)).commit();
                this.f13335c.beginTransaction().show(this.f13335c.findFragmentById(C2300R.C2302id.remote_roller_fragment)).commit();
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                this.f13336d.m9804m();
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.midcalibration, (ViewGroup) null);
        this.f13390g = (PercentRelativeLayout) inflate.findViewById(C2300R.C2302id.heardView);
        this.f13396m = (MidView) inflate.findViewById(C2300R.C2302id.leftremoteview);
        this.f13397n = (MidView) inflate.findViewById(C2300R.C2302id.rightremoteview);
        this.f13394k = (TextView) inflate.findViewById(C2300R.C2302id.showtitleone);
        this.f13395l = (TextView) inflate.findViewById(C2300R.C2302id.showtitletwo);
        this.f13391h = (Button) this.f13390g.findViewById(C2300R.C2302id.black_btn);
        this.f13391h.setOnClickListener(this);
        this.f13393j = (TextView) this.f13390g.findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13393j.setText(C2300R.C2303string.calibration_remote);
        this.f13392i = (Button) inflate.findViewById(C2300R.C2302id.nextbutton);
        this.f13392i.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13393j, this.f13392i, this.f13394k, this.f13395l);
        return inflate;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (isVisible()) {
            switch (enumC2679a) {
                case NEWREMOTEMODEL:
                    C2882am m11291i = c2657a.m11291i();
                    if (this.f13389f == EnumC3422a.jap) {
                        this.f13396m.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13397n.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                        return;
                    } else if (this.f13389f != EnumC3422a.usa) {
                        return;
                    } else {
                        this.f13397n.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13396m.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C2277v.m12784a(getActivity()).m12787a().getInt(RemoteModelActivity.f13406a, 0) == 0) {
            this.f13389f = EnumC3422a.usa;
        } else {
            this.f13389f = EnumC3422a.jap;
        }
    }
}
