package com.baidu.tts.aop.tts;

import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1716b;
/* loaded from: classes.dex */
public class TtsError {

    /* renamed from: a */
    private Throwable f5669a;

    /* renamed from: b */
    private int f5670b;

    /* renamed from: c */
    private String f5671c;

    /* renamed from: d */
    private C1716b f5672d;

    public int getCode() {
        return this.f5670b;
    }

    public int getDetailCode() {
        return this.f5672d != null ? this.f5672d.m14882a(this) : this.f5670b;
    }

    public String getDetailMessage() {
        return this.f5672d != null ? this.f5672d.m14881b(this) : this.f5671c != null ? this.f5671c : "TtsErrorFlyweight is null";
    }

    public EnumC1711n getErrorEnum() {
        if (this.f5672d == null) {
            return null;
        }
        return this.f5672d.a();
    }

    public String getMessage() {
        return this.f5671c;
    }

    public Throwable getThrowable() {
        return this.f5669a;
    }

    public C1716b getTtsErrorFlyweight() {
        return this.f5672d;
    }

    public void setCode(int i) {
        this.f5670b = i;
    }

    public void setMessage(String str) {
        this.f5671c = str;
    }

    public void setThrowable(Throwable th) {
        this.f5669a = th;
    }

    public void setTtsErrorFlyweight(C1716b c1716b) {
        this.f5672d = c1716b;
    }
}
