package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.p001v4.view.ViewCompat;
import android.view.View;
import java.io.InputStream;
/* renamed from: com.amap.api.mapcore.util.eo */
/* loaded from: classes.dex */
public class C0962eo extends View {

    /* renamed from: a */
    private Bitmap f2984a;

    /* renamed from: b */
    private Bitmap f2985b;

    /* renamed from: c */
    private Bitmap f2986c;

    /* renamed from: d */
    private Bitmap f2987d;

    /* renamed from: g */
    private int f2990g;

    /* renamed from: h */
    private int f2991h;

    /* renamed from: i */
    private AbstractC1115l f2992i;

    /* renamed from: e */
    private Paint f2988e = new Paint();

    /* renamed from: f */
    private boolean f2989f = false;

    /* renamed from: j */
    private int f2993j = 0;

    /* renamed from: k */
    private int f2994k = 10;

    /* renamed from: l */
    private int f2995l = 0;

    /* renamed from: m */
    private int f2996m = 0;

    /* renamed from: n */
    private int f2997n = 10;

    /* renamed from: o */
    private int f2998o = 8;

    /* renamed from: p */
    private int f2999p = 0;

    /* renamed from: q */
    private boolean f3000q = false;

    /* renamed from: r */
    private float f3001r = 0.0f;

    /* renamed from: s */
    private float f3002s = 0.0f;

    /* renamed from: t */
    private boolean f3003t = true;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0962eo(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        InputStream inputStream;
        InputStream inputStream2 = null;
        this.f2990g = 0;
        this.f2991h = 0;
        this.f2992i = abstractC1115l;
        try {
            inputStream = C0943ef.m18372a(context).open("ap.data");
            try {
                this.f2986c = BitmapFactory.decodeStream(inputStream);
                this.f2984a = C0945eh.m18355a(this.f2986c, C1022g.f3199a);
                inputStream.close();
                inputStream2 = C0943ef.m18372a(context).open("ap1.data");
                this.f2987d = BitmapFactory.decodeStream(inputStream2);
                this.f2985b = C0945eh.m18355a(this.f2987d, C1022g.f3199a);
                inputStream2.close();
                this.f2991h = this.f2985b.getWidth();
                this.f2990g = this.f2985b.getHeight();
                this.f2988e.setAntiAlias(true);
                this.f2988e.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f2988e.setStyle(Paint.Style.STROKE);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (inputStream2 == null) {
                    return;
                }
                try {
                    inputStream2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    C1007fo.m18012b(th, "WaterMarkerView", "create");
                    th.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream2 == null) {
                        return;
                    }
                    try {
                        inputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                } catch (Throwable th6) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
        }
    }

    /* renamed from: d */
    private void m18213d() {
        switch (this.f2996m) {
            case 0:
                m18210f();
                break;
            case 2:
                m18211e();
                break;
        }
        this.f2994k = this.f2997n;
        this.f2995l = (this.f2992i.getMapHeight() - this.f2998o) - this.f2990g;
        if (this.f2994k < 0) {
            this.f2994k = 0;
        }
        if (this.f2995l < 0) {
            this.f2995l = 0;
        }
    }

    /* renamed from: e */
    private void m18211e() {
        if (this.f3003t) {
            this.f2997n = (int) (this.f2992i.getMapWidth() * this.f3001r);
        } else {
            this.f2997n = (int) ((this.f2992i.getMapWidth() * this.f3001r) - this.f2991h);
        }
        this.f2998o = (int) (this.f2992i.getMapHeight() * this.f3002s);
    }

    /* renamed from: f */
    private void m18210f() {
        if (this.f2993j == 1) {
            this.f2997n = (this.f2992i.getMapWidth() - this.f2991h) / 2;
        } else if (this.f2993j == 2) {
            this.f2997n = (this.f2992i.getMapWidth() - this.f2991h) - 10;
        } else {
            this.f2997n = 10;
        }
        this.f2998o = 8;
    }

    /* renamed from: a */
    public Bitmap m18221a() {
        return this.f2989f ? this.f2985b : this.f2984a;
    }

    /* renamed from: a */
    public void m18220a(int i) {
        this.f2996m = 0;
        this.f2993j = i;
        m18215c();
    }

    /* renamed from: a */
    public void m18219a(int i, float f) {
        this.f2996m = 2;
        this.f2999p = i;
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        switch (i) {
            case 0:
                this.f3001r = max;
                this.f3003t = true;
                break;
            case 1:
                this.f3001r = 1.0f - max;
                this.f3003t = false;
                break;
            case 2:
                this.f3002s = 1.0f - max;
                break;
        }
        m18215c();
    }

    /* renamed from: a */
    public void m18218a(boolean z) {
        try {
            this.f2989f = z;
            if (z) {
                this.f2988e.setColor(-1);
            } else {
                this.f2988e.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            invalidate();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "WaterMarkerView", "changeBitmap");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public Point m18217b() {
        return new Point(this.f2994k, this.f2995l - 2);
    }

    /* renamed from: b */
    public void m18216b(int i) {
        this.f2996m = 1;
        this.f2998o = i;
        m18215c();
    }

    /* renamed from: c */
    public void m18215c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        m18213d();
        invalidate();
    }

    /* renamed from: c */
    public void m18214c(int i) {
        this.f2996m = 1;
        this.f2997n = i;
        m18215c();
    }

    /* renamed from: d */
    public float m18212d(int i) {
        switch (i) {
            case 0:
                return this.f3001r;
            case 1:
                return 1.0f - this.f3001r;
            case 2:
                return 1.0f - this.f3002s;
            default:
                return 0.0f;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (this.f2985b == null) {
                return;
            }
            if (!this.f3000q) {
                m18213d();
                this.f3000q = true;
            }
            canvas.drawBitmap(m18221a(), this.f2994k, this.f2995l, this.f2988e);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
