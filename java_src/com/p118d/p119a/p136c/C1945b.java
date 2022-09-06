package com.p118d.p119a.p136c;

import android.opengl.GLES10;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
/* renamed from: com.d.a.c.b */
/* loaded from: classes.dex */
public final class C1945b {

    /* renamed from: a */
    private static final int f6936a = 2048;

    /* renamed from: b */
    private static C1893e f6937b;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f6937b = new C1893e(max, max);
    }

    private C1945b() {
    }

    /* renamed from: a */
    private static int m13867a(int i, int i2, int i3, boolean z) {
        int m14153a = f6937b.m14153a();
        int m14150b = f6937b.m14150b();
        while (true) {
            if (i / i3 > m14153a || i2 / i3 > m14150b) {
                i3 = z ? i3 * 2 : i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* renamed from: a */
    public static int m13866a(C1893e c1893e) {
        int m14153a = c1893e.m14153a();
        int m14150b = c1893e.m14150b();
        return Math.max((int) Math.ceil(m14153a / f6937b.m14153a()), (int) Math.ceil(m14150b / f6937b.m14150b()));
    }

    /* renamed from: a */
    public static int m13865a(C1893e c1893e, C1893e c1893e2, EnumC1896h enumC1896h, boolean z) {
        int min;
        int i = 1;
        int m14153a = c1893e.m14153a();
        int m14150b = c1893e.m14150b();
        int m14153a2 = c1893e2.m14153a();
        int m14150b2 = c1893e2.m14150b();
        switch (enumC1896h) {
            case FIT_INSIDE:
                if (!z) {
                    min = Math.max(m14153a / m14153a2, m14150b / m14150b2);
                    break;
                } else {
                    int i2 = m14153a / 2;
                    int i3 = m14150b / 2;
                    min = 1;
                    while (true) {
                        if (i2 / min <= m14153a2 && i3 / min <= m14150b2) {
                            break;
                        } else {
                            min *= 2;
                        }
                    }
                }
                break;
            case CROP:
                if (!z) {
                    min = Math.min(m14153a / m14153a2, m14150b / m14150b2);
                    break;
                } else {
                    int i4 = m14153a / 2;
                    int i5 = m14150b / 2;
                    min = 1;
                    while (i4 / min > m14153a2 && i5 / min > m14150b2) {
                        min *= 2;
                    }
                }
                break;
            default:
                min = 1;
                break;
        }
        if (min >= 1) {
            i = min;
        }
        return m13867a(m14153a, m14150b, i, z);
    }

    /* renamed from: a */
    public static C1893e m13864a(AbstractC1926a abstractC1926a, C1893e c1893e) {
        int mo13928a = abstractC1926a.mo13928a();
        if (mo13928a <= 0) {
            mo13928a = c1893e.m14153a();
        }
        int mo13923b = abstractC1926a.mo13923b();
        if (mo13923b <= 0) {
            mo13923b = c1893e.m14150b();
        }
        return new C1893e(mo13928a, mo13923b);
    }

    /* renamed from: b */
    public static float m13863b(C1893e c1893e, C1893e c1893e2, EnumC1896h enumC1896h, boolean z) {
        int i;
        int i2;
        int m14153a = c1893e.m14153a();
        int m14150b = c1893e.m14150b();
        int m14153a2 = c1893e2.m14153a();
        int m14150b2 = c1893e2.m14150b();
        float f = m14153a / m14153a2;
        float f2 = m14150b / m14150b2;
        if ((enumC1896h != EnumC1896h.FIT_INSIDE || f < f2) && (enumC1896h != EnumC1896h.CROP || f >= f2)) {
            i = (int) (m14153a / f2);
            i2 = m14150b2;
        } else {
            i = m14153a2;
            i2 = (int) (m14150b / f);
        }
        if ((z || i >= m14153a || i2 >= m14150b) && (!z || i == m14153a || i2 == m14150b)) {
            return 1.0f;
        }
        return i / m14153a;
    }
}
