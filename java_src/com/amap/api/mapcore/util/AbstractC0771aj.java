package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.aj */
/* loaded from: classes.dex */
public abstract class AbstractC0771aj {

    /* renamed from: a */
    protected final Context f2052a;

    /* renamed from: b */
    protected boolean f2053b;

    /* renamed from: c */
    protected MotionEvent f2054c;

    /* renamed from: d */
    protected MotionEvent f2055d;

    /* renamed from: e */
    protected float f2056e;

    /* renamed from: f */
    protected float f2057f;

    /* renamed from: g */
    protected long f2058g;

    public AbstractC0771aj(Context context) {
        this.f2052a = context;
    }

    /* renamed from: c */
    public static PointF m19074c(MotionEvent motionEvent) {
        float f = 0.0f;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f2 += motionEvent.getX(i);
            f += motionEvent.getY(i);
        }
        return new PointF(f2 / pointerCount, f / pointerCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19048a() {
        if (this.f2054c != null) {
            this.f2054c.recycle();
            this.f2054c = null;
        }
        if (this.f2055d != null) {
            this.f2055d.recycle();
            this.f2055d = null;
        }
        this.f2053b = false;
    }

    /* renamed from: a */
    protected abstract void mo19047a(int i, MotionEvent motionEvent);

    /* renamed from: a */
    public boolean m19076a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!this.f2053b) {
            mo19047a(action, motionEvent);
            return true;
        }
        mo19046b(action, motionEvent);
        return true;
    }

    /* renamed from: b */
    public long m19075b() {
        return this.f2058g;
    }

    /* renamed from: b */
    protected abstract void mo19046b(int i, MotionEvent motionEvent);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo19045b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f2054c;
        if (this.f2055d != null) {
            this.f2055d.recycle();
            this.f2055d = null;
        }
        this.f2055d = MotionEvent.obtain(motionEvent);
        this.f2058g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        if (Build.VERSION.SDK_INT >= 8) {
            this.f2056e = motionEvent.getPressure(motionEvent.getActionIndex());
            this.f2057f = motionEvent2.getPressure(motionEvent2.getActionIndex());
            return;
        }
        this.f2056e = motionEvent.getPressure(0);
        this.f2057f = motionEvent2.getPressure(0);
    }
}
