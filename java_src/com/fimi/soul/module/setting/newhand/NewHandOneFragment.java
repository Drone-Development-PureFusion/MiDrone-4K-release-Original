package com.fimi.soul.module.setting.newhand;

import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.Timer;
/* loaded from: classes.dex */
public class NewHandOneFragment extends BaseNewHandFragment {

    /* renamed from: m */
    private static AbstractC3529a f14059m;

    /* renamed from: c */
    TextView f14060c;

    /* renamed from: d */
    TextView f14061d;

    /* renamed from: e */
    TextView f14062e;

    /* renamed from: f */
    TextView f14063f;

    /* renamed from: g */
    TextView f14064g;

    /* renamed from: h */
    TextView f14065h;

    /* renamed from: i */
    TextView f14066i;

    /* renamed from: j */
    TextView f14067j;

    /* renamed from: k */
    Button f14068k;

    /* renamed from: l */
    private ImageView f14069l;

    /* renamed from: o */
    private Timer f14071o;

    /* renamed from: n */
    private boolean f14070n = false;

    /* renamed from: p */
    private AnimationDrawable f14072p = null;

    /* renamed from: a */
    public static NewHandOneFragment m8142a(AbstractC3529a abstractC3529a) {
        f14059m = abstractC3529a;
        return new NewHandOneFragment();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_one, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
        this.f14060c.setText("1");
        this.f14062e.setText(C2300R.C2303string.new_hand_mode);
        this.f14066i.setText(C2300R.C2303string.new_hand_one_tip_two);
        this.f14067j.setText(C2300R.C2303string.new_hand_one_tip_three);
        this.f14068k.setText(C2300R.C2303string.new_hand_next);
        this.f14068k.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14069l = (ImageView) view.findViewById(C2300R.C2302id.img_left);
        this.f14069l.setBackgroundResource(C2300R.C2301drawable.img_guide_fly_scope);
        this.f14060c = (TextView) view.findViewById(C2300R.C2302id.tv_seq);
        this.f14061d = (TextView) view.findViewById(C2300R.C2302id.tv_total);
        this.f14062e = (TextView) view.findViewById(C2300R.C2302id.tv_title);
        this.f14063f = (TextView) view.findViewById(C2300R.C2302id.tv_number_one);
        this.f14064g = (TextView) view.findViewById(C2300R.C2302id.tv_number_two);
        this.f14066i = (TextView) view.findViewById(C2300R.C2302id.tv_tip_two);
        this.f14065h = (TextView) view.findViewById(C2300R.C2302id.tv_number_three);
        this.f14067j = (TextView) view.findViewById(C2300R.C2302id.tv_tip_three);
        this.f14068k = (Button) view.findViewById(C2300R.C2302id.btn_next);
        C3658ar.m7598b(this.f13954a.getAssets(), this.f14060c, this.f14061d);
        C3658ar.m7612a(this.f13954a.getAssets(), this.f14062e, this.f14063f, this.f14064g, this.f14065h, this.f14066i, this.f14067j, this.f14068k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    public String mo8138b() {
        return NewHandOneFragment.class.getName().toLowerCase();
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f14068k) {
            ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
        }
    }
}
