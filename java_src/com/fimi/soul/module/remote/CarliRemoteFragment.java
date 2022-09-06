package com.fimi.soul.module.remote;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MidView;
/* loaded from: classes.dex */
public class CarliRemoteFragment extends BaseRemoteFragment {

    /* renamed from: f */
    EnumC3412a f13338f;

    /* renamed from: g */
    private Button f13339g;

    /* renamed from: h */
    private Button f13340h;

    /* renamed from: i */
    private TextView f13341i;

    /* renamed from: j */
    private TextView f13342j;

    /* renamed from: k */
    private TextView f13343k;

    /* renamed from: l */
    private MidView f13344l;

    /* renamed from: m */
    private MidView f13345m;

    /* renamed from: com.fimi.soul.module.remote.CarliRemoteFragment$a */
    /* loaded from: classes.dex */
    enum EnumC3412a {
        jap,
        usa
    }

    /* renamed from: a */
    public void m8485a() {
        a(C2300R.C2302id.caliremotestart, C2300R.C2302id.errorcalifragment, getString(C2300R.C2303string.remote_cali_outtime), false);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.nextbutton /* 2131493208 */:
                this.f13336d.m9802o();
                if (this.f13337e == null) {
                    return;
                }
                this.f13337e.mo8479a(C2300R.C2302id.caliremotestart, C2300R.C2302id.cariremotecomple);
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                if (!isVisible() || this.f13337e == null) {
                    return;
                }
                this.f13337e.mo8480a();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.caliremotebegin, (ViewGroup) null);
        this.f13343k = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13343k.setText(C2300R.C2303string.calireming);
        this.f13340h = (Button) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13340h.setOnClickListener(this);
        this.f13344l = (MidView) inflate.findViewById(C2300R.C2302id.leftcircle).findViewById(C2300R.C2302id.rightremoteview);
        this.f13345m = (MidView) inflate.findViewById(C2300R.C2302id.rightcircle).findViewById(C2300R.C2302id.rightremoteview);
        this.f13341i = (TextView) inflate.findViewById(C2300R.C2302id.showtitleone);
        this.f13342j = (TextView) inflate.findViewById(C2300R.C2302id.showtitletwo);
        this.f13339g = (Button) inflate.findViewById(C2300R.C2302id.nextbutton);
        this.f13339g.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13339g, this.f13341i, this.f13342j, this.f13343k);
        return inflate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (isVisible()) {
            switch (enumC2679a) {
                case QuitCaliRemote:
                    c2657a.mo11214b(this);
                    return;
                case NEWREMOTEMODEL:
                    if (isVisible()) {
                        C2882am m11291i = c2657a.m11291i();
                        if (this.f13338f != EnumC3412a.usa) {
                            if (this.f13338f == EnumC3412a.jap) {
                                this.f13345m.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                                this.f13344l.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                                break;
                            }
                        } else {
                            this.f13345m.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                            this.f13344l.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                            break;
                        }
                    }
                    break;
                case backControl:
                    break;
                default:
                    return;
            }
            if (c2657a.mo11229R().m10342c() != 3) {
                return;
            }
            if (c2657a.mo11229R().m10343b() != 86 && c2657a.mo11229R().m10343b() != 85) {
                return;
            }
            m8485a();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z || !isVisible()) {
            return;
        }
        C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calirockertitle));
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C2277v.m12784a(getActivity()).m12787a().getInt(RemoteModelActivity.f13406a, 0) == 0) {
            this.f13338f = EnumC3412a.usa;
        } else {
            this.f13338f = EnumC3412a.jap;
        }
    }
}
