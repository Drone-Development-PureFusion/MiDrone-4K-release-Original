package org.p248a.p249a.p252c.p258f;

import java.lang.reflect.InvocationTargetException;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.c.f.a */
/* loaded from: classes2.dex */
public class C5067a {
    private C5067a() {
    }

    /* renamed from: a */
    public static <T> T m2157a(T t) {
        if (t == null) {
            return null;
        }
        if (!(t instanceof Cloneable)) {
            throw new CloneNotSupportedException();
        }
        try {
            try {
                return (T) t.getClass().getMethod("clone", null).invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof CloneNotSupportedException)) {
                    throw new Error("Unexpected exception", cause);
                }
                throw ((CloneNotSupportedException) cause);
            }
        } catch (NoSuchMethodException e3) {
            throw new NoSuchMethodError(e3.getMessage());
        }
    }

    /* renamed from: b */
    public static Object m2156b(Object obj) {
        return m2157a(obj);
    }
}
