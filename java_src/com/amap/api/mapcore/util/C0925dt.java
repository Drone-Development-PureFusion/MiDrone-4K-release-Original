package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.dt */
/* loaded from: classes.dex */
public class C0925dt {

    /* renamed from: b */
    private short[] f2842b;

    /* renamed from: c */
    private float[] f2843c;

    /* renamed from: d */
    private int f2844d;

    /* renamed from: a */
    private final C0944eg f2841a = new C0944eg();

    /* renamed from: e */
    private final C0938ea f2845e = new C0938ea();

    /* renamed from: f */
    private final C0944eg f2846f = new C0944eg();

    /* renamed from: a */
    private static int m18471a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) Math.signum(((f6 - f4) * f) + ((f2 - f6) * f3) + ((f4 - f2) * f5));
    }

    /* renamed from: a */
    private int m18470a(int i) {
        short[] sArr = this.f2842b;
        int i2 = sArr[m18463d(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[m18462e(i)] * 2;
        float[] fArr = this.f2843c;
        return m18471a(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    /* renamed from: a */
    private void m18472a() {
        int[] iArr = this.f2845e.f2881a;
        while (this.f2844d > 3) {
            int m18467b = m18467b();
            m18464c(m18467b);
            int m18463d = m18463d(m18467b);
            if (m18467b == this.f2844d) {
                m18467b = 0;
            }
            iArr[m18463d] = m18470a(m18463d);
            iArr[m18467b] = m18470a(m18467b);
        }
        if (this.f2844d == 3) {
            C0944eg c0944eg = this.f2846f;
            short[] sArr = this.f2842b;
            c0944eg.m18369a(sArr[0]);
            c0944eg.m18369a(sArr[1]);
            c0944eg.m18369a(sArr[2]);
        }
    }

    /* renamed from: b */
    private int m18467b() {
        int i = this.f2844d;
        for (int i2 = 0; i2 < i; i2++) {
            if (m18466b(i2)) {
                return i2;
            }
        }
        int[] iArr = this.f2845e.f2881a;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] != -1) {
                return i3;
            }
        }
        return 0;
    }

    /* renamed from: b */
    private boolean m18466b(int i) {
        int[] iArr = this.f2845e.f2881a;
        if (iArr[i] == -1) {
            return false;
        }
        int m18463d = m18463d(i);
        int m18462e = m18462e(i);
        short[] sArr = this.f2842b;
        int i2 = sArr[m18463d] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[m18462e] * 2;
        float[] fArr = this.f2843c;
        float f = fArr[i2];
        float f2 = fArr[i2 + 1];
        float f3 = fArr[i3];
        float f4 = fArr[i3 + 1];
        float f5 = fArr[i4];
        float f6 = fArr[i4 + 1];
        int m18462e2 = m18462e(m18462e);
        while (true) {
            int i5 = m18462e2;
            if (i5 == m18463d) {
                return true;
            }
            if (iArr[i5] != 1) {
                int i6 = sArr[i5] * 2;
                float f7 = fArr[i6];
                float f8 = fArr[i6 + 1];
                if (m18471a(f5, f6, f, f2, f7, f8) >= 0 && m18471a(f, f2, f3, f4, f7, f8) >= 0 && m18471a(f3, f4, f5, f6, f7, f8) >= 0) {
                    return false;
                }
            }
            m18462e2 = m18462e(i5);
        }
    }

    /* renamed from: b */
    private static boolean m18465b(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = (i + i2) - 3;
        float f = 0.0f;
        for (int i4 = i; i4 < i3; i4 += 2) {
            f += (fArr[i4] * fArr[i4 + 3]) - (fArr[i4 + 1] * fArr[i4 + 2]);
        }
        return ((fArr[(i + i2) + (-2)] * fArr[i + 1]) + f) - (fArr[i] * fArr[(i + i2) + (-1)]) < 0.0f;
    }

    /* renamed from: c */
    private void m18464c(int i) {
        short[] sArr = this.f2842b;
        C0944eg c0944eg = this.f2846f;
        c0944eg.m18369a(sArr[m18463d(i)]);
        c0944eg.m18369a(sArr[i]);
        c0944eg.m18369a(sArr[m18462e(i)]);
        this.f2841a.m18368b(i);
        this.f2845e.m18394b(i);
        this.f2844d--;
    }

    /* renamed from: d */
    private int m18463d(int i) {
        if (i == 0) {
            i = this.f2844d;
        }
        return i - 1;
    }

    /* renamed from: e */
    private int m18462e(int i) {
        return (i + 1) % this.f2844d;
    }

    /* renamed from: a */
    public C0944eg m18469a(float[] fArr) {
        return m18468a(fArr, 0, fArr.length);
    }

    /* renamed from: a */
    public C0944eg m18468a(float[] fArr, int i, int i2) {
        this.f2843c = fArr;
        int i3 = i2 / 2;
        this.f2844d = i3;
        int i4 = i / 2;
        C0944eg c0944eg = this.f2841a;
        c0944eg.m18371a();
        c0944eg.m18367c(i3);
        c0944eg.f2898b = i3;
        short[] sArr = c0944eg.f2897a;
        this.f2842b = sArr;
        if (m18465b(fArr, i, i2)) {
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                sArr[s] = (short) (i4 + s);
            }
        } else {
            int i5 = i3 - 1;
            for (int i6 = 0; i6 < i3; i6++) {
                sArr[i6] = (short) ((i4 + i5) - i6);
            }
        }
        C0938ea c0938ea = this.f2845e;
        c0938ea.m18396a();
        c0938ea.m18393c(i3);
        for (int i7 = 0; i7 < i3; i7++) {
            c0938ea.m18395a(m18470a(i7));
        }
        C0944eg c0944eg2 = this.f2846f;
        c0944eg2.m18371a();
        c0944eg2.m18367c(Math.max(0, i3 - 2) * 3);
        m18472a();
        return c0944eg2;
    }
}
