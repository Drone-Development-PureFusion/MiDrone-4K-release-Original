package com.fimi.soul.view.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* renamed from: com.fimi.soul.view.cropimage.a */
/* loaded from: classes.dex */
public class C3792a {

    /* renamed from: a */
    public static final String f15878a = "RotateBitmap";

    /* renamed from: b */
    private Bitmap f15879b;

    /* renamed from: c */
    private int f15880c;

    public C3792a(Bitmap bitmap) {
        this.f15879b = bitmap;
        this.f15880c = 0;
    }

    public C3792a(Bitmap bitmap, int i) {
        this.f15879b = bitmap;
        this.f15880c = i % 360;
    }

    /* renamed from: a */
    public int m7062a() {
        return this.f15880c;
    }

    /* renamed from: a */
    public void m7061a(int i) {
        this.f15880c = i;
    }

    /* renamed from: a */
    public void m7060a(Bitmap bitmap) {
        this.f15879b = bitmap;
    }

    /* renamed from: b */
    public Bitmap m7059b() {
        return this.f15879b;
    }

    /* renamed from: c */
    public Matrix m7058c() {
        Matrix matrix = new Matrix();
        if (this.f15880c != 0) {
            matrix.preTranslate(-(this.f15879b.getWidth() / 2), -(this.f15879b.getHeight() / 2));
            matrix.postRotate(this.f15880c);
            matrix.postTranslate(m7055f() / 2, m7056e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m7057d() {
        return (this.f15880c / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m7056e() {
        return m7057d() ? this.f15879b.getWidth() : this.f15879b.getHeight();
    }

    /* renamed from: f */
    public int m7055f() {
        return m7057d() ? this.f15879b.getHeight() : this.f15879b.getWidth();
    }

    /* renamed from: g */
    public void m7054g() {
        if (this.f15879b != null) {
            this.f15879b.recycle();
            this.f15879b = null;
        }
    }
}
