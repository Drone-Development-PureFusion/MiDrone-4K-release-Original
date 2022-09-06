package com.fimi.soul.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.fimi.soul.C2300R;
import java.io.InputStream;
/* renamed from: com.fimi.soul.utils.y */
/* loaded from: classes.dex */
public class C3710y {
    /* renamed from: a */
    public static Bitmap m7391a(Context context, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        InputStream openRawResource = context.getResources().openRawResource(i);
        Rect rect = new Rect();
        rect.left = 20;
        rect.top = 30;
        rect.right = 10;
        return BitmapFactory.decodeStream(openRawResource, rect, options);
    }

    /* renamed from: a */
    public static Bitmap m7390a(Bitmap bitmap, float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: a */
    public static Bitmap m7389a(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a */
    public static boolean m7388a(String str, Context context) {
        return C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingImage)) || C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingAudio)) || C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingVideo));
    }

    /* renamed from: b */
    public static boolean m7387b(String str, Context context) {
        return C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingImage));
    }

    /* renamed from: c */
    public static boolean m7386c(String str, Context context) {
        return C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingVideo));
    }

    /* renamed from: d */
    public static boolean m7385d(String str, Context context) {
        return C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingAudio));
    }
}
