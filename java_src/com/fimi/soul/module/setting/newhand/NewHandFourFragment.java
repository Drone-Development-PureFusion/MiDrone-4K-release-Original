package com.fimi.soul.module.setting.newhand;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class NewHandFourFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14049c;

    /* renamed from: d */
    TextView f14050d;

    /* renamed from: e */
    TextView f14051e;

    /* renamed from: f */
    TextView f14052f;

    /* renamed from: g */
    TextView f14053g;

    /* renamed from: h */
    TextView f14054h;

    /* renamed from: i */
    TextView f14055i;

    /* renamed from: j */
    TextView f14056j;

    /* renamed from: k */
    TextView f14057k;

    /* renamed from: l */
    Button f14058l;

    /* renamed from: a */
    private SpannableString m8143a(int i) {
        String string = getString(i);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.white)), string.length() - 2, string.length(), 33);
        return spannableString;
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_four, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14049c.setText("4");
        this.f14051e.setText(C2300R.C2303string.about_left_stick);
        this.f14055i.setText(C2300R.C2303string.new_hand_four_tip_one);
        this.f14056j.setText(C2300R.C2303string.new_hand_four_tip_two);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14049c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14050d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14051e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14052f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14055i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14053g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14056j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14054h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14058l = (Button) view.findViewById(C2300R.C2302id.btn_next);
        this.f14058l.setOnClickListener(this);
        this.f14057k = (TextView) view.findViewById(C2300R.C2302id.tv_tip_four);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14049c, this.f14050d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14051e, this.f14052f, this.f14053g, this.f14054h, this.f14055i, this.f14056j, this.f14057k, this.f14058l);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandFourFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14058l) {
            Log.i("zhej", "current:" + ((NewHandActivity) getActivity()).m8145a().getCurrentItem());
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
