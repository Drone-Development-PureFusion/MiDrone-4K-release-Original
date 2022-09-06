package com.fimi.soul.module.login;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p181j.C2496e;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.entity.User;
import com.fimi.soul.module.setting.ShowTextActivity;
import com.fimi.soul.service.InitAppService;
import com.fimi.soul.service.QueryDynamicFlyZoneSetvice;
import com.fimi.soul.utils.AbstractC3648am;
import com.fimi.soul.utils.C3642al;
import com.fimi.soul.utils.C3658ar;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes.dex */
public class LoginFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    private TextView f13061a;

    /* renamed from: b */
    private Context f13062b;

    /* renamed from: c */
    private TextView f13063c;

    /* renamed from: d */
    private TextView f13064d;

    /* renamed from: e */
    private Button f13065e;

    /* renamed from: f */
    private Button f13066f;

    /* renamed from: g */
    private TextView f13067g;

    /* renamed from: h */
    private TextView f13068h;

    /* renamed from: i */
    private TextView f13069i;

    /* renamed from: j */
    private TextView f13070j;

    /* renamed from: k */
    private TextView f13071k;

    /* renamed from: l */
    private RelativeLayout f13072l;

    /* renamed from: m */
    private RelativeLayout f13073m;

    /* renamed from: n */
    private LayoutTransition f13074n;

    /* renamed from: o */
    private AbstractC3353a f13075o;

    /* renamed from: q */
    private XiaomiOAuthResults f13077q;

    /* renamed from: r */
    private C2613z f13078r;

    /* renamed from: s */
    private String f13079s;

    /* renamed from: v */
    private AbstractC3648am f13082v;

    /* renamed from: w */
    private CheckBox f13083w;

    /* renamed from: p */
    private String f13076p = "http://dev.xiaomi.com";

    /* renamed from: t */
    private User f13080t = new User();

    /* renamed from: u */
    private Boolean f13081u = false;

    /* renamed from: com.fimi.soul.module.login.LoginFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3353a {
        /* renamed from: b */
        void mo8595b();

        /* renamed from: c */
        void mo8594c();

        /* renamed from: d */
        void mo8593d();
    }

    /* renamed from: a */
    private void m8599a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13061a, "translationX", this.f13061a.getTranslationX(), 1000.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13064d, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ofFloat2.setStartDelay(100L);
        ofFloat2.setDuration(500L);
        ofFloat2.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f13065e, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ofFloat3.setStartDelay(200L);
        ofFloat3.setDuration(500L);
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f13066f, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ofFloat4.setStartDelay(300L);
        ofFloat4.setDuration(500L);
        ofFloat4.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f13067g, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f13069i, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f13071k, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f13070j, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat5).with(ofFloat8).with(ofFloat6).with(ofFloat7);
        animatorSet.setStartDelay(400L);
        animatorSet.setDuration(500L);
        animatorSet.start();
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.f13063c, "translationX", this.f13064d.getTranslationX(), 1000.0f);
        ofFloat9.setStartDelay(500L);
        ofFloat9.setDuration(500L);
        ofFloat9.start();
        this.f13075o.mo8595b();
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13075o = (AbstractC3353a) activity;
        this.f13062b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.agreementshengming_tv /* 2131492947 */:
                Intent intent = new Intent(getActivity(), ShowTextActivity.class);
                intent.putExtra(ShowTextActivity.f13679c, C2353b.f7949g);
                intent.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_shengming);
                intent.putExtra(ShowTextActivity.f13678b, "file:///android_asset/statement.html");
                startActivity(intent);
                return;
            case C2300R.C2302id.register_bt /* 2131493528 */:
                if (!C3658ar.m7601b(this.f13062b)) {
                    C2284z.m12696a(this.f13062b, (int) C2300R.C2303string.login_result_net, 1000);
                    return;
                }
                this.f13062b.startActivity(new Intent(this.f13062b, RegisterActivity.class));
                return;
            case C2300R.C2302id.login_bt /* 2131493529 */:
                if (!this.f13083w.isChecked()) {
                    C2284z.m12697a(getActivity(), (int) C2300R.C2303string.login_ck_agree);
                    return;
                } else if (!C3658ar.m7601b(this.f13062b)) {
                    C2284z.m12696a(this.f13062b, (int) C2300R.C2303string.login_result_net, 1000);
                    return;
                } else {
                    this.f13073m.setVisibility(0);
                    this.f13082v.mo7672a(this.f13062b, new AbstractC3648am.AbstractC3649a() { // from class: com.fimi.soul.module.login.LoginFragment.1
                        @Override // com.fimi.soul.utils.AbstractC3648am.AbstractC3649a
                        /* renamed from: a */
                        public void mo7671a() {
                            LoginFragment.this.f13073m.setVisibility(4);
                            MiPushClient.registerPush(LoginFragment.this.f13062b, "2882303761517328945", C2353b.f7959q);
                            if (!C2238c.m13125c().mo13108d(C2353b.f7960r)) {
                                if (LoginFragment.this.f13075o != null) {
                                    LoginFragment.this.f13075o.mo8594c();
                                }
                            } else if (LoginFragment.this.f13075o != null) {
                                LoginFragment.this.f13075o.mo8593d();
                            }
                            InitAppService.m7829a(LoginFragment.this.getActivity());
                            C2496e.m11922a().m11920a(C2496e.EnumC2497a.IDEL);
                            QueryDynamicFlyZoneSetvice.m7809a(LoginFragment.this.f13062b);
                        }

                        @Override // com.fimi.soul.utils.AbstractC3648am.AbstractC3649a
                        /* renamed from: a */
                        public void mo7670a(String str) {
                            LoginFragment.this.f13073m.setVisibility(4);
                            C2284z.m12694a(LoginFragment.this.f13062b, str, C2284z.f7607c);
                        }

                        @Override // com.fimi.soul.utils.AbstractC3648am.AbstractC3649a
                        /* renamed from: b */
                        public void mo7669b() {
                            LoginFragment.this.f13073m.setVisibility(4);
                        }
                    });
                    return;
                }
            case C2300R.C2302id.tvProtocol /* 2131493532 */:
                Intent intent2 = new Intent(getActivity(), ShowTextActivity.class);
                intent2.putExtra(ShowTextActivity.f13679c, C2353b.f7950h);
                intent2.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_protocol);
                intent2.putExtra(ShowTextActivity.f13678b, "file:///android_asset/protocol.html");
                startActivity(intent2);
                return;
            case C2300R.C2302id.tvPrivacy /* 2131493534 */:
                Intent intent3 = new Intent(getActivity(), ShowTextActivity.class);
                intent3.putExtra(ShowTextActivity.f13679c, C2353b.f7950h);
                intent3.putExtra(ShowTextActivity.f13677a, C2300R.C2303string.agreement_privacy);
                intent3.putExtra(ShowTextActivity.f13678b, "file:///android_asset/privacy.html");
                startActivity(intent3);
                return;
            case C2300R.C2302id.nologin_tv /* 2131493536 */:
                if (this.f13081u.booleanValue()) {
                    return;
                }
                this.f13081u = true;
                if (this.f13075o == null) {
                    return;
                }
                this.f13075o.mo8593d();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_login, viewGroup, false);
        this.f13063c = (TextView) inflate.findViewById(C2300R.C2302id.nologin_tv);
        this.f13063c.setOnClickListener(this);
        this.f13061a = (TextView) inflate.findViewById(C2300R.C2302id.welcom_tv);
        this.f13065e = (Button) inflate.findViewById(C2300R.C2302id.login_bt);
        this.f13066f = (Button) inflate.findViewById(C2300R.C2302id.register_bt);
        this.f13064d = (TextView) inflate.findViewById(C2300R.C2302id.miaircraft_tv);
        this.f13064d = (TextView) inflate.findViewById(C2300R.C2302id.miaircraft_tv);
        this.f13065e = (Button) inflate.findViewById(C2300R.C2302id.login_bt);
        this.f13083w = (CheckBox) inflate.findViewById(C2300R.C2302id.cbAgree);
        this.f13065e.setOnClickListener(this);
        this.f13071k = (TextView) inflate.findViewById(C2300R.C2302id.agreement_tv);
        this.f13066f = (Button) inflate.findViewById(C2300R.C2302id.register_bt);
        this.f13066f.setOnClickListener(this);
        this.f13067g = (TextView) inflate.findViewById(C2300R.C2302id.tvProtocol);
        this.f13067g.getPaint().setFlags(8);
        this.f13067g.getPaint().setAntiAlias(true);
        this.f13067g.setOnClickListener(this);
        this.f13068h = (TextView) inflate.findViewById(C2300R.C2302id.tvPrivacy);
        this.f13068h.getPaint().setFlags(8);
        this.f13068h.getPaint().setAntiAlias(true);
        this.f13068h.setOnClickListener(this);
        this.f13069i = (TextView) inflate.findViewById(C2300R.C2302id.agreementshengming_tv);
        this.f13069i.getPaint().setFlags(8);
        this.f13069i.getPaint().setAntiAlias(true);
        this.f13069i.setOnClickListener(this);
        this.f13070j = (TextView) inflate.findViewById(C2300R.C2302id.loginmillet_tv);
        this.f13073m = (RelativeLayout) inflate.findViewById(C2300R.C2302id.login_progress_rl);
        this.f13078r = C2613z.m11525a(this.f13062b);
        C3658ar.m7612a(this.f13062b.getAssets(), this.f13063c, this.f13061a, this.f13065e, this.f13066f, this.f13064d, this.f13067g, this.f13071k, this.f13069i, this.f13070j);
        this.f13082v = new C3642al();
        return inflate;
    }
}
