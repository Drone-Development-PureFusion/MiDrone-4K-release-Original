package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C1043gr;
import dalvik.system.DexFile;
import java.io.File;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.gn */
/* loaded from: classes.dex */
public class C1036gn {

    /* renamed from: com.amap.api.mapcore.util.gn$a */
    /* loaded from: classes.dex */
    public static class C1038a {
        /* renamed from: a */
        public static C1043gr m17877a(C1016fu c1016fu, String str) {
            List m17952b = c1016fu.m17952b(C1043gr.m17851b(str), C1043gr.class);
            if (m17952b == null || m17952b.size() <= 0) {
                return null;
            }
            return (C1043gr) m17952b.get(0);
        }

        /* renamed from: a */
        public static List<C1043gr> m17876a(C1016fu c1016fu, String str, String str2) {
            return c1016fu.m17952b(C1043gr.m17850b(str, str2), C1043gr.class);
        }

        /* renamed from: a */
        public static void m17878a(C1016fu c1016fu, C1043gr c1043gr, String str) {
            c1016fu.m17964a(c1043gr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17894a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17892a(Context context, C1016fu c1016fu, C0996fh c0996fh) {
        List m17952b = c1016fu.m17952b(C1043gr.m17850b(c0996fh.m18074a(), "copy"), C1043gr.class);
        if (m17952b == null || m17952b.size() == 0) {
            return null;
        }
        C1045gs.m17830a(m17952b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m17952b.size()) {
                return null;
            }
            C1043gr c1043gr = (C1043gr) m17952b.get(i2);
            if (C1045gs.m17835a(context, c1016fu, c1043gr.m17856a(), c0996fh)) {
                try {
                    m17891a(context, c1016fu, c0996fh, m17887a(context, c1043gr.m17856a()), c1043gr.m17846e());
                    return c1043gr.m17846e();
                } catch (Throwable th) {
                    C1045gs.m17831a(th, "FileManager", "loadAvailableD");
                }
            } else {
                m17880c(context, c1016fu, c1043gr.m17856a());
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17887a(Context context, String str) {
        return m17894a(context) + File.separator + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17886a(Context context, String str, String str2) {
        return C0992fe.m18092b(str + str2 + C0989fc.m18113q(context)) + ".png";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m17884a(String str) {
        return str + ".o";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17893a(Context context, C0996fh c0996fh) {
        try {
            String m17881b = m17881b(context, c0996fh.m18074a(), c0996fh.m18070b());
            if (!TextUtils.isEmpty(m17881b)) {
                File file = new File(m17881b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String m17887a = m17887a(context, m17884a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(m17881b, m17887a, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        m17888a(context, file, m17887a, c0996fh);
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    m17879c(context, c0996fh.m18074a(), c0996fh.m18070b());
                }
            }
        } catch (Throwable th) {
            C1045gs.m17831a(th, "BaseClassLoader", "getInstanceByThread()");
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: a */
    static void m17891a(android.content.Context r12, com.amap.api.mapcore.util.C1016fu r13, com.amap.api.mapcore.util.C0996fh r14, java.lang.String r15, java.lang.String r16) {
        /*
            r4 = 0
            r2 = 0
            java.lang.String r3 = r14.m18074a()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r0 = r14.m18070b()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = m17886a(r12, r3, r0)     // Catch: java.lang.Throwable -> Lb7
            m17890a(r12, r13, r1)     // Catch: java.lang.Throwable -> Lb7
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Lb7
            r0.<init>(r15)     // Catch: java.lang.Throwable -> Lb7
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb7
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lb7
            r0 = 32
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> Lbb
            r7.read(r0)     // Catch: java.lang.Throwable -> Lbb
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = r14.m18070b()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = m17881b(r12, r3, r0)     // Catch: java.lang.Throwable -> Lbb
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lbb
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = "rw"
            r6.<init>(r4, r0)     // Catch: java.lang.Throwable -> Lbb
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L5d
            r0 = 0
        L3b:
            int r5 = r7.read(r2)     // Catch: java.lang.Throwable -> L5d
            if (r5 <= 0) goto L6b
            r8 = 1024(0x400, float:1.435E-42)
            if (r5 != r8) goto L4e
            long r8 = (long) r0     // Catch: java.lang.Throwable -> L5d
            r6.seek(r8)     // Catch: java.lang.Throwable -> L5d
            r6.write(r2)     // Catch: java.lang.Throwable -> L5d
        L4c:
            int r0 = r0 + r5
            goto L3b
        L4e:
            byte[] r8 = new byte[r5]     // Catch: java.lang.Throwable -> L5d
            r9 = 0
            r10 = 0
            java.lang.System.arraycopy(r2, r9, r8, r10, r5)     // Catch: java.lang.Throwable -> L5d
            long r10 = (long) r0     // Catch: java.lang.Throwable -> L5d
            r6.seek(r10)     // Catch: java.lang.Throwable -> L5d
            r6.write(r8)     // Catch: java.lang.Throwable -> L5d
            goto L4c
        L5d:
            r0 = move-exception
            r1 = r6
            r2 = r7
        L60:
            throw r0     // Catch: java.lang.Throwable -> L61
        L61:
            r0 = move-exception
            r6 = r1
            r7 = r2
        L64:
            com.amap.api.mapcore.util.C1045gs.m17833a(r7)     // Catch: java.lang.Throwable -> La4
        L67:
            com.amap.api.mapcore.util.C1045gs.m17833a(r6)     // Catch: java.lang.Throwable -> La9
        L6a:
            throw r0
        L6b:
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r2 = com.amap.api.mapcore.util.C0992fe.m18095a(r0)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.mapcore.util.gr$a r0 = new com.amap.api.mapcore.util.gr$a     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = r14.m18070b()     // Catch: java.lang.Throwable -> L5d
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = "used"
            com.amap.api.mapcore.util.gr$a r0 = r0.m17842a(r1)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.mapcore.util.gr r0 = r0.m17844a()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = r0.m17856a()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = com.amap.api.mapcore.util.C1043gr.m17851b(r1)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.mapcore.util.C1036gn.C1038a.m17878a(r13, r0, r1)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.mapcore.util.C1045gs.m17833a(r7)     // Catch: java.lang.Throwable -> L9a
        L96:
            com.amap.api.mapcore.util.C1045gs.m17833a(r6)     // Catch: java.lang.Throwable -> L9f
        L99:
            return
        L9a:
            r0 = move-exception
            r0.printStackTrace()
            goto L96
        L9f:
            r0 = move-exception
            r0.printStackTrace()
            goto L99
        La4:
            r1 = move-exception
            r1.printStackTrace()
            goto L67
        La9:
            r1 = move-exception
            r1.printStackTrace()
            goto L6a
        Lae:
            r0 = move-exception
            r6 = r2
            r7 = r4
            goto L64
        Lb2:
            r0 = move-exception
            r6 = r2
            goto L64
        Lb5:
            r0 = move-exception
            goto L64
        Lb7:
            r0 = move-exception
            r1 = r2
            r2 = r4
            goto L60
        Lbb:
            r0 = move-exception
            r1 = r2
            r2 = r7
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C1036gn.m17891a(android.content.Context, com.amap.api.mapcore.util.fu, com.amap.api.mapcore.util.fh, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17890a(Context context, C1016fu c1016fu, String str) {
        m17880c(context, c1016fu, str);
        m17880c(context, c1016fu, m17884a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17889a(Context context, File file, C0996fh c0996fh) {
        File parentFile = file.getParentFile();
        if (file.exists() || parentFile == null || !parentFile.exists()) {
            return;
        }
        m17879c(context, c0996fh.m18074a(), c0996fh.m18070b());
    }

    /* renamed from: a */
    private static void m17888a(Context context, File file, String str, C0996fh c0996fh) {
        String str2 = null;
        C1016fu c1016fu = new C1016fu(context, C1042gq.m17861a());
        C1043gr m17877a = C1038a.m17877a(c1016fu, file.getName());
        if (m17877a != null) {
            str2 = m17877a.m17846e();
        }
        File file2 = new File(str);
        if (TextUtils.isEmpty(str2) || !file2.exists()) {
            return;
        }
        String m18095a = C0992fe.m18095a(str);
        String name = file2.getName();
        C1038a.m17878a(c1016fu, new C1043gr.C1044a(name, m18095a, c0996fh.m18074a(), c0996fh.m18070b(), str2).m17842a("useod").m17844a(), C1043gr.m17851b(name));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17885a(C1016fu c1016fu, Context context, String str) {
        List<C1043gr> m17876a = C1038a.m17876a(c1016fu, str, "used");
        if (m17876a == null || m17876a.size() <= 0) {
            return;
        }
        for (C1043gr c1043gr : m17876a) {
            if (c1043gr != null && c1043gr.m17849c().equals(str)) {
                m17890a(context, c1016fu, c1043gr.m17856a());
                List m17952b = c1016fu.m17952b(C1043gr.m17854a(str, c1043gr.m17846e()), C1043gr.class);
                if (m17952b != null && m17952b.size() > 0) {
                    C1043gr c1043gr2 = (C1043gr) m17952b.get(0);
                    c1043gr2.m17848c("errorstatus");
                    C1038a.m17878a(c1016fu, c1043gr2, C1043gr.m17851b(c1043gr2.m17856a()));
                    File file = new File(m17887a(context, c1043gr2.m17856a()));
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m17881b(Context context, String str, String str2) {
        return m17887a(context, m17886a(context, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m17882b(Context context, String str) {
        C1016fu c1016fu = new C1016fu(context, C1042gq.m17861a());
        List<C1043gr> m17876a = C1038a.m17876a(c1016fu, str, "copy");
        C1045gs.m17830a(m17876a);
        if (m17876a == null || m17876a.size() <= 1) {
            return;
        }
        int size = m17876a.size();
        for (int i = 1; i < size; i++) {
            m17880c(context, c1016fu, m17876a.get(i).m17856a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m17880c(Context context, C1016fu c1016fu, String str) {
        File file = new File(m17887a(context, str));
        if (file.exists()) {
            file.delete();
        }
        c1016fu.m17961a(C1043gr.m17851b(str), C1043gr.class);
    }

    /* renamed from: c */
    static void m17879c(final Context context, final String str, final String str2) {
        C1007fo.m18011c().submit(new Runnable() { // from class: com.amap.api.mapcore.util.gn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1016fu c1016fu = new C1016fu(context, C1042gq.m17861a());
                    List<C1043gr> m17952b = c1016fu.m17952b(C1043gr.m17855a(str), C1043gr.class);
                    if (m17952b == null || m17952b.size() <= 0) {
                        return;
                    }
                    for (C1043gr c1043gr : m17952b) {
                        if (!str2.equalsIgnoreCase(c1043gr.m17847d())) {
                            C1036gn.m17880c(context, c1016fu, c1043gr.m17856a());
                        }
                    }
                } catch (Throwable th) {
                    C1045gs.m17831a(th, "FileManager", "clearUnSuitableV");
                }
            }
        });
    }
}
