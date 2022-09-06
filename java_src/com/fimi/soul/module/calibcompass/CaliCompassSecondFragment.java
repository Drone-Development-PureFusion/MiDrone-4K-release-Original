package com.fimi.soul.module.calibcompass;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2927k;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class CaliCompassSecondFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    private TextView f11462f;

    /* renamed from: g */
    private Button f11463g;

    /* renamed from: h */
    private Button f11464h;

    /* renamed from: i */
    private Handler f11465i = new Handler() { // from class: com.fimi.soul.module.calibcompass.CaliCompassSecondFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C3057d.m9823a(CaliCompassSecondFragment.this.f11392b).m9820b((byte) 1, (byte) 1, (byte) 3);
        }
    };

    /* renamed from: a */
    private void m9760a(View view) {
        this.f11462f = (TextView) view.findViewById(C2300R.C2302id.showtitleone);
        this.f11464h = (Button) view.findViewById(C2300R.C2302id.nextstep);
        this.f11464h.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f11462f, this.f11464h);
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
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_second, (ViewGroup) null);
        m9760a(inflate);
        return inflate;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        if (!isVisible() || enumC2679a != C2678d.EnumC2679a.CaliCompass) {
            return;
        }
        C2927k m11289k = c2657a.m11289k();
        if (m11289k.m10228d() != 2 || m11289k.m10226e() != 1 || m11289k.m10232b() != 1 || m11289k.m10230c() != 1) {
            return;
        }
        C3074a.m9756a().m9754a("153");
        this.f11393c.beginTransaction().hide(this).show(this.f11393c.findFragmentByTag("thrid")).commitAllowingStateLoss();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            this.f11465i.sendEmptyMessageDelayed(0, 2000L);
        }
    }
}
