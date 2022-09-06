package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.HashMap;
import java.util.Map;
/* renamed from: b.a.a.b.g.d.f */
/* loaded from: classes.dex */
public class C0339f {

    /* renamed from: a */
    Map<C0343j, Class<?>> f633a = new HashMap();

    /* renamed from: b */
    private Class<?> m20905b(Class<?> cls, String str) {
        return this.f633a.get(new C0343j(cls, str));
    }

    /* renamed from: a */
    public Class<?> m20907a(Class<?> cls, String str) {
        String lowerCase = str.toLowerCase();
        while (cls != null) {
            Class<?> m20905b = m20905b(cls, lowerCase);
            if (m20905b != null) {
                return m20905b;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    /* renamed from: a */
    public void m20906a(Class<?> cls, String str, Class<?> cls2) {
        this.f633a.put(new C0343j(cls, str.toLowerCase()), cls2);
    }
}
