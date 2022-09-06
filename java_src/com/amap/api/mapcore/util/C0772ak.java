package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.ak */
/* loaded from: classes.dex */
public class C0772ak extends AbstractC0780ao {

    /* renamed from: l */
    private static final PointF f2059l = new PointF();

    /* renamed from: m */
    private final AbstractC0773a f2060m;

    /* renamed from: n */
    private boolean f2061n;

    /* renamed from: o */
    private PointF f2062o;

    /* renamed from: p */
    private PointF f2063p;

    /* renamed from: q */
    private PointF f2064q = new PointF();

    /* renamed from: r */
    private PointF f2065r = new PointF();

    /* renamed from: com.amap.api.mapcore.util.ak$a */
    /* loaded from: classes.dex */
    public interface AbstractC0773a {
        /* renamed from: a */
        boolean mo17734a(C0772ak c0772ak);

        /* renamed from: b */
        boolean mo17733b(C0772ak c0772ak);

        /* renamed from: c */
        void mo17732c(C0772ak c0772ak);
    }

    public C0772ak(Context context, AbstractC0773a abstractC0773a) {
        super(context);
        this.f2060m = abstractC0773a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: a */
    public void mo19048a() {
        super.a();
        this.f2061n = false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: a */
    protected void mo19047a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                if (!this.f2061n) {
                    return;
                }
                this.f2061n = d(motionEvent);
                if (this.f2061n) {
                    return;
                }
                this.f2053b = this.f2060m.mo17733b(this);
                return;
            case 3:
            case 4:
            default:
                return;
            case 5:
                mo19048a();
                this.f2054c = MotionEvent.obtain(motionEvent);
                this.f2058g = 0L;
                mo19045b(motionEvent);
                this.f2061n = d(motionEvent);
                if (this.f2061n) {
                    return;
                }
                this.f2053b = this.f2060m.mo17733b(this);
                return;
            case 6:
                if (!this.f2061n) {
                }
                return;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    protected void mo19046b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                mo19045b(motionEvent);
                if (this.f2056e / this.f2057f <= 0.67f || !this.f2060m.mo17734a(this)) {
                    return;
                }
                this.f2054c.recycle();
                this.f2054c = MotionEvent.obtain(motionEvent);
                return;
            case 3:
                if (!this.f2061n) {
                    this.f2060m.mo17732c(this);
                }
                mo19048a();
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
                mo19045b(motionEvent);
                if (!this.f2061n) {
                    this.f2060m.mo17732c(this);
                }
                mo19048a();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0780ao, com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    public void mo19045b(MotionEvent motionEvent) {
        super.mo19045b(motionEvent);
        MotionEvent motionEvent2 = this.f2054c;
        this.f2062o = c(motionEvent);
        this.f2063p = c(motionEvent2);
        this.f2065r = this.f2054c.getPointerCount() != motionEvent.getPointerCount() ? f2059l : new PointF(this.f2062o.x - this.f2063p.x, this.f2062o.y - this.f2063p.y);
        this.f2064q.x += this.f2065r.x;
        this.f2064q.y += this.f2065r.y;
    }

    /* renamed from: c */
    public PointF m19073c() {
        return this.f2065r;
    }
}
