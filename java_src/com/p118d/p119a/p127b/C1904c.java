package com.p118d.p119a.p127b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.p118d.p119a.p127b.p128a.EnumC1892d;
import com.p118d.p119a.p127b.p131c.AbstractC1907a;
import com.p118d.p119a.p127b.p135g.AbstractC1937a;
/* renamed from: com.d.a.b.c */
/* loaded from: classes.dex */
public final class C1904c {

    /* renamed from: a */
    private final int f6716a;

    /* renamed from: b */
    private final int f6717b;

    /* renamed from: c */
    private final int f6718c;

    /* renamed from: d */
    private final Drawable f6719d;

    /* renamed from: e */
    private final Drawable f6720e;

    /* renamed from: f */
    private final Drawable f6721f;

    /* renamed from: g */
    private final boolean f6722g;

    /* renamed from: h */
    private final boolean f6723h;

    /* renamed from: i */
    private final boolean f6724i;

    /* renamed from: j */
    private final EnumC1892d f6725j;

    /* renamed from: k */
    private final BitmapFactory.Options f6726k;

    /* renamed from: l */
    private final int f6727l;

    /* renamed from: m */
    private final boolean f6728m;

    /* renamed from: n */
    private final Object f6729n;

    /* renamed from: o */
    private final AbstractC1937a f6730o;

    /* renamed from: p */
    private final AbstractC1937a f6731p;

    /* renamed from: q */
    private final AbstractC1907a f6732q;

    /* renamed from: r */
    private final Handler f6733r;

    /* renamed from: s */
    private final boolean f6734s;

    /* renamed from: com.d.a.b.c$a */
    /* loaded from: classes.dex */
    public static class C1906a {

        /* renamed from: a */
        private int f6735a = 0;

        /* renamed from: b */
        private int f6736b = 0;

        /* renamed from: c */
        private int f6737c = 0;

        /* renamed from: d */
        private Drawable f6738d = null;

        /* renamed from: e */
        private Drawable f6739e = null;

        /* renamed from: f */
        private Drawable f6740f = null;

        /* renamed from: g */
        private boolean f6741g = false;

        /* renamed from: h */
        private boolean f6742h = false;

        /* renamed from: i */
        private boolean f6743i = false;

        /* renamed from: j */
        private EnumC1892d f6744j = EnumC1892d.IN_SAMPLE_POWER_OF_2;

        /* renamed from: k */
        private BitmapFactory.Options f6745k = new BitmapFactory.Options();

        /* renamed from: l */
        private int f6746l = 0;

        /* renamed from: m */
        private boolean f6747m = false;

        /* renamed from: n */
        private Object f6748n = null;

        /* renamed from: o */
        private AbstractC1937a f6749o = null;

        /* renamed from: p */
        private AbstractC1937a f6750p = null;

        /* renamed from: q */
        private AbstractC1907a f6751q = C1877a.m14192c();

        /* renamed from: r */
        private Handler f6752r = null;

        /* renamed from: s */
        private boolean f6753s = false;

        public C1906a() {
            this.f6745k.inPurgeable = true;
            this.f6745k.inInputShareable = true;
        }

