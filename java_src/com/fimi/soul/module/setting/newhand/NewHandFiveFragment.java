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
public class NewHandFiveFragment extends BaseNewHandFragment {

    /* renamed from: c */
    TextView f14039c;

    /* renamed from: d */
    TextView f14040d;

    /* renamed from: e */
    TextView f14041e;

    /* renamed from: f */
    TextView f14042f;

    /* renamed from: g */
    TextView f14043g;

    /* renamed from: h */
    TextView f14044h;

    /* renamed from: i */
    TextView f14045i;

    /* renamed from: j */
    TextView f14046j;

    /* renamed from: k */
    TextView f14047k;

    /* renamed from: l */
    Button f14048l;

    /* renamed from: a */
    private SpannableString m8144a(int i) {
        String string = getString(i);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C2300R.color.white)), string.length() - 2, string.length(), 33);
        return spannableString;
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_five, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14039c.setText("5");
        this.f14041e.setText(C2300R.C2303string.about_right_stick);
        this.f14045i.setText(C2300R.C2303string.new_hand_five_tip_one);
        this.f14046j.setText(C2300R.C2303string.new_hand_five_tip_two);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14039c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14040d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14041e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14042f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14045i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_one);
        this.f14043g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14046j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14044h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14048l = (Button) view.findViewById(C2300R.C2302id.btn_next);
        this.f14048l.setOnClickListener(this);
        this.f14047k = (TextView) view.findViewById(C2300R.C2302id.tv_tip_four);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14039c, this.f14040d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14041e, this.f14042f, this.f14043g, this.f14044h, this.f14045i, this.f14046j, this.f14047k, this.f14048l);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return NewHandFiveFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14048l) {
            Log.i("zhej", "current:" + ((NewHandActivity) getActivity()).m8145a().getCurrentItem());
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
