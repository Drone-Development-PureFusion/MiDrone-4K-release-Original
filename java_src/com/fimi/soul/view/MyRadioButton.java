package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/* loaded from: classes.dex */
public class MyRadioButton extends RadioButton {

    /* renamed from: a */
    private Context f15414a;

    /* renamed from: b */
    private Drawable f15415b;

    /* renamed from: c */
    private int f15416c;

    public MyRadioButton(Context context) {
        super(context);
        this.f15414a = context;
    }

    public MyRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15414a = context;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f15415b;
        if (drawable != null) {
            int gravity = getGravity() & 17;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i = 0;
            switch (gravity) {
                case 16:
                    i = (getHeight() - intrinsicHeight) / 2;
                    break;
                case 80:
                    i = getHeight() - intrinsicHeight;
                    break;
            }
            int width = (getWidth() - intrinsicWidth) / 2;
            drawable.setBounds(width, i, intrinsicWidth + width, intrinsicHeight + i);
            drawable.draw(canvas);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        if (i == 0 || i != this.f15416c) {
            this.f15416c = i;
            Drawable drawable = null;
            if (this.f15416c != 0) {
                drawable = getResources().getDrawable(this.f15416c);
            }
            setButtonDrawable(drawable);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.f15415b != null) {
                this.f15415b.setCallback(null);
                unscheduleDrawable(this.f15415b);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.f15415b = drawable;
            this.f15415b.setState(null);
            setMinHeight(this.f15415b.getIntrinsicHeight());
        }
        refreshDrawableState();
    }
}
