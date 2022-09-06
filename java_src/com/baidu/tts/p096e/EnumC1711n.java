package com.baidu.tts.p096e;

import com.fimi.soul.media.player.IMediaPlayer;
/* renamed from: com.baidu.tts.e.n */
/* loaded from: classes.dex */
public enum EnumC1711n {
    ONLINE_ENGINE_AUTH_FAILURE(EnumC1712a.ONLINE_ENGINE_ERROR, -1, "online engine auth failure"),
    ONLINE_ENGINE_HTTP_REQUEST_FAILURE(EnumC1712a.ONLINE_ENGINE_ERROR, -2, "request failure"),
    ONLINE_ENGINE_CANCEL_FAILURE(EnumC1712a.ONLINE_ENGINE_ERROR, -3, "cancel failure"),
    ONLINE_AUTH_INTERRUPTED_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -4, "InterruptedException"),
    ONLINE_AUTH_EXECUTION_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -5, "ExecutionException"),
    ONLINE_AUTH_TIMEOUT_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -6, "TimeoutException"),
    ONLINE_ENGINE_REQUEST_RESULT_ERROR(EnumC1712a.ONLINE_ENGINE_ERROR, -7, "request result contains error message"),
    ONLINE_TOKEN_IS_NULL(EnumC1712a.ONLINE_ENGINE_ERROR, -8, "access token is null, please check your apikey and secretkey or product id"),
    ONLINE_ENGINE_UNINITIALIZED(EnumC1712a.ONLINE_ENGINE_ERROR, -9, "online engine is not initial"),
    ONLINE_ENGINE_CALL_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -10, "online engine call synthesize exception"),
    ONLINE_UNSUPPORTED_OPERATION(EnumC1712a.ONLINE_ENGINE_ERROR, -11, "this method is not supported by online mode(please use other mode)"),
    ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR(EnumC1712a.ONLINE_ENGINE_ERROR, -12, "request result parse error may responsebag is null"),
    ONLINE_ENGINE_GET_INTERRUPTED(EnumC1712a.ONLINE_ENGINE_ERROR, -13, "online synthesize get was interrupted"),
    ONLINE_ENGINE_GET_EXECUTION_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -14, "online synthesize get exception"),
    ONLINE_ENGINE_GET_TIMEOUT(EnumC1712a.ONLINE_ENGINE_ERROR, -15, "online synthesize get was timeout"),
    ONLINE_AUTH_CANCELLATION_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -16, "CancellationException"),
    OFFLINE_ENGINE_AUTH_FAILURE(EnumC1712a.OFFLINE_ENGINE_ERROR, -100, "offline engine auth failure,please check you offline auth params"),
    OFFLINE_ENGINE_CANCEL_FAILURE(EnumC1712a.OFFLINE_ENGINE_ERROR, -101, "offline engine cancel failure"),
    OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED(EnumC1712a.OFFLINE_ENGINE_ERROR, -102, "offline engine download license failure"),
    OFFLINE_ENGINE_AUTH_NULL(EnumC1712a.OFFLINE_ENGINE_ERROR, -103, "offline engine auth authinfo is null"),
    OFFLINE_AUTH_INTERRUPTED_EXCEPTION(EnumC1712a.OFFLINE_ENGINE_ERROR, -105, "InterruptedException"),
    OFFLINE_AUTH_EXECUTION_EXCEPTION(EnumC1712a.OFFLINE_ENGINE_ERROR, -106, "ExecutionException"),
    OFFLINE_AUTH_TIMEOUT_EXCEPTION(EnumC1712a.OFFLINE_ENGINE_ERROR, -107, "TimeoutException"),
    OFFLINE_ENGINE_INIT_FAILED(EnumC1712a.OFFLINE_ENGINE_ERROR, -108, "bdTTSEngineInit failed,please check you offline params"),
    OFFLINE_ENGINE_UNINITIALIZED(EnumC1712a.OFFLINE_ENGINE_ERROR, -109, "offline engine is uninitialized,please invoke initTts() method"),
    OFFLINE_ENGINE_CALL_EXCEPTION(EnumC1712a.OFFLINE_ENGINE_ERROR, IMediaPlayer.MEDIA_ERROR_TIMED_OUT, "offline engine call synthesize exception"),
    OFFLINE_ENGINE_SYNTHESIZE_ERROR(EnumC1712a.OFFLINE_ENGINE_ERROR, -111, "offline engine synthesize result not 0"),
    OFFLINE_ENGINE_AUTH_EXPIRED(EnumC1712a.OFFLINE_ENGINE_ERROR, -112, "offline engine auth verify expired,formal expired or temp expired"),
    OFFLINE_ENGINE_AUTH_PACKAGE_UNMATCH(EnumC1712a.OFFLINE_ENGINE_ERROR, -113, "package name is unmatch"),
    OFFLINE_ENGINE_AUTH_SIGN_UNMATCH(EnumC1712a.OFFLINE_ENGINE_ERROR, -114, "app sign is unmatch"),
    OFFLINE_ENGINE_AUTH_CUID_UNMATCH(EnumC1712a.OFFLINE_ENGINE_ERROR, -115, "devices cuid is unmatch"),
    OFFLINE_ENGINE_AUTH_PLATFORM_ERROR(EnumC1712a.OFFLINE_ENGINE_ERROR, -116, "platform is unmatch"),
    OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID(EnumC1712a.OFFLINE_ENGINE_ERROR, -117, "license file not exist or file length is 0 (download license fail)"),
    OFFLINE_AUTH_CANCELLATION_EXCEPTION(EnumC1712a.ONLINE_ENGINE_ERROR, -118, "CancellationException"),
    MIX_ENGINE_AUTH_FAILURE(EnumC1712a.MIX_ERROR, -200, "both online and offline engine auth failue"),
    MIX_AUTH_INTERRUPTED_EXCEPTION(EnumC1712a.MIX_ERROR, -201, "InterruptedException"),
    MIX_AUTH_EXECUTION_EXCEPTION(EnumC1712a.MIX_ERROR, -202, "ExecutionException"),
    MIX_AUTH_TIMEOUT_EXCEPTION(EnumC1712a.MIX_ERROR, -203, "TimeoutException"),
    MIX_ENGINE_OFFLINE_INIT_FAILURE(EnumC1712a.MIX_ERROR, -204, "mix engine initTTS, the offline init failure"),
    MIX_AUTH_CANCELLATION_EXCEPTION(EnumC1712a.MIX_ERROR, -205, "CancellationException"),
    TEXT_IS_EMPTY(EnumC1712a.TEXT, -300, "text is null or empty double quotation marks"),
    TEXT_IS_TOO_LONG(EnumC1712a.TEXT, -301, "text length in gbk is more than 1024, the text is too long, cut it short than 1024"),
    TEXT_ENCODE_IS_WRONG(EnumC1712a.TEXT, -302, "text encode is not gbk, please use gbk text"),
    TTS_UNINITIAL(EnumC1712a.TTS, -400, "tts has not been initialized,invoke in a wrong state"),
    TTS_MODE_ILLEGAL(EnumC1712a.TTS, -401, "tts mode unset or not the spechified value"),
    TTS_QUEUE_IS_FULL(EnumC1712a.TTS, -402, "队列长度小于MAX_QUEUE_SIZE时才能加入合成队列"),
    TTS_LIST_IS_TOO_LONG(EnumC1712a.TTS, -403, "list的size小于MAX_LIST_SIZE时才有效"),
    TTS_ENGINE_STOP_FAILURE(EnumC1712a.TTS, -404, "引擎停止失败"),
    TTS_APP_ID_IS_INVALID(EnumC1712a.TTS, -405, "app id is invalid,must be less than int(11)"),
    TTS_PARAMETER_INVALID(EnumC1712a.TTS, -406, "arguments of the method is invalid"),
    APP_RESOURCE_IS_NULL(EnumC1712a.APP, -500, "context was released or persistent app value is null"),
    PLAYER_IS_NULL(EnumC1712a.PLAYER, -600, "player is null"),
    MODEL_PARAMS_ERROR(EnumC1712a.MODEL, -1000, "params is wrong"),
    MODEL_REQUEST_ERROR(EnumC1712a.MODEL, -1001, "request error"),
    MODEL_SERVER_ERROR(EnumC1712a.MODEL, -1002, "server error"),
    MODEL_DB_MODEL_INVALID(EnumC1712a.MODEL, -1003, "model item in db is invalid(fileids is empty)"),
    MODEL_DB_MODEL_FILE_PATHS_INVALID(EnumC1712a.MODEL, IMediaPlayer.MEDIA_ERROR_IO, "model file in db is invalid(abspath is empty)"),
    MODEL_EXISTS(EnumC1712a.MODEL, -1005, "this model exists(have downloaded success ever)"),
    MODEL_BAGS_EMPTY(EnumC1712a.MODEL, -1006, "can't get server model info,maybe modelid invalid or request failure"),
    MODEL_FILE_BAG_EMPTY(EnumC1712a.MODEL, IMediaPlayer.MEDIA_ERROR_MALFORMED, "can't get server file info,maybe fileid invalid or request failure"),
    MODEL_CHECK_EXCEPTION(EnumC1712a.MODEL, -1008, "CheckWork exception happened"),
    MODEL_FILE_DOWNLOAD_EXCEPTION(EnumC1712a.MODEL, -1009, "exception happens when file downloadwork execute"),
    TTS_ERROR_UNKNOW(EnumC1712a.UNKNOW, -9999, "unknow");
    

    /* renamed from: al */
    private final EnumC1712a f6177al;

    /* renamed from: am */
    private final int f6178am;

    /* renamed from: an */
    private final String f6179an;

    /* renamed from: com.baidu.tts.e.n$a */
    /* loaded from: classes.dex */
    public enum EnumC1712a {
        MIX_ERROR,
        ONLINE_ENGINE_ERROR,
        OFFLINE_ENGINE_ERROR,
        TEXT,
        TTS,
        APP,
        PLAYER,
        MODEL,
        UNKNOW
    }

    EnumC1711n(EnumC1712a enumC1712a, int i, String str) {
        this.f6177al = enumC1712a;
        this.f6178am = i;
        this.f6179an = str;
    }

    /* renamed from: a */
    public EnumC1712a m14887a() {
        return this.f6177al;
    }

    /* renamed from: b */
    public int m14886b() {
        return this.f6178am;
    }

    /* renamed from: c */
    public String m14885c() {
        return this.f6179an;
    }
}
