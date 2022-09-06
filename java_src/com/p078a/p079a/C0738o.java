package com.p078a.p079a;

import java.util.zip.ZipException;
/* renamed from: com.a.a.o */
/* loaded from: classes.dex */
public class C0738o extends ZipException {
    private static final long serialVersionUID = 4430521921766595597L;

    /* renamed from: a */
    private final C0739a f1823a;

    /* renamed from: b */
    private final C0748w f1824b;

    /* renamed from: com.a.a.o$a */
    /* loaded from: classes.dex */
    public static class C0739a {

        /* renamed from: a */
        public static final C0739a f1825a = new C0739a("encryption");

        /* renamed from: b */
        public static final C0739a f1826b = new C0739a("compression method");

        /* renamed from: c */
        public static final C0739a f1827c = new C0739a("data descriptor");

        /* renamed from: d */
        private final String f1828d;

        private C0739a(String str) {
            this.f1828d = str;
        }

        public String toString() {
            return this.f1828d;
        }
    }

    public C0738o(C0739a c0739a, C0748w c0748w) {
        super("unsupported feature " + c0739a + " used in entry " + c0748w.getName());
        this.f1823a = c0739a;
        this.f1824b = c0748w;
    }

    /* renamed from: a */
    public C0739a m19225a() {
        return this.f1823a;
    }

    /* renamed from: b */
    public C0748w m19224b() {
        return this.f1824b;
    }
}
