package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class WriteCamera9Grid extends View {

    /* renamed from: a */
    private Paint f15705a;

    /* renamed from: b */
    private float f15706b;

    /* renamed from: c */
    private float f15707c;

    /* renamed from: d */
    private int f15708d;

    /* renamed from: e */
    private int f15709e;

    public WriteCamera9Grid(Context context) {
        super(context);
    }

    public WriteCamera9Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7157a();
    }

    public WriteCamera9Grid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7157a();
    }

    /* renamed from: a */
    private void m7157a() {
        this.f15705a = new Paint();
        this.f15705a.setColor(getResources().getColor(C2300R.color.white));
        this.f15705a.setAlpha(153);
        this.f15705a.setStrokeWidth(1.0f);
        this.f15705a.setAntiAlias(true);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f15706b = displayMetrics.widthPixels;
        this.f15707c = displayMetrics.heightPixels;
        this.f15708d = (int) (this.f15706b / 3.0f);
        this.f15709e = (int) (this.f15707c / 3.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, this.f15709e, this.f15706b, this.f15709e, this.f15705a);
        canvas.drawLine(0.0f, this.f15709e * 2, this.f15706b, this.f15709e * 2, this.f15705a);
        canvas.drawLine(this.f15708d, 0.0f, this.f15708d, this.f15707c, this.f15705a);
        canvas.drawLine(this.f15708d * 2, 0.0f, this.f15708d * 2, this.f15707c, this.f15705a);
    }
}
