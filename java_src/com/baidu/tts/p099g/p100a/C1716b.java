package com.baidu.tts.p099g.p100a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p096e.EnumC1711n;
/* renamed from: com.baidu.tts.g.a.b */
/* loaded from: classes.dex */
public class C1716b extends AbstractC1715a {
    public C1716b(EnumC1711n enumC1711n) {
        super(enumC1711n);
    }

    /* renamed from: a */
    public int m14882a(TtsError ttsError) {
        return this.f6196a.m14886b();
    }

    /* renamed from: b */
    public String m14881b(TtsError ttsError) {
        int code = ttsError.getCode();
        String message = ttsError.getMessage();
        Throwable throwable = ttsError.getThrowable();
        String str = "(" + this.f6196a.m14886b() + ")" + this.f6196a.m14885c();
        if (message != null) {
            str = str + "[(" + code + ")" + message + "]";
        } else if (code != 0) {
            str = str + "[(" + code + ")]";
        }
        if (throwable != null) {
            return str + "[(cause)" + throwable.toString() + "]";
        }
        return str;
    }
}
