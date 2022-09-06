package org.p290c.p299b;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.p290c.C5562c;
/* renamed from: org.c.b.d */
/* loaded from: classes2.dex */
public abstract class AbstractC5509d {
    /* renamed from: a */
    private int m895a(Object obj, Object obj2, String str) {
        if (obj == null) {
            C5562c.m757a(str + "expected array was null");
        }
        if (obj2 == null) {
            C5562c.m757a(str + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            C5562c.m757a(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }

    /* renamed from: a */
    private boolean m896a(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    /* renamed from: a */
    protected abstract void mo781a(Object obj, Object obj2);

    /* renamed from: a */
    public void m894a(String str, Object obj, Object obj2) {
        if (obj == obj2 || Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
            return;
        }
        String str2 = str == null ? "" : str + ": ";
        int m895a = m895a(obj, obj2, str2);
        for (int i = 0; i < m895a; i++) {
            Object obj3 = Array.get(obj, i);
            Object obj4 = Array.get(obj2, i);
            if (!m896a(obj3) || !m896a(obj4)) {
                try {
                    mo781a(obj3, obj4);
                } catch (AssertionError e) {
                    throw new C5491a(str2, e, i);
                }
            } else {
                try {
                    m894a(str, obj3, obj4);
                } catch (C5491a e2) {
                    e2.m925a(i);
                    throw e2;
                }
            }
        }
    }
}
