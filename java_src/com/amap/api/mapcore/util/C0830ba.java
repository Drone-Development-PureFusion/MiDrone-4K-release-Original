package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.amap.api.mapcore.util.ba */
/* loaded from: classes.dex */
public class C0830ba extends Thread {

    /* renamed from: a */
    private Context f2321a;

    /* renamed from: b */
    private C0842bm f2322b;

    public C0830ba(Context context) {
        this.f2321a = context;
        this.f2322b = C0842bm.m18820a(context);
    }

    /* renamed from: a */
    private C0837bh m18887a(File file) {
        String m18335a = C0945eh.m18335a(file);
        C0837bh c0837bh = new C0837bh();
        c0837bh.m18836b(m18335a);
        return c0837bh;
    }

    /* renamed from: a */
    private C0837bh m18886a(String str) {
        C0837bh c0837bh = null;
        String m18987f = C0794ax.m19016a(this.f2321a).m18987f(str);
        File[] listFiles = new File(C0945eh.m18318b(this.f2321a)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if ((file.getName().contains(m18987f) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt") && (c0837bh = m18887a(file)) != null && c0837bh.d() != null) {
                    break;
                }
            }
        }
        return c0837bh;
    }

    /* renamed from: a */
    private void m18888a() {
        C0837bh m18886a;
        ArrayList<C0837bh> m18821a = this.f2322b.m18821a();
        ArrayList<String> m18884b = m18884b();
        ArrayList<String> m18883c = m18883c();
        Iterator<C0837bh> it2 = m18821a.iterator();
        while (it2.hasNext()) {
            C0837bh next = it2.next();
            if (next != null && next.d() != null) {
                if (next.f2360l == 4 || next.f2360l == 7) {
                    if (!m18884b.contains(next.h())) {
                        this.f2322b.m18811b(next);
                    }
                } else if (next.f2360l == 0 || next.f2360l == 1) {
                    if (!(m18883c.contains(next.f()) || m18883c.contains(next.h()))) {
                        this.f2322b.m18811b(next);
                    }
                } else if (next.f2360l == 3 && next.g() != 0) {
                    if (!(m18883c.contains(next.f()) || m18883c.contains(next.h()))) {
                        this.f2322b.m18811b(next);
                    }
                }
            }
        }
        Iterator<String> it3 = m18884b.iterator();
        while (it3.hasNext()) {
            String next2 = it3.next();
            if (!m18885a(next2, m18821a) && (m18886a = m18886a(next2)) != null) {
                this.f2322b.m18819a(m18886a);
            }
        }
        C0794ax m19016a = C0794ax.m19016a(this.f2321a);
        if (m19016a != null) {
            m19016a.m19006a((ArrayList<C0837bh>) null);
        }
    }

    /* renamed from: a */
    private boolean m18885a(String str, ArrayList<C0837bh> arrayList) {
        Iterator<C0837bh> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (str.equals(it2.next().h())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private ArrayList<String> m18884b() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(C0945eh.m18357a(this.f2321a) + "vmap/");
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private ArrayList<String> m18883c() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(C0945eh.m18318b(this.f2321a));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
        }
        return arrayList;
    }

    @Override // java.lang.Thread
    public void destroy() {
        this.f2321a = null;
        this.f2322b = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        m18888a();
    }
}
