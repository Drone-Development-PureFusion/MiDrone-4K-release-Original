package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.c */
/* loaded from: classes.dex */
public class C0863c extends GLSurfaceView implements AbstractC1116m {

    /* renamed from: a */
    private AbstractC1115l f2405a;

    public C0863c(Context context) {
        this(context, null);
    }

    public C0863c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2405a = null;
        this.f2405a = new C0802b(this, context, attributeSet);
    }

    /* renamed from: a */
    public AbstractC1115l m18726a() {
        return this.f2405a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        this.f2405a.mo17522e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.f2405a.mo17547a(motionEvent);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (i == 8 || i == 4) {
            this.f2405a.mo17522e();
        } else if (i == 0) {
            this.f2405a.mo17526d();
        }
        super.onWindowVisibilityChanged(i);
    }
}
