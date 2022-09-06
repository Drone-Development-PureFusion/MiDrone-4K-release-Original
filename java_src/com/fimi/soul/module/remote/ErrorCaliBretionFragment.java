package com.fimi.soul.module.remote;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class ErrorCaliBretionFragment extends BaseRemoteFragment {

    /* renamed from: f */
    C2277v f13350f;

    /* renamed from: g */
    Runnable f13351g = new Runnable() { // from class: com.fimi.soul.module.remote.ErrorCaliBretionFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ErrorCaliBretionFragment.this.f13336d.m9804m();
            ErrorCaliBretionFragment.this.getActivity().finish();
        }
    };

    /* renamed from: h */
    private TextView f13352h;

    /* renamed from: i */
    private Button f13353i;

    /* renamed from: j */
    private Button f13354j;

    /* renamed from: k */
    private Button f13355k;

    /* renamed from: l */
    private Button f13356l;

    /* renamed from: m */
    private TextView f13357m;

    /* renamed from: n */
    private TextView f13358n;

    /* renamed from: o */
    private ImageView f13359o;

    /* renamed from: p */
    private int f13360p;

    /* renamed from: q */
    private boolean f13361q;

    /* renamed from: a */
    private void m8484a() {
        this.f13354j.setVisibility(0);
        this.f13355k.setVisibility(0);
        this.f13356l.setVisibility(8);
    }

    /* renamed from: b */
    private void m8481b() {
        this.f13354j.setVisibility(8);
        this.f13355k.setVisibility(8);
        this.f13356l.setVisibility(0);
    }

    /* renamed from: a */
    public void m8483a(Button button, int i) {
        button.setTextColor(button.getTextColors().withAlpha(i));
    }

    /* renamed from: a */
    public void m8482a(String str, boolean z) {
        this.f13361q = z;
        PercentRelativeLayout.LayoutParams layoutParams = (PercentRelativeLayout.LayoutParams) this.f13359o.getLayoutParams();
        if (true == z) {
            this.f13357m.setText(C2300R.C2303string.calisucess);
            this.f13358n.setText(C2300R.C2303string.caliremotesucess);
            this.f13358n.setVisibility(4);
            layoutParams.setMargins(0, (int) (this.f13360p * 0.1111d), 0, 0);
            this.f13359o.setLayoutParams(layoutParams);
            this.f13359o.setImageResource(C2300R.C2301drawable.icon_calibration_succeed);
            m8481b();
            return;
        }
        this.f13357m.setText(C2300R.C2303string.califail);
        this.f13358n.setVisibility(0);
        if (str == null || "".equals(str)) {
            this.f13358n.setText(C2300R.C2303string.caliremotefail);
        } else {
            this.f13358n.setText(str);
        }
        layoutParams.setMargins(0, (int) (this.f13360p * 0.12592d), 0, 0);
        this.f13359o.setLayoutParams(layoutParams);
        this.f13359o.setImageResource(C2300R.C2301drawable.icon_calibration_defeat);
        m8484a();
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case C2300R.C2302id.quit /* 2131492875 */:
                this.f13336d.m9803n();
                this.f13336d.m9804m();
                getActivity().finish();
                return;
            case C2300R.C2302id.again /* 2131493220 */:
                if (this.f13337e == null) {
                    return;
                }
                this.f13337e.mo8479a(C2300R.C2302id.errorcalifragment, C2300R.C2302id.remote_roller_fragment);
                return;
            case C2300R.C2302id.sucesscomplete /* 2131493221 */:
                getActivity().finish();
                new Handler().post(this.f13351g);
                return;
            case C2300R.C2302id.black_btn /* 2131493817 */:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f13360p = displayMetrics.heightPixels;
    }

    @Override // com.fimi.soul.module.remote.BaseRemoteFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.caliremotesucess, (ViewGroup) null);
        this.f13359o = (ImageView) inflate.findViewById(C2300R.C2302id.tagIcon);
        this.f13352h = (TextView) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13352h.setText(C2300R.C2303string.caliremotesucess);
        this.f13353i = (Button) inflate.findViewById(C2300R.C2302id.heardView).findViewById(C2300R.C2302id.black_btn);
        this.f13353i.setOnClickListener(this);
        this.f13354j = (Button) inflate.findViewById(C2300R.C2302id.quit);
        this.f13354j.setOnClickListener(this);
        this.f13355k = (Button) inflate.findViewById(C2300R.C2302id.again);
        this.f13355k.setOnClickListener(this);
        this.f13356l = (Button) inflate.findViewById(C2300R.C2302id.sucesscomplete);
        this.f13356l.setOnClickListener(this);
        this.f13357m = (TextView) inflate.findViewById(C2300R.C2302id.destitle);
        this.f13358n = (TextView) inflate.findViewById(C2300R.C2302id.calireason);
        this.f13350f = new C2277v(getActivity());
        C3658ar.m7612a(getActivity().getAssets(), this.f13352h, this.f13353i, this.f13354j, this.f13355k, this.f13356l, this.f13357m, this.f13358n);
        m8483a(this.f13354j, 128);
        m8483a(this.f13355k, AbstractC4863e.f20785F);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            if (this.f13361q) {
                C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calisucess));
            } else {
                C2244b.m13099b(getActivity()).m13103a(getString(C2300R.C2303string.calibration_failure));
            }
        }
    }
}
