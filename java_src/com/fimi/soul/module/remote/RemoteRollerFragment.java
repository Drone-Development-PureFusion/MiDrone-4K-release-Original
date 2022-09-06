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
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.MidView;
import com.fimi.soul.view.RemoteRollerView;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class RemoteRollerFragment extends BaseRemoteFragment {

    /* renamed from: f */
    MidView f13425f;

    /* renamed from: g */
    MidView f13426g;

    /* renamed from: h */
    EnumC3430a f13427h;

    /* renamed from: i */
    private TextView f13428i;

    /* renamed from: j */
    private TextView f13429j;

    /* renamed from: k */
    private TextView f13430k;

    /* renamed from: l */
    private Button f13431l;

    /* renamed from: m */
    private Button f13432m;

    /* renamed from: n */
    private RemoteRollerView f13433n;

    /* renamed from: o */
    private RemoteRollerView f13434o;

    /* renamed from: p */
    private RemoteRollerView f13435p;

    /* renamed from: q */
    private RemoteRollerView f13436q;

    /* renamed from: com.fimi.soul.module.remote.RemoteRollerFragment$a */
    /* loaded from: classes.dex */
    enum EnumC3430a {
        jap,
        usa
    }

    /* renamed from: a */
    public void m8470a() {
        if (this.f13334b.mo11216ac()) {
            if (this.f13334b.m11320al()) {
                this.f13429j.setText(C2300R.C2303string.calremotewaringfly);
            } else {
                this.f13429j.setText(C2300R.C2303string.remotewaring);
            }
            this.f13431l.setEnabled(false);
            m8468a(this.f13431l, 77);
            this.f13430k.setVisibility(4);
        } else if (!this.f13334b.mo11217ab().mo10898a()) {
            this.f13431l.setEnabled(false);
            m8468a(this.f13431l, 77);
            this.f13429j.setText(C2300R.C2303string.disconremote);
            this.f13430k.setVisibility(4);
        } else {
            if (!this.f13431l.isEnabled()) {
                C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.reminder_calibration_canStart));
            }
            this.f13431l.setEnabled(true);
            m8468a(this.f13431l, AbstractC4863e.f20785F);
            this.f13429j.setText(C2300R.C2303string.remote_roller_title_one);
            this.f13430k.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void m8469a(View view) {
        this.f13431l = (Button) view.findViewById(C2300R.C2302id.nextbutton);
        this.f13431l.setOnClickListener(this);
        this.f13431l.setEnabled(false);
        this.f13433n = (RemoteRollerView) view.findViewById(C2300R.C2302id.left_up_arrow);
        this.f13434o = (RemoteRollerView) view.findViewById(C2300R.C2302id.left_down_arrow);
        this.f13435p = (RemoteRollerView) view.findViewById(C2300R.C2302id.right_up_arrow);
        this.f13436q = (RemoteRollerView) view.findViewById(C2300R.C2302id.right_down_arrow);
        this.f13433n.setInitView(0);
        this.f13434o.setInitView(1);
        this.f13435p.setInitView(2);
        this.f13436q.setInitView(3);
        this.f13433n.setSweep(51.0f);
        this.f13434o.setSweep(1.0f);
        this.f13435p.setSweep(51.0f);
        this.f13436q.setSweep(1.0f);
        this.f13428i.setText(C2300R.C2303string.calibrate_remote);
        C3658ar.m7612a(getActivity().getAssets(), this.f13432m, this.f13428i, this.f13429j, this.f13430k, this.f13431l);
        m8470a();
    }

    /* renamed from: a */
    public void m8468a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.nextbutton /* 2131493208 */:
                if (!this.f13334b.mo11217ab().mo10898a()) {
                    C2284z.m12694a(this.f13333a, this.f13333a.getString(C2300R.C2303string.cali_fail_please_connect_remote), C2284z.f7606b);
                    return;
                } else if (this.f13334b.mo11216ac()) {
                    C2284z.m12694a(this.f13333a, this.f13333a.getString(C2300R.C2303string.close_plane_to_remote_cali), C2284z.f7606b);
                    return;
                } else {
                    this.f13336d.m9805l();
                    if (this.f13337e == null) {
                        return;
                    }
                    this.f13337e.mo8479a(C2300R.C2302id.remote_roller_fragment, C2300R.C2302id.midcalibrationing);
                    return;
                }
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
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_remote_roller, (ViewGroup) null);
        this.f13425f = (MidView) inflate.findViewById(C2300R.C2302id.leftview).findViewById(C2300R.C2302id.rightremoteview);
        this.f13426g = (MidView) inflate.findViewById(C2300R.C2302id.rightview).findViewById(C2300R.C2302id.rightremoteview);
        this.f13432m = (Button) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13432m.setOnClickListener(this);
        this.f13428i = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13429j = (TextView) inflate.findViewById(C2300R.C2302id.showtitleone);
        this.f13430k = (TextView) inflate.findViewById(C2300R.C2302id.showtitletwo);
        m8469a(inflate);
        return inflate;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        float f = 51.0f;
        float f2 = 1.0f;
        super.onDroneEvent(enumC2679a, c2657a);
        if (enumC2679a == C2678d.EnumC2679a.CLEANALLOBJ) {
            m8470a();
        }
        if (isVisible()) {
            switch (enumC2679a) {
                case NEWREMOTEMODEL:
                    C2882am m11291i = c2657a.m11291i();
                    if (this.f13427h == EnumC3430a.jap) {
                        this.f13425f.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13426g.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                    } else if (this.f13427h == EnumC3430a.usa) {
                        this.f13426g.m7267a((float) (m11291i.m10546i() * 0.0977d), (float) (m11291i.m10548h() * 0.0977d));
                        this.f13425f.m7267a((float) (m11291i.m10552f() * 0.0977d), (float) (m11291i.m10550g() * 0.0977d));
                    }
                    short m10556d = m11291i.m10556d() > 50 ? m11291i.m10556d() : m11291i.m10556d();
                    short m10554e = m11291i.m10554e() > 50 ? m11291i.m10554e() : m11291i.m10554e();
                    if (m10556d >= 992) {
                        m10556d = 1023;
                    }
                    int i = (int) (m10556d * 0.0977d);
                    int i2 = (int) ((m10554e >= 992 ? (short) 1023 : m10554e) * 0.0977d);
                    this.f13433n.setSweep(i > 50 ? i : 51.0f);
                    this.f13434o.setSweep(i < 50 ? 50 - i : 1.0f);
                    RemoteRollerView remoteRollerView = this.f13435p;
                    if (i2 > 50) {
                        f = i2;
                    }
                    remoteRollerView.setSweep(f);
                    RemoteRollerView remoteRollerView2 = this.f13436q;
                    if (i2 < 50) {
                        f2 = 50 - i2;
                    }
                    remoteRollerView2.setSweep(f2);
                    return;
                case Remotecontrol:
                    m8470a();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.f13431l.setEnabled(false);
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C2277v.m12784a(getActivity()).m12787a().getInt(RemoteModelActivity.f13406a, 0) == 0) {
            this.f13427h = EnumC3430a.usa;
        } else {
            this.f13427h = EnumC3430a.jap;
        }
    }
}
