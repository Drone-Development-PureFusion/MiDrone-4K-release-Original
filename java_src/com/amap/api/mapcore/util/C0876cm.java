package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.cm */
/* loaded from: classes.dex */
public class C0876cm implements AbstractC0879cp {

    /* renamed from: b */
    private AbstractC1115l f2444b;

    /* renamed from: c */
    private BitmapDescriptor f2445c;

    /* renamed from: d */
    private LatLng f2446d;

    /* renamed from: e */
    private float f2447e;

    /* renamed from: f */
    private float f2448f;

    /* renamed from: g */
    private LatLngBounds f2449g;

    /* renamed from: h */
    private float f2450h;

    /* renamed from: i */
    private float f2451i;

    /* renamed from: n */
    private String f2456n;

    /* renamed from: p */
    private FloatBuffer f2458p;

    /* renamed from: q */
    private int f2459q;

    /* renamed from: j */
    private boolean f2452j = true;

    /* renamed from: k */
    private float f2453k = 0.0f;

    /* renamed from: l */
    private float f2454l = 0.5f;

    /* renamed from: m */
    private float f2455m = 0.5f;

    /* renamed from: o */
    private FloatBuffer f2457o = null;

    /* renamed from: r */
    private boolean f2460r = false;

    /* renamed from: s */
    private boolean f2461s = false;

    /* renamed from: a */
    FPointBounds f2443a = null;

    /* renamed from: t */
    private List<Float> f2462t = new ArrayList();

    /* renamed from: u */
    private List<Float> f2463u = new ArrayList();

    public C0876cm(AbstractC1115l abstractC1115l) {
        this.f2444b = abstractC1115l;
        try {
            this.f2456n = getId();
        } catch (RemoteException e) {
            C1007fo.m18012b(e, "GroundOverlayDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m18703a(DPoint dPoint, double d, double d2, double d3, double d4, FPoint fPoint) {
        double d5 = d - (this.f2454l * d3);
        double d6 = ((1.0f - this.f2455m) * d4) - d2;
        double d7 = (-this.f2450h) * 0.01745329251994329d;
        fPoint.f4728x = (float) (dPoint.f4726x + (Math.cos(d7) * d5) + (Math.sin(d7) * d6));
        fPoint.f4729y = (float) (((d6 * Math.cos(d7)) - (d5 * Math.sin(d7))) + dPoint.f4727y);
    }

    /* renamed from: a */
    private void m18702a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null) {
            return;
        }
        gl10.glEnable(3042);
        gl10.glTexEnvf(8960, 8704, 8448.0f);
        gl10.glBlendFunc(1, 771);
        gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f - this.f2453k);
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

