package com.fimi.soul.module.calibcompass;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
/* loaded from: classes.dex */
public class CaliComPassFirstFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    AbstractC3061a f11396f;

    /* renamed from: g */
    private TextView f11397g;

    /* renamed from: h */
    private boolean f11398h;

    /* renamed from: i */
    private boolean f11399i;

    /* renamed from: j */
    private Handler f11400j = new Handler() { // from class: com.fimi.soul.module.calibcompass.CaliComPassFirstFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            CaliComPassFirstFragment.this.f11399i = true;
        }
    };

    /* renamed from: k */
    private boolean f11401k;

    /* renamed from: l */
    private boolean f11402l;

    /* renamed from: com.fimi.soul.module.calibcompass.CaliComPassFirstFragment$a */
    /* loaded from: classes.dex */
    interface AbstractC3061a {
        /* renamed from: b */
        void mo9781b();
    }

    /* renamed from: a */
    private void m9798a(View view) {
        this.f11397g = (TextView) view.findViewById(C2300R.C2302id.showtitleone);
        m9797a(this.f11397g);
        C3658ar.m7612a(getActivity().getAssets(), this.f11397g);
    }

    /* renamed from: a */
    private void m9797a(TextView textView) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(C2300R.color.white));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getResources().getColor(C2300R.color.white));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText().toString());
        spannableStringBuilder.setSpan(foregroundColorSpan, 19, 21, 33);
        spannableStringBuilder.setSpan(foregroundColorSpan2, 27, textView.getText().length(), 33);
        textView.setText(spannableStringBuilder);
        m9796a(textView, 128);
    }

    /* renamed from: a */
    public void m9796a(TextView textView, int i) {
        textView.setTextColor(textView.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    public void m9794a(boolean z) {
        this.f11401k = z;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11396f = (AbstractC3061a) activity;
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
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_first, (ViewGroup) null);
        m9798a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11396f = null;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (isVisible()) {
            switch (enumC2679a) {
                case CaliCompass:
                    C2927k m11289k = c2657a.m11289k();
                    if (!this.f11401k) {
                        return;
                    }
                    if (this.f11399i && m11289k.m10228d() == 1 && m11289k.m10226e() == 1 && m11289k.m10232b() == 1 && m11289k.m10230c() == 2) {
                        this.f11399i = false;
                        this.f11402l = true;
                        C3057d.m9823a(c2657a).m9820b((byte) 1, (byte) 1, (byte) 3);
                        return;
                    } else if (m11289k.m10228d() == 1 && m11289k.m10226e() == 1 && m11289k.m10232b() == 0 && m11289k.m10230c() == 1) {
                        Fragment findFragmentByTag = this.f11393c.findFragmentByTag(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
                        if (findFragmentByTag == null || !(findFragmentByTag instanceof CaliCompassErrorFragment) || !findFragmentByTag.isHidden()) {
                            return;
                        }
                        ((CaliCompassErrorFragment) findFragmentByTag).m9773a(getString(C2300R.C2303string.remindererror), false, false);
                        ((CaliCompassActivity) getActivity()).m9783a(getString(C2300R.C2303string.calicompassesucess));
                        this.f11393c.beginTransaction().hide(this).show(findFragmentByTag).commitAllowingStateLoss();
                        return;
                    } else if (this.f11402l && m11289k.m10228d() == 2 && m11289k.m10226e() == 1 && m11289k.m10232b() == 1 && m11289k.m10230c() == 1) {
                        this.f11402l = false;
                        this.f11398h = false;
                        ((CaliCompassActivity) getActivity()).m9783a(getString(C2300R.C2303string.compass_ver_calibration));
                        this.f11393c.beginTransaction().hide(this).show(this.f11393c.findFragmentByTag("thrid")).setCustomAnimations(17432578, 17432579).commitAllowingStateLoss();
                        return;
                    } else if (m11289k.m10228d() != 1 || m11289k.m10226e() != 1 || m11289k.m10232b() != 1 || m11289k.m10230c() != 1 || this.f11398h) {
                        return;
                    } else {
                        this.f11398h = true;
                        this.f11402l = true;
                        C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.compass_hor));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            this.f11398h = false;
            this.f11400j.sendEmptyMessageDelayed(0, 2000L);
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
    }
}
