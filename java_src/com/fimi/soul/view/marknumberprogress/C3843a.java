package com.fimi.soul.view.marknumberprogress;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.view.marknumberprogress.a */
/* loaded from: classes.dex */
public class C3843a implements PopupWindow.OnDismissListener, AbstractC3845b {

    /* renamed from: a */
    private Context f16261a;

    /* renamed from: b */
    private NumberMarkProgressBar f16262b;

    /* renamed from: c */
    private TextView f16263c;

    /* renamed from: d */
    private TextView f16264d;

    /* renamed from: e */
    private AbstractC3845b f16265e;

    /* renamed from: f */
    private String f16266f;

    /* renamed from: g */
    private PopupWindow f16267g;

    /* renamed from: h */
    private boolean f16268h;

    /* renamed from: i */
    private int f16269i;

    /* renamed from: j */
    private boolean f16270j;

    /* renamed from: k */
    private Handler f16271k = new Handler() { // from class: com.fimi.soul.view.marknumberprogress.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C3843a.this.f16267g.dismiss();
        }
    };

    public C3843a(Context context, AbstractC3845b abstractC3845b) {
        this.f16261a = context;
        this.f16265e = abstractC3845b;
        this.f16266f = context.getString(C2300R.C2303string.blightness);
    }

    @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
    /* renamed from: a */
    public void mo6857a(int i) {
    }

    @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
    /* renamed from: a */
    public void mo6856a(int i, int i2) {
        this.f16271k.removeMessages(0);
        this.f16271k.sendEmptyMessageDelayed(0, 3000L);
        this.f16263c.setText(this.f16266f + "" + this.f16262b.getProgress() + "%");
        if (this.f16265e != null && this.f16268h && !this.f16270j) {
            this.f16265e.mo6856a(i, i2);
        }
        this.f16270j = false;
    }

    /* renamed from: a */
    public void m6861a(int i, boolean z) {
        View inflate = LayoutInflater.from(this.f16261a).inflate(C2300R.layout.front_light_popup, (ViewGroup) null);
        this.f16267g = new PopupWindow(inflate, -2, -2, true);
        this.f16267g.setBackgroundDrawable(new ColorDrawable(0));
        inflate.measure(0, 0);
        inflate.getMeasuredWidth();
        inflate.getMeasuredHeight();
        this.f16262b = (NumberMarkProgressBar) inflate.findViewById(C2300R.C2302id.markbar);
        this.f16269i = i;
        this.f16270j = true;
        this.f16262b.setProgress(i);
        this.f16262b.setOnProgressBarListener(this);
        this.f16268h = z;
        this.f16262b.setEnabled(z);
        this.f16263c = (TextView) inflate.findViewById(C2300R.C2302id.info_tv);
        this.f16264d = (TextView) inflate.findViewById(C2300R.C2302id.model_tv);
        this.f16263c.setText(this.f16266f + "" + this.f16262b.getProgress() + "%");
        int[] iArr = new int[2];
        this.f16267g.showAtLocation(inflate, 17, 0, 0);
        this.f16267g.setOnDismissListener(this);
        this.f16271k.sendEmptyMessageDelayed(0, 3000L);
    }

    /* renamed from: a */
    public void m6860a(int i, boolean z, String str) {
        m6861a(i, z);
        if (z) {
            this.f16264d.setVisibility(8);
            return;
        }
        this.f16264d.setVisibility(0);
        this.f16264d.setText(str);
    }

    /* renamed from: a */
    public boolean m6862a() {
        return this.f16267g != null && this.f16267g.isShowing();
    }

    /* renamed from: b */
    public void m6858b(int i) {
        if (this.f16267g == null || this.f16262b == null || this.f16269i == i) {
            return;
        }
        this.f16270j = true;
        this.f16262b.setProgressAndInvalidate(i);
    }

    @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
    /* renamed from: b */
    public void mo6855b(int i, int i2) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f16271k.removeMessages(0);
    }
}
