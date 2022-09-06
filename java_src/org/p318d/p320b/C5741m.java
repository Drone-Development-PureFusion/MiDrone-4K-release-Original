package org.p318d.p320b;
/* renamed from: org.d.b.m */
/* loaded from: classes2.dex */
public final class C5741m {

    /* renamed from: a */
    private static C5743a f23017a;

    /* renamed from: b */
    private static boolean f23018b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.d.b.m$a */
    /* loaded from: classes2.dex */
    public static final class C5743a extends SecurityManager {
        private C5743a() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private C5741m() {
    }

    /* renamed from: a */
    public static Class<?> m125a() {
        C5743a m122b = m122b();
        if (m122b == null) {
            return null;
        }
        Class<?>[] classContext = m122b.getClassContext();
        String name = C5741m.class.getName();
        int i = 0;
        while (i < classContext.length && !name.equals(classContext[i].getName())) {
            i++;
        }
        if (i < classContext.length && i + 2 < classContext.length) {
            return classContext[i + 2];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    /* renamed from: a */
    public static String m124a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static final void m123a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: b */
    private static C5743a m122b() {
        if (f23017a != null) {
            return f23017a;
        }
        if (f23018b) {
            return null;
        }
        f23017a = m120c();
        f23018b = true;
        return f23017a;
    }

    /* renamed from: b */
    public static boolean m121b(String str) {
        String m124a = m124a(str);
        if (m124a == null) {
            return false;
        }
        return m124a.equalsIgnoreCase("true");
    }

    /* renamed from: c */
    private static C5743a m120c() {
        try {
            return new C5743a();
        } catch (SecurityException e) {
            return null;
        }
    }

    /* renamed from: c */
    public static final void m119c(String str) {
        System.err.println("SLF4J: " + str);
    }
}
