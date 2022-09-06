package com.fimi.soul.view.titlebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.fimi.kernel.utils.C2271p;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class FmBottomBar extends LinearLayout {

    /* renamed from: b */
    public LayoutInflater f16468b;

    /* renamed from: d */
    private Activity f16470d;

    /* renamed from: e */
    private PopupWindow f16471e;

    /* renamed from: a */
    public int f16467a = 2;

    /* renamed from: f */
    private WindowManager f16472f = null;

    /* renamed from: c */
    public int f16469c = 320;

    public FmBottomBar(Context context) {
        super(context);
        m6708a(context);
    }

    public FmBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6708a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6706a(View view, View view2, boolean z) {
        C2271p.m12866a(view2);
        int measuredWidth = view.getMeasuredWidth();
        if (view2.getMeasuredWidth() > view.getMeasuredWidth()) {
            measuredWidth = view2.getMeasuredWidth();
        }
        int measuredHeight = getMeasuredHeight();
        if (z) {
            this.f16471e = new PopupWindow(view2, measuredWidth, -2, true);
        } else {
            this.f16471e = new PopupWindow(view2, -1, -2, true);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int left = iArr[0] - view.getLeft();
        int i = left + measuredWidth >= this.f16469c ? (this.f16469c - measuredWidth) - 2 : left;
        this.f16471e.setFocusable(true);
        this.f16471e.setOutsideTouchable(true);
        this.f16471e.setBackgroundDrawable(new ColorDrawable(AsyncImageView.f21295a));
        this.f16471e.showAtLocation(view, 83, i, measuredHeight + 2);
    }

    /* renamed from: a */
    public void m6708a(Context context) {
        this.f16470d = (Activity) context;
        setOrientation(0);
        setId(this.f16467a);
        setPadding(0, 0, 0, 0);
        this.f16468b = LayoutInflater.from(context);
        this.f16472f = this.f16470d.getWindowManager();
        this.f16469c = this.f16472f.getDefaultDisplay().getWidth();
    }

    /* renamed from: a */
    public void m6707a(final View view, final View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.titlebar.FmBottomBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                FmBottomBar.this.m6706a(view, view2, true);
            }
        });
    }

    public void setBottomBarBackground(int i) {
        setBackgroundResource(i);
    }

    public void setBottomBarBackgroundColor(int i) {
        setBackgroundColor(i);
    }

    public void setBottomBarBackgroundDrawable(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBottomView(int i) {
        setBottomView(this.f16468b.inflate(i, (ViewGroup) null));
    }

    public void setBottomView(View view) {
        removeAllViews();
        addView(view, new LinearLayout.LayoutParams(-1, -2));
    }
}
