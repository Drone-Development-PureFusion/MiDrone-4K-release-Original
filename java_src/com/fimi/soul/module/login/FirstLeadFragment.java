package com.fimi.soul.module.login;

import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class FirstLeadFragment extends Fragment implements View.OnClickListener {

    /* renamed from: k */
    private static final int f12948k = 1;

    /* renamed from: l */
    private static final int f12949l = 2;

    /* renamed from: m */
    private static final int f12950m = 3;

    /* renamed from: n */
    private static final int f12951n = 4;

    /* renamed from: o */
    private static final int f12952o = 5;

    /* renamed from: p */
    private static final int f12953p = 6;

    /* renamed from: q */
    private static final int f12954q = 7;

    /* renamed from: r */
    private static final int f12955r = 8;

    /* renamed from: A */
    private TextView f12956A;

    /* renamed from: B */
    private TextView f12957B;

    /* renamed from: C */
    private TextView f12958C;

    /* renamed from: D */
    private TextView f12959D;

    /* renamed from: E */
    private TextView f12960E;

    /* renamed from: F */
    private TextView f12961F;

    /* renamed from: G */
    private TextView f12962G;

    /* renamed from: H */
    private TextView f12963H;

    /* renamed from: I */
    private TextView f12964I;

    /* renamed from: J */
    private TextView f12965J;

    /* renamed from: a */
    RelativeLayout f12966a;

    /* renamed from: b */
    RelativeLayout f12967b;

    /* renamed from: c */
    RelativeLayout f12968c;

    /* renamed from: d */
    RelativeLayout f12969d;

    /* renamed from: e */
    RelativeLayout f12970e;

    /* renamed from: f */
    RelativeLayout f12971f;

    /* renamed from: g */
    RelativeLayout f12972g;

    /* renamed from: h */
    RelativeLayout f12973h;

    /* renamed from: i */
    PercentRelativeLayout f12974i;

    /* renamed from: j */
    AbstractC3337a f12975j;

    /* renamed from: s */
    private int f12976s = 1;

    /* renamed from: t */
    private C2277v f12977t;

    /* renamed from: u */
    private TextView f12978u;

    /* renamed from: v */
    private TextView f12979v;

    /* renamed from: w */
    private TextView f12980w;

    /* renamed from: x */
    private TextView f12981x;

    /* renamed from: y */
    private TextView f12982y;

    /* renamed from: z */
    private TextView f12983z;

    /* renamed from: com.fimi.soul.module.login.FirstLeadFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3337a {
        /* renamed from: n */
        void mo8655n();
    }

    /* renamed from: a */
    public AbstractC3337a m8659a() {
        return this.f12975j;
    }

    /* renamed from: a */
    void m8658a(int i) {
        this.f12966a.setVisibility(8);
        this.f12967b.setVisibility(8);
        this.f12968c.setVisibility(8);
        this.f12969d.setVisibility(8);
        this.f12970e.setVisibility(8);
        this.f12972g.setVisibility(8);
        this.f12971f.setVisibility(8);
        this.f12973h.setVisibility(8);
        switch (i) {
            case 1:
                this.f12967b.setVisibility(0);
                return;
            case 2:
                this.f12971f.setVisibility(0);
                return;
            case 3:
                this.f12972g.setVisibility(0);
                return;
            case 4:
                this.f12970e.setVisibility(0);
                return;
            case 5:
                this.f12969d.setVisibility(0);
                return;
            case 6:
                this.f12968c.setVisibility(0);
                return;
            case 7:
                this.f12966a.setVisibility(0);
                return;
            case 8:
                this.f12973h.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    void m8657a(View view) {
        this.f12974i = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.root_layout);
        this.f12966a = (RelativeLayout) view.findViewById(C2300R.C2302id.setting_layout);
        this.f12967b = (RelativeLayout) view.findViewById(C2300R.C2302id.error_status_layout);
        this.f12968c = (RelativeLayout) view.findViewById(C2300R.C2302id.baoxiang_layout);
        this.f12969d = (RelativeLayout) view.findViewById(C2300R.C2302id.location_layout);
        this.f12970e = (RelativeLayout) view.findViewById(C2300R.C2302id.controll_status_layout);
        this.f12971f = (RelativeLayout) view.findViewById(C2300R.C2302id.battery_layout);
        this.f12972g = (RelativeLayout) view.findViewById(C2300R.C2302id.gsp_layout);
        this.f12973h = (RelativeLayout) view.findViewById(C2300R.C2302id.modle_layout);
        this.f12958C = (TextView) view.findViewById(C2300R.C2302id.error_des);
        this.f12959D = (TextView) view.findViewById(C2300R.C2302id.setting_des);
        this.f12960E = (TextView) view.findViewById(C2300R.C2302id.battery_des);
        this.f12961F = (TextView) view.findViewById(C2300R.C2302id.gsp_des);
        this.f12962G = (TextView) view.findViewById(C2300R.C2302id.controller_des);
        this.f12963H = (TextView) view.findViewById(C2300R.C2302id.location_des);
        this.f12965J = (TextView) view.findViewById(C2300R.C2302id.modle_des);
        this.f12978u = (TextView) view.findViewById(C2300R.C2302id.error_status_title);
        this.f12979v = (TextView) view.findViewById(C2300R.C2302id.setting_title);
        this.f12980w = (TextView) view.findViewById(C2300R.C2302id.battery_title);
        this.f12981x = (TextView) view.findViewById(C2300R.C2302id.gsp_title);
        this.f12982y = (TextView) view.findViewById(C2300R.C2302id.controll_status_title);
        this.f12983z = (TextView) view.findViewById(C2300R.C2302id.location_title);
        this.f12957B = (TextView) view.findViewById(C2300R.C2302id.modle_title);
        C3658ar.m7612a(getActivity().getAssets(), this.f12958C, this.f12960E, this.f12959D, this.f12963H, this.f12961F, this.f12964I, this.f12962G, this.f12960E, this.f12965J, this.f12978u, this.f12980w, this.f12979v, this.f12983z, this.f12981x, this.f12956A, this.f12982y, this.f12980w, this.f12957B);
        this.f12974i.setOnClickListener(this);
    }

    /* renamed from: a */
    public void m8656a(AbstractC3337a abstractC3337a) {
        this.f12975j = abstractC3337a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.root_layout /* 2131493107 */:
                switch (this.f12976s) {
                    case 1:
                        this.f12976s = 2;
                        break;
                    case 2:
                        this.f12976s = 3;
                        break;
                    case 3:
                        this.f12976s = 4;
                        break;
                    case 4:
                        this.f12976s = 5;
                        break;
                    case 5:
                        this.f12976s = 6;
                        break;
                    case 6:
                        this.f12976s = 7;
                        break;
                    case 7:
                        this.f12976s = 8;
                        break;
                    case 8:
                        if (this.f12975j != null) {
                            this.f12975j.mo8655n();
                            break;
                        }
                        break;
                }
            case C2300R.C2302id.error_status_layout /* 2131493676 */:
                this.f12976s = 2;
                break;
            case C2300R.C2302id.controll_status_layout /* 2131493680 */:
                this.f12976s = 5;
                break;
            case C2300R.C2302id.baoxiang_layout /* 2131493684 */:
                this.f12976s = 7;
                break;
            case C2300R.C2302id.location_layout /* 2131493688 */:
                this.f12976s = 6;
                break;
            case C2300R.C2302id.gsp_layout /* 2131493692 */:
                this.f12976s = 4;
                break;
            case C2300R.C2302id.setting_layout /* 2131493696 */:
                this.f12976s = 8;
                break;
            case C2300R.C2302id.battery_layout /* 2131493700 */:
                this.f12976s = 3;
                break;
            case C2300R.C2302id.modle_layout /* 2131493704 */:
                if (this.f12975j != null) {
                    this.f12975j.mo8655n();
                    break;
                }
                break;
        }
        m8658a(this.f12976s);
        this.f12977t.m12787a().edit().putInt("curModel", this.f12976s).commit();
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = View.inflate(getActivity(), C2300R.layout.lead_layout, null);
        m8657a(inflate);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f12977t = C2277v.m12784a(getActivity());
        this.f12976s = this.f12977t.m12787a().getInt("curModel", 1);
        m8658a(this.f12976s);
    }
}
