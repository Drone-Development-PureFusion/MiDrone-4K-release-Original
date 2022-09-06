package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
/* renamed from: com.tencent.connect.avatar.b */
/* loaded from: classes.dex */
public class C4209b extends View {

    /* renamed from: a */
    private Rect f17460a;

    /* renamed from: b */
    private Paint f17461b;

    public C4209b(Context context) {
        super(context);
        m5856b();
    }

    /* renamed from: b */
    private void m5856b() {
        this.f17461b = new Paint();
    }

    /* renamed from: a */
    public Rect m5857a() {
        if (this.f17460a == null) {
            this.f17460a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.f17460a.set(i, i2, i + min, min + i2);
        }
        return this.f17460a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect m5857a = m5857a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f17461b.setStyle(Paint.Style.FILL);
        this.f17461b.setColor(Color.argb(100, 0, 0, 0));
        canvas.drawRect(0.0f, 0.0f, measuredWidth, m5857a.top, this.f17461b);
        canvas.drawRect(0.0f, m5857a.bottom, measuredWidth, measuredHeight, this.f17461b);
        canvas.drawRect(0.0f, m5857a.top, m5857a.left, m5857a.bottom, this.f17461b);
        canvas.drawRect(m5857a.right, m5857a.top, measuredWidth, m5857a.bottom, this.f17461b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f17461b.setStyle(Paint.Style.STROKE);
        this.f17461b.setColor(-1);
        canvas.drawRect(m5857a.left, m5857a.top, m5857a.right - 1, m5857a.bottom, this.f17461b);
    }
}
