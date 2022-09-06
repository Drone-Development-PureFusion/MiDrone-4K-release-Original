package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.AbstractC1333n;
import com.android.volley.C1337o;
import com.android.volley.C1341p;
import com.android.volley.C1384u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* renamed from: com.android.volley.toolbox.k */
/* loaded from: classes.dex */
public class C1366k {

    /* renamed from: a */
    private final C1337o f4669a;

    /* renamed from: c */
    private final AbstractC1372b f4671c;

    /* renamed from: g */
    private Runnable f4675g;

    /* renamed from: b */
    private int f4670b = 100;

    /* renamed from: d */
    private final HashMap<String, C1371a> f4672d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, C1371a> f4673e = new HashMap<>();

    /* renamed from: f */
    private final Handler f4674f = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.android.volley.toolbox.k$a */
    /* loaded from: classes.dex */
    public class C1371a {

        /* renamed from: b */
        private final AbstractC1333n<?> f4685b;

        /* renamed from: c */
        private Bitmap f4686c;

        /* renamed from: d */
        private C1384u f4687d;

        /* renamed from: e */
        private final LinkedList<C1373c> f4688e = new LinkedList<>();

        public C1371a(AbstractC1333n<?> abstractC1333n, C1373c c1373c) {
            this.f4685b = abstractC1333n;
            this.f4688e.add(c1373c);
        }

        /* renamed from: a */
        public C1384u m16607a() {
            return this.f4687d;
        }

        /* renamed from: a */
        public void m16604a(C1373c c1373c) {
            this.f4688e.add(c1373c);
        }

        /* renamed from: a */
        public void m16603a(C1384u c1384u) {
            this.f4687d = c1384u;
        }

