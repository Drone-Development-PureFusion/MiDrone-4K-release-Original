package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.d */
/* loaded from: classes.dex */
public class C0890d extends TextureView$SurfaceTextureListenerC1100k implements AbstractC1116m {

    /* renamed from: a */
    private AbstractC1115l f2527a;

    public C0890d(Context context) {
        this(context, null);
    }

    public C0890d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2527a = null;
        this.f2527a = new C0802b(this, context, attributeSet);
    }

    /* renamed from: a */
    public AbstractC1115l m18670a() {
        return this.f2527a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k, android.view.View
    public void onDetachedFromWindow() {
        this.f2527a.mo17522e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.f2527a.mo17547a(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            this.f2527a.mo17522e();
        } else if (i != 0) {
        } else {
            this.f2527a.mo17526d();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1116m
    public void setZOrderOnTop(boolean z) {
    }
}
