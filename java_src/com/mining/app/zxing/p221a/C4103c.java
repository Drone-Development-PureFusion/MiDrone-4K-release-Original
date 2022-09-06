package com.mining.app.zxing.p221a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
/* renamed from: com.mining.app.zxing.a.c */
/* loaded from: classes.dex */
public final class C4103c {

    /* renamed from: a */
    static final int f17141a;

    /* renamed from: b */
    private static final String f17142b = C4103c.class.getSimpleName();

    /* renamed from: c */
    private static final int f17143c = 240;

    /* renamed from: d */
    private static final int f17144d = 240;

    /* renamed from: e */
    private static final int f17145e = 480;

    /* renamed from: f */
    private static final int f17146f = 360;

    /* renamed from: g */
    private static C4103c f17147g;

    /* renamed from: h */
    private final Context f17148h;

    /* renamed from: i */
    private final C4102b f17149i;

    /* renamed from: j */
    private Camera f17150j;

    /* renamed from: k */
    private Rect f17151k;

    /* renamed from: l */
    private Rect f17152l;

    /* renamed from: m */
    private Rect f17153m;

    /* renamed from: n */
    private boolean f17154n;

    /* renamed from: o */
    private boolean f17155o;

    /* renamed from: p */
    private final boolean f17156p;

    /* renamed from: q */
    private final C4106f f17157q;

    /* renamed from: r */
    private final C4101a f17158r;

    /* renamed from: s */
    private int f17159s;

    static {
        int i;
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            i = 10000;
        }
        f17141a = i;
    }

    private C4103c(Context context) {
        this.f17148h = context;
        this.f17149i = new C4102b(context);
        this.f17156p = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.f17157q = new C4106f(this.f17149i, this.f17156p);
        this.f17158r = new C4101a();
    }

    /* renamed from: a */
    public static C4103c m6188a() {
        return f17147g;
    }

    /* renamed from: a */
    public static void m6186a(Context context) {
        if (f17147g == null) {
            f17147g = new C4103c(context);
        }
    }

    /* renamed from: a */
    public int m6187a(int i) {
        return (i * 58) / 108;
    }

    /* renamed from: a */
    public C4105e m6183a(byte[] bArr, int i, int i2) {
        Rect m6176f = m6176f();
        int m6191c = this.f17149i.m6191c();
        String m6190d = this.f17149i.m6190d();
        switch (m6191c) {
            case 16:
            case 17:
                return new C4105e(bArr, i, i2, m6176f.left, m6176f.top, m6176f.width(), m6176f.height());
            default:
                if (!"yuv420p".equals(m6190d)) {
                    throw new IllegalArgumentException("Unsupported picture format: " + m6191c + '/' + m6190d);
                }
                return new C4105e(bArr, i, i2, m6176f.left, m6176f.top, m6176f.width(), m6176f.height());
        }
    }

    /* renamed from: a */
    public void m6185a(Handler handler, int i) {
        if (this.f17150j == null || !this.f17155o) {
            return;
        }
        this.f17157q.m6163a(handler, i);
        if (this.f17156p) {
            this.f17150j.setOneShotPreviewCallback(this.f17157q);
        } else {
            this.f17150j.setPreviewCallback(this.f17157q);
        }
    }

    /* renamed from: a */
    public void m6184a(SurfaceHolder surfaceHolder) {
        if (this.f17150j == null) {
            this.f17150j = Camera.open();
            if (this.f17150j == null) {
                throw new IOException();
            }
            this.f17150j.setPreviewDisplay(surfaceHolder);
            if (!this.f17154n) {
                this.f17154n = true;
                this.f17149i.m6198a(this.f17150j);
            }
            this.f17149i.m6192b(this.f17150j);
            C4104d.m6168b();
        }
    }

    /* renamed from: b */
    public int m6181b(int i) {
        return (i * 42) / 192;
    }

    /* renamed from: b */
    public void m6182b() {
        if (this.f17150j != null) {
            C4104d.m6168b();
            this.f17150j.release();
            this.f17150j = null;
        }
    }

    /* renamed from: b */
    public void m6180b(Handler handler, int i) {
        if (this.f17150j == null || !this.f17155o) {
            return;
        }
        this.f17158r.m6202a(handler, i);
        this.f17150j.autoFocus(this.f17158r);
    }

    /* renamed from: c */
    public void m6179c() {
        if (this.f17150j == null || this.f17155o) {
            return;
        }
        this.f17150j.startPreview();
        this.f17155o = true;
    }

    /* renamed from: d */
    public void m6178d() {
        if (this.f17150j == null || !this.f17155o) {
            return;
        }
        if (!this.f17156p) {
            this.f17150j.setPreviewCallback(null);
        }
        this.f17150j.stopPreview();
        this.f17157q.m6163a(null, 0);
        this.f17158r.m6202a(null, 0);
        this.f17155o = false;
    }

    /* renamed from: e */
    public Rect m6177e() {
        Point m6194b = this.f17149i.m6194b();
        if (this.f17151k == null) {
            if (this.f17150j == null) {
                return null;
            }
            int m6187a = m6187a(m6194b.x);
            this.f17159s = m6181b(m6194b.y);
            int i = (m6194b.x - m6187a) / 2;
            int i2 = ((m6194b.y - this.f17159s) - m6187a) / 2;
            this.f17151k = new Rect(i, i2, i + m6187a, m6187a + i2);
            Log.d(f17142b, "Calculated framing rect: " + this.f17151k);
        }
        return this.f17151k;
    }

    /* renamed from: f */
    public Rect m6176f() {
        if (this.f17153m == null) {
            Rect rect = new Rect(m6177e());
            Point m6201a = this.f17149i.m6201a();
            Point m6194b = this.f17149i.m6194b();
            rect.left = (rect.left * m6201a.y) / m6194b.x;
            rect.right = (rect.right * m6201a.y) / m6194b.x;
            rect.top = (rect.top * m6201a.x) / m6194b.y;
            rect.bottom = (m6201a.x * rect.bottom) / m6194b.y;
            this.f17153m = rect;
        }
        return this.f17153m;
    }

    /* renamed from: g */
    public Context m6175g() {
        return this.f17148h;
    }
}
