package com.fimi.soul.module.setting.newhand;

import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class NewHandThreeFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14097c;

    /* renamed from: d */
    TextView f14098d;

    /* renamed from: e */
    TextView f14099e;

    /* renamed from: f */
    TextView f14100f;

    /* renamed from: g */
    TextView f14101g;

    /* renamed from: h */
    TextView f14102h;

    /* renamed from: i */
    TextView f14103i;

    /* renamed from: j */
    TextView f14104j;

    /* renamed from: k */
    TextView f14105k;

    /* renamed from: l */
    TextView f14106l;

    /* renamed from: m */
    TextView f14107m;

    /* renamed from: n */
    Button f14108n;

    /* renamed from: o */
    private ImageView f14109o;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_three, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14097c.setText("3");
        this.f14099e.setText(C2300R.C2303string.new_hand_about_drone);
        this.f14103i.setText(C2300R.C2303string.new_hand_three_tip_one);
        this.f14104j.setText(C2300R.C2303string.new_hand_three_tip_two);
        this.f14105k.setText(C2300R.C2303string.new_hand_three_tip_three);
        this.f14108n.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14109o = (ImageView) view.findViewById(C2300R.C2302id.left_iv);
        this.f14109o.setBackgroundResource(C2300R.C2301drawable.newhand_three_anim);
        ((AnimationDrawable) this.f14109o.getBackground()).start();
        this.f14097c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14098d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14099e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14100f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14103i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14101g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14104j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14102h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14105k = (TextView) view.findViewById(C2300R.C2302id.tv_tip_three);
        this.f14108n = (Button) view.findViewById(C2300R.C2302id.btn_next);
        this.f14106l = (TextView) view.findViewById(C2300R.C2302id.tv_plane_header);
        this.f14107m = (TextView) view.findViewById(C2300R.C2302id.tv_plane_tail);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14097c, this.f14098d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14099e, this.f14100f, this.f14101g, this.f14102h, this.f14103i, this.f14104j, this.f14105k, this.f14108n, this.f14106l, this.f14107m);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandThreeFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14108n) {
            Log.i("zhej", "current:" + ((NewHandActivity) getActivity()).m8145a().getCurrentItem());
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
