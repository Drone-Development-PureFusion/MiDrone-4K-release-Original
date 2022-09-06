package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.bm */
/* loaded from: classes.dex */
public class C0842bm {

    /* renamed from: a */
    private static volatile C0842bm f2363a;

    /* renamed from: b */
    private static C1016fu f2364b;

    /* renamed from: c */
    private Context f2365c;

    private C0842bm(Context context) {
        this.f2365c = context;
        f2364b = m18812b(this.f2365c);
    }

    /* renamed from: a */
    public static C0842bm m18820a(Context context) {
        if (f2363a == null) {
            synchronized (C0842bm.class) {
                if (f2363a == null) {
                    f2363a = new C0842bm(context);
                }
            }
        }
        return f2363a;
    }

    /* renamed from: a */
    private List<String> m18814a(List<C0839bj> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (C0839bj c0839bj : list) {
                arrayList.add(c0839bj.m18833a());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m18815a(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String m18832a = C0839bj.m18832a(str);
        if (f2364b.m17952b(m18832a, C0839bj.class).size() > 0) {
            f2364b.m17961a(m18832a, C0839bj.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            arrayList.add(new C0839bj(str, str3));
        }
        f2364b.m17956a((List) arrayList);
    }

    /* renamed from: b */
    private C1016fu m18812b(Context context) {
        try {
            return new C1016fu(context, C0841bl.m18822a());
        } catch (Throwable th) {
            C1007fo.m18012b(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private boolean m18813b() {
        if (f2364b == null) {
            f2364b = m18812b(this.f2365c);
        }
        return f2364b != null;
    }

    /* renamed from: a */
    public synchronized C0837bh m18818a(String str) {
        C0837bh c0837bh = null;
        synchronized (this) {
            if (m18813b()) {
                List m17952b = f2364b.m17952b(C0837bh.e(str), C0837bh.class);
                if (m17952b.size() > 0) {
                    c0837bh = (C0837bh) m17952b.get(0);
                }
            }
        }
        return c0837bh;
    }

    /* renamed from: a */
    public ArrayList<C0837bh> m18821a() {
        ArrayList<C0837bh> arrayList = new ArrayList<>();
        if (!m18813b()) {
            return arrayList;
        }
        for (C0837bh c0837bh : f2364b.m17952b("", C0837bh.class)) {
            arrayList.add(c0837bh);
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m18819a(C0837bh c0837bh) {
        if (m18813b()) {
            f2364b.m17964a(c0837bh, C0837bh.f(c0837bh.h()));
            m18815a(c0837bh.f(), c0837bh.m18837b());
        }
    }

    /* renamed from: a */
    public void m18817a(String str, int i, long j, long j2, long j3) {
        if (!m18813b()) {
            return;
        }
        m18816a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
    }

    /* renamed from: a */
    public synchronized void m18816a(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (m18813b()) {
            f2364b.m17964a(new C0838bi(str, j, i, jArr[0], jArr2[0]), C0838bi.m18834a(str));
        }
    }

    /* renamed from: b */
    public synchronized List<String> m18810b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (m18813b()) {
            arrayList.addAll(m18814a(f2364b.m17952b(C0839bj.m18832a(str), C0839bj.class)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized void m18811b(C0837bh c0837bh) {
        if (m18813b()) {
            f2364b.m17961a(C0840bk.m18825f(c0837bh.h()), C0840bk.class);
            f2364b.m17961a(C0839bj.m18832a(c0837bh.f()), C0839bj.class);
            f2364b.m17961a(C0838bi.m18834a(c0837bh.f()), C0838bi.class);
        }
    }

    /* renamed from: c */
    public synchronized void m18809c(String str) {
        if (m18813b()) {
            f2364b.m17961a(C0840bk.m18827e(str), C0840bk.class);
            f2364b.m17961a(C0839bj.m18832a(str), C0839bj.class);
            f2364b.m17961a(C0838bi.m18834a(str), C0838bi.class);
        }
    }

    /* renamed from: d */
    public synchronized String m18808d(String str) {
        String str2;
        str2 = null;
        if (m18813b()) {
            List m17952b = f2364b.m17952b(C0840bk.m18825f(str), C0840bk.class);
            if (m17952b.size() > 0) {
                str2 = ((C0840bk) m17952b.get(0)).m18828e();
            }
        }
        return str2;
    }
}
