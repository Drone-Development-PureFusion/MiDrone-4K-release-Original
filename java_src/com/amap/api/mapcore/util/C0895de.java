package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.de */
/* loaded from: classes.dex */
public class C0895de implements AbstractC0880cq, AbstractC0883ct, IInfoWindowManager {

    /* renamed from: D */
    private C0902di f2635D;

    /* renamed from: E */
    private C0902di f2636E;

    /* renamed from: a */
    AbstractC1115l f2639a;

    /* renamed from: b */
    private Context f2640b;

    /* renamed from: c */
    private AMap.MultiPositionInfoWindowAdapter f2641c;

    /* renamed from: d */
    private AbstractC0881cr f2642d;

    /* renamed from: j */
    private FPoint f2648j;

    /* renamed from: n */
    private FloatBuffer f2652n;

    /* renamed from: q */
    private boolean f2655q;

    /* renamed from: r */
    private Bitmap f2656r;

    /* renamed from: s */
    private Bitmap f2657s;

    /* renamed from: w */
    private int f2661w;

    /* renamed from: e */
    private boolean f2643e = false;

    /* renamed from: f */
    private int f2644f = 0;

    /* renamed from: g */
    private int f2645g = 0;

    /* renamed from: h */
    private int f2646h = 0;

    /* renamed from: i */
    private int f2647i = 0;

    /* renamed from: k */
    private FloatBuffer f2649k = null;

    /* renamed from: m */
    private boolean f2651m = true;

    /* renamed from: o */
    private float f2653o = 0.5f;

    /* renamed from: p */
    private float f2654p = 1.0f;

    /* renamed from: t */
    private Rect f2658t = new Rect();

    /* renamed from: u */
    private float f2659u = 0.0f;

    /* renamed from: v */
    private float f2660v = 0.0f;

    /* renamed from: x */
    private boolean f2662x = true;

    /* renamed from: y */
    private Bitmap f2663y = null;

    /* renamed from: z */
    private Bitmap f2664z = null;

    /* renamed from: A */
    private Bitmap f2632A = null;

    /* renamed from: B */
    private Bitmap f2633B = null;

    /* renamed from: C */
    private boolean f2634C = false;

    /* renamed from: F */
    private boolean f2637F = false;

    /* renamed from: G */
    private boolean f2638G = true;

    /* renamed from: l */
    private String f2650l = getId();

    public C0895de(AbstractC1115l abstractC1115l, Context context) {
        this.f2639a = null;
        this.f2640b = context;
        this.f2639a = abstractC1115l;
    }

