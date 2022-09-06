package com.baidu.tts.p108l;

import android.text.TextUtils;
import com.baidu.tts.p096e.EnumC1706i;
import com.baidu.tts.p109m.AbstractC1767a;
import java.io.UnsupportedEncodingException;
/* renamed from: com.baidu.tts.l.i */
/* loaded from: classes.dex */
public class C1745i extends AbstractC1767a<C1745i> {

    /* renamed from: a */
    private String f6263a;

    /* renamed from: b */
    private String f6264b;

    /* renamed from: c */
    private String f6265c = "0";

    /* renamed from: d */
    private EnumC1706i f6266d;

    /* renamed from: e */
    private String f6267e;

    public C1745i(String str, String str2) {
        m14738b(str);
        m14734d(str2);
    }

    /* renamed from: a */
    public void m14742a() {
        if (!TextUtils.isEmpty(this.f6267e)) {
            this.f6263a = this.f6267e + this.f6263a;
        }
    }

    /* renamed from: a */
    public void m14741a(EnumC1706i enumC1706i) {
        this.f6266d = enumC1706i;
    }

    /* renamed from: a */
    public void m14740a(String str) {
        this.f6267e = str;
    }

    /* renamed from: b */
    public String m14739b() {
        return this.f6267e;
    }

    /* renamed from: b */
    public void m14738b(String str) {
        this.f6263a = str;
    }

    /* renamed from: c */
    public String m14737c() {
        return this.f6263a;
    }

    /* renamed from: c */
    public void m14736c(String str) {
        this.f6264b = str;
    }

    /* renamed from: d */
    public String m14735d() {
        return this.f6264b;
    }

    /* renamed from: d */
    public void m14734d(String str) {
        if (str == null) {
            str = "0";
        }
        this.f6265c = str;
    }

    /* renamed from: e */
    public byte[] m14733e() {
        try {
            return this.f6263a.getBytes(this.f6264b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public String m14732f() {
        return this.f6265c;
    }

    /* renamed from: g */
    public EnumC1706i m14731g() {
        return this.f6266d;
    }
}
