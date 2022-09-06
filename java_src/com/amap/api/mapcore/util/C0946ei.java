package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
/* renamed from: com.amap.api.mapcore.util.ei */
/* loaded from: classes.dex */
public class C0946ei extends View {

    /* renamed from: a */
    public static final int f2904a = Color.argb(255, 235, 235, 235);

    /* renamed from: b */
    public static final int f2905b = Color.argb(255, 21, 21, 21);

    /* renamed from: c */
    private Paint f2906c = new Paint();

    public C0946ei(Context context) {
        super(context);
        this.f2906c.setAntiAlias(true);
        this.f2906c.setColor(f2904a);
    }

    /* renamed from: a */
    public void m18309a(int i) {
        if (this.f2906c != null) {
            this.f2906c.setColor(i);
        }
    }

    /* renamed from: a */
    public void m18308a(boolean z) {
        if (z) {
            setVisibility(0);
            return;
        }
        setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(200L);
        clearAnimation();
        startAnimation(alphaAnimation);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f2906c);
    }
}
