package org.p318d.p320b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.p318d.AbstractC5744c;
import org.p318d.AbstractC5756f;
import org.p318d.p319a.AbstractC5725d;
import org.p318d.p319a.C5723b;
import org.p318d.p319a.C5726e;
/* renamed from: org.d.b.k */
/* loaded from: classes2.dex */
public class C5739k implements AbstractC5744c {

    /* renamed from: a */
    private final String f23007a;

    /* renamed from: b */
    private volatile AbstractC5744c f23008b;

    /* renamed from: d */
    private Boolean f23009d;

    /* renamed from: e */
    private Method f23010e;

    /* renamed from: f */
    private C5723b f23011f;

    /* renamed from: g */
    private Queue<C5726e> f23012g;

    /* renamed from: h */
    private final boolean f23013h;

    public C5739k(String str, Queue<C5726e> queue, boolean z) {
        this.f23007a = str;
        this.f23012g = queue;
        this.f23013h = z;
    }

    /* renamed from: f */
    private AbstractC5744c m132f() {
        if (this.f23011f == null) {
            this.f23011f = new C5723b(this, this.f23012g);
        }
        return this.f23011f;
    }

    /* renamed from: a */
    AbstractC5744c m138a() {
        return this.f23008b != null ? this.f23008b : this.f23013h ? C5735g.f23005a : m132f();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo118a(String str, Object obj) {
        m138a().mo118a(str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo117a(String str, Object obj, Object obj2) {
        m138a().mo117a(str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo116a(String str, Throwable th) {
        m138a().mo116a(str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo115a(String str, Object... objArr) {
        m138a().mo115a(str, objArr);
    }

    /* renamed from: a */
    public void m137a(AbstractC5725d abstractC5725d) {
        if (m135b()) {
            try {
                this.f23010e.invoke(this.f23008b, abstractC5725d);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    /* renamed from: a */
    public void m136a(AbstractC5744c abstractC5744c) {
        this.f23008b = abstractC5744c;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo113a(AbstractC5756f abstractC5756f, String str) {
        m138a().mo113a(abstractC5756f, str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo112a(AbstractC5756f abstractC5756f, String str, Object obj) {
        m138a().mo112a(abstractC5756f, str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo111a(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m138a().mo111a(abstractC5756f, str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo110a(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m138a().mo110a(abstractC5756f, str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo109a(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m138a().mo109a(abstractC5756f, str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public boolean mo114a(AbstractC5756f abstractC5756f) {
        return m138a().mo114a(abstractC5756f);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo108b(String str, Object obj) {
        m138a().mo108b(str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo107b(String str, Object obj, Object obj2) {
        m138a().mo107b(str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo106b(String str, Throwable th) {
        m138a().mo106b(str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo105b(String str, Object... objArr) {
        m138a().mo105b(str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo103b(AbstractC5756f abstractC5756f, String str) {
        m138a().mo103b(abstractC5756f, str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo102b(AbstractC5756f abstractC5756f, String str, Object obj) {
        m138a().mo102b(abstractC5756f, str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo101b(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m138a().mo101b(abstractC5756f, str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo100b(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m138a().mo100b(abstractC5756f, str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo99b(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m138a().mo99b(abstractC5756f, str, objArr);
    }

    /* renamed from: b */
    public boolean m135b() {
        if (this.f23009d != null) {
            return this.f23009d.booleanValue();
        }
        try {
            this.f23010e = this.f23008b.getClass().getMethod("log", AbstractC5725d.class);
            this.f23009d = Boolean.TRUE;
        } catch (NoSuchMethodException e) {
            this.f23009d = Boolean.FALSE;
        }
        return this.f23009d.booleanValue();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public boolean mo104b(AbstractC5756f abstractC5756f) {
        return m138a().mo104b(abstractC5756f);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo98c(String str, Object obj) {
        m138a().mo98c(str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo97c(String str, Object obj, Object obj2) {
        m138a().mo97c(str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo96c(String str, Throwable th) {
        m138a().mo96c(str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo95c(String str, Object... objArr) {
        m138a().mo95c(str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo93c(AbstractC5756f abstractC5756f, String str) {
        m138a().mo93c(abstractC5756f, str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo92c(AbstractC5756f abstractC5756f, String str, Object obj) {
        m138a().mo92c(abstractC5756f, str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo91c(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m138a().mo91c(abstractC5756f, str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo90c(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m138a().mo90c(abstractC5756f, str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo89c(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m138a().mo89c(abstractC5756f, str, objArr);
    }

    /* renamed from: c */
    public boolean m134c() {
        return this.f23008b == null;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public boolean mo94c(AbstractC5756f abstractC5756f) {
        return m138a().mo94c(abstractC5756f);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public String mo88d() {
        return this.f23007a;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo87d(String str, Object obj) {
        m138a().mo87d(str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo86d(String str, Object obj, Object obj2) {
        m138a().mo86d(str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo85d(String str, Throwable th) {
        m138a().mo85d(str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo84d(String str, Object... objArr) {
        m138a().mo84d(str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo82d(AbstractC5756f abstractC5756f, String str) {
        m138a().mo82d(abstractC5756f, str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo81d(AbstractC5756f abstractC5756f, String str, Object obj) {
        m138a().mo81d(abstractC5756f, str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo80d(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m138a().mo80d(abstractC5756f, str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo79d(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m138a().mo79d(abstractC5756f, str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo78d(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m138a().mo78d(abstractC5756f, str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public boolean mo83d(AbstractC5756f abstractC5756f) {
        return m138a().mo83d(abstractC5756f);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo77e(String str, Object obj) {
        m138a().mo77e(str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo76e(String str, Object obj, Object obj2) {
        m138a().mo76e(str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo75e(String str, Throwable th) {
        m138a().mo75e(str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo74e(String str, Object... objArr) {
        m138a().mo74e(str, objArr);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo72e(AbstractC5756f abstractC5756f, String str) {
        m138a().mo72e(abstractC5756f, str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo71e(AbstractC5756f abstractC5756f, String str, Object obj) {
        m138a().mo71e(abstractC5756f, str, obj);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo70e(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m138a().mo70e(abstractC5756f, str, obj, obj2);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo69e(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m138a().mo69e(abstractC5756f, str, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo68e(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m138a().mo68e(abstractC5756f, str, objArr);
    }

    /* renamed from: e */
    public boolean m133e() {
        return this.f23008b instanceof C5735g;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public boolean mo73e(AbstractC5756f abstractC5756f) {
        return m138a().mo73e(abstractC5756f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f23007a.equals(((C5739k) obj).f23007a);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: f */
    public void mo67f(String str) {
        m138a().mo67f(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: g */
    public void mo66g(String str) {
        m138a().mo66g(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public void mo64h(String str) {
        m138a().mo64h(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public boolean mo65h() {
        return m138a().mo65h();
    }

    public int hashCode() {
        return this.f23007a.hashCode();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public void mo62i(String str) {
        m138a().mo62i(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public boolean mo63i() {
        return m138a().mo63i();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public void mo60j(String str) {
        m138a().mo60j(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public boolean mo61j() {
        return m138a().mo61j();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: k */
    public boolean mo59k() {
        return m138a().mo59k();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: l */
    public boolean mo58l() {
        return m138a().mo58l();
    }
}
