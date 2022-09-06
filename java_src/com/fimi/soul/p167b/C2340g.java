package com.fimi.soul.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.MoreSettingInfo;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.soul.b.g */
/* loaded from: classes.dex */
public class C2340g extends BaseAdapter implements SwitchButton.AbstractC2291a {

    /* renamed from: a */
    private final Context f7857a;

    /* renamed from: b */
    private List<MoreSettingInfo> f7858b;

    /* renamed from: com.fimi.soul.b.g$a */
    /* loaded from: classes.dex */
    public enum EnumC2342a {
        FLIHGT_PARAMETER,
        GIMBAL_ANGLE,
        MAGNETIC_FIELD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.b.g$b */
    /* loaded from: classes.dex */
    public class C2343b {

        /* renamed from: a */
        TextView f7864a;

        /* renamed from: b */
        ImageView f7865b;

        /* renamed from: c */
        TextView f7866c;

        /* renamed from: d */
        TextView f7867d;

        /* renamed from: e */
        TextView f7868e;

        /* renamed from: f */
        ImageView f7869f;

        /* renamed from: g */
        TextView f7870g;

        /* renamed from: h */
        ImageView f7871h;

        /* renamed from: i */
        RelativeLayout f7872i;

        /* renamed from: j */
        SwitchButton f7873j;

        /* renamed from: k */
        TextView f7874k;

        private C2343b() {
        }

        /* renamed from: a */
        public View m12529a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C2340g.this.f7857a).inflate(C2300R.layout.adapt_setting, viewGroup, false);
            this.f7872i = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f7864a = (TextView) inflate.findViewById(C2300R.C2302id.setting_title_tv);
            this.f7865b = (ImageView) inflate.findViewById(C2300R.C2302id.general_setting_iv);
            this.f7866c = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f7869f = (ImageView) inflate.findViewById(C2300R.C2302id.setting_more_iv);
            this.f7867d = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_tv);
            this.f7868e = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_child_tv);
            this.f7870g = (TextView) inflate.findViewById(C2300R.C2302id.setting_delcare);
            this.f7871h = (ImageView) inflate.findViewById(C2300R.C2302id.setting_point);
            this.f7873j = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            this.f7874k = (TextView) inflate.findViewById(C2300R.C2302id.btn_set_model);
            C3658ar.m7612a(C2340g.this.f7857a.getAssets(), this.f7864a, this.f7866c, this.f7870g, this.f7867d, this.f7868e, this.f7874k);
            return inflate;
        }
    }

    public C2340g(Context context, List<MoreSettingInfo> list) {
        this.f7857a = context;
        this.f7858b = list;
    }

    @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
    /* renamed from: a */
    public void mo6579a(View view, boolean z) {
    }

    /* renamed from: a */
    public void m12533a(C2343b c2343b) {
        c2343b.f7874k.setVisibility(4);
        c2343b.f7869f.setVisibility(0);
        c2343b.f7866c.setVisibility(0);
        c2343b.f7864a.setVisibility(4);
        c2343b.f7865b.setBackgroundResource(C2300R.C2301drawable.setting_more_info);
        c2343b.f7866c.setText(C2300R.C2303string.show_flight_parameter);
        c2343b.f7865b.setVisibility(0);
        c2343b.f7873j.setVisibility(0);
        if (C2238c.m13123e().m12771d()) {
            c2343b.f7873j.m12667a(true, false);
        } else {
            c2343b.f7873j.m12667a(false, false);
        }
        c2343b.f7873j.setClickable(false);
        c2343b.f7869f.setVisibility(4);
    }

    /* renamed from: b */
    public void m12531b(C2343b c2343b) {
        c2343b.f7874k.setVisibility(4);
        c2343b.f7869f.setVisibility(0);
        c2343b.f7866c.setVisibility(0);
        c2343b.f7864a.setVisibility(4);
        c2343b.f7865b.setBackgroundResource(C2300R.C2301drawable.icon_setup_calibration3x);
        c2343b.f7866c.setText(C2300R.C2303string.show_calibration_angle);
        c2343b.f7865b.setVisibility(0);
        c2343b.f7873j.setVisibility(0);
        if (C2238c.m13123e().m12767e()) {
            c2343b.f7873j.m12667a(true, false);
        } else {
            c2343b.f7873j.m12667a(false, false);
        }
        c2343b.f7873j.setClickable(false);
        c2343b.f7869f.setVisibility(4);
    }

    /* renamed from: c */
    public void m12530c(C2343b c2343b) {
        c2343b.f7874k.setVisibility(4);
        c2343b.f7869f.setVisibility(0);
        c2343b.f7866c.setVisibility(0);
        c2343b.f7864a.setVisibility(4);
        c2343b.f7865b.setBackgroundResource(C2300R.C2301drawable.flight_parameter);
        c2343b.f7866c.setText(C2300R.C2303string.show_more_patter);
        c2343b.f7865b.setVisibility(0);
        c2343b.f7873j.setVisibility(0);
        if (C2238c.m13123e().m12771d()) {
            c2343b.f7873j.m12667a(true, false);
        } else {
            c2343b.f7873j.m12667a(false, false);
        }
        c2343b.f7873j.setClickable(false);
        c2343b.f7869f.setVisibility(4);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7858b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7858b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2343b c2343b;
        if (view == null) {
            C2343b c2343b2 = new C2343b();
            view = c2343b2.m12529a(viewGroup);
            view.setTag(c2343b2);
            c2343b = c2343b2;
        } else {
            c2343b = (C2343b) view.getTag();
        }
        switch (this.f7858b.get(i).getIndexEnum()) {
            case FLIHGT_PARAMETER:
                m12533a(c2343b);
                break;
            case GIMBAL_ANGLE:
                m12531b(c2343b);
                break;
            case MAGNETIC_FIELD:
                m12530c(c2343b);
                break;
        }
        return view;
    }
}
