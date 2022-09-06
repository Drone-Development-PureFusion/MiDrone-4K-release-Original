package com.p118d.p119a.p127b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import com.p118d.p119a.p120a.p125b.p126a.C1868b;
import com.p118d.p119a.p127b.p128a.C1891c;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1895g;
import com.p118d.p119a.p127b.p130b.AbstractC1902b;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
import com.p118d.p119a.p127b.p135g.AbstractC1937a;
import com.p118d.p119a.p136c.C1949d;
import com.p118d.p119a.p136c.C1950e;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* renamed from: com.d.a.b.e */
/* loaded from: classes.dex */
public final class C1921e {

    /* renamed from: a */
    final Resources f6800a;

    /* renamed from: b */
    final int f6801b;

    /* renamed from: c */
    final int f6802c;

    /* renamed from: d */
    final int f6803d;

    /* renamed from: e */
    final int f6804e;

    /* renamed from: f */
    final AbstractC1937a f6805f;

    /* renamed from: g */
    final Executor f6806g;

    /* renamed from: h */
    final Executor f6807h;

    /* renamed from: i */
    final boolean f6808i;

    /* renamed from: j */
    final boolean f6809j;

    /* renamed from: k */
    final int f6810k;

    /* renamed from: l */
    final int f6811l;

    /* renamed from: m */
    final EnumC1895g f6812m;

    /* renamed from: n */
    final AbstractC1876c f6813n;

    /* renamed from: o */
    final AbstractC1848a f6814o;

    /* renamed from: p */
    final AbstractC1919b f6815p;

    /* renamed from: q */
    final AbstractC1902b f6816q;

    /* renamed from: r */
    final C1904c f6817r;

    /* renamed from: s */
    final AbstractC1919b f6818s;

    /* renamed from: t */
    final AbstractC1919b f6819t;

    /* renamed from: com.d.a.b.e$a */
    /* loaded from: classes.dex */
    public static class C1923a {

        /* renamed from: a */
        public static final int f6821a = 3;

        /* renamed from: b */
        public static final int f6822b = 3;

        /* renamed from: c */
        public static final EnumC1895g f6823c = EnumC1895g.FIFO;

        /* renamed from: d */
        private static final String f6824d = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";

        /* renamed from: e */
        private static final String f6825e = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";

        /* renamed from: f */
        private static final String f6826f = "memoryCache() and memoryCacheSize() calls overlap each other";

        /* renamed from: g */
        private static final String f6827g = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";

        /* renamed from: C */
        private AbstractC1902b f6830C;

        /* renamed from: h */
        private Context f6833h;

        /* renamed from: i */
        private int f6834i = 0;

        /* renamed from: j */
        private int f6835j = 0;

        /* renamed from: k */
        private int f6836k = 0;

        /* renamed from: l */
        private int f6837l = 0;

        /* renamed from: m */
        private AbstractC1937a f6838m = null;

        /* renamed from: n */
        private Executor f6839n = null;

        /* renamed from: o */
        private Executor f6840o = null;

        /* renamed from: p */
        private boolean f6841p = false;

        /* renamed from: q */
        private boolean f6842q = false;

        /* renamed from: r */
        private int f6843r = 3;

        /* renamed from: s */
        private int f6844s = 3;

        /* renamed from: t */
        private boolean f6845t = false;

        /* renamed from: u */
        private EnumC1895g f6846u = f6823c;

        /* renamed from: v */
        private int f6847v = 0;

        /* renamed from: w */
        private long f6848w = 0;

        /* renamed from: x */
        private int f6849x = 0;

        /* renamed from: y */
        private AbstractC1876c f6850y = null;

        /* renamed from: z */
        private AbstractC1848a f6851z = null;

        /* renamed from: A */
        private AbstractC1863a f6828A = null;

        /* renamed from: B */
        private AbstractC1919b f6829B = null;

        /* renamed from: D */
        private C1904c f6831D = null;

        /* renamed from: E */
        private boolean f6832E = false;

        public C1923a(Context context) {
            this.f6833h = context.getApplicationContext();
        }

