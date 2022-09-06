package com.baidu.tts.p096e;
/* renamed from: com.baidu.tts.e.h */
/* loaded from: classes.dex */
public enum EnumC1705h {
    ZH("chinese", "ZH"),
    EN("english", "EN");
    

    /* renamed from: c */
    private final String f6087c;

    /* renamed from: d */
    private final String f6088d;

    EnumC1705h(String str, String str2) {
        this.f6087c = str;
        this.f6088d = str2;
    }

    /* renamed from: a */
    public static EnumC1705h m14894a(String str) {
        EnumC1705h[] values;
        for (EnumC1705h enumC1705h : values()) {
            if (enumC1705h.m14895a().equalsIgnoreCase(str)) {
                return enumC1705h;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m14895a() {
        return this.f6088d;
    }
}
