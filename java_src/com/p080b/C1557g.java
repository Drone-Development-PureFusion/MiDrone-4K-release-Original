package com.p080b;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.b.g */
/* loaded from: classes.dex */
public class C1557g {

    /* renamed from: a */
    static final String f5546a = "/a/";

    /* renamed from: b */
    static final String f5547b = "b";

    /* renamed from: c */
    static final String f5548c = "c";

    /* renamed from: d */
    static final String f5549d = C0477f.f1054a;

    /* renamed from: a */
    static AbstractC1561h m15544a(Context context, int i) {
        switch (i) {
            case 0:
                return new C1555e(i);
            case 1:
                return new C1556f(i);
            case 2:
                return new C1517d(i);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m15546a(int i) {
        switch (i) {
            case 0:
                return C1568n.f5571b;
            case 1:
                return C1568n.f5572c;
            case 2:
                return C1568n.f5573d;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m15545a(Context context) {
        try {
            AbstractC1561h m15544a = m15544a(context, 2);
            if (m15544a == null) {
                return;
            }
            m15544a.m15520b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m15543a(final Context context, final C1549dv c1549dv, final String str) {
        ExecutorService m15874b;
        try {
            if (!c1549dv.m15575e() || (m15874b = C1488c.m15874b()) == null || m15874b.isShutdown()) {
                return;
            }
            m15874b.submit(new Runnable() { // from class: com.b.g.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1557g.m15544a(context, 1).m15532a(c1549dv, context, new Throwable("gpsstatistics"), str, (String) null, (String) null);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m15542a(final Context context, final Throwable th, final int i, final String str, final String str2) {
        try {
            ExecutorService m15874b = C1488c.m15874b();
            if (m15874b == null || m15874b.isShutdown()) {
                return;
            }
            m15874b.submit(new Runnable() { // from class: com.b.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC1561h m15544a = C1557g.m15544a(context, i);
                        if (m15544a == null) {
                            return;
                        }
                        m15544a.m15534a(context, th, str, str2);
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
    public static String m15541b(int i) {
        switch (i) {
            case 0:
                return f5548c;
            case 1:
                return f5547b;
            case 2:
                return f5549d;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m15540b(final Context context) {
        try {
            ExecutorService m15874b = C1488c.m15874b();
            if (m15874b == null || m15874b.isShutdown()) {
                return;
            }
            m15874b.submit(new Runnable() { // from class: com.b.g.3
                /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x005f  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x0064  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    AbstractC1561h abstractC1561h;
                    AbstractC1561h abstractC1561h2;
                    AbstractC1561h abstractC1561h3;
                    Throwable th;
                    Throwable th2;
                    AbstractC1561h abstractC1561h4;
                    AbstractC1561h abstractC1561h5;
                    AbstractC1561h abstractC1561h6 = null;
                    try {
                        abstractC1561h5 = C1557g.m15544a(context, 0);
                        try {
                            abstractC1561h4 = C1557g.m15544a(context, 1);
                        } catch (RejectedExecutionException e) {
                            abstractC1561h4 = null;
                        } catch (Throwable th3) {
                            abstractC1561h2 = abstractC1561h5;
                            abstractC1561h = null;
                            th = th3;
                            abstractC1561h3 = null;
                        }
                    } catch (RejectedExecutionException e2) {
                        abstractC1561h4 = null;
                        abstractC1561h5 = null;
                    } catch (Throwable th4) {
                        abstractC1561h = null;
                        abstractC1561h2 = null;
                        abstractC1561h3 = null;
                        th = th4;
                    }
                    try {
                        try {
                            abstractC1561h6 = C1557g.m15544a(context, 2);
                        } catch (RejectedExecutionException e3) {
                            if (abstractC1561h5 != null) {
                                abstractC1561h5.m15516c();
                            }
                            if (abstractC1561h4 != null) {
                                abstractC1561h4.m15516c();
                            }
                            if (0 == 0) {
                                return;
                            }
                            abstractC1561h6.m15516c();
                        }
                        try {
                            abstractC1561h5.m15515c(context);
                            abstractC1561h4.m15515c(context);
                            abstractC1561h6.m15515c(context);
                            if (abstractC1561h5 != null) {
                                abstractC1561h5.m15516c();
                            }
                            if (abstractC1561h4 != null) {
                                abstractC1561h4.m15516c();
                            }
                            if (abstractC1561h6 == null) {
                                return;
                            }
                            abstractC1561h6.m15516c();
                        } catch (Throwable th5) {
                            abstractC1561h2 = abstractC1561h5;
                            abstractC1561h = abstractC1561h4;
                            abstractC1561h3 = abstractC1561h6;
                            th = th5;
                            if (abstractC1561h2 != null) {
                            }
                            if (abstractC1561h != null) {
                            }
                            if (abstractC1561h3 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        abstractC1561h2 = abstractC1561h5;
                        abstractC1561h = abstractC1561h4;
                        abstractC1561h3 = null;
                        th = th6;
                    }
                }
            });
        } catch (Throwable th) {
            C1450b.m16187a(th, "Log", "processLog");
        }
    }
}
