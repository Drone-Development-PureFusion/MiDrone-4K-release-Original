package com.fimi.soul.module.paircode;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class PairErrorFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    PairCodeActivity f13252a;

    /* renamed from: b */
    Button f13253b;

    /* renamed from: c */
    View f13254c;

    /* renamed from: d */
    private TextView f13255d;

    /* renamed from: e */
    private TextView f13256e;

    /* renamed from: a */
    private void m8498a(View view) {
        this.f13255d = (TextView) view.findViewById(C2300R.C2302id.connect_dis_title);
        this.f13256e = (TextView) view.findViewById(C2300R.C2302id.connect_dis_tip);
        this.f13253b = (Button) view.findViewById(C2300R.C2302id.dis_con_submit);
        C3658ar.m7612a(this.f13252a.getAssets(), this.f13256e, this.f13255d, this.f13253b);
        this.f13253b.setOnClickListener(this);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13252a = (PairCodeActivity) activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.dis_con_submit /* 2131493735 */:
                this.f13252a.finish();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13254c = layoutInflater.inflate(C2300R.layout.pair_disconnect_layout, (ViewGroup) null);
        m8498a(this.f13254c);
        return this.f13254c;
    }
}
