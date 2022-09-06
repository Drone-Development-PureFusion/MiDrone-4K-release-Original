package com.p118d.p119a.p127b.p133e;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p136c.C1949d;
import java.lang.reflect.Field;
/* renamed from: com.d.a.b.e.b */
/* loaded from: classes.dex */
public class C1927b extends AbstractC1929d {
    public C1927b(ImageView imageView) {
        super(imageView);
    }

    public C1927b(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* renamed from: a */
    private static int m13931a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue > 0 && intValue < Integer.MAX_VALUE) {
                return intValue;
            }
        } catch (Exception e) {
            C1949d.m13853a(e);
        }
        return 0;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d, com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public int mo13928a() {
        ImageView imageView;
        int mo13928a = super.mo13928a();
        return (mo13928a > 0 || (imageView = (ImageView) this.f6859c.get()) == null) ? mo13928a : m13931a(imageView, "mMaxWidth");
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d
    /* renamed from: a */
    protected void mo13926a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d
    /* renamed from: a */
    protected void mo13924a(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d, com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: b */
    public int mo13923b() {
        ImageView imageView;
        int mo13923b = super.mo13923b();
        return (mo13923b > 0 || (imageView = (ImageView) this.f6859c.get()) == null) ? mo13923b : m13931a(imageView, "mMaxHeight");
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d, com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: c */
    public EnumC1896h mo13922c() {
        ImageView imageView = (ImageView) this.f6859c.get();
        return imageView != null ? EnumC1896h.m14149a(imageView) : super.mo13922c();
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1929d, com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: g */
    public ImageView mo13921d() {
        return (ImageView) super.mo13921d();
    }
}
