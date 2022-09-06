package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES10;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.df */
/* loaded from: classes.dex */
public class C0897df implements AbstractC0887cx {

    /* renamed from: a */
    private static int f2667a = 0;

    /* renamed from: g */
    private int f2676g;

    /* renamed from: h */
    private Bitmap f2677h;

    /* renamed from: i */
    private int f2678i;

    /* renamed from: j */
    private int f2679j;

    /* renamed from: l */
    private String f2681l;

    /* renamed from: m */
    private LatLng f2682m;

    /* renamed from: p */
    private boolean f2685p;

    /* renamed from: q */
    private C1120q f2686q;

    /* renamed from: r */
    private FloatBuffer f2687r;

    /* renamed from: s */
    private Object f2688s;

    /* renamed from: t */
    private String f2689t;

    /* renamed from: u */
    private int f2690u;

    /* renamed from: v */
    private int f2691v;

    /* renamed from: w */
    private int f2692w;

    /* renamed from: x */
    private Typeface f2693x;

    /* renamed from: y */
    private float f2694y;

    /* renamed from: b */
    private float f2671b = 0.0f;

    /* renamed from: c */
    private float f2672c = 0.0f;

    /* renamed from: d */
    private int f2673d = 4;

    /* renamed from: e */
    private int f2674e = 32;

    /* renamed from: f */
    private FPoint f2675f = new FPoint();

    /* renamed from: k */
    private FloatBuffer f2680k = null;

    /* renamed from: n */
    private float f2683n = 0.5f;

    /* renamed from: o */
    private float f2684o = 1.0f;

    /* renamed from: z */
    private Rect f2695z = new Rect();

    /* renamed from: A */
    private Paint f2668A = new Paint();

    /* renamed from: B */
    private boolean f2669B = false;

    /* renamed from: C */
    private boolean f2670C = false;

    public C0897df(TextOptions textOptions, C1120q c1120q) {
        this.f2685p = true;
        this.f2686q = c1120q;
        if (textOptions.getPosition() != null) {
            this.f2682m = textOptions.getPosition();
        }
        setAlign(textOptions.getAlignX(), textOptions.getAlignY());
        this.f2685p = textOptions.isVisible();
        this.f2689t = textOptions.getText();
        this.f2690u = textOptions.getBackgroundColor();
        this.f2691v = textOptions.getFontColor();
        this.f2692w = textOptions.getFontSize();
        this.f2688s = textOptions.getObject();
        this.f2694y = textOptions.getZIndex();
        this.f2693x = textOptions.getTypeface();
        this.f2681l = getId();
        setRotateAngle(textOptions.getRotate());
        m18573a();
        mo18562i();
    }

