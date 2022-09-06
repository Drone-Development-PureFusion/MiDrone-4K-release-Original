package com.fimi.soul.view.photodraweeview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes.dex */
public class PhotoDraweeView extends SimpleDraweeView implements AbstractC3866c {

    /* renamed from: e */
    private View$OnTouchListenerC3861a f16379e;

    public PhotoDraweeView(Context context) {
        super(context);
        m6770a();
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6770a();
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6770a();
    }

    public PhotoDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m6770a();
    }

    /* renamed from: a */
    protected void m6770a() {
        if (this.f16379e == null || this.f16379e.m6769a() == null) {
            this.f16379e = new View$OnTouchListenerC3861a(this);
        }
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6744a(float f, float f2, float f3, boolean z) {
        this.f16379e.mo6744a(f, f2, f3, z);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6743a(float f, boolean z) {
        this.f16379e.mo6743a(f, z);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6742a(int i, int i2) {
        this.f16379e.mo6742a(i, i2);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMaximumScale() {
        return this.f16379e.getMaximumScale();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMediumScale() {
        return this.f16379e.getMediumScale();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMinimumScale() {
        return this.f16379e.getMinimumScale();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public AbstractC3867d getOnPhotoTapListener() {
        return this.f16379e.getOnPhotoTapListener();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public AbstractC3870g getOnViewTapListener() {
        return this.f16379e.getOnViewTapListener();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getScale() {
        return this.f16379e.getScale();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        m6770a();
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.f16379e.m6755g();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.f16379e.m6763b());
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f16379e.setAllowParentInterceptOnEdge(z);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMaximumScale(float f) {
        this.f16379e.setMaximumScale(f);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMediumScale(float f) {
        this.f16379e.setMediumScale(f);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMinimumScale(float f) {
        this.f16379e.setMinimumScale(f);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f16379e.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f16379e.setOnLongClickListener(onLongClickListener);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnPhotoTapListener(AbstractC3867d abstractC3867d) {
        this.f16379e.setOnPhotoTapListener(abstractC3867d);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnScaleChangeListener(AbstractC3868e abstractC3868e) {
        this.f16379e.setOnScaleChangeListener(abstractC3868e);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnViewTapListener(AbstractC3870g abstractC3870g) {
        this.f16379e.setOnViewTapListener(abstractC3870g);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setScale(float f) {
        this.f16379e.setScale(f);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setZoomTransitionDuration(long j) {
        this.f16379e.setZoomTransitionDuration(j);
    }
}
