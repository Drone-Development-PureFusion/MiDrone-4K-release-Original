package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.AbstractC1333n;
import com.android.volley.AbstractC1345r;
import com.android.volley.C1321d;
import com.android.volley.C1329j;
import com.android.volley.C1331l;
import com.android.volley.C1341p;
import com.android.volley.C1385v;
/* renamed from: com.android.volley.toolbox.l */
/* loaded from: classes.dex */
public class C1375l extends AbstractC1333n<Bitmap> {

    /* renamed from: a */
    private static final int f4694a = 1000;

    /* renamed from: b */
    private static final int f4695b = 2;

    /* renamed from: c */
    private static final float f4696c = 2.0f;

    /* renamed from: i */
    private static final Object f4697i = new Object();

    /* renamed from: d */
    private final C1341p.AbstractC1343b<Bitmap> f4698d;

    /* renamed from: e */
    private final Bitmap.Config f4699e;

    /* renamed from: f */
    private final int f4700f;

    /* renamed from: g */
    private final int f4701g;

    /* renamed from: h */
    private ImageView.ScaleType f4702h;

    @Deprecated
    public C1375l(String str, C1341p.AbstractC1343b<Bitmap> abstractC1343b, int i, int i2, Bitmap.Config config, C1341p.AbstractC1342a abstractC1342a) {
        this(str, abstractC1343b, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, abstractC1342a);
    }

    public C1375l(String str, C1341p.AbstractC1343b<Bitmap> abstractC1343b, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, C1341p.AbstractC1342a abstractC1342a) {
        super(0, str, abstractC1342a);
        a((AbstractC1345r) new C1321d(1000, 2, f4696c));
        this.f4698d = abstractC1343b;
        this.f4699e = config;
        this.f4700f = i;
        this.f4701g = i2;
        this.f4702h = scaleType;
    }

    /* renamed from: a */
    static int m16595a(int i, int i2, int i3, int i4) {
        double min = Math.min(i / i3, i2 / i4);
        float f = 1.0f;
        while (f * f4696c <= min) {
            f *= f4696c;
        }
        return (int) f;
    }

    /* renamed from: a */
    private static int m16594a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else if (i == 0) {
            return (int) ((i2 / i4) * i3);
        } else {
            if (i2 == 0) {
                return i;
            }
            double d = i4 / i3;
            return scaleType == ImageView.ScaleType.CENTER_CROP ? ((double) i) * d < ((double) i2) ? (int) (i2 / d) : i : ((double) i) * d > ((double) i2) ? (int) (i2 / d) : i;
        }
    }

    /* renamed from: b */
    private C1341p<Bitmap> m16592b(C1329j c1329j) {
        Bitmap bitmap;
        byte[] bArr = c1329j.f4566b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f4700f == 0 && this.f4701g == 0) {
            options.inPreferredConfig = this.f4699e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int m16594a = m16594a(this.f4700f, this.f4701g, i, i2, this.f4702h);
            int m16594a2 = m16594a(this.f4701g, this.f4700f, i2, i, this.f4702h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m16595a(i, i2, m16594a, m16594a2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= m16594a && decodeByteArray.getHeight() <= m16594a2)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, m16594a, m16594a2, true);
                decodeByteArray.recycle();
            }
        }
        return bitmap == null ? C1341p.m16688a(new C1331l(c1329j)) : C1341p.m16687a(bitmap, C1362h.m16636a(c1329j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public C1341p<Bitmap> mo13155a(C1329j c1329j) {
        C1341p<Bitmap> m16688a;
        synchronized (f4697i) {
            try {
                m16688a = m16592b(c1329j);
            } catch (OutOfMemoryError e) {
                C1385v.m16563c("Caught OOM for %d byte image, url=%s", Integer.valueOf(c1329j.f4566b.length), g());
                m16688a = C1341p.m16688a(new C1331l(e));
            }
        }
        return m16688a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public void mo13154b(Bitmap bitmap) {
        this.f4698d.mo13137a(bitmap);
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: x */
    public AbstractC1333n.EnumC1336b mo16591x() {
        return AbstractC1333n.EnumC1336b.LOW;
    }
}