        /* renamed from: b */
        public boolean m16601b(C1373c c1373c) {
            this.f4688e.remove(c1373c);
            if (this.f4688e.size() == 0) {
                this.f4685b.m16709l();
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.android.volley.toolbox.k$b */
    /* loaded from: classes.dex */
    public interface AbstractC1372b {
        /* renamed from: a */
        Bitmap mo7560a(String str);

        /* renamed from: a */
        void mo7558a(String str, Bitmap bitmap);
    }

    /* renamed from: com.android.volley.toolbox.k$c */
    /* loaded from: classes.dex */
    public class C1373c {

        /* renamed from: b */
        private Bitmap f4690b;

        /* renamed from: c */
        private final AbstractC1374d f4691c;

        /* renamed from: d */
        private final String f4692d;

        /* renamed from: e */
        private final String f4693e;

        public C1373c(Bitmap bitmap, String str, String str2, AbstractC1374d abstractC1374d) {
            this.f4690b = bitmap;
            this.f4693e = str;
            this.f4692d = str2;
            this.f4691c = abstractC1374d;
        }

        /* renamed from: a */
        public void m16600a() {
            if (this.f4691c == null) {
                return;
            }
            C1371a c1371a = (C1371a) C1366k.this.f4672d.get(this.f4692d);
            if (c1371a != null) {
                if (!c1371a.m16601b(this)) {
                    return;
                }
                C1366k.this.f4672d.remove(this.f4692d);
                return;
            }
            C1371a c1371a2 = (C1371a) C1366k.this.f4673e.get(this.f4692d);
            if (c1371a2 == null) {
                return;
            }
            c1371a2.m16601b(this);
            if (c1371a2.f4688e.size() != 0) {
                return;
            }
            C1366k.this.f4673e.remove(this.f4692d);
        }

        /* renamed from: b */
        public Bitmap m16597b() {
            return this.f4690b;
        }

        /* renamed from: c */
        public String m16596c() {
            return this.f4693e;
        }
    }

    /* renamed from: com.android.volley.toolbox.k$d */
    /* loaded from: classes.dex */
    public interface AbstractC1374d extends C1341p.AbstractC1342a {
        /* renamed from: a */
        void mo7532a(C1373c c1373c, boolean z);
    }

    public C1366k(C1337o c1337o, AbstractC1372b abstractC1372b) {
        this.f4669a = c1337o;
        this.f4671c = abstractC1372b;
    }

    /* renamed from: a */
    public static AbstractC1374d m16622a(final ImageView imageView, final int i, final int i2) {
        return new AbstractC1374d() { // from class: com.android.volley.toolbox.k.1
            @Override // com.android.volley.toolbox.C1366k.AbstractC1374d
            /* renamed from: a */
            public void mo7532a(C1373c c1373c, boolean z) {
                if (c1373c.m16597b() != null) {
                    imageView.setImageBitmap(c1373c.m16597b());
                } else if (i == 0) {
                } else {
                    imageView.setImageResource(i);
                }
            }

            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }
        };
    }

    /* renamed from: a */
    private void m16624a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    /* renamed from: a */
    private void m16615a(String str, C1371a c1371a) {
        this.f4673e.put(str, c1371a);
        if (this.f4675g == null) {
            this.f4675g = new Runnable() { // from class: com.android.volley.toolbox.k.4
                @Override // java.lang.Runnable
                public void run() {
                    for (C1371a c1371a2 : C1366k.this.f4673e.values()) {
                        Iterator it2 = c1371a2.f4688e.iterator();
                        while (it2.hasNext()) {
                            C1373c c1373c = (C1373c) it2.next();
                            if (c1373c.f4691c != null) {
                                if (c1371a2.m16607a() == null) {
                                    c1373c.f4690b = c1371a2.f4686c;
                                    c1373c.f4691c.mo7532a(c1373c, false);
                                } else {
                                    c1373c.f4691c.a(c1371a2.m16607a());
                                }
                            }
                        }
                    }
                    C1366k.this.f4673e.clear();
                    C1366k.this.f4675g = null;
                }
            };
            this.f4674f.postDelayed(this.f4675g, this.f4670b);
        }
    }

    /* renamed from: b */
    private static String m16609b(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append("#S").append(scaleType.ordinal()).append(str).toString();
    }

    /* renamed from: a */
    protected AbstractC1333n<Bitmap> m16617a(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new C1375l(str, new C1341p.AbstractC1343b<Bitmap>() { // from class: com.android.volley.toolbox.k.2
            @Override // com.android.volley.C1341p.AbstractC1343b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo13137a(Bitmap bitmap) {
                C1366k.this.m16616a(str2, bitmap);
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, new C1341p.AbstractC1342a() { // from class: com.android.volley.toolbox.k.3
            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
                C1366k.this.m16611a(str2, c1384u);
            }
        });
    }

    /* renamed from: a */
    public C1373c m16614a(String str, AbstractC1374d abstractC1374d) {
        return m16613a(str, abstractC1374d, 0, 0);
    }

    /* renamed from: a */
    public C1373c m16613a(String str, AbstractC1374d abstractC1374d, int i, int i2) {
        return m16612a(str, abstractC1374d, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* renamed from: a */
    public C1373c m16612a(String str, AbstractC1374d abstractC1374d, int i, int i2, ImageView.ScaleType scaleType) {
        m16624a();
        String m16609b = m16609b(str, i, i2, scaleType);
        Bitmap mo7560a = this.f4671c.mo7560a(m16609b);
        if (mo7560a != null) {
            C1373c c1373c = new C1373c(mo7560a, str, null, null);
            abstractC1374d.mo7532a(c1373c, true);
            return c1373c;
        }
        C1373c c1373c2 = new C1373c(null, str, m16609b, abstractC1374d);
        abstractC1374d.mo7532a(c1373c2, true);
        C1371a c1371a = this.f4672d.get(m16609b);
        if (c1371a != null) {
            c1371a.m16604a(c1373c2);
            return c1373c2;
        }
        AbstractC1333n<Bitmap> m16617a = m16617a(str, i, i2, scaleType, m16609b);
        this.f4669a.m16700a((AbstractC1333n) m16617a);
        this.f4672d.put(m16609b, new C1371a(m16617a, c1373c2));
        return c1373c2;
    }

    /* renamed from: a */
    public void m16623a(int i) {
        this.f4670b = i;
    }

    /* renamed from: a */
    protected void m16616a(String str, Bitmap bitmap) {
        this.f4671c.mo7558a(str, bitmap);
        C1371a remove = this.f4672d.remove(str);
        if (remove != null) {
            remove.f4686c = bitmap;
            m16615a(str, remove);
        }
    }

    /* renamed from: a */
    protected void m16611a(String str, C1384u c1384u) {
        C1371a remove = this.f4672d.remove(str);
        if (remove != null) {
            remove.m16603a(c1384u);
            m16615a(str, remove);
        }
    }

    /* renamed from: a */
    public boolean m16619a(String str, int i, int i2) {
        return m16618a(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* renamed from: a */
    public boolean m16618a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        m16624a();
        return this.f4671c.mo7560a(m16609b(str, i, i2, scaleType)) != null;
    }
}