        /* renamed from: d */
        private void m13953d() {
            if (this.f6839n == null) {
                this.f6839n = C1877a.m14201a(this.f6843r, this.f6844s, this.f6846u);
            } else {
                this.f6841p = true;
            }
            if (this.f6840o == null) {
                this.f6840o = C1877a.m14201a(this.f6843r, this.f6844s, this.f6846u);
            } else {
                this.f6842q = true;
            }
            if (this.f6851z == null) {
                if (this.f6828A == null) {
                    this.f6828A = C1877a.m14194b();
                }
                this.f6851z = C1877a.m14196a(this.f6833h, this.f6828A, this.f6848w, this.f6849x);
            }
            if (this.f6850y == null) {
                this.f6850y = C1877a.m14197a(this.f6833h, this.f6847v);
            }
            if (this.f6845t) {
                this.f6850y = new C1868b(this.f6850y, C1950e.m13845a());
            }
            if (this.f6829B == null) {
                this.f6829B = C1877a.m14198a(this.f6833h);
            }
            if (this.f6830C == null) {
                this.f6830C = C1877a.m14195a(this.f6832E);
            }
            if (this.f6831D == null) {
                this.f6831D = C1904c.m14085t();
            }
        }

        /* renamed from: a */
        public C1923a m13976a() {
            this.f6845t = true;
            return this;
        }

        /* renamed from: a */
        public C1923a m13975a(int i) {
            if (this.f6839n != null || this.f6840o != null) {
                C1949d.m13847c(f6827g, new Object[0]);
            }
            this.f6843r = i;
            return this;
        }

        /* renamed from: a */
        public C1923a m13974a(int i, int i2) {
            this.f6834i = i;
            this.f6835j = i2;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public C1923a m13973a(int i, int i2, AbstractC1937a abstractC1937a) {
            return m13961b(i, i2, abstractC1937a);
        }

        @Deprecated
        /* renamed from: a */
        public C1923a m13972a(AbstractC1848a abstractC1848a) {
            return m13960b(abstractC1848a);
        }

        @Deprecated
        /* renamed from: a */
        public C1923a m13971a(AbstractC1863a abstractC1863a) {
            return m13959b(abstractC1863a);
        }

        /* renamed from: a */
        public C1923a m13970a(AbstractC1876c abstractC1876c) {
            if (this.f6847v != 0) {
                C1949d.m13847c(f6826f, new Object[0]);
            }
            this.f6850y = abstractC1876c;
            return this;
        }

        /* renamed from: a */
        public C1923a m13969a(EnumC1895g enumC1895g) {
            if (this.f6839n != null || this.f6840o != null) {
                C1949d.m13847c(f6827g, new Object[0]);
            }
            this.f6846u = enumC1895g;
            return this;
        }

        /* renamed from: a */
        public C1923a m13968a(AbstractC1902b abstractC1902b) {
            this.f6830C = abstractC1902b;
            return this;
        }

        /* renamed from: a */
        public C1923a m13967a(C1904c c1904c) {
            this.f6831D = c1904c;
            return this;
        }

        /* renamed from: a */
        public C1923a m13966a(AbstractC1919b abstractC1919b) {
            this.f6829B = abstractC1919b;
            return this;
        }

        /* renamed from: a */
        public C1923a m13964a(Executor executor) {
            if (this.f6843r != 3 || this.f6844s != 3 || this.f6846u != f6823c) {
                C1949d.m13847c(f6827g, new Object[0]);
            }
            this.f6839n = executor;
            return this;
        }

        /* renamed from: b */
        public C1923a m13963b() {
            this.f6832E = true;
            return this;
        }

        /* renamed from: b */
        public C1923a m13962b(int i) {
            if (this.f6839n != null || this.f6840o != null) {
                C1949d.m13847c(f6827g, new Object[0]);
            }
            if (i < 1) {
                this.f6844s = 1;
            } else if (i > 10) {
                this.f6844s = 10;
            } else {
                this.f6844s = i;
            }
            return this;
        }

        /* renamed from: b */
        public C1923a m13961b(int i, int i2, AbstractC1937a abstractC1937a) {
            this.f6836k = i;
            this.f6837l = i2;
            this.f6838m = abstractC1937a;
            return this;
        }

        /* renamed from: b */
        public C1923a m13960b(AbstractC1848a abstractC1848a) {
            if (this.f6848w > 0 || this.f6849x > 0) {
                C1949d.m13847c(f6824d, new Object[0]);
            }
            if (this.f6828A != null) {
                C1949d.m13847c(f6825e, new Object[0]);
            }
            this.f6851z = abstractC1848a;
            return this;
        }

        /* renamed from: b */
        public C1923a m13959b(AbstractC1863a abstractC1863a) {
            if (this.f6851z != null) {
                C1949d.m13847c(f6825e, new Object[0]);
            }
            this.f6828A = abstractC1863a;
            return this;
        }

        /* renamed from: b */
        public C1923a m13957b(Executor executor) {
            if (this.f6843r != 3 || this.f6844s != 3 || this.f6846u != f6823c) {
                C1949d.m13847c(f6827g, new Object[0]);
            }
            this.f6840o = executor;
            return this;
        }

        /* renamed from: c */
        public C1923a m13955c(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.f6850y != null) {
                C1949d.m13847c(f6826f, new Object[0]);
            }
            this.f6847v = i;
            return this;
        }

