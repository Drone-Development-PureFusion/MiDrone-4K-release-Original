package com.fimi.soul.module.setting.newhand;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class NewHandSixFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14085c;

    /* renamed from: d */
    TextView f14086d;

    /* renamed from: e */
    TextView f14087e;

    /* renamed from: f */
    TextView f14088f;

    /* renamed from: g */
    TextView f14089g;

    /* renamed from: h */
    TextView f14090h;

    /* renamed from: i */
    TextView f14091i;

    /* renamed from: j */
    TextView f14092j;

    /* renamed from: k */
    Button f14093k;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_six, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14085c.setText("6");
        this.f14087e.setText(C2300R.C2303string.about_motor);
        this.f14091i.setText(C2300R.C2303string.new_hand_six_tip_one);
        this.f14092j.setText(C2300R.C2303string.new_hand_six_tip_two);
        this.f14093k.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14085c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14086d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14087e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14088f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14091i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14089g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14092j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14090h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14093k = (Button) view.findViewById(C2300R.C2302id.btn_next);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14085c, this.f14086d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14087e, this.f14088f, this.f14089g, this.f14090h, this.f14091i, this.f14092j, this.f14093k);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandSixFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14093k) {
            Log.i("zhej", "current:" + ((NewHandActivity) getActivity()).m8145a().getCurrentItem());
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
