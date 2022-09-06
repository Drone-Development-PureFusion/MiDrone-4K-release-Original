package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.al */
/* loaded from: classes.dex */
public class C0774al extends AbstractC0771aj {

    /* renamed from: h */
    private static final PointF f2066h = new PointF();

    /* renamed from: i */
    private final AbstractC0775a f2067i;

    /* renamed from: j */
    private PointF f2068j;

    /* renamed from: k */
    private PointF f2069k;

    /* renamed from: l */
    private PointF f2070l = new PointF();

    /* renamed from: m */
    private PointF f2071m = new PointF();

    /* renamed from: com.amap.api.mapcore.util.al$a */
    /* loaded from: classes.dex */
    public interface AbstractC0775a {
        /* renamed from: a */
        boolean mo17731a(C0774al c0774al);

        /* renamed from: b */
        boolean mo17730b(C0774al c0774al);

        /* renamed from: c */
        void mo17729c(C0774al c0774al);
    }

    public C0774al(Context context, AbstractC0775a abstractC0775a) {
        super(context);
        this.f2067i = abstractC0775a;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: a */
    protected void mo19047a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 0:
                a();
                this.f2054c = MotionEvent.obtain(motionEvent);
                this.f2058g = 0L;
                mo19045b(motionEvent);
                return;
            case 1:
            case 3:
            case 4:
            default:
                return;
            case 2:
                this.f2053b = this.f2067i.mo17730b(this);
                return;
            case 5:
                if (this.f2054c != null) {
                    this.f2054c.recycle();
                }
                this.f2054c = MotionEvent.obtain(motionEvent);
                mo19045b(motionEvent);
                return;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    protected void mo19046b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 1:
            case 3:
                this.f2067i.mo17729c(this);
                a();
                return;
            case 2:
                mo19045b(motionEvent);
                if (this.f2056e / this.f2057f <= 0.67f || !this.f2067i.mo17731a(this)) {
                    return;
                }
                this.f2054c.recycle();
                this.f2054c = MotionEvent.obtain(motionEvent);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    public void mo19045b(MotionEvent motionEvent) {
        super.mo19045b(motionEvent);
        MotionEvent motionEvent2 = this.f2054c;
        this.f2068j = c(motionEvent);
        this.f2069k = c(motionEvent2);
        boolean z = this.f2054c.getPointerCount() != motionEvent.getPointerCount();
        this.f2071m = z ? f2066h : new PointF(this.f2068j.x - this.f2069k.x, this.f2068j.y - this.f2069k.y);
        if (z) {
            this.f2054c.recycle();
            this.f2054c = MotionEvent.obtain(motionEvent);
        }
        this.f2070l.x += this.f2071m.x;
        this.f2070l.y += this.f2071m.y;
    }

    /* renamed from: c */
    public PointF m19072c() {
        return this.f2071m;
    }
}
