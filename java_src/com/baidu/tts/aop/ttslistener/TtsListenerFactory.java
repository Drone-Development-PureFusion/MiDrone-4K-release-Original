package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TtsListenerFactory extends AProxyFactory<TtsListener> {

    /* renamed from: a */
    private TtsListener f5673a;

    public TtsListenerFactory(TtsListener ttsListener) {
        this.f5673a = ttsListener;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public IInterceptorHandler createInterceptorHandler() {
        TtsListenerInterceptorHandler ttsListenerInterceptorHandler = new TtsListenerInterceptorHandler();
        ttsListenerInterceptorHandler.registerMethods();
        return ttsListenerInterceptorHandler;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public List<IInterceptor> createInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ProgressCorrectInterceptor());
        return arrayList;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    /* renamed from: createProxied */
    public TtsListener mo21750createProxied() {
        return this.f5673a;
    }
}