        /* renamed from: c */
        public C1921e m13956c() {
            m13953d();
            return new C1921e(this);
        }

        /* renamed from: d */
        public C1923a m13952d(int i) {
            if (i <= 0 || i >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.f6850y != null) {
                C1949d.m13847c(f6826f, new Object[0]);
            }
            this.f6847v = (int) (((float) Runtime.getRuntime().maxMemory()) * (i / 100.0f));
            return this;
        }

        @Deprecated
        /* renamed from: e */
        public C1923a m13950e(int i) {
            return m13948f(i);
        }

        /* renamed from: f */
        public C1923a m13948f(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.f6851z != null) {
                C1949d.m13847c(f6824d, new Object[0]);
            }
            this.f6848w = i;
            return this;
        }

        @Deprecated
        /* renamed from: g */
        public C1923a m13946g(int i) {
            return m13944h(i);
        }

        /* renamed from: h */
        public C1923a m13944h(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.f6851z != null) {
                C1949d.m13847c(f6824d, new Object[0]);
            }
            this.f6849x = i;
            return this;
        }
    }

    /* renamed from: com.d.a.b.e$b */
    /* loaded from: classes.dex */
    private static class C1924b implements AbstractC1919b {

        /* renamed from: a */
        private final AbstractC1919b f6852a;

        public C1924b(AbstractC1919b abstractC1919b) {
            this.f6852a = abstractC1919b;
        }

        @Override // com.p118d.p119a.p127b.p132d.AbstractC1919b
        /* renamed from: a */
        public InputStream mo13929a(String str, Object obj) {
            switch (AbstractC1919b.EnumC1920a.m13982a(str)) {
                case HTTP:
                case HTTPS:
                    throw new IllegalStateException();
                default:
                    return this.f6852a.mo13929a(str, obj);
            }
        }
    }

    /* renamed from: com.d.a.b.e$c */
    /* loaded from: classes.dex */
    private static class C1925c implements AbstractC1919b {

        /* renamed from: a */
        private final AbstractC1919b f6853a;

        public C1925c(AbstractC1919b abstractC1919b) {
            this.f6853a = abstractC1919b;
        }

        @Override // com.p118d.p119a.p127b.p132d.AbstractC1919b
        /* renamed from: a */
        public InputStream mo13929a(String str, Object obj) {
            InputStream mo13929a = this.f6853a.mo13929a(str, obj);
            switch (AbstractC1919b.EnumC1920a.m13982a(str)) {
                case HTTP:
                case HTTPS:
                    return new C1891c(mo13929a);
                default:
                    return mo13929a;
            }
        }
    }

    private C1921e(C1923a c1923a) {
        this.f6800a = c1923a.f6833h.getResources();
        this.f6801b = c1923a.f6834i;
        this.f6802c = c1923a.f6835j;
        this.f6803d = c1923a.f6836k;
        this.f6804e = c1923a.f6837l;
        this.f6805f = c1923a.f6838m;
        this.f6806g = c1923a.f6839n;
        this.f6807h = c1923a.f6840o;
        this.f6810k = c1923a.f6843r;
        this.f6811l = c1923a.f6844s;
        this.f6812m = c1923a.f6846u;
        this.f6814o = c1923a.f6851z;
        this.f6813n = c1923a.f6850y;
        this.f6817r = c1923a.f6831D;
        this.f6815p = c1923a.f6829B;
        this.f6816q = c1923a.f6830C;
        this.f6808i = c1923a.f6841p;
        this.f6809j = c1923a.f6842q;
        this.f6818s = new C1924b(this.f6815p);
        this.f6819t = new C1925c(this.f6815p);
        C1949d.m13851a(c1923a.f6832E);
    }

    /* renamed from: a */
    public static C1921e m13977a(Context context) {
        return new C1923a(context).m13956c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1893e m13978a() {
        DisplayMetrics displayMetrics = this.f6800a.getDisplayMetrics();
        int i = this.f6801b;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.f6802c;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new C1893e(i, i2);
    }
}
