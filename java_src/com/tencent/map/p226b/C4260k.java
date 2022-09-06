package com.tencent.map.p226b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.tencent.map.b.k */
/* loaded from: classes.dex */
public final class C4260k {

    /* renamed from: a */
    private static int f17703a;

    /* renamed from: b */
    private static int f17704b;

    /* renamed from: c */
    private static int f17705c;

    /* renamed from: d */
    private static int f17706d;

    /* renamed from: e */
    private static int f17707e;

    /* renamed from: f */
    private static int f17708f;

    /* renamed from: g */
    private static ArrayList<C4261a> f17709g;

    /* renamed from: h */
    private static long f17710h;

    /* renamed from: i */
    private static long f17711i;

    /* renamed from: j */
    private static long f17712j;

    /* renamed from: k */
    private static long f17713k;

    /* renamed from: l */
    private static long f17714l;

    /* renamed from: m */
    private static long f17715m;

    /* renamed from: n */
    private static long f17716n;

    /* renamed from: o */
    private static long f17717o;

    /* renamed from: p */
    private static long f17718p;

    /* renamed from: q */
    private static long f17719q;

    /* renamed from: r */
    private static int f17720r;

    /* renamed from: s */
    private static int f17721s;

    /* renamed from: t */
    private static int f17722t;

    /* renamed from: u */
    private static int f17723u;

    /* renamed from: com.tencent.map.b.k$a */
    /* loaded from: classes.dex */
    public static class C4261a {

        /* renamed from: a */
        public long f17724a;

        /* renamed from: b */
        public long f17725b;

        /* renamed from: c */
        public long f17726c;

        /* renamed from: d */
        public long f17727d;

        /* renamed from: e */
        public int f17728e;

        /* renamed from: f */
        public long f17729f;

        /* renamed from: g */
        public int f17730g;

        /* renamed from: h */
        public int f17731h;
    }

