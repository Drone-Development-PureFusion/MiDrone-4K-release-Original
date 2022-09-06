package com.baidu.tts.p096e;
/* renamed from: com.baidu.tts.e.d */
/* loaded from: classes.dex */
public enum EnumC1701d {
    GB18030("gb18030", "0"),
    BIG5("big5", "1"),
    UTF8("utf-8", "2"),
    GBK("gbk", "4"),
    UNICODE("unicode", "5");
    

    /* renamed from: f */
    private final String f6003f;

    /* renamed from: g */
    private final String f6004g;

    EnumC1701d(String str, String str2) {
        this.f6003f = str;
        this.f6004g = str2;
    }

    /* renamed from: a */
    public static EnumC1701d m14901a(String str) {
        EnumC1701d[] values;
        for (EnumC1701d enumC1701d : values()) {
            if (enumC1701d.m14900b().equals(str)) {
                return enumC1701d;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m14902a() {
        return this.f6003f;
    }

    /* renamed from: b */
    public String m14900b() {
        return this.f6004g;
    }
}
