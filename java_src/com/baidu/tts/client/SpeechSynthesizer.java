package com.baidu.tts.client;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p081a.p083b.C1585a;
import com.baidu.tts.p096e.EnumC1696b;
import com.baidu.tts.p096e.EnumC1700c;
import com.baidu.tts.p096e.EnumC1701d;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1705h;
import com.baidu.tts.p096e.EnumC1707j;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.List;
/* loaded from: classes.dex */
public class SpeechSynthesizer {
    public static final int MAX_LIST_SIZE = 100;
    public static final int MAX_QUEUE_SIZE = 1000;

    /* renamed from: b */
    private C1585a f5830b = new C1585a();
    public static final int ERROR_QUEUE_IS_FULL = EnumC1711n.TTS_QUEUE_IS_FULL.m14886b();
    public static final int ERROR_LIST_IS_TOO_LONG = EnumC1711n.TTS_LIST_IS_TOO_LONG.m14886b();
    public static final int ERROR_TEXT_IS_EMPTY = EnumC1711n.TEXT_IS_EMPTY.m14886b();
    public static final int ERROR_TEXT_IS_TOO_LONG = EnumC1711n.TEXT_IS_TOO_LONG.m14886b();
    public static final int ERROR_TEXT_ENCODE_IS_WRONG = EnumC1711n.TEXT_ENCODE_IS_WRONG.m14886b();
    public static final int ERROR_APP_ID_IS_INVALID = EnumC1711n.TTS_APP_ID_IS_INVALID.m14886b();
    public static final String PARAM_SPEED = EnumC1704g.m14897a(EnumC1704g.SPEED);
    public static final String PARAM_PITCH = EnumC1704g.m14897a(EnumC1704g.PITCH);
    public static final String PARAM_VOLUME = EnumC1704g.m14897a(EnumC1704g.VOLUME);
    public static final String PARAM_TTS_TEXT_MODEL_FILE = EnumC1704g.m14897a(EnumC1704g.TEXT_DAT_PATH);
    public static final String PARAM_TTS_SPEECH_MODEL_FILE = EnumC1704g.m14897a(EnumC1704g.SPEECH_DAT_PATH);
    public static final String PARAM_TTS_LICENCE_FILE = EnumC1704g.m14897a(EnumC1704g.TTS_LICENSE_FILE_PATH);
    public static final String PARAM_VOCODER_OPTIM_LEVEL = EnumC1704g.m14897a(EnumC1704g.TTS_VOCODER_OPTIMIZATION);
    public static final String PARAM_CUSTOM_SYNTH = EnumC1704g.m14897a(EnumC1704g.CUSTOM_SYNTH);
    public static final String PARAM_OPEN_XML = EnumC1704g.m14897a(EnumC1704g.OPEN_XML);
    public static final String PARAM_PRODUCT_ID = EnumC1704g.m14897a(EnumC1704g.PRODUCT_ID);
    public static final String PARAM_LANGUAGE = EnumC1704g.m14897a(EnumC1704g.LANGUAGE);
    public static final String PARAM_TEXT_ENCODE = EnumC1704g.m14897a(EnumC1704g.TEXT_ENCODE);
    public static final String PARAM_AUDIO_ENCODE = EnumC1704g.m14897a(EnumC1704g.AUDIO_ENCODE);
    public static final String PARAM_AUDIO_RATE = EnumC1704g.m14897a(EnumC1704g.BITRATE);
    public static final String PARAM_SPEAKER = EnumC1704g.m14897a(EnumC1704g.SPEAKER);
    public static final String PARAM_MIX_MODE = EnumC1704g.m14897a(EnumC1704g.MIX_MODE);
    public static final String MIX_MODE_DEFAULT = EnumC1707j.DEFAULT.name();
    public static final String MIX_MODE_HIGH_SPEED_NETWORK = EnumC1707j.HIGH_SPEED_NETWORK.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE = EnumC1707j.HIGH_SPEED_SYNTHESIZE.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI = EnumC1707j.HIGH_SPEED_SYNTHESIZE_WIFI.name();
    public static final String LANGUAGE_ZH = EnumC1705h.ZH.m14895a();
    public static final String TEXT_ENCODE_GBK = EnumC1701d.GB18030.m14900b();
    public static final String TEXT_ENCODE_BIG5 = EnumC1701d.BIG5.m14900b();
    public static final String TEXT_ENCODE_UTF8 = EnumC1701d.UTF8.m14900b();
    public static final String AUDIO_ENCODE_BV = EnumC1696b.BV.m14906a();
    public static final String AUDIO_ENCODE_AMR = EnumC1696b.AMR.m14906a();
    public static final String AUDIO_ENCODE_OPUS = EnumC1696b.OPUS.m14906a();
    public static final String AUDIO_BITRATE_BV_16K = EnumC1700c.BV_16K.m14904a();
    public static final String AUDIO_BITRATE_AMR_6K6 = EnumC1700c.AMR_6K6.m14904a();
    public static final String AUDIO_BITRATE_AMR_8K85 = EnumC1700c.AMR_8K85.m14904a();
    public static final String AUDIO_BITRATE_AMR_12K65 = EnumC1700c.AMR_12K65.m14904a();
    public static final String AUDIO_BITRATE_AMR_14K25 = EnumC1700c.AMR_14K25.m14904a();
    public static final String AUDIO_BITRATE_AMR_15K85 = EnumC1700c.AMR_15K85.m14904a();
    public static final String AUDIO_BITRATE_AMR_18K25 = EnumC1700c.AMR_18K25.m14904a();
    public static final String AUDIO_BITRATE_AMR_19K85 = EnumC1700c.AMR_19K85.m14904a();
    public static final String AUDIO_BITRATE_AMR_23K05 = EnumC1700c.AMR_23K05.m14904a();
    public static final String AUDIO_BITRATE_AMR_23K85 = EnumC1700c.AMR_23K85.m14904a();
    public static final String AUDIO_BITRATE_OPUS_8K = EnumC1700c.OPUS_8K.m14904a();
    public static final String AUDIO_BITRATE_OPUS_16K = EnumC1700c.OPUS_16K.m14904a();
    public static final String AUDIO_BITRATE_OPUS_18K = EnumC1700c.OPUS_18K.m14904a();
    public static final String AUDIO_BITRATE_OPUS_20K = EnumC1700c.OPUS_20K.m14904a();
    public static final String AUDIO_BITRATE_OPUS_24K = EnumC1700c.OPUS_24K.m14904a();
    public static final String AUDIO_BITRATE_OPUS_32K = EnumC1700c.OPUS_32K.m14904a();

