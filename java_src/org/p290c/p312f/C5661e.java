package org.p290c.p312f;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5648k;
import org.p290c.p312f.p314b.AbstractC5657c;
import org.p290c.p312f.p314b.C5656b;
import org.p290c.p312f.p314b.C5658d;
/* renamed from: org.c.f.e */
/* loaded from: classes.dex */
public class C5661e extends C5670g {

    /* renamed from: a */
    private static final AbstractC5657c f22770a = new C5656b();

    /* renamed from: b */
    private static final List<AbstractC5634l> f22771b = Collections.emptyList();

    /* renamed from: c */
    private final List<AbstractC5634l> f22772c;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.f.e$a */
    /* loaded from: classes.dex */
    public @interface AbstractC5662a {
        /* renamed from: a */
        int m351a() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.f.e$b */
    /* loaded from: classes.dex */
    public @interface AbstractC5663b {
        /* renamed from: a */
        String m350a() default "{index}";
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.f.e$c */
    /* loaded from: classes.dex */
    public @interface AbstractC5664c {
        /* renamed from: a */
        Class<? extends AbstractC5657c> m349a() default C5656b.class;
    }

    public C5661e(Class<?> cls) {
        super(cls, f22771b);
        this.f22772c = Collections.unmodifiableList(m358a(m355b(), ((AbstractC5663b) m353j().mo424a((Class<Annotation>) AbstractC5663b.class)).m350a(), m354b(cls)));
    }

    /* renamed from: a */
    private List<C5658d> m359a(Iterable<Object> iterable, String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            arrayList.add(m357a(str, i, obj));
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<AbstractC5634l> m358a(Iterable<Object> iterable, String str, AbstractC5657c abstractC5657c) {
        try {
            List<C5658d> m359a = m359a(iterable, str);
            ArrayList arrayList = new ArrayList();
            for (C5658d c5658d : m359a) {
                arrayList.add(abstractC5657c.mo365a(c5658d));
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw m352k();
        }
    }

    /* renamed from: a */
    private C5658d m357a(String str, int i, Object obj) {
        return m356a(g(), str, i, obj instanceof Object[] ? (Object[]) obj : new Object[]{obj});
    }

    /* renamed from: a */
    private static C5658d m356a(C5648k c5648k, String str, int i, Object[] objArr) {
        return new C5658d("[" + MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr) + "]", c5648k, Arrays.asList(objArr));
    }

    /* renamed from: b */
    private Iterable<Object> m355b() {
        Object m455a = m353j().m455a((Object) null, new Object[0]);
        if (m455a instanceof Iterable) {
            return (Iterable) m455a;
        }
        if (!(m455a instanceof Object[])) {
            throw m352k();
        }
        return Arrays.asList((Object[]) m455a);
    }

    /* renamed from: b */
    private AbstractC5657c m354b(Class<?> cls) {
        AbstractC5664c abstractC5664c = (AbstractC5664c) cls.getAnnotation(AbstractC5664c.class);
        return abstractC5664c == null ? f22770a : abstractC5664c.m349a().newInstance();
    }

    /* renamed from: j */
    private C5640d m353j() {
        for (C5640d c5640d : g().m417b(AbstractC5663b.class)) {
            if (c5640d.g() && c5640d.h()) {
                return c5640d;
            }
        }
        throw new Exception("No public static parameters method on class " + g().m410e());
    }

    /* renamed from: k */
    private Exception m352k() {
        return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", g().m410e(), m353j().mo450b()));
    }

    @Override // org.p290c.p312f.C5670g, org.p290c.p312f.AbstractC5665f
    /* renamed from: c */
    protected List<AbstractC5634l> mo312c() {
        return this.f22772c;
    }
}
