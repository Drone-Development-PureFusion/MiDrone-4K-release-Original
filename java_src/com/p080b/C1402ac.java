package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import com.p080b.C1399ab;
import com.p080b.C1407ag;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.ac */
/* loaded from: classes.dex */
public class C1402ac extends ClassLoader {

    /* renamed from: c */
    private static C1402ac f4817c = null;

    /* renamed from: h */
    private static boolean f4818h = true;

    /* renamed from: b */
    private final Context f4820b;

    /* renamed from: f */
    private String f4823f;

    /* renamed from: g */
    private C1549dv f4824g;

    /* renamed from: d */
    private final Map<String, Class<?>> f4821d = new HashMap();

    /* renamed from: e */
    private DexFile f4822e = null;

    /* renamed from: a */
    volatile boolean f4819a = true;

    private C1402ac(Context context, ClassLoader classLoader) {
        super(classLoader);
        this.f4820b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.b.ac$1] */
    /* renamed from: a */
    public static synchronized C1402ac m16437a(final Context context, C1549dv c1549dv, final String str, final String str2, String str3, ClassLoader classLoader) {
        C1402ac c1402ac = null;
        synchronized (C1402ac.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                C1404ad.m16426a(context, c1549dv);
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    if (f4817c == null) {
                        new Date().getTime();
                        f4817c = new C1402ac(context.getApplicationContext(), classLoader);
                        f4817c.f4824g = c1549dv;
                        f4817c.m16429a(str, str2 + File.separator + C1399ab.m16447a(file.getName()));
                        new Date().getTime();
                        new Thread() { // from class: com.b.ac.1
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    C1402ac.f4817c.m16435a(context, str, str2);
                                } catch (Throwable th) {
                                    C1450b.m16187a(th, "DynamicClassLoader", "getInstance()");
                                }
                            }
                        }.start();
                    }
                    c1402ac = f4817c;
                } else if (f4818h && parentFile != null && parentFile.exists()) {
                    C1399ab.m16443b(context, c1549dv.m15580a(), c1549dv.m15578b());
                    f4818h = false;
                }
            }
        }
        return c1402ac;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m16436a(Context context, C1549dv c1549dv, String str, String str2, String str3, ClassLoader classLoader, String str4) {
        synchronized (C1402ac.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String str5 = str2 + File.separator + C1399ab.m16447a(file.getName());
                    DexFile loadDex = DexFile.loadDex(str, str5, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        m16430a(new File(str5), str5, str4, new C1565k(context, C1405ae.m16425c()), c1549dv);
                    }
                } else if (f4818h && parentFile != null && parentFile.exists()) {
                    C1399ab.m16443b(context, c1549dv.m15580a(), c1549dv.m15578b());
                    f4818h = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16435a(Context context, String str, String str2) {
        C1565k c1565k;
        File file;
        new Date().getTime();
        try {
            c1565k = new C1565k(context, C1405ae.m16425c());
            file = new File(str);
            m16432a(c1565k, file.getName());
            if (!m16433a(c1565k, this.f4824g, file.getAbsolutePath())) {
                this.f4819a = false;
                C1399ab.m16444b(this.f4820b, c1565k, file.getName());
                String m16455a = C1399ab.m16455a(this.f4820b, c1565k, this.f4824g);
                if (!TextUtils.isEmpty(m16455a)) {
                    this.f4823f = m16455a;
                    m16436a(this.f4820b, this.f4824g, str, str2, null, this.f4820b.getClassLoader(), m16455a);
                }
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "DynamicClassLoader", "verifyDynamicSDK()");
        }
        if (!file.exists()) {
            return;
        }
        String str3 = str2 + File.separator + C1399ab.m16447a(file.getName());
        File file2 = new File(str3);
        if (file2.exists() && !m16431a(c1565k, C1399ab.m16447a(file.getName()), this.f4823f)) {
            m16429a(str, str2 + File.separator + C1399ab.m16447a(file.getName()));
            m16430a(file2, str3, this.f4823f, c1565k, this.f4824g);
        }
        new Date().getTime();
    }

    /* renamed from: a */
    private void m16432a(C1565k c1565k, String str) {
        C1407ag m16439a = C1399ab.C1401a.m16439a(c1565k, str);
        if (m16439a != null) {
            this.f4823f = m16439a.m16412e();
        }
    }

    /* renamed from: a */
    private static void m16430a(File file, String str, String str2, C1565k c1565k, C1549dv c1549dv) {
        if (!TextUtils.isEmpty(str2)) {
            String m15599a = C1545ds.m15599a(str);
            if (TextUtils.isEmpty(m15599a)) {
                return;
            }
            String name = file.getName();
            C1399ab.C1401a.m16440a(c1565k, new C1407ag.C1408a(name, m15599a, c1549dv.m15580a(), c1549dv.m15578b(), str2).m16408a("useodex").m16410a(), C1406af.m16419b(name));
        }
    }

    /* renamed from: a */
    private void m16429a(String str, String str2) {
        try {
            this.f4821d.clear();
            m16427c();
            this.f4822e = DexFile.loadDex(str, str2, 0);
        } catch (IOException e) {
            C1450b.m16187a(e, "DynamicClassLoader", "loadDexFile()");
        } catch (Throwable th) {
            C1450b.m16187a(th, "DynamicClassLoader", "loadDexFile()");
        }
    }

    /* renamed from: a */
    private boolean m16433a(C1565k c1565k, C1549dv c1549dv, String str) {
        return C1399ab.m16448a(c1565k, C1399ab.m16442b(c1549dv.m15580a(), c1549dv.m15578b()), str, c1549dv);
    }

    /* renamed from: a */
    private boolean m16431a(C1565k c1565k, String str, String str2) {
        String m16451a = C1399ab.m16451a(this.f4820b, str);
        if (C1399ab.m16448a(c1565k, str, m16451a, this.f4824g)) {
            return true;
        }
        if (C1399ab.C1401a.m16439a(c1565k, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f4823f)) {
            C1399ab.C1401a.m16440a(c1565k, new C1407ag.C1408a(str, C1545ds.m15599a(m16451a), this.f4824g.m15580a(), this.f4824g.m15578b(), str2).m16408a("useodex").m16410a(), C1406af.m16419b(str));
        }
        return true;
    }

    /* renamed from: c */
    private void m16427c() {
        if (this.f4822e != null) {
            try {
                this.f4822e.close();
            } catch (IOException e) {
                C1450b.m16187a(e, "DynamicClassLoader", "releaseDexFile()");
            } catch (Throwable th) {
                C1450b.m16187a(th, "DynamicClassLoader", "releaseDexFile()");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m16438a() {
        return this.f4822e != null;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        try {
            if (this.f4822e == null) {
                throw new ClassNotFoundException(str);
            }
            Class cls = this.f4821d.get(str);
            if (cls == null) {
                cls = this.f4822e.loadClass(str, this);
                this.f4821d.put(str, cls);
                if (cls == null) {
                    throw new ClassNotFoundException(str);
                }
            }
            return cls;
        } catch (Throwable th) {
            C1450b.m16187a(th, "DynamicClassLoader", "findClass()");
            throw new ClassNotFoundException(str);
        }
    }
}
