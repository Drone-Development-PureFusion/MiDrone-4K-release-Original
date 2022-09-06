package com.baidu.tts.p099g.p100a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p096e.EnumC1711n;
import java.util.Hashtable;
/* renamed from: com.baidu.tts.g.a.c */
/* loaded from: classes.dex */
public class C1717c {

    /* renamed from: a */
    private static volatile C1717c f6197a = null;

    /* renamed from: b */
    private Hashtable<EnumC1711n, C1716b> f6198b = new Hashtable<>();

    private C1717c() {
    }

    /* renamed from: a */
    public static C1717c m14880a() {
        if (f6197a == null) {
            synchronized (C1717c.class) {
                if (f6197a == null) {
                    f6197a = new C1717c();
                }
            }
        }
        return f6197a;
    }

    /* renamed from: a */
    public TtsError m14878a(EnumC1711n enumC1711n, int i) {
        return m14877a(enumC1711n, i, null);
    }

    /* renamed from: a */
    public TtsError m14877a(EnumC1711n enumC1711n, int i, String str) {
        return m14876a(enumC1711n, i, str, null);
    }

    /* renamed from: a */
    public TtsError m14876a(EnumC1711n enumC1711n, int i, String str, Throwable th) {
        TtsError m14873b = m14873b(enumC1711n);
        m14873b.setCode(i);
        m14873b.setMessage(str);
        m14873b.setThrowable(th);
        return m14873b;
    }

    /* renamed from: a */
    public TtsError m14875a(EnumC1711n enumC1711n, String str) {
        return m14877a(enumC1711n, 0, str);
    }

    /* renamed from: a */
    public TtsError m14874a(EnumC1711n enumC1711n, Throwable th) {
        TtsError m14873b = m14873b(enumC1711n);
        m14873b.setThrowable(th);
        return m14873b;
    }

    /* renamed from: a */
    public C1716b m14879a(EnumC1711n enumC1711n) {
        C1716b c1716b = this.f6198b.get(enumC1711n);
        if (c1716b == null) {
            C1716b c1716b2 = new C1716b(enumC1711n);
            this.f6198b.put(enumC1711n, c1716b2);
            return c1716b2;
        }
        return c1716b;
    }

    /* renamed from: b */
    public TtsError m14873b(EnumC1711n enumC1711n) {
        C1716b m14879a = m14879a(enumC1711n);
        TtsError ttsError = new TtsError();
        ttsError.setTtsErrorFlyweight(m14879a);
        return ttsError;
    }
}
