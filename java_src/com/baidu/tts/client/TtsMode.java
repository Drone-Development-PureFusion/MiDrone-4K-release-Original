package com.baidu.tts.client;

import com.baidu.tts.p096e.EnumC1710m;
/* loaded from: classes.dex */
public enum TtsMode {
    ONLINE(EnumC1710m.ONLINE),
    MIX(EnumC1710m.MIX);
    

    /* renamed from: a */
    private final EnumC1710m f5832a;

    TtsMode(EnumC1710m enumC1710m) {
        this.f5832a = enumC1710m;
    }

    public String getDescription() {
        return this.f5832a.m14888b();
    }

    public int getMode() {
        return this.f5832a.m14889a();
    }

    public EnumC1710m getTtsEnum() {
        return this.f5832a;
    }
}
