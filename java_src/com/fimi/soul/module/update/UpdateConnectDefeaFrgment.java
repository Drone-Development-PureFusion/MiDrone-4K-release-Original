package com.fimi.soul.module.update;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
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
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class UpdateConnectDefeaFrgment extends Fragment implements View.OnClickListener {

    /* renamed from: b */
    private Button f14384b;

    /* renamed from: c */
    private Button f14385c;

    /* renamed from: d */
    private Button f14386d;

    /* renamed from: e */
    private ImageView f14387e;

    /* renamed from: f */
    private TextView f14388f;

    /* renamed from: g */
    private TextView f14389g;

    /* renamed from: h */
    private Context f14390h;

    /* renamed from: i */
    private String f14391i;

    /* renamed from: j */
    private String f14392j;

    /* renamed from: k */
    private String f14393k;

    /* renamed from: n */
    private AbstractC3566a f14396n;

    /* renamed from: l */
    private boolean f14394l = false;

    /* renamed from: m */
    private boolean f14395m = false;

    /* renamed from: o */
    private boolean f14397o = false;

    /* renamed from: a */
    Handler f14383a = new Handler() { // from class: com.fimi.soul.module.update.UpdateConnectDefeaFrgment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            UpdateConnectDefeaFrgment.this.f14396n.mo8034g();
        }
    };

    /* renamed from: com.fimi.soul.module.update.UpdateConnectDefeaFrgment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3566a {
        /* renamed from: g */
        void mo8034g();

        /* renamed from: h */
        void mo8033h();
    }

    /* renamed from: a */
    private void m8042a() {
        this.f14387e.startAnimation(AnimationUtils.loadAnimation(this.f14390h, C2300R.anim.update_connect_defea_scale));
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f14390h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation.setStartOffset(350L);
        this.f14388f.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f14390h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation2.setStartOffset(400L);
        this.f14389g.startAnimation(loadAnimation2);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.f14390h, C2300R.anim.update_connect_defea_alpha_trans);
        loadAnimation3.setStartOffset(450L);
        this.f14384b.startAnimation(loadAnimation3);
        this.f14385c.startAnimation(loadAnimation3);
    }

    /* renamed from: a */
    public void m8040a(String str) {
        this.f14392j = str;
    }

    /* renamed from: a */
    public void m8039a(boolean z) {
        this.f14395m = z;
    }

    /* renamed from: b */
    public void m8038b(String str) {
        this.f14391i = str;
    }

    /* renamed from: b */
    public void m8037b(boolean z) {
        this.f14397o = z;
    }

    /* renamed from: c */
    public void m8036c(String str) {
        this.f14393k = str;
    }

    /* renamed from: c */
    public void m8035c(boolean z) {
        this.f14394l = z;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        int i = 0;
        super.onActivityCreated(bundle);
        this.f14389g.setText(this.f14392j);
        this.f14388f.setText(this.f14391i);
        this.f14384b.setText(this.f14393k);
        if (this.f14395m) {
            this.f14383a.sendEmptyMessageDelayed(0, 2000L);
            this.f14387e.setBackgroundResource(C2300R.C2301drawable.newbie_finish_icon);
        }
        if (this.f14397o) {
            this.f14385c.setVisibility(0);
            this.f14385c.setText(getString(C2300R.C2303string.begincalibration));
            this.f14384b.setVisibility(0);
            this.f14384b.setText(getString(C2300R.C2303string.ignore));
            this.f14386d.setVisibility(8);
            return;
        }
        this.f14385c.setVisibility((this.f14394l || this.f14395m) ? 8 : 0);
        this.f14384b.setVisibility((this.f14394l || this.f14395m) ? 8 : 0);
        Button button = this.f14386d;
        if (!this.f14394l || this.f14395m) {
            i = 8;
        }
        button.setVisibility(i);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14390h = activity;
        this.f14396n = (AbstractC3566a) activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.retry_btn /* 2131492966 */:
                this.f14396n.mo8033h();
                return;
            case C2300R.C2302id.noconnect_bt /* 2131493126 */:
                this.f14396n.mo8034g();
                return;
            case C2300R.C2302id.ignore_bt /* 2131493127 */:
                this.f14396n.mo8034g();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.activity_update_connect_defea, viewGroup, false);
        this.f14388f = (TextView) inflate.findViewById(C2300R.C2302id.update_fail_tv);
        this.f14389g = (TextView) inflate.findViewById(C2300R.C2302id.fail_reason);
        this.f14387e = (ImageView) inflate.findViewById(C2300R.C2302id.connect_defeat_iv);
        this.f14384b = (Button) inflate.findViewById(C2300R.C2302id.noconnect_bt);
        this.f14385c = (Button) inflate.findViewById(C2300R.C2302id.retry_btn);
        this.f14386d = (Button) inflate.findViewById(C2300R.C2302id.ignore_bt);
        this.f14384b.setOnClickListener(this);
        this.f14385c.setOnClickListener(this);
        this.f14386d.setOnClickListener(this);
        m8042a();
        C3658ar.m7612a(this.f14390h.getAssets(), this.f14388f, this.f14389g, this.f14385c, this.f14384b);
        return inflate;
    }
}
