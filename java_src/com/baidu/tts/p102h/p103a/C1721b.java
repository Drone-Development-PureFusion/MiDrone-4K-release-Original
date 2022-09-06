package com.baidu.tts.p102h.p103a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.Iterator;
/* renamed from: com.baidu.tts.h.a.b */
/* loaded from: classes.dex */
public class C1721b implements Iterator<C1720a> {

    /* renamed from: a */
    private int f6210a;

    /* renamed from: b */
    private int f6211b;

    /* renamed from: c */
    private int f6212c;

    /* renamed from: d */
    private int f6213d;

    /* renamed from: e */
    private int f6214e;

    /* renamed from: f */
    private int f6215f;

    /* renamed from: d */
    private int m14848d() {
        return (this.f6210a + this.f6211b) - 1;
    }

    /* renamed from: e */
    private int m14847e() {
        return (this.f6213d + this.f6212c) - 1;
    }

    /* renamed from: a */
    public void m14853a() {
        this.f6210a = 0;
        this.f6211b = 0;
        this.f6213d = 0;
        this.f6214e = 0;
        this.f6215f = 0;
    }

    /* renamed from: a */
    public void m14852a(int i) {
        this.f6212c = i;
    }

    /* renamed from: b */
    public void m14851b() {
    }

    /* renamed from: b */
    public void m14850b(int i) {
        this.f6211b += i;
        this.f6215f = 0;
    }

    @Override // java.util.Iterator
    /* renamed from: c */
    public C1720a next() {
        C1720a c1720a = new C1720a();
        int m14847e = m14847e();
        if (m14847e <= m14848d()) {
            int i = (m14847e - this.f6214e) + 1;
            c1720a.m14859a(this.f6215f);
            c1720a.m14856b(i);
            this.f6214e = m14847e + 1;
            this.f6213d = this.f6214e;
            this.f6215f += i;
            float f = this.f6213d / this.f6211b;
            LoggerProxy.m15091d("UtteranceSubpackager", "mCurrentProgressStartIndex=" + this.f6213d + "--mCurrentAllUtteranceLenght=" + this.f6211b + "--percent=" + f);
            c1720a.m14860a(f);
            c1720a.m14858a(true);
        } else {
            int i2 = this.f6211b - this.f6214e;
            c1720a.m14859a(this.f6215f);
            c1720a.m14856b(i2);
            this.f6214e += i2;
            this.f6215f = i2 + this.f6215f;
        }
        return c1720a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6214e < m14848d();
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
