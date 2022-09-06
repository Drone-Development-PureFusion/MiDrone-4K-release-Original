package com.baidu.tts.aop;

import java.util.List;
/* loaded from: classes.dex */
public abstract class AProxyFactory<T> implements IProxyFactory<T> {
    @Override // com.baidu.tts.aop.IProxyFactory
    public T makeProxy() {
        T createProxied = createProxied();
        IInterceptorHandler createInterceptorHandler = createInterceptorHandler();
        List<IInterceptor> createInterceptors = createInterceptors();
        return (createInterceptorHandler == null || createInterceptors == null) ? createProxied : (T) createInterceptorHandler.bind(createProxied, createInterceptors);
    }
}
