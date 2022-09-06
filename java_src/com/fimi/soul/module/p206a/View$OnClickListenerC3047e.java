package com.fimi.soul.module.p206a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.module.p206a.C3035b;
import com.fimi.soul.module.p206a.View$OnClickListenerC3037c;
import com.fimi.soul.view.wheelview.WheelView;
/* renamed from: com.fimi.soul.module.a.e */
/* loaded from: classes.dex */
public class View$OnClickListenerC3047e implements View.OnClickListener, PopupWindow.OnDismissListener, View$OnClickListenerC3037c.AbstractC3045a {

    /* renamed from: a */
    private C3035b f11361a;

    /* renamed from: b */
    private View$OnClickListenerC3037c f11362b;

    /* renamed from: c */
    private SeekBar f11363c;

    /* renamed from: d */
    private boolean f11364d;

    /* renamed from: e */
    private Context f11365e;

    /* renamed from: f */
    private AbstractC3048a f11366f;

    /* renamed from: g */
    private TextView f11367g;

    /* renamed from: h */
    private LinearLayout f11368h;

    /* renamed from: i */
    private PopupWindow f11369i;

    /* renamed from: j */
    private int f11370j;

    /* renamed from: k */
    private WheelView f11371k;

    /* renamed from: l */
    private TextView f11372l;

    /* renamed from: m */
    private LinearLayout f11373m;

    /* renamed from: com.fimi.soul.module.a.e$a */
    /* loaded from: classes.dex */
    public interface AbstractC3048a {
        /* renamed from: a */
        void mo9471a();

        /* renamed from: a */
        void mo9470a(int i, String str);
    }

    public View$OnClickListenerC3047e(Context context, AbstractC3048a abstractC3048a, boolean z) {
        this.f11364d = false;
        this.f11366f = abstractC3048a;
        this.f11365e = context;
        this.f11364d = z;
        this.f11370j = context.getResources().getDimensionPixelSize(C2300R.dimen.camera_menu_location_y);
    }

    /* renamed from: a */
    public void m9862a() {
        if (this.f11369i == null || !this.f11369i.isShowing() || this.f11371k == null) {
            return;
        }
        this.f11371k.m6681a(this.f11362b.m9886d());
        this.f11362b.m9890c();
    }

    @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3037c.AbstractC3045a
    /* renamed from: a */
    public void mo9861a(int i) {
        this.f11373m.setVisibility(i);
        this.f11368h.setVisibility(i);
    }

    @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3037c.AbstractC3045a
    /* renamed from: a */
    public void mo9860a(int i, String str) {
        if (this.f11366f != null) {
            this.f11366f.mo9470a(i, str);
        }
    }

    @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3037c.AbstractC3045a
    /* renamed from: a */
    public void mo9859a(int i, String str, String str2) {
        if (this.f11371k != null) {
            this.f11371k.m6686a(i + 1, str);
        }
    }

    @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3037c.AbstractC3045a
    /* renamed from: a */
    public void mo9858a(int i, boolean z) {
        if (i != 0 || !this.f11364d) {
            this.f11367g.setText(this.f11365e.getString(C2300R.C2303string.camera_menu));
        } else {
            this.f11367g.setText(this.f11365e.getString(C2300R.C2303string.front__setting_app_enable_tip));
        }
    }

    /* renamed from: a */
    public void m9857a(View view, String[] strArr) {
        this.f11367g = (TextView) view.findViewById(C2300R.C2302id.ae_tv);
        this.f11372l = (TextView) view.findViewById(C2300R.C2302id.tv_default);
        if (this.f11364d) {
            this.f11367g.setText(this.f11365e.getString(C2300R.C2303string.front__setting_app_enable_tip));
        }
        this.f11368h = (LinearLayout) view.findViewById(C2300R.C2302id.tab);
        this.f11373m = (LinearLayout) view.findViewById(C2300R.C2302id.main_wv_ly);
        this.f11362b = new View$OnClickListenerC3037c(view, this.f11364d);
        int[] m9895a = this.f11362b.m9895a(strArr);
        this.f11362b.m9900a(this);
        this.f11362b.m9896a(m9895a);
        this.f11361a = new C3035b(this.f11365e);
        this.f11361a.m9903a(this.f11362b.m9883e());
        this.f11371k = (WheelView) view.findViewById(C2300R.C2302id.main_wv);
        this.f11371k.setOffset(1);
        this.f11371k.setItems(this.f11361a.m9904a(C3035b.EnumC3036a.AE, this.f11364d));
        this.f11371k.setOnWheelViewListener(this.f11362b);
        this.f11372l.setOnClickListener(this);
    }

    @Override // com.fimi.soul.module.p206a.View$OnClickListenerC3037c.AbstractC3045a
    /* renamed from: a */
    public void mo9856a(String[] strArr) {
        this.f11366f.mo9470a(-1, this.f11362b.m9872k());
    }

    /* renamed from: b */
    public void m9855b() {
        if (this.f11369i == null || !this.f11369i.isShowing()) {
            return;
        }
        this.f11369i.dismiss();
    }

    /* renamed from: b */
    public void m9854b(String[] strArr) {
        View inflate = LayoutInflater.from(this.f11365e).inflate(C2300R.layout.camera_menu_popup, (ViewGroup) null);
        m9857a(inflate, strArr);
        this.f11369i = new PopupWindow(inflate, this.f11365e.getResources().getDimensionPixelSize(C2300R.dimen.popupwindow_width), this.f11365e.getResources().getDimensionPixelSize(C2300R.dimen.popupwindow_hight), true);
        this.f11369i.setOnDismissListener(this);
        this.f11369i.setBackgroundDrawable(new ColorDrawable(0));
        inflate.measure(0, 0);
        inflate.getMeasuredWidth();
        inflate.getMeasuredHeight();
        this.f11369i.showAtLocation(inflate, 17, 0, -this.f11370j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.tv_default /* 2131493269 */:
                this.f11362b.m9877g();
                return;
            default:
                return;
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.f11366f != null) {
            this.f11366f.mo9471a();
        }
    }
}
