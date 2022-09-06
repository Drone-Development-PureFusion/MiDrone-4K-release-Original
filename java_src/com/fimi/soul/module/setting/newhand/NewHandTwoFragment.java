package com.fimi.soul.module.setting.newhand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class NewHandTwoFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14110c;

    /* renamed from: d */
    TextView f14111d;

    /* renamed from: e */
    TextView f14112e;

    /* renamed from: f */
    TextView f14113f;

    /* renamed from: g */
    TextView f14114g;

    /* renamed from: h */
    TextView f14115h;

    /* renamed from: i */
    TextView f14116i;

    /* renamed from: j */
    TextView f14117j;

    /* renamed from: k */
    TextView f14118k;

    /* renamed from: l */
    TextView f14119l;

    /* renamed from: m */
    TextView f14120m;

    /* renamed from: n */
    Button f14121n;

    /* renamed from: o */
    LoopWidget f14122o;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_two, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14110c.setText("2");
        this.f14112e.setText(C2300R.C2303string.new_hand_take_care);
        this.f14116i.setText(C2300R.C2303string.new_hand_two_tip_one);
        this.f14117j.setText(C2300R.C2303string.new_hand_two_tip_two);
        this.f14118k.setText(C2300R.C2303string.new_hand_two_tip_three);
        this.f14120m.setText(C2300R.C2303string.new_hand_two_tip_four);
        this.f14121n.setOnClickListener(this);
        int[] iArr = {C2300R.C2301drawable.newhand_pic_one, C2300R.C2301drawable.newhand_pic_two, C2300R.C2301drawable.newhand_pic_three, C2300R.C2301drawable.newhand_pic_four};
        this.f14122o.setVisibility(0);
        this.f14122o.setImagesRes(iArr);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14110c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14111d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14112e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14113f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14116i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14114g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14117j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14115h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14118k = (TextView) view.findViewById(C2300R.C2302id.tv_tip_three);
        this.f14121n = (Button) view.findViewById(C2300R.C2302id.btn_next);
        this.f14119l = (TextView) view.findViewById(C2300R.C2302id.tv_number_four);
        this.f14120m = (TextView) view.findViewById(C2300R.C2302id.tv_tip_four);
        this.f14122o = (LoopWidget) view.findViewById(C2300R.C2302id.kanner);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14110c, this.f14111d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14112e, this.f14113f, this.f14114g, this.f14115h, this.f14116i, this.f14117j, this.f14118k, this.f14119l, this.f14120m, this.f14121n);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandTwoFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14121n) {
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
