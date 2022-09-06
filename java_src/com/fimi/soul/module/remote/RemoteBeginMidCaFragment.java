package com.fimi.soul.module.remote;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MidView;
/* loaded from: classes.dex */
public class RemoteBeginMidCaFragment extends BaseRemoteFragment {

    /* renamed from: f */
    public DroidPlannerApp f13363f;

    /* renamed from: g */
    EnumC3415a f13364g;

    /* renamed from: h */
    private TextView f13365h;

    /* renamed from: i */
    private Button f13366i;

    /* renamed from: j */
    private Button f13367j;

    /* renamed from: k */
    private MidView f13368k;

    /* renamed from: l */
    private MidView f13369l;

    /* renamed from: m */
    private C2657a f13370m;

    /* renamed from: com.fimi.soul.module.remote.RemoteBeginMidCaFragment$a */
    /* loaded from: classes.dex */
    enum EnumC3415a {
        jap,
        usa
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13363f = (DroidPlannerApp) activity.getApplication();
        this.f13370m = this.f13363f.f7895a;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.nextbutton /* 2131493208 */:
                if (!this.f13370m.mo11217ab().mo10898a()) {
                    C2284z.m12694a(this.f13333a, this.f13333a.getString(C2300R.C2303string.cali_fail_please_connect_remote), C2284z.f7606b);
                    return;
                } else if (this.f13370m.mo11216ac()) {
                    C2284z.m12694a(this.f13333a, this.f13333a.getString(C2300R.C2303string.close_plane_to_remote_cali), C2284z.f7606b);
                    return;
                } else {
                    this.f13336d.m9805l();
                    this.f13335c.beginTransaction().hide(this.f13335c.findFragmentById(C2300R.C2302id.beginmidcalibration)).commit();
                    this.f13335c.beginTransaction().show(this.f13335c.findFragmentById(C2300R.C2302id.midcalibrationing)).commit();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.beginmidcalibration, (ViewGroup) null);
        this.f13365h = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13365h.setText(C2300R.C2303string.calireming);
        this.f13367j = (Button) inflate.findViewById(C2300R.C2302id.headview).findViewById(C2300R.C2302id.back_btn);
        this.f13368k = (MidView) inflate.findViewById(C2300R.C2302id.rightVew);
        this.f13369l = (MidView) inflate.findViewById(C2300R.C2302id.leftView);
        this.f13366i = (Button) inflate.findViewById(C2300R.C2302id.nextbutton);
        this.f13366i.setOnClickListener(this);
        this.f13367j.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13365h, this.f13367j, this.f13366i);
        return inflate;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (isVisible()) {
            switch (enumC2679a) {
                case NEWREMOTEMODEL:
                    if (!isVisible()) {
                        return;
                    }
                    C2882am m11291i = c2657a.m11291i();
                    if (this.f13364g == EnumC3415a.jap) {
                        this.f13369l.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13368k.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                        return;
                    } else if (this.f13364g != EnumC3415a.usa) {
                        return;
                    } else {
                        this.f13368k.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13369l.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
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
            this.f13364g = EnumC3415a.usa;
        } else {
            this.f13364g = EnumC3415a.jap;
        }
    }
}
