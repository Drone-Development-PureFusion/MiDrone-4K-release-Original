package com.fimi.soul.module.droneFragment;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.fimi.soul.module.droneFragment.g */
/* loaded from: classes.dex */
public class C3185g {

    /* renamed from: a */
    public static int f12120a = 0;

    /* renamed from: b */
    public static int f12121b = 1;

    /* renamed from: c */
    private static AtomicInteger f12122c = new AtomicInteger(f12120a);

    /* renamed from: d */
    private static AtomicInteger f12123d = new AtomicInteger(f12120a);

    /* renamed from: e */
    private static AtomicInteger f12124e = new AtomicInteger(f12120a);

    /* renamed from: f */
    private static AtomicBoolean f12125f = new AtomicBoolean(true);

    /* renamed from: a */
    public static AtomicInteger m9310a() {
        return f12122c;
    }

    /* renamed from: a */
    public static void m9309a(int i) {
        f12124e.set(i);
    }

    /* renamed from: a */
    public static void m9308a(boolean z) {
        f12125f.set(z);
    }

    /* renamed from: b */
    public static AtomicInteger m9307b() {
        return f12123d;
    }

    /* renamed from: b */
    public static void m9306b(int i) {
        f12123d.set(i);
    }

    /* renamed from: c */
    public static AtomicInteger m9305c() {
        return f12124e;
    }

    /* renamed from: c */
    public static void m9304c(int i) {
        f12122c.set(i);
    }

    /* renamed from: d */
    public static AtomicBoolean m9303d() {
        return f12125f;
    }
}