    static {
        NetworkInfo activeNetworkInfo;
        String subscriberId;
        f17703a = 10000;
        f17704b = 15000;
        f17705c = 5000;
        f17706d = 20000;
        f17707e = 25000;
        f17708f = 15000;
        f17703a = 12000;
        f17704b = 20000;
        f17705c = 8000;
        f17706d = 20000;
        f17707e = 25000;
        f17708f = 15000;
        ConnectivityManager connectivityManager = (ConnectivityManager) C4262l.m5673b().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return;
        }
        int type = activeNetworkInfo.getType();
        if (!activeNetworkInfo.isConnected() || type != 0 || (subscriberId = ((TelephonyManager) C4262l.m5673b().getSystemService("phone")).getSubscriberId()) == null || subscriberId.length() <= 3 || subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
            return;
        }
        f17703a = 15000;
        f17704b = 25000;
        f17705c = 10000;
        f17706d = 25000;
        f17707e = 35000;
        f17708f = 15000;
    }

    /* renamed from: a */
    public static int m5685a() {
        NetworkInfo activeNetworkInfo;
        int max = (f17712j <= 0 || f17713k <= 0) ? f17703a : (int) ((Math.max(f17715m, f17712j) + f17713k) - f17714l);
        ConnectivityManager connectivityManager = (ConnectivityManager) C4262l.m5673b().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (!activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                max = f17704b;
            } else if (f17713k > 0 && f17713k < f17705c) {
                max = f17705c;
            }
        }
        int i = (f17723u * f17705c) + max;
        if (i <= f17705c) {
            i = f17705c;
        }
        if (i <= f17713k) {
            i = (int) (f17713k + f17705c);
        }
        if (i >= f17704b) {
            i = f17704b;
        }
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b == null) {
            m5679b = m5683a(Thread.currentThread().getId());
        }
        if (i < m5679b.f17730g + f17705c) {
            i = m5679b.f17730g + f17705c;
        }
        m5679b.f17730g = i;
        return i;
    }

    /* renamed from: a */
    private static C4261a m5683a(long j) {
        C4261a c4261a;
        boolean z;
        int i;
        if (f17709g == null) {
            f17709g = new ArrayList<>();
        }
        synchronized (f17709g) {
            if (f17709g.size() > 20) {
                int size = f17709g.size();
                int i2 = 0;
                boolean z2 = false;
                int i3 = 0;
                while (i2 < size / 2) {
                    if (f17709g.get(i3).f17729f > 0 || System.currentTimeMillis() - f17709g.get(i3).f17725b > 600000) {
                        f17709g.remove(i3);
                        z = true;
                        i = i3;
                    } else {
                        boolean z3 = z2;
                        i = i3 + 1;
                        z = z3;
                    }
                    i2++;
                    i3 = i;
                    z2 = z;
                }
                if (z2) {
                    f17709g.get(0);
                    f17710h = 0L;
                    f17709g.get(0);
                    f17711i = 0L;
                    f17713k = f17709g.get(0).f17726c;
                    f17714l = f17709g.get(0).f17726c;
                    f17717o = f17709g.get(0).f17727d;
                    f17718p = f17709g.get(0).f17727d;
                    if (f17709g.get(0).f17729f > 0) {
                        f17720r = (int) ((f17709g.get(0).f17728e * 1000) / f17709g.get(0).f17729f);
                    }
                    f17721s = f17720r;
                    Iterator<C4261a> it2 = f17709g.iterator();
                    while (it2.hasNext()) {
                        C4261a next = it2.next();
                        if (0 > f17710h) {
                            f17710h = 0L;
                        }
                        if (0 < f17711i) {
                            f17711i = 0L;
                        }
                        if (next.f17726c > f17713k) {
                            f17713k = next.f17726c;
                        }
                        if (next.f17726c < f17714l) {
                            f17714l = next.f17726c;
                        }
                        if (next.f17727d > f17717o) {
                            f17717o = next.f17727d;
                        }
                        if (next.f17727d < f17718p) {
                            f17718p = next.f17727d;
                        }
                        if (next.f17729f > 0) {
                            int i4 = (int) ((next.f17728e * 1000) / next.f17729f);
                            if (i4 > f17720r) {
                                f17720r = i4;
                            }
                            if (i4 < f17721s) {
                                f17721s = i4;
                            }
                        }
                    }
                }
            }
            c4261a = new C4261a();
            c4261a.f17724a = j;
            f17709g.add(c4261a);
        }
        return c4261a;
    }

    /* renamed from: a */
    public static void m5684a(int i) {
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b == null) {
            return;
        }
        m5679b.f17729f = System.currentTimeMillis() - m5679b.f17725b;
        m5679b.f17725b = System.currentTimeMillis();
        m5679b.f17728e = i;
        int i2 = (int) ((i * 1000) / (m5679b.f17729f == 0 ? 1L : m5679b.f17729f));
        f17722t = i2;
        f17720r = i2 > f17720r ? f17722t : f17720r;
        f17721s = f17722t < f17721s ? f17722t : f17721s == 0 ? f17722t : f17721s;
        if (f17709g != null) {
            synchronized (f17709g) {
                Iterator<C4261a> it2 = f17709g.iterator();
                while (it2.hasNext()) {
                    C4261a next = it2.next();
                    int i3 = next.f17728e;
                    long j = next.f17729f;
                }
            }
        }
        if (f17723u > 0 && m5679b.f17726c < f17705c && m5679b.f17727d < f17708f) {
            f17723u--;
        }
        m5679b.f17730g = (int) m5679b.f17726c;
    }

    /* renamed from: a */
    public static void m5682a(HttpURLConnection httpURLConnection) {
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b == null) {
            m5679b = m5683a(Thread.currentThread().getId());
        }
        if (m5679b == null) {
            return;
        }
        m5679b.f17725b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public static void m5681a(boolean z) {
        if (!z) {
            f17723u++;
        }
        C4261a m5677c = m5677c(Thread.currentThread().getId());
        if (m5677c != null) {
            long j = m5677c.f17725b;
        }
    }

    /* renamed from: b */
    public static int m5680b() {
        NetworkInfo activeNetworkInfo;
        int max = (f17716n <= 0 || f17717o <= 0) ? f17706d : (int) ((Math.max(f17719q, f17716n) + f17717o) - f17718p);
        ConnectivityManager connectivityManager = (ConnectivityManager) C4262l.m5673b().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (!activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                max = f17707e;
            } else if (f17717o > 0 && f17717o < f17708f) {
                max = f17708f;
            }
        }
        int i = (f17723u * f17705c) + max;
        if (i <= f17708f) {
            i = f17708f;
        }
        if (i <= f17717o) {
            i = (int) (f17717o + f17708f);
        }
        if (i >= f17707e) {
            i = f17707e;
        }
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b != null) {
            if (i < m5679b.f17731h + f17708f) {
                i = m5679b.f17731h + f17708f;
            }
            if (i < m5679b.f17730g + f17708f) {
                i = m5679b.f17730g + f17708f;
            }
            m5679b.f17731h = i;
        }
        return i;
    }

    /* renamed from: b */
    private static C4261a m5679b(long j) {
        C4261a c4261a;
        if (f17709g == null) {
            return null;
        }
        synchronized (f17709g) {
            Iterator<C4261a> it2 = f17709g.iterator();
            while (true) {
                if (it2.hasNext()) {
                    c4261a = it2.next();
                    if (c4261a.f17724a == j) {
                        break;
                    }
                } else {
                    c4261a = null;
                    break;
                }
            }
        }
        return c4261a;
    }

    /* renamed from: c */
    private static C4261a m5677c(long j) {
        if (f17709g != null) {
            synchronized (f17709g) {
                for (int size = f17709g.size() - 1; size >= 0; size--) {
                    if (f17709g.get(size).f17724a == j) {
                        return f17709g.remove(size);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public static void m5678c() {
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b == null) {
            return;
        }
        m5679b.f17726c = System.currentTimeMillis() - m5679b.f17725b;
        m5679b.f17725b = System.currentTimeMillis();
        f17715m = m5679b.f17726c;
        f17713k = m5679b.f17726c > f17713k ? m5679b.f17726c : f17713k;
        f17714l = m5679b.f17726c < f17714l ? m5679b.f17726c : f17714l == 0 ? m5679b.f17726c : f17714l;
        if (f17709g == null) {
            return;
        }
        synchronized (f17709g) {
            Iterator<C4261a> it2 = f17709g.iterator();
            int i = 0;
            while (it2.hasNext()) {
                C4261a next = it2.next();
                if (next.f17726c > 0) {
                    f17712j += next.f17726c;
                    i++;
                }
            }
            if (i > 0) {
                f17712j /= i;
            }
        }
    }

    /* renamed from: d */
    public static void m5676d() {
        C4261a m5679b = m5679b(Thread.currentThread().getId());
        if (m5679b == null) {
            return;
        }
        m5679b.f17727d = System.currentTimeMillis() - m5679b.f17725b;
        m5679b.f17725b = System.currentTimeMillis();
        f17719q = m5679b.f17727d;
        f17717o = m5679b.f17727d > f17717o ? m5679b.f17727d : f17717o;
        f17718p = m5679b.f17727d < f17718p ? m5679b.f17727d : f17718p == 0 ? m5679b.f17727d : f17718p;
        if (f17709g == null) {
            return;
        }
        synchronized (f17709g) {
            Iterator<C4261a> it2 = f17709g.iterator();
            int i = 0;
            while (it2.hasNext()) {
                C4261a next = it2.next();
                if (next.f17727d > 0) {
                    f17716n += next.f17727d;
                    i++;
                }
            }
            if (i > 0) {
                f17716n /= i;
            }
        }
    }
}
