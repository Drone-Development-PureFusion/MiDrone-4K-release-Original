package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Gradient {

    /* renamed from: a */
    private int f3667a;

    /* renamed from: b */
    private int[] f3668b;

    /* renamed from: c */
    private float[] f3669c;

    /* renamed from: d */
    private boolean f3670d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.maps.model.Gradient$a */
    /* loaded from: classes.dex */
    public class C1142a {

        /* renamed from: b */
        private final int f3672b;

        /* renamed from: c */
        private final int f3673c;

        /* renamed from: d */
        private final float f3674d;

        private C1142a(int i, int i2, float f) {
            this.f3672b = i;
            this.f3673c = i2;
            this.f3674d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        this.f3670d = true;
        try {
            if (iArr == null || fArr == null) {
                throw new AMapException("colors and startPoints should not be null");
            }
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            }
            if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            }
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (fArr[i2] <= fArr[i2 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
            }
            this.f3667a = i;
            this.f3668b = new int[iArr.length];
            this.f3669c = new float[fArr.length];
            System.arraycopy(iArr, 0, this.f3668b, 0, iArr.length);
            System.arraycopy(fArr, 0, this.f3669c, 0, fArr.length);
            this.f3670d = true;
        } catch (AMapException e) {
            this.f3670d = false;
            Log.e(MapTilsCacheAndResManager.AUTONAVI_PATH, e.getErrorMessage());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static int m17413a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    /* renamed from: a */
    private HashMap<Integer, C1142a> m17414a() {
        HashMap<Integer, C1142a> hashMap = new HashMap<>();
        if (this.f3669c[0] != 0.0f) {
            hashMap.put(0, new C1142a(Color.argb(0, Color.red(this.f3668b[0]), Color.green(this.f3668b[0]), Color.blue(this.f3668b[0])), this.f3668b[0], this.f3669c[0] * this.f3667a));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3668b.length) {
                break;
            }
            hashMap.put(Integer.valueOf((int) (this.f3667a * this.f3669c[i2 - 1])), new C1142a(this.f3668b[i2 - 1], this.f3668b[i2], (this.f3669c[i2] - this.f3669c[i2 - 1]) * this.f3667a));
            i = i2 + 1;
        }
        if (this.f3669c[this.f3669c.length - 1] != 1.0f) {
            int length = this.f3669c.length - 1;
            hashMap.put(Integer.valueOf((int) (this.f3667a * this.f3669c[length])), new C1142a(this.f3668b[length], this.f3668b[length], this.f3667a * (1.0f - this.f3669c[length])));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateColorMap(double d) {
        C1142a c1142a;
        int i;
        HashMap<Integer, C1142a> m17414a = m17414a();
        int[] iArr = new int[this.f3667a];
        int i2 = 0;
        C1142a c1142a2 = m17414a.get(0);
        int i3 = 0;
        while (i2 < this.f3667a) {
            if (m17414a.containsKey(Integer.valueOf(i2))) {
                i = i2;
                c1142a = m17414a.get(Integer.valueOf(i2));
            } else {
                c1142a = c1142a2;
                i = i3;
            }
            iArr[i2] = m17413a(c1142a.f3672b, c1142a.f3673c, (i2 - i) / c1142a.f3674d);
            i2++;
            i3 = i;
            c1142a2 = c1142a;
        }
        if (d != 1.0d) {
            for (int i4 = 0; i4 < this.f3667a; i4++) {
                int i5 = iArr[i4];
                iArr[i4] = Color.argb((int) (Color.alpha(i5) * d), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.f3670d;
    }
}
