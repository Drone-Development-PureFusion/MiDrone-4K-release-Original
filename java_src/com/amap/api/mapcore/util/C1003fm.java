package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.amap.api.mapcore.util.fm */
/* loaded from: classes.dex */
public class C1003fm {

    /* renamed from: a */
    public static final String f3160a = "/a/";

    /* renamed from: b */
    static final String f3161b = "b";

    /* renamed from: c */
    static final String f3162c = "c";

    /* renamed from: d */
    static final String f3163d = C0477f.f1054a;

    /* renamed from: e */
    public static final String f3164e = "e";

    /* renamed from: f */
    public static final String f3165f = "f";

    /* renamed from: a */
    static AbstractC1013fs m18025a(Context context, int i) {
        switch (i) {
            case 0:
                return new C1011fq(i);
            case 1:
                return new C1012fr(i);
            case 2:
                return new C1010fp(i);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static Class<? extends AbstractC1026gd> m18027a(int i) {
        switch (i) {
            case 0:
                return C1020fy.class;
            case 1:
                return C1023ga.class;
            case 2:
                return C1019fx.class;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m18024a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f3160a + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m18026a(Context context) {
        try {
            AbstractC1013fs m18025a = m18025a(context, 2);
            if (m18025a == null) {
                return;
            }
            m18025a.m17986b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m18023a(final Context context, final Throwable th, final int i, final String str, final String str2) {
        try {
            ExecutorService m18011c = C1007fo.m18011c();
            if (m18011c == null || m18011c.isShutdown()) {
                return;
            }
            m18011c.submit(new Runnable() { // from class: com.amap.api.mapcore.util.fm.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC1013fs m18025a = C1003fm.m18025a(context, i);
                        if (m18025a == null) {
                            return;
                        }
                        m18025a.m18001a(context, th, str, str2);
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

    /* renamed from: b */
    public static AbstractC1026gd m18022b(int i) {
        switch (i) {
            case 0:
                return new C1020fy();
            case 1:
                return new C1023ga();
            case 2:
                return new C1019fx();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m18021b(final Context context) {
        try {
            ExecutorService m18011c = C1007fo.m18011c();
            if (m18011c == null || m18011c.isShutdown()) {
                return;
            }
            m18011c.submit(new Runnable() { // from class: com.amap.api.mapcore.util.fm.2
                /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    AbstractC1013fs abstractC1013fs;
                    AbstractC1013fs abstractC1013fs2;
                    AbstractC1013fs abstractC1013fs3;
                    Throwable th;
                    Throwable th2;
                    AbstractC1013fs abstractC1013fs4;
                    AbstractC1013fs abstractC1013fs5;
                    AbstractC1013fs abstractC1013fs6 = null;
                    try {
                        abstractC1013fs5 = C1003fm.m18025a(context, 0);
                        try {
                            abstractC1013fs4 = C1003fm.m18025a(context, 1);
                            try {
                                try {
                                    abstractC1013fs6 = C1003fm.m18025a(context, 2);
                                    try {
                                        abstractC1013fs5.m17980c(context);
                                        abstractC1013fs4.m17980c(context);
                                        abstractC1013fs6.m17980c(context);
                                        C1081hj.m17677a(context);
                                        C1079hh.m17690a(context);
                                        if (abstractC1013fs5 != null) {
                                            abstractC1013fs5.m17981c();
                                        }
                                        if (abstractC1013fs4 != null) {
                                            abstractC1013fs4.m17981c();
                                        }
                                        if (abstractC1013fs6 == null) {
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        abstractC1013fs2 = abstractC1013fs5;
                                        abstractC1013fs = abstractC1013fs4;
                                        abstractC1013fs3 = abstractC1013fs6;
                                        th2 = th3;
                                        try {
                                            C1002fl.m18028a(th2, "Log", "processLog");
                                            if (abstractC1013fs2 != null) {
                                                abstractC1013fs2.m17981c();
                                            }
                                            if (abstractC1013fs != null) {
                                                abstractC1013fs.m17981c();
                                            }
                                            if (abstractC1013fs3 == null) {
                                                return;
                                            }
                                            abstractC1013fs3.m17981c();
                                            return;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            if (abstractC1013fs2 != null) {
                                                abstractC1013fs2.m17981c();
                                            }
                                            if (abstractC1013fs != null) {
                                                abstractC1013fs.m17981c();
                                            }
                                            if (abstractC1013fs3 != null) {
                                                abstractC1013fs3.m17981c();
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (RejectedExecutionException e) {
                                    if (abstractC1013fs5 != null) {
                                        abstractC1013fs5.m17981c();
                                    }
                                    if (abstractC1013fs4 != null) {
                                        abstractC1013fs4.m17981c();
                                    }
                                    if (0 == 0) {
                                        return;
                                    }
                                    abstractC1013fs6.m17981c();
                                }
                            } catch (Throwable th5) {
                                abstractC1013fs2 = abstractC1013fs5;
                                abstractC1013fs = abstractC1013fs4;
                                abstractC1013fs3 = null;
                                th = th5;
                            }
                        } catch (RejectedExecutionException e2) {
                            abstractC1013fs4 = null;
                        } catch (Throwable th6) {
                            abstractC1013fs2 = abstractC1013fs5;
                            abstractC1013fs = null;
                            th = th6;
                            abstractC1013fs3 = null;
                        }
                    } catch (RejectedExecutionException e3) {
                        abstractC1013fs4 = null;
                        abstractC1013fs5 = null;
                    } catch (Throwable th7) {
                        abstractC1013fs = null;
                        abstractC1013fs2 = null;
                        abstractC1013fs3 = null;
                        th = th7;
                    }
                    abstractC1013fs6.m17981c();
                }
            });
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Log", "processLog");
        }
    }

    /* renamed from: c */
    public static String m18020c(int i) {
        switch (i) {
            case 0:
                return f3162c;
            case 1:
                return f3161b;
            case 2:
                return f3163d;
            default:
                return "";
        }
    }
}
