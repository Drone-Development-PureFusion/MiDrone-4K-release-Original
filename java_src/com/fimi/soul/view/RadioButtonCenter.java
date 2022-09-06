package com.fimi.soul.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.fimi.soul.C2300R;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class RadioButtonCenter extends RadioButton {

    /* renamed from: a */
    private Drawable f15420a;

    public RadioButtonCenter(Context context) {
        super(context);
    }

    public RadioButtonCenter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadioButtonCenter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.RadioButtonCenter, i, 0);
        try {
            this.f15420a = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            setButtonDrawable(AsyncImageView.f21295a);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15420a != null) {
            this.f15420a.setState(getDrawableState());
            int gravity = getGravity() & 112;
            int intrinsicHeight = this.f15420a.getIntrinsicHeight();
            int i = 0;
            switch (gravity) {
                case 16:
                    i = (getHeight() - intrinsicHeight) / 2;
                    break;
                case 80:
                    i = getHeight() - intrinsicHeight;
                    break;
            }
            int intrinsicWidth = this.f15420a.getIntrinsicWidth();
            int width = (getWidth() - intrinsicWidth) / 2;
            this.f15420a.setBounds(width, i, intrinsicWidth + width, intrinsicHeight + i);
            this.f15420a.draw(canvas);
        }
    }
}