    /* renamed from: a */
    private int m18569a(GL10 gl10) {
        int[] iArr = {0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: a */
    private static String m18570a(String str) {
        f2667a++;
        return str + f2667a;
    }

    /* renamed from: a */
    private void m18573a() {
        if (this.f2689t == null || this.f2689t.trim().length() <= 0) {
            return;
        }
        try {
            this.f2668A.setTypeface(this.f2693x);
            this.f2668A.setSubpixelText(true);
            this.f2668A.setAntiAlias(true);
            this.f2668A.setStrokeWidth(5.0f);
            this.f2668A.setStrokeCap(Paint.Cap.ROUND);
            this.f2668A.setTextSize(this.f2692w);
            this.f2668A.setTextAlign(Paint.Align.CENTER);
            this.f2668A.setColor(this.f2691v);
            Paint.FontMetrics fontMetrics = this.f2668A.getFontMetrics();
            int i = (int) (fontMetrics.descent - fontMetrics.ascent);
            this.f2668A.getTextBounds(this.f2689t, 0, this.f2689t.length(), this.f2695z);
            Bitmap createBitmap = Bitmap.createBitmap(this.f2695z.width() + 6, i, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(this.f2690u);
            canvas.drawText(this.f2689t, this.f2695z.centerX() + 3, (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f), this.f2668A);
            this.f2677h = createBitmap;
            this.f2678i = this.f2677h.getWidth();
            this.f2679j = this.f2677h.getHeight();
            this.f2687r = C0945eh.m18327a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TextDelegateImp", "initBitmap");
        }
    }

    /* renamed from: a */
    private void m18572a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i == 0 || floatBuffer == null || floatBuffer2 == null) {
            return;
        }
        GLES10.glEnable(3042);
        GLES10.glBlendFunc(1, 771);
        GLES10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GLES10.glEnable(3553);
        GLES10.glEnableClientState(32884);
        GLES10.glEnableClientState(32888);
        GLES10.glBindTexture(3553, i);
        GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
        GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
        GLES10.glDrawArrays(6, 0, 4);
        GLES10.glDisableClientState(32884);
        GLES10.glDisableClientState(32888);
        GLES10.glDisable(3553);
        GLES10.glDisable(3042);
    }

    /* renamed from: a */
    private void m18571a(AbstractC1115l abstractC1115l) {
        float[] m18348a = C0945eh.m18348a(abstractC1115l, 0, this.f2675f, this.f2671b, m18567b(), m18566c(), this.f2683n, this.f2684o);
        if (this.f2680k == null) {
            this.f2680k = C0945eh.m18327a(m18348a);
        } else {
            this.f2680k = C0945eh.m18326a(m18348a, this.f2680k);
        }
        if (this.f2676g != 0) {
            m18572a(this.f2676g, this.f2680k, this.f2687r);
        }
    }

    /* renamed from: b */
    private int m18567b() {
        return this.f2678i;
    }

    /* renamed from: c */
    private int m18566c() {
        return this.f2679j;
    }

    /* renamed from: d */
    private void m18565d() {
        if (this.f2686q.m17504a() != null) {
            this.f2686q.m17504a().setRunLowFrame(false);
        }
    }

    /* renamed from: e */
    private synchronized void m18564e() {
        m18573a();
        this.f2670C = false;
        m18565d();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: a */
    public void mo18568a(GL10 gl10, AbstractC1115l abstractC1115l) {
        if (!this.f2685p || this.f2669B || this.f2682m == null || this.f2677h == null) {
            return;
        }
        if (!this.f2670C) {
            try {
                if (this.f2677h != null && !this.f2677h.isRecycled()) {
                    if (this.f2676g == 0) {
                        this.f2676g = m18569a(gl10);
                    }
                    C0945eh.m18315b(gl10, this.f2676g, this.f2677h, false);
                    this.f2670C = true;
                    this.f2677h.recycle();
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "TextDelegateImp", "loadtexture");
                th.printStackTrace();
                return;
            }
        }
        try {
            m18571a(abstractC1115l);
        } catch (Throwable th2) {
            C1007fo.m18012b(th2, "TextDelegateImp", "drawMarker");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void destroy() {
        try {
            this.f2669B = true;
            remove();
            if (this.f2677h != null) {
                this.f2677h.recycle();
                this.f2677h = null;
            }
            if (this.f2687r != null) {
                this.f2687r.clear();
                this.f2687r = null;
            }
            if (this.f2680k != null) {
                this.f2680k.clear();
                this.f2680k = null;
            }
            this.f2682m = null;
            this.f2688s = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "TextDelegateImp destroy");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean equalsRemote(IOverlayImage iOverlayImage) {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getAlignX() {
        return this.f2673d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getAlignY() {
        return this.f2674e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorU() {
        return this.f2683n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorV() {
        return this.f2684o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getBackgroundColor() {
        return this.f2690u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getFontColor() {
        return this.f2691v;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getFontSize() {
        return this.f2692w;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu, com.autonavi.amap.mapcore.interfaces.IMarker
    public IMarkerAction getIMarkerAction() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public String getId() {
        if (this.f2681l == null) {
            this.f2681l = m18570a("Text");
        }
        return this.f2681l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public Object getObject() {
        return this.f2688s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public LatLng getPosition() {
        return this.f2682m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getRotateAngle() {
        return this.f2672c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public String getText() {
        return this.f2689t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public Typeface getTypeface() {
        return this.f2693x;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getZIndex() {
        return this.f2694y;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: h */
    public Rect mo18563h() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: i */
    public boolean mo18562i() {
        try {
            if (this.f2682m == null) {
                return false;
            }
            this.f2686q.m17504a().mo17556a(this.f2682m.latitude, this.f2682m.longitude, this.f2675f);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean isVisible() {
        return this.f2685p;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: j */
    public boolean mo18561j() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: k */
    public boolean mo18560k() {
        return this.f2675f != null && C0945eh.m18341a(this.f2675f, this.f2686q.m17504a().mo17511p());
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: l */
    public void mo18559l() {
        this.f2670C = false;
        this.f2676g = 0;
        m18573a();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0884cu
    /* renamed from: m */
    public boolean mo18558m() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public synchronized boolean remove() {
        m18565d();
        this.f2685p = false;
        return this.f2686q.m17501a(this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setAlign(int i, int i2) {
        this.f2673d = i;
        switch (i) {
            case 1:
                this.f2683n = 0.0f;
                break;
            case 2:
                this.f2683n = 1.0f;
                break;
            case 3:
            default:
                this.f2683n = 0.5f;
                break;
            case 4:
                this.f2683n = 0.5f;
                break;
        }
        this.f2674e = i2;
        switch (i2) {
            case 8:
                this.f2684o = 0.0f;
                break;
            case 16:
                this.f2684o = 1.0f;
                break;
            case 32:
                this.f2684o = 0.5f;
                break;
            default:
                this.f2684o = 0.5f;
                break;
        }
        m18565d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setAnchor(float f, float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setBackgroundColor(int i) {
        this.f2690u = i;
        m18564e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setFontColor(int i) {
        this.f2691v = i;
        m18564e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setFontSize(int i) {
        this.f2692w = i;
        m18564e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setObject(Object obj) {
        this.f2688s = obj;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setPosition(LatLng latLng) {
        this.f2682m = latLng;
        mo18562i();
        m18565d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setRotateAngle(float f) {
        this.f2672c = f;
        this.f2671b = (((-f) % 360.0f) + 360.0f) % 360.0f;
        m18565d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setText(String str) {
        this.f2689t = str;
        m18564e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setTypeface(Typeface typeface) {
        this.f2693x = typeface;
        m18564e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setVisible(boolean z) {
        if (this.f2685p == z) {
            return;
        }
        this.f2685p = z;
        mo18562i();
        m18565d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setZIndex(float f) {
        this.f2694y = f;
        this.f2686q.m17481g();
    }
}
