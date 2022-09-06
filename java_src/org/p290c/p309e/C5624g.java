package org.p290c.p309e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.p299b.C5505c;
import org.p290c.p309e.AbstractC5621e;
import org.p290c.p312f.p313a.C5642e;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.c.e.g */
/* loaded from: classes2.dex */
public class C5624g {

    /* renamed from: a */
    private final List<String> f22725a = new ArrayList();

    /* renamed from: b */
    private final List<Class<?>> f22726b = new ArrayList();

    /* renamed from: c */
    private final List<Throwable> f22727c = new ArrayList();

    /* renamed from: org.c.e.g$a */
    /* loaded from: classes2.dex */
    public static class C5625a extends Exception {
        private static final long serialVersionUID = 1;

        public C5625a(String str) {
            super(str);
        }
    }

    C5624g() {
    }

    /* renamed from: a */
    public static C5624g m518a(String[] strArr) {
        C5624g c5624g = new C5624g();
        c5624g.m513d(strArr);
        return c5624g;
    }

    /* renamed from: a */
    private AbstractC5627i m521a(Throwable th) {
        return AbstractC5627i.m497a(C5624g.class, th);
    }

    /* renamed from: a */
    private AbstractC5627i m519a(AbstractC5627i abstractC5627i) {
        try {
            AbstractC5627i abstractC5627i2 = abstractC5627i;
            for (String str : this.f22725a) {
                abstractC5627i2 = abstractC5627i2.m495a(C5620d.m526a(abstractC5627i2, str));
            }
            return abstractC5627i2;
        } catch (AbstractC5621e.C5622a e) {
            return m521a(e);
        }
    }

    /* renamed from: a */
    private String[] m517a(String[] strArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i != i2) {
            arrayList.add(strArr[i]);
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: d */
    private void m513d(String[] strArr) {
        m514c(m515b(strArr));
    }

    /* renamed from: a */
    public List<String> m522a() {
        return Collections.unmodifiableList(this.f22725a);
    }

    /* renamed from: a */
    public AbstractC5627i m520a(C5593a c5593a) {
        return this.f22727c.isEmpty() ? m519a(AbstractC5627i.m494a(c5593a, (Class[]) this.f22726b.toArray(new Class[this.f22726b.size()]))) : m521a(new C5642e(this.f22727c));
    }

    /* renamed from: b */
    public List<Class<?>> m516b() {
        return Collections.unmodifiableList(this.f22726b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return new java.lang.String[0];
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String[] m515b(String... strArr) {
        int i;
        String substring;
        int i2 = 0;
        while (true) {
            if (i2 == strArr.length) {
                break;
            }
            String str = strArr[i2];
            if (str.equals("--")) {
                return m517a(strArr, i2 + 1, strArr.length);
            }
            if (!str.startsWith("--")) {
                return m517a(strArr, i2, strArr.length);
            }
            if (str.startsWith("--filter=") || str.equals("--filter")) {
                if (str.equals("--filter")) {
                    i = i2 + 1;
                    if (i >= strArr.length) {
                        this.f22727c.add(new C5625a(str + " value not specified"));
                        break;
                    }
                    substring = strArr[i];
                } else {
                    i = i2;
                    substring = str.substring(str.indexOf(61) + 1);
                }
                this.f22725a.add(substring);
                i2 = i;
            } else {
                this.f22727c.add(new C5625a("JUnit knows nothing about the " + str + " option"));
            }
            i2++;
        }
    }

    /* renamed from: c */
    void m514c(String[] strArr) {
        for (String str : strArr) {
            try {
                this.f22726b.add(C5505c.m897a(str));
            } catch (ClassNotFoundException e) {
                this.f22727c.add(new IllegalArgumentException("Could not find class [" + str + "]", e));
            }
        }
    }
}
