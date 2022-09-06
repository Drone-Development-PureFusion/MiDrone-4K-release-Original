package it.sephiroth.android.library.p240a;

import java.util.Random;
/* renamed from: it.sephiroth.android.library.a.a */
/* loaded from: classes2.dex */
public final class C4884a {

    /* renamed from: a */
    private static final Random f20854a = new Random();

    /* renamed from: b */
    private static final float f20855b = 0.017453292f;

    /* renamed from: c */
    private static final float f20856c = 57.295784f;

    private C4884a() {
    }

    /* renamed from: a */
    public static float m2974a(float f) {
        return f > 0.0f ? f : -f;
    }

    /* renamed from: a */
    public static float m2973a(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    /* renamed from: a */
    public static float m2972a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* renamed from: a */
    public static float m2971a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    /* renamed from: a */
    public static float m2970a(float f, float f2, float f3, float f4, float f5) {
        return ((f3 - f4) * ((f5 - f) / (f2 - f))) + f3;
    }

    /* renamed from: a */
    public static float m2969a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (float) Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
    }

    /* renamed from: a */
    public static float m2967a(int i, int i2) {
        return i > i2 ? i : i2;
    }

    /* renamed from: a */
    public static int m2968a(int i) {
        return (int) (f20854a.nextFloat() * i);
    }

    /* renamed from: a */
    public static int m2966a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* renamed from: a */
    public static long m2964a(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    /* renamed from: a */
    public static void m2965a(long j) {
        f20854a.setSeed(j);
    }

    /* renamed from: b */
    public static float m2963b(float f) {
        return (float) Math.log(f);
    }

    /* renamed from: b */
    public static float m2962b(float f, float f2) {
        return f > f2 ? f : f2;
    }

    /* renamed from: b */
    public static float m2961b(float f, float f2, float f3) {
        return f > f2 ? f > f3 ? f : f3 : f2 > f3 ? f2 : f3;
    }

    /* renamed from: b */
    public static float m2960b(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* renamed from: b */
    public static float m2959b(int i, int i2, int i3) {
        if (i > i2) {
            if (i <= i3) {
                i = i3;
            }
            return i;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        return i2;
    }

    /* renamed from: c */
    public static float m2958c(float f) {
        return (float) Math.exp(f);
    }

    /* renamed from: c */
    public static float m2957c(float f, float f2) {
        return f < f2 ? f : f2;
    }

    /* renamed from: c */
    public static float m2956c(float f, float f2, float f3) {
        return f < f2 ? f < f3 ? f : f3 : f2 < f3 ? f2 : f3;
    }

    /* renamed from: c */
    public static float m2954c(int i, int i2, int i3) {
        if (i < i2) {
            if (i >= i3) {
                i = i3;
            }
            return i;
        }
        if (i2 >= i3) {
            i2 = i3;
        }
        return i2;
    }

    /* renamed from: c */
    public static int m2955c(int i, int i2) {
        return i >= i2 ? i : (int) ((f20854a.nextFloat() * (i2 - i)) + i);
    }

    /* renamed from: d */
    public static float m2953d(float f) {
        return f * f;
    }

    /* renamed from: d */
    public static float m2952d(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    /* renamed from: d */
    public static float m2951d(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    /* renamed from: e */
    public static float m2950e(float f) {
        return f20855b * f;
    }

    /* renamed from: e */
    public static float m2949e(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    /* renamed from: e */
    public static float m2948e(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* renamed from: f */
    public static float m2947f(float f) {
        return f20856c * f;
    }

    /* renamed from: f */
    public static float m2946f(float f, float f2) {
        return f >= f2 ? f : f + (f20854a.nextFloat() * (f2 - f));
    }

    /* renamed from: f */
    public static float m2945f(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* renamed from: g */
    public static float m2944g(float f) {
        return (float) Math.acos(f);
    }

    /* renamed from: h */
    public static float m2943h(float f) {
        return (float) Math.asin(f);
    }

    /* renamed from: i */
    public static float m2942i(float f) {
        return (float) Math.atan(f);
    }

    /* renamed from: j */
    public static float m2941j(float f) {
        return (float) Math.tan(f);
    }

    /* renamed from: k */
    public static float m2940k(float f) {
        return f20854a.nextFloat() * f;
    }
}
