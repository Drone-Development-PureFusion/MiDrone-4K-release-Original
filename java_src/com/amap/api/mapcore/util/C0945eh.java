package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.mapcore.util.C0996fh;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.amap.api.mapcore.util.eh */
/* loaded from: classes.dex */
public class C0945eh {

    /* renamed from: a */
    static final int[] f2900a = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    /* renamed from: b */
    static final double[] f2901b = {7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};

    /* renamed from: c */
    private static List<Float> f2902c = new ArrayList(4);

    /* renamed from: d */
    private static List<Float> f2903d = new ArrayList(4);

    /* renamed from: a */
    public static double m18364a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    /* renamed from: a */
    private static float m18362a(float f) {
        if (f == 50.0f) {
            return 0.082f;
        }
        if (f == 54.0f) {
            return 0.15f;
        }
        if (f == 57.0f) {
            return 0.2f;
        }
        return f == 60.0f ? 0.25f : 0.0f;
    }

    /* renamed from: a */
    public static float m18361a(float f, float f2) {
        if (f > 40.0f) {
            if (f2 <= 15.0f) {
                return 40.0f;
            }
            if (f2 <= 16.0f) {
                return 50.0f;
            }
            if (f2 <= 17.0f) {
                return 54.0f;
            }
            return f2 <= 18.0f ? 57.0f : 60.0f;
        }
        return f;
    }

    /* renamed from: a */
    public static float m18340a(MapConfig mapConfig, float f) {
        return f > mapConfig.maxZoomLevel ? mapConfig.maxZoomLevel : f < mapConfig.minZoomLevel ? mapConfig.minZoomLevel : f;
    }

    /* renamed from: a */
    public static float m18337a(MapProjection mapProjection, MapConfig mapConfig, IPoint iPoint, IPoint iPoint2, int i, int i2) {
        mapProjection.setMapAngle(0.0f);
        mapProjection.setCameraHeaderAngle(0.0f);
        mapProjection.recalculate();
        IPoint iPoint3 = new IPoint();
        IPoint iPoint4 = new IPoint();
        m18339a(mapProjection, iPoint, iPoint3);
        m18339a(mapProjection, iPoint2, iPoint4);
        double d = iPoint3.f4730x - iPoint4.f4730x;
        double d2 = iPoint4.f4731y - iPoint3.f4731y;
        if (d <= 0.0d) {
            d = 1.0d;
        }
        if (d2 <= 0.0d) {
            d2 = 1.0d;
        }
        double log = Math.log(i / d) / Math.log(2.0d);
        double max = Math.max(log, Math.log(i2 / d2) / Math.log(2.0d));
        boolean z = Math.abs(max - log) < 1.0E-7d;
        float m18340a = m18340a(mapConfig, (float) (mapProjection.getMapZoomer() + Math.floor(max)));
        do {
            m18340a = m18340a(mapConfig, (float) (m18340a + 0.1d));
            mapProjection.setMapZoomer(m18340a);
            mapProjection.recalculate();
            m18339a(mapProjection, iPoint, iPoint3);
            m18339a(mapProjection, iPoint2, iPoint4);
            double d3 = iPoint3.f4730x - iPoint4.f4730x;
            double d4 = iPoint4.f4731y - iPoint3.f4731y;
            if (z) {
                if (d3 >= i) {
                    return (float) (m18340a - 0.1d);
                }
            } else if (d4 >= i2) {
                return (float) (m18340a - 0.1d);
            }
        } while (m18340a < mapConfig.maxZoomLevel);
        return m18340a;
    }

    /* renamed from: a */
    public static int m18360a(int i) {
        int log = (int) (Math.log(i) / Math.log(2.0d));
        return (1 << log) >= i ? 1 << log : 1 << (log + 1);
    }

