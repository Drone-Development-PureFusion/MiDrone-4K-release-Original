package com.baidu.tts.p096e;

import com.tencent.connect.common.Constants;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import com.tencent.stat.DeviceInfo;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.baidu.tts.e.g */
/* loaded from: classes.dex */
public enum EnumC1704g {
    STATE(null, XiaomiOAuthConstants.EXTRA_STATE_2, null),
    CODE(null, XiaomiOAuthConstants.EXTRA_CODE_2, null),
    DATA(null, "data", null),
    IVERSION(null, "iversion", null),
    URL(null, "url", null),
    MD5(null, "md5", null),
    LENGTH(null, "length", null),
    ABS_PATH(null, "absPath", null),
    ID(null, "id", null),
    GENDER(null, "gender", null),
    DOMAIN(null, "domain", null),
    QUALITY(null, "quality", null),
    DATA_COUNT(null, "data_count", null),
    DATA_LIST(null, "data_list", null),
    NAME(null, "name", null),
    VERSION_MIN(null, "version_min", null),
    VERSION_MAX(null, "version_max", null),
    TEXT_DATA_ID(null, "text_data_id", null),
    SPEECH_DATA_ID(null, "speech_data_id", null),
    FUNCTION("func", "function", ""),
    ERROR_NUMBER("err_no", "errorNumber", ""),
    ERROR_MESSAGE("err_msg", "errorMessage", ""),
    MIX_MODE(null, "mixMode", null),
    NOTIFICATION_COUNT_PER_SECOND("ncps", "notificationCountPerSecond", ""),
    PERCENT("pct", "percent", ""),
    APP_CODE("ac", "appCode", ""),
    PACKAGE_NAME("pn", "packageName", GameAppOperation.QQFAV_DATALINE_APPNAME),
    PLATFORM("", Constants.PARAM_PLATFORM, ""),
    SPEED("spd", "speed", ""),
    VOLUME("vol", "volume", ""),
    PITCH("pit", "pitch", ""),
    LANGUAGE("lan", "language", ""),
    TEXT_ENCODE("cod", "textEncode", ""),
    STREAM_TYPE("st", "streamType", ""),
    AUDIO_ENCODE("aue", "audioEncode", ""),
    BITRATE("rate", "audioRate", ""),
    SPEAKER("per", "speaker", ""),
    STYLE("sty", "style", ""),
    BACKGROUND("bcg", "background", ""),
    PRODUCT_ID("pdt", "productId", ""),
    TEXT_DAT_PATH("tdp", "textDatPath", ""),
    SPEECH_DAT_PATH("sdp", "speechDatPath", ""),
    TTS_LICENSE_FILE_PATH("tlfp", "ttsLicenseFilePath", ""),
    CUSTOM_SYNTH("cs", "custom_synth", ""),
    OPEN_XML("ox", "open_xml", ""),
    TTS_VOCODER_OPTIMIZATION("tvo", "ttsVocoderOptimzation", ""),
    SAMPLE_RATE("sr", "sampleRate", ""),
    SERIAL_NUMBER("sn", "serialNumber", ""),
    INDEX("idx", "index", ""),
    TEXT("tex", "text", ""),
    CTP("ctp", "clientPath", ""),
    CUID("cuid", "deviceId", "wise_cuid"),
    VERSION(DeviceInfo.TAG_VERSION, GameAppOperation.QQFAV_DATALINE_VERSION, "sdk_version"),
    NUMBER("num", "number", ""),
    ENGINE("en", "engine", ""),
    TERRITORY("ter", "territory", ""),
    PUNCTUATION("puc", "punctuation", ""),
    CONTEXT("ctx", C0359h.f700ac, ""),
    API_KEY("", MMPluginProviderConstants.OAuth.API_KEY, ""),
    SECRET_KEY("", "secretKey", ""),
    TOKEN("tok", com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, "");
    

    /* renamed from: aj */
    private final String f6081aj;

    /* renamed from: ak */
    private final String f6082ak;

    /* renamed from: al */
    private final String f6083al;

    EnumC1704g(String str, String str2, String str3) {
        this.f6081aj = str;
        this.f6082ak = str2;
        this.f6083al = str3;
    }

    /* renamed from: a */
    public static String m14897a(EnumC1704g enumC1704g) {
        if (enumC1704g == null) {
            return null;
        }
        return enumC1704g.name();
    }

    /* renamed from: a */
    public String m14898a() {
        return this.f6081aj;
    }

    /* renamed from: b */
    public String m14896b() {
        return this.f6082ak;
    }
}
