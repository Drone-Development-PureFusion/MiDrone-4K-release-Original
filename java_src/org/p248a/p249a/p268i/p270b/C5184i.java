package org.p248a.p249a.p268i.p270b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.HttpResponse;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5006c
/* renamed from: org.a.a.i.b.i */
/* loaded from: classes2.dex */
class C5184i implements InvocationHandler {

    /* renamed from: a */
    private final HttpResponse f21952a;

    C5184i(HttpResponse httpResponse) {
        this.f21952a = httpResponse;
    }

    /* renamed from: a */
    public static AbstractC5035b m1764a(HttpResponse httpResponse) {
        return (AbstractC5035b) Proxy.newProxyInstance(C5184i.class.getClassLoader(), new Class[]{AbstractC5035b.class}, new C5184i(httpResponse));
    }

    /* renamed from: a */
    public void m1765a() {
        C5354d.m1303b(this.f21952a.getEntity());
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().equals("close")) {
            m1765a();
            return null;
        }
        try {
            return method.invoke(this.f21952a, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            throw cause;
        }
    }
}
