package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
/* renamed from: com.amap.api.mapcore.util.dy */
/* loaded from: classes.dex */
public class C0933dy extends AbstractC0934dz {

    /* renamed from: a */
    protected int f2868a;

    /* renamed from: b */
    protected int f2869b;

    public C0933dy(Context context, int i, int i2) {
        super(context);
        m18426a(i, i2);
    }

    /* renamed from: a */
    public static int m18424a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i5 = Math.round(i3 / i2);
            int round = Math.round(i4 / i);
            if (i5 >= round) {
                i5 = round;
            }
            while ((i4 * i3) / (i5 * i5) > i * i2 * 2) {
                i5++;
            }
        }
        return i5;
    }

    /* renamed from: a */
    private Bitmap m18427a(int i) {
        return m18425a(this.f2873d, i, this.f2868a, this.f2869b, a());
    }

    /* renamed from: a */
    public static Bitmap m18425a(Resources resources, int i, int i2, int i3, C0929dw c0929dw) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = m18424a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* renamed from: a */
    public static Bitmap m18423a(FileDescriptor fileDescriptor, int i, int i2, C0929dw c0929dw) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = m18424a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0934dz
    /* renamed from: a */
    protected Bitmap mo18418a(Object obj) {
        return m18427a(Integer.parseInt(String.valueOf(obj)));
    }

    /* renamed from: a */
    public void m18426a(int i, int i2) {
        this.f2868a = i;
        this.f2869b = i2;
    }
}
