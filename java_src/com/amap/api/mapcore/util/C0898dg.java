package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import com.amap.api.mapcore.util.AbstractC0911dq;
import com.amap.api.mapcore.util.AbstractC0934dz;
import com.amap.api.mapcore.util.C0929dw;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.dg */
/* loaded from: classes.dex */
public class C0898dg implements AbstractC0888cy {

    /* renamed from: g */
    private static int f2696g = 0;

    /* renamed from: a */
    private C1128v f2697a;

    /* renamed from: b */
    private TileProvider f2698b;

    /* renamed from: c */
    private Float f2699c;

    /* renamed from: d */
    private boolean f2700d;

    /* renamed from: e */
    private boolean f2701e;

    /* renamed from: f */
    private AbstractC1115l f2702f;

    /* renamed from: h */
    private int f2703h;

    /* renamed from: i */
    private int f2704i;

    /* renamed from: j */
    private int f2705j;

    /* renamed from: k */
    private C0932dx f2706k;

    /* renamed from: l */
    private CopyOnWriteArrayList<C0899a> f2707l;

    /* renamed from: m */
    private boolean f2708m;

    /* renamed from: n */
    private C0900b f2709n;

    /* renamed from: o */
    private final String f2710o;

    /* renamed from: p */
    private String f2711p;

    /* renamed from: q */
    private FloatBuffer f2712q;

    /* renamed from: com.amap.api.mapcore.util.dg$a */
    /* loaded from: classes.dex */
    public class C0899a implements Cloneable {

        /* renamed from: a */
        public int f2713a;

        /* renamed from: b */
        public int f2714b;

        /* renamed from: c */
        public int f2715c;

        /* renamed from: d */
        public int f2716d;

        /* renamed from: e */
        public IPoint f2717e;

        /* renamed from: f */
        public int f2718f;

        /* renamed from: g */
        public boolean f2719g;

        /* renamed from: h */
        public FloatBuffer f2720h;

        /* renamed from: i */
        public Bitmap f2721i;

        /* renamed from: j */
        public AbstractC0934dz.C0935a f2722j;

        /* renamed from: k */
        public int f2723k;

        public C0899a(int i, int i2, int i3, int i4) {
            this.f2718f = 0;
            this.f2719g = false;
            this.f2720h = null;
            this.f2721i = null;
            this.f2722j = null;
            this.f2723k = 0;
            this.f2713a = i;
            this.f2714b = i2;
            this.f2715c = i3;
            this.f2716d = i4;
        }

        public C0899a(C0899a c0899a) {
            this.f2718f = 0;
            this.f2719g = false;
            this.f2720h = null;
            this.f2721i = null;
            this.f2722j = null;
            this.f2723k = 0;
            this.f2713a = c0899a.f2713a;
            this.f2714b = c0899a.f2714b;
            this.f2715c = c0899a.f2715c;
            this.f2716d = c0899a.f2716d;
            this.f2717e = c0899a.f2717e;
            this.f2720h = c0899a.f2720h;
        }

