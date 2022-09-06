package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C1036gn;
import com.amap.api.mapcore.util.C1043gr;
import dalvik.system.DexFile;
import java.io.File;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.mapcore.util.go */
/* loaded from: classes.dex */
public class C1039go extends AbstractC1033gk {

    /* renamed from: g */
    private PublicKey f3244g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1039go(Context context, C0996fh c0996fh, boolean z) {
        super(context, c0996fh, z);
        String m17881b = C1036gn.m17881b(context, c0996fh.m18074a(), c0996fh.m18070b());
        String m17894a = C1036gn.m17894a(context);
        m17865b(m17881b, m17894a);
        File file = new File(m17881b);
        if (z) {
            m17869a(m17881b, m17894a + File.separator + C1036gn.m17884a(file.getName()));
            m17867b(context, m17881b, m17894a);
        }
    }

    /* renamed from: a */
    private void m17873a(C1016fu c1016fu, File file) {
        C1043gr m17877a = C1036gn.C1038a.m17877a(c1016fu, file.getName());
        if (m17877a != null) {
            this.f3237f = m17877a.m17846e();
        }
    }

    /* renamed from: a */
    private void m17868a(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
            } while (inputStream.read(new byte[8192]) > 0);
        } catch (Throwable th) {
            try {
                C1045gs.m17831a(th, "DyLoader", "loadJa");
                try {
                    C1045gs.m17833a(inputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } finally {
                try {
                    C1045gs.m17833a(inputStream);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m17874a(C1016fu c1016fu, C0996fh c0996fh, String str) {
        if (m17871a(new File(str))) {
            return C1045gs.m17834a(c1016fu, C1036gn.m17886a(this.f3232a, c0996fh.m18074a(), c0996fh.m18070b()), str, c0996fh);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17872a(C1016fu c1016fu, String str, String str2) {
        String m17887a = C1036gn.m17887a(this.f3232a, str);
        if (C1045gs.m17834a(c1016fu, str, m17887a, this.f3236e)) {
            return true;
        }
        if (C1036gn.C1038a.m17877a(c1016fu, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f3237f)) {
            C1036gn.C1038a.m17878a(c1016fu, new C1043gr.C1044a(str, C0992fe.m18095a(m17887a), this.f3236e.m18074a(), this.f3236e.m18070b(), str2).m17842a("useod").m17844a(), C1043gr.m17851b(str));
        }
        return true;
    }

    /* renamed from: a */
    private boolean m17871a(File file) {
        JarFile jarFile;
        boolean z = false;
        try {
            m17864c();
            jarFile = new JarFile(file);
        } catch (Throwable th) {
            th = th;
            jarFile = null;
        }
        try {
            JarEntry jarEntry = jarFile.getJarEntry("classes.dex");
            if (jarEntry != null) {
                m17868a(jarFile, jarEntry);
                Certificate[] certificates = jarEntry.getCertificates();
                if (certificates != null) {
                    z = m17870a(file, certificates);
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable th2) {
                        }
                    }
                } else if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable th3) {
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                C1045gs.m17831a(th, "DyLoader", "verify");
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable th5) {
                    }
                }
                return z;
            } finally {
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable th6) {
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m17870a(File file, Certificate[] certificateArr) {
        int length;
        try {
            if (certificateArr.length > 0 && certificateArr.length - 1 >= 0) {
                certificateArr[length].verify(this.f3244g);
                return true;
            }
        } catch (Exception e) {
            C1045gs.m17831a(e, "DyLoader", "check");
        }
        return false;
    }

    /* renamed from: b */
    private void m17867b(final Context context, final String str, final String str2) {
        C1007fo.m18011c().submit(new Runnable() { // from class: com.amap.api.mapcore.util.go.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1039go.this.m17875a(context, str, str2);
                } catch (Throwable th) {
                    C1045gs.m17831a(th, "dLoader", "run()");
                }
            }
        });
    }

    /* renamed from: b */
    private void m17866b(C1016fu c1016fu, File file) {
        this.f3235d = false;
        C1036gn.m17890a(this.f3232a, c1016fu, file.getName());
        String m17892a = C1036gn.m17892a(this.f3232a, c1016fu, this.f3236e);
        if (!TextUtils.isEmpty(m17892a)) {
            this.f3237f = m17892a;
            C1036gn.m17893a(this.f3232a, this.f3236e);
        }
    }

    /* renamed from: b */
    private void m17865b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
    }

    /* renamed from: c */
    private void m17864c() {
        if (this.f3244g != null) {
            return;
        }
        this.f3244g = C1045gs.m17836a();
    }

    /* renamed from: a */
    void m17875a(Context context, String str, String str2) {
        C1016fu c1016fu;
        File file;
        new Date().getTime();
        try {
            c1016fu = new C1016fu(context, C1042gq.m17861a());
            file = new File(str);
            m17873a(c1016fu, file);
            if (!m17874a(c1016fu, this.f3236e, file.getAbsolutePath())) {
                m17866b(c1016fu, file);
            }
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dLoader", "verifyD()");
        }
        if (!file.exists()) {
            return;
        }
        if (new File(str2 + File.separator + C1036gn.m17884a(file.getName())).exists() && !m17872a(c1016fu, C1036gn.m17884a(file.getName()), this.f3237f)) {
            C1036gn.m17893a(this.f3232a, this.f3236e);
        }
        new Date().getTime();
    }

    /* renamed from: a */
    void m17869a(String str, String str2) {
        try {
            if (this.f3234c != null) {
                return;
            }
            b();
            this.f3234c = DexFile.loadDex(str, str2, 0);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dLoader", "loadFile");
            throw new Exception("load file fail");
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        try {
            if (this.f3234c == null) {
                throw new ClassNotFoundException(str);
            }
            try {
                synchronized (this.f3233b) {
                    Class cls = this.f3233b.get(str);
                    try {
                        if (cls == null) {
                            cls = this.f3234c.loadClass(str, this);
                            if (cls == null) {
                                throw new ClassNotFoundException(str);
                            }
                            synchronized (this.f3233b) {
                                this.f3233b.put(str, cls);
                            }
                        }
                        return cls;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            C1045gs.m17831a(th3, "dLoader", "findCl");
            throw new ClassNotFoundException(str);
        }
    }
}
