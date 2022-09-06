package com.p118d.p119a.p127b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import com.p118d.p119a.p127b.C1904c;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import com.p118d.p119a.p127b.p133e.C1927b;
import com.p118d.p119a.p127b.p133e.C1928c;
import com.p118d.p119a.p127b.p134f.AbstractC1932a;
import com.p118d.p119a.p127b.p134f.AbstractC1933b;
import com.p118d.p119a.p127b.p134f.C1935d;
import com.p118d.p119a.p136c.C1945b;
import com.p118d.p119a.p136c.C1949d;
import com.p118d.p119a.p136c.C1950e;
/* renamed from: com.d.a.b.d */
/* loaded from: classes.dex */
public class C1914d {

    /* renamed from: a */
    public static final String f6766a = C1914d.class.getSimpleName();

    /* renamed from: b */
    static final String f6767b = "Initialize ImageLoader with configuration";

    /* renamed from: c */
    static final String f6768c = "Destroy ImageLoader";

    /* renamed from: d */
    static final String f6769d = "Load image from memory cache [%s]";

    /* renamed from: e */
    private static final String f6770e = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";

    /* renamed from: f */
    private static final String f6771f = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";

    /* renamed from: g */
    private static final String f6772g = "ImageLoader must be init with configuration before using";

    /* renamed from: h */
    private static final String f6773h = "ImageLoader configuration can not be initialized with null";

    /* renamed from: l */
    private static volatile C1914d f6774l;

    /* renamed from: i */
    private C1921e f6775i;

    /* renamed from: j */
    private C1930f f6776j;

    /* renamed from: k */
    private AbstractC1932a f6777k = new C1935d();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.d.a.b.d$a */
    /* loaded from: classes.dex */
    public static class C1916a extends C1935d {

        /* renamed from: a */
        private Bitmap f6778a;

        private C1916a() {
        }

        /* renamed from: a */
        public Bitmap m13995a() {
            return this.f6778a;
        }

        @Override // com.p118d.p119a.p127b.p134f.C1935d, com.p118d.p119a.p127b.p134f.AbstractC1932a
        /* renamed from: a */
        public void mo13895a(String str, View view, Bitmap bitmap) {
            this.f6778a = bitmap;
        }
    }

    protected C1914d() {
    }

