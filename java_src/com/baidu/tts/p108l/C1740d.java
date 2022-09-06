package com.baidu.tts.p108l;

import com.baidu.tts.p096e.EnumC1701d;
import com.baidu.tts.p096e.EnumC1705h;
import com.baidu.tts.p109m.AbstractC1767a;
/* renamed from: com.baidu.tts.l.d */
/* loaded from: classes.dex */
public class C1740d<T> extends AbstractC1767a<T> {

    /* renamed from: a */
    private String f6243a = "5";

    /* renamed from: b */
    private String f6244b = "5";

    /* renamed from: c */
    private String f6245c = "5";

    /* renamed from: d */
    private EnumC1705h f6246d = EnumC1705h.ZH;

    /* renamed from: e */
    private EnumC1701d f6247e = EnumC1701d.UTF8;

    /* renamed from: a */
    public void m14785a(EnumC1701d enumC1701d) {
        this.f6247e = enumC1701d;
    }

    /* renamed from: i */
    public void m14784i(String str) {
        this.f6246d = EnumC1705h.m14894a(str);
    }

    /* renamed from: j */
    public void m14783j(String str) {
        this.f6243a = str;
    }

    /* renamed from: k */
    public void m14782k(String str) {
        this.f6244b = str;
    }

    /* renamed from: l */
    public void m14781l(String str) {
        this.f6245c = str;
    }

    /* renamed from: p */
    public String m14780p() {
        return this.f6247e.m14902a();
    }

    /* renamed from: q */
    public String m14779q() {
        return this.f6247e.m14900b();
    }

    /* renamed from: r */
    public String m14778r() {
        return this.f6246d.m14895a();
    }

    /* renamed from: s */
    public String m14777s() {
        return this.f6243a;
    }

    /* renamed from: t */
    public String m14776t() {
        return this.f6244b;
    }

    /* renamed from: u */
    public String m14775u() {
        return this.f6245c;
    }

    /* renamed from: v */
    public long m14774v() {
        return Long.parseLong(this.f6245c);
    }

    /* renamed from: w */
    public long m14773w() {
        return Long.parseLong(this.f6243a);
    }

    /* renamed from: x */
    public long m14772x() {
        return Long.parseLong(this.f6244b);
    }
}
