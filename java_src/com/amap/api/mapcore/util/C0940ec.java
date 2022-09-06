package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.mapcore.util.ec */
/* loaded from: classes.dex */
public class C0940ec {
    /* renamed from: a */
    private static int m18378a(byte[] bArr, int i) {
        return (bArr[i + 0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | (bArr[i + 1] << 8) | (bArr[i + 2] << 16) | (bArr[i + 3] << 24);
    }

    /* renamed from: a */
    private static Bitmap m18380a(InputStream inputStream) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] m18382a = m18382a(decodeStream);
        if (NinePatch.isNinePatchChunk(m18382a)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            decodeStream.recycle();
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, m18382a);
            return createBitmap;
        }
        return decodeStream;
    }

    /* renamed from: a */
    public static Drawable m18383a(Context context, String str) {
        Bitmap m18375b = m18375b(context, str);
        if (m18375b.getNinePatchChunk() == null) {
            return new BitmapDrawable(m18375b);
        }
        Rect rect = new Rect();
        m18376a(m18375b.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), m18375b, m18375b.getNinePatchChunk(), rect, null);
    }

    /* renamed from: a */
    private static void m18381a(Bitmap bitmap, byte[] bArr) {
        int i = 0;
        int[] iArr = new int[bitmap.getWidth() - 2];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            } else if (-16777216 == iArr[i2]) {
                m18377a(bArr, 12, i2);
                break;
            } else {
                i2++;
            }
        }
        int length = iArr.length - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (-16777216 == iArr[length]) {
                m18377a(bArr, 16, (iArr.length - length) - 2);
                break;
            } else {
                length--;
            }
        }
        int[] iArr2 = new int[bitmap.getHeight() - 2];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (true) {
            if (i >= iArr2.length) {
                break;
            } else if (-16777216 == iArr2[i]) {
                m18377a(bArr, 20, i);
                break;
            } else {
                i++;
            }
        }
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            if (-16777216 == iArr2[length2]) {
                m18377a(bArr, 24, (iArr2.length - length2) - 2);
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m18379a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    private static void m18377a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    /* renamed from: a */
    private static void m18376a(byte[] bArr, Rect rect) {
        rect.left = m18378a(bArr, 12);
        rect.right = m18378a(bArr, 16);
        rect.top = m18378a(bArr, 20);
        rect.bottom = m18378a(bArr, 24);
    }

    /* renamed from: a */
    private static byte[] m18382a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int[] iArr = new int[width - 2];
        bitmap.getPixels(iArr, 0, width, 1, 0, width - 2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[iArr.length + (-1)] == -16777216;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 != iArr[i4]) {
                i3++;
                m18379a(byteArrayOutputStream, i4);
                i2 = iArr[i4];
            }
        }
        if (z2) {
            i3++;
            m18379a(byteArrayOutputStream, iArr.length);
        }
        int i5 = i3;
        int i6 = i5 + 1;
        int i7 = z ? i6 - 1 : i6;
        int i8 = z2 ? i7 - 1 : i7;
        int[] iArr2 = new int[height - 2];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, height - 2);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[iArr2.length + (-1)] == -16777216;
        int length2 = iArr2.length;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length2; i11++) {
            if (i9 != iArr2[i11]) {
                i10++;
                m18379a(byteArrayOutputStream, i11);
                i9 = iArr2[i11];
            }
        }
        if (z4) {
            i10++;
            m18379a(byteArrayOutputStream, iArr2.length);
        }
        int i12 = i10 + 1;
        int i13 = z3 ? i12 - 1 : i12;
        if (z4) {
            i13--;
        }
        for (int i14 = 0; i14 < i8 * i13; i14++) {
            m18379a(byteArrayOutputStream, 1);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = 1;
        byteArray[1] = (byte) i5;
        byteArray[2] = (byte) i10;
        byteArray[3] = (byte) (i13 * i8);
        m18381a(bitmap, byteArray);
        return byteArray;
    }

    /* renamed from: b */
    private static Bitmap m18375b(Context context, String str) {
        InputStream open = C0943ef.m18372a(context).open(str);
        Bitmap m18380a = m18380a(open);
        open.close();
        return m18380a;
    }
}
