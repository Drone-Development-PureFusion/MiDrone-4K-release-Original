package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.p001v4.util.LongSparseArray;
import android.util.Log;
import com.amap.api.mapcore.util.C0924ds;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* renamed from: c */
    private C1144a f3690c;

    /* renamed from: d */
    private Collection<WeightedLatLng> f3691d;

    /* renamed from: e */
    private C0924ds f3692e;

    /* renamed from: f */
    private int f3693f;

    /* renamed from: g */
    private Gradient f3694g;

    /* renamed from: h */
    private int[] f3695h;

    /* renamed from: i */
    private double[] f3696i;

    /* renamed from: j */
    private double f3697j;

    /* renamed from: k */
    private double[] f3698k;

    /* renamed from: a */
    private static final int[] f3688a = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};

    /* renamed from: b */
    private static final float[] f3689b = {0.2f, 1.0f};
    public static final Gradient DEFAULT_GRADIENT = new Gradient(f3688a, f3689b);

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private Collection<WeightedLatLng> f3699a;

        /* renamed from: b */
        private int f3700b = 12;

        /* renamed from: c */
        private Gradient f3701c = HeatmapTileProvider.DEFAULT_GRADIENT;

        /* renamed from: d */
        private double f3702d = 0.6d;

        public HeatmapTileProvider build() {
            if (this.f3699a == null || this.f3699a.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e) {
                    Log.e(MapTilsCacheAndResManager.AUTONAVI_PATH, e.getErrorMessage());
                    e.printStackTrace();
                    return null;
                }
            }
            return new HeatmapTileProvider(this);
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.m17398d(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.f3701c = gradient;
            return this;
        }

        public Builder radius(int i) {
            this.f3700b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.f3702d = Math.max(0.0d, Math.min(d, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.f3699a = collection;
            return this;
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.f3691d = builder.f3699a;
        this.f3693f = builder.f3700b;
        this.f3694g = builder.f3701c;
        if (this.f3694g == null || !this.f3694g.isAvailable()) {
            this.f3694g = DEFAULT_GRADIENT;
        }
        this.f3697j = builder.f3702d;
        this.f3696i = m17407a(this.f3693f, this.f3693f / 3.0d);
        m17405a(this.f3694g);
        m17399c(this.f3691d);
    }

    /* renamed from: a */
    static double m17403a(Collection<WeightedLatLng> collection, C0924ds c0924ds, int i, int i2) {
        LongSparseArray longSparseArray;
        double d = c0924ds.f2835a;
        double d2 = c0924ds.f2837c;
        double d3 = c0924ds.f2836b;
        double d4 = c0924ds.f2838d;
        double d5 = ((int) ((i2 / (i * 2)) + 0.5d)) / (d2 - d > d4 - d3 ? d2 - d : d4 - d3);
        LongSparseArray longSparseArray2 = new LongSparseArray();
        double d6 = 0.0d;
        Iterator<WeightedLatLng> it2 = collection.iterator();
        while (true) {
            double d7 = d6;
            if (it2.hasNext()) {
                WeightedLatLng next = it2.next();
                int i3 = (int) ((next.getPoint().f4726x - d) * d5);
                int i4 = (int) ((next.getPoint().f4727y - d3) * d5);
                LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray2.get(i3);
                if (longSparseArray3 == null) {
                    LongSparseArray longSparseArray4 = new LongSparseArray();
                    longSparseArray2.put(i3, longSparseArray4);
                    longSparseArray = longSparseArray4;
                } else {
                    longSparseArray = longSparseArray3;
                }
                Double d8 = (Double) longSparseArray.get(i4);
                if (d8 == null) {
                    d8 = Double.valueOf(0.0d);
                }
                Double valueOf = Double.valueOf(next.intensity + d8.doubleValue());
                longSparseArray.put(i4, valueOf);
                d6 = valueOf.doubleValue() > d7 ? valueOf.doubleValue() : d7;
            } else {
                return d7;
            }
        }
    }

    /* renamed from: a */
    static Bitmap m17401a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    /* renamed from: a */
    static C0924ds m17404a(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it2 = collection.iterator();
        WeightedLatLng next = it2.next();
        double d = next.getPoint().f4726x;
        double d2 = next.getPoint().f4726x;
        double d3 = next.getPoint().f4727y;
        double d4 = next.getPoint().f4727y;
        while (it2.hasNext()) {
            WeightedLatLng next2 = it2.next();
            double d5 = next2.getPoint().f4726x;
            double d6 = next2.getPoint().f4727y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new C0924ds(d, d2, d3, d4);
    }

    /* renamed from: a */
    private static Tile m17406a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(256, 256, byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    private void m17405a(Gradient gradient) {
        this.f3694g = gradient;
        this.f3695h = gradient.generateColorMap(this.f3697j);
    }

    /* renamed from: a */
    private double[] m17408a(int i) {
        double[] dArr = new double[21];
        for (int i2 = 5; i2 < 11; i2++) {
            dArr[i2] = m17403a(this.f3691d, this.f3692e, i, (int) (1280.0d * Math.pow(2.0d, i2)));
            if (i2 == 5) {
                for (int i3 = 0; i3 < i2; i3++) {
                    dArr[i3] = dArr[i2];
                }
            }
        }
        for (int i4 = 11; i4 < 21; i4++) {
            dArr[i4] = dArr[10];
        }
        return dArr;
    }

    /* renamed from: a */
    static double[] m17407a(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d) * d));
        }
        return dArr;
    }

    /* renamed from: a */
    static double[][] m17402a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, length, length);
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    int i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    for (int i6 = floor > i3 - floor ? floor : i3 - floor; i6 < i5; i6++) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d);
                    }
                }
            }
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i7 = floor; i7 < i2 + 1; i7++) {
            for (int i8 = 0; i8 < length; i8++) {
                double d2 = dArr3[i7][i8];
                if (d2 != 0.0d) {
                    int i9 = (i2 < i8 + floor ? i2 : i8 + floor) + 1;
                    for (int i10 = floor > i8 - floor ? floor : i8 - floor; i10 < i9; i10++) {
                        double[] dArr6 = dArr5[i7 - floor];
                        int i11 = i10 - floor;
                        dArr6[i11] = dArr6[i11] + (dArr2[i10 - (i8 - floor)] * d2);
                    }
                }
            }
        }
        return dArr5;
    }

    /* renamed from: c */
    private void m17399c(Collection<WeightedLatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (WeightedLatLng weightedLatLng : collection) {
            if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                arrayList.add(weightedLatLng);
            }
        }
        this.f3691d = arrayList;
        this.f3692e = m17404a(this.f3691d);
        this.f3690c = new C1144a(this.f3692e);
        for (WeightedLatLng weightedLatLng2 : this.f3691d) {
            this.f3690c.m17373a(weightedLatLng2);
        }
        this.f3698k = m17408a(this.f3693f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static Collection<WeightedLatLng> m17398d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        ArrayList<WeightedLatLng> arrayList;
        double d;
        double pow = 1.0d / Math.pow(2.0d, i3);
        double d2 = (this.f3693f * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((this.f3693f * 2) + 256);
        double d4 = (i * pow) - d2;
        double d5 = ((i + 1) * pow) + d2;
        double d6 = (i2 * pow) - d2;
        double d7 = (pow * (i2 + 1)) + d2;
        ArrayList arrayList2 = new ArrayList();
        if (d4 < 0.0d) {
            arrayList = this.f3690c.m17375a(new C0924ds(1.0d + d4, 1.0d, d6, d7));
            d = -1.0d;
        } else if (d5 > 1.0d) {
            arrayList = this.f3690c.m17375a(new C0924ds(0.0d, d5 - 1.0d, d6, d7));
            d = 1.0d;
        } else {
            arrayList = arrayList2;
            d = 0.0d;
        }
        C0924ds c0924ds = new C0924ds(d4, d5, d6, d7);
        if (!c0924ds.m18475a(new C0924ds(this.f3692e.f2835a - d2, this.f3692e.f2837c + d2, this.f3692e.f2836b - d2, d2 + this.f3692e.f2838d))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> m17375a = this.f3690c.m17375a(c0924ds);
        if (m17375a.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, (this.f3693f * 2) + 256, (this.f3693f * 2) + 256);
        for (WeightedLatLng weightedLatLng : m17375a) {
            DPoint point = weightedLatLng.getPoint();
            int i4 = (int) ((point.f4727y - d6) / d3);
            double[] dArr2 = dArr[(int) ((point.f4726x - d4) / d3)];
            dArr2[i4] = dArr2[i4] + weightedLatLng.intensity;
        }
        for (WeightedLatLng weightedLatLng2 : arrayList) {
            DPoint point2 = weightedLatLng2.getPoint();
            int i5 = (int) ((point2.f4727y - d6) / d3);
            double[] dArr3 = dArr[(int) (((point2.f4726x + d) - d4) / d3)];
            dArr3[i5] = dArr3[i5] + weightedLatLng2.intensity;
        }
        return m17406a(m17401a(m17402a(dArr, this.f3696i), this.f3695h, this.f3698k[i3]));
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }
}