        /* renamed from: a */
        public C0899a clone() {
            try {
                C0899a c0899a = (C0899a) super.clone();
                c0899a.f2713a = this.f2713a;
                c0899a.f2714b = this.f2714b;
                c0899a.f2715c = this.f2715c;
                c0899a.f2716d = this.f2716d;
                c0899a.f2717e = (IPoint) this.f2717e.clone();
                c0899a.f2720h = this.f2720h.asReadOnlyBuffer();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new C0899a(this);
        }

        /* renamed from: a */
        public void m18540a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    this.f2722j = null;
                    this.f2721i = C0945eh.m18354a(bitmap, C0945eh.m18360a(bitmap.getWidth()), C0945eh.m18360a(bitmap.getHeight()));
                    C0898dg.this.f2702f.setRunLowFrame(false);
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "TileOverlayDelegateImp", "setBitmap");
                    th.printStackTrace();
                    if (this.f2723k < 3) {
                        if (C0898dg.this.f2706k != null) {
                            C0898dg.this.f2706k.a(true, this);
                        }
                        this.f2723k++;
                    }
                }
            } else if (this.f2723k < 3) {
                if (C0898dg.this.f2706k != null) {
                    C0898dg.this.f2706k.a(true, this);
                }
                this.f2723k++;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }

        /* renamed from: b */
        public void m18539b() {
            try {
                AbstractC0934dz.m18421a(this);
                if (this.f2719g) {
                    C0898dg.this.f2697a.m17467a(this.f2718f);
                }
                this.f2719g = false;
                this.f2718f = 0;
                if (this.f2721i != null && !this.f2721i.isRecycled()) {
                    this.f2721i.recycle();
                }
                this.f2721i = null;
                if (this.f2720h != null) {
                    this.f2720h.clear();
                }
                this.f2720h = null;
                this.f2722j = null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0899a)) {
                return false;
            }
            C0899a c0899a = (C0899a) obj;
            return this.f2713a == c0899a.f2713a && this.f2714b == c0899a.f2714b && this.f2715c == c0899a.f2715c && this.f2716d == c0899a.f2716d;
        }

        public int hashCode() {
            return (this.f2713a * 7) + (this.f2714b * 11) + (this.f2715c * 13) + this.f2716d;
        }

        public String toString() {
            return this.f2713a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f2714b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f2715c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f2716d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.dg$b */
    /* loaded from: classes.dex */
    public class C0900b extends AbstractC0911dq<AbstractC1115l, Void, List<C0899a>> {

        /* renamed from: e */
        private int f2726e;

        /* renamed from: f */
        private boolean f2727f;

        public C0900b(boolean z) {
            this.f2727f = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public List<C0899a> mo18398a(AbstractC1115l... abstractC1115lArr) {
            try {
                int mapWidth = abstractC1115lArr[0].getMapWidth();
                int mapHeight = abstractC1115lArr[0].getMapHeight();
                this.f2726e = (int) abstractC1115lArr[0].mo17512o();
                if (mapWidth > 0 && mapHeight > 0) {
                    return C0898dg.this.m18556a(this.f2726e, mapWidth, mapHeight);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo18403a(List<C0899a> list) {
            if (list == null) {
                return;
            }
            try {
                if (list.size() <= 0) {
                    return;
                }
                C0898dg.this.m18550a(list, this.f2726e, this.f2727f);
                list.clear();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public C0898dg(TileOverlayOptions tileOverlayOptions, C1128v c1128v) {
        this.f2701e = false;
        this.f2703h = 256;
        this.f2704i = 256;
        this.f2705j = -1;
        this.f2707l = new CopyOnWriteArrayList<>();
        this.f2708m = false;
        this.f2709n = null;
        this.f2710o = "TileOverlay";
        this.f2711p = null;
        this.f2712q = null;
        this.f2697a = c1128v;
        this.f2698b = tileOverlayOptions.getTileProvider();
        this.f2703h = this.f2698b.getTileWidth();
        this.f2704i = this.f2698b.getTileHeight();
        int m18360a = C0945eh.m18360a(this.f2703h);
        int m18360a2 = C0945eh.m18360a(this.f2704i);
        float f = this.f2703h / m18360a;
        float f2 = this.f2704i / m18360a2;
        this.f2712q = C0945eh.m18327a(new float[]{0.0f, f2, f, f2, f, 0.0f, 0.0f, 0.0f});
        this.f2699c = Float.valueOf(tileOverlayOptions.getZIndex());
        this.f2700d = tileOverlayOptions.isVisible();
        this.f2711p = getId();
        this.f2702f = this.f2697a.m17468a();
        this.f2705j = Integer.valueOf(this.f2711p.substring("TileOverlay".length())).intValue();
        try {
            C0929dw.C0931a c0931a = new C0929dw.C0931a(this.f2697a.m17457e(), this.f2711p);
            c0931a.m18434a(tileOverlayOptions.getMemoryCacheEnabled());
            c0931a.m18432b(tileOverlayOptions.getDiskCacheEnabled());
            c0931a.m18436a(tileOverlayOptions.getMemCacheSize());
            c0931a.m18433b(tileOverlayOptions.getDiskCacheSize());
            String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
            if (diskCacheDir != null && !diskCacheDir.equals("")) {
                c0931a.m18435a(diskCacheDir);
            }
            this.f2706k = new C0932dx(this.f2697a.m17457e(), this.f2703h, this.f2704i);
            this.f2706k.m18430a(this.f2698b);
            this.f2706k.a(c0931a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mo18547a(true);
    }

    public C0898dg(TileOverlayOptions tileOverlayOptions, C1128v c1128v, boolean z) {
        this(tileOverlayOptions, c1128v);
        this.f2701e = z;
    }

    /* renamed from: a */
    private static String m18551a(String str) {
        f2696g++;
        return str + f2696g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<C0899a> m18556a(int i, int i2, int i3) {
        MapProjection mo17530c = this.f2702f.mo17530c();
        FPoint fPoint = new FPoint();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        mo17530c.win2Map(0, 0, fPoint);
        mo17530c.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
        int min = Math.min(Integer.MAX_VALUE, iPoint.f4730x);
        int max = Math.max(0, iPoint.f4730x);
        int min2 = Math.min(Integer.MAX_VALUE, iPoint.f4731y);
        int max2 = Math.max(0, iPoint.f4731y);
        mo17530c.win2Map(i2, 0, fPoint);
        mo17530c.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
        int min3 = Math.min(min, iPoint.f4730x);
        int max3 = Math.max(max, iPoint.f4730x);
        int min4 = Math.min(min2, iPoint.f4731y);
        int max4 = Math.max(max2, iPoint.f4731y);
        mo17530c.win2Map(0, i3, fPoint);
        mo17530c.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
        int min5 = Math.min(min3, iPoint.f4730x);
        int max5 = Math.max(max3, iPoint.f4730x);
        int min6 = Math.min(min4, iPoint.f4731y);
        int max6 = Math.max(max4, iPoint.f4731y);
        mo17530c.win2Map(i2, i3, fPoint);
        mo17530c.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
        int min7 = Math.min(min5, iPoint.f4730x);
        int max7 = Math.max(max5, iPoint.f4730x);
        int min8 = Math.min(min6, iPoint.f4731y);
        int max8 = Math.max(max6, iPoint.f4731y);
        int i4 = min7 - ((1 << (20 - i)) * this.f2703h);
        int i5 = min8 - ((1 << (20 - i)) * this.f2704i);
        mo17530c.getGeoCenter(iPoint2);
        int i6 = (iPoint2.f4730x >> (20 - i)) / this.f2703h;
        int i7 = (iPoint2.f4731y >> (20 - i)) / this.f2704i;
        int i8 = (i6 << (20 - i)) * this.f2703h;
        int i9 = (i7 << (20 - i)) * this.f2704i;
        C0899a c0899a = new C0899a(i6, i7, i, this.f2705j);
        c0899a.f2717e = new IPoint(i8, i9);
        ArrayList<C0899a> arrayList = new ArrayList<>();
        arrayList.add(c0899a);
        int i10 = 1;
        while (true) {
            int i11 = i10;
            boolean z = false;
            for (int i12 = i6 - i11; i12 <= i6 + i11; i12++) {
                int i13 = i7 + i11;
                IPoint iPoint3 = new IPoint((i12 << (20 - i)) * this.f2703h, (i13 << (20 - i)) * this.f2704i);
                if (iPoint3.f4730x < max7 && iPoint3.f4730x > i4 && iPoint3.f4731y < max8 && iPoint3.f4731y > i5) {
                    if (!z) {
                        z = true;
                    }
                    C0899a c0899a2 = new C0899a(i12, i13, i, this.f2705j);
                    c0899a2.f2717e = iPoint3;
                    arrayList.add(c0899a2);
                }
                int i14 = i7 - i11;
                IPoint iPoint4 = new IPoint((i12 << (20 - i)) * this.f2703h, (i14 << (20 - i)) * this.f2704i);
                if (iPoint4.f4730x < max7 && iPoint4.f4730x > i4 && iPoint4.f4731y < max8 && iPoint4.f4731y > i5) {
                    if (!z) {
                        z = true;
                    }
                    C0899a c0899a3 = new C0899a(i12, i14, i, this.f2705j);
                    c0899a3.f2717e = iPoint4;
                    arrayList.add(c0899a3);
                }
            }
            for (int i15 = (i7 + i11) - 1; i15 > i7 - i11; i15--) {
                int i16 = i6 + i11;
                IPoint iPoint5 = new IPoint((i16 << (20 - i)) * this.f2703h, (i15 << (20 - i)) * this.f2704i);
                if (iPoint5.f4730x < max7 && iPoint5.f4730x > i4 && iPoint5.f4731y < max8 && iPoint5.f4731y > i5) {
                    if (!z) {
                        z = true;
                    }
                    C0899a c0899a4 = new C0899a(i16, i15, i, this.f2705j);
                    c0899a4.f2717e = iPoint5;
                    arrayList.add(c0899a4);
                }
                int i17 = i6 - i11;
                IPoint iPoint6 = new IPoint((i17 << (20 - i)) * this.f2703h, (i15 << (20 - i)) * this.f2704i);
                if (iPoint6.f4730x < max7 && iPoint6.f4730x > i4 && iPoint6.f4731y < max8 && iPoint6.f4731y > i5) {
                    if (!z) {
                        z = true;
                    }
                    C0899a c0899a5 = new C0899a(i17, i15, i, this.f2705j);
                    c0899a5.f2717e = iPoint6;
                    arrayList.add(c0899a5);
                }
            }
            if (!z) {
                return arrayList;
            }
            i10 = i11 + 1;
        }
    }

    /* renamed from: a */
    private void m18548a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null) {
            return;
        }
        gl10.glEnable(3042);
        gl10.glTexEnvf(8960, 8704, 8448.0f);
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

    /* renamed from: a */
    private boolean m18555a(C0899a c0899a) {
        MapProjection mo17530c = this.f2702f.mo17530c();
        float f = c0899a.f2715c;
        int i = this.f2703h;
        int i2 = this.f2704i;
        int i3 = c0899a.f2717e.f4730x;
        int i4 = c0899a.f2717e.f4731y + ((1 << (20 - ((int) f))) * i2);
        FPoint fPoint = new FPoint();
        mo17530c.geo2Map(i3, i4, fPoint);
        FPoint fPoint2 = new FPoint();
        mo17530c.geo2Map(((1 << (20 - ((int) f))) * i) + i3, i4, fPoint2);
        FPoint fPoint3 = new FPoint();
        mo17530c.geo2Map((i * (1 << (20 - ((int) f)))) + i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint3);
        FPoint fPoint4 = new FPoint();
        mo17530c.geo2Map(i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint4);
        float[] fArr = {fPoint.f4728x, fPoint.f4729y, 0.0f, fPoint2.f4728x, fPoint2.f4729y, 0.0f, fPoint3.f4728x, fPoint3.f4729y, 0.0f, fPoint4.f4728x, fPoint4.f4729y, 0.0f};
        if (c0899a.f2720h == null) {
            c0899a.f2720h = C0945eh.m18327a(fArr);
        } else {
            c0899a.f2720h = C0945eh.m18326a(fArr, c0899a.f2720h);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m18550a(List<C0899a> list, int i, boolean z) {
        boolean z2;
        if (list != null && this.f2707l != null) {
            Iterator<C0899a> it2 = this.f2707l.iterator();
            while (it2.hasNext()) {
                C0899a next = it2.next();
                Iterator<C0899a> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    C0899a next2 = it3.next();
                    if (next.equals(next2) && next.f2719g) {
                        next2.f2719g = next.f2719g;
                        next2.f2718f = next.f2718f;
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    next.m18539b();
                }
            }
            this.f2707l.clear();
            if (i > ((int) this.f2702f.getMaxZoomLevel()) || i < ((int) this.f2702f.getMinZoomLevel())) {
                return false;
            }
            int size = list.size();
            if (size <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0899a c0899a = list.get(i2);
                if (c0899a != null && (!this.f2701e || (c0899a.f2715c >= 10 && !C0942ee.m18373a(c0899a.f2713a, c0899a.f2714b, c0899a.f2715c)))) {
                    this.f2707l.add(c0899a);
                    if (!c0899a.f2719g && this.f2706k != null) {
                        this.f2706k.a(z, c0899a);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0888cy
    /* renamed from: a */
    public void mo18557a() {
        if (this.f2706k != null) {
            this.f2706k.a(false);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0888cy
    /* renamed from: a */
    public void mo18549a(GL10 gl10) {
        if (this.f2707l == null || this.f2707l.size() == 0) {
            return;
        }
        Iterator<C0899a> it2 = this.f2707l.iterator();
        while (it2.hasNext()) {
            C0899a next = it2.next();
            if (!next.f2719g) {
                try {
                    IPoint iPoint = next.f2717e;
                    if (next.f2721i != null && !next.f2721i.isRecycled() && iPoint != null) {
                        next.f2718f = C0945eh.m18329a(gl10, next.f2721i);
                        if (next.f2718f != 0) {
                            next.f2719g = true;
                        }
                        next.f2721i = null;
                    }
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "TileOverlayDelegateImp", "drawTiles");
                }
            }
            if (next.f2719g) {
                m18555a(next);
                m18548a(gl10, next.f2718f, next.f2720h, this.f2712q);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0888cy
    /* renamed from: a */
    public void mo18547a(boolean z) {
        if (this.f2708m) {
            return;
        }
        if (this.f2709n != null && this.f2709n.a() == AbstractC0911dq.EnumC0920d.RUNNING) {
            this.f2709n.a(true);
        }
        this.f2709n = new C0900b(z);
        this.f2709n.c((Object[]) new AbstractC1115l[]{this.f2702f});
    }

    @Override // com.amap.api.mapcore.util.AbstractC0888cy
    /* renamed from: b */
    public void mo18546b() {
        if (this.f2707l == null || this.f2707l.size() == 0) {
            return;
        }
        Iterator<C0899a> it2 = this.f2707l.iterator();
        while (it2.hasNext()) {
            C0899a next = it2.next();
            next.f2719g = false;
            next.f2718f = 0;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0888cy
    /* renamed from: b */
    public void mo18544b(boolean z) {
        if (this.f2708m != z) {
            this.f2708m = z;
            if (this.f2706k == null) {
                return;
            }
            this.f2706k.b(z);
        }
    }

    /* renamed from: c */
    public void m18543c() {
        if (this.f2707l != null) {
            this.f2707l.clear();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void clearTileCache() {
        if (this.f2706k != null) {
            this.f2706k.f();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public String getId() {
        if (this.f2711p == null) {
            this.f2711p = m18551a("TileOverlay");
        }
        return this.f2711p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public float getZIndex() {
        return this.f2699c.floatValue();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean isVisible() {
        return this.f2700d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void remove() {
        if (this.f2709n != null && this.f2709n.a() == AbstractC0911dq.EnumC0920d.RUNNING) {
            this.f2709n.a(true);
        }
        Iterator<C0899a> it2 = this.f2707l.iterator();
        while (it2.hasNext()) {
            it2.next().m18539b();
        }
        this.f2707l.clear();
        if (this.f2706k != null) {
            this.f2706k.g();
        }
        this.f2697a.m17461b(this);
        this.f2702f.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setVisible(boolean z) {
        this.f2700d = z;
        this.f2702f.setRunLowFrame(false);
        if (z) {
            mo18547a(true);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setZIndex(float f) {
        this.f2699c = Float.valueOf(f);
        this.f2697a.m17459c();
    }
}
