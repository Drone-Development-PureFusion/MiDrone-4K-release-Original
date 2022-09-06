package com.fimi.soul.module.update;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class AutoSelfErrorFrgment extends Fragment {

    /* renamed from: n */
    private static int f14253n = 0;

    /* renamed from: b */
    private Button f14255b;

    /* renamed from: c */
    private Button f14256c;

    /* renamed from: d */
    private Button f14257d;

    /* renamed from: e */
    private ImageView f14258e;

    /* renamed from: f */
    private TextView f14259f;

    /* renamed from: g */
    private TextView f14260g;

    /* renamed from: h */
    private Context f14261h;

    /* renamed from: i */
    private String f14262i;

    /* renamed from: j */
    private String f14263j;

    /* renamed from: k */
    private String f14264k;

    /* renamed from: l */
    private boolean f14265l = false;

    /* renamed from: m */
    private boolean f14266m = false;

    /* renamed from: a */
    Handler f14254a = new Handler() { // from class: com.fimi.soul.module.update.AutoSelfErrorFrgment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (AutoSelfErrorFrgment.this.getActivity() != null) {
                AutoSelfErrorFrgment.this.startActivity(new Intent(AutoSelfErrorFrgment.this.getActivity(), FlightActivity.class));
                AutoSelfErrorFrgment.this.getActivity().finish();
            }
        }
    };

    /* renamed from: a */
    private void m8102a() {
        this.f14258e.startAnimation(AnimationUtils.loadAnimation(this.f14261h, C2300R.anim.update_connect_defea_scale));
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f14261h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation.setStartOffset(350L);
        this.f14259f.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f14261h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation2.setStartOffset(400L);
        this.f14260g.startAnimation(loadAnimation2);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.f14261h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation3.setStartOffset(450L);
        this.f14255b.startAnimation(loadAnimation3);
        this.f14256c.startAnimation(loadAnimation3);
    }

    /* renamed from: a */
    public void m8101a(String str) {
        this.f14263j = str;
    }

    /* renamed from: a */
    public void m8100a(boolean z) {
        this.f14266m = z;
    }

    /* renamed from: b */
    public void m8099b(String str) {
        this.f14262i = str;
    }

    /* renamed from: b */
    public void m8098b(boolean z) {
        this.f14265l = z;
    }

    /* renamed from: c */
    public void m8097c(String str) {
        this.f14264k = str;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        int i = 0;
        super.onActivityCreated(bundle);
        this.f14260g.setText(this.f14263j);
        this.f14259f.setText(this.f14262i);
        this.f14255b.setText(this.f14264k);
        if (this.f14266m) {
            this.f14254a.sendEmptyMessageDelayed(f14253n, 2000L);
            this.f14258e.setBackgroundResource(C2300R.C2301drawable.newbie_finish_icon);
        }
        this.f14256c.setVisibility((this.f14265l || this.f14266m) ? 8 : 0);
        this.f14255b.setVisibility((this.f14265l || this.f14266m) ? 8 : 0);
        Button button = this.f14257d;
        if (!this.f14265l || this.f14266m) {
            i = 8;
        }
        button.setVisibility(i);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14261h = activity;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.activity_update_connect_defea, viewGroup, false);
        this.f14259f = (TextView) inflate.findViewById(C2300R.C2302id.update_fail_tv);
        this.f14260g = (TextView) inflate.findViewById(C2300R.C2302id.fail_reason);
        this.f14258e = (ImageView) inflate.findViewById(C2300R.C2302id.connect_defeat_iv);
        this.f14255b = (Button) inflate.findViewById(C2300R.C2302id.noconnect_bt);
        this.f14256c = (Button) inflate.findViewById(C2300R.C2302id.retry_btn);
        this.f14257d = (Button) inflate.findViewById(C2300R.C2302id.ignore_bt);
        m8102a();
        C3658ar.m7612a(this.f14261h.getAssets(), this.f14259f, this.f14260g, this.f14256c, this.f14255b);
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14254a.removeMessages(f14253n);
    }
}
