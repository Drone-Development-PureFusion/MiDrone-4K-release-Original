package com.p118d.p119a.p127b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.p118d.p119a.p127b.C1904c;
import com.p118d.p119a.p127b.p128a.C1889b;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1892d;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p127b.p130b.AbstractC1902b;
import com.p118d.p119a.p127b.p130b.C1903c;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import com.p118d.p119a.p127b.p134f.AbstractC1932a;
import com.p118d.p119a.p127b.p134f.AbstractC1933b;
import com.p118d.p119a.p136c.C1947c;
import com.p118d.p119a.p136c.C1949d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.d.a.b.h */
/* loaded from: classes.dex */
public final class RunnableC1938h implements C1947c.AbstractC1948a, Runnable {

    /* renamed from: f */
    private static final String f6885f = "ImageLoader is paused. Waiting...  [%s]";

    /* renamed from: g */
    private static final String f6886g = ".. Resume loading [%s]";

    /* renamed from: h */
    private static final String f6887h = "Delay %d ms before loading...  [%s]";

    /* renamed from: i */
    private static final String f6888i = "Start display image task [%s]";

    /* renamed from: j */
    private static final String f6889j = "Image already is loading. Waiting... [%s]";

    /* renamed from: k */
    private static final String f6890k = "...Get cached bitmap from memory after waiting. [%s]";

    /* renamed from: l */
    private static final String f6891l = "Load image from network [%s]";

    /* renamed from: m */
    private static final String f6892m = "Load image from disk cache [%s]";

    /* renamed from: n */
    private static final String f6893n = "Resize image in disk cache [%s]";

    /* renamed from: o */
    private static final String f6894o = "PreProcess image before caching in memory [%s]";

    /* renamed from: p */
    private static final String f6895p = "PostProcess image before displaying [%s]";

    /* renamed from: q */
    private static final String f6896q = "Cache image in memory [%s]";

    /* renamed from: r */
    private static final String f6897r = "Cache image on disk [%s]";

    /* renamed from: s */
    private static final String f6898s = "Process image before cache on disk [%s]";

    /* renamed from: t */
    private static final String f6899t = "ImageAware is reused for another image. Task is cancelled. [%s]";

    /* renamed from: u */
    private static final String f6900u = "ImageAware was collected by GC. Task is cancelled. [%s]";

    /* renamed from: v */
    private static final String f6901v = "Task was interrupted [%s]";

    /* renamed from: w */
    private static final String f6902w = "No stream for image [%s]";

    /* renamed from: x */
    private static final String f6903x = "Pre-processor returned null [%s]";

    /* renamed from: y */
    private static final String f6904y = "Post-processor returned null [%s]";

    /* renamed from: z */
    private static final String f6905z = "Bitmap processor for disk cache returned null [%s]";

    /* renamed from: A */
    private final C1930f f6906A;

    /* renamed from: B */
    private final C1936g f6907B;

    /* renamed from: C */
    private final Handler f6908C;

    /* renamed from: D */
    private final C1921e f6909D;

    /* renamed from: E */
    private final AbstractC1919b f6910E;

    /* renamed from: F */
    private final AbstractC1919b f6911F;

    /* renamed from: G */
    private final AbstractC1919b f6912G;

    /* renamed from: H */
    private final AbstractC1902b f6913H;

    /* renamed from: I */
    private final String f6914I;

    /* renamed from: J */
    private final C1893e f6915J;

    /* renamed from: K */
    private final boolean f6916K;

    /* renamed from: L */
    private EnumC1894f f6917L = EnumC1894f.NETWORK;

    /* renamed from: a */
    final String f6918a;

    /* renamed from: b */
    final AbstractC1926a f6919b;

    /* renamed from: c */
    final C1904c f6920c;

    /* renamed from: d */
    final AbstractC1932a f6921d;

    /* renamed from: e */
    final AbstractC1933b f6922e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.d.a.b.h$a */
    /* loaded from: classes.dex */
    public class C1942a extends Exception {
        C1942a() {
        }
    }

