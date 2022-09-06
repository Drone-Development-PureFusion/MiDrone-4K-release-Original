package org.p248a.p249a.p252c.p258f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.c.f.e */
/* loaded from: classes2.dex */
public class C5073e implements AbstractC5072d {

    /* renamed from: a */
    private final Method f21593a;

    public C5073e() {
        try {
            this.f21593a = Class.forName("java.net.IDN").getMethod("toUnicode", String.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    @Override // org.p248a.p249a.p252c.p258f.AbstractC5072d
    /* renamed from: a */
    public String mo2140a(String str) {
        try {
            return (String) this.f21593a.invoke(null, str);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }
}
