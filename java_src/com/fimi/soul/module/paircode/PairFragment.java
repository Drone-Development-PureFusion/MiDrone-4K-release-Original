package com.fimi.soul.module.paircode;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2687ac;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class PairFragment extends Fragment implements View.OnClickListener, C2678d.AbstractC2680b, AbstractC3401a {

    /* renamed from: a */
    public static final int f13257a = 2;

    /* renamed from: b */
    public static final int f13258b = 16;

    /* renamed from: c */
    View f13259c;

    /* renamed from: d */
    private RelativeLayout f13260d;

    /* renamed from: e */
    private RelativeLayout f13261e;

    /* renamed from: f */
    private RelativeLayout f13262f;

    /* renamed from: g */
    private TextView f13263g;

    /* renamed from: h */
    private PairCodeActivity f13264h;

    /* renamed from: com.fimi.soul.module.paircode.PairFragment$a */
    /* loaded from: classes.dex */
    enum EnumC3396a {
        in_sky,
        no_connected,
        prepared
    }

    /* renamed from: a */
    private void m8497a() {
        C2687ac c2687ac = new C2687ac();
        c2687ac.m11186a((byte) 8);
        c2687ac.m11184a(C2367d.m12459a().m12438k());
        this.f13264h.drone.mo11217ab().mo10897a(c2687ac.mo11073b());
        this.f13264h.m8501a(true);
    }

    /* renamed from: a */
    private void m8496a(EnumC3396a enumC3396a) {
        this.f13260d.setVisibility(8);
        this.f13261e.setVisibility(8);
        this.f13262f.setVisibility(8);
        switch (enumC3396a) {
            case in_sky:
                this.f13260d.setVisibility(0);
                return;
            case no_connected:
                this.f13261e.setVisibility(0);
                return;
            case prepared:
                this.f13262f.setVisibility(0);
                ((Button) this.f13259c.findViewById(C2300R.C2302id.pre_pair_btn)).setOnClickListener(this);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.paircode.AbstractC3401a
    /* renamed from: a */
    public void mo8492a(int i) {
        switch (i) {
            case 2:
                m8496a(EnumC3396a.no_connected);
                return;
            case 16:
                if (this.f13264h.drone.m11320al()) {
                    m8496a(EnumC3396a.in_sky);
                    return;
                } else {
                    m8496a(EnumC3396a.prepared);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.paircode.AbstractC3401a
    /* renamed from: a */
    public void mo8491a(int i, int i2) {
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13264h = (PairCodeActivity) activity;
        this.f13264h.m8502a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.pre_pair_btn /* 2131493793 */:
                if (!this.f13264h.drone.mo11217ab().mo10898a()) {
                    return;
                }
                m8497a();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13259c = layoutInflater.inflate(C2300R.layout.pair_status_layout, (ViewGroup) null);
        this.f13260d = (RelativeLayout) this.f13259c.findViewById(C2300R.C2302id.sky_layout);
        this.f13261e = (RelativeLayout) this.f13259c.findViewById(C2300R.C2302id.connect_layout);
        this.f13262f = (RelativeLayout) this.f13259c.findViewById(C2300R.C2302id.prepare_layout);
        this.f13263g = (TextView) this.f13259c.findViewById(C2300R.C2302id.pair_des);
        return this.f13259c;
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11216ac() || !c2657a.mo11217ab().mo10898a()) {
            return;
        }
        switch (enumC2679a) {
            case FLY_INSKY:
                if (c2657a.m11320al()) {
                    m8496a(EnumC3396a.in_sky);
                    return;
                } else {
                    m8496a(EnumC3396a.prepared);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (C2367d.m12459a().m12438k()) {
            this.f13263g.setText(getString(C2300R.C2303string.paircode_step_des_4k));
        } else {
            this.f13263g.setText(getString(C2300R.C2303string.paircode_step_des));
        }
        C3658ar.m7612a(this.f13264h.getAssets(), this.f13263g);
        if (!this.f13264h.drone.mo11217ab().mo10898a()) {
            m8496a(EnumC3396a.no_connected);
        } else if (this.f13264h.drone.m11320al()) {
            m8496a(EnumC3396a.in_sky);
        } else {
            m8496a(EnumC3396a.prepared);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f13264h.drone.mo11219a(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f13264h.drone.mo11214b(this);
    }
}
