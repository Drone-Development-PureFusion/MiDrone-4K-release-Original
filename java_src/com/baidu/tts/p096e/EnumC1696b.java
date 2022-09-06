package com.baidu.tts.p096e;
/* renamed from: com.baidu.tts.e.b */
/* loaded from: classes.dex */
public enum EnumC1696b {
    BV("0") { // from class: com.baidu.tts.e.b.1
    },
    AMR("1") { // from class: com.baidu.tts.e.b.2
    },
    OPUS("2") { // from class: com.baidu.tts.e.b.3
    };
    

    /* renamed from: d */
    private final String f5972d;

    EnumC1696b(String str) {
        this.f5972d = str;
    }

    /* renamed from: a */
    public static EnumC1696b m14905a(String str) {
        EnumC1696b[] values;
        for (EnumC1696b enumC1696b : values()) {
            if (enumC1696b.m14906a().equals(str)) {
                return enumC1696b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m14906a() {
        return this.f5972d;
    }
}
