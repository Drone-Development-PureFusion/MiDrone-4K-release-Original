package org.p290c.p291a.p292a;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.p290c.AbstractC5436a;
import org.p290c.AbstractC5490b;
import org.p290c.AbstractC5635f;
import org.p290c.AbstractC5672g;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p315g.AbstractC5673a;
/* renamed from: org.c.a.a.d */
/* loaded from: classes.dex */
public final class C5445d extends AbstractC5673a {

    /* renamed from: a */
    private static final Set<Class<? extends Annotation>> f22516a = Collections.unmodifiableSet(new HashSet(Arrays.asList(AbstractC5672g.class, AbstractC5490b.class, AbstractC5635f.class, AbstractC5436a.class)));

    /* renamed from: a */
    private void m1034a(List<Exception> list, Class<?> cls) {
        list.add(new Exception(String.format("@%s can not be combined with @Category", cls.getSimpleName())));
    }

    @Override // org.p290c.p315g.AbstractC5673a
    /* renamed from: a */
    public List<Exception> mo308a(C5640d c5640d) {
        Annotation[] mo425a;
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : c5640d.mo425a()) {
            for (Class<? extends Annotation> cls : f22516a) {
                if (annotation.annotationType().isAssignableFrom(cls)) {
                    m1034a(arrayList, cls);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
