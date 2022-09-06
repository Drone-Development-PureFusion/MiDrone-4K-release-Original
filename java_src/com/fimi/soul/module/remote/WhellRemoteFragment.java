package com.fimi.soul.module.remote;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2882am;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.RemoteRollerView;
/* loaded from: classes.dex */
public class WhellRemoteFragment extends BaseRemoteFragment {

    /* renamed from: f */
    private TextView f13441f;

    /* renamed from: g */
    private TextView f13442g;

    /* renamed from: h */
    private TextView f13443h;

    /* renamed from: i */
    private Button f13444i;

    /* renamed from: j */
    private Button f13445j;

    /* renamed from: k */
    private RemoteRollerView f13446k;

    /* renamed from: l */
    private RemoteRollerView f13447l;

    /* renamed from: m */
    private RemoteRollerView f13448m;

    /* renamed from: n */
    private RemoteRollerView f13449n;

    /* renamed from: o */
    private boolean f13450o;

    /* renamed from: p */
    private final int f13451p = 1;

    /* renamed from: q */
    private Handler f13452q = new Handler() { // from class: com.fimi.soul.module.remote.WhellRemoteFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!WhellRemoteFragment.this.f13450o) {
                C2244b.m13099b(WhellRemoteFragment.this.getActivity()).m13103a(WhellRemoteFragment.this.getString(C2300R.C2303string.caliwhell));
            }
        }
    };

    /* renamed from: a */
    public void m8466a(boolean z, String str) {
        if (this.f13452q.hasMessages(1)) {
            this.f13452q.removeMessages(1);
        }
        if (z) {
            a(C2300R.C2302id.cariremotecomple, C2300R.C2302id.errorcalifragment, "", z);
        } else {
            a(C2300R.C2302id.cariremotecomple, C2300R.C2302id.errorcalifragment, str, z);
        }
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
                this.f13336d.m9801p();
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
        View inflate = layoutInflater.inflate(C2300R.layout.whellcalicomplete, (ViewGroup) null);
        this.f13443h = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13443h.setText(C2300R.C2303string.calireming);
        this.f13445j = (Button) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13445j.setOnClickListener(this);
        this.f13441f = (TextView) inflate.findViewById(C2300R.C2302id.showtitleone);
        this.f13442g = (TextView) inflate.findViewById(C2300R.C2302id.showtitletwo);
        this.f13444i = (Button) inflate.findViewById(C2300R.C2302id.nextbutton);
        this.f13444i.setOnClickListener(this);
        this.f13446k = (RemoteRollerView) inflate.findViewById(C2300R.C2302id.left_up_arrow);
        this.f13447l = (RemoteRollerView) inflate.findViewById(C2300R.C2302id.left_down_arrow);
        this.f13448m = (RemoteRollerView) inflate.findViewById(C2300R.C2302id.right_up_arrow);
        this.f13449n = (RemoteRollerView) inflate.findViewById(C2300R.C2302id.right_down_arrow);
        this.f13446k.setInitView(0);
        this.f13447l.setInitView(1);
        this.f13448m.setInitView(2);
        this.f13449n.setInitView(3);
        this.f13446k.setSweep(51.0f);
        this.f13447l.setSweep(1.0f);
        this.f13448m.setSweep(51.0f);
        this.f13449n.setSweep(1.0f);
        C3658ar.m7612a(getActivity().getAssets(), this.f13444i, this.f13441f, this.f13442g);
        return inflate;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (isVisible()) {
            switch (enumC2679a) {
                case QuitCaliRemote:
                    c2657a.mo11214b(this);
                    return;
                case backControl:
                    C3074a.m9756a().m9754a("98");
                    if (c2657a.mo11229R().m10343b() == 86 && c2657a.mo11229R().m10342c() == 2 && c2657a.mo11229R().m10341d() == 1) {
                        m8466a(true, "");
                        return;
                    } else if (c2657a.mo11229R().m10342c() >= 2 && c2657a.mo11229R().m10343b() == 85 && c2657a.mo11229R().m10341d() == 2) {
                        this.f13450o = true;
                        m8466a(false, getString(C2300R.C2303string.remote_cali_rocker_failue));
                        return;
                    } else if (c2657a.mo11229R().m10342c() >= 2 && c2657a.mo11229R().m10343b() == 86 && c2657a.mo11229R().m10341d() == 2) {
                        this.f13450o = true;
                        m8466a(false, getString(C2300R.C2303string.remote_cali_roller_failue));
                        return;
                    } else if (c2657a.mo11229R().m10342c() != 3 || c2657a.mo11229R().m10343b() != 86) {
                        return;
                    } else {
                        m8466a(false, getString(C2300R.C2303string.remote_cali_outtime));
                        return;
                    }
                case NEWREMOTEMODEL:
                    C2882am m11291i = c2657a.m11291i();
                    short m10556d = m11291i.m10556d() > 50 ? m11291i.m10556d() : m11291i.m10556d();
                    short m10554e = m11291i.m10554e() > 50 ? m11291i.m10554e() : m11291i.m10554e();
                    if (m10556d >= 992) {
                        m10556d = 1023;
                    }
                    int i = (int) (m10556d * 0.0977d);
                    int i2 = (int) ((m10554e >= 992 ? (short) 1023 : m10554e) * 0.0977d);
                    this.f13446k.setSweep(i > 50 ? i : 51.0f);
                    this.f13447l.setSweep(i < 50 ? 50 - i : 1.0f);
                    this.f13448m.setSweep(i2 > 50 ? i2 : 51.0f);
                    this.f13449n.setSweep(i2 < 50 ? 50 - i2 : 1.0f);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            this.f13452q.sendEmptyMessageDelayed(1, 2000L);
        } else {
            this.f13450o = false;
        }
    }
}
