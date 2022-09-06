package com.fimi.x1bh.module.arrowkey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.x1bh.module.arrowkey.b */
/* loaded from: classes.dex */
public class C3900b extends BaseAdapter implements SwitchButton.AbstractC2291a {

    /* renamed from: a */
    private Context f16601a;

    /* renamed from: b */
    private List<C3899a> f16602b;

    /* renamed from: c */
    private AbstractC3902a f16603c;

    /* renamed from: com.fimi.x1bh.module.arrowkey.b$a */
    /* loaded from: classes.dex */
    interface AbstractC3902a {
        /* renamed from: a */
        void mo6605a(EnumC3903b enumC3903b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.x1bh.module.arrowkey.b$b */
    /* loaded from: classes.dex */
    public enum EnumC3903b {
        HORZONTAL_OPERATION,
        VERTIAL_OPERATION,
        BOTTOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.arrowkey.b$c */
    /* loaded from: classes.dex */
    public class C3904c {

        /* renamed from: a */
        TextView f16608a;

        /* renamed from: b */
        RelativeLayout f16609b;

        /* renamed from: c */
        SwitchButton f16610c;

        private C3904c() {
        }

        /* renamed from: a */
        public View m6604a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C3900b.this.f16601a).inflate(C2300R.layout.item_arrow_key, viewGroup, false);
            this.f16609b = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f16608a = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f16610c = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            C3658ar.m7612a(C3900b.this.f16601a.getAssets(), this.f16608a);
            return inflate;
        }

        /* renamed from: a */
        public void m6603a(boolean z) {
            this.f16609b.setClickable(z);
        }
    }

    public C3900b(Context context) {
        this.f16601a = context;
    }

    /* renamed from: a */
    private void m6608a(C3904c c3904c, ViewGroup.LayoutParams layoutParams) {
        c3904c.f16609b.setBackgroundResource(C2300R.C2301drawable.list_setting_selector);
        c3904c.f16610c.setVisibility(4);
        c3904c.f16608a.setTextColor(this.f16601a.getResources().getColor(C2300R.color.setting_content));
        c3904c.f16610c.setAlpha(1.0f);
        layoutParams.height = (int) this.f16601a.getResources().getDimension(C2300R.dimen.setting_adapt_height);
        c3904c.f16609b.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public int m6609a(EnumC3903b enumC3903b) {
        for (int i = 0; i < this.f16602b.size(); i++) {
            if (enumC3903b == this.f16602b.get(i).m6612b()) {
                return i;
            }
        }
        return 0;
    }

    @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
    /* renamed from: a */
    public void mo6579a(View view, boolean z) {
        if (((Integer) view.getTag()).intValue() == m6609a(EnumC3903b.HORZONTAL_OPERATION)) {
            SwitchButton switchButton = (SwitchButton) view.findViewWithTag(view.getTag());
            if (this.f16602b.get(m6609a(EnumC3903b.HORZONTAL_OPERATION)).m6611c()) {
                switchButton.m12667a(true, false);
            } else {
                switchButton.m12667a(false, false);
            }
            this.f16603c.mo6605a(EnumC3903b.HORZONTAL_OPERATION);
        } else if (((Integer) view.getTag()).intValue() != m6609a(EnumC3903b.VERTIAL_OPERATION)) {
        } else {
            SwitchButton switchButton2 = (SwitchButton) view.findViewWithTag(view.getTag());
            if (this.f16602b.get(m6609a(EnumC3903b.HORZONTAL_OPERATION)).m6611c()) {
                switchButton2.m12667a(true, false);
            } else {
                switchButton2.m12667a(false, false);
            }
            this.f16603c.mo6605a(EnumC3903b.VERTIAL_OPERATION);
        }
    }

    /* renamed from: a */
    public void m6610a(AbstractC3902a abstractC3902a) {
        this.f16603c = abstractC3902a;
    }

    /* renamed from: a */
    public void m6606a(List<C3899a> list) {
        this.f16602b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f16602b == null) {
            return 0;
        }
        return this.f16602b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3904c c3904c;
        if (view == null) {
            C3904c c3904c2 = new C3904c();
            view = c3904c2.m6604a(viewGroup);
            view.setTag(c3904c2);
            c3904c = c3904c2;
        } else {
            c3904c = (C3904c) view.getTag();
        }
        if (this.f16602b != null) {
            m6608a(c3904c, view.getLayoutParams());
            if (i == EnumC3903b.HORZONTAL_OPERATION.ordinal()) {
                c3904c.f16608a.setVisibility(0);
                c3904c.f16608a.setText(C2300R.C2303string.arrowkey_horzontal_operation);
                c3904c.f16610c.setVisibility(0);
                c3904c.f16610c.setOnSwitchListener(this);
                c3904c.f16610c.setTag(Integer.valueOf(m6609a(EnumC3903b.HORZONTAL_OPERATION)));
                if (this.f16602b.get(EnumC3903b.HORZONTAL_OPERATION.ordinal()).m6611c()) {
                    c3904c.f16610c.m12667a(true, false);
                } else {
                    c3904c.f16610c.m12667a(false, false);
                }
            } else if (i == EnumC3903b.VERTIAL_OPERATION.ordinal()) {
                c3904c.f16608a.setVisibility(0);
                c3904c.f16608a.setText(C2300R.C2303string.arrowkey_vertial_operation);
                c3904c.f16610c.setVisibility(0);
                c3904c.f16610c.setOnSwitchListener(this);
                c3904c.f16610c.setTag(Integer.valueOf(m6609a(EnumC3903b.VERTIAL_OPERATION)));
                if (this.f16602b.get(EnumC3903b.VERTIAL_OPERATION.ordinal()).m6611c()) {
                    c3904c.f16610c.m12667a(true, false);
                } else {
                    c3904c.f16610c.m12667a(false, false);
                }
            } else if (i == EnumC3903b.BOTTOM.ordinal()) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) this.f16601a.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
                c3904c.f16609b.setLayoutParams(layoutParams);
                c3904c.f16609b.setBackgroundResource(C2300R.color.list_nomal);
                c3904c.f16610c.setVisibility(8);
                c3904c.f16608a.setVisibility(8);
                c3904c.m6603a(false);
            }
        }
        return view;
    }
}
