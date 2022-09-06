package com.baidu.speechsynthesizer.utility;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
/* loaded from: classes.dex */
public class SpeechDecoder {
    static {
        LoggerProxy.m15091d("SpeechDecoder", "before load gnustl_shared");
        System.loadLibrary("gnustl_shared");
        LoggerProxy.m15091d("SpeechDecoder", "before load BDSpeechDecoder_V1");
        System.loadLibrary("BDSpeechDecoder_V1");
        LoggerProxy.m15091d("SpeechDecoder", "after load BDSpeechDecoder_V1");
    }

    public native int decode(byte[] bArr, int i, short[] sArr, int[] iArr, int i2, int i3);
}
