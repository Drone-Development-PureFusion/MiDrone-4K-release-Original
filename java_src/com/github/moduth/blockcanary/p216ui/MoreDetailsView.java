package com.github.moduth.blockcanary.p216ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* renamed from: com.github.moduth.blockcanary.ui.MoreDetailsView */
/* loaded from: classes.dex */
public final class MoreDetailsView extends View {

    /* renamed from: a */
    private final Paint f17041a = new Paint(1);

    /* renamed from: b */
    private boolean f17042b = true;

    public MoreDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17041a.setStrokeWidth(C3988b.m6312a(2.0f, getResources()));
        this.f17041a.setColor(-8083771);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i = height / 2;
        int i2 = width / 2;
        canvas.drawLine(0.0f, i, width, i, this.f17041a);
        if (this.f17042b) {
            canvas.drawLine(i2, 0.0f, i2, height, this.f17041a);
        }
    }

    public void setFolding(boolean z) {
        if (z != this.f17042b) {
            this.f17042b = z;
            invalidate();
        }
    }
}
