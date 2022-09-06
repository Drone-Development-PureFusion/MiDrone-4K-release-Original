package com.fimi.soul.module.setting.GimalCalibration;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class GimalCaliIngFragment extends Fragment implements View.OnClickListener {

    /* renamed from: i */
    private static final int f13540i = 100;

    /* renamed from: a */
    private TextView f13541a;

    /* renamed from: b */
    private TextView f13542b;

    /* renamed from: c */
    private TextView f13543c;

    /* renamed from: d */
    private TextView f13544d;

    /* renamed from: e */
    private TextView f13545e;

    /* renamed from: f */
    private Button f13546f;

    /* renamed from: g */
    private ProgressView f13547g;

    /* renamed from: h */
    private AbstractC3447a f13548h;

    /* renamed from: com.fimi.soul.module.setting.GimalCalibration.GimalCaliIngFragment$a */
    /* loaded from: classes.dex */
    interface AbstractC3447a {
        /* renamed from: a */
        void mo8444a();
    }

    /* renamed from: a */
    private void m8445a(View view) {
        this.f13541a = (TextView) view.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13541a.setText(C2300R.C2303string.gc_calbrating_titling);
        this.f13542b = (TextView) view.findViewById(C2300R.C2302id.process);
        this.f13543c = (TextView) view.findViewById(C2300R.C2302id.processsign);
        this.f13544d = (TextView) view.findViewById(C2300R.C2302id.desTitle);
        this.f13545e = (TextView) view.findViewById(C2300R.C2302id.desTips);
        this.f13546f = (Button) view.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13546f.setOnClickListener(this);
        this.f13547g = (ProgressView) view.findViewById(C2300R.C2302id.pro_calibration);
        this.f13547g.setMaxCount(100.0f);
        C3658ar.m7612a(getActivity().getAssets(), this.f13541a, this.f13544d, this.f13546f);
        C3658ar.m7598b(getActivity().getAssets(), this.f13542b, this.f13543c);
    }

    /* renamed from: a */
    public void m8446a(int i) {
        this.f13542b.setText(i + "");
        this.f13547g.setCurrentCount(i);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13548h = (AbstractC3447a) activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != C2300R.C2302id.black_btn || this.f13548h == null) {
            return;
        }
        this.f13548h.mo8444a();
    }

    @Override // android.support.p001v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.gimalcaliing, (ViewGroup) null);
        m8445a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f13548h != null) {
            this.f13548h = null;
        }
    }
}
