package com.p118d.p119a.p127b.p130b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1892d;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
import com.p118d.p119a.p136c.C1945b;
import com.p118d.p119a.p136c.C1947c;
import com.p118d.p119a.p136c.C1949d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.d.a.b.b.a */
/* loaded from: classes.dex */
public class C1899a implements AbstractC1902b {

    /* renamed from: a */
    protected static final String f6695a = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";

    /* renamed from: b */
    protected static final String f6696b = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";

    /* renamed from: c */
    protected static final String f6697c = "Rotate image on %1$d° [%2$s]";

    /* renamed from: d */
    protected static final String f6698d = "Flip image horizontally [%s]";

    /* renamed from: e */
    protected static final String f6699e = "No stream for image [%s]";

    /* renamed from: f */
    protected static final String f6700f = "Image can't be decoded [%s]";

    /* renamed from: g */
    protected final boolean f6701g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.d.a.b.b.a$a */
    /* loaded from: classes.dex */
    public static class C1900a {

        /* renamed from: a */
        public final int f6702a;

        /* renamed from: b */
        public final boolean f6703b;

        protected C1900a() {
            this.f6702a = 0;
            this.f6703b = false;
        }

        protected C1900a(int i, boolean z) {
            this.f6702a = i;
            this.f6703b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.d.a.b.b.a$b */
    /* loaded from: classes.dex */
    public static class C1901b {

        /* renamed from: a */
        public final C1893e f6704a;

        /* renamed from: b */
        public final C1900a f6705b;

        protected C1901b(C1893e c1893e, C1900a c1900a) {
            this.f6704a = c1893e;
            this.f6705b = c1900a;
        }
    }

    public C1899a(boolean z) {
        this.f6701g = z;
    }

    /* renamed from: a */
    private boolean m14143a(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && AbstractC1919b.EnumC1920a.m13982a(str) == AbstractC1919b.EnumC1920a.FILE;
    }

    /* renamed from: a */
    protected Bitmap m14147a(Bitmap bitmap, C1903c c1903c, int i, boolean z) {
        Matrix matrix = new Matrix();
        EnumC1892d m14132e = c1903c.m14132e();
        if (m14132e == EnumC1892d.EXACTLY || m14132e == EnumC1892d.EXACTLY_STRETCHED) {
            C1893e c1893e = new C1893e(bitmap.getWidth(), bitmap.getHeight(), i);
            float m13863b = C1945b.m13863b(c1893e, c1903c.m14133d(), c1903c.m14131f(), m14132e == EnumC1892d.EXACTLY_STRETCHED);
            if (Float.compare(m13863b, 1.0f) != 0) {
                matrix.setScale(m13863b, m13863b);
                if (this.f6701g) {
                    C1949d.m13854a(f6696b, c1893e, c1893e.m14152a(m13863b), Float.valueOf(m13863b), c1903c.m14139a());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f6701g) {
                C1949d.m13854a(f6698d, c1903c.m14139a());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.f6701g) {
                C1949d.m13854a(f6697c, Integer.valueOf(i), c1903c.m14139a());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.p118d.p119a.p127b.p130b.AbstractC1902b
    /* renamed from: a */
    public Bitmap mo14140a(C1903c c1903c) {
        InputStream m14142b = m14142b(c1903c);
        if (m14142b == null) {
            C1949d.m13846d(f6699e, c1903c.m14139a());
            return null;
        }
        try {
            C1901b m14145a = m14145a(m14142b, c1903c);
            m14142b = m14141b(m14142b, c1903c);
            Bitmap decodeStream = BitmapFactory.decodeStream(m14142b, null, m14146a(m14145a.f6704a, c1903c));
            if (decodeStream != null) {
                return m14147a(decodeStream, c1903c, m14145a.f6705b.f6702a, m14145a.f6705b.f6703b);
            }
            C1949d.m13846d(f6700f, c1903c.m14139a());
            return decodeStream;
        } finally {
            C1947c.m13861a((Closeable) m14142b);
        }
    }

    /* renamed from: a */
    protected BitmapFactory.Options m14146a(C1893e c1893e, C1903c c1903c) {
        int m13865a;
        EnumC1892d m14132e = c1903c.m14132e();
        if (m14132e == EnumC1892d.NONE) {
            m13865a = 1;
        } else if (m14132e == EnumC1892d.NONE_SAFE) {
            m13865a = C1945b.m13866a(c1893e);
        } else {
            m13865a = C1945b.m13865a(c1893e, c1903c.m14133d(), c1903c.m14131f(), m14132e == EnumC1892d.IN_SAMPLE_POWER_OF_2);
        }
        if (m13865a > 1 && this.f6701g) {
            C1949d.m13854a(f6695a, c1893e, c1893e.m14151a(m13865a), Integer.valueOf(m13865a), c1903c.m14139a());
        }
        BitmapFactory.Options m14127j = c1903c.m14127j();
        m14127j.inSampleSize = m13865a;
        return m14127j;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    protected C1900a m14144a(String str) {
        int i = 0;
        boolean z = true;
        try {
        } catch (IOException e) {
            C1949d.m13847c("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(AbstractC1919b.EnumC1920a.FILE.m13980c(str)).getAttributeInt("Orientation", 1)) {
            case 1:
            default:
                z = false;
                break;
            case 2:
                break;
            case 3:
                z = false;
                i = Opcodes.GETFIELD;
                break;
            case 4:
                i = Opcodes.GETFIELD;
                break;
            case 5:
                i = 270;
                break;
            case 6:
                z = false;
                i = 90;
                break;
            case 7:
                i = 90;
                break;
            case 8:
                z = false;
                i = 270;
                break;
        }
        return new C1900a(i, z);
    }

    /* renamed from: a */
    protected C1901b m14145a(InputStream inputStream, C1903c c1903c) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String m14137b = c1903c.m14137b();
        C1900a c1900a = (!c1903c.m14128i() || !m14143a(m14137b, options.outMimeType)) ? new C1900a() : m14144a(m14137b);
        return new C1901b(new C1893e(options.outWidth, options.outHeight, c1900a.f6702a), c1900a);
    }

    /* renamed from: b */
    protected InputStream m14142b(C1903c c1903c) {
        return c1903c.m14130g().mo13929a(c1903c.m14137b(), c1903c.m14129h());
    }

    /* renamed from: b */
    protected InputStream m14141b(InputStream inputStream, C1903c c1903c) {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException e) {
            C1947c.m13861a((Closeable) inputStream);
            return m14142b(c1903c);
        }
    }
}
