package com.p080b;

import android.content.Context;
import com.p080b.C1407ag;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.ab */
/* loaded from: classes.dex */
public class C1399ab {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.ab$a */
    /* loaded from: classes.dex */
    public static class C1401a {
        C1401a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static C1407ag m16439a(C1565k c1565k, String str) {
            List m15489c = c1565k.m15489c(C1406af.m16419b(str), new C1406af());
            if (m15489c == null || m15489c.size() <= 0) {
                return null;
            }
            return (C1407ag) m15489c.get(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static void m16440a(C1565k c1565k, C1407ag c1407ag, String str) {
            C1406af c1406af = new C1406af();
            c1406af.mo15448a(c1407ag);
            c1565k.m15498a(c1406af, str);
        }
    }

    C1399ab() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16456a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "dex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16455a(Context context, C1565k c1565k, C1549dv c1549dv) {
        List m15489c = c1565k.m15489c(C1406af.m16418b(c1549dv.m15580a(), "copy"), new C1406af());
        if (m15489c == null || m15489c.size() == 0) {
            return null;
        }
        m16445a(m15489c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m15489c.size()) {
                return null;
            }
            C1407ag c1407ag = (C1407ag) m15489c.get(i2);
            if (m16452a(context, c1565k, c1407ag.m16417a(), c1549dv)) {
                try {
                    m16454a(context, c1565k, c1549dv, new C1407ag.C1408a(m16442b(c1549dv.m15580a(), c1549dv.m15578b()), c1407ag.m16415b(), c1549dv.m15580a(), c1549dv.m15578b(), c1407ag.m16412e()).m16408a("usedex").m16410a(), m16451a(context, c1407ag.m16417a()));
                    return c1407ag.m16412e();
                } catch (Throwable th) {
                    C1450b.m16187a(th, "DexFileManager", "loadAvailableDynamicSDKFile");
                }
            } else {
                m16453a(context, c1565k, c1407ag.m16417a());
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16451a(Context context, String str) {
        return m16456a(context) + File.separator + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16450a(Context context, String str, String str2) {
        return m16451a(context, m16442b(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m16447a(String str) {
        return str + ".dex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m16454a(Context context, C1565k c1565k, C1549dv c1549dv, C1407ag c1407ag, String str) {
        ?? r3;
        FileOutputStream fileOutputStream;
        ?? fileInputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                String m15580a = c1549dv.m15580a();
                m16444b(context, c1565k, c1407ag.m16417a());
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(new File(m16450a(context, m15580a, c1549dv.m15578b())), true);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = null;
                    fileOutputStream2 = fileInputStream;
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                C1401a.m16440a(c1565k, c1407ag, C1406af.m16419b(c1407ag.m16417a()));
                if (fileInputStream != 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream2 = fileInputStream;
                try {
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    r3 = fileOutputStream2;
                    fileOutputStream2 = fileOutputStream;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                r3 = fileInputStream;
                if (r3 != 0) {
                }
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            fileOutputStream = null;
        } catch (IOException e10) {
            throw e10;
        } catch (Throwable th5) {
            th = th5;
            r3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m16453a(Context context, C1565k c1565k, String str) {
        m16441c(context, c1565k, str);
    }

    /* renamed from: a */
    public static void m16449a(C1565k c1565k, Context context, C1549dv c1549dv) {
        C1406af c1406af = new C1406af();
        String m15580a = c1549dv.m15580a();
        String m16442b = m16442b(m15580a, c1549dv.m15578b());
        C1407ag m16439a = C1401a.m16439a(c1565k, m16442b);
        if (m16439a != null) {
            m16444b(context, c1565k, m16442b);
            List m15489c = c1565k.m15489c(C1406af.m16422a(m15580a, m16439a.m16412e()), c1406af);
            if (m15489c == null || m15489c.size() <= 0) {
                return;
            }
            C1407ag c1407ag = (C1407ag) m15489c.get(0);
            c1407ag.m16416a("errorstatus");
            C1401a.m16440a(c1565k, c1407ag, C1406af.m16419b(c1407ag.m16417a()));
            File file = new File(m16451a(context, c1407ag.m16417a()));
            if (!file.exists()) {
                return;
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m16445a(List<C1407ag> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() - 1) {
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 < list.size()) {
                        C1407ag c1407ag = list.get(i2);
                        C1407ag c1407ag2 = list.get(i4);
                        if (C1410ah.m16402a(c1407ag2.m16412e(), c1407ag.m16412e()) > 0) {
                            list.set(i2, c1407ag2);
                            list.set(i4, c1407ag);
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    static boolean m16452a(Context context, C1565k c1565k, String str, C1549dv c1549dv) {
        return m16448a(c1565k, str, m16451a(context, str), c1549dv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m16448a(C1565k c1565k, String str, String str2, C1549dv c1549dv) {
        C1407ag m16439a = C1401a.m16439a(c1565k, str);
        return m16439a != null && c1549dv.m15578b().equals(m16439a.m16413d()) && m16446a(str2, m16439a.m16415b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m16446a(String str, String str2) {
        String m15599a = C1545ds.m15599a(str);
        return m15599a != null && m15599a.equalsIgnoreCase(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m16442b(String str, String str2) {
        return C1545ds.m15596b(str + str2) + ".jar";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m16444b(Context context, C1565k c1565k, String str) {
        m16441c(context, c1565k, str);
        m16441c(context, c1565k, m16447a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.b.ab$1] */
    /* renamed from: b */
    public static void m16443b(final Context context, final String str, final String str2) {
        new Thread() { // from class: com.b.ab.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C1565k c1565k = new C1565k(context, C1405ae.m16425c());
                    List<C1407ag> m15489c = c1565k.m15489c(C1406af.m16423a(str), new C1406af());
                    if (m15489c == null || m15489c.size() <= 0) {
                        return;
                    }
                    for (C1407ag c1407ag : m15489c) {
                        if (!str2.equalsIgnoreCase(c1407ag.m16413d())) {
                            C1399ab.m16453a(context, c1565k, c1407ag.m16417a());
                        }
                    }
                } catch (Throwable th) {
                    C1450b.m16187a(th, "DexFileManager", "clearUnSuitableVersion");
                }
            }
        }.start();
    }

    /* renamed from: c */
    private static void m16441c(Context context, C1565k c1565k, String str) {
        File file = new File(m16451a(context, str));
        if (file.exists()) {
            file.delete();
        }
        c1565k.m15496a(C1406af.m16419b(str), new C1406af());
    }
}