        /* renamed from: a */
        public C1906a m14084a() {
            this.f6741g = true;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public C1906a m14083a(int i) {
            this.f6735a = i;
            return this;
        }

        /* renamed from: a */
        public C1906a m14082a(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.f6745k.inPreferredConfig = config;
            return this;
        }

        /* renamed from: a */
        public C1906a m14081a(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.f6745k = options;
            return this;
        }

        /* renamed from: a */
        public C1906a m14080a(Drawable drawable) {
            this.f6738d = drawable;
            return this;
        }

        /* renamed from: a */
        public C1906a m14079a(Handler handler) {
            this.f6752r = handler;
            return this;
        }

        /* renamed from: a */
        public C1906a m14078a(EnumC1892d enumC1892d) {
            this.f6744j = enumC1892d;
            return this;
        }

        /* renamed from: a */
        public C1906a m14076a(AbstractC1907a abstractC1907a) {
            if (abstractC1907a == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.f6751q = abstractC1907a;
            return this;
        }

        /* renamed from: a */
        public C1906a m14075a(C1904c c1904c) {
            this.f6735a = c1904c.f6716a;
            this.f6736b = c1904c.f6717b;
            this.f6737c = c1904c.f6718c;
            this.f6738d = c1904c.f6719d;
            this.f6739e = c1904c.f6720e;
            this.f6740f = c1904c.f6721f;
            this.f6741g = c1904c.f6722g;
            this.f6742h = c1904c.f6723h;
            this.f6743i = c1904c.f6724i;
            this.f6744j = c1904c.f6725j;
            this.f6745k = c1904c.f6726k;
            this.f6746l = c1904c.f6727l;
            this.f6747m = c1904c.f6728m;
            this.f6748n = c1904c.f6729n;
            this.f6749o = c1904c.f6730o;
            this.f6750p = c1904c.f6731p;
            this.f6751q = c1904c.f6732q;
            this.f6752r = c1904c.f6733r;
            this.f6753s = c1904c.f6734s;
            return this;
        }

        /* renamed from: a */
        public C1906a m14074a(AbstractC1937a abstractC1937a) {
            this.f6749o = abstractC1937a;
            return this;
        }

        /* renamed from: a */
        public C1906a m14073a(Object obj) {
            this.f6748n = obj;
            return this;
        }

        /* renamed from: a */
        public C1906a m14072a(boolean z) {
            this.f6741g = z;
            return this;
        }

        @Deprecated
        /* renamed from: b */
        public C1906a m14071b() {
            this.f6742h = true;
            return this;
        }

        /* renamed from: b */
        public C1906a m14070b(int i) {
            this.f6735a = i;
            return this;
        }

        /* renamed from: b */
        public C1906a m14069b(Drawable drawable) {
            this.f6739e = drawable;
            return this;
        }

        /* renamed from: b */
        public C1906a m14067b(AbstractC1937a abstractC1937a) {
            this.f6750p = abstractC1937a;
            return this;
        }

        /* renamed from: b */
        public C1906a m14066b(boolean z) {
            this.f6742h = z;
            return this;
        }

        @Deprecated
        /* renamed from: c */
        public C1906a m14065c() {
            return m14057d(true);
        }

        /* renamed from: c */
        public C1906a m14064c(int i) {
            this.f6736b = i;
            return this;
        }

        /* renamed from: c */
        public C1906a m14063c(Drawable drawable) {
            this.f6740f = drawable;
            return this;
        }

        @Deprecated
        /* renamed from: c */
        public C1906a m14061c(boolean z) {
            return m14057d(z);
        }

        /* renamed from: d */
        public C1906a m14059d(int i) {
            this.f6737c = i;
            return this;
        }

        /* renamed from: d */
        public C1906a m14057d(boolean z) {
            this.f6743i = z;
            return this;
        }

        /* renamed from: d */
        public C1904c m14060d() {
            return new C1904c(this);
        }

        /* renamed from: e */
        public C1906a m14056e(int i) {
            this.f6746l = i;
            return this;
        }

        /* renamed from: e */
        public C1906a m14054e(boolean z) {
            this.f6747m = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public C1906a m14052f(boolean z) {
            this.f6753s = z;
            return this;
        }
    }

    private C1904c(C1906a c1906a) {
        this.f6716a = c1906a.f6735a;
        this.f6717b = c1906a.f6736b;
        this.f6718c = c1906a.f6737c;
        this.f6719d = c1906a.f6738d;
        this.f6720e = c1906a.f6739e;
        this.f6721f = c1906a.f6740f;
        this.f6722g = c1906a.f6741g;
        this.f6723h = c1906a.f6742h;
        this.f6724i = c1906a.f6743i;
        this.f6725j = c1906a.f6744j;
        this.f6726k = c1906a.f6745k;
        this.f6727l = c1906a.f6746l;
        this.f6728m = c1906a.f6747m;
        this.f6729n = c1906a.f6748n;
        this.f6730o = c1906a.f6749o;
        this.f6731p = c1906a.f6750p;
        this.f6732q = c1906a.f6751q;
        this.f6733r = c1906a.f6752r;
        this.f6734s = c1906a.f6753s;
    }

    /* renamed from: t */
    public static C1904c m14085t() {
        return new C1906a().m14060d();
    }

    /* renamed from: a */
    public Drawable m14125a(Resources resources) {
        return this.f6716a != 0 ? resources.getDrawable(this.f6716a) : this.f6719d;
    }

    /* renamed from: a */
    public boolean m14126a() {
        return (this.f6719d == null && this.f6716a == 0) ? false : true;
    }

    /* renamed from: b */
    public Drawable m14122b(Resources resources) {
        return this.f6717b != 0 ? resources.getDrawable(this.f6717b) : this.f6720e;
    }

    /* renamed from: b */
    public boolean m14123b() {
        return (this.f6720e == null && this.f6717b == 0) ? false : true;
    }

    /* renamed from: c */
    public Drawable m14119c(Resources resources) {
        return this.f6718c != 0 ? resources.getDrawable(this.f6718c) : this.f6721f;
    }

    /* renamed from: c */
    public boolean m14120c() {
        return (this.f6721f == null && this.f6718c == 0) ? false : true;
    }

    /* renamed from: d */
    public boolean m14117d() {
        return this.f6730o != null;
    }

    /* renamed from: e */
    public boolean m14115e() {
        return this.f6731p != null;
    }

    /* renamed from: f */
    public boolean m14113f() {
        return this.f6727l > 0;
    }

    /* renamed from: g */
    public boolean m14111g() {
        return this.f6722g;
    }

    /* renamed from: h */
    public boolean m14109h() {
        return this.f6723h;
    }

    /* renamed from: i */
    public boolean m14107i() {
        return this.f6724i;
    }

    /* renamed from: j */
    public EnumC1892d m14105j() {
        return this.f6725j;
    }

    /* renamed from: k */
    public BitmapFactory.Options m14103k() {
        return this.f6726k;
    }

    /* renamed from: l */
    public int m14101l() {
        return this.f6727l;
    }

    /* renamed from: m */
    public boolean m14099m() {
        return this.f6728m;
    }

    /* renamed from: n */
    public Object m14097n() {
        return this.f6729n;
    }

    /* renamed from: o */
    public AbstractC1937a m14095o() {
        return this.f6730o;
    }

    /* renamed from: p */
    public AbstractC1937a m14093p() {
        return this.f6731p;
    }

    /* renamed from: q */
    public AbstractC1907a m14091q() {
        return this.f6732q;
    }

    /* renamed from: r */
    public Handler m14089r() {
        return this.f6733r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean m14087s() {
        return this.f6734s;
    }
}
