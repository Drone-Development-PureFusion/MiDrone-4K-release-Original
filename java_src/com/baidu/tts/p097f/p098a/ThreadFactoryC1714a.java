package com.baidu.tts.p097f.p098a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ThreadFactory;
/* renamed from: com.baidu.tts.f.a.a */
/* loaded from: classes.dex */
public class ThreadFactoryC1714a implements ThreadFactory {

    /* renamed from: a */
    private String f6194a;

    /* renamed from: b */
    private int f6195b;

    public ThreadFactoryC1714a(String str) {
        this.f6194a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        this.f6195b++;
        String str = this.f6194a + "(" + this.f6195b + ")";
        thread.setName(str);
        LoggerProxy.m15091d("NameThreadFactory", "threadName=" + str);
        return thread;
    }
}
