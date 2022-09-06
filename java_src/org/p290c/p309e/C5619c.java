package org.p290c.p309e;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: org.c.e.c */
/* loaded from: classes.dex */
public class C5619c implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: d */
    private final Collection<C5619c> f22718d;

    /* renamed from: e */
    private final String f22719e;

    /* renamed from: f */
    private final Serializable f22720f;

    /* renamed from: g */
    private final Annotation[] f22721g;

    /* renamed from: h */
    private volatile Class<?> f22722h;

    /* renamed from: c */
    private static final Pattern f22717c = Pattern.compile("([\\s\\S]*)\\((.*)\\)");

    /* renamed from: a */
    public static final C5619c f22715a = new C5619c(null, "No Tests", new Annotation[0]);

    /* renamed from: b */
    public static final C5619c f22716b = new C5619c(null, "Test mechanism", new Annotation[0]);

    private C5619c(Class<?> cls, String str, Serializable serializable, Annotation... annotationArr) {
        this.f22718d = new ConcurrentLinkedQueue();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The display name must not be empty.");
        }
        if (serializable == null) {
            throw new IllegalArgumentException("The unique id must not be null.");
        }
        this.f22722h = cls;
        this.f22719e = str;
        this.f22720f = serializable;
        this.f22721g = annotationArr;
    }

    private C5619c(Class<?> cls, String str, Annotation... annotationArr) {
        this(cls, str, str, annotationArr);
    }

    /* renamed from: a */
    private String m551a(int i, String str) {
        Matcher matcher = f22717c.matcher(toString());
        return matcher.matches() ? matcher.group(i) : str;
    }

    /* renamed from: a */
    private static String m546a(String str, String str2) {
        return String.format("%s(%s)", str, str2);
    }

    /* renamed from: a */
    public static C5619c m550a(Class<?> cls) {
        return new C5619c(cls, cls.getName(), cls.getAnnotations());
    }

    /* renamed from: a */
    public static C5619c m549a(Class<?> cls, String str) {
        return new C5619c(cls, m546a(str, cls.getName()), new Annotation[0]);
    }

    /* renamed from: a */
    public static C5619c m548a(Class<?> cls, String str, Annotation... annotationArr) {
        return new C5619c(cls, m546a(str, cls.getName()), annotationArr);
    }

    /* renamed from: a */
    public static C5619c m547a(String str, Serializable serializable, Annotation... annotationArr) {
        return new C5619c(null, str, serializable, annotationArr);
    }

    /* renamed from: a */
    public static C5619c m545a(String str, String str2, Serializable serializable) {
        return new C5619c(null, m546a(str2, str), serializable, new Annotation[0]);
    }

    /* renamed from: a */
    public static C5619c m544a(String str, String str2, Annotation... annotationArr) {
        return new C5619c(null, m546a(str2, str), annotationArr);
    }

    /* renamed from: a */
    public static C5619c m543a(String str, Annotation... annotationArr) {
        return new C5619c(null, str, annotationArr);
    }

    /* renamed from: a */
    public String m552a() {
        return this.f22719e;
    }

    /* renamed from: a */
    public void m542a(C5619c c5619c) {
        this.f22718d.add(c5619c);
    }

    /* renamed from: b */
    public <T extends Annotation> T m540b(Class<T> cls) {
        Annotation[] annotationArr;
        for (Annotation annotation : this.f22721g) {
            if (annotation.annotationType().equals(cls)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    /* renamed from: b */
    public ArrayList<C5619c> m541b() {
        return new ArrayList<>(this.f22718d);
    }

    /* renamed from: c */
    public boolean m539c() {
        return !m538d();
    }

    /* renamed from: d */
    public boolean m538d() {
        return this.f22718d.isEmpty();
    }

    /* renamed from: e */
    public int m537e() {
        if (m538d()) {
            return 1;
        }
        int i = 0;
        Iterator<C5619c> it2 = this.f22718d.iterator();
        while (true) {
            int i2 = i;
            if (!it2.hasNext()) {
                return i2;
            }
            i = it2.next().m537e() + i2;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5619c)) {
            return false;
        }
        return this.f22720f.equals(((C5619c) obj).f22720f);
    }

    /* renamed from: f */
    public boolean m536f() {
        return equals(f22715a);
    }

    /* renamed from: g */
    public C5619c m535g() {
        return new C5619c(this.f22722h, this.f22719e, this.f22721g);
    }

    /* renamed from: h */
    public Collection<Annotation> m534h() {
        return Arrays.asList(this.f22721g);
    }

    public int hashCode() {
        return this.f22720f.hashCode();
    }

    /* renamed from: i */
    public Class<?> m533i() {
        if (this.f22722h != null) {
            return this.f22722h;
        }
        String m532j = m532j();
        if (m532j == null) {
            return null;
        }
        try {
            this.f22722h = Class.forName(m532j, false, getClass().getClassLoader());
            return this.f22722h;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: j */
    public String m532j() {
        return this.f22722h != null ? this.f22722h.getName() : m551a(2, toString());
    }

    /* renamed from: k */
    public String m531k() {
        return m551a(1, (String) null);
    }

    public String toString() {
        return m552a();
    }
}
