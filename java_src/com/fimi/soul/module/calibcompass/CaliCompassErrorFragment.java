package com.fimi.soul.module.calibcompass;

import android.app.Activity;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.CheckCampssBeann;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.utils.C3658ar;
import it.p235a.p236a.AbstractC4863e;
import java.util.List;
/* loaded from: classes.dex */
public class CaliCompassErrorFragment extends BaseCaliCompassFragment {

    /* renamed from: f */
    AbstractC3070a f11436f;

    /* renamed from: g */
    private Button f11437g;

    /* renamed from: h */
    private Button f11438h;

    /* renamed from: i */
    private Button f11439i;

    /* renamed from: j */
    private ImageView f11440j;

    /* renamed from: k */
    private TextView f11441k;

    /* renamed from: l */
    private TextView f11442l;

    /* renamed from: m */
    private boolean f11443m;

    /* renamed from: n */
    private boolean f11444n;

    /* renamed from: o */
    private boolean f11445o;

    /* renamed from: p */
    private Handler f11446p = new Handler();

    /* renamed from: q */
    private Runnable f11447q = new Runnable() { // from class: com.fimi.soul.module.calibcompass.CaliCompassErrorFragment.1
        @Override // java.lang.Runnable
        public void run() {
            CaliCompassErrorFragment.this.getActivity().setResult(0);
            CaliCompassErrorFragment.this.getActivity().finish();
        }
    };

    /* renamed from: r */
    private int f11448r;

    /* renamed from: com.fimi.soul.module.calibcompass.CaliCompassErrorFragment$a */
    /* loaded from: classes.dex */
    interface AbstractC3070a {
        /* renamed from: d */
        void mo9767d();

        /* renamed from: e */
        void mo9766e();
    }

    /* renamed from: a */
    private void m9775a(View view) {
        this.f11440j = (ImageView) view.findViewById(C2300R.C2302id.tagIcon);
        this.f11437g = (Button) view.findViewById(C2300R.C2302id.quit);
        this.f11437g.setOnClickListener(this);
        this.f11438h = (Button) view.findViewById(C2300R.C2302id.again);
        this.f11438h.setOnClickListener(this);
        this.f11439i = (Button) view.findViewById(C2300R.C2302id.sucesscomplete);
        this.f11439i.setOnClickListener(this);
        this.f11441k = (TextView) view.findViewById(C2300R.C2302id.destitle);
        this.f11442l = (TextView) view.findViewById(C2300R.C2302id.calireason);
        m9774a(this.f11437g, 128);
        m9774a(this.f11438h, AbstractC4863e.f20785F);
        C3658ar.m7612a(getActivity().getAssets(), this.f11437g, this.f11438h, this.f11439i, this.f11441k, this.f11442l);
    }

    /* renamed from: b */
    private void m9771b() {
        this.f11437g.setVisibility(0);
        this.f11438h.setVisibility(0);
        this.f11439i.setVisibility(8);
    }

    /* renamed from: c */
    private void m9770c() {
        this.f11437g.setVisibility(8);
        this.f11438h.setVisibility(8);
        this.f11439i.setVisibility(0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.fimi.soul.module.calibcompass.CaliCompassErrorFragment$2] */
    /* renamed from: d */
    private void m9769d() {
        new AsyncTask<Void, Void, Void>() { // from class: com.fimi.soul.module.calibcompass.CaliCompassErrorFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                CheckCampssBeann checkCampssBeann;
                List<LatLng> listLatlng;
                CheckCampssBeann checkCampssBeann2 = (CheckCampssBeann) C2241c.m13122a().mo13118a(C2854c.f10520Z, CheckCampssBeann.class);
                if (checkCampssBeann2 != null) {
                    checkCampssBeann = checkCampssBeann2;
                    listLatlng = checkCampssBeann2.getListLatlng();
                } else {
                    checkCampssBeann = new CheckCampssBeann();
                    listLatlng = checkCampssBeann.getListLatlng();
                }
                Location m11639d = C2571k.m11651a(CaliCompassErrorFragment.this.getActivity()).m11639d();
                if (m11639d != null) {
                    listLatlng.add(new LatLng(m11639d.getLatitude(), m11639d.getLongitude()));
                    checkCampssBeann.setListLatlng(listLatlng);
                    C2241c.m13122a().mo13117a(C2854c.f10520Z, checkCampssBeann);
                    return null;
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* renamed from: a */
    public void m9776a() {
        C3057d.m9823a(this.f11392b).m9833a((byte) 1, (byte) 1, (byte) 4);
        getActivity().finish();
    }

    /* renamed from: a */
    public void m9774a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    public void m9773a(String str, boolean z, boolean z2) {
        this.f11444n = z;
        this.f11445o = z2;
        if (true != z) {
            this.f11441k.setText(C2300R.C2303string.califail);
            this.f11442l.setText(str);
            PercentRelativeLayout.LayoutParams layoutParams = (PercentRelativeLayout.LayoutParams) this.f11440j.getLayoutParams();
            layoutParams.setMargins(0, (int) (this.f11448r * 0.12592f), 0, 0);
            this.f11440j.setLayoutParams(layoutParams);
            this.f11440j.setImageResource(C2300R.C2301drawable.icon_calibration_defeat);
            m9771b();
            return;
        }
        this.f11441k.setText(C2300R.C2303string.calisucess);
        this.f11442l.setText(str);
        PercentRelativeLayout.LayoutParams layoutParams2 = (PercentRelativeLayout.LayoutParams) this.f11440j.getLayoutParams();
        layoutParams2.setMargins(0, (int) (this.f11448r * 0.1111f), 0, 0);
        this.f11440j.setLayoutParams(layoutParams2);
        this.f11440j.setImageResource(C2300R.C2301drawable.icon_calibration_succeed);
        m9770c();
        m9769d();
    }

    /* renamed from: a */
    public void m9772a(boolean z) {
        this.f11443m = z;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11436f = (AbstractC3070a) activity;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.quit /* 2131492875 */:
                if (this.f11436f == null) {
                    return;
                }
                this.f11436f.mo9766e();
                return;
            case C2300R.C2302id.again /* 2131493220 */:
                ((CaliCompassActivity) getActivity()).m9783a(getString(C2300R.C2303string.compass_calibration));
                if (this.f11436f == null) {
                    return;
                }
                this.f11436f.mo9767d();
                return;
            case C2300R.C2302id.sucesscomplete /* 2131493221 */:
                this.f11446p.postDelayed(this.f11447q, 300L);
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                this.f11446p.postDelayed(this.f11447q, 300L);
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f11448r = displayMetrics.heightPixels;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.cali_compass_error, (ViewGroup) null);
        m9775a(inflate);
        return inflate;
    }

    @Override // com.fimi.soul.module.calibcompass.BaseCaliCompassFragment, android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f11436f != null) {
            this.f11436f = null;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z || !isVisible()) {
            return;
        }
        if (this.f11444n) {
            C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calisucess));
        } else if (this.f11445o) {
        } else {
            C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calibration_failure));
        }
    }
}
