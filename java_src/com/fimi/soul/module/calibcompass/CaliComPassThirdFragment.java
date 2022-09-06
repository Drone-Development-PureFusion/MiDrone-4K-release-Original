package com.fimi.soul.module.calibcompass;

import android.app.Activity;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2927k;
import com.fimi.soul.utils.C3658ar;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
/* loaded from: classes.dex */
public class CaliComPassThirdFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    AbstractC3063a f11405f;

    /* renamed from: g */
    private TextView f11406g;

    /* renamed from: h */
    private boolean f11407h;

    /* renamed from: com.fimi.soul.module.calibcompass.CaliComPassThirdFragment$a */
    /* loaded from: classes.dex */
    interface AbstractC3063a {
        /* renamed from: a */
        void mo9782a(boolean z);
    }

    /* renamed from: a */
    private void m9793a(View view) {
        this.f11406g = (TextView) view.findViewById(C2300R.C2302id.showtitleone);
        m9792a(this.f11406g);
        C3658ar.m7612a(getActivity().getAssets(), this.f11406g);
    }

    /* renamed from: a */
    private void m9792a(TextView textView) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(C2300R.color.white));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getResources().getColor(C2300R.color.white));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText().toString());
        spannableStringBuilder.setSpan(foregroundColorSpan, 19, 23, 33);
        spannableStringBuilder.setSpan(foregroundColorSpan2, 29, this.f11406g.getText().length(), 33);
        this.f11406g.setText(spannableStringBuilder);
        m9791a(this.f11406g, 128);
    }

    /* renamed from: a */
    public void m9791a(TextView textView, int i) {
        textView.setTextColor(textView.getTextColors().withAlpha(i));
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11405f = (AbstractC3063a) activity;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.black_btn /* 2131493817 */:
                if (this.f11395e == null) {
                    return;
                }
                this.f11395e.mo9790a();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_third, (ViewGroup) null);
        m9793a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11405f = null;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (isVisible()) {
            switch (enumC2679a) {
                case CaliCompass:
                    C2927k m11289k = c2657a.m11289k();
                    if (this.f11405f != null) {
                        this.f11405f.mo9782a(true);
                    }
                    if (m11289k.m10228d() != 2 || m11289k.m10226e() != 1 || m11289k.m10232b() != 1 || m11289k.m10230c() != 2) {
                        return;
                    }
                    if (this.f11405f != null) {
                        this.f11405f.mo9782a(false);
                    }
                    this.f11407h = false;
                    Fragment findFragmentByTag = this.f11393c.findFragmentByTag(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
                    if (findFragmentByTag == null || !(findFragmentByTag instanceof CaliCompassErrorFragment) || !findFragmentByTag.isHidden()) {
                        return;
                    }
                    ((CaliCompassErrorFragment) findFragmentByTag).m9773a(getString(C2300R.C2303string.calicomsucess), true, false);
                    ((CaliCompassActivity) getActivity()).m9783a(getString(C2300R.C2303string.calicompassesucess));
                    this.f11393c.beginTransaction().hide(this).show(findFragmentByTag).commitAllowingStateLoss();
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
            C2244b.m13105a(getActivity()).m13103a(getString(C2300R.C2303string.compass_ver));
        }
    }
}
