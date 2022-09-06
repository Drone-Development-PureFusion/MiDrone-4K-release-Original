package org.p290c.p299b.p303d;

import java.lang.reflect.Method;
import java.util.List;
import org.p290c.AbstractC5436a;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5690k;
import org.p290c.AbstractC5692m;
@Deprecated
/* renamed from: org.c.b.d.k */
/* loaded from: classes.dex */
public class C5552k {

    /* renamed from: a */
    private final Method f22638a;

    /* renamed from: b */
    private C5551j f22639b;

    public C5552k(Method method, C5551j c5551j) {
        this.f22638a = method;
        this.f22639b = c5551j;
    }

    /* renamed from: a */
    public void m788a(Object obj) {
        this.f22638a.invoke(obj, new Object[0]);
    }

    /* renamed from: a */
    public boolean m789a() {
        return this.f22638a.getAnnotation(AbstractC5690k.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m787a(Throwable th) {
        return !m785c().isAssignableFrom(th.getClass());
    }

    /* renamed from: b */
    public long m786b() {
        AbstractC5692m abstractC5692m = (AbstractC5692m) this.f22638a.getAnnotation(AbstractC5692m.class);
        if (abstractC5692m == null) {
            return 0L;
        }
        return abstractC5692m.m278b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public Class<? extends Throwable> m785c() {
        AbstractC5692m abstractC5692m = (AbstractC5692m) this.f22638a.getAnnotation(AbstractC5692m.class);
        if (abstractC5692m == null || abstractC5692m.m279a() == AbstractC5692m.C5693a.class) {
            return null;
        }
        return abstractC5692m.m279a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m784d() {
        return m785c() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public List<Method> m783e() {
        return this.f22639b.m799a(AbstractC5635f.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public List<Method> m782f() {
        return this.f22639b.m799a(AbstractC5436a.class);
    }
}
