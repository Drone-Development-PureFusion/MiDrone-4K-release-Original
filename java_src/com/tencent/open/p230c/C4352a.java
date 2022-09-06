package com.tencent.open.p230c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* renamed from: com.tencent.open.c.a */
/* loaded from: classes2.dex */
public class C4352a extends RelativeLayout {

    /* renamed from: a */
    private static final String f18167a = C4352a.class.getName();

    /* renamed from: b */
    private Rect f18168b;

    /* renamed from: c */
    private boolean f18169c = false;

    /* renamed from: d */
    private AbstractC4353a f18170d = null;

    /* renamed from: com.tencent.open.c.a$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4353a {
        void onKeyboardHidden();

        void onKeyboardShown(int i);
    }

    public C4352a(Context context) {
        super(context);
        this.f18168b = null;
        if (this.f18168b == null) {
            this.f18168b = new Rect();
        }
    }

    /* renamed from: a */
    public void m5387a(AbstractC4353a abstractC4353a) {
        this.f18170d = abstractC4353a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f18168b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f18168b.top) - size;
        if (this.f18170d != null && size != 0) {
            if (height > 100) {
                this.f18170d.onKeyboardShown((Math.abs(this.f18168b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                this.f18170d.onKeyboardHidden();
            }
        }
        super.onMeasure(i, i2);
    }
}
