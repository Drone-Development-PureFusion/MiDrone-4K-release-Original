package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.mapcore.util.C0898dg;
import com.amap.api.mapcore.util.C0929dw;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
/* renamed from: com.amap.api.mapcore.util.dz */
/* loaded from: classes.dex */
public abstract class AbstractC0934dz {

    /* renamed from: a */
    private C0929dw f2870a;

    /* renamed from: b */
    private C0929dw.C0931a f2871b;

    /* renamed from: d */
    protected Resources f2873d;

    /* renamed from: e */
    private boolean f2874e = false;

    /* renamed from: c */
    protected boolean f2872c = false;

    /* renamed from: f */
    private final Object f2875f = new Object();

    /* renamed from: com.amap.api.mapcore.util.dz$a */
    /* loaded from: classes.dex */
    public class C0935a extends AbstractC0911dq<Boolean, Void, Bitmap> {

        /* renamed from: e */
        private final WeakReference<C0898dg.C0899a> f2877e;

        public C0935a(C0898dg.C0899a c0899a) {
            this.f2877e = new WeakReference<>(c0899a);
        }

        /* renamed from: e */
        private C0898dg.C0899a m18399e() {
            C0898dg.C0899a c0899a = this.f2877e.get();
            if (this == AbstractC0934dz.m18410c(c0899a)) {
                return c0899a;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Bitmap mo18398a(Boolean... boolArr) {
            try {
                boolean booleanValue = boolArr[0].booleanValue();
                C0898dg.C0899a c0899a = this.f2877e.get();
                if (c0899a == null) {
                    return null;
                }
                String str = c0899a.f2713a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c0899a.f2714b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c0899a.f2715c;
                synchronized (AbstractC0934dz.this.f2875f) {
                    while (AbstractC0934dz.this.f2872c && !d()) {
                        AbstractC0934dz.this.f2875f.wait();
                    }
                }
                Bitmap m18444b = (AbstractC0934dz.this.f2870a == null || d() || m18399e() == null || AbstractC0934dz.this.f2874e) ? null : AbstractC0934dz.this.f2870a.m18444b(str);
                Bitmap mo18418a = (!booleanValue || m18444b != null || d() || m18399e() == null || AbstractC0934dz.this.f2874e) ? m18444b : AbstractC0934dz.this.mo18418a((Object) c0899a);
                if (mo18418a == null || AbstractC0934dz.this.f2870a == null) {
                    return mo18418a;
                }
                AbstractC0934dz.this.f2870a.m18449a(str, mo18418a);
                return mo18418a;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo18403a(Bitmap bitmap) {
            try {
                if (d() || AbstractC0934dz.this.f2874e) {
                    bitmap = null;
                }
                C0898dg.C0899a m18399e = m18399e();
                if (bitmap == null || bitmap.isRecycled() || m18399e == null) {
                    return;
                }
                m18399e.m18540a(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public void mo18400b(Bitmap bitmap) {
            super.mo18400b((C0935a) bitmap);
            synchronized (AbstractC0934dz.this.f2875f) {
                AbstractC0934dz.this.f2875f.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.amap.api.mapcore.util.dz$b */
    /* loaded from: classes.dex */
    public class C0936b extends AbstractC0911dq<Object, Void, Void> {
        protected C0936b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.AbstractC0911dq
        /* renamed from: d */
        public Void mo18398a(Object... objArr) {
            try {
                switch (((Integer) objArr[0]).intValue()) {
                    case 0:
                        AbstractC0934dz.this.m18411c();
                        break;
                    case 1:
                        AbstractC0934dz.this.m18415b();
                        break;
                    case 2:
                        AbstractC0934dz.this.m18408d();
                        break;
                    case 3:
                        AbstractC0934dz.this.m18407e();
                        break;
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0934dz(Context context) {
        this.f2873d = context.getResources();
    }

    /* renamed from: a */
    public static void m18421a(C0898dg.C0899a c0899a) {
        C0935a m18410c = m18410c(c0899a);
        if (m18410c != null) {
            m18410c.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static C0935a m18410c(C0898dg.C0899a c0899a) {
        if (c0899a != null) {
            return c0899a.f2722j;
        }
        return null;
    }

    /* renamed from: a */
    protected abstract Bitmap mo18418a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C0929dw m18422a() {
        return this.f2870a;
    }

    /* renamed from: a */
    public void m18420a(C0929dw.C0931a c0931a) {
        this.f2871b = c0931a;
        this.f2870a = C0929dw.m18453a(this.f2871b);
        new C0936b().c(1);
    }

    /* renamed from: a */
    public void m18417a(boolean z) {
        this.f2874e = z;
        m18412b(false);
    }

    /* renamed from: a */
    public void m18416a(boolean z, C0898dg.C0899a c0899a) {
        if (c0899a == null) {
            return;
        }
        Bitmap bitmap = null;
        try {
            if (this.f2870a != null) {
                bitmap = this.f2870a.m18450a(c0899a.f2713a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c0899a.f2714b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c0899a.f2715c);
            }
            if (bitmap != null) {
                c0899a.m18540a(bitmap);
                return;
            }
            C0935a c0935a = new C0935a(c0899a);
            c0899a.f2722j = c0935a;
            c0935a.a(AbstractC0911dq.f2806d, Boolean.valueOf(z));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    protected void m18415b() {
        if (this.f2870a != null) {
            this.f2870a.m18457a();
        }
    }

    /* renamed from: b */
    public void m18412b(boolean z) {
        synchronized (this.f2875f) {
            this.f2872c = z;
            if (!this.f2872c) {
                this.f2875f.notifyAll();
            }
        }
    }

    /* renamed from: c */
    protected void m18411c() {
        if (this.f2870a != null) {
            this.f2870a.m18447b();
        }
    }

    /* renamed from: d */
    protected void m18408d() {
        if (this.f2870a != null) {
            this.f2870a.m18443c();
        }
    }

    /* renamed from: e */
    protected void m18407e() {
        if (this.f2870a != null) {
            this.f2870a.m18441d();
            this.f2870a = null;
        }
    }

    /* renamed from: f */
    public void m18406f() {
        new C0936b().c(0);
    }

    /* renamed from: g */
    public void m18405g() {
        new C0936b().c(3);
    }
}
