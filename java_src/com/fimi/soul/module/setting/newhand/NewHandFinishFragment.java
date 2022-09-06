package com.fimi.soul.module.setting.newhand;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class NewHandFinishFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14035c;

    /* renamed from: d */
    TextView f14036d;

    /* renamed from: e */
    Button f14037e;

    /* renamed from: f */
    Button f14038f;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_finish, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14035c = (TextView) view.findViewById(C2300R.C2302id.tv_finish);
        this.f14036d = (TextView) view.findViewById(C2300R.C2302id.tv_content);
        this.f14037e = (Button) view.findViewById(C2300R.C2302id.btn_study_again);
        this.f14037e.setOnClickListener(this);
        this.f14038f = (Button) view.findViewById(C2300R.C2302id.btn_try_fly);
        this.f14038f.setOnClickListener(this);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14035c, this.f14036d, this.f14037e, this.f14038f);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandFiveFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14037e) {
            NewHandOneFragment newHandOneFragment = new NewHandOneFragment();
            this.f13955b.beginTransaction().replace(C2300R.C2302id.root_layout, newHandOneFragment, newHandOneFragment.mo8138b()).commitAllowingStateLoss();
        }
        if (view == this.f14038f) {
            C2238c.m13125c().mo13114a(C2353b.f7960r, true);
            if (C2238c.m13125c().mo13108d(C2353b.f7920K)) {
                getActivity().finish();
                return;
            }
            startActivity(new Intent(getActivity(), FlightActivity.class));
            getActivity().finish();
        }
    }
}
