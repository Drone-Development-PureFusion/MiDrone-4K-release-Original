package com.fimi.x1bh.module.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.x1bh.module.setting.b */
/* loaded from: classes.dex */
public class C3928b extends BaseAdapter {

    /* renamed from: a */
    private Context f16756a;

    /* renamed from: b */
    private List<C3927a> f16757b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.x1bh.module.setting.b$a */
    /* loaded from: classes.dex */
    public enum EnumC3930a {
        CONNECT_PLANE,
        FIRMWARE_UPDATE,
        CAMERA_SETTING,
        ARROW_KEY_SET,
        ABOUT,
        XIAOMI_ACCOUNT,
        BOTTOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.setting.b$b */
    /* loaded from: classes.dex */
    public class C3931b {

        /* renamed from: a */
        TextView f16766a;

        /* renamed from: b */
        ImageView f16767b;

        /* renamed from: c */
        TextView f16768c;

        /* renamed from: d */
        TextView f16769d;

        /* renamed from: e */
        TextView f16770e;

        /* renamed from: f */
        ImageView f16771f;

        /* renamed from: g */
        TextView f16772g;

        /* renamed from: h */
        ImageView f16773h;

        /* renamed from: i */
        RelativeLayout f16774i;

        /* renamed from: j */
        SwitchButton f16775j;

        /* renamed from: k */
        TextView f16776k;

        private C3931b() {
        }

