package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
@SuppressLint({"NewApi"})
/* renamed from: com.amap.api.mapcore.util.k */
/* loaded from: classes.dex */
public class TextureView$SurfaceTextureListenerC1100k extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    private static final C1111j f3436a = new C1111j();

    /* renamed from: b */
    private final WeakReference<TextureView$SurfaceTextureListenerC1100k> f3437b = new WeakReference<>(this);

    /* renamed from: c */
    private C1110i f3438c;

    /* renamed from: d */
    private GLSurfaceView.Renderer f3439d;

    /* renamed from: e */
    private boolean f3440e;

    /* renamed from: f */
    private AbstractC1106e f3441f;

    /* renamed from: g */
    private AbstractC1107f f3442g;

    /* renamed from: h */
    private AbstractC1108g f3443h;

    /* renamed from: i */
    private AbstractC1112k f3444i;

    /* renamed from: j */
    private int f3445j;

    /* renamed from: k */
    private int f3446k;

    /* renamed from: l */
    private boolean f3447l;

    /* renamed from: com.amap.api.mapcore.util.k$a */
    /* loaded from: classes.dex */
    private abstract class AbstractC1102a implements AbstractC1106e {

        /* renamed from: a */
        protected int[] f3448a;

        public AbstractC1102a(int[] iArr) {
            this.f3448a = m17603a(iArr);
        }

        /* renamed from: a */
        private int[] m17603a(int[] iArr) {
            if (TextureView$SurfaceTextureListenerC1100k.this.f3446k == 2 || TextureView$SurfaceTextureListenerC1100k.this.f3446k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                System.arraycopy(iArr, 0, iArr2, 0, length - 1);
                iArr2[length - 1] = 12352;
                if (TextureView$SurfaceTextureListenerC1100k.this.f3446k == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1106e
        /* renamed from: a */
        public EGLConfig mo17600a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f3448a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f3448a, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig mo17601a = mo17601a(egl10, eGLDisplay, eGLConfigArr);
            if (mo17601a != null) {
                return mo17601a;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        /* renamed from: a */
        abstract EGLConfig mo17601a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* renamed from: com.amap.api.mapcore.util.k$b */
    /* loaded from: classes.dex */
    private class C1103b extends AbstractC1102a {

        /* renamed from: c */
        protected int f3450c;

        /* renamed from: d */
        protected int f3451d;

        /* renamed from: e */
        protected int f3452e;

        /* renamed from: f */
        protected int f3453f;

        /* renamed from: g */
        protected int f3454g;

        /* renamed from: h */
        protected int f3455h;

        /* renamed from: j */
        private int[] f3457j = new int[1];

        public C1103b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f3450c = i;
            this.f3451d = i2;
            this.f3452e = i3;
            this.f3453f = i4;
            this.f3454g = i5;
            this.f3455h = i6;
        }

        /* renamed from: a */
        private int m17602a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f3457j) ? this.f3457j[0] : i2;
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1102a
        /* renamed from: a */
        public EGLConfig mo17601a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int m17602a = m17602a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int m17602a2 = m17602a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (m17602a >= this.f3454g && m17602a2 >= this.f3455h) {
                    int m17602a3 = m17602a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int m17602a4 = m17602a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int m17602a5 = m17602a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int m17602a6 = m17602a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (m17602a3 == this.f3450c && m17602a4 == this.f3451d && m17602a5 == this.f3452e && m17602a6 == this.f3453f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.k$c */
    /* loaded from: classes.dex */
    private class C1104c implements AbstractC1107f {

        /* renamed from: b */
        private int f3459b;

        private C1104c() {
            this.f3459b = 12440;
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1107f
        /* renamed from: a */
        public EGLContext mo17599a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f3459b, TextureView$SurfaceTextureListenerC1100k.this.f3446k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TextureView$SurfaceTextureListenerC1100k.this.f3446k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1107f
        /* renamed from: a */
        public void mo17598a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                C1109h.m17593a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.k$d */
    /* loaded from: classes.dex */
    private static class C1105d implements AbstractC1108g {
        private C1105d() {
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1108g
        /* renamed from: a */
        public EGLSurface mo17597a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC1100k.AbstractC1108g
        /* renamed from: a */
        public void mo17596a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.k$e */
    /* loaded from: classes.dex */
    public interface AbstractC1106e {
        /* renamed from: a */
        EGLConfig mo17600a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.amap.api.mapcore.util.k$f */
    /* loaded from: classes.dex */
    public interface AbstractC1107f {
        /* renamed from: a */
        EGLContext mo17599a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: a */
        void mo17598a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.amap.api.mapcore.util.k$g */
    /* loaded from: classes.dex */
    public interface AbstractC1108g {
        /* renamed from: a */
        EGLSurface mo17597a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: a */
        void mo17596a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.k$h */
    /* loaded from: classes.dex */
    public static class C1109h {

        /* renamed from: a */
        EGL10 f3460a;

        /* renamed from: b */
        EGLDisplay f3461b;

        /* renamed from: c */
        EGLSurface f3462c;

        /* renamed from: d */
        EGLConfig f3463d;

        /* renamed from: e */
        EGLContext f3464e;

        /* renamed from: f */
        private WeakReference<TextureView$SurfaceTextureListenerC1100k> f3465f;

        public C1109h(WeakReference<TextureView$SurfaceTextureListenerC1100k> weakReference) {
            this.f3465f = weakReference;
        }

        /* renamed from: a */
        private void m17594a(String str) {
            m17593a(str, this.f3460a.eglGetError());
        }

        /* renamed from: a */
        public static void m17593a(String str, int i) {
            throw new RuntimeException(m17590b(str, i));
        }

        /* renamed from: a */
        public static void m17592a(String str, String str2, int i) {
            Log.w(str, m17590b(str2, i));
        }

        /* renamed from: b */
        public static String m17590b(String str, int i) {
            return str + " failed: " + i;
        }

        /* renamed from: g */
        private void m17585g() {
            if (this.f3462c == null || this.f3462c == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f3460a.eglMakeCurrent(this.f3461b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3465f.get();
            if (textureView$SurfaceTextureListenerC1100k != null) {
                textureView$SurfaceTextureListenerC1100k.f3443h.mo17596a(this.f3460a, this.f3461b, this.f3462c);
            }
            this.f3462c = null;
        }

        /* renamed from: a */
        public void m17595a() {
            this.f3460a = (EGL10) EGLContext.getEGL();
            this.f3461b = this.f3460a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f3461b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f3460a.eglInitialize(this.f3461b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3465f.get();
            if (textureView$SurfaceTextureListenerC1100k == null) {
                this.f3463d = null;
                this.f3464e = null;
            } else {
                this.f3463d = textureView$SurfaceTextureListenerC1100k.f3441f.mo17600a(this.f3460a, this.f3461b);
                this.f3464e = textureView$SurfaceTextureListenerC1100k.f3442g.mo17599a(this.f3460a, this.f3461b, this.f3463d);
            }
            if (this.f3464e == null || this.f3464e == EGL10.EGL_NO_CONTEXT) {
                this.f3464e = null;
                m17594a("createContext");
            }
            this.f3462c = null;
        }

        /* renamed from: b */
        public boolean m17591b() {
            if (this.f3460a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f3461b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f3463d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            m17585g();
            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3465f.get();
            if (textureView$SurfaceTextureListenerC1100k != null) {
                this.f3462c = textureView$SurfaceTextureListenerC1100k.f3443h.mo17597a(this.f3460a, this.f3461b, this.f3463d, textureView$SurfaceTextureListenerC1100k.getSurfaceTexture());
            } else {
                this.f3462c = null;
            }
            if (this.f3462c == null || this.f3462c == EGL10.EGL_NO_SURFACE) {
                if (this.f3460a.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (this.f3460a.eglMakeCurrent(this.f3461b, this.f3462c, this.f3462c, this.f3464e)) {
                return true;
            } else {
                m17592a("EGLHelper", "eglMakeCurrent", this.f3460a.eglGetError());
                return false;
            }
        }

        /* renamed from: c */
        GL m17589c() {
            GL gl = this.f3464e.getGL();
            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3465f.get();
            if (textureView$SurfaceTextureListenerC1100k != null) {
                if (textureView$SurfaceTextureListenerC1100k.f3444i != null) {
                    gl = textureView$SurfaceTextureListenerC1100k.f3444i.m17560a(gl);
                }
                if ((textureView$SurfaceTextureListenerC1100k.f3445j & 3) == 0) {
                    return gl;
                }
                int i = 0;
                if ((textureView$SurfaceTextureListenerC1100k.f3445j & 1) != 0) {
                    i = 1;
                }
                return GLDebugHelper.wrap(gl, i, (textureView$SurfaceTextureListenerC1100k.f3445j & 2) != 0 ? new C1113l() : null);
            }
            return gl;
        }

        /* renamed from: d */
        public int m17588d() {
            if (!this.f3460a.eglSwapBuffers(this.f3461b, this.f3462c)) {
                return this.f3460a.eglGetError();
            }
            return 12288;
        }

        /* renamed from: e */
        public void m17587e() {
            m17585g();
        }

        /* renamed from: f */
        public void m17586f() {
            if (this.f3464e != null) {
                TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3465f.get();
                if (textureView$SurfaceTextureListenerC1100k != null) {
                    textureView$SurfaceTextureListenerC1100k.f3442g.mo17598a(this.f3460a, this.f3461b, this.f3464e);
                }
                this.f3464e = null;
            }
            if (this.f3461b != null) {
                this.f3460a.eglTerminate(this.f3461b);
                this.f3461b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.k$i */
    /* loaded from: classes.dex */
    public static class C1110i extends Thread {

        /* renamed from: a */
        private boolean f3466a;

        /* renamed from: b */
        private boolean f3467b;

        /* renamed from: c */
        private boolean f3468c;

        /* renamed from: d */
        private boolean f3469d;

        /* renamed from: e */
        private boolean f3470e;

        /* renamed from: f */
        private boolean f3471f;

        /* renamed from: g */
        private boolean f3472g;

        /* renamed from: h */
        private boolean f3473h;

        /* renamed from: i */
        private boolean f3474i;

        /* renamed from: j */
        private boolean f3475j;

        /* renamed from: k */
        private boolean f3476k;

        /* renamed from: p */
        private boolean f3481p;

        /* renamed from: s */
        private C1109h f3484s;

        /* renamed from: t */
        private WeakReference<TextureView$SurfaceTextureListenerC1100k> f3485t;

        /* renamed from: q */
        private ArrayList<Runnable> f3482q = new ArrayList<>();

        /* renamed from: r */
        private boolean f3483r = true;

        /* renamed from: l */
        private int f3477l = 0;

        /* renamed from: m */
        private int f3478m = 0;

        /* renamed from: o */
        private boolean f3480o = true;

        /* renamed from: n */
        private int f3479n = 1;

        C1110i(WeakReference<TextureView$SurfaceTextureListenerC1100k> weakReference) {
            this.f3485t = weakReference;
        }

        /* renamed from: j */
        private void m17571j() {
            if (this.f3474i) {
                this.f3474i = false;
                this.f3484s.m17587e();
            }
        }

        /* renamed from: k */
        private void m17570k() {
            if (this.f3473h) {
                this.f3484s.m17586f();
                this.f3473h = false;
                TextureView$SurfaceTextureListenerC1100k.f3436a.m17561c(this);
            }
        }

        /* renamed from: l */
        private void m17569l() {
            boolean z;
            int i;
            Runnable remove;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i2;
            boolean z8;
            GL10 gl10;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int i3;
            int i4;
            this.f3484s = new C1109h(this.f3485t);
            this.f3473h = false;
            this.f3474i = false;
            boolean z15 = false;
            GL10 gl102 = null;
            int i5 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            Runnable runnable = null;
            int i6 = 0;
            boolean z22 = false;
            while (true) {
                try {
                    synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                        while (!this.f3466a) {
                            if (!this.f3482q.isEmpty()) {
                                z = z22;
                                i = i6;
                                remove = this.f3482q.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            } else {
                                if (this.f3469d != this.f3468c) {
                                    boolean z23 = this.f3468c;
                                    this.f3469d = this.f3468c;
                                    TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.f3476k) {
                                    m17571j();
                                    m17570k();
                                    this.f3476k = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    m17571j();
                                    m17570k();
                                    z19 = false;
                                }
                                if (z9 && this.f3474i) {
                                    m17571j();
                                }
                                if (z9 && this.f3473h) {
                                    TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k = this.f3485t.get();
                                    if (!(textureView$SurfaceTextureListenerC1100k == null ? false : textureView$SurfaceTextureListenerC1100k.f3447l) || TextureView$SurfaceTextureListenerC1100k.f3436a.m17567a()) {
                                        m17570k();
                                    }
                                }
                                if (z9 && TextureView$SurfaceTextureListenerC1100k.f3436a.m17564b()) {
                                    this.f3484s.m17586f();
                                }
                                if (!this.f3470e && !this.f3472g) {
                                    if (this.f3474i) {
                                        m17571j();
                                    }
                                    this.f3472g = true;
                                    this.f3471f = false;
                                    TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                }
                                if (this.f3470e && this.f3472g) {
                                    this.f3472g = false;
                                    TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.f3481p = true;
                                    TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                }
                                if (m17568m()) {
                                    if (!this.f3473h) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TextureView$SurfaceTextureListenerC1100k.f3436a.m17563b(this)) {
                                            try {
                                                this.f3484s.m17595a();
                                                this.f3473h = true;
                                                z15 = true;
                                                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                            } catch (RuntimeException e) {
                                                TextureView$SurfaceTextureListenerC1100k.f3436a.m17561c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.f3473h || this.f3474i) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.f3474i = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.f3474i) {
                                        if (this.f3483r) {
                                            z14 = true;
                                            i4 = this.f3477l;
                                            i3 = this.f3478m;
                                            z13 = true;
                                            z12 = true;
                                            this.f3483r = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.f3480o = false;
                                        TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                        z3 = z11;
                                        z6 = z13;
                                        remove = runnable;
                                        z = z22;
                                        i = i4;
                                        int i8 = i3;
                                        z2 = z12;
                                        z4 = z19;
                                        z5 = z14;
                                        z7 = z16;
                                        i2 = i8;
                                    } else {
                                        z20 = z11;
                                        z18 = z10;
                                    }
                                }
                                TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                            }
                        }
                        synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                            m17571j();
                            m17570k();
                        }
                        return;
                    }
                    if (remove != null) {
                        remove.run();
                        i5 = i2;
                        z16 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        boolean z24 = z;
                        runnable = null;
                        i6 = i;
                        z22 = z24;
                    } else {
                        if (!z2) {
                            z8 = z2;
                        } else if (this.f3484s.m17591b()) {
                            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                                this.f3475j = true;
                                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                                this.f3475j = true;
                                this.f3471f = true;
                                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                            }
                            i5 = i2;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            boolean z25 = z;
                            runnable = remove;
                            i6 = i;
                            z22 = z25;
                        }
                        if (z3) {
                            GL10 gl103 = (GL10) this.f3484s.m17589c();
                            TextureView$SurfaceTextureListenerC1100k.f3436a.m17565a(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k2 = this.f3485t.get();
                            if (textureView$SurfaceTextureListenerC1100k2 != null) {
                                textureView$SurfaceTextureListenerC1100k2.f3439d.onSurfaceCreated(gl10, this.f3484s.f3463d);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k3 = this.f3485t.get();
                            if (textureView$SurfaceTextureListenerC1100k3 != null) {
                                textureView$SurfaceTextureListenerC1100k3.f3439d.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TextureView$SurfaceTextureListenerC1100k textureView$SurfaceTextureListenerC1100k4 = this.f3485t.get();
                        if (textureView$SurfaceTextureListenerC1100k4 != null) {
                            textureView$SurfaceTextureListenerC1100k4.f3439d.onDrawFrame(gl10);
                        }
                        int m17588d = this.f3484s.m17588d();
                        switch (m17588d) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                C1109h.m17592a("GLThread", "eglSwapBuffers", m17588d);
                                synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                                    this.f3471f = true;
                                    TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                                    break;
                                }
                        }
                        boolean z26 = z6 ? true : z;
                        runnable = remove;
                        gl102 = gl10;
                        i6 = i;
                        z22 = z26;
                        boolean z27 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z8;
                        i5 = i2;
                        z16 = z27;
                    }
                } catch (Throwable th) {
                    synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                        m17571j();
                        m17570k();
                        throw th;
                    }
                }
            }
        }

        /* renamed from: m */
        private boolean m17568m() {
            return !this.f3469d && this.f3470e && !this.f3471f && this.f3477l > 0 && this.f3478m > 0 && (this.f3480o || this.f3479n == 1);
        }

        /* renamed from: a */
        public void m17583a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3479n = i;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
            }
        }

        /* renamed from: a */
        public void m17582a(int i, int i2) {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3477l = i;
                this.f3478m = i2;
                this.f3483r = true;
                this.f3480o = true;
                this.f3481p = false;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (!this.f3467b && !this.f3469d && !this.f3481p && m17584a()) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: a */
        public void m17580a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3482q.add(runnable);
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
            }
        }

        /* renamed from: a */
        public boolean m17584a() {
            return this.f3473h && this.f3474i && m17568m();
        }

        /* renamed from: b */
        public int m17579b() {
            int i;
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                i = this.f3479n;
            }
            return i;
        }

        /* renamed from: c */
        public void m17578c() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3480o = true;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
            }
        }

        /* renamed from: d */
        public void m17577d() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3470e = true;
                this.f3475j = false;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (this.f3472g && !this.f3475j && !this.f3467b) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: e */
        public void m17576e() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3470e = false;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (!this.f3472g && !this.f3467b) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: f */
        public void m17575f() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3468c = true;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (!this.f3467b && !this.f3469d) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: g */
        public void m17574g() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3468c = false;
                this.f3480o = true;
                this.f3481p = false;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (!this.f3467b && this.f3469d && !this.f3481p) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: h */
        public void m17573h() {
            synchronized (TextureView$SurfaceTextureListenerC1100k.f3436a) {
                this.f3466a = true;
                TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
                while (!this.f3467b) {
                    try {
                        TextureView$SurfaceTextureListenerC1100k.f3436a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: i */
        public void m17572i() {
            this.f3476k = true;
            TextureView$SurfaceTextureListenerC1100k.f3436a.notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                m17569l();
            } catch (InterruptedException e) {
            } finally {
                TextureView$SurfaceTextureListenerC1100k.f3436a.m17566a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.k$j */
    /* loaded from: classes.dex */
    public static class C1111j {

        /* renamed from: a */
        private static String f3486a = "GLThreadManager";

        /* renamed from: b */
        private boolean f3487b;

        /* renamed from: c */
        private int f3488c;

        /* renamed from: d */
        private boolean f3489d;

        /* renamed from: e */
        private boolean f3490e;

        /* renamed from: f */
        private boolean f3491f;

        /* renamed from: g */
        private C1110i f3492g;

        private C1111j() {
        }

        /* renamed from: c */
        private void m17562c() {
            if (!this.f3487b) {
                this.f3488c = 131072;
                if (this.f3488c >= 131072) {
                    this.f3490e = true;
                }
                this.f3487b = true;
            }
        }

        /* renamed from: a */
        public synchronized void m17566a(C1110i c1110i) {
            c1110i.f3467b = true;
            if (this.f3492g == c1110i) {
                this.f3492g = null;
            }
            notifyAll();
        }

        /* renamed from: a */
        public synchronized void m17565a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                if (!this.f3489d) {
                    m17562c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f3488c < 131072) {
                        this.f3490e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.f3490e) {
                        z = false;
                    }
                    this.f3491f = z;
                    this.f3489d = true;
                }
            }
        }

        /* renamed from: a */
        public synchronized boolean m17567a() {
            return this.f3491f;
        }

        /* renamed from: b */
        public synchronized boolean m17564b() {
            m17562c();
            return !this.f3490e;
        }

        /* renamed from: b */
        public boolean m17563b(C1110i c1110i) {
            if (this.f3492g == c1110i || this.f3492g == null) {
                this.f3492g = c1110i;
                notifyAll();
                return true;
            }
            m17562c();
            if (this.f3490e) {
                return true;
            }
            if (this.f3492g != null) {
                this.f3492g.m17572i();
            }
            return false;
        }

        /* renamed from: c */
        public void m17561c(C1110i c1110i) {
            if (this.f3492g == c1110i) {
                this.f3492g = null;
            }
            notifyAll();
        }
    }

    /* renamed from: com.amap.api.mapcore.util.k$k */
    /* loaded from: classes.dex */
    public interface AbstractC1112k {
        /* renamed from: a */
        GL m17560a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.k$l */
    /* loaded from: classes.dex */
    public static class C1113l extends Writer {

        /* renamed from: a */
        private StringBuilder f3493a = new StringBuilder();

        C1113l() {
        }

        /* renamed from: a */
        private void m17559a() {
            if (this.f3493a.length() > 0) {
                Log.v("GLSurfaceView", this.f3493a.toString());
                this.f3493a.delete(0, this.f3493a.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m17559a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            m17559a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    m17559a();
                } else {
                    this.f3493a.append(c);
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.k$m */
    /* loaded from: classes.dex */
    private class C1114m extends C1103b {
        public C1114m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public TextureView$SurfaceTextureListenerC1100k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17616a();
    }

    /* renamed from: a */
    private void m17616a() {
        setSurfaceTextureListener(this);
    }

    /* renamed from: e */
    private void m17608e() {
        if (this.f3438c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* renamed from: b */
    public void m17614b() {
        this.f3438c.m17575f();
    }

    /* renamed from: c */
    public void m17612c() {
        this.f3438c.m17574g();
    }

    protected void finalize() {
        try {
            if (this.f3438c != null) {
                this.f3438c.m17573h();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3440e && this.f3439d != null) {
            int m17579b = this.f3438c != null ? this.f3438c.m17579b() : 1;
            this.f3438c = new C1110i(this.f3437b);
            if (m17579b != 1) {
                this.f3438c.m17583a(m17579b);
            }
            this.f3438c.start();
        }
        this.f3440e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (this.f3438c != null) {
            this.f3438c.m17573h();
        }
        this.f3440e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i3 - i, i4 - i2);
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3438c.m17577d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f3438c.m17576e();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3438c.m17582a(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f3438c.m17580a(runnable);
    }

    public void requestRender() {
        this.f3438c.m17578c();
    }

    public void setRenderMode(int i) {
        this.f3438c.m17583a(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        m17608e();
        if (this.f3441f == null) {
            this.f3441f = new C1114m(true);
        }
        if (this.f3442g == null) {
            this.f3442g = new C1104c();
        }
        if (this.f3443h == null) {
            this.f3443h = new C1105d();
        }
        this.f3439d = renderer;
        this.f3438c = new C1110i(this.f3437b);
        this.f3438c.start();
    }
}
