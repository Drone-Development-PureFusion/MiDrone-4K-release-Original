package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
/* renamed from: com.amap.api.mapcore.util.ap */
/* loaded from: classes.dex */
public class C0781ap extends AbstractC0780ao {

    /* renamed from: n */
    private static final PointF f2110n = new PointF();

    /* renamed from: l */
    private final AbstractC0782a f2111l;

    /* renamed from: m */
    private boolean f2112m;

    /* renamed from: o */
    private PointF f2113o;

    /* renamed from: p */
    private PointF f2114p;

    /* renamed from: q */
    private PointF f2115q = new PointF();

    /* renamed from: r */
    private PointF f2116r = new PointF();

    /* renamed from: com.amap.api.mapcore.util.ap$a */
    /* loaded from: classes.dex */
    public interface AbstractC0782a {
        /* renamed from: a */
        void mo17725a(C0781ap c0781ap);

        /* renamed from: b */
        boolean mo19044b(C0781ap c0781ap);
    }

    /* renamed from: com.amap.api.mapcore.util.ap$b */
    /* loaded from: classes.dex */
    public static class C0783b implements AbstractC0782a {
        @Override // com.amap.api.mapcore.util.C0781ap.AbstractC0782a
        /* renamed from: a */
        public void mo17725a(C0781ap c0781ap) {
        }

        @Override // com.amap.api.mapcore.util.C0781ap.AbstractC0782a
        /* renamed from: b */
        public boolean mo19044b(C0781ap c0781ap) {
            return true;
        }
    }

    public C0781ap(Context context, AbstractC0782a abstractC0782a) {
        super(context);
        this.f2111l = abstractC0782a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: a */
    public void mo19048a() {
        super.a();
        this.f2112m = false;
        this.f2115q.x = 0.0f;
        this.f2116r.x = 0.0f;
        this.f2115q.y = 0.0f;
        this.f2116r.y = 0.0f;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: a */
    protected void mo19047a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 5:
                mo19048a();
                this.f2054c = MotionEvent.obtain(motionEvent);
                this.f2058g = 0L;
                mo19045b(motionEvent);
                this.f2112m = d(motionEvent);
                if (this.f2112m) {
                    return;
                }
                this.f2053b = this.f2111l.mo19044b(this);
                return;
            default:
                return;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0771aj
    /* renamed from: b */
    protected void mo19046b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 3:
                mo19048a();
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
                mo19045b(motionEvent);
                if (!this.f2112m) {
                    this.f2111l.mo17725a(this);
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
        this.f2113o = c(motionEvent);
        this.f2114p = c(motionEvent2);
        this.f2116r = this.f2054c.getPointerCount() != motionEvent.getPointerCount() ? f2110n : new PointF(this.f2113o.x - this.f2114p.x, this.f2113o.y - this.f2114p.y);
        this.f2115q.x += this.f2116r.x;
        this.f2115q.y += this.f2116r.y;
    }
}
