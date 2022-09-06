package com.xiaomi.channel.commonutils.stats;

import java.util.LinkedList;
/* renamed from: com.xiaomi.channel.commonutils.stats.a */
/* loaded from: classes2.dex */
public class C4502a {

    /* renamed from: a */
    private LinkedList<C4503a> f18582a = new LinkedList<>();

    /* renamed from: com.xiaomi.channel.commonutils.stats.a$a */
    /* loaded from: classes2.dex */
    public static class C4503a {

        /* renamed from: d */
        private static final C4502a f18583d = new C4502a();

        /* renamed from: a */
        public int f18584a;

        /* renamed from: b */
        public String f18585b;

        /* renamed from: c */
        public Object f18586c;

        C4503a(int i, Object obj) {
            this.f18584a = i;
            this.f18586c = obj;
        }
    }

    /* renamed from: a */
    public static C4502a m4965a() {
        return C4503a.f18583d;
    }

    /* renamed from: d */
    private void m4961d() {
        if (this.f18582a.size() > 100) {
            this.f18582a.removeFirst();
        }
    }

    /* renamed from: a */
    public synchronized void m4964a(Object obj) {
        this.f18582a.add(new C4503a(0, obj));
        m4961d();
    }

    /* renamed from: b */
    public synchronized int m4963b() {
        return this.f18582a.size();
    }

    /* renamed from: c */
    public synchronized LinkedList<C4503a> m4962c() {
        LinkedList<C4503a> linkedList;
        linkedList = this.f18582a;
        this.f18582a = new LinkedList<>();
        return linkedList;
    }
}