    /* renamed from: a */
    private Bitmap m18610a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f2640b != null) {
            LinearLayout linearLayout = new LinearLayout(this.f2640b);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return C0945eh.m18351a(view);
    }

    /* renamed from: a */
    private void m18603a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null || i == 0) {
            return;
        }
        gl10.glEnable(3042);
        gl10.glBlendFunc(1, 771);
        gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        gl10.glEnable(3553);
        gl10.glEnableClientState(32884);
        gl10.glEnableClientState(32888);
        gl10.glBindTexture(3553, i);
        gl10.glVertexPointer(3, 5126, 0, floatBuffer);
        gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
        gl10.glDrawArrays(6, 0, 4);
        gl10.glDisableClientState(32884);
        gl10.glDisableClientState(32888);
        gl10.glDisable(3553);
        gl10.glDisable(3042);
    }

    /* renamed from: b */
    private int m18597b(GL10 gl10) {
        int[] iArr = {0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m18596b(boolean z) {
        if (z) {
            m18599b(m18584j());
        } else {
            m18599b(m18583k());
        }
    }

    /* renamed from: c */
    private synchronized void m18594c(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* renamed from: c */
    private void m18593c(final boolean z) {
        if (this.f2636E != null) {
            this.f2638G = false;
            this.f2637F = true;
            this.f2636E.m18531d();
            this.f2636E.m18534a(new Animation.AnimationListener() { // from class: com.amap.api.mapcore.util.de.1
                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationEnd() {
                    if (C0895de.this.f2635D != null) {
                        C0895de.this.f2637F = true;
                        C0895de.this.f2635D.m18531d();
                        C0895de.this.m18596b(z);
                    }
                }

                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationStart() {
                }
            });
        } else if (this.f2635D == null) {
            m18596b(z);
        } else {
            this.f2637F = true;
            this.f2635D.m18531d();
            m18596b(z);
        }
    }

    /* renamed from: d */
    private void m18592d(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m18594c(this.f2664z);
        this.f2664z = bitmap;
    }

    /* renamed from: e */
    private void m18591e(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m18594c(this.f2632A);
        this.f2632A = bitmap;
    }

    /* renamed from: f */
    private void m18589f(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m18594c(this.f2633B);
        this.f2633B = bitmap;
    }

    /* renamed from: g */
    private boolean m18587g(Bitmap bitmap) {
        if (this.f2663y == null || bitmap.hashCode() != this.f2663y.hashCode()) {
            if (this.f2632A != null && bitmap.hashCode() == this.f2632A.hashCode()) {
                return true;
            }
            if (this.f2664z != null && bitmap.hashCode() == this.f2664z.hashCode()) {
                return true;
            }
            return this.f2633B != null && bitmap.hashCode() == this.f2633B.hashCode();
        }
        return true;
    }

    /* renamed from: j */
    private Bitmap m18584j() {
        return this.f2663y;
    }

    /* renamed from: k */
    private Bitmap m18583k() {
        return this.f2632A;
    }

    /* renamed from: l */
    private void m18582l() {
        if (!this.f2638G && this.f2636E != null && !this.f2636E.m18526l()) {
            this.f2637F = true;
            C0907dn c0907dn = new C0907dn();
            this.f2636E.mo18519a(AnimationUtils.currentAnimationTimeMillis(), c0907dn);
            if (c0907dn == null || Double.isNaN(c0907dn.f2784e) || Double.isNaN(c0907dn.f2785f)) {
                return;
            }
            this.f2659u = (float) c0907dn.f2784e;
            this.f2660v = (float) c0907dn.f2785f;
        } else if (this.f2635D == null || this.f2635D.m18526l()) {
            this.f2659u = 1.0f;
            this.f2660v = 1.0f;
            this.f2637F = false;
        } else {
            this.f2638G = false;
            this.f2637F = true;
            this.f2644f = this.f2646h;
            this.f2645g = this.f2647i;
            C0907dn c0907dn2 = new C0907dn();
            this.f2635D.mo18519a(AnimationUtils.currentAnimationTimeMillis(), c0907dn2);
            if (c0907dn2 == null || Double.isNaN(c0907dn2.f2784e) || Double.isNaN(c0907dn2.f2785f)) {
                return;
            }
            this.f2659u = (float) c0907dn2.f2784e;
            this.f2660v = (float) c0907dn2.f2785f;
        }
    }

    /* renamed from: m */
    private void m18581m() {
        if (!this.f2662x || this.f2656r == null) {
            m18599b(m18583k());
        } else {
            m18593c(false);
        }
        m18601a(false);
    }

    /* renamed from: n */
    private void m18580n() {
        if (this.f2662x || this.f2656r == null) {
            m18599b(m18584j());
        } else {
            m18593c(true);
        }
        m18601a(true);
    }

    /* renamed from: o */
    private void m18579o() {
        Bitmap bitmap;
        if (this.f2656r != null && (bitmap = this.f2656r) != null) {
            bitmap.recycle();
            this.f2656r = null;
        }
        if (this.f2657s != null && !this.f2657s.isRecycled()) {
            this.f2657s.recycle();
            this.f2657s = null;
        }
        if (this.f2663y != null && !this.f2663y.isRecycled()) {
            this.f2663y.recycle();
        }
        if (this.f2664z != null && !this.f2664z.isRecycled()) {
            this.f2664z.recycle();
        }
        if (this.f2632A != null && !this.f2632A.isRecycled()) {
            this.f2632A.recycle();
        }
        if (this.f2633B == null || this.f2633B.isRecycled()) {
            return;
        }
        this.f2633B.recycle();
    }

    /* renamed from: p */
    private void m18578p() {
    }

    /* renamed from: q */
    private Rect m18577q() {
        return new Rect(this.f2658t.left, this.f2658t.top, this.f2658t.right, this.f2658t.top + m18575s());
    }

    /* renamed from: r */
    private Rect m18576r() {
        return new Rect(this.f2658t.left, this.f2658t.top, this.f2658t.right, this.f2658t.top + m18574t());
    }

    /* renamed from: s */
    private int m18575s() {
        if (this.f2663y == null || this.f2663y.isRecycled()) {
            return 0;
        }
        return this.f2663y.getHeight();
    }

    /* renamed from: t */
    private int m18574t() {
        if (this.f2632A == null || this.f2632A.isRecycled()) {
            return 0;
        }
        return this.f2632A.getHeight();
    }

    /* renamed from: a */
    public void m18612a(int i, int i2) {
        if (this.f2637F) {
            this.f2646h = i;
            this.f2647i = i2;
            return;
        }
        this.f2644f = i;
        this.f2645g = i2;
        this.f2646h = i;
        this.f2647i = i2;
    }

    /* renamed from: a */
    public void m18611a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m18594c(this.f2663y);
        this.f2663y = bitmap;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: a */
    public synchronized void mo18259a(AbstractC0881cr abstractC0881cr) {
        if (abstractC0881cr != null) {
            if (abstractC0881cr.getTitle() != null || abstractC0881cr.getSnippet() != null) {
                if (this.f2642d != null && !this.f2642d.getId().equals(abstractC0881cr.getId())) {
                    mo18241d();
                }
                if (this.f2641c != null) {
                    this.f2642d = abstractC0881cr;
                    abstractC0881cr.mo18687a(true);
                    setVisible(true);
                    m18611a(m18610a(this.f2641c.getInfoWindow(new Marker(this.f2642d))));
                    m18592d(m18610a(this.f2641c.getInfoWindowClick(new Marker(this.f2642d))));
                    m18591e(m18610a(this.f2641c.getOverturnInfoWindow(new Marker(this.f2642d))));
                    m18589f(m18610a(this.f2641c.getOverturnInfoWindowClick(new Marker(this.f2642d))));
                }
            }
        }
    }

    /* renamed from: a */
    public void m18607a(AMap.MultiPositionInfoWindowAdapter multiPositionInfoWindowAdapter) {
        this.f2641c = multiPositionInfoWindowAdapter;
    }

    /* renamed from: a */
    public void m18606a(FPoint fPoint) {
        this.f2648j = fPoint;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
    }

    /* renamed from: a */
    public void m18602a(GL10 gl10, MapProjection mapProjection, int i, int i2) {
        if (!this.f2651m || this.f2648j == null || this.f2656r == null) {
            return;
        }
        if (this.f2656r.isRecycled()) {
        }
        if (!this.f2634C && !this.f2656r.isRecycled()) {
            try {
                if (this.f2661w != 0) {
                    gl10.glDeleteTextures(1, new int[]{this.f2661w}, 0);
                } else {
                    this.f2661w = m18597b(gl10);
                }
                if (this.f2656r != null && !this.f2656r.isRecycled()) {
                    C0945eh.m18315b(gl10, this.f2661w, this.f2656r, false);
                    this.f2634C = true;
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "PopupOverlay", "drawMarker");
                th.printStackTrace();
                return;
            }
        }
        m18582l();
        if (!m18605a(mapProjection, i, i2)) {
            return;
        }
        gl10.glLoadIdentity();
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        gl10.glOrthof(0.0f, i, 0.0f, i2, 1.0f, -1.0f);
        m18603a(gl10, this.f2661w, this.f2649k, this.f2652n);
        if (!this.f2655q) {
            return;
        }
        this.f2655q = false;
        m18578p();
    }

    /* renamed from: a */
    public void m18601a(boolean z) {
        this.f2662x = z;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: a */
    public boolean mo18265a(MotionEvent motionEvent) {
        return this.f2651m && this.f2642d != null && C0945eh.m18353a(this.f2658t, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* renamed from: a */
    public boolean m18605a(MapProjection mapProjection, int i, int i2) {
        if (this.f2648j == null) {
            return false;
        }
        IPoint iPoint = new IPoint();
        mapProjection.map2Win(this.f2648j.f4728x, this.f2648j.f4729y, iPoint);
        int m18588g = m18588g();
        int m18586h = m18586h();
        int i3 = (int) ((iPoint.f4730x + this.f2644f) - (m18588g * this.f2653o));
        int i4 = (int) (iPoint.f4731y + this.f2645g + (m18586h * (1.0f - this.f2654p)));
        if (i3 - m18588g > i || i3 < (-m18588g) * 2 || i4 < (-m18586h) * 2 || i4 - m18586h > i2 || this.f2656r == null) {
            return false;
        }
        int width = this.f2656r.getWidth();
        int height = this.f2656r.getHeight();
        if (this.f2652n == null) {
            this.f2652n = C0945eh.m18327a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        }
        int i5 = (int) ((1.0f - this.f2659u) * 0.5d * width);
        this.f2658t.left = i3 + i5;
        this.f2658t.top = i4 - height;
        this.f2658t.right = width + i3;
        this.f2658t.bottom = i4;
        float[] fArr = {i3 + i5, i2 - i4, 0.0f, (i3 + width) - i5, i2 - i4, 0.0f, (i3 + width) - i5, (i2 - i4) + height, 0.0f, i3 + i5, (i2 - i4) + height, 0.0f};
        if (this.f2649k == null) {
            this.f2649k = C0945eh.m18327a(fArr);
        } else {
            this.f2649k = C0945eh.m18326a(fArr, this.f2649k);
        }
        return true;
    }

    /* renamed from: b */
    public synchronized void m18599b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled() && (this.f2656r == null || this.f2656r.hashCode() != bitmap.hashCode())) {
                    if (this.f2656r != null) {
                        if (this.f2663y == null && this.f2664z == null && this.f2632A == null && this.f2633B == null) {
                            m18594c(this.f2657s);
                            this.f2657s = this.f2656r;
                        } else if (!m18587g(this.f2656r)) {
                            m18594c(this.f2657s);
                            this.f2657s = this.f2656r;
                        }
                    }
                    this.f2634C = false;
                    this.f2656r = bitmap;
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: d */
    public synchronized void mo18241d() {
        setVisible(false);
        m18579o();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        if (this.f2643e) {
            try {
                remove();
                m18579o();
                if (this.f2652n != null) {
                    this.f2652n.clear();
                    this.f2652n = null;
                }
                if (this.f2649k != null) {
                    this.f2649k.clear();
                    this.f2649k = null;
                }
                this.f2648j = null;
                this.f2661w = 0;
            } catch (Throwable th) {
                C1007fo.m18012b(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0880cq
    /* renamed from: e */
    public void mo18237e() {
        try {
            if (this.f2642d == null || !this.f2642d.k()) {
                setVisible(false);
                return;
            }
            setVisible(true);
            Rect h = this.f2642d.h();
            int mo18684c = this.f2642d.mo18684c() + this.f2642d.mo18682e();
            int mo18681f = this.f2642d.mo18681f() + this.f2642d.mo18683d() + 2;
            if (m18585i()) {
                if (this.f2656r != null) {
                    return;
                }
                if (this.f2663y == null && this.f2632A == null) {
                    return;
                }
            }
            IMarkerAction iMarkerAction = this.f2642d.getIMarkerAction();
            if (iMarkerAction != null && !iMarkerAction.isInfoWindowEnable()) {
                setVisible(false);
                return;
            }
            setVisible(true);
            if (iMarkerAction == null || !iMarkerAction.isInfoWindowAutoOverturn()) {
                m18606a(this.f2642d.mo18696a());
                m18612a(mo18684c, mo18681f);
                m18580n();
                return;
            }
            Rect m18577q = m18577q();
            Rect m18576r = m18576r();
            if (m18590f()) {
                m18576r.offset(0, h.height() + m18577q.height() + 2);
            } else {
                m18577q.offset(0, -(h.height() + m18577q.height() + 2));
            }
            int mo17541a = this.f2639a.mo17541a(iMarkerAction, m18577q);
            int mo17541a2 = this.f2639a.mo17541a(iMarkerAction, m18576r);
            if (mo17541a <= 0 || (mo17541a2 != 0 && (mo17541a2 <= 0 || mo17541a >= mo17541a2))) {
                m18580n();
            } else {
                mo18681f = this.f2642d.mo18681f() + this.f2642d.mo18683d() + 2 + h.height() + m18576r.height();
                m18581m();
            }
            m18606a(this.f2642d.mo18696a());
            m18612a(mo18684c, mo18681f);
        } catch (Throwable th) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    /* renamed from: f */
    public boolean m18590f() {
        return this.f2662x;
    }

    /* renamed from: g */
    public int m18588g() {
        try {
            return this.f2656r.getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2650l == null) {
            this.f2650l = "PopupOverlay";
        }
        return this.f2650l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return 0.0f;
    }

    /* renamed from: h */
    public int m18586h() {
        try {
            return this.f2656r.getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    /* renamed from: i */
    public boolean m18585i() {
        return this.f2637F;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f2651m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAppearAnimation(Animation animation) {
        if (this.f2636E == null || !this.f2636E.equals(animation.glAnimation)) {
            this.f2635D = animation.glAnimation;
            return;
        }
        try {
            this.f2635D = animation.glAnimation.clone();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackColor(int i) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackEnable(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackScale(float f, float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowDisappearAnimation(Animation animation) {
        if (this.f2635D == null || !this.f2635D.equals(animation.glAnimation)) {
            this.f2636E = animation.glAnimation;
            return;
        }
        try {
            this.f2636E = animation.glAnimation.clone();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        if (!this.f2651m && z) {
            this.f2655q = true;
        }
        this.f2651m = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void startAnimation() {
    }
}
