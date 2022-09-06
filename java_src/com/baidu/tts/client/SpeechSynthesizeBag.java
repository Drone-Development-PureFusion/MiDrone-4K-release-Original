package com.baidu.tts.client;

import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.tools.ResourceTools;
/* loaded from: classes.dex */
public class SpeechSynthesizeBag {

    /* renamed from: a */
    private String f5827a;

    /* renamed from: b */
    private String f5828b;

    public String getText() {
        return this.f5827a;
    }

    public String getUtteranceId() {
        return this.f5828b;
    }

    public int setText(String str) {
        EnumC1711n isTextValid = ResourceTools.isTextValid(str);
        if (isTextValid == null) {
            this.f5827a = str;
            return 0;
        }
        return isTextValid.m14886b();
    }

    public void setUtteranceId(String str) {
        this.f5828b = str;
    }
}
