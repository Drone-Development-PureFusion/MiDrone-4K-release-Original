package com.baidu.tts.client;
/* loaded from: classes.dex */
public class SpeechError {
    public int code;
    public String description;

    public String toString() {
        return "(" + this.code + ")" + this.description;
    }
}
