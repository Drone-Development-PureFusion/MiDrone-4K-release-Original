package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* renamed from: com.amap.api.mapcore.util.ao */
/* loaded from: classes.dex */
public abstract class AbstractC0780ao extends AbstractC0771aj {

    /* renamed from: h */
    protected float f2097h;

    /* renamed from: i */
    protected float f2098i;

    /* renamed from: j */
    protected float f2099j;

    /* renamed from: k */
    protected float f2100k;

    /* renamed from: l */
    private final float f2101l;

    /* renamed from: m */
    private float f2102m;

    /* renamed from: n */
    private float f2103n;

    /* renamed from: o */
    private float f2104o;

    /* renamed from: p */
    private float f2105p;

    /* renamed from: q */
    private float f2106q = 0.0f;

    /* renamed from: r */
    private float f2107r = 0.0f;

    /* renamed from: s */
    private float f2108s = 0.0f;

    /* renamed from: t */
    private float f2109t = 0.0f;

    public AbstractC0780ao(Context context) {
        super(context);
        this.f2101l = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* renamed from: a */
    protected static float m19051a(MotionEvent motionEvent, int i) {
        float x = motionEvent.getX() - motionEvent.getRawX();
        if (i < motionEvent.getPointerCount()) {
            return x + motionEvent.getX(i);
        }
        return 0.0f;
    }

    /* renamed from: b */
    protected static float m19050b(MotionEvent motionEvent, int i) {
        float y = motionEvent.getY() - motionEvent.getRawY();
        if (i < motionEvent.getPointerCount()) {
            return y + motionEvent.getY(i);
        }
        return 0.0f;
    }

    /* renamed from: a */
    public PointF m19052a(int i) {
        return i == 0 ? new PointF(this.f2106q, this.f2107r) : new PointF(this.f2108s, this.f2109t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    public void mo19045b(MotionEvent motionEvent) {
        super.mo19045b(motionEvent);
        MotionEvent motionEvent2 = this.f2054c;
        int pointerCount = this.f2054c.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f2104o = -1.0f;
            this.f2105p = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.f2097h = x2 - x;
            this.f2098i = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.f2099j = x4 - x3;
            this.f2100k = y4 - y3;
            this.f2106q = x3 - x;
            this.f2107r = y3 - y;
            this.f2108s = x4 - x2;
            this.f2109t = y4 - y2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public boolean m19049d(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.f2052a.getResources().getDisplayMetrics();
        this.f2102m = displayMetrics.widthPixels - this.f2101l;
        this.f2103n = displayMetrics.heightPixels - this.f2101l;
        float f = this.f2101l;
        float f2 = this.f2102m;
        float f3 = this.f2103n;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float m19051a = m19051a(motionEvent, 1);
        float m19050b = m19050b(motionEvent, 1);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2 = m19051a < f || m19050b < f || m19051a > f2 || m19050b > f3;
        return (z && z2) || z || z2;
    }
}
