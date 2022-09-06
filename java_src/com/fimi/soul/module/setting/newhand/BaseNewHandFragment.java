package com.fimi.soul.module.setting.newhand;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public abstract class BaseNewHandFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    protected Context f13954a;

    /* renamed from: b */
    protected FragmentManager f13955b;

    /* renamed from: c */
    private TextView f13956c;

    /* renamed from: a */
    protected abstract View mo8140a(LayoutInflater layoutInflater);

    /* renamed from: a */
    protected abstract void mo8141a();

    /* renamed from: a */
    protected abstract void mo8139a(View view);

    /* renamed from: b */
    protected abstract String mo8138b();

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13954a = activity.getApplicationContext();
        this.f13955b = getFragmentManager();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.newhand_skip_tv /* 2131493558 */:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View mo8140a = mo8140a(layoutInflater);
        mo8139a(mo8140a);
        mo8141a();
        this.f13956c = (TextView) mo8140a.findViewById(C2300R.C2302id.newhand_skip_tv);
        C2238c.m13125c().mo13108d(C2353b.f7960r);
        this.f13956c.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13956c);
        return mo8140a;
    }
}
