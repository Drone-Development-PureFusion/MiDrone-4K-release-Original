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
public class NewHandStartPagerFragment extends BaseNewHandFragment {

    /* renamed from: c */
    private TextView f14094c;

    /* renamed from: d */
    private TextView f14095d;

    /* renamed from: e */
    private Button f14096e;

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected View mo8140a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(C2300R.layout.fragment_newhand_start, (ViewGroup) null);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8141a() {
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: a */
    protected void mo8139a(View view) {
        this.f14094c = (TextView) view.findViewById(C2300R.C2302id.newhand_title_tv);
        this.f14095d = (TextView) view.findViewById(C2300R.C2302id.newhand_content_tv);
        this.f14096e = (Button) view.findViewById(C2300R.C2302id.newhand_start_btn);
        this.f14096e.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f14094c, this.f14095d, this.f14096e);
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment
    /* renamed from: b */
    protected String mo8138b() {
        return null;
    }

    @Override // com.fimi.soul.module.setting.newhand.BaseNewHandFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.newhand_start_btn /* 2131493573 */:
                Log.i("zhej", "current:" + ((NewHandActivity) getActivity()).m8145a().getCurrentItem());
                ((NewHandActivity) getActivity()).m8145a().setCurrentItem(((NewHandActivity) getActivity()).m8145a().getCurrentItem() + 1, true);
                return;
            default:
                return;
        }
    }
}
