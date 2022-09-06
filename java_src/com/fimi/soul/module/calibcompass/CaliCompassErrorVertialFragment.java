package com.fimi.soul.module.calibcompass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class CaliCompassErrorVertialFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    private TextView f11451f;

    /* renamed from: g */
    private TextView f11452g;

    /* renamed from: h */
    private Button f11453h;

    /* renamed from: a */
    private void m9765a(View view) {
        this.f11451f = (TextView) view.findViewById(C2300R.C2302id.title);
        this.f11452g = (TextView) view.findViewById(C2300R.C2302id.descompass);
        this.f11453h = (Button) view.findViewById(C2300R.C2302id.againcali);
        this.f11453h.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f11451f, this.f11452g, this.f11453h);
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.againcali /* 2131493224 */:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_error_vertical, (ViewGroup) null);
        m9765a(inflate);
        return inflate;
    }
}
