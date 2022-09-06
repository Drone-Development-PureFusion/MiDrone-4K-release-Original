package com.fimi.soul.module.calibcompass;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.CheckCampssBeann;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* loaded from: classes.dex */
public class CaliCompassFourFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    private TextView f11454f;

    /* renamed from: g */
    private TextView f11455g;

    /* renamed from: h */
    private TextView f11456h;

    /* renamed from: i */
    private Button f11457i;

    /* renamed from: j */
    private boolean f11458j;

    /* renamed from: k */
    private Handler f11459k = new Handler();

    /* renamed from: l */
    private Runnable f11460l = new Runnable() { // from class: com.fimi.soul.module.calibcompass.CaliCompassFourFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!CaliCompassFourFragment.this.f11458j) {
                CaliCompassFourFragment.this.getActivity().setResult(0);
                CaliCompassFourFragment.this.getActivity().finish();
                return;
            }
            Intent intent = new Intent(CaliCompassFourFragment.this.getActivity(), LoginActivity.class);
            intent.putExtra("login", false);
            CaliCompassFourFragment.this.startActivity(intent);
            CaliCompassFourFragment.this.getActivity().finish();
        }
    };

    /* renamed from: a */
    private void m9763a(View view) {
        this.f11454f = (TextView) view.findViewById(C2300R.C2302id.title);
        this.f11455g = (TextView) view.findViewById(C2300R.C2302id.descompass);
        this.f11456h = (TextView) view.findViewById(C2300R.C2302id.descompasscom);
        this.f11457i = (Button) view.findViewById(C2300R.C2302id.endcalicompass);
        this.f11457i.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f11454f, this.f11455g, this.f11456h, this.f11457i);
    }

    /* renamed from: a */
    public void m9764a() {
        C3057d.m9823a(this.f11392b).m9833a((byte) 1, (byte) 1, (byte) 4);
        getActivity().finish();
    }

    /* renamed from: a */
    public void m9761a(boolean z) {
        this.f11458j = z;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == C2300R.C2302id.endcalicompass) {
            this.f11459k.postDelayed(this.f11460l, 300L);
        }
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_four, (ViewGroup) null);
        m9763a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        CheckCampssBeann checkCampssBeann;
        List<LatLng> listLatlng;
        super.onHiddenChanged(z);
        if (z || !isVisible()) {
            return;
        }
        CheckCampssBeann checkCampssBeann2 = (CheckCampssBeann) C2241c.m13122a().mo13118a(C2854c.f10520Z, CheckCampssBeann.class);
        if (checkCampssBeann2 != null) {
            checkCampssBeann = checkCampssBeann2;
            listLatlng = checkCampssBeann2.getListLatlng();
        } else {
            checkCampssBeann = new CheckCampssBeann();
            listLatlng = checkCampssBeann.getListLatlng();
        }
        Location m11639d = C2571k.m11651a(getActivity()).m11639d();
        if (m11639d == null) {
            return;
        }
        listLatlng.add(new LatLng(m11639d.getLatitude(), m11639d.getLongitude()));
        checkCampssBeann.setListLatlng(listLatlng);
        C2241c.m13122a().mo13117a(C2854c.f10520Z, checkCampssBeann);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
