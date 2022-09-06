package com.amap.api.services.core;

import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.amap.api.services.core.bj */
/* loaded from: classes.dex */
public class C1210bj {
    /* renamed from: a */
    public static String m17128a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
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
    static synchronized java.lang.String m17127a(java.lang.Throwable r7) {
        /*
            r0 = 0
            java.lang.Class<com.amap.api.services.core.bj> r4 = com.amap.api.services.core.C1210bj.class
            monitor-enter(r4)
            java.io.StringWriter r3 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L37
            r3.<init>()     // Catch: java.lang.Throwable -> L37
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L7e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7e
            r7.printStackTrace(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.Throwable r1 = r7.getCause()     // Catch: java.lang.Throwable -> L81
        L15:
            if (r1 == 0) goto L1f
            r1.printStackTrace(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.Throwable r1 = r1.getCause()     // Catch: java.lang.Throwable -> L81
            goto L15
        L1f:
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "\n"
            java.lang.String r6 = "<br/>"
            java.lang.String r0 = r1.replaceAll(r5, r6)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L30
            r3.close()     // Catch: java.lang.Throwable -> L6e
        L30:
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.lang.Throwable -> L73
        L35:
            monitor-exit(r4)
            return r0
        L37:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L3a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto L42
            r3.close()     // Catch: java.lang.Throwable -> L69
        L42:
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.lang.Throwable -> L48
            goto L35
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L35
        L4d:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L50:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L54:
            if (r3 == 0) goto L59
            r3.close()     // Catch: java.lang.Throwable -> L5f
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.lang.Throwable -> L64
        L5e:
            throw r0     // Catch: java.lang.Throwable -> L4d
        L5f:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L59
        L64:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L5e
        L69:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L42
        L6e:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L30
        L73:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            goto L35
        L78:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L54
        L7c:
            r0 = move-exception
            goto L54
        L7e:
            r1 = move-exception
            r2 = r0
            goto L3a
        L81:
            r1 = move-exception
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.C1210bj.m17127a(java.lang.Throwable):java.lang.String");
    }
}
