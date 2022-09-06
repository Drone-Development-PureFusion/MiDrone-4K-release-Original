package com.fimi.soul.view.photodraweeview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
/* renamed from: com.fimi.soul.view.photodraweeview.b */
/* loaded from: classes.dex */
public class GestureDetector$OnDoubleTapListenerC3865b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a */
    private View$OnTouchListenerC3861a f16416a;

    public GestureDetector$OnDoubleTapListenerC3865b(View$OnTouchListenerC3861a view$OnTouchListenerC3861a) {
        m6745a(view$OnTouchListenerC3861a);
    }

    /* renamed from: a */
    public void m6745a(View$OnTouchListenerC3861a view$OnTouchListenerC3861a) {
        this.f16416a = view$OnTouchListenerC3861a;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f16416a == null) {
            return false;
        }
        try {
            float scale = this.f16416a.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.f16416a.getMediumScale()) {
                this.f16416a.mo6744a(this.f16416a.getMediumScale(), x, y, true);
            } else if (scale < this.f16416a.getMediumScale() || scale >= this.f16416a.getMaximumScale()) {
                this.f16416a.mo6744a(this.f16416a.getMinimumScale(), x, y, true);
            } else {
                this.f16416a.mo6744a(this.f16416a.getMaximumScale(), x, y, true);
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        DraweeView<GenericDraweeHierarchy> m6769a;
        RectF m6760c;
        if (this.f16416a == null || (m6769a = this.f16416a.m6769a()) == null) {
            return false;
        }
        if (this.f16416a.getOnPhotoTapListener() != null && (m6760c = this.f16416a.m6760c()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (m6760c.contains(x, y)) {
                this.f16416a.getOnPhotoTapListener().mo6741a(m6769a, (x - m6760c.left) / m6760c.width(), (y - m6760c.top) / m6760c.height());
                return true;
            }
        }
        if (this.f16416a.getOnViewTapListener() == null) {
            return false;
        }
        this.f16416a.getOnViewTapListener().m6735a(m6769a, motionEvent.getX(), motionEvent.getY());
        return true;
    }
}
