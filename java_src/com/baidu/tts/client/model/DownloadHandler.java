package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p093d.C1668a;
import com.baidu.tts.p093d.C1680b;
import com.baidu.tts.p093d.p095b.C1681a;
import com.baidu.tts.p093d.p095b.C1684d;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class DownloadHandler {
    public static final int DOWNLOAD_SUCCESS = 0;

    /* renamed from: a */
    private C1680b f5843a;

    /* renamed from: b */
    private Future<C1668a> f5844b;

    /* renamed from: c */
    private TtsError f5845c;

    /* renamed from: d */
    private C1681a f5846d = C1681a.m15012a();

    /* renamed from: e */
    private volatile boolean f5847e = false;

    /* renamed from: a */
    private OnDownloadListener m15056a() {
        return this.f5843a.m15013c();
    }

    /* renamed from: a */
    private void m15055a(String str) {
        OnDownloadListener m15056a = m15056a();
        if (m15056a != null) {
            synchronized (this) {
                if (!this.f5847e) {
                    m15056a.onStart(str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15054a(String str, int i) {
        OnDownloadListener m15056a = m15056a();
        if (m15056a != null) {
            synchronized (this) {
                if (!this.f5847e) {
                    m15056a.onFinish(str, i);
                    this.f5843a.m15016a((OnDownloadListener) null);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15053a(String str, long j, long j2) {
        OnDownloadListener m15056a = m15056a();
        if (m15056a != null) {
            synchronized (this) {
                if (!this.f5847e) {
                    m15056a.onProgress(str, j, j2);
                }
            }
        }
    }

    public C1680b getDownloadParams() {
        return this.f5843a;
    }

    public int getErrorCode() {
        return getErrorCode(this.f5845c);
    }

    public int getErrorCode(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailCode();
        }
        return 0;
    }

    public String getErrorMessage() {
        return getErrorMessage(this.f5845c);
    }

    public String getErrorMessage(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailMessage();
        }
        return null;
    }

    public String getModelId() {
        return this.f5843a.m15017a();
    }

    public TtsError getTtsError() {
        return this.f5845c;
    }

    public synchronized void reset() {
        LoggerProxy.m15091d("DownloadHandler", "reset");
        this.f5847e = false;
    }

    public void reset(C1680b c1680b) {
        setDownloadParams(c1680b);
        reset();
    }

    public void setCheckFuture(Future<C1668a> future) {
        this.f5844b = future;
    }

    public void setDownloadParams(C1680b c1680b) {
        this.f5843a = c1680b;
    }

    public void setTtsError(TtsError ttsError) {
        this.f5845c = ttsError;
    }

    public synchronized void stop() {
        LoggerProxy.m15091d("DownloadHandler", "stop");
        this.f5847e = true;
        if (this.f5844b != null) {
            this.f5844b.cancel(true);
            this.f5844b = null;
        }
        this.f5846d.m15011a(this);
        this.f5843a.m15016a((OnDownloadListener) null);
    }

    public void updateFinish(C1684d c1684d, TtsError ttsError) {
        updateFinish(c1684d.m14962g(), ttsError);
    }

    public void updateFinish(String str, TtsError ttsError) {
        setTtsError(ttsError);
        m15054a(str, getErrorCode());
    }

    public void updateProgress(C1684d c1684d) {
        m15053a(c1684d.m14962g(), c1684d.m14961h(), c1684d.m14967c());
    }

    public void updateStart(C1684d c1684d) {
        m15055a(c1684d.m14962g());
    }
}