    /* renamed from: a */
    private static volatile SpeechSynthesizer f5829a = null;

    private SpeechSynthesizer() {
    }

    public static SpeechSynthesizer getInstance() {
        if (f5829a == null) {
            synchronized (SpeechSynthesizer.class) {
                if (f5829a == null) {
                    f5829a = new SpeechSynthesizer();
                }
            }
        }
        return f5829a;
    }

    public AuthInfo auth(TtsMode ttsMode) {
        return this.f5830b.m15386b(ttsMode);
    }

    public int batchSpeak(List<SpeechSynthesizeBag> list) {
        return DataTool.isListEmpty(list) ? EnumC1711n.TTS_PARAMETER_INVALID.m14886b() : this.f5830b.m15391a(list);
    }

    public int freeCustomResource() {
        return this.f5830b.m15378f();
    }

    public synchronized int initTts(TtsMode ttsMode) {
        TtsError m15397a;
        m15397a = this.f5830b.m15397a(ttsMode);
        return m15397a == null ? 0 : m15397a.getDetailCode();
    }

    public String libVersion() {
        return this.f5830b.m15404a();
    }

    public int loadCustomResource(String str) {
        return this.f5830b.m15395a(str);
    }

    public int loadEnglishModel(String str, String str2) {
        return this.f5830b.m15381c(str, str2);
    }

    public int loadModel(String str, String str2) {
        return this.f5830b.m15384b(str, str2);
    }

    public synchronized int pause() {
        return this.f5830b.m15389b();
    }

    public synchronized int release() {
        this.f5830b.m15379e();
        f5829a = null;
        return 0;
    }

    public synchronized int resume() {
        return this.f5830b.m15382c();
    }

    public int setApiKey(String str, String str2) {
        setParam(EnumC1704g.API_KEY.name(), str);
        setParam(EnumC1704g.SECRET_KEY.name(), str2);
        return 0;
    }

    public int setAppId(String str) {
        if (StringTool.isAllNumber(str)) {
            setParam(EnumC1704g.APP_CODE.name(), str);
            return 0;
        }
        return ERROR_APP_ID_IS_INVALID;
    }

    public int setAudioStreamType(int i) {
        return this.f5830b.m15402a(i);
    }

    public void setContext(Context context) {
        this.f5830b.m15401a(context);
    }

    public int setParam(String str, String str2) {
        return this.f5830b.m15394a(str, str2);
    }

    public void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        this.f5830b.m15398a(speechSynthesizerListener);
    }

    public int setStereoVolume(float f, float f2) {
        return this.f5830b.m15403a(f, f2);
    }

    public int speak(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return speak(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception e) {
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }
    }

    public int speak(String str) {
        return speak(str, null);
    }

    public int speak(String str, String str2) {
        return speak(str, str2, null);
    }

    public int speak(String str, String str2, Bundle bundle) {
        return this.f5830b.m15393a(str, str2, bundle);
    }

    public synchronized int stop() {
        return this.f5830b.m15380d();
    }

    public int synthesize(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return synthesize(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception e) {
            return EnumC1711n.TTS_PARAMETER_INVALID.m14886b();
        }
    }

    public int synthesize(String str) {
        return synthesize(str, null);
    }

    public int synthesize(String str, String str2) {
        return synthesize(str, str2, null);
    }

    public int synthesize(String str, String str2, Bundle bundle) {
        return this.f5830b.m15383b(str, str2, bundle);
    }
}