    /* renamed from: a */
    private static Handler m14034a(C1904c c1904c) {
        Handler m14089r = c1904c.m14089r();
        if (c1904c.m14087s()) {
            return null;
        }
        return (m14089r == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : m14089r;
    }

    /* renamed from: a */
    public static C1914d m14036a() {
        if (f6774l == null) {
            synchronized (C1914d.class) {
                if (f6774l == null) {
                    f6774l = new C1914d();
                }
            }
        }
        return f6774l;
    }

    /* renamed from: m */
    private void m13996m() {
        if (this.f6775i == null) {
            throw new IllegalStateException(f6772g);
        }
    }

    /* renamed from: a */
    public Bitmap m14030a(String str) {
        return m14023a(str, (C1893e) null, (C1904c) null);
    }

    /* renamed from: a */
    public Bitmap m14024a(String str, C1893e c1893e) {
        return m14023a(str, c1893e, (C1904c) null);
    }

    /* renamed from: a */
    public Bitmap m14023a(String str, C1893e c1893e, C1904c c1904c) {
        if (c1904c == null) {
            c1904c = this.f6775i.f6817r;
        }
        C1904c m14060d = new C1904c.C1906a().m14075a(c1904c).m14052f(true).m14060d();
        C1916a c1916a = new C1916a();
        m14022a(str, c1893e, m14060d, c1916a);
        return c1916a.m13995a();
    }

    /* renamed from: a */
    public Bitmap m14019a(String str, C1904c c1904c) {
        return m14023a(str, (C1893e) null, c1904c);
    }

    /* renamed from: a */
    public String m14035a(ImageView imageView) {
        return this.f6776j.m13917a(new C1927b(imageView));
    }

    /* renamed from: a */
    public String m14033a(AbstractC1926a abstractC1926a) {
        return this.f6776j.m13917a(abstractC1926a);
    }

    /* renamed from: a */
    public synchronized void m14032a(C1921e c1921e) {
        if (c1921e == null) {
            throw new IllegalArgumentException(f6773h);
        }
        if (this.f6775i == null) {
            C1949d.m13854a(f6767b, new Object[0]);
            this.f6776j = new C1930f(c1921e);
            this.f6775i = c1921e;
        } else {
            C1949d.m13847c(f6770e, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m14031a(AbstractC1932a abstractC1932a) {
        if (abstractC1932a == null) {
            abstractC1932a = new C1935d();
        }
        this.f6777k = abstractC1932a;
    }

    /* renamed from: a */
    public void m14029a(String str, ImageView imageView) {
        m14014a(str, new C1927b(imageView), (C1904c) null, (AbstractC1932a) null, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14028a(String str, ImageView imageView, C1904c c1904c) {
        m14014a(str, new C1927b(imageView), c1904c, (AbstractC1932a) null, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14027a(String str, ImageView imageView, C1904c c1904c, AbstractC1932a abstractC1932a) {
        m14026a(str, imageView, c1904c, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14026a(String str, ImageView imageView, C1904c c1904c, AbstractC1932a abstractC1932a, AbstractC1933b abstractC1933b) {
        m14014a(str, new C1927b(imageView), c1904c, abstractC1932a, abstractC1933b);
    }

    /* renamed from: a */
    public void m14025a(String str, ImageView imageView, AbstractC1932a abstractC1932a) {
        m14014a(str, new C1927b(imageView), (C1904c) null, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14022a(String str, C1893e c1893e, C1904c c1904c, AbstractC1932a abstractC1932a) {
        m14021a(str, c1893e, c1904c, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14021a(String str, C1893e c1893e, C1904c c1904c, AbstractC1932a abstractC1932a, AbstractC1933b abstractC1933b) {
        m13996m();
        if (c1893e == null) {
            c1893e = this.f6775i.m13978a();
        }
        m14014a(str, new C1928c(str, c1893e, EnumC1896h.CROP), c1904c == null ? this.f6775i.f6817r : c1904c, abstractC1932a, abstractC1933b);
    }

    /* renamed from: a */
    public void m14020a(String str, C1893e c1893e, AbstractC1932a abstractC1932a) {
        m14021a(str, c1893e, (C1904c) null, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14018a(String str, C1904c c1904c, AbstractC1932a abstractC1932a) {
        m14021a(str, (C1893e) null, c1904c, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14017a(String str, AbstractC1926a abstractC1926a) {
        m14014a(str, abstractC1926a, (C1904c) null, (AbstractC1932a) null, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14016a(String str, AbstractC1926a abstractC1926a, C1904c c1904c) {
        m14014a(str, abstractC1926a, c1904c, (AbstractC1932a) null, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14015a(String str, AbstractC1926a abstractC1926a, C1904c c1904c, AbstractC1932a abstractC1932a) {
        m14014a(str, abstractC1926a, c1904c, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14014a(String str, AbstractC1926a abstractC1926a, C1904c c1904c, AbstractC1932a abstractC1932a, AbstractC1933b abstractC1933b) {
        m13996m();
        if (abstractC1926a == null) {
            throw new IllegalArgumentException(f6771f);
        }
        AbstractC1932a abstractC1932a2 = abstractC1932a == null ? this.f6777k : abstractC1932a;
        C1904c c1904c2 = c1904c == null ? this.f6775i.f6817r : c1904c;
        if (TextUtils.isEmpty(str)) {
            this.f6776j.m13908b(abstractC1926a);
            abstractC1932a2.mo13896a(str, abstractC1926a.mo13921d());
            if (c1904c2.m14123b()) {
                abstractC1926a.mo13925a(c1904c2.m14122b(this.f6775i.f6800a));
            } else {
                abstractC1926a.mo13925a((Drawable) null);
            }
            abstractC1932a2.mo13895a(str, abstractC1926a.mo13921d(), (Bitmap) null);
            return;
        }
        C1893e m13864a = C1945b.m13864a(abstractC1926a, this.f6775i.m13978a());
        String m13843a = C1950e.m13843a(str, m13864a);
        this.f6776j.m13916a(abstractC1926a, m13843a);
        abstractC1932a2.mo13896a(str, abstractC1926a.mo13921d());
        Bitmap mo14206a = this.f6775i.f6813n.mo14206a(m13843a);
        if (mo14206a == null || mo14206a.isRecycled()) {
            if (c1904c2.m14126a()) {
                abstractC1926a.mo13925a(c1904c2.m14125a(this.f6775i.f6800a));
            } else if (c1904c2.m14111g()) {
                abstractC1926a.mo13925a((Drawable) null);
            }
            RunnableC1938h runnableC1938h = new RunnableC1938h(this.f6776j, new C1936g(str, abstractC1926a, m13864a, m13843a, c1904c2, abstractC1932a2, abstractC1933b, this.f6776j.m13911a(str)), m14034a(c1904c2));
            if (c1904c2.m14087s()) {
                runnableC1938h.run();
                return;
            } else {
                this.f6776j.m13914a(runnableC1938h);
                return;
            }
        }
        C1949d.m13854a(f6769d, m13843a);
        if (!c1904c2.m14115e()) {
            c1904c2.m14091q().mo14037a(mo14206a, abstractC1926a, EnumC1894f.MEMORY_CACHE);
            abstractC1932a2.mo13895a(str, abstractC1926a.mo13921d(), mo14206a);
            return;
        }
        RunnableC1943i runnableC1943i = new RunnableC1943i(this.f6776j, mo14206a, new C1936g(str, abstractC1926a, m13864a, m13843a, c1904c2, abstractC1932a2, abstractC1933b, this.f6776j.m13911a(str)), m14034a(c1904c2));
        if (c1904c2.m14087s()) {
            runnableC1943i.run();
        } else {
            this.f6776j.m13913a(runnableC1943i);
        }
    }

    /* renamed from: a */
    public void m14013a(String str, AbstractC1926a abstractC1926a, AbstractC1932a abstractC1932a) {
        m14014a(str, abstractC1926a, (C1904c) null, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14012a(String str, AbstractC1932a abstractC1932a) {
        m14021a(str, (C1893e) null, (C1904c) null, abstractC1932a, (AbstractC1933b) null);
    }

    /* renamed from: a */
    public void m14011a(boolean z) {
        this.f6776j.m13910a(z);
    }

    /* renamed from: b */
    public void m14009b(ImageView imageView) {
        this.f6776j.m13908b(new C1927b(imageView));
    }

    /* renamed from: b */
    public void m14008b(AbstractC1926a abstractC1926a) {
        this.f6776j.m13908b(abstractC1926a);
    }

    /* renamed from: b */
    public void m14007b(boolean z) {
        this.f6776j.m13906b(z);
    }

    /* renamed from: b */
    public boolean m14010b() {
        return this.f6775i != null;
    }

    /* renamed from: c */
    public AbstractC1876c m14006c() {
        m13996m();
        return this.f6775i.f6813n;
    }

    /* renamed from: d */
    public void m14005d() {
        m13996m();
        this.f6775i.f6813n.mo14204b();
    }

    @Deprecated
    /* renamed from: e */
    public AbstractC1848a m14004e() {
        return m14003f();
    }

    /* renamed from: f */
    public AbstractC1848a m14003f() {
        m13996m();
        return this.f6775i.f6814o;
    }

    @Deprecated
    /* renamed from: g */
    public void m14002g() {
        m14001h();
    }

    /* renamed from: h */
    public void m14001h() {
        m13996m();
        this.f6775i.f6814o.mo14217c();
    }

    /* renamed from: i */
    public void m14000i() {
        this.f6776j.m13918a();
    }

    /* renamed from: j */
    public void m13999j() {
        this.f6776j.m13909b();
    }

    /* renamed from: k */
    public void m13998k() {
        this.f6776j.m13905c();
    }

    /* renamed from: l */
    public void m13997l() {
        if (this.f6775i != null) {
            C1949d.m13854a(f6768c, new Object[0]);
        }
        m13998k();
        this.f6775i.f6814o.mo14230b();
        this.f6776j = null;
        this.f6775i = null;
    }
}
