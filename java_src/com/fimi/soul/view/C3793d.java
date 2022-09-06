package com.fimi.soul.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import java.util.List;
/* renamed from: com.fimi.soul.view.d */
/* loaded from: classes.dex */
public class C3793d extends PopupWindow {

    /* renamed from: c */
    private LinearLayout f15883c;

    /* renamed from: d */
    private LinearLayout.LayoutParams f15884d;

    /* renamed from: e */
    private Context f15885e;

    /* renamed from: a */
    final Handler f15881a = new Handler();

    /* renamed from: f */
    private int f15886f = 2;

    /* renamed from: b */
    Runnable f15882b = new Runnable() { // from class: com.fimi.soul.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            C3793d.m7053a(C3793d.this);
            if (C3793d.this.f15886f >= 0) {
                C3793d.this.f15881a.postDelayed(C3793d.this.f15882b, 1000L);
            } else if (!C3793d.this.isShowing()) {
            } else {
                C3793d.this.dismiss();
            }
        }
    };

    public C3793d(Context context, int i, int i2) {
        super(context);
        this.f15884d = null;
        this.f15885e = context;
        this.f15884d = new LinearLayout.LayoutParams(-2, -2);
        this.f15884d.gravity = 17;
        this.f15884d.topMargin = 10;
        this.f15883c = new LinearLayout(context);
        this.f15883c.setOrientation(1);
        this.f15883c.setGravity(1);
        setContentView(this.f15883c);
        setWidth(-2);
        setHeight(i2);
        setBackgroundDrawable(context.getResources().getDrawable(C2300R.C2301drawable.bubble));
        getContentView().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.fimi.soul.view.d.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    C3793d.this.dismiss();
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ int m7053a(C3793d c3793d) {
        int i = c3793d.f15886f;
        c3793d.f15886f = i - 1;
        return i;
    }

    /* renamed from: a */
    public void m7052a(List<Integer> list, View view, int i, int i2) {
        if (isShowing()) {
            dismiss();
            return;
        }
        this.f15883c.removeAllViews();
        View view2 = new View(this.f15885e);
        view2.setLayoutParams(new ViewGroup.LayoutParams(1, 30));
        this.f15883c.addView(view2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                setHeight((list.size() * ((int) this.f15885e.getResources().getDimension(C2300R.dimen.popuwindows_h))) + 50);
                setFocusable(true);
                showAsDropDown(view, i, i2);
                this.f15886f = 1;
                this.f15881a.postDelayed(this.f15882b, 1000L);
                return;
            }
            TextView textView = new TextView(this.f15885e);
            textView.setTextColor(-1);
            textView.setSingleLine(true);
            textView.setText(this.f15885e.getResources().getString(list.get(i4).intValue()));
            this.f15884d.topMargin = 5;
            this.f15883c.addView(textView, this.f15884d);
            i3 = i4 + 1;
        }
    }
}
