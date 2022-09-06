package com.baidu.tts.p096e;

import com.fimi.soul.utils.C3686n;
/* renamed from: com.baidu.tts.e.c */
/* loaded from: classes.dex */
public enum EnumC1700c {
    BV_16K("16K", "0"),
    AMR_6K6("6K6", "0"),
    AMR_8K85("16K", "1"),
    AMR_12K65("16K", "2"),
    AMR_14K25("16K", "3"),
    AMR_15K85("16K", "4"),
    AMR_18K25("16K", "5"),
    AMR_19K85("16K", "6"),
    AMR_23K05("16K", C3686n.f15083l),
    AMR_23K85("16K", C3686n.f15084m),
    OPUS_8K("16K", "0"),
    OPUS_16K("16K", "1"),
    OPUS_18K("16K", "2"),
    OPUS_20K("16K", "3"),
    OPUS_24K("16K", "4"),
    OPUS_32K("16K", "5"),
    MP3_8K("16K", "0"),
    MP3_11K("16K", "1"),
    MP3_16K("16K", "2"),
    MP3_24K("16K", "3"),
    MP3_32K("16K", "4");
    

    /* renamed from: v */
    private final String f5995v;

    /* renamed from: w */
    private final String f5996w;

    EnumC1700c(String str, String str2) {
        this.f5995v = str;
        this.f5996w = str2;
    }

    /* renamed from: a */
    public static EnumC1700c m14903a(String str) {
        EnumC1700c[] values;
        for (EnumC1700c enumC1700c : values()) {
            if (enumC1700c.m14904a().equals(str)) {
                return enumC1700c;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m14904a() {
        return this.f5996w;
    }
}