        /* renamed from: a */
        public View m6484a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C3928b.this.f16756a).inflate(C2300R.layout.adapt_setting, viewGroup, false);
            this.f16774i = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f16766a = (TextView) inflate.findViewById(C2300R.C2302id.setting_title_tv);
            this.f16767b = (ImageView) inflate.findViewById(C2300R.C2302id.general_setting_iv);
            this.f16768c = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f16771f = (ImageView) inflate.findViewById(C2300R.C2302id.setting_more_iv);
            this.f16769d = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_tv);
            this.f16770e = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_child_tv);
            this.f16772g = (TextView) inflate.findViewById(C2300R.C2302id.setting_delcare);
            this.f16773h = (ImageView) inflate.findViewById(C2300R.C2302id.setting_point);
            this.f16775j = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            this.f16776k = (TextView) inflate.findViewById(C2300R.C2302id.btn_set_model);
            C3658ar.m7612a(C3928b.this.f16756a.getAssets(), this.f16766a, this.f16768c, this.f16772g, this.f16769d, this.f16770e, this.f16776k);
            return inflate;
        }

        /* renamed from: a */
        public void m6483a(boolean z) {
            this.f16774i.setClickable(z);
        }
    }

    public C3928b(Context context) {
        this.f16756a = context;
    }

    /* renamed from: a */
    private void m6487a(C3931b c3931b, ViewGroup.LayoutParams layoutParams) {
        c3931b.f16774i.setBackgroundResource(C2300R.C2301drawable.list_setting_selector);
        c3931b.f16766a.setVisibility(4);
        c3931b.f16771f.setVisibility(4);
        c3931b.f16767b.setVisibility(4);
        c3931b.f16775j.setVisibility(4);
        c3931b.f16773h.setVisibility(8);
        c3931b.f16772g.setVisibility(4);
        c3931b.f16769d.setVisibility(4);
        c3931b.f16770e.setVisibility(4);
        c3931b.f16768c.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_content));
        c3931b.f16769d.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_content));
        c3931b.f16770e.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_content_child));
        c3931b.f16772g.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_declare));
        c3931b.f16767b.setAlpha(1.0f);
        c3931b.f16775j.setAlpha(1.0f);
        c3931b.f16771f.setAlpha(1.0f);
        layoutParams.height = (int) this.f16756a.getResources().getDimension(C2300R.dimen.setting_adapt_height);
        c3931b.f16774i.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public int m6488a(EnumC3930a enumC3930a) {
        for (int i = 0; i < this.f16757b.size(); i++) {
            if (enumC3930a == this.f16757b.get(i).m6491d()) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void m6485a(List<C3927a> list) {
        this.f16757b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f16757b == null) {
            return 0;
        }
        return this.f16757b.size();
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
        C3931b c3931b;
        if (view == null) {
            C3931b c3931b2 = new C3931b();
            view = c3931b2.m6484a(viewGroup);
            view.setTag(c3931b2);
            c3931b = c3931b2;
        } else {
            c3931b = (C3931b) view.getTag();
        }
        if (this.f16757b != null) {
            m6487a(c3931b, view.getLayoutParams());
            if (i == EnumC3930a.CONNECT_PLANE.ordinal()) {
                if (!this.f16757b.get(m6488a(EnumC3930a.CONNECT_PLANE)).m6490e()) {
                    c3931b.f16768c.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_ash));
                    c3931b.f16774i.setBackgroundResource(C2300R.color.list_nomal);
                    c3931b.f16767b.setAlpha(0.3f);
                    c3931b.f16771f.setAlpha(0.3f);
                }
                c3931b.f16771f.setVisibility(0);
                c3931b.f16768c.setVisibility(0);
                c3931b.f16766a.setVisibility(4);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16776k.setVisibility(4);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.connect_aircraft);
                c3931b.f16768c.setText(C2300R.C2303string.connect_plane);
            }
            if (i == EnumC3930a.FIRMWARE_UPDATE.ordinal()) {
                if (!this.f16757b.get(m6488a(EnumC3930a.FIRMWARE_UPDATE)).m6490e()) {
                    c3931b.f16768c.setTextColor(this.f16756a.getResources().getColor(C2300R.color.setting_ash));
                    c3931b.f16774i.setBackgroundResource(C2300R.color.list_nomal);
                    c3931b.f16767b.setAlpha(0.3f);
                    c3931b.f16771f.setAlpha(0.3f);
                }
                if (this.f16757b.get(m6488a(EnumC3930a.FIRMWARE_UPDATE)).m6490e()) {
                    if (this.f16757b.get(m6488a(EnumC3930a.FIRMWARE_UPDATE)).m6489f()) {
                        c3931b.f16772g.setVisibility(0);
                        c3931b.f16772g.setText(this.f16756a.getResources().getString(C2300R.C2303string.new_firmware_upgrade));
                        c3931b.f16773h.setVisibility(0);
                    } else {
                        c3931b.f16773h.setVisibility(4);
                        c3931b.f16772g.setVisibility(4);
                    }
                }
                c3931b.f16768c.setVisibility(0);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.camera_settings);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16768c.setText(C2300R.C2303string.refreshupdate);
                c3931b.f16771f.setVisibility(0);
            }
            if (i == EnumC3930a.CAMERA_SETTING.ordinal()) {
                c3931b.f16768c.setVisibility(0);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.camera_settings);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16768c.setText(C2300R.C2303string.camera_setting);
                c3931b.f16771f.setVisibility(0);
            } else if (i == EnumC3930a.ARROW_KEY_SET.ordinal()) {
                c3931b.f16768c.setVisibility(0);
                c3931b.f16768c.setText(C2300R.C2303string.cloud_setting_arrow_key_set);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.arrow_key_icon);
                c3931b.f16771f.setVisibility(0);
            } else if (i == EnumC3930a.XIAOMI_ACCOUNT.ordinal()) {
                c3931b.f16768c.setVisibility(0);
                c3931b.f16768c.setText(C2300R.C2303string.cloud_setting_xiaomi_account);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.mi_id);
                c3931b.f16771f.setVisibility(0);
                if (this.f16757b.get(m6488a(EnumC3930a.XIAOMI_ACCOUNT)).m6494b().booleanValue()) {
                    c3931b.f16772g.setVisibility(0);
                    c3931b.f16772g.setText(this.f16757b.get(m6488a(EnumC3930a.XIAOMI_ACCOUNT)).m6492c());
                    c3931b.f16771f.setVisibility(4);
                }
            } else if (i == EnumC3930a.BOTTOM.ordinal()) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) this.f16756a.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
                c3931b.f16774i.setLayoutParams(layoutParams);
                c3931b.f16774i.setBackgroundResource(C2300R.color.list_nomal);
                c3931b.f16766a.setVisibility(8);
                c3931b.f16775j.setVisibility(8);
                c3931b.f16768c.setVisibility(8);
                c3931b.m6483a(false);
            } else if (i == EnumC3930a.ABOUT.ordinal()) {
                c3931b.f16776k.setVisibility(4);
                c3931b.f16766a.setVisibility(4);
                c3931b.f16767b.setVisibility(0);
                c3931b.f16767b.setBackgroundResource(C2300R.C2301drawable.about_icon);
                c3931b.f16768c.setText(C2300R.C2303string.about);
                c3931b.f16768c.setVisibility(0);
                c3931b.f16771f.setVisibility(0);
            }
        }
        return view;
    }
}
