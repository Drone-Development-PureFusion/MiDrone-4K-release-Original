package com.mining.app.zxing.p221a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mining.app.zxing.a.b */
/* loaded from: classes.dex */
public final class C4102b {

    /* renamed from: b */
    private static final int f17133b = 27;

    /* renamed from: c */
    private static final int f17134c = 30;

    /* renamed from: e */
    private final Context f17136e;

    /* renamed from: f */
    private Point f17137f;

    /* renamed from: g */
    private Point f17138g;

    /* renamed from: h */
    private int f17139h;

    /* renamed from: i */
    private String f17140i;

    /* renamed from: a */
    private static final String f17132a = C4102b.class.getSimpleName();

    /* renamed from: d */
    private static final Pattern f17135d = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4102b(Context context) {
        this.f17136e = context;
    }

    /* renamed from: a */
    private static int m6196a(CharSequence charSequence, int i) {
        String[] split = f17135d.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(i - parseDouble) >= Math.abs(i - i3)) {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static Point m6199a(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        String str2 = str == null ? parameters.get("preview-size-value") : str;
        Point point2 = null;
        if (str2 != null) {
            Log.d(f17132a, "preview-size-values parameter: " + str2);
            point2 = m6195a(str2, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    /* renamed from: a */
    private static Point m6195a(CharSequence charSequence, Point point) {
        int i;
        int i2;
        int i3;
        int i4;
        String[] split = f17135d.split(charSequence);
        int length = split.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = Integer.MAX_VALUE;
        while (true) {
            if (i5 >= length) {
                i = i6;
                i2 = i7;
                break;
            }
            String trim = split[i5].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                Log.w(f17132a, "Bad preview-size: " + trim);
                i3 = i6;
                i4 = i7;
            } else {
                try {
                    i2 = Integer.parseInt(trim.substring(0, indexOf));
                    i = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(i2 - point.x) + Math.abs(i - point.y);
                    if (abs == 0) {
                        break;
                    } else if (abs < i8) {
                        i8 = abs;
                        i4 = i2;
                        i3 = i;
                    } else {
                        i3 = i6;
                        i4 = i7;
                    }
                } catch (NumberFormatException e) {
                    Log.w(f17132a, "Bad preview-size: " + trim);
                    i3 = i6;
                    i4 = i7;
                }
            }
            i5++;
            i7 = i4;
            i6 = i3;
        }
        if (i2 <= 0 || i <= 0) {
            return null;
        }
        return new Point(i2, i);
    }

    /* renamed from: a */
    private void m6200a(Camera.Parameters parameters) {
        if (!Build.MODEL.contains("Behold II") || C4103c.f17141a != 3) {
            parameters.set("flash-value", 2);
        } else {
            parameters.set("flash-value", 1);
        }
        parameters.set("flash-mode", "off");
    }

    /* renamed from: b */
    private void m6193b(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 <= parseDouble) {
                        parseDouble = 27;
                    }
                    i = parseDouble;
                } catch (NumberFormatException e) {
                    Log.w(f17132a, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException e2) {
                    Log.w(f17132a, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = m6196a(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException e3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str3 == null) {
                return;
            }
            parameters.set("taking-picture-zoom", i);
        }
    }

    /* renamed from: e */
    public static int m6189e() {
        return 30;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Point m6201a() {
        return this.f17138g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6198a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f17139h = parameters.getPreviewFormat();
        this.f17140i = parameters.get("preview-format");
        Log.d(f17132a, "Default preview format: " + this.f17139h + '/' + this.f17140i);
        Display defaultDisplay = ((WindowManager) this.f17136e.getSystemService("window")).getDefaultDisplay();
        this.f17137f = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.d(f17132a, "Screen resolution: " + this.f17137f);
        this.f17138g = m6199a(parameters, this.f17137f);
        Log.d(f17132a, "Camera resolution: " + this.f17137f);
    }

    /* renamed from: a */
    protected void m6197a(Camera camera, int i) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method == null) {
                return;
            }
            method.invoke(camera, Integer.valueOf(i));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Point m6194b() {
        return this.f17137f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m6192b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Log.d(f17132a, "Setting preview size: " + this.f17138g);
        parameters.setPreviewSize(this.f17138g.x, this.f17138g.y);
        m6200a(parameters);
        m6193b(parameters);
        m6197a(camera, 90);
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m6191c() {
        return this.f17139h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public String m6190d() {
        return this.f17140i;
    }
}
