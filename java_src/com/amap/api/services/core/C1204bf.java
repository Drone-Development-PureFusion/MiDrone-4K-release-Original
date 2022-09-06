package com.amap.api.services.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.amap.api.services.core.bf */
/* loaded from: classes.dex */
public class C1204bf {

    /* renamed from: a */
    static final String f4079a = "/a/";

    /* renamed from: b */
    static final String f4080b = "b";

    /* renamed from: c */
    static final String f4081c = "c";

    /* renamed from: d */
    static final String f4082d = C0477f.f1054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17166a(Context context) {
        try {
            AbstractC1209bi m17147a = AbstractC1209bi.m17147a(2);
            if (m17147a == null) {
                return;
            }
            m17147a.m17146a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17165a(final Context context, final Throwable th, final int i, final String str, final String str2) {
        try {
            ExecutorService m17182a = C1190ay.m17182a();
            if (m17182a == null || m17182a.isShutdown()) {
                return;
            }
            m17182a.submit(new Runnable() { // from class: com.amap.api.services.core.bf.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC1209bi m17147a = AbstractC1209bi.m17147a(i);
                        if (m17147a == null) {
                            return;
                        }
                        m17147a.m17142a(context, th, str, str2);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m17164b(final Context context) {
        try {
            ExecutorService m17182a = C1190ay.m17182a();
            if (m17182a == null || m17182a.isShutdown()) {
                return;
            }
            m17182a.submit(new Runnable() { // from class: com.amap.api.services.core.bf.2
                /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0067  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    AbstractC1207bg abstractC1207bg;
                    AbstractC1207bg abstractC1207bg2;
                    AbstractC1207bg abstractC1207bg3;
                    Throwable th;
                    Throwable th2;
                    AbstractC1207bg abstractC1207bg4;
                    AbstractC1207bg abstractC1207bg5;
                    AbstractC1207bg abstractC1207bg6 = null;
                    try {
                        abstractC1207bg5 = AbstractC1207bg.m17161a(context, 0);
                        try {
                            abstractC1207bg4 = AbstractC1207bg.m17161a(context, 1);
                            try {
                                try {
                                    abstractC1207bg6 = AbstractC1207bg.m17161a(context, 2);
                                } catch (RejectedExecutionException e) {
                                    if (abstractC1207bg5 != null) {
                                        abstractC1207bg5.m17152c();
                                    }
                                    if (abstractC1207bg4 != null) {
                                        abstractC1207bg4.m17152c();
                                    }
                                    if (0 == 0) {
                                        return;
                                    }
                                    abstractC1207bg6.m17152c();
                                }
                            } catch (Throwable th3) {
                                abstractC1207bg2 = abstractC1207bg5;
                                abstractC1207bg = abstractC1207bg4;
                                abstractC1207bg3 = null;
                                th2 = th3;
                            }
                            try {
                                abstractC1207bg5.m17154b(context);
                                abstractC1207bg4.m17154b(context);
                                abstractC1207bg6.m17154b(context);
                                if (abstractC1207bg5 != null) {
                                    abstractC1207bg5.m17152c();
                                }
                                if (abstractC1207bg4 != null) {
                                    abstractC1207bg4.m17152c();
                                }
                                if (abstractC1207bg6 == null) {
                                    return;
                                }
                            } catch (Throwable th4) {
                                abstractC1207bg2 = abstractC1207bg5;
                                abstractC1207bg = abstractC1207bg4;
                                abstractC1207bg3 = abstractC1207bg6;
                                th = th4;
                                if (abstractC1207bg2 != null) {
                                }
                                if (abstractC1207bg != null) {
                                }
                                if (abstractC1207bg3 != null) {
                                }
                                throw th;
                            }
                        } catch (RejectedExecutionException e2) {
                            abstractC1207bg4 = null;
                        } catch (Throwable th5) {
                            abstractC1207bg2 = abstractC1207bg5;
                            abstractC1207bg = null;
                            th2 = th5;
                            abstractC1207bg3 = null;
                        }
                    } catch (RejectedExecutionException e3) {
                        abstractC1207bg4 = null;
                        abstractC1207bg5 = null;
                    } catch (Throwable th6) {
                        abstractC1207bg = null;
                        abstractC1207bg2 = null;
                        abstractC1207bg3 = null;
                        th = th6;
                    }
                    abstractC1207bg6.m17152c();
                }
            });
        } catch (Throwable th) {
            C1190ay.m17177a(th, "Log", "processLog");
            th.printStackTrace();
        }
    }
}