    /* renamed from: e */
    private void m18701e() {
        if (this.f2446d == null) {
            return;
        }
        double cos = this.f2447e / ((6371000.79d * Math.cos(this.f2446d.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
        double d = this.f2448f / 111194.94043265979d;
        this.f2449g = new LatLngBounds(new LatLng(this.f2446d.latitude - ((1.0f - this.f2455m) * d), this.f2446d.longitude - (this.f2454l * cos)), new LatLng((d * this.f2455m) + this.f2446d.latitude, (cos * (1.0f - this.f2454l)) + this.f2446d.longitude));
        m18699g();
    }

    /* renamed from: f */
    private void m18700f() {
        if (this.f2449g == null) {
            return;
        }
        LatLng latLng = this.f2449g.southwest;
        LatLng latLng2 = this.f2449g.northeast;
        this.f2446d = new LatLng(latLng.latitude + ((1.0f - this.f2455m) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (this.f2454l * (latLng2.longitude - latLng.longitude)));
        this.f2447e = (float) (6371000.79d * Math.cos(this.f2446d.latitude * 0.01745329251994329d) * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
        this.f2448f = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
        m18699g();
    }

    /* renamed from: g */
    private void m18699g() {
        if (this.f2449g == null) {
            return;
        }
        float[] fArr = new float[12];
        FPoint fPoint = new FPoint();
        FPoint fPoint2 = new FPoint();
        FPoint fPoint3 = new FPoint();
        FPoint fPoint4 = new FPoint();
        this.f2444b.mo17556a(this.f2449g.southwest.latitude, this.f2449g.southwest.longitude, fPoint);
        this.f2444b.mo17556a(this.f2449g.southwest.latitude, this.f2449g.northeast.longitude, fPoint2);
        this.f2444b.mo17556a(this.f2449g.northeast.latitude, this.f2449g.northeast.longitude, fPoint3);
        this.f2444b.mo17556a(this.f2449g.northeast.latitude, this.f2449g.southwest.longitude, fPoint4);
        FPointBounds.Builder builder = new FPointBounds.Builder();
        builder.include(fPoint);
        builder.include(fPoint4);
        builder.include(fPoint2);
        builder.include(fPoint3);
        this.f2443a = builder.build();
        if (this.f2450h != 0.0f) {
            double d = fPoint2.f4728x - fPoint.f4728x;
            double d2 = fPoint2.f4729y - fPoint3.f4729y;
            DPoint dPoint = new DPoint();
            dPoint.f4726x = fPoint.f4728x + (this.f2454l * d);
            dPoint.f4727y = fPoint.f4729y - ((1.0f - this.f2455m) * d2);
            m18703a(dPoint, 0.0d, 0.0d, d, d2, fPoint);
            m18703a(dPoint, d, 0.0d, d, d2, fPoint2);
            m18703a(dPoint, d, d2, d, d2, fPoint3);
            m18703a(dPoint, 0.0d, d2, d, d2, fPoint4);
        }
        fArr[0] = fPoint.f4728x;
        fArr[1] = fPoint.f4729y;
        fArr[2] = 0.0f;
        fArr[3] = fPoint2.f4728x;
        fArr[4] = fPoint2.f4729y;
        fArr[5] = 0.0f;
        fArr[6] = fPoint3.f4728x;
        fArr[7] = fPoint3.f4729y;
        fArr[8] = 0.0f;
        fArr[9] = fPoint4.f4728x;
        fArr[10] = fPoint4.f4729y;
        fArr[11] = 0.0f;
        if (this.f2457o == null) {
            this.f2457o = C0945eh.m18327a(fArr);
        } else {
            this.f2457o = C0945eh.m18326a(fArr, this.f2457o);
        }
    }

    /* renamed from: h */
    private void m18698h() {
        if (this.f2445c == null) {
            return;
        }
        int width = this.f2445c.getWidth();
        int height = this.f2445c.getHeight();
        int height2 = this.f2445c.getBitmap().getHeight();
        float width2 = width / this.f2445c.getBitmap().getWidth();
        float f = height / height2;
        this.f2458p = C0945eh.m18327a(new float[]{0.0f, f, width2, f, width2, 0.0f, 0.0f, 0.0f});
    }

    /* renamed from: a */
    public void m18704a(float f, float f2) {
        this.f2454l = f;
        this.f2455m = f2;
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public void mo18604a(GL10 gl10) {
        if (this.f2452j) {
            if ((this.f2446d == null && this.f2449g == null) || this.f2445c == null) {
                return;
            }
            if (!this.f2460r) {
                Bitmap bitmap = this.f2445c.getBitmap();
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (this.f2459q == 0) {
                        int[] iArr = {0};
                        gl10.glGenTextures(1, iArr, 0);
                        this.f2459q = iArr[0];
                    } else {
                        gl10.glDeleteTextures(1, new int[]{this.f2459q}, 0);
                    }
                    C0945eh.m18315b(gl10, this.f2459q, bitmap, true);
                }
                this.f2460r = true;
            }
            if (this.f2447e == 0.0f && this.f2448f == 0.0f) {
                return;
            }
            m18702a(gl10, this.f2459q, this.f2457o, this.f2458p);
            this.f2461s = true;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: a */
    public boolean mo18613a() {
        if (this.f2443a != null) {
            FPoint[] mo17511p = this.f2444b.mo17511p();
            this.f2462t.clear();
            this.f2463u.clear();
            for (int i = 0; i < mo17511p.length; i++) {
                FPoint fPoint = mo17511p[i];
                this.f2462t.add(i, Float.valueOf(fPoint.f4728x));
                this.f2463u.add(i, Float.valueOf(fPoint.f4729y));
            }
            return C0945eh.m18349a(new C0941ed(this.f2443a.southwest.f4728x, this.f2443a.northeast.f4728x, this.f2443a.southwest.f4729y, this.f2443a.northeast.f4729y), new C0941ed(((Float) Collections.min(this.f2462t)).floatValue(), ((Float) Collections.max(this.f2462t)).floatValue(), ((Float) Collections.min(this.f2463u)).floatValue(), ((Float) Collections.max(this.f2463u)).floatValue()));
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: b */
    public boolean mo18600b() {
        this.f2461s = false;
        if (this.f2446d == null) {
            m18700f();
            return true;
        } else if (this.f2449g == null) {
            m18701e();
            return true;
        } else {
            m18699g();
            return true;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0883ct
    /* renamed from: c */
    public boolean mo18595c() {
        return this.f2461s;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0879cp
    /* renamed from: d */
    public void mo18697d() {
        this.f2460r = false;
        this.f2459q = 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        Bitmap bitmap;
        try {
            remove();
            if (this.f2445c != null && (bitmap = this.f2445c.getBitmap()) != null) {
                bitmap.recycle();
                this.f2445c = null;
            }
            if (this.f2458p != null) {
                this.f2458p.clear();
                this.f2458p = null;
            }
            if (this.f2457o != null) {
                this.f2457o.clear();
                this.f2457o = null;
            }
            this.f2446d = null;
            this.f2449g = null;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getBearing() {
        return this.f2450h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLngBounds getBounds() {
        return this.f2449g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getHeight() {
        return this.f2448f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.f2456n == null) {
            this.f2456n = C1097j.m17627a("GroundOverlay");
        }
        return this.f2456n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLng getPosition() {
        return this.f2446d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getTransparency() {
        return this.f2453k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getWidth() {
        return this.f2447e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.f2451i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f2452j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() {
        this.f2444b.mo17540a(getId());
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setBearing(float f) {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (!this.f2460r || Math.abs(this.f2450h - f2) <= 1.0E-7d) {
            this.f2450h = f2;
        } else {
            this.f2450h = f2;
            m18699g();
        }
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f) {
        if (f <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        if (!this.f2460r || this.f2447e == f) {
            this.f2447e = f;
            this.f2448f = f;
        } else {
            this.f2447e = f;
            this.f2448f = f;
            m18701e();
        }
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        if (!this.f2460r || this.f2447e == f || this.f2448f == f2) {
            this.f2447e = f;
            this.f2448f = f2;
        } else {
            this.f2447e = f;
            this.f2448f = f2;
            m18701e();
        }
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setImage(BitmapDescriptor bitmapDescriptor) {
        this.f2445c = bitmapDescriptor;
        m18698h();
        if (this.f2460r) {
            this.f2460r = false;
        }
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPosition(LatLng latLng) {
        this.f2446d = latLng;
        m18701e();
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.f2449g = latLngBounds;
        m18700f();
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setTransparency(float f) {
        if (f < 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Transparency must be in the range [0..1]");
        }
        this.f2453k = f;
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f2452j = z;
        this.f2444b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        this.f2451i = f;
        this.f2444b.mo17509r();
        this.f2444b.setRunLowFrame(false);
    }
}
