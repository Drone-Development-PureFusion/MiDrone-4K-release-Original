package com.mining.app.zxing.p221a;

import android.graphics.Bitmap;
import android.support.p001v4.view.ViewCompat;
import com.google.zxing.LuminanceSource;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.mining.app.zxing.a.e */
/* loaded from: classes.dex */
public final class C4105e extends LuminanceSource {

    /* renamed from: a */
    private final byte[] f17163a;

    /* renamed from: b */
    private final int f17164b;

    /* renamed from: c */
    private final int f17165c;

    /* renamed from: d */
    private final int f17166d;

    /* renamed from: e */
    private final int f17167e;

    public C4105e(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f17163a = bArr;
        this.f17164b = i;
        this.f17165c = i2;
        this.f17166d = i3;
        this.f17167e = i4;
    }

    /* renamed from: a */
    public int m6166a() {
        return this.f17164b;
    }

    /* renamed from: b */
    public int m6165b() {
        return this.f17165c;
    }

    /* renamed from: c */
    public Bitmap m6164c() {
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[width * height];
        byte[] bArr = this.f17163a;
        int i = (this.f17167e * this.f17164b) + this.f17166d;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i2 * width;
            for (int i4 = 0; i4 < width; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i += this.f17164b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.f17164b && height == this.f17165c) {
            return this.f17163a;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = (this.f17167e * this.f17164b) + this.f17166d;
        if (width == this.f17164b) {
            System.arraycopy(this.f17163a, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f17163a;
        for (int i3 = 0; i3 < height; i3++) {
            System.arraycopy(bArr2, i2, bArr, i3 * width, width);
            i2 += this.f17164b;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f17163a, ((this.f17167e + i) * this.f17164b) + this.f17166d, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }
}
