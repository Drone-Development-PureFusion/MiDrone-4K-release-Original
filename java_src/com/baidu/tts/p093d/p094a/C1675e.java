package com.baidu.tts.p093d.p094a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p093d.p094a.C1670b;
import java.util.concurrent.Future;
/* renamed from: com.baidu.tts.d.a.e */
/* loaded from: classes.dex */
public class C1675e {

    /* renamed from: a */
    private Future<Void> f5891a;

    /* renamed from: b */
    private C1670b.CallableC1671a f5892b;

    /* renamed from: a */
    public void m15022a() {
        LoggerProxy.m15091d("EngineDownloadHandler", "before stop");
        try {
            LoggerProxy.m15091d("EngineDownloadHandler", "stop fileId=" + this.f5892b.m15031c().m15030a());
        } catch (Exception e) {
        }
        if (this.f5891a != null) {
            LoggerProxy.m15091d("EngineDownloadHandler", "unDone = " + this.f5891a.cancel(true));
        }
        if (this.f5892b != null) {
            this.f5892b.m15032b();
        }
        LoggerProxy.m15091d("EngineDownloadHandler", "after stop");
    }

    /* renamed from: a */
    public void m15021a(C1670b.CallableC1671a callableC1671a) {
        this.f5892b = callableC1671a;
    }

    /* renamed from: a */
    public void m15020a(Future<Void> future) {
        this.f5891a = future;
    }
}
