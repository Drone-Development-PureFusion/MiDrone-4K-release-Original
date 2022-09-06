package org.p290c.p291a.p296e.p297a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.p290c.p291a.p296e.AbstractC5465a;
import org.p290c.p291a.p296e.AbstractC5474b;
import org.p290c.p291a.p296e.AbstractC5477c;
import org.p290c.p291a.p296e.C5478d;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.a.e.a.f */
/* loaded from: classes.dex */
public class C5473f extends C5466a {
    public C5473f(C5648k c5648k) {
        super(c5648k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p291a.p296e.p297a.C5466a
    /* renamed from: b */
    public Collection<C5640d> mo968b(C5478d c5478d) {
        Collection<C5640d> mo968b = super.mo968b(c5478d);
        String m961a = ((AbstractC5477c) c5478d.m946e(AbstractC5477c.class)).m961a();
        ArrayList arrayList = new ArrayList();
        for (C5640d c5640d : mo968b) {
            if (Arrays.asList(((AbstractC5474b) c5640d.mo424a((Class<Annotation>) AbstractC5474b.class)).m964a()).contains(m961a)) {
                arrayList.add(c5640d);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p291a.p296e.p297a.C5466a
    /* renamed from: c */
    public Collection<Field> mo967c(C5478d c5478d) {
        Collection<Field> mo967c = super.mo967c(c5478d);
        String m961a = ((AbstractC5477c) c5478d.m946e(AbstractC5477c.class)).m961a();
        ArrayList arrayList = new ArrayList();
        for (Field field : mo967c) {
            if (Arrays.asList(((AbstractC5465a) field.getAnnotation(AbstractC5465a.class)).m997a()).contains(m961a)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p291a.p296e.p297a.C5466a
    /* renamed from: d */
    public Collection<Field> mo966d(C5478d c5478d) {
        Collection<Field> mo966d = super.mo966d(c5478d);
        String m961a = ((AbstractC5477c) c5478d.m946e(AbstractC5477c.class)).m961a();
        ArrayList arrayList = new ArrayList();
        for (Field field : mo966d) {
            if (Arrays.asList(((AbstractC5474b) field.getAnnotation(AbstractC5474b.class)).m964a()).contains(m961a)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p291a.p296e.p297a.C5466a
    /* renamed from: e */
    public Collection<C5640d> mo965e(C5478d c5478d) {
        Collection<C5640d> mo965e = super.mo965e(c5478d);
        String m961a = ((AbstractC5477c) c5478d.m946e(AbstractC5477c.class)).m961a();
        ArrayList arrayList = new ArrayList();
        for (C5640d c5640d : mo965e) {
            if (Arrays.asList(((AbstractC5465a) c5640d.mo424a((Class<Annotation>) AbstractC5465a.class)).m997a()).contains(m961a)) {
                arrayList.add(c5640d);
            }
        }
        return arrayList;
    }
}
