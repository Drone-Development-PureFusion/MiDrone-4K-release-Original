package com.baidu.tts.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AInterceptor implements IInterceptor {

    /* renamed from: a */
    protected List<String> f5663a = new ArrayList();

    public AInterceptor() {
        mo15332a();
    }

    /* renamed from: a */
    private boolean m15339a(String str) {
        return this.f5663a.contains(str);
    }

    /* renamed from: a */
    protected abstract Object mo15331a(Object obj, Method method, Object[] objArr);

    /* renamed from: a */
    protected abstract void mo15332a();

    @Override // com.baidu.tts.aop.IInterceptor
    public Object after(Object obj, Method method, Object[] objArr, Object obj2) {
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.IInterceptor
    public Object before(Object obj, Method method, Object[] objArr) {
        return m15339a(method.getName()) ? mo15331a(obj, method, objArr) : AInterceptorHandler.DEFAULT;
    }
}
