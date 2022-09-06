package com.fimi.soul.module.setting.newhand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3686n;
/* loaded from: classes.dex */
public class NewHandSevenFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14073c;

    /* renamed from: d */
    TextView f14074d;

    /* renamed from: e */
    TextView f14075e;

    /* renamed from: f */
    TextView f14076f;

    /* renamed from: g */
    TextView f14077g;

    /* renamed from: h */
    TextView f14078h;

    /* renamed from: i */
    TextView f14079i;

    /* renamed from: j */
    TextView f14080j;

    /* renamed from: k */
    TextView f14081k;

    /* renamed from: l */
    TextView f14082l;

    /* renamed from: m */
    TextView f14083m;

    /* renamed from: n */
    Button f14084n;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_seven, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14073c.setText(C3686n.f15083l);
        this.f14075e.setText(C2300R.C2303string.ready_flying);
        this.f14079i.setText(C2300R.C2303string.new_hand_seven_tip_one);
        this.f14080j.setText(C2300R.C2303string.new_hand_seven_tip_two);
        this.f14081k.setText(C2300R.C2303string.new_hand_seven_tip_three);
        this.f14083m.setText(C2300R.C2303string.new_hand_seven_tip_four);
        this.f14084n.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14073c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14074d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14075e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14076f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14079i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14077g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14080j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14078h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14081k = (TextView) view.findViewById(C2300R.C2302id.tv_tip_three);
        this.f14082l = (TextView) view.findViewById(C2300R.C2302id.tv_number_four);
        this.f14083m = (TextView) view.findViewById(C2300R.C2302id.tv_tip_four);
        this.f14084n = (Button) view.findViewById(C2300R.C2302id.btn_next);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14073c, this.f14074d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14075e, this.f14076f, this.f14077g, this.f14078h, this.f14079i, this.f14080j, this.f14081k, this.f14084n, this.f14082l, this.f14083m);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandSevenFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14084n) {
            C2238c.m13125c().mo13114a(C2353b.f7960r, true);
            getActivity().finish();
        }
    }
}
