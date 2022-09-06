package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class StatisticsInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected Object mo15331a(Object obj, Method method, Object[] objArr) {
        LoggerProxy.m15091d("StatisticsInterceptor", "statistics");
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    /* renamed from: a */
    protected void mo15332a() {
        this.f5663a.add("speak");
        this.f5663a.add("synthesize");
    }
}