    /* renamed from: a */
    public static int m18330a(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        int m18315b = m18315b(gl10, i, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return m18315b;
    }

    /* renamed from: a */
    public static int m18329a(GL10 gl10, Bitmap bitmap) {
        return m18328a(gl10, bitmap, false);
    }

    /* renamed from: a */
    public static int m18328a(GL10 gl10, Bitmap bitmap, boolean z) {
        return m18330a(gl10, 0, bitmap, z);
    }

    /* renamed from: a */
    public static int m18323a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: a */
    public static Bitmap m18358a(int i, int i2, int i3, int i4, GL10 gl10) {
        try {
            int[] iArr = new int[i3 * i4];
            int[] iArr2 = new int[i3 * i4];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = iArr[(i5 * i3) + i6];
                    iArr2[(((i4 - i5) - 1) * i3) + i6] = (i7 & (-16711936)) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m18356a(Context context, String str) {
        try {
            InputStream open = C0943ef.m18372a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "Util", "fromAsset");
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m18355a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    /* renamed from: a */
    public static Bitmap m18354a(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return bitmap2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap2;
        }
    }

    /* renamed from: a */
    public static Bitmap m18351a(View view) {
        try {
            m18317b(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache == null) {
                return null;
            }
            return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Pair<Float, IPoint> m18350a(AbstractC0766af abstractC0766af, MapProjection mapProjection, MapConfig mapConfig) {
        return m18338a(mapProjection, mapConfig, Math.max(abstractC0766af.f2030h, 1), Math.max(abstractC0766af.f2031i, 1), Math.max(abstractC0766af.f2032j, 1), Math.max(abstractC0766af.f2033k, 1), abstractC0766af.f2028f, abstractC0766af.width, abstractC0766af.height);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01a7 A[LOOP:0: B:20:0x00f6->B:31:0x01a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0159 A[EDGE_INSN: B:32:0x0159->B:33:0x0159 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Float, IPoint> m18338a(MapProjection mapProjection, MapConfig mapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        float m18340a;
        double d;
        double d2;
        int i7;
        int i8;
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
        MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, iPoint2);
        int i9 = iPoint.f4730x - iPoint2.f4730x;
        int i10 = iPoint2.f4731y - iPoint.f4731y;
        int i11 = i5 - (i + i2);
        int i12 = i6 - (i3 + i4);
        if (i9 >= 0 || i10 >= 0) {
            int i13 = i11 <= 0 ? 1 : i11;
            if (i12 <= 0) {
                i12 = 1;
            }
            mapProjection.setMapAngle(0.0f);
            mapProjection.setCameraHeaderAngle(0.0f);
            mapProjection.recalculate();
            IPoint iPoint3 = new IPoint();
            IPoint iPoint4 = new IPoint();
            mapProjection.getLatLng2Pixel(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint3);
            mapProjection.getLatLng2Pixel(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint4);
            double d3 = iPoint3.f4730x - iPoint4.f4730x;
            double d4 = iPoint4.f4731y - iPoint3.f4731y;
            if (d3 <= 0.0d) {
                d3 = 1.0d;
            }
            if (d4 <= 0.0d) {
                d4 = 1.0d;
            }
            double log = Math.log(i13 / d3) / Math.log(2.0d);
            double min = Math.min(log, Math.log(i12 / d4) / Math.log(2.0d));
            boolean z = Math.abs(min - log) < 1.0E-7d;
            float m18340a2 = m18340a(mapConfig, (float) (Math.floor(min) + mapProjection.getMapZoomer()));
            while (true) {
                m18340a = m18340a(mapConfig, (float) (m18340a2 + 0.01d));
                mapProjection.setMapZoomer(m18340a);
                mapProjection.recalculate();
                mapProjection.getLatLng2Pixel(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint3);
                mapProjection.getLatLng2Pixel(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint4);
                d = iPoint3.f4730x - iPoint4.f4730x;
                d2 = iPoint4.f4731y - iPoint3.f4731y;
                if (d <= 0.0d) {
                    d = 1.0d;
                }
                if (d2 <= 0.0d) {
                    d2 = 1.0d;
                }
                if (z) {
                    if (d >= i13) {
                        break;
                    }
                    if (m18340a < mapConfig.maxZoomLevel) {
                        break;
                    }
                    m18340a2 = m18340a;
                } else {
                    if (d2 >= i12) {
                        break;
                    }
                    if (m18340a < mapConfig.maxZoomLevel) {
                    }
                }
            }
            m18340a = (float) (m18340a - 0.01d);
            if (z) {
                i7 = (int) (iPoint2.f4730x + ((((i5 / 2) - i) / d) * i9));
                i8 = (int) (((((i4 - i3) + d2) * i10) / (d2 * 2.0d)) + iPoint.f4731y);
            } else {
                i7 = (int) (iPoint2.f4730x + ((((i2 - i) + d) * i9) / (d * 2.0d)));
                i8 = (int) (((((i6 / 2) - i3) / d2) * i10) + iPoint.f4731y);
            }
            return new Pair<>(Float.valueOf(m18340a), new IPoint(i7, i8));
        }
        return null;
    }

    /* renamed from: a */
    public static DPoint m18346a(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new DPoint(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    /* renamed from: a */
    private static FPoint3 m18344a(FPoint fPoint, FPoint fPoint2, FPoint3 fPoint3, FPoint3 fPoint32) {
        FPoint3 fPoint33 = new FPoint3(0.0f, 0.0f, fPoint3.colorIndex);
        double d = ((fPoint2.f4729y - fPoint.f4729y) * (fPoint.f4728x - fPoint3.f4728x)) - ((fPoint2.f4728x - fPoint.f4728x) * (fPoint.f4729y - fPoint3.f4729y));
        double d2 = ((fPoint2.f4729y - fPoint.f4729y) * (fPoint32.f4728x - fPoint3.f4728x)) - ((fPoint2.f4728x - fPoint.f4728x) * (fPoint32.f4729y - fPoint3.f4729y));
        fPoint33.f4728x = (float) (fPoint3.f4728x + (((fPoint32.f4728x - fPoint3.f4728x) * d) / d2));
        fPoint33.f4729y = (float) (((d * (fPoint32.f4729y - fPoint3.f4729y)) / d2) + fPoint3.f4729y);
        return fPoint33;
    }

    /* renamed from: a */
    private static FPoint m18342a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint fPoint5 = new FPoint(0.0f, 0.0f);
        double d = ((fPoint2.f4729y - fPoint.f4729y) * (fPoint.f4728x - fPoint3.f4728x)) - ((fPoint2.f4728x - fPoint.f4728x) * (fPoint.f4729y - fPoint3.f4729y));
        double d2 = ((fPoint2.f4729y - fPoint.f4729y) * (fPoint4.f4728x - fPoint3.f4728x)) - ((fPoint2.f4728x - fPoint.f4728x) * (fPoint4.f4729y - fPoint3.f4729y));
        fPoint5.f4728x = (float) (fPoint3.f4728x + (((fPoint4.f4728x - fPoint3.f4728x) * d) / d2));
        fPoint5.f4729y = (float) (((d * (fPoint4.f4729y - fPoint3.f4729y)) / d2) + fPoint3.f4729y);
        return fPoint5;
    }

    /* renamed from: a */
    public static String m18357a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getCacheDir().toString() + File.separator;
        }
        File file = (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals("")) ? new File(Environment.getExternalStorageDirectory(), MapTilsCacheAndResManager.AUTONAVI_PATH) : new File(MapsInitializer.sdcardDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "data");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.toString() + File.separator;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m18335a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        FileInputStream fileInputStream2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            try {
                                C1007fo.m18012b(e, "Util", "readFile fileNotFound");
                                e.printStackTrace();
                                if (fileInputStream2 != null) {
                                    try {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                        }
                                    } finally {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                return stringBuffer.toString();
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                bufferedReader2 = bufferedReader;
                                if (fileInputStream != null) {
                                    try {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                            if (bufferedReader2 != null) {
                                                try {
                                                    bufferedReader2.close();
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (IOException e7) {
                                                e7.printStackTrace();
                                            }
                                        }
                                        throw th2;
                                    }
                                }
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            bufferedReader2 = bufferedReader;
                            C1007fo.m18012b(e, "Util", "readFile io");
                            e.printStackTrace();
                            try {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                return stringBuffer.toString();
                            } catch (Throwable th3) {
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader2 = bufferedReader;
                            if (fileInputStream != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            try {
                                fileInputStream.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                    bufferedReader = null;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e19) {
                    e = e19;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (FileNotFoundException e20) {
            e = e20;
            bufferedReader = null;
        } catch (IOException e21) {
            e = e21;
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m18334a(InputStream inputStream) {
        try {
            return new String(m18316b(inputStream), "utf-8");
        } catch (Throwable th) {
            C1007fo.m18012b(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m18333a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    /* renamed from: a */
    public static String m18322a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static FloatBuffer m18327a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static FloatBuffer m18326a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static List<FPoint> m18325a(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b = 0; b < 4; b = (byte) (b + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= (z ? size : size - 1)) {
                    break;
                }
                FPoint fPoint = (FPoint) arrayList2.get(i % size);
                FPoint fPoint2 = (FPoint) arrayList2.get((i + 1) % size);
                if (i == 0 && m18343a(fPoint, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                if (m18343a(fPoint, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    if (m18343a(fPoint2, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(m18342a(fPointArr[b], fPointArr[(b + 1) % fPointArr.length], fPoint, fPoint2));
                    }
                } else if (m18343a(fPoint2, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    arrayList.add(m18342a(fPointArr[b], fPointArr[(b + 1) % fPointArr.length], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
                i++;
            }
            arrayList2.clear();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public static void m18352a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: a */
    private static void m18339a(MapProjection mapProjection, IPoint iPoint, IPoint iPoint2) {
        mapProjection.recalculate();
        FPoint fPoint = new FPoint();
        mapProjection.geo2Map(iPoint.f4730x, iPoint.f4731y, fPoint);
        mapProjection.map2Win(fPoint.f4728x, fPoint.f4729y, iPoint2);
    }

    /* renamed from: a */
    public static void m18331a(GL10 gl10, int i) {
        gl10.glDeleteTextures(1, new int[]{i}, 0);
    }

    /* renamed from: a */
    public static boolean m18365a() {
        return Build.VERSION.SDK_INT >= 8;
    }

    /* renamed from: a */
    public static boolean m18363a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = ((d3 - d) * (d8 - d6)) - ((d4 - d2) * (d7 - d5));
        if (d9 != 0.0d) {
            double d10 = (((d2 - d6) * (d7 - d5)) - ((d - d5) * (d8 - d6))) / d9;
            double d11 = (((d2 - d6) * (d3 - d)) - ((d - d5) * (d4 - d2))) / d9;
            return d10 >= 0.0d && d10 <= 1.0d && d11 >= 0.0d && d11 <= 1.0d;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m18359a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            Log.w("3dmap", "the map must have a size");
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m18353a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    /* renamed from: a */
    public static boolean m18349a(C0941ed c0941ed, C0941ed c0941ed2) {
        float min = Math.min(c0941ed.f2892a, c0941ed2.f2892a);
        float min2 = Math.min(c0941ed.f2894c, c0941ed2.f2894c);
        if (min < 0.0f) {
            c0941ed.f2892a -= min;
            c0941ed.f2893b -= min;
            c0941ed2.f2892a -= min;
            c0941ed2.f2893b -= min;
        }
        if (min2 < 0.0f) {
            c0941ed.f2894c -= min2;
            c0941ed.f2895d -= min2;
            c0941ed2.f2894c -= min2;
            c0941ed2.f2895d -= min2;
        }
        if (c0941ed.f2895d > c0941ed2.f2895d || c0941ed.f2894c < c0941ed2.f2894c || c0941ed.f2893b > c0941ed2.f2893b || c0941ed.f2892a < c0941ed2.f2892a) {
            if (c0941ed2.f2895d <= c0941ed.f2895d && c0941ed2.f2894c >= c0941ed.f2894c && c0941ed2.f2893b <= c0941ed.f2893b && c0941ed2.f2892a >= c0941ed.f2892a) {
                return true;
            }
            return Math.min(c0941ed.f2893b, c0941ed2.f2893b) - Math.max(c0941ed.f2892a, c0941ed2.f2892a) >= 0.0f && Math.min(c0941ed.f2895d, c0941ed2.f2895d) - Math.max(c0941ed.f2894c, c0941ed2.f2894c) >= 0.0f;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m18345a(LatLng latLng, List<LatLng> list) {
        int i = 0;
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i3 >= list.size() - 1) {
                return i4 % 2 != 0;
            }
            double d4 = list.get(i3).longitude;
            double d5 = list.get(i3).latitude;
            double d6 = list.get(i3 + 1).longitude;
            double d7 = list.get(i3 + 1).latitude;
            if (m18320b(d, d2, d4, d5, d6, d7)) {
                return true;
            }
            if (Math.abs(d7 - d5) >= 1.0E-9d) {
                if (m18320b(d4, d5, d, d2, 180.0d, d3)) {
                    if (d5 > d7) {
                        i4++;
                    }
                } else if (m18320b(d6, d7, d, d2, 180.0d, d3)) {
                    if (d7 > d5) {
                        i4++;
                    }
                } else if (m18363a(d4, d5, d6, d7, d, d2, 180.0d, d3)) {
                    i4++;
                }
            }
            i = i4;
            i2 = i3 + 1;
        }
    }

    /* renamed from: a */
    private static boolean m18343a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return ((double) (((fPoint3.f4728x - fPoint2.f4728x) * (fPoint.f4729y - fPoint2.f4729y)) - ((fPoint.f4728x - fPoint2.f4728x) * (fPoint3.f4729y - fPoint2.f4729y)))) >= 0.0d;
    }

    /* renamed from: a */
    public static boolean m18341a(FPoint fPoint, FPoint[] fPointArr) {
        if (fPointArr == null) {
            return false;
        }
        for (byte b = 0; b < fPointArr.length; b = (byte) (b + 1)) {
            if (!m18343a(fPoint, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static float[] m18348a(AbstractC1115l abstractC1115l, int i, FPoint fPoint, float f, int i2, int i3, float f2, float f3) {
        float f4 = fPoint.f4728x;
        float f5 = fPoint.f4729y;
        float[] fArr = new float[12];
        float mapPerPixelUnitLength = abstractC1115l.getMapConfig().getMapPerPixelUnitLength() * i2;
        float mapPerPixelUnitLength2 = abstractC1115l.getMapConfig().getMapPerPixelUnitLength() * i3;
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[4];
        Matrix.setIdentityM(fArr2, 0);
        if (i == 3) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, abstractC1115l.mo17530c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
            Matrix.translateM(fArr2, 0, f4 - (mapPerPixelUnitLength / 2.0f), f5 - (mapPerPixelUnitLength2 / 2.0f), 0.0f);
            Matrix.rotateM(fArr2, 0, -abstractC1115l.mo17530c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.translateM(fArr2, 0, (mapPerPixelUnitLength / 2.0f) - f4, (mapPerPixelUnitLength2 / 2.0f) - f5, 0.0f);
        } else if (i == 1) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        } else {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, abstractC1115l.mo17530c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(fArr2, 0, -abstractC1115l.mo17530c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        }
        float[] fArr4 = new float[4];
        fArr3[0] = f4 - (mapPerPixelUnitLength * f2);
        fArr3[1] = ((1.0f - f3) * mapPerPixelUnitLength2) + f5;
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[0] = fArr4[0];
        fArr[1] = fArr4[1];
        fArr[2] = fArr4[2];
        fArr3[0] = ((1.0f - f2) * mapPerPixelUnitLength) + f4;
        fArr3[1] = ((1.0f - f3) * mapPerPixelUnitLength2) + f5;
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[3] = fArr4[0];
        fArr[4] = fArr4[1];
        fArr[5] = fArr4[2];
        fArr3[0] = ((1.0f - f2) * mapPerPixelUnitLength) + f4;
        fArr3[1] = f5 - (mapPerPixelUnitLength2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[6] = fArr4[0];
        fArr[7] = fArr4[1];
        fArr[8] = fArr4[2];
        fArr3[0] = f4 - (mapPerPixelUnitLength * f2);
        fArr3[1] = f5 - (mapPerPixelUnitLength2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[9] = fArr4[0];
        fArr[10] = fArr4[1];
        fArr[11] = fArr4[2];
        return fArr;
    }

    /* renamed from: a */
    public static FPoint[] m18347a(AbstractC1115l abstractC1115l, boolean z) {
        int i;
        int i2;
        float m18362a = (float) (m18362a(abstractC1115l.getCameraAngle()) * abstractC1115l.getMapHeight());
        if (z) {
            i2 = 100;
            i = 10;
        } else {
            i = 0;
            i2 = 0;
        }
        FPoint fPoint = new FPoint();
        abstractC1115l.mo17550a(-i2, (int) (m18362a - i), fPoint);
        FPoint fPoint2 = new FPoint();
        abstractC1115l.mo17550a(abstractC1115l.getMapWidth() + i2, (int) (m18362a - i), fPoint2);
        FPoint fPoint3 = new FPoint();
        abstractC1115l.mo17550a(abstractC1115l.getMapWidth() + i2, abstractC1115l.getMapHeight() + i2, fPoint3);
        FPoint fPoint4 = new FPoint();
        abstractC1115l.mo17550a(-i2, i2 + abstractC1115l.getMapHeight(), fPoint4);
        return new FPoint[]{fPoint, fPoint2, fPoint3, fPoint4};
    }

    /* renamed from: a */
    public static FPoint[] m18336a(IAMap iAMap, boolean z, MapProjection mapProjection) {
        int i;
        int i2;
        float m18362a = (float) (m18362a(iAMap.getCameraAngle()) * iAMap.getMapHeight());
        if (z) {
            i2 = 100;
            i = 10;
        } else {
            i = 0;
            i2 = 0;
        }
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(-i2, (int) (m18362a - i), fPoint);
        FPoint fPoint2 = new FPoint();
        mapProjection.win2Map(iAMap.getMapWidth() + i2, (int) (m18362a - i), fPoint2);
        FPoint fPoint3 = new FPoint();
        mapProjection.win2Map(iAMap.getMapWidth() + i2, iAMap.getMapHeight() + i2, fPoint3);
        FPoint fPoint4 = new FPoint();
        mapProjection.win2Map(-i2, i2 + iAMap.getMapHeight(), fPoint4);
        return new FPoint[]{fPoint, fPoint2, fPoint3, fPoint4};
    }

    /* renamed from: a */
    private static Float[] m18332a(List<Float> list, List<Float> list2, List<Float> list3, List<Float> list4, float f, float f2) {
        Float[] fArr = new Float[2];
        float floatValue = ((Float) Collections.min(list)).floatValue();
        float floatValue2 = ((Float) Collections.max(list)).floatValue();
        float floatValue3 = ((Float) Collections.min(list2)).floatValue();
        float floatValue4 = ((Float) Collections.max(list2)).floatValue();
        float abs = Math.abs(floatValue2 - floatValue);
        float abs2 = Math.abs(floatValue3 - floatValue4);
        float floatValue5 = ((Float) Collections.min(list3)).floatValue();
        float floatValue6 = ((Float) Collections.max(list3)).floatValue();
        float floatValue7 = ((Float) Collections.min(list4)).floatValue();
        float floatValue8 = ((Float) Collections.max(list4)).floatValue();
        float abs3 = abs > Math.abs(floatValue6 - floatValue5) ? Math.abs(floatValue6 - floatValue5) : abs;
        float abs4 = abs2 > Math.abs(floatValue8 - floatValue7) ? Math.abs(floatValue8 - floatValue7) : abs2;
        float f3 = floatValue5 + (abs3 / 2.0f);
        float f4 = (abs4 / 2.0f) + floatValue7;
        float f5 = floatValue6 - (abs3 / 2.0f);
        float f6 = floatValue8 - (abs4 / 2.0f);
        if (f > f3) {
            f3 = f;
        }
        if (f3 < f5) {
            f5 = f3;
        }
        if (f2 < f6) {
            f6 = f2;
        }
        if (f6 <= f4) {
            f6 = f4;
        }
        fArr[0] = Float.valueOf(f5);
        fArr[1] = Float.valueOf(f6);
        return fArr;
    }

    /* renamed from: a */
    public static synchronized Integer[] m18324a(IPoint[] iPointArr, IPoint[] iPointArr2, int i, int i2) {
        Integer[] numArr;
        synchronized (C0945eh.class) {
            if (iPointArr != null && iPointArr2 != null) {
                if (iPointArr.length == 2) {
                    ArrayList arrayList = new ArrayList(4);
                    ArrayList arrayList2 = new ArrayList(4);
                    for (int i3 = 0; i3 < iPointArr2.length; i3++) {
                        IPoint iPoint = iPointArr2[i3];
                        arrayList.add(i3, Float.valueOf(iPoint.f4730x));
                        arrayList2.add(i3, Float.valueOf(iPoint.f4731y));
                    }
                    ArrayList arrayList3 = new ArrayList(2);
                    ArrayList arrayList4 = new ArrayList(2);
                    for (int i4 = 0; i4 < iPointArr.length; i4++) {
                        IPoint iPoint2 = iPointArr[i4];
                        arrayList3.add(i4, Float.valueOf(iPoint2.f4730x));
                        arrayList4.add(i4, Float.valueOf(iPoint2.f4731y));
                    }
                    Float[] m18332a = m18332a(arrayList, arrayList2, arrayList3, arrayList4, i, i2);
                    numArr = new Integer[]{Integer.valueOf((int) m18332a[0].floatValue()), Integer.valueOf((int) m18332a[1].floatValue())};
                }
            }
            numArr = null;
        }
        return numArr;
    }

    /* renamed from: b */
    public static int m18315b(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            gl10.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        gl10.glEnable(3553);
        gl10.glBindTexture(3553, i);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, C2227d.f7442b, 9729.0f);
        if (z) {
            gl10.glTexParameterf(3553, 10242, 10497.0f);
            gl10.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            gl10.glTexParameterf(3553, 10242, 33071.0f);
            gl10.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        gl10.glDisable(3553);
        return i;
    }

    /* renamed from: b */
    public static String m18319b(int i) {
        return i < 1000 ? i + C0413a.f922b : (i / 1000) + "km";
    }

    /* renamed from: b */
    public static String m18318b(Context context) {
        String m18357a = m18357a(context);
        if (m18357a == null) {
            return null;
        }
        File file = new File(m18357a, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    /* renamed from: b */
    public static List<FPoint> m18314b(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b = 0; b < 4; b = (byte) (b + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= (z ? size : size - 1)) {
                    break;
                }
                FPoint3 fPoint3 = (FPoint3) arrayList2.get(i % size);
                FPoint3 fPoint32 = (FPoint3) arrayList2.get((i + 1) % size);
                if (i == 0 && m18343a(fPoint3, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    arrayList.add(fPoint3);
                }
                if (m18343a(fPoint3, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    if (m18343a(fPoint32, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                        arrayList.add(fPoint32);
                    } else {
                        arrayList.add(m18344a(fPointArr[b], fPointArr[(b + 1) % fPointArr.length], fPoint3, fPoint32));
                    }
                } else if (m18343a(fPoint32, fPointArr[b], fPointArr[(b + 1) % fPointArr.length])) {
                    arrayList.add(m18344a(fPointArr[b], fPointArr[(b + 1) % fPointArr.length], fPoint3, fPoint32));
                    arrayList.add(fPoint32);
                }
                i++;
            }
            arrayList2.clear();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    /* renamed from: b */
    private static void m18317b(View view) {
        int i = 0;
        if (!(view instanceof ViewGroup)) {
            if (!(view instanceof TextView)) {
                return;
            }
            ((TextView) view).setHorizontallyScrolling(false);
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= ((ViewGroup) view).getChildCount()) {
                return;
            }
            m18317b(((ViewGroup) view).getChildAt(i2));
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public static boolean m18321b() {
        return Build.VERSION.SDK_INT >= 9;
    }

    /* renamed from: b */
    public static boolean m18320b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(m18364a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    /* renamed from: b */
    public static byte[] m18316b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: c */
    public static boolean m18313c() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: c */
    public static boolean m18312c(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            NetworkInfo.State state = activeNetworkInfo.getState();
            return (state == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m18311d() {
        return Build.VERSION.SDK_INT >= 12;
    }

    /* renamed from: e */
    public static C0996fh m18310e() {
        try {
            return C1022g.f3204f == null ? new C0996fh.C0998a("3dmap", "4.1.2", C1022g.f3202d).m18060a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).m18061a("4.1.2").m18063a() : C1022g.f3204f;
        } catch (Throwable th) {
            return null;
        }
    }
}
