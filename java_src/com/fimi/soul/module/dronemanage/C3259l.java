package com.fimi.soul.module.dronemanage;

import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.fimi.soul.module.dronemanage.l */
/* loaded from: classes.dex */
public class C3259l {

    /* renamed from: a */
    public static final int f12547a = 0;

    /* renamed from: b */
    public static final int f12548b = 1;

    /* renamed from: c */
    public static final int f12549c = 2;

    /* renamed from: d */
    public static final int f12550d = 3;

    /* renamed from: e */
    public static final int f12551e = 4;

    /* renamed from: f */
    public static final int f12552f = 5;

    /* renamed from: g */
    public static final int f12553g = 6;

    /* renamed from: h */
    public static final int f12554h = 7;

    /* renamed from: i */
    private static AtomicInteger f12555i = new AtomicInteger(0);

    /* renamed from: a */
    public static final int m8924a() {
        return f12555i.get();
    }

    /* renamed from: a */
    public static final void m8923a(Integer num) {
        f12555i.set(num.intValue());
    }
}
