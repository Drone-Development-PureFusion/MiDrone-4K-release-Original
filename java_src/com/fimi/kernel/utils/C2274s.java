package com.fimi.kernel.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.p001v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.p318d.AbstractC5756f;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* renamed from: com.fimi.kernel.utils.s */
/* loaded from: classes.dex */
public class C2274s {

    /* renamed from: a */
    public static final int f7552a = 0;

    /* renamed from: b */
    public static final int f7553b = 1;

    /* renamed from: c */
    public static final int f7554c = 2;

    /* renamed from: d */
    public static final int f7555d = 2048;

    /* renamed from: e */
    public static final int f7556e = 2048;

    /* renamed from: a */
    private static float m12831a(int i, int i2, int i3, int i4) {
        float f = i3 / i;
        float f2 = i4 / i2;
        return f > f2 ? f : f2;
    }

    /* renamed from: a */
    private static int m12834a(double d) {
        int highestOneBit = Integer.highestOneBit((int) Math.floor(d));
        if (highestOneBit == 0) {
            return 1;
        }
        return highestOneBit;
    }

    /* renamed from: a */
    private static int m12833a(int i) {
        return (int) ((((i >> 8) & 255) * 0.59d) + (0.3d * ((i >> 16) & 255)) + ((i & 255) * 0.11d));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m12823a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                    i = byteArrayOutputStream.toByteArray().length;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return i;
                }
            } catch (Throwable th) {
                th = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return i;
    }

    /* renamed from: a */
    public static int m12814a(String str, String str2) {
        int i = 0;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static Bitmap m12830a(Context context, Bitmap bitmap, int i) {
        int width = bitmap.getWidth() > bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        return m12825a(bitmap, (float) (width > i ? width / i : 1.0d));
    }

    /* renamed from: a */
    public static Bitmap m12829a(Context context, Uri uri, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        InputStream openInputStream = contentResolver.openInputStream(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        BitmapFactory.decodeStream(openInputStream, null, options);
        openInputStream.close();
        if (options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        int i2 = options.outHeight > options.outWidth ? options.outHeight : options.outWidth;
        double d = i2 > i ? i2 / i : 1.0d;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = m12834a(d);
        options2.inDither = true;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        InputStream openInputStream2 = contentResolver.openInputStream(uri);
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
        openInputStream2.close();
        return m12824a(decodeStream, i, i);
    }

    /* renamed from: a */
    public static Bitmap m12827a(Context context, String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        int i2 = options.outHeight > options.outWidth ? options.outHeight : options.outWidth;
        double d = i2 > i ? i2 / i : 1.0d;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = m12834a(d);
        options2.inDither = true;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return m12824a(BitmapFactory.decodeFile(str, options2), i, i);
    }

    /* renamed from: a */
    public static Bitmap m12825a(Bitmap bitmap, float f) {
        Bitmap bitmap2;
        if (!m12795h(bitmap)) {
            return null;
        }
        if (f == 1.0f) {
            return bitmap;
        }
        try {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (bitmap2 != bitmap) {
                    bitmap.recycle();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bitmap != null) {
                    bitmap.recycle();
                    bitmap2 = null;
                } else {
                    bitmap2 = null;
                }
            }
            return bitmap2;
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static Bitmap m12824a(Bitmap bitmap, int i, int i2) {
        if (!m12795h(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] m12802c = m12802c(width, height, i, i2);
        int i3 = m12802c[0];
        int i4 = m12802c[1];
        Bitmap m12825a = m12825a(bitmap, m12810b(width, height, i3, i4));
        return (m12825a.getWidth() > i3 || m12825a.getHeight() > i4) ? m12807b(m12825a, i3, i4) : m12825a;
    }

    /* renamed from: a */
    public static Bitmap m12821a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m12818a(ImageView imageView) {
        Bitmap bitmap;
        Exception e;
        try {
            bitmap = Bitmap.createBitmap(imageView.getDrawingCache());
        } catch (Exception e2) {
            bitmap = null;
            e = e2;
        }
        try {
            imageView.setDrawingCacheEnabled(false);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bitmap;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m12817a(File file) {
        try {
            return BitmapFactory.decodeFile(file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m12816a(File file, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int[] m12802c = m12802c(i3, i4, i, i2);
        float m12831a = m12831a(i3, i4, m12802c[0], m12802c[1]);
        if (m12831a != 0.0f) {
            i3 = (int) (i3 * m12831a);
            i4 = (int) (i4 * m12831a);
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        if (m12831a < 0.25d) {
            options.inSampleSize = 2;
        } else if (m12831a < 0.125d) {
            options.inSampleSize = 4;
        } else {
            options.inSampleSize = 1;
        }
        options.outWidth = i3;
        options.outHeight = i4;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        return m12825a(BitmapFactory.decodeFile(file.getPath(), options), m12831a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m12815a(String str, int i, int i2, int i3) {
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap = 0;
        bitmap = 0;
        bitmap = 0;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                openConnection.setDoInput(true);
                openConnection.connect();
                inputStream = openConnection.getInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, null);
                    bitmap = i == 0 ? m12807b(decodeStream, i2, i3) : i == 1 ? m12824a(decodeStream, i2, i3) : decodeStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    C2266k.m12947a(C2274s.class, "" + e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bitmap;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bitmap.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m12813a(byte[] bArr) {
        try {
            if (bArr.length == 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Drawable m12826a(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable;
        if (bitmap == null) {
            return null;
        }
        try {
            bitmapDrawable = new BitmapDrawable(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            bitmapDrawable = null;
        }
        return bitmapDrawable;
    }

    /* renamed from: a */
    public static Drawable m12820a(View view) {
        try {
            Bitmap m12805b = m12805b(view);
            if (m12805b != null) {
                return new BitmapDrawable(m12805b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public static String m12828a(Context context, String str) {
        long j = 0;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                j = MediaPlayer.create(context, Uri.fromFile(file)).getDuration();
            } catch (Exception e) {
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.applyPattern("mm:ss");
        return simpleDateFormat.format(new Date(j));
    }

    /* renamed from: a */
    public static void m12812a(Bitmap[] bitmapArr) {
        if (bitmapArr != null) {
            try {
                for (Bitmap bitmap : bitmapArr) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        C2266k.m12947a(C2274s.class, "Bitmap释放" + bitmap.toString());
                        bitmap.recycle();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m12811a(String[] strArr) {
    }

    /* renamed from: a */
    private static boolean m12832a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            C2266k.m12934c(C2274s.class, "请求Bitmap的宽高参数必须大于0");
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m12822a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Exception e;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    if (z) {
                        try {
                            bitmap.recycle();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return bArr;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    bArr = null;
                    e = e5;
                }
            } catch (Throwable th) {
                th = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            byteArrayOutputStream = null;
            bArr = null;
            e = e7;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m12819a(View view, Bitmap.CompressFormat compressFormat) {
        try {
            return m12822a(m12805b(view), compressFormat, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static float m12810b(int i, int i2, int i3, int i4) {
        float f = i3 / i;
        float f2 = i4 / i2;
        return f > f2 ? f2 : f;
    }

    /* renamed from: b */
    public static Bitmap m12808b(Bitmap bitmap, float f) {
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(f % 360.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m12807b(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4 = 0;
        Bitmap bitmap2 = null;
        if (m12795h(bitmap)) {
            try {
                if (m12832a(i, i2)) {
                    try {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width > i) {
                            i3 = (width - i) / 2;
                        } else {
                            i = width;
                            i3 = 0;
                        }
                        if (height > i2) {
                            i4 = (height - i2) / 2;
                        } else {
                            i2 = height;
                        }
                        bitmap2 = Bitmap.createBitmap(bitmap, i3, i4, i, i2);
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    }
                }
            } catch (Throwable th) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        }
        return bitmap2;
    }

    /* renamed from: b */
    public static Bitmap m12805b(View view) {
        if (view != null) {
            try {
                view.setDrawingCacheEnabled(true);
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                view.buildDrawingCache();
                return view.getDrawingCache();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Bitmap m12803b(File file, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int[] m12802c = m12802c(i3, i4, i, i2);
        int i5 = m12802c[0];
        int i6 = m12802c[1];
        float m12831a = m12831a(i3, i4, i5, i6);
        if (m12831a != 1.0f) {
            i3 = (int) (i3 * m12831a);
            i4 = (int) (i4 * m12831a);
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        if (m12831a < 0.25d) {
            options.inSampleSize = 2;
        } else if (m12831a < 0.125d) {
            options.inSampleSize = 4;
        } else {
            options.inSampleSize = 1;
        }
        options.outHeight = i4;
        options.outWidth = i3;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath(), options);
        if (decodeFile != null) {
            return m12807b(decodeFile, i5, i6);
        }
        return null;
    }

    /* renamed from: b */
    public static TransitionDrawable m12809b(Bitmap bitmap) {
        TransitionDrawable transitionDrawable;
        if (bitmap == null) {
            return null;
        }
        try {
            transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(AsyncImageView.f21295a), new BitmapDrawable(bitmap)});
        } catch (Exception e) {
            e.printStackTrace();
            transitionDrawable = null;
        }
        return transitionDrawable;
    }

    /* renamed from: b */
    public static TransitionDrawable m12806b(Drawable drawable) {
        TransitionDrawable transitionDrawable;
        if (drawable == null) {
            return null;
        }
        try {
            transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(AsyncImageView.f21295a), drawable});
        } catch (Exception e) {
            e.printStackTrace();
            transitionDrawable = null;
        }
        return transitionDrawable;
    }

    /* renamed from: b */
    public static float[] m12804b(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        return new float[]{options.outWidth, options.outHeight};
    }

    /* renamed from: c */
    public static Bitmap m12801c(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f4 = width;
            f3 = width;
            f5 = width;
            f6 = width;
            f = width / 2;
            height = width;
            f2 = 0.0f;
        } else {
            f = height / 2;
            f2 = (width - height) / 2;
            f3 = width - f2;
            f4 = height;
            f5 = height;
            f6 = height;
            width = height;
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f2, (int) 0.0f, (int) f3, (int) f4);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f5, (int) f6);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    /* renamed from: c */
    public static Bitmap m12800c(Bitmap bitmap, float f) {
        int height;
        int width;
        try {
            Matrix matrix = new Matrix();
            if ((f / 90.0f) % 2.0f != 0.0f) {
                height = bitmap.getWidth();
                width = bitmap.getHeight();
            } else {
                height = bitmap.getHeight();
                width = bitmap.getWidth();
            }
            int i = height / 2;
            int i2 = width / 2;
            matrix.preTranslate(-i, -i2);
            matrix.postRotate(f);
            matrix.postTranslate(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    private static int[] m12802c(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 2048;
        int[] iArr = new int[2];
        int i7 = i3 <= 0 ? i : i3;
        int i8 = i4 <= 0 ? i2 : i4;
        if (i7 > 2048) {
            i8 = (int) (i8 * (2048 / i));
            i7 = 2048;
        }
        if (i8 > 2048) {
            i5 = (int) ((2048 / i2) * i7);
        } else {
            i6 = i8;
            i5 = i7;
        }
        iArr[0] = i5;
        iArr[1] = i6;
        return iArr;
    }

    /* renamed from: d */
    public static Bitmap m12799d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height / 2, width, height / 2, matrix, false);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, (height / 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawRect(0.0f, height, width, height + 1, new Paint());
            canvas.drawBitmap(createBitmap, 0.0f, height + 1, (Paint) null);
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, bitmap.getHeight(), 0.0f, createBitmap2.getHeight() + 1, 1895825407, (int) ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0.0f, height, width, createBitmap2.getHeight() + 1, paint);
            return createBitmap2;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* renamed from: e */
    public static void m12798e(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                C2266k.m12947a(C2274s.class, "Bitmap释放" + bitmap.toString());
                bitmap.recycle();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: f */
    public static String m12797f(Bitmap bitmap) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 8, 8, false);
        int width = createScaledBitmap.getWidth();
        int height = createScaledBitmap.getHeight();
        Log.i(LocaleUtil.THAI, "将图片缩小到8x8的尺寸:" + width + AbstractC5756f.f23062a + height);
        int[] iArr = new int[width * height];
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                iArr[(i * height) + i2] = m12833a(createScaledBitmap.getPixel(i, i2));
            }
        }
        m12798e(createScaledBitmap);
        int m12910b = C2267l.m12910b(iArr);
        int[] iArr2 = new int[width * height];
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            if (iArr[i3] >= m12910b) {
                iArr2[i3] = 1;
            } else {
                iArr2[i3] = 0;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < iArr2.length; i4 += 4) {
            stringBuffer.append(C2267l.m12924a((iArr2[i4] * ((int) Math.pow(2.0d, 3.0d))) + (iArr2[i4 + 1] * ((int) Math.pow(2.0d, 2.0d))) + (iArr2[i4 + 2] * ((int) Math.pow(2.0d, 1.0d))) + iArr2[i4 + 2]));
        }
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public static int[] m12796g(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[64];
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                int pixel = bitmap.getPixel(i, i2);
                int i3 = (pixel >> 24) & 255;
                int i4 = (pixel >> 16) & 255;
                int i5 = (pixel >> 8) & 255;
                int i6 = pixel & 255;
                int i7 = (i6 >= 192 ? 3 : i6 >= 128 ? 2 : i6 >= 64 ? 1 : i6 >= 0 ? 0 : 0) + ((i5 >= 192 ? 3 : i5 >= 128 ? 2 : i5 >= 64 ? 1 : i5 >= 0 ? 0 : 0) * 4) + ((i4 >= 192 ? 3 : i4 >= 128 ? 2 : i4 >= 64 ? 1 : i4 >= 0 ? 0 : 0) * 16);
                iArr[i7] = iArr[i7] + 1;
            }
        }
        return iArr;
    }

    /* renamed from: h */
    private static boolean m12795h(Bitmap bitmap) {
        if (bitmap == null) {
            C2266k.m12934c(C2274s.class, "原图Bitmap为空了");
            return false;
        } else if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            return true;
        } else {
            C2266k.m12934c(C2274s.class, "原图Bitmap大小为0");
            return false;
        }
    }
}
