package com.baidu.tts.auth;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C1605b;
import com.baidu.tts.auth.C1607c;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
/* loaded from: classes.dex */
public class AuthInfo {

    /* renamed from: a */
    private EnumC1710m f5674a;

    /* renamed from: b */
    private C1607c.C1608a f5675b;

    /* renamed from: c */
    private C1605b.C1606a f5676c;

    /* renamed from: d */
    private TtsError f5677d;

    public int getLeftValidDays() {
        return this.f5676c.m15310a();
    }

    public TtsError getMixTtsError() {
        TtsError onlineTtsError = getOnlineTtsError();
        TtsError offlineTtsError = getOfflineTtsError();
        TtsError ttsError = null;
        if (onlineTtsError != null && offlineTtsError != null) {
            ttsError = C1717c.m14880a().m14873b(EnumC1711n.MIX_ENGINE_AUTH_FAILURE);
        } else if (onlineTtsError == null && offlineTtsError != null) {
            ttsError = C1717c.m14880a().m14873b(EnumC1711n.OFFLINE_ENGINE_AUTH_FAILURE);
        } else if (onlineTtsError != null && offlineTtsError == null) {
            ttsError = C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_AUTH_FAILURE);
        }
        return ttsError != null ? ttsError : this.f5677d;
    }

    public String getNotifyMessage() {
        return this.f5676c.m15304c();
    }

    public C1605b.C1606a getOfflineResult() {
        return this.f5676c;
    }

    public TtsError getOfflineTtsError() {
        return this.f5676c != null ? this.f5676c.m15306b() : this.f5677d;
    }

    public C1607c.C1608a getOnlineResult() {
        return this.f5675b;
    }

    public TtsError getOnlineTtsError() {
        return this.f5675b != null ? this.f5675b.m15285b() : this.f5677d;
    }

    public EnumC1710m getTtsEnum() {
        return this.f5674a;
    }

    public TtsError getTtsError() {
        if (this.f5677d == null) {
            switch (this.f5674a) {
                case ONLINE:
                    return this.f5675b.m15285b();
                case OFFLINE:
                    return this.f5676c.m15306b();
                case MIX:
                    return getMixTtsError();
                default:
                    return null;
            }
        }
        return this.f5677d;
    }

    public boolean isMixSuccess() {
        return isOnlineSuccess() || isOfflineSuccess();
    }

    public boolean isOfflineSuccess() {
        if (this.f5676c != null) {
            return this.f5676c.mo14832g();
        }
        return false;
    }

    public boolean isOnlineSuccess() {
        if (this.f5675b != null) {
            return this.f5675b.mo14832g();
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.f5677d != null) {
            LoggerProxy.m15091d("AuthInfo", "cause=" + this.f5677d.getThrowable().getMessage());
            return false;
        } else if (this.f5674a == null) {
            return false;
        } else {
            switch (this.f5674a) {
                case ONLINE:
                    return isOnlineSuccess();
                case OFFLINE:
                    return isOfflineSuccess();
                case MIX:
                    return isMixSuccess();
                default:
                    return false;
            }
        }
    }

    public void setOfflineResult(C1605b.C1606a c1606a) {
        this.f5676c = c1606a;
    }

    public void setOnlineResult(C1607c.C1608a c1608a) {
        this.f5675b = c1608a;
    }

    public void setTtsEnum(EnumC1710m enumC1710m) {
        this.f5674a = enumC1710m;
    }

    public void setTtsError(TtsError ttsError) {
        this.f5677d = ttsError;
    }
}
