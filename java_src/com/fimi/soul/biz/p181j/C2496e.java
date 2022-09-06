package com.fimi.soul.biz.p181j;
/* renamed from: com.fimi.soul.biz.j.e */
/* loaded from: classes.dex */
public class C2496e {

    /* renamed from: a */
    public static C2496e f8618a;

    /* renamed from: d */
    private static EnumC2497a f8619d = EnumC2497a.IDEL;

    /* renamed from: b */
    private double f8620b;

    /* renamed from: c */
    private double f8621c;

    /* renamed from: com.fimi.soul.biz.j.e$a */
    /* loaded from: classes.dex */
    public enum EnumC2497a {
        IDEL,
        SENDDATA,
        QUERY,
        OUTTIME,
        COMPLETE,
        ERROR,
        WAIT,
        SAMEVERSION,
        HANDSHAKE,
        SENDPAGE
    }

    private C2496e() {
    }

    /* renamed from: a */
    public static C2496e m11922a() {
        if (f8618a == null) {
            synchronized (C2496e.class) {
                if (f8618a == null) {
                    f8618a = new C2496e();
                }
            }
        }
        return f8618a;
    }

    /* renamed from: a */
    public void m11921a(double d) {
        this.f8620b = d;
    }

    /* renamed from: a */
    public void m11920a(EnumC2497a enumC2497a) {
        f8619d = enumC2497a;
    }

    /* renamed from: b */
    public EnumC2497a m11919b() {
        return f8619d;
    }

    /* renamed from: b */
    public void m11918b(double d) {
        this.f8621c = d;
    }

    /* renamed from: c */
    public double m11917c() {
        return this.f8620b;
    }

    /* renamed from: d */
    public double m11916d() {
        return this.f8621c;
    }
}
