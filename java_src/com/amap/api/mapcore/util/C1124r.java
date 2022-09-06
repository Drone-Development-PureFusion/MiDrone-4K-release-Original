package com.amap.api.mapcore.util;

import android.view.animation.AnimationUtils;
import com.fimi.soul.biz.camera.C2427e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: com.amap.api.mapcore.util.r */
/* loaded from: classes.dex */
public class C1124r {

    /* renamed from: a */
    public FloatBuffer f3513a;

    /* renamed from: b */
    public ShortBuffer f3514b;

    /* renamed from: i */
    private C0901dh f3521i;

    /* renamed from: e */
    private float f3517e = 0.0f;

    /* renamed from: f */
    private float f3518f = 0.0f;

    /* renamed from: g */
    private float f3519g = 0.0f;

    /* renamed from: h */
    private float f3520h = 0.7f;

    /* renamed from: c */
    float[] f3515c = {-1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: d */
    short[] f3516d = {0, 1, 3, 0, 3, 2};

    public C1124r() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f3516d.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f3514b = allocateDirect.asShortBuffer();
        this.f3514b.put(this.f3516d);
        this.f3514b.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.f3515c.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.f3513a = allocateDirect2.asFloatBuffer();
        this.f3513a.put(this.f3515c);
        this.f3513a.position(0);
    }

    /* renamed from: a */
    private void m17478a() {
        C0907dn c0907dn = new C0907dn();
        if (this.f3521i == null || this.f3521i.l()) {
            return;
        }
        this.f3521i.a(AnimationUtils.currentAnimationTimeMillis(), c0907dn);
        if (Double.isNaN(c0907dn.f2782c)) {
            return;
        }
        this.f3520h = (float) c0907dn.f2782c;
    }

    /* renamed from: a */
    public void m17477a(int i, int i2, int i3, int i4) {
        this.f3517e = i / 255.0f;
        this.f3518f = i2 / 255.0f;
        this.f3519g = i3 / 255.0f;
        this.f3520h = i4 / 255.0f;
    }

    /* renamed from: a */
    public void m17476a(C0901dh c0901dh) {
        if (this.f3521i != null && !this.f3521i.l()) {
            this.f3521i.b();
        }
        if (c0901dh == null) {
            return;
        }
        this.f3521i = c0901dh;
        this.f3521i.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m17475a(GL10 gl10, int i, int i2) {
        gl10.glPushMatrix();
        gl10.glScalef(i / 2.0f, i2 / 2.0f, 0.0f);
        gl10.glEnableClientState(32884);
        gl10.glDisable(2929);
        gl10.glDisable(3553);
        gl10.glEnable(3042);
        gl10.glBlendFunc(C2427e.f8184N, 771);
        m17478a();
        gl10.glColor4f(this.f3517e, this.f3518f, this.f3519g, this.f3520h);
        gl10.glVertexPointer(3, 5126, 0, this.f3513a);
        gl10.glDrawElements(4, this.f3516d.length, 5123, this.f3514b);
        gl10.glDisableClientState(32884);
        gl10.glDisable(3042);
        gl10.glPopMatrix();
        gl10.glFlush();
    }
}
