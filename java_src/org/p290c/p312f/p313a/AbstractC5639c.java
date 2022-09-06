package org.p290c.p312f.p313a;

import java.lang.reflect.Modifier;
import java.util.List;
import org.p290c.p312f.p313a.AbstractC5639c;
/* renamed from: org.c.f.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC5639c<T extends AbstractC5639c<T>> implements AbstractC5637a {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m458a(List<T> list) {
        for (T t : list) {
            if (mo453a((AbstractC5639c<T>) t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    abstract boolean mo453a(T t);

    /* renamed from: b */
    public abstract String mo450b();

    /* renamed from: c */
    protected abstract int mo446c();

    /* renamed from: e */
    public abstract Class<?> mo444e();

    /* renamed from: f */
    public abstract Class<?> mo443f();

    /* renamed from: g */
    public boolean m457g() {
        return Modifier.isStatic(mo446c());
    }

    /* renamed from: h */
    public boolean m456h() {
        return Modifier.isPublic(mo446c());
    }
}
