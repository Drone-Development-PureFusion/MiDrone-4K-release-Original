package com.fimi.soul.module.paircode;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.utils.C3658ar;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class PairResultFragment extends Fragment implements View.OnClickListener, AbstractC3401a {

    /* renamed from: a */
    RelativeLayout f13271a;

    /* renamed from: b */
    RelativeLayout f13272b;

    /* renamed from: c */
    RelativeLayout f13273c;

    /* renamed from: e */
    TextView f13275e;

    /* renamed from: f */
    TextView f13276f;

    /* renamed from: g */
    TextView f13277g;

    /* renamed from: h */
    TextView f13278h;

    /* renamed from: i */
    Button f13279i;

    /* renamed from: j */
    Button f13280j;

    /* renamed from: k */
    Button f13281k;

    /* renamed from: l */
    ProgressView f13282l;

    /* renamed from: m */
    PairCodeActivity f13283m;

    /* renamed from: n */
    View f13284n;

    /* renamed from: o */
    Timer f13285o;

    /* renamed from: p */
    private final int f13286p = 2;

    /* renamed from: q */
    private final int f13287q = 3;

    /* renamed from: r */
    private final int f13288r = 4;

    /* renamed from: s */
    private final int f13289s = -1;

    /* renamed from: t */
    private final int f13290t = 0;

    /* renamed from: d */
    public int f13274d = 0;

    /* renamed from: u */
    private final int f13291u = 256;

    /* renamed from: v */
    private Handler f13292v = new Handler() { // from class: com.fimi.soul.module.paircode.PairResultFragment.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 256:
                    PairResultFragment.this.f13282l.setCurrentCount(PairResultFragment.this.f13274d);
                    PairResultFragment.this.f13277g.setText(String.valueOf(PairResultFragment.this.f13274d));
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.paircode.PairResultFragment$a */
    /* loaded from: classes.dex */
    public enum EnumC3400a {
        success,
        fail,
        busy
    }

    /* renamed from: a */
    private void m8495a(View view) {
        this.f13272b = (RelativeLayout) view.findViewById(C2300R.C2302id.pair_fail);
        this.f13278h = (TextView) this.f13272b.findViewById(C2300R.C2302id.pair_fail_rt);
        this.f13271a = (RelativeLayout) view.findViewById(C2300R.C2302id.pair_success);
        this.f13273c = (RelativeLayout) view.findViewById(C2300R.C2302id.pair_progress);
        this.f13282l = (ProgressView) this.f13284n.findViewById(C2300R.C2302id.progress_v);
        this.f13282l.setFrontColor(getResources().getColor(C2300R.color.white_half));
        this.f13282l.setMaxCount(100.0f);
        this.f13282l.setCurrentCount(0.0f);
        this.f13275e = (TextView) this.f13284n.findViewById(C2300R.C2302id.connect_des);
        this.f13276f = (TextView) this.f13284n.findViewById(C2300R.C2302id.connect_des_tip);
        this.f13277g = (TextView) this.f13284n.findViewById(C2300R.C2302id.pair_index);
        C3658ar.m7598b(getActivity().getAssets(), this.f13277g);
        this.f13279i = (Button) this.f13284n.findViewById(C2300R.C2302id.exit_btn);
        this.f13280j = (Button) this.f13284n.findViewById(C2300R.C2302id.repair_btn);
        this.f13281k = (Button) this.f13284n.findViewById(C2300R.C2302id.con_submit);
        this.f13281k.setOnClickListener(this);
        this.f13279i.setOnClickListener(this);
        this.f13280j.setOnClickListener(this);
        C3658ar.m7612a(getActivity().getAssets(), this.f13275e, this.f13276f, this.f13277g, this.f13279i, this.f13280j, this.f13281k);
    }

    /* renamed from: a */
    private void m8494a(EnumC3400a enumC3400a) {
        this.f13272b.setVisibility(8);
        this.f13271a.setVisibility(8);
        this.f13273c.setVisibility(8);
        switch (enumC3400a) {
            case success:
                this.f13273c.setVisibility(0);
                if (this.f13274d == -1) {
                    this.f13273c.setVisibility(8);
                    this.f13278h.setText(getResources().getString(C2300R.C2303string.pair_outtime));
                    this.f13272b.setVisibility(0);
                    this.f13283m.m8501a(false);
                    return;
                } else if (this.f13274d != 100) {
                    if (C2367d.m12459a().m12438k()) {
                        this.f13282l.setCurrentCount(this.f13274d);
                        this.f13277g.setText(String.valueOf(this.f13274d));
                        return;
                    }
                    this.f13285o = new Timer();
                    this.f13285o.schedule(new TimerTask() { // from class: com.fimi.soul.module.paircode.PairResultFragment.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            PairResultFragment.this.f13292v.sendEmptyMessage(256);
                            PairResultFragment.this.f13274d = 10;
                        }
                    }, 200L, 200L);
                    return;
                } else {
                    this.f13273c.setVisibility(8);
                    this.f13272b.setVisibility(8);
                    this.f13271a.setVisibility(0);
                    if (C2367d.m12459a().m12438k() || this.f13285o == null) {
                        return;
                    }
                    this.f13285o.cancel();
                    this.f13285o = null;
                    return;
                }
            case fail:
                this.f13272b.setVisibility(0);
                return;
            case busy:
                this.f13278h.setText(getResources().getString(C2300R.C2303string.pair_busy));
                this.f13272b.setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.module.paircode.AbstractC3401a
    /* renamed from: a */
    public void mo8492a(int i) {
    }

    @Override // com.fimi.soul.module.paircode.AbstractC3401a
    /* renamed from: a */
    public void mo8491a(int i, int i2) {
        switch (i) {
            case 2:
                this.f13274d = i2;
                m8494a(EnumC3400a.success);
                return;
            case 3:
                m8494a(EnumC3400a.fail);
                return;
            case 4:
                m8494a(EnumC3400a.busy);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13283m = (PairCodeActivity) activity;
        this.f13283m.m8502a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.exit_btn /* 2131493740 */:
                getActivity().finish();
                return;
            case C2300R.C2302id.repair_btn /* 2131493741 */:
                this.f13283m.m8504a();
                return;
            case C2300R.C2302id.con_submit /* 2131493750 */:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13284n = layoutInflater.inflate(C2300R.layout.pair_rt_layout, (ViewGroup) null);
        m8495a(this.f13284n);
        return this.f13284n;
    }
}
