package com.p118d.p119a.p127b.p133e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p136c.C1949d;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* renamed from: com.d.a.b.e.d */
/* loaded from: classes.dex */
public abstract class AbstractC1929d implements AbstractC1926a {

    /* renamed from: a */
    public static final String f6857a = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: b */
    public static final String f6858b = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: c */
    protected Reference<View> f6859c;

    /* renamed from: d */
    protected boolean f6860d;

    public AbstractC1929d(View view) {
        this(view, true);
    }

    public AbstractC1929d(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f6859c = new WeakReference(view);
        this.f6860d = z;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public int mo13928a() {
        View view = this.f6859c.get();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int width = (!this.f6860d || layoutParams == null || layoutParams.width == -2) ? 0 : view.getWidth();
            return (width > 0 || layoutParams == null) ? width : layoutParams.width;
        }
        return 0;
    }

    /* renamed from: a */
    protected abstract void mo13926a(Bitmap bitmap, View view);

    /* renamed from: a */
    protected abstract void mo13924a(Drawable drawable, View view);

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public boolean mo13927a(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f6859c.get();
            if (view != null) {
                mo13926a(bitmap, view);
                return true;
            }
        } else {
            C1949d.m13847c(f6858b, new Object[0]);
        }
        return false;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public boolean mo13925a(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f6859c.get();
            if (view != null) {
                mo13924a(drawable, view);
                return true;
            }
        } else {
            C1949d.m13847c(f6857a, new Object[0]);
        }
        return false;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: b */
    public int mo13923b() {
        View view = this.f6859c.get();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int height = (!this.f6860d || layoutParams == null || layoutParams.height == -2) ? 0 : view.getHeight();
            return (height > 0 || layoutParams == null) ? height : layoutParams.height;
        }
        return 0;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: c */
    public EnumC1896h mo13922c() {
        return EnumC1896h.CROP;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: d */
    public View mo13921d() {
        return this.f6859c.get();
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: e */
    public boolean mo13920e() {
        return this.f6859c.get() == null;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: f */
    public int mo13919f() {
        View view = this.f6859c.get();
        return view == null ? super.hashCode() : view.hashCode();
    }
}
