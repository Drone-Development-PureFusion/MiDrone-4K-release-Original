package com.fimi.soul.module.calibcompass;

import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2927k;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class CaliCompassStatusFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    private TextView f11467f;

    /* renamed from: g */
    private TextView f11468g;

    /* renamed from: h */
    private Button f11469h;

    /* renamed from: i */
    private Button f11470i;

    /* renamed from: j */
    private boolean f11471j;

    /* renamed from: a */
    public void m9759a(int i, boolean z) {
        if (!getString(i).toString().equals(this.f11468g.getText().toString())) {
            this.f11468g.setText(i);
        }
        if (this.f11470i.isEnabled() != z && z) {
            C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.reminder_calibration_canStart));
        }
        this.f11470i.setEnabled(z);
        if (z) {
            m9758a(this.f11470i, AbstractC4863e.f20785F);
        } else {
            m9758a(this.f11470i, 77);
        }
    }

    /* renamed from: a */
    public void m9758a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    public void m9757a(boolean z) {
        this.f11470i.setEnabled(z);
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.begincalicompss /* 2131493205 */:
                C3057d.m9823a(this.f11392b).m9833a((byte) 1, (byte) 1, (byte) 1);
                ((CaliCompassActivity) getActivity()).m9783a(getString(C2300R.C2303string.compass_hor_calibration));
                this.f11393c.beginTransaction().hide(this).show(this.f11393c.findFragmentByTag("first")).commitAllowingStateLoss();
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.begin_calicaompass, (ViewGroup) null);
        this.f11468g = (TextView) inflate.findViewById(C2300R.C2302id.showtitleone);
        this.f11470i = (Button) inflate.findViewById(C2300R.C2302id.begincalicompss);
        this.f11470i.setOnClickListener(this);
        this.f11470i.setEnabled(false);
        C3658ar.m7612a(getActivity().getAssets(), this.f11468g);
        if (!this.f11392b.mo11217ab().mo10898a() || this.f11392b.m11320al()) {
            if (this.f11392b.m11320al()) {
                m9759a(C2300R.C2303string.plane_start_can_not_calration_compass, false);
            } else {
                m9759a(C2300R.C2303string.calidisconremote, false);
            }
        } else if (this.f11392b.m11318an().m10098an()) {
            m9759a(C2300R.C2303string.calicpmssing, false);
            C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calicpmssing));
        } else {
            m9759a(C2300R.C2303string.begincalocomremider, true);
        }
        return inflate;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (isVisible()) {
            switch (enumC2679a) {
                case CaliCompass:
                    C2927k m11289k = c2657a.m11289k();
                    if (m11289k.m10228d() != 2 || m11289k.m10226e() != 1 || m11289k.m10232b() != 1) {
                        return;
                    }
                    if (m11289k.m10230c() != 2 && m11289k.m10230c() != 3) {
                        return;
                    }
                    if (m11289k.m10230c() != 2) {
                        this.f11471j = true;
                        m9759a(C2300R.C2303string.calicompasscoming, false);
                        return;
                    }
                    Fragment findFragmentByTag = this.f11393c.findFragmentByTag(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
                    if (findFragmentByTag == null || !(findFragmentByTag instanceof CaliCompassErrorFragment) || findFragmentByTag.isHidden()) {
                        return;
                    }
                    ((CaliCompassErrorFragment) findFragmentByTag).m9773a(getString(C2300R.C2303string.calicomsucess), true, false);
                    this.f11393c.beginTransaction().hide(this).show(findFragmentByTag).commitAllowingStateLoss();
                    return;
                case SIMULATORINFO:
                default:
                    return;
                case Remotecontrol:
                    if (!c2657a.mo11216ac() && this.f11471j) {
                        this.f11471j = false;
                    }
                    if (this.f11471j) {
                        return;
                    }
                    if (!c2657a.mo11216ac()) {
                        m9759a(C2300R.C2303string.calisiacondrone, false);
                        return;
                    } else if (c2657a.mo11216ac() && c2657a.m11320al()) {
                        m9759a(C2300R.C2303string.plane_start_can_not_calration_compass, false);
                        return;
                    } else if (!c2657a.mo11216ac()) {
                        return;
                    } else {
                        if (c2657a.m11318an().m10098an()) {
                            m9759a(C2300R.C2303string.calicpmssing, false);
                            return;
                        } else {
                            m9759a(C2300R.C2303string.begincalocomremider, true);
                            return;
                        }
                    }
                case CLEANALLOBJ:
                    m9759a(C2300R.C2303string.GC_caliFail_discon, false);
                    return;
            }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            if (this.f11392b.mo11217ab().mo10898a() && !this.f11392b.m11320al()) {
                return;
            }
            if (this.f11392b.m11320al()) {
                m9759a(C2300R.C2303string.plane_start_can_not_calration_compass, false);
            } else {
                m9759a(C2300R.C2303string.calidisconremote, false);
            }
        }
    }
}