    public RunnableC1938h(C1930f c1930f, C1936g c1936g, Handler handler) {
        this.f6906A = c1930f;
        this.f6907B = c1936g;
        this.f6908C = handler;
        this.f6909D = c1930f.f6861a;
        this.f6910E = this.f6909D.f6815p;
        this.f6911F = this.f6909D.f6818s;
        this.f6912G = this.f6909D.f6819t;
        this.f6913H = this.f6909D.f6816q;
        this.f6918a = c1936g.f6877a;
        this.f6914I = c1936g.f6878b;
        this.f6919b = c1936g.f6879c;
        this.f6915J = c1936g.f6880d;
        this.f6920c = c1936g.f6881e;
        this.f6921d = c1936g.f6882f;
        this.f6922e = c1936g.f6883g;
        this.f6916K = this.f6920c.m14087s();
    }

    /* renamed from: a */
    private Bitmap m13887a(String str) {
        return this.f6913H.mo14140a(new C1903c(this.f6914I, str, this.f6918a, this.f6915J, this.f6919b.mo13922c(), m13878h(), this.f6920c));
    }

    /* renamed from: a */
    private void m13890a(final C1889b.EnumC1890a enumC1890a, final Throwable th) {
        if (this.f6916K || m13870p() || m13876j()) {
            return;
        }
        m13888a(new Runnable() { // from class: com.d.a.b.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (RunnableC1938h.this.f6920c.m14120c()) {
                    RunnableC1938h.this.f6919b.mo13925a(RunnableC1938h.this.f6920c.m14119c(RunnableC1938h.this.f6909D.f6800a));
                }
                RunnableC1938h.this.f6921d.mo13894a(RunnableC1938h.this.f6918a, RunnableC1938h.this.f6919b.mo13921d(), new C1889b(enumC1890a, th));
            }
        }, false, this.f6908C, this.f6906A);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m13888a(Runnable runnable, boolean z, Handler handler, C1930f c1930f) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            c1930f.m13912a(runnable);
        } else {
            handler.post(runnable);
        }
    }

    /* renamed from: b */
    private boolean m13886b() {
        AtomicBoolean m13903d = this.f6906A.m13903d();
        if (m13903d.get()) {
            synchronized (this.f6906A.m13902e()) {
                if (m13903d.get()) {
                    C1949d.m13854a(f6885f, this.f6914I);
                    try {
                        this.f6906A.m13902e().wait();
                        C1949d.m13854a(f6886g, this.f6914I);
                    } catch (InterruptedException e) {
                        C1949d.m13846d(f6901v, this.f6914I);
                        return true;
                    }
                }
            }
        }
        return m13876j();
    }

    /* renamed from: b */
    private boolean m13885b(int i, int i2) {
        File mo14221a = this.f6909D.f6814o.mo14221a(this.f6918a);
        if (mo14221a != null && mo14221a.exists()) {
            Bitmap mo14140a = this.f6913H.mo14140a(new C1903c(this.f6914I, AbstractC1919b.EnumC1920a.FILE.m13981b(mo14221a.getAbsolutePath()), this.f6918a, new C1893e(i, i2), EnumC1896h.FIT_INSIDE, m13878h(), new C1904c.C1906a().m14075a(this.f6920c).m14078a(EnumC1892d.IN_SAMPLE_INT).m14060d()));
            if (mo14140a != null && this.f6909D.f6805f != null) {
                C1949d.m13854a(f6898s, this.f6914I);
                mo14140a = this.f6909D.f6805f.m13892a(mo14140a);
                if (mo14140a == null) {
                    C1949d.m13846d(f6905z, this.f6914I);
                }
            }
            Bitmap bitmap = mo14140a;
            if (bitmap != null) {
                boolean mo14220a = this.f6909D.f6814o.mo14220a(this.f6918a, bitmap);
                bitmap.recycle();
                return mo14220a;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m13884c() {
        if (this.f6920c.m14113f()) {
            C1949d.m13854a(f6887h, Integer.valueOf(this.f6920c.m14101l()), this.f6914I);
            try {
                Thread.sleep(this.f6920c.m14101l());
                return m13876j();
            } catch (InterruptedException e) {
                C1949d.m13846d(f6901v, this.f6914I);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m13883c(final int i, final int i2) {
        if (m13870p() || m13876j()) {
            return false;
        }
        if (this.f6922e != null) {
            m13888a(new Runnable() { // from class: com.d.a.b.h.1
                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1938h.this.f6922e.m13897a(RunnableC1938h.this.f6918a, RunnableC1938h.this.f6919b.mo13921d(), i, i2);
                }
            }, false, this.f6908C, this.f6906A);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004b, code lost:
        if (r0.getHeight() > 0) goto L24;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap m13882d() {
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e;
        IOException e2;
        File mo14221a;
        try {
            try {
                File mo14221a2 = this.f6909D.f6814o.mo14221a(this.f6918a);
                if (mo14221a2 == null || !mo14221a2.exists() || mo14221a2.length() <= 0) {
                    bitmap = null;
                } else {
                    C1949d.m13854a(f6892m, this.f6914I);
                    this.f6917L = EnumC1894f.DISC_CACHE;
                    m13877i();
                    bitmap = m13887a(AbstractC1919b.EnumC1920a.FILE.m13981b(mo14221a2.getAbsolutePath()));
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0) {
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        C1949d.m13853a(e2);
                        m13890a(C1889b.EnumC1890a.IO_ERROR, e2);
                        return bitmap;
                    } catch (IllegalStateException e4) {
                        m13890a(C1889b.EnumC1890a.NETWORK_DENIED, (Throwable) null);
                        return bitmap;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        C1949d.m13853a(e);
                        m13890a(C1889b.EnumC1890a.OUT_OF_MEMORY, e);
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        C1949d.m13853a(th);
                        m13890a(C1889b.EnumC1890a.UNKNOWN, th);
                        return bitmap;
                    }
                }
                C1949d.m13854a(f6891l, this.f6914I);
                this.f6917L = EnumC1894f.NETWORK;
                String str = this.f6918a;
                if (this.f6920c.m14107i() && m13881e() && (mo14221a = this.f6909D.f6814o.mo14221a(this.f6918a)) != null) {
                    str = AbstractC1919b.EnumC1920a.FILE.m13981b(mo14221a.getAbsolutePath());
                }
                m13877i();
                bitmap = m13887a(str);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    m13890a(C1889b.EnumC1890a.DECODING_ERROR, (Throwable) null);
                }
            } catch (C1942a e6) {
                throw e6;
            }
        } catch (IOException e7) {
            bitmap = null;
            e2 = e7;
        } catch (IllegalStateException e8) {
            bitmap = null;
        } catch (OutOfMemoryError e9) {
            bitmap = null;
            e = e9;
        } catch (Throwable th3) {
            bitmap = null;
            th = th3;
        }
        return bitmap;
    }

    /* renamed from: e */
    private boolean m13881e() {
        C1949d.m13854a(f6897r, this.f6914I);
        try {
            boolean m13880f = m13880f();
            if (!m13880f) {
                return m13880f;
            }
            int i = this.f6909D.f6803d;
            int i2 = this.f6909D.f6804e;
            if (i <= 0 && i2 <= 0) {
                return m13880f;
            }
            C1949d.m13854a(f6893n, this.f6914I);
            m13885b(i, i2);
            return m13880f;
        } catch (IOException e) {
            C1949d.m13853a(e);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m13880f() {
        boolean z = false;
        InputStream mo13929a = m13878h().mo13929a(this.f6918a, this.f6920c.m14097n());
        if (mo13929a == null) {
            C1949d.m13846d(f6902w, this.f6914I);
        } else {
            try {
                z = this.f6909D.f6814o.mo14219a(this.f6918a, mo13929a, this);
            } finally {
                C1947c.m13861a((Closeable) mo13929a);
            }
        }
        return z;
    }

    /* renamed from: g */
    private void m13879g() {
        if (this.f6916K || m13870p()) {
            return;
        }
        m13888a(new Runnable() { // from class: com.d.a.b.h.3
            @Override // java.lang.Runnable
            public void run() {
                RunnableC1938h.this.f6921d.mo13893b(RunnableC1938h.this.f6918a, RunnableC1938h.this.f6919b.mo13921d());
            }
        }, false, this.f6908C, this.f6906A);
    }

    /* renamed from: h */
    private AbstractC1919b m13878h() {
        return this.f6906A.m13901f() ? this.f6911F : this.f6906A.m13900g() ? this.f6912G : this.f6910E;
    }

    /* renamed from: i */
    private void m13877i() {
        m13875k();
        m13873m();
    }

    /* renamed from: j */
    private boolean m13876j() {
        return m13874l() || m13872n();
    }

    /* renamed from: k */
    private void m13875k() {
        if (m13874l()) {
            throw new C1942a();
        }
    }

    /* renamed from: l */
    private boolean m13874l() {
        if (this.f6919b.mo13920e()) {
            C1949d.m13854a(f6900u, this.f6914I);
            return true;
        }
        return false;
    }

    /* renamed from: m */
    private void m13873m() {
        if (m13872n()) {
            throw new C1942a();
        }
    }

    /* renamed from: n */
    private boolean m13872n() {
        if (!this.f6914I.equals(this.f6906A.m13917a(this.f6919b))) {
            C1949d.m13854a(f6899t, this.f6914I);
            return true;
        }
        return false;
    }

    /* renamed from: o */
    private void m13871o() {
        if (m13870p()) {
            throw new C1942a();
        }
    }

    /* renamed from: p */
    private boolean m13870p() {
        if (Thread.interrupted()) {
            C1949d.m13854a(f6901v, this.f6914I);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m13891a() {
        return this.f6918a;
    }

    @Override // com.p118d.p119a.p136c.C1947c.AbstractC1948a
    /* renamed from: a */
    public boolean mo13857a(int i, int i2) {
        return this.f6916K || m13883c(i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!m13886b() && !m13884c()) {
            ReentrantLock reentrantLock = this.f6907B.f6884h;
            C1949d.m13854a(f6888i, this.f6914I);
            if (reentrantLock.isLocked()) {
                C1949d.m13854a(f6889j, this.f6914I);
            }
            reentrantLock.lock();
            try {
                m13877i();
                Bitmap mo14206a = this.f6909D.f6813n.mo14206a(this.f6914I);
                if (mo14206a == null || mo14206a.isRecycled()) {
                    mo14206a = m13882d();
                    if (mo14206a == null) {
                        return;
                    }
                    m13877i();
                    m13871o();
                    if (this.f6920c.m14117d()) {
                        C1949d.m13854a(f6894o, this.f6914I);
                        mo14206a = this.f6920c.m14095o().m13892a(mo14206a);
                        if (mo14206a == null) {
                            C1949d.m13846d(f6903x, this.f6914I);
                        }
                    }
                    if (mo14206a != null && this.f6920c.m14109h()) {
                        C1949d.m13854a(f6896q, this.f6914I);
                        this.f6909D.f6813n.mo14205a(this.f6914I, mo14206a);
                    }
                } else {
                    this.f6917L = EnumC1894f.MEMORY_CACHE;
                    C1949d.m13854a(f6890k, this.f6914I);
                }
                if (mo14206a != null && this.f6920c.m14115e()) {
                    C1949d.m13854a(f6895p, this.f6914I);
                    mo14206a = this.f6920c.m14093p().m13892a(mo14206a);
                    if (mo14206a == null) {
                        C1949d.m13846d(f6904y, this.f6914I);
                    }
                }
                m13877i();
                m13871o();
                reentrantLock.unlock();
                m13888a(new RunnableC1898b(mo14206a, this.f6907B, this.f6906A, this.f6917L), this.f6916K, this.f6908C, this.f6906A);
            } catch (C1942a e) {
                m13879g();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
