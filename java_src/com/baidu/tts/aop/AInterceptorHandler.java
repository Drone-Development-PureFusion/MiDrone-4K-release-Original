package com.baidu.tts.aop;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AInterceptorHandler implements IInterceptorHandler {
    public static final Object DEFAULT = 0;
    public static final Object END = 1;

    /* renamed from: a */
    protected List<IInterceptor> f5664a;

    /* renamed from: b */
    protected Object f5665b;

    /* renamed from: c */
    protected List<String> f5666c = new ArrayList();

    /* renamed from: a */
    protected Object m15338a(Object obj, Method method, Object[] objArr) {
        Object obj2 = DEFAULT;
        int size = this.f5664a.size();
        Object obj3 = obj2;
        for (int i = 0; i < size; i++) {
            obj3 = this.f5664a.get(i).before(obj, method, objArr);
            if (obj3.equals(END)) {
                break;
            }
        }
        return obj3;
    }

    /* renamed from: a */
    protected Object m15337a(Object obj, Method method, Object[] objArr, Object obj2) {
        Object obj3 = DEFAULT;
        int size = this.f5664a.size() - 1;
        while (size >= 0) {
            Object after = this.f5664a.get(size).after(obj, method, objArr, obj2);
            size--;
            obj3 = after;
        }
        return obj3;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public Object bind(Object obj, List<IInterceptor> list) {
        this.f5665b = obj;
        this.f5664a = list;
        Class<?> cls = this.f5665b.getClass();
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
        LoggerProxy.m15091d("AInterceptorHandler", "proxy=" + newProxyInstance);
        return newProxyInstance;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public boolean canIntercept(String str) {
        return this.f5666c.contains(str);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (canIntercept(method.getName())) {
            if (m15338a(this.f5665b, method, objArr).equals(END)) {
                return null;
            }
            Object invoke = method.invoke(this.f5665b, objArr);
            LoggerProxy.m15091d("AInterceptorHandler", "afterResult=" + m15337a(this.f5665b, method, objArr, invoke));
            return invoke;
        }
        return method.invoke(this.f5665b, objArr);
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethod(String str) {
        if (str != null) {
            this.f5666c.add(str);
        }
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void unregisterMethod(String str) {
        if (str != null) {
            this.f5666c.remove(str);
        }
    }
}
