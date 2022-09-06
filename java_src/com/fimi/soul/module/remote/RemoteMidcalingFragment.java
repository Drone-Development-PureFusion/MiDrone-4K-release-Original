package com.fimi.soul.module.remote;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class RemoteMidcalingFragment extends BaseRemoteFragment {

    /* renamed from: f */
    private RemoteEndCaliFragment f13402f;

    /* renamed from: g */
    private TextView f13403g;

    /* renamed from: h */
    private Button f13404h;

    /* renamed from: a */
    public void m8475a() {
        a(C2300R.C2302id.midcalibrationing, C2300R.C2302id.errorcalifragment, getString(C2300R.C2303string.remote_cali_outtime), false);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() != C2300R.C2302id.black_btn || !isVisible() || this.f13337e == null) {
            return;
        }
        this.f13337e.mo8480a();
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.remotecaliing, (ViewGroup) null);
        this.f13403g = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13403g.setText(C2300R.C2303string.calireming);
        this.f13404h = (Button) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13404h.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13403g, this.f13404h);
        return inflate;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (isVisible()) {
            switch (enumC2679a) {
                case QuitCaliRemote:
                    c2657a.mo11214b(this);
                    return;
                case backControl:
                    if (isVisible()) {
                        C3074a.m9756a().m9754a("98");
                        if (c2657a.mo11229R().m10342c() == 1 && c2657a.mo11229R().m10343b() == 82) {
                            if (this.f13337e != null) {
                                this.f13337e.mo8479a(C2300R.C2302id.midcalibrationing, C2300R.C2302id.endmidcalibration);
                            }
                            this.f13336d.m9806k();
                        }
                    }
                    if (c2657a.mo11229R().m10342c() != 3 || c2657a.mo11229R().m10343b() != 86) {
                        return;
                    }
                    m8475a();
                    return;
                default:
                    return;
            }
        }
    }
}
