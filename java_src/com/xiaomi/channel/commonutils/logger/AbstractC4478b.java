package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.xiaomi.channel.commonutils.logger.b */
/* loaded from: classes.dex */
public abstract class AbstractC4478b {

    /* renamed from: a */
    private static int f18531a = 2;

    /* renamed from: b */
    private static LoggerInterface f18532b = new C4477a();

    /* renamed from: c */
    private static final HashMap<Integer, Long> f18533c = new HashMap<>();

    /* renamed from: d */
    private static final HashMap<Integer, String> f18534d = new HashMap<>();

    /* renamed from: e */
    private static final Integer f18535e = -1;

    /* renamed from: f */
    private static AtomicInteger f18536f = new AtomicInteger(1);

    /* renamed from: a */
    public static int m5047a() {
        return f18531a;
    }

    /* renamed from: a */
    public static void m5046a(int i, String str) {
        if (i >= f18531a) {
            f18532b.log(str);
        }
    }

    /* renamed from: a */
    public static void m5045a(int i, String str, Throwable th) {
        if (i >= f18531a) {
            f18532b.log(str, th);
        }
    }

    /* renamed from: a */
    public static void m5044a(int i, Throwable th) {
        if (i >= f18531a) {
            f18532b.log("", th);
        }
    }

    /* renamed from: a */
    public static void m5043a(LoggerInterface loggerInterface) {
        f18532b = loggerInterface;
    }

    /* renamed from: a */
    public static void m5042a(Integer num) {
        if (f18531a > 1 || !f18533c.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f18533c.remove(num).longValue();
        f18532b.log(f18534d.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a */
    public static void m5041a(String str) {
        m5046a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    /* renamed from: a */
    public static void m5040a(String str, Throwable th) {
        m5045a(4, str, th);
    }

    /* renamed from: a */
    public static void m5039a(Throwable th) {
        m5044a(4, th);
    }

    /* renamed from: b */
    public static void m5038b(String str) {
        m5046a(0, str);
    }

    /* renamed from: c */
    public static void m5037c(String str) {
        m5046a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    /* renamed from: d */
    public static void m5036d(String str) {
        m5046a(4, str);
    }

    /* renamed from: e */
    public static Integer m5035e(String str) {
        if (f18531a <= 1) {
            Integer valueOf = Integer.valueOf(f18536f.incrementAndGet());
            f18533c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f18534d.put(valueOf, str);
            f18532b.log(str + " starts");
            return valueOf;
        }
        return f18535e;
    }
}
